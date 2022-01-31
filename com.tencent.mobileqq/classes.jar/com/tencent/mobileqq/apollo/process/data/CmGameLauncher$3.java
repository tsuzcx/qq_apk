package com.tencent.mobileqq.apollo.process.data;

import aktr;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameLauncher$3
  implements Runnable
{
  public CmGameLauncher$3(aktr paramaktr) {}
  
  public void run()
  {
    if (aktr.a(this.this$0) != null)
    {
      aktr.a(this.this$0).setPreserveEGLContextOnPause(true);
      aktr.a(this.this$0).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.3
 * JD-Core Version:    0.7.0.1
 */