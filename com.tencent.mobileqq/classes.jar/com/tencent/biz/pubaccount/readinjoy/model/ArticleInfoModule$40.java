package com.tencent.biz.pubaccount.readinjoy.model;

import awge;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import pew;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

public class ArticleInfoModule$40
  implements Runnable
{
  public ArticleInfoModule$40(pew parampew, List paramList, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void run()
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject;
    long l;
    int i;
    label161:
    ConcurrentHashMap localConcurrentHashMap;
    Iterator localIterator2;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localObject = (oidb_cmd0x8c8.FeedsInfo)localIterator1.next();
        if ((((oidb_cmd0x8c8.FeedsInfo)localObject).feeds_type.has()) && (((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.has()) && (((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.uint64_feeds_id.has()))
        {
          l = ((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.uint64_feeds_id.get();
          i = ((oidb_cmd0x8c8.FeedsInfo)localObject).feeds_type.get();
          localObject = l + "" + i;
          localObject = (ArticleInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          if (localObject != null)
          {
            this.this$0.a((awge)localObject);
            localConcurrentHashMap = (ConcurrentHashMap)pew.a(this.this$0).get(Integer.valueOf(0));
            if (localConcurrentHashMap != null)
            {
              localIterator2 = localConcurrentHashMap.values().iterator();
              do
              {
                if (!localIterator2.hasNext()) {
                  break;
                }
                localObject = (ArticleInfo)localIterator2.next();
              } while ((((ArticleInfo)localObject).mFeedId != l) || (((ArticleInfo)localObject).mFeedType != i));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localConcurrentHashMap.remove(Long.valueOf(((ArticleInfo)localObject).mRecommendSeq));
        pew.a(this.this$0, Integer.valueOf(0), (ArticleInfo)localObject);
        localArrayList2.add(Long.valueOf(((ArticleInfo)localObject).mRecommendSeq));
      }
      localConcurrentHashMap = (ConcurrentHashMap)pew.a(this.this$0).get(Integer.valueOf(70));
      if (localConcurrentHashMap == null) {
        break;
      }
      localIterator2 = localConcurrentHashMap.values().iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject = (ArticleInfo)localIterator2.next();
      } while ((((ArticleInfo)localObject).mFeedId != l) || (((ArticleInfo)localObject).mFeedType != i));
      for (;;)
      {
        if (localObject == null) {
          break label499;
        }
        localConcurrentHashMap.remove(Long.valueOf(((ArticleInfo)localObject).mRecommendSeq));
        pew.a(this.this$0, Integer.valueOf(70), (ArticleInfo)localObject);
        localArrayList1.add(Long.valueOf(((ArticleInfo)localObject).mRecommendSeq));
        break;
        QLog.d("ArticleInfoModule", 1, "remove artileinfo cache is null while feedid = " + l + "feedtype" + i);
        break label161;
        localObject = new ArrayList(localArrayList2);
        localArrayList1 = new ArrayList(localArrayList1);
        ThreadManager.getUIHandler().post(new ArticleInfoModule.40.1(this, (List)localObject, localArrayList1));
        return;
        localObject = null;
      }
      label499:
      break;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.40
 * JD-Core Version:    0.7.0.1
 */