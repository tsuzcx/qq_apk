package com.tencent.gdtad.api;

public final class GdtAdError
{
  private int a = -2147483648;
  
  public GdtAdError(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String a()
  {
    switch (a())
    {
    default: 
      return null;
    case 7: 
      return "Display Format Mismatch";
    case 6: 
      return "Server Error";
    case 5: 
      return "No Fill";
    case 4: 
      return "Invalid Request";
    case 3: 
      return "Network Error";
    case 2: 
      return "Ad was re-loaded too frequently";
    case 1: 
      return "Internal Error";
    }
    return "Success";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAdError
 * JD-Core Version:    0.7.0.1
 */