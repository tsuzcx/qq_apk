package com.tencent.aelight.camera.ae.album.logic;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import com.tencent.aelight.camera.ae.album.fragment.AENewPhotoListFragment;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.TAVCut;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;

public class AEPhotoListLogicDefault
  extends AEPhotoListLogicBase<AENewPhotoListFragment>
  implements AEPhotoListLogic.IadapterCallback, AEPhotoListLogic.IcheckBoxCallback, AEPhotoListLogic.IitemClickCallback
{
  protected PhotoListData a;
  private List<AEPhotoListLogicDefault.InitResult> a;
  
  public AEPhotoListLogicDefault(AENewPhotoListFragment paramAENewPhotoListFragment)
  {
    super(paramAENewPhotoListFragment);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IitemClickCallback = this;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IadapterCallback = this;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IcheckBoxCallback = this;
    this.a = new PhotoListData();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData = ((PhotoListData)this.a);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.add(new AEPhotoListLogicDefault.InitResult(this, paramInt));
    }
  }
  
  private void j()
  {
    if (!AEKitForQQ.a())
    {
      this.jdField_a_of_type_JavaUtilList.add(new AEPhotoListLogicDefault.InitResult(this, -1));
    }
    else
    {
      a(FeatureManager.Features.YT_COMMON.init(), -2);
      a(FeatureManager.Features.PTU_TOOLS.init(), -3);
      a(FeatureManager.Features.PTU_ALGO.init(), -4);
      a(FeatureManager.Features.LIGHT_SDK.init(), -8);
      a(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
    TAVCut.initTAVCut(BaseApplicationImpl.context, FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.g(), new AEPhotoListLogicDefault.1(this));
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilList.size();
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    String str2 = super.a(paramLocalMediaInfo);
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n)
      {
        str1 = str2;
        if (paramLocalMediaInfo != null)
        {
          str1 = str2;
          if ("video".equals(paramLocalMediaInfo[0])) {
            str1 = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131694856, new Object[] { Integer.valueOf(i) });
          }
        }
      }
    }
    return str1;
  }
  
  public List<LocalMediaInfo> a(boolean paramBoolean)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) && (paramBoolean)) {
      i = 15;
    } else {
      i = -1;
    }
    List localList = AlbumUtil.getAlbumMedias(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName, i, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration);
    LogTag.a("PEAK", "getAlbumMedias");
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() != 0))
    {
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size())
      {
        if (TextUtils.isEmpty((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(i))) {
          QZLog.e("QQAlbum:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
        }
        i += 1;
      }
    }
    return localList;
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAlbum initData(),intent extras is:");
      localStringBuilder.append(paramIntent.getExtras());
      QLog.d("SelectPhotoTrace", 2, localStringBuilder.toString());
    }
    super.a(paramIntent);
    j();
    k();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.j = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    ReplacePhotoDataUtil.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, false, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.g = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.h = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", -1L);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", -1L);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject1 = new HashMap();
    boolean bool = false;
    int i1 = 0;
    int j = 0;
    int i = 0;
    int n = 0;
    while (i1 < paramArrayList.size())
    {
      Object localObject2 = (String)paramArrayList.get(i1);
      if (!ImageManager.isNetworkUrl((String)localObject2))
      {
        int k;
        int m;
        if (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2) == 1)
        {
          localObject2 = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2);
          k = j;
          m = i;
          if (localObject2 != null)
          {
            SendVideoInfo localSendVideoInfo = new SendVideoInfo();
            localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject2).fileSize;
            localSendVideoInfo.duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(n), localSendVideoInfo);
            m = i + 1;
            k = j;
          }
        }
        else
        {
          k = j + 1;
          m = i;
        }
        n += 1;
        i = m;
        j = k;
      }
      i1 += 1;
    }
    if (!((HashMap)localObject1).isEmpty())
    {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
      i = 1;
    }
    else
    {
      i = 0;
    }
    paramBoolean = bool;
    if (SVBusiUtil.jdField_b_of_type_Long != 0L)
    {
      paramBoolean = bool;
      if (System.currentTimeMillis() - SVBusiUtil.jdField_b_of_type_Long < 300000L) {
        paramBoolean = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("upload video isConfirmed=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" allowUploadInXGTime=");
      ((StringBuilder)localObject1).append(SVBusiUtil.jdField_b_of_type_Long);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
    }
    if ((NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) && (!paramBoolean) && (i != 0))
    {
      localObject1 = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131718735);
      paramIntent = new AEPhotoListLogicDefault.2(this, paramIntent, paramArrayList);
      if (FreeWifiHelper.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 4, new AEPhotoListLogicDefault.3(this, paramIntent))) {
        DialogUtil.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 232, null, (String)localObject1, new AEPhotoListLogicDefault.4(this, paramIntent), new AEPhotoListLogicDefault.5(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAlbum", 2, "show shortvideo_mobile_send_confirm dialog");
      }
      return;
    }
    PhotoUtils.sendPhoto(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, paramArrayList, 2, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Boolean);
  }
  
  public void a(Message paramMessage)
  {
    super.a(paramMessage);
    ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).h();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if ((paramMessage.obj instanceof String))
    {
      String str = (String)paramMessage.obj;
      QZLog.d("QQAlbum", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
      {
        QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), String.format(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131694856), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) }), 0).a();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(str);
        ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).i();
      }
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
    }
  }
  
  public void a(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    } else {
      i = 0;
    }
    StatisticConstants.b(paramView, i);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.h)
    {
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      AlbumUtil.anim(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      return;
    }
    paramView = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      AEQLog.d("AEPhotoListLogicDefault", "onTitleBtnCancelClick---className is null, return");
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    AlbumUtil.anim(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode) {
      return;
    }
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      paramView = new StringBuilder();
      paramView.append("current select count:");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
      QLog.d("QQAlbum", 2, paramView.toString());
    }
    LocalMediaInfo localLocalMediaInfo = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt);
    int j = localLocalMediaInfo.selectStatus;
    long l;
    if ((j != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Long >= 1000L)
      {
        QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), a(localLocalMediaInfo), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_Long = l;
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Int == 9501) && (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (j != 1))
    {
      l = 0L;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      while (paramView.hasNext()) {
        l += FileUtils.getFileSizes((String)paramView.next());
      }
      if (l + FileUtils.getFileSizes(localLocalMediaInfo.path) > 52428800L)
      {
        QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "选择图片总大小不能超过50M", 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
        paramCheckBox.setChecked(false);
        return;
      }
    }
    if ((((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo)) && (FileUtils.getFileSizes(localLocalMediaInfo.path) > 3145728L))
    {
      QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "图片文件过大", 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
      paramCheckBox.setChecked(false);
      return;
    }
    if (j != 1) {
      i = 1;
    }
    localLocalMediaInfo.selectStatus = i;
    if (localLocalMediaInfo.selectStatus == 1) {
      bool = true;
    } else {
      bool = false;
    }
    String str = localLocalMediaInfo.path;
    paramView = PresendPicMgr.a();
    if (bool)
    {
      paramCheckBox = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      PhotoListData localPhotoListData;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) && (paramCheckBox != null) && ("video".equals(paramCheckBox[0])))
      {
        localPhotoListData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData;
        localPhotoListData.jdField_c_of_type_Int += 1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localPhotoListData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData;
        localPhotoListData.jdField_d_of_type_Int += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(localLocalMediaInfo.position);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      if ((paramView != null) && (paramCheckBox != null) && (paramCheckBox[0] != null) && (!"video".equals(paramCheckBox[0]))) {
        paramView.a(str, 1052, ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getIntExtra("entrance", 0));
      }
      StatisticConstants.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_totalSelNum");
      paramView = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramCheckBox = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      paramView = paramCheckBox;
      if (paramCheckBox == null)
      {
        paramView = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramView);
      }
      paramView.put(str, Integer.valueOf(((GridLayoutManager)((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(str)) {
        paramView.put(str, new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName));
      }
    }
    else
    {
      paramCheckBox = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) && (paramCheckBox != null) && ("video".equals(paramCheckBox[0])))
      {
        paramCheckBox = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData;
        paramCheckBox.jdField_c_of_type_Int -= 1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        paramCheckBox = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData;
        paramCheckBox.jdField_d_of_type_Int -= 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(localLocalMediaInfo.position);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.remove(str);
      if (paramView != null) {
        paramView.b(str, 1013);
      }
      StatisticConstants.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
      paramView = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      if (paramView != null) {
        paramView.remove(str);
      }
      paramView = AlbumUtil.sSelectItemAlbum;
      if (paramView.containsKey(str)) {
        paramView.remove(str);
      }
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IonSelectionChangeListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IonSelectionChangeListener.a(bool, localLocalMediaInfo);
    }
    ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool);
    ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d(bool ^ true);
    d();
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  protected void a(AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, LocalMediaInfo paramLocalMediaInfo)
  {
    if (ReplacePhotoDataUtil.a(paramLocalMediaInfo.path, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_JavaUtilHashMap))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramPhotoVH.d.setImageDrawable(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getDrawable(2130839350));
      } else {
        paramPhotoVH.d.setImageResource(2130839350);
      }
      paramPhotoVH.d.setVisibility(0);
      return;
    }
    paramPhotoVH.d.setVisibility(8);
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    ReplacePhotoDataUtil.a(paramList, 0, null, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_JavaUtilHashMap);
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    AlbumUtil.a();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    } else {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_e_of_type_JavaLangString);
    }
    paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_JavaUtilHashMap);
    PhotoListData.jdField_b_of_type_Int = ((GridLayoutManager)((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    paramIntent.setClass(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), NewPhotoPreviewActivity.class);
    paramIntent.addFlags(603979776);
    c(paramIntent);
    AlbumUtil.anim(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference.get();
    int m = 0;
    if (localObject == null) {
      return false;
    }
    if (super.a(paramList, paramBoolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.l)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData;
        ((PhotoListData)localObject).l = false;
        int j;
        if (((PhotoListData)localObject).jdField_e_of_type_Int == -1) {
          j = PhotoListData.jdField_b_of_type_Int;
        } else {
          j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_e_of_type_Int;
        }
        if (j == -1)
        {
          localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
          i = j;
          if (localObject != null)
          {
            k = ((LinkedHashMap)localObject).size();
            i = j;
            if (k > 0) {
              i = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(k - 1)])).intValue();
            }
          }
          int k = i;
          if (i == -1)
          {
            k = i;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.q)
            {
              localObject = paramList.iterator();
              j = 0;
              for (;;)
              {
                k = i;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus == 3)
                {
                  k = j;
                  break;
                }
                j += 1;
              }
            }
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
          if ((k == -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) && (!((ArrayList)localObject).isEmpty()))
          {
            j = paramList.size();
            localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            i = m;
            while ((i < j) && (!((String)localObject).equals(((LocalMediaInfo)paramList.get(i)).path))) {
              i += 1;
            }
          }
        }
        else
        {
          PhotoListData.jdField_b_of_type_Int = -1;
        }
        int i = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.getItemCount();
        if (i != 0) {}
        ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPhotoListLogicDefault.8(this));
      }
      return true;
    }
    return false;
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum);
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
  
  public View c()
  {
    return super.c();
  }
  
  public void c()
  {
    d();
    super.c();
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.isEmpty()) {
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() - 1));
    }
    AlbumUtil.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      while (paramView.hasNext()) {
        FileUtils.getFileSizes((String)paramView.next());
      }
      if (FileManagerUtil.a())
      {
        FMDialogUtil.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131692561, 2131692566, new AEPhotoListLogicDefault.6(this));
        return;
      }
    }
    i();
  }
  
  protected void d()
  {
    super.d();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    localArrayList.size();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateButton selectedPhotoList.size()=");
      localStringBuilder.append(localArrayList.size());
      QLog.d("_photo", 2, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    super.e();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_f_of_type_Int == 10016)
    {
      if (!((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false))
      {
        ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
        return;
      }
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_f_of_type_Int = 0;
    }
  }
  
  public void f()
  {
    super.f();
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) {
      StatisticCollector.getInstance(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    } else if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.equalsIgnoreCase("Camera")) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.equalsIgnoreCase("camera")) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.contains("Camera")) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.contains("camera"))) {
      StatisticCollector.getInstance(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
    } else {
      StatisticCollector.getInstance(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
    }
    PresendPicMgr.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_e_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_b_of_type_JavaLangString)) {
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      StatisticConstants.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
    }
    Intent localIntent = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
    localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      NewFlowCameraReporter.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    a(localIntent, false, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {
      return;
    }
    Object localObject = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter;
    if ((localObject != null) && (((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).a != null))
    {
      localObject = (LocalMediaInfo)((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).a.get(paramInt);
      if ((localObject != null) && (paramLocalMediaInfo != null) && (((LocalMediaInfo)localObject).path != null))
      {
        if (paramLocalMediaInfo.path == null) {
          return;
        }
        if (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)) {
          return;
        }
        localObject = localHandler.obtainMessage();
        ((Message)localObject).what = 0;
        Bundle localBundle = new Bundle();
        localBundle.putInt("ALBUMLIST_POSITION", paramInt);
        localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
        ((Message)localObject).setData(localBundle);
        localHandler.sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault
 * JD-Core Version:    0.7.0.1
 */