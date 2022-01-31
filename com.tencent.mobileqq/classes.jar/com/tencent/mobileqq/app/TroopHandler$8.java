package com.tencent.mobileqq.app;

import awuk;
import awuq;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    awuk localawuk = new awuk(this, new awuq());
    try
    {
      localawuk.setOutput(paramByteArrayOutputStream, paramString);
      localawuk.startDocument(paramString, null);
      localawuk.startTag(null, "msg");
      localawuk.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localawuk.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localawuk.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localawuk);
        localawuk.startTag(null, "source");
        localawuk.endTag(null, "source");
        localawuk.endTag(null, "msg");
        localawuk.endDocument();
        localawuk.flush();
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