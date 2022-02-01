package com.tencent.mobileqq.activity.photo;

import android.view.View;
import com.tencent.image.URLImageView;
import com.tencent.widget.AbsListView.RecyclerListener;

class QzonePhotoPreviewActivity$VerticalPictureAdapter$1
  implements AbsListView.RecyclerListener
{
  QzonePhotoPreviewActivity$VerticalPictureAdapter$1(QzonePhotoPreviewActivity.VerticalPictureAdapter paramVerticalPictureAdapter) {}
  
  public void onMovedToScrapHeap(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof QzonePhotoPreviewActivity.VerticalPictureAdapter.VerticalPictureHolder))) {
      ((QzonePhotoPreviewActivity.VerticalPictureAdapter.VerticalPictureHolder)paramView).a.setImageDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity.VerticalPictureAdapter.1
 * JD-Core Version:    0.7.0.1
 */