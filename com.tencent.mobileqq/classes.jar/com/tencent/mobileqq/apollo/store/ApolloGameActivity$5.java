package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

class ApolloGameActivity$5
  implements Runnable
{
  ApolloGameActivity$5(ApolloGameActivity paramApolloGameActivity) {}
  
  public void run()
  {
    ApolloGameActivity.a(this.this$0, ApolloUtilImpl.getGameIcon(CmGameUtil.a(), ApolloGameActivity.a(this.this$0)));
    if (ApolloGameActivity.a(this.this$0) != null) {
      ApolloGameActivity.a(this.this$0).a(ApolloGameActivity.a(this.this$0));
    }
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity.5
 * JD-Core Version:    0.7.0.1
 */