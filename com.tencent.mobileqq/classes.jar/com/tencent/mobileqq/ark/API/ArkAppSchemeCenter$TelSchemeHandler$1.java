package com.tencent.mobileqq.ark.API;

import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import angy;
import angz;
import anha;
import bdcd;
import bdfq;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppSchemeCenter$TelSchemeHandler$1
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$1(angy paramangy, String paramString) {}
  
  public void run()
  {
    bdfq localbdfq = bdcd.a(BaseActivity.sTopActivity, this.a);
    TextView localTextView = (TextView)localbdfq.findViewById(2131365231);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localbdfq.setPositiveButton(2131691699, new angz(this, localbdfq));
    localbdfq.setNegativeButton(2131690648, new anha(this, localbdfq));
    try
    {
      localbdfq.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */