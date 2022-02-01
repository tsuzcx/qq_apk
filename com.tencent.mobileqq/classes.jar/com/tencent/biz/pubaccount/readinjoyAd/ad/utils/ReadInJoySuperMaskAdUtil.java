package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

public class ReadInJoySuperMaskAdUtil
{
  public static boolean a = false;
  private static volatile ReadInJoySuperMaskAdUtil c;
  ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener b = null;
  
  public static ReadInJoySuperMaskAdUtil a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new ReadInJoySuperMaskAdUtil();
        }
      }
      finally {}
    }
    return c;
  }
  
  public void a(int paramInt)
  {
    ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener localRIJSuperMaskAdEventListener = this.b;
    if (localRIJSuperMaskAdEventListener != null) {
      localRIJSuperMaskAdEventListener.a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener localRIJSuperMaskAdEventListener = this.b;
    if (localRIJSuperMaskAdEventListener != null) {
      localRIJSuperMaskAdEventListener.a(paramInt, paramBoolean);
    }
  }
  
  public void a(ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener paramRIJSuperMaskAdEventListener)
  {
    this.b = paramRIJSuperMaskAdEventListener;
  }
  
  public void b()
  {
    if (this.b != null) {
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil
 * JD-Core Version:    0.7.0.1
 */