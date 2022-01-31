import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class aqyg
{
  final LruCache<String, aqyi> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final List<Object> jdField_a_of_type_JavaUtilList;
  final ConcurrentHashMap<String, Object[]> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public aqyg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(3);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new aqyh(this, 20);
  }
  
  public static final int a(QQAppInterface paramQQAppInterface)
  {
    int i = ((Integer)atbi.a(paramQQAppInterface.getAccount(), "self_gender", Integer.valueOf(0))).intValue();
    if (i == 2) {
      return 1;
    }
    if (i == 1) {
      return 0;
    }
    return 2;
  }
  
  private aqyi a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null)
      {
        paramString = (aqyi)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(String paramString, aqyi paramaqyi)
  {
    try
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, paramaqyi);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public Object a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null))
    {
      paramString = null;
      return paramString;
    }
    int i = 2;
    aqyi localaqyi = a(paramString);
    if (localaqyi == null) {
      if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        paramString = (String)atbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_nick", String.valueOf(""));
        i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString, i, NetConnInfoCenter.getServerTime());
      }
    }
    for (;;)
    {
      switch (paramInt)
      {
      case 2: 
      default: 
        return null;
        if (QLog.isDevelopLevel())
        {
          atbr.a("PttShow", "getGender no cache", new Object[] { paramString });
          paramString = null;
          continue;
          i = localaqyi.jdField_a_of_type_Int;
          paramString = localaqyi.b;
        }
        break;
      case 1: 
        return Integer.valueOf(i);
        paramString = null;
      }
    }
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null)) {
      return null;
    }
    paramString = a(paramString, 2);
    if ((paramString instanceof String)) {
      return (String)paramString;
    }
    return null;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.extLong & 0x1) == 0) || (paramMessageRecord.senderuin == null)) {}
    label218:
    do
    {
      Object localObject1;
      do
      {
        return;
        localObject1 = a(paramMessageRecord.senderuin);
      } while ((localObject1 != null) && (((aqyi)localObject1).jdField_a_of_type_Long >= paramMessageRecord.time));
      try
      {
        String str1 = paramMessageRecord.getExtInfoFromExtStr("hotchat_nick");
        i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("hotchat_gender"));
        l1 = paramMessageRecord.time;
        localObject2 = str1;
        j = i;
        if (!paramMessageRecord.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label218;
        }
        str2 = (String)atbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_nick", String.valueOf(""));
        k = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = str1;
        if (str2 == null) {
          break;
        }
        localObject1 = str1;
        if (str2.length() <= 0) {
          break;
        }
        localObject1 = str2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          long l1;
          Object localObject2;
          int j;
          String str2;
          int k;
          long l2;
          localException.printStackTrace();
          continue;
          if (k != 2) {
            i = k;
          }
        }
      }
      l2 = NetConnInfoCenter.getServerTime();
      localObject2 = localObject1;
      j = i;
      l1 = l2;
      if (QLog.isDevelopLevel())
      {
        atbr.a("PttShow", "cacheSelfGender", new Object[] { str2, Integer.valueOf(k), Long.valueOf(l2) });
        l1 = l2;
        j = i;
        localObject2 = localObject1;
      }
      a(paramMessageRecord.senderuin, (String)localObject2, j, l1);
    } while (!QLog.isDevelopLevel());
    atbr.a("PttShow", "cacheGender", new Object[] { paramMessageRecord.extStr });
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    do
    {
      do
      {
        do
        {
          return;
          localaqyi = a(paramString1);
          if ((localaqyi == null) || (localaqyi.jdField_a_of_type_Long > paramLong)) {
            break;
          }
          localaqyi.jdField_a_of_type_Int = paramInt;
          if ((paramString2 != null) && (paramString2.length() > 0)) {
            localaqyi.b = paramString2;
          }
          localaqyi.jdField_a_of_type_Long = paramLong;
        } while (!QLog.isDevelopLevel());
        atbr.a("PttShow", "cacheGender_update", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      } while (localaqyi != null);
      aqyi localaqyi = new aqyi();
      localaqyi.jdField_a_of_type_JavaLangString = paramString1;
      localaqyi.jdField_a_of_type_Int = paramInt;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        localaqyi.b = paramString2;
      }
      localaqyi.jdField_a_of_type_Long = paramLong;
      a(paramString1, localaqyi);
    } while (!QLog.isDevelopLevel());
    atbr.a("PttShow", "cacheGender_add", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqyg
 * JD-Core Version:    0.7.0.1
 */