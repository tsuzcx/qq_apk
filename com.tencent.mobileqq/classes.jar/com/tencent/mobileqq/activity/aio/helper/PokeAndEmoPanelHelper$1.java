package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.qphone.base.util.QLog;

class PokeAndEmoPanelHelper$1
  implements Runnable
{
  PokeAndEmoPanelHelper$1(PokeAndEmoPanelHelper paramPokeAndEmoPanelHelper) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeAndEmoPanelHelper", 2, "checkPESourceDowned onShow First");
    }
    PokeItemHelper.g(PokeAndEmoPanelHelper.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PokeAndEmoPanelHelper.1
 * JD-Core Version:    0.7.0.1
 */