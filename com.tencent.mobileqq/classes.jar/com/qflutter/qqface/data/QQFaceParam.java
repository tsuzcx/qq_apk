package com.qflutter.qqface.data;

import io.flutter.plugin.common.MethodCall;

public class QQFaceParam
{
  private static final String PARAM_ACCOUNT = "account";
  private static final String PARAM_FACE_ID_TYPE = "face_id_type";
  private static final String PARAM_FACE_SHAPE = "face_shape";
  private static final String PARAM_FACE_SIZE = "face_size";
  private static final String PARAM_FACE_TYPE = "face_type";
  private static final String PARAM_FORCE_SHAPE = "force_shape";
  public String account;
  public int faceShape = -1;
  public int faceType = -1;
  public int forceShape = 0;
  
  public QQFaceParam() {}
  
  public QQFaceParam(MethodCall paramMethodCall)
  {
    this.account = ((String)paramMethodCall.argument("account"));
    if (paramMethodCall.argument("face_type") != null) {
      this.faceType = ((Integer)paramMethodCall.argument("face_type")).intValue();
    }
    if (paramMethodCall.argument("face_shape") != null) {
      this.faceShape = ((Integer)paramMethodCall.argument("face_shape")).intValue();
    }
  }
  
  public String getFaceId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.account);
    localStringBuilder.append("_");
    localStringBuilder.append(this.faceType);
    localStringBuilder.append("_");
    localStringBuilder.append(this.faceShape);
    localStringBuilder.append("_");
    localStringBuilder.append(this.forceShape);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqface.data.QQFaceParam
 * JD-Core Version:    0.7.0.1
 */