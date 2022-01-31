package com.tencent.biz.qqstory.storyHome.discover;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;

public class MakeSureVideoInfoSegment$IPullResultCallbackImpl
  implements BatchHandlerListPuller.IPullResultCallback
{
  public final MakeSureVideoInfoSegment a;
  public final String a;
  
  public MakeSureVideoInfoSegment$IPullResultCallbackImpl(MakeSureVideoInfoSegment paramMakeSureVideoInfoSegment, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverMakeSureVideoInfoSegment = paramMakeSureVideoInfoSegment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_JavaLangString);
    if ((localStoryVideoItem != null) && (MakeSureVideoInfoSegment.a(localStoryVideoItem)))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverMakeSureVideoInfoSegment.b(localStoryVideoItem);
      return;
    }
    MakeSureVideoInfoSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverMakeSureVideoInfoSegment, new ErrorMessage(-1, "get from server failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.MakeSureVideoInfoSegment.IPullResultCallbackImpl
 * JD-Core Version:    0.7.0.1
 */