package com.tencent.biz.qqstory.shareGroup.model;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;

class ShareGroupManager$1
  extends ShareGroupManager.GetFeedVidListObserver
{
  ShareGroupManager$1(ShareGroupManager paramShareGroupManager, int paramInt1, String paramString, int paramInt2) {}
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int == paramVideoCollectionItem.videoVidList.size())
    {
      boolean bool = true;
      paramBoolean = bool;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("currentVidListSize == videoCollectionItem.videoVidList.size():");
        ((StringBuilder)localObject).append(paramVideoCollectionItem.toString());
        QLog.e("Q.qqstory.discover.ShareGroupManager", 2, ((StringBuilder)localObject).toString());
        paramBoolean = bool;
      }
    }
    if (paramBoolean)
    {
      localObject = new ShareGroupManager.GetFeedIdVidListEvent();
      ((ShareGroupManager.GetFeedIdVidListEvent)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((ShareGroupManager.GetFeedIdVidListEvent)localObject).jdField_a_of_type_JavaUtilArrayList = paramVideoCollectionItem.videoVidList;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupManager.a(this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager.1
 * JD-Core Version:    0.7.0.1
 */