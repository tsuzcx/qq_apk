package com.tencent.mobileqq.activity.aio.zhitu;

import java.util.Iterator;

public abstract class GifImageIterator
  implements Iterator<GifImage>
{
  public abstract GifImage a();
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.GifImageIterator
 * JD-Core Version:    0.7.0.1
 */