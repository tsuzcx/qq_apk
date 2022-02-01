package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController.SlideShowActionListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewAdapter;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.ThrowablesUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class PhotoPreviewLogicDefault
  extends PhotoPreviewLogicBase<NewPhotoPreviewActivity, PhotoOtherData>
  implements SlideShowViewController.SlideShowActionListener, PhotoPreviewLogic.IonCheckedChangedCallback
{
  public PhotoPreviewData a;
  PhotoPreviewLogicDefault.IslideShowActionListenerCallback a;
  
  public PhotoPreviewLogicDefault(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewLogicDefault$IslideShowActionListenerCallback = null;
    this.mOnCheckedChangedCallback = this;
    this.mPhotoPreviewData = new PhotoPreviewData();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData = ((PhotoPreviewData)this.mPhotoPreviewData);
  }
  
  private void e()
  {
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Boolean = false;
    LinearLayout localLinearLayout = (LinearLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131363738);
    Object localObject = (RelativeLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131363736);
    if (((PhotoOtherData)this.mOtherCommonData).a()) {
      ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Boolean = LiuHaiUtils.a(localLinearLayout, (View)localObject, 0);
    }
    while (localLinearLayout == null) {
      return;
    }
    localObject = localLinearLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = LiuHaiUtils.jdField_a_of_type_Int;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.setVisibility(0);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Boolean = true;
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Int == 1) {
      return 141;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Int == 3)) {
      return 143;
    }
    return 99;
  }
  
  protected PhotoOtherData a()
  {
    return new PhotoPreviewLogicDefault.1(this);
  }
  
  protected PreviewAdapter a()
  {
    return new PreviewAdapter(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewLogicDefault$IslideShowActionListenerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewLogicDefault$IslideShowActionListenerCallback.ak_();
    }
    String str = "";
    if (((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() != -1)
    {
      str = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion());
      this.mPhotoCommonData.selectedPhotoList.add(str);
      this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
      if (((PhotoOtherData)this.mOtherCommonData).a())
      {
        if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
          this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      }
    }
    ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(str);
    updateButton();
    b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
  }
  
  protected void a(int paramInt)
  {
    Object localObject1 = PresendPicMgr.a(null);
    if (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.lastTimeShowToast >= 700L)
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getExceedMaxSelectNumStr(), 1000).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.titleBarHeight);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.lastTimeShowToast = l;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l) {
          ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
    }
    Object localObject2;
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      return;
      if (paramInt == -1) {
        break;
      }
      localObject2 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt);
      localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject2);
    } while ((this.mPhotoCommonData.currentQualityType == 2) && (b()));
    if ((((PhotoOtherData)this.mOtherCommonData).a()) && (!QQStoryFlowCallback.a(this.mActivity, localLocalMediaInfo)))
    {
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return;
    }
    if ((((NewPhotoPreviewActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (Utils.a((String)localObject2)) && (FileUtils.a((String)localObject2) > 3145728L))
    {
      QQToast.a(this.mActivity, "图片文件过大", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.titleBarHeight);
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return;
    }
    if ((localObject1 != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt)) != 1)) {
      ((PresendPicMgr)localObject1).a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_Int);
    }
    localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt);
    this.mPhotoCommonData.selectedPhotoList.add(localObject1);
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
    this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(paramInt));
    if (((PhotoOtherData)this.mOtherCommonData).a())
    {
      if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
        this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
      }
      localObject2 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(localObject1, localObject2);
    }
    ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber((String)localObject1);
    updateButton();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < this.mPhotoCommonData.selectedPhotoList.size()) && (paramInt2 >= 0) && (paramInt2 < this.mPhotoCommonData.selectedPhotoList.size()))
    {
      Collections.swap(this.mPhotoCommonData.selectedPhotoList, paramInt1, paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController.a();
        if (!TextUtils.isEmpty(str)) {
          ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(str);
        }
      }
      SlideShowPhotoListManager.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      if (!paramIntent.getBooleanExtra("PhotoConst.SEND_ORIGIN", false)) {
        bool = true;
      }
      if (bool) {
        break label32;
      }
    }
    label32:
    String str2;
    String str1;
    do
    {
      do
      {
        return;
        str2 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      } while (str2 == null);
      ThreadManager.excute(new PhotoPreviewLogicDefault.9(this, str2), 64, null, true);
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "onActivityResultForMultiEdit hasEdit:" + bool + ", picPath:" + str2);
      }
      str1 = paramIntent.getStringExtra("key_multi_edit_source_path");
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.indexOf(str1);
    } while (paramInt1 < 0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap.containsValue(str1)) {}
    for (paramIntent = ReplacePhotoDataUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap, str1);; paramIntent = str1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap.put(paramIntent, str2);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.add(paramInt1, str2);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.remove(paramInt1 + 1);
      paramInt2 = this.mPhotoCommonData.selectedPhotoList.indexOf(str1);
      if (paramInt2 >= 0)
      {
        this.mPhotoCommonData.selectedPhotoList.add(paramInt2, str2);
        this.mPhotoCommonData.selectedPhotoList.remove(paramInt2 + 1);
      }
      ((NewPhotoPreviewActivity)this.mActivity).adapter.notifyDataSetChanged();
      ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoSelectedThumbAdapter.notifyDataSetChanged();
      ((NewPhotoPreviewActivity)this.mActivity).gallery.setSelection(paramInt1);
      paramIntent = PresendPicMgr.a();
      if (paramIntent == null) {
        break;
      }
      paramIntent.b(str1, 1003);
      paramIntent.a(str2, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_Int);
      return;
    }
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    i2 = 0;
    i = -1;
    int j;
    int k;
    int i1;
    try
    {
      m = PhotoUtils.getTypeforReportSpcialDiscuss((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      HashMap localHashMap = new HashMap();
      j = 0;
      i = 0;
      int n = 0;
      k = 0;
      for (;;)
      {
        if (n >= paramArrayList.size()) {
          break label324;
        }
        localObject1 = (String)paramArrayList.get(n);
        if (!ImageManager.isNetworkUrl((String)localObject1)) {
          break;
        }
        i1 = k;
        k = i;
        i = i1;
        n += 1;
        i1 = k;
        k = i;
        i = i1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        m = i;
        if (QLog.isColorLevel())
        {
          QLog.e("PhotoPreviewActivity", 2, "submit", localException1);
          m = i;
        }
      }
    }
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject1) == 1)
    {
      localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
      localObject2 = new SendVideoActivity.SendVideoInfo();
      i += 1;
      if (((((LocalMediaInfo)localObject1).mDuration > 1200000L) || (((LocalMediaInfo)localObject1).fileSize > 1048576000L)) && (a()))
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131719359), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299166));
        ((NewPhotoPreviewActivity)this.mActivity).finish();
      }
    }
    label324:
    do
    {
      return;
      ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
      ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
      localException1.put(Integer.valueOf(k), localObject2);
      for (;;)
      {
        i1 = k + 1;
        k = i;
        i = i1;
        break;
        j += 1;
      }
      localObject1 = String.valueOf(j);
      localObject2 = String.valueOf(i);
      try
      {
        paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
        if (localException1.isEmpty()) {
          break label710;
        }
        paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localException1);
        i = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          boolean bool;
          String str;
          i = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("PhotoPreviewActivity", 2, "put extra Exception");
            i = i2;
            continue;
            bool = false;
            continue;
            if (paramBoolean)
            {
              PhotoUtils.sendPhoto(this.mActivity, paramIntent, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap, this.mPhotoCommonData.currentQualityType, true);
              ((NewPhotoPreviewActivity)this.mActivity).setResult(-1);
              ((NewPhotoPreviewActivity)this.mActivity).finish();
            }
            for (;;)
            {
              ReportController.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", m, 0, (String)localObject1, (String)localObject2, "", "");
              return;
              PhotoUtils.sendPhoto(this.mActivity, paramIntent, paramArrayList, this.mPhotoCommonData.currentQualityType, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Boolean);
            }
            i = 0;
          }
        }
      }
      if ((ShortVideoBusiManager.b == 0L) || (System.currentTimeMillis() - ShortVideoBusiManager.b >= 300000L)) {
        break label601;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + ShortVideoBusiManager.b);
      }
      if ((!NetworkUtil.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0) || (!a())) {
        break label607;
      }
      str = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131719019);
      paramIntent = new PhotoPreviewLogicDefault.5(this, paramBoolean, paramIntent, paramArrayList, m, (String)localObject1, (String)localObject2);
      if (FreeWifiHelper.a(this.mActivity, 4, new PhotoPreviewLogicDefault.6(this, paramIntent))) {
        DialogUtil.a(this.mActivity, 232, null, str, new PhotoPreviewLogicDefault.7(this, paramIntent), new PhotoPreviewLogicDefault.8(this)).show();
      }
    } while (!QLog.isColorLevel());
    QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getResources();
    Object localObject2 = this.mPhotoCommonData.selectedPhotoList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) == 1)) {
        paramTextView.setText(((Resources)localObject1).getString(2131694882));
      }
    }
    int i = AlbumUtil.a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, false, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap, this.mPhotoCommonData.selectedMediaInfoHashMap);
    localObject2 = PhotoUtils.getRawPhotoSize(this.mActivity, i);
    if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) || (((String)localObject2).equals("0"))) {}
    for (localObject1 = ((Resources)localObject1).getString(2131694882);; localObject1 = ((Resources)localObject1).getString(2131694882) + "(共" + (String)localObject2 + ")")
    {
      paramTextView.setText((CharSequence)localObject1);
      return;
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    if (paramSlideItemInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewLogicDefault$IslideShowActionListenerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewLogicDefault$IslideShowActionListenerCallback.a_(paramSlideItemInfo);
    }
    int i = 0;
    label24:
    if (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.size()) {
      if (!((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(i)).equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i))) {
          break;
        }
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
        int j = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(i));
        if (j >= 0)
        {
          this.mPhotoCommonData.selectedPhotoList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(i));
          this.mPhotoCommonData.selectedIndex.remove(j);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(i));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(i));
          }
        }
        updateButton();
        b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(i));
        return;
        i += 1;
        break label24;
      }
      this.mPhotoCommonData.selectedPhotoList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      updateButton();
      ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      b(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      return;
      i = -1;
    }
  }
  
  public void a(String paramString)
  {
    int j = 0;
    if ((((PhotoOtherData)this.mOtherCommonData).a()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.addAll(this.mPhotoCommonData.selectedPhotoList);
      this.mPhotoCommonData.selectedIndex.clear();
      i = 0;
      while (i < this.mPhotoCommonData.selectedPhotoList.size())
      {
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(i));
        i += 1;
      }
      ((NewPhotoPreviewActivity)this.mActivity).adapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Boolean = true;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.indexOf(paramString);
    if (i < 0) {
      i = j;
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.mActivity).gallery.setSelection(i);
      return;
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    int k = 0;
    float f = 16.0F / FontSettingManager.getFontLevel();
    int i;
    if ((((NewPhotoPreviewActivity)this.mActivity).getResources().getDisplayMetrics().densityDpi < 400) || (Build.VERSION.SDK_INT <= 21))
    {
      i = 1;
      if ((f >= 1.0F) && (i == 0)) {
        break label269;
      }
      if (i == 0) {
        break label270;
      }
      f = 0.7F * f;
    }
    label269:
    label270:
    for (;;)
    {
      int j = k;
      if (QLog.isColorLevel())
      {
        QLog.d("PhotoPreviewActivity", 2, "need scale,reqWidth:" + ((NewPhotoPreviewActivity)this.mActivity).reqWidth + " scale:" + f);
        j = k;
      }
      label121:
      if (j < ((NewPhotoPreviewActivity)this.mActivity).bottomBar.getChildCount())
      {
        View localView = ((NewPhotoPreviewActivity)this.mActivity).bottomBar.getChildAt(j);
        localView.setScaleX(f);
        localView.setScaleY(f);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        if (j == ((NewPhotoPreviewActivity)this.mActivity).bottomBar.getChildCount() - 1) {
          localLayoutParams.rightMargin = ((int)(localLayoutParams.rightMargin * f));
        }
        for (;;)
        {
          localView.setLayoutParams(localLayoutParams);
          j += 1;
          break label121;
          i = 0;
          break;
          localLayoutParams.leftMargin = ((int)(localLayoutParams.leftMargin * f));
          if ((i != 0) && (f < 1.0F)) {
            localLayoutParams.leftMargin = ((int)(localLayoutParams.leftMargin * f));
          }
        }
      }
      return;
    }
  }
  
  protected void b(int paramInt)
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
    int i = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(paramInt));
    if (i >= 0)
    {
      this.mPhotoCommonData.selectedIndex.remove(i);
      if (paramInt != -1)
      {
        this.mPhotoCommonData.selectedPhotoList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt));
        }
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt), 1014);
        }
      }
    }
    updateButton();
    if ((this.mPhotoCommonData.selectedIndex.size() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.k = false;
    }
  }
  
  void b(String paramString)
  {
    if (((PhotoOtherData)this.mOtherCommonData).a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController = new SlideShowViewController(this.mActivity, this);
      }
      SlideShowPhotoListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController);
      SlideShowPhotoListManager.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
      SlideShowPhotoListManager.a().a(this.mActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController.a(this.mPhotoCommonData.selectedPhotoList.indexOf(paramString));
      if (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Boolean)
      {
        paramString = (RelativeLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131379413);
        ((ViewGroup)paramString.getParent()).removeView(paramString);
        Object localObject = paramString.getLayoutParams();
        localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ViewUtils.a(8.0F);
        ((RelativeLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131363736)).addView(paramString, (ViewGroup.LayoutParams)localObject);
      }
      ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(4);
    }
  }
  
  protected boolean b()
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if ((((PhotoOtherData)this.mOtherCommonData).a()) && (i != -1) && (new File((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(i)).length() > PicUploadFileSizeLimit.getLimitC2C()))
    {
      QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694878), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299166));
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    switch (this.mPhotoCommonData.currentQualityType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694882));
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
      return;
    }
    a(((NewPhotoPreviewActivity)this.mActivity).qualityTv);
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
  }
  
  public void c(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(paramInt);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) {
      ((NewPhotoPreviewActivity)this.mActivity).getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaLangString)))) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.performClick();
    }
    ArrayList localArrayList = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    StatisticConstants.a(localArrayList.size(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.totalPicCount);
    StatisticConstants.a(localIntent, localArrayList.size(), this.mPhotoCommonData.currentQualityType);
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (this.mPhotoCommonData.currentQualityType == 2)
    {
      if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) && (localArrayList.size() == 1) && (FileUtils.a((String)localArrayList.get(0)) > PicUploadFileSizeLimit.getLimitC2C()))
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694878), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299166));
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
        return;
      }
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1010);
        localPresendPicMgr.a();
      }
      ReportController.b(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Boolean) {
        ((NewPhotoPreviewActivity)this.mActivity).topBar.setVisibility(4);
      }
      NewFlowCameraReporter.a(localArrayList);
      if (((PhotoOtherData)this.mOtherCommonData).a()) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l)
      {
        localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        localIntent.putExtra("session_info", localIntent.getParcelableExtra("session_info"));
      }
      a(localIntent, this.mPhotoCommonData.containNetImage(), ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
      return;
      if ((localPresendPicMgr != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.k) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false)) && (((PhotoOtherData)this.mOtherCommonData).a(this.mPhotoCommonData))) {
        localPresendPicMgr.a(localIntent);
      }
    }
  }
  
  void doOnDestroy()
  {
    if (((PhotoOtherData)this.mOtherCommonData).a()) {
      SlideShowPhotoListManager.a().f();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.cameraType == 103) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths != null)) {}
    try
    {
      Object localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = GlobalImageCache.a.remove((String)localObject + "#short_video_camera_preview_cache");
        if ((localObject instanceof Bitmap))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoPreviewActivity", 2, "recycle short video preview cache");
          }
          CameraUtils.a((Bitmap)localObject);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label121:
      break label121;
    }
    super.doOnDestroy();
  }
  
  void doOnResume()
  {
    super.doOnResume();
    QQLiveImage.onForeground(this.mActivity);
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false);
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, false);
    if (((NewPhotoPreviewActivity)this.mActivity).magicStickBtn != null) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(true);
    }
    if (((PhotoOtherData)this.mOtherCommonData).a())
    {
      SlideShowPhotoListManager.a().c();
      SlideShowPhotoListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController);
      SlideShowPhotoListManager.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
  }
  
  public void flashPicCheckedChanged(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i = paramBoolean;
    int i;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.k = true;
      Object localObject = ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((CheckBox)localObject).setChecked(paramBoolean);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(2147483647);
        if ((this.mPhotoCommonData.selectedPhotoList.isEmpty()) && (((NewPhotoPreviewActivity)this.mActivity).gallery.getFirstVisiblePosition() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.size()))
        {
          ((NewPhotoPreviewActivity)this.mActivity).selectLayout.performClick();
          updateButton();
        }
        if ((((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.size() > ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()))
        {
          if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion())) == 1) {
            break label433;
          }
          i = 1;
          label191:
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.j) && (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null) && (i != 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.j = false;
            BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
            localObject = new TextView(this.mActivity);
            i = AIOUtils.a(10.0F, ((NewPhotoPreviewActivity)this.mActivity).getResources());
            ((TextView)localObject).setPadding(i, 0, i, 0);
            ((TextView)localObject).setTextColor(-1);
            ((TextView)localObject).setText("选中的图片每人只能查看一次");
            ((TextView)localObject).setTextSize(14.0F);
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a((View)localObject);
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(false);
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(((NewPhotoPreviewActivity)this.mActivity).flashTv);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int != 0) {
          break label438;
        }
        ReportController.b(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
      }
    }
    label433:
    label438:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        i = 0;
        break label191;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 3000)
        {
          ReportController.b(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int != 1);
      ReportController.b(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
      return;
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(-1);
    } while (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
  }
  
  protected void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.canUseURL = paramIntent.getBooleanExtra("PhotoConst.USE_URL_PATH", false);
    super.initData(paramIntent);
    NewFlowCameraReporter.a("preview create");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.j = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.cameraType = paramIntent.getIntExtra("camera_type", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.h = paramIntent.getBooleanExtra("showFlashPic", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Int = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Int = paramIntent.getIntExtra("camera_front_back", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_Int = paramIntent.getIntExtra("camera_filter_id", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_g_of_type_Int = paramIntent.getIntExtra("camera_capture_method", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap"));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap = new HashMap();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap);
    }
    if (QLog.isColorLevel()) {
      QLog.d("aioSendPhotos", 2, "mCanUseURL:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.canUseURL + " mSelectedSendParams size:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.size());
    }
    this.mPhotoCommonData.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    }
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.from)) {
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.m = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.m)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
      if (localPresendPicMgr != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "Photo+ send pic,cancel presend!");
        }
        localPresendPicMgr.a(1003);
      }
      PhotoUtils.sendPhoto(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Int = paramIntent.getIntExtra("key_pic_to_edit_from", 0);
  }
  
  protected void initUI()
  {
    e();
    if (Build.VERSION.SDK_INT == 19)
    {
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100 | 0x1000);
    }
    super.initUI();
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getResources();
    ((NewPhotoPreviewActivity)this.mActivity).reqWidth = ((Resources)localObject).getDisplayMetrics().widthPixels;
    ((NewPhotoPreviewActivity)this.mActivity).reqHeight = ((Resources)localObject).getDisplayMetrics().heightPixels;
    ((NewPhotoPreviewActivity)this.mActivity).mNeedStatusTrans = true;
    ((NewPhotoPreviewActivity)this.mActivity).mActNeedImmersive = false;
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131367252));
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_AndroidViewView = ((NewPhotoPreviewActivity)this.mActivity).findViewById(2131367250);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoSelectedThumbAdapter = new NewPhotoSelectedThumbAdapter((NewPhotoPreviewActivity)this.mActivity);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoSelectedThumbAdapter.a(this.mPhotoCommonData.selectedPhotoList);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoSelectedThumbAdapter);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoSelectedThumbAdapter);
    if (needShowMultiPhoto())
    {
      ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.showBar)
    {
      ((NewPhotoPreviewActivity)this.mActivity).topBar.setVisibility(0);
      if (((PhotoOtherData)this.mOtherCommonData).a()) {
        ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(4);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.h) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.size() == 0))
      {
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setOnCheckedChangeListener(this.mActivity);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setOnClickListener(new PhotoPreviewLogicDefault.2(this));
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setContentDescription("闪照");
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setContentDescription("闪照");
      }
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(this.mActivity);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Boolean) {
        break label885;
      }
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(0);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(0);
      label516:
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean) {
        break label918;
      }
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setOnClickListener(new PhotoPreviewLogicDefault.3(this));
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new PhotoPreviewLogicDefault.4(this));
      updateButton();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.isSingleMode))
      {
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 1001)
      {
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
      b();
      if (((PhotoOtherData)this.mOtherCommonData).a())
      {
        ((NewPhotoPreviewActivity)this.mActivity).backToPhotoListBtn.setText("");
        ((NewPhotoPreviewActivity)this.mActivity).titleView.setVisibility(8);
        if (((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() != -1) {
          b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
        }
      }
      float f = ((NewPhotoPreviewActivity)this.mActivity).getResources().getDisplayMetrics().density;
      AIOUtils.a(((NewPhotoPreviewActivity)this.mActivity).magicStickBtn, (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(f * 10.0F + 0.5F));
      return;
      ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(0);
      break;
      label885:
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      break label516;
      label918:
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
    }
  }
  
  public boolean needShowMultiPhoto()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 24747)
    {
      SlideShowPhotoListManager.a().a(paramIntent, this.mPhotoCommonData.selectedMediaInfoHashMap);
      return;
    }
    if (paramInt1 == 18001)
    {
      ((NewPhotoPreviewActivity)this.mActivity).c(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18002)
    {
      ((NewPhotoPreviewActivity)this.mActivity).b(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18003)
    {
      ((NewPhotoPreviewActivity)this.mActivity).a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 10000)
    {
      a(paramInt1, paramInt2, paramIntent);
      return;
    }
    PhotoUtils.onSendResult(this.mActivity, paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_Boolean, this.mPhotoCommonData.myUin);
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_Boolean) {
      SlideShowPhotoListManager.a().a(SlideShowPhotoListManager.a().c());
    }
    Intent localIntent1 = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    localIntent1.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Int);
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.from))
    {
      localIntent1.setClass(this.mActivity, NewPhotoListActivity.class);
      localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.isSingleMode) {
        localIntent1.removeExtra("PhotoConst.PHOTO_PATHS");
      }
    }
    for (;;)
    {
      localIntent1.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap);
      localIntent1.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap);
      ((NewPhotoPreviewActivity)this.mActivity).startActivity(localIntent1);
      label149:
      if (localIntent1.getBooleanExtra("keep_selected_status_after_finish", false))
      {
        localIntent1 = new Intent();
        localIntent1.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
        localIntent1.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
        localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
        localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap);
        ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, localIntent1);
      }
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      if (paramBoolean) {
        try
        {
          ((NewPhotoPreviewActivity)this.mActivity).overridePendingTransition(2130772043, 2130772045);
          return;
          localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
          localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap);
          continue;
          if (!"FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.from)) {
            break label149;
          }
          Intent localIntent2 = new Intent();
          localIntent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
          localIntent2.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap);
          localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
          localIntent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
          ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, localIntent2);
        }
        catch (Exception localException)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("PhotoPreviewActivity", 2, "[PhotoPreviewActivity] overridePendingTransition=" + localException);
          return;
        }
      }
    }
    AlbumUtil.anim(this.mActivity, true, false);
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, " onItemSelected position=" + paramInt);
    }
    super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = ((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt);
    int i;
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramAdapterView) == 1) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramView.setContentDescription("视频" + paramInt);
        if (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
          ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
        }
      }
      try
      {
        for (;;)
        {
          ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt)).thumbRect);
          if (((PhotoOtherData)this.mOtherCommonData).a())
          {
            if (paramAdapterView != null) {
              ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(paramAdapterView);
            }
            b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt));
          }
          return;
          i = 0;
          break;
          paramView.setContentDescription("照片" + paramInt);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoPreviewActivity", 2, ThrowablesUtils.a(paramView));
          }
        }
      }
    }
  }
  
  protected void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if ((i != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.size() > i))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(i));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString != null)
      {
        ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean)
        {
          paramView = paramIntent;
          if (paramIntent == null) {
            paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString, true, true, true, true, true, paramInt2, a(), 4, paramBundle);
          }
          paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) {
            break label365;
          }
          paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
          if (paramInt1 != -1) {
            break label383;
          }
          ((NewPhotoPreviewActivity)this.mActivity).startActivity(paramView);
          label189:
          ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(false);
          paramView = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
          if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
          {
            paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
            if (paramView != null) {
              ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
            }
          }
          if ((needShowMultiPhoto()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Int > 0))
          {
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Int;
            paramView = new StringBuilder();
            if (this.mPhotoCommonData.selectedPhotoList == null) {
              break label398;
            }
          }
        }
      }
    }
    label398:
    for (paramInt1 = this.mPhotoCommonData.selectedPhotoList.size();; paramInt1 = 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramInt1 + "", "", "", "");
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      label365:
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Int);
      break;
      label383:
      ((NewPhotoPreviewActivity)this.mActivity).startActivityForResult(paramView, paramInt1);
      break label189;
    }
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).flashPicCb;
      if (!paramBoolean)
      {
        paramBoolean = true;
        paramCompoundButton.setChecked(paramBoolean);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(2147483647);
        if (AlbumUtil.a(this.mPhotoCommonData.selectedPhotoList, ((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_Int, this.mPhotoCommonData.allMediaInfoHashMap, true, this.mPhotoCommonData.selectedMediaInfoHashMap) <= 0) {
          break label178;
        }
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694878), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299166));
        this.mPhotoCommonData.currentQualityType = 0;
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694882));
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
      }
      label178:
      do
      {
        do
        {
          do
          {
            do
            {
              int j;
              do
              {
                return;
                paramBoolean = false;
                break;
                if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
                  break label665;
                }
                j = ((NewPhotoPreviewActivity)this.mActivity).gallery.getFirstVisiblePosition();
              } while (j >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.size());
              long l = new File((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(j)).length();
              if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(j)) == 1) {}
              for (int i = 1; (i == 0) && (l > PicUploadFileSizeLimit.getLimitC2C()); i = 0)
              {
                QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694878), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299166));
                this.mPhotoCommonData.currentQualityType = 0;
                ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694882));
                ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
                return;
              }
              if ((i != 0) && (l > 104345600L))
              {
                QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131719381), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299166));
                AlbumUtil.c();
              }
              ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber("", 1);
              this.mPhotoCommonData.selectedPhotoList.add(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(j));
              this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(j));
              ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
              this.mPhotoCommonData.currentQualityType = 2;
              a(((NewPhotoPreviewActivity)this.mActivity).qualityTv);
              updateButton();
              paramCompoundButton = PresendPicMgr.a();
              if ((paramCompoundButton != null) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(j)) != 1)) {
                paramCompoundButton.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(j), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_f_of_type_Int);
              }
              paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
            } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
            paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          } while (paramCompoundButton == null);
          ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          return;
          if (AlbumUtil.a(this.mPhotoCommonData.selectedPhotoList, 104345600L, this.mPhotoCommonData.allMediaInfoHashMap, true, this.mPhotoCommonData.selectedMediaInfoHashMap) > 0)
          {
            QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131719381), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299166));
            AlbumUtil.c();
          }
          ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
          this.mPhotoCommonData.currentQualityType = 2;
          a(((NewPhotoPreviewActivity)this.mActivity).qualityTv);
          paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
        } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
        paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
      } while (paramCompoundButton == null);
      label665:
      ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
    this.mPhotoCommonData.currentQualityType = 0;
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694882));
    ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(-1);
  }
  
  protected void onSelectClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.mActivity).getResources();
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i))) {
      b(i);
    }
    for (;;)
    {
      if ((((PhotoOtherData)this.mOtherCommonData).a()) && (i != -1)) {
        b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(i));
      }
      LpReportInfo_pf00064.allReport(603, 2);
      return;
      a(i);
    }
  }
  
  protected void updateButton()
  {
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getResources();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Boolean)
    {
      localObject = ((Resources)localObject).getString(2131694896);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.customSendBtnText == null) {
        break label803;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.customSendBtnText;
    }
    label288:
    label803:
    for (;;)
    {
      int i;
      label76:
      boolean bool1;
      int j;
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0))
      {
        i = 1;
        if (i == 0) {
          break label575;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_g_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.isSingleMode)) {
          break label449;
        }
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((CharSequence)localObject);
        bool1 = this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
        if ((((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() == -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.size() <= ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion())) {
          break label740;
        }
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion())) == 1) {
          break label718;
        }
        j = 1;
        label229:
        boolean bool2 = AlbumUtil.isNetUrl((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
        if (((i != 0) && (!bool1)) || (j == 0) || (bool2)) {
          break label723;
        }
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
        if (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoSelectedThumbAdapter != null)
        {
          if (!needShowMultiPhoto()) {
            break label757;
          }
          if (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 4)
          {
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
          }
          ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoSelectedThumbAdapter.notifyDataSetChanged();
        }
      }
      for (;;)
      {
        if ((bool1) || (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum)) {
          break label788;
        }
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setActivated(true);
        return;
        if (((PhotoOtherData)this.mOtherCommonData).a())
        {
          localObject = ((Resources)localObject).getString(2131699266);
          break;
        }
        localObject = ((Resources)localObject).getString(2131694852);
        break;
        i = 0;
        break label76;
        label449:
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
        c();
        Button localButton;
        if (((PhotoOtherData)this.mOtherCommonData).a())
        {
          localButton = ((NewPhotoPreviewActivity)this.mActivity).sendBtn;
          if (this.mPhotoCommonData.selectedPhotoList.size() < 2) {
            break label570;
          }
        }
        label570:
        for (bool1 = true;; bool1 = false)
        {
          localButton.setEnabled(bool1);
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((String)localObject + "(" + this.mPhotoCommonData.selectedPhotoList.size() + ")");
          break;
        }
        label575:
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((CharSequence)localObject);
        if (((PhotoOtherData)this.mOtherCommonData).a()) {
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(false);
        }
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(null);
        localObject = ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox;
        if (this.mPhotoCommonData.currentQualityType == 2) {}
        for (bool1 = true;; bool1 = false)
        {
          ((CheckBox)localObject).setChecked(bool1);
          ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(this.mActivity);
          if (this.mPhotoCommonData.currentQualityType == 2) {
            ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(-16734752);
          }
          c();
          break;
        }
        label718:
        j = 0;
        break label229;
        label723:
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(false);
        break label288;
        label740:
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(false);
        break label288;
        label757:
        ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_AndroidViewView.setVisibility(4);
        ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      }
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setActivated(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault
 * JD-Core Version:    0.7.0.1
 */