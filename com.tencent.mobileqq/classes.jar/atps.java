import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.ServerConfigManager.ConfigType;

public class atps
{
  private static SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
  public static final String[] a;
  public static final String[] b = { "XG预下载配额余量", "XG当前消耗流量", "XG流量总消耗", "XG预下载总数", "XG预下载命中数", "XG预下载未命中数", "XG手动看图数", "XG消耗量余量", "WIFI预下载总数", "WIFI预下载命中数", "WIFI预下载未命中数", "WIFI手动看图数", "XG是否超过上限", ajjy.a(2131642369) };
  static String[] c = { "1031637263", "81118728", "354653668", "87587790", "745798311", "362675669", "27801478", "991636135", "249484612", "279242625", "517152365", "349808804", "1053134469", "303137720", "9948938", "165326859", "584781501", "864600712", "410363461", "306392284", "878898475", "34242313", "842714741", "26080655", "1003187685" };
  
  static
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor = jdField_a_of_type_AndroidContentSharedPreferences.edit();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "xgFlowPre", "xgFlowWaste", "accFlowPreTotal", "xgPreDownCount", "xgHitCount", "xgMissCount", "xgManulClickCount", "xgFlowWasteBalance", "wifiPreDownCout", "wifiHitCount", "wifiMissCount", "wifiManulClickCount" };
  }
  
  public static int a()
  {
    int j = 3;
    int k = badq.a(BaseApplication.getContext());
    int i;
    if (k == 1) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (k == 2);
      if (k == 3) {
        return 2;
      }
      i = j;
    } while (k != 4);
    return 1;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 * 8 + paramInt2 * 2 + paramInt3;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int i;
    if (paramInt == 1)
    {
      i = 1;
      if ((i == 0) || (paramQQAppInterface == null)) {
        break label63;
      }
    }
    label63:
    label69:
    label75:
    label80:
    do
    {
      int j;
      for (;;)
      {
        try
        {
          bool = ariz.a().a(paramQQAppInterface, paramString);
          if (paramInt != 3000) {
            break label69;
          }
          j = 1;
          if (paramInt != 0) {
            break label75;
          }
          paramInt = 1;
          if (!bool) {
            break label80;
          }
          return 1;
        }
        catch (Throwable paramQQAppInterface)
        {
          QLog.e(".troop", 1, "PicPreDownloadUtils.calcUinType Error", paramQQAppInterface);
        }
        i = 0;
        break;
        boolean bool = false;
        continue;
        j = 0;
        continue;
        paramInt = 0;
      }
      if (i != 0) {
        return 0;
      }
      if (j != 0) {
        return 2;
      }
    } while (paramInt == 0);
    return 3;
  }
  
  /* Error */
  public static long a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: lload_2
    //   5: lreturn
    //   6: aload_0
    //   7: getstatic 186	mqq/manager/ServerConfigManager$ConfigType:common	Lmqq/manager/ServerConfigManager$ConfigType;
    //   10: aload_1
    //   11: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:a	(Lmqq/manager/ServerConfigManager$ConfigType;Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnull +70 -> 86
    //   19: aload_0
    //   20: invokestatic 197	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 201	java/lang/Long:longValue	()J
    //   28: lstore 4
    //   30: aload_1
    //   31: aload_0
    //   32: invokevirtual 201	java/lang/Long:longValue	()J
    //   35: invokestatic 204	atps:a	(Ljava/lang/String;J)V
    //   38: ldc 206
    //   40: ldc 208
    //   42: new 210	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   49: ldc 215
    //   51: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 221
    //   60: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: lload 4
    //   65: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   68: ldc 226
    //   70: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_2
    //   74: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 235	atpg:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   83: lload 4
    //   85: lreturn
    //   86: aload_1
    //   87: lload_2
    //   88: invokestatic 204	atps:a	(Ljava/lang/String;J)V
    //   91: lload_2
    //   92: lstore 4
    //   94: goto -56 -> 38
    //   97: astore_0
    //   98: lload_2
    //   99: lstore 4
    //   101: goto -63 -> 38
    //   104: astore_0
    //   105: goto -67 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramQQAppInterface	QQAppInterface
    //   0	108	1	paramString	String
    //   0	108	2	paramLong	long
    //   28	72	4	l	long
    // Exception table:
    //   from	to	target	type
    //   6	15	97	java/lang/Exception
    //   19	30	97	java/lang/Exception
    //   86	91	97	java/lang/Exception
    //   30	38	104	java/lang/Exception
  }
  
  public static long a(String paramString, long paramLong)
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString, paramLong);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, axvt paramaxvt)
  {
    if (paramaxvt == null) {}
    while ((!(paramaxvt.a instanceof MessageForPic)) || (paramaxvt.b == 65537)) {
      return;
    }
    MessageForPic localMessageForPic = (MessageForPic)paramaxvt.a;
    atpg.a("PIC_TAG_PRELOAD", "updateDownState", "Before update, networkType:" + localMessageForPic.preDownNetworkType + ",state:" + localMessageForPic.preDownState + ",uniseq:" + localMessageForPic.uniseq);
    if (paramaxvt.g == 1) {
      localMessageForPic.preDownState = 1;
    }
    for (;;)
    {
      atpg.a("PIC_TAG_PRELOAD", "updateDownState", "After update, networkType:" + localMessageForPic.preDownNetworkType + ",state:" + localMessageForPic.preDownState + ",uniseq:" + localMessageForPic.uniseq);
      a(paramQQAppInterface, localMessageForPic);
      return;
      if (paramaxvt.g == 3) {
        localMessageForPic.preDownState = 4;
      } else if ((localMessageForPic.preDownState != 1) && (localMessageForPic.preDownState != 4)) {
        localMessageForPic.preDownState = 0;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {}
    Object localObject;
    label193:
    do
    {
      do
      {
        awwr localawwr;
        do
        {
          do
          {
            return;
            atpg.a("PIC_TAG_PRELOAD", "updateMsg", "uniseq:" + paramMessageForPic.uniseq + ",network:" + paramMessageForPic.preDownNetworkType + "state:" + paramMessageForPic.preDownState);
            paramMessageForPic.serial();
            localObject = paramQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
            if (paramMessageForPic.subMsgId != MessageForPic.defaultSuMsgId) {
              break label193;
            }
            if (!(localObject instanceof MessageForStructing)) {
              break;
            }
            localObject = (MessageForStructing)localObject;
          } while (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare));
          localawwr = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
        } while (localawwr == null);
        localawwr.a = paramMessageForPic;
        paramQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, ((MessageForStructing)localObject).structingMsg.getBytes());
        return;
        paramQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, paramMessageForPic.msgData);
        return;
      } while (!(localObject instanceof MessageForMixedMsg));
      localObject = ((MessageForMixedMsg)localObject).upateMessageForPic(paramMessageForPic);
    } while (localObject == null);
    paramQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, (byte[])localObject);
  }
  
  public static void a(String paramString) {}
  
  @TargetApi(9)
  public static void a(String paramString, long paramLong)
  {
    a(paramString, paramLong, true);
  }
  
  @TargetApi(9)
  public static void a(String paramString, long paramLong, boolean paramBoolean)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramString, paramLong);
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      }
    }
    else {
      return;
    }
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "enablePeakFlow");
    if (paramQQAppInterface == null) {
      return paramBoolean;
    }
    return paramQQAppInterface.equals("1");
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PeakFlowTimePeriod");
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = new long[0];
      return paramQQAppInterface;
    }
    String[] arrayOfString = paramQQAppInterface.split(";");
    if (arrayOfString == null) {
      return new long[0];
    }
    long[] arrayOfLong = new long[arrayOfString.length * 2];
    int k = arrayOfString.length;
    int i = 0;
    int j = 0;
    for (;;)
    {
      paramQQAppInterface = arrayOfLong;
      if (i >= k) {
        break;
      }
      paramQQAppInterface = arrayOfString[i].split("-");
      if ((paramQQAppInterface == null) || (paramQQAppInterface.length != 2)) {
        return new long[0];
      }
      arrayOfLong[j] = Long.valueOf(paramQQAppInterface[0]).longValue();
      arrayOfLong[(j + 1)] = Long.valueOf(paramQQAppInterface[1]).longValue();
      j += 2;
      i += 1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {}
    while (paramMessageForPic.preDownState != 0) {
      return;
    }
    paramMessageForPic.preDownState = 1;
    paramMessageForPic.preDownNetworkType = a();
    atpg.a("PIC_TAG_PRELOAD", "updateDownState4SD", "networkType:" + paramMessageForPic.preDownNetworkType + ",state:" + paramMessageForPic.preDownState + ",uniseq:" + paramMessageForPic.uniseq);
    a(paramQQAppInterface, paramMessageForPic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atps
 * JD-Core Version:    0.7.0.1
 */