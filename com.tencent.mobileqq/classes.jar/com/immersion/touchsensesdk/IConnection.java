package com.immersion.touchsensesdk;

public abstract interface IConnection
{
  public abstract void disconnect();
  
  public abstract int getContentLength();
  
  public abstract long getLastModified();
  
  public abstract int getResponseCode();
  
  public abstract byte[] readAllData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.immersion.touchsensesdk.IConnection
 * JD-Core Version:    0.7.0.1
 */