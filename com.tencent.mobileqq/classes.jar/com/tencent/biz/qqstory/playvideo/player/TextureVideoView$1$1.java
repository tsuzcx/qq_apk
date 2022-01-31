package com.tencent.biz.qqstory.playvideo.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import vsk;
import vtz;

public class TextureVideoView$1$1
  implements Runnable
{
  public TextureVideoView$1$1(vsk paramvsk, vtz paramvtz) {}
  
  public void run()
  {
    this.jdField_a_of_type_Vsk.a.d = this.jdField_a_of_type_Vtz.c();
    this.jdField_a_of_type_Vsk.a.e = this.jdField_a_of_type_Vtz.d();
    if ((this.jdField_a_of_type_Vsk.a.d != 0) && (this.jdField_a_of_type_Vsk.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.jdField_a_of_type_Vsk.a.getSurfaceTexture().setDefaultBufferSize(this.jdField_a_of_type_Vsk.a.d, this.jdField_a_of_type_Vsk.a.e);
      }
      this.jdField_a_of_type_Vsk.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */