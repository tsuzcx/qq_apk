package com.tencent.luggage.setting.ui;

import com.tencent.luggage.wxa.eh.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class BizSubscribeMsgManagerUI$d$a
  implements Runnable
{
  BizSubscribeMsgManagerUI$d$a(BizSubscribeMsgManagerUI.d paramd, c paramc) {}
  
  public final void run()
  {
    if (this.a.a.isFinishing()) {
      return;
    }
    BizSubscribeMsgManagerUI.a(this.a.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.BizSubscribeMsgManagerUI.d.a
 * JD-Core Version:    0.7.0.1
 */