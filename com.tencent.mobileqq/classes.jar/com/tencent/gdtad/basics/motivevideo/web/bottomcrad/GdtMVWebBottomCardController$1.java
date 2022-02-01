package com.tencent.gdtad.basics.motivevideo.web.bottomcrad;

import com.tencent.qphone.base.util.QLog;

class GdtMVWebBottomCardController$1
  implements Runnable
{
  GdtMVWebBottomCardController$1(GdtMVWebBottomCardController paramGdtMVWebBottomCardController) {}
  
  public void run()
  {
    if (this.this$0.d)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "webView load success");
      return;
    }
    QLog.i("GdtMVWebBottomCardController", 1, "webView load over time");
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.web.bottomcrad.GdtMVWebBottomCardController.1
 * JD-Core Version:    0.7.0.1
 */