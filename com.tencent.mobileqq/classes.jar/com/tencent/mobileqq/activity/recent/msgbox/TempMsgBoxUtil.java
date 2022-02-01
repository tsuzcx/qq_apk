package com.tencent.mobileqq.activity.recent.msgbox;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.ITempMsgBoxBusinessHandler;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentItemTempMsgBoxData;
import com.tencent.mobileqq.activity.recent.msgbox.inject.TempMsgBoxBusinessInjectUtil;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class TempMsgBoxUtil
{
  public static ITempMsgBoxCallback a;
  private static Map<Integer, Integer> b = new HashMap();
  private static Map<Integer, Integer> c = new HashMap();
  private static Map<Integer, String> d = new HashMap();
  private static HashMap<String, ITempMsgBoxBusinessHandler> e = new HashMap();
  
  static
  {
    try
    {
      a = (ITempMsgBoxCallback)((Class)TempMsgBoxBusinessInjectUtil.b.get(0)).newInstance();
    }
    catch (Exception localException)
    {
      QLog.e("TempMsgBoxUtil", 1, "registerCallback error: ", localException);
    }
    d.put(Integer.valueOf(10007), "tempGameMsg");
    d.put(Integer.valueOf(1024), "publicAccount");
    b.put(Integer.valueOf(1000), Integer.valueOf(2131897425));
    b.put(Integer.valueOf(1004), Integer.valueOf(2131897425));
    b.put(Integer.valueOf(1006), Integer.valueOf(2131897427));
    b.put(Integer.valueOf(1023), Integer.valueOf(2131897428));
    b.put(Integer.valueOf(1022), Integer.valueOf(2131897432));
    b.put(Integer.valueOf(10010), Integer.valueOf(2131897420));
    b.put(Integer.valueOf(1024), Integer.valueOf(2131897421));
    b.put(Integer.valueOf(1005), Integer.valueOf(2131897433));
    c.put(Integer.valueOf(1000), Integer.valueOf(0));
    c.put(Integer.valueOf(1004), Integer.valueOf(1));
    c.put(Integer.valueOf(1006), Integer.valueOf(130));
    c.put(Integer.valueOf(1023), Integer.valueOf(133));
    c.put(Integer.valueOf(1022), Integer.valueOf(134));
    c.put(Integer.valueOf(10010), Integer.valueOf(167));
  }
  
  private static int a(int paramInt, IConversationFacade paramIConversationFacade)
  {
    int i = paramIConversationFacade.getReadUnreadMark(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    if (i > 0) {
      paramInt = i;
    }
    return paramInt;
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    IConversationFacade localIConversationFacade = (IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "");
    boolean bool = localIConversationFacade.isUinInRecentList(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    int i = 0;
    int j = 0;
    if (bool)
    {
      ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
      List localList = localITempMsgBoxManager.getMsgBoxRecentUsers();
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
        if (Math.max(localRecentUser.lastmsgtime, localRecentUser.lastmsgdrafttime) > Math.max(((RecentUser)localObject).lastmsgtime, ((RecentUser)localObject).lastmsgdrafttime)) {
          localObject = localRecentUser;
        }
      }
      if ((!TextUtils.equals(((RecentUser)localObject).uin, AppConstants.FILTER_MSG_UIN)) && (!localITempMsgBoxManager.isMsgBoxRead())) {
        j = RecentItemTempMsgBoxData.a(paramAppInterface, localList, localIConversationFacade);
      }
      i = j;
      if (j == 0) {
        i = a(j, localIConversationFacade);
      }
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("getTempMsgBoxUnread() called with: msgBoxUnread = [");
    paramAppInterface.append(i);
    paramAppInterface.append("]");
    QLog.d("TempMsgBoxUtil", 2, paramAppInterface.toString());
    return i;
  }
  
  public static int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      return 2;
    }
    if (paramBoolean2) {
      return 1;
    }
    return 0;
  }
  
  public static ConversationInfo a(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return new ConversationInfo();
    }
    ConversationInfo localConversationInfo1 = paramConversationInfo;
    if (TextUtils.equals(paramConversationInfo.uin, AppConstants.FILTER_MSG_UIN))
    {
      paramConversationInfo = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramConversationInfo = a(((IConversationFacade)paramConversationInfo.getRuntimeService(IConversationFacade.class, "")).getConversationInfoSet(), paramConversationInfo);
      localConversationInfo1 = new ConversationInfo();
      paramConversationInfo = paramConversationInfo.iterator();
      while (paramConversationInfo.hasNext())
      {
        ConversationInfo localConversationInfo2 = (ConversationInfo)paramConversationInfo.next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGetUnreadCount() called with: info = [");
          localStringBuilder.append(localConversationInfo2);
          localStringBuilder.append("]");
          QLog.d("TempMsgBoxUtil", 2, localStringBuilder.toString());
        }
        if (localConversationInfo2.type == 7000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TempMsgBoxUtil", 2, "onGetUnreadCount() called skip UIN_TYPE_SUBACCOUNT_ASSISTANT ");
          }
        }
        else
        {
          localConversationInfo1.setUnread(localConversationInfo1.unreadCount + localConversationInfo2.unreadCount);
          localConversationInfo1.setUnreadMark(localConversationInfo1.unreadMark + localConversationInfo2.unreadMark);
        }
      }
    }
    return localConversationInfo1;
  }
  
  public static String a(AppInterface paramAppInterface, RecentUser paramRecentUser)
  {
    int i = paramRecentUser.getType();
    Object localObject = ((ITempChatPluginManager)paramAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(i);
    if (localObject != null) {
      return ((AbstractTempChatPlugin)localObject).b(paramRecentUser.uin);
    }
    localObject = (String)d.get(Integer.valueOf(i));
    if (localObject != null)
    {
      localObject = (ITempMsgBoxBusinessHandler)e.get(localObject);
      if (localObject != null)
      {
        localObject = ((ITempMsgBoxBusinessHandler)localObject).a(paramAppInterface, paramRecentUser.uin);
        break label90;
      }
    }
    localObject = "";
    label90:
    if (i == 1000)
    {
      paramAppInterface = ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopUin(paramRecentUser.troopUin);
      return ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getTroopNickName(paramRecentUser.uin, paramAppInterface, paramRecentUser.troopUin, true, null);
    }
    if (i == 1004)
    {
      localObject = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getDiscussionMemberShowName(paramRecentUser.troopUin, paramRecentUser.uin);
      paramAppInterface = (AppInterface)localObject;
      if (localObject != null)
      {
        paramAppInterface = (AppInterface)localObject;
        if (((String)localObject).equals(paramRecentUser.uin)) {
          return ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(paramRecentUser.uin, true);
        }
      }
    }
    else
    {
      if (i == 1006) {
        return b(paramAppInterface, paramRecentUser);
      }
      paramAppInterface = (AppInterface)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInterface = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(paramRecentUser.uin, true);
      }
    }
    return paramAppInterface;
  }
  
  @NonNull
  private static List<ConversationInfo> a(Set<ConversationInfo> paramSet, AppInterface paramAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    paramAppInterface = (ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)paramSet.next();
      if (paramAppInterface.isBelongToFilterBox(localConversationInfo.uin, localConversationInfo.type)) {
        localArrayList.add(localConversationInfo);
      }
    }
    return localArrayList;
  }
  
  public static Map<Integer, Integer> a()
  {
    return b;
  }
  
  public static void a(int paramInt, String paramString, MsgSummary paramMsgSummary)
  {
    if ((paramInt == 10011) && (!TextUtils.isEmpty(paramString))) {
      paramMsgSummary.strPrefix = paramString;
    }
  }
  
  public static void a(AppInterface paramAppInterface, Object paramObject)
  {
    boolean bool = paramObject instanceof RecentItemTempMsgBoxData;
    if ((bool) && (!TempMsgBoxConstants.a))
    {
      TempMsgBoxConstants.a = true;
      ReportController.b(paramAppInterface, "dc00898", "", "", "0X800B1BE", "0X800B1BE", 0, 0, "", "", "", "");
    }
    if (bool)
    {
      Iterator localIterator = e.values().iterator();
      while (localIterator.hasNext()) {
        ((ITempMsgBoxBusinessHandler)localIterator.next()).a(paramAppInterface, paramObject);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (((ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers().isEmpty())
    {
      paramAppInterface = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      paramAppInterface.a(paramAppInterface.b(AppConstants.TEMP_MSG_BOX_UIN, 10011), paramBoolean);
    }
  }
  
  private static String b(AppInterface paramAppInterface, RecentUser paramRecentUser)
  {
    paramAppInterface = (IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, "");
    String str = paramAppInterface.getUinByPhoneNum(paramRecentUser.uin);
    if (paramAppInterface != null) {
      paramAppInterface = paramAppInterface.queryContactByCodeNumber(paramRecentUser.uin);
    } else {
      paramAppInterface = null;
    }
    if (paramAppInterface != null) {
      return paramAppInterface.name;
    }
    if (str != null) {
      return ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(str, true);
    }
    return paramRecentUser.uin;
  }
  
  public static Map<Integer, Integer> b()
  {
    return c;
  }
  
  public static Map<Integer, String> c()
  {
    return d;
  }
  
  public static HashMap<String, ITempMsgBoxBusinessHandler> d()
  {
    return e;
  }
  
  public static void e()
  {
    HashMap localHashMap = TempMsgBoxBusinessInjectUtil.a;
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Class localClass = (Class)localHashMap.get(str);
      if (localClass != null) {
        try
        {
          e.put(str, localClass.newInstance());
        }
        catch (Exception localException)
        {
          QLog.e("TempMsgBoxUtil", 1, "registerBusinessHandler error: ", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxUtil
 * JD-Core Version:    0.7.0.1
 */