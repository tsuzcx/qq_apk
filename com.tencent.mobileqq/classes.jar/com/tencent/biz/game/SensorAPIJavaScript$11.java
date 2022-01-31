package com.tencent.biz.game;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import go;
import java.lang.ref.WeakReference;
import ndq;

class SensorAPIJavaScript$11
  extends Thread
{
  SensorAPIJavaScript$11(SensorAPIJavaScript paramSensorAPIJavaScript, Context paramContext, String paramString) {}
  
  public void run()
  {
    int i = 15;
    String str = "";
    if ((i > 0) && (this.this$0.a != null)) {
      if (this.this$0.a.get() == null) {
        i = 2;
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.this$0.c = false;
        if (QLog.isDevelopLevel()) {
          QLog.d("SensorApi", 4, "run check end: " + i);
        }
        if (i != 0) {
          break label200;
        }
        int j = this.this$0.a();
        this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ndq.a(Integer.toString(i)), ndq.a(str), ndq.a(Integer.toString(j)) });
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("SensorApi", 4, "run check: " + i);
        }
        str = go.a(this.jdField_a_of_type_AndroidContentContext);
        if (!TextUtils.isEmpty(str)) {
          i = 0;
        } else {
          try
          {
            Thread.sleep(2000L);
            i -= 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            i = 2;
          }
        }
      }
      continue;
      label200:
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ndq.a(Integer.toString(i)) });
      return;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.11
 * JD-Core Version:    0.7.0.1
 */