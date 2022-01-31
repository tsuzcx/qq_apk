package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShareGroupMultiSharePlayMode
  extends CommentPlayMode
{
  protected String h;
  protected int l;
  
  public ShareGroupMultiSharePlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.h = paramBundle.getString("extra_share_time");
    this.l = paramBundle.getInt("extra_share_time_zone");
    this.jdField_j_of_type_Int = 1;
    b(2);
    this.p = 1;
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 96;
    }
    return this.f;
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager.a(this.g, this.p);
    if ((paramBundle != null) && (paramBundle.mIsVideoEnd) && (this.n))
    {
      int i = 0;
      while (i < paramBundle.mVideoItemList.size())
      {
        if (!StoryVideoItem.isFakeVid(((StoryVideoItem)paramBundle.mVideoItemList.get(i)).mVid)) {
          this.d.add(((StoryVideoItem)paramBundle.mVideoItemList.get(i)).mVid);
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler = new BatchGetVideoInfoHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.d, this.e);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a(a(this.jdField_j_of_type_JavaLangString));
      if (!TextUtils.isEmpty(this.g)) {
        GetFeedFeatureHandler.a(Collections.singletonList(this.g));
      }
      return;
    }
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.NewFriendsPlayMode", 2, "feedVideoInfo is null. no videoseq.");
      }
    }
    for (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader = new VideoListPageLoader(1, this.g, this.p, -1);; this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader = new VideoListPageLoader(1, this.g, this.p, paramBundle.mVideoSeq))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.b(this.i);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.c();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.ShareGroupMultiSharePlayMode
 * JD-Core Version:    0.7.0.1
 */