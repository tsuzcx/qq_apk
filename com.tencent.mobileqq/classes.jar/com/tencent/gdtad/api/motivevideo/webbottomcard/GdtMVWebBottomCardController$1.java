package com.tencent.gdtad.api.motivevideo.webbottomcard;

import acfo;
import com.tencent.qphone.base.util.QLog;

public class GdtMVWebBottomCardController$1
  implements Runnable
{
  public GdtMVWebBottomCardController$1(acfo paramacfo) {}
  
  public void run()
  {
    if (this.this$0.d)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "webView load success");
      return;
    }
    QLog.i("GdtMVWebBottomCardController", 1, "webView load over time");
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.webbottomcard.GdtMVWebBottomCardController.1
 * JD-Core Version:    0.7.0.1
 */