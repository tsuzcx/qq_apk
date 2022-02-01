package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import anfk;
import com.tencent.common.app.AppInterface;

public class ApolloViewController$3
  implements Runnable
{
  public ApolloViewController$3(anfk paramanfk, Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((anfk.a(this.this$0) == null) || (anfk.a(this.this$0) == null)) {
      return;
    }
    if (anfk.a(this.this$0) == null)
    {
      anfk.a(this.this$0, new ApolloImageShareLayout(this.jdField_a_of_type_AndroidAppActivity));
      anfk.a(this.this$0).a(anfk.a(this.this$0).getWidth(), anfk.a(this.this$0).getHeight(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, anfk.a(this.this$0).roleId, anfk.a(this.this$0).dressIds, this.this$0.a);
      anfk.a(this.this$0).addView(anfk.a(this.this$0), new FrameLayout.LayoutParams(-1, -1));
    }
    anfk.a(this.this$0).bringToFront();
    anfk.a(this.this$0).a(anfk.a(this.this$0).roleId, anfk.a(this.this$0).dressIds, this.this$0.a, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */