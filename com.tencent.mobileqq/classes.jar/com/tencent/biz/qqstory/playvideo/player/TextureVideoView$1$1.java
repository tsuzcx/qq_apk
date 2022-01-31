package com.tencent.biz.qqstory.playvideo.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import udv;
import ufk;

public class TextureVideoView$1$1
  implements Runnable
{
  public TextureVideoView$1$1(udv paramudv, ufk paramufk) {}
  
  public void run()
  {
    this.jdField_a_of_type_Udv.a.d = this.jdField_a_of_type_Ufk.c();
    this.jdField_a_of_type_Udv.a.e = this.jdField_a_of_type_Ufk.d();
    if ((this.jdField_a_of_type_Udv.a.d != 0) && (this.jdField_a_of_type_Udv.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.jdField_a_of_type_Udv.a.getSurfaceTexture().setDefaultBufferSize(this.jdField_a_of_type_Udv.a.d, this.jdField_a_of_type_Udv.a.e);
      }
      this.jdField_a_of_type_Udv.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */