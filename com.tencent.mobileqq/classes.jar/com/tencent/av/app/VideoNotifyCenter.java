package com.tencent.av.app;

import java.util.Observable;

public class VideoNotifyCenter
  extends Observable
{
  VideoAppInterface a = null;
  
  public VideoNotifyCenter(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null) {
      this.a = paramVideoAppInterface;
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    try
    {
      super.setChanged();
      super.notifyObservers(paramArrayOfObject);
      return;
    }
    finally
    {
      paramArrayOfObject = finally;
      throw paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.VideoNotifyCenter
 * JD-Core Version:    0.7.0.1
 */