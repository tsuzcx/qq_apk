package com.tencent.mobileqq.ark.api.scheme;

import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TelSchemeHandler$1
  implements Runnable
{
  TelSchemeHandler$1(TelSchemeHandler paramTelSchemeHandler, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(BaseActivity.sTopActivity, this.a);
    TextView localTextView = (TextView)localQQCustomDialog.findViewById(2131431876);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localQQCustomDialog.setPositiveButton(2131888562, new TelSchemeHandler.1.1(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(2131887648, new TelSchemeHandler.1.2(this, localQQCustomDialog));
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */