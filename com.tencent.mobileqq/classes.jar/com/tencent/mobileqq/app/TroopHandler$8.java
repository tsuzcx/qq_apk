package com.tencent.mobileqq.app;

import bcvr;
import bcvx;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    bcvr localbcvr = new bcvr(this, new bcvx());
    try
    {
      localbcvr.setOutput(paramByteArrayOutputStream, paramString);
      localbcvr.startDocument(paramString, null);
      localbcvr.startTag(null, "msg");
      localbcvr.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localbcvr.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localbcvr.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localbcvr);
        localbcvr.startTag(null, "source");
        localbcvr.endTag(null, "source");
        localbcvr.endTag(null, "msg");
        localbcvr.endDocument();
        localbcvr.flush();
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