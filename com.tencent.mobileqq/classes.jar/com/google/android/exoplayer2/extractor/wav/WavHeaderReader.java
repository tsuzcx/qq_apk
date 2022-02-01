package com.google.android.exoplayer2.extractor.wav;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class WavHeaderReader
{
  private static final String TAG = "WavHeaderReader";
  private static final int TYPE_FLOAT = 3;
  private static final int TYPE_PCM = 1;
  private static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;
  
  public static WavHeader peek(ExtractorInput paramExtractorInput)
  {
    int i = 0;
    Assertions.checkNotNull(paramExtractorInput);
    ParsableByteArray localParsableByteArray = new ParsableByteArray(16);
    if (WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray).id != Util.getIntegerCodeForString("RIFF")) {
      return null;
    }
    paramExtractorInput.peekFully(localParsableByteArray.data, 0, 4);
    localParsableByteArray.setPosition(0);
    int j = localParsableByteArray.readInt();
    if (j != Util.getIntegerCodeForString("WAVE"))
    {
      Log.e("WavHeaderReader", "Unsupported RIFF format: " + j);
      return null;
    }
    for (WavHeaderReader.ChunkHeader localChunkHeader = WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray); localChunkHeader.id != Util.getIntegerCodeForString("fmt "); localChunkHeader = WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray)) {
      paramExtractorInput.advancePeekPosition((int)localChunkHeader.size);
    }
    if (localChunkHeader.size >= 16L) {}
    int k;
    int m;
    int n;
    int i1;
    int i2;
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      paramExtractorInput.peekFully(localParsableByteArray.data, 0, 16);
      localParsableByteArray.setPosition(0);
      j = localParsableByteArray.readLittleEndianUnsignedShort();
      k = localParsableByteArray.readLittleEndianUnsignedShort();
      m = localParsableByteArray.readLittleEndianUnsignedIntToInt();
      n = localParsableByteArray.readLittleEndianUnsignedIntToInt();
      i1 = localParsableByteArray.readLittleEndianUnsignedShort();
      i2 = localParsableByteArray.readLittleEndianUnsignedShort();
      int i3 = k * i2 / 8;
      if (i1 == i3) {
        break;
      }
      throw new ParserException("Expected block alignment: " + i3 + "; got: " + i1);
    }
    switch (j)
    {
    default: 
      Log.e("WavHeaderReader", "Unsupported WAV format type: " + j);
      return null;
    case 1: 
    case 65534: 
      i = Util.getPcmEncoding(i2);
    }
    while (i == 0)
    {
      Log.e("WavHeaderReader", "Unsupported WAV bit depth " + i2 + " for type " + j);
      return null;
      if (i2 == 32) {
        i = 4;
      }
    }
    paramExtractorInput.advancePeekPosition((int)localChunkHeader.size - 16);
    return new WavHeader(k, m, n, i1, i2, i);
  }
  
  public static void skipToData(ExtractorInput paramExtractorInput, WavHeader paramWavHeader)
  {
    Assertions.checkNotNull(paramExtractorInput);
    Assertions.checkNotNull(paramWavHeader);
    paramExtractorInput.resetPeekPosition();
    ParsableByteArray localParsableByteArray = new ParsableByteArray(8);
    for (WavHeaderReader.ChunkHeader localChunkHeader = WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray); localChunkHeader.id != Util.getIntegerCodeForString("data"); localChunkHeader = WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray))
    {
      Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + localChunkHeader.id);
      long l = 8L + localChunkHeader.size;
      if (localChunkHeader.id == Util.getIntegerCodeForString("RIFF")) {
        l = 12L;
      }
      if (l > 2147483647L) {
        throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + localChunkHeader.id);
      }
      paramExtractorInput.skipFully((int)l);
    }
    paramExtractorInput.skipFully(8);
    paramWavHeader.setDataBounds(paramExtractorInput.getPosition(), localChunkHeader.size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.wav.WavHeaderReader
 * JD-Core Version:    0.7.0.1
 */