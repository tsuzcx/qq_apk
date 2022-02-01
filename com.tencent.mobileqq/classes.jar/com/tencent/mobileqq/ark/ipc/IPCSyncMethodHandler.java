package com.tencent.mobileqq.ark.ipc;

import android.os.Bundle;
import eipc.EIPCResult;

public abstract interface IPCSyncMethodHandler
  extends IPCMethodHandler
{
  public abstract EIPCResult a(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ipc.IPCSyncMethodHandler
 * JD-Core Version:    0.7.0.1
 */