package com.tencent.biz.pubaccount.readinjoy.mvp;

public abstract interface ListContract$IListModel<BEAN>
{
  public abstract void a(ListContract.NextPageCallback<BEAN> paramNextPageCallback);
  
  public abstract void a(boolean paramBoolean, ListContract.FirstPageCallback<BEAN> paramFirstPageCallback);
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.mvp.ListContract.IListModel
 * JD-Core Version:    0.7.0.1
 */