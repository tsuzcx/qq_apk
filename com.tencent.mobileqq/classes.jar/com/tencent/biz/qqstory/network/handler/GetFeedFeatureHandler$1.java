package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class GetFeedFeatureHandler$1
  implements Runnable
{
  GetFeedFeatureHandler$1(GetFeedFeatureHandler paramGetFeedFeatureHandler) {}
  
  public void run()
  {
    Object localObject3;
    if (GetFeedFeatureHandler.a(this.this$0))
    {
      localObject1 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = (Long)GetFeedFeatureHandler.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
        if ((localObject3 != null) && (System.currentTimeMillis() - ((Long)localObject3).longValue() < 30000L))
        {
          ((Iterator)localObject1).remove();
          SLog.a("Q.qqstory.home.GetFeedFeatureHandler", "remove same request for feed info:%s", localObject2);
        }
        else
        {
          GetFeedFeatureHandler.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    SLog.a("Q.qqstory.home.GetFeedFeatureHandler", "request for feed info:%s", this.this$0.jdField_a_of_type_JavaUtilList);
    Object localObject1 = new ArrayList();
    Object localObject2 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a((String)localObject3) == null)
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
      localObject2 = new BatchGetFriendStoryFeedInfoRequest();
      ((BatchGetFriendStoryFeedInfoRequest)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = new FeedIdListSeqInfo((String)((Iterator)localObject1).next(), 0, "", "");
        ((BatchGetFriendStoryFeedInfoRequest)localObject2).jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      CmdTaskManger.a().a((NetworkRequest)localObject2, this.this$0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedFeature: first=", this.this$0.jdField_a_of_type_JavaUtilList.get(0) });
    }
    localObject1 = new GetFeedFeatureRequest();
    ((GetFeedFeatureRequest)localObject1).jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_JavaUtilList;
    CmdTaskManger.a().a((NetworkRequest)localObject1, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.1
 * JD-Core Version:    0.7.0.1
 */