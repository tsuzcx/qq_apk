package com.tencent.luggage.wxa.qz;

import android.graphics.BitmapFactory.Options;
import java.util.Arrays;

final class a$a
{
  final StackTraceElement[] a;
  final String b;
  final BitmapFactory.Options c;
  final long d;
  
  a$a(String paramString, BitmapFactory.Options paramOptions)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    this.a = ((StackTraceElement[])Arrays.copyOfRange(arrayOfStackTraceElement, 4, arrayOfStackTraceElement.length));
    this.b = paramString;
    this.c = paramOptions;
    this.d = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.a.a
 * JD-Core Version:    0.7.0.1
 */