package com.tencent.mobileqq.activity.aio.rebuild.input.funbtn;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IFunBtnEnabledCheck;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;

public class PhotoFunBtnEnabledCheck
  implements IFunBtnEnabledCheck
{
  public boolean a(AIOContext paramAIOContext)
  {
    return ((PhotoListHelper)paramAIOContext.a(7)).f() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.funbtn.PhotoFunBtnEnabledCheck
 * JD-Core Version:    0.7.0.1
 */