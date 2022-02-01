package com.tencent.biz.qqstory.shareGroup.infocard;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager.GetFeedVidListObserver;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;

class QQStoryShareGroupProfileActivity$3
  extends ShareGroupManager.GetFeedVidListObserver
{
  QQStoryShareGroupProfileActivity$3(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean)
  {
    VidToSimpleInfoHandler.GetSimpleInfoListEvent localGetSimpleInfoListEvent = new VidToSimpleInfoHandler.GetSimpleInfoListEvent();
    localGetSimpleInfoListEvent.a = paramVideoCollectionItem.collectionId;
    localGetSimpleInfoListEvent.b = paramVideoCollectionItem.collectionVideoUIItemList;
    StoryDispatcher.a().dispatch(localGetSimpleInfoListEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.3
 * JD-Core Version:    0.7.0.1
 */