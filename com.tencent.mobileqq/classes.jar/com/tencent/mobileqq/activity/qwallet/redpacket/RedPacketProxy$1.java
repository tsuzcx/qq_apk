package com.tencent.mobileqq.activity.qwallet.redpacket;

import ajcd;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class RedPacketProxy$1
  extends ResultReceiver
{
  public RedPacketProxy$1(ajcd paramajcd, Handler paramHandler, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramBundle.setClassLoader(getClass().getClassLoader());
    paramBundle = (RedPacketInfoBase)paramBundle.getParcelable("key_red_packet_info");
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      localAppRuntime.runOnUiThread(new RedPacketProxy.1.1(this, paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketProxy.1
 * JD-Core Version:    0.7.0.1
 */