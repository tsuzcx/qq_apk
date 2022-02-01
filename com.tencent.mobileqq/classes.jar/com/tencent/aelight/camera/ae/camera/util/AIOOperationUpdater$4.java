package com.tencent.aelight.camera.ae.camera.util;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;

class AIOOperationUpdater$4
  extends AIOOperationUpdater.BeautyProcessor
{
  AIOOperationUpdater$4(AIOOperationUpdater paramAIOOperationUpdater, AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM)
  {
    super(paramAIOOperationUpdater, paramOPERATION_ENUM);
  }
  
  public boolean a(AEFilterProcessTex paramAEFilterProcessTex, AIOOperationUpdater.OperationRecoveryInfo paramOperationRecoveryInfo)
  {
    paramAEFilterProcessTex.b(paramOperationRecoveryInfo.a, paramOperationRecoveryInfo.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.4
 * JD-Core Version:    0.7.0.1
 */