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
    int j = 0;
    if (paramGroupId != null)
    {
      i = paramData.jdField_a_of_type_JavaUtilList.indexOf(new IDataProvider.GroupInfo(paramGroupId));
      j = i;
      if (i < 0)
      {
        SLog.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramGroupId });
        j = 0;
      }
    }
    int i1 = j - 1;
    int n = j + 1;
    int k = 0;
    int i = 0;
    int m;
    if (i1 >= 0)
    {
      m = i1;
      for (;;)
      {
        k = i;
        if (m < 0) {
          break label277;
        }
        k = i;
        if (m <= i1 - paramInt1) {
          break label277;
        }
        if (((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramGroupId = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramGroupId)) {
        break label707;
      }
      localResult.jdField_a_of_type_JavaUtilList.add(paramGroupId);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramGroupId = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramGroupId);
      i = k;
      if (b(paramGroupId)) {
        break;
      }
      localResult.a(paramGroupId);
      i = k;
      break;
      i = k;
      if (n < i2)
      {
        i = n;
        paramInt1 = k;
        for (;;)
        {
          k = i;
          i = paramInt1;
          if (k >= i2) {
            break label464;
          }
          i = paramInt1;
          if (k <= n + paramInt2) {
            break label464;
          }
          if (((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramGroupId = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramGroupId)) {
          break label700;
        }
        localResult.jdField_a_of_type_JavaUtilList.add(paramGroupId);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramGroupId = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramGroupId);
        paramInt1 = i;
        if (b(paramGroupId)) {
          break;
        }
        localResult.a(paramGroupId);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramGroupId = ((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramGroupId.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramGroupId.size())
          {
            str = (String)paramGroupId.get(k);
            if ((a(str)) || (localResult.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localResult.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localResult.b.size() < paramInt4)
          {
            str = (String)((IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localResult.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localResult;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localResult;
        }
      }
    }
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
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.indexOf(new IDataProvider.GroupInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId));
    if (i < 0)
    {
      SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId });
      return;
    }
    Object localObject1 = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilMap.get(((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilMap.get(((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(j);
      if (((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilMap.get(((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(i);
      if (((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilMap.get(((IDataProvider.GroupInfo)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (FeedManager)SuperManager.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((FeedManager)localObject2).a(str);
      }
    }
    SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader
 * JD-Core Version:    0.7.0.1
 */