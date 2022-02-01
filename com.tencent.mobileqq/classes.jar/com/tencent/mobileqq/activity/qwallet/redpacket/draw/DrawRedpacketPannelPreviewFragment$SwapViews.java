package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.widget.Rotate3dAnimation;

final class DrawRedpacketPannelPreviewFragment$SwapViews
  implements Runnable
{
  private final View jdField_a_of_type_AndroidViewView;
  private final boolean jdField_a_of_type_Boolean;
  private final View b;
  
  public DrawRedpacketPannelPreviewFragment$SwapViews(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, boolean paramBoolean, View paramView1, View paramView2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.b = paramView2;
  }
  
  public void run()
  {
    float f1 = DrawRedpacketPannelPreviewFragment.a(this.this$0).getWidth() / 2.0F;
    float f2 = DrawRedpacketPannelPreviewFragment.a(this.this$0).getHeight() / 2.0F;
    Rotate3dAnimation localRotate3dAnimation;
    if (this.jdField_a_of_type_Boolean)
    {
      localRotate3dAnimation = new Rotate3dAnimation(-90.0F, 0.0F, f1, f2, 610.0F, false);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(0);
      if (QWalletRedPkgUtils.a(this.this$0.getActivity()))
      {
        DrawRedpacketPannelPreviewFragment.a(this.this$0).setVisibility(0);
        DrawRedpacketPannelPreviewFragment.f(this.this$0).setVisibility(4);
      }
    }
    for (;;)
    {
      localRotate3dAnimation.setDuration(250L);
      localRotate3dAnimation.setFillAfter(true);
      localRotate3dAnimation.setInterpolator(new DecelerateInterpolator());
      DrawRedpacketPannelPreviewFragment.a(this.this$0).startAnimation(localRotate3dAnimation);
      return;
      DrawRedpacketPannelPreviewFragment.f(this.this$0).setVisibility(0);
      DrawRedpacketPannelPreviewFragment.b(this.this$0).setVisibility(4);
      continue;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b.setVisibility(8);
      localRotate3dAnimation = new Rotate3dAnimation(90.0F, 0.0F, f1, f2, 610.0F, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.SwapViews
 * JD-Core Version:    0.7.0.1
 */