package com.tencent.biz.qqstory.album.flter;

import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.strategy.SplitConfig.TimeSplitConfig;
import com.tencent.biz.qqstory.album.strategy.TimeSplitStrategy;
import java.util.List;

public class OneDayAlbumFilter
  extends BaseAlbumFilter
{
  public OneDayAlbumFilter(SplitConfig.TimeSplitConfig paramTimeSplitConfig)
  {
    super(paramTimeSplitConfig.a);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = ("Q.qqstory.recommendAlbum.logic_OneDayAlbumFilter " + paramTimeSplitConfig.c);
    TimeSplitStrategy localTimeSplitStrategy = new TimeSplitStrategy();
    localTimeSplitStrategy.a(paramTimeSplitConfig);
    a(localTimeSplitStrategy);
  }
  
  protected void c(List<StoryAlbum> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.flter.OneDayAlbumFilter
 * JD-Core Version:    0.7.0.1
 */