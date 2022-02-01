package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import UserGrowth.stDramaFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.Checkable;

public class WSEpisodeItemData
  implements Checkable
{
  private stDramaFeed a;
  private String b;
  private String c;
  private int d;
  private boolean e;
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public String d()
  {
    stDramaFeed localstDramaFeed = this.a;
    if ((localstDramaFeed != null) && (localstDramaFeed.feed != null) && (this.a.feed.poster != null)) {
      return this.a.feed.poster.id;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData
 * JD-Core Version:    0.7.0.1
 */