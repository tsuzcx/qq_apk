package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class MsgTabNodePullVideoBasicInfoSegment$2
  implements BatchGetVideoInfo.IBatchGetVideoInfoCallback
{
  MsgTabNodePullVideoBasicInfoSegment$2(MsgTabNodePullVideoBasicInfoSegment paramMsgTabNodePullVideoBasicInfoSegment, List paramList) {}
  
  public void a()
  {
    QLog.e("Q.qqstory.msgTab.jobPullBasicInfo", 1, "pull video info failed");
    MsgTabNodePullVideoBasicInfoSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodePullVideoBasicInfoSegment, new ErrorMessage(102, "pull video info failed"));
  }
  
  public void a(ArrayList<StoryVideoItem> paramArrayList)
  {
    if (paramArrayList == null)
    {
      SLog.e("Q.qqstory.msgTab.jobPullBasicInfo", "video list empty !");
      MsgTabNodePullVideoBasicInfoSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodePullVideoBasicInfoSegment, new ErrorMessage(102, "video list empty !"));
      return;
    }
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    Object localObject;
    while (paramArrayList.hasNext())
    {
      localObject = (StoryVideoItem)paramArrayList.next();
      localHashMap.put(((StoryVideoItem)localObject).mVid, localObject);
    }
    paramArrayList = new ArrayList();
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      localObject = (MsgTabVideoData)this.jdField_a_of_type_JavaUtilList.get(i);
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localHashMap.get(((MsgTabVideoData)localObject).b);
      if (localStoryVideoItem == null) {
        SLog.e("Q.qqstory.msgTab.jobPullBasicInfo", "not found video!");
      }
      for (;;)
      {
        i += 1;
        break;
        ((MsgTabVideoData)localObject).a = localStoryVideoItem;
        paramArrayList.add(localObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullBasicInfo", 2, "pull video info succeed, info");
    }
    MsgTabNodePullVideoBasicInfoSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodePullVideoBasicInfoSegment, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodePullVideoBasicInfoSegment.2
 * JD-Core Version:    0.7.0.1
 */