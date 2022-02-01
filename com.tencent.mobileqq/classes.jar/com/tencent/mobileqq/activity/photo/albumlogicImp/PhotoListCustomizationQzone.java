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
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
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
  public static boolean e = false;
  public static boolean g = false;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private LinkedHashMap<String, LocalMediaInfo> jdField_a_of_type_JavaUtilLinkedHashMap;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  protected boolean f;
  boolean h = false;
  boolean i = false;
  boolean j;
  boolean k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o;
  private boolean p;
  private boolean q = false;
  private boolean r = false;
  
  PhotoListCustomizationQzone(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  private ArrayList<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = paramString.split(";");
      if ((paramString == null) || (paramString.length <= 0)) {
        break label55;
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
      label47:
      label55:
      break label47;
    }
    QLog.e("QQAlbum", 2, "parseBlockPaths error!");
    return localArrayList;
  }
  
  private List<LocalMediaInfo> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2) && (paramInt1 <= paramInt2)) {
        try
        {
          if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.getItemCount())
          {
            LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt1);
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
    else if (!this.l)
    {
      this.l = true;
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
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    int i1 = localLocalMediaInfo.position.intValue();
    paramInt = i1;
    if (!e)
    {
      paramInt = i1;
      if (AlbumUtil.getMediaType(localLocalMediaInfo) == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.clear();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList = new ArrayList();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.add(localLocalMediaInfo.path);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = new ArrayList();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localLocalMediaInfo.path);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.clear();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex = new ArrayList();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(0));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        paramInt = 0;
      }
    }
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.e);
    localIntent.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_JavaLangString);
    PhotoListData.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.containsKey(localLocalMediaInfo.path)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    localIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_JavaUtilHashMap);
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, NewPhotoPreviewActivity.class);
    boolean bool = this.jdField_b_of_type_Boolean;
    if (bool) {
      paramIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", bool);
    }
    localIntent.putExtra("from_qzone", this.n);
    localIntent.addFlags(603979776);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)) {
      ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaLangString, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size(), 0, "", "", "", "");
    }
    if (this.o)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivityForResult(paramIntent, 10010);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    }
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, true, true);
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
    PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramIntent, localArrayList, 2, false);
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
    localVideoSendPublicParamBase.mContext = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
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
  
  private boolean a()
  {
    return (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.p) || (this.n);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent, String paramString)
  {
    boolean bool3 = this.f;
    boolean bool2 = true;
    boolean bool1 = true;
    if (bool3)
    {
      if ("qzone_plugin.apk".equals(paramString))
      {
        paramString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if ((paramString != null) && (!paramString.contains("TrimVideoActivity")))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0))
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, "不能同时选择照片和视频", 0).a();
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean = false;
            return true;
          }
          if (paramLocalMediaInfo.mDuration < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean = true;
            return false;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean = false;
          paramLocalMediaInfo = new StringBuilder();
          long l1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration / 1000L;
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
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramLocalMediaInfo.toString(), 0).a();
          return true;
        }
        if (this.o)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean = true;
          return false;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData;
        if (paramLocalMediaInfo.mDuration <= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration) {
          bool1 = false;
        }
        paramString.jdField_b_of_type_Boolean = bool1;
        paramIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean);
        return false;
      }
    }
    else if ("qzone_plugin.apk".equals(paramString))
    {
      paramString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if ((paramString != null) && (!paramString.contains("TrimVideoActivity")))
      {
        if ((!this.j) && (paramLocalMediaInfo.mDuration <= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration) && (!this.jdField_a_of_type_Boolean) && ((!this.jdField_b_of_type_Boolean) || (!e)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean = false;
          paramIntent.putExtra("support_record", false);
          paramIntent.putExtra("support_trim", true);
          paramIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
          paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
          paramIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.e);
          return false;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean = true;
        return false;
      }
      if (this.o)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean = true;
        return false;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData;
      if (paramLocalMediaInfo.mDuration > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramString.jdField_b_of_type_Boolean = bool1;
      paramIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean);
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    return "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(paramString);
  }
  
  private void b(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return;
    }
    int i4 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
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
    case 2131377197: 
      i1 = 1;
      break;
    case 2131373035: 
      i1 = 4;
      break;
    case 2131370603: 
      i1 = 5;
      break;
    case 2131369202: 
      i1 = 3;
    }
    if ((this.jdField_a_of_type_Int == 1) && (paramInt == 2131377197))
    {
      LpReportInfo_pf00064.allReport(586, 47, 3, String.valueOf(i4));
      return;
    }
    LpReportInfo_pf00064.allReport(i3, i2, i1);
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, ShortVideoPreviewActivity.class);
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("file_send_path", paramLocalMediaInfo.path);
    localIntent.putExtra("file_send_size", paramLocalMediaInfo.fileSize);
    localIntent.putExtra("file_send_duration", paramLocalMediaInfo.mDuration);
    localIntent.putExtra("file_width", paramLocalMediaInfo.mediaWidth);
    localIntent.putExtra("file_height", paramLocalMediaInfo.mediaHeight);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Int);
    localIntent.putExtra("file_source", "album");
    localIntent.putExtra("is_from_system_media", paramLocalMediaInfo.isSystemMeidaStore);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n)
    {
      localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    if (((this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e) && (!g))) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n)) {
      localIntent.putExtra("preview_only", true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivityForResult(localIntent, 17);
  }
  
  private void b(List<LocalMediaInfo> paramList)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new PhotoListCustomizationQzone.2(this, paramList));
  }
  
  private boolean b(String paramString)
  {
    return ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(paramString)) || ("com.tencent.qcircle.QCirclePublishFeedActivity".equals(paramString));
  }
  
  private boolean c(String paramString)
  {
    return "com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity".equals(paramString);
  }
  
  private boolean d(String paramString)
  {
    return ("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) || ("com.qzone.common.activities.FeedActionPanelActivity".equals(paramString)) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(paramString)) || (this.h) || (this.jdField_d_of_type_Boolean);
  }
  
  private void g(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (((paramIntent == null) || (paramIntent.isEmpty())) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
    }
    if ((this.r) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.o = false;
      b(this.jdField_d_of_type_JavaLangString);
    }
  }
  
  private void g(LocalMediaInfo paramLocalMediaInfo)
  {
    XMPCoreUtil.getInstance().loadXMPCoreJarModule(new PhotoListCustomizationQzone.3(this, paramLocalMediaInfo));
  }
  
  private void h(Intent paramIntent)
  {
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    boolean bool = false;
    this.j = paramIntent.getBooleanExtra("PhotoConst.IS_TRIM_VIDEO_BLACK_LIST", false);
    this.h = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", false);
    this.k = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_P2V", false);
    this.m = paramIntent.getBooleanExtra("NEED_QZONE_MACHINE_LEARNING_REPORT", false);
    e = paramIntent.getBooleanExtra("QZONE_SUPPORT_MIX_MOOD", false);
    this.f = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    g = paramIntent.getBooleanExtra("upload_single_video", false);
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", -1);
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.i = paramIntent.getBooleanExtra("PhotoConst.IS_NO_PANORAMA", false);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    this.p = paramIntent.getBooleanExtra("from_qzoneshare", false);
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("report_from");
    if (paramIntent.getIntExtra("p_e_s_type", 0) != 0) {
      bool = true;
    }
    this.r = bool;
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.QZONE_SINGLE_PHOTO_PATH_EDITED");
  }
  
  private void i(Intent paramIntent)
  {
    if (paramIntent != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
          return;
        }
        paramIntent = paramIntent.getSerializableExtra("qzone_album_machine_learning_exposed_media_list");
        if (paramIntent != null)
        {
          paramIntent = ((List)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramIntent.next();
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
        return;
      }
      try
      {
        if ((!this.q) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.getItemCount() > 0)) {
          n();
        }
        int i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MachineLearningExposedMediaUpperBound", 50) - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.size();
        if (i2 > 0)
        {
          int i1 = 0;
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
          while ((localIterator.hasNext()) && (i1 < i2))
          {
            LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Map.Entry)localIterator.next()).getValue();
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.containsKey(localLocalMediaInfo.path))
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
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (localPublishParam == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQAlbum", 2, "handleQzoneEditVideoResult: publishParam == null");
        }
        return;
      }
      int i1;
      if (localPublishParam.f <= 5) {
        i1 = localPublishParam.f;
      } else {
        i1 = 0;
      }
      int i6 = paramIntent.getIntExtra("KEY_VIDEO_FRAME_COUNT", 0);
      boolean bool3 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
      a(localPublishParam.k, i1, localPublishParam.j, localPublishParam.jdField_c_of_type_JavaLangString, localPublishParam.jdField_b_of_type_JavaLangString, (int)localPublishParam.jdField_a_of_type_Long, i6, (FlowComponentInterface)((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).getVideoComponentCallback(), (String)localObject1, i2, (ArrayList)localObject2, i3, i4, (String)localObject3, i5, str, bool1, bool2, bool3);
    }
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
    int i2 = 0;
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.containsKey(str)) && (AlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(str)) == 1))
      {
        ((Iterator)localObject).remove();
        i2 = 1;
      }
      else if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.containsKey(str)) && (!str.startsWith("http://qzs.qq.com")) && (!str.startsWith("https://qzs.qq.com")) && (str.toLowerCase().endsWith(".gif")))
      {
        ((Iterator)localObject).remove();
        i1 = 1;
      }
    }
    localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694849, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) });
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.subList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size()).clear();
    }
    else if (i2 != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694854);
    }
    else if (i1 != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694853);
    }
    if (localObject != null) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, (CharSequence)localObject, 0).a();
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
    if ((this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e)) || (this.jdField_d_of_type_Boolean)) {
      paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    }
    if (this.m) {
      j(paramIntent);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      NewFlowCameraReporter.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    paramIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_a_of_type_JavaUtilHashMap);
    if (1 == this.jdField_a_of_type_Int)
    {
      paramIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
      paramIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    }
    else
    {
      paramIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
    paramIntent.putExtra("key_state_type", this.jdField_c_of_type_Int);
    a(paramIntent, false, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
  }
  
  private void m()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (AlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(str)) == 1) {
        localIterator.remove();
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentWidgetPhotoGridView != null)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
        return;
      }
      Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition());
      if ((localObject != null) && (this.jdField_a_of_type_JavaUtilLinkedHashMap != null))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
          if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localLocalMediaInfo.path)) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
          }
        }
      }
      this.q = true;
    }
  }
  
  private void o()
  {
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
    QZoneHelper.forwardToQzoneVideoCaptureNew(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, localBundle, 10001);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.entrySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext()) {
      if (QAlbumUtil.getMediaType((LocalMediaInfo)((Map.Entry)localIterator.next()).getValue()) == 1) {
        i1 += 1;
      }
    }
    return i1;
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = super.a(paramView, paramInt);
    LocalMediaInfo localLocalMediaInfo1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    if ((this.jdField_b_of_type_Boolean) && (!e) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null)) {
      if (this.jdField_a_of_type_Int == 1)
      {
        paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      }
      else
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        int i5 = paramInt - 1;
        int i6 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.size();
        int i2 = 0;
        int i1 = i5;
        int i3;
        for (paramInt = 0; i2 < i6; paramInt = i3)
        {
          String str = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.get(i2);
          LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(str);
          int i4 = i1;
          i3 = paramInt;
          if (AlbumUtil.getMediaType(localLocalMediaInfo2) == 0)
          {
            localArrayList1.add(str);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.contains(str))) {
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
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList = localArrayList1;
        paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
        paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
        paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
        if (AlbumUtil.getMediaType(localLocalMediaInfo1) == 0) {
          paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i1);
        }
      }
    }
    paramView.putExtra("from_qzone", this.n);
    boolean bool = this.jdField_b_of_type_Boolean;
    if (bool) {
      paramView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", bool);
    }
    return paramView;
  }
  
  public Holder a(@NonNull Holder paramHolder, int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      a(1);
    }
    return super.a(paramHolder, paramInt);
  }
  
  public String a(LocalMediaInfo paramLocalMediaInfo)
  {
    String str2 = super.a(paramLocalMediaInfo);
    long l1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((a() <= 0) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) || (paramLocalMediaInfo == null) || (!"video".equals(paramLocalMediaInfo[0]))))
      {
        str1 = str2;
        if (this.jdField_a_of_type_Int == 1) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694849, new Object[] { Long.valueOf(l1) });
        }
      }
      else
      {
        if ((a() == l1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0]))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694859, new Object[] { Long.valueOf(l1) });
        }
        if (this.o) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694858, new Object[] { Long.valueOf(l1) });
        }
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694856, new Object[] { Long.valueOf(l1) });
      }
    }
    return str1;
  }
  
  public void a()
  {
    super.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText;
    boolean bool2 = true;
    boolean bool1 = true;
    if (localObject1 != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText;
    } else if (1 == this.jdField_a_of_type_Int) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2131694864);
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2131694839);
    }
    Object localObject2;
    if (1 != this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() <= 0) {
        bool1 = false;
      }
      localObject2 = localObject1;
      bool2 = bool1;
      if (bool1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
        ((StringBuilder)localObject2).append(")");
        localObject2 = ((StringBuilder)localObject2).toString();
        bool2 = bool1;
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= 3)
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
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
      QLog.d("_photo", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool2);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    PhotoListAdapter localPhotoListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i1)
      {
        Object localObject = localPhotoListAdapter.a(paramInt1);
        int i2 = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (i2 >= 0)
        {
          localObject = (Holder)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentWidgetPhotoGridView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2).getTag();
          if ((localObject != null) && (((Holder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)) {
            ((Holder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(i2 + 1);
          }
        }
        paramInt1 += 1;
      }
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b(true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 24747)) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onClipFinish(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    }
    if ((this.o) && (paramInt2 == -1) && (paramInt1 != 24747))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(paramInt2, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      return;
    }
    if (paramInt1 == 10001) {
      if (paramInt2 == -1)
      {
        k(paramIntent);
      }
      else if ((this.o) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
        if (!TextUtils.isEmpty(str)) {
          FileUtils.deleteDirectory(new File(str).getParent());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(0, paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      }
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    this.o = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    super.a(paramIntent);
    h(paramIntent);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Boolean = a(this.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_Boolean = b(this.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = c(this.jdField_b_of_type_JavaLangString);
      this.n = d(this.jdField_b_of_type_JavaLangString);
    }
    if (this.k)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
    }
    if (this.m)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      i(paramIntent);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("imageSizeLimit", 0);
    }
    if (this.jdField_a_of_type_Int == 1) {
      l();
    }
    if (this.f) {
      m();
    }
    if ((this.o) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getIntExtra("qq_sub_business_id", -1) == 3))
    {
      SlideShowPhotoListManager.a().c(22);
      SlideShowPhotoListManager.a().b(14);
      SlideShowPhotoListManager.a().c();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().removeExtra("qq_sub_business_id");
    }
    if (((this.n) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId"))) || ((this.h) && (this.i)))
    {
      int i1 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480);
      int i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100);
      String str = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      ArrayList localArrayList = null;
      if (str != null) {
        localArrayList = a(str);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.imageMinWidth = i2;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.imageMinHeight = i2;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.imageMinSize = i1;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.blockPaths = localArrayList;
    }
    g(paramIntent);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    paramArrayList = new HashMap();
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size())
    {
      Object localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(i1);
      if (!ImageManager.isNetworkUrl((String)localObject))
      {
        if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, (String)localObject) == 1)
        {
          localObject = ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, (String)localObject);
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
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaUtilHashMap, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, false);
      return;
    }
    PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Boolean);
  }
  
  public void a(Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivityHandler.b();
    if ((paramMessage.obj instanceof String))
    {
      paramMessage = (String)paramMessage.obj;
      QZLog.d("QQAlbum", 2, new Object[] { "onEncodeSuccess = ", paramMessage });
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = new ArrayList();
      }
      int i1;
      if (this.jdField_b_of_type_Boolean) {
        i1 = AlbumUtil.b();
      } else {
        i1 = AlbumUtil.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694856), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) }), 0).a();
      }
      else if (a() >= i1)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694861), new Object[] { Integer.valueOf(i1) }), 0).a();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramMessage);
        QQAlbumUtils.a(this);
      }
      QQAlbumUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramMessage);
    }
  }
  
  public void a(View paramView)
  {
    b(paramView.getId());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() - 1));
    }
    AlbumUtil.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if (localIntent.getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      while (paramView.hasNext()) {
        FileUtils.getFileSizes((String)paramView.next());
      }
      if (FileManagerUtil.a())
      {
        FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, 2131692561, 2131692566, new PhotoListCustomizationQzone.5(this));
        return;
      }
    }
    if (this.p)
    {
      String str = localIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      paramView = str;
      if (TextUtils.isEmpty(str)) {
        paramView = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      }
      localIntent.addFlags(603979776);
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, paramView);
      paramView = QZoneHelper.UserInfo.getInstance();
      QZoneHelper.forwardToFriendFeed(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramView, localIntent, -1, null);
      return;
    }
    b();
  }
  
  public void a(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    if ((this.jdField_c_of_type_Boolean) && (localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0) && (this.jdField_b_of_type_Int > 0) && (localLocalMediaInfo.fileSize > this.jdField_b_of_type_Int))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131694896, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int / 1048576) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    super.a(paramView, paramInt);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    if ((this.o) && (!((IQQStoryFlowManager)QRoute.api(IQQStoryFlowManager.class)).isValidMedia(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, localLocalMediaInfo))) {
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) && (arrayOfString != null) && ("video".equals(arrayOfString[0])) && (!AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, a(), localLocalMediaInfo, this.jdField_b_of_type_Boolean)))
      {
        localLocalMediaInfo.selectStatus = 2;
        return;
      }
    }
    super.a(paramView, paramInt, paramCheckBox);
    if (this.o)
    {
      if (((ISlideShowController)QRoute.api(ISlideShowController.class)).getPhotoList().isEmpty())
      {
        i2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentWidgetPhotoGridView.getChildAt(paramInt - i2);
        if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentWidgetPhotoGridView.getHeight() - paramView.getY() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_b_of_type_Int)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentWidgetPhotoGridView.smoothScrollBy(ISlideShowController.RECYCLERVIEW_HEIGHT, 500);
        }
      }
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
    }
    if (i1 == 0)
    {
      MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      this.jdField_a_of_type_JavaUtilHashMap.put(localLocalMediaInfo.path, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
      return;
    }
    MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
    this.jdField_a_of_type_JavaUtilHashMap.remove(localLocalMediaInfo.path);
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    b(paramView.getId());
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)
    {
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      paramView.putExtra("p_e_s_type", 7);
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = new HashMap(1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(0)) != null)) {
        paramView.put("param_localmediainfo", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(0)));
      }
      if (a()) {
        paramView = ((IEditPicForQzone)QRoute.api(IEditPicForQzone.class)).newPictureEditIntentWithoutPublish(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(0));
      } else {
        paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(0), true, true, true, true, true, 3, 142, 5, paramView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivity(paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.magicStickBtn != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.magicStickBtn.setClickable(false);
      }
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter;
    int i1;
    if ((localObject2 != null) && (paramSlideItemInfo != null))
    {
      localObject1 = ((PhotoListAdapter)localObject2).a();
      i1 = 0;
      while (i1 < ((List)localObject1).size())
      {
        if (((LocalMediaInfo)((List)localObject1).get(i1)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
          break label71;
        }
        i1 += 1;
      }
      i1 = -1;
      label71:
      if (i1 >= 0)
      {
        localObject1 = ((PhotoListAdapter)localObject2).a(i1);
        this.jdField_a_of_type_JavaUtilHashMap.remove(((LocalMediaInfo)localObject1).path);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if ((localObject2 != null) && (paramSlideItemInfo != null))
    {
      Object localObject3 = ((PhotoListAdapter)localObject2).a();
      i1 = 0;
      while (i1 < ((List)localObject3).size())
      {
        if (((LocalMediaInfo)((List)localObject3).get(i1)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
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
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) && (localObject3 != null) && ("video".equals(localObject3[0])))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData;
          ((PhotoListData)localObject3).jdField_c_of_type_Int -= 1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_Int == 1) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData;
          ((PhotoListData)localObject3).jdField_d_of_type_Int -= 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(localObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(paramSlideItemInfo.position);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.remove(localObject2);
        localObject3 = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
        if (localObject3 != null) {
          ((HashMap)localObject3).remove(localObject2);
        }
        localObject3 = QAlbumUtil.sSelectItemAlbum;
        if (((HashMap)localObject3).containsKey(localObject2)) {
          ((HashMap)localObject3).remove(localObject2);
        }
        a(false, paramSlideItemInfo);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a(i1, false);
        a();
        ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
        return;
      }
      if (i1 == -1)
      {
        ((ArrayList)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
        localObject2 = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
        }
        localObject2 = QAlbumUtil.sSelectItemAlbum;
        if (((HashMap)localObject2).containsKey(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
          ((HashMap)localObject2).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.c();
        a();
        ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
      }
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.f)
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      if (bool) {
        localIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", bool);
      }
    }
    super.a(paramLocalMediaInfo, paramInt);
  }
  
  public void a(String paramString)
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
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
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.getItemCount()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(i1);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    PhotoListData.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    b(localIntent);
    QAlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, true, true);
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    if (((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) && (QzoneConfig.getInstance().getConfig("PhotoAlbum", "paranoramaOpenCheck", 1) != 0)) {
      b(paramList);
    } else {
      QLog.i("QQAlbum", 2, "@panoramatest isnot fromqzone");
    }
    super.a(paramList);
  }
  
  void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramList != null) && (paramHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!paramHashMap.containsKey(str)) {
          paramHashMap.put(str, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(str));
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramInt2);
    if (this.o)
    {
      if (((ISlideShowController)QRoute.api(ISlideShowController.class)).getPhotoList().isEmpty())
      {
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
        View localView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentWidgetPhotoGridView.getChildAt(paramInt1 - paramInt2);
        if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentWidgetPhotoGridView.getHeight() - localView.getY() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_b_of_type_Int)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentWidgetPhotoGridView.smoothScrollBy(ISlideShowController.RECYCLERVIEW_HEIGHT, 500);
        }
      }
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
    }
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("from_qzone", this.n);
    paramIntent.putExtra("readSource", this.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("p_e_s_type", 3);
    boolean bool = this.jdField_b_of_type_Boolean;
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) && (arrayOfString != null) && ("video".equals(arrayOfString[0])) && (!AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, a(), paramLocalMediaInfo, this.jdField_b_of_type_Boolean))) {
        return false;
      }
    }
    boolean bool = super.a(paramLocalMediaInfo, paramBoolean);
    if (bool)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramLocalMediaInfo.path, Integer.valueOf(paramLocalMediaInfo.panoramaPhotoType));
        return bool;
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramLocalMediaInfo.path);
    }
    return bool;
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    if (super.a(paramList))
    {
      if (this.o)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
        ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
      }
      return true;
    }
    return false;
  }
  
  public View b()
  {
    View localView;
    if (this.o)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getSystemService("layout_inflater");
      localView = null;
      if (localLayoutInflater != null) {
        return localLayoutInflater.inflate(2131561734, null);
      }
    }
    else
    {
      localView = super.b();
    }
    return localView;
  }
  
  public Holder b(@NonNull Holder paramHolder, int paramInt)
  {
    Holder localHolder = super.b(paramHolder, paramInt);
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    if ((localLocalMediaInfo != null) && (((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).isPanoramaPhoto(localLocalMediaInfo.panoramaPhotoType)) && ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))) {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    return localHolder;
  }
  
  protected void b()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    } else if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.equalsIgnoreCase("Camera")) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.equalsIgnoreCase("camera")) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.contains("Camera")) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.contains("camera"))) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
    } else {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.e) && ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_JavaLangString))))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.magicStickBtn != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.magicStickBtn.performClick();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null)
      {
        StatisticConstants.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
        StatisticConstants.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size(), ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
      }
      if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2)
      {
        if (localPresendPicMgr != null)
        {
          localPresendPicMgr.a(1008);
          localPresendPicMgr.a();
        }
        ReportController.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
      }
      l(localIntent);
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramIntent, PublicFragmentActivityForPeak.class, QzonePhotoPreviewActivity.class);
      return;
    }
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    if (paramView != null) {
      b(paramView.getId());
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    } else {
      i1 = 0;
    }
    StatisticConstants.b(paramView, i1);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.h)
    {
      if (this.o) {
        ((ISlideShowController)QRoute.api(ISlideShowController.class)).setData(((ISlideShowController)QRoute.api(ISlideShowController.class)).getTemp());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, false, false);
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
    if (this.jdField_a_of_type_Boolean) {
      paramView.removeExtra("PeakConstants.selectedMediaInfoHashMap");
    }
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivity(paramView);
    }
    else
    {
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str2 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str1))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(paramView, (String)localObject);
        QZoneHelper.launchQZone(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, str2, paramView, 2);
      }
      else if ("qqfav.apk".equals(str1))
      {
        QfavHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, str2, paramView, 2);
      }
      else
      {
        QLog.e("QQAlbum", 1, "Watermark has been deleted!");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, false, false);
  }
  
  public void b(View paramView, int paramInt)
  {
    if (!Utils.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131718574), 0).a();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    if (paramView == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
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
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramView, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getTitleBarHeight());
        return;
      }
      l1 = QZoneHelper.getVideoCanUploadSize();
      if (paramView.fileSize > l1)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("请选择不超过");
        ((StringBuilder)localObject).append((float)l1 / 1024.0F / 1024.0F / 1024.0F);
        ((StringBuilder)localObject).append("G的视频");
        QQToast.a(paramView, ((StringBuilder)localObject).toString(), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getTitleBarHeight());
        return;
      }
    }
    if ((i1 == 0) && (paramView.fileSize > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoSizeLimit))
    {
      paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, "你选择的视频文件过大，无法发送。");
      paramView.setPositiveButton(2131694583, new DialogUtil.DialogOnClickAdapter());
      paramView.show();
      return;
    }
    HashMap localHashMap = AlbumUtil.sSelectItemAlbum;
    if (!localHashMap.containsKey(paramView.path))
    {
      Pair localPair = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
      localHashMap.put(paramView.path, localPair);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a(paramView.path);
    if (("cover_mall_record_video".equals(str2)) && (paramView.mDuration / 1000L > this.jdField_a_of_type_Long / 1000L))
    {
      paramView = new StringBuilder();
      paramView.append("视频时间不能超过");
      paramView.append(this.jdField_a_of_type_Long / 1000L);
      paramView.append("s，请重新选择");
      paramView = paramView.toString();
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramView, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getTitleBarHeight());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQToast:");
      ((StringBuilder)localObject).append(paramView);
      QLog.i("QQAlbum", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (a(paramView, (Intent)localObject, str1)) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean)
    {
      a(paramView, (Intent)localObject);
      return;
    }
    if (((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (!this.o)) || ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) && (!this.f)))
    {
      b(paramView, (Intent)localObject);
      return;
    }
    a(paramInt, (Intent)localObject);
  }
  
  protected void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ThreadManager.postImmediately(new PhotoListCustomizationQzone.4(this, paramString), null, true);
    }
  }
  
  public void c(Intent paramIntent)
  {
    if (this.m) {
      j(paramIntent);
    }
    if (this.n)
    {
      paramIntent.putExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", true);
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200));
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480));
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100));
      String str = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      ArrayList localArrayList = null;
      if (str != null) {
        localArrayList = a(str);
      }
      paramIntent.putStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS", localArrayList);
      paramIntent.putExtra("from_qzone", this.n);
    }
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    b(paramView.getId());
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if ((localArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    }
    super.c(paramView);
  }
  
  public void c(View paramView, int paramInt)
  {
    if (!Utils.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131718574), 0).a();
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.dispatchTakePictureIntent();
      return;
    }
    o();
  }
  
  public void d() {}
  
  public void e(Intent paramIntent)
  {
    a(5);
    super.e(paramIntent);
  }
  
  public void f()
  {
    super.f();
    if (this.o)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onResume();
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).setPhotoListController();
    }
  }
  
  public void f(Intent paramIntent)
  {
    a(4);
    super.f(paramIntent);
  }
  
  public void g()
  {
    if (this.o) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onPhotoListDestroy();
    }
    super.g();
  }
  
  public void h()
  {
    super.h();
    if (this.o)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getBooleanExtra("report_first_exposure", true);
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).initPhotoListController(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b, this, bool);
      k();
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().putExtra("report_first_exposure", false);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentWidgetPhotoGridView.addOnScrollListener(new PhotoListCustomizationQzone.1(this));
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText)) && (1 == this.jdField_a_of_type_Int))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2131694864);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.imgCountTipsTv != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.imgCountTipsTv.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.imgCountTipsTv.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2131694873));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setText(str);
      }
    }
  }
  
  void k()
  {
    Object localObject = ((ISlideShowController)QRoute.api(ISlideShowController.class)).getPhotoList();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.j) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).setTemp((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (localSlideItemInfo != null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.contains(localSlideItemInfo.jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localSlideItemInfo.jdField_b_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.position)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.position);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone
 * JD-Core Version:    0.7.0.1
 */