package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AudioPlayback$BufferQueue
{
  private int jdField_a_of_type_Int;
  private List<AudioPlayback.BufferQueue.Item> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Queue<AudioPlayback.BufferQueue.Item> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private int b;
  
  AudioPlayback.BufferQueue.Item a()
  {
    try
    {
      AudioPlayback.BufferQueue.Item localItem = (AudioPlayback.BufferQueue.Item)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localItem != null) {
        this.b -= localItem.jdField_a_of_type_JavaNioByteBuffer.remaining();
      }
      return localItem;
    }
    finally {}
  }
  
  void a()
  {
    try
    {
      for (;;)
      {
        AudioPlayback.BufferQueue.Item localItem = (AudioPlayback.BufferQueue.Item)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localItem == null) {
          break;
        }
        a(localItem);
      }
      this.b = 0;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  void a(AudioPlayback.BufferQueue.Item paramItem)
  {
    try
    {
      int i = paramItem.jdField_a_of_type_JavaNioByteBuffer.capacity();
      int j = this.jdField_a_of_type_Int;
      if (i != j) {
        return;
      }
      paramItem.jdField_a_of_type_JavaNioByteBuffer.rewind();
      this.jdField_a_of_type_JavaUtilList.add(paramItem);
      return;
    }
    finally {}
  }
  
  void a(ByteBuffer paramByteBuffer, long paramLong)
  {
    try
    {
      if (paramByteBuffer.remaining() > this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_Int = paramByteBuffer.remaining();
      }
      AudioPlayback.BufferQueue.Item localItem;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        localItem = (AudioPlayback.BufferQueue.Item)this.jdField_a_of_type_JavaUtilList.remove(0);
      } else {
        localItem = new AudioPlayback.BufferQueue.Item(paramByteBuffer.remaining());
      }
      localItem.jdField_a_of_type_JavaNioByteBuffer.limit(paramByteBuffer.remaining());
      localItem.jdField_a_of_type_JavaNioByteBuffer.mark();
      localItem.jdField_a_of_type_JavaNioByteBuffer.put(paramByteBuffer);
      localItem.jdField_a_of_type_JavaNioByteBuffer.reset();
      localItem.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaUtilQueue.add(localItem);
      this.b += localItem.jdField_a_of_type_JavaNioByteBuffer.remaining();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback.BufferQueue
 * JD-Core Version:    0.7.0.1
 */