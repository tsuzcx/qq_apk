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
  private final stDrama jdField_a_of_type_UserGrowthStDrama;
  private stDramaFeed jdField_a_of_type_UserGrowthStDramaFeed;
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public WSDramaItemData(stDrama paramstDrama)
  {
    this.jdField_a_of_type_UserGrowthStDrama = paramstDrama;
  }
  
  public int a()
  {
    stDramaFeed localstDramaFeed = this.jdField_a_of_type_UserGrowthStDramaFeed;
    if (localstDramaFeed != null) {
      return localstDramaFeed.num;
    }
    return 0;
  }
  
  public stDrama a()
  {
    return this.jdField_a_of_type_UserGrowthStDrama;
  }
  
  public stDramaFeed a()
  {
    return this.jdField_a_of_type_UserGrowthStDramaFeed;
  }
  
  public stSimpleMetaFeed a()
  {
    stDramaFeed localstDramaFeed = this.jdField_a_of_type_UserGrowthStDramaFeed;
    if (localstDramaFeed != null) {
      return localstDramaFeed.feed;
    }
    return null;
  }
  
  public String a()
  {
    stDrama localstDrama = this.jdField_a_of_type_UserGrowthStDrama;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null)) {
      return this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.id;
    }
    return "";
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(stDramaFeed paramstDramaFeed)
  {
    this.jdField_a_of_type_UserGrowthStDramaFeed = paramstDramaFeed;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    stDramaFeed localstDramaFeed = this.jdField_a_of_type_UserGrowthStDramaFeed;
    if (localstDramaFeed != null) {
      localstDramaFeed.feed = paramstSimpleMetaFeed;
    }
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    if ((localstDrama != null) && (localstDrama.dramaInfo != null) && (this.jdField_a_of_type_UserGrowthStDramaFeed != null)) {
      return this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.curPublishedFeedNum;
    }
    return 0;
  }
  
  public String b()
  {
    stDramaFeed localstDramaFeed = this.jdField_a_of_type_UserGrowthStDramaFeed;
    if ((localstDramaFeed != null) && (localstDramaFeed.feed != null)) {
      return this.jdField_a_of_type_UserGrowthStDramaFeed.feed.id;
    }
    return "";
  }
  
  public boolean b()
  {
    stDrama localstDrama = this.jdField_a_of_type_UserGrowthStDrama;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localstDrama != null)
    {
      bool1 = bool2;
      if (localstDrama.dramaInfo != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_UserGrowthStDramaFeed != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.curPublishedFeedNum == this.jdField_a_of_type_UserGrowthStDramaFeed.num) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int c()
  {
    stDrama localstDrama = this.jdField_a_of_type_UserGrowthStDrama;
    if ((localstDrama != null) && (localstDrama.dramaInfo != null) && (this.jdField_a_of_type_UserGrowthStDramaFeed != null)) {
      return this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.curWatchedFeedNum;
    }
    return 0;
  }
  
  public String c()
  {
    stDramaFeed localstDramaFeed = this.jdField_a_of_type_UserGrowthStDramaFeed;
    if ((localstDramaFeed != null) && (localstDramaFeed.feed != null) && (this.jdField_a_of_type_UserGrowthStDramaFeed.feed.poster != null)) {
      return this.jdField_a_of_type_UserGrowthStDramaFeed.feed.poster.id;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData
 * JD-Core Version:    0.7.0.1
 */