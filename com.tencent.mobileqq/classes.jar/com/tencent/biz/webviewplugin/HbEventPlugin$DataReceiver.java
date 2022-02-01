package com.tencent.biz.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class HbEventPlugin$DataReceiver
  extends BroadcastReceiver
{
  public String a;
  public String b;
  public int c;
  
  private HbEventPlugin$DataReceiver(HbEventPlugin paramHbEventPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("bc_seq", -1);
    if (i < 0)
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("DataReceive | onReceive sequence = ");
        paramContext.append(i);
        paramContext.append("| wrong seq");
        QLog.d("PortalManager.HbEventPlugin", 2, paramContext.toString());
      }
      return;
    }
    if (i != this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive sequence != seq | miss hit");
      }
      return;
    }
    paramContext = paramIntent.getExtras();
    byte[] arrayOfByte = paramContext.getByteArray("bc_data");
    i = paramIntent.getIntExtra("portal_type_key", -1);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive data = null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      if (i == 1009) {
        paramContext = "REQ_TYPE_GET_HEAD returned";
      } else {
        paramContext = paramContext.toString();
      }
      paramIntent = new StringBuilder();
      paramIntent.append("DataReceiver.onReceive | ");
      paramIntent.append(i);
      paramIntent.append(",");
      paramIntent.append(this.c);
      paramIntent.append(",");
      paramIntent.append(this.a);
      paramIntent.append(",");
      paramIntent.append(paramContext);
      QLog.d("PortalManager.HbEventPlugin", 2, paramIntent.toString());
    }
    switch (i)
    {
    default: 
      return;
    }
    this.d.b(this.c);
    paramIntent = PortalUtils.b(arrayOfByte);
    paramContext = paramIntent;
    if (paramIntent == null)
    {
      paramContext = new JSONObject();
      try
      {
        paramContext.put("errorCode", -1);
        paramContext = paramContext.toString();
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        paramContext = paramIntent;
      }
    }
    this.d.a(this.a, new String[] { paramContext });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HbEventPlugin.DataReceiver
 * JD-Core Version:    0.7.0.1
 */