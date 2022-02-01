package com.tencent.mobileqq.app;

import bdnt;
import bdnz;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    bdnt localbdnt = new bdnt(this, new bdnz());
    try
    {
      localbdnt.setOutput(paramByteArrayOutputStream, paramString);
      localbdnt.startDocument(paramString, null);
      localbdnt.startTag(null, "msg");
      localbdnt.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localbdnt.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localbdnt.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localbdnt);
        localbdnt.startTag(null, "source");
        localbdnt.endTag(null, "source");
        localbdnt.endTag(null, "msg");
        localbdnt.endDocument();
        localbdnt.flush();
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