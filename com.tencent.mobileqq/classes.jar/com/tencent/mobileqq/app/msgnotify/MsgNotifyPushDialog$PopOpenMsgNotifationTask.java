package com.tencent.mobileqq.app.msgnotify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class MsgNotifyPushDialog$PopOpenMsgNotifationTask
  extends AsyncTask<Void, Integer, Boolean>
{
  WeakReference<QQAppInterface> a;
  
  public MsgNotifyPushDialog$PopOpenMsgNotifationTask(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    try
    {
      Object localObject1 = (QQAppInterface)this.a.get();
      if (localObject1 == null) {
        return Boolean.valueOf(false);
      }
      if (!((QQAppInterface)localObject1).isLogin()) {
        return Boolean.valueOf(false);
      }
      if ((GuardManager.a != null) && (!GuardManager.a.a("com.tencent.mobileqq"))) {
        return Boolean.valueOf(false);
      }
      MsgNotifyPushDialog.a((QQAppInterface)localObject1);
      if ((MsgNotifyPushDialog.jdField_a_of_type_Boolean) && (!MsgNotifyPushDialog.jdField_c_of_type_Boolean) && (MsgNotifyPushDialog.jdField_a_of_type_AndroidContentIntent != null))
      {
        if ((MsgNotifyPushDialog.b != 0) && (Build.VERSION.SDK_INT > MsgNotifyPushDialog.b)) {
          return Boolean.valueOf(false);
        }
        paramVarArgs = ((QQAppInterface)localObject1).getCurrentUin();
        if (QQAppInterface.isNotificationEnabled() != 0) {
          break label756;
        }
        int i = 1;
        if (i != 0)
        {
          if (!MsgNotifyPushDialog.a((QQAppInterface)localObject1)) {
            return Boolean.valueOf(false);
          }
          localObject1 = PreferenceManager.getDefaultSharedPreferences(((QQAppInterface)localObject1).getApp());
          long l2 = System.currentTimeMillis();
          long l1 = MsgNotifyPushDialog.a();
          if (l1 == -1L) {
            MsgNotifyPushDialog.a(((SharedPreferences)localObject1).getLong("push_open_notify_lasttime", l2));
          }
          int j = ((SharedPreferences)localObject1).getInt("push_open_notify_stage", 1);
          int k = ((SharedPreferences)localObject1).getInt("push_open_notify_stage_count", 0);
          int n = ((SharedPreferences)localObject1).getInt("push_msg_notify_count", 0);
          int m = 2147483647;
          if (j == 1)
          {
            l1 = MsgNotifyPushDialog.jdField_c_of_type_Int * MsgNotifyPushDialog.jdField_a_of_type_Long;
            i = MsgNotifyPushDialog.d;
          }
          else if (j == 2)
          {
            l1 = MsgNotifyPushDialog.e * MsgNotifyPushDialog.jdField_a_of_type_Long;
            i = MsgNotifyPushDialog.f;
          }
          else
          {
            if (j != 3) {
              break label761;
            }
            l1 = MsgNotifyPushDialog.g * MsgNotifyPushDialog.jdField_a_of_type_Long;
            i = 2147483647;
          }
          if (k < i) {
            break label775;
          }
          Object localObject2 = ((SharedPreferences)localObject1).edit();
          j += 1;
          ((SharedPreferences.Editor)localObject2).putInt("push_open_notify_stage", j);
          ((SharedPreferences.Editor)localObject2).remove("push_open_notify_stage_count");
          ((SharedPreferences.Editor)localObject2).commit();
          if (j == 1)
          {
            l1 = MsgNotifyPushDialog.jdField_c_of_type_Int * MsgNotifyPushDialog.jdField_a_of_type_Long;
            i = MsgNotifyPushDialog.d;
            break label769;
          }
          if (j == 2)
          {
            l1 = MsgNotifyPushDialog.e * MsgNotifyPushDialog.jdField_a_of_type_Long;
            i = MsgNotifyPushDialog.f;
            break label769;
          }
          if (j != 3) {
            break label769;
          }
          l1 = MsgNotifyPushDialog.g * MsgNotifyPushDialog.jdField_a_of_type_Long;
          i = m;
          break label769;
          if (QLog.isColorLevel()) {
            QLog.d("PushOpenNotify", 2, new Object[] { "PopOpenMsgNotifation, stage:", Integer.valueOf(j), " stagecount:", Integer.valueOf(k), " count:", Integer.valueOf(n), " countMax:", Integer.valueOf(i), " pushInteral:", Long.valueOf(l1), " timeDiff:", Long.valueOf(l2 - MsgNotifyPushDialog.a()) });
          }
          if ((l2 - MsgNotifyPushDialog.a() > l1) || (n == 0))
          {
            MsgNotifyPushDialog.a(l2);
            localObject1 = ((SharedPreferences)localObject1).edit();
            i = k + 1;
            ((SharedPreferences.Editor)localObject1).putInt("push_open_notify_stage_count", i);
            ((SharedPreferences.Editor)localObject1).putInt("push_msg_notify_count", n + 1);
            ((SharedPreferences.Editor)localObject1).putLong("push_open_notify_lasttime", l2);
            if ((j == 1) && (i == 1))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramVarArgs);
              ((StringBuilder)localObject2).append("_");
              ((StringBuilder)localObject2).append("push_open_notify_count");
              ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString());
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramVarArgs);
              ((StringBuilder)localObject2).append("_");
              ((StringBuilder)localObject2).append("push_open_notify_open");
              ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString());
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramVarArgs);
              ((StringBuilder)localObject2).append("_");
              ((StringBuilder)localObject2).append("push_open_notify_cancle");
              ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString());
            }
            ((SharedPreferences.Editor)localObject1).commit();
            return Boolean.valueOf(true);
          }
        }
        return Boolean.valueOf(false);
      }
      return Boolean.valueOf(false);
    }
    catch (Exception paramVarArgs)
    {
      label743:
      break label743;
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
      if (paramBoolean.booleanValue())
      {
        if (localQQAppInterface == null) {
          return;
        }
        paramBoolean = new Intent(localQQAppInterface.getApp(), DialogActivity.class);
        paramBoolean.addFlags(268435456);
        paramBoolean.addFlags(536870912);
        paramBoolean.addFlags(67108864);
        paramBoolean.addFlags(131072);
        paramBoolean.putExtra("key_dialog_type", DialogActivity.jdField_c_of_type_Int);
        localQQAppInterface.getApp().startActivity(paramBoolean);
        return;
      }
      return;
    }
    catch (Exception paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushOpenNotify", 2, "popOpenMsgNotifation, exception: ", paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.PopOpenMsgNotifationTask
 * JD-Core Version:    0.7.0.1
 */