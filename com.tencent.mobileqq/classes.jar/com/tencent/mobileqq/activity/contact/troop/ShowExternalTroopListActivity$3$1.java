package com.tencent.mobileqq.activity.contact.troop;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;

class ShowExternalTroopListActivity$3$1
  implements Runnable
{
  ShowExternalTroopListActivity$3$1(ShowExternalTroopListActivity.3 param3, String paramString, Card paramCard) {}
  
  public void run()
  {
    this.c.a.setText(this.a);
    if (this.c.this$0.l)
    {
      this.c.b.setText(HardCodeUtil.a(2131911506));
      return;
    }
    this.c.b.setText(HardCodeUtil.a(2131911505));
    Object localObject;
    if (this.c.this$0.o != null)
    {
      localObject = ((IBizTroopMemberInfoService)this.c.this$0.app.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberCard(this.c.this$0.o, this.c.this$0.n);
      if (localObject != null)
      {
        if (((TroopMemberCard)localObject).sex == 1) {
          this.c.b.setText(HardCodeUtil.a(2131911507));
        }
        this.c.a.setText(((TroopMemberCard)localObject).nick);
      }
    }
    else
    {
      localObject = this.b;
      if ((localObject != null) && (((Card)localObject).shGender == 1)) {
        this.c.b.setText(HardCodeUtil.a(2131911508));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.3.1
 * JD-Core Version:    0.7.0.1
 */