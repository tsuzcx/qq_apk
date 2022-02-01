package com.tencent.biz.qqcircle.publish.request;

import FileUpload.MultiPicInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostAEHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.activity.QCircleSavePart;
import com.tencent.biz.qqcircle.publish.model.DynamicArrayList;
import com.tencent.biz.qqcircle.publish.model.ImageInfo;
import com.tencent.biz.qqcircle.publish.model.MediaWrapper;
import com.tencent.biz.qqcircle.publish.model.QzoneMediaUploadParams;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoVideoInfo;
import com.tencent.biz.qqcircle.publish.model.UploadVideoObject;
import com.tencent.biz.qqcircle.publish.publishconst.QzoneUploadConst;
import com.tencent.biz.qqcircle.publish.queue.IUploadQueueListener;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.service.video.util.QCircleVideoUtils;
import com.tencent.biz.qqcircle.publish.task.QCircleImageUploadTask;
import com.tencent.biz.qqcircle.publish.task.QCircleVideoUploadTask;
import com.tencent.biz.qqcircle.publish.util.ImageQualityPreference;
import com.tencent.biz.qqcircle.publish.util.PublishUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import cooperation.qqcircle.report.QCircleMapReporter;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QCircleUploadRequest
  extends QCircleMediaUploadRequest
  implements QCircleAEEditorGenerateResultListener
{
  private static final int s = QCircleConfigHelper.a("QZoneSetting", "qqcircleTimeOutMaxRetryCount", Integer.valueOf(1)).intValue();
  private static final int z = QCircleConfigHelper.a("QZoneSetting", "qqcircleGenerateOverTime", Integer.valueOf(60000)).intValue();
  private QCircleMediaUploadRequest.IMediaUploadTaskInfoListener A;
  private Runnable B = new QCircleUploadRequest.1(this);
  @NeedParcel
  private boolean t = true;
  @NeedParcel
  private String u;
  @NeedParcel
  private boolean v = false;
  @NeedParcel
  private int w = 0;
  private boolean x = false;
  private int y = 0;
  
  public QCircleUploadRequest() {}
  
  public QCircleUploadRequest(List<MediaWrapper> paramList, QzoneMediaUploadParams paramQzoneMediaUploadParams, IUploadQueueListener paramIUploadQueueListener, QCircleMediaUploadRequest.IMediaUploadListener paramIMediaUploadListener)
  {
    this(paramList, paramQzoneMediaUploadParams, paramIUploadQueueListener, paramIMediaUploadListener, null);
  }
  
  public QCircleUploadRequest(List<MediaWrapper> paramList, QzoneMediaUploadParams paramQzoneMediaUploadParams, IUploadQueueListener paramIUploadQueueListener, QCircleMediaUploadRequest.IMediaUploadListener paramIMediaUploadListener, QCircleMediaUploadRequest.IMediaUploadTaskInfoListener paramIMediaUploadTaskInfoListener)
  {
    super(paramList, paramQzoneMediaUploadParams, paramIUploadQueueListener, paramIMediaUploadListener);
    this.t = paramQzoneMediaUploadParams.K;
    this.u = paramQzoneMediaUploadParams.L;
    this.v = paramQzoneMediaUploadParams.M;
    this.A = paramIMediaUploadTaskInfoListener;
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "QCircleUploadRequest... isVideoReady:", Boolean.valueOf(this.t), " missionID:", this.u });
  }
  
  private void b(int paramInt)
  {
    b(paramInt, QzoneUploadConst.a(paramInt));
    QCircleHostAEHelper.removeListener(this);
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.B);
  }
  
  private void c(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask.mExtend_info == null) {
      paramAbstractUploadTask.mExtend_info = new HashMap();
    }
    if (!TextUtils.isEmpty(this.c.O))
    {
      paramAbstractUploadTask.mExtend_info.put("trace_id", this.c.O);
      return;
    }
    QLog.w("[upload2_QCircleUploadRequest]", 1, "warn!!! clientTraceId is empty");
    paramAbstractUploadTask.mExtend_info.put("trace_id", "");
  }
  
  private void f()
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "tryExportVideo... missionId:", this.u, " isVideoReady:", Boolean.valueOf(this.t) });
    if ((!this.t) && (!TextUtils.isEmpty(this.u)))
    {
      QCircleHostAEHelper.initAEEditorManagerForQzone();
      RFThreadManager.getSerialThreadHandler().post(new QCircleUploadRequest.2(this));
    }
  }
  
  private boolean g()
  {
    return this.w < s;
  }
  
  private void h()
  {
    if ((QCircleConfigHelper.b()) && (this.v))
    {
      DynamicArrayList localDynamicArrayList = new DynamicArrayList();
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        MediaWrapper localMediaWrapper = (MediaWrapper)localIterator.next();
        if ((localMediaWrapper != null) && (localMediaWrapper.a()) && (localMediaWrapper.c() != null)) {
          localDynamicArrayList.add(localMediaWrapper.c().b);
        }
      }
      QCircleSavePart.a(localDynamicArrayList, QCircleHostConstants.AppConstants.SDCARD_IMG_SAVE());
    }
  }
  
  protected AbstractUploadTask a(ShuoshuoVideoInfo paramShuoshuoVideoInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.f)
    {
      paramShuoshuoVideoInfo = new StringBuilder();
      paramShuoshuoVideoInfo.append(c());
      paramShuoshuoVideoInfo.append(", createVideoUploadTask after aborted, return null!");
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramShuoshuoVideoInfo.toString());
      return null;
    }
    if (paramShuoshuoVideoInfo == null)
    {
      paramShuoshuoVideoInfo = new StringBuilder();
      paramShuoshuoVideoInfo.append(c());
      paramShuoshuoVideoInfo.append(", createVideoUploadTask with null videoInfo, return null!");
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramShuoshuoVideoInfo.toString());
      return null;
    }
    UploadVideoObject localUploadVideoObject = UploadVideoObject.a(paramShuoshuoVideoInfo);
    Object localObject = paramShuoshuoVideoInfo.b;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!PublishUtils.a((String)localObject))) {
      localUploadVideoObject.a = ((String)localObject);
    }
    this.k.put(localUploadVideoObject.a(), localUploadVideoObject);
    localObject = new QCircleVideoUploadTask(localUploadVideoObject.a());
    int i;
    if (this.c.k > 0) {
      i = this.c.k;
    } else {
      i = localUploadVideoObject.i();
    }
    ((QCircleVideoUploadTask)localObject).iIsNew = i;
    ((QCircleVideoUploadTask)localObject).flowId = a(this.c.d, localUploadVideoObject.a());
    ((QCircleVideoUploadTask)localObject).iUin = LoginData.a().b();
    ((QCircleVideoUploadTask)localObject).sRefer = "mqq";
    ((QCircleVideoUploadTask)localObject).vLoginData = paramArrayOfByte;
    ((QCircleVideoUploadTask)localObject).md5 = localUploadVideoObject.b();
    ((QCircleVideoUploadTask)localObject).sTitle = localUploadVideoObject.d();
    ((QCircleVideoUploadTask)localObject).sDesc = localUploadVideoObject.e();
    ((QCircleVideoUploadTask)localObject).iFlag = localUploadVideoObject.c();
    ((QCircleVideoUploadTask)localObject).sCoverUrl = localUploadVideoObject.h();
    ((QCircleVideoUploadTask)localObject).iPlayTime = ((int)localUploadVideoObject.f());
    ((QCircleVideoUploadTask)localObject).iUploadTime = (this.c.f - paramInt);
    ((QCircleVideoUploadTask)localObject).iBusiNessType = this.c.l;
    if (this.c.o) {
      paramArrayOfByte = this.c.m;
    } else {
      paramArrayOfByte = a(this.e, paramInt, ((QCircleVideoUploadTask)localObject).iUploadTime, localUploadVideoObject);
    }
    ((QCircleVideoUploadTask)localObject).vBusiNessData = paramArrayOfByte;
    ((QCircleVideoUploadTask)localObject).iIsOriginalVideo = localUploadVideoObject.j();
    ((QCircleVideoUploadTask)localObject).iIsFormatF20 = localUploadVideoObject.k();
    ((QCircleVideoUploadTask)localObject).uploadEntrance = this.c.e;
    ((QCircleVideoUploadTask)localObject).uploadTaskCallback = this;
    a((AbstractUploadTask)localObject, paramShuoshuoVideoInfo);
    ((QCircleVideoUploadTask)localObject).extend_info = new HashMap();
    ((QCircleVideoUploadTask)localObject).extend_info.put("video_type", UploadVideoObject.b(paramShuoshuoVideoInfo));
    ((QCircleVideoUploadTask)localObject).keepTmpFile(true);
    c((AbstractUploadTask)localObject);
    a((AbstractUploadTask)localObject, this.c.e);
    paramShuoshuoVideoInfo = new StringBuilder();
    paramShuoshuoVideoInfo.append(c());
    paramShuoshuoVideoInfo.append(", createVideoUploadTask finish.  index: ");
    paramShuoshuoVideoInfo.append(paramInt);
    paramShuoshuoVideoInfo.append(", QCircleVideoUploadTask:");
    paramShuoshuoVideoInfo.append(((QCircleVideoUploadTask)localObject).toString());
    QLog.i("[upload2_QCircleUploadRequest]", 1, paramShuoshuoVideoInfo.toString());
    return localObject;
  }
  
  protected ImageUploadTask a(ImageInfo paramImageInfo, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f)
    {
      paramImageInfo = new StringBuilder();
      paramImageInfo.append(c());
      paramImageInfo.append(", createImageUploadTask after aborted, return null!");
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramImageInfo.toString());
      return null;
    }
    if (paramImageInfo == null)
    {
      paramImageInfo = new StringBuilder();
      paramImageInfo.append(c());
      paramImageInfo.append(", createImageUploadTask with null imageInfo, return null!");
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramImageInfo.toString());
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c());
    ((StringBuilder)localObject).append(", createImageUploadTask photoPath:");
    ((StringBuilder)localObject).append(paramImageInfo.a);
    QLog.d("[upload2_QCircleUploadRequest]", 1, ((StringBuilder)localObject).toString());
    localObject = paramImageInfo.a;
    int j = 0;
    localObject = new QCircleImageUploadTask(false, (String)localObject);
    ((QCircleImageUploadTask)localObject).uploadTaskCallback = this;
    ((QCircleImageUploadTask)localObject).iUin = LoginData.a().b();
    ((QCircleImageUploadTask)localObject).sRefer = "mqq";
    ((QCircleImageUploadTask)localObject).vLoginData = paramArrayOfByte;
    ((QCircleImageUploadTask)localObject).md5 = a(paramImageInfo.a);
    ((QCircleImageUploadTask)localObject).sAlbumName = "";
    ((QCircleImageUploadTask)localObject).flowId = a((int)this.c.c, paramImageInfo.a);
    ((QCircleImageUploadTask)localObject).uploadEntrance = this.c.e;
    ((QCircleImageUploadTask)localObject).sPicTitle = "";
    ((QCircleImageUploadTask)localObject).sPicDesc = this.c.i;
    ((QCircleImageUploadTask)localObject).bWaterType = this.c.j;
    ((QCircleImageUploadTask)localObject).autoRotate = this.d;
    ((QCircleImageUploadTask)localObject).clientFakeKey = this.c.d;
    ((QCircleImageUploadTask)localObject).uploadPoi = this.c.w;
    ((QCircleImageUploadTask)localObject).iBusiNessType = this.c.l;
    if (((QCircleImageUploadTask)localObject).iBusiNessType == 1) {
      ((QCircleImageUploadTask)localObject).vBusiNessData = this.c.m;
    }
    paramArrayOfByte = new MultiPicInfo();
    if (this.c.u > 0) {
      i = this.c.u;
    } else {
      i = this.e;
    }
    paramArrayOfByte.iBatUploadNum = i;
    if (this.c.v >= 0) {
      i = this.c.v;
    } else {
      i = paramInt;
    }
    paramArrayOfByte.iCurUpload = i;
    ((QCircleImageUploadTask)localObject).mutliPicInfo = paramArrayOfByte;
    ((QCircleImageUploadTask)localObject).iUploadTime = (this.c.f - paramInt);
    ((QCircleImageUploadTask)localObject).iUploadType = this.c.h;
    ((QCircleImageUploadTask)localObject).iBatchID = this.c.c;
    int i = j;
    if (this.e > 0) {
      i = 1;
    }
    ((QCircleImageUploadTask)localObject).iUpPicType = i;
    ((QCircleImageUploadTask)localObject).keepTmpFile(true);
    c((AbstractUploadTask)localObject);
    a((ImageUploadTask)localObject, this.c.a);
    a((ImageUploadTask)localObject, this.c, paramImageInfo, paramBoolean1, paramBoolean2);
    a((ImageUploadTask)localObject, this.c);
    a((AbstractUploadTask)localObject, this.c.e);
    paramImageInfo = new StringBuilder();
    paramImageInfo.append(c());
    paramImageInfo.append(", createImageUploadTask finish, picPath:");
    paramImageInfo.append(((QCircleImageUploadTask)localObject).uploadFilePath);
    paramImageInfo.append(", flowId:");
    paramImageInfo.append(((QCircleImageUploadTask)localObject).flowId);
    paramImageInfo.append(", index: ");
    paramImageInfo.append(paramInt);
    paramImageInfo.append(", iUploadTime:");
    paramImageInfo.append(((QCircleImageUploadTask)localObject).iUploadTime);
    QLog.i("[upload2_QCircleUploadRequest]", 1, paramImageInfo.toString());
    return localObject;
  }
  
  public void a(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo != null) && (!TextUtils.isEmpty(paramLocalMediaInfo.path)))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = QCircleVideoUtils.a(QCircleApplication.APP, paramLocalMediaInfo._id, paramLocalMediaInfo.path, paramLocalMediaInfo.fileSize, 1, paramLocalMediaInfo.thumbnailPath, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth, 0L, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.needProcess, null);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = QCircleVideoUtils.a(QCircleApplication.APP, paramLocalMediaInfo._id, paramLocalMediaInfo.path, paramLocalMediaInfo.fileSize, 1, null, paramLocalMediaInfo.thumbHeight, paramLocalMediaInfo.thumbWidth, 0L, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.needProcess, null, false);
      }
      QCircleVideoUtils.a(paramString, "video_is_use_qcircle_rate", true);
      int i;
      if (ImageQualityPreference.a().a(1, paramLocalMediaInfo) == 3) {
        i = 1;
      } else {
        i = 0;
      }
      paramLocalMediaInfo.needProcess = (i ^ 0x1);
      paramLocalMediaInfo.mIsUploadOrigin = (paramLocalMediaInfo.needProcess ^ true);
      MediaWrapper localMediaWrapper = new MediaWrapper(paramString);
      if (localMediaWrapper.c().n == true)
      {
        localMediaWrapper.c().n = paramLocalMediaInfo.needProcess;
        paramString = localMediaWrapper.c();
        if (paramLocalMediaInfo.needProcess == true) {
          i = 0;
        } else {
          i = 1;
        }
        paramString.l = i;
        localMediaWrapper.c().q = (paramLocalMediaInfo.needProcess ^ true);
      }
      else if (!paramLocalMediaInfo.needProcess)
      {
        localMediaWrapper.c().n = false;
        localMediaWrapper.c().l = 1;
        localMediaWrapper.c().q = true;
      }
      localMediaWrapper.f = paramLocalMediaInfo.mediaOriginWidth;
      localMediaWrapper.g = paramLocalMediaInfo.mediaOriginHeight;
      localMediaWrapper.h = paramLocalMediaInfo.mediaOriginSize;
      localMediaWrapper.i = paramLocalMediaInfo.mediaOriginBitrate;
      localMediaWrapper.j = paramLocalMediaInfo.mediaBitrate;
      localMediaWrapper.a = paramLocalMediaInfo.materialID;
      localMediaWrapper.b = paramLocalMediaInfo.filterID;
      localMediaWrapper.c = paramLocalMediaInfo.materialName;
      localMediaWrapper.d = paramLocalMediaInfo.scheme;
      localMediaWrapper.e = paramLocalMediaInfo.showCircleTakeSame;
      localMediaWrapper.k = paramLocalMediaInfo.mKuolieId;
      localMediaWrapper.l = paramLocalMediaInfo.mKuolieCenterX;
      localMediaWrapper.m = paramLocalMediaInfo.mKuolieCenterY;
      localMediaWrapper.o = paramLocalMediaInfo.mKuolieWidthScale;
      localMediaWrapper.p = paramLocalMediaInfo.mKuolieHeightScale;
      localMediaWrapper.n = paramLocalMediaInfo.mKuolieRotate;
      paramString = this.A;
      if (paramString != null)
      {
        List localList = paramString.a();
        if ((localList != null) && (localList.size() > 0))
        {
          localObject = ((MediaWrapper)localList.get(0)).q;
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = "none";
          }
          localMediaWrapper.q = paramString;
          localObject = ((MediaWrapper)localList.get(0)).r;
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = "none";
          }
          localMediaWrapper.r = paramString;
          localObject = ((MediaWrapper)localList.get(0)).s;
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = "none";
          }
          localMediaWrapper.s = paramString;
          localObject = ((MediaWrapper)localList.get(0)).t;
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = "none";
          }
          localMediaWrapper.t = paramString;
        }
      }
      QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "uploadVideo... mediaWrapper:", localMediaWrapper.toString() });
      localArrayList.add(localMediaWrapper);
      this.h = localArrayList;
      paramString = this.A;
      if (paramString != null) {
        paramString.a(this.h);
      }
      a(localArrayList);
      paramString = (QCircleMediaUploadRequest.UploadMediaInfo)this.j.get(paramLocalMediaInfo.path);
      if (paramString == null)
      {
        paramLocalMediaInfo = new StringBuilder();
        paramLocalMediaInfo.append(c());
        paramLocalMediaInfo.append(", uploadVideo but get UploadMediaInfo fail path = ");
        paramLocalMediaInfo.append(paramString);
        QLog.e("[upload2_QCircleUploadRequest]", 1, paramLocalMediaInfo.toString());
        b(10000);
        return;
      }
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(this.g, 5));
      b(LoginData.a().e());
      return;
    }
    QLog.e("[upload2_QCircleUploadRequest]", 1, "uploadVideo... localMediaInfo == null || TextUtils.isEmpty(localMediaInfo.path)");
    b(10001);
  }
  
  public boolean a()
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "cancel... missionId:", this.u });
    QCircleHostAEHelper.removeListener(this);
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.B);
    return super.a();
  }
  
  protected void b(byte[] paramArrayOfByte)
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "doUploadVideo... isVideoReady:", Boolean.valueOf(this.t), " missionID:", this.u });
    if ((!this.t) && (!TextUtils.isEmpty(this.u)))
    {
      paramArrayOfByte = null;
      if (!TextUtils.isEmpty(this.u))
      {
        paramArrayOfByte = QCircleHostAEHelper.getMissionInfo(this.u);
      }
      else
      {
        QLog.e("[upload2_QCircleUploadRequest]", 1, "missionID not null");
        b(10000);
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.isVideoReady))
      {
        QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "doUploadVideo... localMediaInfo != null localMediaInfo:", paramArrayOfByte.toString() });
        this.t = true;
        a(this.u, paramArrayOfByte);
        return;
      }
      QCircleHostAEHelper.addListener(this);
      QCircleHostAEHelper.retryMission(this.u);
      RFThreadManager.getSerialThreadHandler().postDelayed(this.B, z);
      QLog.d("[upload2_QCircleUploadRequest]", 1, "doUploadVideo... wait for export complete...");
      return;
    }
    h();
    super.b(paramArrayOfByte);
  }
  
  public void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "onAETavSessionExportCompleted... missionId:", paramString });
    if (!paramString.equals(this.u))
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append("onAETavSessionExportCompleted not the same mission this.missionID:");
      paramLocalMediaInfo.append(this.u);
      paramLocalMediaInfo.append(" missionID:");
      paramLocalMediaInfo.append(paramString);
      QLog.w("[upload2_QCircleUploadRequest]", 1, paramLocalMediaInfo.toString());
      return;
    }
    if (this.f)
    {
      RFThreadManager.getSerialThreadHandler().removeCallbacks(this.B);
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append(c());
      paramLocalMediaInfo.append(", onAETavSessionExportCompleted... aborted missionID:");
      paramLocalMediaInfo.append(paramString);
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramLocalMediaInfo.toString());
      return;
    }
    this.t = true;
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.B);
    QCircleHostAEHelper.removeListener(this);
    Object localObject2 = QCircleMapReporter.getInstance();
    Object localObject3 = QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST;
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.c.O);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.w));
    Object localObject4 = new StringBuilder();
    boolean bool = this.x;
    String str = "QQ";
    if (bool) {
      localObject1 = "QQ";
    } else {
      localObject1 = "Peak";
    }
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(":");
    ((StringBuilder)localObject4).append(this.y);
    ((QCircleMapReporter)localObject2).reportEnd((String)localObject3, paramString, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleReportHelper.newEntry("attach_info", ((StringBuilder)localObject4).toString()), QCircleReportHelper.newEntry("ret_code", "0") }));
    localObject2 = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
    localObject3 = QCircleReportHelper.newEntry("traceid", this.c.O);
    localEntry1 = QCircleReportHelper.newEntry("ret_code", "0");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramLocalMediaInfo.mediaWidth);
    ((StringBuilder)localObject1).append("x");
    ((StringBuilder)localObject1).append(paramLocalMediaInfo.mediaHeight);
    localEntry2 = QCircleReportHelper.newEntry("ext1", ((StringBuilder)localObject1).toString());
    localObject4 = QCircleReportHelper.newEntry("ext2", String.valueOf(paramLocalMediaInfo.mediaBitrate));
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("ext3", String.valueOf(paramLocalMediaInfo.fileSize));
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("ext4", String.valueOf(paramLocalMediaInfo.mDuration / 1000L));
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("ext5", paramLocalMediaInfo.path);
    FeedCloudCommon.Entry localEntry6 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.w));
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.x) {
      localObject1 = str;
    } else {
      localObject1 = "Peak";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(":");
    localStringBuilder.append(this.y);
    QCirclePublishQualityReporter.report((String)localObject2, Arrays.asList(new FeedCloudCommon.Entry[] { localObject3, localEntry1, localEntry2, localObject4, localEntry3, localEntry4, localEntry5, localEntry6, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }));
    if ((this.h != null) && (this.h.size() > 0) && (((MediaWrapper)this.h.get(0)).c() != null) && (!TextUtils.isEmpty(((MediaWrapper)this.h.get(0)).c().h)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onAETavSessionExportCompleted... localMediaInfo.thumbnailPath:");
      ((StringBuilder)localObject1).append(paramLocalMediaInfo.thumbnailPath);
      ((StringBuilder)localObject1).append(" mCoverUrl:");
      ((StringBuilder)localObject1).append(((MediaWrapper)this.h.get(0)).c().h);
      QLog.d("[upload2_QCircleUploadRequest]", 1, ((StringBuilder)localObject1).toString());
      paramLocalMediaInfo.thumbnailPath = ((MediaWrapper)this.h.get(0)).c().h;
    }
    a(paramString, paramLocalMediaInfo);
  }
  
  public void onAETavSessionExportError(String paramString1, int paramInt, String paramString2)
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "onAETavSessionExportError... missionId:", paramString1 });
    if (!paramString1.equals(this.u))
    {
      paramString2 = new StringBuilder();
      paramString2.append("onAETavSessionExportError not the same mission this.missionID:");
      paramString2.append(this.u);
      paramString2.append(" missionID:");
      paramString2.append(paramString1);
      QLog.w("[upload2_QCircleUploadRequest]", 1, paramString2.toString());
      return;
    }
    boolean bool = this.f;
    String str = "QQ";
    if (bool)
    {
      paramString2 = new StringBuilder();
      paramString2.append(c());
      paramString2.append(", onAETavSessionExportError... aborted missionID:");
      paramString2.append(paramString1);
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramString2.toString());
      localObject1 = QCircleMapReporter.getInstance();
      localObject2 = QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST;
      localObject3 = QCircleReportHelper.newEntry("traceid", this.c.O);
      localObject4 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.w));
      localObject5 = new StringBuilder();
      if (this.x) {
        paramString2 = "QQ";
      } else {
        paramString2 = "Peak";
      }
      ((StringBuilder)localObject5).append(paramString2);
      ((StringBuilder)localObject5).append(":");
      ((StringBuilder)localObject5).append(this.y);
      ((QCircleMapReporter)localObject1).reportEnd((String)localObject2, paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { localObject3, localObject4, QCircleReportHelper.newEntry("attach_info", ((StringBuilder)localObject5).toString()), QCircleReportHelper.newEntry("ret_code", "-80000000") }));
      paramString1 = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
      paramString2 = QCircleReportHelper.newEntry("traceid", this.c.O);
      localObject1 = QCircleReportHelper.newEntry("ret_code", "-80000000");
      localObject2 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.w));
      localObject3 = new StringBuilder();
      if (!this.x) {
        str = "Peak";
      }
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(this.y);
      QCirclePublishQualityReporter.report(paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { paramString2, localObject1, localObject2, QCircleReportHelper.newEntry("attach_info", ((StringBuilder)localObject3).toString()) }));
      return;
    }
    Object localObject2 = QCircleMapReporter.getInstance();
    Object localObject3 = QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST;
    Object localObject4 = QCircleReportHelper.newEntry("traceid", this.c.O);
    Object localObject5 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.w));
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.x) {
      localObject1 = "QQ";
    } else {
      localObject1 = "Peak";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(":");
    localStringBuilder.append(this.y);
    ((QCircleMapReporter)localObject2).reportEnd((String)localObject3, paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { localObject4, localObject5, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt)) }));
    paramString1 = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
    Object localObject1 = QCircleReportHelper.newEntry("traceid", this.c.O);
    localObject2 = QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt));
    paramString2 = QCircleReportHelper.newEntry("desc", paramString2);
    localObject3 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.w));
    localObject4 = new StringBuilder();
    if (!this.x) {
      str = "Peak";
    }
    ((StringBuilder)localObject4).append(str);
    ((StringBuilder)localObject4).append(":");
    ((StringBuilder)localObject4).append(this.y);
    QCirclePublishQualityReporter.report(paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { localObject1, localObject2, paramString2, localObject3, QCircleReportHelper.newEntry("attach_info", ((StringBuilder)localObject4).toString()) }));
    b(10000);
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "onAETavSessionExporting... missionId:", paramString, " progress:", Float.valueOf(paramFloat) });
    StringBuilder localStringBuilder;
    if (!paramString.equals(this.u))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAETavSessionExporting not the same mission this.missionID:");
      localStringBuilder.append(this.u);
      localStringBuilder.append(" missionID:");
      localStringBuilder.append(paramString);
      QLog.w("[upload2_QCircleUploadRequest]", 1, localStringBuilder.toString());
      return;
    }
    if (this.f)
    {
      RFThreadManager.getSerialThreadHandler().removeCallbacks(this.B);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append(", onAETavSessionExporting... aborted missionID:");
      localStringBuilder.append(paramString);
      QLog.e("[upload2_QCircleUploadRequest]", 1, localStringBuilder.toString());
      return;
    }
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.B);
    RFThreadManager.getSerialThreadHandler().postDelayed(this.B, z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.request.QCircleUploadRequest
 * JD-Core Version:    0.7.0.1
 */