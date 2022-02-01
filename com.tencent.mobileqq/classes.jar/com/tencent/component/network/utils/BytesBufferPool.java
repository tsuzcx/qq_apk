package com.tencent.component.network.utils;

import java.util.ArrayList;

public class BytesBufferPool
{
  private final int mBufferSize;
  private final ArrayList<BytesBufferPool.BytesBuffer> mList;
  private final int mPoolSize;
  
  public BytesBufferPool(int paramInt1, int paramInt2)
  {
    this.mList = new ArrayList(paramInt1);
    this.mPoolSize = paramInt1;
    this.mBufferSize = paramInt2;
  }
  
  public void clear()
  {
    try
    {
      this.mList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BytesBufferPool.BytesBuffer get()
  {
    try
    {
      int i = this.mList.size();
      BytesBufferPool.BytesBuffer localBytesBuffer;
      if (i > 0) {
        localBytesBuffer = (BytesBufferPool.BytesBuffer)this.mList.remove(i - 1);
      } else {
        localBytesBuffer = new BytesBufferPool.BytesBuffer(this.mBufferSize, null);
      }
      return localBytesBuffer;
    }
    finally {}
  }
  
  public void recycle(BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    try
    {
      int i = paramBytesBuffer.data.length;
      int j = this.mBufferSize;
      if (i != j) {
        return;
      }
      if (this.mList.size() < this.mPoolSize)
      {
        paramBytesBuffer.offset = 0;
        paramBytesBuffer.length = 0;
        this.mList.add(paramBytesBuffer);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.BytesBufferPool
 * JD-Core Version:    0.7.0.1
 */