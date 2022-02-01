package com.tencent.mobileqq.app.hiddenchat;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HiddenChatComparator
  implements Comparator<RecentBaseData>
{
  private QQAppInterface a;
  private StringBuilder b = new StringBuilder();
  
  public HiddenChatComparator(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private int a(RecentUserBaseData paramRecentUserBaseData, int paramInt)
  {
    int k = paramRecentUserBaseData.mUnreadNum;
    int j = 0;
    int i = j;
    if (k > 0)
    {
      i = j;
      if (paramRecentUserBaseData.mUser.getType() == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.getCurrentAccountUin());
        localStringBuilder.append(paramRecentUserBaseData.mUser.uin);
        i = j;
        if (QvipSpecialCareUtil.a(localStringBuilder.toString()))
        {
          i = j;
          if (!a(paramRecentUserBaseData.mUser.uin, 0)) {
            i = 1;
          }
        }
      }
    }
    if (i != 0) {
      paramInt = 4096;
    }
    return paramInt;
  }
  
  private int a(String paramString1, String paramString2)
  {
    long l = Long.parseLong(paramString1) - Long.parseLong(paramString2);
    if (l == 0L) {
      return 0;
    }
    if (l > 0L) {
      return 1;
    }
    return -1;
  }
  
  private void a()
  {
    if ((this.b != null) && (QLog.isDevelopLevel()))
    {
      this.b.append("]");
      QLog.i("Q.recent", 4, this.b.toString());
    }
  }
  
  private void a(String... paramVarArgs)
  {
    if ((this.b != null) && (QLog.isDevelopLevel()) && (paramVarArgs != null))
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.b.append(str);
        i += 1;
      }
    }
  }
  
  private boolean a(RecentUserBaseData paramRecentUserBaseData)
  {
    TroopManager localTroopManager = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramRecentUserBaseData.mUser.getType() == 1) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(this.a, paramRecentUserBaseData.mUser))) {
      return localTroopManager.o(paramRecentUserBaseData.getRecentUserUin());
    }
    return FriendsStatusUtil.a(this.a, paramRecentUserBaseData.mUser);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    return (this.a.getConversationFacade() != null) && (this.a.getConversationFacade().d(paramString, paramInt) > 0);
  }
  
  private void b(List<RecentUser> paramList)
  {
    if (QLog.isDevelopLevel())
    {
      Object localObject = this.b;
      if (localObject == null) {
        this.b = new StringBuilder();
      } else {
        ((StringBuilder)localObject).setLength(0);
      }
      this.b.append("checkRUList, src[");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (RecentUser)paramList.next();
        if (localObject == null)
        {
          this.b.append("null | null,");
        }
        else
        {
          StringBuilder localStringBuilder = this.b;
          localStringBuilder.append(((RecentUser)localObject).uin);
          localStringBuilder.append("|");
          localStringBuilder.append(((RecentUser)localObject).getType());
          localStringBuilder.append(",");
        }
      }
      this.b.append("], [");
    }
  }
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    boolean bool1 = paramRecentBaseData1 instanceof RecentUserBaseData;
    int i = 0;
    if ((bool1) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      bool1 = a(paramRecentBaseData1);
      boolean bool2 = a(paramRecentBaseData2);
      if ((bool1) && (!bool2)) {
        return -1;
      }
      if ((!bool1) && (bool2)) {
        return 1;
      }
      long l2;
      int j;
      long l3;
      if (!bool1)
      {
        int k = a(paramRecentBaseData1, 0);
        int m = a(paramRecentBaseData2, 0);
        l2 = Math.max(paramRecentBaseData1.mUser.lastmsgtime, paramRecentBaseData1.mUser.lastmsgdrafttime);
        long l4 = Math.max(paramRecentBaseData2.mUser.lastmsgtime, paramRecentBaseData2.mUser.lastmsgdrafttime);
        l1 = l2;
        if (paramRecentBaseData1.mUser.lastmsgtime <= 0L)
        {
          l1 = l2;
          if (paramRecentBaseData1.mUser.lastmsgdrafttime <= 0L) {
            l1 = Math.max(l2, paramRecentBaseData1.mUser.opTime);
          }
        }
        j = k;
        i = m;
        l3 = l1;
        l2 = l4;
        if (paramRecentBaseData2.mUser.lastmsgtime <= 0L)
        {
          j = k;
          i = m;
          l3 = l1;
          l2 = l4;
          if (paramRecentBaseData2.mUser.lastmsgdrafttime <= 0L)
          {
            l2 = Math.max(l4, paramRecentBaseData2.mUser.opTime);
            j = k;
            i = m;
            l3 = l1;
          }
        }
      }
      else
      {
        l3 = paramRecentBaseData1.mDisplayTime;
        l2 = paramRecentBaseData2.mDisplayTime;
        j = 0;
      }
      if (l3 > l2) {
        l1 = 3L;
      } else if (l3 < l2) {
        l1 = 1L;
      } else {
        l1 = 2L;
      }
      long l1 = (int)(l1 | j) - (int)(i | 0x2);
      if (l1 == 0L) {
        return a(paramRecentBaseData1.mUser.uin, paramRecentBaseData2.mUser.uin);
      }
      if (l1 < 0L) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
  
  public void a(List<RecentUser> paramList)
  {
    b(paramList);
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    i -= 1;
    Object localObject3;
    for (Object localObject1 = null; i >= 0; localObject1 = localObject3)
    {
      RecentUser localRecentUser = (RecentUser)paramList.get(i);
      if (localRecentUser == null)
      {
        paramList.remove(i);
        localObject3 = localObject1;
      }
      else if ((!TextUtils.isEmpty(localRecentUser.uin)) && (!TextUtils.isEmpty(localRecentUser.uin.trim())))
      {
        Object localObject2;
        if ((localRecentUser.getType() == 1) && ((localRecentUser.lFlag & 1L) != 0L))
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = this.a;
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = ((QQAppInterface)localObject3).getHotChatMng(true);
            }
          }
          localObject3 = localObject2;
          if (localObject2 != null)
          {
            localObject3 = localObject2;
            if (!((HotChatManager)localObject2).b(localRecentUser.uin))
            {
              paramList.remove(i);
              a(new String[] { "invalide hotchat ", String.valueOf(i), ",", localRecentUser.uin, ";" });
              localObject3 = localObject2;
            }
          }
        }
        else if (localRecentUser.getType() == 3000)
        {
          localObject2 = this.a;
          localObject3 = localObject1;
          if (localObject2 != null)
          {
            localObject2 = ((DiscussionManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(localRecentUser.uin);
            if ((localObject2 != null) && (!((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser()))
            {
              localObject3 = localObject1;
              if (!((DiscussionInfo)localObject2).isHidden()) {}
            }
            else
            {
              paramList.remove(i);
              a(new String[] { "hidden_RecentUser ", String.valueOf(i), ",", localRecentUser.uin, ";" });
              localObject3 = localObject1;
            }
          }
        }
        else if (localRecentUser.lFlag == 16L)
        {
          localObject3 = localObject1;
          if (this.a != null)
          {
            AdvertisementRecentUserManager.a().a(this.a, localRecentUser);
            localObject3 = localObject1;
          }
        }
        else
        {
          localObject3 = localObject1;
          if (localRecentUser.getType() == 10005)
          {
            localObject3 = localObject1;
            if (this.a != null)
            {
              ImaxAdRecentUserManager.a().a(this.a, localRecentUser);
              localObject3 = localObject1;
            }
          }
        }
      }
      else
      {
        paramList.remove(i);
        a(new String[] { String.valueOf(i), ",", String.valueOf(localRecentUser.getType()), ";" });
        localObject3 = localObject1;
      }
      i -= 1;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatComparator
 * JD-Core Version:    0.7.0.1
 */