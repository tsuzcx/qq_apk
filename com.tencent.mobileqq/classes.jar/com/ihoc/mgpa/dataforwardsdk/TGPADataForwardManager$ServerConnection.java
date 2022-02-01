package com.ihoc.mgpa.dataforwardsdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.timi.game.utils.Logger;
import java.util.Map;

class TGPADataForwardManager$ServerConnection
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceConnected: ComponentName=");
    localStringBuilder.append(paramComponentName);
    Logger.a("TGPA_DataForward", localStringBuilder.toString());
    paramIBinder = IDataForward.Stub.a(paramIBinder);
    if (paramIBinder != null)
    {
      TGPADataForwardManager.a(this.a).put(paramComponentName.getPackageName(), paramIBinder);
      try
      {
        paramIBinder.a(TGPADataForwardManager.b(this.a));
        return;
      }
      catch (RemoteException paramComponentName)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceDisconnected: ComponentName=");
    localStringBuilder.append(paramComponentName);
    Logger.d("TGPA_DataForward", localStringBuilder.toString());
    TGPADataForwardManager.a(this.a).remove(paramComponentName.getPackageName());
    TGPADataForwardManager.c(this.a).remove(paramComponentName.getPackageName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.ihoc.mgpa.dataforwardsdk.TGPADataForwardManager.ServerConnection
 * JD-Core Version:    0.7.0.1
 */