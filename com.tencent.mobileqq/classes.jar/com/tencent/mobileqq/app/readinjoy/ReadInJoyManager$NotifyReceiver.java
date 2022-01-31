package com.tencent.mobileqq.app.readinjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.ExecutorService;
import zsu;

public class ReadInJoyManager$NotifyReceiver
  extends BroadcastReceiver
{
  public ReadInJoyManager$NotifyReceiver(ReadInJoyManager paramReadInJoyManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ReadInJoyManager.a(this.a).execute(new zsu(this, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */