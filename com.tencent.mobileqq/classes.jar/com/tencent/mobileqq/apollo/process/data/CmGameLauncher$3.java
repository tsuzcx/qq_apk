package com.tencent.mobileqq.apollo.process.data;

import akyg;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameLauncher$3
  implements Runnable
{
  public CmGameLauncher$3(akyg paramakyg) {}
  
  public void run()
  {
    if (akyg.a(this.this$0) != null)
    {
      akyg.a(this.this$0).setPreserveEGLContextOnPause(true);
      akyg.a(this.this$0).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.3
 * JD-Core Version:    0.7.0.1
 */