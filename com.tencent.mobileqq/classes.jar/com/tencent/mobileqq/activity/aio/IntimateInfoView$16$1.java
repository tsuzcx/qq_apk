package com.tencent.mobileqq.activity.aio;

import aclw;
import acmh;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class IntimateInfoView$16$1
  implements Runnable
{
  IntimateInfoView$16$1(IntimateInfoView.16 param16, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  @RequiresApi(api=16)
  public void run()
  {
    if ((aclw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$16.this$0) != null) && (acmh.a(aclw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$16.this$0)) != null))
    {
      int i = acmh.a(aclw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$16.this$0)).indexOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$16.a);
      RelativeLayout localRelativeLayout = (RelativeLayout)aclw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$16.this$0).getChild(i);
      if (localRelativeLayout != null)
      {
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131301188);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          localImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        if (this.b != null) {
          localRelativeLayout.setBackgroundDrawable(new BitmapDrawable(this.b));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.16.1
 * JD-Core Version:    0.7.0.1
 */