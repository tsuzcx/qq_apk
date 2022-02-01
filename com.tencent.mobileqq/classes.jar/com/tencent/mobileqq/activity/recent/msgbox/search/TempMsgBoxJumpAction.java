package com.tencent.mobileqq.activity.recent.msgbox.search;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class TempMsgBoxJumpAction
  extends JumpAction
{
  public TempMsgBoxJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setFlags(67108864);
      PublicFragmentActivity.a(this.a, localIntent, TempMsgBoxFragment.class);
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("TempMsgBoxJumpAction", 1, localRuntimeException, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.search.TempMsgBoxJumpAction
 * JD-Core Version:    0.7.0.1
 */