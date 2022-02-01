package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.device.RIJDisplayStyleManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJMergeKanDianMessage
{
  public static SimpleDateFormat a;
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
  }
  
  public static int a()
  {
    if (RIJQQAppInterfaceUtil.a() == null) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return -1;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      int i = 0;
      while (i < localException.size())
      {
        localObject1 = (RecentBaseData)localException.get(i);
        if (localObject1 != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)localObject1).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN);
          if (bool) {
            return i;
          }
        }
        i += 1;
      }
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    int i2 = 0;
    long l1 = NetConnInfoCenter.getServerTime();
    int i = RIJDisplayStyleManager.a;
    int j = i - 2;
    if ((paramQQAppInterface == null) || (i <= 0))
    {
      QLog.d("RIJMergeKanDianMessage", 1, "break insert individual push time:" + l1);
      return l1;
    }
    Object localObject1 = new ArrayList();
    Object localObject2;
    int i1;
    int m;
    try
    {
      localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject2 != null) {
        break label195;
      }
      QLog.d("RIJMergeKanDianMessage", 1, "conversation frame is null");
      return l1;
    }
    catch (Exception paramQQAppInterface)
    {
      i1 = 0;
      m = i;
    }
    label102:
    QLog.d("RIJMergeKanDianMessage", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    int k = m;
    i = i1;
    label137:
    if (i != 0)
    {
      i = 0;
      label143:
      m = i2;
      if (i >= k) {}
    }
    for (;;)
    {
      long l2;
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(i);
        if (paramQQAppInterface != null)
        {
          l2 = ((RecentUserBaseData)paramQQAppInterface).mUser.showUpTime;
          if (l2 <= 0L) {}
        }
        else
        {
          i += 1;
          break label143;
          label195:
          localObject2 = ((Conversation)localObject2).a().b();
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((List)localObject2).iterator();
          Object localObject3;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (!(localObject3 instanceof RecentBaseData)) {
              continue;
            }
            ((List)localObject1).add((RecentBaseData)localObject3);
            continue;
          }
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RecentBaseData)((Iterator)localObject2).next();
            if (localObject3 == null) {
              continue;
            }
            localObject3 = (RecentUserBaseData)localObject3;
            if ((((RecentUserBaseData)localObject3).mUser == null) || (((RecentUserBaseData)localObject3).mUser.getType() != 1008) || (!ServiceAccountFolderManager.b(paramQQAppInterface, ((RecentUserBaseData)localObject3).mUser.uin))) {
              continue;
            }
            ((Iterator)localObject2).remove();
            continue;
          }
          k = ((List)localObject1).size();
          m = i;
          if (i > k) {
            m = k;
          }
          n = 0;
          i = 0;
          if (n < m) {
            i1 = i;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int n;
        boolean bool;
        QLog.d("RIJMergeKanDianMessage", 1, "failed to construct individual push time " + paramQQAppInterface.toString());
      }
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(n);
        i1 = i;
        if (paramQQAppInterface == null) {
          break label733;
        }
        i1 = i;
        paramQQAppInterface = (RecentUserBaseData)paramQQAppInterface;
        k = i;
        i1 = i;
        if (paramQQAppInterface.mUnreadNum > 0) {
          k = 1;
        }
        i1 = k;
        bool = TextUtils.equals(paramQQAppInterface.getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN);
        i1 = k;
        if (!bool) {
          break label733;
        }
        i = n;
        j = k;
        n += 1;
        k = j;
        j = i;
        i = k;
      }
      catch (Exception paramQQAppInterface) {}
      k = m;
      break label137;
      m = i;
      if (m >= j)
      {
        QLog.d("RIJMergeKanDianMessage", 1, "insert individual push time:" + l1);
        return l1;
      }
      for (;;)
      {
        QLog.d("RIJMergeKanDianMessage", 1, "insert individual push time:" + l1);
        return l1;
        i = (int)(Math.random() * (j - m)) + 1 + m;
        paramQQAppInterface = (RecentUserBaseData)((List)localObject1).get(i - 1);
        localObject1 = (RecentUserBaseData)((List)localObject1).get(i);
        l2 = Math.max(paramQQAppInterface.mUser.lastmsgtime, paramQQAppInterface.mUser.lastmsgdrafttime);
        long l3 = Math.max(((RecentUserBaseData)localObject1).mUser.lastmsgtime, ((RecentUserBaseData)localObject1).mUser.lastmsgdrafttime);
        double d = Math.random();
        l1 = l2 - ((l2 - l3) * d) - 1L;
        continue;
        QLog.d("RIJMergeKanDianMessage", 1, "construct individual push first " + k + " msg no red point");
      }
      break label102;
      label733:
      i = j;
      j = i1;
    }
  }
  
  public static String a(int paramInt)
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    int j = Math.max(10, RIJDisplayStyleManager.a);
    if (localObject == null) {
      return "";
    }
    List localList = a();
    StringBuilder localStringBuilder = new StringBuilder(RIJDisplayStyleManager.a + ":");
    int i = localList.size();
    if (0 + j < i) {
      i = 0 + j;
    }
    for (;;)
    {
      ConversationFacade localConversationFacade = ((QQAppInterface)localObject).getConversationFacade();
      j = 0;
      if (j < i)
      {
        localObject = (RecentBaseData)localList.get(j);
        RecentUserBaseData localRecentUserBaseData;
        int k;
        if (localObject != null)
        {
          localRecentUserBaseData = (RecentUserBaseData)localObject;
          if ((localRecentUserBaseData.mUser != null) && ((localRecentUserBaseData.mUser.getType() == paramInt) || (paramInt == -1)))
          {
            k = localConversationFacade.a(localRecentUserBaseData.getRecentUserUin(), localRecentUserBaseData.mUser.getType());
            if (localRecentUserBaseData.mUnreadFlag == 3) {
              k = 0;
            }
            if (localRecentUserBaseData.mUser.getType() != 1008) {
              break label240;
            }
          }
        }
        label240:
        for (localObject = "1";; localObject = "0")
        {
          localStringBuilder.append((String)localObject).append("_").append(localRecentUserBaseData.getRecentUserUin()).append("_").append(k);
          if (j != i - 1) {
            localStringBuilder.append(":");
          }
          j += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "getScreenPaInfo : " + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
  }
  
  private static List<RecentBaseData> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    try
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null)
      {
        QLog.d("RIJMergeKanDianMessage", 1, "conversation frame is null");
        return localArrayList;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return localArrayList;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return localArrayList;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("RIJMergeKanDianMessage", 2, localException.getMessage());
    }
    for (;;)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (RecentUserBaseData)localObject2;
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (ServiceAccountFolderManager.b(localException, ((RecentUserBaseData)localObject2).mUser.uin))) {
            ((Iterator)localObject1).remove();
          }
        }
      }
    }
  }
  
  public static List<String> a(MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    do
    {
      do
      {
        return null;
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        paramMessageRecord.parse();
      } while ((paramMessageRecord.structingMsg == null) || (TextUtils.isEmpty(paramMessageRecord.structingMsg.mArticleIds)));
      paramMessageRecord = paramMessageRecord.structingMsg.mArticleIds.split("\\|");
    } while (paramMessageRecord.length <= 0);
    return Arrays.asList(paramMessageRecord);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramQQAppInterface.getMessageFacade();
      } while (localObject == null);
      localObject = ((QQMessageFacade)localObject).a();
    } while ((localObject == null) || (((ConversationFacade)localObject).a(paramString, 1008) <= 0));
    ThreadManager.post(new RIJMergeKanDianMessage.2(paramString, paramQQAppInterface), 8, null, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (!paramQQAppInterface.isread) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (!paramMessageRecord.mIsParsed) {
        paramMessageRecord.parse();
      }
      if (paramMessageRecord.structingMsg != null) {
        break label32;
      }
    }
    for (;;)
    {
      return true;
      label32:
      if (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mExtraData)) {
        try
        {
          int i = new JSONObject(paramMessageRecord.structingMsg.mExtraData).optInt("keyguard_jump", 1);
          if (i != 1) {
            return false;
          }
        }
        catch (JSONException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return true;
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (paramAbsStructMsg != null) && (paramAbsStructMsg.mMsgUrl != null) && (paramAbsStructMsg.mMsgUrl.contains("kandianshare.html5.qq.com"));
  }
  
  public static boolean a(String paramString)
  {
    Object localObject1 = new ArrayList();
    label50:
    int i;
    do
    {
      do
      {
        while (!((Iterator)localObject1).hasNext()) {
          try
          {
            localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
            if (localObject2 == null) {
              return false;
            }
            localObject2 = ((Conversation)localObject2).a().b();
            if (localObject2 == null) {
              return false;
            }
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              if (!(localObject3 instanceof RecentBaseData)) {
                break label50;
              }
              ((List)localObject1).add((RecentBaseData)localObject3);
              break label50;
            }
            localObject1 = ((List)localObject1).iterator();
          }
          catch (Exception paramString)
          {
            QLog.d("RIJMergeKanDianMessage", 1, "failed to construct recent base " + paramString.toString());
            return false;
          }
        }
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
      } while (localObject2 == null);
      Object localObject2 = (RecentUserBaseData)localObject2;
      if (TextUtils.equals(((RecentUserBaseData)localObject2).getRecentUserUin(), paramString)) {
        return true;
      }
      i = ((RecentUserBaseData)localObject2).mMenuFlag;
    } while ((i & 0x20) != 0);
    return false;
  }
  
  public static int b()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData)) {
          localArrayList.add((RecentBaseData)localObject2);
        }
      }
      k = Math.min(localException.size(), RIJDisplayStyleManager.a);
    }
    catch (Exception localException)
    {
      QLog.d("RIJMergeKanDianMessage", 1, "failed to construct recent base " + localException.toString());
      return -1;
    }
    int k;
    int j = 0;
    for (;;)
    {
      if (j < k)
      {
        localObject1 = (RecentBaseData)localException.get(j);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if (!TextUtils.equals(((RecentUserBaseData)localObject1).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN))
          {
            if (((RecentUserBaseData)localObject1).getRecentUserType() == 5000) {
              break label236;
            }
            if (((RecentUserBaseData)localObject1).getUnreadNum() > 0)
            {
              int m = ((RecentUserBaseData)localObject1).getUnreadNum();
              i = m + i;
              break label236;
            }
          }
        }
      }
      else
      {
        return i;
      }
      label236:
      j += 1;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    int j = RIJDisplayStyleManager.a;
    if ((paramQQAppInterface == null) || (j <= 0)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = RecentDataListManager.a().a;
      if (localObject1 != null) {
        localArrayList.addAll((Collection)localObject1);
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (RecentUserBaseData)localObject2;
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (ServiceAccountFolderManager.b(paramQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin)))
          {
            ((Iterator)localObject1).remove();
            continue;
            return false;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.d("RIJMergeKanDianMessage", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    }
    for (;;)
    {
      int k = localArrayList.size();
      int i = j;
      if (j > k) {
        i = k;
      }
      while (j < i)
      {
        paramQQAppInterface = (RecentBaseData)localArrayList.get(j);
        if (paramQQAppInterface != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)paramQQAppInterface).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN);
          if (bool) {
            return true;
          }
        }
        j += 1;
        continue;
        j = 0;
      }
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Boolean)
    {
      ThreadManager.executeOnSubThread(new RIJMergeKanDianMessage.1(paramQQAppInterface));
      jdField_a_of_type_Boolean = false;
    }
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof SplashActivity))
    {
      if (((SplashActivity)localObject).getCurrentTab() != FrameControllerUtil.a)
      {
        QLog.d("RIJMergeKanDianMessage", 1, "r:Not in conversationtab");
        return false;
      }
    }
    else
    {
      QLog.d("RIJMergeKanDianMessage", 1, "r:top activity is not splash");
      return false;
    }
    if (!ReadInJoyHelper.c(paramQQAppInterface))
    {
      QLog.d("RIJMergeKanDianMessage", 1, "r:config false");
      return false;
    }
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), null, "qqsetting_kandian_key", true))
    {
      QLog.d("RIJMergeKanDianMessage", 1, "kandian push disabled");
      return false;
    }
    localObject = ReadInJoyHelper.a(paramQQAppInterface);
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    int i = Calendar.getInstance().get(11);
    if ((!TextUtils.equals((CharSequence)localObject, str)) && (i >= 6))
    {
      if (!a(paramQQAppInterface))
      {
        QLog.d("RIJMergeKanDianMessage", 1, "r:true to get individual push");
        return true;
      }
      QLog.d("RIJMergeKanDianMessage", 1, "r:already has red point");
    }
    for (;;)
    {
      return false;
      QLog.d("RIJMergeKanDianMessage", 1, "r:hour:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJMergeKanDianMessage
 * JD-Core Version:    0.7.0.1
 */