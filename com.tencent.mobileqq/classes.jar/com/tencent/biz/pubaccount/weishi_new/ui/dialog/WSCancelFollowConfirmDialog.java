package com.tencent.biz.pubaccount.weishi_new.ui.dialog;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/dialog/WSCancelFollowConfirmDialog;", "Lcom/tencent/biz/pubaccount/weishi_new/ui/dialog/WSBottomDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onConfirmDialogClickListener", "Lcom/tencent/biz/pubaccount/weishi_new/ui/dialog/WSOnConfirmDialogClickListener;", "getOnConfirmDialogClickListener", "()Lcom/tencent/biz/pubaccount/weishi_new/ui/dialog/WSOnConfirmDialogClickListener;", "setOnConfirmDialogClickListener", "(Lcom/tencent/biz/pubaccount/weishi_new/ui/dialog/WSOnConfirmDialogClickListener;)V", "initView", "", "onClick", "v", "Landroid/view/View;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSCancelFollowConfirmDialog
  extends WSBottomDialog
  implements View.OnClickListener
{
  @Nullable
  private WSOnConfirmDialogClickListener a;
  
  public WSCancelFollowConfirmDialog(@NotNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private final void a()
  {
    setContentView(1929773059);
    View localView = findViewById(1929707584);
    View.OnClickListener localOnClickListener = (View.OnClickListener)this;
    localView.setOnClickListener(localOnClickListener);
    findViewById(1929707583).setOnClickListener(localOnClickListener);
  }
  
  public final void a(@Nullable WSOnConfirmDialogClickListener paramWSOnConfirmDialogClickListener)
  {
    this.a = paramWSOnConfirmDialogClickListener;
  }
  
  public void onClick(@Nullable View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 1929707584))
    {
      paramView = this.a;
      if (paramView != null) {
        paramView.a();
      }
    }
    else
    {
      if (paramView == null) {
        return;
      }
      if (paramView.intValue() == 1929707583)
      {
        paramView = this.a;
        if (paramView != null) {
          paramView.b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.dialog.WSCancelFollowConfirmDialog
 * JD-Core Version:    0.7.0.1
 */