package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import pqu;
import pqw;
import qdw;
import qep;
import qga;
import qjb;
import rbg;

public class ArticleInfoModule$3
  implements Runnable
{
  public ArticleInfoModule$3(qep paramqep, long paramLong1, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, List paramList1, boolean paramBoolean2, long paramLong2, List paramList2, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    boolean bool3 = false;
    boolean bool1;
    Object localObject;
    if (this.jdField_a_of_type_Long == -1L)
    {
      bool1 = true;
      qep.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ArrayOfByte);
      qep.a(this.this$0).a(this.jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break label711;
      }
      localObject = qep.a(this.this$0).a(this.jdField_a_of_type_Int);
      if (localObject != null) {
        break label829;
      }
      localObject = new ConcurrentHashMap();
    }
    label829:
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
          localStringBuilder.append("article【" + i + "】 id : " + localArticleInfo.mArticleID + " seq : " + localArticleInfo.mRecommendSeq + " title : " + pqu.a(localArticleInfo.mTitle) + " , groupID : " + localArticleInfo.mGroupId + " rowkey : " + localArticleInfo.innerUniqueID + ", mFeedType : " + localArticleInfo.mFeedType + " feeedCookie : " + localArticleInfo.mFeedCookie + ", mFeedID : " + localArticleInfo.mFeedId + " algorithmID : " + localArticleInfo.mAlgorithmID + " strategyId : " + localArticleInfo.mStrategyId + " businessID : " + localArticleInfo.businessId + " businessName :" + localArticleInfo.businessName + " commentShareUrl : " + localArticleInfo.commentShareUrl);
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
            if ((pqw.o(localArticleInfo)) && (!((ConcurrentMap)localObject).containsKey(Long.valueOf(localArticleInfo.mRecommendSeq)))) {
              ((ConcurrentMap)localObject).put(Long.valueOf(localArticleInfo.mRecommendSeq), Boolean.valueOf(false));
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
        if (((ConcurrentMap)localObject).size() > 0) {
          qep.a(this.this$0).a(this.jdField_a_of_type_Int, (ConcurrentMap)localObject);
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
      qdw.a(this.jdField_a_of_type_JavaUtilList);
      label711:
      rbg.a().a(this.jdField_a_of_type_JavaUtilList);
      qep.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      if (bool1)
      {
        qep.a(this.this$0).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg);
        qep.a(this.this$0, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      qep.a(this.this$0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.3
 * JD-Core Version:    0.7.0.1
 */