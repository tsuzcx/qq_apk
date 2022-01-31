package com.tencent.biz.qqstory.takevideo.rmw;

import java.util.Observable;

public class SimpleObservable
  extends Observable
{
  public void notifyObservers()
  {
    setChanged();
    super.notifyObservers();
  }
  
  public void notifyObservers(Object paramObject)
  {
    setChanged();
    super.notifyObservers(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.SimpleObservable
 * JD-Core Version:    0.7.0.1
 */