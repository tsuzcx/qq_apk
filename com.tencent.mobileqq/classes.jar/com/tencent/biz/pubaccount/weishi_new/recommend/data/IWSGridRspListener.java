package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stSimpleMetaFeed;
import java.util.List;

public abstract interface IWSGridRspListener
{
  public abstract void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.IWSGridRspListener
 * JD-Core Version:    0.7.0.1
 */