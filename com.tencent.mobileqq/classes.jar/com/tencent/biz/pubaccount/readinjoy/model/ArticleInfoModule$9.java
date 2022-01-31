package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import obz;
import oni;
import ooq;
import peq;

public class ArticleInfoModule$9
  implements Runnable
{
  public ArticleInfoModule$9(ooq paramooq, long paramLong1, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, List paramList1, boolean paramBoolean2, long paramLong2, List paramList2, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    boolean bool3 = false;
    boolean bool1;
    Object localObject;
    if (this.jdField_a_of_type_Long == -1L)
    {
      bool1 = true;
      this.this$0.a(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ArrayOfByte);
      this.this$0.c(this.jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break label691;
      }
      localObject = (ConcurrentHashMap)ooq.b(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localObject != null) {
        break label803;
      }
      localObject = new ConcurrentHashMap();
    }
    label803:
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("\n");
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        int i = 0;
        label119:
        if (localIterator.hasNext())
        {
          ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
          localStringBuilder.append("article【" + i + "】 id : " + localArticleInfo.mArticleID + " seq : " + localArticleInfo.mRecommendSeq + " title : " + obz.c(localArticleInfo.mTitle) + " , groupID : " + localArticleInfo.mGroupId + " rowkey : " + localArticleInfo.innerUniqueID + ", mFeedType : " + localArticleInfo.mFeedType + " feeedCookie : " + localArticleInfo.mFeedCookie + ", mFeedID : " + localArticleInfo.mFeedId + " algorithmID : " + localArticleInfo.mAlgorithmID + " strategyId : " + localArticleInfo.mStrategyId + " businessID : " + localArticleInfo.businessId + " businessName :" + localArticleInfo.businessName);
          SocializeFeedsInfo localSocializeFeedsInfo;
          if (localArticleInfo.mSocialFeedInfo != null)
          {
            localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
            if (QLog.isColorLevel())
            {
              localStringBuilder.append(" " + localSocializeFeedsInfo);
              localStringBuilder.append("\n");
            }
          }
          for (;;)
          {
            if ((obz.o(localArticleInfo)) && (!((ConcurrentHashMap)localObject).containsKey(Long.valueOf(localArticleInfo.mRecommendSeq)))) {
              ((ConcurrentHashMap)localObject).put(Long.valueOf(localArticleInfo.mRecommendSeq), Boolean.valueOf(false));
            }
            i += 1;
            break label119;
            bool1 = false;
            break;
            localStringBuilder.append("SocialFeedInfo: mFeedId: " + localSocializeFeedsInfo.jdField_a_of_type_Long + " mFeedStatus: " + localSocializeFeedsInfo.k + " mFollowStatus: " + localSocializeFeedsInfo.h);
            localStringBuilder.append("\n");
            continue;
            localStringBuilder.append("\n");
          }
        }
        if (((ConcurrentHashMap)localObject).size() > 0) {
          ooq.b(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
        }
      }
      localObject = new StringBuilder().append("handleRefreshChannel success=").append(this.jdField_a_of_type_Boolean).append(" channelId=").append(this.jdField_a_of_type_Int).append(" noMoreData=").append(this.jdField_b_of_type_Boolean).append(" beginRecommendSeq=").append(this.jdField_a_of_type_Long).append(" endRecommendSeq=").append(this.jdField_b_of_type_Long).append(" isInMsgTab : ");
      boolean bool2 = bool3;
      if (this.this$0.a != null)
      {
        bool2 = bool3;
        if ((this.this$0.a instanceof QQAppInterface)) {
          bool2 = true;
        }
      }
      QLog.i("ArticleInfoModule", 1, bool2 + " isRefresh : " + bool1 + ", " + localStringBuilder.toString());
      oni.a(this.jdField_a_of_type_JavaUtilList);
      label691:
      peq.a().a(this.jdField_a_of_type_JavaUtilList);
      this.this$0.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      if (bool1)
      {
        ooq.a(this.this$0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg);
        ooq.a(this.this$0, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      ooq.a(this.this$0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.9
 * JD-Core Version:    0.7.0.1
 */