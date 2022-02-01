package com.google.android.exoplayer2.extractor.ts;

import java.util.Collections;
import java.util.List;

public final class TsPayloadReader$EsInfo
{
  public final byte[] descriptorBytes;
  public final List<TsPayloadReader.DvbSubtitleInfo> dvbSubtitleInfos;
  public final String language;
  public final int streamType;
  
  public TsPayloadReader$EsInfo(int paramInt, String paramString, List<TsPayloadReader.DvbSubtitleInfo> paramList, byte[] paramArrayOfByte)
  {
    this.streamType = paramInt;
    this.language = paramString;
    if (paramList == null) {
      paramString = Collections.emptyList();
    } else {
      paramString = Collections.unmodifiableList(paramList);
    }
    this.dvbSubtitleInfos = paramString;
    this.descriptorBytes = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo
 * JD-Core Version:    0.7.0.1
 */