package com.tencent.mobileqq.apollo.process.data;

import akwd;
import akyg;
import akyy;
import alaj;
import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(akyy paramakyy, int paramInt) {}
  
  public void run()
  {
    if (akyy.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = akwd.a(akyy.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((akyg)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((akyy.a(this.this$0) != null) && (akyy.a(this.this$0).getVisibility() == 0))
      {
        ((alaj)localObject).a(false);
        akyy.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((alaj)localObject).a(true);
    akyy.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */