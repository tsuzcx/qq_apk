package com.tencent.mobileqq.activity.aio.photo;

import aegs;
import aeic;
import aeiy;
import agqv;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class AIOGalleryScene$2
  implements Runnable
{
  public AIOGalleryScene$2(aegs paramaegs) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Aeic.a();
    if ((localObject == null) || (((aeiy)localObject).a == null)) {}
    ImageView localImageView;
    do
    {
      do
      {
        do
        {
          return;
          localImageView = (ImageView)this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371129);
          if ((!(((aeiy)localObject).a instanceof AIOShortVideoData)) || (((AIOShortVideoData)((aeiy)localObject).a).b != 1)) {
            break;
          }
          localObject = aegs.a(this.this$0);
        } while ((localImageView == null) || (localObject == null));
        localObject = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
      } while (!(localObject instanceof URLDrawable));
      if (((URLDrawable)localObject).getPlayState() == 2)
      {
        localImageView.setImageResource(2130845268);
        return;
      }
      localImageView.setImageResource(2130845267);
      return;
    } while ((localImageView == null) || (this.this$0.jdField_a_of_type_Agqv == null));
    int i = this.this$0.jdField_a_of_type_Agqv.a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "mVideoStateChecker, long video，videoState =  " + i);
    }
    if ((i == 1) || (i == 2) || (i == 3) || (i == 7))
    {
      localImageView.setImageResource(2130845268);
      return;
    }
    localImageView.setImageResource(2130845267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.2
 * JD-Core Version:    0.7.0.1
 */