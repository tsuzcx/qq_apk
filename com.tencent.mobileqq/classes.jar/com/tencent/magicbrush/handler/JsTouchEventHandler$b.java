package com.tencent.magicbrush.handler;

import java.lang.ref.WeakReference;

public class JsTouchEventHandler$b
  implements JsTouchEventHandler.a
{
  private WeakReference<JsTouchEventHandler> a;
  
  public JsTouchEventHandler$b(JsTouchEventHandler paramJsTouchEventHandler)
  {
    this.a = new WeakReference(paramJsTouchEventHandler);
  }
  
  public void a(long paramLong)
  {
    JsTouchEventHandler localJsTouchEventHandler = (JsTouchEventHandler)this.a.get();
    if (localJsTouchEventHandler != null) {
      JsTouchEventHandler.a(localJsTouchEventHandler, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.JsTouchEventHandler.b
 * JD-Core Version:    0.7.0.1
 */