package com.tencent.mobileqq.apollo.process.data;

import ajac;
import ajcf;
import ajcx;
import ajei;
import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(ajcx paramajcx, int paramInt) {}
  
  public void run()
  {
    if (ajcx.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = ajac.a(ajcx.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((ajcf)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((ajcx.a(this.this$0) != null) && (ajcx.a(this.this$0).getVisibility() == 0))
      {
        ((ajei)localObject).a(false);
        ajcx.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((ajei)localObject).a(true);
    ajcx.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */