package com.tencent.mobileqq.activity.aio.photo;

import ahri;
import ahsn;
import ahtm;
import ahtn;
import aklr;
import aklw;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AIOGalleryScene$3
  implements Runnable
{
  public AIOGalleryScene$3(ahri paramahri) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if ((this.this$0.jdField_a_of_type_Ahsn.a() != null) && (this.this$0.jdField_a_of_type_Ahsn.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null))
    {
      localObject1 = this.this$0.jdField_a_of_type_Ahsn.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (!(localObject1 instanceof AIOShortVideoData)) {
        break label474;
      }
      localObject2 = (AIOShortVideoData)localObject1;
      if (((AIOShortVideoData)localObject2).b != 0) {
        break label361;
      }
      if ((this.this$0.jdField_a_of_type_Aklr != null) && (this.this$0.jdField_a_of_type_Aklr.c())) {}
    }
    else
    {
      return;
    }
    long l1;
    label168:
    long l2;
    if (this.this$0.jdField_a_of_type_Ahsn.a().jdField_a_of_type_Ahtn.d)
    {
      l1 = this.this$0.jdField_a_of_type_Aklr.c();
      localObject1 = ShortVideoUtils.stringForFileSize(ahri.a(this.this$0), l1 * 1024L);
      this.this$0.e.setText((String)localObject1 + "/s");
      if ((this.this$0.jdField_a_of_type_Aklr == null) || (this.this$0.jdField_a_of_type_Aklr.a == null) || (!this.this$0.jdField_a_of_type_Aklr.a.a)) {
        break label566;
      }
      l1 = this.this$0.jdField_a_of_type_Aklr.d();
      l2 = ((AIOShortVideoData)localObject2).h;
    }
    label566:
    for (float f = (int)((float)l1 / (float)l2 * 10000.0F);; f = 10000.0F)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "mProgressChecker, 长视频，cacheProgress =  " + f);
      }
      this.this$0.jdField_b_of_type_AndroidWidgetSeekBar.setSecondaryProgress((int)f);
      label474:
      for (;;)
      {
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.this$0.jdField_b_of_type_JavaLangRunnable, 100L);
        return;
        l1 = this.this$0.jdField_a_of_type_Aklr.a();
        int i = (int)(l1 / this.this$0.jdField_a_of_type_Aklr.b() * 10000.0D);
        this.this$0.c.setText(ShortVideoUtils.stringForTime(l1));
        this.this$0.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
        break label168;
        label361:
        if (((AIOShortVideoData)localObject2).b == 1)
        {
          localObject2 = ahri.a(this.this$0);
          if (localObject2 != null)
          {
            localObject2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject2).a();
            if ((localObject2 instanceof URLDrawable))
            {
              l1 = ((URLDrawable)localObject2).getCurrentPostion();
              l2 = ((AIOShortVideoData)localObject1).a * 1000;
              this.this$0.c.setText(ShortVideoUtils.stringForTime(l1));
              this.this$0.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)(l1 / l2 * 10000.0D));
              this.this$0.jdField_b_of_type_AndroidWidgetSeekBar.setSecondaryProgress(10000);
              continue;
              if (AIOFileVideoData.class.isInstance(localObject1))
              {
                if ((this.this$0.jdField_a_of_type_Aklr == null) || (!this.this$0.jdField_a_of_type_Aklr.c())) {
                  break;
                }
                l1 = this.this$0.jdField_a_of_type_Aklr.a();
                i = (int)(l1 / this.this$0.jdField_a_of_type_Aklr.b() * 10000.0D);
                this.this$0.c.setText(ShortVideoUtils.stringForTime(l1));
                this.this$0.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.3
 * JD-Core Version:    0.7.0.1
 */