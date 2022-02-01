package com.tencent.beacon.core.network.volley;

public class ParseError
  extends VolleyError
{
  public ParseError() {}
  
  public ParseError(NetworkResponse paramNetworkResponse)
  {
    super(paramNetworkResponse);
  }
  
  public ParseError(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.ParseError
 * JD-Core Version:    0.7.0.1
 */