package com.tencent.mobileqq.apollo.store;

import aiug;
import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;

public class ApolloViewController$3
  implements Runnable
{
  public ApolloViewController$3(aiug paramaiug, Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((aiug.a(this.this$0) == null) || (aiug.a(this.this$0) == null)) {
      return;
    }
    if (aiug.a(this.this$0) == null)
    {
      aiug.a(this.this$0, new ApolloImageShareLayout(this.jdField_a_of_type_AndroidAppActivity));
      aiug.a(this.this$0).a(aiug.a(this.this$0).getWidth(), aiug.a(this.this$0).getHeight(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, aiug.a(this.this$0).roleId, aiug.a(this.this$0).dressIds, this.this$0.a);
      aiug.a(this.this$0).addView(aiug.a(this.this$0), new FrameLayout.LayoutParams(-1, -1));
    }
    aiug.a(this.this$0).bringToFront();
    aiug.a(this.this$0).a(aiug.a(this.this$0).roleId, aiug.a(this.this$0).dressIds, this.this$0.a, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */