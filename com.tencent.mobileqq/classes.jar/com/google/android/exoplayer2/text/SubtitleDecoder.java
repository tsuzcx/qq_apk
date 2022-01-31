package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.Decoder;

public abstract interface SubtitleDecoder
  extends Decoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException>
{
  public abstract void setPositionUs(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.text.SubtitleDecoder
 * JD-Core Version:    0.7.0.1
 */