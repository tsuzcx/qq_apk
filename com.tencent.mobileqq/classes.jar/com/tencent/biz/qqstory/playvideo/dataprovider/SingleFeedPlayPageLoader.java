package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import java.util.ArrayList;
import java.util.List;

public class SingleFeedPlayPageLoader
  extends FeedIdBasePlayPageLoader<SingleFeedPlayInfo>
{
  public SingleFeedPlayPageLoader(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public FeedIdListSeqInfo a(String paramString)
  {
    paramString = new FeedIdListSeqInfo(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    ArrayList localArrayList = new ArrayList();
    FeedIdBasePlayPageLoader.FeedBaseGroupId localFeedBaseGroupId = new FeedIdBasePlayPageLoader.FeedBaseGroupId(((SingleFeedPlayInfo)this.a).mFeedFeedId, new FeedIdListSeqInfo(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localFeedBaseGroupId.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localFeedBaseGroupId);
    paramCallBack.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SingleFeedPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */