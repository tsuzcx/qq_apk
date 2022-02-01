package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

class ArticleInfoModule$2
  implements Runnable
{
  ArticleInfoModule$2(ArticleInfoModule paramArticleInfoModule, boolean paramBoolean1, List paramList1, List paramList2, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() != 1) || (this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
        if (QLog.isColorLevel()) {
          QLog.e("ArticleInfoModule", 2, "###onGetVideoRealtimeReplaceList: reqArticleList  szie != 1 or articleInfoList is empty.");
        }
      }
      long l2;
      Object localObject1;
      do
      {
        StringBuilder localStringBuilder;
        Object localObject2;
        long l1;
        Object localObject3;
        do
        {
          do
          {
            do
            {
              return;
              l2 = ((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue();
              localStringBuilder = new StringBuilder("\n");
              localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
              i = 0;
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ArticleInfo)((Iterator)localObject1).next();
                localStringBuilder.append("实时替换 article【" + i + "】 id : " + ((ArticleInfo)localObject2).mArticleID + " seq : " + ((ArticleInfo)localObject2).mRecommendSeq + " title : " + RIJAppSetting.a(((ArticleInfo)localObject2).mTitle) + " , groupID : " + ((ArticleInfo)localObject2).mGroupId + " algorithmID : " + ((ArticleInfo)localObject2).mAlgorithmID + " strategyId : " + ((ArticleInfo)localObject2).mStrategyId + " feedType: " + ((ArticleInfo)localObject2).mFeedType);
                if (QLog.isColorLevel()) {
                  if (((ArticleInfo)localObject2).mSocialFeedInfo != null)
                  {
                    localStringBuilder.append(" " + ((ArticleInfo)localObject2).mSocialFeedInfo);
                    localStringBuilder.append("\n");
                  }
                }
                for (;;)
                {
                  i += 1;
                  break;
                  localStringBuilder.append("\n");
                  continue;
                  localStringBuilder.append("\n");
                }
              }
              QLog.i("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList success=" + this.jdField_a_of_type_Boolean + " channelId=" + this.jdField_a_of_type_Int + ", reqArticleID: " + l2 + localStringBuilder.toString());
              localObject1 = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int));
              if (localObject1 != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList fail, for currentSeqList is null, channelId=" + this.jdField_a_of_type_Int);
            return;
            localObject2 = ((List)localObject1).iterator();
            l1 = -1L;
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Long)((Iterator)localObject2).next();
              ArticleInfo localArticleInfo = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int), (Long)localObject3);
              if (l2 == localArticleInfo.mArticleID)
              {
                l1 = ((Long)localObject3).longValue();
                QLog.i("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList find the original article seq：" + localObject3 + ", reqArticleID: " + l2 + ", title : " + RIJAppSetting.a(localArticleInfo.mTitle));
              }
            }
          } while (l1 == -1L);
          if (QLog.isColorLevel())
          {
            localStringBuilder.setLength(0);
            localStringBuilder.append("current seq list >>").append("\n");
            i = 0;
            while (i < ((List)localObject1).size())
            {
              localObject2 = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int), (Long)((List)localObject1).get(i));
              localStringBuilder.append("article [" + i + "] seq : " + ((List)localObject1).get(i) + ", id : " + ((ArticleInfo)localObject2).mArticleID + " title : " + RIJAppSetting.a(((ArticleInfo)localObject2).mTitle));
              localStringBuilder.append("\n");
              i += 1;
            }
            QLog.d("ArticleInfoModule", 2, localStringBuilder.toString());
          }
          localObject2 = ArticleInfoModule.a(this.this$0).c(this.jdField_a_of_type_Int);
        } while (localObject2 == null);
        int k = ((List)localObject1).size();
        int j = this.jdField_b_of_type_JavaUtilList.size();
        int i = 0;
        while (i < k)
        {
          long l3 = ((Long)((List)localObject1).get(i)).longValue();
          if (((l1 & 0xFFFFFF00) == (0xFFFFFF00 & l3)) && (l3 >= l1))
          {
            localObject3 = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(l3));
            ((ArticleInfo)localObject3).mRecommendSeq = (j + l3);
            ((ConcurrentMap)localObject2).remove(Long.valueOf(l3));
            ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int), (ArticleInfo)localObject3, true);
          }
          i += 1;
        }
        i = j - 1;
        while (i >= 0)
        {
          localObject1 = (ArticleInfo)this.jdField_b_of_type_JavaUtilList.get(i);
          ((ArticleInfo)localObject1).mRecommendSeq = (j + l1 - 1L - i);
          ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int), (ArticleInfo)localObject1, true);
          i -= 1;
        }
        localObject1 = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int));
        if (QLog.isColorLevel())
        {
          localStringBuilder.setLength(0);
          localStringBuilder.append("new seq list >>").append("\n");
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject2 = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int), (Long)((List)localObject1).get(i));
            localStringBuilder.append("article [" + i + "] seq : " + ((List)localObject1).get(i) + ", id : " + ((ArticleInfo)localObject2).mArticleID + " title : " + RIJAppSetting.a(((ArticleInfo)localObject2).mTitle));
            localStringBuilder.append("\n");
            i += 1;
          }
          QLog.d("ArticleInfoModule", 2, localStringBuilder.toString());
        }
      } while (!this.jdField_b_of_type_Boolean);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, l2, (List)localObject1, this.jdField_b_of_type_JavaUtilList);
      return;
    }
    QLog.e("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.2
 * JD-Core Version:    0.7.0.1
 */