package com.tencent.mobileqq.apollo.game;

import android.util.LruCache;

class ApolloGameResManager$1
  extends LruCache<String, ApolloGameResManager.ApolloGameRes>
{
  ApolloGameResManager$1(ApolloGameResManager paramApolloGameResManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, ApolloGameResManager.ApolloGameRes paramApolloGameRes)
  {
    if ((paramApolloGameRes != null) && (paramApolloGameRes.a != null)) {
      return paramApolloGameRes.a.length;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameResManager.1
 * JD-Core Version:    0.7.0.1
 */