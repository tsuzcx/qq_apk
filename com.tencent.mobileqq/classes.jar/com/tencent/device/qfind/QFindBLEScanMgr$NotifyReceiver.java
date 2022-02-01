package com.tencent.device.qfind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.device.ble.JNIEngineLite;
import com.tencent.device.ble.QFindGattManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class QFindBLEScanMgr$NotifyReceiver
  extends BroadcastReceiver
{
  public QFindBLEScanMgr$NotifyReceiver(QFindBLEScanMgr paramQFindBLEScanMgr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFindBLEScanMgr NotifyReceiver onReceive action=");
      localStringBuilder.append(paramContext);
      QLog.i("QFindBLE", 2, localStringBuilder.toString());
    }
    boolean bool = "com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED".equals(paramContext);
    StringBuilder localStringBuilder = null;
    int i;
    if (bool)
    {
      i = paramIntent.getExtras().getInt("com.tencent.device.ble.EXTRA_BLEID");
      paramIntent = this.a.r.values().iterator();
      while (paramIntent.hasNext())
      {
        paramContext = (BlePeerInfo)paramIntent.next();
        if (paramContext.i == i) {
          break label120;
        }
      }
      paramContext = null;
      label120:
      if (paramContext == null)
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("QFindBLEScanMgr GATT_SERVICES_DISCOVERED bleId ");
          paramContext.append(i);
          paramContext.append(" is not in mReportedDevice");
          QLog.i("QFindBLE", 2, paramContext.toString());
        }
        return;
      }
      paramContext = JNIEngineLite.packVerifyReq((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
      QFindGattManager.a().a(i, paramContext);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("QFindBLEScanMgr GATT_SERVICES_DISCOVERED bleId ");
        paramContext.append(i);
        QLog.i("QFindBLE", 2, paramContext.toString());
      }
    }
    else
    {
      if ("onDeviceVerifyRsp".equals(paramContext))
      {
        paramContext = paramIntent.getExtras();
        i = paramContext.getInt("bleId");
        paramIntent = paramContext.getByteArray("buffer");
        Iterator localIterator = this.a.r.values().iterator();
        do
        {
          paramContext = localStringBuilder;
          if (!localIterator.hasNext()) {
            break;
          }
          paramContext = (BlePeerInfo)localIterator.next();
        } while (paramContext.i != i);
        if (paramContext == null)
        {
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("QFindBLEScanMgr onDeviceVerifyRsp bleId ");
            paramContext.append(i);
            paramContext.append(" is not in mReportedDevice");
            QLog.i("QFindBLE", 2, paramContext.toString());
          }
          return;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("QFindBLEScanMgr onDeviceVerifyRsp bleId ");
          localStringBuilder.append(i);
          localStringBuilder.append(": data ");
          localStringBuilder.append(paramIntent.length);
          QLog.i("QFindBLE", 2, localStringBuilder.toString());
        }
        if (!paramContext.m)
        {
          paramContext.k = paramIntent;
          QFindBLEScanMgr.a(this.a, paramContext, paramContext.j, true);
          paramIntent = new StringBuilder();
          paramIntent.append("");
          paramIntent.append(paramContext.e);
          paramIntent.append("|");
          paramIntent.append(paramContext.a());
          paramIntent = paramIntent.toString();
          paramContext.m = true;
          paramContext.n = false;
          paramIntent = (BlePeerInfo)this.a.r.put(paramIntent, paramContext);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("QFindBLEScanMgr onDeviceVerifyRsp old bleId ");
            localStringBuilder.append(paramIntent.i);
            localStringBuilder.append(" ; reported = ");
            localStringBuilder.append(paramIntent.m);
            QLog.i("QFindBLE", 2, localStringBuilder.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("QFindBLEScanMgr onDeviceVerifyRsp report already bleId ");
          paramIntent.append(i);
          paramIntent.append(" ; reported = ");
          paramIntent.append(paramContext.m);
          QLog.i("QFindBLE", 2, paramIntent.toString());
        }
        QFindGattManager.a().b(paramContext.a());
        return;
      }
      if ("QFIND_BLE_CONNECT_ERROR".equals(paramContext))
      {
        i = paramIntent.getExtras().getInt("bleId");
        paramIntent = this.a.r.values().iterator();
        while (paramIntent.hasNext())
        {
          paramContext = (BlePeerInfo)paramIntent.next();
          if (paramContext.i == i) {
            break label702;
          }
        }
        paramContext = null;
        label702:
        if (paramContext == null)
        {
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR bleId ");
            paramContext.append(i);
            paramContext.append(" is not in mReportedDevice");
            QLog.i("QFindBLE", 2, paramContext.toString());
          }
          return;
        }
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR bleId ");
          paramIntent.append(i);
          paramIntent.append(" ; reported = ");
          paramIntent.append(paramContext.m);
          QLog.i("QFindBLE", 2, paramIntent.toString());
        }
        if (!paramContext.m)
        {
          QFindBLEScanMgr.a(this.a, paramContext, paramContext.j, false);
          paramIntent = new StringBuilder();
          paramIntent.append("");
          paramIntent.append(paramContext.e);
          paramIntent.append("|");
          paramIntent.append(paramContext.a());
          paramIntent = paramIntent.toString();
          paramContext.m = true;
          paramContext.n = false;
          paramContext = (BlePeerInfo)this.a.r.put(paramIntent, paramContext);
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR old bleId ");
            paramIntent.append(paramContext.i);
            paramIntent.append(" ; reported = ");
            paramIntent.append(paramContext.m);
            QLog.i("QFindBLE", 2, paramIntent.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR report already bleId ");
          paramIntent.append(i);
          paramIntent.append(" ; reported = ");
          paramIntent.append(paramContext.m);
          QLog.i("QFindBLE", 2, paramIntent.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */