package com.tencent.aelight.camera.ae.camera.util;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import java.util.HashMap;

abstract class AIOOperationUpdater$BeautyProcessor
  implements AIOOperationUpdater.IRecoveryOperator
{
  private AIOOperationUpdater.OPERATION_ENUM a;
  
  public AIOOperationUpdater$BeautyProcessor(AIOOperationUpdater paramAIOOperationUpdater, AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM)
  {
    this.a = paramOPERATION_ENUM;
  }
  
  public AIOOperationUpdater.OperationRecoveryInfo a()
  {
    if (AIOOperationUpdater.b(this.b) != null) {
      return (AIOOperationUpdater.OperationRecoveryInfo)AIOOperationUpdater.b(this.b).get(this.a);
    }
    return null;
  }
  
  public boolean a(AEFilterProcessTex paramAEFilterProcessTex)
  {
    AIOOperationUpdater.OperationRecoveryInfo localOperationRecoveryInfo = a();
    if ((paramAEFilterProcessTex != null) && (localOperationRecoveryInfo != null)) {
      return a(paramAEFilterProcessTex, localOperationRecoveryInfo);
    }
    return false;
  }
  
  public abstract boolean a(AEFilterProcessTex paramAEFilterProcessTex, AIOOperationUpdater.OperationRecoveryInfo paramOperationRecoveryInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.BeautyProcessor
 * JD-Core Version:    0.7.0.1
 */