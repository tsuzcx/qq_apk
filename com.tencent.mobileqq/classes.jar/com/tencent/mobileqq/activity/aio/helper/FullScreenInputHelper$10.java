package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.TextMenuListener;

class FullScreenInputHelper$10
  implements XEditTextEx.TextMenuListener
{
  FullScreenInputHelper$10(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public boolean a()
  {
    if (FullScreenInputHelper.a(this.a).a.length() > 0) {
      return this.a.b(false);
    }
    return false;
  }
  
  public boolean b()
  {
    if (FullScreenInputHelper.a(this.a).a.length() > 0) {
      return this.a.b(true);
    }
    return false;
  }
  
  public boolean c()
  {
    return this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.10
 * JD-Core Version:    0.7.0.1
 */