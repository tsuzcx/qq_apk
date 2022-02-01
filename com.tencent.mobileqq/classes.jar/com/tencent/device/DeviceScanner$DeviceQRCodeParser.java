package com.tencent.device;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class DeviceScanner$DeviceQRCodeParser
{
  public String strDevPid = "";
  public String strDevSN = "";
  public String strDevToken = "";
  public String strTag = "";
  
  public boolean parseQRCodeUrl(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if ((!paramString.startsWith("http://iot.qq.com/add")) && (!paramString.startsWith("https://iot.qq.com/add"))) {
      return false;
    }
    paramString = paramString.substring(paramString.indexOf("?") + 1);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String[] arrayOfString1 = paramString.split("&");
    Object localObject1 = null;
    Object localObject2;
    if (arrayOfString1 != null)
    {
      localObject1 = null;
      paramString = localObject1;
      int i = 0;
      while (i < arrayOfString1.length)
      {
        String[] arrayOfString2 = arrayOfString1[i].split("=");
        localObject2 = localObject1;
        String str = paramString;
        if (arrayOfString2 != null)
        {
          localObject2 = localObject1;
          str = paramString;
          if (arrayOfString2.length == 2) {
            if (arrayOfString2[0].equals("pid"))
            {
              localObject2 = arrayOfString2[1];
              str = paramString;
            }
            else if (arrayOfString2[0].equals("sn"))
            {
              str = arrayOfString2[1];
              localObject2 = localObject1;
            }
            else if (arrayOfString2[0].equals("token"))
            {
              this.strDevToken = arrayOfString2[1];
              localObject2 = localObject1;
              str = paramString;
            }
            else
            {
              localObject2 = localObject1;
              str = paramString;
              if (arrayOfString2[0].equals("addtag"))
              {
                this.strTag = arrayOfString2[1];
                str = paramString;
                localObject2 = localObject1;
              }
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
        paramString = str;
      }
    }
    else
    {
      paramString = null;
    }
    if (!TextUtils.isEmpty(localObject1))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if ((paramString.length() != 16) && (QLog.isColorLevel()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("device qrcode sn: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" is invalid, length:");
        ((StringBuilder)localObject2).append(paramString.length());
        QLog.e("smartdevice::DeviceScanner", 2, ((StringBuilder)localObject2).toString());
      }
      this.strDevSN = paramString;
      this.strDevPid = localObject1;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.DeviceScanner.DeviceQRCodeParser
 * JD-Core Version:    0.7.0.1
 */