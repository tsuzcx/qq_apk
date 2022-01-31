package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import urp;
import urt;
import vco;
import vex;
import vfj;
import woq;
import woy;
import wxe;

public class GetFeedFeatureHandler$1
  implements Runnable
{
  public GetFeedFeatureHandler$1(vco paramvco) {}
  
  public void run()
  {
    Object localObject3;
    if (vco.a(this.this$0))
    {
      localObject1 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = (Long)vco.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
        if ((localObject3 != null) && (System.currentTimeMillis() - ((Long)localObject3).longValue() < 30000L))
        {
          ((Iterator)localObject1).remove();
          wxe.a("Q.qqstory.home.GetFeedFeatureHandler", "remove same request for feed info:%s", localObject2);
        }
        else
        {
          vco.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    wxe.a("Q.qqstory.home.GetFeedFeatureHandler", "request for feed info:%s", this.this$0.jdField_a_of_type_JavaUtilList);
    Object localObject1 = new ArrayList();
    Object localObject2 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.this$0.jdField_a_of_type_Woy.a((String)localObject3) == null)
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
      localObject2 = new vex();
      ((vex)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = new woq((String)((Iterator)localObject1).next(), 0, "", "");
        ((vex)localObject2).jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      urp.a().a((urt)localObject2, this.this$0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedFeature: first=", this.this$0.jdField_a_of_type_JavaUtilList.get(0) });
    }
    localObject1 = new vfj();
    ((vfj)localObject1).jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_JavaUtilList;
    urp.a().a((urt)localObject1, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.1
 * JD-Core Version:    0.7.0.1
 */