package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class DvbDecoder
  extends SimpleSubtitleDecoder
{
  private final DvbParser parser;
  
  public DvbDecoder(List<byte[]> paramList)
  {
    super("DvbDecoder");
    paramList = new ParsableByteArray((byte[])paramList.get(0));
    this.parser = new DvbParser(paramList.readUnsignedShort(), paramList.readUnsignedShort());
  }
  
  protected DvbSubtitle decode(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.parser.reset();
    }
    return new DvbSubtitle(this.parser.decode(paramArrayOfByte, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.text.dvb.DvbDecoder
 * JD-Core Version:    0.7.0.1
 */