package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;

public class ControlUIObserver$BaseParameter
{
  String a = null;
  private long b = 0L;
  private int c;
  
  ControlUIObserver$BaseParameter(int paramInt)
  {
    this.c = paramInt;
  }
  
  public long a()
  {
    if ((this.b == 0L) && (AudioHelper.a()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq未初始化:");
      localStringBuilder.append(getClass().getSimpleName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return this.b;
  }
  
  public void a(long paramLong, String paramString)
  {
    this.b = paramLong;
    this.a = paramString;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    paramVideoAppInterface.a(new Object[] { Integer.valueOf(this.c), this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver.BaseParameter
 * JD-Core Version:    0.7.0.1
 */