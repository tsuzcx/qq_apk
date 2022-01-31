package com.dataline.activities;

import alud;
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
    ((TextView)findViewById(2131368624)).setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131368655);
    localTextView.setVisibility(0);
    localTextView.setText(alud.a(2131708817));
    localTextView.setOnClickListener(new cq(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131165395);
    setContentView(2131558981);
    setTitle(2131691412);
    super.getWindow().setBackgroundDrawable(null);
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterDefaultActivity
 * JD-Core Version:    0.7.0.1
 */