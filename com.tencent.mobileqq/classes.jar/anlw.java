import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class anlw
{
  public static int a(BaseChatPie paramBaseChatPie, annl paramannl, ApolloActionData paramApolloActionData)
  {
    int j;
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null))
    {
      j = 0;
      return j;
    }
    paramBaseChatPie = (ankc)paramBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
    boolean bool = paramBaseChatPie.b(paramApolloActionData.actionId);
    int i;
    if ((paramApolloActionData.hasSound) || (paramannl.e > 0)) {
      i = 1;
    }
    for (;;)
    {
      if (paramBaseChatPie.c(paramApolloActionData.actionId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanelUtil", 2, new Object[] { "data actionId:", Integer.valueOf(paramApolloActionData.actionId), "typeValue:", Integer.valueOf(i) });
        }
        return i | 0x2;
        if (paramApolloActionData.actionType == 8) {
          i = 1024;
        }
      }
      else
      {
        j = i;
        if (paramApolloActionData.feeType == 6)
        {
          if (bool)
          {
            j = 16;
            j = i | j;
          }
        }
        else
        {
          int k = j;
          if (paramApolloActionData.feeType == 2)
          {
            if (!bool) {
              break label235;
            }
            i = 4;
            label177:
            k = j | i;
          }
          i = k;
          if (paramApolloActionData.feeType == 9) {
            i = k | 0x2000;
          }
          j = i;
          if (paramApolloActionData.feeType != 7) {
            break;
          }
          if (!bool) {
            break label242;
          }
        }
        label235:
        label242:
        for (j = 8;; j = 512)
        {
          return i | j;
          j = 64;
          break;
          i = 128;
          break label177;
        }
      }
      i = 0;
    }
  }
  
  public static String a(@NotNull String paramString)
  {
    Object localObject = ApolloUtil.a();
    if (localObject == null) {
      return null;
    }
    paramString = anhm.a(paramString, (QQAppInterface)localObject, false);
    if ((paramString != null) && (paramString.length == 2) && (paramString[1] != null) && (((int[])paramString[1]).length > 0))
    {
      paramString = (int[])paramString[1];
      localObject = new StringBuilder();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(paramString[i]).append("_");
        i += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlw
 * JD-Core Version:    0.7.0.1
 */