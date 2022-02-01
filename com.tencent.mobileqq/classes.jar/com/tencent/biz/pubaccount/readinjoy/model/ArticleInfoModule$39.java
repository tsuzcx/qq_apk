package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import pon;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

public class ArticleInfoModule$39
  implements Runnable
{
  public ArticleInfoModule$39(pon parampon, List paramList, ConcurrentHashMap paramConcurrentHashMap, boolean paramBoolean) {}
  
  public void run()
  {
    EntityTransaction localEntityTransaction = this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    localEntityTransaction.begin();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject;
    int j;
    long l;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label449;
      }
      localObject = (oidb_cmd0x8c8.FeedsInfo)localIterator.next();
      j = i;
      try
      {
        if (((oidb_cmd0x8c8.FeedsInfo)localObject).has())
        {
          j = i;
          if (((oidb_cmd0x8c8.FeedsInfo)localObject).get() != null)
          {
            j = i;
            if (((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.has())
            {
              j = i;
              if (((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.get() != null)
              {
                oidb_cmd0x8c8.SocializeFeedsInfo localSocializeFeedsInfo = (oidb_cmd0x8c8.SocializeFeedsInfo)((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.get();
                if (localSocializeFeedsInfo.uint64_feeds_id.has())
                {
                  l = localSocializeFeedsInfo.uint64_feeds_id.get();
                  label131:
                  if (l != 0L) {
                    break label168;
                  }
                  QLog.d("ArticleInfoModule", 1, "convertPBToInfo failed feedsInfo feedsId == 0");
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("ArticleInfoModule", 1, "handle0x8c8UpdateUpvoteAndComment merge failed ", localException);
      }
    }
    for (;;)
    {
      break;
      l = 0L;
      break label131;
      label168:
      if (!((oidb_cmd0x8c8.FeedsInfo)localObject).feeds_type.has())
      {
        QLog.d("ArticleInfoModule", 1, "convertPBToInfo failed feedsInfo feeds_type == null");
        break;
      }
      j = ((oidb_cmd0x8c8.FeedsInfo)localObject).feeds_type.get();
      localObject = l + "" + j;
      QLog.d("ArticleInfoModule", 1, new Object[] { "handle 8c8, feedsId = ", Long.valueOf(l), ", feedsType = ", Integer.valueOf(j) });
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get((String)localObject + 0);
      if (localArticleInfo != null) {
        pon.a(this.this$0, localArticleInfo, localException, 0);
      }
      localArticleInfo = (ArticleInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get((String)localObject + 70);
      if (localArticleInfo != null) {
        pon.a(this.this$0, localArticleInfo, localException, 70);
      }
      localObject = (ArticleInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get((String)localObject + 41403);
      if (localObject != null) {
        pon.a(this.this$0, (ArticleInfo)localObject, localException, 41403);
      }
      if ((this.jdField_a_of_type_Boolean) && (localObject != null) && (((ArticleInfo)localObject).mSocialFeedInfo != null))
      {
        boolean bool = pon.a(this.this$0, (ArticleInfo)localObject);
        if (!bool) {
          break;
        }
      }
      j = 1;
      i = j;
    }
    label449:
    if ((i != 0) && (this.this$0.jdField_a_of_type_AndroidOsHandler != null)) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.39.1(this));
    }
    localEntityTransaction.commit();
    localEntityTransaction.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.39
 * JD-Core Version:    0.7.0.1
 */