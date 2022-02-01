package com.tencent.luggage.setting.ui;

import com.tencent.luggage.wxa.eg.a.a;
import com.tencent.luggage.wxa.ei.a;
import com.tencent.luggage.wxa.ih.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/setting/ui/BizSubscribeMsgManagerUI$initAdapter$1", "Lcom/tencent/luggage/setting/adapter/SubscribeMsgListAdapter$CheckBoxStateChangedListener;", "getState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onChanged", "", "check", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class BizSubscribeMsgManagerUI$b
  implements a.a
{
  public void a(@NotNull d paramd, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "item");
    a locala = BizSubscribeMsgManagerUI.a(this.a);
    if (locala != null) {
      locala.a(paramd, paramBoolean);
    }
  }
  
  public boolean a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "item");
    a locala = BizSubscribeMsgManagerUI.a(this.a);
    if (locala != null) {
      return locala.a(paramd);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.BizSubscribeMsgManagerUI.b
 * JD-Core Version:    0.7.0.1
 */