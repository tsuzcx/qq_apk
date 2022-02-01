package com.tencent.aelight.camera.ae.camera.util;

import java.util.concurrent.CopyOnWriteArrayList;

class AIOOperationUpdater$BeautyConfig
  implements AIOOperationUpdater.IOperateConfig
{
  private AIOOperationUpdater.OPERATION_ENUM b;
  
  public AIOOperationUpdater$BeautyConfig(AIOOperationUpdater paramAIOOperationUpdater, AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM)
  {
    this.b = paramOPERATION_ENUM;
  }
  
  public boolean a()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = AIOOperationUpdater.a(this.a);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localCopyOnWriteArrayList != null)
    {
      bool1 = bool2;
      if (AIOOperationUpdater.a(this.a).contains(this.b))
      {
        if (!AIOOperationUpdater.a(this.a).contains(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION)) {
          return true;
        }
        int i = AIOOperationUpdater.a(this.a).indexOf(this.b);
        if (AIOOperationUpdater.a(this.a).indexOf(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION) > i) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.BeautyConfig
 * JD-Core Version:    0.7.0.1
 */