package com.tencent.mobileqq.activity.aio.doodle;

import msg.aio_doodle.DoodleMsgProto.DoodleData;
import msg.aio_doodle.DoodleMsgProto.DoodleHeader;

public abstract interface DoodleMsgTranslator$TranslatorListener
{
  public abstract boolean a(DoodleMsgProto.DoodleData paramDoodleData);
  
  public abstract boolean a(DoodleMsgProto.DoodleHeader paramDoodleHeader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgTranslator.TranslatorListener
 * JD-Core Version:    0.7.0.1
 */