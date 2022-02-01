package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class PhotoListCustomization<O extends OtherCommonData>
  implements MediaScanner.OnMediaScannerListener, ISceneCallBack
{
  public PeakFragmentActivity a;
  public O a;
  public PhotoCommonBaseData<O> a;
  public PhotoListBaseData a;
  public PhotoListSceneBase a;
  
  protected PhotoListCustomization(PeakFragmentActivity paramPeakFragmentActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity = paramPeakFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = PhotoCommonBaseData.getInstance(paramPeakFragmentActivity.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.bindCommonData(a());
    paramPeakFragmentActivity.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData = new PhotoListBaseData();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListCustomization new，activity = ");
      localStringBuilder.append(paramPeakFragmentActivity);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase = a();
  }
  
  public abstract Intent a(View paramView, int paramInt);
  
  protected OtherCommonData a()
  {
    return new PhotoListCustomization.1(this);
  }
  
  public abstract AbstractAlbumListFragment a();
  
  public abstract Holder a(@NonNull Holder paramHolder, int paramInt);
  
  public PhotoListSceneBase a()
  {
    return new PhotoListSceneBase(this);
  }
  
  public abstract List<LocalMediaInfo> a(Object... paramVarArgs);
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Message paramMessage);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, int paramInt);
  
  public abstract void a(View paramView, int paramInt, CheckBox paramCheckBox);
  
  public abstract void a(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  public abstract void a(List<LocalMediaInfo> paramList, int paramInt);
  
  public void a(boolean paramBoolean) {}
  
  public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean);
  
  public abstract boolean a(List<LocalMediaInfo> paramList);
  
  public abstract Holder b(@NonNull Holder paramHolder, int paramInt);
  
  public abstract void b(Intent paramIntent);
  
  public abstract void b(View paramView);
  
  public abstract void b(View paramView, int paramInt);
  
  public abstract Holder c(@NonNull Holder paramHolder, int paramInt);
  
  public abstract void c();
  
  public abstract void c(Intent paramIntent);
  
  public abstract void c(View paramView);
  
  public abstract void c(View paramView, int paramInt);
  
  public abstract void e(Intent paramIntent);
  
  public abstract void f();
  
  public abstract void f(Intent paramIntent);
  
  public abstract void g();
  
  public abstract void h();
  
  public void i()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListCustomization close，activity = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
  }
  
  public abstract void j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomization
 * JD-Core Version:    0.7.0.1
 */