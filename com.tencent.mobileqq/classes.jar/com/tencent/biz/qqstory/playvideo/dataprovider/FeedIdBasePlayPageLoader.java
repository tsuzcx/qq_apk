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
  private static List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  private int jdField_a_of_type_Int = 0;
  final INFO jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  public FeedListPageLoaderBase.FeedIdListCache a;
  
  public FeedIdBasePlayPageLoader(INFO paramINFO)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramINFO;
    AssertUtils.checkNotNull(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
  }
  
  private static int b(FeedIdBasePlayPageLoader.FeedBaseGroupId paramFeedBaseGroupId, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    if (paramFeedBaseGroupId.a == null) {
      return 0;
    }
    int k = paramFeedBaseGroupId.a.b;
    int i = k;
    int j;
    if (k == -1) {
      j = DateUtils.a(paramFeedBaseGroupId.a.c) ^ true;
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
    paramList.jdField_a_of_type_JavaUtilList = localArrayList;
    paramList.jdField_a_of_type_JavaUtilMap = localHashMap;
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
      if (localFeedIdListSeqInfo.jdField_a_of_type_Boolean) {
        localArrayList.add(new FeedIdBasePlayPageLoader.FeedBaseGroupId(localFeedIdListSeqInfo.jdField_a_of_type_JavaLangString, localFeedIdListSeqInfo));
      } else {
        SLog.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "ignore feed:%s for not playable", new Object[] { localFeedIdListSeqInfo.jdField_a_of_type_JavaLangString });
      }
    }
    return localArrayList;
  }
  
  public IDataProvider.StartInfo a()
  {
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId);
    Object localObject4 = null;
    FeedIdBasePlayPageLoader.FeedBaseGroupId localFeedBaseGroupId;
    if (!bool) {
      localFeedBaseGroupId = new FeedIdBasePlayPageLoader.FeedBaseGroupId(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId));
    } else {
      localFeedBaseGroupId = null;
    }
    Object localObject5 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mStartVid;
    Object localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mStartVideoFeedId;
    Object localObject2 = localObject5;
    Object localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject5))
    {
      localObject2 = localObject5;
      localObject1 = localObject3;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForcePlayVidFromOld2New)
      {
        FeedVideoInfo localFeedVideoInfo = ((FeedVideoManager)SuperManager.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, 1);
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
              localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId;
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
        int i = b(localFeedBaseGroupId, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
        localObject5 = ((FeedVideoManager)SuperManager.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, i);
        localObject3 = localObject4;
        if (localObject5 != null)
        {
          localObject3 = localObject4;
          if (((FeedVideoInfo)localObject5).mIsVideoEnd)
          {
            localObject3 = localObject4;
            if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache)
            {
              localObject3 = b(((FeedVideoInfo)localObject5).mVideoItemList, ((FeedVideoInfo)localObject5).feedId, localFeedBaseGroupId);
              SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start hit group info cache %s", localObject3);
            }
          }
        }
      }
    }
    localObject1 = new IDataProvider.StartInfo(localFeedBaseGroupId, (String)localObject2, (String)localObject1);
    ((IDataProvider.StartInfo)localObject1).a = ((IDataProvider.GroupInfo)localObject3);
    return localObject1;
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
      localArrayList.add(new FeedIdBasePlayPageLoader.HomeFeedVidFullSyncer((FeedIdBasePlayPageLoader.FeedBaseGroupId)paramList.next(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo));
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    boolean bool;
    if (this.jdField_a_of_type_Int == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Int += 1;
    a(bool, paramInt, paramCallBack);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, IGroupPageLoader.CallBack paramCallBack);
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.FeedIdBasePlayPageLoader
 * JD-Core Version:    0.7.0.1
 */