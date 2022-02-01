package com.heytap.msp.push.callback;

import android.content.Context;
import com.heytap.msp.push.mode.DataMessage;

public abstract interface IDataMessageCallBackService
{
  public abstract void processMessage(Context paramContext, DataMessage paramDataMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.msp.push.callback.IDataMessageCallBackService
 * JD-Core Version:    0.7.0.1
 */