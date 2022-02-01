package com.tencent.mobileqq.ark.API;

import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import apxj;
import apxk;
import apxl;
import bhlq;
import bhpc;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppSchemeCenter$TelSchemeHandler$1
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$1(apxj paramapxj, String paramString) {}
  
  public void run()
  {
    bhpc localbhpc = bhlq.a(BaseActivity.sTopActivity, this.a);
    TextView localTextView = (TextView)localbhpc.findViewById(2131365519);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localbhpc.setPositiveButton(2131691440, new apxk(this, localbhpc));
    localbhpc.setNegativeButton(2131690580, new apxl(this, localbhpc));
    try
    {
      localbhpc.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */