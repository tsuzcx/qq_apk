package com.tencent.av.camera;

import java.util.Observable;

public class CameraNotifyCenter
  extends Observable
{
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.camera.CameraNotifyCenter
 * JD-Core Version:    0.7.0.1
 */