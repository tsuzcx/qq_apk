package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.apollo.listener.ApolloRspCallback;
import org.jetbrains.annotations.Nullable;

class ApolloPanel$30
  implements ApolloRspCallback
{
  ApolloPanel$30(ApolloPanel paramApolloPanel, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, long paramLong, @Nullable String paramString)
  {
    this.c.post(new ApolloPanel.30.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.30
 * JD-Core Version:    0.7.0.1
 */