package com.tencent.av.ui.funchat.zimu;

import android.os.Handler;
import android.os.Message;
import com.tencent.av.AVLog;
import java.lang.ref.WeakReference;

class ZimuItemViewFilm$myHander
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<ZimuItemViewFilm> jdField_a_of_type_JavaLangRefWeakReference;
  
  ZimuItemViewFilm$myHander(String paramString, ZimuItemViewFilm paramZimuItemViewFilm)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramZimuItemViewFilm);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ZimuItemViewFilm localZimuItemViewFilm = (ZimuItemViewFilm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localZimuItemViewFilm != null)
    {
      if (paramMessage.what != 0) {
        return;
      }
      ZimuItemViewFilm.a(localZimuItemViewFilm);
      AVLog.printColorLog(this.jdField_a_of_type_JavaLangString, "ITEM_DISPEAR");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemViewFilm.myHander
 * JD-Core Version:    0.7.0.1
 */