package com.tencent.mobileqq.apollo.handler;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract interface IVasExtensionHandler
{
  public abstract void a(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.IVasExtensionHandler
 * JD-Core Version:    0.7.0.1
 */