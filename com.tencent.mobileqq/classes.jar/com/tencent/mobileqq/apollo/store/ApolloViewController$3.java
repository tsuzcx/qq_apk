package com.tencent.mobileqq.apollo.store;

import akzs;
import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;

public class ApolloViewController$3
  implements Runnable
{
  public ApolloViewController$3(akzs paramakzs, Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((akzs.a(this.this$0) == null) || (akzs.a(this.this$0) == null)) {
      return;
    }
    if (akzs.a(this.this$0) == null)
    {
      akzs.a(this.this$0, new ApolloImageShareLayout(this.jdField_a_of_type_AndroidAppActivity));
      akzs.a(this.this$0).a(akzs.a(this.this$0).getWidth(), akzs.a(this.this$0).getHeight(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, akzs.a(this.this$0).roleId, akzs.a(this.this$0).dressIds, this.this$0.a);
      akzs.a(this.this$0).addView(akzs.a(this.this$0), new FrameLayout.LayoutParams(-1, -1));
    }
    akzs.a(this.this$0).bringToFront();
    akzs.a(this.this$0).a(akzs.a(this.this$0).roleId, akzs.a(this.this$0).dressIds, this.this$0.a, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */