package com.tencent.biz.qqcircle.richframework.sender.iml;

public class QCircleRequestSender
{
  private static volatile QCircleRequestSender a;
  
  public static QCircleRequestSender a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleRequestSender();
        }
      }
      finally {}
    }
    return a;
  }
  
  public QCircleRequestCall b()
  {
    return new QCircleRequestCall();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender
 * JD-Core Version:    0.7.0.1
 */