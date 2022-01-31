package com.tencent.device.file;

import aljq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bdcs;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import java.util.HashMap;
import java.util.HashSet;
import ztk;

public class DeviceFileHandler$DeviceNotifyReceiver
  extends BroadcastReceiver
{
  public DeviceFileHandler$DeviceNotifyReceiver(DeviceFileHandler paramDeviceFileHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    long l1;
    label301:
    int j;
    label386:
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    long l2;
                    long l3;
                    do
                    {
                      do
                      {
                        return;
                        paramContext = paramIntent.getAction();
                      } while (paramContext == null);
                      if (!paramContext.equalsIgnoreCase("SmartDevice_OnMiniFileTransferProgress")) {
                        break;
                      }
                      paramContext = paramIntent.getExtras();
                      l1 = paramContext.getLong("cookie", 0L);
                      l2 = paramContext.getLong("progress", 0L);
                      l3 = paramContext.getLong("total", 0L);
                      paramContext = (Session)DeviceFileHandler.a(this.a).get(Long.valueOf(l1));
                    } while (paramContext == null);
                    if (paramContext.uFileSizeSrc == 0L) {
                      paramContext.uFileSizeSrc = l3;
                    }
                    this.a.notifyUI(102, true, new Object[] { paramContext, Float.valueOf((float)((float)l2 * 1.0D / (float)l3)) });
                    return;
                    if (!paramContext.equalsIgnoreCase("SmartDevice_OnMiniFileTransferComplete")) {
                      break;
                    }
                    paramContext = paramIntent.getExtras();
                    l1 = paramContext.getLong("cookie", 0L);
                    i = paramContext.getInt("err_code", 0);
                    str = paramContext.getString("filepath");
                    paramIntent = (Session)DeviceFileHandler.b(this.a).get(Long.valueOf(l1));
                  } while (paramIntent == null);
                  if (this.a.b.contains(Long.valueOf(l1))) {
                    if (!TextUtils.isEmpty(str))
                    {
                      if (str.lastIndexOf(".") > 0)
                      {
                        paramContext = str.substring(str.lastIndexOf("."));
                        paramContext = aljq.aX + "/smart_device/" + System.currentTimeMillis() + paramContext;
                        bdcs.b(str, paramContext);
                        paramIntent.strFilePathSrc = paramContext;
                        this.a.b.remove(Long.valueOf(l1));
                      }
                    }
                    else
                    {
                      if (i == -5103058) {
                        this.a.c.put(Long.valueOf(paramIntent.uSessionID), Integer.valueOf(-5103058));
                      }
                      paramContext = this.a;
                      if (i != 0) {
                        break label386;
                      }
                    }
                  }
                  for (bool = true;; bool = false)
                  {
                    paramContext.notifyUI(103, bool, paramIntent);
                    return;
                    paramContext = ".amr";
                    break;
                    if (!paramIntent.actionInfo.strServiceName.equalsIgnoreCase(ztk.c)) {
                      break label301;
                    }
                    paramIntent.vFileMD5Src = str.getBytes();
                    break label301;
                  }
                  if (!paramContext.equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress")) {
                    break;
                  }
                  paramContext = paramIntent.getExtras();
                } while (paramContext == null);
                this.a.notifyUI(104, true, paramContext);
                return;
                if (!paramContext.equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet")) {
                  break;
                }
                paramContext = paramIntent.getExtras();
              } while (paramContext == null);
              this.a.notifyUI(105, true, paramContext);
              return;
            } while (!paramContext.equalsIgnoreCase("CloudPrintJobNotifyEvent"));
            paramIntent = paramIntent.getExtras();
          } while (paramIntent == null);
          i = paramIntent.getInt("nType", 0);
          String str = paramIntent.getString("strJobId");
          j = paramIntent.getInt("nEventValue", 0);
          paramContext = null;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          paramContext = (Session)DeviceFileHandler.c(this.a).get(Long.valueOf(Long.parseLong(str)));
        } while (paramContext == null);
        switch (i)
        {
        default: 
          return;
        }
      } while (j == 0);
      this.a.notifyUI(103, false, paramContext);
      return;
      if (j == 100)
      {
        this.a.notifyUI(103, true, paramContext);
        return;
      }
      this.a.notifyUI(102, true, new Object[] { paramContext, Float.valueOf((float)(j / 100.0D)) });
      return;
      this.a.c.put(Long.valueOf(paramContext.uSessionID), Integer.valueOf(j));
      this.a.notifyUI(103, false, paramContext);
      return;
      l1 = paramIntent.getLong("uDin", 0L);
    } while (l1 == 0L);
    paramContext = DeviceFileHandler.d(this.a);
    if (j != 3) {}
    for (boolean bool = true;; bool = false)
    {
      paramContext.put(Long.valueOf(l1), Boolean.valueOf(bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileHandler.DeviceNotifyReceiver
 * JD-Core Version:    0.7.0.1
 */