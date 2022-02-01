package com.tencent.luggage.wxa.dw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

class a$1
  extends ResultReceiver
{
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((4660 == paramInt) && (paramBundle != null))
    {
      paramBundle = (Intent)paramBundle.getParcelable("intent");
      if (paramBundle != null)
      {
        paramBundle.setFlags(paramBundle.getFlags() & 0xEFFFFFFF);
        this.a.startActivity(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dw.a.1
 * JD-Core Version:    0.7.0.1
 */