package com.tencent.aekit.openrender.internal;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class FrameBufferCache
{
  public static boolean DEBUG = false;
  private static final ThreadLocal<FrameBufferCache> INSTANCE = new FrameBufferCache.1();
  private static final String TAG = FrameBufferCache.class.getSimpleName();
  private Map<FrameBufferCache.FrameSize, Queue<Frame>> allMap = new HashMap();
  private Map<FrameBufferCache.FrameSize, Integer> countMap = new HashMap();
  private Map<FrameBufferCache.FrameSize, Queue<Frame>> map = new HashMap();
  private Map<FrameBufferCache.FrameSize, Queue<Frame>> usedMap = new HashMap();
  
  public static FrameBufferCache getInstance()
  {
    return (FrameBufferCache)INSTANCE.get();
  }
  
  public void destroy()
  {
    Iterator localIterator = this.allMap.values().iterator();
    while (localIterator.hasNext())
    {
      Queue localQueue = (Queue)localIterator.next();
      while (!localQueue.isEmpty()) {
        ((Frame)localQueue.poll()).clear();
      }
    }
    this.allMap.clear();
    this.map.clear();
    this.usedMap.clear();
    this.countMap.clear();
  }
  
  public void destroyReserveFrame(Frame paramFrame)
  {
    if (paramFrame == null) {
      return;
    }
    Object localObject = this.allMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Queue localQueue = (Queue)((Iterator)localObject).next();
      while (!localQueue.isEmpty())
      {
        Frame localFrame = (Frame)localQueue.poll();
        if (localFrame != paramFrame) {
          localFrame.clear();
        }
      }
    }
    this.allMap.clear();
    this.map.clear();
    this.usedMap.clear();
    this.countMap.clear();
    localObject = new LinkedList();
    ((Queue)localObject).offer(paramFrame);
    this.allMap.put(new FrameBufferCache.FrameSize(this, paramFrame.width, paramFrame.height), localObject);
  }
  
  public void forceRecycle()
  {
    Iterator localIterator1 = this.allMap.values().iterator();
    int i = 0;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Queue)localIterator1.next()).iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!localIterator2.hasNext()) {
          break;
        }
        if (((Frame)localIterator2.next()).unlock()) {
          j += 1;
        }
      }
    }
    if ((DEBUG) && (i > 0)) {
      Log.e(TAG, i + " frames are leaked!");
    }
  }
  
  public Frame get(int paramInt1, int paramInt2)
  {
    FrameBufferCache.FrameSize localFrameSize = new FrameBufferCache.FrameSize(this, paramInt1, paramInt2);
    Object localObject1 = (Queue)this.map.get(localFrameSize);
    if (localObject1 == null)
    {
      localObject1 = new LinkedList();
      this.map.put(localFrameSize, localObject1);
    }
    for (;;)
    {
      Object localObject2 = (Queue)this.allMap.get(localFrameSize);
      if (localObject2 == null)
      {
        localObject2 = new LinkedList();
        this.allMap.put(localFrameSize, localObject2);
      }
      for (;;)
      {
        Frame localFrame;
        if (((Queue)localObject1).isEmpty())
        {
          localFrame = new Frame(Frame.Type.FRAME_CACHE);
          localFrame.bindFrame(-1, paramInt1, paramInt2, 0.0D);
          ((Queue)localObject2).offer(localFrame);
        }
        for (localObject2 = localFrame;; localObject2 = localFrame)
        {
          if (!this.countMap.containsKey(localFrameSize)) {
            this.countMap.put(localFrameSize, Integer.valueOf(2147483647));
          }
          this.countMap.put(localFrameSize, Integer.valueOf(Math.min(((Integer)this.countMap.get(localFrameSize)).intValue(), ((Queue)localObject1).size())));
          return localObject2;
          localFrame = (Frame)((Queue)localObject1).poll();
          if (DEBUG)
          {
            Queue localQueue = (Queue)this.usedMap.get(localFrameSize);
            localObject2 = localQueue;
            if (localQueue == null)
            {
              localObject2 = new LinkedList();
              this.usedMap.put(localFrameSize, localObject2);
            }
            if (!((Queue)localObject2).contains(localFrame)) {
              ((Queue)localObject2).offer(localFrame);
            }
          }
        }
      }
    }
  }
  
  public boolean put(Frame paramFrame)
  {
    if (paramFrame == null) {
      return false;
    }
    FrameBufferCache.FrameSize localFrameSize = new FrameBufferCache.FrameSize(this, paramFrame.width, paramFrame.height);
    Queue localQueue = (Queue)this.map.get(localFrameSize);
    Object localObject = localQueue;
    if (localQueue == null)
    {
      localObject = new LinkedList();
      this.map.put(localFrameSize, localObject);
    }
    if (!((Queue)localObject).contains(paramFrame)) {
      return ((Queue)localObject).offer(paramFrame);
    }
    return false;
  }
  
  public void reset()
  {
    this.usedMap.clear();
  }
  
  public void shrink()
  {
    Iterator localIterator = this.map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      Queue localQueue1 = (Queue)((Map.Entry)localObject).getValue();
      Queue localQueue2 = (Queue)this.allMap.get(((Map.Entry)localObject).getKey());
      int i;
      if (this.countMap.containsKey(((Map.Entry)localObject).getKey())) {
        i = ((Integer)this.countMap.get(((Map.Entry)localObject).getKey())).intValue();
      }
      while ((i > 0) && (!localQueue1.isEmpty()))
      {
        localObject = (Frame)localQueue1.poll();
        if (localQueue2 != null) {
          localQueue2.remove(localObject);
        }
        ((Frame)localObject).clear();
        i -= 1;
        continue;
        i = localQueue1.size();
      }
    }
    this.countMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.FrameBufferCache
 * JD-Core Version:    0.7.0.1
 */