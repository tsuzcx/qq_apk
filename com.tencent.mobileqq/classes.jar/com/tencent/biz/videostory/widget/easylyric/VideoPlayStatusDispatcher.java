package com.tencent.biz.videostory.widget.easylyric;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoPlayStatusDispatcher
{
  private static final VideoPlayStatusDispatcher.Instance a = new VideoPlayStatusDispatcher.Instance(null);
  private CopyOnWriteArrayList<OnLyricListener> b = new CopyOnWriteArrayList();
  private boolean c = false;
  
  public static VideoPlayStatusDispatcher a()
  {
    return (VideoPlayStatusDispatcher)a.getInstance();
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.b;
    if ((localObject != null) && (!this.c))
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnLyricListener)((Iterator)localObject).next()).a(paramLong);
      }
    }
  }
  
  public void a(OnLyricListener paramOnLyricListener)
  {
    this.b.add(paramOnLyricListener);
  }
  
  public void b()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnLyricListener)((Iterator)localObject).next()).b();
      }
    }
  }
  
  public void b(OnLyricListener paramOnLyricListener)
  {
    this.b.remove(paramOnLyricListener);
  }
  
  public void c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnLyricListener)((Iterator)localObject).next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.VideoPlayStatusDispatcher
 * JD-Core Version:    0.7.0.1
 */