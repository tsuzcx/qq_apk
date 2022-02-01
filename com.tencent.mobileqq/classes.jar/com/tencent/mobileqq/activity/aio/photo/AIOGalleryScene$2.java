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
    if ((localObject == null) || (((AIORichMediaInfo)localObject).a == null)) {}
    ImageView localImageView;
    do
    {
      do
      {
        do
        {
          return;
          localImageView = (ImageView)this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372608);
          if ((!(((AIORichMediaInfo)localObject).a instanceof AIOShortVideoData)) || (((AIOShortVideoData)((AIORichMediaInfo)localObject).a).b != 1)) {
            break;
          }
          localObject = AIOGalleryScene.a(this.this$0);
        } while ((localImageView == null) || (localObject == null));
        localObject = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
      } while (!(localObject instanceof URLDrawable));
      if (((URLDrawable)localObject).getPlayState() == 2)
      {
        localImageView.setImageResource(2130846433);
        return;
      }
      localImageView.setImageResource(2130846432);
      return;
    } while ((localImageView == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO == null));
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "mVideoStateChecker, long video，videoState =  " + i);
    }
    if ((i == 1) || (i == 2) || (i == 3) || (i == 7))
    {
      localImageView.setImageResource(2130846433);
      return;
    }
    localImageView.setImageResource(2130846432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.2
 * JD-Core Version:    0.7.0.1
 */