package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

class ApolloFloatActivity$1
  implements Runnable
{
  ApolloFloatActivity$1(ApolloFloatActivity paramApolloFloatActivity, Resources paramResources, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((ApolloFloatActivity)localObject).rightView = new TextView((Context)localObject);
    this.this$0.rightView.setBackgroundResource(2130853306);
    localObject = new RelativeLayout.LayoutParams(ViewUtils.dip2px(50.0F), ViewUtils.dip2px(52.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(5.0F);
    this.this$0.rightView.setTextColor(this.a.getColor(2131167987));
    this.this$0.rightView.setGravity(17);
    this.this$0.rightView.setTextSize(17.0F);
    this.this$0.rightView.setText(2131887812);
    this.this$0.rightView.setOnClickListener(this.this$0);
    this.b.addView(this.this$0.rightView, (ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloFloatActivity.1
 * JD-Core Version:    0.7.0.1
 */