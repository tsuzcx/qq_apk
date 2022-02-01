package com.tencent.ilivesdk.violationstrikeservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface ViolationStrikeServiceInterface
  extends ServiceBaseInterface
{
  public abstract void init(ViolationStrikeServiceAdapter paramViolationStrikeServiceAdapter);
  
  public abstract void setOnStrikeListener(ViolationStrikeServiceInterface.ViolationStrikeListener paramViolationStrikeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.violationstrikeservice_interface.ViolationStrikeServiceInterface
 * JD-Core Version:    0.7.0.1
 */