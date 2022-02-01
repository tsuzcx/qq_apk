package com.tencent.avgame.videorecord;

import android.opengl.GLES20;

class GameVideoImageFilter$1
  implements Runnable
{
  GameVideoImageFilter$1(GameVideoImageFilter paramGameVideoImageFilter) {}
  
  public void run()
  {
    if ((GameVideoImageFilter.a(this.this$0) == -1) && (GameVideoImageFilter.a(this.this$0) != null))
    {
      GLES20.glActiveTexture(33987);
      GameVideoImageFilter.a(this.this$0, OpenGlUtils.a(GameVideoImageFilter.a(this.this$0), -1));
    }
    GameVideoImageFilter.b(this.this$0, GameVideoImageFilter.c(this.this$0, GameVideoImageFilter.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoImageFilter.1
 * JD-Core Version:    0.7.0.1
 */