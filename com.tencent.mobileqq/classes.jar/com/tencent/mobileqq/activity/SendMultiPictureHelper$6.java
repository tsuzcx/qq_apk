package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

class SendMultiPictureHelper$6
  implements INetEventHandler
{
  SendMultiPictureHelper$6(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Toast.makeText(BaseApplicationImpl.getApplication(), this.a.a.getString(2131892112), 1).show();
      SendMultiPictureHelper.6.1 local1 = new SendMultiPictureHelper.6.1(this);
      new Handler().postDelayed(local1, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper.6
 * JD-Core Version:    0.7.0.1
 */