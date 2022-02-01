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
  private static final String TAG = "FrameBufferCache";
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
    Object localObject1 = this.allMap.values().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Queue)((Iterator)localObject1).next()).iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        if (((Frame)((Iterator)localObject2).next()).unlock()) {
          j += 1;
        }
      }
    }
    if ((DEBUG) && (i > 0))
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" frames are leaked!");
      Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public Frame get(int paramInt1, int paramInt2)
  {
    FrameBufferCache.FrameSize localFrameSize = new FrameBufferCache.FrameSize(this, paramInt1, paramInt2);
    Object localObject2 = (Queue)this.map.get(localFrameSize);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new LinkedList();
      this.map.put(localFrameSize, localObject1);
    }
    Object localObject3 = (Queue)this.allMap.get(localFrameSize);
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new LinkedList();
      this.allMap.put(localFrameSize, localObject2);
    }
    if (((Queue)localObject1).isEmpty())
    {
      localObject3 = new Frame(Frame.Type.FRAME_CACHE);
      ((Frame)localObject3).bindFrame(-1, paramInt1, paramInt2, 0.0D);
      ((Queue)localObject2).offer(localObject3);
    }
    else
    {
      Frame localFrame = (Frame)((Queue)localObject1).poll();
      localObject3 = localFrame;
      if (DEBUG)
      {
        localObject3 = (Queue)this.usedMap.get(localFrameSize);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new LinkedList();
          this.usedMap.put(localFrameSize, localObject2);
        }
        localObject3 = localFrame;
        if (!((Queue)localObject2).contains(localFrame))
        {
          ((Queue)localObject2).offer(localFrame);
          localObject3 = localFrame;
        }
      }
    }
    if (!this.countMap.containsKey(localFrameSize)) {
      this.countMap.put(localFrameSize, Integer.valueOf(2147483647));
    }
    localObject2 = this.countMap;
    ((Map)localObject2).put(localFrameSize, Integer.valueOf(Math.min(((Integer)((Map)localObject2).get(localFrameSize)).intValue(), ((Queue)localObject1).size())));
    return localObject3;
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
      } else {
        i = localQueue1.size();
      }
      while ((i > 0) && (!localQueue1.isEmpty()))
      {
        localObject = (Frame)localQueue1.poll();
        if (localQueue2 != null) {
          localQueue2.remove(localObject);
        }
        ((Frame)localObject).clear();
        i -= 1;
      }
    }
    this.countMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.FrameBufferCache
 * JD-Core Version:    0.7.0.1
 */