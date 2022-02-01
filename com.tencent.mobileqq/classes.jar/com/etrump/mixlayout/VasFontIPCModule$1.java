package com.etrump.mixlayout;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import eipc.EIPCResult;
import java.io.File;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

class VasFontIPCModule$1
  implements Runnable
{
  VasFontIPCModule$1(VasFontIPCModule paramVasFontIPCModule, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject;
    if (new File(VasSoUtils.a() + "libvipfont8417.so").exists())
    {
      localObject = EIPCResult.createResult(0, null);
      this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject);
    }
    do
    {
      do
      {
        return;
        VasFontIPCModule.a(this.this$0).add(Integer.valueOf(this.jdField_a_of_type_Int));
      } while (!VasFontIPCModule.a(this.this$0).compareAndSet(false, true));
      localObject = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    } while (localObject == null);
    ((IVasQuickUpdateService)localObject).downloadItem(1004L, "libVipFont_8417", "VasFontIPCModule");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.VasFontIPCModule.1
 * JD-Core Version:    0.7.0.1
 */