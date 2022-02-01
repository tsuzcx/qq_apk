package com.tencent.mobileqq.apollo.process.data;

import anbd;
import ande;
import android.app.Activity;
import andw;
import anfj;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(andw paramandw, int paramInt) {}
  
  public void run()
  {
    if (andw.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = anbd.a(andw.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((ande)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((andw.a(this.this$0) != null) && (andw.a(this.this$0).getVisibility() == 0))
      {
        ((anfj)localObject).a(false);
        andw.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((anfj)localObject).a(true);
    andw.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */