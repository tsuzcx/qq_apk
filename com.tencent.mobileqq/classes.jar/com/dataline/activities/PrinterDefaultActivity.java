package com.dataline.activities;

import ajjy;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import co;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class PrinterDefaultActivity
  extends IphoneTitleBarActivity
{
  private void a()
  {
    ((TextView)findViewById(2131302804)).setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131302832);
    localTextView.setVisibility(0);
    localTextView.setText(ajjy.a(2131642637));
    localTextView.setOnClickListener(new co(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131099823);
    setContentView(2131493384);
    setTitle(2131625782);
    super.getWindow().setBackgroundDrawable(null);
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.PrinterDefaultActivity
 * JD-Core Version:    0.7.0.1
 */