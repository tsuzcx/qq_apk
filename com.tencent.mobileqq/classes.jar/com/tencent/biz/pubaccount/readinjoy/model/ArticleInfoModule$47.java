package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import pay;
import ptv;
import rdm;
import rdn;
import rdp;
import tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.TopicInfo;

public class ArticleInfoModule$47
  implements Runnable
{
  public ArticleInfoModule$47(ptv paramptv, int paramInt, Set paramSet, List paramList) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)ptv.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator1.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)localConcurrentHashMap.get(Long.valueOf(((Long)localIterator1.next()).longValue()));
      if ((localArticleInfo != null) && (pay.o(localArticleInfo)) && (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
      {
        Iterator localIterator2 = localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          rdn localrdn = (rdn)localIterator2.next();
          if (localrdn.a != null)
          {
            Iterator localIterator3 = this.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator3.hasNext())
            {
              oidb_cmd0xa6e.TopicInfo localTopicInfo = (oidb_cmd0xa6e.TopicInfo)localIterator3.next();
              if (localrdn.a.b == localTopicInfo.uint64_topic_id.get()) {
                localrdn.a.jdField_a_of_type_Int = localTopicInfo.uint32_pv.get();
              }
            }
          }
        }
        localArticleInfo.invalidateProteusTemplateBean();
        this.this$0.a(localArticleInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.47
 * JD-Core Version:    0.7.0.1
 */