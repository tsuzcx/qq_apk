package com.qflutter.qqface.data;

import io.flutter.plugin.common.MethodCall;

public class QQFaceParam
{
  private static final String PARAM_ACCOUNT = "account";
  private static final String PARAM_FACE_ID_TYPE = "face_id_type";
  private static final String PARAM_FACE_SHAPE = "face_shape";
  private static final String PARAM_FACE_SIZE = "face_size";
  private static final String PARAM_FACE_TYPE = "face_type";
  public String account;
  public String faceId;
  public int faceShape = -1;
  public int faceType = -1;
  
  public QQFaceParam(MethodCall paramMethodCall)
  {
    this.account = ((String)paramMethodCall.argument("account"));
    if (paramMethodCall.argument("face_type") != null) {
      this.faceType = ((Integer)paramMethodCall.argument("face_type")).intValue();
    }
    if (paramMethodCall.argument("face_shape") != null) {
      this.faceShape = ((Integer)paramMethodCall.argument("face_shape")).intValue();
    }
    this.faceId = getFaceId();
  }
  
  private String getFaceId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.account);
    localStringBuilder.append("_");
    localStringBuilder.append(this.faceType);
    localStringBuilder.append("_");
    localStringBuilder.append(this.faceShape);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQFaceRequest{account='");
    localStringBuilder.append(this.account);
    localStringBuilder.append('\'');
    localStringBuilder.append(", faceType=");
    localStringBuilder.append(this.faceType);
    localStringBuilder.append(", faceShape=");
    localStringBuilder.append(this.faceShape);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqface.data.QQFaceParam
 * JD-Core Version:    0.7.0.1
 */