package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

class RIJUpvoteAndCommentHandler$3
  implements Runnable
{
  RIJUpvoteAndCommentHandler$3(RIJUpvoteAndCommentHandler paramRIJUpvoteAndCommentHandler, List paramList, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void run()
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (oidb_cmd0x8c8.FeedsInfo)localIterator.next();
      if ((((oidb_cmd0x8c8.FeedsInfo)localObject).feeds_type.has()) && (((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.has()) && (((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.uint64_feeds_id.has()))
      {
        long l = ((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.uint64_feeds_id.get();
        int i = ((oidb_cmd0x8c8.FeedsInfo)localObject).feeds_type.get();
        localObject = l + "" + i;
        localObject = (ArticleInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null) {
          this.this$0.a.a((Entity)localObject);
        }
        for (;;)
        {
          localObject = this.this$0.a.a().c(0);
          RIJUpvoteAndCommentHandler.a(this.this$0, (ConcurrentMap)localObject, l, i, localArrayList2);
          localObject = this.this$0.a.a().c(70);
          RIJUpvoteAndCommentHandler.b(this.this$0, (ConcurrentMap)localObject, l, i, localArrayList2);
          break;
          QLog.d("RIJUpvoteAndCommentHandler", 1, "remove artileinfo cache is null while feedid = " + l + "feedtype" + i);
        }
      }
    }
    localArrayList2 = new ArrayList(localArrayList2);
    localArrayList1 = new ArrayList(localArrayList1);
    ThreadManager.getUIHandler().post(new RIJUpvoteAndCommentHandler.3.1(this, localArrayList2, localArrayList1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJUpvoteAndCommentHandler.3
 * JD-Core Version:    0.7.0.1
 */