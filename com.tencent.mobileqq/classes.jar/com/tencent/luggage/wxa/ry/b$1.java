package com.tencent.luggage.wxa.ry;

import java.io.PrintStream;

final class b$1
  implements b.a
{
  public void a(int paramInt, String paramString1, String paramString2)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString2);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ry.b.1
 * JD-Core Version:    0.7.0.1
 */