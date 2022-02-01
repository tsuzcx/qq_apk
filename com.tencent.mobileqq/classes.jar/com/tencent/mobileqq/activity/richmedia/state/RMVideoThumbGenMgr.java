package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RMVideoThumbGenMgr
{
  RMVideoThumbGenMgr.ThumbGenItem a;
  ArrayList<RMVideoThumbGenMgr.ThumbGenItem> b = new ArrayList();
  private Object c = new Object();
  
  int a(RMVideoThumbGenMgr.ThumbGenItem paramThumbGenItem, boolean paramBoolean)
  {
    if (paramThumbGenItem == null) {
      return 1;
    }
    paramThumbGenItem.c = true;
    int i = paramThumbGenItem.a.getAndSet(7);
    if ((i == 3) && (paramThumbGenItem.h != null) && (paramBoolean))
    {
      FileUtils.deleteFile(paramThumbGenItem.h);
      paramThumbGenItem.h = null;
      return i;
    }
    if ((i == 6) && (paramThumbGenItem.g != null))
    {
      FileUtils.deleteFile(paramThumbGenItem.g);
      paramThumbGenItem.g = null;
    }
    return i;
  }
  
  public RMVideoThumbGenMgr.ThumbGenItem a()
  {
    return this.a;
  }
  
  void b()
  {
    for (;;)
    {
      synchronized (this.c)
      {
        if (this.b.size() > 0)
        {
          RMVideoThumbGenMgr.ThumbGenItem localThumbGenItem = (RMVideoThumbGenMgr.ThumbGenItem)this.b.get(0);
          this.b.remove(0);
          if ((localThumbGenItem != null) && (a(localThumbGenItem, localThumbGenItem.j) == 2)) {
            synchronized (this.c)
            {
              this.b.add(localThumbGenItem);
              return;
            }
          }
          return;
        }
      }
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr
 * JD-Core Version:    0.7.0.1
 */