package com.tencent.mobileqq.apollo.process.data;

import ajae;
import ajch;
import ajcz;
import ajek;
import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(ajcz paramajcz, int paramInt) {}
  
  public void run()
  {
    if (ajcz.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = ajae.a(ajcz.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((ajch)localObject).a();
    } while (localObject == null);
    if ((this.a == 0) || (this.a == 8))
    {
      if ((ajcz.a(this.this$0) != null) && (ajcz.a(this.this$0).getVisibility() == 0))
      {
        ((ajek)localObject).a(false);
        ajcz.a(this.this$0).setRequestedOrientation(this.a);
      }
      this.this$0.a = this.a;
      return;
    }
    ((ajek)localObject).a(true);
    ajcz.a(this.this$0).setRequestedOrientation(this.a);
    this.this$0.a = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */