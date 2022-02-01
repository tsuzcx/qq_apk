package com.tencent.biz.qqcircle.publish.request;

import com.qq.taf.jce.JceStruct;
import com.tencent.biz.qqcircle.publish.common.IQZoneProtocolListener;
import com.tencent.biz.qqcircle.publish.queue.IUploadQueueListener;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;
import java.util.HashMap;

public abstract class QCircleRequest
  implements SmartParcelable
{
  public static String n = "QzoneNewService.";
  private String a = n;
  @NeedParcel
  private String b;
  @NeedParcel
  private int c;
  @NeedParcel
  private boolean d;
  @NeedParcel
  private long e;
  private String f;
  protected String m = "[upload2]QCircleRequest";
  public transient IQZoneProtocolListener o;
  @NeedParcel
  protected HashMap<Object, Object> p = new HashMap();
  @NeedParcel
  public JceStruct q;
  protected IUploadQueueListener r;
  
  public QCircleRequest() {}
  
  public QCircleRequest(String paramString)
  {
    this(paramString, false);
    this.m = getClass().getSimpleName();
  }
  
  public QCircleRequest(String paramString, boolean paramBoolean)
  {
    this.b = paramString;
    this.d = paramBoolean;
    this.e = System.currentTimeMillis();
    this.m = getClass().getSimpleName();
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(IQZoneProtocolListener paramIQZoneProtocolListener)
  {
    this.o = paramIQZoneProtocolListener;
  }
  
  public void a(IUploadQueueListener paramIUploadQueueListener)
  {
    this.r = paramIUploadQueueListener;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public String e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.request.QCircleRequest
 * JD-Core Version:    0.7.0.1
 */