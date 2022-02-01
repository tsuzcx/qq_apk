package com.tencent.av.wtogether.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_av_together.common.WTogetherCommon.Result;

public class ReqComResult
{
  public final int a;
  public final long b;
  public boolean c;
  public int d;
  public String e;
  public ReqVideoAction f;
  
  public ReqComResult(int paramInt, long paramLong)
  {
    this.a = paramInt;
    this.b = paramLong;
    this.c = false;
    this.d = -1;
    this.e = null;
    this.f = null;
  }
  
  public ReqComResult(int paramInt, long paramLong, ReqVideoAction paramReqVideoAction)
  {
    this.a = paramInt;
    this.b = paramLong;
    this.c = false;
    this.d = -1;
    this.e = null;
    this.f = paramReqVideoAction;
  }
  
  public void a(WTogetherCommon.Result paramResult)
  {
    if (paramResult != null) {
      this.d = paramResult.errcode.get();
    } else {
      this.d = -1;
    }
    if (paramResult != null) {
      this.e = paramResult.errmsg.get();
    } else {
      this.e = null;
    }
    boolean bool;
    if (this.d == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ComResult{from: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", roomId: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isSuccess: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", errCode: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", errMsg: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", action: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.ReqComResult
 * JD-Core Version:    0.7.0.1
 */