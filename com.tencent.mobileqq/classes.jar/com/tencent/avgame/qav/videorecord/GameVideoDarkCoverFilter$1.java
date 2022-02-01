package com.tencent.avgame.qav.videorecord;

import android.opengl.GLES20;

class GameVideoDarkCoverFilter$1
  implements Runnable
{
  GameVideoDarkCoverFilter$1(GameVideoDarkCoverFilter paramGameVideoDarkCoverFilter, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    GLES20.glUniform4f(GameVideoDarkCoverFilter.a(this.this$0), this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GameVideoDarkCoverFilter.1
 * JD-Core Version:    0.7.0.1
 */