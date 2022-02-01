package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoListAdapter$OnItemClickListener
  implements View.OnClickListener
{
  public int a;
  
  PhotoListAdapter$OnItemClickListener(PhotoListAdapter paramPhotoListAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.getItemViewType(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization != null) {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.c(paramView, this.jdField_a_of_type_Int);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.b(paramView, this.jdField_a_of_type_Int);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a().isSingleMode)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a(paramView, this.jdField_a_of_type_Int);
      }
      else
      {
        Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a(paramView, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.b(localIntent);
        QAlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, true, true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter.OnItemClickListener
 * JD-Core Version:    0.7.0.1
 */