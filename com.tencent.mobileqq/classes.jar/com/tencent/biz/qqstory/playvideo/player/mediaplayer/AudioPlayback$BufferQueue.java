package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AudioPlayback$BufferQueue
{
  private int a;
  private Queue<AudioPlayback.BufferQueue.Item> b = new LinkedList();
  private List<AudioPlayback.BufferQueue.Item> c = new ArrayList();
  private int d;
  
  AudioPlayback.BufferQueue.Item a()
  {
    try
    {
      AudioPlayback.BufferQueue.Item localItem = (AudioPlayback.BufferQueue.Item)this.b.poll();
      if (localItem != null) {
        this.d -= localItem.a.remaining();
      }
      return localItem;
    }
    finally {}
  }
  
  void a(AudioPlayback.BufferQueue.Item paramItem)
  {
    try
    {
      int i = paramItem.a.capacity();
      int j = this.a;
      if (i != j) {
        return;
      }
      paramItem.a.rewind();
      this.c.add(paramItem);
      return;
    }
    finally {}
  }
  
  void a(ByteBuffer paramByteBuffer, long paramLong)
  {
    try
    {
      if (paramByteBuffer.remaining() > this.a)
      {
        this.c.clear();
        this.a = paramByteBuffer.remaining();
      }
      AudioPlayback.BufferQueue.Item localItem;
      if (!this.c.isEmpty()) {
        localItem = (AudioPlayback.BufferQueue.Item)this.c.remove(0);
      } else {
        localItem = new AudioPlayback.BufferQueue.Item(paramByteBuffer.remaining());
      }
      localItem.a.limit(paramByteBuffer.remaining());
      localItem.a.mark();
      localItem.a.put(paramByteBuffer);
      localItem.a.reset();
      localItem.b = paramLong;
      this.b.add(localItem);
      this.d += localItem.a.remaining();
      return;
    }
    finally {}
  }
  
  void b()
  {
    try
    {
      for (;;)
      {
        AudioPlayback.BufferQueue.Item localItem = (AudioPlayback.BufferQueue.Item)this.b.poll();
        if (localItem == null) {
          break;
        }
        a(localItem);
      }
      this.d = 0;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback.BufferQueue
 * JD-Core Version:    0.7.0.1
 */