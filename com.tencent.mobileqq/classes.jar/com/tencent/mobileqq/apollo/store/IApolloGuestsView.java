package com.tencent.mobileqq.apollo.store;

import java.util.List;

public abstract interface IApolloGuestsView
{
  public abstract void onApprovalGet(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onApprovalSet(int paramInt);
  
  public abstract void onDressChange();
  
  public abstract void onLoadApolloInfo(int[] paramArrayOfInt, int paramInt);
  
  public abstract void onTagLoad(List<DressDescriptionItem> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.IApolloGuestsView
 * JD-Core Version:    0.7.0.1
 */