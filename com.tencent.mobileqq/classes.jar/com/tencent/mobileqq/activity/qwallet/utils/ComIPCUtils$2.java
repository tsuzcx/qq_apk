package com.tencent.mobileqq.activity.qwallet.utils;

import aixw;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public final class ComIPCUtils$2
  extends ResultReceiver
{
  public ComIPCUtils$2(Handler paramHandler, aixw paramaixw, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("res");
      this.jdField_a_of_type_Aixw.a(this.jdField_a_of_type_JavaLangString, paramBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils.2
 * JD-Core Version:    0.7.0.1
 */