package com.tencent.biz.pubaccount.weishi_new.drama.data;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.Checkable;
import java.util.List;

public class WSDramaItemData
  implements Checkable
{
  private final stDrama a;
  private stDramaFeed b;
  private List<String> c;
  private boolean d;
  
  public WSDramaItemData(stDrama paramstDrama)
  {
    this.a = paramstDrama;
  }
  
  public void a(stDramaFeed paramstDramaFeed)
  {
    this.b = paramstDramaFeed;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    stDramaFeed localstDramaFeed = this.b;
    if (localstDramaFeed != null) {
      localstDramaFeed.feed = paramstSimpleMetaFeed;
    }
  }
  
  public void a(List<String> paramList)
  {
    this.c = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public String b()
  {
    stDrama localstDrama = this.a;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.a.dramaInfo.id;
    }
    return "";
  }
  
  public int c()
  {
    stDramaFeed localstDramaFeed = this.b;
    if (localstDramaFeed != null) {
      return localstDramaFeed.num;
    }
    return 0;
  }
  
  public String d()
  {
    stDramaFeed localstDramaFeed = this.b;
    if ((localstDramaFeed != null) && (localstDramaFeed.feed != null)) {
      return this.b.feed.id;
    }
    return "";
  }
  
  public String e()
  {
    stDramaFeed localstDramaFeed = this.b;
    if ((localstDramaFeed != null) && (localstDramaFeed.feed != null) && (this.b.feed.poster != null)) {
      return this.b.feed.poster.id;
    }
    return "";
  }
  
  public stDrama f()
  {
    return this.a;
  }
  
  public stDramaFeed g()
  {
    return this.b;
  }
  
  public List<String> h()
  {
    return this.c;
  }
  
  public stSimpleMetaFeed i()
  {
    stDramaFeed localstDramaFeed = this.b;
    if (localstDramaFeed != null) {
      return localstDramaFeed.feed;
    }
    return null;
  }
  
  public boolean j()
  {
    stDrama localstDrama = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localstDrama != null)
    {
      bool1 = bool2;
      if (localstDrama.dramaInfo != null)
      {
        bool1 = bool2;
        if (this.b != null)
        {
          bool1 = bool2;
          if (this.a.dramaInfo.curPublishedFeedNum == this.b.num) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int k()
  {
    stDrama localstDrama = this.a;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null) && (this.b != null)) {
      return this.a.dramaInfo.curPublishedFeedNum;
    }
    return 0;
  }
  
  public int l()
  {
    stDrama localstDrama = this.a;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null) && (this.b != null)) {
      return this.a.dramaInfo.curWatchedFeedNum;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData
 * JD-Core Version:    0.7.0.1
 */