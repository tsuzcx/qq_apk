package com.tencent.mobileqq.activity.aio.photo;

import aghx;
import agjh;
import agkf;
import aiqi;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class AIOGalleryScene$2
  implements Runnable
{
  public AIOGalleryScene$2(aghx paramaghx) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Agjh.a();
    if ((localObject == null) || (((agkf)localObject).a == null)) {}
    ImageView localImageView;
    do
    {
      do
      {
        do
        {
          return;
          localImageView = (ImageView)this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371461);
          if ((!(((agkf)localObject).a instanceof AIOShortVideoData)) || (((AIOShortVideoData)((agkf)localObject).a).b != 1)) {
            break;
          }
          localObject = aghx.a(this.this$0);
        } while ((localImageView == null) || (localObject == null));
        localObject = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
      } while (!(localObject instanceof URLDrawable));
      if (((URLDrawable)localObject).getPlayState() == 2)
      {
        localImageView.setImageResource(2130845707);
        return;
      }
      localImageView.setImageResource(2130845706);
      return;
    } while ((localImageView == null) || (this.this$0.jdField_a_of_type_Aiqi == null));
    int i = this.this$0.jdField_a_of_type_Aiqi.a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "mVideoStateChecker, long video，videoState =  " + i);
    }
    if ((i == 1) || (i == 2) || (i == 3) || (i == 7))
    {
      localImageView.setImageResource(2130845707);
      return;
    }
    localImageView.setImageResource(2130845706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.2
 * JD-Core Version:    0.7.0.1
 */