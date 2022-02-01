package com.tencent.biz.qqstory.album.model.strategy;

import com.tencent.biz.qqstory.album.RuleConfig;
import java.util.List;

public class BaseSplitConfig
{
  public int a;
  public int b;
  public String c;
  public String d;
  public int e;
  public List<String> f;
  
  public BaseSplitConfig() {}
  
  public BaseSplitConfig(RuleConfig paramRuleConfig)
  {
    this.a = paramRuleConfig.a;
    int i;
    if (paramRuleConfig.e > 0) {
      i = paramRuleConfig.e;
    } else {
      i = a(this.a);
    }
    this.b = i;
    this.c = paramRuleConfig.f;
    this.d = paramRuleConfig.b;
    this.e = paramRuleConfig.c;
    this.f = paramRuleConfig.d;
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mTransId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mTextId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" mAlbumMinPicCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mAlbumDesc=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mTransList=");
    Object localObject = this.f;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig
 * JD-Core Version:    0.7.0.1
 */