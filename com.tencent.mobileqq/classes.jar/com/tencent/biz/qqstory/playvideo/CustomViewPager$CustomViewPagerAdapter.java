package com.tencent.biz.qqstory.playvideo;

import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class CustomViewPager$CustomViewPagerAdapter
  extends PagerAdapter
{
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    long l = SystemClock.uptimeMillis();
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    SLog.a("Q.qqstory.player.ViewPager", "destroyItem, cost=%d", Long.valueOf(SystemClock.uptimeMillis() - l));
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    super.finishUpdate(paramViewGroup);
    SLog.b("Q.qqstory.player.ViewPager", "finishUpdate");
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
    SLog.a("Q.qqstory.player.ViewPager", "instantiateItem, cost=%d", Long.valueOf(SystemClock.uptimeMillis() - l));
    return paramViewGroup;
  }
  
  public void notifyDataSetChanged()
  {
    long l = SystemClock.uptimeMillis();
    SLog.b("Q.qqstory.player.ViewPager", "notifyDataSetChanged start");
    super.notifyDataSetChanged();
    SLog.a("Q.qqstory.player.ViewPager", "notifyDataSetChanged end, cost=%d", Long.valueOf(SystemClock.uptimeMillis() - l));
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    super.startUpdate(paramViewGroup);
    SLog.b("Q.qqstory.player.ViewPager", "startUpdate");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.CustomViewPager.CustomViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */