package com.google.android.exoplayer2.text.cea;

final class Cea708Decoder$DtvCcPacket
{
  int currentIndex;
  public final byte[] packetData;
  public final int packetSize;
  public final int sequenceNumber;
  
  public Cea708Decoder$DtvCcPacket(int paramInt1, int paramInt2)
  {
    this.sequenceNumber = paramInt1;
    this.packetSize = paramInt2;
    this.packetData = new byte[paramInt2 * 2 - 1];
    this.currentIndex = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket
 * JD-Core Version:    0.7.0.1
 */