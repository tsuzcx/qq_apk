package com.tencent.mobileqq.apollo.process;

import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;

public final class CmGameUtil$2
  implements Runnable
{
  public CmGameUtil$2(PopupWindow paramPopupWindow) {}
  
  public void run()
  {
    try
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 2, "showNewPlusGuidePop err e=" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameUtil.2
 * JD-Core Version:    0.7.0.1
 */