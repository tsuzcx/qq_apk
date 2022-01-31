package com.tencent.mobileqq.apollo.process.data;

import akro;
import aktr;
import akuj;
import akvu;
import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(akuj paramakuj, int paramInt) {}
  
  public void run()
  {
    if (akuj.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = akro.a(akuj.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((aktr)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((akuj.a(this.this$0) != null) && (akuj.a(this.this$0).getVisibility() == 0))
      {
        ((akvu)localObject).a(false);
        akuj.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((akvu)localObject).a(true);
    akuj.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */