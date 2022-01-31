package com.tencent.mobileqq.app;

import axum;
import axus;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    axum localaxum = new axum(this, new axus());
    try
    {
      localaxum.setOutput(paramByteArrayOutputStream, paramString);
      localaxum.startDocument(paramString, null);
      localaxum.startTag(null, "msg");
      localaxum.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localaxum.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localaxum.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localaxum);
        localaxum.startTag(null, "source");
        localaxum.endTag(null, "source");
        localaxum.endTag(null, "msg");
        localaxum.endDocument();
        localaxum.flush();
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