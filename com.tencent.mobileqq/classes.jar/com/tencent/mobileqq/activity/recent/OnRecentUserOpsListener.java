package com.tencent.mobileqq.activity.recent;

import android.view.View;

public abstract interface OnRecentUserOpsListener
{
  public abstract void onClick(View paramView, Object paramObject);
  
  public abstract void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2);
  
  public abstract void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean);
  
  public abstract void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener
 * JD-Core Version:    0.7.0.1
 */