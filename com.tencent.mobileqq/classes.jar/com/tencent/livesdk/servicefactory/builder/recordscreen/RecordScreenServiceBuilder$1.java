package com.tencent.livesdk.servicefactory.builder.recordscreen;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilivesdk.recordservice_interface.RecordServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class RecordScreenServiceBuilder$1
  implements RecordServiceAdapter
{
  RecordScreenServiceBuilder$1(RecordScreenServiceBuilder paramRecordScreenServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public ToastInterface getToastUtil()
  {
    return (ToastInterface)this.val$serviceManager.getService(ToastInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.recordscreen.RecordScreenServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */