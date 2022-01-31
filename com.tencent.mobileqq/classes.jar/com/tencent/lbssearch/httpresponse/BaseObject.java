package com.tencent.lbssearch.httpresponse;

public class BaseObject
{
  public Exception exception;
  public String message;
  public int status;
  
  public boolean isStatusOk()
  {
    return this.status == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.lbssearch.httpresponse.BaseObject
 * JD-Core Version:    0.7.0.1
 */