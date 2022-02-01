package com.tencent.mobileqq.auto.engine.lib.delegateimpl;

import com.tencent.mobileqq.auto.engine.lib.IToastDelegate;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class ASToastImpl
  implements IToastDelegate
{
  public int getIconTypeDefault()
  {
    return 0;
  }
  
  public int getIconTypeError()
  {
    return 1;
  }
  
  public int getIconTypeNone()
  {
    return -1;
  }
  
  public int getIconTypeSuccess()
  {
    return 2;
  }
  
  public void makeTextAndShow(int paramInt1, String paramString, int paramInt2)
  {
    QQToast.makeText(MobileQQ.sMobileQQ, paramInt1, paramString, paramInt2).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.lib.delegateimpl.ASToastImpl
 * JD-Core Version:    0.7.0.1
 */