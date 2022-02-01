package com.tencent.biz.qqstory.album.strategy;

import com.tencent.biz.qqstory.album.StoryAlbumConfig.RuleConfig;
import java.util.List;

public class SplitConfig$BaseSplitConfig
{
  public int a;
  public String a;
  public List<String> a;
  public int b;
  public String b;
  public int c;
  
  public SplitConfig$BaseSplitConfig() {}
  
  public SplitConfig$BaseSplitConfig(StoryAlbumConfig.RuleConfig paramRuleConfig)
  {
    this.jdField_a_of_type_Int = paramRuleConfig.jdField_e_of_type_Int;
    if (paramRuleConfig.g > 0) {}
    for (int i = paramRuleConfig.g;; i = SplitConfig.a(this.jdField_a_of_type_Int))
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_JavaLangString = paramRuleConfig.jdField_e_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramRuleConfig.d;
      this.c = paramRuleConfig.f;
      this.jdField_a_of_type_JavaUtilList = paramRuleConfig.jdField_a_of_type_JavaUtilList;
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("BaseSplitConfig =[");
    localStringBuilder1.append(" type=").append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(" mTransId=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder1.append(" mTextId=").append(this.c);
    localStringBuilder1.append(" mAlbumMinPicCount=").append(this.jdField_b_of_type_Int);
    localStringBuilder1.append(" mAlbumDesc=").append(this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" mTransList=");
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (String str = "";; str = this.jdField_a_of_type_JavaUtilList.toString())
    {
      localStringBuilder2.append(str);
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.SplitConfig.BaseSplitConfig
 * JD-Core Version:    0.7.0.1
 */