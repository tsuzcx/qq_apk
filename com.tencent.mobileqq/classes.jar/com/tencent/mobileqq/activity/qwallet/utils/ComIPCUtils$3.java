package com.tencent.mobileqq.activity.qwallet.utils;

import alas;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public final class ComIPCUtils$3
  extends ResultReceiver
{
  public ComIPCUtils$3(Handler paramHandler, alas paramalas, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("res");
      this.jdField_a_of_type_Alas.a(this.jdField_a_of_type_JavaLangString, paramBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils.3
 * JD-Core Version:    0.7.0.1
 */