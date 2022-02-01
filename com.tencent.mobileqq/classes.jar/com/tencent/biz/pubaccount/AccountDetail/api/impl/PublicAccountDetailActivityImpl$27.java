package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class PublicAccountDetailActivityImpl$27
  implements View.OnClickListener
{
  PublicAccountDetailActivityImpl$27(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("tel:");
    paramView.append(this.a);
    paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
    this.b.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.27
 * JD-Core Version:    0.7.0.1
 */