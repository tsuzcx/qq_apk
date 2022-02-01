package com.tencent.mobileqq.app.utils;

import android.os.Message;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

class MessageRoamHandler$ChatHistoryMessageObserver
  extends MessageObserver
{
  private int b;
  
  public MessageRoamHandler$ChatHistoryMessageObserver(MessageRoamHandler paramMessageRoamHandler, int paramInt)
  {
    this.b = paramInt;
  }
  
  protected void onUpdateDelRoamChat(boolean paramBoolean)
  {
    if (this.a.a != this.b) {
      return;
    }
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)MessageRoamHandler.a(this.a).getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (!paramBoolean)
    {
      localMessageRoamManager.a(8, null);
      return;
    }
    localMessageRoamManager.a(9, null);
  }
  
  protected void onUpdateGetRoamChat(boolean paramBoolean, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onUpdateRoamMsgSearchResult(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Object localObject1 = (HashMap)paramObject;
    Object localObject2 = (String)((HashMap)localObject1).get("KEYWORD");
    long l = ((Long)((HashMap)localObject1).get("SEARCHSEQUENCE")).longValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateRoamMsgSearchResult isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",keyword:");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(",sequence:");
      localStringBuilder.append(l);
      QLog.d("Q.roammsg", 2, localStringBuilder.toString());
    }
    localObject2 = MessageRoamHandler.a(this.a).getHandler(C2CMessageSearchDialog.class);
    if (!paramBoolean)
    {
      localObject1 = ((MqqHandler)localObject2).obtainMessage(4);
      ((Message)localObject1).obj = paramObject;
      ((MqqHandler)localObject2).sendMessage((Message)localObject1);
      return;
    }
    if (((HashMap)localObject1).get("SEARCHRESULT") != null)
    {
      localObject1 = ((MqqHandler)localObject2).obtainMessage(5);
      ((Message)localObject1).obj = paramObject;
      ((MqqHandler)localObject2).sendMessage((Message)localObject1);
    }
  }
  
  protected void onUpdateSetRoamChat(boolean paramBoolean)
  {
    if (this.a.a != this.b) {
      return;
    }
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)MessageRoamHandler.a(this.a).getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (!paramBoolean)
    {
      localMessageRoamManager.a(7, null);
      return;
    }
    localMessageRoamManager.a(6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.MessageRoamHandler.ChatHistoryMessageObserver
 * JD-Core Version:    0.7.0.1
 */