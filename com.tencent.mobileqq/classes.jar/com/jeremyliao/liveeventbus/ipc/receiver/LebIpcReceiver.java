package com.jeremyliao.liveeventbus.ipc.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.jeremyliao.liveeventbus.ipc.decode.IDecoder;
import com.jeremyliao.liveeventbus.ipc.decode.ValueDecoder;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;

public class LebIpcReceiver
  extends BroadcastReceiver
{
  private IDecoder decoder;
  
  public LebIpcReceiver(JsonConverter paramJsonConverter)
  {
    this.decoder = new ValueDecoder(paramJsonConverter);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("intent.action.ACTION_LEB_IPC".equals(paramIntent.getAction())) {}
    try
    {
      paramContext = paramIntent.getStringExtra("leb_ipc_key");
      paramIntent = this.decoder.decode(paramIntent);
      if (paramContext != null) {
        LiveEventBus.get(paramContext).post(paramIntent);
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void setJsonConverter(JsonConverter paramJsonConverter)
  {
    this.decoder = new ValueDecoder(paramJsonConverter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.ipc.receiver.LebIpcReceiver
 * JD-Core Version:    0.7.0.1
 */