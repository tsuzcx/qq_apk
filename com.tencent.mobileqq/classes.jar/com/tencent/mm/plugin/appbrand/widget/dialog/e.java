package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;

public class e
  extends WeUIProgresssDialog
  implements i, i.a
{
  private DialogInterface.OnShowListener a;
  private DialogInterface.OnDismissListener b;
  private DialogInterface.OnCancelListener c;
  private boolean d;
  private boolean e = true;
  private l f;
  private View g;
  
  public e(Context paramContext)
  {
    super(paramContext, 2131953304);
    try
    {
      onCreate(null);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void a()
  {
    DialogInterface.OnDismissListener localOnDismissListener = this.b;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(this);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(l paraml)
  {
    DialogInterface.OnShowListener localOnShowListener = this.a;
    if (localOnShowListener != null) {
      localOnShowListener.onShow(this);
    }
    this.f = paraml;
  }
  
  public void dismiss()
  {
    l locall = this.f;
    if (locall != null)
    {
      locall.b(this);
      a();
    }
  }
  
  public void e()
  {
    DialogInterface.OnCancelListener localOnCancelListener = this.c;
    if (localOnCancelListener != null) {
      localOnCancelListener.onCancel(this);
    }
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public boolean g()
  {
    return this.e;
  }
  
  public View getContentView()
  {
    return this.g;
  }
  
  public int h()
  {
    return 1;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    this.e = paramBoolean;
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    this.d = paramBoolean;
  }
  
  public void setContentView(@LayoutRes int paramInt)
  {
    setContentView(LayoutInflater.from(getContext()).inflate(paramInt, null));
  }
  
  public void setContentView(@NonNull View paramView)
  {
    this.g = paramView;
  }
  
  public void setContentView(@NonNull View paramView, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    setContentView(paramView);
  }
  
  public void setOnCancelListener(@Nullable DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super.setOnCancelListener(paramOnCancelListener);
    this.c = paramOnCancelListener;
  }
  
  public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    super.setOnDismissListener(paramOnDismissListener);
    this.b = paramOnDismissListener;
  }
  
  public void setOnShowListener(@Nullable DialogInterface.OnShowListener paramOnShowListener)
  {
    super.setOnShowListener(paramOnShowListener);
    this.a = paramOnShowListener;
  }
  
  public void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.e
 * JD-Core Version:    0.7.0.1
 */