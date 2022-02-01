package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.V8;

class ConcurrentV8$1
  implements V8Runnable
{
  ConcurrentV8$1(ConcurrentV8 paramConcurrentV8) {}
  
  public void run(V8 paramV8)
  {
    if ((paramV8 != null) && (!paramV8.isReleased())) {
      paramV8.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.ConcurrentV8.1
 * JD-Core Version:    0.7.0.1
 */