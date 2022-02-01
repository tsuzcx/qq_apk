import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class axsi
{
  static Comparator<axtj> a = new axsj();
  
  public static axtj a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      Object localObject = (anyw)paramQQAppInterface.getManager(51);
      if (localObject == null) {
        return null;
      }
      if (((anyw)localObject).a(false)) {
        return null;
      }
      if (!((anyw)localObject).c(paramString)) {
        return null;
      }
      localObject = ((anyw)localObject).a(paramString, paramBoolean);
      if (localObject == null) {
        return null;
      }
      paramString = a(paramQQAppInterface, paramString, (ExtensionInfo)localObject, paramLong);
      paramQQAppInterface = paramString;
    } while (paramString != null);
    return null;
  }
  
  private static axtj a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      return null;
    }
    paramExtensionInfo = a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong);
    if ((paramExtensionInfo != null) && (!paramExtensionInfo.jdField_a_of_type_Boolean))
    {
      axtg localaxtg = arfj.a().a(paramExtensionInfo.jdField_a_of_type_Long);
      if (localaxtg != null)
      {
        axtj localaxtj = new axtj();
        localaxtj.a(paramExtensionInfo);
        localaxtj.jdField_c_of_type_Boolean = localaxtg.jdField_b_of_type_Boolean;
        localaxtj.jdField_a_of_type_JavaLangString = localaxtg.a(localaxtj.jdField_b_of_type_Long);
        localaxtj.jdField_b_of_type_Boolean = localaxtg.jdField_a_of_type_Boolean;
        localaxtj.jdField_b_of_type_Int = localaxtg.jdField_b_of_type_Int;
        localaxtj.jdField_a_of_type_Int = localaxtg.jdField_a_of_type_Int;
        localaxtj.jdField_c_of_type_Int = axsg.a(paramQQAppInterface, paramString, localaxtj.jdField_a_of_type_Long, localaxtj.jdField_b_of_type_Long);
        localaxtj.jdField_c_of_type_JavaLangString = axsr.c(localaxtj.jdField_c_of_type_JavaLangString);
        axte.a().a(paramQQAppInterface, paramString, localaxtj);
        localaxtj.jdField_c_of_type_JavaLangString = axtc.a(paramQQAppInterface, paramString, localaxtj.jdField_a_of_type_Long, localaxtj.jdField_b_of_type_Long, localaxtj.h, localaxtj.jdField_c_of_type_JavaLangString);
        if (!localaxtj.d())
        {
          if (QLog.isColorLevel()) {
            QLog.i("MutualMarkDataCenter", 2, "getMutualMarkDisPlayInfo IconResource InValid displayInfo:" + localaxtj);
          }
          return null;
        }
        if ((localaxtg.a(localaxtj.jdField_b_of_type_Long)) && (axsg.b(paramQQAppInterface, localaxtj.jdField_a_of_type_Long, localaxtj.jdField_b_of_type_Long))) {
          return localaxtj;
        }
        if ((localaxtg.a()) && (axsg.b(paramQQAppInterface, localaxtj.jdField_a_of_type_Long)))
        {
          paramLong = localaxtg.a(localaxtj.jdField_b_of_type_Long);
          if (paramLong != -1L)
          {
            localaxtj.jdField_b_of_type_Long = paramLong;
            return localaxtj;
          }
        }
      }
    }
    return null;
  }
  
  public static axtj a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      localObject = null;
    }
    do
    {
      ExtensionInfo localExtensionInfo;
      axtj localaxtj;
      do
      {
        do
        {
          return localObject;
          localObject = (anyw)paramQQAppInterface.getManager(51);
          if (localObject == null) {
            return null;
          }
          if (((anyw)localObject).a(false)) {
            return null;
          }
          if (!((anyw)localObject).c(paramString)) {
            return null;
          }
          localExtensionInfo = ((anyw)localObject).a(paramString, paramBoolean);
          if (localExtensionInfo == null) {
            return null;
          }
          localaxtj = a(paramQQAppInterface, paramString, localExtensionInfo, 1L);
          localObject = localaxtj;
        } while (localaxtj != null);
        localaxtj = a(paramQQAppInterface, paramString, localExtensionInfo, 2L);
        localObject = localaxtj;
      } while (localaxtj != null);
      paramQQAppInterface = a(paramQQAppInterface, paramString, localExtensionInfo, 3L);
      localObject = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  private static axtk a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {}
    do
    {
      do
      {
        return null;
        if (!axsr.c(paramLong)) {
          break;
        }
      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
      return (axtk)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramLong));
    } while ((!axsr.b(paramLong)) || ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (paramExtensionInfo.intimate_type != paramLong) || (paramExtensionInfo.intimate_level < 0) || (paramExtensionInfo.intimate_level > 2));
    paramQQAppInterface = new axtk();
    paramQQAppInterface.jdField_a_of_type_Long = paramExtensionInfo.intimate_type;
    paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.intimate_level;
    if (paramExtensionInfo.isExtinguish) {
      paramQQAppInterface.f = 1L;
    }
    paramQQAppInterface.d = paramExtensionInfo.last_intimate_chatTime;
    paramQQAppInterface.c = paramExtensionInfo.intimate_chatDays;
    return paramQQAppInterface;
  }
  
  public static Pair<axtj, axtj> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = a(paramQQAppInterface, paramString, false, 1);
    Object localObject4;
    if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
    {
      localObject4 = ((ArrayList)localObject2).iterator();
      localObject2 = null;
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (axtj)((Iterator)localObject4).next();
        if (!((axtj)localObject3).jdField_b_of_type_Boolean)
        {
          if ((localObject2 == null) || (((axtj)localObject3).jdField_b_of_type_Int < ((axtj)localObject2).jdField_b_of_type_Int)) {
            localObject2 = localObject3;
          }
        }
        else {
          for (;;)
          {
            break;
            if ((localObject1 != null) && (((axtj)localObject3).jdField_b_of_type_Int >= localObject1.jdField_b_of_type_Int)) {
              break label182;
            }
            localObject1 = localObject3;
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (TextUtils.isEmpty(((axtj)localObject2).jdField_b_of_type_JavaLangString))) {
          axte.a().a(paramQQAppInterface, paramString, (axtj)localObject2);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (TextUtils.isEmpty(localObject1.jdField_b_of_type_JavaLangString))
          {
            axte.a().a(paramQQAppInterface, paramString, localObject1);
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      return new Pair(localObject4, localObject3);
      label182:
      break;
      localObject4 = null;
    }
  }
  
  public static ArrayList<blpn> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<axtj> paramArrayList)
  {
    axtj localaxtj = null;
    Object localObject = localaxtj;
    if (paramArrayList != null)
    {
      localObject = localaxtj;
      if (!paramArrayList.isEmpty())
      {
        localObject = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localaxtj = (axtj)paramArrayList.next();
          blpn localblpn = new blpn();
          localblpn.jdField_a_of_type_Int = localaxtj.jdField_c_of_type_Int;
          localblpn.jdField_a_of_type_JavaLangString = localaxtj.jdField_c_of_type_JavaLangString;
          if (TextUtils.isEmpty(localaxtj.jdField_b_of_type_JavaLangString)) {
            axte.a().a(paramQQAppInterface, paramString, localaxtj);
          }
          if (!TextUtils.isEmpty(localaxtj.jdField_b_of_type_JavaLangString)) {
            localblpn.jdField_b_of_type_JavaLangString = localaxtj.jdField_b_of_type_JavaLangString;
          }
          localblpn.jdField_a_of_type_Float = localaxtj.a();
          ((ArrayList)localObject).add(localblpn);
        }
      }
    }
    return localObject;
  }
  
  public static ArrayList<axtj> a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = (anyw)paramQQAppInterface.getManager(51);
    if (localObject == null) {
      paramQQAppInterface = null;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if ((paramInt == 2) || (paramInt == 1)) {}
        for (boolean bool = ((anyw)localObject).a(true); bool; bool = ((anyw)localObject).a(false)) {
          return null;
        }
        if (!((anyw)localObject).c(paramString)) {
          return null;
        }
        ExtensionInfo localExtensionInfo = ((anyw)localObject).a(paramString, paramBoolean);
        if (localExtensionInfo == null) {
          return null;
        }
        localObject = new ArrayList();
        long[] arrayOfLong = axsh.b;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          axtj localaxtj = a(paramQQAppInterface, paramString, localExtensionInfo, arrayOfLong[i]);
          if (localaxtj != null) {
            ((ArrayList)localObject).add(localaxtj);
          }
          i += 1;
        }
        paramQQAppInterface = (QQAppInterface)localObject;
      } while (((ArrayList)localObject).isEmpty());
      paramQQAppInterface = (QQAppInterface)localObject;
    } while (paramInt == 1);
    Collections.sort((List)localObject, a);
    return localObject;
  }
  
  public static void a(axtj paramaxtj, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramaxtj == null)) {}
    do
    {
      do
      {
        return;
      } while ((!axsr.c(paramaxtj.jdField_a_of_type_Long)) || (paramExtensionInfo.mutualMarks == null));
      paramExtensionInfo = (axtk)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramaxtj.jdField_a_of_type_Long));
    } while (paramExtensionInfo == null);
    paramExtensionInfo.jdField_b_of_type_Boolean = paramaxtj.jdField_a_of_type_Boolean;
    paramExtensionInfo.i = paramaxtj.i;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      break label15;
    }
    for (;;)
    {
      label15:
      return;
      if (a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong) != null)
      {
        Object localObject = arfj.a().a(paramLong);
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          b(paramQQAppInterface, paramString, paramExtensionInfo, ((axtg)((Iterator)localObject).next()).jdField_a_of_type_Long);
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramBoolean, 0);
    paramBoolean = bool;
    if (paramQQAppInterface != null)
    {
      paramBoolean = bool;
      if (!paramQQAppInterface.isEmpty()) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!axsr.c(paramLong)) {
          break;
        }
      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(paramLong));
      return;
    } while ((!axsr.b(paramLong)) || ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (paramExtensionInfo.intimate_type != paramLong));
    paramExtensionInfo.intimate_type = 0;
    paramExtensionInfo.intimate_level = 0;
    paramExtensionInfo.intimate_chatDays = 0;
    paramExtensionInfo.last_intimate_chatTime = 0L;
    paramExtensionInfo.isExtinguish = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsi
 * JD-Core Version:    0.7.0.1
 */