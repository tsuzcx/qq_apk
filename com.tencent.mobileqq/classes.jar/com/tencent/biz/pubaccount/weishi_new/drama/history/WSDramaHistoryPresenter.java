package com.tencent.biz.pubaccount.weishi_new.drama.history;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import java.util.ArrayList;
import java.util.List;

public class WSDramaHistoryPresenter
{
  private WSDramaHistoryConstract.View a;
  private WSDramaHistoryDataFetcher b;
  private WSDramaHistoryData c;
  private boolean d;
  private boolean e;
  
  public WSDramaHistoryPresenter(WSDramaHistoryConstract.View paramView)
  {
    this.a = paramView;
    this.b = new WSDramaHistoryDataFetcher();
  }
  
  private List<WSDramaHistoryData> a(List<WSDramaHistoryData> paramList)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((WSDramaHistoryConstract.View)localObject).a() == null) {
        return paramList;
      }
      ArrayList localArrayList = new ArrayList();
      int i = this.a.a().size();
      int j = 0;
      WSDramaHistoryData localWSDramaHistoryData = null;
      if (i > 0) {
        localObject = (WSDramaHistoryData)this.a.a().get(0);
      } else {
        localObject = null;
      }
      i = j;
      if (this.a.a().size() > 1)
      {
        localWSDramaHistoryData = (WSDramaHistoryData)this.a.a().get(1);
        i = j;
      }
      while (i < paramList.size())
      {
        if ((localObject != null) && (TextUtils.equals(((WSDramaHistoryData)localObject).b(), ((WSDramaHistoryData)paramList.get(i)).b()))) {
          localArrayList.add(paramList.get(i));
        }
        if ((localWSDramaHistoryData != null) && (TextUtils.equals(localWSDramaHistoryData.b(), ((WSDramaHistoryData)paramList.get(i)).b()))) {
          localArrayList.add(paramList.get(i));
        }
        i += 1;
      }
      paramList.removeAll(localArrayList);
    }
    return paramList;
  }
  
  private void b(stDrama paramstDrama)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((WSDramaHistoryConstract.View)localObject).a() == null) {
        return;
      }
      if (paramstDrama != null)
      {
        if (paramstDrama.dramaInfo == null) {
          return;
        }
        paramstDrama = new WSDramaHistoryData(paramstDrama);
        ArrayList localArrayList1 = new ArrayList(this.a.a());
        ArrayList localArrayList2 = new ArrayList();
        int i = 0;
        while (i < localArrayList1.size())
        {
          localObject = (WSDramaHistoryData)localArrayList1.get(i);
          if (TextUtils.equals(paramstDrama.b(), ((WSDramaHistoryData)localObject).b()))
          {
            localArrayList2.add(localObject);
            if (((WSDramaHistoryData)localObject).a.dramaInfo.curWatchedFeedNum > paramstDrama.a.dramaInfo.curWatchedFeedNum) {
              paramstDrama = (stDrama)localObject;
            }
          }
          i += 1;
        }
        localArrayList1.removeAll(localArrayList2);
        paramstDrama.a(true);
        localArrayList1.add(0, paramstDrama);
        this.a.a(localArrayList1, this.e);
      }
    }
  }
  
  private void c(stDrama paramstDrama)
  {
    paramstDrama = new WSDramaHistoryData(paramstDrama);
    ArrayList localArrayList = new ArrayList(this.a.a());
    int i = 0;
    int j = 0;
    while (i < localArrayList.size())
    {
      WSDramaHistoryData localWSDramaHistoryData = (WSDramaHistoryData)localArrayList.get(i);
      if (TextUtils.equals(paramstDrama.b(), localWSDramaHistoryData.b())) {
        if (localWSDramaHistoryData.a.dramaInfo.curWatchedFeedNum <= paramstDrama.a.dramaInfo.curWatchedFeedNum)
        {
          j = i;
        }
        else
        {
          j = i;
          paramstDrama = localWSDramaHistoryData;
        }
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      if (j == 0)
      {
        paramstDrama.a(true);
        localArrayList.set(0, paramstDrama);
      }
      else
      {
        paramstDrama.a(false);
        localArrayList.remove(j);
        localArrayList.add(1, paramstDrama);
      }
    }
    this.a.a(localArrayList, this.e);
  }
  
  public stDrama a(stDrama paramstDrama)
  {
    stDrama localstDrama = new stDrama();
    stDramaInfo localstDramaInfo = new stDramaInfo();
    localstDramaInfo.id = paramstDrama.dramaInfo.id;
    localstDramaInfo.name = paramstDrama.dramaInfo.name;
    localstDramaInfo.recmdDesc = paramstDrama.dramaInfo.recmdDesc;
    localstDramaInfo.coverImg = paramstDrama.dramaInfo.coverImg;
    localstDramaInfo.tag = paramstDrama.dramaInfo.tag;
    localstDramaInfo.isPublishCompleted = paramstDrama.dramaInfo.isPublishCompleted;
    localstDramaInfo.isFollowed = paramstDrama.dramaInfo.isFollowed;
    localstDramaInfo.playCount = paramstDrama.dramaInfo.playCount;
    localstDramaInfo.curPublishedFeedNum = paramstDrama.dramaInfo.curPublishedFeedNum;
    localstDramaInfo.curWatchedFeedNum = paramstDrama.dramaInfo.curWatchedFeedNum;
    localstDramaInfo.curWatchedFeedID = paramstDrama.dramaInfo.curWatchedFeedID;
    localstDrama.dramaInfo = localstDramaInfo;
    localstDrama.tagIcon = paramstDrama.tagIcon;
    return localstDrama;
  }
  
  public void a(stDrama paramstDrama, boolean paramBoolean)
  {
    this.c = new WSDramaHistoryData(paramstDrama);
    this.c.a(paramBoolean);
    this.d = paramBoolean;
    if (paramBoolean)
    {
      b(paramstDrama);
      return;
    }
    c(paramstDrama);
  }
  
  public void a(FetcherParams paramFetcherParams)
  {
    this.b.a(paramFetcherParams, new WSDramaHistoryPresenter.1(this, paramFetcherParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryPresenter
 * JD-Core Version:    0.7.0.1
 */