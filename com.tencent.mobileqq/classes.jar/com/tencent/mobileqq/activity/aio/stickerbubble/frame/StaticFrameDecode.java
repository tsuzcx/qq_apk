package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qphone.base.util.BaseApplication;

public class StaticFrameDecode
  implements IFrameDecode
{
  private int a;
  
  public StaticFrameDecode(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a()
  {
    return 1000000;
  }
  
  public Bitmap a()
  {
    return BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), this.a);
  }
  
  public void a() {}
  
  public int b()
  {
    return 1;
  }
  
  public void b() {}
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.StaticFrameDecode
 * JD-Core Version:    0.7.0.1
 */