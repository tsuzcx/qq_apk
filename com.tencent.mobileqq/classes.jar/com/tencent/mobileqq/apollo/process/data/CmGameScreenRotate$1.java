package com.tencent.mobileqq.apollo.process.data;

import amwn;
import amyo;
import amzg;
import anat;
import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(amzg paramamzg, int paramInt) {}
  
  public void run()
  {
    if (amzg.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = amwn.a(amzg.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((amyo)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((amzg.a(this.this$0) != null) && (amzg.a(this.this$0).getVisibility() == 0))
      {
        ((anat)localObject).a(false);
        amzg.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((anat)localObject).a(true);
    amzg.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */