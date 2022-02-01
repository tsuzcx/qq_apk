package com.tencent.biz.qcircleshadow.delegateimpl;

import com.tencent.biz.qcircleshadow.lib.delegate.IToastDelegate;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class QCircleToastImpl
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
    QQToast.a(MobileQQ.sMobileQQ, paramInt1, paramString, paramInt2).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.delegateimpl.QCircleToastImpl
 * JD-Core Version:    0.7.0.1
 */