package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoConst.Menu;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomizationBase;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewModel;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PhotoPreviewCustomizationDefault
  extends PhotoPreviewCustomizationBase<PhotoOtherData>
{
  protected NewPhotoPreviewActivity a;
  protected PhotoPreviewData a;
  
  public PhotoPreviewCustomizationDefault(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity = ((NewPhotoPreviewActivity)paramAbstractPhotoPreviewActivity);
    this.a = new PhotoPreviewData();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData = ((PhotoPreviewData)this.a);
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Int == 1) {
      return 141;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Int != 3)) {
      return 99;
    }
    return 143;
  }
  
  protected PhotoOtherData a()
  {
    return new PhotoPreviewCustomizationDefault.1(this);
  }
  
  public Class a()
  {
    return NewPhotoListActivity.class;
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources();
    a().jdField_a_of_type_Int = ((Resources)localObject).getDisplayMetrics().widthPixels;
    a().jdField_b_of_type_Int = ((Resources)localObject).getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView = ((HorizontalListView)a().jdField_b_of_type_AndroidViewView.findViewById(2131367036));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListDivider = a().jdField_b_of_type_AndroidViewView.findViewById(2131367034);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoAdapter = new NewPhotoSelectedThumbAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoAdapter);
    }
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListDivider != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListDivider.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.m)
    {
      if (a().jdField_a_of_type_AndroidViewView != null) {
        a().jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (a().jdField_b_of_type_AndroidViewView != null) {
        a().jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    if ((a().jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.h) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.size() == 0))
    {
      a().jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      a().jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(a());
      a().jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new PhotoPreviewCustomizationDefault.2(this));
      a().jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("闪照");
      a().jdField_b_of_type_AndroidWidgetTextView.setContentDescription("闪照");
    }
    if (a().jdField_b_of_type_AndroidWidgetCheckBox != null)
    {
      a().jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(a());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Boolean) {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
      } else {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
    }
    if (a().jdField_c_of_type_AndroidWidgetTextView != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Boolean) {
        a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      } else {
        a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    if (a().jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean) {
        a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      } else {
        a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new PhotoPreviewCustomizationDefault.3(this));
    }
    if (a().jdField_a_of_type_AndroidWidgetButton != null) {
      a().jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new PhotoPreviewCustomizationDefault.4(this));
    }
    b();
    if ((a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode))) {
      a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
    }
    if (a().jdField_b_of_type_AndroidWidgetCheckBox != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)) {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 1001) {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
    }
    if ((a().jdField_c_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode))) {
      a().jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (a().jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)) {
        a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 1001) {
        a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    e();
    if (a().jdField_a_of_type_AndroidWidgetTextView != null)
    {
      float f = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDisplayMetrics().density;
      localObject = a().jdField_a_of_type_AndroidWidgetTextView;
      int i = (int)(f * 10.0F + 0.5F);
      BaseAIOUtils.a((View)localObject, i, i, i, i);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onItemSelected position=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    super.a(paramInt);
    Object localObject = a().getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
    {
      StringBuilder localStringBuilder;
      if (((RichMediaBrowserInfo)localObject).baseData.getType() == 100)
      {
        localObject = a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("照片");
        localStringBuilder.append(paramInt);
        ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
        return;
      }
      if (((RichMediaBrowserInfo)localObject).baseData.getType() == 101)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup.dismiss();
        }
        localObject = a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("视频");
        localStringBuilder.append(paramInt);
        ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_ORIGIN", false) ^ true;
      if (!bool) {
        return;
      }
      String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (str == null) {
        return;
      }
      ThreadManager.excute(new PhotoPreviewCustomizationDefault.5(this, str), 64, null, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onActivityResultForMultiEdit hasEdit:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", picPath:");
        ((StringBuilder)localObject).append(str);
        QLog.i("QQAlbum", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramIntent.getStringExtra("key_multi_edit_source_path");
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject);
      if (paramInt1 >= 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_JavaUtilHashMap.containsValue(localObject)) {
          paramIntent = ReplacePhotoDataUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_JavaUtilHashMap, (String)localObject);
        } else {
          paramIntent = (Intent)localObject;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_JavaUtilHashMap.put(paramIntent, str);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.add(paramInt1, str);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1 + 1);
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(localObject);
        if (paramInt2 >= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramInt2, str);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(paramInt2 + 1);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoAdapter.notifyDataSetChanged();
        paramIntent = new RichMediaBrowserInfo();
        localObject = new PreviewPictureData();
        ((PreviewPictureData)localObject).filePath = str;
        paramIntent.baseData = ((RichMediaBaseData)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a.updateItem(paramIntent, paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a.setSelectedIndex(paramInt1);
        a().notifyDataSetChanged();
        a().scrollToCurrentPosition();
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject;
    if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaLangString == null)
    {
      localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      if (localObject != null) {
        ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaLangString = ((AppRuntime)localObject).getAccount();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.o = paramIntent.getBooleanExtra("PhotoConst.USE_URL_PATH", false);
    super.a(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.j = MobileQQ.getContext().getSharedPreferences(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.h = paramIntent.getBooleanExtra("showFlashPic", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Int = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap"));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mCanUseURL:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.o);
      ((StringBuilder)localObject).append(" mSelectedSendParams size:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.size());
      QLog.d("aioSendPhotos", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", -1L);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    }
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Int = paramIntent.getIntExtra("key_pic_to_edit_from", 0);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    int j = 0;
    while (i < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(i);
      if (!ImageManager.isNetworkUrl((String)localObject))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject) == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject);
          if (localObject != null)
          {
            SendVideoInfo localSendVideoInfo = new SendVideoInfo();
            localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
            localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
            localHashMap.put(Integer.valueOf(j), localSendVideoInfo);
          }
        }
        j += 1;
      }
      i += 1;
    }
    try
    {
      if (localHashMap.isEmpty()) {
        break label168;
      }
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    catch (Exception localException)
    {
      label153:
      label168:
      break label153;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "put extra Exception");
    }
    if (paramBoolean)
    {
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, paramIntent, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.setResult(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.finish();
      return;
    }
    ((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, paramIntent, paramArrayList, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Boolean);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources();
    int i = a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(i))) {
      c(i);
    } else {
      b(i);
    }
    LpReportInfo_pf00064.allReport(603, 2);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    int i = a().a();
    if ((i != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size() > i))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData;
      paramView.jdField_a_of_type_JavaLangString = ((String)paramView.jdField_a_of_type_JavaUtilArrayList.get(i));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString != null)
      {
        ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean)
        {
          paramView = ((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).toEditPicActivityIntent(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString, paramInt2, paramBundle);
          paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) {
            paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Int);
          }
          if (paramInt1 == -1) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.startActivity(paramView);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.startActivityForResult(paramView, paramInt1);
          }
          paramView = a().jdField_a_of_type_AndroidWidgetTextView;
          paramInt1 = 0;
          if (paramView != null) {
            a().jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
          if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
          {
            paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
            if (paramView != null) {
              ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
            }
          }
          if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Int > 0))
          {
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Int;
            paramView = new StringBuilder();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
              paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
            }
            paramView.append(paramInt1);
            paramView.append("");
            ReportController.b(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramView.toString(), "", "", "");
          }
        }
        LpReportInfo_pf00064.allReport(603, 4, 1);
      }
    }
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (a().jdField_a_of_type_AndroidWidgetCheckBox != null)
      {
        a().jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean ^ true);
        a().jdField_b_of_type_AndroidWidgetTextView.setTextColor(2147483647);
      }
      if (QQAlbumUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap, true, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap) > 0)
      {
        paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity;
        QQToast.a(paramCompoundButton, paramCompoundButton.getResources().getString(2131694867), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDimensionPixelSize(2131299168));
        ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 0;
        a().jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(PhotoConst.Menu.jdField_e_of_type_Int));
        a().jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.isEmpty())
      {
        int j = a().a();
        if (j < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size())
        {
          long l = new File((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(j)).length();
          int i;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(j)) == 1) {
            i = 1;
          } else {
            i = 0;
          }
          if ((i == 0) && (l > ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit()))
          {
            paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity;
            QQToast.a(paramCompoundButton, paramCompoundButton.getResources().getString(2131694867), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDimensionPixelSize(2131299168));
            ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 0;
            a().jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(PhotoConst.Menu.jdField_e_of_type_Int));
            a().jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
            return;
          }
          a().a("", 1);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(j));
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(j));
          a().jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
          ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 2;
          a(a().jdField_c_of_type_AndroidWidgetTextView);
          b();
          paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
          if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
          {
            paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
            if (paramCompoundButton != null) {
              ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
            }
          }
        }
      }
      else
      {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
        ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 2;
        a(a().jdField_c_of_type_AndroidWidgetTextView);
        paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
        if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
        {
          paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          if (paramCompoundButton != null) {
            ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          }
        }
      }
    }
    else
    {
      if (a().jdField_b_of_type_AndroidWidgetCheckBox != null) {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      if (a().jdField_c_of_type_AndroidWidgetTextView != null)
      {
        ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 0;
        a().jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(PhotoConst.Menu.jdField_e_of_type_Int));
      }
      if (a().jdField_b_of_type_AndroidWidgetTextView != null) {
        a().jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
    }
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if ((!QAlbumUtil.isNetUrl((String)localObject3)) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject3) == 1)) {
        paramTextView.setText(((Resources)localObject1).getString(PhotoConst.Menu.jdField_e_of_type_Int));
      }
    }
    int i = QQAlbumUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap, false, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    localObject2 = QQAlbumUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, i);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() != 0) && (!((String)localObject2).equals("0")))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((Resources)localObject1).getString(PhotoConst.Menu.jdField_e_of_type_Int));
      ((StringBuilder)localObject3).append("(共");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(")");
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject1 = ((Resources)localObject1).getString(PhotoConst.Menu.jdField_e_of_type_Int);
    }
    paramTextView.setText((CharSequence)localObject1);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Boolean) {
      localObject = ((Resources)localObject).getString(2131694885);
    } else {
      localObject = ((Resources)localObject).getString(2131694839);
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode))
      {
        if (a().jdField_a_of_type_AndroidWidgetButton != null)
        {
          a().jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          Button localButton = a().jdField_a_of_type_AndroidWidgetButton;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("(");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
          localStringBuilder.append(")");
          localButton.setText(localStringBuilder.toString());
        }
        f();
      }
      else if (a().jdField_a_of_type_AndroidWidgetButton != null)
      {
        a().jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        a().jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      }
    }
    else
    {
      if (a().jdField_a_of_type_AndroidWidgetButton != null) {
        a().jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      }
      if (a().jdField_b_of_type_AndroidWidgetCheckBox != null)
      {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
        localObject = a().jdField_b_of_type_AndroidWidgetCheckBox;
        if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((CheckBox)localObject).setChecked(bool1);
        a().jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(a());
      }
      if ((a().jdField_c_of_type_AndroidWidgetTextView != null) && (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2)) {
        a().jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16734752);
      }
      f();
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(a().a()));
    if (a().jdField_a_of_type_AndroidWidgetTextView != null) {
      if ((a().a() != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size() > a().a()))
      {
        int j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(a().a())) != 1) {
          j = 1;
        } else {
          j = 0;
        }
        boolean bool2 = QAlbumUtil.isNetUrl((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(a().a()));
        if (((i == 0) || (bool1)) && (j != 0) && (!bool2)) {
          a().jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        } else {
          a().jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        }
      }
      else
      {
        a().jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoAdapter != null) {
      if (a())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView.getVisibility() == 4))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListDivider.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoAdapter.notifyDataSetChanged();
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListDivider.setVisibility(4);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoListView.setVisibility(4);
      }
    }
    if (a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)
    {
      if ((!bool1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
      {
        a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(true);
        return;
      }
      a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(false);
    }
  }
  
  protected void b(int paramInt)
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Long >= 700L)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, a().a(), 1000).a();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData;
        ((PhotoPreviewData)localObject1).jdField_a_of_type_Long = l;
        if (((PhotoPreviewData)localObject1).l) {
          ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      return;
    }
    if (paramInt != -1)
    {
      localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) && (c())) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (BaseImageUtil.b((String)localObject1)) && (FileUtils.getFileSizes((String)localObject1) > 3145728L))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, "图片文件过大", 0).a();
        a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localObject1);
      Object localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap != null)
      {
        localObject2 = (PhotoSendParams)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap != null)
      {
        localObject2 = (PicInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap.get(localObject1);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(paramInt));
      a().a((String)localObject1);
    }
    b();
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Int == 103) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList != null)) {}
    try
    {
      Object localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        MQLruCache localMQLruCache = GlobalImageCache.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("#short_video_camera_preview_cache");
        localObject = localMQLruCache.remove(localStringBuilder.toString());
        if ((localObject instanceof Bitmap))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "recycle short video preview cache");
          }
          localObject = (Bitmap)localObject;
          if (!((Bitmap)localObject).isRecycled()) {
            ((Bitmap)localObject).recycle();
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label117:
      break label117;
    }
    super.c();
  }
  
  protected void c(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.indexOf(Integer.valueOf(paramInt));
    if (i >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(i);
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        }
      }
    }
    b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.size() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.k = false;
    }
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public void d(int paramInt)
  {
    a().jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  protected void e()
  {
    float f2 = 16.0F / FontSettingManager.getFontLevel();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDisplayMetrics().densityDpi;
    int j = 0;
    if ((i >= 400) && (Build.VERSION.SDK_INT > 21)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((f2 < 1.0F) || (i != 0))
    {
      float f1 = f2;
      if (i != 0) {
        f1 = f2 * 0.7F;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("need scale,reqWidth:");
        ((StringBuilder)localObject).append(a().jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" scale:");
        ((StringBuilder)localObject).append(f1);
        QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
      }
      if (a().jdField_a_of_type_AndroidViewViewGroup != null) {
        while (j < a().jdField_a_of_type_AndroidViewViewGroup.getChildCount())
        {
          localObject = a().jdField_a_of_type_AndroidViewViewGroup.getChildAt(j);
          ((View)localObject).setScaleX(f1);
          ((View)localObject).setScaleY(f1);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
          if (j == a().jdField_a_of_type_AndroidViewViewGroup.getChildCount() - 1)
          {
            localMarginLayoutParams.rightMargin = ((int)(localMarginLayoutParams.rightMargin * f1));
          }
          else
          {
            localMarginLayoutParams.leftMargin = ((int)(localMarginLayoutParams.leftMargin * f1));
            if ((i != 0) && (f1 < 1.0F)) {
              localMarginLayoutParams.leftMargin = ((int)(localMarginLayoutParams.leftMargin * f1));
            }
          }
          ((View)localObject).setLayoutParams(localMarginLayoutParams);
          j += 1;
        }
      }
    }
  }
  
  public void f()
  {
    int i = ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 2) {
        return;
      }
      if (a().jdField_c_of_type_AndroidWidgetTextView != null) {
        a(a().jdField_c_of_type_AndroidWidgetTextView);
      }
      if (a().jdField_b_of_type_AndroidWidgetCheckBox != null) {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
    }
    else
    {
      if (a().jdField_c_of_type_AndroidWidgetTextView != null) {
        a().jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(PhotoConst.Menu.jdField_e_of_type_Int));
      }
      if (a().jdField_b_of_type_AndroidWidgetCheckBox != null) {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
    }
  }
  
  public void g()
  {
    Intent localIntent1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
    localIntent1.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Int);
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaLangString))
    {
      localIntent1.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, NewPhotoListActivity.class);
      localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)
      {
        localIntent1.removeExtra("PhotoConst.PHOTO_PATHS");
      }
      else
      {
        localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
        localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_JavaUtilHashMap);
      }
      localIntent1.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap);
      localIntent1.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.startActivity(localIntent1);
    }
    else if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaLangString))
    {
      Intent localIntent2 = new Intent();
      localIntent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      localIntent2.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap);
      localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
      localIntent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.setResult(-1, localIntent2);
    }
    if (localIntent1.getBooleanExtra("keep_selected_status_after_finish", false))
    {
      localIntent1 = new Intent();
      localIntent1.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      localIntent1.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex);
      localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
      localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_JavaUtilHashMap);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.setResult(-1, localIntent1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.finish();
  }
  
  protected void h()
  {
    if ((a().jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaLangString)))) {
      a().jdField_a_of_type_AndroidWidgetTextView.performClick();
    }
    a().a();
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Boolean) {
      a().jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
    a(localIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.containNetImage(), a().a());
  }
  
  public void i()
  {
    super.i();
    QQLiveImage.onForeground(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
    SmallScreenUtils.a(MobileQQ.getContext(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(MobileQQ.getContext(), false);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(MobileQQ.getContext(), 2, false);
    if (a().jdField_a_of_type_AndroidWidgetTextView != null) {
      a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup.dismiss();
    }
  }
  
  public void k()
  {
    super.k();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10000)
    {
      a(paramInt1, paramInt2, paramIntent);
      return;
    }
    QQAlbumUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_Boolean, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
 * JD-Core Version:    0.7.0.1
 */