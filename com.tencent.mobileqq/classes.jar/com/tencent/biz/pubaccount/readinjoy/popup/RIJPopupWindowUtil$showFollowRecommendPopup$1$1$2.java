package com.tencent.biz.pubaccount.readinjoy.popup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class RIJPopupWindowUtil$showFollowRecommendPopup$1$1$2
  implements DialogInterface.OnDismissListener
{
  public static final 2 a = new 2();
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new RIJFollowRecommendPopupEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJPopupWindowUtil.showFollowRecommendPopup.1.1.2
 * JD-Core Version:    0.7.0.1
 */