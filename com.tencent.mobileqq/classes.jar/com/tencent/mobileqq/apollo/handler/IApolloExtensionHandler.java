package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.profile.like.OnPraiseSetCallback;
import java.util.ArrayList;
import java.util.List;

public abstract interface IApolloExtensionHandler
{
  public abstract AppInterface a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void a(int paramInt, Bundle paramBundle, OnPraiseSetCallback paramOnPraiseSetCallback);
  
  public abstract void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3);
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(int paramInt, List<MessageRecord> paramList);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(ApolloBaseInfo paramApolloBaseInfo);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, long paramLong, String paramString2);
  
  public abstract void a(String paramString, MessageMicro paramMessageMicro, Class paramClass, BusinessObserver paramBusinessObserver);
  
  public abstract void a(String paramString, Object paramObject, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver);
  
  public abstract void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver);
  
  public abstract void a(ArrayList<Long> paramArrayList, String paramString);
  
  public abstract void a(long... paramVarArgs);
  
  public abstract void a(String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt);
  
  public abstract boolean a(String paramString1, String paramString2);
  
  public abstract void b(String paramString);
  
  public abstract void c();
  
  public abstract void c(int paramInt);
  
  public abstract void c(String paramString);
  
  public abstract void d(String paramString);
  
  public abstract void e(String paramString);
  
  public abstract void f(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler
 * JD-Core Version:    0.7.0.1
 */