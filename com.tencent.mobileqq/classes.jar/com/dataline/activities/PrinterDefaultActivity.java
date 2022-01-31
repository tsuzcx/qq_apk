package com.dataline.activities;

import ajya;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import eh;

public class PrinterDefaultActivity
  extends IphoneTitleBarActivity
{
  private void a()
  {
    ((TextView)findViewById(2131368429)).setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131368457);
    localTextView.setVisibility(0);
    localTextView.setText(ajya.a(2131708433));
    localTextView.setOnClickListener(new eh(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131165360);
    setContentView(2131558945);
    setTitle(2131691358);
    super.getWindow().setBackgroundDrawable(null);
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.PrinterDefaultActivity
 * JD-Core Version:    0.7.0.1
 */