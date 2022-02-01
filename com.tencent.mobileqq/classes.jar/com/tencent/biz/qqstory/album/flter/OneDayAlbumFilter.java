package com.tencent.biz.qqstory.album.flter;

import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.strategy.AbstractSplitStrategy;
import com.tencent.biz.qqstory.album.strategy.SplitConfig.TimeSplitConfig;
import com.tencent.biz.qqstory.album.strategy.TimeSplitStrategy;
import java.util.List;

public class OneDayAlbumFilter
  extends BaseAlbumFilter
{
  public OneDayAlbumFilter(SplitConfig.TimeSplitConfig paramTimeSplitConfig)
  {
    super(paramTimeSplitConfig.a);
    this.b = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Q.qqstory.recommendAlbum.logic_OneDayAlbumFilter ");
    ((StringBuilder)localObject).append(paramTimeSplitConfig.i);
    this.c = ((StringBuilder)localObject).toString();
    localObject = new TimeSplitStrategy();
    ((TimeSplitStrategy)localObject).a(paramTimeSplitConfig);
    a((AbstractSplitStrategy)localObject);
  }
  
  protected void c(List<StoryAlbum> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.flter.OneDayAlbumFilter
 * JD-Core Version:    0.7.0.1
 */