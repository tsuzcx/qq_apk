package com.tencent.mobileqq.apollo.process.data;

import ampj;
import amrk;
import amsc;
import amtp;
import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(amsc paramamsc, int paramInt) {}
  
  public void run()
  {
    if (amsc.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = ampj.a(amsc.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((amrk)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((amsc.a(this.this$0) != null) && (amsc.a(this.this$0).getVisibility() == 0))
      {
        ((amtp)localObject).a(false);
        amsc.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((amtp)localObject).a(true);
    amsc.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */