package com.tencent.av.utils;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class PopupDialog$1
  extends ResultReceiver
{
  PopupDialog$1(Handler paramHandler, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.onClick(null, paramInt);
      }
    }
    else if (paramInt == 1)
    {
      paramBundle = this.b;
      if (paramBundle != null) {
        paramBundle.onClick(null, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialog.1
 * JD-Core Version:    0.7.0.1
 */