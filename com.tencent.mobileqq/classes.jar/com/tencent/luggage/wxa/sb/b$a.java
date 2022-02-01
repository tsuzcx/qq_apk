package com.tencent.luggage.wxa.sb;

import android.database.Cursor;
import android.database.CursorWrapper;

public class b$a
  extends CursorWrapper
{
  b$a(b paramb, Cursor paramCursor)
  {
    super(paramCursor);
  }
  
  public a.a a()
  {
    String str = getString(0);
    double d1 = getDouble(1);
    double d2 = getDouble(2);
    return new a.a(str, (float)d1, d2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sb.b.a
 * JD-Core Version:    0.7.0.1
 */