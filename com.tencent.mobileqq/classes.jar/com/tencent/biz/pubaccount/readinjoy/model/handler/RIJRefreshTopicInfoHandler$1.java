package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.ReqBody;

class RIJRefreshTopicInfoHandler$1
  implements Runnable
{
  RIJRefreshTopicInfoHandler$1(RIJRefreshTopicInfoHandler paramRIJRefreshTopicInfoHandler, ConcurrentMap paramConcurrentMap1, ConcurrentMap paramConcurrentMap2, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      long l = ((Long)((Iterator)localObject2).next()).longValue();
      if (!((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.get(Long.valueOf(l))).booleanValue())
      {
        Object localObject3 = (ArticleInfo)this.b.get(Long.valueOf(l));
        if ((localObject3 != null) && (RIJFeedsType.o((BaseArticleInfo)localObject3)) && (((ArticleInfo)localObject3).mNewPolymericInfo.a != null))
        {
          localObject3 = ((ArticleInfo)localObject3).mNewPolymericInfo.a.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)((Iterator)localObject3).next();
            if (localPackArticleInfo.a != null) {
              ((ArrayList)localObject1).add(Long.valueOf(localPackArticleInfo.a.b));
            }
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.put(Long.valueOf(l), Boolean.valueOf(true));
        }
      }
    }
    localObject2 = new oidb_cmd0xa6e.ReqBody();
    ((oidb_cmd0xa6e.ReqBody)localObject2).rpt_topiclist.set((List)localObject1);
    ((oidb_cmd0xa6e.ReqBody)localObject2).uint32_req_pv.set(1);
    localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0xa6e", 2670, 4, ((oidb_cmd0xa6e.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).addAttribute("channelId", Integer.valueOf(this.jdField_a_of_type_Int));
    ((ToServiceMsg)localObject1).addAttribute("0xa6e_articleSeqSet", this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.keySet());
    this.this$0.a.a((ToServiceMsg)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJRefreshTopicInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */