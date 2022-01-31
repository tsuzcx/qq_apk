package com.tencent.av.business.manager.support;

import com.tencent.av.app.VideoAppInterface;

public class SupportDefault
  extends SupportBase
{
  public SupportDefault(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public int a(String paramString)
  {
    return 1;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return true;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportDefault
 * JD-Core Version:    0.7.0.1
 */