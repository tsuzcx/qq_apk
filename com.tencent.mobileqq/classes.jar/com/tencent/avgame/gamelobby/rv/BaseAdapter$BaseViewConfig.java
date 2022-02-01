package com.tencent.avgame.gamelobby.rv;

import com.tencent.avgame.gamelobby.data.IBaseData;

public class BaseAdapter$BaseViewConfig
{
  public int a;
  public BaseViewHolder.ViewHolderFactory<?> b;
  public Class<? extends BaseViewHolder<? extends IBaseData>> c;
  public BaseViewHolder.OnClickListener d;
  
  public BaseAdapter$BaseViewConfig(int paramInt, BaseViewHolder.ViewHolderFactory<?> paramViewHolderFactory, BaseViewHolder.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
    this.a = paramInt;
    this.b = paramViewHolderFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.BaseAdapter.BaseViewConfig
 * JD-Core Version:    0.7.0.1
 */