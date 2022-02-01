package com.tencent.comic;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class BoodoPluginLoadingDialog
  extends Dialog
  implements DialogInterface.OnDismissListener
{
  private final VipComicJumpActivity.LoadingCondition a;
  private BoodoPluginLoadingDialog.HippyActivityLaunchReceiver b;
  
  public BoodoPluginLoadingDialog(Context paramContext, VipComicJumpActivity.LoadingCondition paramLoadingCondition)
  {
    super(paramContext, 2131953338);
    setContentView(2131624611);
    this.a = paramLoadingCondition;
    a();
  }
  
  private void a()
  {
    setOnDismissListener(this);
    setCanceledOnTouchOutside(false);
    setCancelable(true);
    Object localObject = getWindow();
    ((Window)localObject).setGravity(80);
    if (Build.VERSION.SDK_INT >= 14)
    {
      ((Window)localObject).setDimAmount(0.0F);
      ((Window)localObject).setGravity(17);
    }
    localObject = LayoutInflater.from(getContext()).inflate(1996816386, null);
    ((ImageView)((View)localObject).findViewById(1996750881)).setImageResource(2130853467);
    setContentView((View)localObject);
    if (this.b == null)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("action_hippy_activity_launch");
      this.b = new BoodoPluginLoadingDialog.HippyActivityLaunchReceiver(this, null);
      getContext().registerReceiver(this.b, (IntentFilter)localObject);
    }
  }
  
  private void b()
  {
    if (this.b != null)
    {
      getContext().unregisterReceiver(this.b);
      this.b = null;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.b = true;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.BoodoPluginLoadingDialog
 * JD-Core Version:    0.7.0.1
 */