package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import android.app.Dialog;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.OnInterceptDialogClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$schemeJumpAction$1", "Lcom/tencent/biz/pubaccount/weishi_new/util/OuterInterceptManager$OnInterceptDialogClickListener;", "onDialogShow", "", "dialog", "Landroid/app/Dialog;", "onNegativeClick", "onNotIntercept", "onPositiveClick", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgFragment$schemeJumpAction$1
  implements OuterInterceptManager.OnInterceptDialogClickListener
{
  public void a() {}
  
  public void a(@NotNull Dialog paramDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramDialog, "dialog");
    if ((paramDialog instanceof QQCustomDialog))
    {
      paramDialog = (QQCustomDialog)paramDialog;
      paramDialog.setTitle(WSMsgFragment.c(this.a).getString(1929838627));
      paramDialog.setMessage((CharSequence)WSMsgFragment.c(this.a).getString(1929838626));
    }
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragment.schemeJumpAction.1
 * JD-Core Version:    0.7.0.1
 */