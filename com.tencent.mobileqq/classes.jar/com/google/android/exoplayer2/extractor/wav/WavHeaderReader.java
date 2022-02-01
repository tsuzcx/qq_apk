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
    Assertions.checkNotNull(paramExtractorInput);
    ParsableByteArray localParsableByteArray = new ParsableByteArray(16);
    if (WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray).id != Util.getIntegerCodeForString("RIFF")) {
      return null;
    }
    Object localObject = localParsableByteArray.data;
    int i = 4;
    paramExtractorInput.peekFully((byte[])localObject, 0, 4);
    localParsableByteArray.setPosition(0);
    int j = localParsableByteArray.readInt();
    if (j != Util.getIntegerCodeForString("WAVE"))
    {
      paramExtractorInput = new StringBuilder();
      paramExtractorInput.append("Unsupported RIFF format: ");
      paramExtractorInput.append(j);
      Log.e("WavHeaderReader", paramExtractorInput.toString());
      return null;
    }
    for (localObject = WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray); ((WavHeaderReader.ChunkHeader)localObject).id != Util.getIntegerCodeForString("fmt "); localObject = WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray)) {
      paramExtractorInput.advancePeekPosition((int)((WavHeaderReader.ChunkHeader)localObject).size);
    }
    boolean bool;
    if (((WavHeaderReader.ChunkHeader)localObject).size >= 16L) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    paramExtractorInput.peekFully(localParsableByteArray.data, 0, 16);
    localParsableByteArray.setPosition(0);
    j = localParsableByteArray.readLittleEndianUnsignedShort();
    int k = localParsableByteArray.readLittleEndianUnsignedShort();
    int m = localParsableByteArray.readLittleEndianUnsignedIntToInt();
    int n = localParsableByteArray.readLittleEndianUnsignedIntToInt();
    int i1 = localParsableByteArray.readLittleEndianUnsignedShort();
    int i2 = localParsableByteArray.readLittleEndianUnsignedShort();
    int i3 = k * i2 / 8;
    if (i1 == i3)
    {
      if (j != 1) {
        if (j != 3)
        {
          if (j != 65534)
          {
            paramExtractorInput = new StringBuilder();
            paramExtractorInput.append("Unsupported WAV format type: ");
            paramExtractorInput.append(j);
            Log.e("WavHeaderReader", paramExtractorInput.toString());
            return null;
          }
        }
        else
        {
          if (i2 != 32) {
            i = 0;
          }
          break label324;
        }
      }
      i = Util.getPcmEncoding(i2);
      label324:
      if (i == 0)
      {
        paramExtractorInput = new StringBuilder();
        paramExtractorInput.append("Unsupported WAV bit depth ");
        paramExtractorInput.append(i2);
        paramExtractorInput.append(" for type ");
        paramExtractorInput.append(j);
        Log.e("WavHeaderReader", paramExtractorInput.toString());
        return null;
      }
      paramExtractorInput.advancePeekPosition((int)((WavHeaderReader.ChunkHeader)localObject).size - 16);
      return new WavHeader(k, m, n, i1, i2, i);
    }
    paramExtractorInput = new StringBuilder();
    paramExtractorInput.append("Expected block alignment: ");
    paramExtractorInput.append(i3);
    paramExtractorInput.append("; got: ");
    paramExtractorInput.append(i1);
    paramExtractorInput = new ParserException(paramExtractorInput.toString());
    for (;;)
    {
      throw paramExtractorInput;
    }
  }
  
  public static void skipToData(ExtractorInput paramExtractorInput, WavHeader paramWavHeader)
  {
    Assertions.checkNotNull(paramExtractorInput);
    Assertions.checkNotNull(paramWavHeader);
    paramExtractorInput.resetPeekPosition();
    ParsableByteArray localParsableByteArray = new ParsableByteArray(8);
    WavHeaderReader.ChunkHeader localChunkHeader = WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray);
    while (localChunkHeader.id != Util.getIntegerCodeForString("data"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Ignoring unknown WAV chunk: ");
      localStringBuilder.append(localChunkHeader.id);
      Log.w("WavHeaderReader", localStringBuilder.toString());
      long l = localChunkHeader.size + 8L;
      if (localChunkHeader.id == Util.getIntegerCodeForString("RIFF")) {
        l = 12L;
      }
      if (l <= 2147483647L)
      {
        paramExtractorInput.skipFully((int)l);
        localChunkHeader = WavHeaderReader.ChunkHeader.peek(paramExtractorInput, localParsableByteArray);
      }
      else
      {
        paramExtractorInput = new StringBuilder();
        paramExtractorInput.append("Chunk is too large (~2GB+) to skip; id: ");
        paramExtractorInput.append(localChunkHeader.id);
        throw new ParserException(paramExtractorInput.toString());
      }
    }
    paramExtractorInput.skipFully(8);
    paramWavHeader.setDataBounds(paramExtractorInput.getPosition(), localChunkHeader.size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.wav.WavHeaderReader
 * JD-Core Version:    0.7.0.1
 */