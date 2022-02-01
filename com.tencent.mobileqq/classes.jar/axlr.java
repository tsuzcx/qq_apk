import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class axlr
{
  static Comparator<axms> a = new axls();
  
  public static axms a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      Object localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        return null;
      }
      if (((anvk)localObject).a(false)) {
        return null;
      }
      if (!((anvk)localObject).c(paramString)) {
        return null;
      }
      localObject = ((anvk)localObject).a(paramString, paramBoolean);
      if (localObject == null) {
        return null;
      }
      paramString = a(paramQQAppInterface, paramString, (ExtensionInfo)localObject, paramLong);
      paramQQAppInterface = paramString;
    } while (paramString != null);
    return null;
  }
  
  private static axms a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      return null;
    }
    paramExtensionInfo = a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong);
    if ((paramExtensionInfo != null) && (!paramExtensionInfo.jdField_a_of_type_Boolean))
    {
      axmp localaxmp = arcc.a().a(paramExtensionInfo.jdField_a_of_type_Long);
      if (localaxmp != null)
      {
        axms localaxms = new axms();
        localaxms.a(paramExtensionInfo);
        localaxms.jdField_c_of_type_Boolean = localaxmp.jdField_b_of_type_Boolean;
        localaxms.jdField_a_of_type_JavaLangString = localaxmp.a(localaxms.jdField_b_of_type_Long);
        localaxms.jdField_b_of_type_Boolean = localaxmp.jdField_a_of_type_Boolean;
        localaxms.jdField_b_of_type_Int = localaxmp.jdField_b_of_type_Int;
        localaxms.jdField_a_of_type_Int = localaxmp.jdField_a_of_type_Int;
        localaxms.jdField_c_of_type_Int = axlp.a(paramQQAppInterface, paramString, localaxms.jdField_a_of_type_Long, localaxms.jdField_b_of_type_Long);
        localaxms.jdField_c_of_type_JavaLangString = axma.c(localaxms.jdField_c_of_type_JavaLangString);
        axmn.a().a(paramQQAppInterface, paramString, localaxms);
        localaxms.jdField_c_of_type_JavaLangString = axml.a(paramQQAppInterface, paramString, localaxms.jdField_a_of_type_Long, localaxms.jdField_b_of_type_Long, localaxms.h, localaxms.jdField_c_of_type_JavaLangString);
        if (!localaxms.d())
        {
          if (QLog.isColorLevel()) {
            QLog.i("MutualMarkDataCenter", 2, "getMutualMarkDisPlayInfo IconResource InValid displayInfo:" + localaxms);
          }
          return null;
        }
        if ((localaxmp.a(localaxms.jdField_b_of_type_Long)) && (axlp.b(paramQQAppInterface, localaxms.jdField_a_of_type_Long, localaxms.jdField_b_of_type_Long))) {
          return localaxms;
        }
        if ((localaxmp.a()) && (axlp.b(paramQQAppInterface, localaxms.jdField_a_of_type_Long)))
        {
          paramLong = localaxmp.a(localaxms.jdField_b_of_type_Long);
          if (paramLong != -1L)
          {
            localaxms.jdField_b_of_type_Long = paramLong;
            return localaxms;
          }
        }
      }
    }
    return null;
  }
  
  public static axms a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      localObject = null;
    }
    do
    {
      ExtensionInfo localExtensionInfo;
      axms localaxms;
      do
      {
        do
        {
          do
          {
            return localObject;
            localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (localObject == null) {
              return null;
            }
            if (((anvk)localObject).a(false)) {
              return null;
            }
            if (!((anvk)localObject).c(paramString)) {
              return null;
            }
            localExtensionInfo = ((anvk)localObject).a(paramString, paramBoolean);
            if (localExtensionInfo == null) {
              return null;
            }
            localaxms = a(paramQQAppInterface, paramString, localExtensionInfo, 1L);
            localObject = localaxms;
          } while (localaxms != null);
          localaxms = a(paramQQAppInterface, paramString, localExtensionInfo, 2L);
          localObject = localaxms;
        } while (localaxms != null);
        localaxms = a(paramQQAppInterface, paramString, localExtensionInfo, 3L);
        localObject = localaxms;
      } while (localaxms != null);
      paramQQAppInterface = a(paramQQAppInterface, paramString, localExtensionInfo, 26L);
      localObject = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  private static axmt a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {}
    do
    {
      do
      {
        return null;
        if (!axma.c(paramLong)) {
          break;
        }
      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
      return (axmt)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramLong));
    } while ((!axma.b(paramLong)) || ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 26L) && (paramLong != 3L)) || (paramExtensionInfo.intimate_type != paramLong) || (paramExtensionInfo.intimate_level < 0) || (paramExtensionInfo.intimate_level > 2));
    paramQQAppInterface = new axmt();
    paramQQAppInterface.jdField_a_of_type_Long = paramExtensionInfo.intimate_type;
    paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.intimate_level;
    if (paramExtensionInfo.isExtinguish) {
      paramQQAppInterface.f = 1L;
    }
    paramQQAppInterface.d = paramExtensionInfo.last_intimate_chatTime;
    paramQQAppInterface.c = paramExtensionInfo.intimate_chatDays;
    return paramQQAppInterface;
  }
  
  public static Pair<axms, axms> a(QQAppInterface paramQQAppInterface, String paramString)
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
        localObject3 = (axms)((Iterator)localObject4).next();
        if (!((axms)localObject3).jdField_b_of_type_Boolean)
        {
          if ((localObject2 == null) || (((axms)localObject3).jdField_b_of_type_Int < ((axms)localObject2).jdField_b_of_type_Int)) {
            localObject2 = localObject3;
          }
        }
        else {
          for (;;)
          {
            break;
            if ((localObject1 != null) && (((axms)localObject3).jdField_b_of_type_Int >= localObject1.jdField_b_of_type_Int)) {
              break label182;
            }
            localObject1 = localObject3;
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (TextUtils.isEmpty(((axms)localObject2).jdField_b_of_type_JavaLangString))) {
          axmn.a().a(paramQQAppInterface, paramString, (axms)localObject2);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (TextUtils.isEmpty(localObject1.jdField_b_of_type_JavaLangString))
          {
            axmn.a().a(paramQQAppInterface, paramString, localObject1);
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
  
  public static ArrayList<SingleLineTextView.IconDrawableInfo> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<axms> paramArrayList)
  {
    axms localaxms = null;
    Object localObject = localaxms;
    if (paramArrayList != null)
    {
      localObject = localaxms;
      if (!paramArrayList.isEmpty())
      {
        localObject = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localaxms = (axms)paramArrayList.next();
          SingleLineTextView.IconDrawableInfo localIconDrawableInfo = new SingleLineTextView.IconDrawableInfo();
          localIconDrawableInfo.iconResId = localaxms.jdField_c_of_type_Int;
          localIconDrawableInfo.icon_static_url = localaxms.jdField_c_of_type_JavaLangString;
          if (TextUtils.isEmpty(localaxms.jdField_b_of_type_JavaLangString)) {
            axmn.a().a(paramQQAppInterface, paramString, localaxms);
          }
          if (!TextUtils.isEmpty(localaxms.jdField_b_of_type_JavaLangString)) {
            localIconDrawableInfo.iconDynamicUrl = localaxms.jdField_b_of_type_JavaLangString;
          }
          localIconDrawableInfo.icon_status_alpha = localaxms.a();
          if (Float.compare(localIconDrawableInfo.icon_status_alpha, 1.0F) < 0) {
            QLog.i("MutualMarkDataCenter", 1, "getRecentListIconDrawableInfos friendUin:" + paramString + " info:" + localaxms.toString());
          }
          ((ArrayList)localObject).add(localIconDrawableInfo);
        }
      }
    }
    return localObject;
  }
  
  public static ArrayList<axms> a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null) {
      paramQQAppInterface = null;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if ((paramInt == 2) || (paramInt == 1)) {}
        for (boolean bool = ((anvk)localObject).a(true); bool; bool = ((anvk)localObject).a(false)) {
          return null;
        }
        if (!((anvk)localObject).c(paramString)) {
          return null;
        }
        ExtensionInfo localExtensionInfo = ((anvk)localObject).a(paramString, paramBoolean);
        if (localExtensionInfo == null) {
          return null;
        }
        localObject = new ArrayList();
        long[] arrayOfLong = axlq.b;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          axms localaxms = a(paramQQAppInterface, paramString, localExtensionInfo, arrayOfLong[i]);
          if (localaxms != null) {
            ((ArrayList)localObject).add(localaxms);
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
  
  public static void a(axms paramaxms, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramaxms == null)) {}
    do
    {
      do
      {
        return;
      } while ((!axma.c(paramaxms.jdField_a_of_type_Long)) || (paramExtensionInfo.mutualMarks == null));
      paramExtensionInfo = (axmt)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramaxms.jdField_a_of_type_Long));
    } while (paramExtensionInfo == null);
    paramExtensionInfo.jdField_b_of_type_Boolean = paramaxms.jdField_a_of_type_Boolean;
    paramExtensionInfo.i = paramaxms.i;
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
        Object localObject = arcc.a().a(paramLong);
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          b(paramQQAppInterface, paramString, paramExtensionInfo, ((axmp)((Iterator)localObject).next()).jdField_a_of_type_Long);
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
        if (!axma.c(paramLong)) {
          break;
        }
      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(paramLong));
      return;
    } while ((!axma.b(paramLong)) || ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 26L) && (paramLong != 3L)) || (paramExtensionInfo.intimate_type != paramLong));
    paramExtensionInfo.intimate_type = 0;
    paramExtensionInfo.intimate_level = 0;
    paramExtensionInfo.intimate_chatDays = 0;
    paramExtensionInfo.last_intimate_chatTime = 0L;
    paramExtensionInfo.isExtinguish = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlr
 * JD-Core Version:    0.7.0.1
 */