package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.Collections;
import java.util.List;

public final class DefaultHlsExtractorFactory
  implements HlsExtractorFactory
{
  public static final String AAC_FILE_EXTENSION = ".aac";
  public static final String AC3_FILE_EXTENSION = ".ac3";
  public static final String EC3_FILE_EXTENSION = ".ec3";
  public static final String M4_FILE_EXTENSION_PREFIX = ".m4";
  public static final String MP3_FILE_EXTENSION = ".mp3";
  public static final String MP4_FILE_EXTENSION = ".mp4";
  public static final String MP4_FILE_EXTENSION_PREFIX = ".mp4";
  public static final String VTT_FILE_EXTENSION = ".vtt";
  public static final String WEBVTT_FILE_EXTENSION = ".webvtt";
  
  public Pair<Extractor, Boolean> createExtractor(Extractor paramExtractor, Uri paramUri, Format paramFormat, List<Format> paramList, DrmInitData paramDrmInitData, TimestampAdjuster paramTimestampAdjuster)
  {
    paramUri = paramUri.getLastPathSegment();
    boolean bool2 = "text/vtt".equals(paramFormat.sampleMimeType);
    boolean bool1 = false;
    if ((!bool2) && (!paramUri.endsWith(".webvtt")) && (!paramUri.endsWith(".vtt")))
    {
      if (paramUri.endsWith(".aac")) {
        paramExtractor = new AdtsExtractor();
      }
      for (;;)
      {
        bool1 = true;
        break;
        if ((!paramUri.endsWith(".ac3")) && (!paramUri.endsWith(".ec3")))
        {
          if (paramUri.endsWith(".mp3"))
          {
            paramExtractor = new Mp3Extractor(0, 0L);
          }
          else
          {
            if (paramExtractor != null) {
              break;
            }
            if ((!paramUri.endsWith(".mp4")) && (!paramUri.startsWith(".m4", paramUri.length() - 4)) && (!paramUri.startsWith(".mp4", paramUri.length() - 5)))
            {
              int i = 16;
              if (paramList != null) {
                i = 48;
              } else {
                paramList = Collections.emptyList();
              }
              paramExtractor = paramFormat.codecs;
              int k = i;
              if (!TextUtils.isEmpty(paramExtractor))
              {
                int j = i;
                if (!"audio/mp4a-latm".equals(MimeTypes.getAudioMediaMimeType(paramExtractor))) {
                  j = i | 0x2;
                }
                k = j;
                if (!"video/avc".equals(MimeTypes.getVideoMediaMimeType(paramExtractor))) {
                  k = j | 0x4;
                }
              }
              paramExtractor = new TsExtractor(2, paramTimestampAdjuster, new DefaultTsPayloadReaderFactory(k, paramList));
              break;
            }
            if (paramList == null) {
              paramList = Collections.emptyList();
            }
            paramExtractor = new FragmentedMp4Extractor(0, paramTimestampAdjuster, null, paramDrmInitData, paramList);
            break;
          }
        }
        else {
          paramExtractor = new Ac3Extractor();
        }
      }
    }
    paramExtractor = new WebvttExtractor(paramFormat.language, paramTimestampAdjuster);
    return Pair.create(paramExtractor, Boolean.valueOf(bool1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory
 * JD-Core Version:    0.7.0.1
 */