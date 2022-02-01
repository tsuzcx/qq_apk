package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ApolloFloatActivity$1
  implements Runnable
{
  ApolloFloatActivity$1(ApolloFloatActivity paramApolloFloatActivity, Resources paramResources, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((ApolloFloatActivity)localObject).rightView = new TextView((Context)localObject);
    this.this$0.rightView.setBackgroundResource(2130851075);
    localObject = new RelativeLayout.LayoutParams(AIOUtils.b(50.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.b(52.0F, this.jdField_a_of_type_AndroidContentResResources));
    if (ApolloFloatActivity.access$000(this.this$0) == 1)
    {
      this.this$0.rightView.setTextColor(-16777216);
      this.this$0.rightView.setVisibility(8);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentResResources);
      this.this$0.rightView.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131167050));
    }
    this.this$0.rightView.setGravity(17);
    this.this$0.rightView.setTextSize(17.0F);
    this.this$0.rightView.setText(2131690874);
    this.this$0.rightView.setOnClickListener(this.this$0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.this$0.rightView, (ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloFloatActivity.1
 * JD-Core Version:    0.7.0.1
 */