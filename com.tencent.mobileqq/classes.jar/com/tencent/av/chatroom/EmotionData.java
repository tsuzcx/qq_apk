package com.tencent.av.chatroom;

import com.tencent.mobileqq.text.style.EmoticonSpan;
import java.util.Comparator;
import java.util.List;

public class EmotionData
{
  public static final Object d = new Object();
  public static final Comparator<EmotionData> e = new EmotionData.1();
  private static EmotionData g = null;
  private static int h = 0;
  public EmoticonSpan a;
  public int b;
  public int c;
  private EmotionData f;
  
  private EmotionData(EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    this.a = paramEmoticonSpan;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public static EmotionData a(EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    synchronized (d)
    {
      if (g != null)
      {
        EmotionData localEmotionData = g;
        g = localEmotionData.f;
        localEmotionData.b(paramEmoticonSpan, paramInt1, paramInt2);
        h -= 1;
        return localEmotionData;
      }
      return new EmotionData(paramEmoticonSpan, paramInt1, paramInt2);
    }
  }
  
  public static void a(List<EmotionData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        EmotionData localEmotionData = (EmotionData)paramList.remove(i);
        if (localEmotionData != null) {
          localEmotionData.a();
        }
        i -= 1;
      }
    }
  }
  
  private void b(EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    this.f = null;
    this.a = paramEmoticonSpan;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a()
  {
    b(null, -1, -1);
    synchronized (d)
    {
      if (h < 50)
      {
        this.f = g;
        g = this;
        h += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.EmotionData
 * JD-Core Version:    0.7.0.1
 */