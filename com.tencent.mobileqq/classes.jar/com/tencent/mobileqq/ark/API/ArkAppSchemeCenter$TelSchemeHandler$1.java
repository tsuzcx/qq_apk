package com.tencent.mobileqq.ark.API;

import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aptx;
import apty;
import aptz;
import bhdj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ArkAppSchemeCenter$TelSchemeHandler$1
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$1(aptx paramaptx, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(BaseActivity.sTopActivity, this.a);
    TextView localTextView = (TextView)localQQCustomDialog.findViewById(2131365644);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localQQCustomDialog.setPositiveButton(2131691565, new apty(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(2131690697, new aptz(this, localQQCustomDialog));
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */