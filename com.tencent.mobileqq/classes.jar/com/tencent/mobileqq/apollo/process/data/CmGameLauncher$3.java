package com.tencent.mobileqq.apollo.process.data;

import ande;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameLauncher$3
  implements Runnable
{
  public CmGameLauncher$3(ande paramande) {}
  
  public void run()
  {
    if (ande.a(this.this$0) != null)
    {
      ande.a(this.this$0).setPreserveEGLContextOnPause(true);
      ande.a(this.this$0).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.3
 * JD-Core Version:    0.7.0.1
 */