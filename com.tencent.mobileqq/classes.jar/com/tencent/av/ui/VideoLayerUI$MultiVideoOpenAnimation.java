package com.tencent.av.ui;

import android.graphics.Rect;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import mdz;

public class VideoLayerUI$MultiVideoOpenAnimation
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private int b;
  
  public VideoLayerUI$MultiVideoOpenAnimation(VideoLayerUI paramVideoLayerUI, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramVideoLayerUI = paramVideoLayerUI.jdField_a_of_type_ArrayOfMdz[this.jdField_a_of_type_Int];
    Rect localRect = paramVideoLayerUI.b();
    this.jdField_a_of_type_Float = (localRect.width() / 10.0F);
    paramInt = localRect.right;
    int i = localRect.width();
    paramVideoLayerUI.b(paramInt, localRect.top, i + paramInt, localRect.bottom);
    paramVideoLayerUI.b();
  }
  
  public void run()
  {
    if (this.b == 9) {
      this.this$0.c(false);
    }
    for (;;)
    {
      this.b += 1;
      if (this.b <= 9) {
        this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 30L);
      }
      return;
      mdz localmdz = this.this$0.jdField_a_of_type_ArrayOfMdz[this.jdField_a_of_type_Int];
      Rect localRect = localmdz.b();
      int i = (int)(localRect.left - this.jdField_a_of_type_Float);
      int j = localRect.width();
      localmdz.b(i, localRect.top, j + i, localRect.bottom);
      localmdz.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MultiVideoOpenAnimation
 * JD-Core Version:    0.7.0.1
 */