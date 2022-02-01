package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class PhotoPreviewCustomizationFastImage
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFastImage";
  int jdField_a_of_type_Int = 1037;
  boolean jdField_a_of_type_Boolean;
  
  protected PhotoPreviewCustomizationFastImage(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    a().d.setText(2131694876);
    a().a.setVisibility(8);
    a().jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.c = true;
    super.a(paramIntent);
    Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
    if (localObject != null)
    {
      if (PresendPicMgr.a(null) != null) {
        PresendPicMgr.a(null).b();
      }
      localObject = PresendPicMgr.b(IPresendPicMgr.Stub.a(((BinderWarpper)localObject).a));
      String str = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(str) != 1)
      {
        ((PresendPicMgr)localObject).a(str, this.jdField_a_of_type_Int, 10);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("  initData , presendMgr = ");
          localStringBuilder.append(localObject);
          localStringBuilder.append(",picpath = ");
          localStringBuilder.append(str);
          localStringBuilder.append(",from = ");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d);
          localStringBuilder.append(",mBusiType = ");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          QLog.d("QQAlbum", 2, localStringBuilder.toString());
        }
      }
    }
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("callFromFastImage", false);
    if ("FromFastImage".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d)) {
      StatisticConstants.c();
    }
    if ("FromCamera".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d)) {
      StatisticConstants.a();
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      localObject = PresendPicMgr.a(null);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "Photo+ send pic,cancel presend!");
        }
        ((PresendPicMgr)localObject).a(1003);
      }
      PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, true);
    }
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a != null)
    {
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X8004D95", "0X8004D95", 0, 0, "", "", "", "");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
    }
    super.a(paramView, paramInt1, paramBundle, paramInt2, paramIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i = paramBoolean;
    if (paramBoolean)
    {
      a().b.setChecked(paramBoolean ^ true);
      a().jdField_c_of_type_AndroidWidgetTextView.setTextColor(2147483647);
      return;
    }
    a().jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup.dismiss();
    }
  }
  
  public void g()
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (localPresendPicMgr != null)
    {
      int i;
      if ("FromCamera".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d)) {
        i = 1016;
      } else {
        i = 1017;
      }
      localPresendPicMgr.a(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.finish();
  }
  
  protected void h()
  {
    if ("FromFastImage".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d))
    {
      ReportController.b(null, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      StatisticConstants.d();
    }
    if ("FromCamera".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d)) {
      StatisticConstants.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
    }
    super.h();
    ReportController.b(null, "CliOper", "", "", "0X8005147", "0X8005147", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFastImage
 * JD-Core Version:    0.7.0.1
 */