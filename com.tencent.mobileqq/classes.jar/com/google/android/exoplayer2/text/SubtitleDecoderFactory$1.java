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
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
        if (str.equals("text/vtt"))
        {
          i = 0;
          continue;
          if (str.equals("text/x-ssa"))
          {
            i = 1;
            continue;
            if (str.equals("application/x-mp4-vtt"))
            {
              i = 2;
              continue;
              if (str.equals("application/ttml+xml"))
              {
                i = 3;
                continue;
                if (str.equals("application/x-subrip"))
                {
                  i = 4;
                  continue;
                  if (str.equals("application/x-quicktime-tx3g"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("application/cea-608"))
                    {
                      i = 6;
                      continue;
                      if (str.equals("application/x-mp4-cea-608"))
                      {
                        i = 7;
                        continue;
                        if (str.equals("application/cea-708"))
                        {
                          i = 8;
                          continue;
                          if (str.equals("application/dvbsubs"))
                          {
                            i = 9;
                            continue;
                            if (str.equals("application/pgs")) {
                              i = 10;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return new WebvttDecoder();
    return new SsaDecoder(paramFormat.initializationData);
    return new Mp4WebvttDecoder();
    return new TtmlDecoder();
    return new SubripDecoder();
    return new Tx3gDecoder(paramFormat.initializationData);
    return new Cea608Decoder(paramFormat.sampleMimeType, paramFormat.accessibilityChannel);
    return new Cea708Decoder(paramFormat.accessibilityChannel);
    return new DvbDecoder(paramFormat.initializationData);
    return new PgsDecoder();
  }
  
  public boolean supportsFormat(Format paramFormat)
  {
    paramFormat = paramFormat.sampleMimeType;
    return ("text/vtt".equals(paramFormat)) || ("text/x-ssa".equals(paramFormat)) || ("application/ttml+xml".equals(paramFormat)) || ("application/x-mp4-vtt".equals(paramFormat)) || ("application/x-subrip".equals(paramFormat)) || ("application/x-quicktime-tx3g".equals(paramFormat)) || ("application/cea-608".equals(paramFormat)) || ("application/x-mp4-cea-608".equals(paramFormat)) || ("application/cea-708".equals(paramFormat)) || ("application/dvbsubs".equals(paramFormat)) || ("application/pgs".equals(paramFormat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.text.SubtitleDecoderFactory.1
 * JD-Core Version:    0.7.0.1
 */