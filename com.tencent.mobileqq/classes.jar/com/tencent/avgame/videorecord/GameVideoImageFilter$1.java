package com.tencent.avgame.videorecord;

import android.opengl.GLES20;
import ngo;
import ngz;

public class GameVideoImageFilter$1
  implements Runnable
{
  public GameVideoImageFilter$1(ngo paramngo) {}
  
  public void run()
  {
    if ((ngo.a(this.this$0) == -1) && (ngo.a(this.this$0) != null))
    {
      GLES20.glActiveTexture(33987);
      ngo.a(this.this$0, ngz.a(ngo.a(this.this$0), -1));
    }
    ngo.b(this.this$0, ngo.c(this.this$0, ngo.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoImageFilter.1
 * JD-Core Version:    0.7.0.1
 */