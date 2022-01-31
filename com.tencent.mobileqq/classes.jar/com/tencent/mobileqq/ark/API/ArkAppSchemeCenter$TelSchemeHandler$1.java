package com.tencent.mobileqq.ark.API;

import alqi;
import alqj;
import alqk;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bbcv;
import bbgg;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppSchemeCenter$TelSchemeHandler$1
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$1(alqi paramalqi, String paramString) {}
  
  public void run()
  {
    bbgg localbbgg = bbcv.a(BaseActivity.sTopActivity, this.a);
    TextView localTextView = (TextView)localbbgg.findViewById(2131365147);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localbbgg.setPositiveButton(2131691644, new alqj(this, localbbgg));
    localbbgg.setNegativeButton(2131690596, new alqk(this, localbbgg));
    try
    {
      localbbgg.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */