package com.tencent.mobileqq.activity;

import abhw;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class GesturePWDGuideActivity
  extends IphoneTitleBarActivity
{
  private Button a;
  
  private void a()
  {
    setTitle(2131693004);
    this.a = ((Button)findViewById(2131367009));
    this.a.setOnClickListener(new abhw(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 999))
    {
      setResult(-1);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131559117);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDGuideActivity
 * JD-Core Version:    0.7.0.1
 */