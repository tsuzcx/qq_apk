package com.google.gson.internal;

public final class $Gson$Preconditions
{
  private $Gson$Preconditions()
  {
    throw new UnsupportedOperationException();
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal..Gson.Preconditions
 * JD-Core Version:    0.7.0.1
 */