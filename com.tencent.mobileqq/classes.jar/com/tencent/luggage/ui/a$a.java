package com.tencent.luggage.ui;

import android.content.Context;
import java.util.LinkedList;
import java.util.Queue;

public final class a$a
{
  private static final Queue<a> a = new LinkedList();
  
  public static a a(Context paramContext)
  {
    a locala = (a)a.poll();
    if (locala != null)
    {
      a.a(locala, paramContext);
      return locala;
    }
    return new a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.a.a
 * JD-Core Version:    0.7.0.1
 */