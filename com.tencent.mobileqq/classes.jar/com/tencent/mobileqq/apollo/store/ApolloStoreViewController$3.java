package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;

class ApolloStoreViewController$3
  implements Runnable
{
  ApolloStoreViewController$3(ApolloStoreViewController paramApolloStoreViewController, Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (ApolloStoreViewController.k(this.this$0) != null)
    {
      if (ApolloStoreViewController.a(this.this$0) == null) {
        return;
      }
      if (ApolloStoreViewController.l(this.this$0) == null)
      {
        ApolloStoreViewController.a(this.this$0, new ApolloImageShareLayout(this.a));
        ApolloStoreViewController.l(this.this$0).a(ApolloStoreViewController.k(this.this$0).getWidth(), ApolloStoreViewController.k(this.this$0).getHeight(), this.b, ApolloStoreViewController.a(this.this$0).roleId, ApolloStoreViewController.a(this.this$0).dressIds, ApolloStoreViewController.m(this.this$0));
        ApolloStoreViewController.k(this.this$0).addView(ApolloStoreViewController.l(this.this$0), new FrameLayout.LayoutParams(-1, -1));
      }
      ApolloStoreViewController.l(this.this$0).bringToFront();
      ApolloStoreViewController.l(this.this$0).a(ApolloStoreViewController.a(this.this$0).roleId, ApolloStoreViewController.a(this.this$0).dressIds, ApolloStoreViewController.m(this.this$0), this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreViewController.3
 * JD-Core Version:    0.7.0.1
 */