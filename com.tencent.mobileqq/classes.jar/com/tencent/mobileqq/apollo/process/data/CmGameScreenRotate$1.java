package com.tencent.mobileqq.apollo.process.data;

import aing;
import aipj;
import aiqb;
import airm;
import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(aiqb paramaiqb, int paramInt) {}
  
  public void run()
  {
    if (aiqb.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = aing.a(aiqb.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((aipj)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((aiqb.a(this.this$0) != null) && (aiqb.a(this.this$0).getVisibility() == 0))
      {
        ((airm)localObject).a(false);
        aiqb.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((airm)localObject).a(true);
    aiqb.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */