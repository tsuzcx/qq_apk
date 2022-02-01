package com.tencent.biz.pubaccount.weishi_new.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/dialog/WSBottomDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initWindow", "", "setContentView", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResID", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public class WSBottomDialog
  extends Dialog
{
  public WSBottomDialog(@NotNull Context paramContext)
  {
    super(paramContext, 1929904129);
  }
  
  private final void a()
  {
    Object localObject = getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getAttributes();
      ((WindowManager.LayoutParams)localObject).width = -1;
      ((WindowManager.LayoutParams)localObject).height = -2;
      ((WindowManager.LayoutParams)localObject).gravity = 80;
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    a();
  }
  
  public void setContentView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.setContentView(paramView);
    a();
  }
  
  public void setContentView(@NotNull View paramView, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.setContentView(paramView, paramLayoutParams);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.dialog.WSBottomDialog
 * JD-Core Version:    0.7.0.1
 */