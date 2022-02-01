package com.tencent.biz.anonymous;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QQAnonymousDialog
  extends ReportDialog
{
  public View a;
  public ImageView b;
  public TextView c;
  public int d;
  public Context e;
  public LayoutInflater f;
  public Handler g = new Handler(new QQAnonymousDialog.1(this));
  
  public QQAnonymousDialog(Context paramContext)
  {
    super(paramContext, 2131953338);
    this.e = paramContext;
    this.f = LayoutInflater.from(paramContext);
    this.a = this.f.inflate(2131626659, null);
    this.c = ((TextView)this.a.findViewById(2131437636));
    this.b = ((ImageView)this.a.findViewById(2131437653));
  }
  
  public void a()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.width = ((int)DisplayUtils.a(this.e, 44.0F));
    localLayoutParams.height = ((int)DisplayUtils.a(this.e, 44.0F));
    super.show();
    this.a.postDelayed(new QQAnonymousDialog.2(this), 1000L);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        this.b.setImageResource(2130844767);
        this.c.setText(paramString);
        if (AppSetting.e) {
          QQAppInterface.speak(paramString);
        }
      }
      else
      {
        this.d = 0;
        this.b.setImageResource(2130844772);
        this.c.setText(this.e.getResources().getString(2131893816));
      }
    }
    else
    {
      this.b.setImageResource(2130844773);
      this.c.setText(paramString);
      if (AppSetting.e) {
        QQAppInterface.speak(paramString);
      }
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.a);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.anonymous.QQAnonymousDialog
 * JD-Core Version:    0.7.0.1
 */