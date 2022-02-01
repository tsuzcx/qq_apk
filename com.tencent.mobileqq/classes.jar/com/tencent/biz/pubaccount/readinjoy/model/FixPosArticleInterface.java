package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.ArrayList;

public abstract interface FixPosArticleInterface
{
  public abstract ArrayList<BaseArticleInfo> a(int paramInt);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, FixPosArticleInterface.FixPosArticleAsyncListener paramFixPosArticleAsyncListener);
  
  public abstract int[] a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FixPosArticleInterface
 * JD-Core Version:    0.7.0.1
 */