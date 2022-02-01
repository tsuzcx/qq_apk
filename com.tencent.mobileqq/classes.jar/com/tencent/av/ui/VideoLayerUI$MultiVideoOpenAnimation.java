package com.tencent.av.ui;

import android.graphics.Rect;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

public class VideoLayerUI$MultiVideoOpenAnimation
  implements Runnable
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  
  public VideoLayerUI$MultiVideoOpenAnimation(VideoLayerUI paramVideoLayerUI, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramVideoLayerUI = paramVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.jdField_a_of_type_Int];
    Rect localRect = paramVideoLayerUI.b();
    this.jdField_a_of_type_Float = (localRect.width() / 10.0F);
    paramInt = localRect.right;
    int i = localRect.width();
    paramVideoLayerUI.b(paramInt, localRect.top, i + paramInt, localRect.bottom);
    paramVideoLayerUI.b();
  }
  
  public void run()
  {
    if (this.b == 9)
    {
      this.this$0.c(false);
    }
    else
    {
      GLVideoView localGLVideoView = this.this$0.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.jdField_a_of_type_Int];
      Rect localRect = localGLVideoView.b();
      int i = (int)(localRect.left - this.jdField_a_of_type_Float);
      int j = localRect.width();
      localGLVideoView.b(i, localRect.top, j + i, localRect.bottom);
      localGLVideoView.b();
    }
    this.b += 1;
    if (this.b <= 9) {
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 30L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MultiVideoOpenAnimation
 * JD-Core Version:    0.7.0.1
 */