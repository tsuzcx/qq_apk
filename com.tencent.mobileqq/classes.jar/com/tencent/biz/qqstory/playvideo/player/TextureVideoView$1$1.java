package com.tencent.biz.qqstory.playvideo.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import vwt;
import vyi;

public class TextureVideoView$1$1
  implements Runnable
{
  public TextureVideoView$1$1(vwt paramvwt, vyi paramvyi) {}
  
  public void run()
  {
    this.jdField_a_of_type_Vwt.a.d = this.jdField_a_of_type_Vyi.c();
    this.jdField_a_of_type_Vwt.a.e = this.jdField_a_of_type_Vyi.d();
    if ((this.jdField_a_of_type_Vwt.a.d != 0) && (this.jdField_a_of_type_Vwt.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.jdField_a_of_type_Vwt.a.getSurfaceTexture().setDefaultBufferSize(this.jdField_a_of_type_Vwt.a.d, this.jdField_a_of_type_Vwt.a.e);
      }
      this.jdField_a_of_type_Vwt.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */