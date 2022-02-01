package com.tencent.map.tools.net.http;

import com.tencent.map.sdk.a.ft;
import com.tencent.map.tools.net.NetAdapter;

public class HttpCanceler
{
  private NetAdapter a;
  private ft<Boolean> b;
  private boolean c;
  
  public void cancel()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((NetAdapter)localObject).cancel())) {
      this.c = true;
    }
    localObject = this.b;
    if (localObject != null) {
      ((ft)localObject).a(Boolean.valueOf(this.c));
    }
  }
  
  public boolean isCanceled()
  {
    return this.c;
  }
  
  public void setHttpAccessRequest(NetAdapter paramNetAdapter, ft<Boolean> paramft)
  {
    this.a = paramNetAdapter;
    this.b = paramft;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.tools.net.http.HttpCanceler
 * JD-Core Version:    0.7.0.1
 */