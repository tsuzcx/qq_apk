package com.tencent.mobileqq.activity.aio.photo;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AIOGalleryScene$3
  implements Runnable
{
  AIOGalleryScene$3(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null))
    {
      Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      long l1;
      double d1;
      double d2;
      int i;
      if ((localObject1 instanceof AIOShortVideoData))
      {
        localObject1 = (AIOShortVideoData)localObject1;
        Object localObject2;
        long l2;
        if (((AIOShortVideoData)localObject1).b == 0)
        {
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO != null)
          {
            if (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c()) {
              return;
            }
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.d)
            {
              l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c();
              localObject2 = ShortVideoUtils.stringForFileSize(AIOGalleryScene.a(this.this$0), l1 * 1024L);
              TextView localTextView = this.this$0.e;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append("/s");
              localTextView.setText(localStringBuilder.toString());
            }
            else
            {
              l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a();
              d1 = l1;
              d2 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.b();
              Double.isNaN(d1);
              Double.isNaN(d2);
              i = (int)(d1 / d2 * 10000.0D);
              this.this$0.c.setText(ShortVideoUtils.stringForTime(l1));
              this.this$0.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
            }
            localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
            float f2 = 10000.0F;
            float f1 = f2;
            if (localObject2 != null)
            {
              f1 = f2;
              if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a != null)
              {
                f1 = f2;
                if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a.a)
                {
                  l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.d();
                  l2 = ((AIOShortVideoData)localObject1).h;
                  f1 = (int)((float)l1 / (float)l2 * 10000.0F);
                }
              }
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("mProgressChecker, 长视频，cacheProgress =  ");
              ((StringBuilder)localObject1).append(f1);
              QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject1).toString());
            }
            this.this$0.jdField_b_of_type_AndroidWidgetSeekBar.setSecondaryProgress((int)f1);
          }
        }
        else if (((AIOShortVideoData)localObject1).b == 1)
        {
          localObject2 = AIOGalleryScene.a(this.this$0);
          if (localObject2 != null)
          {
            localObject2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject2).a();
            if ((localObject2 instanceof URLDrawable))
            {
              l1 = ((URLDrawable)localObject2).getCurrentPostion();
              l2 = ((AIOShortVideoData)localObject1).a * 1000;
              this.this$0.c.setText(ShortVideoUtils.stringForTime(l1));
              localObject1 = this.this$0.jdField_b_of_type_AndroidWidgetSeekBar;
              d1 = l1;
              d2 = l2;
              Double.isNaN(d1);
              Double.isNaN(d2);
              ((SeekBar)localObject1).setProgress((int)(d1 / d2 * 10000.0D));
              this.this$0.jdField_b_of_type_AndroidWidgetSeekBar.setSecondaryProgress(10000);
            }
          }
        }
      }
      else if (AIOFileVideoData.class.isInstance(localObject1))
      {
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO != null)
        {
          if (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c()) {
            return;
          }
          l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a();
          d1 = l1;
          d2 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.b();
          Double.isNaN(d1);
          Double.isNaN(d2);
          i = (int)(d1 / d2 * 10000.0D);
          this.this$0.c.setText(ShortVideoUtils.stringForTime(l1));
          this.this$0.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
        }
        else
        {
          return;
        }
      }
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.this$0.jdField_b_of_type_JavaLangRunnable, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.3
 * JD-Core Version:    0.7.0.1
 */