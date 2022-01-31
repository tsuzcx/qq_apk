package com.dataline.activities;

import alpo;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import cq;

public class PrinterDefaultActivity
  extends IphoneTitleBarActivity
{
  private void a()
  {
    ((TextView)findViewById(2131368613)).setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131368644);
    localTextView.setVisibility(0);
    localTextView.setText(alpo.a(2131708805));
    localTextView.setOnClickListener(new cq(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131165395);
    setContentView(2131558982);
    setTitle(2131691411);
    super.getWindow().setBackgroundDrawable(null);
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterDefaultActivity
 * JD-Core Version:    0.7.0.1
 */