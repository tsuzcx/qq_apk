package com.tencent.av.wtogether.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_av_together.common.WTogetherCommon.Result;

public class ReqComResult
{
  public final int a;
  public final long a;
  public ReqVideoAction a;
  public String a;
  public boolean a;
  public int b;
  
  public ReqComResult(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    this.b = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction = null;
  }
  
  public ReqComResult(int paramInt, long paramLong, ReqVideoAction paramReqVideoAction)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    this.b = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction = paramReqVideoAction;
  }
  
  public void a(WTogetherCommon.Result paramResult)
  {
    if (paramResult != null) {
      this.b = paramResult.errcode.get();
    } else {
      this.b = -1;
    }
    if (paramResult != null) {
      this.jdField_a_of_type_JavaLangString = paramResult.errmsg.get();
    } else {
      this.jdField_a_of_type_JavaLangString = null;
    }
    boolean bool;
    if (this.b == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ComResult{from: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", roomId: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", isSuccess: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", errCode: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", errMsg: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", action: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.ReqComResult
 * JD-Core Version:    0.7.0.1
 */