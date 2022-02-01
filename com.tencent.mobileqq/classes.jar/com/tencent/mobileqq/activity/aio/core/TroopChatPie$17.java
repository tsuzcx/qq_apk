package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopChatPie$17
  extends BizTroopObserver
{
  TroopChatPie$17(TroopChatPie paramTroopChatPie) {}
  
  protected void a(Object paramObject)
  {
    if (this.a.V != null) {
      this.a.V.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.f.isResume()) {
      return;
    }
    if (paramBoolean1)
    {
      int i;
      if (paramBoolean2)
      {
        localObject = this.a.f;
        i = 2131893968;
      }
      else
      {
        localObject = this.a.f;
        i = 2131893876;
      }
      Object localObject = ((BaseActivity)localObject).getString(i);
      QQToast.makeText(this.a.f.getApplicationContext(), 2, (CharSequence)localObject, 1).show(this.a.f.getTitleBarHeight());
      return;
    }
    QQToast.makeText(this.a.f.getApplicationContext(), 1, 2131893967, 1).show(this.a.f.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.17
 * JD-Core Version:    0.7.0.1
 */