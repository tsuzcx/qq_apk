package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import pha;
import pwb;
import qnf;
import rfv;
import rfw;
import rfy;
import tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.ReqBody;

public class ArticleInfoModule$47
  implements Runnable
{
  public ArticleInfoModule$47(pwb parampwb, ConcurrentHashMap paramConcurrentHashMap1, ConcurrentHashMap paramConcurrentHashMap2, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      long l = ((Long)((Iterator)localObject2).next()).longValue();
      if (!((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l))).booleanValue())
      {
        Object localObject3 = (ArticleInfo)this.b.get(Long.valueOf(l));
        if ((localObject3 != null) && (pha.o((BaseArticleInfo)localObject3)) && (((ArticleInfo)localObject3).mNewPolymericInfo.a != null))
        {
          localObject3 = ((ArticleInfo)localObject3).mNewPolymericInfo.a.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            rfw localrfw = (rfw)((Iterator)localObject3).next();
            if (localrfw.a != null) {
              ((ArrayList)localObject1).add(Long.valueOf(localrfw.a.b));
            }
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), Boolean.valueOf(true));
        }
      }
    }
    localObject2 = new oidb_cmd0xa6e.ReqBody();
    ((oidb_cmd0xa6e.ReqBody)localObject2).rpt_topiclist.set((List)localObject1);
    ((oidb_cmd0xa6e.ReqBody)localObject2).uint32_req_pv.set(1);
    localObject1 = qnf.a("OidbSvc.0xa6e", 2670, 4, ((oidb_cmd0xa6e.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).addAttribute("channelId", Integer.valueOf(this.jdField_a_of_type_Int));
    ((ToServiceMsg)localObject1).addAttribute("0xa6e_articleSeqSet", this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet());
    this.this$0.a((ToServiceMsg)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.47
 * JD-Core Version:    0.7.0.1
 */