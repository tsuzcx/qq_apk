package com.tencent.biz.qqstory.playvideo.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import xtz;
import xvo;

public class TextureVideoView$1$1
  implements Runnable
{
  public TextureVideoView$1$1(xtz paramxtz, xvo paramxvo) {}
  
  public void run()
  {
    this.jdField_a_of_type_Xtz.a.d = this.jdField_a_of_type_Xvo.c();
    this.jdField_a_of_type_Xtz.a.e = this.jdField_a_of_type_Xvo.d();
    if ((this.jdField_a_of_type_Xtz.a.d != 0) && (this.jdField_a_of_type_Xtz.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.jdField_a_of_type_Xtz.a.getSurfaceTexture().setDefaultBufferSize(this.jdField_a_of_type_Xtz.a.d, this.jdField_a_of_type_Xtz.a.e);
      }
      this.jdField_a_of_type_Xtz.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */