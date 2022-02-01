package com.tencent.biz.qqcircle.publish.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostAEHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.QZoneAppConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._PhotoConst;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QAlbumConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCirclePicPreviewInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart;
import com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.ContentSet;
import com.tencent.biz.qqcircle.publish.activity.QCircleSavePart;
import com.tencent.biz.qqcircle.publish.common.config.LocalConfig;
import com.tencent.biz.qqcircle.publish.model.DynamicArrayList;
import com.tencent.biz.qqcircle.publish.model.ImageInfo;
import com.tencent.biz.qqcircle.publish.model.MediaWrapper;
import com.tencent.biz.qqcircle.publish.model.QzoneShuoShuoParams;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoContent;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoVideoInfo;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.service.video.util.QCircleVideoUtils;
import com.tencent.biz.qqcircle.publish.task.QCircleUploadShuoShuoTask;
import com.tencent.biz.qqcircle.publish.util.AlbumUtil;
import com.tencent.biz.qqcircle.publish.util.ImageQualityPreference;
import com.tencent.biz.qqcircle.publish.util.ImageUtil;
import com.tencent.biz.qqcircle.publish.util.QcirclePublishJumpModel;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleMapReporter;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.LocalMultiProcConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QCirclePublishViewModel
  extends BasePublishModel
  implements QCircleAEEditorGenerateResultListener, QCircleAEEditorUICallbackListener
{
  public static final int u = QCircleConfigHelper.aG() / 1000;
  public static boolean x = true;
  QcirclePublishJumpModel A = new QcirclePublishJumpModel();
  public boolean B = true;
  protected QCirclePublishViewModel.EditVideoTimeOutRunnable C = new QCirclePublishViewModel.EditVideoTimeOutRunnable(this);
  private HashMap<String, ArrayList<String>> E = new HashMap();
  private HashMap<String, String> F;
  private boolean G = false;
  private ArrayList<String> H;
  private boolean I = false;
  private int J;
  private boolean K = false;
  private boolean L = false;
  private Intent M;
  private QCirclePublishViewModel.AEEditorUIBroadcastReceiver N = new QCirclePublishViewModel.AEEditorUIBroadcastReceiver(this);
  public MutableLiveData<DynamicArrayList<String>> a = new MutableLiveData();
  public MutableLiveData<HashMap<String, LocalMediaInfo>> b = new MutableLiveData();
  public MutableLiveData<HashMap<String, ShuoshuoVideoInfo>> c = new MutableLiveData();
  public MutableLiveData<QCirclePublishContentPart.ContentSet> d = new MutableLiveData();
  public MutableLiveData<Boolean> e = new MutableLiveData();
  public DynamicArrayList<String> f = new DynamicArrayList();
  public HashMap<String, LocalMediaInfo> g = new HashMap();
  public String h;
  public HashMap<String, String> i = new HashMap();
  public boolean j;
  public String k = QCircleHostConstants._AEEditorConstants.AE_PHOTO_PICKER_TAB_ALBUM();
  public int l;
  public int m;
  public boolean n = false;
  protected long o;
  public int p;
  public boolean q = false;
  public boolean r = false;
  protected boolean s = false;
  boolean t = true;
  public long v;
  public String w = "";
  public LbsDataV2.PoiInfo y = null;
  public boolean z = false;
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_MEDIA_POSITION(), paramInt);
    if (this.g.get(paramString) == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClickPhotoPreview... mSelectedMediaInfoMap.get(path) == null path:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("[QcirclePublish]QCirclePublishViewModel", 1, ((StringBuilder)localObject).toString());
      paramString = QCircleConfigHelper.a("QZoneTextSetting", "ToastVideoSomeThingfail", "预览失败");
      QCircleToast.a(QCircleToast.c, paramString, 0);
      return;
    }
    ((Intent)localObject).putExtra(QCircleHostConstants._AEEditorConstants.KEY_AE_VIDEO_MISSION_ID(), ((LocalMediaInfo)this.g.get(paramString)).missionID);
    HostUIHelper.openHostEnvironment(new QCirclePublishViewModel.4(this, (Intent)localObject));
    QCirclePublishReport.a(15, 28, 1, null, null);
  }
  
  private void a(QzoneShuoShuoParams paramQzoneShuoShuoParams)
  {
    QCircleUploadShuoShuoTask localQCircleUploadShuoShuoTask = new QCircleUploadShuoShuoTask(67, 1, paramQzoneShuoShuoParams);
    localQCircleUploadShuoShuoTask.av = UUID.randomUUID().toString();
    localQCircleUploadShuoShuoTask.y = paramQzoneShuoShuoParams.z;
    localQCircleUploadShuoShuoTask.z = paramQzoneShuoShuoParams.H;
    QCircleTaskQueue.a().a(localQCircleUploadShuoShuoTask);
    a(localQCircleUploadShuoShuoTask);
  }
  
  private void a(QzoneShuoShuoParams paramQzoneShuoShuoParams, BasePartFragment paramBasePartFragment, ArrayList<MediaWrapper> paramArrayList, LocalMediaInfo paramLocalMediaInfo)
  {
    if (ImageQualityPreference.a().a(1, paramLocalMediaInfo) == 3) {
      bool = true;
    } else {
      bool = false;
    }
    this.s = bool;
    boolean bool = this.s;
    paramLocalMediaInfo.needProcess = (bool ^ true);
    paramLocalMediaInfo.mIsUploadOrigin = bool;
    paramQzoneShuoShuoParams.W = paramLocalMediaInfo.isVideoReady;
    paramQzoneShuoShuoParams.X = paramLocalMediaInfo.missionID;
    ShuoshuoVideoInfo localShuoshuoVideoInfo = QCircleVideoUtils.a(paramBasePartFragment.getActivity(), paramLocalMediaInfo._id, paramLocalMediaInfo.path, paramLocalMediaInfo.fileSize, 1, paramLocalMediaInfo.thumbnailPath, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth, 0L, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.needProcess, null);
    Object localObject = localShuoshuoVideoInfo;
    if (localShuoshuoVideoInfo == null)
    {
      QLog.w("[QcirclePublish]QCirclePublishViewModel", 1, "videoInfo == null and renew");
      localObject = QCircleVideoUtils.a(paramBasePartFragment.getActivity(), paramLocalMediaInfo._id, paramLocalMediaInfo.path, paramLocalMediaInfo.fileSize, 1, null, paramLocalMediaInfo.thumbHeight, paramLocalMediaInfo.thumbWidth, 0L, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.needProcess, null, false);
    }
    ((ShuoshuoVideoInfo)localObject).v = paramQzoneShuoShuoParams.b;
    QCircleVideoUtils.a((ShuoshuoVideoInfo)localObject, "video_is_use_qcircle_rate", true);
    if ((paramLocalMediaInfo.mOriginPath != null) && (paramLocalMediaInfo.mOriginPath.size() > 0))
    {
      ((ShuoshuoVideoInfo)localObject).y = paramLocalMediaInfo.mOriginPath;
    }
    else
    {
      ((ShuoshuoVideoInfo)localObject).y = new ArrayList();
      ((ShuoshuoVideoInfo)localObject).y.add(paramLocalMediaInfo.path);
    }
    localObject = new MediaWrapper((ShuoshuoVideoInfo)localObject);
    if (((MediaWrapper)localObject).c().n == true)
    {
      ((MediaWrapper)localObject).c().n = paramLocalMediaInfo.needProcess;
      paramQzoneShuoShuoParams = ((MediaWrapper)localObject).c();
      int i1;
      if (paramLocalMediaInfo.needProcess == true) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      paramQzoneShuoShuoParams.l = i1;
      ((MediaWrapper)localObject).c().q = (true ^ paramLocalMediaInfo.needProcess);
    }
    else if (!paramLocalMediaInfo.needProcess)
    {
      ((MediaWrapper)localObject).c().n = false;
      ((MediaWrapper)localObject).c().l = 1;
      ((MediaWrapper)localObject).c().q = true;
    }
    ((MediaWrapper)localObject).f = paramLocalMediaInfo.mediaOriginWidth;
    ((MediaWrapper)localObject).g = paramLocalMediaInfo.mediaOriginHeight;
    ((MediaWrapper)localObject).h = paramLocalMediaInfo.mediaOriginSize;
    ((MediaWrapper)localObject).i = paramLocalMediaInfo.mediaOriginBitrate;
    ((MediaWrapper)localObject).j = paramLocalMediaInfo.mediaBitrate;
    ((MediaWrapper)localObject).a = paramLocalMediaInfo.materialID;
    ((MediaWrapper)localObject).b = paramLocalMediaInfo.filterID;
    ((MediaWrapper)localObject).c = paramLocalMediaInfo.materialName;
    ((MediaWrapper)localObject).d = paramLocalMediaInfo.scheme;
    ((MediaWrapper)localObject).e = paramLocalMediaInfo.showCircleTakeSame;
    ((MediaWrapper)localObject).k = paramLocalMediaInfo.mKuolieId;
    ((MediaWrapper)localObject).l = paramLocalMediaInfo.mKuolieCenterX;
    ((MediaWrapper)localObject).m = paramLocalMediaInfo.mKuolieCenterY;
    ((MediaWrapper)localObject).o = paramLocalMediaInfo.mKuolieWidthScale;
    ((MediaWrapper)localObject).p = paramLocalMediaInfo.mKuolieHeightScale;
    ((MediaWrapper)localObject).n = paramLocalMediaInfo.mKuolieRotate;
    bool = TextUtils.isEmpty((CharSequence)this.i.get("templateId"));
    paramBasePartFragment = "none";
    if (bool) {
      paramQzoneShuoShuoParams = "none";
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("templateId");
    }
    ((MediaWrapper)localObject).q = paramQzoneShuoShuoParams;
    if (TextUtils.isEmpty((CharSequence)this.i.get("filterId"))) {
      paramQzoneShuoShuoParams = "none";
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("filterId");
    }
    ((MediaWrapper)localObject).r = paramQzoneShuoShuoParams;
    if (TextUtils.isEmpty((CharSequence)this.i.get("stickerId"))) {
      paramQzoneShuoShuoParams = "none";
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("stickerId");
    }
    ((MediaWrapper)localObject).s = paramQzoneShuoShuoParams;
    if (TextUtils.isEmpty((CharSequence)this.i.get("textId"))) {
      paramQzoneShuoShuoParams = paramBasePartFragment;
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("textId");
    }
    ((MediaWrapper)localObject).t = paramQzoneShuoShuoParams;
    paramArrayList.add(localObject);
  }
  
  private void a(QzoneShuoShuoParams paramQzoneShuoShuoParams, ArrayList<MediaWrapper> paramArrayList, ArrayList<String> paramArrayList1, LocalMediaInfo paramLocalMediaInfo)
  {
    if (URLUtil.isNetworkUrl(paramLocalMediaInfo.path))
    {
      localObject = new ImageInfo();
      ((ImageInfo)localObject).a = paramLocalMediaInfo.path;
    }
    else
    {
      localObject = new ImageInfo(paramLocalMediaInfo.path);
      ((ImageInfo)localObject).k = paramLocalMediaInfo.panoramaPhotoType;
    }
    ((ImageInfo)localObject).r = paramLocalMediaInfo.mMimeType;
    if ((paramQzoneShuoShuoParams.E != null) && (paramQzoneShuoShuoParams.E.containsKey(paramLocalMediaInfo.path))) {
      ((ImageInfo)localObject).h.put("mark_uin_upload", paramQzoneShuoShuoParams.E.get(paramLocalMediaInfo.path));
    }
    ((ImageInfo)localObject).e = paramQzoneShuoShuoParams.b;
    a(paramLocalMediaInfo, (ImageInfo)localObject);
    ((ImageInfo)localObject).o = paramLocalMediaInfo.mediaOriginWidth;
    ((ImageInfo)localObject).p = paramLocalMediaInfo.mediaOriginHeight;
    ((ImageInfo)localObject).q = paramLocalMediaInfo.mediaOriginSize;
    MediaWrapper localMediaWrapper = new MediaWrapper((ImageInfo)localObject);
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
    boolean bool = TextUtils.isEmpty((CharSequence)this.i.get("ImageTemplateId"));
    Object localObject = "none";
    if (bool) {
      paramQzoneShuoShuoParams = "none";
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("ImageTemplateId");
    }
    localMediaWrapper.q = paramQzoneShuoShuoParams;
    if (TextUtils.isEmpty((CharSequence)this.i.get("filterId"))) {
      paramQzoneShuoShuoParams = "none";
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("filterId");
    }
    localMediaWrapper.r = paramQzoneShuoShuoParams;
    if (TextUtils.isEmpty((CharSequence)this.i.get("stickerId"))) {
      paramQzoneShuoShuoParams = "none";
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("stickerId");
    }
    localMediaWrapper.s = paramQzoneShuoShuoParams;
    if (TextUtils.isEmpty((CharSequence)this.i.get("textId"))) {
      paramQzoneShuoShuoParams = "none";
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("textId");
    }
    localMediaWrapper.t = paramQzoneShuoShuoParams;
    if (TextUtils.isEmpty((CharSequence)this.i.get("frameId"))) {
      paramQzoneShuoShuoParams = "none";
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("frameId");
    }
    localMediaWrapper.u = paramQzoneShuoShuoParams;
    if (TextUtils.isEmpty((CharSequence)this.i.get("cropId"))) {
      paramQzoneShuoShuoParams = (QzoneShuoShuoParams)localObject;
    } else {
      paramQzoneShuoShuoParams = (String)this.i.get("cropId");
    }
    localMediaWrapper.v = paramQzoneShuoShuoParams;
    paramArrayList.add(localMediaWrapper);
    paramArrayList1.add(paramLocalMediaInfo.path);
  }
  
  private void a(QCircleUploadShuoShuoTask paramQCircleUploadShuoShuoTask)
  {
    if (paramQCircleUploadShuoShuoTask == null) {
      return;
    }
    paramQCircleUploadShuoShuoTask = paramQCircleUploadShuoShuoTask.I();
    if (paramQCircleUploadShuoShuoTask == null) {
      return;
    }
    a(paramQCircleUploadShuoShuoTask);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramQCircleUploadShuoShuoTask, 1));
    SimpleEventBus.getInstance().dispatchEvent(new QCircleSelectTabEvent(1).needScrollTop());
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i1 = QCircleConfigHelper.a("qqcircle", "QcircleEditVideoTimeout", Integer.valueOf(60000)).intValue();
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
    RFThreadManager.getSerialThreadHandler().postDelayed(this.C, i1);
    this.C.a = paramLocalMediaInfo.missionID;
    Object localObject2 = QCircleMapReporter.getInstance();
    if (TextUtils.isEmpty(paramLocalMediaInfo.missionID)) {
      localObject1 = "NoId";
    } else {
      localObject1 = paramLocalMediaInfo.missionID;
    }
    ((QCircleMapReporter)localObject2).startKey((String)localObject1);
    String str = QCirclePublishQualityReporter.E_VIDEO_EXPORT_START;
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.w);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramLocalMediaInfo.mediaOriginWidth);
    ((StringBuilder)localObject1).append("x");
    ((StringBuilder)localObject1).append(paramLocalMediaInfo.mediaOriginHeight);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ext1", ((StringBuilder)localObject1).toString());
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("ext2", String.valueOf(paramLocalMediaInfo.mediaOriginBitrate));
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("ext3", String.valueOf(paramLocalMediaInfo.mediaOriginSize));
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("ext4", String.valueOf(paramLocalMediaInfo.mDuration / 1000L));
    ArrayList localArrayList = paramLocalMediaInfo.mOriginPath;
    localObject2 = "";
    localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (paramLocalMediaInfo.mOriginPath.size() > 0) {
        localObject1 = (String)paramLocalMediaInfo.mOriginPath.get(0);
      }
    }
    QCirclePublishQualityReporter.report(str, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, QCircleReportHelper.newEntry("ext5", (String)localObject1), QCircleReportHelper.newEntry("ret_code", "0") }));
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, ImageInfo paramImageInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth != 0) && (paramLocalMediaInfo.mediaHeight != 0))
    {
      paramImageInfo.m = paramLocalMediaInfo.mediaWidth;
      paramImageInfo.n = paramLocalMediaInfo.mediaHeight;
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramLocalMediaInfo.path, localOptions);
    int i1 = ImageUtil.a(paramLocalMediaInfo.path);
    if ((i1 != 90) && (i1 != 270))
    {
      paramImageInfo.m = localOptions.outWidth;
      paramImageInfo.n = localOptions.outHeight;
      return;
    }
    paramImageInfo.m = localOptions.outHeight;
    paramImageInfo.n = localOptions.outWidth;
  }
  
  private void a(QCircleFakeFeed paramQCircleFakeFeed)
  {
    Object localObject1 = paramQCircleFakeFeed.getContent();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    localObject1 = new StringBuilder((String)localObject1);
    Matcher localMatcher = QCirclePublishContentPart.p.matcher((CharSequence)localObject1);
    int i1 = 0;
    int i2 = 0;
    try
    {
      while (localMatcher.find())
      {
        int i3 = localMatcher.start() - i2;
        int i4 = localMatcher.end() - i2;
        if (i4 - i3 != 1)
        {
          String str = localMatcher.group().substring(1);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("{tagName=");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("}");
          localObject2 = ((StringBuilder)localObject2).toString();
          ((StringBuilder)localObject1).replace(i3 + 1, i4, (String)localObject2);
          i2 += str.length() - ((String)localObject2).length();
          i1 = 1;
        }
      }
      if (i1 != 0)
      {
        paramQCircleFakeFeed.setContent(((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception paramQCircleFakeFeed)
    {
      QLog.e("[QcirclePublish]QCirclePublishViewModel", 1, paramQCircleFakeFeed, new Object[0]);
    }
  }
  
  public static boolean a(long paramLong)
  {
    return QCircleHostQzoneHelper.getInt4Uin("_qq_circle_publish", 0, paramLong) == 1;
  }
  
  public static boolean a(String paramString, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if (!QCircleHostAEHelper.checkAEResVersionOKForAEBasePackage())
    {
      QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, "isPtuReady... checkAEResVersionOK not OK");
      return false;
    }
    if (paramHashMap.containsKey(paramString))
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramHashMap.get(paramString);
      if (localLocalMediaInfo != null)
      {
        if ((TextUtils.isEmpty(localLocalMediaInfo.missionID)) && (AlbumUtil.b((LocalMediaInfo)paramHashMap.get(paramString))))
        {
          QLog.w("[QcirclePublish]QCirclePublishViewModel", 1, "isPtuReady... missionId empty");
          return false;
        }
        return true;
      }
      QLog.w("[QcirclePublish]QCirclePublishViewModel", 1, "isPtuReady... mediaInfo == null");
      return false;
    }
    QLog.w("[QcirclePublish]QCirclePublishViewModel", 1, "isPtuReady... mSelectedVideoInfoMap.containsKey(videoPath) is false");
    return false;
  }
  
  private String b(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = paramString;
    if (paramHashMap != null)
    {
      localObject = paramString;
      if (paramHashMap.containsKey("atuin"))
      {
        String[] arrayOfString = ((String)paramHashMap.get("atuin")).split(",");
        ArrayList localArrayList = new ArrayList();
        localObject = new StringBuilder();
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          paramHashMap = HostDataTransUtils.getFriendNickName(arrayOfString[i1]);
          if (!TextUtils.isEmpty(paramHashMap))
          {
            localArrayList.add(paramHashMap);
            paramHashMap = QCirclePublishContentPart.b(paramHashMap.replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A").replace(">", "%3E"));
          }
          else
          {
            paramHashMap = arrayOfString[i1];
            localArrayList.add(arrayOfString[i1]);
          }
          ((StringBuilder)localObject).append("@{uin:");
          ((StringBuilder)localObject).append(arrayOfString[i1]);
          ((StringBuilder)localObject).append(",nick:");
          ((StringBuilder)localObject).append(paramHashMap);
          ((StringBuilder)localObject).append("} ");
          i1 += 1;
        }
        if (TextUtils.isEmpty(paramString))
        {
          paramString = new StringBuilder();
          paramString.append("\n");
          paramString.append(localObject);
          return paramString.toString();
        }
        paramHashMap = new StringBuilder();
        paramHashMap.append(paramString);
        paramHashMap.append("\n");
        paramHashMap.append(localObject);
        localObject = paramHashMap.toString();
      }
    }
    return localObject;
  }
  
  private ArrayList<String> d(Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getStringArrayListExtra(QCircleHostConstants._PhotoConst.PHOTO_PATHS());
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra(QCircleHostConstants._QAlbumConstants.SELECTED_MEDIA_INFO_HASH_MAP());
    paramIntent = (HashMap)paramIntent.getSerializableExtra("key_image_sucai_info");
    if (paramIntent != null) {
      this.i = paramIntent;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("getData4Intent... imagePaths:");
    paramIntent.append(localArrayList);
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, paramIntent.toString());
    if (localHashMap != null) {
      if (this.g != null)
      {
        QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, "getData4Intent... has old mSelectedMediaInfoMap");
        this.g.putAll(localHashMap);
      }
      else
      {
        this.g = localHashMap;
      }
    }
    if (this.g == null) {
      this.g = new HashMap();
    }
    return localArrayList;
  }
  
  public static boolean m()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_show_associate_tag_panel", Integer.valueOf(1)).intValue() == 1;
  }
  
  private void n()
  {
    Object localObject1 = new HashMap();
    Iterator localIterator = this.f.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      ((HashMap)localObject1).put(localObject2, (LocalMediaInfo)this.g.get(localObject2));
    }
    this.g.clear();
    this.g.putAll((Map)localObject1);
    localObject1 = this.E;
    if ((localObject1 != null) && (((HashMap)localObject1).size() > 0))
    {
      localIterator = this.g.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        ArrayList localArrayList = (ArrayList)this.E.get(((Map.Entry)localObject1).getKey());
        if (localArrayList != null) {
          ((LocalMediaInfo)((Map.Entry)localObject1).getValue()).aiTextLabel = localArrayList;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("path:");
        ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getKey());
        ((StringBuilder)localObject2).append(" aiTextCache:");
        if (localArrayList != null) {
          localObject1 = localArrayList.toString();
        } else {
          localObject1 = "null";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, ((StringBuilder)localObject2).toString());
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkSelectMediaInfoMap... mSelectedMediaInfoMap size:");
    ((StringBuilder)localObject1).append(this.g.size());
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, ((StringBuilder)localObject1).toString());
  }
  
  private void o()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = this.g.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((AlbumUtil.b(localLocalMediaInfo)) && (!localLocalMediaInfo.isVideoReady)) {
          a(localLocalMediaInfo);
        }
        if ((AlbumUtil.b(localLocalMediaInfo)) && (TextUtils.isEmpty(localLocalMediaInfo.thumbnailPath))) {
          QCircleVideoUtils.a(QCircleApplication.APP, localLocalMediaInfo);
        }
      }
    }
  }
  
  private void p()
  {
    Object localObject1 = this.g;
    String str = "1";
    Object localObject5 = "0";
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((HashMap)localObject1).entrySet().iterator();
      localObject1 = "0";
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (LocalMediaInfo)((Map.Entry)((Iterator)localObject3).next()).getValue();
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).mKuolieId)) {
          localObject2 = "1";
        }
        localObject1 = localObject2;
        if (((LocalMediaInfo)localObject4).mTextId > 0)
        {
          i1 = ((LocalMediaInfo)localObject4).mTextId;
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = "0";
    int i2 = QCircleHostQzoneHelper.getInt4Uin("qcircle_publish_selected_grid_save", QCircleConfigHelper.a("qqcircle", "qqcircle_save_media_in_device_when_publish", Integer.valueOf(0)).intValue(), LoginData.a().b());
    int i1 = 1;
    if (i2 != 1) {
      i1 = 0;
    }
    localObject1 = this.F;
    if (localObject1 != null)
    {
      localObject1 = (String)((HashMap)localObject1).get("traceid");
      localObject4 = localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      localObject4 = "0";
    }
    localObject1 = q();
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      localObject3 = TextUtils.join(";", (Iterable)localObject1);
    } else {
      localObject3 = "0";
    }
    if (this.y == null)
    {
      localObject1 = "2";
    }
    else
    {
      localObject1 = localObject5;
      if (this.z) {
        localObject1 = "1";
      }
    }
    localObject5 = new QCircleLpReportDc05504.DataBuilder();
    Object localObject4 = ((QCircleLpReportDc05504.DataBuilder)localObject5).setExt1(String.valueOf(this.l)).setExt2((String)localObject4).setExt5((String)localObject1);
    if (this.I) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    localObject4 = ((QCircleLpReportDc05504.DataBuilder)localObject4).setExt6((String)localObject1);
    if (i1 != 0) {
      localObject1 = str;
    } else {
      localObject1 = "2";
    }
    ((QCircleLpReportDc05504.DataBuilder)localObject4).setExt7((String)localObject1).setExt8((String)localObject2).setExt12((String)localObject3);
    if (this.i.size() > 0)
    {
      boolean bool = TextUtils.isEmpty((CharSequence)this.i.get("shuiyinId"));
      localObject2 = "none";
      if (bool) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.i.get("shuiyinId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject5).setExt9((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.i.get("filterId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.i.get("filterId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt10((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.i.get("frameId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.i.get("frameId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt11((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.i.get("stickerId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.i.get("stickerId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt13((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.i.get("guajianId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.i.get("guajianId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt14((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.i.get("templateId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.i.get("templateId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt15((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.i.get("ImageTemplateId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.i.get("ImageTemplateId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt16((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.i.get("textId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.i.get("textId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt17((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.i.get("musicId"))) {
        localObject1 = localObject2;
      } else {
        localObject1 = (String)this.i.get("musicId");
      }
      ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt18((String)localObject1);
    }
    QCirclePublishReport.a(15, 2, 0, (QCircleLpReportDc05504.DataBuilder)localObject5);
  }
  
  private List<String> q()
  {
    if (TextUtils.isEmpty(this.h)) {
      return null;
    }
    localArrayList = new ArrayList();
    Object localObject = new StringBuilder(this.h);
    localObject = QCirclePublishContentPart.p.matcher((CharSequence)localObject);
    try
    {
      while (((Matcher)localObject).find())
      {
        int i1 = ((Matcher)localObject).start();
        if (((Matcher)localObject).end() - i1 != 1) {
          localArrayList.add(((Matcher)localObject).group().substring(1));
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      QLog.e("[QcirclePublish]QCirclePublishViewModel", 1, localException, new Object[0]);
    }
  }
  
  public String a()
  {
    return "[QcirclePublish]QCirclePublishViewModel";
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.f;
    if ((localObject != null) && (paramInt < ((DynamicArrayList)localObject).size())) {
      localObject = (String)this.f.get(paramInt);
    } else {
      localObject = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      HashMap localHashMap = this.g;
      if ((localHashMap != null) && (localHashMap.containsKey(localObject)))
      {
        if (AlbumUtil.b((LocalMediaInfo)this.g.remove(localObject))) {
          QCirclePublishReport.a(15, 28, 2, null, null);
        }
        this.b.postValue(this.g);
      }
      this.f.remove(paramInt);
      this.a.postValue(this.f);
      k();
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    Object localObject1 = this.f;
    if ((localObject1 != null) && (((DynamicArrayList)localObject1).size() != 0))
    {
      localObject1 = (String)this.f.get(0);
      if (this.g.get(localObject1) != null)
      {
        if (!AlbumUtil.b((LocalMediaInfo)this.g.get(localObject1)))
        {
          localObject1 = new ArrayList();
          Object localObject2 = this.f.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            ((List)localObject1).add(this.g.get(str));
          }
          localObject2 = new QCirclePicPreviewInitBean();
          ((QCirclePicPreviewInitBean)localObject2).setMediaInfoList((List)localObject1);
          ((QCirclePicPreviewInitBean)localObject2).setClientTraceId(this.w);
          QCircleLauncher.a(paramActivity, (QCirclePicPreviewInitBean)localObject2, paramInt);
          QCirclePublishReport.a(15, 20, 0, "", "");
          return;
        }
        if (!a((String)localObject1, this.g))
        {
          b(paramActivity);
          QCirclePublishReport.a(15, 28, 1, null, null);
          return;
        }
        a(0, (String)localObject1);
      }
      return;
    }
    QLog.e("[QcirclePublish]QCirclePublishViewModel", 1, "onClickPhotoPreview... extendGridView == null || mSelectedImageList == null || mSelectedImageList.size() == 0");
    a(paramActivity);
    QCirclePublishReport.a(15, 19, 2, "", "");
  }
  
  public void a(Context paramContext)
  {
    this.A.a(paramContext, this.M, this.f, this.n, this.k);
    this.E.clear();
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = d(paramIntent);
    if (paramIntent != null) {
      QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, new Object[] { "loadFromAlbumList pic size: ", Integer.valueOf(paramIntent.size()) });
    } else {
      QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, "loadFromAlbumList pic is null");
    }
    if ((paramIntent != null) && (this.f != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadFromAlbumList... has selected size :");
      localStringBuilder.append(this.f.size());
      QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, localStringBuilder.toString());
      if (this.n) {
        this.f.clear();
      }
      this.f.addAll(paramIntent);
    }
    n();
    this.a.postValue(this.f);
    this.b.postValue(this.g);
    o();
    k();
  }
  
  public void a(QzoneShuoShuoParams paramQzoneShuoShuoParams, BasePartFragment paramBasePartFragment)
  {
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < paramQzoneShuoShuoParams.c.size(); i2 = i3)
    {
      localObject1 = (String)paramQzoneShuoShuoParams.c.get(i1);
      localObject1 = (LocalMediaInfo)this.g.get(localObject1);
      if (localObject1 != null)
      {
        ((ArrayList)localObject2).add(localObject1);
      }
      else
      {
        localObject1 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject1).path = ((String)this.f.get(i1));
        ((ArrayList)localObject2).add(localObject1);
      }
      if (AlbumUtil.c((LocalMediaInfo)localObject1))
      {
        a(paramQzoneShuoShuoParams, (ArrayList)localObject3, localArrayList, (LocalMediaInfo)localObject1);
        i3 = i2;
      }
      else
      {
        i3 = i2;
        if (AlbumUtil.b((LocalMediaInfo)localObject1))
        {
          a(paramQzoneShuoShuoParams, paramBasePartFragment, (ArrayList)localObject3, (LocalMediaInfo)localObject1);
          i3 = i2 + 1;
        }
      }
      i1 += 1;
    }
    if (i2 == 0) {
      QCircleSavePart.a(paramQzoneShuoShuoParams.c);
    }
    paramQzoneShuoShuoParams.d = ((List)localObject2);
    paramQzoneShuoShuoParams.K = ((ArrayList)localObject3);
    paramQzoneShuoShuoParams.N = localArrayList;
    paramQzoneShuoShuoParams.Y = this.l;
    paramQzoneShuoShuoParams.Z = this.m;
    boolean bool;
    if (QCircleHostQzoneHelper.getInt4Uin("qcircle_publish_selected_grid_save", QCircleConfigHelper.a("qqcircle", "qqcircle_save_media_in_device_when_publish", Integer.valueOf(0)).intValue(), LoginData.a().b()) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramQzoneShuoShuoParams.aa = bool;
    Object localObject1 = QCirclePublishQualityReporter.E_PUBLIC_EXIT_NORMAL;
    localObject2 = QCircleReportHelper.newEntry("traceid", this.w);
    localObject3 = QCircleReportHelper.newEntry("ret_code", "0");
    if (i2 == 0) {
      paramBasePartFragment = "pic";
    } else {
      paramBasePartFragment = "video";
    }
    QCirclePublishQualityReporter.report((String)localObject1, Arrays.asList(new FeedCloudCommon.Entry[] { localObject2, localObject3, QCircleReportHelper.newEntry("ext1", paramBasePartFragment), QCircleReportHelper.newEntry("ext2", String.valueOf(paramQzoneShuoShuoParams.c.size())) }));
  }
  
  public void a(BasePartFragment paramBasePartFragment)
  {
    QCircleHostAEHelper.removeListener(this);
    QCircleHostAEHelper.removeUICallbackListener(this);
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
    p();
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
    Object localObject1 = paramBasePartFragment.getActivity().getIntent();
    if (localObject1 != null) {
      localObject1 = ((Intent)localObject1).getStringExtra("key_ext_param");
    } else {
      localObject1 = null;
    }
    QzoneShuoShuoParams localQzoneShuoShuoParams = new QzoneShuoShuoParams();
    localQzoneShuoShuoParams.S = false;
    String str = this.h;
    Object localObject2 = str;
    if (str != null) {
      localObject2 = str.trim();
    }
    localQzoneShuoShuoParams.b = ((String)localObject2);
    localQzoneShuoShuoParams.c = this.f;
    localQzoneShuoShuoParams.k = false;
    localQzoneShuoShuoParams.r = ImageQualityPreference.a().a(1, this.f, this.g);
    localQzoneShuoShuoParams.w = ((String)localObject1);
    localQzoneShuoShuoParams.z = this.p;
    localQzoneShuoShuoParams.ac = this.I;
    localQzoneShuoShuoParams.ad = this.w;
    localObject2 = ((QCirclePoiViewModel)paramBasePartFragment.a(QCirclePoiViewModel.class)).d();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashMap();
    }
    localQzoneShuoShuoParams.p = ((Map)localObject1);
    localQzoneShuoShuoParams.i = ((QCirclePoiViewModel)paramBasePartFragment.a(QCirclePoiViewModel.class)).g;
    localQzoneShuoShuoParams.j = ((QCirclePoiViewModel)paramBasePartFragment.a(QCirclePoiViewModel.class)).b();
    localQzoneShuoShuoParams.x = ((QCirclePoiViewModel)paramBasePartFragment.a(QCirclePoiViewModel.class)).c();
    localQzoneShuoShuoParams.m = ((QCircleShareViewModel)paramBasePartFragment.a(QCircleShareViewModel.class)).b;
    a(localQzoneShuoShuoParams, paramBasePartFragment);
    a(localQzoneShuoShuoParams);
    if ((this.G) && (!QCircleConfigHelper.a(HostDataTransUtils.isStudyMode())))
    {
      localObject1 = new QCircleFolderBean();
      ((QCircleFolderBean)localObject1).setEnableSplash(false);
      QCircleLauncher.a(paramBasePartFragment.getActivity(), (QCircleFolderBean)localObject1);
    }
    paramBasePartFragment.getActivity().finish();
    paramBasePartFragment.getActivity().overridePendingTransition(2130771994, 2130771995);
    new Handler(Looper.getMainLooper()).postDelayed(new QCirclePublishViewModel.2(this), 100L);
  }
  
  public void a(BasePartFragment paramBasePartFragment, int paramInt)
  {
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, "saveShuoshuo...");
    ShuoshuoContent localShuoshuoContent = new ShuoshuoContent();
    Object localObject = this.h;
    if (localObject != null) {
      localShuoshuoContent.a((String)localObject);
    }
    localObject = this.f;
    if ((localObject != null) && (((DynamicArrayList)localObject).size() > 0)) {
      localShuoshuoContent.a(new ArrayList(this.f));
    }
    localShuoshuoContent.a(this.g);
    localShuoshuoContent.a(((QCircleShareViewModel)paramBasePartFragment.a(QCircleShareViewModel.class)).b);
    long l1 = LoginData.a().b();
    LocalConfig.a(localShuoshuoContent, l1, "_qq_circle_publish");
    LocalConfig.a(this.v, this.K, "_qq_circle_publish", l1);
    QCircleHostQzoneHelper.putInt4Uin("_qq_circle_publish", 1, l1);
    QCircleHostQzoneHelper.putInt4Uin("_qq_circle_publish_draft_from", paramInt, l1);
    LocalConfig.a("_qq_circle_has_select_cover", this.I, l1);
  }
  
  public void a(BasePartFragment paramBasePartFragment, Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent == null)
    {
      QLog.e("[QcirclePublish]QCirclePublishViewModel", 1, new Object[] { Integer.valueOf(1), "initData... intent == null" });
      return;
    }
    this.M = paramIntent;
    QCircleHostAEHelper.initAEEditorManagerForQzone();
    QCircleHostAEHelper.addListener(this);
    QCircleHostAEHelper.addUICallbackListener(this);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("AEEDITOR_UPDATE_AI_TEXT");
    QCircleApplication.APP.registerReceiver(this.N, (IntentFilter)localObject);
    this.o = LoginData.a().b();
    this.F = ((HashMap)paramIntent.getSerializableExtra("key_attrs"));
    this.h = paramIntent.getStringExtra(QCircleHostQzoneHelper.QZONE_SHARE_SUMMERY());
    int i1;
    if (TextUtils.isEmpty(this.h)) {
      i1 = 0;
    } else {
      i1 = this.h.length();
    }
    this.h = b(this.h, this.F);
    if (!TextUtils.isEmpty(this.h)) {
      this.d.postValue(new QCirclePublishContentPart.ContentSet(this.h, i1));
    }
    this.H = paramIntent.getStringArrayListExtra(QCircleHostQzoneHelper.QZONE_SHARE_IMAGES());
    if ((this.H == null) && (!paramBoolean)) {
      a(paramIntent);
    }
    localObject = this.H;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (!this.f.contains(str)) {
          a(str);
        }
      }
      this.a.postValue(this.f);
      k();
    }
    this.p = paramIntent.getIntExtra(QCircleHostConstants.QZoneAppConstants.KEY_UPLOAD_ENTRANCE(), 23);
    this.q = true;
    this.r = true;
    this.l = paramIntent.getIntExtra("fromType", 1);
    this.m = paramIntent.getIntExtra(QCircleHostConstants._AEEditorConstants.VIDEO_PHOTO_FROM(), 2);
    this.G = paramIntent.getBooleanExtra("key_qcircle_publish_finish_jump_to_mainpage", false);
    this.t = paramIntent.getBooleanExtra("key_need_use_draft", false);
    if (!this.t) {
      this.t = paramIntent.getBooleanExtra("key_qcircle_pulish_use_draft", false);
    }
    if (QCircleHostQzoneHelper.getInt4Uin("_qq_circle_publish", 0, this.o) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.K = paramIntent.getBooleanExtra("bundle_key_allow_long_video", false);
    this.v = paramIntent.getIntExtra("bundle_key_max_limit_video", u);
    this.w = paramIntent.getStringExtra(QCircleConstants.w);
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, new Object[] { "initData... mQcircleFromType:", Integer.valueOf(this.l), " mQcircleUpType:", Integer.valueOf(this.m) });
    String str = QCirclePublishQualityReporter.E_PUBLIC_ENTER;
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.w);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ext1", String.valueOf(this.l));
    if (i1 != 0) {
      localObject = "hasdraft";
    } else {
      localObject = "nodraft";
    }
    QCirclePublishQualityReporter.report(str, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleReportHelper.newEntry("ext2", (String)localObject), QCircleReportHelper.newEntry("ret_code", "0") }));
    if ((this.t) && (i1 != 0))
    {
      b(paramBasePartFragment);
      return;
    }
    this.k = paramIntent.getStringExtra(QCircleHostConstants._AEEditorConstants.KEY_AE_EDITOR_FROM_PHOTO_PICKER_TAB());
  }
  
  public void a(LbsDataV2.PoiInfo paramPoiInfo)
  {
    this.y = paramPoiInfo;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.h = paramString;
    this.j = paramBoolean;
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    DynamicArrayList localDynamicArrayList = this.f;
    if (localDynamicArrayList != null)
    {
      if (localDynamicArrayList.contains(paramString)) {
        return false;
      }
      if (this.f.size() >= b())
      {
        paramString = String.format(HardCodeUtil.a(2131891843), new Object[] { Integer.valueOf(b()) });
        QCircleToast.a(QCircleToast.b, paramString, 0);
        return false;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.f.add(paramString);
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    return 9;
  }
  
  public void b(Context paramContext)
  {
    String str = (String)this.f.get(0);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_photo_previewer_list", this.f);
    localIntent.putExtra("key_photo_previewer_cur_position", 0);
    localIntent.putExtra("key_photo_previewer_is_video", AlbumUtil.b((LocalMediaInfo)this.g.get(str)));
    localIntent.putExtra("key_photo_previewer_video_cover_width", ((LocalMediaInfo)this.g.get(str)).mediaWidth);
    localIntent.putExtra("key_photo_previewer_video_cover_height", ((LocalMediaInfo)this.g.get(str)).mediaHeight);
    QCircleLauncher.a(paramContext, localIntent);
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = paramIntent.getParcelableArrayListExtra("publish_pic_preview_result_data_key");
    if (paramIntent == null) {
      return;
    }
    this.f.clear();
    this.g.clear();
    this.i.clear();
    paramIntent = paramIntent.iterator();
    while (paramIntent.hasNext())
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramIntent.next();
      if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)))
      {
        this.f.add(localLocalMediaInfo.path);
        this.g.put(localLocalMediaInfo.path, localLocalMediaInfo);
      }
    }
    n();
    this.a.postValue(this.f);
    this.b.postValue(this.g);
    k();
  }
  
  public void b(BasePartFragment paramBasePartFragment)
  {
    boolean bool = true;
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, "recoverDraft...");
    Object localObject = LocalConfig.b("_qq_circle_publish", this.o);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.h = ((String)localObject);
      localObject = this.d;
      String str = this.h;
      ((MutableLiveData)localObject).postValue(new QCirclePublishContentPart.ContentSet(str, str.length()));
    }
    localObject = (ArrayList)LocalConfig.c("_qq_circle_publish", this.o);
    if (localObject != null)
    {
      this.f.addAll((Collection)localObject);
      this.a.postValue(this.f);
      k();
    }
    localObject = LocalConfig.d("_qq_circle_publish", this.o);
    if ((localObject != null) && (((Map)localObject).size() > 0))
    {
      this.g = ((HashMap)localObject);
      this.b.postValue(this.g);
    }
    int i1 = LocalConfig.a("_qq_circle_publish", this.o);
    localObject = (QCircleShareViewModel)paramBasePartFragment.a(QCircleShareViewModel.class);
    if ((i1 & 0x1) == 0) {
      bool = false;
    }
    ((QCircleShareViewModel)localObject).b = bool;
    ((QCircleShareViewModel)paramBasePartFragment.a(QCircleShareViewModel.class)).a.postValue(Boolean.valueOf(((QCircleShareViewModel)paramBasePartFragment.a(QCircleShareViewModel.class)).b));
    this.K = LocalConfig.a("_qq_circle_publish", this.o, false);
    this.v = LocalConfig.b("_qq_circle_publish", this.o, u);
    this.I = LocalConfig.b("_qq_circle_has_select_cover", false, this.o);
  }
  
  public void b(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public boolean b(String paramString)
  {
    HashMap localHashMap = this.g;
    if (localHashMap == null) {
      return false;
    }
    return a(paramString, localHashMap);
  }
  
  public void c()
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((LocalMediaInfo)((Map.Entry)((Iterator)localObject).next()).getValue()).aiTextLabel = null;
    }
  }
  
  public void c(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_MEDIA_PATH());
    String str1 = paramIntent.getStringExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_COVER_PATH());
    float f1 = paramIntent.getFloatExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_COVER_POSITION(), 0.5F);
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (this.g.get(str2) != null))
    {
      paramIntent = (LocalMediaInfo)this.g.get(str2);
      paramIntent.thumbnailPath = str1;
      paramIntent.thumbnailProgress = f1;
      this.I = true;
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult... 封面选择成功: progress = ");
      paramIntent.append(f1);
      paramIntent.append(" | path = ");
      paramIntent.append(str1);
      QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, paramIntent.toString());
      this.b.postValue(this.g);
    }
  }
  
  protected void d()
  {
    QLog.e("[QcirclePublish]QCirclePublishViewModel", 1, new Object[] { Integer.valueOf(1), "handleEditVideoTimeOut: 圈子视频合成超时 missionId:", this.C.a });
    QCircleHostAEHelper.cancelMission(this.C.a);
    QCircleMapReporter.getInstance().reportEnd(QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST, this.C.a, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.w), QCircleReportHelper.newEntry("ext6", String.valueOf(this.J)), QCircleReportHelper.newEntry("attach_info", "Peak"), QCircleReportHelper.newEntry("ret_code", "-80000007") }));
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.w), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext6", String.valueOf(this.J)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
    RFThreadManager.getUIHandler().post(new QCirclePublishViewModel.1(this));
  }
  
  public void deleteMedia(int paramInt)
  {
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, new Object[] { "deleteMedia... position:", Integer.valueOf(paramInt) });
    HostUIHelper.closeHostEnvironment();
    a(paramInt);
  }
  
  public boolean e()
  {
    Object localObject = this.h;
    if ((localObject != null) && (!TextUtils.isEmpty(((String)localObject).trim()))) {
      return true;
    }
    localObject = this.f;
    return (localObject != null) && (!((ArrayList)localObject).isEmpty());
  }
  
  public boolean f()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return false;
      }
      localObject = (String)((ArrayList)localObject).get(0);
      if (localObject != null)
      {
        HashMap localHashMap = this.g;
        if (localHashMap == null) {
          return false;
        }
        localObject = (LocalMediaInfo)localHashMap.get(localObject);
        if (localObject != null)
        {
          if (!HostStaticInvokeHelper.validateVideoType(((LocalMediaInfo)localObject).mMimeType)) {
            return false;
          }
          return ((LocalMediaInfo)localObject).isVideoReady ^ true;
        }
      }
    }
    return false;
  }
  
  public String g()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return null;
      }
      localObject = (String)((ArrayList)localObject).get(0);
      if (localObject != null)
      {
        HashMap localHashMap = this.g;
        if (localHashMap == null) {
          return null;
        }
        localObject = (LocalMediaInfo)localHashMap.get(localObject);
        if (localObject != null)
        {
          if (!HostStaticInvokeHelper.validateVideoType(((LocalMediaInfo)localObject).mMimeType)) {
            return null;
          }
          return ((LocalMediaInfo)localObject).missionID;
        }
      }
    }
    return null;
  }
  
  public void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearDraft... mIsNeedUseDraft:");
    localStringBuilder.append(this.t);
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, localStringBuilder.toString());
    LocalConfig.a(this.o, "_qq_circle_publish");
    LocalMultiProcConfig.putInt4Uin("_qq_circle_publish", 0, this.o);
    QCircleHostQzoneHelper.putInt4Uin("_qq_circle_publish", 0, this.o);
  }
  
  public void i()
  {
    HostUIHelper.openHostEnvironment(new QCirclePublishViewModel.3(this));
    QCirclePublishReport.a(15, 18, 2, "", "");
  }
  
  public boolean j()
  {
    Object localObject1 = this.f.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (LocalMediaInfo)this.g.get(localObject2);
      if ((AlbumUtil.c((LocalMediaInfo)localObject2)) && (!new File(((LocalMediaInfo)localObject2).path).exists()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isPicsExist... path not exists... path:");
        ((StringBuilder)localObject1).append(((LocalMediaInfo)localObject2).path);
        QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
    }
    return true;
  }
  
  public void k()
  {
    boolean bool = this.j;
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool)
    {
      this.e.postValue(localBoolean);
      return;
    }
    DynamicArrayList localDynamicArrayList = this.f;
    if ((localDynamicArrayList != null) && (!localDynamicArrayList.isEmpty()))
    {
      this.e.postValue(Boolean.valueOf(true));
      return;
    }
    this.e.postValue(localBoolean);
  }
  
  public boolean l()
  {
    return this.L;
  }
  
  public void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, new Object[] { "onAETavSessionExportCompleted... missionID:", paramString });
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
    this.J = 0;
    if ((paramLocalMediaInfo != null) && (!TextUtils.isEmpty(paramLocalMediaInfo.path)))
    {
      Object localObject = this.g;
      if (localObject != null)
      {
        localObject = (LocalMediaInfo)((HashMap)localObject).get(paramLocalMediaInfo.path);
        if (localObject != null)
        {
          QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, new Object[] { "onAETavSessionExportCompleted... oldMedia thumbnailPath:", ((LocalMediaInfo)localObject).thumbnailPath, " oldMedia.thumbnailProgress:", Float.valueOf(((LocalMediaInfo)localObject).thumbnailProgress) });
          paramLocalMediaInfo.thumbnailPath = ((LocalMediaInfo)localObject).thumbnailPath;
          paramLocalMediaInfo.thumbnailProgress = ((LocalMediaInfo)localObject).thumbnailProgress;
          this.g.put(paramLocalMediaInfo.path, paramLocalMediaInfo);
          this.b.postValue(this.g);
        }
        QCircleMapReporter.getInstance().reportEnd(QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST, paramString, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.w), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext6", String.valueOf(this.J)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
        paramString = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
        localObject = QCircleReportHelper.newEntry("traceid", this.w);
        FeedCloudCommon.Entry localEntry = QCircleReportHelper.newEntry("ret_code", "0");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLocalMediaInfo.mediaWidth);
        localStringBuilder.append("x");
        localStringBuilder.append(paramLocalMediaInfo.mediaHeight);
        QCirclePublishQualityReporter.report(paramString, Arrays.asList(new FeedCloudCommon.Entry[] { localObject, localEntry, QCircleReportHelper.newEntry("ext1", localStringBuilder.toString()), QCircleReportHelper.newEntry("ext2", String.valueOf(paramLocalMediaInfo.mediaBitrate)), QCircleReportHelper.newEntry("ext3", String.valueOf(paramLocalMediaInfo.fileSize)), QCircleReportHelper.newEntry("ext4", String.valueOf(paramLocalMediaInfo.mDuration / 1000L)), QCircleReportHelper.newEntry("ext5", paramLocalMediaInfo.path), QCircleReportHelper.newEntry("ext6", String.valueOf(this.J)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
      }
    }
  }
  
  public void onAETavSessionExportError(String paramString1, int paramInt, String paramString2)
  {
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, new Object[] { "onAETavSessionExportError... missionID:", paramString1, " errorCode=", Integer.valueOf(paramInt) });
    if (paramInt != QCircleHostConstants._AEEditorConstants.GENERATE_ERROR_NODATA())
    {
      int i1 = this.J;
      if (i1 < 2)
      {
        this.J = (i1 + 1);
        QCircleHostAEHelper.retryMission(paramString1);
        RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
        paramInt = QCircleConfigHelper.a("qqcircle", "QcircleEditVideoTimeout", Integer.valueOf(60000)).intValue();
        RFThreadManager.getSerialThreadHandler().postDelayed(this.C, paramInt);
        return;
      }
    }
    QCircleMapReporter.getInstance().reportEnd(QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST, paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.w), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt)), QCircleReportHelper.newEntry("ext6", String.valueOf(this.J)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.w), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt)), QCircleReportHelper.newEntry("desc", paramString2), QCircleReportHelper.newEntry("ext6", String.valueOf(this.J)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, new Object[] { "onAETavSessionExporting... missionID:", paramString, " progress:", Float.valueOf(paramFloat) });
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
    int i1 = QCircleConfigHelper.a("qqcircle", "QcircleEditVideoTimeout", Integer.valueOf(60000)).intValue();
    RFThreadManager.getSerialThreadHandler().postDelayed(this.C, i1);
  }
  
  public void onCleared()
  {
    super.onCleared();
    QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, "onCleared...");
    if (this.N != null) {
      try
      {
        QCircleApplication.APP.unregisterReceiver(this.N);
        this.N = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[QcirclePublish]QCirclePublishViewModel", 1, "onCleared...", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel
 * JD-Core Version:    0.7.0.1
 */