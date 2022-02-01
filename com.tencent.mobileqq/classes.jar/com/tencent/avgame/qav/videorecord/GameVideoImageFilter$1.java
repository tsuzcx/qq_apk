package com.tencent.avgame.qav.videorecord;

import android.opengl.GLES20;

class GameVideoImageFilter$1
  implements Runnable
{
  GameVideoImageFilter$1(GameVideoImageFilter paramGameVideoImageFilter) {}
  
  public void run()
  {
    if ((GameVideoImageFilter.a(this.this$0) == -1) && (GameVideoImageFilter.b(this.this$0) != null))
    {
      GLES20.glActiveTexture(33987);
      localGameVideoImageFilter = this.this$0;
      GameVideoImageFilter.a(localGameVideoImageFilter, OpenGlUtils.a(GameVideoImageFilter.b(localGameVideoImageFilter), -1));
    }
    GameVideoImageFilter localGameVideoImageFilter = this.this$0;
    GameVideoImageFilter.b(localGameVideoImageFilter, GameVideoImageFilter.c(localGameVideoImageFilter, GameVideoImageFilter.c(localGameVideoImageFilter)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GameVideoImageFilter.1
 * JD-Core Version:    0.7.0.1
 */