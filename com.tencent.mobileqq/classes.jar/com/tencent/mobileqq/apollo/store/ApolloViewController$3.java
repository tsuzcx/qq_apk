package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;

class ApolloViewController$3
  implements Runnable
{
  ApolloViewController$3(ApolloViewController paramApolloViewController, Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((ApolloViewController.a(this.this$0) == null) || (ApolloViewController.a(this.this$0) == null)) {
      return;
    }
    if (ApolloViewController.a(this.this$0) == null)
    {
      ApolloViewController.a(this.this$0, new ApolloImageShareLayout(this.jdField_a_of_type_AndroidAppActivity));
      ApolloViewController.a(this.this$0).a(ApolloViewController.a(this.this$0).getWidth(), ApolloViewController.a(this.this$0).getHeight(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, ApolloViewController.a(this.this$0).roleId, ApolloViewController.a(this.this$0).dressIds, this.this$0.a);
      ApolloViewController.a(this.this$0).addView(ApolloViewController.a(this.this$0), new FrameLayout.LayoutParams(-1, -1));
    }
    ApolloViewController.a(this.this$0).bringToFront();
    ApolloViewController.a(this.this$0).a(ApolloViewController.a(this.this$0).roleId, ApolloViewController.a(this.this$0).dressIds, this.this$0.a, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */