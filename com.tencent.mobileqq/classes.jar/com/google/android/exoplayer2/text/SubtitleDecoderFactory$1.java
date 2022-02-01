package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.dvb.DvbDecoder;
import com.google.android.exoplayer2.text.pgs.PgsDecoder;
import com.google.android.exoplayer2.text.ssa.SsaDecoder;
import com.google.android.exoplayer2.text.subrip.SubripDecoder;
import com.google.android.exoplayer2.text.ttml.TtmlDecoder;
import com.google.android.exoplayer2.text.tx3g.Tx3gDecoder;
import com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder;
import com.google.android.exoplayer2.text.webvtt.WebvttDecoder;

final class SubtitleDecoderFactory$1
  implements SubtitleDecoderFactory
{
  public SubtitleDecoder createDecoder(Format paramFormat)
  {
    String str = paramFormat.sampleMimeType;
    switch (str.hashCode())
    {
    default: 
      break;
    case 1693976202: 
      if (str.equals("application/ttml+xml")) {
        i = 3;
      }
      break;
    case 1668750253: 
      if (str.equals("application/x-subrip")) {
        i = 4;
      }
      break;
    case 1566016562: 
      if (str.equals("application/cea-708")) {
        i = 8;
      }
      break;
    case 1566015601: 
      if (str.equals("application/cea-608")) {
        i = 6;
      }
      break;
    case 930165504: 
      if (str.equals("application/x-mp4-cea-608")) {
        i = 7;
      }
      break;
    case 822864842: 
      if (str.equals("text/x-ssa")) {
        i = 1;
      }
      break;
    case 691401887: 
      if (str.equals("application/x-quicktime-tx3g")) {
        i = 5;
      }
      break;
    case -1004728940: 
      if (str.equals("text/vtt")) {
        i = 0;
      }
      break;
    case -1026075066: 
      if (str.equals("application/x-mp4-vtt")) {
        i = 2;
      }
      break;
    case -1248334819: 
      if (str.equals("application/pgs")) {
        i = 10;
      }
      break;
    case -1351681404: 
      if (str.equals("application/dvbsubs")) {
        i = 9;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
    case 10: 
      return new PgsDecoder();
    case 9: 
      return new DvbDecoder(paramFormat.initializationData);
    case 8: 
      return new Cea708Decoder(paramFormat.accessibilityChannel);
    case 6: 
    case 7: 
      return new Cea608Decoder(paramFormat.sampleMimeType, paramFormat.accessibilityChannel);
    case 5: 
      return new Tx3gDecoder(paramFormat.initializationData);
    case 4: 
      return new SubripDecoder();
    case 3: 
      return new TtmlDecoder();
    case 2: 
      return new Mp4WebvttDecoder();
    case 1: 
      return new SsaDecoder(paramFormat.initializationData);
    }
    return new WebvttDecoder();
  }
  
  public boolean supportsFormat(Format paramFormat)
  {
    paramFormat = paramFormat.sampleMimeType;
    return ("text/vtt".equals(paramFormat)) || ("text/x-ssa".equals(paramFormat)) || ("application/ttml+xml".equals(paramFormat)) || ("application/x-mp4-vtt".equals(paramFormat)) || ("application/x-subrip".equals(paramFormat)) || ("application/x-quicktime-tx3g".equals(paramFormat)) || ("application/cea-608".equals(paramFormat)) || ("application/x-mp4-cea-608".equals(paramFormat)) || ("application/cea-708".equals(paramFormat)) || ("application/dvbsubs".equals(paramFormat)) || ("application/pgs".equals(paramFormat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.SubtitleDecoderFactory.1
 * JD-Core Version:    0.7.0.1
 */