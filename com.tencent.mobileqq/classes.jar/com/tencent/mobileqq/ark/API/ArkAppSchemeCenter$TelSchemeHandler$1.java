package com.tencent.mobileqq.ark.API;

import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import apjt;
import apju;
import apjv;
import bglp;
import bgpa;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppSchemeCenter$TelSchemeHandler$1
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$1(apjt paramapjt, String paramString) {}
  
  public void run()
  {
    bgpa localbgpa = bglp.a(BaseActivity.sTopActivity, this.a);
    TextView localTextView = (TextView)localbgpa.findViewById(2131365475);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localbgpa.setPositiveButton(2131691437, new apju(this, localbgpa));
    localbgpa.setNegativeButton(2131690582, new apjv(this, localbgpa));
    try
    {
      localbgpa.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */