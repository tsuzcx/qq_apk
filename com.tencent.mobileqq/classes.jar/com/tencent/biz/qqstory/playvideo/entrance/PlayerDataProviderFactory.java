package com.tencent.biz.qqstory.playvideo.entrance;

import com.tencent.biz.qqstory.playvideo.dataprovider.DiscoverBannerPlayPageLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.HomeFeedPlayPageLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.HotRecommendFeedPlayPagerLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider;
import com.tencent.biz.qqstory.playvideo.dataprovider.MemoriesFeedPlayPageLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.MemorySelectVideoPageLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.ProfileFeedPlayPageLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.ShareFromMemoryPlayPageLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider;
import com.tencent.biz.qqstory.playvideo.dataprovider.SingleFeedPlayPageLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.TroopAssistantHomeFeedPlayPageLoader;
import com.tencent.biz.qqstory.playvideo.dataprovider.VidListDataProvider;
import com.tencent.biz.qqstory.playvideo.dataprovider.VidListPlayPageLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;

public class PlayerDataProviderFactory
{
  public static IDataProvider a(Object paramObject)
  {
    SLog.d("Q.qqstory.player.data.SimpleDataProvider", "play info:%s", new Object[] { paramObject });
    if ((paramObject instanceof HomeFeedPlayInfo)) {
      return new SimpleDataProvider(new HomeFeedPlayPageLoader((HomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAssistantHomeFeedPlayInfo)) {
      return new SimpleDataProvider(new TroopAssistantHomeFeedPlayPageLoader((TroopAssistantHomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof ProfileFeedPlayInfo)) {
      return new SimpleDataProvider(new ProfileFeedPlayPageLoader((ProfileFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof SingleFeedPlayInfo)) {
      return new SimpleDataProvider(new SingleFeedPlayPageLoader((SingleFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof MsgTabPlayInfo)) {
      return new SimpleDataProvider(new MsgTabPlayPageLoader((MsgTabPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemoriesFeedPlayInfo)) {
      return new SimpleDataProvider(new MemoriesFeedPlayPageLoader((MemoriesFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof HotRecommendFeedPlayInfo)) {
      return new SimpleDataProvider(new HotRecommendFeedPlayPagerLoader((HotRecommendFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof VidListPlayInfo)) {
      return new SimpleDataProvider(new VidListPlayPageLoader((VidListPlayInfo)paramObject));
    }
    if ((paramObject instanceof DiscoverBannerPlayInfo)) {
      return new SimpleDataProvider(new DiscoverBannerPlayPageLoader((DiscoverBannerPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAIOPlayInfo)) {
      return new VidListDataProvider(((TroopAIOPlayInfo)paramObject).storyId);
    }
    if ((paramObject instanceof ShareFromMemoryPlayInfo)) {
      return new SimpleDataProvider(new ShareFromMemoryPlayPageLoader((ShareFromMemoryPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemorySelectVideoPlayInfo)) {
      return new SimpleDataProvider(new MemorySelectVideoPageLoader((MemorySelectVideoPlayInfo)paramObject));
    }
    AssertUtils.a("play info unknown", new Object[0]);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.PlayerDataProviderFactory
 * JD-Core Version:    0.7.0.1
 */