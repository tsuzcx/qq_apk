package com.tencent.mobileqq.activity.aio.doodle;

import java.io.OutputStream;
import msg.aio_doodle.DoodleMsgProto.DoodleData;
import msg.aio_doodle.DoodleMsgProto.DoodleHeader;

class DoodlePanel$6
  implements DoodleMsgTranslator.TranslatorListener
{
  DoodlePanel$6(DoodlePanel paramDoodlePanel, OutputStream paramOutputStream) {}
  
  public boolean a(DoodleMsgProto.DoodleData paramDoodleData)
  {
    if (paramDoodleData == null) {
      return false;
    }
    paramDoodleData = paramDoodleData.toByteArray();
    byte[] arrayOfByte = DoodleMsgTranslator.a(paramDoodleData.length);
    try
    {
      this.a.write(arrayOfByte);
      this.a.write(paramDoodleData);
      label33:
      return true;
    }
    catch (Exception paramDoodleData)
    {
      break label33;
    }
  }
  
  public boolean a(DoodleMsgProto.DoodleHeader paramDoodleHeader)
  {
    if (paramDoodleHeader == null) {
      return false;
    }
    paramDoodleHeader = paramDoodleHeader.toByteArray();
    byte[] arrayOfByte = DoodleMsgTranslator.a(paramDoodleHeader.length);
    try
    {
      this.a.write(arrayOfByte);
      this.a.write(paramDoodleHeader);
      label33:
      return true;
    }
    catch (Exception paramDoodleHeader)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.6
 * JD-Core Version:    0.7.0.1
 */