package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.video.CmGameVideoViewController;

class CmGameScreenRotate$1
  implements Runnable
{
  CmGameScreenRotate$1(CmGameScreenRotate paramCmGameScreenRotate, int paramInt) {}
  
  public void run()
  {
    if (CmGameScreenRotate.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = CmGameUtil.a(CmGameScreenRotate.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((CmGameLauncher)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((CmGameScreenRotate.a(this.this$0) != null) && (CmGameScreenRotate.a(this.this$0).getVisibility() == 0))
      {
        ((CmGameVideoViewController)localObject).a(false);
        CmGameScreenRotate.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((CmGameVideoViewController)localObject).a(true);
    CmGameScreenRotate.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */