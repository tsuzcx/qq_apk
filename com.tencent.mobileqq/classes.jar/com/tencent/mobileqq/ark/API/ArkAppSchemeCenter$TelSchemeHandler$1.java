package com.tencent.mobileqq.ark.API;

import albu;
import albv;
import albw;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import babr;
import bafb;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppSchemeCenter$TelSchemeHandler$1
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$1(albu paramalbu, String paramString) {}
  
  public void run()
  {
    bafb localbafb = babr.a(BaseActivity.sTopActivity, this.a);
    TextView localTextView = (TextView)localbafb.findViewById(2131299579);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localbafb.setPositiveButton(2131626068, new albv(this, localbafb));
    localbafb.setNegativeButton(2131625035, new albw(this, localbafb));
    try
    {
      localbafb.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */