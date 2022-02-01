package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SeqUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

class FloatWindowPrivacyModel$1
  extends BroadcastReceiver
{
  FloatWindowPrivacyModel$1(FloatWindowPrivacyModel paramFloatWindowPrivacyModel) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.video.v2q.SmallScreenState"))
    {
      int i = paramIntent.getIntExtra("SmallScreenState", -1);
      long l = SeqUtil.a(paramIntent);
      boolean bool = SmallScreenUtils.c(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
      if ((AudioHelper.e()) || (bool)) {
        QLog.w("FloatWindowPrivacyModel", 1, "Receiver ACTION_SMALL_SCREEN_STATE, isFloatWindowOpAllowed[" + bool + "], state[" + i + "], seq[" + l + "]");
      }
      if (bool) {
        this.a.jdField_a_of_type_MqqAppBaseActivity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.FloatWindowPrivacyModel.1
 * JD-Core Version:    0.7.0.1
 */