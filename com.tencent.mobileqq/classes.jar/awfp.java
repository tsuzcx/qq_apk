import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.SingleLineTextView.IconDrawableInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class awfp
{
  static Comparator<awgq> a = new awfq();
  
  public static awgq a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      Object localObject = (amsw)paramQQAppInterface.getManager(51);
      if (localObject == null) {
        return null;
      }
      if (((amsw)localObject).a(false)) {
        return null;
      }
      if (!((amsw)localObject).c(paramString)) {
        return null;
      }
      localObject = ((amsw)localObject).a(paramString, paramBoolean);
      if (localObject == null) {
        return null;
      }
      paramString = a(paramQQAppInterface, paramString, (ExtensionInfo)localObject, paramLong);
      paramQQAppInterface = paramString;
    } while (paramString != null);
    return null;
  }
  
  private static awgq a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      return null;
    }
    paramExtensionInfo = a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong);
    if ((paramExtensionInfo != null) && (!paramExtensionInfo.jdField_a_of_type_Boolean))
    {
      awgn localawgn = apyz.a().a(paramExtensionInfo.jdField_a_of_type_Long);
      if (localawgn != null)
      {
        awgq localawgq = new awgq();
        localawgq.a(paramExtensionInfo);
        localawgq.jdField_c_of_type_Boolean = localawgn.jdField_b_of_type_Boolean;
        localawgq.jdField_a_of_type_JavaLangString = localawgn.a(localawgq.jdField_b_of_type_Long);
        localawgq.jdField_b_of_type_Boolean = localawgn.jdField_a_of_type_Boolean;
        localawgq.jdField_b_of_type_Int = localawgn.jdField_b_of_type_Int;
        localawgq.jdField_a_of_type_Int = localawgn.jdField_a_of_type_Int;
        localawgq.jdField_c_of_type_Int = awfn.a(paramQQAppInterface, paramString, localawgq.jdField_a_of_type_Long, localawgq.jdField_b_of_type_Long);
        localawgq.jdField_c_of_type_JavaLangString = awfy.c(localawgq.jdField_c_of_type_JavaLangString);
        awgl.a().a(paramQQAppInterface, paramString, localawgq);
        localawgq.jdField_c_of_type_JavaLangString = awgj.a(paramQQAppInterface, paramString, localawgq.jdField_a_of_type_Long, localawgq.jdField_b_of_type_Long, localawgq.h, localawgq.jdField_c_of_type_JavaLangString);
        if (!localawgq.d())
        {
          if (QLog.isColorLevel()) {
            QLog.i("MutualMarkDataCenter", 2, "getMutualMarkDisPlayInfo IconResource InValid displayInfo:" + localawgq);
          }
          return null;
        }
        if ((localawgn.a(localawgq.jdField_b_of_type_Long)) && (awfn.b(paramQQAppInterface, localawgq.jdField_a_of_type_Long, localawgq.jdField_b_of_type_Long))) {
          return localawgq;
        }
        if ((localawgn.a()) && (awfn.b(paramQQAppInterface, localawgq.jdField_a_of_type_Long)))
        {
          paramLong = localawgn.a(localawgq.jdField_b_of_type_Long);
          if (paramLong != -1L)
          {
            localawgq.jdField_b_of_type_Long = paramLong;
            return localawgq;
          }
        }
      }
    }
    return null;
  }
  
  public static awgq a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      localObject = null;
    }
    do
    {
      ExtensionInfo localExtensionInfo;
      awgq localawgq;
      do
      {
        do
        {
          do
          {
            return localObject;
            localObject = (amsw)paramQQAppInterface.getManager(51);
            if (localObject == null) {
              return null;
            }
            if (((amsw)localObject).a(false)) {
              return null;
            }
            if (!((amsw)localObject).c(paramString)) {
              return null;
            }
            localExtensionInfo = ((amsw)localObject).a(paramString, paramBoolean);
            if (localExtensionInfo == null) {
              return null;
            }
            localawgq = a(paramQQAppInterface, paramString, localExtensionInfo, 1L);
            localObject = localawgq;
          } while (localawgq != null);
          localawgq = a(paramQQAppInterface, paramString, localExtensionInfo, 2L);
          localObject = localawgq;
        } while (localawgq != null);
        localawgq = a(paramQQAppInterface, paramString, localExtensionInfo, 3L);
        localObject = localawgq;
      } while (localawgq != null);
      paramQQAppInterface = a(paramQQAppInterface, paramString, localExtensionInfo, 26L);
      localObject = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  private static awgr a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {}
    do
    {
      do
      {
        return null;
        if (!awfy.c(paramLong)) {
          break;
        }
      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
      return (awgr)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramLong));
    } while ((!awfy.b(paramLong)) || ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 26L) && (paramLong != 3L)) || (paramExtensionInfo.intimate_type != paramLong) || (paramExtensionInfo.intimate_level < 0) || (paramExtensionInfo.intimate_level > 2));
    paramQQAppInterface = new awgr();
    paramQQAppInterface.jdField_a_of_type_Long = paramExtensionInfo.intimate_type;
    paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.intimate_level;
    if (paramExtensionInfo.isExtinguish) {
      paramQQAppInterface.f = 1L;
    }
    paramQQAppInterface.d = paramExtensionInfo.last_intimate_chatTime;
    paramQQAppInterface.c = paramExtensionInfo.intimate_chatDays;
    return paramQQAppInterface;
  }
  
  public static Pair<awgq, awgq> a(QQAppInterface paramQQAppInterface, String paramString)
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
        localObject3 = (awgq)((Iterator)localObject4).next();
        if (!((awgq)localObject3).jdField_b_of_type_Boolean)
        {
          if ((localObject2 == null) || (((awgq)localObject3).jdField_b_of_type_Int < ((awgq)localObject2).jdField_b_of_type_Int)) {
            localObject2 = localObject3;
          }
        }
        else {
          for (;;)
          {
            break;
            if ((localObject1 != null) && (((awgq)localObject3).jdField_b_of_type_Int >= localObject1.jdField_b_of_type_Int)) {
              break label182;
            }
            localObject1 = localObject3;
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (TextUtils.isEmpty(((awgq)localObject2).jdField_b_of_type_JavaLangString))) {
          awgl.a().a(paramQQAppInterface, paramString, (awgq)localObject2);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (TextUtils.isEmpty(localObject1.jdField_b_of_type_JavaLangString))
          {
            awgl.a().a(paramQQAppInterface, paramString, localObject1);
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
  
  public static ArrayList<SingleLineTextView.IconDrawableInfo> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<awgq> paramArrayList)
  {
    awgq localawgq = null;
    Object localObject = localawgq;
    if (paramArrayList != null)
    {
      localObject = localawgq;
      if (!paramArrayList.isEmpty())
      {
        localObject = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localawgq = (awgq)paramArrayList.next();
          SingleLineTextView.IconDrawableInfo localIconDrawableInfo = new SingleLineTextView.IconDrawableInfo();
          localIconDrawableInfo.iconResId = localawgq.jdField_c_of_type_Int;
          localIconDrawableInfo.icon_static_url = localawgq.jdField_c_of_type_JavaLangString;
          if (TextUtils.isEmpty(localawgq.jdField_b_of_type_JavaLangString)) {
            awgl.a().a(paramQQAppInterface, paramString, localawgq);
          }
          if (!TextUtils.isEmpty(localawgq.jdField_b_of_type_JavaLangString)) {
            localIconDrawableInfo.iconDynamicUrl = localawgq.jdField_b_of_type_JavaLangString;
          }
          localIconDrawableInfo.icon_status_alpha = localawgq.a();
          if (Float.compare(localIconDrawableInfo.icon_status_alpha, 1.0F) < 0) {
            QLog.i("MutualMarkDataCenter", 1, "getRecentListIconDrawableInfos friendUin:" + paramString + " info:" + localawgq.toString());
          }
          ((ArrayList)localObject).add(localIconDrawableInfo);
        }
      }
    }
    return localObject;
  }
  
  public static ArrayList<awgq> a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = (amsw)paramQQAppInterface.getManager(51);
    if (localObject == null) {
      paramQQAppInterface = null;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if ((paramInt == 2) || (paramInt == 1)) {}
        for (boolean bool = ((amsw)localObject).a(true); bool; bool = ((amsw)localObject).a(false)) {
          return null;
        }
        if (!((amsw)localObject).c(paramString)) {
          return null;
        }
        ExtensionInfo localExtensionInfo = ((amsw)localObject).a(paramString, paramBoolean);
        if (localExtensionInfo == null) {
          return null;
        }
        localObject = new ArrayList();
        long[] arrayOfLong = awfo.b;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          awgq localawgq = a(paramQQAppInterface, paramString, localExtensionInfo, arrayOfLong[i]);
          if (localawgq != null) {
            ((ArrayList)localObject).add(localawgq);
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
  
  public static void a(awgq paramawgq, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramawgq == null)) {}
    do
    {
      do
      {
        return;
      } while ((!awfy.c(paramawgq.jdField_a_of_type_Long)) || (paramExtensionInfo.mutualMarks == null));
      paramExtensionInfo = (awgr)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramawgq.jdField_a_of_type_Long));
    } while (paramExtensionInfo == null);
    paramExtensionInfo.jdField_b_of_type_Boolean = paramawgq.jdField_a_of_type_Boolean;
    paramExtensionInfo.i = paramawgq.i;
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
        Object localObject = apyz.a().a(paramLong);
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          b(paramQQAppInterface, paramString, paramExtensionInfo, ((awgn)((Iterator)localObject).next()).jdField_a_of_type_Long);
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
        if (!awfy.c(paramLong)) {
          break;
        }
      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(paramLong));
      return;
    } while ((!awfy.b(paramLong)) || ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 26L) && (paramLong != 3L)) || (paramExtensionInfo.intimate_type != paramLong));
    paramExtensionInfo.intimate_type = 0;
    paramExtensionInfo.intimate_level = 0;
    paramExtensionInfo.intimate_chatDays = 0;
    paramExtensionInfo.last_intimate_chatTime = 0L;
    paramExtensionInfo.isExtinguish = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfp
 * JD-Core Version:    0.7.0.1
 */