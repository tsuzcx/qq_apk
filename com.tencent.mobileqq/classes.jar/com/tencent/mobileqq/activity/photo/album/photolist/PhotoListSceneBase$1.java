package com.tencent.mobileqq.activity.photo.album.photolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import java.util.concurrent.atomic.AtomicBoolean;

class PhotoListSceneBase$1
  extends RecyclerView.OnScrollListener
{
  PhotoListSceneBase$1(PhotoListSceneBase paramPhotoListSceneBase) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper != null) && (this.a.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition() + this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.mEachCount / 2 > this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.getItemCount()) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.a.get())) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase.1
 * JD-Core Version:    0.7.0.1
 */