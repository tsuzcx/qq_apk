package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

public class PhotoListCustomizationArk
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationArk";
  private boolean a;
  private String b;
  private String c;
  
  public PhotoListCustomizationArk(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public Intent a(View paramView, int paramInt)
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    localIntent.putExtra("key_ark_app_res_path", this.b);
    localIntent.putExtra("key_should_compress", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("key_ark_app_engine_res_dir", this.c);
    return super.a(paramView, paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.b = paramIntent.getStringExtra("key_ark_app_res_path");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_should_compress", false);
    this.c = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.setClickable(false);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() * 128);
        int i = 0;
        while (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size())
        {
          paramView.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(i) }));
          i += 1;
        }
        QLog.d("PhotoListCustomizationArk", 2, paramView.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.a.a();
      ThreadManagerV2.executeOnSubThread(new PhotoListCustomizationArk.1(this));
    }
    else
    {
      ChooseImageIPCModule.a().a("callbackArk", null, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    ChooseImageIPCModule.a().a("callbackArk", null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    super.b(paramView);
  }
  
  public void c()
  {
    ChooseImageIPCModule.a().a("callbackArk", null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, false, false);
  }
  
  public void c(Intent paramIntent)
  {
    paramIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    super.c(paramIntent);
  }
  
  public void h()
  {
    super.h();
    NewPhotoListActivity localNewPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArkApp ark app res:");
      localStringBuilder.append(this.b);
      QLog.d("PhotoListCustomizationArk", 2, localStringBuilder.toString());
    }
    localNewPhotoListActivity.findViewById(2131373035).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationArk
 * JD-Core Version:    0.7.0.1
 */