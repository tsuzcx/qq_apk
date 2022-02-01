package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class FastWebActivity$26$1$1
  implements InvocationHandler
{
  FastWebActivity$26$1$1(FastWebActivity.26.1 param1) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    this.a.a.a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    FastWebActivity.a(this.a.a.a).setVisibility(8);
    QLog.d("FastWebActivity", 1, "open web page, set activity transparent");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.26.1.1
 * JD-Core Version:    0.7.0.1
 */