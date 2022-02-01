package com.tencent.mobileqq.apollo.process.data;

import amyo;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameLauncher$3
  implements Runnable
{
  public CmGameLauncher$3(amyo paramamyo) {}
  
  public void run()
  {
    if (amyo.a(this.this$0) != null)
    {
      amyo.a(this.this$0).setPreserveEGLContextOnPause(true);
      amyo.a(this.this$0).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.3
 * JD-Core Version:    0.7.0.1
 */