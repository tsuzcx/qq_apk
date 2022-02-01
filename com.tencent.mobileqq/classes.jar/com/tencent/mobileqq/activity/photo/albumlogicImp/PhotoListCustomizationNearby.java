package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class PhotoListCustomizationNearby
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby";
  
  PhotoListCustomizationNearby(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth >= 320) && (paramLocalMediaInfo.mediaHeight >= 320)) {
      return true;
    }
    paramLocalMediaInfo = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, 230, null, HardCodeUtil.a(2131708093), HardCodeUtil.a(2131708077), null, null, new PhotoListCustomizationNearby.1(this));
    try
    {
      paramLocalMediaInfo.show();
    }
    catch (Exception paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListCustomizationNearby", 2, "showLocationFailDialog fail!", paramLocalMediaInfo);
      }
    }
    return false;
  }
  
  public Intent a(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.getItemViewType(paramInt) == 0) && (!a(localLocalMediaInfo))) {
      return null;
    }
    return super.a(paramView, paramInt);
  }
  
  public String a(LocalMediaInfo paramLocalMediaInfo)
  {
    return HardCodeUtil.a(2131694389);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a(paramInt))) {
      super.a(paramView, paramInt, paramCheckBox);
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent != null) {
      super.b(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby
 * JD-Core Version:    0.7.0.1
 */