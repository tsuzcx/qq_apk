package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import java.util.ArrayList;
import java.util.List;

public class HotRecommendFeedPlayPagerLoader
  extends FeedIdBasePlayPageLoader<HotRecommendFeedPlayInfo>
{
  public HotRecommendFeedPlayPagerLoader(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public FeedIdListSeqInfo a(String paramString)
  {
    paramString = new FeedIdListSeqInfo(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    ArrayList localArrayList = new ArrayList();
    FeedIdBasePlayPageLoader.FeedBaseGroupId localFeedBaseGroupId = new FeedIdBasePlayPageLoader.FeedBaseGroupId(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new FeedIdListSeqInfo(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localFeedBaseGroupId.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localFeedBaseGroupId);
    paramCallBack.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.HotRecommendFeedPlayPagerLoader
 * JD-Core Version:    0.7.0.1
 */