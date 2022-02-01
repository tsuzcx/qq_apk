package com.tencent.mobileqq.apollo.game;

import com.tencent.mobileqq.webprocess.WebAccelerateHelper;

class ApolloWebViewFragment$3
  implements Runnable
{
  ApolloWebViewFragment$3(ApolloWebViewFragment paramApolloWebViewFragment, String paramString) {}
  
  public void run()
  {
    WebAccelerateHelper.getInstance().preGetKey(this.a, ApolloWebViewFragment.a(this.this$0), null);
    WebAccelerateHelper.getInstance().preCheckOffline(this.a);
    WebAccelerateHelper.getInstance().preFetchResource(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebViewFragment.3
 * JD-Core Version:    0.7.0.1
 */