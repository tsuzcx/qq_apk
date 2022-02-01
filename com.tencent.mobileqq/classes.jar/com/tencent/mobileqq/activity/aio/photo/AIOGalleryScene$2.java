package com.tencent.mobileqq.activity.aio.photo;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO;
import com.tencent.qphone.base.util.QLog;

class AIOGalleryScene$2
  implements Runnable
{
  AIOGalleryScene$2(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if (localObject != null)
    {
      if (((AIORichMediaInfo)localObject).a == null) {
        return;
      }
      ImageView localImageView = (ImageView)this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372192);
      if (((((AIORichMediaInfo)localObject).a instanceof AIOShortVideoData)) && (((AIOShortVideoData)((AIORichMediaInfo)localObject).a).b == 1))
      {
        localObject = AIOGalleryScene.a(this.this$0);
        if ((localImageView != null) && (localObject != null))
        {
          localObject = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
          if ((localObject instanceof URLDrawable))
          {
            if (((URLDrawable)localObject).getPlayState() == 2)
            {
              localImageView.setImageResource(2130846309);
              return;
            }
            localImageView.setImageResource(2130846308);
          }
        }
      }
      else if ((localImageView != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO != null))
      {
        int i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mVideoStateChecker, long video，videoState =  ");
          ((StringBuilder)localObject).append(i);
          QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
        }
        if ((i != 1) && (i != 2) && (i != 3) && (i != 7))
        {
          localImageView.setImageResource(2130846308);
          return;
        }
        localImageView.setImageResource(2130846309);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.2
 * JD-Core Version:    0.7.0.1
 */