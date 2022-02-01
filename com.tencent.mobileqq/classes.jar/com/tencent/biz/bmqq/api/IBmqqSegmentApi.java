package com.tencent.biz.bmqq.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IBmqqSegmentApi
  extends QRouteApi
{
  public abstract void initSegmentCache(Context paramContext);
  
  public abstract boolean isBmqqUin(Context paramContext, String paramString);
  
  public abstract boolean isBmqqUin(String paramString);
  
  public abstract boolean isBmqqUinNoBlock(String paramString);
  
  public abstract boolean isCrm3ExtUin(Context paramContext, String paramString);
  
  public abstract boolean isUin(String paramString);
  
  public abstract boolean isWeixinUin(Context paramContext, String paramString);
  
  public abstract void updateEqqConfig(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.bmqq.api.IBmqqSegmentApi
 * JD-Core Version:    0.7.0.1
 */