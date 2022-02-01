package com.tencent.mobileqq.apollo.aio.item;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

final class ApolloItemBuilder$5
  implements Runnable
{
  ApolloItemBuilder$5(Context paramContext, int paramInt, String paramString) {}
  
  public void run()
  {
    QQToast.makeText(this.a.getApplicationContext(), this.b, this.c, 1).show(this.a.getResources().getDimensionPixelSize(2131299920));
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloItemBuilder", 2, "fav action number is 144");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */