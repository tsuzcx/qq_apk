package com.tencent.mobileqq.activity.aio.coreui.input;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import java.util.Iterator;
import java.util.List;

class FunBtnUI$2
  implements View.OnLongClickListener
{
  FunBtnUI$2(FunBtnUI paramFunBtnUI) {}
  
  public boolean onLongClick(View paramView)
  {
    Iterator localIterator = FunBtnUI.a(this.a).p().c().i().iterator();
    while (localIterator.hasNext()) {
      ((IFunBtnLongClickCallback)localIterator.next()).a(FunBtnUI.a(this.a), paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI.2
 * JD-Core Version:    0.7.0.1
 */