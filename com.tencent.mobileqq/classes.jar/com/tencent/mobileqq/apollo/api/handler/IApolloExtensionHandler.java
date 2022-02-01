package com.tencent.mobileqq.apollo.api.handler;

import android.os.Bundle;
import com.tencent.gamecenter.common.util.ReportInfoManager.ReportChannlInfo;
import com.tencent.mobileqq.apollo.request.ApolloRequestCallbackManager.ApolloRspCallback;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseSetCallback;
import com.tencent.mobileqq.widget.ColorClearableEditText.Paragraph;
import java.util.ArrayList;
import java.util.List;

public abstract interface IApolloExtensionHandler
{
  public abstract QQAppInterface a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void a(int paramInt, Bundle paramBundle, PraiseManager.OnPraiseSetCallback paramOnPraiseSetCallback);
  
  public abstract void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3);
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(int paramInt1, String paramString1, boolean paramBoolean, int paramInt2, String paramString2);
  
  public abstract void a(int paramInt, List<MessageRecord> paramList);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(ReportInfoManager.ReportChannlInfo paramReportChannlInfo);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt, ApolloRequestCallbackManager.ApolloRspCallback paramApolloRspCallback);
  
  public abstract void a(String paramString1, int paramInt, String paramString2);
  
  public abstract void a(String paramString, MessageMicro paramMessageMicro, Class paramClass, BusinessObserver paramBusinessObserver);
  
  public abstract void a(String paramString1, String paramString2, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver);
  
  public abstract void a(String paramString, ArrayList<ColorClearableEditText.Paragraph> paramArrayList, int paramInt);
  
  public abstract void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver);
  
  public abstract void a(ArrayList<Long> paramArrayList, String paramString);
  
  public abstract void a(long... paramVarArgs);
  
  public abstract void a(String[] paramArrayOfString);
  
  public abstract void a(String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt);
  
  public abstract boolean a(String paramString1, String paramString2);
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(String paramString);
  
  public abstract void c(String paramString);
  
  public abstract void d(String paramString);
  
  public abstract void e(String paramString);
  
  public abstract void f(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler
 * JD-Core Version:    0.7.0.1
 */