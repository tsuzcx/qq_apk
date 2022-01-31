package com.tencent.mobileqq.ark.API;

import alqh;
import alqi;
import alqj;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bbdj;
import bbgu;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppSchemeCenter$TelSchemeHandler$1
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$1(alqh paramalqh, String paramString) {}
  
  public void run()
  {
    bbgu localbbgu = bbdj.a(BaseActivity.sTopActivity, this.a);
    TextView localTextView = (TextView)localbbgu.findViewById(2131365146);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localbbgu.setPositiveButton(2131691644, new alqi(this, localbbgu));
    localbbgu.setNegativeButton(2131690596, new alqj(this, localbbgu));
    try
    {
      localbbgu.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */