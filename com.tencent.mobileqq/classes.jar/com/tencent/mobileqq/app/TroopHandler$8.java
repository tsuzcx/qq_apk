package com.tencent.mobileqq.app;

import bcgv;
import bchb;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    bcgv localbcgv = new bcgv(this, new bchb());
    try
    {
      localbcgv.setOutput(paramByteArrayOutputStream, paramString);
      localbcgv.startDocument(paramString, null);
      localbcgv.startTag(null, "msg");
      localbcgv.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localbcgv.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localbcgv.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localbcgv);
        localbcgv.startTag(null, "source");
        localbcgv.endTag(null, "source");
        localbcgv.endTag(null, "msg");
        localbcgv.endDocument();
        localbcgv.flush();
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