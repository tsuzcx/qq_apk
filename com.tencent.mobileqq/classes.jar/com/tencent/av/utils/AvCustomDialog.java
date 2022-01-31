package com.tencent.av.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import kgg;
import kgh;

public class AvCustomDialog
  extends Dialog
{
  public AvCustomDialog(Context paramContext)
  {
    super(paramContext, 2131624515);
    a();
  }
  
  void a()
  {
    super.getWindow().setGravity(17);
    super.setContentView(2130969364);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131366262);
    localFrameLayout.setOnClickListener(new kgg(this));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
  }
  
  void b()
  {
    findViewById(2131366261).setOnClickListener(new kgh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.AvCustomDialog
 * JD-Core Version:    0.7.0.1
 */