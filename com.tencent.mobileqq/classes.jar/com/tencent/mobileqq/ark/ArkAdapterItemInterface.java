package com.tencent.mobileqq.ark;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;

public abstract interface ArkAdapterItemInterface
{
  public abstract void attachArkView(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, int paramInt);
  
  public abstract void clickTail(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, LinearLayout paramLinearLayout, Context paramContext);
  
  public abstract void destroyContainerByRemove();
  
  public abstract ArkAdapterItemInterface extendArkCardByOpen(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2);
  
  public abstract String[] getArkAppNameAndPath();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAdapterItemInterface
 * JD-Core Version:    0.7.0.1
 */