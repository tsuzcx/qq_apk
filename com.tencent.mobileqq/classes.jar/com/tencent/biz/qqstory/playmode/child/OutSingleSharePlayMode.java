package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import npl;

public class OutSingleSharePlayMode
  extends CommentPlayMode
{
  private FriendListObserver b = new npl(this);
  
  public OutSingleSharePlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.a.a.setVisibility(8);
    PlayModeUtils.a().addObserver(this.b);
  }
  
  private void b(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = PlayModeUtils.a();
    if ((((FriendsManager)localQQAppInterface.getManager(50)).c(paramString2) == null) && (TextUtils.equals(paramString1, paramString2))) {
      ((FriendListHandler)localQQAppInterface.a(1)).b(paramString2);
    }
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 19;
    }
    return this.f;
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    super.a(paramVideoViewHolder, paramStoryVideoItem);
    b(PlayModeUtils.a(paramStoryVideoItem.mOwnerUid), String.valueOf(paramStoryVideoItem.mOwnerUid));
  }
  
  public void c()
  {
    super.c();
    PlayModeUtils.a().removeObserver(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.OutSingleSharePlayMode
 * JD-Core Version:    0.7.0.1
 */