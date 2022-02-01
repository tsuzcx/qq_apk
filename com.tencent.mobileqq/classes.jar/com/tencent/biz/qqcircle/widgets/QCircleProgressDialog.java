package com.tencent.biz.qqcircle.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppInterfaceUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QCircleProgressDialog
  extends ReportDialog
{
  String a;
  private Context b;
  private LayoutInflater c;
  private View d;
  private TextView e;
  private ImageView f = null;
  private ImageView g = null;
  private Animatable h;
  private LinearLayout i;
  private int j = 0;
  private int k = 48;
  private int l = -2;
  private QCircleProgressDialog.Callback m;
  
  public QCircleProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public QCircleProgressDialog(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 2131626921, 48);
  }
  
  public QCircleProgressDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, 2131953409);
    this.b = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.d = this.c.inflate(paramInt2, null);
    this.i = ((LinearLayout)this.d.findViewById(2131429577));
    this.e = ((TextView)this.d.findViewById(2131438913));
    this.j = paramInt1;
    this.k = paramInt3;
    this.f = ((ImageView)this.d.findViewById(2131447458));
    this.g = ((ImageView)this.d.findViewById(2131447459));
    this.h = ((Animatable)this.g.getDrawable());
  }
  
  public void a(int paramInt)
  {
    this.e.setText(paramInt);
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 106	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 111	com/tencent/biz/qqcircle/QCirclePluginUtil:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 111	com/tencent/biz/qqcircle/QCirclePluginUtil:a	(Landroid/app/Dialog;)V
    //   14: aload_1
    //   15: athrow
    //   16: astore_1
    //   17: goto -13 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	20	0	this	QCircleProgressDialog
    //   9	6	1	localObject	java.lang.Object
    //   16	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   0	4	16	java/lang/Exception
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (TextUtils.isEmpty(this.a)) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    if (QCircleHostConstants._AppSetting.enableTalkBack()) {
      HostAppInterfaceUtil.speak(this.a);
    }
    return true;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    QCircleProgressDialog.Callback localCallback = this.m;
    if (localCallback != null) {
      localCallback.a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.d);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = this.l;
    localLayoutParams.gravity = this.k;
    localLayoutParams.y += this.j;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
  
  protected void onStart()
  {
    this.g.postDelayed(new QCircleProgressDialog.1(this), 50L);
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.h.isRunning()) {
      this.h.stop();
    }
    super.onStop();
  }
  
  public void show()
  {
    Context localContext = this.b;
    if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing())) {
      return;
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleProgressDialog
 * JD-Core Version:    0.7.0.1
 */