package com.etrump.mixlayout;

import bdom;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import eipc.EIPCResult;
import gh;
import java.io.File;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class VasFontIPCModule$1
  implements Runnable
{
  public VasFontIPCModule$1(gh paramgh, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject;
    if (new File(bdom.a() + "libvipfont808.so").exists())
    {
      localObject = EIPCResult.createResult(0, null);
      this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject);
    }
    do
    {
      do
      {
        return;
        gh.a(this.this$0).add(Integer.valueOf(this.jdField_a_of_type_Int));
      } while (!gh.a(this.this$0).compareAndSet(false, true));
      localObject = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
    } while (localObject == null);
    ((VasQuickUpdateManager)localObject).downloadItem(1004L, "libVipFont_808", "VasFontIPCModule");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.VasFontIPCModule.1
 * JD-Core Version:    0.7.0.1
 */