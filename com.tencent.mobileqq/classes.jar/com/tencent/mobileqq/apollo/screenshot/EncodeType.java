package com.tencent.mobileqq.apollo.screenshot;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/EncodeType;", "", "(Ljava/lang/String;I)V", "APNG", "GIF", "FRAME", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum EncodeType
{
  static
  {
    EncodeType localEncodeType1 = new EncodeType("APNG", 0);
    APNG = localEncodeType1;
    EncodeType localEncodeType2 = new EncodeType("GIF", 1);
    GIF = localEncodeType2;
    EncodeType localEncodeType3 = new EncodeType("FRAME", 2);
    FRAME = localEncodeType3;
    $VALUES = new EncodeType[] { localEncodeType1, localEncodeType2, localEncodeType3 };
  }
  
  private EncodeType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.EncodeType
 * JD-Core Version:    0.7.0.1
 */