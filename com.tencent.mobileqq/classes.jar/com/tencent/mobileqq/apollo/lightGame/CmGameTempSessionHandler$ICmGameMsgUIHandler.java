package com.tencent.mobileqq.apollo.lightGame;

import com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.UserInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import java.util.List;

public abstract interface CmGameTempSessionHandler$ICmGameMsgUIHandler
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString, int paramInt, long paramLong);
  
  public abstract void a(String paramString, int paramInt, List<MessageForApollo> paramList);
  
  public abstract void a(String paramString, CmGameChatPie.UserInfo paramUserInfo);
  
  public abstract void a(String paramString, CmGameTempSessionHandler.TopGameInfo paramTopGameInfo);
  
  public abstract void a(String paramString, List<ApolloGameData> paramList);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2);
  
  public abstract void a(boolean paramBoolean, String paramString, int paramInt, long paramLong);
  
  public abstract void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong);
  
  public abstract void b(String paramString);
  
  public abstract void b(String paramString, int paramInt1, int paramInt2);
  
  public abstract void b(boolean paramBoolean, String paramString, int paramInt, long paramLong);
  
  public abstract void c(String paramString);
  
  public abstract void d(String paramString);
  
  public abstract void e(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.ICmGameMsgUIHandler
 * JD-Core Version:    0.7.0.1
 */