package com.tencent.mobileqq.apollo.api.listener;

public abstract interface OnApolloViewListener
{
  public abstract void onNotifyLongTouch(String paramString);
  
  public abstract void onNotifyStatusChanged(int paramInt, String paramString);
  
  public abstract void onSurfaceReady(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener
 * JD-Core Version:    0.7.0.1
 */