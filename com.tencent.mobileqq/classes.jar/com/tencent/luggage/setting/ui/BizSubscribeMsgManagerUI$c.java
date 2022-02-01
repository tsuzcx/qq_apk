package com.tencent.luggage.setting.ui;

import com.tencent.luggage.wxa.ei.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onStatusChange"}, k=3, mv={1, 1, 16})
final class BizSubscribeMsgManagerUI$c
  implements MMSwitchBtn.ISwitch
{
  BizSubscribeMsgManagerUI$c(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    Object localObject = BizSubscribeMsgManagerUI.b(this.a);
    if (localObject != null) {
      localObject = Boolean.valueOf(((MMSwitchBtn)localObject).isCheck());
    } else {
      localObject = null;
    }
    o.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsg onSwitchChanged %s", new Object[] { localObject });
    localObject = BizSubscribeMsgManagerUI.a(this.a);
    if (localObject != null)
    {
      MMSwitchBtn localMMSwitchBtn = BizSubscribeMsgManagerUI.b(this.a);
      if (localMMSwitchBtn != null) {
        paramBoolean = localMMSwitchBtn.isCheck();
      } else {
        paramBoolean = false;
      }
      ((a)localObject).a(paramBoolean);
    }
    localObject = BizSubscribeMsgManagerUI.b(this.a);
    if ((localObject != null) && (((MMSwitchBtn)localObject).isCheck() == true))
    {
      BizSubscribeMsgManagerUI.a(this.a, true);
      return;
    }
    BizSubscribeMsgManagerUI.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.BizSubscribeMsgManagerUI.c
 * JD-Core Version:    0.7.0.1
 */