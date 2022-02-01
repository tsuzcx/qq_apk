package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import wlb;
import wlf;
import wwa;
import wyj;
import wyv;
import yib;
import yij;
import yqp;

public class GetFeedFeatureHandler$1
  implements Runnable
{
  public GetFeedFeatureHandler$1(wwa paramwwa) {}
  
  public void run()
  {
    Object localObject3;
    if (wwa.a(this.this$0))
    {
      localObject1 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = (Long)wwa.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
        if ((localObject3 != null) && (System.currentTimeMillis() - ((Long)localObject3).longValue() < 30000L))
        {
          ((Iterator)localObject1).remove();
          yqp.a("Q.qqstory.home.GetFeedFeatureHandler", "remove same request for feed info:%s", localObject2);
        }
        else
        {
          wwa.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    yqp.a("Q.qqstory.home.GetFeedFeatureHandler", "request for feed info:%s", this.this$0.jdField_a_of_type_JavaUtilList);
    Object localObject1 = new ArrayList();
    Object localObject2 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.this$0.jdField_a_of_type_Yij.a((String)localObject3) == null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((List)localObject1).add(localObject3);
        }
      }
      else {
        this.this$0.b.add(localObject3);
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedItem: first=", ((List)localObject1).get(0) });
      }
      localObject2 = new wyj();
      ((wyj)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = new yib((String)((Iterator)localObject1).next(), 0, "", "");
        ((wyj)localObject2).jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      wlb.a().a((wlf)localObject2, this.this$0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedFeature: first=", this.this$0.jdField_a_of_type_JavaUtilList.get(0) });
    }
    localObject1 = new wyv();
    ((wyv)localObject1).jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_JavaUtilList;
    wlb.a().a((wlf)localObject1, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.1
 * JD-Core Version:    0.7.0.1
 */