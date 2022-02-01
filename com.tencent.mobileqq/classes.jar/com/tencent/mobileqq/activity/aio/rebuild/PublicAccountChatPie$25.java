package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PublicAccountChatPie$25
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountChatPie$25(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.a.cj) {
      return;
    }
    paramView = this.a;
    paramView.cj = true;
    if ((paramView.bv != null) && (this.a.bv.length > 0))
    {
      this.a.s(2131893010);
      paramInt = this.a.bv[0];
      if (paramInt == 0) {
        this.a.a(true, 0);
      } else {
        this.a.a(false, paramInt);
      }
    }
    else
    {
      this.a.s(2131893010);
      this.a.a(true, 0);
    }
    this.a.ck.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.25
 * JD-Core Version:    0.7.0.1
 */