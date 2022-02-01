package com.tencent.mobileqq.apollo.store;

import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.util.WeakReferenceHandler;

class ApolloStoreViewController$4
  implements OnApolloViewListener
{
  ApolloStoreViewController$4(ApolloStoreViewController paramApolloStoreViewController, DisplayMetrics paramDisplayMetrics, ApolloStoreViewController.PlayActionData paramPlayActionData) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ApolloStoreViewController.a(this.c, true);
    float f = this.a.density;
    ApolloStoreViewController.a(this.c, paramInt1 / 2 / f);
    if ((ApolloStoreViewController.n(this.c) != null) && (ApolloStoreViewController.f(this.c) != null) && (ApolloStoreViewController.e(this.c) != null))
    {
      ApolloStoreViewController.n(this.c).onExecDispose();
      ApolloStoreViewController.f(this.c).onExecDispose();
      Message localMessage = ApolloStoreViewController.e(this.c).obtainMessage(19, this.b.actionType, this.b.activeId);
      if (this.b.previewOnFrame) {
        localMessage.obj = Float.valueOf(this.b.frameTime);
      }
      ApolloStoreViewController.e(this.c).sendMessageDelayed(localMessage, 100L);
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreViewController.4
 * JD-Core Version:    0.7.0.1
 */