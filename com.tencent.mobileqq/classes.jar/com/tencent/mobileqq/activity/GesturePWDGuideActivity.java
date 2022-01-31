package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import sra;

public class GesturePWDGuideActivity
  extends IphoneTitleBarActivity
{
  private Button a;
  
  private void a()
  {
    setTitle(2131436017);
    this.a = ((Button)findViewById(2131364687));
    this.a.setOnClickListener(new sra(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 999))
    {
      setResult(-1);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130969011);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDGuideActivity
 * JD-Core Version:    0.7.0.1
 */