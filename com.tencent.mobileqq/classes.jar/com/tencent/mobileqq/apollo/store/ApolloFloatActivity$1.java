package com.tencent.mobileqq.apollo.store;

import actn;
import android.content.res.Resources;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class ApolloFloatActivity$1
  implements Runnable
{
  ApolloFloatActivity$1(ApolloFloatActivity paramApolloFloatActivity, Resources paramResources, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    this.this$0.a = new TextView(this.this$0);
    this.this$0.a.setBackgroundResource(2130849546);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(actn.a(50.0F, this.jdField_a_of_type_AndroidContentResResources), actn.a(52.0F, this.jdField_a_of_type_AndroidContentResResources));
    if (ApolloFloatActivity.a(this.this$0) == 1)
    {
      this.this$0.a.setTextColor(-16777216);
      this.this$0.a.setVisibility(8);
    }
    for (;;)
    {
      this.this$0.a.setGravity(17);
      this.this$0.a.setTextSize(17.0F);
      this.this$0.a.setText(2131690832);
      this.this$0.a.setOnClickListener(this.this$0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.this$0.a, localLayoutParams);
      return;
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.rightMargin = actn.a(5.0F, this.jdField_a_of_type_AndroidContentResResources);
      this.this$0.a.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131166848));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloFloatActivity.1
 * JD-Core Version:    0.7.0.1
 */