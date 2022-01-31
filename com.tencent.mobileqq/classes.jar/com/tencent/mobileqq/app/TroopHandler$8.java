package com.tencent.mobileqq.app;

import axuo;
import axuu;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    axuo localaxuo = new axuo(this, new axuu());
    try
    {
      localaxuo.setOutput(paramByteArrayOutputStream, paramString);
      localaxuo.startDocument(paramString, null);
      localaxuo.startTag(null, "msg");
      localaxuo.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localaxuo.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localaxuo.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localaxuo);
        localaxuo.startTag(null, "source");
        localaxuo.endTag(null, "source");
        localaxuo.endTag(null, "msg");
        localaxuo.endDocument();
        localaxuo.flush();
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