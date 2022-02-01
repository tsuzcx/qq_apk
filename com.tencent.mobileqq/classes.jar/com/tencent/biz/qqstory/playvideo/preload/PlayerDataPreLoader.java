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
  public BatchGetVideoInfo.VideoLocalCacheFilter a = new PlayerDataPreLoader.2(this);
  private IDataProvider b;
  private IDataProvider.GroupId c;
  private String d;
  private final StoryManager e;
  private final FeedManager f;
  private IDataProvider.Data g;
  
  public PlayerDataPreLoader(IDataProvider paramIDataProvider)
  {
    this.b = paramIDataProvider;
    this.e = ((StoryManager)SuperManager.a(5));
    this.f = ((FeedManager)SuperManager.a(11));
  }
  
  private PlayerDataPreLoader.Result a(IDataProvider.Data paramData, IDataProvider.GroupId paramGroupId, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    PlayerDataPreLoader.Result localResult = new PlayerDataPreLoader.Result();
    if (paramData == null) {
      return localResult;
    }
    int i2 = paramData.c.size();
    if (i2 == 0) {
      return localResult;
    }
    int i;
    int k;
    if (paramGroupId != null)
    {
      i = paramData.c.indexOf(new IDataProvider.GroupInfo(paramGroupId));
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
        if (((IDataProvider.GroupInfo)paramData.c.get(i1)).c.size() != 0)
        {
          paramGroupId = (String)((IDataProvider.GroupInfo)paramData.c.get(i1)).c.get(0);
          j = i;
          if (!a(paramGroupId))
          {
            localResult.a.add(paramGroupId);
            j = i + 1;
          }
          paramGroupId = (String)((IDataProvider.GroupInfo)paramData.c.get(i1)).d.get(paramGroupId);
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
        if (((IDataProvider.GroupInfo)paramData.c.get(i)).c.size() != 0)
        {
          paramGroupId = (String)((IDataProvider.GroupInfo)paramData.c.get(i)).c.get(0);
          paramInt1 = j;
          if (!a(paramGroupId))
          {
            localResult.a.add(paramGroupId);
            paramInt1 = j + 1;
          }
          paramGroupId = (String)((IDataProvider.GroupInfo)paramData.c.get(i)).d.get(paramGroupId);
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
      paramGroupId = ((IDataProvider.GroupInfo)paramData.c.get(paramInt2)).c;
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
          if (!localResult.a.contains(str))
          {
            localResult.a.add(str);
            j = i + 1;
          }
        }
        if (localResult.b.size() < paramInt4)
        {
          str = (String)((IDataProvider.GroupInfo)paramData.c.get(paramInt2)).d.get(str);
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
    paramString = this.e.a(paramString);
    return (paramString != null) && (!this.a.a(paramString));
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
    ((FeedManager)SuperManager.a(11)).d(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.f.b(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    Object localObject1 = this.g;
    if ((localObject1 != null) && (((IDataProvider.Data)localObject1).c.size() != 0) && (this.c != null) && (this.d != null))
    {
      localObject1 = new ArrayList();
      int i = this.g.c.indexOf(new IDataProvider.GroupInfo(this.c));
      if (i < 0)
      {
        SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.c });
        return;
      }
      Object localObject2 = (IDataProvider.GroupInfo)this.g.c.get(i);
      int j = ((IDataProvider.GroupInfo)localObject2).c.indexOf(this.d);
      if (j < 0)
      {
        SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.d });
        return;
      }
      int k = j + 1;
      if (k < ((IDataProvider.GroupInfo)localObject2).c.size())
      {
        localObject3 = (String)((IDataProvider.GroupInfo)localObject2).d.get(((IDataProvider.GroupInfo)localObject2).c.get(k));
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      j -= 1;
      if (j >= 0)
      {
        localObject2 = (String)((IDataProvider.GroupInfo)localObject2).d.get(((IDataProvider.GroupInfo)localObject2).c.get(j));
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Collection)localObject1).add(localObject2);
        }
      }
      j = i + 1;
      if ((j >= 0) && (j < this.g.c.size()))
      {
        localObject2 = (IDataProvider.GroupInfo)this.g.c.get(j);
        if (((IDataProvider.GroupInfo)localObject2).c.size() > 0)
        {
          localObject2 = (String)((IDataProvider.GroupInfo)localObject2).d.get(((IDataProvider.GroupInfo)localObject2).c.get(0));
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((Collection)localObject1).add(localObject2);
          }
        }
      }
      i -= 1;
      if ((i >= 0) && (i < this.g.c.size()))
      {
        localObject2 = (IDataProvider.GroupInfo)this.g.c.get(i);
        if (((IDataProvider.GroupInfo)localObject2).c.size() > 0)
        {
          localObject2 = (String)((IDataProvider.GroupInfo)localObject2).d.get(((IDataProvider.GroupInfo)localObject2).c.get(0));
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
          ((FeedManager)localObject3).g(str);
        }
      }
      SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localObject1, Integer.valueOf(((ArrayList)localObject2).size()) });
      return;
    }
    SLog.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
  }
  
  public void a()
  {
    this.g = this.b.a(this.c, 10);
    Iterator localIterator = this.g.c.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof IDataProvider.FakeGroupInfo)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString)
  {
    this.c = paramGroupId;
    this.d = paramString;
    d();
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.b.a(this);
  }
  
  public void c()
  {
    this.b.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader
 * JD-Core Version:    0.7.0.1
 */