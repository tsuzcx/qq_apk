package com.tencent.avgame.videorecord;

import android.opengl.GLES20;
import njy;
import nkj;

public class GameVideoImageFilter$1
  implements Runnable
{
  public GameVideoImageFilter$1(njy paramnjy) {}
  
  public void run()
  {
    if ((njy.a(this.this$0) == -1) && (njy.a(this.this$0) != null))
    {
      GLES20.glActiveTexture(33987);
      njy.a(this.this$0, nkj.a(njy.a(this.this$0), -1));
    }
    njy.b(this.this$0, njy.c(this.this$0, njy.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoImageFilter.1
 * JD-Core Version:    0.7.0.1
 */