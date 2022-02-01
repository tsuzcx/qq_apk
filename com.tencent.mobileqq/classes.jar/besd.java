import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class besd
{
  private static int a(int paramInt, MessageRecord paramMessageRecord)
  {
    int j = -1;
    boolean bool = awig.a(paramMessageRecord);
    int i;
    if (paramInt != 27) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("getFlowersCounts, bizType = ").append(paramInt).append(", isNearbyFlowerMsg = ").append(bool).append(", msgType = ");
        paramInt = j;
        if (paramMessageRecord != null) {
          paramInt = paramMessageRecord.msgtype;
        }
        QLog.d("Navigate.UpdateMsgInfoUtil", 2, paramInt + ", flowersCount = " + i);
      }
      return i;
      if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool))
      {
        i = -1;
      }
      else
      {
        if (bool)
        {
          if ((paramMessageRecord instanceof MessageForStructing)) {
            i = awig.a((MessageForStructing)paramMessageRecord);
          }
        }
        else
        {
          if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
          {
            i = ((MessageForDeliverGiftTips)paramMessageRecord).giftCount;
            continue;
          }
          i = -1;
          continue;
        }
        i = -1;
      }
    }
  }
  
  @Nullable
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, bdyi parambdyi, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramString, parambdyi, paramMessageRecord, paramBoolean);
    return b(paramQQAppInterface, paramString, parambdyi, paramObject, paramMessageRecord, paramBoolean);
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 3000) {
      return bese.a(paramString, i);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, bdyi parambdyi, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int j = parambdyi.a(paramQQAppInterface, paramBoolean, paramString);
    int i = a(j, paramMessageRecord);
    if (((!paramBoolean) && (!a(j))) || (i == -1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.UpdateMsgInfoUtil", 2, "isTroop = " + paramBoolean + ", bizType = " + j + ", flowers = " + i + ", troopCode = " + paramString + ", isTroop = " + paramBoolean);
      }
      return;
    }
    String str = a(paramString, paramBoolean);
    j = berd.b(j);
    paramString = null;
    if (j == 102) {
      paramString = paramMessageRecord;
    }
    long l = bdyo.a(j, parambdyi.a.a, parambdyi.a.b);
    ((bese)paramQQAppInterface.getManager(363)).a(str, j, parambdyi.a.a, l, "", i, paramString);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 24) || (paramInt == 12) || (paramInt == 20) || (paramInt == 22);
  }
  
  @Nullable
  private static Object b(QQAppInterface paramQQAppInterface, String paramString, bdyi parambdyi, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = parambdyi.a(paramQQAppInterface, paramBoolean, paramString);
    if ((!paramBoolean) && (!a(i))) {
      return null;
    }
    paramString = ((aknv)paramQQAppInterface.getManager(366)).a(i);
    if (paramString != null) {
      return paramString.a(i, parambdyi, paramObject, paramMessageRecord, paramQQAppInterface);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     besd
 * JD-Core Version:    0.7.0.1
 */