package com.tencent.biz.pubaccount.weishi_new.combo.main.receiver;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.combo.main.WSComboMainFragment;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/main/receiver/WSComboMainForUserAuthReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSUserAuthEvent;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainFragment;)V", "fragmentRef", "Lmqq/util/WeakReference;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboMainForUserAuthReceiver
  implements WSSimpleEventReceiver<WSUserAuthEvent>
{
  private final WeakReference<WSComboMainFragment> a;
  
  public WSComboMainForUserAuthReceiver(@NotNull WSComboMainFragment paramWSComboMainFragment)
  {
    this.a = new WeakReference(paramWSComboMainFragment);
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (WSComboMainFragment)this.a.get();
    if (paramWSSimpleBaseEvent != null) {
      paramWSSimpleBaseEvent = paramWSSimpleBaseEvent.getActivity();
    } else {
      paramWSSimpleBaseEvent = null;
    }
    WSUserAuthDialog.a((Context)paramWSSimpleBaseEvent, "frame");
  }
  
  @NotNull
  public ArrayList<Class<WSUserAuthEvent>> z()
  {
    return CollectionsKt.arrayListOf(new Class[] { WSUserAuthEvent.class });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.main.receiver.WSComboMainForUserAuthReceiver
 * JD-Core Version:    0.7.0.1
 */