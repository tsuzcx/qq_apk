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

public class ausj
{
  static Comparator<autj> a = new ausk();
  
  public static autj a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      Object localObject = (alto)paramQQAppInterface.getManager(51);
      if (localObject == null) {
        return null;
      }
      if (((alto)localObject).a(false)) {
        return null;
      }
      if (!((alto)localObject).c(paramString)) {
        return null;
      }
      localObject = ((alto)localObject).a(paramString, paramBoolean);
      if (localObject == null) {
        return null;
      }
      paramString = a(paramQQAppInterface, paramString, (ExtensionInfo)localObject, paramLong);
      paramQQAppInterface = paramString;
    } while (paramString != null);
    return null;
  }
  
  private static autj a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      return null;
    }
    paramExtensionInfo = a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong);
    if ((paramExtensionInfo != null) && (!paramExtensionInfo.jdField_a_of_type_Boolean))
    {
      auth localauth = aooq.a().a(paramExtensionInfo.jdField_a_of_type_Long);
      if (localauth != null)
      {
        autj localautj = new autj();
        localautj.a(paramExtensionInfo);
        localautj.jdField_c_of_type_Boolean = localauth.jdField_b_of_type_Boolean;
        localautj.jdField_a_of_type_JavaLangString = localauth.a(localautj.jdField_b_of_type_Long);
        localautj.jdField_b_of_type_Boolean = localauth.jdField_a_of_type_Boolean;
        localautj.jdField_b_of_type_Int = localauth.jdField_b_of_type_Int;
        localautj.jdField_a_of_type_Int = localauth.jdField_a_of_type_Int;
        localautj.jdField_c_of_type_Int = aush.a(paramQQAppInterface, paramString, localautj.jdField_a_of_type_Long, localautj.jdField_b_of_type_Long);
        if (!localautj.d())
        {
          if (QLog.isColorLevel()) {
            QLog.i("MutualMarkDataCenter", 2, "getMutualMarkDisPlayInfo IconResource InValid displayInfo:" + localautj);
          }
          return null;
        }
        if ((localauth.a(localautj.jdField_b_of_type_Long)) && (aush.b(paramQQAppInterface, localautj.jdField_a_of_type_Long, localautj.jdField_b_of_type_Long))) {
          return localautj;
        }
        if ((localauth.a()) && (aush.b(paramQQAppInterface, localautj.jdField_a_of_type_Long)))
        {
          paramLong = localauth.a(localautj.jdField_b_of_type_Long);
          if (paramLong != -1L)
          {
            localautj.jdField_b_of_type_Long = paramLong;
            return localautj;
          }
        }
      }
    }
    return null;
  }
  
  public static autj a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      localObject = null;
    }
    do
    {
      ExtensionInfo localExtensionInfo;
      autj localautj;
      do
      {
        do
        {
          return localObject;
          localObject = (alto)paramQQAppInterface.getManager(51);
          if (localObject == null) {
            return null;
          }
          if (((alto)localObject).a(false)) {
            return null;
          }
          if (!((alto)localObject).c(paramString)) {
            return null;
          }
          localExtensionInfo = ((alto)localObject).a(paramString, paramBoolean);
          if (localExtensionInfo == null) {
            return null;
          }
          localautj = a(paramQQAppInterface, paramString, localExtensionInfo, 1L);
          localObject = localautj;
        } while (localautj != null);
        localautj = a(paramQQAppInterface, paramString, localExtensionInfo, 2L);
        localObject = localautj;
      } while (localautj != null);
      paramQQAppInterface = a(paramQQAppInterface, paramString, localExtensionInfo, 3L);
      localObject = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  private static autk a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
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
                                            if (!auss.c(paramLong)) {
                                              break;
                                            }
                                            localObject1 = localObject2;
                                          } while (paramExtensionInfo.mutualMarks == null);
                                          localObject1 = localObject2;
                                        } while (paramExtensionInfo.mutualMarks.isEmpty());
                                        return (autk)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramLong));
                                        localObject1 = localObject2;
                                      } while (!auss.b(paramLong));
                                      if ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) {
                                        break;
                                      }
                                      localObject1 = localObject2;
                                    } while (paramExtensionInfo.intimate_type != paramLong);
                                    localObject1 = localObject2;
                                  } while (paramExtensionInfo.intimate_level < 0);
                                  localObject1 = localObject2;
                                } while (paramExtensionInfo.intimate_level > 2);
                                paramQQAppInterface = new autk();
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
                            paramQQAppInterface = new autk();
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
                        paramQQAppInterface = new autk();
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
                    paramQQAppInterface = new autk();
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
                paramQQAppInterface = new autk();
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
            if (!autp.b()) {
              break;
            }
            localObject1 = localObject2;
          } while (paramExtensionInfo.newBestIntimacyType < 1);
          localObject1 = localObject2;
        } while (paramExtensionInfo.newBestIntimacyType > 2);
        paramQQAppInterface = new autk();
        paramQQAppInterface.jdField_a_of_type_Long = 12L;
        paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.newBestIntimacyType;
        return paramQQAppInterface;
        localObject1 = localObject2;
      } while (paramExtensionInfo.bestIntimacyType < 1);
      localObject1 = localObject2;
    } while (paramExtensionInfo.bestIntimacyType > 2);
    paramQQAppInterface = new autk();
    paramQQAppInterface.jdField_a_of_type_Long = 12L;
    paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.bestIntimacyType;
    return paramQQAppInterface;
  }
  
  public static Pair<autj, autj> a(QQAppInterface paramQQAppInterface, String paramString)
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
        localObject3 = (autj)((Iterator)localObject4).next();
        if (!((autj)localObject3).jdField_b_of_type_Boolean)
        {
          if ((localObject2 == null) || (((autj)localObject3).jdField_b_of_type_Int < ((autj)localObject2).jdField_b_of_type_Int)) {
            localObject2 = localObject3;
          }
        }
        else {
          for (;;)
          {
            break;
            if ((localObject1 != null) && (((autj)localObject3).jdField_b_of_type_Int >= localObject1.jdField_b_of_type_Int)) {
              break label182;
            }
            localObject1 = localObject3;
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (TextUtils.isEmpty(((autj)localObject2).jdField_b_of_type_JavaLangString))) {
          autf.a().a(paramQQAppInterface, paramString, (autj)localObject2);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (TextUtils.isEmpty(localObject1.jdField_b_of_type_JavaLangString))
          {
            autf.a().a(paramQQAppInterface, paramString, localObject1);
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
  
  public static ArrayList<biaz> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<autj> paramArrayList)
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
          paramArrayList = (autj)paramString.next();
          biaz localbiaz = new biaz();
          localbiaz.jdField_a_of_type_Int = paramArrayList.jdField_c_of_type_Int;
          localbiaz.jdField_a_of_type_JavaLangString = paramArrayList.jdField_c_of_type_JavaLangString;
          localbiaz.jdField_a_of_type_Float = paramArrayList.a();
          paramQQAppInterface.add(localbiaz);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static ArrayList<autj> a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = (alto)paramQQAppInterface.getManager(51);
    if (localObject == null) {
      paramQQAppInterface = null;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if ((paramInt == 2) || (paramInt == 1)) {}
        for (boolean bool = ((alto)localObject).a(true); bool; bool = ((alto)localObject).a(false)) {
          return null;
        }
        if (!((alto)localObject).c(paramString)) {
          return null;
        }
        ExtensionInfo localExtensionInfo = ((alto)localObject).a(paramString, paramBoolean);
        if (localExtensionInfo == null) {
          return null;
        }
        localObject = new ArrayList();
        long[] arrayOfLong = ausi.b;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          autj localautj = a(paramQQAppInterface, paramString, localExtensionInfo, arrayOfLong[i]);
          if (localautj != null) {
            ((ArrayList)localObject).add(localautj);
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
  
  public static void a(autj paramautj, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramautj == null)) {}
    do
    {
      do
      {
        return;
        if (!auss.c(paramautj.jdField_a_of_type_Long)) {
          break;
        }
      } while (paramExtensionInfo.mutualMarks == null);
      paramExtensionInfo = (autk)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramautj.jdField_a_of_type_Long));
    } while (paramExtensionInfo == null);
    paramExtensionInfo.jdField_b_of_type_Boolean = paramautj.jdField_a_of_type_Boolean;
    paramExtensionInfo.h = paramautj.h;
    return;
    switch ((int)paramautj.jdField_a_of_type_Long)
    {
    default: 
      return;
    case 4: 
      paramExtensionInfo.hasRemindFrdship = paramautj.jdField_a_of_type_Boolean;
      paramExtensionInfo.frdshipAnimStartTime = paramautj.h;
      return;
    case 5: 
      paramExtensionInfo.hasRemindChat = paramautj.jdField_a_of_type_Boolean;
      paramExtensionInfo.chatAnimStartTime = paramautj.h;
      return;
    }
    paramExtensionInfo.hasRemindPraise = paramautj.jdField_a_of_type_Boolean;
    paramExtensionInfo.praiseAnimStartTime = paramautj.h;
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
        Object localObject = aooq.a().a(paramLong);
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          b(paramQQAppInterface, paramString, paramExtensionInfo, ((auth)((Iterator)localObject).next()).jdField_a_of_type_Long);
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
                        if (!auss.c(paramLong)) {
                          break;
                        }
                      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
                      paramExtensionInfo.mutualMarks.remove(Long.valueOf(paramLong));
                      return;
                    } while (!auss.b(paramLong));
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
        if (!autp.b()) {
          break;
        }
      } while ((paramExtensionInfo.newBestIntimacyType < 1) || (paramExtensionInfo.newBestIntimacyType > 2));
      paramExtensionInfo.newBestIntimacyType = 0;
      return;
    } while ((paramExtensionInfo.bestIntimacyType < 1) || (paramExtensionInfo.bestIntimacyType > 2));
    paramExtensionInfo.bestIntimacyType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausj
 * JD-Core Version:    0.7.0.1
 */