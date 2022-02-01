package com.tencent.avgame.videorecord;

import android.opengl.GLES20;
import nqy;
import nrj;

public class GameVideoImageFilter$1
  implements Runnable
{
  public GameVideoImageFilter$1(nqy paramnqy) {}
  
  public void run()
  {
    if ((nqy.a(this.this$0) == -1) && (nqy.a(this.this$0) != null))
    {
      GLES20.glActiveTexture(33987);
      nqy.a(this.this$0, nrj.a(nqy.a(this.this$0), -1));
    }
    nqy.b(this.this$0, nqy.c(this.this$0, nqy.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoImageFilter.1
 * JD-Core Version:    0.7.0.1
 */