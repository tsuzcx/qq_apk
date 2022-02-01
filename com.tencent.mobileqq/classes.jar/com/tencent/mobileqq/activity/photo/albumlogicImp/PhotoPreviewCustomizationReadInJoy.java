package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoPreviewCustomizationReadInJoy
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
  PhotoPreviewCustomizationReadInJoy(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Boolean)
    {
      a().c.setVisibility(8);
      a().jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.findViewById(2131365501).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.findViewById(2131365501).setOnClickListener(new PhotoPreviewCustomizationReadInJoy.1(this));
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)) && (!this.jdField_a_of_type_Boolean)) {
      a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.b)
    {
      a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 1))
      {
        a().jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        return;
      }
      a().jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      return;
    }
    if (this.c) {
      a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver", false);
    this.b = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver_preview", false);
    this.c = paramIntent.getBooleanExtra("from_readinjoy_ugc", false);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = a().a();
    if (paramInt1 != -1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString != null)
    {
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.c)
      {
        if ((!this.jdField_a_of_type_Boolean) && (!this.c) && (!this.b))
        {
          paramView = new HashMap(1);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) && ((LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString) != null)) {
            paramView.put("param_localmediainfo", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString));
          }
          paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString, true, true, true, true, true, paramInt2, a(), 4, paramView);
        }
        else
        {
          if (this.jdField_a_of_type_Boolean)
          {
            paramInt1 = a().a();
            if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt1));
            }
          }
          paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString, true, true, true, true, true, 8, a(), 0);
        }
      }
      else
      {
        paramView = new Bundle();
        paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString, true, true, true, true, true, 2, a(), 4, paramView);
      }
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) {
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      } else {
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.b);
      }
      paramView.putExtra("PhotoConst.readinjoy_delete_pic_position", a().a());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.startActivity(paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.overridePendingTransition(2130772065, 2130772067);
      a().jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
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
  
  public void b()
  {
    super.b();
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.g) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode) && (this.jdField_a_of_type_Boolean)) {
      a().jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    }
  }
  
  protected void h()
  {
    super.h();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy
 * JD-Core Version:    0.7.0.1
 */