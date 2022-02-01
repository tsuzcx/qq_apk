package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import pwb;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

public class ArticleInfoModule$40
  implements Runnable
{
  public ArticleInfoModule$40(pwb parampwb, List paramList, ConcurrentHashMap paramConcurrentHashMap) {}
  
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
          this.this$0.a((Entity)localObject);
        }
        for (;;)
        {
          localObject = (ConcurrentHashMap)pwb.a(this.this$0).get(Integer.valueOf(0));
          pwb.a(this.this$0, (ConcurrentHashMap)localObject, l, i, localArrayList2);
          localObject = (ConcurrentHashMap)pwb.a(this.this$0).get(Integer.valueOf(70));
          pwb.b(this.this$0, (ConcurrentHashMap)localObject, l, i, localArrayList2);
          break;
          QLog.d("ArticleInfoModule", 1, "remove artileinfo cache is null while feedid = " + l + "feedtype" + i);
        }
      }
    }
    localArrayList2 = new ArrayList(localArrayList2);
    localArrayList1 = new ArrayList(localArrayList1);
    ThreadManager.getUIHandler().post(new ArticleInfoModule.40.1(this, localArrayList2, localArrayList1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.40
 * JD-Core Version:    0.7.0.1
 */