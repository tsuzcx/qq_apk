package com.tencent.av.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class AvCustomDialog
  extends ReportDialog
{
  public AvCustomDialog(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, i);
    a();
  }
  
  void a()
  {
    super.getWindow().setGravity(17);
    super.setContentView(2131559774);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131373650);
    localFrameLayout.setOnClickListener(new AvCustomDialog.1(this));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
  }
  
  void b()
  {
    findViewById(2131373649).setOnClickListener(new AvCustomDialog.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AvCustomDialog
 * JD-Core Version:    0.7.0.1
 */