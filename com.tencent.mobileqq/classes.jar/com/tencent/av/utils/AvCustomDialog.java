package com.tencent.av.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import kfr;
import kfs;

public class AvCustomDialog
  extends Dialog
{
  public AvCustomDialog(Context paramContext)
  {
    super(paramContext, 2131624516);
    a();
  }
  
  void a()
  {
    super.getWindow().setGravity(17);
    super.setContentView(2130969365);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131366289);
    localFrameLayout.setOnClickListener(new kfr(this));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
  }
  
  void b()
  {
    findViewById(2131366288).setOnClickListener(new kfs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.AvCustomDialog
 * JD-Core Version:    0.7.0.1
 */