package com.tencent.biz.qqcircle.publish.common;

import android.os.Bundle;
import com.tencent.biz.qqcircle.publish.common.feedInterface.IResult;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;

public class QCircleResult
  implements IResult, SmartParcelable, Cloneable
{
  @NeedParcel
  public int a;
  @NeedParcel
  private int b;
  @NeedParcel
  private int c;
  @NeedParcel
  private String d;
  @NeedParcel
  private Object e;
  @NeedParcel
  private final Bundle f = new Bundle();
  
  public QCircleResult() {}
  
  public QCircleResult(QCircleResult paramQCircleResult)
  {
    this.a = paramQCircleResult.a;
    this.b = paramQCircleResult.b;
    this.c = paramQCircleResult.c;
    this.d = paramQCircleResult.d;
    this.e = paramQCircleResult.e;
  }
  
  public QCircleResult a()
  {
    return new QCircleResult(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.common.QCircleResult
 * JD-Core Version:    0.7.0.1
 */