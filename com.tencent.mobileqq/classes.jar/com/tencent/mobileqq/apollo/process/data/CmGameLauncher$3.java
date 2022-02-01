package com.tencent.mobileqq.apollo.process.data;

import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class CmGameLauncher$3
  implements Runnable
{
  CmGameLauncher$3(CmGameLauncher paramCmGameLauncher) {}
  
  public void run()
  {
    if (CmGameLauncher.a(this.this$0) != null)
    {
      CmGameLauncher.a(this.this$0).setPreserveEGLContextOnPause(true);
      CmGameLauncher.a(this.this$0).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.3
 * JD-Core Version:    0.7.0.1
 */