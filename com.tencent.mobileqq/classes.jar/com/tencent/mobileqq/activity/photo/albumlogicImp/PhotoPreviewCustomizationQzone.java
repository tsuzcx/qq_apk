package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.aelight.camera.qqstory.api.IEditPicForQzone;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowActionListener;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.qqslideshow.ISlideShowController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhotoPreviewCustomizationQzone
  extends PhotoPreviewCustomizationDefault
  implements SlideShowActionListener
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationQzone";
  int jdField_a_of_type_Int = 0;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  protected boolean a;
  boolean b;
  public boolean c;
  public boolean d;
  boolean e;
  
  protected PhotoPreviewCustomizationQzone(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  private int b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    int j = 0;
    if (localObject != null) {
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size()) {
          break;
        }
        localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(j);
        k = i;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject) == 1) {
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public void a()
  {
    super.a();
    if (this.b)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).initPhotoPreviewController(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, a().jdField_b_of_type_AndroidViewView, this);
      if (a().d != null) {
        a().d.setText("");
      }
      if (a().e != null) {
        a().e.setVisibility(8);
      }
      if (a().a() != -1) {
        b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(a().a()));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.mEnableLiuHai)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)a().jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378764);
        ((ViewGroup)localRelativeLayout.getParent()).removeView(localRelativeLayout);
        Object localObject = localRelativeLayout.getLayoutParams();
        localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ViewUtils.a(8.0F);
        ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.findViewById(2131363666)).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      }
    }
    if ((a().jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Boolean)) {
      a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.b)
    {
      Object localObject2 = null;
      RichMediaBrowserInfo localRichMediaBrowserInfo = a().getItem(paramInt);
      Object localObject1 = localObject2;
      if (localRichMediaBrowserInfo != null)
      {
        localObject1 = localObject2;
        if (localRichMediaBrowserInfo.baseData != null) {
          if (localRichMediaBrowserInfo.baseData.getType() == 100)
          {
            localObject1 = ((PreviewPictureData)localRichMediaBrowserInfo.baseData).filePath;
          }
          else
          {
            localObject1 = localObject2;
            if (localRichMediaBrowserInfo.baseData.getType() == 101) {
              localObject1 = ((PreviewVideoData)localRichMediaBrowserInfo.baseData).filePath;
            }
          }
        }
      }
      if (localObject1 != null) {
        a().a((String)localObject1);
      }
      b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.c = true;
    NewFlowCameraReporter.a("preview create");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Int = paramIntent.getIntExtra("camera_type", 1);
    this.b = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    super.a(paramIntent);
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    this.c = paramIntent.getBooleanExtra("from_qzone", false);
    this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("fromQzonePhotoGroup", false);
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_SHUOSHUO", false);
    if (this.b) {
      SlideShowPhotoListManager.a().b(19);
    }
  }
  
  public void a(View paramView)
  {
    int i = a().a();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(i)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.indexOf(Integer.valueOf(i)) >= 0) && (i != -1))
      {
        localObject = this.jdField_a_of_type_JavaUtilHashMap;
        if (localObject != null) {
          ((HashMap)localObject).remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
    }
    else
    {
      if (i != -1) {
        localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(i);
      } else {
        localObject = "";
      }
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject);
      if ((this.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject) == 1) && (!AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, b(), localLocalMediaInfo, this.b)))
      {
        a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if (i != -1)
      {
        localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((this.c) || (this.b))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
          }
          localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localObject, localLocalMediaInfo);
          if (this.jdField_a_of_type_JavaUtilHashMap == null) {
            this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
          }
          if (localLocalMediaInfo != null) {
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
          }
        }
      }
    }
    super.a(paramView);
    if ((this.b) && (i != -1)) {
      b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(i));
    }
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = a().a();
    if (paramInt1 != -1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString != null)
    {
      paramView = null;
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramBundle = new Intent();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
        paramView = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_Boolean) && (AlbumUtil.getMediaType(paramView) == 1) && (this.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.c))
      {
        new HashMap(1).put("param_localmediainfo", paramView);
        paramBundle = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
        paramBundle.putExtras(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent());
        paramBundle.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramBundle.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        paramBundle.putExtra("DirectBackToQzone", true);
        paramBundle.putExtra("qzone_plugin_activity_name", "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity");
        paramBundle.putExtra("short_video_refer", getClass().getName());
        paramBundle.putExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 1);
        paramBundle.putExtra("file_send_path", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString);
        paramBundle.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
        paramBundle.putExtra("file_send_duration", paramView.mDuration);
        paramBundle.putExtra("file_width", paramView.mediaWidth);
        paramBundle.putExtra("file_height", paramView.mediaHeight);
        paramView = paramBundle;
      }
      else
      {
        paramView = paramBundle;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.c)
        {
          paramView = new HashMap(1);
          paramBundle.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) && ((LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString) != null)) {
            paramView.put("param_localmediainfo", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString));
          }
          if (this.c) {
            paramView = ((IEditPicForQzone)QRoute.api(IEditPicForQzone.class)).newPictureEditIntentWithoutPublish(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString);
          } else {
            paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString, true, true, true, true, true, 3, 99, 4, paramView);
          }
        }
      }
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.startActivity(paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.overridePendingTransition(2130772065, 2130772067);
      if (a().jdField_a_of_type_AndroidWidgetTextView != null) {
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
    }
    LpReportInfo_pf00064.allReport(603, 4, 1);
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    if (paramSlideItemInfo == null) {
      return;
    }
    b(paramSlideItemInfo);
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      if (((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(paramSlideItemInfo.b))
      {
        j = i;
        break;
      }
      i += 1;
    }
    if (j >= 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(j)))
      {
        a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.indexOf(Integer.valueOf(j));
        if (i >= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(j));
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(i);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(j));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(j));
          }
        }
        b();
        b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(j));
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(paramSlideItemInfo.b);
      b();
      a().a(paramSlideItemInfo.b);
      b(paramSlideItemInfo.b);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.b) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.clear();
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(i));
        i += 1;
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.notifyImageListChanged(localList, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_e_of_type_Boolean = true;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.browserModel.setSelectedIndex(i);
    a().scrollToCurrentPosition();
  }
  
  public View b()
  {
    View localView;
    if (this.b)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getSystemService("layout_inflater");
      localView = null;
      if (localLayoutInflater != null)
      {
        localView = localLayoutInflater.inflate(2131561734, null);
        localView.setPadding(0, 0, 0, AIOUtils.b(12.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
        return localView;
      }
    }
    else
    {
      localView = super.b();
    }
    return localView;
  }
  
  public void b()
  {
    super.b();
    Object localObject;
    if (this.b) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(2131699371);
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(2131694839);
    }
    int i = this.jdField_a_of_type_Int;
    boolean bool2 = true;
    if (i == 1) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(2131694864);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText;
    }
    boolean bool1;
    if ((a().jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0) && (this.jdField_a_of_type_Int == 1))
    {
      Button localButton = a().jdField_a_of_type_AndroidWidgetButton;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localButton.setEnabled(bool1);
      localButton = a().jdField_a_of_type_AndroidWidgetButton;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("(");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
      localStringBuilder.append(")");
      localButton.setText(localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (a().jdField_a_of_type_AndroidWidgetButton != null)
      {
        a().jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        if (this.b) {
          a().jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
      }
      if ((a().jdField_a_of_type_AndroidWidgetTextView != null) && (this.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList != null)) {
        a().jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
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
      if ((a().c != null) && (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2)) {
        a().c.setTextColor(-16734752);
      }
      f();
    }
    if (a().jdField_a_of_type_AndroidWidgetButton != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (this.b)
        {
          localObject = a().jdField_a_of_type_AndroidWidgetButton;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= 2) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          ((Button)localObject).setEnabled(bool1);
        }
      }
      else if (this.b) {
        a().jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
  }
  
  protected void b(int paramInt)
  {
    if (paramInt != -1)
    {
      Object localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject);
      if (this.b)
      {
        if (!((IQQStoryFlowManager)QRoute.api(IQQStoryFlowManager.class)).isValidMedia(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, (LocalMediaInfo)localObject))
        {
          a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
        }
        localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localObject, localLocalMediaInfo);
      }
    }
    super.b(paramInt);
    b();
  }
  
  public void b(SlideItemInfo paramSlideItemInfo)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(paramSlideItemInfo.b)) {
        break label52;
      }
      i += 1;
    }
    i = -1;
    label52:
    if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramSlideItemInfo = this.jdField_a_of_type_JavaUtilHashMap;
      if (paramSlideItemInfo != null) {
        paramSlideItemInfo.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
    }
  }
  
  void b(String paramString)
  {
    if (this.b)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).updatePhotoPreviewSelectUI(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(paramString));
    }
  }
  
  protected boolean b()
  {
    return this.c ^ true;
  }
  
  public void c()
  {
    if (this.b) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onPhotoPreviewDestroy();
    }
    super.c();
  }
  
  public void d()
  {
    m();
    Object localObject;
    if (a().a() != -1)
    {
      String str = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(a().a());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(a().a()));
      localObject = str;
      if (this.b)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(str);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(str, localObject);
        localObject = str;
      }
    }
    else
    {
      localObject = "";
    }
    a().a((String)localObject);
    b();
    b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(a().a()));
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_Boolean) && (this.b)) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).setData(((ISlideShowController)QRoute.api(ISlideShowController.class)).getTemp());
    }
    super.g();
  }
  
  protected void h()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.setResult(-1, (Intent)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.finish();
      return;
    }
    Object localObject1 = a().a();
    Object localObject2;
    Object localObject3;
    if ((this.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.isEmpty()) && (((ArrayList)localObject1).size() == 1))
    {
      localObject2 = (String)((ArrayList)localObject1).get(0);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject2);
      if (localObject3 != null)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(((LocalMediaInfo)localObject3).panoramaPhotoType));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localObject2, localObject3);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject2) == 1) && (!AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, b(), (LocalMediaInfo)localObject3, this.jdField_e_of_type_Boolean)))
      {
        a().jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        return;
      }
    }
    if (localObject1 != null)
    {
      StatisticConstants.a(((ArrayList)localObject1).size(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_Int);
      StatisticConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent(), ((ArrayList)localObject1).size(), ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
    }
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
    if (localObject1 != null) {
      NewFlowCameraReporter.a((List)localObject1);
    }
    if ((this.c) || (this.b))
    {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
      localIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_a_of_type_JavaUtilHashMap);
    }
    if (1 == this.jdField_a_of_type_Int) {
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
    } else {
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
    if (this.b) {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    }
    a(localIntent, false, a().a());
    if (localIntent.getBooleanExtra("custom_photopreview_sendbtn_report", false))
    {
      localObject3 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportActionName");
      localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localIntent.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportReverse2");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if ((localObject3 != null) && (localObject1 != null)) {
        ReportController.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
      }
    }
  }
  
  public void i()
  {
    super.i();
    if (this.b)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onResume();
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).setPhotoPreviewController();
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
    }
  }
  
  public void m()
  {
    int i = a().a();
    if (i != -1)
    {
      String str = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.c)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(str);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (localLocalMediaInfo != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 24747)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onClipFinish(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
      return;
    }
    if ((this.b) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.setResult(paramInt2, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationQzone
 * JD-Core Version:    0.7.0.1
 */