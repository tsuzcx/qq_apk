package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class VideoLayerUIBase$MoveSmallViewAnimation
  implements Runnable
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 1;
  private final int c = 9;
  
  private VideoLayerUIBase$MoveSmallViewAnimation(VideoLayerUIBase paramVideoLayerUIBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Float = ((paramInt4 - paramInt2) / 10.0F);
    this.jdField_b_of_type_Float = ((paramInt5 - paramInt3) / 10.0F);
    this.jdField_b_of_type_Int = paramInt1;
  }
  
  public void run()
  {
    if (this.this$0.j()) {
      return;
    }
    if (this.jdField_a_of_type_Int == 9) {
      this.this$0.h(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.this$0.a == null) {
        break;
      }
      if (this.jdField_a_of_type_Int > 9) {
        break label99;
      }
      this.this$0.a.a().postDelayed(this, 10L);
      return;
      this.this$0.d((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    }
    label99:
    this.this$0.s();
    this.this$0.a.a(new Object[] { Integer.valueOf(121) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.MoveSmallViewAnimation
 * JD-Core Version:    0.7.0.1
 */