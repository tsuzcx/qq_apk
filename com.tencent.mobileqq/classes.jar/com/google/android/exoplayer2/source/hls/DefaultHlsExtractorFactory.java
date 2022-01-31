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
    boolean bool2 = false;
    String str = paramUri.getLastPathSegment();
    boolean bool1;
    if (("text/vtt".equals(paramFormat.sampleMimeType)) || (str.endsWith(".webvtt")) || (str.endsWith(".vtt")))
    {
      paramUri = new WebvttExtractor(paramFormat.language, paramTimestampAdjuster);
      bool1 = bool2;
    }
    do
    {
      for (;;)
      {
        return Pair.create(paramUri, Boolean.valueOf(bool1));
        if (str.endsWith(".aac"))
        {
          paramUri = new AdtsExtractor();
          bool1 = true;
        }
        else if ((str.endsWith(".ac3")) || (str.endsWith(".ec3")))
        {
          paramUri = new Ac3Extractor();
          bool1 = true;
        }
        else
        {
          if (!str.endsWith(".mp3")) {
            break;
          }
          paramUri = new Mp3Extractor(0, 0L);
          bool1 = true;
        }
      }
      bool1 = bool2;
      paramUri = paramExtractor;
    } while (paramExtractor != null);
    if ((str.endsWith(".mp4")) || (str.startsWith(".m4", str.length() - 4)) || (str.startsWith(".mp4", str.length() - 5)))
    {
      if (paramList != null) {}
      for (;;)
      {
        paramUri = new FragmentedMp4Extractor(0, paramTimestampAdjuster, null, paramDrmInitData, paramList);
        bool1 = bool2;
        break;
        paramList = Collections.emptyList();
      }
    }
    int i = 16;
    if (paramList != null) {
      i = 48;
    }
    for (;;)
    {
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
      paramUri = new TsExtractor(2, paramTimestampAdjuster, new DefaultTsPayloadReaderFactory(k, paramList));
      bool1 = bool2;
      break;
      paramList = Collections.emptyList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory
 * JD-Core Version:    0.7.0.1
 */