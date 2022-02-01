package com.tencent.mobileqq.Doraemon.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class SdkAuthDialog
  extends ReportDialog
{
  public static boolean a = false;
  public static final DownloadParams.DecodeHandler b = new SdkAuthDialog.5();
  private Context c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  
  public SdkAuthDialog(Context paramContext)
  {
    super(paramContext, 2131952196);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131625555, null);
    setContentView(paramContext);
    this.d = ((ImageView)a(paramContext, 2131428619));
    this.e = ((TextView)a(paramContext, 2131428632));
    this.f = ((TextView)a(paramContext, 2131428904));
    this.g = ((ImageView)a(paramContext, 2131449249));
    this.h = ((TextView)a(paramContext, 2131449279));
    this.i = ((TextView)a(paramContext, 2131428891));
    this.i.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.j = ((TextView)a(paramContext, 2131437091));
    this.k = ((TextView)a(paramContext, 2131444812));
    setCanceledOnTouchOutside(false);
    paramContext = getWindow();
    if (paramContext != null) {
      paramContext.setGravity(80);
    }
  }
  
  public <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public void a()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    setOnCancelListener(new SdkAuthDialog.3(this, paramOnCancelListener));
    setOnKeyListener(new SdkAuthDialog.4(this, paramOnCancelListener));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.k.setOnClickListener(new SdkAuthDialog.1(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    if (HttpUtil.isValidUrl(paramString))
    {
      paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
      ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
      paramString.setTag(new int[] { localLayoutParams.width, localLayoutParams.height, Utils.a(5.0F, this.c.getResources()) });
      paramString.setDecodeHandler(b);
      this.d.setImageDrawable(paramString);
    }
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.j.setOnClickListener(new SdkAuthDialog.2(this, paramOnClickListener));
  }
  
  public void b(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void c(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void d(String paramString)
  {
    this.i.setText(paramString);
  }
  
  public void e(String paramString)
  {
    this.k.setText(paramString);
  }
  
  public void f(String paramString)
  {
    this.j.setText(paramString);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog
 * JD-Core Version:    0.7.0.1
 */