package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class DoodlePanel$3
  implements DoodleLayout.DoodleLayoutListener
{
  DoodlePanel$3(DoodlePanel paramDoodlePanel) {}
  
  public void a(int paramInt)
  {
    DoodlePanel.a(this.a);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      if (!DoodlePanel.b(this.a))
      {
        DoodlePanel.a(this.a, true);
        DoodlePanel.3.1 local1 = new DoodlePanel.3.1(this);
        DialogUtil.a(this.a.getContext(), 230, null, this.a.getContext().getString(2131886488), null, this.a.getContext().getString(2131886478), local1, null).show();
      }
    }
    else {
      QQToast.makeText(this.a.getContext(), this.a.getContext().getString(2131886480), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.3
 * JD-Core Version:    0.7.0.1
 */