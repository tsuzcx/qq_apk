package com.tencent.biz.qqstory.album.strategy;

import com.tencent.biz.qqstory.album.StoryAlbumConfig.RuleConfig;

public class SplitConfig$TreeGatherConfig
  extends SplitConfig.BaseSplitConfig
{
  public int d = -1;
  public int e = -1;
  
  public SplitConfig$TreeGatherConfig() {}
  
  public SplitConfig$TreeGatherConfig(StoryAlbumConfig.RuleConfig paramRuleConfig)
  {
    super(paramRuleConfig);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TreeGatherConfig =[");
    localStringBuilder.append(" mStartGatherLevel=").append(this.d);
    localStringBuilder.append(" mEndGatherLevel=").append(this.e);
    localStringBuilder.append("] ");
    return localStringBuilder.toString() + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.SplitConfig.TreeGatherConfig
 * JD-Core Version:    0.7.0.1
 */