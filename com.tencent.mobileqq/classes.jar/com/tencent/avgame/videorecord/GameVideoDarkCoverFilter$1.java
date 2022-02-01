package com.tencent.avgame.videorecord;

import android.opengl.GLES20;
import njx;

public class GameVideoDarkCoverFilter$1
  implements Runnable
{
  public GameVideoDarkCoverFilter$1(njx paramnjx, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    GLES20.glUniform4f(njx.a(this.this$0), this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoDarkCoverFilter.1
 * JD-Core Version:    0.7.0.1
 */