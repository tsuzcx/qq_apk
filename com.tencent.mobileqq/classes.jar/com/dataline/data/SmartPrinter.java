package com.dataline.data;

import android.os.Bundle;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SmartPrinter
  extends PrinterEntity
{
  public boolean a(List<FileInfo> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    if (paramString == null) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString.getInt("printCopies");
      paramString.getInt("duplexMode");
      label32:
      boolean bool1 = bool2;
      if (paramList != null)
      {
        bool1 = bool2;
        if (this.c != 0L)
        {
          paramString = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            paramString.add(((FileInfo)paramList.next()).d());
          }
          paramQQAppInterface = (DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          paramList = new Bundle();
          bool1 = true;
          paramList.putInt("copies", 1);
          paramList.putInt("duplexMode", 1);
          paramQQAppInterface = paramQQAppInterface.b();
          String str = DeviceMsgHandle.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.c);
          localStringBuilder.append("");
          paramQQAppInterface.a(str, localStringBuilder.toString(), paramString, paramList);
        }
      }
      return bool1;
    }
    catch (JSONException paramString)
    {
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.data.SmartPrinter
 * JD-Core Version:    0.7.0.1
 */