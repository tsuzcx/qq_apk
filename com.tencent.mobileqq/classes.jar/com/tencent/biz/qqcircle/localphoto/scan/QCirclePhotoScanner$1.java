package com.tencent.biz.qqcircle.localphoto.scan;

import android.os.Handler.Callback;
import android.os.Message;

class QCirclePhotoScanner$1
  implements Handler.Callback
{
  QCirclePhotoScanner$1(QCirclePhotoScanner paramQCirclePhotoScanner) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            QCirclePhotoScanner.d(this.a);
          }
        }
        else {
          QCirclePhotoScanner.c(this.a);
        }
      }
      else {
        QCirclePhotoScanner.b(this.a);
      }
    }
    else {
      QCirclePhotoScanner.a(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.QCirclePhotoScanner.1
 * JD-Core Version:    0.7.0.1
 */