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

public class asxb
{
  static Comparator<asyb> a = new asxc();
  
  public static asyb a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      Object localObject = (ajxn)paramQQAppInterface.getManager(51);
      if (localObject == null) {
        return null;
      }
      if (((ajxn)localObject).a(false)) {
        return null;
      }
      if (!((ajxn)localObject).c(paramString)) {
        return null;
      }
      localObject = ((ajxn)localObject).a(paramString, paramBoolean);
      if (localObject == null) {
        return null;
      }
      paramString = a(paramQQAppInterface, paramString, (ExtensionInfo)localObject, paramLong);
      paramQQAppInterface = paramString;
    } while (paramString != null);
    return null;
  }
  
  private static asyb a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      return null;
    }
    paramExtensionInfo = a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong);
    if ((paramExtensionInfo != null) && (!paramExtensionInfo.jdField_a_of_type_Boolean))
    {
      asxz localasxz = amtg.a().a(paramExtensionInfo.jdField_a_of_type_Long);
      if (localasxz != null)
      {
        asyb localasyb = new asyb();
        localasyb.a(paramExtensionInfo);
        localasyb.jdField_c_of_type_Boolean = localasxz.jdField_b_of_type_Boolean;
        localasyb.jdField_a_of_type_JavaLangString = localasxz.a(localasyb.jdField_b_of_type_Long);
        localasyb.jdField_b_of_type_Boolean = localasxz.jdField_a_of_type_Boolean;
        localasyb.jdField_b_of_type_Int = localasxz.jdField_b_of_type_Int;
        localasyb.jdField_a_of_type_Int = localasxz.jdField_a_of_type_Int;
        localasyb.jdField_c_of_type_Int = aswz.a(paramQQAppInterface, paramString, localasyb.jdField_a_of_type_Long, localasyb.jdField_b_of_type_Long);
        if (!localasyb.d())
        {
          if (QLog.isColorLevel()) {
            QLog.i("MutualMarkDataCenter", 2, "getMutualMarkDisPlayInfo IconResource InValid displayInfo:" + localasyb);
          }
          return null;
        }
        if ((localasxz.a(localasyb.jdField_b_of_type_Long)) && (aswz.b(paramQQAppInterface, localasyb.jdField_a_of_type_Long, localasyb.jdField_b_of_type_Long))) {
          return localasyb;
        }
        if ((localasxz.a()) && (aswz.b(paramQQAppInterface, localasyb.jdField_a_of_type_Long)))
        {
          paramLong = localasxz.a(localasyb.jdField_b_of_type_Long);
          if (paramLong != -1L)
          {
            localasyb.jdField_b_of_type_Long = paramLong;
            return localasyb;
          }
        }
      }
    }
    return null;
  }
  
  public static asyb a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      localObject = null;
    }
    do
    {
      ExtensionInfo localExtensionInfo;
      asyb localasyb;
      do
      {
        do
        {
          return localObject;
          localObject = (ajxn)paramQQAppInterface.getManager(51);
          if (localObject == null) {
            return null;
          }
          if (((ajxn)localObject).a(false)) {
            return null;
          }
          if (!((ajxn)localObject).c(paramString)) {
            return null;
          }
          localExtensionInfo = ((ajxn)localObject).a(paramString, paramBoolean);
          if (localExtensionInfo == null) {
            return null;
          }
          localasyb = a(paramQQAppInterface, paramString, localExtensionInfo, 1L);
          localObject = localasyb;
        } while (localasyb != null);
        localasyb = a(paramQQAppInterface, paramString, localExtensionInfo, 2L);
        localObject = localasyb;
      } while (localasyb != null);
      paramQQAppInterface = a(paramQQAppInterface, paramString, localExtensionInfo, 3L);
      localObject = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  private static asyc a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
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
                                            if (!asxk.c(paramLong)) {
                                              break;
                                            }
                                            localObject1 = localObject2;
                                          } while (paramExtensionInfo.mutualMarks == null);
                                          localObject1 = localObject2;
                                        } while (paramExtensionInfo.mutualMarks.isEmpty());
                                        return (asyc)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramLong));
                                        localObject1 = localObject2;
                                      } while (!asxk.b(paramLong));
                                      if ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) {
                                        break;
                                      }
                                      localObject1 = localObject2;
                                    } while (paramExtensionInfo.intimate_type != paramLong);
                                    localObject1 = localObject2;
                                  } while (paramExtensionInfo.intimate_level < 0);
                                  localObject1 = localObject2;
                                } while (paramExtensionInfo.intimate_level > 2);
                                paramQQAppInterface = new asyc();
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
                            paramQQAppInterface = new asyc();
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
                        paramQQAppInterface = new asyc();
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
                    paramQQAppInterface = new asyc();
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
                paramQQAppInterface = new asyc();
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
            if (!asyh.b()) {
              break;
            }
            localObject1 = localObject2;
          } while (paramExtensionInfo.newBestIntimacyType < 1);
          localObject1 = localObject2;
        } while (paramExtensionInfo.newBestIntimacyType > 2);
        paramQQAppInterface = new asyc();
        paramQQAppInterface.jdField_a_of_type_Long = 12L;
        paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.newBestIntimacyType;
        return paramQQAppInterface;
        localObject1 = localObject2;
      } while (paramExtensionInfo.bestIntimacyType < 1);
      localObject1 = localObject2;
    } while (paramExtensionInfo.bestIntimacyType > 2);
    paramQQAppInterface = new asyc();
    paramQQAppInterface.jdField_a_of_type_Long = 12L;
    paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.bestIntimacyType;
    return paramQQAppInterface;
  }
  
  public static Pair<asyb, asyb> a(QQAppInterface paramQQAppInterface, String paramString)
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
        localObject3 = (asyb)((Iterator)localObject4).next();
        if (!((asyb)localObject3).jdField_b_of_type_Boolean)
        {
          if ((localObject2 == null) || (((asyb)localObject3).jdField_b_of_type_Int < ((asyb)localObject2).jdField_b_of_type_Int)) {
            localObject2 = localObject3;
          }
        }
        else {
          for (;;)
          {
            break;
            if ((localObject1 != null) && (((asyb)localObject3).jdField_b_of_type_Int >= localObject1.jdField_b_of_type_Int)) {
              break label182;
            }
            localObject1 = localObject3;
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (TextUtils.isEmpty(((asyb)localObject2).jdField_b_of_type_JavaLangString))) {
          asxx.a().a(paramQQAppInterface, paramString, (asyb)localObject2);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (TextUtils.isEmpty(localObject1.jdField_b_of_type_JavaLangString))
          {
            asxx.a().a(paramQQAppInterface, paramString, localObject1);
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
  
  public static ArrayList<bfve> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<asyb> paramArrayList)
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
          paramArrayList = (asyb)paramString.next();
          bfve localbfve = new bfve();
          localbfve.jdField_a_of_type_Int = paramArrayList.jdField_c_of_type_Int;
          localbfve.jdField_a_of_type_JavaLangString = paramArrayList.jdField_c_of_type_JavaLangString;
          localbfve.jdField_a_of_type_Float = paramArrayList.a();
          paramQQAppInterface.add(localbfve);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static ArrayList<asyb> a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = (ajxn)paramQQAppInterface.getManager(51);
    if (localObject == null) {
      paramQQAppInterface = null;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if ((paramInt == 2) || (paramInt == 1)) {}
        for (boolean bool = ((ajxn)localObject).a(true); bool; bool = ((ajxn)localObject).a(false)) {
          return null;
        }
        if (!((ajxn)localObject).c(paramString)) {
          return null;
        }
        ExtensionInfo localExtensionInfo = ((ajxn)localObject).a(paramString, paramBoolean);
        if (localExtensionInfo == null) {
          return null;
        }
        localObject = new ArrayList();
        long[] arrayOfLong = asxa.b;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          asyb localasyb = a(paramQQAppInterface, paramString, localExtensionInfo, arrayOfLong[i]);
          if (localasyb != null) {
            ((ArrayList)localObject).add(localasyb);
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
  
  public static void a(asyb paramasyb, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramasyb == null)) {}
    do
    {
      do
      {
        return;
        if (!asxk.c(paramasyb.jdField_a_of_type_Long)) {
          break;
        }
      } while (paramExtensionInfo.mutualMarks == null);
      paramExtensionInfo = (asyc)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramasyb.jdField_a_of_type_Long));
    } while (paramExtensionInfo == null);
    paramExtensionInfo.jdField_b_of_type_Boolean = paramasyb.jdField_a_of_type_Boolean;
    paramExtensionInfo.h = paramasyb.h;
    return;
    switch ((int)paramasyb.jdField_a_of_type_Long)
    {
    default: 
      return;
    case 4: 
      paramExtensionInfo.hasRemindFrdship = paramasyb.jdField_a_of_type_Boolean;
      paramExtensionInfo.frdshipAnimStartTime = paramasyb.h;
      return;
    case 5: 
      paramExtensionInfo.hasRemindChat = paramasyb.jdField_a_of_type_Boolean;
      paramExtensionInfo.chatAnimStartTime = paramasyb.h;
      return;
    }
    paramExtensionInfo.hasRemindPraise = paramasyb.jdField_a_of_type_Boolean;
    paramExtensionInfo.praiseAnimStartTime = paramasyb.h;
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
        Object localObject = amtg.a().a(paramLong);
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          b(paramQQAppInterface, paramString, paramExtensionInfo, ((asxz)((Iterator)localObject).next()).jdField_a_of_type_Long);
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
                        if (!asxk.c(paramLong)) {
                          break;
                        }
                      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
                      paramExtensionInfo.mutualMarks.remove(Long.valueOf(paramLong));
                      return;
                    } while (!asxk.b(paramLong));
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
        if (!asyh.b()) {
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
 * Qualified Name:     asxb
 * JD-Core Version:    0.7.0.1
 */