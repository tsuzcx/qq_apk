package com.tencent.gamecenter.appointment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bicy;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import ynz;

public class GameCenterReceiver
  extends BroadcastReceiver
{
  static GameCenterReceiver jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver;
  public static boolean a;
  List<ynz> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +41 -> 47
    //   9: ldc 29
    //   11: iconst_2
    //   12: new 31	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   19: ldc 34
    //   21: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 44	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   27: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 49
    //   32: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 51	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_Boolean	Z
    //   38: invokevirtual 54	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: getstatic 64	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   50: ifnonnull +13 -> 63
    //   53: new 2	com/tencent/gamecenter/appointment/GameCenterReceiver
    //   56: dup
    //   57: invokespecial 65	com/tencent/gamecenter/appointment/GameCenterReceiver:<init>	()V
    //   60: putstatic 64	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   63: getstatic 51	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_Boolean	Z
    //   66: ifne +82 -> 148
    //   69: new 67	android/content/IntentFilter
    //   72: dup
    //   73: invokespecial 68	android/content/IntentFilter:<init>	()V
    //   76: astore_0
    //   77: getstatic 44	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   80: iconst_1
    //   81: if_icmpne +9 -> 90
    //   84: aload_0
    //   85: ldc 70
    //   87: invokevirtual 74	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: ldc 76
    //   93: invokevirtual 74	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   96: new 67	android/content/IntentFilter
    //   99: dup
    //   100: invokespecial 68	android/content/IntentFilter:<init>	()V
    //   103: astore_1
    //   104: aload_1
    //   105: ldc 78
    //   107: invokevirtual 81	android/content/IntentFilter:addDataScheme	(Ljava/lang/String;)V
    //   110: aload_1
    //   111: ldc 83
    //   113: invokevirtual 74	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   116: aload_1
    //   117: ldc 85
    //   119: invokevirtual 74	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   122: invokestatic 89	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   125: getstatic 64	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   128: aload_1
    //   129: invokevirtual 95	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   132: pop
    //   133: invokestatic 89	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   136: getstatic 64	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   139: aload_0
    //   140: invokevirtual 95	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   143: pop
    //   144: iconst_1
    //   145: putstatic 51	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_Boolean	Z
    //   148: ldc 2
    //   150: monitorexit
    //   151: return
    //   152: astore_0
    //   153: ldc 2
    //   155: monitorexit
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: goto -11 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   76	64	0	localIntentFilter1	android.content.IntentFilter
    //   152	5	0	localObject	java.lang.Object
    //   158	1	0	localThrowable	java.lang.Throwable
    //   103	26	1	localIntentFilter2	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   3	47	152	finally
    //   47	63	152	finally
    //   63	90	152	finally
    //   90	122	152	finally
    //   122	148	152	finally
    //   122	148	158	java/lang/Throwable
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    ThreadManagerV2.excute(new GameCenterReceiver.2(this, paramIntent), 16, null, true);
  }
  
  private void a(String paramString, Intent paramIntent)
  {
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterReceiver", 2, "receiveSystemInstallAction intentPkgNameString=" + paramIntent);
    }
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.contains(":"))) {}
    do
    {
      return;
      paramIntent = paramIntent.split(":");
    } while (paramIntent.length < 2);
    ThreadManagerV2.excute(new GameCenterReceiver.1(this, paramIntent[1], paramString), 16, null, true);
  }
  
  public static void a(ynz paramynz)
  {
    if (jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver == null) {}
    while ((paramynz == null) || (jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver.jdField_a_of_type_JavaUtilList.contains(paramynz))) {
      return;
    }
    synchronized (jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver.jdField_a_of_type_JavaUtilList)
    {
      jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver.jdField_a_of_type_JavaUtilList.add(paramynz);
      return;
    }
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 29
    //   11: iconst_2
    //   12: ldc 149
    //   14: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: getstatic 64	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   20: ifnull +24 -> 44
    //   23: getstatic 51	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_Boolean	Z
    //   26: istore_0
    //   27: iload_0
    //   28: ifeq +12 -> 40
    //   31: invokestatic 89	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   34: getstatic 64	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   37: invokevirtual 153	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   40: aconst_null
    //   41: putstatic 64	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   44: iconst_0
    //   45: putstatic 51	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_Boolean	Z
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: astore_1
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -19 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	2	0	bool	boolean
    //   52	5	1	localObject	java.lang.Object
    //   58	1	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   3	17	52	finally
    //   17	27	52	finally
    //   31	40	52	finally
    //   40	44	52	finally
    //   44	48	52	finally
    //   31	40	58	java/lang/Throwable
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterReceiver", 2, "onReceive action=" + paramContext);
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        bicy.a().a(false, -1L);
        return;
      }
      if (("android.intent.action.PACKAGE_ADDED".equals(paramContext)) || ("android.intent.action.PACKAGE_REMOVED".equals(paramContext)))
      {
        a(paramContext, paramIntent);
        return;
      }
    } while (!"com.tencent.gamecenter.action".equals(paramContext));
    a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver
 * JD-Core Version:    0.7.0.1
 */