package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;

public abstract interface SubtitleDecoderFactory
{
  public static final SubtitleDecoderFactory DEFAULT = new SubtitleDecoderFactory.1();
  
  public abstract SubtitleDecoder createDecoder(Format paramFormat);
  
  public abstract boolean supportsFormat(Format paramFormat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.text.SubtitleDecoderFactory
 * JD-Core Version:    0.7.0.1
 */