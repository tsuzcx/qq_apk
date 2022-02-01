package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ShareResultDialog
  extends ReportDialog
{
  private View a;
  private View b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private Context h;
  private boolean i = false;
  private ShareResultDialog.IShareResultCallback j = null;
  
  public ShareResultDialog(Context paramContext)
  {
    super(paramContext, 2131953338);
    super.setContentView(2131624766);
    this.h = paramContext;
    a();
  }
  
  private void a()
  {
    this.a = super.findViewById(2131447475);
    this.b = super.findViewById(2131447469);
    this.c = ((TextView)super.findViewById(2131431864));
    this.d = ((TextView)super.findViewById(2131431870));
    this.e = ((TextView)super.findViewById(2131447473));
    ((ImageView)super.findViewById(2131447474)).setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
    this.f = ((TextView)super.findViewById(2131447467));
    ((ImageView)super.findViewById(2131447468)).setColorFilter(-909794, PorterDuff.Mode.MULTIPLY);
    this.g = ((TextView)super.findViewById(2131446515));
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("width:");
    ((StringBuilder)localObject).append(this.c.getLayoutParams().width);
    QLog.i("ShareToQZone", 2, ((StringBuilder)localObject).toString());
    int m = 0;
    if (paramBoolean) {
      this.d.setVisibility(0);
    } else {
      this.d.setVisibility(8);
    }
    localObject = this.b;
    if (this.i) {
      k = 8;
    } else {
      k = 0;
    }
    ((View)localObject).setVisibility(k);
    localObject = this.a;
    if (this.i) {
      k = 0;
    } else {
      k = 8;
    }
    ((View)localObject).setVisibility(k);
    localObject = this.g;
    int k = m;
    if (this.i) {
      k = 8;
    }
    ((TextView)localObject).setVisibility(k);
  }
  
  public void a(int paramInt)
  {
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setText(paramInt);
    }
  }
  
  public void a(ShareResultDialog.IShareResultCallback paramIShareResultCallback)
  {
    this.j = paramIShareResultCallback;
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.c.setText(paramString);
    this.c.setOnClickListener(new ShareResultDialog.1(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    TextView localTextView = this.g;
    if (localTextView != null)
    {
      if (paramInt != 0)
      {
        localTextView.setText(paramInt);
        return;
      }
      localTextView.setText("");
    }
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      b(false);
      return;
    }
    b(true);
    this.d.setText(paramString);
    this.d.setOnClickListener(new ShareResultDialog.2(this, paramOnClickListener));
  }
  
  public void c(int paramInt)
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setText(paramInt);
    }
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onBackPressed()
  {
    QLog.i("ShareResultDialog", 2, "onBackPressed");
    super.onBackPressed();
    ShareResultDialog.IShareResultCallback localIShareResultCallback = this.j;
    if (localIShareResultCallback != null)
    {
      boolean bool;
      if (this.d.getVisibility() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localIShareResultCallback.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareResultDialog
 * JD-Core Version:    0.7.0.1
 */