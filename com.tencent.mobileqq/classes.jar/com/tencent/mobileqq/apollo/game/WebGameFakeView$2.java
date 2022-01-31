package com.tencent.mobileqq.apollo.game;

import aixs;
import android.content.Intent;
import android.text.TextUtils;

class WebGameFakeView$2
  implements Runnable
{
  WebGameFakeView$2(WebGameFakeView paramWebGameFakeView, Intent paramIntent) {}
  
  public void run()
  {
    if (this.a != null)
    {
      WebGameFakeView.Director localDirector = new WebGameFakeView.Director();
      String str = this.a.getStringExtra(WebGameFakeView.Director.TITLE);
      if (!TextUtils.isEmpty(str)) {
        localDirector.title = str;
      }
      str = this.a.getStringExtra(WebGameFakeView.Director.FOREGROUND_COLOR);
      if (!TextUtils.isEmpty(str)) {
        localDirector.frontColor = str;
      }
      str = this.a.getStringExtra(WebGameFakeView.Director.BACKGROUND_COLOR);
      if (!TextUtils.isEmpty(str)) {
        localDirector.bgColor = str;
      }
      this.this$0.a = localDirector;
      this.this$0.a();
      this.a.putExtra("Director", localDirector);
    }
    aixs.a().a(this.a, ApolloWebViewFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.WebGameFakeView.2
 * JD-Core Version:    0.7.0.1
 */