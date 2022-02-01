package com.tencent.av.redpacket.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup;

class RedPacketGameView$4
  implements Runnable
{
  RedPacketGameView$4(RedPacketGameView paramRedPacketGameView, ViewGroup paramViewGroup) {}
  
  public void run()
  {
    this.a.removeView(this.this$0.jdField_a_of_type_AndroidViewView);
    this.this$0.jdField_a_of_type_AndroidViewView = null;
    if (this.this$0.c != null)
    {
      this.this$0.c.recycle();
      this.this$0.c = null;
    }
    if (this.this$0.b != null)
    {
      this.this$0.b.recycle();
      this.this$0.b = null;
    }
    if (this.this$0.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameView.4
 * JD-Core Version:    0.7.0.1
 */