package com.tencent.mobileqq.app;

import azqi;
import azqo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    azqi localazqi = new azqi(this, new azqo());
    try
    {
      localazqi.setOutput(paramByteArrayOutputStream, paramString);
      localazqi.startDocument(paramString, null);
      localazqi.startTag(null, "msg");
      localazqi.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localazqi.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localazqi.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localazqi);
        localazqi.startTag(null, "source");
        localazqi.endTag(null, "source");
        localazqi.endTag(null, "msg");
        localazqi.endDocument();
        localazqi.flush();
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