package com.tencent.mobileqq.app;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import anvc;
import com.tencent.mobileqq.activity.home.MainFragment;

public class FrameHelperActivity$9$2
  implements Runnable
{
  public FrameHelperActivity$9$2(anvc paramanvc, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_Anvc.a.b.setVisibility(8);
      this.jdField_a_of_type_Anvc.a.b.setContentDescription(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_Anvc.a.a() == MainFragment.b) {
      this.jdField_a_of_type_Anvc.a.b.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Anvc.a.b.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break;
      this.jdField_a_of_type_Anvc.a.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.9.2
 * JD-Core Version:    0.7.0.1
 */