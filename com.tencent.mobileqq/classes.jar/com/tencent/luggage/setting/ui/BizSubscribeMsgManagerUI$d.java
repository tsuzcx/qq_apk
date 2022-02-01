package com.tencent.luggage.setting.ui;

import com.tencent.luggage.wxa.eh.c;
import com.tencent.luggage.wxa.ei.b.a;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/setting/ui/BizSubscribeMsgManagerUI$loadData$1", "Lcom/tencent/luggage/setting/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onError", "", "onSuccess", "data", "Lcom/tencent/luggage/setting/entity/SubscribeMsgSettingData;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class BizSubscribeMsgManagerUI$d
  implements b.a
{
  public void a()
  {
    o.b("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList ERROR");
  }
  
  public void a(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "data");
    o.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList onSuccess");
    this.a.runOnUiThread((Runnable)new BizSubscribeMsgManagerUI.d.a(this, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.BizSubscribeMsgManagerUI.d
 * JD-Core Version:    0.7.0.1
 */