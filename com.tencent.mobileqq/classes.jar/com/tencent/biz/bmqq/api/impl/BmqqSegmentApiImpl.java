package com.tencent.biz.bmqq.api.impl;

import android.content.Context;
import com.tencent.biz.bmqq.api.IBmqqSegmentApi;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;

public class BmqqSegmentApiImpl
  implements IBmqqSegmentApi
{
  public void initSegmentCache(Context paramContext)
  {
    BmqqSegmentUtil.a(paramContext);
  }
  
  public boolean isBmqqUin(Context paramContext, String paramString)
  {
    return BmqqSegmentUtil.a(paramContext, paramString);
  }
  
  public boolean isBmqqUin(String paramString)
  {
    return BmqqSegmentUtil.b(paramString);
  }
  
  public boolean isBmqqUinNoBlock(String paramString)
  {
    return BmqqSegmentUtil.c(paramString);
  }
  
  public boolean isCrm3ExtUin(Context paramContext, String paramString)
  {
    return BmqqSegmentUtil.b(paramContext, paramString);
  }
  
  public boolean isUin(String paramString)
  {
    return BmqqSegmentUtil.a(paramString);
  }
  
  public boolean isWeixinUin(Context paramContext, String paramString)
  {
    return BmqqSegmentUtil.c(paramContext, paramString);
  }
  
  public void updateEqqConfig(String paramString)
  {
    BmqqSegmentUtil.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.bmqq.api.impl.BmqqSegmentApiImpl
 * JD-Core Version:    0.7.0.1
 */