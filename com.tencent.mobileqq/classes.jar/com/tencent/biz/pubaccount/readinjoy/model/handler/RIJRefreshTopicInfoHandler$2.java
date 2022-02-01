package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import pqw;
import qep;
import qga;
import qjb;
import rps;
import rpt;
import rpv;
import tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.TopicInfo;

public class RIJRefreshTopicInfoHandler$2
  implements Runnable
{
  public RIJRefreshTopicInfoHandler$2(qjb paramqjb, int paramInt, Set paramSet, List paramList) {}
  
  public void run()
  {
    ConcurrentMap localConcurrentMap = this.this$0.a.a().c(this.jdField_a_of_type_Int);
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator1.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)localConcurrentMap.get(Long.valueOf(((Long)localIterator1.next()).longValue()));
      if ((localArticleInfo != null) && (pqw.o(localArticleInfo)) && (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
      {
        Iterator localIterator2 = localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          rpt localrpt = (rpt)localIterator2.next();
          if (localrpt.a != null)
          {
            Iterator localIterator3 = this.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator3.hasNext())
            {
              oidb_cmd0xa6e.TopicInfo localTopicInfo = (oidb_cmd0xa6e.TopicInfo)localIterator3.next();
              if (localrpt.a.b == localTopicInfo.uint64_topic_id.get()) {
                localrpt.a.jdField_a_of_type_Int = localTopicInfo.uint32_pv.get();
              }
            }
          }
        }
        localArticleInfo.invalidateProteusTemplateBean();
        this.this$0.a.a(localArticleInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJRefreshTopicInfoHandler.2
 * JD-Core Version:    0.7.0.1
 */