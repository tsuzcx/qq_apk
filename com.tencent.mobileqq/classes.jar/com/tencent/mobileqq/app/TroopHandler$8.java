package com.tencent.mobileqq.app;

import azur;
import azux;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    azur localazur = new azur(this, new azux());
    try
    {
      localazur.setOutput(paramByteArrayOutputStream, paramString);
      localazur.startDocument(paramString, null);
      localazur.startTag(null, "msg");
      localazur.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localazur.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localazur.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localazur);
        localazur.startTag(null, "source");
        localazur.endTag(null, "source");
        localazur.endTag(null, "msg");
        localazur.endDocument();
        localazur.flush();
        return;
      }
      return;
    }
    catch (Exception paramByteArrayOutputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.8
 * JD-Core Version:    0.7.0.1
 */