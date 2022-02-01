package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePopWindowUpdateBalanceEvent;
import com.tencent.qphone.base.util.QLog;

class QCirclePolyLikePopWindow$5
  implements Runnable
{
  QCirclePolyLikePopWindow$5(QCirclePolyLikePopWindow paramQCirclePolyLikePopWindow, QCirclePopWindowUpdateBalanceEvent paramQCirclePopWindowUpdateBalanceEvent) {}
  
  public void run()
  {
    QCirclePolyLikePopWindow.e(this.this$0).setText(String.format(QCirclePolyLikePopWindow.d(this.this$0).getContext().getResources().getString(2131895839), new Object[] { Float.valueOf(this.a.balance) }));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveEvent update balance:");
    localStringBuilder.append(this.a.balance);
    QLog.d("QCirclePolymorphicLikePopWindow", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow.5
 * JD-Core Version:    0.7.0.1
 */