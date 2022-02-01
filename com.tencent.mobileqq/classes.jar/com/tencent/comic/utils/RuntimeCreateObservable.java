package com.tencent.comic.utils;

import java.util.Observable;

public class RuntimeCreateObservable
  extends Observable
{
  public void a()
  {
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.utils.RuntimeCreateObservable
 * JD-Core Version:    0.7.0.1
 */