package com.tencent.mobileqq.app;

import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import org.xmlpull.v1.XmlSerializer;

final class TroopHandler$8
  extends StructMsgItemCover
{
  TroopHandler$8(String paramString)
  {
    super(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.ac == null) {}
    for (String str = "";; str = this.ac)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.8
 * JD-Core Version:    0.7.0.1
 */