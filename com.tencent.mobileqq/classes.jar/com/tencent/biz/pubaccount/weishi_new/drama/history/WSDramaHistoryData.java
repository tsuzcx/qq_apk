package com.tencent.biz.pubaccount.weishi_new.drama.history;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;

public class WSDramaHistoryData
{
  public stDrama a;
  private boolean b;
  
  public WSDramaHistoryData(stDrama paramstDrama)
  {
    this.a = paramstDrama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public String b()
  {
    stDrama localstDrama = this.a;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.a.dramaInfo.id;
    }
    return "";
  }
  
  public String c()
  {
    stDrama localstDrama = this.a;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.a.dramaInfo.curWatchedFeedID;
    }
    return "";
  }
  
  public int d()
  {
    stDrama localstDrama = this.a;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.a.dramaInfo.curPublishedFeedNum;
    }
    return 0;
  }
  
  public boolean e()
  {
    stDrama localstDrama = this.a;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.a.dramaInfo.isPublishCompleted;
    }
    return false;
  }
  
  public int f()
  {
    stDrama localstDrama = this.a;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.a.dramaInfo.curWatchedFeedNum;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryData
 * JD-Core Version:    0.7.0.1
 */