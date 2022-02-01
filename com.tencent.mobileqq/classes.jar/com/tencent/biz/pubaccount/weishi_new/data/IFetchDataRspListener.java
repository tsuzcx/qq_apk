package com.tencent.biz.pubaccount.weishi_new.data;

import java.util.List;

public abstract interface IFetchDataRspListener<I>
{
  public abstract void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(List<I> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener
 * JD-Core Version:    0.7.0.1
 */