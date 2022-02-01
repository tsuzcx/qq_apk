package com.tencent.biz.qqstory.comment.lego;

import com.tencent.biz.ProtoServlet;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class LegoNetworkRequester
{
  public static LegoNetworkRequester a;
  
  public static LegoNetworkRequester a()
  {
    if (a == null) {
      a = new LegoNetworkRequester();
    }
    return a;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(LegoRequestBase paramLegoRequestBase, LegoResponseBase paramLegoResponseBase)
  {
    byte[] arrayOfByte = paramLegoRequestBase.a();
    String str = paramLegoRequestBase.a();
    long l = System.currentTimeMillis();
    a(paramLegoRequestBase.a(), arrayOfByte, new LegoNetworkRequester.1(this, l, paramLegoRequestBase, str, paramLegoResponseBase));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester
 * JD-Core Version:    0.7.0.1
 */