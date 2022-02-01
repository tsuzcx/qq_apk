package com.tencent.biz.qcircleshadow.local;

public class QCircleLoggerFactory$FormattingTuple
{
  public static FormattingTuple a = new FormattingTuple(null);
  private String b;
  private Throwable c;
  private Object[] d;
  
  public QCircleLoggerFactory$FormattingTuple(String paramString)
  {
    this(paramString, null, null);
  }
  
  public QCircleLoggerFactory$FormattingTuple(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    this.b = paramString;
    this.c = paramThrowable;
    this.d = paramArrayOfObject;
  }
  
  public String a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleLoggerFactory.FormattingTuple
 * JD-Core Version:    0.7.0.1
 */