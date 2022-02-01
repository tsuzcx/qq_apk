package com.tencent.biz.eqq;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;

final class CrmIvrText$1
  implements Runnable
{
  CrmIvrText$1(QQAppInterface paramQQAppInterface, View paramView, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a;
    Context localContext = this.b.getContext();
    String str = this.c;
    CrmUtils.a(localQQAppInterface, localContext, str, CrmUtils.c(this.a, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmIvrText.1
 * JD-Core Version:    0.7.0.1
 */