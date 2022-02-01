package com.tencent.mobileqq.activity.aio;

import afbj;
import afbw;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class IntimateInfoView$18$1
  implements Runnable
{
  IntimateInfoView$18$1(IntimateInfoView.18 param18, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  @RequiresApi(api=16)
  public void run()
  {
    RelativeLayout localRelativeLayout;
    ImageView localImageView;
    if ((afbj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$18.this$0) != null) && (afbw.a(afbj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$18.this$0)) != null))
    {
      int i = afbw.a(afbj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$18.this$0)).indexOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$18.a);
      localRelativeLayout = (RelativeLayout)afbj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$18.this$0).getChild(i);
      if (localRelativeLayout != null)
      {
        localImageView = (ImageView)localRelativeLayout.findViewById(2131367269);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView$18.a.type != 17) {
          break label147;
        }
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        localImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if (this.b != null) {
        localRelativeLayout.setBackgroundDrawable(new BitmapDrawable(this.b));
      }
      return;
      label147:
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.18.1
 * JD-Core Version:    0.7.0.1
 */