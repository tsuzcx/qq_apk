package com.tencent.mobileqq.app;

import com.tencent.mobileqq.structmsg.AbsStructMsg.XmlSerializerWithFilter;
import com.tencent.mobileqq.structmsg.QQXmlSerializer;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

final class TroopHandler$7
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    AbsStructMsg.XmlSerializerWithFilter localXmlSerializerWithFilter = new AbsStructMsg.XmlSerializerWithFilter(this, new QQXmlSerializer());
    try
    {
      localXmlSerializerWithFilter.setOutput(paramByteArrayOutputStream, paramString);
      localXmlSerializerWithFilter.startDocument(paramString, null);
      localXmlSerializerWithFilter.startTag(null, "msg");
      localXmlSerializerWithFilter.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localXmlSerializerWithFilter.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        localXmlSerializerWithFilter.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(localXmlSerializerWithFilter);
        localXmlSerializerWithFilter.startTag(null, "source");
        localXmlSerializerWithFilter.endTag(null, "source");
        localXmlSerializerWithFilter.endTag(null, "msg");
        localXmlSerializerWithFilter.endDocument();
        localXmlSerializerWithFilter.flush();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.7
 * JD-Core Version:    0.7.0.1
 */