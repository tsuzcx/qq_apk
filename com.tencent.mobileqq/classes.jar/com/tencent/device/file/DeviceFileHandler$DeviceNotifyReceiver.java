package com.tencent.device.file;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.HashMap;
import java.util.HashSet;

public class DeviceFileHandler$DeviceNotifyReceiver
  extends BroadcastReceiver
{
  public DeviceFileHandler$DeviceNotifyReceiver(DeviceFileHandler paramDeviceFileHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    if (paramContext != null)
    {
      boolean bool3 = paramContext.equalsIgnoreCase("SmartDevice_OnMiniFileTransferProgress");
      boolean bool2 = false;
      boolean bool1 = false;
      long l1;
      double d1;
      if (bool3)
      {
        paramContext = paramIntent.getExtras();
        l1 = paramContext.getLong("cookie", 0L);
        long l2 = paramContext.getLong("progress", 0L);
        long l3 = paramContext.getLong("total", 0L);
        paramContext = (Session)DeviceFileHandler.a(this.a).get(Long.valueOf(l1));
        if (paramContext == null) {
          return;
        }
        if (paramContext.uFileSizeSrc == 0L) {
          paramContext.uFileSizeSrc = l3;
        }
        paramIntent = this.a;
        d1 = (float)l2;
        Double.isNaN(d1);
        double d2 = (float)l3;
        Double.isNaN(d2);
        paramIntent.notifyUI(102, true, new Object[] { paramContext, Float.valueOf((float)(d1 * 1.0D / d2)) });
        return;
      }
      int i;
      Object localObject;
      if (paramContext.equalsIgnoreCase("SmartDevice_OnMiniFileTransferComplete"))
      {
        paramContext = paramIntent.getExtras();
        l1 = paramContext.getLong("cookie", 0L);
        i = paramContext.getInt("err_code", 0);
        localObject = paramContext.getString("filepath");
        paramIntent = (Session)DeviceFileHandler.b(this.a).get(Long.valueOf(l1));
        if (paramIntent == null) {
          return;
        }
        if (this.a.d.contains(Long.valueOf(l1)))
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (((String)localObject).lastIndexOf(".") > 0) {
              paramContext = ((String)localObject).substring(((String)localObject).lastIndexOf("."));
            } else {
              paramContext = ".amr";
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(AppConstants.SDCARD_PATH);
            localStringBuilder.append("/smart_device/");
            localStringBuilder.append(System.currentTimeMillis());
            localStringBuilder.append(paramContext);
            paramContext = localStringBuilder.toString();
            FileUtils.moveFile((String)localObject, paramContext);
            paramIntent.strFilePathSrc = paramContext;
            this.a.d.remove(Long.valueOf(l1));
          }
        }
        else if (paramIntent.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.c)) {
          paramIntent.vFileMD5Src = ((String)localObject).getBytes();
        }
        if (i == -5103058) {
          this.a.e.put(Long.valueOf(paramIntent.uSessionID), Integer.valueOf(-5103058));
        }
        paramContext = this.a;
        if (i == 0) {
          bool1 = true;
        }
        paramContext.notifyUI(103, bool1, paramIntent);
        return;
      }
      if (paramContext.equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress"))
      {
        paramContext = paramIntent.getExtras();
        if (paramContext != null) {
          this.a.notifyUI(104, true, paramContext);
        }
      }
      else if (paramContext.equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet"))
      {
        paramContext = paramIntent.getExtras();
        if (paramContext != null) {
          this.a.notifyUI(105, true, paramContext);
        }
      }
      else if (paramContext.equalsIgnoreCase("CloudPrintJobNotifyEvent"))
      {
        localObject = paramIntent.getExtras();
        if (localObject != null)
        {
          i = ((Bundle)localObject).getInt("nType", 0);
          paramIntent = ((Bundle)localObject).getString("strJobId");
          int j = ((Bundle)localObject).getInt("nEventValue", 0);
          paramContext = null;
          if (!TextUtils.isEmpty(paramIntent))
          {
            paramIntent = (Session)DeviceFileHandler.c(this.a).get(Long.valueOf(Long.parseLong(paramIntent)));
            paramContext = paramIntent;
            if (paramIntent == null) {
              return;
            }
          }
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4) {
                  return;
                }
                l1 = ((Bundle)localObject).getLong("uDin", 0L);
                if (l1 != 0L)
                {
                  paramContext = DeviceFileHandler.d(this.a);
                  bool1 = bool2;
                  if (j != 3) {
                    bool1 = true;
                  }
                  paramContext.put(Long.valueOf(l1), Boolean.valueOf(bool1));
                }
              }
              else
              {
                this.a.e.put(Long.valueOf(paramContext.uSessionID), Integer.valueOf(j));
                this.a.notifyUI(103, false, paramContext);
              }
            }
            else
            {
              if (j == 100)
              {
                this.a.notifyUI(103, true, paramContext);
                return;
              }
              paramIntent = this.a;
              d1 = j;
              Double.isNaN(d1);
              paramIntent.notifyUI(102, true, new Object[] { paramContext, Float.valueOf((float)(d1 / 100.0D)) });
            }
          }
          else if (j != 0) {
            this.a.notifyUI(103, false, paramContext);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileHandler.DeviceNotifyReceiver
 * JD-Core Version:    0.7.0.1
 */