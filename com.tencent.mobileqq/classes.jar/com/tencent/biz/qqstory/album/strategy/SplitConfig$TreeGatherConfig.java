package com.tencent.biz.qqstory.album.strategy;

import com.tencent.biz.qqstory.album.RuleConfig;
import com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig;

public class SplitConfig$TreeGatherConfig
  extends BaseSplitConfig
{
  public int d = -1;
  public int e = -1;
  
  public SplitConfig$TreeGatherConfig() {}
  
  public SplitConfig$TreeGatherConfig(RuleConfig paramRuleConfig)
  {
    super(paramRuleConfig);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("TreeGatherConfig =[");
    localStringBuilder1.append(" mStartGatherLevel=");
    localStringBuilder1.append(this.d);
    localStringBuilder1.append(" mEndGatherLevel=");
    localStringBuilder1.append(this.e);
    localStringBuilder1.append("] ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(localStringBuilder1.toString());
    localStringBuilder2.append(super.toString());
    return localStringBuilder2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.SplitConfig.TreeGatherConfig
 * JD-Core Version:    0.7.0.1
 */