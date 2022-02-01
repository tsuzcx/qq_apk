package com.tencent.biz.pubaccount.weishi_new.drama.history;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;

public class WSDramaHistoryData
{
  public stDrama a;
  private boolean a;
  
  public WSDramaHistoryData(stDrama paramstDrama)
  {
    this.jdField_a_of_type_UserGrowthStDrama = paramstDrama;
  }
  
  public int a()
  {
    stDrama localstDrama = this.jdField_a_of_type_UserGrowthStDrama;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.curPublishedFeedNum;
    }
    return 0;
  }
  
  public String a()
  {
    stDrama localstDrama = this.jdField_a_of_type_UserGrowthStDrama;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.id;
    }
    return "";
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    stDrama localstDrama = this.jdField_a_of_type_UserGrowthStDrama;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.curWatchedFeedNum;
    }
    return 0;
  }
  
  public String b()
  {
    stDrama localstDrama = this.jdField_a_of_type_UserGrowthStDrama;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.curWatchedFeedID;
    }
    return "";
  }
  
  public boolean b()
  {
    stDrama localstDrama = this.jdField_a_of_type_UserGrowthStDrama;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.isPublishCompleted;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryData
 * JD-Core Version:    0.7.0.1
 */