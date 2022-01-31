import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;

public class aupz
{
  private static beey<Integer> jdField_a_of_type_Beey;
  private static String jdField_a_of_type_JavaLangString = "ReceiptUtil";
  private static boolean jdField_a_of_type_Boolean;
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_Boolean) {
      b(paramQQAppInterface);
    }
    return acim.a;
  }
  
  private static long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramString));
      }
    }
    return -1L;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_Boolean) {
      b(paramQQAppInterface);
    }
    int i = c(paramQQAppInterface) + 1;
    a(paramQQAppInterface, i);
    if (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "increaseSentNum with result:  " + Integer.toString(i));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setSentNum: " + paramInt);
    }
    jdField_a_of_type_Beey.a(a(paramQQAppInterface.getCurrentAccountUin()), Integer.valueOf(paramInt));
    paramQQAppInterface.getPreferences().edit().putInt("receipt_msg_sent_num", paramInt).apply();
  }
  
  public static boolean a()
  {
    return acim.b;
  }
  
  private static boolean a(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong2);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    Date localDate = localCalendar.getTime();
    localCalendar.setTimeInMillis(paramLong1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    if (localDate.compareTo(localCalendar.getTime()) == 0) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramLong1 + " and " + paramLong2 + "isToday? " + bool);
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        bool1 = bool2;
        if (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_Boolean) {
      b(paramQQAppInterface);
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    long l1 = localSharedPreferences.getLong("receipt_msg_store_time", 0L);
    long l2 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!a(l1, l2))
    {
      a(paramQQAppInterface, 0);
      localSharedPreferences.edit().putLong("receipt_msg_store_time", l2).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getLeftNum max is " + a(paramQQAppInterface));
    }
    return a(paramQQAppInterface) - c(paramQQAppInterface);
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    jdField_a_of_type_Beey = new beey(1);
    int i = localSharedPreferences.getInt("receipt_msg_sent_num", 0);
    jdField_a_of_type_Beey.a(a(paramQQAppInterface.getCurrentAccountUin()), Integer.valueOf(i));
    jdField_a_of_type_Boolean = true;
  }
  
  private static int c(QQAppInterface paramQQAppInterface)
  {
    int i = ((Integer)jdField_a_of_type_Beey.a(a(paramQQAppInterface.getCurrentAccountUin()), Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getSentNum is " + i);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aupz
 * JD-Core Version:    0.7.0.1
 */