package com.tencent.TMG.sdk;

public class InternalEnterParam
  extends AVRoomMulti.EnterParam
{
  protected int bussType;
  protected byte[] extraData;
  protected byte[] freeFlowSignature;
  protected int relationType;
  
  public InternalEnterParam(InternalEnterParam.InternalEnterRoomParamBuilder paramInternalEnterRoomParamBuilder)
  {
    super(paramInternalEnterRoomParamBuilder);
    this.bussType = paramInternalEnterRoomParamBuilder.bussType;
    this.relationType = paramInternalEnterRoomParamBuilder.relationType;
    this.extraData = paramInternalEnterRoomParamBuilder.extraData;
    this.freeFlowSignature = paramInternalEnterRoomParamBuilder.freeFlowSignature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.InternalEnterParam
 * JD-Core Version:    0.7.0.1
 */