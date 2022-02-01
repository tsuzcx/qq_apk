package com.tencent.mobileqq.activity.aio.rebuild.input.righticon;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IOnRightIconClickListener;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

public class ComplexScriptOnclickListener
  implements IOnRightIconClickListener
{
  public boolean a(AIOContext paramAIOContext, View paramView)
  {
    if (TextUtils.isContainComplexScript(paramAIOContext.p().d().f().a().toString()))
    {
      QQToast.makeText(paramAIOContext.b(), HardCodeUtil.a(2131899189), 0).show();
      return true;
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.righticon.ComplexScriptOnclickListener
 * JD-Core Version:    0.7.0.1
 */