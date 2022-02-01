package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed.StoryVideoListComp;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class FeedIdBasePlayPageLoader$HomeFeedVidFullSyncer
  implements IGroupPageLoader.IVidFullSyncer
{
  private int jdField_a_of_type_Int;
  private final FeedIdBasePlayPageLoader.FeedBaseGroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId;
  private IGroupPageLoader.IVidFullSyncer.CallBack jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private VideoListPageLoader jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader;
  protected final FeedVideoManager a;
  
  public FeedIdBasePlayPageLoader$HomeFeedVidFullSyncer(FeedIdBasePlayPageLoader.FeedBaseGroupId paramFeedBaseGroupId, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId = paramFeedBaseGroupId;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager = ((FeedVideoManager)SuperManager.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, IDataProvider.GroupId paramGroupId)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramGroupId);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if (!paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramGetVideoListEvent);
      return;
    }
    if (paramGetVideoListEvent.c) {
      paramList.clear();
    }
    paramList.addAll(paramGetVideoListEvent.jdField_a_of_type_JavaUtilList);
    SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramGetVideoListEvent.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramGetVideoListEvent.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.c();
      return;
    }
    b(paramList, paramGetVideoListEvent);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader = new VideoListPageLoader(1, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader = new VideoListPageLoader(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.a(new FeedIdBasePlayPageLoader.HomeFeedVidFullSyncer.1(this, paramList));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.c();
      SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = FeedIdBasePlayPageLoader.a(paramList, paramString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack.a(paramString, true);
  }
  
  private void b(List<StoryVideoItem> paramList, VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId);
      return;
    }
    if (paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramGetVideoListEvent.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId.a.b))
    {
      if (FeedIdBasePlayPageLoader.a() == null) {
        FeedIdBasePlayPageLoader.c(((StoryManager)SuperManager.a(5)).a(true));
      }
      if (FeedIdBasePlayPageLoader.a().size() != 0)
      {
        localIterator = FeedIdBasePlayPageLoader.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId.a.c))
          {
            SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new VideoListHomeFeed.StoryVideoListComp(bool));
      localIterator = paramList.iterator();
      paramList = new ArrayList(paramList.size());
      while (localIterator.hasNext())
      {
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
        if (!paramList.contains(localStoryVideoItem)) {
          paramList.add(localStoryVideoItem);
        }
      }
    }
    paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((FeedVideoManager)SuperManager.a(12)).a(1, paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramGetVideoListEvent.jdField_a_of_type_Boolean, paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramGetVideoListEvent.jdField_a_of_type_JavaLangString);
  }
  
  public void a(IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack = paramCallBack;
    int i = FeedIdBasePlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramCallBack = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderFeedIdBasePlayPageLoader$FeedBaseGroupId.a.jdField_a_of_type_JavaLangString, i);
    if ((paramCallBack != null) && (paramCallBack.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramCallBack.mVideoItemList;
      paramCallBack = paramCallBack.feedId;
      SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramCallBack);
      a((List)localObject, paramCallBack);
      return;
    }
    a((List)localObject, paramCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.FeedIdBasePlayPageLoader.HomeFeedVidFullSyncer
 * JD-Core Version:    0.7.0.1
 */