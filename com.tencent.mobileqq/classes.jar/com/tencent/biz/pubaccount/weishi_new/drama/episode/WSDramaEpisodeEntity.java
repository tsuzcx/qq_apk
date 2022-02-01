package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import UserGrowth.stDramaInfo;
import java.util.List;

public class WSDramaEpisodeEntity
{
  private final stDramaInfo jdField_a_of_type_UserGrowthStDramaInfo;
  private final List<WSEpisodeItemData> jdField_a_of_type_JavaUtilList;
  
  public WSDramaEpisodeEntity(List<WSEpisodeItemData> paramList, stDramaInfo paramstDramaInfo)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_UserGrowthStDramaInfo = paramstDramaInfo;
  }
  
  public stDramaInfo a()
  {
    return this.jdField_a_of_type_UserGrowthStDramaInfo;
  }
  
  public List<WSEpisodeItemData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeEntity
 * JD-Core Version:    0.7.0.1
 */