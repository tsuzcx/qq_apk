package com.tencent.mm.ui.widget.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ui.f;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

public class WeUIProgresssDialog
  extends ReportProgressDialog
{
  private Context a;
  private View b;
  private TextView c;
  private ProgressBar d;
  
  public WeUIProgresssDialog(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public WeUIProgresssDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    this.b = View.inflate(this.a, 2131625609, null);
    this.c = ((TextView)this.b.findViewById(2131440747));
    this.d = ((ProgressBar)this.b.findViewById(2131440746));
    setCanceledOnTouchOutside(true);
  }
  
  public static WeUIProgresssDialog getProgressDialog(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = new WeUIProgresssDialog(paramContext, 2131953304);
    paramContext.setMessage(paramCharSequence);
    paramContext.setCancelable(paramBoolean);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static WeUIProgresssDialog show(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = getProgressDialog(paramContext, paramCharSequence, paramBoolean, paramOnCancelListener);
    paramContext.show();
    return paramContext;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismiss exception, e = ");
      localStringBuilder.append(localException.getMessage());
      f.e("WeUI.WeUIProgresssDialog", localStringBuilder.toString(), new Object[0]);
    }
  }
  
  public void hideProgress()
  {
    ProgressBar localProgressBar = this.d;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(8);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.b, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      f.a("WeUI.WeUIProgresssDialog", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog
 * JD-Core Version:    0.7.0.1
 */