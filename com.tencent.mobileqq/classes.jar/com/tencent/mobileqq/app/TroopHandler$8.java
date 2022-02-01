package com.tencent.mobileqq.app;

import bdok;
import bdoq;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    bdok localbdok = new bdok(this, new bdoq());
    try
    {
      localbdok.setOutput(paramByteArrayOutputStream, paramString);
      localbdok.startDocument(paramString, null);
      localbdok.startTag(null, "msg");
      localbdok.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localbdok.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localbdok.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localbdok);
        localbdok.startTag(null, "source");
        localbdok.endTag(null, "source");
        localbdok.endTag(null, "msg");
        localbdok.endDocument();
        localbdok.flush();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.8
 * JD-Core Version:    0.7.0.1
 */