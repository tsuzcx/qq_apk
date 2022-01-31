package com.dataline.activities;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import cl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class PrinterDefaultActivity
  extends IphoneTitleBarActivity
{
  private void a()
  {
    ((TextView)findViewById(2131363245)).setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131363428);
    localTextView.setVisibility(0);
    localTextView.setText("关闭");
    localTextView.setOnClickListener(new cl(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131492895);
    setContentView(2130968884);
    setTitle(2131427673);
    super.getWindow().setBackgroundDrawable(null);
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.activities.PrinterDefaultActivity
 * JD-Core Version:    0.7.0.1
 */