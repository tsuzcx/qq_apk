package com.tencent.biz.qqstory.album.model.strategy;

import com.tencent.biz.qqstory.album.RuleConfig;
import java.util.List;

public class BaseSplitConfig
{
  public int a;
  public String a;
  public List<String> a;
  public int b;
  public String b;
  public int c;
  
  public BaseSplitConfig() {}
  
  public BaseSplitConfig(RuleConfig paramRuleConfig)
  {
    this.jdField_a_of_type_Int = paramRuleConfig.jdField_a_of_type_Int;
    int i;
    if (paramRuleConfig.c > 0) {
      i = paramRuleConfig.c;
    } else {
      i = a(this.jdField_a_of_type_Int);
    }
    this.jdField_b_of_type_Int = i;
    this.jdField_a_of_type_JavaLangString = paramRuleConfig.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramRuleConfig.jdField_a_of_type_JavaLangString;
    this.c = paramRuleConfig.jdField_b_of_type_Int;
    this.jdField_a_of_type_JavaUtilList = paramRuleConfig.jdField_a_of_type_JavaUtilList;
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 3) && (paramInt != 4))
      {
        if (paramInt != 6) {}
        return 6;
      }
      return 10;
    }
    return 6;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BaseSplitConfig =[");
    localStringBuilder.append(" type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mTransId=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" mTextId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mAlbumMinPicCount=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" mAlbumDesc=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mTransList=");
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = localObject.toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig
 * JD-Core Version:    0.7.0.1
 */