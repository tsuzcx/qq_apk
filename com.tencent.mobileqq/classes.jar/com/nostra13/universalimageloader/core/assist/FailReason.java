package com.nostra13.universalimageloader.core.assist;

public class FailReason
{
  private final Throwable cause;
  private final FailReason.FailType type;
  
  public FailReason(FailReason.FailType paramFailType, Throwable paramThrowable)
  {
    this.type = paramFailType;
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public FailReason.FailType getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.FailReason
 * JD-Core Version:    0.7.0.1
 */