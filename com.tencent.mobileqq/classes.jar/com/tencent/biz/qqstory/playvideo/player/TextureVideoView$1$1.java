package com.tencent.biz.qqstory.playvideo.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import wvk;
import wwz;

public class TextureVideoView$1$1
  implements Runnable
{
  public TextureVideoView$1$1(wvk paramwvk, wwz paramwwz) {}
  
  public void run()
  {
    this.jdField_a_of_type_Wvk.a.d = this.jdField_a_of_type_Wwz.c();
    this.jdField_a_of_type_Wvk.a.e = this.jdField_a_of_type_Wwz.d();
    if ((this.jdField_a_of_type_Wvk.a.d != 0) && (this.jdField_a_of_type_Wvk.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.jdField_a_of_type_Wvk.a.getSurfaceTexture().setDefaultBufferSize(this.jdField_a_of_type_Wvk.a.d, this.jdField_a_of_type_Wvk.a.e);
      }
      this.jdField_a_of_type_Wvk.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */