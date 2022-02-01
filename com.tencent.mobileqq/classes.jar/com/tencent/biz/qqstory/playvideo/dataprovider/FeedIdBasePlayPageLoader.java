package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.DateUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class FeedIdBasePlayPageLoader<INFO extends FeedBasePlayInfo>
  extends IGroupPageLoader.BaseGroupPageLoader
{
  private static List<StoryVideoItem> d;
  final INFO a;
  public FeedListPageLoaderBase.FeedIdListCache b;
  private int c = 0;
  
  public FeedIdBasePlayPageLoader(INFO paramINFO)
  {
    this.a = paramINFO;
    AssertUtils.checkNotNull(this.a);
  }
  
  private static int b(FeedIdBasePlayPageLoader.FeedBaseGroupId paramFeedBaseGroupId, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    if (paramFeedBaseGroupId.a == null) {
      return 0;
    }
    int k = paramFeedBaseGroupId.a.h;
    int i = k;
    int j;
    if (k == -1) {
      j = DateUtils.a(paramFeedBaseGroupId.a.d) ^ true;
    }
    k = j;
    if (paramFeedBasePlayInfo.mForcePlayVidFromOld2New)
    {
      k = j;
      if (paramFeedBaseGroupId.equals(new FeedIdBasePlayPageLoader.FeedBaseGroupId(paramFeedBasePlayInfo.mFeedFeedId, null))) {
        k = 1;
      }
    }
    return k;
  }
  
  @NonNull
  private static IDataProvider.GroupInfo b(List<StoryVideoItem> paramList, String paramString, FeedIdBasePlayPageLoader.FeedBaseGroupId paramFeedBaseGroupId)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.get(i);
      String str = localStoryVideoItem.mVid;
      localArrayList.add(str);
      if (!TextUtils.isEmpty(localStoryVideoItem.mAttachedFeedId)) {
        localHashMap.put(str, localStoryVideoItem.mAttachedFeedId);
      } else {
        localHashMap.put(str, paramString);
      }
      i += 1;
    }
    paramList = new IDataProvider.GroupInfo(paramFeedBaseGroupId);
    paramList.c = localArrayList;
    paramList.d = localHashMap;
    SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return group=%s vid %d, list %s", paramFeedBaseGroupId, Integer.valueOf(localArrayList.size()), localArrayList);
    return paramList;
  }
  
  @NonNull
  static List<IDataProvider.GroupId> b(List<FeedIdListSeqInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)paramList.next();
      if (localFeedIdListSeqInfo.f) {
        localArrayList.add(new FeedIdBasePlayPageLoader.FeedBaseGroupId(localFeedIdListSeqInfo.a, localFeedIdListSeqInfo));
      } else {
        SLog.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "ignore feed:%s for not playable", new Object[] { localFeedIdListSeqInfo.a });
      }
    }
    return localArrayList;
  }
  
  public FeedIdListSeqInfo a(String paramString)
  {
    return null;
  }
  
  public List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new FeedIdBasePlayPageLoader.HomeFeedVidFullSyncer((FeedIdBasePlayPageLoader.FeedBaseGroupId)paramList.next(), this.a));
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    boolean bool;
    if (this.c == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.c += 1;
    a(bool, paramInt, paramCallBack);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, IGroupPageLoader.CallBack paramCallBack);
  
  public void b() {}
  
  public IDataProvider.StartInfo c()
  {
    boolean bool = TextUtils.isEmpty(this.a.mFeedFeedId);
    Object localObject4 = null;
    FeedIdBasePlayPageLoader.FeedBaseGroupId localFeedBaseGroupId;
    if (!bool) {
      localFeedBaseGroupId = new FeedIdBasePlayPageLoader.FeedBaseGroupId(this.a.mFeedFeedId, a(this.a.mFeedFeedId));
    } else {
      localFeedBaseGroupId = null;
    }
    Object localObject5 = this.a.mStartVid;
    Object localObject3 = this.a.mStartVideoFeedId;
    Object localObject2 = localObject5;
    Object localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject5))
    {
      localObject2 = localObject5;
      localObject1 = localObject3;
      if (this.a.mForcePlayVidFromOld2New)
      {
        FeedVideoInfo localFeedVideoInfo = ((FeedVideoManager)SuperManager.a(12)).a(this.a.mFeedFeedId, 1);
        localObject2 = localObject5;
        localObject1 = localObject3;
        if (localFeedVideoInfo != null)
        {
          localObject2 = ((StoryVideoItem)localFeedVideoInfo.mVideoItemList.get(0)).mVid;
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            if (!TextUtils.isEmpty(((StoryVideoItem)localFeedVideoInfo.mVideoItemList.get(0)).mAttachedFeedId)) {
              localObject1 = ((StoryVideoItem)localFeedVideoInfo.mVideoItemList.get(0)).mAttachedFeedId;
            } else {
              localObject1 = this.a.mFeedFeedId;
            }
          }
          SLog.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start vid:%s feedId:%s", new Object[] { localObject2, localObject1 });
        }
      }
    }
    localObject3 = localObject4;
    if (localFeedBaseGroupId != null)
    {
      localObject3 = localObject4;
      if (localFeedBaseGroupId.a != null)
      {
        int i = b(localFeedBaseGroupId, this.a);
        localObject5 = ((FeedVideoManager)SuperManager.a(12)).a(this.a.mFeedFeedId, i);
        localObject3 = localObject4;
        if (localObject5 != null)
        {
          localObject3 = localObject4;
          if (((FeedVideoInfo)localObject5).mIsVideoEnd)
          {
            localObject3 = localObject4;
            if (!this.a.mForceNotUseVidCache)
            {
              localObject3 = b(((FeedVideoInfo)localObject5).mVideoItemList, ((FeedVideoInfo)localObject5).feedId, localFeedBaseGroupId);
              SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start hit group info cache %s", localObject3);
            }
          }
        }
      }
    }
    localObject1 = new IDataProvider.StartInfo(localFeedBaseGroupId, (String)localObject2, (String)localObject1);
    ((IDataProvider.StartInfo)localObject1).d = ((IDataProvider.GroupInfo)localObject3);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.FeedIdBasePlayPageLoader
 * JD-Core Version:    0.7.0.1
 */