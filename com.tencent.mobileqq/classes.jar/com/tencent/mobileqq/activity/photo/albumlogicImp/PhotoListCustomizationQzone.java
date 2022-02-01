package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.aelight.camera.qqstory.api.IEditPicForQzone;
import com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.aelight.camera.struct.editor.FlowComponentInterface;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowActionListener;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.Holder;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqslideshow.ISlideShowController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.widget.PhotoGridView;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.XMPCoreUtil;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PhotoListCustomizationQzone
  extends PhotoListCustomizationDefault
  implements SlideShowActionListener
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone";
  public static boolean n = false;
  public static boolean p = false;
  private LinkedHashMap<String, LocalMediaInfo> A;
  private boolean B = false;
  private boolean C;
  private boolean D;
  private boolean E = false;
  private String F = "";
  private boolean G = false;
  private String H;
  private int I;
  public String i = "";
  boolean j = false;
  boolean k = false;
  boolean l = false;
  boolean m = false;
  protected boolean o;
  int q = 0;
  boolean r = false;
  HashMap<String, Integer> s;
  boolean t = false;
  long u;
  int v;
  boolean w;
  boolean x;
  private boolean y = false;
  private boolean z = false;
  
  PhotoListCustomizationQzone(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  private void A()
  {
    if (this.h.l != null)
    {
      if (this.A == null) {
        return;
      }
      Object localObject = b(this.h.m.findFirstVisibleItemPosition(), this.h.m.findLastVisibleItemPosition());
      if ((localObject != null) && (this.A != null))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
          if (!this.A.containsKey(localLocalMediaInfo.path)) {
            this.A.put(localLocalMediaInfo.path, localLocalMediaInfo);
          }
        }
      }
      this.E = true;
    }
  }
  
  private boolean B()
  {
    IModule localIModule = AVBizModuleFactory.getModuleByName("默认相机");
    return (localIModule != null) && (!"true".equals(localIModule.checkAVFocus()));
  }
  
  private void C()
  {
    if (B())
    {
      QZLog.e("QQAlbum", 2, new Object[] { "audio video invalid." });
      QQToast.makeText(this.c, 0, 2131916633, 0).show();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
    localBundle.putInt("edit_video_type", 10001);
    localBundle.putInt("entrance_type", 122);
    localBundle.putInt("extra.busi_type", 3);
    localBundle.putInt("edit_video_way", 12);
    localBundle.putInt("key_camera_photo_edit_type", 1);
    localBundle.putInt("key_camera_video_edit_type", 5);
    localBundle.putBoolean("extra_directly_back", true);
    localBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localBundle.putBoolean("DirectBackToQzone", true);
    localBundle.putString("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewPhotoListActivity.class.getName());
    localBundle.putBoolean("enable_edit_video", true);
    localBundle.putBoolean("enable_input_text", false);
    localBundle.putBoolean("enable_priv_list", false);
    localBundle.putInt("entry_source", 5);
    localBundle.putBoolean("support_record", true);
    localBundle.putBoolean("enable_local_video", false);
    localBundle.putBoolean("enable_local_button", false);
    localBundle.putBoolean("go_publish_activity", false);
    localBundle.putBoolean("enterPtu", false);
    localBundle.putInt("p_e_s_type", 1);
    QZoneHelper.forwardToQzoneVideoCaptureNew(this.c, localBundle, 10001);
  }
  
  private boolean D()
  {
    return (this.k) || (this.j) || (this.l) || (this.D) || (this.B);
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 5)
            {
              localHashMap.put("result_photo", "1");
              QLog.i("QQAlbum", 2, "result_photo");
            }
          }
          else
          {
            localHashMap.put("result_video", "1");
            QLog.i("QQAlbum", 2, "result_video");
          }
        }
        else
        {
          localHashMap.put("click_pass", "1");
          QLog.i("QQAlbum", 2, "click_pass");
        }
      }
      else
      {
        localHashMap.put("click_fail", "1");
        QLog.i("QQAlbum", 2, "click_fail");
      }
    }
    else if (!this.y)
    {
      this.y = true;
      localHashMap.put("exposure", "1");
      QLog.i("QQAlbum", 2, "exposure");
    }
    if (localHashMap.size() > 0)
    {
      QLog.i("QQAlbum", 2, "begin report");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qzoneChoosePhotoCamera", true, 0L, 0L, localHashMap, null, true);
      return;
    }
    QLog.i("QQAlbum", 2, "no param");
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    Intent localIntent = this.c.getIntent();
    localIntent.putExtra("ALBUM_NAME", this.e.albumName);
    localIntent.putExtra("ALBUM_ID", this.e.albumId);
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    int i1 = localLocalMediaInfo.position.intValue();
    paramInt = i1;
    if (!n)
    {
      paramInt = i1;
      if (AlbumUtil.getMediaType(localLocalMediaInfo) == 1)
      {
        if (this.e.mediaPathsList != null) {
          this.e.mediaPathsList.clear();
        } else {
          this.e.mediaPathsList = new ArrayList();
        }
        this.e.mediaPathsList.add(localLocalMediaInfo.path);
        if (this.e.selectedPhotoList != null) {
          this.e.selectedPhotoList.clear();
        } else {
          this.e.selectedPhotoList = new ArrayList();
        }
        this.e.selectedPhotoList.add(localLocalMediaInfo.path);
        if (this.e.selectedIndex != null) {
          this.e.selectedIndex.clear();
        } else {
          this.e.selectedIndex = new ArrayList();
        }
        this.e.selectedIndex.add(Integer.valueOf(0));
        if (this.e.selectedMediaInfoHashMap != null) {
          this.e.selectedMediaInfoHashMap.clear();
        } else {
          this.e.selectedMediaInfoHashMap = new HashMap();
        }
        this.e.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        paramInt = 0;
      }
    }
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.e.selectedIndex);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.f).d);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.b.f);
    localIntent.putExtra("PasterConstants.paster_id", this.b.h);
    localIntent.putExtra("PasterConstants.paster_cate_id", this.b.i);
    PhotoListData.w = this.h.m.findFirstVisibleItemPosition();
    if (!this.e.selectedMediaInfoHashMap.containsKey(localLocalMediaInfo.path)) {
      this.e.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.e.selectedMediaInfoHashMap);
    localIntent.putExtra("PasterConstants.pasters_data", this.b.g);
    localIntent.setClass(this.c, NewPhotoPreviewActivity.class);
    boolean bool = this.k;
    if (bool) {
      paramIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", bool);
    }
    localIntent.putExtra("from_qzone", this.B);
    localIntent.addFlags(603979776);
    if ((this.e.selectedPhotoList != null) && (this.e.selectedPhotoList.size() > 0)) {
      ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.f).e, "0X8005674", "0X8005674", 0, this.e.selectedPhotoList.size(), 0, "", "", "", "");
    }
    if (this.C)
    {
      this.c.startActivityForResult(paramIntent, 10010);
    }
    else
    {
      this.c.startActivity(localIntent);
      this.c.finish();
    }
    AlbumUtil.anim(this.c, true, true);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent)
  {
    paramIntent.putExtra("file_send_path", paramLocalMediaInfo.path);
    paramIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    paramIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLocalMediaInfo.fileSize);
    paramIntent.putExtra("file_send_duration", paramLocalMediaInfo.mDuration);
    paramIntent.putExtra("file_width", paramLocalMediaInfo.mediaWidth);
    paramIntent.putExtra("file_height", paramLocalMediaInfo.mediaHeight);
    paramIntent.putExtra("media_info", paramLocalMediaInfo);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLocalMediaInfo.path);
    PhotoUtils.sendPhoto(this.c, paramIntent, localArrayList, 2, false);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, FlowComponentInterface paramFlowComponentInterface, String paramString5, int paramInt4, ArrayList<String> paramArrayList, int paramInt5, int paramInt6, String paramString6, int paramInt7, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("QQAlbum", 1, "videoFilePath is empty.");
      return;
    }
    paramString1 = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      ((IPtvFilterUtil)QRoute.api(IPtvFilterUtil.class)).createFakeVidConfigFile(paramString1, paramString4);
    }
    VideoSendPublicParamBase localVideoSendPublicParamBase = new VideoSendPublicParamBase();
    localVideoSendPublicParamBase.mContext = this.c;
    localVideoSendPublicParamBase.mVideoCacheDir = paramString1;
    localVideoSendPublicParamBase.mEncodeMode = paramInt1;
    localVideoSendPublicParamBase.mVideoFilePath = paramString2;
    localVideoSendPublicParamBase.mThumbFilePath = paramString3;
    localVideoSendPublicParamBase.mThumbWidth = 0;
    localVideoSendPublicParamBase.mThumbHeight = 0;
    localVideoSendPublicParamBase.fakeVid = paramString4;
    localVideoSendPublicParamBase.recordTime = paramInt2;
    localVideoSendPublicParamBase.mUserCallBack = paramFlowComponentInterface;
    localVideoSendPublicParamBase.mContent = paramString5;
    localVideoSendPublicParamBase.mPriv = paramInt4;
    localVideoSendPublicParamBase.mPrivUinList = paramArrayList;
    localVideoSendPublicParamBase.mEnableEditVideo = true;
    localVideoSendPublicParamBase.topicSyncQzone = false;
    localVideoSendPublicParamBase.fontId = paramInt5;
    localVideoSendPublicParamBase.fontFormatType = paramInt6;
    localVideoSendPublicParamBase.fontUrl = paramString6;
    localVideoSendPublicParamBase.superFontId = paramInt7;
    localVideoSendPublicParamBase.superFontInfo = paramString7;
    localVideoSendPublicParamBase.generateGif = paramBoolean1;
    localVideoSendPublicParamBase.timerDelete = paramBoolean2;
    localVideoSendPublicParamBase.isUploadOrigin = paramBoolean3;
    localVideoSendPublicParamBase.entrySource = 5;
    localVideoSendPublicParamBase.mUin = "";
    localVideoSendPublicParamBase.mUinType = 0;
    localVideoSendPublicParamBase.mTroopUin = "";
    ((IMediaCodecSendTask)QRoute.api(IMediaCodecSendTask.class)).execute(localVideoSendPublicParamBase);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent, String paramString)
  {
    boolean bool3 = this.o;
    boolean bool2 = true;
    boolean bool1 = true;
    if (bool3)
    {
      if ("qzone_plugin.apk".equals(paramString))
      {
        paramString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if ((paramString != null) && (!paramString.contains("TrimVideoActivity")))
        {
          if ((this.e.selectedPhotoList != null) && (this.e.selectedPhotoList.size() > 0))
          {
            QQToast.makeText(this.c, "不能同时选择照片和视频", 0).show();
            this.b.c = false;
            return true;
          }
          if (paramLocalMediaInfo.mDuration < this.e.filter.videoMaxDuration)
          {
            this.b.c = true;
            return false;
          }
          this.b.c = false;
          paramLocalMediaInfo = new StringBuilder();
          long l1 = this.e.filter.videoMaxDuration / 1000L;
          if (l1 > 60L)
          {
            l1 /= 60L;
            if (l1 > 60L)
            {
              paramLocalMediaInfo.append(l1 / 60L);
              paramLocalMediaInfo.append("小时");
            }
            else
            {
              paramLocalMediaInfo.append(l1);
              paramLocalMediaInfo.append("分钟");
            }
          }
          else
          {
            paramLocalMediaInfo.append(l1);
            paramLocalMediaInfo.append("秒");
          }
          paramLocalMediaInfo.append("以上的视频不可选");
          QQToast.makeText(this.c, paramLocalMediaInfo.toString(), 0).show();
          return true;
        }
        if (this.C)
        {
          this.b.c = true;
          return false;
        }
        paramString = this.b;
        if (paramLocalMediaInfo.mDuration <= this.e.filter.videoMaxDuration) {
          bool1 = false;
        }
        paramString.c = bool1;
        paramIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.b.c);
        return false;
      }
    }
    else if ("qzone_plugin.apk".equals(paramString))
    {
      paramString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if ((paramString != null) && (!paramString.contains("TrimVideoActivity")))
      {
        if ((!this.w) && (paramLocalMediaInfo.mDuration <= this.e.filter.videoMaxDuration) && (!this.j) && ((!this.k) || (!n)))
        {
          this.b.c = false;
          paramIntent.putExtra("support_record", false);
          paramIntent.putExtra("support_trim", true);
          paramIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
          paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
          paramIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.b.f);
          return false;
        }
        this.b.c = true;
        return false;
      }
      if (this.C)
      {
        this.b.c = true;
        return false;
      }
      paramString = this.b;
      if (paramLocalMediaInfo.mDuration > this.e.filter.videoMaxDuration) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramString.c = bool1;
      paramIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.b.c);
    }
    return false;
  }
  
  private List<LocalMediaInfo> b(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2) && (paramInt1 <= paramInt2)) {
        try
        {
          if (paramInt1 < this.h.t.getItemCount())
          {
            LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt1);
            if (localLocalMediaInfo.mMimeType.equals("image/jpeg")) {
              localArrayList.add(localLocalMediaInfo);
            }
          }
          paramInt1 += 1;
        }
        catch (Exception localException)
        {
          QLog.e("QQAlbum", 2, "getExposedMedia error!", localException);
        }
      }
    }
    return localArrayList;
  }
  
  private void b(int paramInt)
  {
    if (TextUtils.isEmpty(this.F)) {
      return;
    }
    int i4 = this.e.selectedPhotoList.size();
    int i1 = 2;
    int i3;
    int i2;
    if (i4 == 0)
    {
      i3 = 601;
      i2 = 0;
    }
    else
    {
      i3 = 600;
      if (i4 == 1) {
        i2 = 1;
      } else {
        i2 = 2;
      }
    }
    switch (paramInt)
    {
    default: 
      return;
    case 2131445580: 
      i1 = 1;
      break;
    case 2131440614: 
      i1 = 4;
      break;
    case 2131437877: 
      i1 = 5;
      break;
    case 2131436180: 
      i1 = 3;
    }
    if ((this.q == 1) && (paramInt == 2131445580))
    {
      LpReportInfo_pf00064.allReport(586, 47, 3, String.valueOf(i4));
      return;
    }
    LpReportInfo_pf00064.allReport(i3, i2, i1);
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent)
  {
    Intent localIntent = new Intent(this.c, ShortVideoPreviewActivity.class);
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("file_send_path", paramLocalMediaInfo.path);
    localIntent.putExtra("file_send_size", paramLocalMediaInfo.fileSize);
    localIntent.putExtra("file_send_duration", paramLocalMediaInfo.mDuration);
    localIntent.putExtra("file_width", paramLocalMediaInfo.mediaWidth);
    localIntent.putExtra("file_height", paramLocalMediaInfo.mediaHeight);
    localIntent.putExtra("uin", this.b.o);
    localIntent.putExtra("uintype", this.b.m);
    localIntent.putExtra("file_source", "album");
    localIntent.putExtra("is_from_system_media", paramLocalMediaInfo.isSystemMeidaStore);
    if (this.b.B)
    {
      localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", this.e.selectedPhotoList);
    }
    if (((this.j) || ((this.k) && (n) && (!p))) && (this.b.B)) {
      localIntent.putExtra("preview_only", true);
    }
    this.c.startActivityForResult(localIntent, 17);
  }
  
  private boolean c(String paramString)
  {
    return "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(paramString);
  }
  
  private void d(List<LocalMediaInfo> paramList)
  {
    QZLog.i("QQAlbum", "loadPanoramaPhotoList");
    ThreadManagerV2.excute(new PhotoListCustomizationQzone.2(this, paramList), 16, null, false);
  }
  
  private boolean d(String paramString)
  {
    return ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(paramString)) || ("com.tencent.qcircle.QCirclePublishFeedActivity".equals(paramString));
  }
  
  private boolean e(String paramString)
  {
    return "com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity".equals(paramString);
  }
  
  private boolean f(String paramString)
  {
    return ("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) || ("com.qzone.common.activities.FeedActionPanelActivity".equals(paramString)) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(paramString)) || (this.r) || (this.m);
  }
  
  private ArrayList<String> g(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = paramString.split(";");
      if ((paramString == null) || (paramString.length <= 0)) {
        break label57;
      }
      int i1 = 0;
      while (i1 < paramString.length)
      {
        localArrayList.add(paramString[i1]);
        i1 += 1;
      }
    }
    catch (NullPointerException paramString)
    {
      label48:
      label57:
      break label48;
    }
    QLog.e("QQAlbum", 2, "parseBlockPaths error!");
    return localArrayList;
  }
  
  private void g(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (((paramIntent == null) || (paramIntent.isEmpty())) && (this.e != null) && (this.e.selectedPhotoList != null)) {
      this.e.selectedPhotoList.clear();
    }
    if ((this.G) && (!TextUtils.isEmpty(this.H)))
    {
      this.b.G = false;
      b(this.H);
    }
  }
  
  private void h(Intent paramIntent)
  {
    this.i = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    boolean bool = false;
    this.w = paramIntent.getBooleanExtra("PhotoConst.IS_TRIM_VIDEO_BLACK_LIST", false);
    this.r = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", false);
    this.x = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_P2V", false);
    this.z = paramIntent.getBooleanExtra("NEED_QZONE_MACHINE_LEARNING_REPORT", false);
    n = paramIntent.getBooleanExtra("QZONE_SUPPORT_MIX_MOOD", false);
    this.o = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    p = paramIntent.getBooleanExtra("upload_single_video", false);
    this.q = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.I = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", -1);
    this.s = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.t = paramIntent.getBooleanExtra("PhotoConst.IS_NO_PANORAMA", false);
    this.u = paramIntent.getLongExtra("PhotoConst.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    this.D = paramIntent.getBooleanExtra("from_qzoneshare", false);
    this.F = paramIntent.getStringExtra("report_from");
    if (paramIntent.getIntExtra("p_e_s_type", 0) != 0) {
      bool = true;
    }
    this.G = bool;
    this.H = paramIntent.getStringExtra("PhotoConst.QZONE_SINGLE_PHOTO_PATH_EDITED");
  }
  
  private void h(LocalMediaInfo paramLocalMediaInfo)
  {
    QZLog.i("QQAlbum", "loadPanoramaPhoto");
    XMPCoreUtil.getInstance().loadXMPCoreJarModule(new PhotoListCustomizationQzone.3(this, paramLocalMediaInfo));
  }
  
  private void i(Intent paramIntent)
  {
    if (paramIntent != null) {
      try
      {
        if (this.A == null) {
          return;
        }
        paramIntent = paramIntent.getSerializableExtra("qzone_album_machine_learning_exposed_media_list");
        if (paramIntent != null)
        {
          paramIntent = ((List)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramIntent.next();
            this.A.put(localLocalMediaInfo.path, localLocalMediaInfo);
          }
        }
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("QQAlbum", 2, "restoreUnSelectedExposedData error!", paramIntent);
      }
    }
  }
  
  private void j(Intent paramIntent)
  {
    if (this.e.selectedMediaInfoHashMap != null)
    {
      if (this.A == null) {
        return;
      }
      try
      {
        if ((!this.E) && (this.h.t != null) && (this.h.t.getItemCount() > 0)) {
          A();
        }
        int i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MachineLearningExposedMediaUpperBound", 50) - this.e.selectedMediaInfoHashMap.size();
        if (i2 > 0)
        {
          int i1 = 0;
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = this.A.entrySet().iterator();
          while ((localIterator.hasNext()) && (i1 < i2))
          {
            LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Map.Entry)localIterator.next()).getValue();
            if (!this.e.selectedMediaInfoHashMap.containsKey(localLocalMediaInfo.path))
            {
              localArrayList.add(localLocalMediaInfo);
              i1 += 1;
            }
          }
          paramIntent.putExtra("qzone_album_machine_learning_exposed_media_list", (Serializable)localArrayList);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("QQAlbum", 2, "prepareExposedMediaInfo error!", paramIntent);
      }
    }
  }
  
  private void k(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject2 = paramIntent.getStringExtra("key_content");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      int i2 = paramIntent.getIntExtra("key_priv", 1);
      Object localObject3 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new ArrayList();
      }
      int i3 = paramIntent.getIntExtra("key_font_id", -1);
      int i4 = paramIntent.getIntExtra("key_font_format_type", 0);
      localObject3 = paramIntent.getStringExtra("key_font_url");
      int i5 = paramIntent.getIntExtra("key_super_font_id", -1);
      String str = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      if (localPublishParam == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQAlbum", 2, "handleQzoneEditVideoResult: publishParam == null");
        }
        return;
      }
      int i1;
      if (localPublishParam.n <= 5) {
        i1 = localPublishParam.n;
      } else {
        i1 = 0;
      }
      int i6 = paramIntent.getIntExtra("KEY_VIDEO_FRAME_COUNT", 0);
      boolean bool3 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
      a(localPublishParam.u, i1, localPublishParam.t, localPublishParam.c, localPublishParam.b, (int)localPublishParam.j, i6, (FlowComponentInterface)((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).getVideoComponentCallback(), (String)localObject1, i2, (ArrayList)localObject2, i3, i4, (String)localObject3, i5, str, bool1, bool2, bool3);
    }
  }
  
  private void l(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
    String str2 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (("qzone_plugin.apk".equals(str1)) && ("com.qzone.video.activity.TrimVideoActivity".equals(str2)))
    {
      paramIntent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
      paramIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    }
    if ("qzone_plugin.apk".equals(str1)) {
      paramIntent.putExtra("isEmbedInTabActivity", paramIntent.getBooleanExtra("isEmbedInTabActivity", false));
    }
    if ((this.j) || ((this.k) && (n)) || (this.m)) {
      paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.e.selectedMediaInfoHashMap);
    }
    if (this.z) {
      j(paramIntent);
    }
    if (this.e.selectedPhotoList != null) {
      NewFlowCameraReporter.a(this.e.selectedPhotoList);
    }
    paramIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.s);
    if (1 == this.q)
    {
      paramIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
      paramIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    }
    else
    {
      paramIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
    paramIntent.putExtra("key_state_type", this.I);
    a(paramIntent, false, this.e.selectedPhotoList);
  }
  
  private void y()
  {
    Object localObject = this.e.selectedPhotoList.iterator();
    int i2 = 0;
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((this.e.selectedMediaInfoHashMap.containsKey(str)) && (AlbumUtil.getMediaType((LocalMediaInfo)this.e.selectedMediaInfoHashMap.get(str)) == 1))
      {
        ((Iterator)localObject).remove();
        i2 = 1;
      }
      else if ((!this.e.selectedMediaInfoHashMap.containsKey(str)) && (!str.startsWith("http://qzs.qq.com")) && (!str.startsWith("https://qzs.qq.com")) && (str.toLowerCase().endsWith(".gif")))
      {
        ((Iterator)localObject).remove();
        i1 = 1;
      }
    }
    localObject = null;
    if (this.e.selectedPhotoList.size() > this.e.maxSelectNum)
    {
      localObject = this.c.getResources().getString(2131892552, new Object[] { Integer.valueOf(this.e.maxSelectNum) });
      this.e.selectedPhotoList.subList(this.e.maxSelectNum, this.e.selectedPhotoList.size()).clear();
    }
    else if (i2 != 0)
    {
      localObject = this.c.getResources().getString(2131892557);
    }
    else if (i1 != 0)
    {
      localObject = this.c.getResources().getString(2131892556);
    }
    if (localObject != null) {
      QQToast.makeText(this.c, (CharSequence)localObject, 0).show();
    }
  }
  
  private void z()
  {
    Iterator localIterator = this.e.selectedPhotoList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (AlbumUtil.getMediaType((LocalMediaInfo)this.e.selectedMediaInfoHashMap.get(str)) == 1) {
        localIterator.remove();
      }
    }
  }
  
  public Holder a(@NonNull Holder paramHolder, int paramInt)
  {
    if ((this.k) || (this.j)) {
      a(1);
    }
    return super.a(paramHolder, paramInt);
  }
  
  public void a()
  {
    super.a();
    Object localObject1 = this.e.customSendBtnText;
    boolean bool2 = true;
    boolean bool1 = true;
    if (localObject1 != null) {
      localObject1 = this.e.customSendBtnText;
    } else if (1 == this.q) {
      localObject1 = this.c.getString(2131892567);
    } else {
      localObject1 = this.c.getString(2131892542);
    }
    Object localObject2;
    if (1 != this.q)
    {
      if (this.e.selectedPhotoList.size() <= 0) {
        bool1 = false;
      }
      localObject2 = localObject1;
      bool2 = bool1;
      if (bool1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(this.e.selectedPhotoList.size());
        ((StringBuilder)localObject2).append(")");
        localObject2 = ((StringBuilder)localObject2).toString();
        bool2 = bool1;
      }
    }
    else if (this.e.selectedPhotoList.size() >= 3)
    {
      localObject2 = localObject1;
    }
    else
    {
      bool2 = false;
      localObject2 = localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateButton selectedPhotoList.size()=");
      ((StringBuilder)localObject1).append(this.e.selectedPhotoList.size());
      QLog.d("_photo", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.h.o != null)
    {
      this.h.o.setText((CharSequence)localObject2);
      this.h.o.setEnabled(bool2);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.e.selectedPhotoList;
    PhotoListAdapter localPhotoListAdapter = this.h.t;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = this.h.m.findFirstVisibleItemPosition();
      int i1 = this.h.m.findLastVisibleItemPosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i1)
      {
        Object localObject = localPhotoListAdapter.a(paramInt1);
        int i2 = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (i2 >= 0)
        {
          localObject = (Holder)this.h.l.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2).getTag();
          if ((localObject != null) && (((Holder)localObject).f != null)) {
            ((Holder)localObject).f.setCheckedNumber(i2 + 1);
          }
        }
        paramInt1 += 1;
      }
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(localArrayList, this.e.allMediaInfoHashMap);
    }
    this.h.b(true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 24747)) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onClipFinish(paramIntent, this.e.selectedMediaInfoHashMap);
    }
    if ((this.C) && (paramInt2 == -1) && (paramInt1 != 24747))
    {
      this.c.setResult(paramInt2, paramIntent);
      this.c.finish();
      return;
    }
    if (paramInt1 == 10001) {
      if (paramInt2 == -1)
      {
        k(paramIntent);
      }
      else if ((this.C) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
        if (!TextUtils.isEmpty(str)) {
          FileUtils.deleteDirectory(new File(str).getParent());
        }
        this.c.setResult(0, paramIntent);
        this.c.finish();
      }
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    this.C = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    super.a(paramIntent);
    h(paramIntent);
    if (!TextUtils.isEmpty(this.i))
    {
      this.j = c(this.i);
      this.k = d(this.i);
      this.l = e(this.i);
      this.B = f(this.i);
    }
    if (this.x)
    {
      this.m = true;
      this.k = true;
    }
    if (this.z)
    {
      this.A = new LinkedHashMap();
      i(paramIntent);
    }
    if (this.s == null) {
      this.s = new HashMap();
    }
    if (this.l) {
      this.v = paramIntent.getIntExtra("imageSizeLimit", 0);
    }
    if (this.q == 1) {
      y();
    }
    if (this.o) {
      z();
    }
    if ((this.C) && (this.c.getIntent().getIntExtra("qq_sub_business_id", -1) == 3))
    {
      SlideShowPhotoListManager.a().c(22);
      SlideShowPhotoListManager.a().b(14);
      SlideShowPhotoListManager.a().j();
      this.c.getIntent().removeExtra("qq_sub_business_id");
    }
    if (((this.B) && (this.e.albumId.equals("$RecentAlbumId"))) || ((this.r) && (this.t)))
    {
      int i1 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480);
      int i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100);
      String str = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      ArrayList localArrayList = null;
      if (str != null) {
        localArrayList = g(str);
      }
      this.e.filter.imageMinWidth = i2;
      this.e.filter.imageMinHeight = i2;
      this.e.filter.imageMinSize = i1;
      this.e.filter.blockPaths = localArrayList;
      this.e.filter.needHeif = true;
    }
    g(paramIntent);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    paramArrayList = new HashMap();
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.e.selectedPhotoList.size())
    {
      Object localObject = (String)this.e.selectedPhotoList.get(i1);
      if (!ImageManager.isNetworkUrl((String)localObject))
      {
        if (((PhotoOtherData)this.f).a(this.e, (String)localObject) == 1)
        {
          localObject = ((PhotoOtherData)this.f).b(this.e, (String)localObject);
          if (localObject != null)
          {
            SendVideoInfo localSendVideoInfo = new SendVideoInfo();
            localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
            localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
            paramArrayList.put(Integer.valueOf(i2), localSendVideoInfo);
          }
        }
        i2 += 1;
      }
      i1 += 1;
    }
    if (!paramArrayList.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
    }
    if (paramBoolean)
    {
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(this.c, paramIntent, this.e.selectedPhotoList, this.b.b, ((PhotoOtherData)this.f).d, false);
      return;
    }
    PhotoUtils.sendPhoto(this.c, paramIntent, this.e.selectedPhotoList, ((PhotoOtherData)this.f).d, this.b.a);
  }
  
  public void a(Message paramMessage)
  {
    this.b.u.b();
    if ((paramMessage.obj instanceof String))
    {
      paramMessage = (String)paramMessage.obj;
      QZLog.d("QQAlbum", 2, new Object[] { "onEncodeSuccess = ", paramMessage });
      if (this.e.selectedPhotoList == null) {
        this.e.selectedPhotoList = new ArrayList();
      }
      int i1;
      if (this.k) {
        i1 = AlbumUtil.d();
      } else {
        i1 = AlbumUtil.c();
      }
      if (this.e.selectedPhotoList.size() >= this.e.maxSelectNum)
      {
        QQToast.makeText(this.c, String.format(this.c.getResources().getString(2131892559), new Object[] { Integer.valueOf(this.e.maxSelectNum) }), 0).show();
      }
      else if (x() >= i1)
      {
        QQToast.makeText(this.c, String.format(this.c.getResources().getString(2131892564), new Object[] { Integer.valueOf(i1) }), 0).show();
      }
      else
      {
        this.e.selectedPhotoList.add(paramMessage);
        QQAlbumUtils.a(this);
      }
      QQAlbumUtils.a(this.c, paramMessage);
    }
  }
  
  public void a(View paramView)
  {
    b(paramView.getId());
    if (this.h.o != null) {
      this.h.o.setClickable(false);
    }
    if (!this.e.selectedPhotoList.isEmpty()) {
      this.h.a((String)this.e.selectedPhotoList.get(this.e.selectedPhotoList.size() - 1));
    }
    AlbumUtil.a();
    if (this.e.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    Intent localIntent = this.c.getIntent();
    if (localIntent.getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.e.selectedPhotoList.iterator();
      while (paramView.hasNext()) {
        FileUtils.getFileSizes((String)paramView.next());
      }
      if (FileManagerUtil.b())
      {
        FMDialogUtil.a(this.c, 2131889584, 2131889589, new PhotoListCustomizationQzone.5(this));
        return;
      }
    }
    if (this.D)
    {
      String str = localIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      paramView = str;
      if (TextUtils.isEmpty(str)) {
        paramView = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      }
      localIntent.addFlags(603979776);
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, paramView);
      paramView = QZoneHelper.UserInfo.getInstance();
      QZoneHelper.forwardToFriendFeed(this.c, paramView, localIntent, -1, null);
      return;
    }
    c();
  }
  
  public void a(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    if ((this.l) && (localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0) && (this.v > 0) && (localLocalMediaInfo.fileSize > this.v))
    {
      QQToast.makeText(this.c, this.c.getResources().getString(2131892600, new Object[] { Integer.valueOf(this.v / 1048576) }), 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    super.a(paramView, paramInt);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    if ((this.C) && (!((IQQStoryFlowManager)QRoute.api(IQQStoryFlowManager.class)).isValidMedia(this.c, localLocalMediaInfo))) {
      return;
    }
    int i2 = localLocalMediaInfo.selectStatus;
    int i1 = 1;
    if (i2 != 1) {
      i1 = 0;
    }
    if (i1 == 0)
    {
      String[] arrayOfString = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if ((this.b.B) && (arrayOfString != null) && ("video".equals(arrayOfString[0])) && (!AlbumUtil.a(this.c, x(), localLocalMediaInfo, this.k)))
      {
        localLocalMediaInfo.selectStatus = 2;
        return;
      }
    }
    super.a(paramView, paramInt, paramCheckBox);
    if (this.C)
    {
      if (((ISlideShowController)QRoute.api(ISlideShowController.class)).getPhotoList().isEmpty())
      {
        i2 = this.h.m.findFirstVisibleItemPosition();
        paramView = this.h.l.getChildAt(paramInt - i2);
        if ((paramView != null) && (this.h.l.getHeight() - paramView.getY() < this.h.t.i)) {
          this.h.l.smoothScrollBy(ISlideShowController.RECYCLERVIEW_HEIGHT, 500);
        }
      }
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.e.selectedPhotoList, this.e.allMediaInfoHashMap);
    }
    if (i1 == 0)
    {
      MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      this.s.put(localLocalMediaInfo.path, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
      return;
    }
    MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
    this.s.remove(localLocalMediaInfo.path);
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    b(paramView.getId());
    paramView = this.c.getIntent();
    if (this.e.selectedPhotoList.size() > 0)
    {
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.e.selectedPhotoList);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
      paramView.putExtra("p_e_s_type", 7);
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = new HashMap(1);
      if ((this.e.selectedMediaInfoHashMap != null) && (this.e.selectedMediaInfoHashMap.get(this.e.selectedPhotoList.get(0)) != null)) {
        paramView.put("param_localmediainfo", this.e.selectedMediaInfoHashMap.get(this.e.selectedPhotoList.get(0)));
      }
      if (D()) {
        paramView = ((IEditPicForQzone)QRoute.api(IEditPicForQzone.class)).newPictureEditIntentWithoutPublish(this.c, (String)this.e.selectedPhotoList.get(0));
      } else {
        paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.c, (String)this.e.selectedPhotoList.get(0), true, true, true, true, true, 3, 142, 5, paramView);
      }
      this.c.startActivity(paramView);
      if (this.c.magicStickBtn != null) {
        this.c.magicStickBtn.setClickable(false);
      }
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject2 = this.h.t;
    int i1;
    if ((localObject2 != null) && (paramSlideItemInfo != null))
    {
      localObject1 = ((PhotoListAdapter)localObject2).a();
      i1 = 0;
      while (i1 < ((List)localObject1).size())
      {
        if (((LocalMediaInfo)((List)localObject1).get(i1)).path.equals(paramSlideItemInfo.f)) {
          break label71;
        }
        i1 += 1;
      }
      i1 = -1;
      label71:
      if (i1 >= 0)
      {
        localObject1 = ((PhotoListAdapter)localObject2).a(i1);
        this.s.remove(((LocalMediaInfo)localObject1).path);
      }
    }
    Object localObject1 = this.e.selectedPhotoList;
    if ((localObject2 != null) && (paramSlideItemInfo != null))
    {
      Object localObject3 = ((PhotoListAdapter)localObject2).a();
      i1 = 0;
      while (i1 < ((List)localObject3).size())
      {
        if (((LocalMediaInfo)((List)localObject3).get(i1)).path.equals(paramSlideItemInfo.f)) {
          break label167;
        }
        i1 += 1;
      }
      i1 = -1;
      label167:
      if ((i1 >= 0) && (i1 < ((List)localObject3).size()))
      {
        paramSlideItemInfo = ((PhotoListAdapter)localObject2).a(i1);
        paramSlideItemInfo.selectStatus = 2;
        localObject2 = paramSlideItemInfo.path;
        localObject3 = MimeHelper.getMimeType(paramSlideItemInfo.mMimeType);
        if ((this.b.B) && (localObject3 != null) && ("video".equals(localObject3[0])))
        {
          localObject3 = this.b;
          ((PhotoListData)localObject3).C -= 1;
          if (this.b.C == 1) {
            this.b.E = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject3 = this.b;
          ((PhotoListData)localObject3).D -= 1;
        }
        this.e.selectedPhotoList.remove(localObject2);
        this.e.selectedIndex.remove(paramSlideItemInfo.position);
        this.e.selectedMediaInfoHashMap.remove(localObject2);
        localObject3 = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.e.albumId);
        if (localObject3 != null) {
          ((HashMap)localObject3).remove(localObject2);
        }
        localObject3 = QAlbumUtil.sSelectItemAlbum;
        if (((HashMap)localObject3).containsKey(localObject2)) {
          ((HashMap)localObject3).remove(localObject2);
        }
        a(false, paramSlideItemInfo);
        this.h.a(i1, false);
        a();
        ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged((List)localObject1, this.e.allMediaInfoHashMap);
        return;
      }
      if (i1 == -1)
      {
        ((ArrayList)localObject1).remove(paramSlideItemInfo.f);
        this.e.selectedMediaInfoHashMap.remove(paramSlideItemInfo.f);
        localObject2 = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.e.albumId);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(paramSlideItemInfo.f);
        }
        localObject2 = QAlbumUtil.sSelectItemAlbum;
        if (((HashMap)localObject2).containsKey(paramSlideItemInfo.f)) {
          ((HashMap)localObject2).remove(paramSlideItemInfo.f);
        }
        this.h.d();
        a();
        ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged((List)localObject1, this.e.allMediaInfoHashMap);
      }
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    Intent localIntent = this.c.getIntent();
    if (!this.b.j)
    {
      boolean bool = this.k;
      if (bool) {
        localIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", bool);
      }
    }
    super.a(paramLocalMediaInfo, paramInt);
  }
  
  public void a(String paramString)
  {
    Intent localIntent = this.c.getIntent();
    ArrayList localArrayList = this.e.selectedPhotoList;
    HashMap localHashMap = this.e.selectedMediaInfoHashMap;
    localIntent.putExtra("ALBUM_NAME", this.e.albumName);
    localIntent.putExtra("ALBUM_ID", this.e.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    int i2 = localArrayList.size();
    Object localObject = new ArrayList(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      ((ArrayList)localObject).add(Integer.valueOf(i1));
      i1 += 1;
    }
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", (ArrayList)localObject);
    i1 = localArrayList.indexOf(paramString);
    if ((i1 > 0) && (i1 < this.h.t.getItemCount()))
    {
      localObject = this.h.t.a(i1);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    PhotoListData.w = this.h.m.findFirstVisibleItemPosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass(this.c, NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    b(localIntent);
    QAlbumUtil.anim(this.c, true, true);
  }
  
  void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramList != null) && (paramHashMap != null) && (this.e.allMediaInfoHashMap != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!paramHashMap.containsKey(str)) {
          paramHashMap.put(str, this.e.allMediaInfoHashMap.get(str));
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramInt2);
    if (this.C)
    {
      if (((ISlideShowController)QRoute.api(ISlideShowController.class)).getPhotoList().isEmpty())
      {
        paramInt2 = this.h.m.findFirstVisibleItemPosition();
        View localView = this.h.l.getChildAt(paramInt1 - paramInt2);
        if ((localView != null) && (this.h.l.getHeight() - localView.getY() < this.h.t.i)) {
          this.h.l.smoothScrollBy(ISlideShowController.RECYCLERVIEW_HEIGHT, 500);
        }
      }
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.e.selectedPhotoList, this.e.allMediaInfoHashMap);
    }
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("from_qzone", this.B);
    paramIntent.putExtra("readSource", this.F);
    paramIntent.putExtra("p_e_s_type", 3);
    boolean bool = this.k;
    if (bool) {
      paramIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", bool);
    }
    super.a(paramBoolean, paramIntent);
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((this.b.B) && (arrayOfString != null) && ("video".equals(arrayOfString[0])) && (!AlbumUtil.a(this.c, x(), paramLocalMediaInfo, this.k))) {
        return false;
      }
    }
    boolean bool = super.a(paramLocalMediaInfo, paramBoolean);
    if (bool)
    {
      if (paramBoolean)
      {
        this.s.put(paramLocalMediaInfo.path, Integer.valueOf(paramLocalMediaInfo.panoramaPhotoType));
        return bool;
      }
      this.s.remove(paramLocalMediaInfo.path);
    }
    return bool;
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    if (super.a(paramList))
    {
      if (this.C)
      {
        a(this.e.selectedPhotoList, this.e.selectedMediaInfoHashMap);
        ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.e.selectedPhotoList, this.e.allMediaInfoHashMap);
      }
      return true;
    }
    return false;
  }
  
  public Intent b(View paramView, int paramInt)
  {
    paramView = super.b(paramView, paramInt);
    LocalMediaInfo localLocalMediaInfo1 = this.h.t.a(paramInt);
    if ((this.k) && (!n) && (this.e.allMediaInfoHashMap != null)) {
      if (this.q == 1)
      {
        paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.e.selectedPhotoList);
      }
      else
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        int i5 = paramInt - 1;
        int i6 = this.e.mediaPathsList.size();
        int i2 = 0;
        int i1 = i5;
        int i3;
        for (paramInt = 0; i2 < i6; paramInt = i3)
        {
          String str = (String)this.e.mediaPathsList.get(i2);
          LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)this.e.allMediaInfoHashMap.get(str);
          int i4 = i1;
          i3 = paramInt;
          if (AlbumUtil.getMediaType(localLocalMediaInfo2) == 0)
          {
            localArrayList1.add(str);
            if ((this.e.selectedPhotoList != null) && (this.e.selectedPhotoList.contains(str))) {
              localArrayList2.add(Integer.valueOf(paramInt));
            }
            if (localLocalMediaInfo2.position.intValue() == i5) {
              i1 = paramInt;
            }
            i3 = paramInt + 1;
            i4 = i1;
          }
          i2 += 1;
          i1 = i4;
        }
        this.e.mediaPathsList = localArrayList1;
        paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
        paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
        paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
        if (AlbumUtil.getMediaType(localLocalMediaInfo1) == 0) {
          paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i1);
        }
      }
    }
    paramView.putExtra("from_qzone", this.B);
    boolean bool = this.k;
    if (bool) {
      paramView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", bool);
    }
    return paramView;
  }
  
  public Holder b(@NonNull Holder paramHolder, int paramInt)
  {
    Holder localHolder = super.b(paramHolder, paramInt);
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    if ((localLocalMediaInfo != null) && (((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).isPanoramaPhoto(localLocalMediaInfo.panoramaPhotoType)) && ((this.k) || (this.j))) {
      paramHolder.a.setVisibility(0);
    }
    return localHolder;
  }
  
  public void b(Intent paramIntent)
  {
    if (this.q == 1)
    {
      PublicFragmentActivity.Launcher.a(this.c, paramIntent, PublicFragmentActivityForPeak.class, QzonePhotoPreviewActivity.class);
      return;
    }
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    if (paramView != null) {
      b(paramView.getId());
    }
    paramView = this.c.getIntent();
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    int i1;
    if (this.e.selectedPhotoList != null) {
      i1 = this.e.selectedPhotoList.size();
    } else {
      i1 = 0;
    }
    StatisticConstants.b(paramView, i1);
    if (!this.b.l)
    {
      if (this.C) {
        ((ISlideShowController)QRoute.api(ISlideShowController.class)).setData(((ISlideShowController)QRoute.api(ISlideShowController.class)).getTemp());
      }
      this.c.finish();
      AlbumUtil.anim(this.c, false, false);
      return;
    }
    localObject = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (localObject == null) {
      return;
    }
    paramView.setClassName(str1, (String)localObject);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.j) {
      paramView.removeExtra("PeakConstants.selectedMediaInfoHashMap");
    }
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
    {
      this.c.startActivity(paramView);
    }
    else
    {
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str2 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str1))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(paramView, (String)localObject);
        QZoneHelper.launchQZone(this.c, str2, paramView, 2);
      }
      else if ("qqfav.apk".equals(str1))
      {
        QfavHelper.a(this.c, str2, paramView, 2);
      }
      else
      {
        QLog.e("QQAlbum", 1, "Watermark has been deleted!");
      }
    }
    this.c.finish();
    AlbumUtil.anim(this.c, false, false);
  }
  
  protected void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ThreadManager.postImmediately(new PhotoListCustomizationQzone.4(this, paramString), null, true);
    }
  }
  
  public String c(LocalMediaInfo paramLocalMediaInfo)
  {
    String str2 = super.c(paramLocalMediaInfo);
    long l1 = this.e.maxSelectNum;
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((x() <= 0) && ((!this.b.B) || (paramLocalMediaInfo == null) || (!"video".equals(paramLocalMediaInfo[0]))))
      {
        str1 = str2;
        if (this.q == 1) {
          return this.c.getResources().getString(2131892552, new Object[] { Long.valueOf(l1) });
        }
      }
      else
      {
        if ((x() == l1) && (this.b.B) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0]))) {
          this.c.getResources().getString(2131892562, new Object[] { Long.valueOf(l1) });
        }
        if (this.C) {
          return this.c.getResources().getString(2131892561, new Object[] { Long.valueOf(l1) });
        }
        str1 = this.c.getResources().getString(2131892559, new Object[] { Long.valueOf(l1) });
      }
    }
    return str1;
  }
  
  protected void c()
  {
    Intent localIntent = this.c.getIntent();
    if (this.e.albumId.equals("$RecentAlbumId")) {
      StatisticCollector.getInstance(this.c).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    } else if ((!this.e.albumName.equalsIgnoreCase("Camera")) && (!this.e.albumName.equalsIgnoreCase("camera")) && (!this.e.albumName.contains("Camera")) && (!this.e.albumName.contains("camera"))) {
      StatisticCollector.getInstance(this.c).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
    } else {
      StatisticCollector.getInstance(this.c).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if ((this.b.f) && ((!TextUtils.isEmpty(this.b.h)) || (!TextUtils.isEmpty(this.b.i))))
    {
      if (this.c.magicStickBtn != null) {
        this.c.magicStickBtn.performClick();
      }
    }
    else
    {
      if (this.e.selectedPhotoList != null)
      {
        StatisticConstants.a(localIntent, this.e.selectedPhotoList.size());
        StatisticConstants.a(localIntent, this.e.selectedPhotoList.size(), ((PhotoOtherData)this.f).d);
      }
      if (((PhotoOtherData)this.f).d == 2)
      {
        if (localPresendPicMgr != null)
        {
          localPresendPicMgr.a(1008);
          localPresendPicMgr.b();
        }
        ReportController.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
      }
      l(localIntent);
    }
  }
  
  public void c(Intent paramIntent)
  {
    if (this.z) {
      j(paramIntent);
    }
    if (this.B)
    {
      paramIntent.putExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", true);
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200));
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480));
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100));
      String str = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      ArrayList localArrayList = null;
      if (str != null) {
        localArrayList = g(str);
      }
      paramIntent.putStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS", localArrayList);
      paramIntent.putExtra("from_qzone", this.B);
    }
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    b(paramView.getId());
    ArrayList localArrayList = this.e.selectedPhotoList;
    if ((localArrayList != null) && (this.c != null)) {
      this.c.getIntent().putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    }
    super.c(paramView);
  }
  
  public void c(View paramView, int paramInt)
  {
    if (!Utils.b())
    {
      QQToast.makeText(this.c, this.c.getResources().getString(2131916075), 0).show();
      return;
    }
    paramView = this.h.t.a(paramInt);
    if (paramView == null) {
      return;
    }
    Object localObject = this.c.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
    String str2 = ((Intent)localObject).getStringExtra("video_refer");
    int i1;
    if ((!TextUtils.isEmpty(str2)) && ((str2.contains("QZonePublishMoodTabActivity")) || (str2.contains("QZoneUploadPhotoRealActivity")))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      long l1 = ((Intent)localObject).getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION", 9223372036854775807L);
      if (paramView.mDuration > l1)
      {
        paramView = new StringBuilder();
        paramView.append("请选择不超过");
        paramView.append(l1 / 60L / 1000L);
        paramView.append("分钟的视频");
        paramView = paramView.toString();
        QQToast.makeText(this.c, paramView, 0).show(this.c.getTitleBarHeight());
        return;
      }
      l1 = QZoneHelper.getVideoCanUploadSize();
      if (paramView.fileSize > l1)
      {
        paramView = this.c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("请选择不超过");
        ((StringBuilder)localObject).append((float)l1 / 1024.0F / 1024.0F / 1024.0F);
        ((StringBuilder)localObject).append("G的视频");
        QQToast.makeText(paramView, ((StringBuilder)localObject).toString(), 0).show(this.c.getTitleBarHeight());
        return;
      }
    }
    if ((i1 == 0) && (paramView.fileSize > this.e.filter.videoSizeLimit))
    {
      paramView = DialogUtil.a(this.c, "你选择的视频文件过大，无法发送。");
      paramView.setPositiveButton(2131892267, new DialogUtil.DialogOnClickAdapter());
      paramView.show();
      return;
    }
    HashMap localHashMap = AlbumUtil.sSelectItemAlbum;
    if (!localHashMap.containsKey(paramView.path))
    {
      Pair localPair = new Pair(this.e.albumId, this.e.albumName);
      localHashMap.put(paramView.path, localPair);
    }
    this.h.a(paramView.path);
    if (("cover_mall_record_video".equals(str2)) && (paramView.mDuration / 1000L > this.u / 1000L))
    {
      paramView = new StringBuilder();
      paramView.append("视频时间不能超过");
      paramView.append(this.u / 1000L);
      paramView.append("s，请重新选择");
      paramView = paramView.toString();
      QQToast.makeText(this.c, paramView, 0).show(this.c.getTitleBarHeight());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQToast:");
      ((StringBuilder)localObject).append(paramView);
      QLog.i("QQAlbum", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (a(paramView, (Intent)localObject, str1)) {
      return;
    }
    if (!this.b.c)
    {
      a(paramView, (Intent)localObject);
      return;
    }
    if (((!this.j) && (!this.k) && (!this.m) && (!this.C)) || ((!this.b.B) && (!this.o)))
    {
      b(paramView, (Intent)localObject);
      return;
    }
    a(paramInt, (Intent)localObject);
  }
  
  public void c(List<LocalMediaInfo> paramList)
  {
    if (((this.k) || (this.j)) && (QzoneConfig.getInstance().getConfig("PhotoAlbum", "paranoramaOpenCheck", 1) != 0)) {
      d(paramList);
    } else {
      QLog.i("QQAlbum", 2, "@panoramatest isnot fromqzone");
    }
    super.c(paramList);
  }
  
  public void d() {}
  
  public void d(View paramView, int paramInt)
  {
    if (!Utils.b())
    {
      QQToast.makeText(this.c, this.c.getResources().getString(2131916075), 0).show();
      return;
    }
    if ((!this.k) && (!this.j))
    {
      this.c.dispatchTakePictureIntent();
      return;
    }
    C();
  }
  
  public void e(Intent paramIntent)
  {
    a(5);
    super.e(paramIntent);
  }
  
  public void f(Intent paramIntent)
  {
    a(4);
    super.f(paramIntent);
  }
  
  public void g()
  {
    super.g();
    if (this.C)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onResume();
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).setPhotoListController();
    }
  }
  
  public void h()
  {
    if (this.C) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onPhotoListDestroy();
    }
    super.h();
  }
  
  public void k()
  {
    super.k();
    if (this.C)
    {
      boolean bool = this.c.getIntent().getBooleanExtra("report_first_exposure", true);
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).initPhotoListController(this.c, this.h.h, this, bool);
      w();
      if (bool) {
        this.c.getIntent().putExtra("report_first_exposure", false);
      }
    }
    this.h.l.addOnScrollListener(new PhotoListCustomizationQzone.1(this));
    if ((TextUtils.isEmpty(this.e.customSendBtnText)) && (1 == this.q))
    {
      String str = this.c.getString(2131892567);
      if (this.c.imgCountTipsTv != null)
      {
        this.c.imgCountTipsTv.setVisibility(0);
        this.c.imgCountTipsTv.setText(this.c.getString(2131892576));
      }
      if (this.h.o != null) {
        this.h.o.setText(str);
      }
    }
  }
  
  public View o()
  {
    View localView;
    if (this.C)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.c.getSystemService("layout_inflater");
      localView = null;
      if (localLayoutInflater != null) {
        return localLayoutInflater.inflate(2131628113, null);
      }
    }
    else
    {
      localView = super.o();
    }
    return localView;
  }
  
  void w()
  {
    Object localObject = ((ISlideShowController)QRoute.api(ISlideShowController.class)).getPhotoList();
    if (this.b.q) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).setTemp((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (localSlideItemInfo != null)
      {
        if (!this.e.selectedPhotoList.contains(localSlideItemInfo.f)) {
          this.e.selectedPhotoList.add(localSlideItemInfo.f);
        }
        if (!this.e.selectedIndex.contains(localSlideItemInfo.a.position)) {
          this.e.selectedIndex.add(localSlideItemInfo.a.position);
        }
        this.e.selectedMediaInfoHashMap.put(localSlideItemInfo.f, localSlideItemInfo.a);
      }
    }
    if (this.e.selectedPhotoList.size() > 0) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.e.selectedPhotoList, this.e.allMediaInfoHashMap, false);
    }
  }
  
  public int x()
  {
    Iterator localIterator = this.e.selectedMediaInfoHashMap.entrySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext()) {
      if (QAlbumUtil.getMediaType((LocalMediaInfo)((Map.Entry)localIterator.next()).getValue()) == 1) {
        i1 += 1;
      }
    }
    return i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone
 * JD-Core Version:    0.7.0.1
 */