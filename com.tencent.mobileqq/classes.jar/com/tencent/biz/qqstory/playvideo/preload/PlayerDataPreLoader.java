package com.tencent.biz.qqstory.playvideo.preload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.VideoLocalCacheFilter;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.Data;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.FakeGroupInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.ICallBack;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PlayerDataPreLoader
  implements IDataProvider.ICallBack
{
  private final StoryManager jdField_a_of_type_ComTencentBizQqstoryModelStoryManager;
  public BatchGetVideoInfo.VideoLocalCacheFilter a;
  private IDataProvider.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data;
  private IDataProvider.GroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  private IDataProvider jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider;
  private final FeedManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager;
  private String jdField_a_of_type_JavaLangString;
  
  public PlayerDataPreLoader(IDataProvider paramIDataProvider)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo$VideoLocalCacheFilter = new PlayerDataPreLoader.2(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider = paramIDataProvider;
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager = ((StoryManager)SuperManager.a(5));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
  }
  
  private PlayerDataPreLoader.Result a(IDataProvider.Data paramData, IDataProvider.GroupId paramGroupId, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    PlayerDataPreLoader.Result localResult = new PlayerDataPreLoader.Result();
    if (paramData == null) {
      return localResult;
    }
    int i2 = paramData.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localResult;
    }
    int i;
    int k;
    if (paramGroupId != null)
    {
      i = paramData.jdField_a_of_type_JavaUtilList.indexOf(new IDataProvider.GroupInfo(paramGroupId));
      k = i;
      if (i < 0) {
        SLog.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramGroupId });
      }
    }
    else
    {
      k = 0;
    }
    int n = k - 1;
    int m = k + 1;
    if (n >= 0)
    {
      i = 0;
      int i1;
      for (j = n;; j = i1 - 1)
      {
        i1 = j;
        j = i;
        if (i1 < 0) {
          break;
        }
        j = i;
        if (i1 <= n - paramInt1) {
          break;
        }
        if (((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaUtilList.size() != 0)
        {
          paramGroupId = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaUtilList.get(0);
          j = i;
          if (!a(paramGroupId))
          {
            localResult.jdField_a_of_type_JavaUtilList.add(paramGroupId);
            j = i + 1;
          }
          paramGroupId = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaUtilMap.get(paramGroupId);
          i = j;
          if (!b(paramGroupId))
          {
            localResult.a(paramGroupId);
            i = j;
          }
        }
      }
    }
    int j = 0;
    paramInt1 = j;
    if (m < i2) {
      for (paramInt1 = m;; paramInt1 = i - 1)
      {
        i = paramInt1;
        paramInt1 = j;
        if (i >= i2) {
          break;
        }
        paramInt1 = j;
        if (i <= paramInt2 + m) {
          break;
        }
        if (((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaUtilList.size() != 0)
        {
          paramGroupId = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaUtilList.get(0);
          paramInt1 = j;
          if (!a(paramGroupId))
          {
            localResult.jdField_a_of_type_JavaUtilList.add(paramGroupId);
            paramInt1 = j + 1;
          }
          paramGroupId = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaUtilMap.get(paramGroupId);
          j = paramInt1;
          if (!b(paramGroupId))
          {
            localResult.a(paramGroupId);
            j = paramInt1;
          }
        }
      }
    }
    paramInt2 = k;
    for (j = paramInt1; paramInt2 < i2; j = i)
    {
      paramGroupId = ((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
      if (k == paramInt2)
      {
        m = paramGroupId.indexOf(paramString) - paramInt3;
        i = j;
        paramInt1 = m;
        if (m >= 0) {}
      }
      else
      {
        paramInt1 = 0;
      }
      for (i = j; paramInt1 < paramGroupId.size(); i = j)
      {
        String str = (String)paramGroupId.get(paramInt1);
        j = i;
        if (!a(str))
        {
          j = i;
          if (!localResult.jdField_a_of_type_JavaUtilList.contains(str))
          {
            localResult.jdField_a_of_type_JavaUtilList.add(str);
            j = i + 1;
          }
        }
        if (localResult.b.size() < paramInt4)
        {
          str = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
          if (!b(str)) {
            localResult.a(str);
          }
        }
        if (j > paramInt4) {
          return localResult;
        }
        paramInt1 += 1;
      }
      paramInt2 += 1;
    }
    return localResult;
  }
  
  private void a(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (StoryVideoItem.isFakeVid((String)localIterator.next())) {
        localIterator.remove();
      }
    }
    if (paramList.size() == 0) {
      return;
    }
    SLog.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new VidToBasicInfoHandler(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo$VideoLocalCacheFilter.a(paramString));
  }
  
  private void b(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (FeedItem.isFakeFeedId((String)localIterator.next())) {
        localIterator.remove();
      }
    }
    if (paramList.size() == 0) {
      return;
    }
    SLog.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((FeedManager)SuperManager.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data;
    if ((localObject1 != null) && (((IDataProvider.Data)localObject1).jdField_a_of_type_JavaUtilList.size() != 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId != null) && (this.jdField_a_of_type_JavaLangString != null))
    {
      localObject1 = new ArrayList();
      int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.indexOf(new IDataProvider.GroupInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId));
      if (i < 0)
      {
        SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId });
        return;
      }
      Object localObject2 = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(i);
      int j = ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
      if (j < 0)
      {
        SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
      }
      int k = j + 1;
      if (k < ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.size())
      {
        localObject3 = (String)((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilMap.get(((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.get(k));
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      j -= 1;
      if (j >= 0)
      {
        localObject2 = (String)((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilMap.get(((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.get(j));
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Collection)localObject1).add(localObject2);
        }
      }
      j = i + 1;
      if ((j >= 0) && (j < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.size()))
      {
        localObject2 = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(j);
        if (((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localObject2 = (String)((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilMap.get(((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.get(0));
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((Collection)localObject1).add(localObject2);
          }
        }
      }
      i -= 1;
      if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.size()))
      {
        localObject2 = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(i);
        if (((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localObject2 = (String)((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilMap.get(((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.get(0));
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((Collection)localObject1).add(localObject2);
          }
        }
      }
      localObject2 = new ArrayList();
      Object localObject3 = (FeedManager)SuperManager.a(11);
      Iterator localIterator = ((Collection)localObject1).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject2).contains(str)))
        {
          ((ArrayList)localObject2).add(str);
          ((FeedManager)localObject3).a(str);
        }
      }
      SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localObject1, Integer.valueOf(((ArrayList)localObject2).size()) });
      return;
    }
    SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, 10);
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof IDataProvider.FakeGroupInfo)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader
 * JD-Core Version:    0.7.0.1
 */