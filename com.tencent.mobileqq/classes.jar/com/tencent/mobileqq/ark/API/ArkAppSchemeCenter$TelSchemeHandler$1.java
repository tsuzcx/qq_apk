package com.tencent.mobileqq.ark.API;

import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anlh;
import anli;
import anlj;
import bdgm;
import bdjz;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppSchemeCenter$TelSchemeHandler$1
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$1(anlh paramanlh, String paramString) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(BaseActivity.sTopActivity, this.a);
    TextView localTextView = (TextView)localbdjz.findViewById(2131365233);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localbdjz.setPositiveButton(2131691700, new anli(this, localbdjz));
    localbdjz.setNegativeButton(2131690648, new anlj(this, localbdjz));
    try
    {
      localbdjz.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */