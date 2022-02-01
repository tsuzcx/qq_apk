package com.tencent.biz.qqstory.utils;

import amtj;
import android.support.annotation.NonNull;
import bcdb;
import com.tencent.image.URLDrawable;
import java.util.concurrent.ConcurrentHashMap;
import xvv;
import yqj;

class UIUtils$URLDrawableMonitor
{
  public static ConcurrentHashMap<UIUtils.DrawableListenerHolder, Boolean> sDrawableStateMap = new ConcurrentHashMap();
  private static volatile URLDrawableMonitor sMonitor;
  
  public static URLDrawableMonitor getInstance()
  {
    if (sMonitor == null) {}
    try
    {
      if (sMonitor == null) {
        sMonitor = new URLDrawableMonitor();
      }
      return sMonitor;
    }
    finally {}
  }
  
  public static void monitor(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new UIUtils.DrawableListenerHolder(getInstance(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    sDrawableStateMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void remove(@NonNull UIUtils.DrawableListenerHolder paramDrawableListenerHolder)
  {
    boolean bool = sDrawableStateMap.containsKey(paramDrawableListenerHolder);
    xvv.a("Q.qqstory.UIUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool) {
      bcdb.a(yqj.a(amtj.a(2131714879), null), "Story.UIUtils.monitor " + paramDrawableListenerHolder.toString());
    }
    paramDrawableListenerHolder.drawable.setDownloadListener(null);
    paramDrawableListenerHolder.drawable.setURLDrawableListener(null);
    sDrawableStateMap.remove(paramDrawableListenerHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.URLDrawableMonitor
 * JD-Core Version:    0.7.0.1
 */