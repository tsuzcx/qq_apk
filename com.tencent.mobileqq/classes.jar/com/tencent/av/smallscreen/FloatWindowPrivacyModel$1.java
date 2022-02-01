package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.common.app.business.BaseVideoAppInterface;
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
      boolean bool = SmallScreenUtils.c(this.a.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface.getApp());
      if ((AudioHelper.b()) || (bool))
      {
        paramContext = new StringBuilder();
        paramContext.append("Receiver ACTION_SMALL_SCREEN_STATE, isFloatWindowOpAllowed[");
        paramContext.append(bool);
        paramContext.append("], state[");
        paramContext.append(i);
        paramContext.append("], seq[");
        paramContext.append(l);
        paramContext.append("]");
        QLog.w("FloatWindowPrivacyModel", 1, paramContext.toString());
      }
      if (bool) {
        this.a.jdField_a_of_type_MqqAppBaseActivity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.FloatWindowPrivacyModel.1
 * JD-Core Version:    0.7.0.1
 */