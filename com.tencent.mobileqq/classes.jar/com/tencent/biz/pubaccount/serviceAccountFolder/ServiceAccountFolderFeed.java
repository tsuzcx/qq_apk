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
  public int a;
  public long a;
  public MessageRecord a;
  public CharSequence a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  @notColumn
  public CharSequence b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  @notColumn
  public int e;
  public String e;
  
  public ServiceAccountFolderFeed()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131167170);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static ServiceAccountFolderFeed a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    RecentItemPublicAccountChatMsgData localRecentItemPublicAccountChatMsgData = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    localRecentItemPublicAccountChatMsgData.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    paramRecentUser = new ServiceAccountFolderFeed();
    paramRecentUser.jdField_a_of_type_Boolean = true;
    paramRecentUser.jdField_a_of_type_JavaLangString = localRecentItemPublicAccountChatMsgData.getRecentUserUin();
    paramRecentUser.jdField_b_of_type_Int = localRecentItemPublicAccountChatMsgData.mUnreadNum;
    paramRecentUser.jdField_c_of_type_Int = localRecentItemPublicAccountChatMsgData.mAuthenIconId;
    paramRecentUser.jdField_a_of_type_Long = localRecentItemPublicAccountChatMsgData.mDisplayTime;
    paramRecentUser.jdField_b_of_type_JavaLangString = localRecentItemPublicAccountChatMsgData.mShowTime;
    paramRecentUser.jdField_b_of_type_Long = localRecentItemPublicAccountChatMsgData.getLastMsgTime();
    paramRecentUser.jdField_c_of_type_JavaLangString = localRecentItemPublicAccountChatMsgData.mTitleName;
    paramRecentUser.jdField_a_of_type_JavaLangCharSequence = localRecentItemPublicAccountChatMsgData.mLastMsg;
    paramRecentUser.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.getMessageFacade().b(paramRecentUser.jdField_a_of_type_JavaLangString, 1008);
    paramRecentUser.jdField_d_of_type_JavaLangString = ServiceAccountFolderManager.a(paramQQAppInterface, paramRecentUser.jdField_a_of_type_JavaLangString);
    paramRecentUser.jdField_e_of_type_JavaLangString = localRecentItemPublicAccountChatMsgData.mReportKeyBytesOacMsgxtend;
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
    localServiceAccountFolderFeed.jdField_a_of_type_Boolean = false;
    localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString = paramSubscriptionFeed.jdField_a_of_type_JavaLangString;
    localServiceAccountFolderFeed.jdField_b_of_type_Int = paramSubscriptionFeed.jdField_b_of_type_Int;
    localServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
    localServiceAccountFolderFeed.jdField_a_of_type_Long = paramSubscriptionFeed.jdField_a_of_type_Long;
    localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramSubscriptionFeed.jdField_a_of_type_JavaLangString, paramSubscriptionFeed.jdField_a_of_type_Long);
    String str2 = TroopBarAssistantManager.a().a(paramSubscriptionFeed.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramSubscriptionFeed.jdField_a_of_type_JavaLangString;
    }
    localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = str1;
    if (paramSubscriptionFeed.jdField_a_of_type_JavaUtilList.size() > 0) {
      localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = ((SubscriptionFeedItem)paramSubscriptionFeed.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.getMessageFacade().b(paramSubscriptionFeed.jdField_a_of_type_JavaLangString, 1008);
    localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString = ServiceAccountFolderManager.a(paramQQAppInterface, paramSubscriptionFeed.jdField_a_of_type_JavaLangString);
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
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramQQAppInterface.findPublicAccountInfo(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo != null)
      {
        if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
          paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
        }
        paramServiceAccountFolderFeed.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
        paramServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
        return;
      }
      paramQQAppInterface = paramQQAppInterface.findAccountDetailInfo(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      if (paramQQAppInterface != null)
      {
        if (!TextUtils.isEmpty(paramQQAppInterface.getName())) {
          paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = paramQQAppInterface.getName();
        }
        int i = paramQQAppInterface.getShowFlag();
        boolean bool = true;
        if (1 != i) {
          bool = false;
        }
        paramServiceAccountFolderFeed.jdField_b_of_type_Boolean = bool;
        paramServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    int i = paramQQAppInterface.getConversationFacade().g(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1008);
    int j = paramServiceAccountFolderFeed.jdField_b_of_type_Int;
    if (j > 0)
    {
      if ((j == 1) && (i > 0))
      {
        paramServiceAccountFolderFeed.jdField_a_of_type_Int = 2;
        return;
      }
      paramServiceAccountFolderFeed.jdField_a_of_type_Int = 1;
      if (i > 0) {
        paramServiceAccountFolderFeed.jdField_b_of_type_Int -= 1;
      }
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface != null)
    {
      paramServiceAccountFolderFeed.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramServiceAccountFolderFeed.jdField_a_of_type_Long == paramQQAppInterface.getTime())
        {
          paramServiceAccountFolderFeed.jdField_e_of_type_Int = 4;
          return;
        }
        if ((paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (paramQQAppInterface.getTime() > paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time))
        {
          paramServiceAccountFolderFeed.jdField_e_of_type_Int = 4;
          paramServiceAccountFolderFeed.jdField_a_of_type_Long = paramQQAppInterface.getTime();
          paramServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
          paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
        }
      }
    }
  }
  
  public final boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 1) {
      return i == 4;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("ServiceAccountFolderFeed content->");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mIsCreateFromMessageTab:");
    localStringBuilder2.append(this.jdField_a_of_type_Boolean);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mUin:");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mUnreadFlag:");
    localStringBuilder2.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mUnreadNum:");
    localStringBuilder2.append(this.jdField_b_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mAuthenIconId:");
    localStringBuilder2.append(this.jdField_c_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mShowTime:");
    localStringBuilder2.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mTitleName:");
    localStringBuilder2.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mMsgBrief:");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangCharSequence);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mMsgExtraInfo:");
    localStringBuilder2.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mDraft:");
    localStringBuilder2.append(this.jdField_b_of_type_JavaLangCharSequence);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mStatus:");
    localStringBuilder2.append(this.jdField_e_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mDisplayTime:");
    localStringBuilder2.append(this.jdField_a_of_type_Long);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mOperationTime:");
    localStringBuilder2.append(this.jdField_b_of_type_Long);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed
 * JD-Core Version:    0.7.0.1
 */