package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeEntity;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class WSDramaDataModule
{
  private final Map<String, WSDramaItemData> a = new HashMap();
  private final Map<String, List<String>> b = new HashMap();
  private final Map<String, Map<Integer, stDramaFeed>> c = new HashMap();
  
  @NotNull
  private WSEpisodeItemData a(int paramInt1, int paramInt2, String paramString)
  {
    WSEpisodeItemData localWSEpisodeItemData = new WSEpisodeItemData();
    localWSEpisodeItemData.b(paramString);
    localWSEpisodeItemData.a(paramString);
    boolean bool = true;
    paramInt2 += 1;
    localWSEpisodeItemData.a(paramInt2);
    if (paramInt2 != paramInt1) {
      bool = false;
    }
    localWSEpisodeItemData.a(bool);
    return localWSEpisodeItemData;
  }
  
  private void a(stDramaInfo paramstDramaInfo, List<String> paramList)
  {
    if (paramstDramaInfo != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (paramstDramaInfo.curWatchedFeedNum <= 0)
      {
        paramstDramaInfo.curWatchedFeedNum = 1;
        paramstDramaInfo.curWatchedFeedID = ((String)paramList.get(0));
      }
      if (paramstDramaInfo.curWatchedFeedNum > paramstDramaInfo.curPublishedFeedNum)
      {
        paramstDramaInfo.curWatchedFeedNum = paramstDramaInfo.curPublishedFeedNum;
        paramstDramaInfo.curWatchedFeedID = ((String)paramList.get(paramList.size() - 1));
      }
    }
  }
  
  WSDramaItemData a(String paramString)
  {
    return (WSDramaItemData)this.a.get(paramString);
  }
  
  WSDramaEpisodeEntity a(String paramString)
  {
    List localList = a(paramString);
    paramString = a(paramString);
    int i;
    if (paramString != null)
    {
      paramString = paramString.a().dramaInfo;
      i = paramString.curWatchedFeedNum;
      a(paramString, localList);
    }
    else
    {
      paramString = null;
      i = 0;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < localList.size())
    {
      localArrayList.add(a(i, j, (String)localList.get(j)));
      j += 1;
    }
    if ((i == 0) && (localArrayList.size() > 0)) {
      ((WSEpisodeItemData)localArrayList.get(0)).a(true);
    }
    return new WSDramaEpisodeEntity(localArrayList, paramString);
  }
  
  List<String> a(String paramString)
  {
    List localList = (List)this.b.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.b.put(paramString, localObject);
    }
    return localObject;
  }
  
  Map<Integer, stDramaFeed> a(String paramString)
  {
    Map localMap = (Map)this.c.get(paramString);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.c.put(paramString, localObject);
    }
    return localObject;
  }
  
  void a()
  {
    this.b.clear();
    this.c.clear();
    this.a.clear();
  }
  
  void a(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.a() != null))
    {
      if (paramString.a().dramaInfo == null) {
        return;
      }
      paramString.a().dramaInfo.curWatchedFeedNum = paramInt;
    }
  }
  
  void a(List<WSDramaItemData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (WSDramaItemData)paramList.next();
      String str = ((WSDramaItemData)localObject).a();
      this.b.put(str, ((WSDramaItemData)localObject).a());
      this.a.put(str, localObject);
      localObject = ((WSDramaItemData)localObject).a();
      if (localObject != null) {
        a(str).put(Integer.valueOf(((stDramaFeed)localObject).num), localObject);
      }
    }
  }
  
  void a(List<stDramaFeed> paramList, String paramString)
  {
    paramString = a(paramString);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stDramaFeed localstDramaFeed = (stDramaFeed)paramList.next();
      paramString.put(Integer.valueOf(localstDramaFeed.num), localstDramaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataModule
 * JD-Core Version:    0.7.0.1
 */