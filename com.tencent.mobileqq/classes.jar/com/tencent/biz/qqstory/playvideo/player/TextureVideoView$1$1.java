package com.tencent.biz.qqstory.playvideo.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import uds;
import ufh;

public class TextureVideoView$1$1
  implements Runnable
{
  public TextureVideoView$1$1(uds paramuds, ufh paramufh) {}
  
  public void run()
  {
    this.jdField_a_of_type_Uds.a.d = this.jdField_a_of_type_Ufh.c();
    this.jdField_a_of_type_Uds.a.e = this.jdField_a_of_type_Ufh.d();
    if ((this.jdField_a_of_type_Uds.a.d != 0) && (this.jdField_a_of_type_Uds.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.jdField_a_of_type_Uds.a.getSurfaceTexture().setDefaultBufferSize(this.jdField_a_of_type_Uds.a.d, this.jdField_a_of_type_Uds.a.e);
      }
      this.jdField_a_of_type_Uds.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */