package com.tencent.mobileqq.apollo.game;

import android.util.LruCache;

class ApolloGameResManager$2
  extends LruCache<String, ApolloGameResManager.ApolloGameRes>
{
  protected int a(String paramString, ApolloGameResManager.ApolloGameRes paramApolloGameRes)
  {
    if ((paramApolloGameRes != null) && (paramApolloGameRes.a != null)) {
      return paramApolloGameRes.a.length;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameResManager.2
 * JD-Core Version:    0.7.0.1
 */