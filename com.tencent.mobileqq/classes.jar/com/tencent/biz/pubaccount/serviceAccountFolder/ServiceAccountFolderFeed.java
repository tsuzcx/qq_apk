package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeedItem;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ServiceAccountFolderFeed
{
  public boolean a;
  public String b;
  public int c = 0;
  public int d;
  public int e;
  public long f;
  public String g;
  public String h;
  public CharSequence i;
  public MessageRecord j;
  public int k = BaseApplicationImpl.getApplication().getResources().getColor(2131168153);
  public String l;
  public boolean m = true;
  public long n = 0L;
  @notColumn
  public CharSequence o;
  @notColumn
  public int p;
  public String q;
  
  public static ServiceAccountFolderFeed a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    RecentItemPublicAccountChatMsgData localRecentItemPublicAccountChatMsgData = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    localRecentItemPublicAccountChatMsgData.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    paramRecentUser = new ServiceAccountFolderFeed();
    paramRecentUser.a = true;
    paramRecentUser.b = localRecentItemPublicAccountChatMsgData.getRecentUserUin();
    paramRecentUser.d = localRecentItemPublicAccountChatMsgData.mUnreadNum;
    paramRecentUser.e = localRecentItemPublicAccountChatMsgData.mAuthenIconId;
    paramRecentUser.f = localRecentItemPublicAccountChatMsgData.mDisplayTime;
    paramRecentUser.g = localRecentItemPublicAccountChatMsgData.mShowTime;
    paramRecentUser.n = localRecentItemPublicAccountChatMsgData.getLastMsgTime();
    paramRecentUser.h = localRecentItemPublicAccountChatMsgData.mTitleName;
    paramRecentUser.i = localRecentItemPublicAccountChatMsgData.mLastMsg;
    paramRecentUser.j = paramQQAppInterface.getMessageFacade().r(paramRecentUser.b, 1008);
    paramRecentUser.l = ServiceAccountFolderManager.b(paramQQAppInterface, paramRecentUser.b);
    paramRecentUser.q = localRecentItemPublicAccountChatMsgData.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, paramRecentUser);
    b(paramQQAppInterface, paramRecentUser);
    c(paramQQAppInterface, paramRecentUser);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("createFromRecentUser->");
      paramQQAppInterface.append(paramRecentUser.toString());
      QLog.d("ServiceAccountFolderFeed", 2, paramQQAppInterface.toString());
    }
    return paramRecentUser;
  }
  
  public static ServiceAccountFolderFeed a(QQAppInterface paramQQAppInterface, SubscriptionFeed paramSubscriptionFeed)
  {
    ServiceAccountFolderFeed localServiceAccountFolderFeed = new ServiceAccountFolderFeed();
    localServiceAccountFolderFeed.a = false;
    localServiceAccountFolderFeed.b = paramSubscriptionFeed.c;
    localServiceAccountFolderFeed.d = paramSubscriptionFeed.b;
    localServiceAccountFolderFeed.e = 0;
    localServiceAccountFolderFeed.f = paramSubscriptionFeed.d;
    localServiceAccountFolderFeed.g = TimeManager.a().a(paramSubscriptionFeed.c, paramSubscriptionFeed.d);
    String str2 = TroopBarAssistantManager.a().a(paramSubscriptionFeed.c);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramSubscriptionFeed.c;
    }
    localServiceAccountFolderFeed.h = str1;
    if (paramSubscriptionFeed.e.size() > 0) {
      localServiceAccountFolderFeed.i = ((SubscriptionFeedItem)paramSubscriptionFeed.e.get(0)).c;
    }
    localServiceAccountFolderFeed.j = paramQQAppInterface.getMessageFacade().r(paramSubscriptionFeed.c, 1008);
    localServiceAccountFolderFeed.l = ServiceAccountFolderManager.b(paramQQAppInterface, paramSubscriptionFeed.c);
    a(paramQQAppInterface, localServiceAccountFolderFeed);
    b(paramQQAppInterface, localServiceAccountFolderFeed);
    c(paramQQAppInterface, localServiceAccountFolderFeed);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("createFromSubscriptionFeed->");
      paramQQAppInterface.append(localServiceAccountFolderFeed.toString());
      QLog.d("ServiceAccountFolderFeed", 2, paramQQAppInterface.toString());
    }
    return localServiceAccountFolderFeed;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    paramQQAppInterface = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramQQAppInterface.findPublicAccountInfo(paramServiceAccountFolderFeed.b);
      if (localPublicAccountInfo != null)
      {
        if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
          paramServiceAccountFolderFeed.h = localPublicAccountInfo.name;
        }
        paramServiceAccountFolderFeed.m = localPublicAccountInfo.isVisible();
        paramServiceAccountFolderFeed.e = 0;
        return;
      }
      paramQQAppInterface = paramQQAppInterface.findAccountDetailInfo(paramServiceAccountFolderFeed.b);
      if (paramQQAppInterface != null)
      {
        if (!TextUtils.isEmpty(paramQQAppInterface.getName())) {
          paramServiceAccountFolderFeed.h = paramQQAppInterface.getName();
        }
        int i1 = paramQQAppInterface.getShowFlag();
        boolean bool = true;
        if (1 != i1) {
          bool = false;
        }
        paramServiceAccountFolderFeed.m = bool;
        paramServiceAccountFolderFeed.e = 0;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    int i1 = paramQQAppInterface.getConversationFacade().h(paramServiceAccountFolderFeed.b, 1008);
    int i2 = paramServiceAccountFolderFeed.d;
    if (i2 > 0)
    {
      if ((i2 == 1) && (i1 > 0))
      {
        paramServiceAccountFolderFeed.c = 2;
        return;
      }
      paramServiceAccountFolderFeed.c = 1;
      if (i1 > 0) {
        paramServiceAccountFolderFeed.d -= 1;
      }
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface != null)
    {
      paramServiceAccountFolderFeed.o = null;
      paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramServiceAccountFolderFeed.b, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramServiceAccountFolderFeed.f == paramQQAppInterface.getTime())
        {
          paramServiceAccountFolderFeed.p = 4;
          return;
        }
        if ((paramServiceAccountFolderFeed.j == null) || (paramQQAppInterface.getTime() > paramServiceAccountFolderFeed.j.time))
        {
          paramServiceAccountFolderFeed.p = 4;
          paramServiceAccountFolderFeed.f = paramQQAppInterface.getTime();
          paramServiceAccountFolderFeed.g = TimeManager.a().a(paramServiceAccountFolderFeed.b, paramQQAppInterface.getTime());
          paramServiceAccountFolderFeed.i = paramQQAppInterface.getSummary();
        }
      }
    }
  }
  
  public final boolean a()
  {
    int i1 = this.c;
    if (i1 != 1) {
      return i1 == 4;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("ServiceAccountFolderFeed content->");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mIsCreateFromMessageTab:");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mUin:");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mUnreadFlag:");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mUnreadNum:");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mAuthenIconId:");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mShowTime:");
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mTitleName:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mMsgBrief:");
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mMsgExtraInfo:");
    localStringBuilder2.append(this.l);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mDraft:");
    localStringBuilder2.append(this.o);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mStatus:");
    localStringBuilder2.append(this.p);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mDisplayTime:");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mOperationTime:");
    localStringBuilder2.append(this.n);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed
 * JD-Core Version:    0.7.0.1
 */