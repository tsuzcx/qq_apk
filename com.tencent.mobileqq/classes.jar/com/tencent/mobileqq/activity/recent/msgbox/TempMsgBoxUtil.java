package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TempMsgBoxUtil
{
  private static Map<Integer, Integer> a;
  public static boolean a;
  private static Map<Integer, Integer> b;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    b = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1000), Integer.valueOf(2131699289));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1004), Integer.valueOf(2131699289));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1006), Integer.valueOf(2131699291));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1023), Integer.valueOf(2131699292));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1022), Integer.valueOf(2131699296));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10010), Integer.valueOf(2131699284));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1024), Integer.valueOf(2131699285));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1005), Integer.valueOf(2131699297));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10009), Integer.valueOf(2131699288));
    b.put(Integer.valueOf(1000), Integer.valueOf(0));
    b.put(Integer.valueOf(1004), Integer.valueOf(1));
    b.put(Integer.valueOf(1006), Integer.valueOf(130));
    b.put(Integer.valueOf(1023), Integer.valueOf(133));
    b.put(Integer.valueOf(1022), Integer.valueOf(134));
    b.put(Integer.valueOf(10010), Integer.valueOf(167));
  }
  
  private static int a(int paramInt, ConversationFacade paramConversationFacade)
  {
    int i = paramConversationFacade.d(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    if (i > 0) {
      paramInt = i;
    }
    return paramInt;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    ConversationFacade localConversationFacade = paramQQAppInterface.getConversationFacade();
    TempMsgBoxManager localTempMsgBoxManager;
    List localList;
    int i;
    if (localConversationFacade.b(AppConstants.TEMP_MSG_BOX_UIN, 10011))
    {
      localTempMsgBoxManager = (TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
      localList = localTempMsgBoxManager.a(paramQQAppInterface);
      if (localList.isEmpty())
      {
        QLog.e("TempMsgBoxUtil", 1, "onGetUnreadMsgNum: msgBoxRecentUsers.isEmpty()");
        return 0;
      }
      Object localObject = (RecentUser)localList.get(0);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)localIterator.next();
        if (Math.max(localRecentUser.lastmsgtime, localRecentUser.lastmsgdrafttime) <= Math.max(((RecentUser)localObject).lastmsgtime, ((RecentUser)localObject).lastmsgdrafttime)) {
          break label222;
        }
        localObject = localRecentUser;
      }
      if (TextUtils.equals(((RecentUser)localObject).uin, AppConstants.FILTER_MSG_UIN))
      {
        i = 0;
        label152:
        j = i;
        if (i != 0) {}
      }
    }
    for (int j = a(i, localConversationFacade);; j = 0)
    {
      QLog.d("TempMsgBoxUtil", 2, "getTempMsgBoxUnread() called with: msgBoxUnread = [" + j + "]");
      return j;
      if (localTempMsgBoxManager.a())
      {
        i = 0;
        break label152;
      }
      i = RecentItemTempMsgBoxData.a(paramQQAppInterface, localList, localConversationFacade);
      break label152;
      label222:
      break;
    }
  }
  
  public static ConversationInfo a(ConversationInfo paramConversationInfo)
  {
    Object localObject = paramConversationInfo;
    if (TextUtils.equals(paramConversationInfo.uin, AppConstants.FILTER_MSG_UIN))
    {
      paramConversationInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = a(paramConversationInfo.getConversationFacade().a(), paramConversationInfo);
      paramConversationInfo = new ConversationInfo();
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        localObject = paramConversationInfo;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (ConversationInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("TempMsgBoxUtil", 2, "onGetUnreadCount() called with: info = [" + localObject + "]");
        }
        if (((ConversationInfo)localObject).type == 7000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TempMsgBoxUtil", 2, "onGetUnreadCount() called skip UIN_TYPE_SUBACCOUNT_ASSISTANT ");
          }
        }
        else
        {
          paramConversationInfo.setUnread(paramConversationInfo.unreadCount + ((ConversationInfo)localObject).unreadCount);
          int i = paramConversationInfo.unreadMark;
          paramConversationInfo.setUnreadMark(((ConversationInfo)localObject).unreadMark + i);
        }
      }
    }
    return localObject;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    Object localObject1 = "";
    Object localObject2 = ((TempChatPluginManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(paramRecentUser.type);
    if (localObject2 != null) {
      localObject1 = ((AbstractTempChatPlugin)localObject2).b(paramRecentUser.uin);
    }
    do
    {
      do
      {
        return localObject1;
        if (paramRecentUser.getType() == 1024)
        {
          paramQQAppInterface = RecentItemPublicAccountChatMsgData.a(paramQQAppInterface, (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER), paramRecentUser.uin);
          if (paramQQAppInterface == null) {
            break label223;
          }
          return paramQQAppInterface.name;
        }
        if (paramRecentUser.getType() == 1000)
        {
          localObject2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          if (localObject2 != null)
          {
            localObject1 = ((TroopManager)localObject2).b(paramRecentUser.troopUin);
            localObject1 = ContactUtils.a(paramQQAppInterface, paramRecentUser.uin, (String)localObject1, paramRecentUser.troopUin, true, null);
          }
          return localObject1;
        }
        if (paramRecentUser.getType() != 1004) {
          break;
        }
        localObject2 = ContactUtils.c(paramQQAppInterface, paramRecentUser.troopUin, paramRecentUser.uin);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (!((String)localObject2).equals(paramRecentUser.uin));
    return ContactUtils.c(paramQQAppInterface, paramRecentUser.uin, true);
    if (paramRecentUser.getType() == 10007) {
      return GameMsgUtil.a(paramRecentUser.uin, paramQQAppInterface);
    }
    if (paramRecentUser.getType() == 1006) {
      return b(paramQQAppInterface, paramRecentUser);
    }
    return ContactUtils.c(paramQQAppInterface, paramRecentUser.uin, true);
    label223:
    return "";
  }
  
  @NonNull
  private static List<ConversationInfo> a(Set<ConversationInfo> paramSet, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    paramQQAppInterface = (TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)paramSet.next();
      if (paramQQAppInterface.a(localConversationInfo.uin, localConversationInfo.type)) {
        localArrayList.add(localConversationInfo);
      }
    }
    return localArrayList;
  }
  
  public static Map<Integer, Integer> a()
  {
    return jdField_a_of_type_JavaUtilMap;
  }
  
  public static void a(int paramInt, String paramString, MsgSummary paramMsgSummary)
  {
    if ((paramInt == 10011) && (!TextUtils.isEmpty(paramString))) {
      paramMsgSummary.strPrefix = paramString;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = ((TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramQQAppInterface).iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (localRecentUser.getType() == 10012)
      {
        b(paramQQAppInterface);
      }
      else
      {
        RecentUtil.b(paramQQAppInterface, localRecentUser.uin, localRecentUser.type);
        paramQQAppInterface.getMessageFacade().c(localRecentUser.uin, localRecentUser.type);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Object paramObject)
  {
    if (((paramObject instanceof RecentItemTempMsgBoxData)) && (!jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = true;
      ReportController.b(((BaseActivity)paramContext).app, "dc00898", "", "", "0X800B1BE", "0X800B1BE", 0, 0, "", "", "", "");
    }
    if ((paramObject instanceof RecentItemTempMsgBoxData)) {
      GameMsgUtil.a(paramQQAppInterface, paramObject);
    }
  }
  
  private static String b(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    String str = ContactUtils.e(paramQQAppInterface, paramRecentUser.uin);
    Object localObject = (PhoneContactManager)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localObject != null) {}
    for (localObject = ((PhoneContactManager)localObject).c(paramRecentUser.uin);; localObject = null)
    {
      if (localObject != null) {
        return ((PhoneContact)localObject).name;
      }
      if (str != null) {
        return ContactUtils.c(paramQQAppInterface, str, true);
      }
      return paramRecentUser.uin;
    }
  }
  
  public static Map<Integer, Integer> b()
  {
    return b;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = FilterMsgBoxRecentUserUtil.a(paramQQAppInterface).iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      RecentUtil.b(paramQQAppInterface, localRecentUser.uin, localRecentUser.type);
      paramQQAppInterface.getMessageFacade().c(localRecentUser.uin, localRecentUser.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxUtil
 * JD-Core Version:    0.7.0.1
 */