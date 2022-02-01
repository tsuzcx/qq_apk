package com.tencent.magicbrush.handler;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.gi.c.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class JsTouchEventHandler
{
  private IntBuffer a;
  private FloatBuffer b;
  private JsTouchEventHandler.b c = new JsTouchEventHandler.b(this);
  
  public JsTouchEventHandler()
  {
    a(10);
  }
  
  private int a(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionMasked();
    if (j != 0)
    {
      int i = 1;
      if (j != 1)
      {
        if (j != 2)
        {
          i = 3;
          if (j != 3)
          {
            if (j == 5) {
              break label45;
            }
            if (j == 6) {
              break label43;
            }
            return -1;
          }
        }
        return i;
      }
      label43:
      return 2;
    }
    label45:
    return 0;
  }
  
  private void a(int paramInt)
  {
    IntBuffer localIntBuffer = this.a;
    if ((localIntBuffer != null) && (localIntBuffer.capacity() >= paramInt))
    {
      this.a.clear();
      this.b.clear();
      return;
    }
    localIntBuffer = this.a;
    int i;
    if (localIntBuffer != null)
    {
      i = localIntBuffer.capacity();
      for (;;)
      {
        j = i;
        if (i >= paramInt) {
          break;
        }
        i *= 2;
      }
    }
    int j = paramInt;
    localIntBuffer = this.a;
    if (localIntBuffer == null) {
      i = 0;
    } else {
      i = localIntBuffer.capacity();
    }
    c.c.b("MicroMsg.JsTouchEventHandler", "Should Create A New Buffer, Current = [%d], Request = [%d], ShouldBe = [%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
    this.a = ByteBuffer.allocateDirect(j * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
    this.b = ByteBuffer.allocateDirect(j * 2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  }
  
  private native long nativeCreateTouchEvent(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer, FloatBuffer paramFloatBuffer, long paramLong);
  
  private native void nativeFreeTouchEvent(long paramLong);
  
  public long a(@NonNull MotionEvent paramMotionEvent, float paramFloat)
  {
    a(paramMotionEvent.getPointerCount());
    int k = a(paramMotionEvent);
    if (k == -1) {
      return 0L;
    }
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      this.a.put(paramMotionEvent.getPointerId(i));
      this.b.put(paramMotionEvent.getX(i) / paramFloat);
      this.b.put(paramMotionEvent.getY(i) / paramFloat);
      i += 1;
    }
    int m = a(paramMotionEvent);
    if (k == 1) {
      i = -1;
    } else {
      i = paramMotionEvent.getActionIndex();
    }
    return nativeCreateTouchEvent(m, i, j, this.a, this.b, paramMotionEvent.getEventTime());
  }
  
  public JsTouchEventHandler.a a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.JsTouchEventHandler
 * JD-Core Version:    0.7.0.1
 */