package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;

class AIOGalleryScene$24
  implements AIOGalleryAdapter.OnAdapterNotify
{
  AIOGalleryScene$24(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void a(int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.a.a().findViewById(2131367687);
      if (localView != null) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          localView.setVisibility(0);
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          localAlphaAnimation.setDuration(300L);
          localView.startAnimation(localAlphaAnimation);
          localView.postDelayed(new AIOGalleryScene.24.1(this, localView), 8000L);
          return;
          if (1 != paramInt) {
            break;
          }
        } while ((this.a.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager == null) || (((AIOGalleryScene.J(this.a) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)AIOGalleryScene.K(this.a)).b)) || (this.a.c));
        this.a.c(null);
        return;
        if (2 != paramInt) {
          break;
        }
        this.a.a(null);
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager == null) || (((AIOGalleryScene.L(this.a) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)AIOGalleryScene.M(this.a)).b)) || (this.a.c));
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      return;
    } while (3 != paramInt);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.i = true;
    this.a.e.setText("");
    this.a.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.24
 * JD-Core Version:    0.7.0.1
 */