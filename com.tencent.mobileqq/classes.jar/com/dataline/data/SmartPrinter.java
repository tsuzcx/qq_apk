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
    if (paramString == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new JSONObject(paramString);
        paramString.getInt("printCopies");
        paramString.getInt("duplexMode");
        label29:
        if ((paramList == null) || (this.a == 0L)) {
          continue;
        }
        paramString = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          paramString.add(((FileInfo)paramList.next()).c());
        }
        paramList = (DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putInt("copies", 1);
        paramQQAppInterface.putInt("duplexMode", 1);
        paramList.a().a(DeviceMsgHandle.c, this.a + "", paramString, paramQQAppInterface);
        return true;
      }
      catch (JSONException paramString)
      {
        break label29;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.data.SmartPrinter
 * JD-Core Version:    0.7.0.1
 */