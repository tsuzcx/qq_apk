package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowUtils;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoPreviewLogicReadInJoy
  extends PhotoPreviewLogicDefault
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d;
  
  PhotoPreviewLogicReadInJoy(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void d()
  {
    if (this.d)
    {
      SlideShowUtils.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList);
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
      return;
    }
    super.d();
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.d = paramIntent.getBooleanExtra("from_readinjoy_slideshow", false);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver", false);
    this.b = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver_preview", false);
    this.c = paramIntent.getBooleanExtra("from_readinjoy_ugc", false);
    ((PhotoOtherData)this.mOtherCommonData).a(this.d, this.mPhotoCommonData);
  }
  
  public void initUI()
  {
    super.initUI();
    if (((PhotoOtherData)this.mOtherCommonData).a()) {
      ((NewPhotoPreviewActivity)this.mActivity).titleView.setVisibility(8);
    }
    label239:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          ((NewPhotoPreviewActivity)this.mActivity).findViewById(2131365657).setVisibility(0);
          ((NewPhotoPreviewActivity)this.mActivity).findViewById(2131365657).setOnClickListener(new PhotoPreviewLogicReadInJoy.1(this));
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.isSingleMode)) && (!this.jdField_a_of_type_Boolean)) {
          ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
        }
        if (!this.b) {
          break label239;
        }
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.size() > 1) && (this.mPhotoCommonData.selectedPhotoList.size() > 1)) {
          break;
        }
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setVisibility(8);
        }
      }
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(false);
      return;
    } while (!this.c);
    ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10013)
    {
      if ((paramInt2 == -1) && (this.d))
      {
        ((NewPhotoPreviewActivity)this.mActivity).setResult(paramInt2, paramIntent);
        ((NewPhotoPreviewActivity)this.mActivity).finish();
      }
      do
      {
        do
        {
          return;
        } while (!this.d);
        paramIntent = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      } while (TextUtils.isEmpty(paramIntent));
      FileUtils.a(new File(paramIntent).getParent());
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (paramInt1 != -1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a = ((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a != null)
    {
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.c) {
        break label441;
      }
      if ((!this.jdField_a_of_type_Boolean) && (!this.c) && (!this.b)) {
        break label343;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramInt1 = ((NewPhotoPreviewActivity)this.mActivity).gallery.getFirstVisiblePosition();
        if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.size()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a = ((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt1));
        }
      }
      paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a, true, true, true, true, true, 8, a(), 0);
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) {
        break label479;
      }
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
    }
    for (;;)
    {
      paramView.putExtra("PhotoConst.readinjoy_delete_pic_position", ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion());
      ((NewPhotoPreviewActivity)this.mActivity).startActivity(paramView);
      ((NewPhotoPreviewActivity)this.mActivity).overridePendingTransition(2130772043, 2130772045);
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(false);
      paramView = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
      if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
      {
        paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
        if (paramView != null) {
          ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
        }
      }
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      label343:
      paramView = new HashMap(1);
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && ((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a) != null)) {
        paramView.put("param_localmediainfo", this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a));
      }
      paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a, true, true, true, true, true, paramInt2, a(), 4, paramView);
      break;
      label441:
      paramView = new Bundle();
      paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a, true, true, true, true, true, 2, a(), 4, paramView);
      break;
      label479:
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.b);
    }
  }
  
  public void updateButton()
  {
    super.updateButton();
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.isSingleMode) && (this.jdField_a_of_type_Boolean)) {
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicReadInJoy
 * JD-Core Version:    0.7.0.1
 */