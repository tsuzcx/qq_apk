package com.tencent.comic.utils;

import android.content.Context;
import java.util.Observable;

public class FirstInObservable
  extends Observable
{
  public void a(Context paramContext)
  {
    setChanged();
    notifyObservers(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.utils.FirstInObservable
 * JD-Core Version:    0.7.0.1
 */