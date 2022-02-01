package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.Messenger;

public class RMWMessengerObserver
{
  public final Messenger a;
  public final String a;
  protected boolean a;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (RMWMessengerObserver)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWMessengerObserver
 * JD-Core Version:    0.7.0.1
 */