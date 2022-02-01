package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import java.util.List;

public abstract interface IVerticalRspListener
{
  public abstract void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener
 * JD-Core Version:    0.7.0.1
 */