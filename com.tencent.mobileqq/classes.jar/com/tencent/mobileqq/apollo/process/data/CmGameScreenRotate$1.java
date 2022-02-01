package com.tencent.mobileqq.apollo.process.data;

import alvx;
import alxy;
import alyq;
import amad;
import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(alyq paramalyq, int paramInt) {}
  
  public void run()
  {
    if (alyq.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = alvx.a(alyq.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((alxy)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((alyq.a(this.this$0) != null) && (alyq.a(this.this$0).getVisibility() == 0))
      {
        ((amad)localObject).a(false);
        alyq.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((amad)localObject).a(true);
    alyq.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */