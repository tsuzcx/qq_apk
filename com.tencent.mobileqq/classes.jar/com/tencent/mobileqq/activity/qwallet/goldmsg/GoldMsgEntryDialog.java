package com.tencent.mobileqq.activity.qwallet.goldmsg;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;

public class GoldMsgEntryDialog
  extends Dialog
{
  private ImageView a;
  
  public GoldMsgEntryDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131624518);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new ImageView(getContext());
    this.a.setImageResource(2130844166);
    paramBundle = getWindow();
    paramBundle.setContentView(this.a);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgEntryDialog
 * JD-Core Version:    0.7.0.1
 */