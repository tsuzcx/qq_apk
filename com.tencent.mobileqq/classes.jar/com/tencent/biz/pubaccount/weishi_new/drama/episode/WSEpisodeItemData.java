package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import UserGrowth.stDramaFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.Checkable;

public class WSEpisodeItemData
  implements Checkable
{
  private int jdField_a_of_type_Int;
  private stDramaFeed jdField_a_of_type_UserGrowthStDramaFeed;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    stDramaFeed localstDramaFeed = this.jdField_a_of_type_UserGrowthStDramaFeed;
    if ((localstDramaFeed != null) && (localstDramaFeed.feed != null) && (this.jdField_a_of_type_UserGrowthStDramaFeed.feed.poster != null)) {
      return this.jdField_a_of_type_UserGrowthStDramaFeed.feed.poster.id;
    }
    return "";
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData
 * JD-Core Version:    0.7.0.1
 */