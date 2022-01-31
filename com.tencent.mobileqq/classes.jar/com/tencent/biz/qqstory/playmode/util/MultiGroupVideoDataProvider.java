package com.tencent.biz.qqstory.playmode.util;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import nra;

public abstract class MultiGroupVideoDataProvider
{
  public ArrayList c = new ArrayList();
  protected int e;
  
  public void a()
  {
    this.c.clear();
  }
  
  public void a(MultiGroupVideoDataProvider.DataObserver paramDataObserver)
  {
    try
    {
      if (!this.c.contains(paramDataObserver)) {
        this.c.add(paramDataObserver);
      }
      return;
    }
    finally
    {
      paramDataObserver = finally;
      throw paramDataObserver;
    }
  }
  
  public void a(VideoData paramVideoData)
  {
    try
    {
      new Handler(Looper.getMainLooper()).post(new nra(this, paramVideoData));
      return;
    }
    finally
    {
      paramVideoData = finally;
      throw paramVideoData;
    }
  }
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.MultiGroupVideoDataProvider
 * JD-Core Version:    0.7.0.1
 */