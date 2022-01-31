package com.tencent.mobileqq.armap;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

public class ARMapSupercellCardDialog
  extends Dialog
  implements View.OnClickListener
{
  Activity a;
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapSupercellCardDialog
 * JD-Core Version:    0.7.0.1
 */