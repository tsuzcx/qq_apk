package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultTsPayloadReaderFactory
  implements TsPayloadReader.Factory
{
  private static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 134;
  public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
  public static final int FLAG_DETECT_ACCESS_UNITS = 8;
  public static final int FLAG_IGNORE_AAC_STREAM = 2;
  public static final int FLAG_IGNORE_H264_STREAM = 4;
  public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
  public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
  private final List<Format> closedCaptionFormats;
  private final int flags;
  
  public DefaultTsPayloadReaderFactory()
  {
    this(0);
  }
  
  public DefaultTsPayloadReaderFactory(int paramInt)
  {
    this(paramInt, Collections.emptyList());
  }
  
  public DefaultTsPayloadReaderFactory(int paramInt, List<Format> paramList)
  {
    this.flags = paramInt;
    Object localObject = paramList;
    if (!isSet(32))
    {
      localObject = paramList;
      if (paramList.isEmpty()) {
        localObject = Collections.singletonList(Format.createTextSampleFormat(null, "application/cea-608", 0, null));
      }
    }
    this.closedCaptionFormats = ((List)localObject);
  }
  
  private SeiReader buildSeiReader(TsPayloadReader.EsInfo paramEsInfo)
  {
    if (isSet(32)) {
      return new SeiReader(this.closedCaptionFormats);
    }
    ParsableByteArray localParsableByteArray = new ParsableByteArray(paramEsInfo.descriptorBytes);
    paramEsInfo = this.closedCaptionFormats;
    while (localParsableByteArray.bytesLeft() > 0)
    {
      int i = localParsableByteArray.readUnsignedByte();
      int k = localParsableByteArray.readUnsignedByte();
      int m = localParsableByteArray.getPosition();
      if (i == 134)
      {
        ArrayList localArrayList = new ArrayList();
        int n = localParsableByteArray.readUnsignedByte();
        i = 0;
        for (;;)
        {
          paramEsInfo = localArrayList;
          if (i >= (n & 0x1F)) {
            break;
          }
          String str = localParsableByteArray.readString(3);
          int i1 = localParsableByteArray.readUnsignedByte();
          int j;
          if ((i1 & 0x80) != 0) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            j = i1 & 0x3F;
            paramEsInfo = "application/cea-708";
          }
          else
          {
            paramEsInfo = "application/cea-608";
            j = 1;
          }
          localArrayList.add(Format.createTextSampleFormat(null, paramEsInfo, null, -1, 0, str, j, null));
          localParsableByteArray.skipBytes(2);
          i += 1;
        }
      }
      localParsableByteArray.setPosition(m + k);
    }
    return new SeiReader(paramEsInfo);
  }
  
  private boolean isSet(int paramInt)
  {
    return (paramInt & this.flags) != 0;
  }
  
  public SparseArray<TsPayloadReader> createInitialPayloadReaders()
  {
    return new SparseArray();
  }
  
  public TsPayloadReader createPayloadReader(int paramInt, TsPayloadReader.EsInfo paramEsInfo)
  {
    if (paramInt != 2)
    {
      if ((paramInt != 3) && (paramInt != 4))
      {
        if (paramInt != 15)
        {
          if (paramInt != 17)
          {
            if (paramInt != 21)
            {
              if (paramInt != 27)
              {
                if (paramInt != 36)
                {
                  if (paramInt != 89)
                  {
                    if (paramInt != 138)
                    {
                      if (paramInt != 129)
                      {
                        if (paramInt == 130) {
                          break label133;
                        }
                        if (paramInt != 134)
                        {
                          if (paramInt != 135) {
                            return null;
                          }
                        }
                        else
                        {
                          if (isSet(16)) {
                            return null;
                          }
                          return new SectionReader(new SpliceInfoSectionReader());
                        }
                      }
                      return new PesReader(new Ac3Reader(paramEsInfo.language));
                    }
                    label133:
                    return new PesReader(new DtsReader(paramEsInfo.language));
                  }
                  return new PesReader(new DvbSubtitleReader(paramEsInfo.dvbSubtitleInfos));
                }
                return new PesReader(new H265Reader(buildSeiReader(paramEsInfo)));
              }
              if (isSet(4)) {
                return null;
              }
              return new PesReader(new H264Reader(buildSeiReader(paramEsInfo), isSet(1), isSet(8)));
            }
            return new PesReader(new Id3Reader());
          }
          if (isSet(2)) {
            return null;
          }
          return new PesReader(new LatmReader(paramEsInfo.language));
        }
        if (isSet(2)) {
          return null;
        }
        return new PesReader(new AdtsReader(false, paramEsInfo.language));
      }
      return new PesReader(new MpegAudioReader(paramEsInfo.language));
    }
    return new PesReader(new H262Reader());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory
 * JD-Core Version:    0.7.0.1
 */