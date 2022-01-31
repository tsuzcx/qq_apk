package com.tencent.mobileqq.activity.recent;

import android.view.View;

public abstract interface OnRecentUserOpsListener
{
  public abstract void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean);
  
  public abstract void a(View paramView, Object paramObject);
  
  public abstract void a(RecentBaseData paramRecentBaseData, String paramString);
  
  public abstract void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener
 * JD-Core Version:    0.7.0.1
 */