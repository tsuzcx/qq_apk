import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bdoc
{
  public static int a(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a().size();
      }
    }
    return 0;
  }
  
  public static int a(String paramString, short paramShort)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null)
      {
        if (paramShort <= paramString.a().size()) {
          return ((bdob)paramString.a().get(paramShort - 1)).a();
        }
        QLog.w("StreamDataManager", 2, "getRecordedSize error shPackSeq: " + paramShort + "sfi.getStreamData().size(): " + paramString.a().size());
      }
    }
    return 0;
  }
  
  public static File a(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return null;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.size() > 0))
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        bdod localbdod = (bdod)localHashMap.get(str);
        if ((localbdod.b() == paramInt1) && (localbdod.a() == paramInt2)) {
          return str;
        }
      }
    }
    return null;
  }
  
  public static Map.Entry<String, bdod> a(long paramLong1, long paramLong2)
  {
    Object localObject = bdoe.a();
    if (QLog.isColorLevel()) {
      QLog.d("StreamDataManager", 2, "getStreamFileInfoEntryByMsg  try get random is:" + paramLong1 + ",msgSeq is:" + paramLong2);
    }
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        bdod localbdod = (bdod)localEntry.getValue();
        if (QLog.isColorLevel()) {
          QLog.d("StreamDataManager", 2, "getStreamFileInfoEntryByMsg  random is:" + bcsa.a((int)localbdod.b) + ",msgSeq is:" + localbdod.jdField_a_of_type_Long);
        }
        if ((bcsa.a((int)localbdod.b) == paramLong1) && (paramLong2 == localbdod.jdField_a_of_type_Long)) {
          return localEntry;
        }
      }
    }
    return null;
  }
  
  public static short a(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.c();
      }
    }
    return -1;
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null)
      {
        int i = paramString.a().size();
        paramString.a((short)i);
        if (i >= 1) {
          ((bdob)paramString.a().get(paramString.a().size() - 1)).a(true);
        }
      }
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.jdField_a_of_type_Long = paramLong;
      }
    }
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong1, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    a(paramString1, paramQQAppInterface, paramString2, paramLong1, false, paramInt1, paramInt2, paramLong2, paramBundle);
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong1, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    short s1 = -1;
    Object localObject = bdoe.a();
    paramInt1 = bhrp.a(paramInt1);
    short s2;
    bdob localbdob;
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString1)))
    {
      localObject = (bdod)((HashMap)localObject).get(paramString1);
      ((bdod)localObject).jdField_a_of_type_Boolean = paramBoolean;
      if (localObject != null)
      {
        s2 = s1;
        if (((bdod)localObject).a() == 0)
        {
          localObject = ((bdod)localObject).a();
          s2 = s1;
          if (localObject != null)
          {
            s2 = s1;
            if (((List)localObject).size() > 0)
            {
              localObject = ((List)localObject).iterator();
              s2 = s1;
              if (((Iterator)localObject).hasNext())
              {
                localbdob = (bdob)((Iterator)localObject).next();
                if ((localbdob.a() == localbdob.a().length) && (!localbdob.b()))
                {
                  s1 = localbdob.a();
                  localbdob.b(true);
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      if ((!localbdob.b()) && (localbdob.a()))
      {
        s1 = localbdob.a();
        localbdob.b(true);
        continue;
        if ((s2 != -1) && (paramLong1 != 0L)) {
          paramQQAppInterface.a().a(paramString2, paramString1, paramLong1, s2, paramInt1, paramInt2, paramLong2, paramBundle);
        }
        return;
      }
    }
  }
  
  public static void a(String paramString, short paramShort)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.c(paramShort);
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramBoolean);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (!localHashMap.containsKey(paramString)))
    {
      paramQQAppInterface = new bdod(paramQQAppInterface, paramInt1, paramString, paramInt2);
      paramQQAppInterface.a(paramInt3);
      try
      {
        localHashMap.put(paramString, paramQQAppInterface);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
      try
      {
        localHashMap.remove(paramString);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static boolean a(String paramString, short paramShort)
  {
    HashMap localHashMap = bdoe.a();
    return (localHashMap == null) || (!localHashMap.containsKey(paramString)) || (((bdod)localHashMap.get(paramString)).b() != paramShort);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    return a(paramString, paramArrayOfByte, paramInt, paramShort, false);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort, boolean paramBoolean)
  {
    Object localObject1 = bdoe.a();
    if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramString)))
    {
      bdod localbdod = (bdod)((HashMap)localObject1).get(paramString);
      if (!paramBoolean) {}
      try
      {
        localbdod.a(paramArrayOfByte, paramInt);
        if (localbdod.a() == 0)
        {
          paramString = localbdod.a();
          if (paramString.size() == 0)
          {
            localObject1 = new bdob(localbdod.jdField_a_of_type_Int);
            System.arraycopy(paramArrayOfByte, 0, ((bdob)localObject1).a(), 0, paramInt);
            ((bdob)localObject1).a(paramInt);
            paramShort = localbdod.b();
            s = (short)(paramShort + 1);
            ((bdob)localObject1).a(paramShort);
            paramString.add(localObject1);
            localbdod.b(s);
            return true;
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          short s;
          if (QLog.isColorLevel())
          {
            QLog.d("StreamDataManager", 2, "write fail", paramString);
            continue;
            localObject1 = (bdob)paramString.get(paramString.size() - 1);
            Object localObject2 = ((bdob)localObject1).a();
            int i;
            if (((bdob)localObject1).a() < localObject2.length)
            {
              i = localObject2.length - ((bdob)localObject1).a();
              if (i >= paramInt)
              {
                System.arraycopy(paramArrayOfByte, 0, ((bdob)localObject1).a(), ((bdob)localObject1).a(), paramInt);
                ((bdob)localObject1).a(((bdob)localObject1).a() + paramInt);
              }
              else
              {
                if (paramInt <= i)
                {
                  System.arraycopy(paramArrayOfByte, 0, ((bdob)localObject1).a(), ((bdob)localObject1).a(), paramInt);
                  ((bdob)localObject1).a(((bdob)localObject1).a() + paramInt);
                  return true;
                }
                System.arraycopy(paramArrayOfByte, 0, ((bdob)localObject1).a(), ((bdob)localObject1).a(), i);
                ((bdob)localObject1).a(((bdob)localObject1).a().length);
                paramInt -= i;
                localObject1 = new bdob(localbdod.jdField_a_of_type_Int);
                System.arraycopy(paramArrayOfByte, i, ((bdob)localObject1).a(), 0, paramInt);
                ((bdob)localObject1).a(paramInt);
                paramShort = localbdod.b();
                s = (short)(paramShort + 1);
                ((bdob)localObject1).a(paramShort);
                paramString.add(localObject1);
                localbdod.b(s);
              }
            }
            else
            {
              localObject1 = new bdob(localbdod.jdField_a_of_type_Int);
              System.arraycopy(paramArrayOfByte, 0, ((bdob)localObject1).a(), 0, paramInt);
              ((bdob)localObject1).a(paramInt);
              paramShort = localbdod.b();
              s = (short)(paramShort + 1);
              ((bdob)localObject1).a(paramShort);
              paramString.add(localObject1);
              localbdod.b(s);
              continue;
              if (localbdod.a() == 1)
              {
                localObject2 = localbdod.a();
                paramInt = paramArrayOfByte.length;
                i = 0;
                if (paramInt > 0)
                {
                  if (((List)localObject2).size() == 0)
                  {
                    paramString = new bdob(localbdod.jdField_a_of_type_Int);
                    ((List)localObject2).add(paramString);
                  }
                  for (;;)
                  {
                    int k = paramString.a().length - paramString.a();
                    int j = k;
                    if (k >= paramInt) {
                      j = paramInt;
                    }
                    System.arraycopy(paramArrayOfByte, i, paramString.a(), paramString.a(), j);
                    i += j;
                    paramInt -= j;
                    paramString.a(j + paramString.a());
                    paramString.a(paramShort);
                    break;
                    localObject1 = (bdob)((List)localObject2).get(((List)localObject2).size() - 1);
                    paramString = (String)localObject1;
                    if (((bdob)localObject1).a().length - ((bdob)localObject1).a() <= 0)
                    {
                      paramString = new bdob(localbdod.jdField_a_of_type_Int);
                      ((List)localObject2).add(paramString);
                    }
                  }
                }
                localbdod.b((short)(paramShort + 1));
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public static byte[] a(String paramString, short paramShort)
  {
    Object localObject = bdoe.a();
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString)))
    {
      paramString = (bdod)((HashMap)localObject).get(paramString);
      if (paramString != null)
      {
        localObject = (bdob)paramString.a().get(paramShort - 1);
        paramString = ((bdob)localObject).a();
        paramShort = ((bdob)localObject).a();
        if (paramShort != paramString.length)
        {
          localObject = new byte[paramShort];
          System.arraycopy(paramString, 0, localObject, 0, paramShort);
          return localObject;
        }
        return paramString;
      }
    }
    return null;
  }
  
  public static int b(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.b();
      }
    }
    return -1;
  }
  
  public static short b(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return 0;
  }
  
  public static void b(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a();
      }
    }
  }
  
  public static void b(String paramString, long paramLong)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.b = paramLong;
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.jdField_a_of_type_Boolean;
      }
    }
    return false;
  }
  
  public static int c(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    int i;
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null)
      {
        i = paramString.a().size();
        if ((i < 1) || (((bdob)paramString.a().get(i - 1)).b())) {
          return i;
        }
        return i - 1;
      }
    }
    return 0;
    return i;
  }
  
  public static short c(String paramString)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.b();
      }
    }
    return 0;
  }
  
  public static void c(String paramString, long paramLong)
  {
    HashMap localHashMap = bdoe.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (bdod)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramLong);
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    List localList = bdoe.a();
    if ((localList != null) && (!localList.contains(paramString)))
    {
      localList.add(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean d(String paramString)
  {
    List localList = bdoe.a();
    if ((localList != null) && (localList.contains(paramString)))
    {
      localList.remove(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean e(String paramString)
  {
    List localList = bdoe.a();
    return (localList != null) && (localList.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoc
 * JD-Core Version:    0.7.0.1
 */