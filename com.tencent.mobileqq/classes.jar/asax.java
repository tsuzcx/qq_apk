import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class asax
{
  static Comparator<asbx> a = new asay();
  
  public static asbx a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      Object localObject = (ajjj)paramQQAppInterface.getManager(51);
      if (localObject == null) {
        return null;
      }
      if (((ajjj)localObject).a(false)) {
        return null;
      }
      if (!((ajjj)localObject).c(paramString)) {
        return null;
      }
      localObject = ((ajjj)localObject).a(paramString, paramBoolean);
      if (localObject == null) {
        return null;
      }
      paramString = a(paramQQAppInterface, paramString, (ExtensionInfo)localObject, paramLong);
      paramQQAppInterface = paramString;
    } while (paramString != null);
    return null;
  }
  
  private static asbx a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      return null;
    }
    paramExtensionInfo = a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong);
    if ((paramExtensionInfo != null) && (!paramExtensionInfo.jdField_a_of_type_Boolean))
    {
      asbv localasbv = amde.a().a(paramExtensionInfo.jdField_a_of_type_Long);
      if (localasbv != null)
      {
        asbx localasbx = new asbx();
        localasbx.a(paramExtensionInfo);
        localasbx.jdField_c_of_type_Boolean = localasbv.jdField_b_of_type_Boolean;
        localasbx.jdField_a_of_type_JavaLangString = localasbv.a(localasbx.jdField_b_of_type_Long);
        localasbx.jdField_b_of_type_Boolean = localasbv.jdField_a_of_type_Boolean;
        localasbx.jdField_b_of_type_Int = localasbv.jdField_b_of_type_Int;
        localasbx.jdField_a_of_type_Int = localasbv.jdField_a_of_type_Int;
        localasbx.jdField_c_of_type_Int = asav.a(paramQQAppInterface, paramString, localasbx.jdField_a_of_type_Long, localasbx.jdField_b_of_type_Long);
        if (!localasbx.d())
        {
          if (QLog.isColorLevel()) {
            QLog.i("MutualMarkDataCenter", 2, "getMutualMarkDisPlayInfo IconResource InValid displayInfo:" + localasbx);
          }
          return null;
        }
        if ((localasbv.a(localasbx.jdField_b_of_type_Long)) && (asav.b(paramQQAppInterface, localasbx.jdField_a_of_type_Long, localasbx.jdField_b_of_type_Long))) {
          return localasbx;
        }
        if ((localasbv.a()) && (asav.b(paramQQAppInterface, localasbx.jdField_a_of_type_Long)))
        {
          paramLong = localasbv.a(localasbx.jdField_b_of_type_Long);
          if (paramLong != -1L)
          {
            localasbx.jdField_b_of_type_Long = paramLong;
            return localasbx;
          }
        }
      }
    }
    return null;
  }
  
  public static asbx a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      localObject = null;
    }
    do
    {
      ExtensionInfo localExtensionInfo;
      asbx localasbx;
      do
      {
        do
        {
          return localObject;
          localObject = (ajjj)paramQQAppInterface.getManager(51);
          if (localObject == null) {
            return null;
          }
          if (((ajjj)localObject).a(false)) {
            return null;
          }
          if (!((ajjj)localObject).c(paramString)) {
            return null;
          }
          localExtensionInfo = ((ajjj)localObject).a(paramString, paramBoolean);
          if (localExtensionInfo == null) {
            return null;
          }
          localasbx = a(paramQQAppInterface, paramString, localExtensionInfo, 1L);
          localObject = localasbx;
        } while (localasbx != null);
        localasbx = a(paramQQAppInterface, paramString, localExtensionInfo, 2L);
        localObject = localasbx;
      } while (localasbx != null);
      paramQQAppInterface = a(paramQQAppInterface, paramString, localExtensionInfo, 3L);
      localObject = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  private static asby a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramExtensionInfo != null) {
          break label33;
        }
        localObject1 = localObject2;
      }
    }
    label33:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            return localObject1;
                                            if (!asbg.c(paramLong)) {
                                              break;
                                            }
                                            localObject1 = localObject2;
                                          } while (paramExtensionInfo.mutualMarks == null);
                                          localObject1 = localObject2;
                                        } while (paramExtensionInfo.mutualMarks.isEmpty());
                                        return (asby)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramLong));
                                        localObject1 = localObject2;
                                      } while (!asbg.b(paramLong));
                                      if ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) {
                                        break;
                                      }
                                      localObject1 = localObject2;
                                    } while (paramExtensionInfo.intimate_type != paramLong);
                                    localObject1 = localObject2;
                                  } while (paramExtensionInfo.intimate_level < 0);
                                  localObject1 = localObject2;
                                } while (paramExtensionInfo.intimate_level > 2);
                                paramQQAppInterface = new asby();
                                paramQQAppInterface.jdField_a_of_type_Long = paramExtensionInfo.intimate_type;
                                paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.intimate_level;
                                if (paramExtensionInfo.isExtinguish) {
                                  paramQQAppInterface.f = 1L;
                                }
                                paramQQAppInterface.d = paramExtensionInfo.last_intimate_chatTime;
                                paramQQAppInterface.c = paramExtensionInfo.intimate_chatDays;
                                return paramQQAppInterface;
                                if (paramLong != 4L) {
                                  break;
                                }
                                localObject1 = localObject2;
                              } while (paramExtensionInfo.friendshipLevel < 1);
                              localObject1 = localObject2;
                            } while (paramExtensionInfo.friendshipLevel > 3);
                            paramQQAppInterface = new asby();
                            paramQQAppInterface.jdField_a_of_type_Long = 4L;
                            paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.friendshipLevel;
                            paramQQAppInterface.d = paramExtensionInfo.lastFriendshipTime;
                            paramQQAppInterface.c = paramExtensionInfo.friendshipChatDays;
                            paramQQAppInterface.jdField_b_of_type_Boolean = paramExtensionInfo.hasRemindFrdship;
                            paramQQAppInterface.h = paramExtensionInfo.frdshipAnimStartTime;
                            return paramQQAppInterface;
                            if (paramLong != 5L) {
                              break;
                            }
                            localObject1 = localObject2;
                          } while (paramExtensionInfo.chatHotLevel < 1);
                          localObject1 = localObject2;
                        } while (paramExtensionInfo.chatHotLevel > 2);
                        paramQQAppInterface = new asby();
                        paramQQAppInterface.jdField_a_of_type_Long = 5L;
                        paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.chatHotLevel;
                        paramQQAppInterface.d = paramExtensionInfo.lastChatTime;
                        paramQQAppInterface.c = paramExtensionInfo.chatDays;
                        paramQQAppInterface.jdField_b_of_type_Boolean = paramExtensionInfo.hasRemindChat;
                        paramQQAppInterface.h = paramExtensionInfo.chatAnimStartTime;
                        return paramQQAppInterface;
                        if (paramLong != 6L) {
                          break;
                        }
                        localObject1 = localObject2;
                      } while (paramExtensionInfo.praiseHotLevel < 1);
                      localObject1 = localObject2;
                    } while (paramExtensionInfo.praiseHotLevel > 2);
                    paramQQAppInterface = new asby();
                    paramQQAppInterface.jdField_a_of_type_Long = 6L;
                    paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.praiseHotLevel;
                    paramQQAppInterface.d = paramExtensionInfo.lastpraiseTime;
                    paramQQAppInterface.jdField_b_of_type_Boolean = paramExtensionInfo.hasRemindPraise;
                    paramQQAppInterface.h = paramExtensionInfo.praiseAnimStartTime;
                    return paramQQAppInterface;
                    if (paramLong != 7L) {
                      break;
                    }
                    localObject1 = localObject2;
                  } while (paramExtensionInfo.loverChatLevel < 1);
                  localObject1 = localObject2;
                } while (paramExtensionInfo.loverChatLevel > 2);
                paramQQAppInterface = new asby();
                paramQQAppInterface.jdField_a_of_type_Long = 7L;
                paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.loverChatLevel;
                paramQQAppInterface.d = paramExtensionInfo.loverLastChatTime;
                paramQQAppInterface.c = paramExtensionInfo.loverChatDays;
                localObject1 = paramQQAppInterface;
              } while (!paramExtensionInfo.loverTransFlag);
              paramQQAppInterface.f = 2L;
              paramQQAppInterface.g = (NetConnInfoCenter.getServerTimeMillis() / 1000L + 86400L);
              return paramQQAppInterface;
              localObject1 = localObject2;
            } while (paramLong != 12L);
            if (!ascd.b()) {
              break;
            }
            localObject1 = localObject2;
          } while (paramExtensionInfo.newBestIntimacyType < 1);
          localObject1 = localObject2;
        } while (paramExtensionInfo.newBestIntimacyType > 2);
        paramQQAppInterface = new asby();
        paramQQAppInterface.jdField_a_of_type_Long = 12L;
        paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.newBestIntimacyType;
        return paramQQAppInterface;
        localObject1 = localObject2;
      } while (paramExtensionInfo.bestIntimacyType < 1);
      localObject1 = localObject2;
    } while (paramExtensionInfo.bestIntimacyType > 2);
    paramQQAppInterface = new asby();
    paramQQAppInterface.jdField_a_of_type_Long = 12L;
    paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.bestIntimacyType;
    return paramQQAppInterface;
  }
  
  public static Pair<asbx, asbx> a(QQAppInterface paramQQAppInterface, String paramString)
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
        localObject3 = (asbx)((Iterator)localObject4).next();
        if (!((asbx)localObject3).jdField_b_of_type_Boolean)
        {
          if ((localObject2 == null) || (((asbx)localObject3).jdField_b_of_type_Int < ((asbx)localObject2).jdField_b_of_type_Int)) {
            localObject2 = localObject3;
          }
        }
        else {
          for (;;)
          {
            break;
            if ((localObject1 != null) && (((asbx)localObject3).jdField_b_of_type_Int >= localObject1.jdField_b_of_type_Int)) {
              break label182;
            }
            localObject1 = localObject3;
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (TextUtils.isEmpty(((asbx)localObject2).jdField_b_of_type_JavaLangString))) {
          asbt.a().a(paramQQAppInterface, paramString, (asbx)localObject2);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (TextUtils.isEmpty(localObject1.jdField_b_of_type_JavaLangString))
          {
            asbt.a().a(paramQQAppInterface, paramString, localObject1);
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
  
  public static ArrayList<benk> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<asbx> paramArrayList)
  {
    paramString = null;
    paramQQAppInterface = paramString;
    if (paramArrayList != null)
    {
      paramQQAppInterface = paramString;
      if (!paramArrayList.isEmpty())
      {
        paramQQAppInterface = new ArrayList();
        paramString = paramArrayList.iterator();
        while (paramString.hasNext())
        {
          paramArrayList = (asbx)paramString.next();
          benk localbenk = new benk();
          localbenk.jdField_a_of_type_Int = paramArrayList.jdField_c_of_type_Int;
          localbenk.jdField_a_of_type_JavaLangString = paramArrayList.jdField_c_of_type_JavaLangString;
          localbenk.jdField_a_of_type_Float = paramArrayList.a();
          paramQQAppInterface.add(localbenk);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static ArrayList<asbx> a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = (ajjj)paramQQAppInterface.getManager(51);
    if (localObject == null) {
      paramQQAppInterface = null;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if ((paramInt == 2) || (paramInt == 1)) {}
        for (boolean bool = ((ajjj)localObject).a(true); bool; bool = ((ajjj)localObject).a(false)) {
          return null;
        }
        if (!((ajjj)localObject).c(paramString)) {
          return null;
        }
        ExtensionInfo localExtensionInfo = ((ajjj)localObject).a(paramString, paramBoolean);
        if (localExtensionInfo == null) {
          return null;
        }
        localObject = new ArrayList();
        long[] arrayOfLong = asaw.b;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          asbx localasbx = a(paramQQAppInterface, paramString, localExtensionInfo, arrayOfLong[i]);
          if (localasbx != null) {
            ((ArrayList)localObject).add(localasbx);
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
  
  public static void a(asbx paramasbx, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramasbx == null)) {}
    do
    {
      do
      {
        return;
        if (!asbg.c(paramasbx.jdField_a_of_type_Long)) {
          break;
        }
      } while (paramExtensionInfo.mutualMarks == null);
      paramExtensionInfo = (asby)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramasbx.jdField_a_of_type_Long));
    } while (paramExtensionInfo == null);
    paramExtensionInfo.jdField_b_of_type_Boolean = paramasbx.jdField_a_of_type_Boolean;
    paramExtensionInfo.h = paramasbx.h;
    return;
    switch ((int)paramasbx.jdField_a_of_type_Long)
    {
    default: 
      return;
    case 4: 
      paramExtensionInfo.hasRemindFrdship = paramasbx.jdField_a_of_type_Boolean;
      paramExtensionInfo.frdshipAnimStartTime = paramasbx.h;
      return;
    case 5: 
      paramExtensionInfo.hasRemindChat = paramasbx.jdField_a_of_type_Boolean;
      paramExtensionInfo.chatAnimStartTime = paramasbx.h;
      return;
    }
    paramExtensionInfo.hasRemindPraise = paramasbx.jdField_a_of_type_Boolean;
    paramExtensionInfo.praiseAnimStartTime = paramasbx.h;
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
        Object localObject = amde.a().a(paramLong);
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          b(paramQQAppInterface, paramString, paramExtensionInfo, ((asbv)((Iterator)localObject).next()).jdField_a_of_type_Long);
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
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        if (!asbg.c(paramLong)) {
                          break;
                        }
                      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
                      paramExtensionInfo.mutualMarks.remove(Long.valueOf(paramLong));
                      return;
                    } while (!asbg.b(paramLong));
                    if ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) {
                      break;
                    }
                  } while (paramExtensionInfo.intimate_type != paramLong);
                  paramExtensionInfo.intimate_type = 0;
                  paramExtensionInfo.intimate_level = 0;
                  paramExtensionInfo.intimate_chatDays = 0;
                  paramExtensionInfo.last_intimate_chatTime = 0L;
                  paramExtensionInfo.isExtinguish = false;
                  return;
                  if (paramLong != 4L) {
                    break;
                  }
                } while ((paramExtensionInfo.friendshipLevel < 1) || (paramExtensionInfo.friendshipLevel > 3));
                paramExtensionInfo.friendshipLevel = 0;
                paramExtensionInfo.friendshipChatDays = 0;
                paramExtensionInfo.lastFriendshipTime = 0L;
                return;
                if (paramLong != 5L) {
                  break;
                }
              } while ((paramExtensionInfo.chatHotLevel < 1) || (paramExtensionInfo.chatHotLevel > 2));
              paramExtensionInfo.chatHotLevel = 0;
              return;
              if (paramLong != 6L) {
                break;
              }
            } while ((paramExtensionInfo.praiseHotLevel < 1) || (paramExtensionInfo.praiseHotLevel > 2));
            paramExtensionInfo.praiseHotLevel = 0;
            return;
            if (paramLong != 7L) {
              break;
            }
          } while ((paramExtensionInfo.loverChatLevel < 1) || (paramExtensionInfo.loverChatLevel > 2));
          paramExtensionInfo.loverChatLevel = 0;
          paramExtensionInfo.loverTransFlag = false;
          return;
        } while (paramLong != 12L);
        if (!ascd.b()) {
          break;
        }
      } while ((paramExtensionInfo.newBestIntimacyType < 1) || (paramExtensionInfo.newBestIntimacyType > 2));
      paramExtensionInfo.newBestIntimacyType = 0;
      return;
    } while ((paramExtensionInfo.bestIntimacyType < 1) || (paramExtensionInfo.bestIntimacyType > 2));
    paramExtensionInfo.bestIntimacyType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asax
 * JD-Core Version:    0.7.0.1
 */