package com.tencent.avgame.videorecord;

import android.opengl.GLES20;
import nij;
import niu;

public class GameVideoImageFilter$1
  implements Runnable
{
  public GameVideoImageFilter$1(nij paramnij) {}
  
  public void run()
  {
    if ((nij.a(this.this$0) == -1) && (nij.a(this.this$0) != null))
    {
      GLES20.glActiveTexture(33987);
      nij.a(this.this$0, niu.a(nij.a(this.this$0), -1));
    }
    nij.b(this.this$0, nij.c(this.this$0, nij.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoImageFilter.1
 * JD-Core Version:    0.7.0.1
 */