package com.tencent.ilivesdk.recordservice_interface;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;

public abstract interface RecordServiceAdapter
{
  public abstract LogInterface getLogger();
  
  public abstract ToastInterface getToastUtil();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.recordservice_interface.RecordServiceAdapter
 * JD-Core Version:    0.7.0.1
 */