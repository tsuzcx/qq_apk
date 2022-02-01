package com.tencent.biz.qqstory.playvideo.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import xqe;
import xrt;

public class TextureVideoView$1$1
  implements Runnable
{
  public TextureVideoView$1$1(xqe paramxqe, xrt paramxrt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Xqe.a.d = this.jdField_a_of_type_Xrt.c();
    this.jdField_a_of_type_Xqe.a.e = this.jdField_a_of_type_Xrt.d();
    if ((this.jdField_a_of_type_Xqe.a.d != 0) && (this.jdField_a_of_type_Xqe.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.jdField_a_of_type_Xqe.a.getSurfaceTexture().setDefaultBufferSize(this.jdField_a_of_type_Xqe.a.d, this.jdField_a_of_type_Xqe.a.e);
      }
      this.jdField_a_of_type_Xqe.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */