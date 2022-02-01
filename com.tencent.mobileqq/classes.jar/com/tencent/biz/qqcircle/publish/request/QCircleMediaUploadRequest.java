package com.tencent.biz.qqcircle.publish.request;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadVideoInfoRsp;
import FileUpload.stPoi;
import NS_MOBILE_OPERATION.LbsInfo;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDeviceHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.common.IQZoneProtocolListener;
import com.tencent.biz.qqcircle.publish.model.ImageInfo;
import com.tencent.biz.qqcircle.publish.model.MediaWrapper;
import com.tencent.biz.qqcircle.publish.model.QZonePreUploadInfo;
import com.tencent.biz.qqcircle.publish.model.QzoneMediaUploadParams;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoVideoInfo;
import com.tencent.biz.qqcircle.publish.model.UploadVideoObject;
import com.tencent.biz.qqcircle.publish.publishconst.QzoneUploadConst;
import com.tencent.biz.qqcircle.publish.queue.IUploadQueueListener;
import com.tencent.biz.qqcircle.publish.request.result.UploadFileResponse;
import com.tencent.biz.qqcircle.publish.service.video.util.QCircleVideoUtils;
import com.tencent.biz.qqcircle.publish.task.QCircleQueueTaskInfo;
import com.tencent.biz.qqcircle.publish.task.compress.VideoCompressEngine;
import com.tencent.biz.qqcircle.publish.task.compress.VideoCompressTask;
import com.tencent.biz.qqcircle.publish.task.compress.VideoCompressTask.VideoCompressListener;
import com.tencent.biz.qqcircle.publish.task.report.TaskReportInfo.MediaReportInfo;
import com.tencent.biz.qqcircle.publish.util.ExifUtil;
import com.tencent.biz.qqcircle.publish.util.ExtendExifInterface;
import com.tencent.biz.qqcircle.publish.util.PublishUtils;
import com.tencent.biz.qqcircle.publish.util.VideoCompressConfig;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QCircleMediaUploadRequest
  extends QCircleBaseUploadRequest
  implements VideoCompressTask.VideoCompressListener, IUploadTaskCallback
{
  private AbstractUploadTask A;
  private QCircleMediaUploadRequest.IMediaUploadListener B;
  private Object C = new Object();
  public QzoneMediaUploadParams c;
  protected boolean d;
  protected int e;
  protected volatile boolean f;
  protected String g;
  protected List<MediaWrapper> h;
  protected LinkedHashMap<String, QCircleMediaUploadRequest.UploadMediaInfo> i = new LinkedHashMap();
  protected LinkedHashMap<String, QCircleMediaUploadRequest.UploadMediaInfo> j = new LinkedHashMap();
  protected HashMap<String, UploadVideoObject> k = new HashMap();
  protected ArrayList<AbstractUploadTask> l = new ArrayList();
  private int s;
  private int t;
  private volatile int u = 0;
  private int v = 0;
  private int w = 0;
  private long x;
  private HashMap<String, QCircleMediaUploadRequest.UploadMediaInfo> y = new HashMap();
  private ArrayList<VideoCompressTask> z = new ArrayList();
  
  public QCircleMediaUploadRequest() {}
  
  public QCircleMediaUploadRequest(List<MediaWrapper> paramList, QzoneMediaUploadParams paramQzoneMediaUploadParams, IUploadQueueListener paramIUploadQueueListener, QCircleMediaUploadRequest.IMediaUploadListener paramIMediaUploadListener)
  {
    super((String)null);
    this.c = paramQzoneMediaUploadParams;
    if (this.c == null)
    {
      this.c = new QzoneMediaUploadParams();
      QLog.e("[upload2_QCircleMediaUploadRequest]", 1, "constructor error, uploadParams null, set to default");
    }
    if ((this.c.a == 0) || (this.c.a == 4) || (this.c.a == 5)) {
      this.d = true;
    }
    if (!TextUtils.isEmpty(this.c.b)) {
      c(this.c.b);
    }
    if (!TextUtils.isEmpty(this.c.p)) {
      this.a = this.c.p;
    }
    if (this.c.f == 0L)
    {
      this.c.f = (HostStaticInvokeHelper.getServerTimeMillis() / 1000L);
      paramQzoneMediaUploadParams = new StringBuilder();
      paramQzoneMediaUploadParams.append(c());
      paramQzoneMediaUploadParams.append(", get uploadTime 0, reset to serverTime:");
      paramQzoneMediaUploadParams.append(this.c.f);
      QLog.w("[upload2_QCircleMediaUploadRequest]", 1, paramQzoneMediaUploadParams.toString());
    }
    this.x = this.c.c;
    this.g = this.c.d;
    if (paramIUploadQueueListener != null) {
      a(paramIUploadQueueListener);
    }
    if (paramIMediaUploadListener != null) {
      this.B = paramIMediaUploadListener;
    }
    this.h = paramList;
    a(this.h);
    if ((this.i.size() > 0) && (this.j.size() > 0) && (!this.c.t)) {
      this.c.b(true);
    }
  }
  
  private ImageUploadTask a(ImageInfo paramImageInfo, byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramImageInfo, paramArrayOfByte, paramInt, false, false);
  }
  
  private String a(ShuoshuoVideoInfo paramShuoshuoVideoInfo)
  {
    if (paramShuoshuoVideoInfo == null) {
      return null;
    }
    String str2 = paramShuoshuoVideoInfo.h;
    String str1;
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      str1 = str2;
      if (!new File(str2).isDirectory()) {}
    }
    else
    {
      str1 = QCircleVideoUtils.a(paramShuoshuoVideoInfo.b);
    }
    return str1;
  }
  
  private void a(int paramInt, String paramString, JceStruct paramJceStruct)
  {
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.setEncodeName("utf8");
    localUniAttribute.put("ReplyCode", Integer.valueOf(paramInt));
    String str;
    if (paramInt == 0) {
      str = "success";
    } else {
      str = "fail";
    }
    localUniAttribute.put("StrResult", str);
    if (paramJceStruct != null) {
      localUniAttribute.put("response", paramJceStruct);
    }
    this.o.a(localUniAttribute, paramInt, paramInt, paramString, false);
  }
  
  private void a(AbstractUploadTask paramAbstractUploadTask, ImageUploadTask paramImageUploadTask, String paramString)
  {
    if (paramAbstractUploadTask != null)
    {
      if (paramImageUploadTask == null) {
        return;
      }
      paramImageUploadTask.iUploadTime = paramAbstractUploadTask.iUploadTime;
      if (paramImageUploadTask.stExtendInfo == null) {
        paramImageUploadTask.stExtendInfo = new PicExtendInfo();
      }
      if (paramImageUploadTask.stExtendInfo.mapParams == null) {
        paramImageUploadTask.stExtendInfo.mapParams = new HashMap();
      }
      paramImageUploadTask.stExtendInfo.mapParams.put("vid", paramString);
      if (paramImageUploadTask.stExternalMapExt == null) {
        paramImageUploadTask.stExternalMapExt = new HashMap();
      }
      if (this.c.n != null) {
        paramImageUploadTask.stExternalMapExt.putAll(this.c.n);
      }
      paramImageUploadTask.stExternalMapExt.put("is_client_upload_cover", "1");
      paramImageUploadTask.stExternalMapExt.put("is_pic_video_mix_feeds", "1");
      paramAbstractUploadTask = (UploadVideoObject)this.k.get(paramAbstractUploadTask.uploadFilePath);
      if (paramAbstractUploadTask != null)
      {
        paramString = paramImageUploadTask.stExternalMapExt;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbstractUploadTask.g());
        localStringBuilder.append("");
        paramString.put("mix_videoSize", localStringBuilder.toString());
        paramString = paramImageUploadTask.stExternalMapExt;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbstractUploadTask.j());
        localStringBuilder.append("");
        paramString.put("mix_isOriginalVideo", localStringBuilder.toString());
        paramString = paramImageUploadTask.stExternalMapExt;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbstractUploadTask.f());
        localStringBuilder.append("");
        paramString.put("mix_time", localStringBuilder.toString());
        paramImageUploadTask.sPicDesc = paramAbstractUploadTask.e();
      }
      if ((paramImageUploadTask.iDistinctUse == 14301) && (paramImageUploadTask.isCover))
      {
        paramImageUploadTask.iBusiNessType = 0;
        paramImageUploadTask.vBusiNessData = null;
      }
      if (this.c.a()) {
        paramImageUploadTask.vBusiNessData = null;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    QCirclePublishQualityReporter.report(paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", paramString2), QCircleReportHelper.newEntry("ret_code", paramString3), QCircleReportHelper.newEntry("ext1", paramString4), QCircleReportHelper.newEntry("ext2", String.valueOf(paramInt)) }));
  }
  
  public static final byte[] a(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null))
    {
      UniPacket localUniPacket = new UniPacket();
      localUniPacket.setEncodeName("UTF-8");
      localUniPacket.setRequestId(0);
      localUniPacket.setFuncName("FuncName");
      localUniPacket.setServantName("ServantName");
      localUniPacket.put(paramString, paramObject);
      paramString = localUniPacket.encode();
      localUniPacket.clearCacheData();
      return paramString;
    }
    return null;
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    Object localObject1 = this.i.values();
    if ((localObject1 != null) && (!((Collection)localObject1).isEmpty()))
    {
      int m = 0;
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (QCircleMediaUploadRequest.UploadMediaInfo)((Iterator)localObject1).next();
        if (this.f)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(c());
          paramArrayOfByte.append(", doUploadPhoto aborted");
          QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramArrayOfByte.toString());
          a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.O, "-80000000", QCircleConstants.y, m);
          return;
        }
        if (localObject2 == null)
        {
          m += 1;
          a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.O, "-80000001", QCircleConstants.y, m);
        }
        else
        {
          ImageUploadTask localImageUploadTask = a(((QCircleMediaUploadRequest.UploadMediaInfo)localObject2).a.d(), paramArrayOfByte, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject2).b);
          if (localImageUploadTask != null)
          {
            a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.O, "0", QCircleConstants.y, m);
            a(localImageUploadTask, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject2).b, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject2).d);
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(c());
            ((StringBuilder)localObject2).append(", doUploadPhoto, createImageUploadTask error");
            QLog.e("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject2).toString());
            a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.O, "-80000002", QCircleConstants.y, m);
          }
          m += 1;
        }
      }
    }
  }
  
  private boolean f()
  {
    return false;
  }
  
  private void g()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(c());
      ((StringBuilder)localObject1).append(", cancelAllTasks");
      QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject1).toString());
      this.f = true;
      if (this.l.size() > 0)
      {
        localObject1 = this.l.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)((Iterator)localObject1).next();
          UploadServiceBuilder.getInstance().cancel(localAbstractUploadTask);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(c());
          localStringBuilder.append(", cancel flowId:");
          localStringBuilder.append(localAbstractUploadTask.flowId);
          QLog.i("[upload2_QCircleMediaUploadRequest]", 1, localStringBuilder.toString());
        }
        this.l.clear();
      }
      if (this.z.size() > 0)
      {
        localObject1 = this.z.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((VideoCompressTask)((Iterator)localObject1).next()).g();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected int a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = new StringBuilder();
    paramString2.append(str);
    paramString2.append(String.valueOf(paramString1));
    return paramString2.toString().hashCode();
  }
  
  public QCircleQueueTaskInfo a(QCircleQueueTaskInfo paramQCircleQueueTaskInfo)
  {
    if (this.f) {
      return paramQCircleQueueTaskInfo;
    }
    VideoCompressTask localVideoCompressTask = VideoCompressEngine.a().b();
    Object localObject1;
    int m;
    if (localVideoCompressTask != null)
    {
      localObject1 = HardCodeUtil.a(2131909566);
      QCircleMediaUploadRequest.UploadMediaInfo localUploadMediaInfo = (QCircleMediaUploadRequest.UploadMediaInfo)this.j.get(localVideoCompressTask.b);
      boolean bool;
      if (localUploadMediaInfo != null) {
        bool = localUploadMediaInfo.a.e();
      } else {
        bool = false;
      }
      if (bool) {
        localObject1 = HardCodeUtil.a(2131909561);
      }
      if (localVideoCompressTask.y())
      {
        double d1 = localVideoCompressTask.z();
        if (d1 == 0.0D)
        {
          localObject2 = "0.00";
        }
        else
        {
          double d2 = 200.0D * (1.0D / (Math.exp(-d1) + 1.0D) - 0.5D);
          d1 = d2;
          if (Double.isNaN(d2)) {
            d1 = 0.0D;
          }
          localObject2 = String.format("%.2f", new Object[] { Double.valueOf(d1) });
        }
        StringBuilder localStringBuilder;
        if (this.j.size() > 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131909562));
          localStringBuilder.append(this.v + 1);
          localStringBuilder.append(HardCodeUtil.a(2131909557));
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(HardCodeUtil.a(2131909567));
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("%");
          paramQCircleQueueTaskInfo.b = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(HardCodeUtil.a(2131909559));
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("%");
          paramQCircleQueueTaskInfo.b = localStringBuilder.toString();
        }
        paramQCircleQueueTaskInfo.g = false;
        paramQCircleQueueTaskInfo.f = 0;
      }
      else
      {
        m = this.w;
        if (m == 0)
        {
          paramQCircleQueueTaskInfo.b = QCircleConfigHelper.a("QZoneTextSetting", "UploadWait", "等待上传");
          paramQCircleQueueTaskInfo.f = 0;
        }
        else if (m == 1)
        {
          if (this.j.size() > 1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131909558));
            ((StringBuilder)localObject2).append(this.v + 1);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131909563));
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131909568));
            paramQCircleQueueTaskInfo.b = ((StringBuilder)localObject2).toString();
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131909565));
            paramQCircleQueueTaskInfo.b = ((StringBuilder)localObject2).toString();
          }
        }
      }
      Object localObject2 = localVideoCompressTask.b;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (new File((String)localObject2).exists()))
      {
        localObject1 = localObject2;
        if (!new File((String)localObject2).isDirectory()) {}
      }
      else
      {
        localObject1 = localObject2;
        if (localUploadMediaInfo != null)
        {
          localObject1 = localObject2;
          if (localUploadMediaInfo.a != null)
          {
            localObject1 = localObject2;
            if (localUploadMediaInfo.a.c() != null) {
              localObject1 = localUploadMediaInfo.a.c().h;
            }
          }
        }
      }
      paramQCircleQueueTaskInfo.h = ((String)localObject1);
      paramQCircleQueueTaskInfo.i = true;
    }
    if (TextUtils.isEmpty(paramQCircleQueueTaskInfo.h))
    {
      int n = this.u;
      localObject1 = this.h;
      if ((localObject1 != null) && (((List)localObject1).size() > 0) && (n >= 0))
      {
        m = n;
        if (n == this.h.size()) {
          m = n - 1;
        }
        localObject1 = (MediaWrapper)this.h.get(m);
        if (localObject1 != null)
        {
          if (((MediaWrapper)localObject1).b())
          {
            paramQCircleQueueTaskInfo.h = ((MediaWrapper)localObject1).d().a;
            return paramQCircleQueueTaskInfo;
          }
          if (((MediaWrapper)localObject1).a())
          {
            paramQCircleQueueTaskInfo.h = ((MediaWrapper)localObject1).c().h;
            paramQCircleQueueTaskInfo.i = true;
          }
        }
      }
    }
    return paramQCircleQueueTaskInfo;
  }
  
  protected AbstractUploadTask a(ShuoshuoVideoInfo paramShuoshuoVideoInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.f)
    {
      paramShuoshuoVideoInfo = new StringBuilder();
      paramShuoshuoVideoInfo.append(c());
      paramShuoshuoVideoInfo.append(", createVideoUploadTask after aborted, return null!");
      QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramShuoshuoVideoInfo.toString());
      return null;
    }
    if (paramShuoshuoVideoInfo == null)
    {
      paramShuoshuoVideoInfo = new StringBuilder();
      paramShuoshuoVideoInfo.append(c());
      paramShuoshuoVideoInfo.append(", createVideoUploadTask with null videoInfo, return null!");
      QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramShuoshuoVideoInfo.toString());
      return null;
    }
    UploadVideoObject localUploadVideoObject = UploadVideoObject.a(paramShuoshuoVideoInfo);
    Object localObject = paramShuoshuoVideoInfo.b;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!PublishUtils.a((String)localObject))) {
      localUploadVideoObject.a = ((String)localObject);
    }
    this.k.put(localUploadVideoObject.a(), localUploadVideoObject);
    localObject = new VideoUploadTask(localUploadVideoObject.a());
    int m;
    if (this.c.k > 0) {
      m = this.c.k;
    } else {
      m = localUploadVideoObject.i();
    }
    ((VideoUploadTask)localObject).iIsNew = m;
    ((VideoUploadTask)localObject).flowId = a(this.c.d, localUploadVideoObject.a());
    ((VideoUploadTask)localObject).iUin = LoginData.a().b();
    ((VideoUploadTask)localObject).sRefer = "mqq";
    ((VideoUploadTask)localObject).vLoginData = paramArrayOfByte;
    ((VideoUploadTask)localObject).md5 = localUploadVideoObject.b();
    ((VideoUploadTask)localObject).sTitle = localUploadVideoObject.d();
    ((VideoUploadTask)localObject).sDesc = localUploadVideoObject.e();
    ((VideoUploadTask)localObject).iFlag = localUploadVideoObject.c();
    ((VideoUploadTask)localObject).sCoverUrl = localUploadVideoObject.h();
    ((VideoUploadTask)localObject).iPlayTime = ((int)localUploadVideoObject.f());
    ((VideoUploadTask)localObject).iUploadTime = (this.c.f - paramInt);
    ((VideoUploadTask)localObject).iBusiNessType = this.c.l;
    if (this.c.o) {
      paramArrayOfByte = this.c.m;
    } else {
      paramArrayOfByte = a(this.e, paramInt, ((VideoUploadTask)localObject).iUploadTime, localUploadVideoObject);
    }
    ((VideoUploadTask)localObject).vBusiNessData = paramArrayOfByte;
    ((VideoUploadTask)localObject).iIsOriginalVideo = localUploadVideoObject.j();
    ((VideoUploadTask)localObject).iIsFormatF20 = localUploadVideoObject.k();
    ((VideoUploadTask)localObject).uploadEntrance = this.c.e;
    ((VideoUploadTask)localObject).uploadTaskCallback = this;
    if (this.c.J)
    {
      ((VideoUploadTask)localObject).setInnerAppid("qq_story_video");
      ((VideoUploadTask)localObject).iSync = 0;
    }
    a((AbstractUploadTask)localObject, paramShuoshuoVideoInfo);
    ((VideoUploadTask)localObject).extend_info = new HashMap();
    ((VideoUploadTask)localObject).extend_info.put("video_type", UploadVideoObject.b(paramShuoshuoVideoInfo));
    a((AbstractUploadTask)localObject, this.c.e);
    paramShuoshuoVideoInfo = new StringBuilder();
    paramShuoshuoVideoInfo.append(c());
    paramShuoshuoVideoInfo.append(", createVideoUploadTask finish. videoPath:");
    paramShuoshuoVideoInfo.append(((VideoUploadTask)localObject).uploadFilePath);
    paramShuoshuoVideoInfo.append(", flowId:");
    paramShuoshuoVideoInfo.append(((VideoUploadTask)localObject).flowId);
    paramShuoshuoVideoInfo.append(", index: ");
    paramShuoshuoVideoInfo.append(paramInt);
    paramShuoshuoVideoInfo.append(", iUploadTime:");
    paramShuoshuoVideoInfo.append(((VideoUploadTask)localObject).iUploadTime);
    QLog.i("[upload2_QCircleMediaUploadRequest]", 1, paramShuoshuoVideoInfo.toString());
    return localObject;
  }
  
  protected ImageUploadTask a(ImageInfo paramImageInfo, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f)
    {
      paramImageInfo = new StringBuilder();
      paramImageInfo.append(c());
      paramImageInfo.append(", createImageUploadTask after aborted, return null!");
      QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramImageInfo.toString());
      return null;
    }
    if (paramImageInfo == null)
    {
      paramImageInfo = new StringBuilder();
      paramImageInfo.append(c());
      paramImageInfo.append(", createImageUploadTask with null imageInfo, return null!");
      QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramImageInfo.toString());
      return null;
    }
    Object localObject = paramImageInfo.a;
    int n = 0;
    localObject = new ImageUploadTask(false, (String)localObject);
    ((ImageUploadTask)localObject).uploadTaskCallback = this;
    ((ImageUploadTask)localObject).iUin = LoginData.a().b();
    ((ImageUploadTask)localObject).sRefer = "mqq";
    ((ImageUploadTask)localObject).vLoginData = paramArrayOfByte;
    ((ImageUploadTask)localObject).md5 = a(paramImageInfo.a);
    ((ImageUploadTask)localObject).sAlbumName = "";
    ((ImageUploadTask)localObject).flowId = a((int)this.c.c, paramImageInfo.a);
    ((ImageUploadTask)localObject).uploadEntrance = this.c.e;
    ((ImageUploadTask)localObject).sPicTitle = "";
    ((ImageUploadTask)localObject).sPicDesc = this.c.i;
    ((ImageUploadTask)localObject).bWaterType = this.c.j;
    ((ImageUploadTask)localObject).autoRotate = this.d;
    ((ImageUploadTask)localObject).clientFakeKey = this.c.d;
    ((ImageUploadTask)localObject).uploadPoi = this.c.w;
    ((ImageUploadTask)localObject).iBusiNessType = this.c.l;
    if (((ImageUploadTask)localObject).iBusiNessType == 1) {
      ((ImageUploadTask)localObject).vBusiNessData = this.c.m;
    }
    paramArrayOfByte = new MultiPicInfo();
    if (this.c.u > 0) {
      m = this.c.u;
    } else {
      m = this.e;
    }
    paramArrayOfByte.iBatUploadNum = m;
    if (this.c.v >= 0) {
      m = this.c.v;
    } else {
      m = paramInt;
    }
    paramArrayOfByte.iCurUpload = m;
    ((ImageUploadTask)localObject).mutliPicInfo = paramArrayOfByte;
    ((ImageUploadTask)localObject).iUploadTime = (this.c.f - paramInt);
    ((ImageUploadTask)localObject).iUploadType = this.c.h;
    ((ImageUploadTask)localObject).iBatchID = this.c.c;
    int m = n;
    if (this.e > 0) {
      m = 1;
    }
    ((ImageUploadTask)localObject).iUpPicType = m;
    a((ImageUploadTask)localObject, this.c.a);
    a((ImageUploadTask)localObject, this.c, paramImageInfo, paramBoolean1, false);
    a((ImageUploadTask)localObject, this.c);
    a((AbstractUploadTask)localObject, this.c.e);
    paramImageInfo = new StringBuilder();
    paramImageInfo.append(c());
    paramImageInfo.append(", createImageUploadTask finish, picPath:");
    paramImageInfo.append(((ImageUploadTask)localObject).uploadFilePath);
    paramImageInfo.append(", flowId:");
    paramImageInfo.append(((ImageUploadTask)localObject).flowId);
    paramImageInfo.append(", index: ");
    paramImageInfo.append(paramInt);
    paramImageInfo.append(", iUploadTime:");
    paramImageInfo.append(((ImageUploadTask)localObject).iUploadTime);
    QLog.i("[upload2_QCircleMediaUploadRequest]", 1, paramImageInfo.toString());
    return localObject;
  }
  
  public void a(VideoCompressTask paramVideoCompressTask)
  {
    if ((paramVideoCompressTask != null) && (!TextUtils.isEmpty(paramVideoCompressTask.b)))
    {
      if (!this.j.containsKey(paramVideoCompressTask.b)) {
        return;
      }
      paramVideoCompressTask = (QCircleMediaUploadRequest.UploadMediaInfo)this.j.get(paramVideoCompressTask.b);
      if ((paramVideoCompressTask != null) && (paramVideoCompressTask.g != null)) {
        paramVideoCompressTask.g.e = System.currentTimeMillis();
      }
    }
  }
  
  public void a(VideoCompressTask paramVideoCompressTask, double paramDouble)
  {
    if ((paramVideoCompressTask != null) && (this.B != null))
    {
      paramVideoCompressTask = (QCircleMediaUploadRequest.UploadMediaInfo)this.j.get(paramVideoCompressTask.b);
      if (paramVideoCompressTask != null) {
        this.B.a(paramVideoCompressTask.d, paramVideoCompressTask.b, paramDouble);
      }
    }
  }
  
  public void a(VideoCompressTask paramVideoCompressTask, int paramInt)
  {
    this.z.remove(paramVideoCompressTask);
    Object localObject = paramVideoCompressTask.b;
    QCircleMediaUploadRequest.UploadMediaInfo localUploadMediaInfo = (QCircleMediaUploadRequest.UploadMediaInfo)this.j.get(localObject);
    ShuoshuoVideoInfo localShuoshuoVideoInfo = paramVideoCompressTask.u();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()) && (!((String)localObject).equals(localShuoshuoVideoInfo.b))) {
      localShuoshuoVideoInfo.b = ((String)localObject);
    }
    if ((!this.f) && (PublishUtils.a(localShuoshuoVideoInfo)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append(", onCompressFailed errorCode:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", videoPath:");
      ((StringBuilder)localObject).append(localShuoshuoVideoInfo.b);
      ((StringBuilder)localObject).append(", upload video without compress");
      QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject).toString());
      localObject = new Intent();
      ((Intent)localObject).putExtra("video_source_path", localShuoshuoVideoInfo.b);
      a(paramVideoCompressTask, (Intent)localObject);
      VideoCompressEngine.a().b(paramVideoCompressTask);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(", onCompressFailed errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", videoPath:");
    localStringBuilder.append(localShuoshuoVideoInfo.b);
    localStringBuilder.append(", do not upload");
    QLog.e("[upload2_QCircleMediaUploadRequest]", 1, localStringBuilder.toString());
    this.w = 1;
    g();
    if ((this.r.bn_() != 2) || (!paramVideoCompressTask.H()))
    {
      paramVideoCompressTask = new StringBuilder();
      paramVideoCompressTask.append(HardCodeUtil.a(2131909560));
      paramVideoCompressTask.append(this.v + 1);
      paramVideoCompressTask.append(HardCodeUtil.a(2131909564));
      a(paramInt, paramVideoCompressTask.toString(), null);
    }
    paramVideoCompressTask = this.B;
    if (paramVideoCompressTask != null)
    {
      int m;
      if (localUploadMediaInfo != null) {
        m = localUploadMediaInfo.b;
      } else {
        m = -1;
      }
      paramVideoCompressTask.a((String)localObject, m, paramInt, "");
    }
  }
  
  public void a(VideoCompressTask paramVideoCompressTask, Intent paramIntent)
  {
    if (this.f) {
      return;
    }
    this.z.remove(paramVideoCompressTask);
    this.w = 0;
    this.v += 1;
    paramIntent = paramIntent.getStringExtra("video_source_path");
    Object localObject1 = (QCircleMediaUploadRequest.UploadMediaInfo)this.j.get(paramIntent);
    if (localObject1 == null)
    {
      paramVideoCompressTask = new StringBuilder();
      paramVideoCompressTask.append(c());
      paramVideoCompressTask.append(", onCompressSuccess but get UploadMediaInfo fail path = ");
      paramVideoCompressTask.append(localObject1);
      QLog.i("[upload2_QCircleMediaUploadRequest]", 1, paramVideoCompressTask.toString());
      return;
    }
    boolean bool = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).a.e();
    Object localObject2 = paramVideoCompressTask.u();
    this.y.put(((ShuoshuoVideoInfo)localObject2).b, localObject1);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(c());
    ((StringBuilder)localObject3).append(", onCompressSuccess srcPath:");
    ((StringBuilder)localObject3).append(((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d);
    ((StringBuilder)localObject3).append(", destPath:");
    ((StringBuilder)localObject3).append(((ShuoshuoVideoInfo)localObject2).b);
    QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject3).toString());
    if ((!bool) && (((ShuoshuoVideoInfo)localObject2).o > 0L)) {
      ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).c = QCircleVideoUtils.a(((ShuoshuoVideoInfo)localObject2).b);
    }
    ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).g.f = System.currentTimeMillis();
    localObject3 = new File(((ShuoshuoVideoInfo)localObject2).b);
    if (((File)localObject3).exists()) {
      ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).g.d = (((File)localObject3).length() / 1024L);
    }
    localObject3 = this.B;
    if (localObject3 != null) {
      ((QCircleMediaUploadRequest.IMediaUploadListener)localObject3).a(((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d, ((ShuoshuoVideoInfo)localObject2).b, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).e);
    }
    if ((this.r != null) && (this.r.bn_() == 1))
    {
      if (bool)
      {
        localObject2 = new ImageInfo(((ShuoshuoVideoInfo)localObject2).b);
        if (!this.i.containsKey(((ImageInfo)localObject2).a))
        {
          localObject3 = new MediaWrapper((ImageInfo)localObject2);
          QCircleMediaUploadRequest.UploadMediaInfo localUploadMediaInfo = new QCircleMediaUploadRequest.UploadMediaInfo();
          localUploadMediaInfo.a = ((MediaWrapper)localObject3);
          localUploadMediaInfo.b = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b;
          localUploadMediaInfo.e = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).e;
          localUploadMediaInfo.d = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d;
          this.i.put(((ImageInfo)localObject2).a, localUploadMediaInfo);
        }
        localObject2 = a((ImageInfo)localObject2, LoginData.a().e(), ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b);
        if (localObject2 == null)
        {
          paramVideoCompressTask = new StringBuilder();
          paramVideoCompressTask.append(c());
          paramVideoCompressTask.append(", onCompressSuccess, createImageUploadTask[gif] error, return");
          QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramVideoCompressTask.toString());
          return;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(c());
        ((StringBuilder)localObject3).append(", validAndUpload gif, path:");
        ((StringBuilder)localObject3).append(((AbstractUploadTask)localObject2).uploadFilePath);
        ((StringBuilder)localObject3).append(", flowId:");
        ((StringBuilder)localObject3).append(((AbstractUploadTask)localObject2).flowId);
        QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject3).toString());
        a((AbstractUploadTask)localObject2, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d);
      }
      else
      {
        localObject2 = a((ShuoshuoVideoInfo)localObject2, LoginData.a().e(), ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b);
        if (localObject2 == null)
        {
          paramVideoCompressTask = new StringBuilder();
          paramVideoCompressTask.append(c());
          paramVideoCompressTask.append(", onCompressSuccess, createVideoUploadTask error, return");
          QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramVideoCompressTask.toString());
          return;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(c());
        ((StringBuilder)localObject3).append(", validAndUpload, path:");
        ((StringBuilder)localObject3).append(((AbstractUploadTask)localObject2).uploadFilePath);
        ((StringBuilder)localObject3).append(", flowId:");
        ((StringBuilder)localObject3).append(((AbstractUploadTask)localObject2).flowId);
        QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject3).toString());
        a((AbstractUploadTask)localObject2, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d);
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(c());
      ((StringBuilder)localObject1).append(" don't in running state, upload paused");
      QLog.w("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject1).toString());
    }
    if ((paramVideoCompressTask.g) && (!TextUtils.isEmpty(paramIntent)) && (PublishUtils.a(paramIntent))) {
      try
      {
        paramVideoCompressTask = new StringBuilder();
        paramVideoCompressTask.append(c());
        paramVideoCompressTask.append(", delete directory file, path:");
        paramVideoCompressTask.append(paramIntent);
        QLog.i("[upload2_QCircleMediaUploadRequest]", 1, paramVideoCompressTask.toString());
        HostFileUtils.deleteFile(new File(paramIntent));
        return;
      }
      catch (Exception paramVideoCompressTask)
      {
        QLog.w("[upload2_QCircleMediaUploadRequest]", 1, paramVideoCompressTask.getMessage());
      }
    }
  }
  
  protected void a(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (paramAbstractUploadTask == null) {
      return;
    }
    if (paramInt != 19)
    {
      if ((paramInt != 45) && (paramInt != 207)) {}
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return;
        }
        paramAbstractUploadTask.entry = "shoushuo";
        return;
      }
    }
    paramAbstractUploadTask.entry = "album";
  }
  
  protected void a(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    this.l.add(paramAbstractUploadTask);
    Object localObject;
    if (a(paramAbstractUploadTask))
    {
      localObject = this.B;
      if (localObject != null) {
        ((QCircleMediaUploadRequest.IMediaUploadListener)localObject).a(paramInt, paramString, paramAbstractUploadTask.uploadFilePath);
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append(", validAndUpload fail, srcPath:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", flowId:");
      ((StringBuilder)localObject).append(paramAbstractUploadTask.flowId);
      QLog.e("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(AbstractUploadTask paramAbstractUploadTask, ShuoshuoVideoInfo paramShuoshuoVideoInfo)
  {
    if (paramShuoshuoVideoInfo != null)
    {
      Object localObject = paramShuoshuoVideoInfo.u;
      boolean bool = false;
      if (localObject != null) {
        bool = paramShuoshuoVideoInfo.u.getBoolean("video_is_sync_to_weishi", false);
      }
      paramAbstractUploadTask.isSyncWeishi = bool;
      if (paramAbstractUploadTask.isSyncWeishi)
      {
        paramAbstractUploadTask.sDevIMEI = QCircleHostDeviceHelper.getIMEI();
        if ((paramAbstractUploadTask instanceof ImageUploadTask))
        {
          localObject = (ImageUploadTask)paramAbstractUploadTask;
          if ((this.c.G != null) && (((ImageUploadTask)localObject).stExtendInfo != null) && (((ImageUploadTask)localObject).stExtendInfo.mapParams != null))
          {
            ((ImageUploadTask)localObject).stExternalMapExt.put("geo_x_choose", String.valueOf(this.c.G.lbs_x));
            ((ImageUploadTask)localObject).stExternalMapExt.put("geo_y_choose", String.valueOf(this.c.G.lbs_y));
          }
          if (paramShuoshuoVideoInfo.v == null) {
            paramAbstractUploadTask = "";
          } else {
            paramAbstractUploadTask = paramShuoshuoVideoInfo.v;
          }
          ((ImageUploadTask)localObject).sPicDesc = paramAbstractUploadTask;
        }
      }
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, int paramInt)
  {
    if (paramImageUploadTask == null) {
      return;
    }
    int m = 7;
    int i1 = 0;
    int n = 0;
    if (paramInt == 4)
    {
      if ((paramImageUploadTask.iBusiNessType != 0) && (!this.c.s)) {
        paramImageUploadTask.iSync = 1;
      } else {
        paramImageUploadTask.iSync = 0;
      }
      if (!this.c.J) {
        n = paramImageUploadTask.iSync;
      }
      paramImageUploadTask.iSync = n;
      paramImageUploadTask.sAlbumID = "";
      if (this.c.y != -1) {
        m = this.c.y;
      }
      paramImageUploadTask.iAlbumTypeID = m;
    }
    else if ((paramInt != 1) && (paramInt != 3))
    {
      paramImageUploadTask.iSync = 1;
      if (TextUtils.isEmpty(this.c.g))
      {
        if (this.c.y != -1) {
          m = this.c.y;
        } else {
          m = 1;
        }
        paramImageUploadTask.iAlbumTypeID = m;
      }
      else
      {
        m = i1;
        if (this.c.y != -1) {
          m = this.c.y;
        }
        paramImageUploadTask.iAlbumTypeID = m;
        paramImageUploadTask.sAlbumID = this.c.g;
      }
    }
    else
    {
      paramImageUploadTask.iSync = 0;
      paramImageUploadTask.sAlbumID = "";
      if (this.c.y != -1) {
        m = this.c.y;
      }
      paramImageUploadTask.iAlbumTypeID = m;
    }
    if (paramInt == 0)
    {
      paramImageUploadTask.iDistinctUse = 14301;
      return;
    }
    if (paramInt == 1)
    {
      paramImageUploadTask.iDistinctUse = 14302;
      return;
    }
    if ((paramInt == 4) || (paramInt == 3)) {
      paramImageUploadTask.iDistinctUse = 14303;
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, QzoneMediaUploadParams paramQzoneMediaUploadParams)
  {
    if (paramImageUploadTask != null)
    {
      if (paramQzoneMediaUploadParams == null) {
        return;
      }
      paramQzoneMediaUploadParams = paramQzoneMediaUploadParams.z;
      if (paramQzoneMediaUploadParams != null)
      {
        paramImageUploadTask.preupload = paramQzoneMediaUploadParams.b;
        if (paramQzoneMediaUploadParams.a(paramImageUploadTask.uploadFilePath)) {
          paramImageUploadTask.preupload = 2;
        }
      }
      else
      {
        paramImageUploadTask.preupload = 0;
      }
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, QzoneMediaUploadParams paramQzoneMediaUploadParams, ImageInfo paramImageInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    if (paramImageUploadTask != null)
    {
      if (paramQzoneMediaUploadParams == null) {
        return;
      }
      if (paramImageUploadTask.stExtendInfo == null) {
        paramImageUploadTask.stExtendInfo = new PicExtendInfo();
      }
      if (paramImageUploadTask.stExtendInfo.mapParams == null) {
        paramImageUploadTask.stExtendInfo.mapParams = new HashMap();
      }
      if (paramImageUploadTask.stExternalMapExt == null) {
        paramImageUploadTask.stExternalMapExt = new HashMap();
      }
      boolean bool = paramQzoneMediaUploadParams.t;
      str1 = "1";
      if (bool) {
        paramImageUploadTask.stExternalMapExt.put("is_pic_video_mix_feeds", "1");
      }
      if ((paramQzoneMediaUploadParams.D != null) && (paramQzoneMediaUploadParams.D.size() > 0)) {
        paramImageUploadTask.stExternalMapExt.putAll(paramQzoneMediaUploadParams.D);
      }
    }
    try
    {
      if (JpegExifReader.isCrashJpeg(paramImageUploadTask.uploadFilePath)) {
        break label190;
      }
      localObject = new ExtendExifInterface(paramImageUploadTask.uploadFilePath);
      paramImageUploadTask.stExtendInfo.mapExif = ExifUtil.a((ExtendExifInterface)localObject);
      paramImageUploadTask.exifTime = a((ExtendExifInterface)localObject, paramImageUploadTask.uploadFilePath);
    }
    catch (Exception localException)
    {
      Object localObject;
      label181:
      Iterator localIterator;
      break label181;
    }
    QLog.e("[upload2_QCircleMediaUploadRequest]", 1, "read pic exif error");
    label190:
    if ((!paramBoolean1) && (!f()))
    {
      if (paramImageInfo.f != null) {
        a(paramImageUploadTask, paramImageInfo.f);
      } else {
        a(paramImageUploadTask);
      }
    }
    else {
      a(paramImageUploadTask, paramQzoneMediaUploadParams.E);
    }
    localObject = new HashMap();
    if ((paramImageInfo != null) && (paramImageInfo.h != null) && (paramImageInfo.h.size() > 0))
    {
      localIterator = paramImageInfo.h.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        ((HashMap)localObject).put(str2, (byte[])paramImageInfo.h.get(str2));
      }
    }
    if ((paramQzoneMediaUploadParams.B != null) && (paramQzoneMediaUploadParams.B.containsKey(paramImageInfo.a))) {
      ((HashMap)localObject).put("mark_uin_upload", paramQzoneMediaUploadParams.B.get(paramImageInfo.a));
    } else {
      ((HashMap)localObject).put("mark_uin_upload", new byte[0]);
    }
    paramImageUploadTask.mExternalByteData = ((HashMap)localObject);
    if ((paramQzoneMediaUploadParams.F != null) && (paramQzoneMediaUploadParams.F.size() > 0)) {
      paramImageUploadTask.mExternalByteData.putAll(paramQzoneMediaUploadParams.F);
    }
    if ((paramImageInfo != null) && (paramQzoneMediaUploadParams.C != null) && (paramQzoneMediaUploadParams.C.containsKey(paramImageInfo.a)))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("youtu_tag_array", paramQzoneMediaUploadParams.C.get(paramImageInfo.a));
      paramImageUploadTask.stExternalMapExt.putAll((Map)localObject);
    }
    if ((paramImageInfo != null) && (paramImageInfo.g != null) && (paramImageInfo.g.size() > 0)) {
      paramImageUploadTask.stExternalMapExt.putAll(paramImageInfo.g);
    }
    if (!TextUtils.isEmpty(paramQzoneMediaUploadParams.x)) {
      paramImageUploadTask.stExtendInfo.mapParams.put("open_appid", paramQzoneMediaUploadParams.x);
    }
    if (paramQzoneMediaUploadParams.w != null)
    {
      paramImageUploadTask.stExtendInfo.mapParams.put("show_geo", String.valueOf(paramQzoneMediaUploadParams.w.show_poi));
      if (QLog.isDevelopLevel())
      {
        paramImageInfo = new StringBuilder();
        paramImageInfo.append(", show_geo:");
        paramImageInfo.append(paramQzoneMediaUploadParams.w.show_poi);
        QLog.d("[upload2_QCircleMediaUploadRequest]", 4, paramImageInfo.toString());
      }
    }
    else
    {
      paramImageUploadTask.stExtendInfo.mapParams.put("show_geo", "0");
      if (QLog.isDevelopLevel()) {
        QLog.d("[upload2_QCircleMediaUploadRequest]", 4, ", show_geo:0");
      }
    }
    if (paramBoolean2)
    {
      QLog.d("[upload2_QCircleMediaUploadRequest]", 1, new Object[] { "setExtendInfoParams... hasSelectCover:", Boolean.valueOf(paramQzoneMediaUploadParams.N) });
      paramImageInfo = paramImageUploadTask.stExtendInfo.mapParams;
      if (paramQzoneMediaUploadParams.N) {
        paramImageUploadTask = str1;
      } else {
        paramImageUploadTask = "0";
      }
      paramImageInfo.put("user_select_cover", paramImageUploadTask);
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, Object paramObject)
  {
    synchronized (this.C)
    {
      this.u += 1;
      Object localObject2 = (QCircleMediaUploadRequest.UploadMediaInfo)this.i.get(paramImageUploadTask.uploadFilePath);
      ??? = localObject2;
      if (localObject2 == null)
      {
        ??? = localObject2;
        if (!TextUtils.isEmpty(paramImageUploadTask.mOriginFilePath)) {
          ??? = (QCircleMediaUploadRequest.UploadMediaInfo)this.i.get(paramImageUploadTask.mOriginFilePath);
        }
      }
      if ((??? != null) && (((QCircleMediaUploadRequest.UploadMediaInfo)???).g != null))
      {
        ((QCircleMediaUploadRequest.UploadMediaInfo)???).g.e = paramImageUploadTask.compressStartTime;
        ((QCircleMediaUploadRequest.UploadMediaInfo)???).g.f = paramImageUploadTask.compressEndTime;
        localObject2 = this.B;
        if (localObject2 != null) {
          ((QCircleMediaUploadRequest.IMediaUploadListener)localObject2).a(((QCircleMediaUploadRequest.UploadMediaInfo)???).g);
        }
      }
      boolean bool = paramImageUploadTask.isCover;
      Object localObject4 = null;
      if (bool) {
        localObject2 = (QCircleMediaUploadRequest.UploadMediaInfo)this.j.get(paramImageUploadTask.srcVideoPath);
      } else {
        localObject2 = null;
      }
      if ((paramObject instanceof ImageUploadResult))
      {
        Object localObject5 = (ImageUploadResult)paramObject;
        UploadFileResponse localUploadFileResponse = new UploadFileResponse();
        localUploadFileResponse.albumId = ((ImageUploadResult)localObject5).sAlbumID;
        localUploadFileResponse.height = ((ImageUploadResult)localObject5).iHeight;
        localUploadFileResponse.width = ((ImageUploadResult)localObject5).iWidth;
        localUploadFileResponse.photoId = ((ImageUploadResult)localObject5).sPhotoID;
        localUploadFileResponse.slocId = ((ImageUploadResult)localObject5).sSloc;
        localUploadFileResponse.originId = ((ImageUploadResult)localObject5).sOriPhotoID;
        localUploadFileResponse.oheight = ((ImageUploadResult)localObject5).iOriHeight;
        localUploadFileResponse.owidth = ((ImageUploadResult)localObject5).iOriWidth;
        localUploadFileResponse.url = ((ImageUploadResult)localObject5).sBURL;
        localUploadFileResponse.picType = ((ImageUploadResult)localObject5).iPicType;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(LoginData.a().b());
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(paramImageUploadTask.iUploadTime);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(this.c.d);
        localUploadFileResponse.clientFakeKey = ((StringBuilder)localObject3).toString();
        if (??? != null) {
          localObject3 = ((QCircleMediaUploadRequest.UploadMediaInfo)???).d;
        } else {
          localObject3 = "";
        }
        localUploadFileResponse.originUploadUrl = ((String)localObject3);
        localUploadFileResponse.md5 = ((ImageUploadResult)localObject5).sPhotoMD5;
        if (??? != null) {
          ((QCircleMediaUploadRequest.UploadMediaInfo)???).f = localUploadFileResponse;
        }
        if (this.B != null)
        {
          int m;
          if (??? != null) {
            m = ((QCircleMediaUploadRequest.UploadMediaInfo)???).e;
          }
          for (;;)
          {
            break;
            if (localObject2 != null) {
              m = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject2).e;
            } else {
              m = 0;
            }
          }
          QCircleMediaUploadRequest.IMediaUploadListener localIMediaUploadListener = this.B;
          localObject5 = ((ImageUploadResult)localObject5).sPhotoID;
          localObject3 = localObject4;
          if (??? != null) {
            localObject3 = ((QCircleMediaUploadRequest.UploadMediaInfo)???).d;
          }
          localIMediaUploadListener.a(localUploadFileResponse, paramImageUploadTask, m, (String)localObject5, (String)localObject3, paramImageUploadTask.uploadFilePath);
        }
        if (this.r != null) {
          this.r.a(paramObject);
        }
        synchronized (this.C)
        {
          if (this.u >= this.e)
          {
            paramObject = localUploadFileResponse;
            if (paramImageUploadTask.isCover)
            {
              paramObject = localUploadFileResponse;
              if (localObject2 != null) {
                paramObject = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject2).f;
              }
            }
            a(0, "", paramObject);
          }
          return;
        }
      }
      return;
    }
    for (;;)
    {
      throw paramImageUploadTask;
    }
  }
  
  protected void a(VideoUploadTask arg1, Object paramObject)
  {
    Object localObject2 = (QCircleMediaUploadRequest.UploadMediaInfo)this.j.get(???.uploadFilePath);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (QCircleMediaUploadRequest.UploadMediaInfo)this.y.get(???.uploadFilePath);
    }
    if (localObject1 == null)
    {
      paramObject = new StringBuilder();
      paramObject.append(c());
      paramObject.append(", get MediaOrderInfo fail path = ");
      paramObject.append(???.uploadFilePath);
      paramObject.append(", flowId:");
      paramObject.append(???.flowId);
      QLog.i("[upload2_QCircleMediaUploadRequest]", 1, paramObject.toString());
      return;
    }
    if (((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).g != null)
    {
      localObject2 = this.B;
      if (localObject2 != null) {
        ((QCircleMediaUploadRequest.IMediaUploadListener)localObject2).a(((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).g);
      }
    }
    Object localObject3 = (VideoUploadResult)paramObject;
    localObject2 = new UploadVideoInfoRsp();
    ((UploadVideoInfoRsp)localObject2).iBusiNessType = ((VideoUploadResult)localObject3).iBusiNessType;
    ((UploadVideoInfoRsp)localObject2).sVid = ((VideoUploadResult)localObject3).sVid;
    ((UploadVideoInfoRsp)localObject2).vBusiNessData = ((VideoUploadResult)localObject3).vBusiNessData;
    localObject3 = ((UploadVideoInfoRsp)localObject2).sVid;
    ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).f = ((JceStruct)localObject2);
    MediaWrapper localMediaWrapper = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).a;
    Object localObject4 = (UploadVideoObject)this.k.get(???.uploadFilePath);
    if ((localObject4 != null) && (TextUtils.isEmpty(((UploadVideoObject)localObject4).a)) && (localMediaWrapper != null) && (localMediaWrapper.a()) && (localMediaWrapper.c().m == 0) && (!PublishUtils.a(???.uploadFilePath)))
    {
      ((UploadVideoObject)localObject4).a = ???.uploadFilePath;
      ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d = ???.uploadFilePath;
    }
    localObject4 = this.B;
    if (localObject4 != null) {
      ((QCircleMediaUploadRequest.IMediaUploadListener)localObject4).a((JceStruct)localObject2, ???, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).e, (String)localObject3, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d, ???.uploadFilePath);
    }
    if (this.r != null) {
      this.r.a(paramObject);
    }
    if (this.c.q)
    {
      localObject2 = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).c;
      paramObject = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramObject = new StringBuilder();
        paramObject.append(c());
        paramObject.append(", coverPath == null, reget cover, videoPath:");
        paramObject.append(???.uploadFilePath);
        paramObject.append(", flowId:");
        paramObject.append(???.flowId);
        QLog.i("[upload2_QCircleMediaUploadRequest]", 1, paramObject.toString());
        paramObject = QCircleVideoUtils.a(???.uploadFilePath);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(c());
      ((StringBuilder)localObject2).append(", create VideoCover Upload Task, videoPath:");
      ((StringBuilder)localObject2).append(???.uploadFilePath);
      ((StringBuilder)localObject2).append(", coverPath:");
      ((StringBuilder)localObject2).append(paramObject);
      QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject2).toString());
      localObject2 = ImageInfo.a(paramObject);
      boolean bool;
      if (f())
      {
        bool = true;
      }
      else
      {
        if (localObject2 != null) {
          ((ImageInfo)localObject2).f = b(((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d);
        }
        bool = false;
      }
      localObject2 = a((ImageInfo)localObject2, LoginData.a().e(), ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b, bool, true);
      if (localObject2 == null)
      {
        localObject1 = QzoneUploadConst.a(1707);
        b(1707, (String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(c());
        ((StringBuilder)localObject2).append(", create VideoCover Upload Task failed msg:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", videoPath:");
        ((StringBuilder)localObject2).append(???.uploadFilePath);
        ((StringBuilder)localObject2).append(", coverPath:");
        ((StringBuilder)localObject2).append(paramObject);
        QLog.e("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject2).toString());
        a(QCirclePublishQualityReporter.E_UPLOAD_RESULT, this.c.O, "-80000005", QCircleConstants.x, 0);
        return;
      }
      ((ImageUploadTask)localObject2).isCover = true;
      ((ImageUploadTask)localObject2).srcVideoPath = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d;
      a(???, (ImageUploadTask)localObject2, (String)localObject3);
      a((ImageUploadTask)localObject2, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d);
      if ((localMediaWrapper != null) && (localMediaWrapper.a())) {
        a((AbstractUploadTask)localObject2, localMediaWrapper.c());
      }
      a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.O, "0", QCircleConstants.y, 0);
      a((AbstractUploadTask)localObject2, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d);
      paramObject = new StringBuilder();
      paramObject.append(c());
      paramObject.append(", upload video succeed, videoPath:");
      paramObject.append(???.uploadFilePath);
      paramObject.append(", flowId:");
      paramObject.append(???.flowId);
      paramObject.append(", vid:");
      paramObject.append((String)localObject3);
      paramObject.append(", validAndUpload, coverPath:");
      paramObject.append(((ImageUploadTask)localObject2).uploadFilePath);
      paramObject.append(", cover flowId:");
      paramObject.append(((ImageUploadTask)localObject2).flowId);
      QLog.i("[upload2_QCircleMediaUploadRequest]", 1, paramObject.toString());
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append(c());
    paramObject.append(", upload video succeed, videoPath:");
    paramObject.append(???.uploadFilePath);
    paramObject.append(", flowId:");
    paramObject.append(???.flowId);
    paramObject.append(", vid:");
    paramObject.append((String)localObject3);
    paramObject.append(", don't need upload cover");
    QLog.i("[upload2_QCircleMediaUploadRequest]", 1, paramObject.toString());
    synchronized (this.C)
    {
      this.u += 1;
      if (this.u >= this.e) {
        a(0, "", (JceStruct)localObject2);
      }
      return;
    }
  }
  
  protected void a(List<MediaWrapper> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.e = 0;
      this.j.clear();
      this.i.clear();
      this.s = paramList.size();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (MediaWrapper)localIterator.next();
        if (localObject2 != null)
        {
          int m = paramList.indexOf(localObject2);
          Object localObject1 = new QCircleMediaUploadRequest.UploadMediaInfo();
          ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).a = ((MediaWrapper)localObject2);
          ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b = m;
          ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).e = (this.t + m);
          Object localObject3;
          if (((MediaWrapper)localObject2).a())
          {
            this.e += 1;
            ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d = ((MediaWrapper)localObject2).c().b;
            this.j.put(((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d, localObject1);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(c());
            ((StringBuilder)localObject3).append(", load video ");
            ((StringBuilder)localObject3).append(((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d);
            QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject3).toString());
            ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).g = new TaskReportInfo.MediaReportInfo(2, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d);
            ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).g.c = (((MediaWrapper)localObject2).c().g / 1024L);
          }
          else if (((MediaWrapper)localObject2).b())
          {
            localObject3 = ((MediaWrapper)localObject2).d();
            if ((localObject3 != null) && (!URLUtil.isNetworkUrl(((ImageInfo)localObject3).a)))
            {
              this.e += 1;
              ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d = ((ImageInfo)localObject3).a;
              this.i.put(((ImageInfo)localObject3).a, localObject1);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(c());
              ((StringBuilder)localObject2).append(", load photo ");
              ((StringBuilder)localObject2).append(((ImageInfo)localObject3).a);
              QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject2).toString());
              ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).g = new TaskReportInfo.MediaReportInfo(1, ((ImageInfo)localObject3).a);
              ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).g.c = (((ImageInfo)localObject3).c / 1024L);
            }
            else
            {
              localIterator.remove();
              this.t += 1;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(c());
              ((StringBuilder)localObject2).append(", load photo ");
              if (localObject3 == null)
              {
                localObject1 = "null imageInfo";
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("rich image:");
                ((StringBuilder)localObject1).append(((ImageInfo)localObject3).a);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(", pass this one, current index:");
              ((StringBuilder)localObject2).append(m);
              QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject2).toString());
            }
          }
        }
      }
      paramList = new StringBuilder();
      paramList.append(c());
      paramList.append(", uploadMediaList total num:");
      paramList.append(this.s);
      paramList.append(", batch num:");
      paramList.append(this.e);
      paramList.append(", rich photo num:");
      paramList.append(this.t);
      QLog.i("[upload2_QCircleMediaUploadRequest]", 1, paramList.toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    c(paramArrayOfByte);
    b(paramArrayOfByte);
  }
  
  public boolean a()
  {
    g();
    return true;
  }
  
  protected byte[] a(int paramInt1, int paramInt2, long paramLong, UploadVideoObject paramUploadVideoObject)
  {
    UploadPicInfoReq localUploadPicInfoReq = new UploadPicInfoReq();
    localUploadPicInfoReq.iBatchID = this.c.c;
    localUploadPicInfoReq.mutliPicInfo = new MultiPicInfo();
    localUploadPicInfoReq.mutliPicInfo.iBatUploadNum = paramInt1;
    localUploadPicInfoReq.mutliPicInfo.iCurUpload = paramInt2;
    if (localUploadPicInfoReq.stExtendInfo == null)
    {
      localUploadPicInfoReq.stExtendInfo = new PicExtendInfo();
      localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
    }
    if (localUploadPicInfoReq.stExternalMapExt == null) {
      localUploadPicInfoReq.stExternalMapExt = new HashMap();
    }
    if (this.c.t)
    {
      localUploadPicInfoReq.stExternalMapExt.put("is_client_upload_cover", "1");
      localUploadPicInfoReq.stExternalMapExt.put("is_pic_video_mix_feeds", "1");
    }
    String str = "";
    Object localObject2;
    if (paramUploadVideoObject != null)
    {
      localObject1 = localUploadPicInfoReq.stExternalMapExt;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUploadVideoObject.g());
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("mix_videoSize", ((StringBuilder)localObject2).toString());
      localObject1 = localUploadPicInfoReq.stExternalMapExt;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUploadVideoObject.j());
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("mix_isOriginalVideo", ((StringBuilder)localObject2).toString());
      localObject1 = localUploadPicInfoReq.stExternalMapExt;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUploadVideoObject.f());
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("mix_time", ((StringBuilder)localObject2).toString());
    }
    if (Build.VERSION.SDK_INT >= 5)
    {
      if (localUploadPicInfoReq.stExtendInfo == null) {
        paramUploadVideoObject = null;
      } else {
        paramUploadVideoObject = localUploadPicInfoReq.stExtendInfo.mapExif;
      }
      if (paramUploadVideoObject != null)
      {
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("Make"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_CameraMaker = ((String)localObject1);
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("Model"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_CameraModel = ((String)localObject1);
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("GPSLatitude"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_Latitude = ((String)localObject1);
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("GPSLatitudeRef"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_LatitudeRef = ((String)localObject1);
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("GPSLongitude"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_Longitude = ((String)localObject1);
        localObject1 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("GPSLongitudeRef"));
        paramUploadVideoObject = (UploadVideoObject)localObject1;
        if (localObject1 == null) {
          paramUploadVideoObject = "";
        }
        localUploadPicInfoReq.sExif_LongitudeRef = paramUploadVideoObject;
      }
    }
    localUploadPicInfoReq.iUploadTime = paramLong;
    Object localObject1 = (HashMap)localUploadPicInfoReq.mapExt;
    paramUploadVideoObject = (UploadVideoObject)localObject1;
    if (localObject1 == null) {
      paramUploadVideoObject = new HashMap();
    }
    if (this.c.d == null) {
      localObject1 = str;
    } else {
      localObject1 = this.c.d;
    }
    paramUploadVideoObject.put("mobile_fakefeeds_clientkey", localObject1);
    if ((localUploadPicInfoReq.stExtendInfo != null) && (localUploadPicInfoReq.stExtendInfo.mapParams == null)) {
      localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
    }
    if (!TextUtils.isEmpty(this.c.b)) {
      paramUploadVideoObject.put("refer", this.c.b);
    }
    localUploadPicInfoReq.mapExt = paramUploadVideoObject;
    localUploadPicInfoReq.iBusiNessType = this.c.l;
    if (localUploadPicInfoReq.iBusiNessType == 1)
    {
      if (this.c.m == null) {
        paramUploadVideoObject = new byte[0];
      } else {
        paramUploadVideoObject = this.c.m;
      }
      localUploadPicInfoReq.vBusiNessData = paramUploadVideoObject;
    }
    else
    {
      localUploadPicInfoReq.vBusiNessData = new byte[0];
    }
    try
    {
      paramUploadVideoObject = a("UploadPicInfoReq", localUploadPicInfoReq);
      return paramUploadVideoObject;
    }
    catch (Throwable paramUploadVideoObject)
    {
      QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramUploadVideoObject.getMessage());
    }
    return null;
  }
  
  public void b() {}
  
  protected void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
    if (this.r != null) {
      this.r.a(null, paramInt, paramString);
    }
  }
  
  protected void b(byte[] paramArrayOfByte)
  {
    Object localObject1 = this.j.values();
    QLog.d("[upload2_QCircleMediaUploadRequest]", 1, new Object[] { "doUploadVideo... upload video size:", Integer.valueOf(((Collection)localObject1).size()) });
    if ((localObject1 != null) && (!((Collection)localObject1).isEmpty()))
    {
      Object localObject3 = ((Collection)localObject1).iterator();
      int m = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (QCircleMediaUploadRequest.UploadMediaInfo)((Iterator)localObject3).next();
        if (this.f)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(c());
          paramArrayOfByte.append(", doUploadVideo aborted");
          QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramArrayOfByte.toString());
          a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.O, "-80000000", QCircleConstants.x, m);
          return;
        }
        if ((localObject1 != null) && (((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).a != null))
        {
          Object localObject2 = ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).a.c();
          if (localObject2 != null)
          {
            ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).c = a((ShuoshuoVideoInfo)localObject2);
            if (((((ShuoshuoVideoInfo)localObject2).q) && (((ShuoshuoVideoInfo)localObject2).f == ((ShuoshuoVideoInfo)localObject2).t)) || (((ShuoshuoVideoInfo)localObject2).t >= QCircleHostQzoneHelper.getVideoCanCompressLimitMs())) {
              ((ShuoshuoVideoInfo)localObject2).n = false;
            }
            if (PublishUtils.a(((ShuoshuoVideoInfo)localObject2).b)) {
              ((ShuoshuoVideoInfo)localObject2).n = true;
            }
            if (!PublishUtils.c(((ShuoshuoVideoInfo)localObject2).b))
            {
              g();
              a(1700, QzoneUploadConst.a(1700), null);
              paramArrayOfByte = this.B;
              if (paramArrayOfByte != null) {
                paramArrayOfByte.a(((ShuoshuoVideoInfo)localObject2).b, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b, 1700, "");
              }
              a(QCirclePublishQualityReporter.E_UPLOAD_RESULT, this.c.O, "-80000004", QCircleConstants.x, m);
              return;
            }
            Object localObject4;
            if (PublishUtils.b((ShuoshuoVideoInfo)localObject2))
            {
              boolean bool;
              if ((((ShuoshuoVideoInfo)localObject2).n) && (((ShuoshuoVideoInfo)localObject2).m == 0) && (PublishUtils.a(((ShuoshuoVideoInfo)localObject2).b))) {
                bool = true;
              } else {
                bool = false;
              }
              if (VideoCompressConfig.a()) {
                bool = true;
              }
              localObject4 = new VideoCompressTask((ShuoshuoVideoInfo)localObject2, this.c.d, this, bool);
              if (((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).a.e()) {
                ((VideoCompressTask)localObject4).a(((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).a.e());
              }
              ((VideoCompressTask)localObject4).b(this.c.I);
              ((VideoCompressTask)localObject4).c(((ShuoshuoVideoInfo)localObject2).q);
              this.z.add(localObject4);
              VideoCompressEngine.a().c((VideoCompressTask)localObject4);
              continue;
            }
            if ((!PublishUtils.a()) && ((PublishUtils.a(((ShuoshuoVideoInfo)localObject2).b)) || (!PublishUtils.a((ShuoshuoVideoInfo)localObject2))))
            {
              g();
              paramArrayOfByte = QzoneUploadConst.a(1706);
              b(1706, paramArrayOfByte);
              localObject3 = this.B;
              if (localObject3 != null) {
                ((QCircleMediaUploadRequest.IMediaUploadListener)localObject3).a(((ShuoshuoVideoInfo)localObject2).b, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b, 1706, paramArrayOfByte);
              }
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append(c());
              paramArrayOfByte.append(", upload video which must compress, but check video compress env failed.");
              QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramArrayOfByte.toString());
              a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.O, "-80000003", QCircleConstants.x, m);
              return;
            }
            if (((ShuoshuoVideoInfo)localObject2).n)
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(c());
              ((StringBuilder)localObject4).append(", video[");
              ((StringBuilder)localObject4).append(((ShuoshuoVideoInfo)localObject2).b);
              ((StringBuilder)localObject4).append("] need compress but env check failed, upload directly");
              QLog.i("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject4).toString());
              ((ShuoshuoVideoInfo)localObject2).n = false;
            }
            localObject2 = a((ShuoshuoVideoInfo)localObject2, paramArrayOfByte, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b);
            if (localObject2 != null)
            {
              a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.O, "0", QCircleConstants.x, m);
              a((AbstractUploadTask)localObject2, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).b, ((QCircleMediaUploadRequest.UploadMediaInfo)localObject1).d);
              continue;
            }
            a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.O, "-80000002", QCircleConstants.x, m);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(c());
            ((StringBuilder)localObject1).append(", doUploadVideo, createVideoUploadTask error");
            QLog.e("[upload2_QCircleMediaUploadRequest]", 1, ((StringBuilder)localObject1).toString());
            continue;
          }
        }
        m += 1;
      }
    }
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchId:");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", fakeKey:");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    this.A = paramAbstractUploadTask;
    this.l.remove(paramAbstractUploadTask);
    String str = paramString;
    if (paramString == null) {
      str = QCircleConfigHelper.a("QZoneTextSetting", "UploadFail", "上传失败");
    }
    paramString = new StringBuilder();
    paramString.append(c());
    paramString.append(", onUploadError path:");
    paramString.append(paramAbstractUploadTask.uploadFilePath);
    paramString.append(", flowId:");
    paramString.append(paramAbstractUploadTask.flowId);
    paramString.append(" errorCode:");
    paramString.append(paramInt);
    paramString.append(", errorMsg:");
    paramString.append(str);
    QLog.e("[upload2_QCircleMediaUploadRequest]", 1, paramString.toString());
    a(paramInt, str, null);
    g();
    if (this.r != null) {
      this.r.a(paramAbstractUploadTask, paramInt, str);
    }
    if (this.B != null)
    {
      boolean bool = paramAbstractUploadTask instanceof ImageUploadTask;
      Object localObject;
      if (bool)
      {
        paramString = this.i;
        localObject = paramAbstractUploadTask.uploadFilePath;
        paramAbstractUploadTask = paramString;
        paramString = (String)localObject;
      }
      else
      {
        localObject = this.j;
        paramString = paramAbstractUploadTask.uploadFilePath;
        paramAbstractUploadTask = (AbstractUploadTask)localObject;
      }
      paramAbstractUploadTask = (QCircleMediaUploadRequest.UploadMediaInfo)paramAbstractUploadTask.get(paramString);
      paramString = this.B;
      int m;
      if (paramAbstractUploadTask != null) {
        m = paramAbstractUploadTask.b;
      } else {
        m = -1;
      }
      paramString.a(m, paramInt, str, bool);
    }
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2)
  {
    if (this.f) {
      return;
    }
    if (this.r != null)
    {
      this.r.a(paramLong2 / 1024L, paramLong1 / 1024L);
      if (this.r.bn_() != 1)
      {
        this.r.a(1);
        this.r.a(System.currentTimeMillis());
      }
      this.r.b();
    }
  }
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (!this.f)
    {
      if (paramInt == 3) {
        return;
      }
      if ((this.r != null) && (this.r.bn_() != paramInt)) {
        this.r.a(paramInt);
      }
    }
  }
  
  public void onUploadSucceed(AbstractUploadTask paramAbstractUploadTask, Object paramObject)
  {
    if (this.f) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(", onUploadSucceed, path:");
    localStringBuilder.append(paramAbstractUploadTask.uploadFilePath);
    localStringBuilder.append(", flowId:");
    localStringBuilder.append(paramAbstractUploadTask.flowId);
    localStringBuilder.append(", mCurNumImage:");
    localStringBuilder.append(this.u);
    QLog.i("[upload2_QCircleMediaUploadRequest]", 1, localStringBuilder.toString());
    this.l.remove(paramAbstractUploadTask);
    if ((paramAbstractUploadTask instanceof ImageUploadTask))
    {
      a((ImageUploadTask)paramAbstractUploadTask, paramObject);
      return;
    }
    if ((paramAbstractUploadTask instanceof VideoUploadTask)) {
      a((VideoUploadTask)paramAbstractUploadTask, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.request.QCircleMediaUploadRequest
 * JD-Core Version:    0.7.0.1
 */