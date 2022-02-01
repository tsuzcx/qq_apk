package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;

final class VorbisReader
  extends StreamReader
{
  private VorbisUtil.CommentHeader commentHeader;
  private int previousPacketBlockSize;
  private boolean seenFirstAudioPacket;
  private VorbisUtil.VorbisIdHeader vorbisIdHeader;
  private VorbisReader.VorbisSetup vorbisSetup;
  
  static void appendNumberOfSamples(ParsableByteArray paramParsableByteArray, long paramLong)
  {
    paramParsableByteArray.setLimit(paramParsableByteArray.limit() + 4);
    paramParsableByteArray.data[(paramParsableByteArray.limit() - 4)] = ((byte)(int)(paramLong & 0xFF));
    paramParsableByteArray.data[(paramParsableByteArray.limit() - 3)] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    paramParsableByteArray.data[(paramParsableByteArray.limit() - 2)] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    paramParsableByteArray.data[(paramParsableByteArray.limit() - 1)] = ((byte)(int)(paramLong >>> 24 & 0xFF));
  }
  
  private static int decodeBlockSize(byte paramByte, VorbisReader.VorbisSetup paramVorbisSetup)
  {
    int i = readBits(paramByte, paramVorbisSetup.iLogModes, 1);
    if (!paramVorbisSetup.modes[i].blockFlag) {
      return paramVorbisSetup.idHeader.blockSize0;
    }
    return paramVorbisSetup.idHeader.blockSize1;
  }
  
  static int readBits(byte paramByte, int paramInt1, int paramInt2)
  {
    return paramByte >> paramInt2 & 255 >>> 8 - paramInt1;
  }
  
  public static boolean verifyBitstreamType(ParsableByteArray paramParsableByteArray)
  {
    try
    {
      boolean bool = VorbisUtil.verifyVorbisHeaderCapturePattern(1, paramParsableByteArray, true);
      return bool;
    }
    catch (ParserException paramParsableByteArray) {}
    return false;
  }
  
  protected void onSeekEnd(long paramLong)
  {
    int i = 0;
    super.onSeekEnd(paramLong);
    if (paramLong != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.seenFirstAudioPacket = bool;
      if (this.vorbisIdHeader != null) {
        i = this.vorbisIdHeader.blockSize0;
      }
      this.previousPacketBlockSize = i;
      return;
    }
  }
  
  protected long preparePayload(ParsableByteArray paramParsableByteArray)
  {
    int i = 0;
    if ((paramParsableByteArray.data[0] & 0x1) == 1) {
      return -1L;
    }
    int j = decodeBlockSize(paramParsableByteArray.data[0], this.vorbisSetup);
    if (this.seenFirstAudioPacket) {
      i = (this.previousPacketBlockSize + j) / 4;
    }
    appendNumberOfSamples(paramParsableByteArray, i);
    this.seenFirstAudioPacket = true;
    this.previousPacketBlockSize = j;
    return i;
  }
  
  protected boolean readHeaders(ParsableByteArray paramParsableByteArray, long paramLong, StreamReader.SetupData paramSetupData)
  {
    if (this.vorbisSetup != null) {
      return false;
    }
    this.vorbisSetup = readSetupHeaders(paramParsableByteArray);
    if (this.vorbisSetup == null) {
      return true;
    }
    paramParsableByteArray = new ArrayList();
    paramParsableByteArray.add(this.vorbisSetup.idHeader.data);
    paramParsableByteArray.add(this.vorbisSetup.setupHeaderData);
    paramSetupData.format = Format.createAudioSampleFormat(null, "audio/vorbis", null, this.vorbisSetup.idHeader.bitrateNominal, -1, this.vorbisSetup.idHeader.channels, (int)this.vorbisSetup.idHeader.sampleRate, paramParsableByteArray, null, 0, null);
    return true;
  }
  
  VorbisReader.VorbisSetup readSetupHeaders(ParsableByteArray paramParsableByteArray)
  {
    if (this.vorbisIdHeader == null)
    {
      this.vorbisIdHeader = VorbisUtil.readVorbisIdentificationHeader(paramParsableByteArray);
      return null;
    }
    if (this.commentHeader == null)
    {
      this.commentHeader = VorbisUtil.readVorbisCommentHeader(paramParsableByteArray);
      return null;
    }
    byte[] arrayOfByte = new byte[paramParsableByteArray.limit()];
    System.arraycopy(paramParsableByteArray.data, 0, arrayOfByte, 0, paramParsableByteArray.limit());
    paramParsableByteArray = VorbisUtil.readVorbisModes(paramParsableByteArray, this.vorbisIdHeader.channels);
    int i = VorbisUtil.iLog(paramParsableByteArray.length - 1);
    return new VorbisReader.VorbisSetup(this.vorbisIdHeader, this.commentHeader, arrayOfByte, paramParsableByteArray, i);
  }
  
  protected void reset(boolean paramBoolean)
  {
    super.reset(paramBoolean);
    if (paramBoolean)
    {
      this.vorbisSetup = null;
      this.vorbisIdHeader = null;
      this.commentHeader = null;
    }
    this.previousPacketBlockSize = 0;
    this.seenFirstAudioPacket = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.VorbisReader
 * JD-Core Version:    0.7.0.1
 */