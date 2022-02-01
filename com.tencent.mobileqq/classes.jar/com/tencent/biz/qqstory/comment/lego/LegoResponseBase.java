package com.tencent.biz.qqstory.comment.lego;

import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public abstract class LegoResponseBase
{
  public int d;
  public String e;
  
  public LegoResponseBase() {}
  
  public LegoResponseBase(qqstory_struct.ErrorInfo paramErrorInfo)
  {
    this.d = paramErrorInfo.error_code.get();
    this.e = paramErrorInfo.error_desc.get().toStringUtf8();
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt, Bundle paramBundle);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.lego.LegoResponseBase
 * JD-Core Version:    0.7.0.1
 */