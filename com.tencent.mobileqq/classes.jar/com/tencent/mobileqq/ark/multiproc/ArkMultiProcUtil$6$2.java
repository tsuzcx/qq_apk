package com.tencent.mobileqq.ark.multiproc;

import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.mobileqq.app.BusinessObserver;

class ArkMultiProcUtil$6$2
  implements BusinessObserver
{
  ArkMultiProcUtil$6$2(ArkMultiProcUtil.6 param6, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback != null) {
      this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil.6.2
 * JD-Core Version:    0.7.0.1
 */