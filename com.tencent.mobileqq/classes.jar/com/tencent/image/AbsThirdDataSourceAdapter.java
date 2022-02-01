package com.tencent.image;

public abstract class AbsThirdDataSourceAdapter
{
  public static final int STATUS_NOT_PREPARED = 0;
  public static final int STATUS_PREPARED = 2;
  public static final int STATUS_PREPARING = 1;
  
  public abstract int getPlayType();
  
  public abstract int getStaus();
  
  public abstract String getURL();
  
  public abstract void requestPrepare(String paramString, AbsThirdDataSourceAdapter.OnPreparedCallback paramOnPreparedCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.AbsThirdDataSourceAdapter
 * JD-Core Version:    0.7.0.1
 */