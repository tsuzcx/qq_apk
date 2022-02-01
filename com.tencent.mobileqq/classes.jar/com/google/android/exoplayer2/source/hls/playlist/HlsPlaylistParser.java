package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HlsPlaylistParser
  implements ParsingLoadable.Parser<HlsPlaylist>
{
  private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
  private static final String BOOLEAN_FALSE = "NO";
  private static final String BOOLEAN_TRUE = "YES";
  private static final String KEYFORMAT_IDENTITY = "identity";
  private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
  private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
  private static final String METHOD_AES_128 = "AES-128";
  private static final String METHOD_NONE = "NONE";
  private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
  private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
  private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
  private static final String PLAYLIST_HEADER = "#EXTM3U";
  private static final Pattern REGEX_ATTR_BYTERANGE;
  private static final Pattern REGEX_AUDIO;
  private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
  private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
  private static final Pattern REGEX_BANDWIDTH;
  private static final Pattern REGEX_BYTERANGE;
  private static final Pattern REGEX_CODECS;
  private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
  private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
  private static final Pattern REGEX_FRAME_RATE;
  private static final Pattern REGEX_GROUP_ID;
  private static final Pattern REGEX_INSTREAM_ID;
  private static final Pattern REGEX_IV;
  private static final Pattern REGEX_KEYFORMAT;
  private static final Pattern REGEX_LANGUAGE;
  private static final Pattern REGEX_MEDIA_DURATION;
  private static final Pattern REGEX_MEDIA_SEQUENCE;
  private static final Pattern REGEX_METHOD;
  private static final Pattern REGEX_NAME;
  private static final Pattern REGEX_PLAYLIST_TYPE;
  private static final Pattern REGEX_RESOLUTION;
  private static final Pattern REGEX_TARGET_DURATION;
  private static final Pattern REGEX_TIME_OFFSET;
  private static final Pattern REGEX_TYPE;
  private static final Pattern REGEX_URI;
  private static final Pattern REGEX_VERSION;
  private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
  private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
  private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
  private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
  private static final String TAG_GAP = "#EXT-X-GAP";
  private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
  private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
  private static final String TAG_KEY = "#EXT-X-KEY";
  private static final String TAG_MEDIA = "#EXT-X-MEDIA";
  private static final String TAG_MEDIA_DURATION = "#EXTINF";
  private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
  private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
  private static final String TAG_PREFIX = "#EXT";
  private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
  private static final String TAG_START = "#EXT-X-START";
  private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
  private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
  private static final String TAG_VERSION = "#EXT-X-VERSION";
  private static final String TYPE_AUDIO = "AUDIO";
  private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
  private static final String TYPE_SUBTITLES = "SUBTITLES";
  private static final String TYPE_VIDEO = "VIDEO";
  
  static
  {
    REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)");
    REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
  }
  
  private static boolean checkPlaylistHeader(BufferedReader paramBufferedReader)
  {
    int j = paramBufferedReader.read();
    int i = j;
    if (j == 239)
    {
      if ((paramBufferedReader.read() != 187) || (paramBufferedReader.read() != 191)) {
        return false;
      }
      i = paramBufferedReader.read();
    }
    j = skipIgnorableWhitespace(paramBufferedReader, true, i);
    int k = "#EXTM3U".length();
    i = 0;
    while (i < k)
    {
      if (j != "#EXTM3U".charAt(i)) {
        return false;
      }
      j = paramBufferedReader.read();
      i += 1;
    }
    return Util.isLinebreak(skipIgnorableWhitespace(paramBufferedReader, false, j));
  }
  
  private static Pattern compileBooleanAttrPattern(String paramString)
  {
    return Pattern.compile(paramString + "=(" + "NO" + "|" + "YES" + ")");
  }
  
  private static boolean parseBooleanAttribute(String paramString, Pattern paramPattern, boolean paramBoolean)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      paramBoolean = paramString.group(1).equals("YES");
    }
    return paramBoolean;
  }
  
  private static double parseDoubleAttr(String paramString, Pattern paramPattern)
  {
    return Double.parseDouble(parseStringAttr(paramString, paramPattern));
  }
  
  private static int parseIntAttr(String paramString, Pattern paramPattern)
  {
    return Integer.parseInt(parseStringAttr(paramString, paramPattern));
  }
  
  private static long parseLongAttr(String paramString, Pattern paramPattern)
  {
    return Long.parseLong(parseStringAttr(paramString, paramPattern));
  }
  
  private static HlsMasterPlaylist parseMasterPlaylist(HlsPlaylistParser.LineIterator paramLineIterator, String paramString)
  {
    Object localObject3 = new HashSet();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    String str2;
    int k;
    String str1;
    Object localObject4;
    int i;
    while (paramLineIterator.hasNext())
    {
      str2 = paramLineIterator.next();
      if (str2.startsWith("#EXT")) {
        localArrayList4.add(str2);
      }
      if (str2.startsWith("#EXT-X-MEDIA"))
      {
        localArrayList5.add(str2);
      }
      else if (str2.startsWith("#EXT-X-STREAM-INF"))
      {
        boolean bool2 = str2.contains("CLOSED-CAPTIONS=NONE");
        k = parseIntAttr(str2, REGEX_BANDWIDTH);
        str1 = parseOptionalStringAttr(str2, REGEX_AVERAGE_BANDWIDTH);
        if (str1 != null) {
          k = Integer.parseInt(str1);
        }
        str1 = parseOptionalStringAttr(str2, REGEX_CODECS);
        localObject4 = parseOptionalStringAttr(str2, REGEX_RESOLUTION);
        if (localObject4 != null)
        {
          localObject4 = ((String)localObject4).split("x");
          i = Integer.parseInt(localObject4[0]);
          int m = Integer.parseInt(localObject4[1]);
          if (i > 0)
          {
            j = m;
            if (m > 0) {}
          }
          else
          {
            i = -1;
          }
        }
        for (j = -1;; j = -1)
        {
          float f = -1.0F;
          localObject4 = parseOptionalStringAttr(str2, REGEX_FRAME_RATE);
          if (localObject4 != null) {
            f = Float.parseFloat((String)localObject4);
          }
          str2 = parseOptionalStringAttr(str2, REGEX_AUDIO);
          if ((str2 != null) && (str1 != null)) {
            localHashMap.put(str2, Util.getCodecsOfType(str1, 1));
          }
          str2 = paramLineIterator.next();
          if (((HashSet)localObject3).add(str2)) {
            localArrayList1.add(new HlsMasterPlaylist.HlsUrl(str2, Format.createVideoContainerFormat(Integer.toString(localArrayList1.size()), "application/x-mpegURL", null, str1, k, i, j, f, null, 0)));
          }
          bool1 |= bool2;
          break;
          i = -1;
        }
      }
    }
    int j = 0;
    paramLineIterator = (HlsPlaylistParser.LineIterator)localObject2;
    if (j < localArrayList5.size())
    {
      localObject2 = (String)localArrayList5.get(j);
      k = parseSelectionFlags((String)localObject2);
      str2 = parseOptionalStringAttr((String)localObject2, REGEX_URI);
      localObject3 = parseStringAttr((String)localObject2, REGEX_NAME);
      str1 = parseOptionalStringAttr((String)localObject2, REGEX_LANGUAGE);
      localObject4 = parseOptionalStringAttr((String)localObject2, REGEX_GROUP_ID);
      String str3 = parseStringAttr((String)localObject2, REGEX_TYPE);
      i = -1;
      switch (str3.hashCode())
      {
      default: 
        label504:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        j += 1;
        break;
        if (!str3.equals("AUDIO")) {
          break label504;
        }
        i = 0;
        break label504;
        if (!str3.equals("SUBTITLES")) {
          break label504;
        }
        i = 1;
        break label504;
        if (!str3.equals("CLOSED-CAPTIONS")) {
          break label504;
        }
        i = 2;
        break label504;
        localObject4 = (String)localHashMap.get(localObject4);
        if (localObject4 != null) {}
        for (localObject2 = MimeTypes.getMediaMimeType((String)localObject4);; localObject2 = null)
        {
          localObject2 = Format.createAudioContainerFormat((String)localObject3, "application/x-mpegURL", (String)localObject2, (String)localObject4, -1, -1, -1, null, k, str1);
          if (str2 != null) {
            break label650;
          }
          localObject1 = localObject2;
          break;
        }
        label650:
        localArrayList2.add(new HlsMasterPlaylist.HlsUrl(str2, (Format)localObject2));
        continue;
        localArrayList3.add(new HlsMasterPlaylist.HlsUrl(str2, Format.createTextContainerFormat((String)localObject3, "application/x-mpegURL", "text/vtt", null, -1, k, str1)));
      }
      str2 = parseStringAttr((String)localObject2, REGEX_INSTREAM_ID);
      if (str2.startsWith("CC"))
      {
        localObject2 = "application/cea-608";
        i = Integer.parseInt(str2.substring(2));
        label741:
        if (paramLineIterator != null) {
          break label829;
        }
        paramLineIterator = new ArrayList();
      }
    }
    label829:
    for (;;)
    {
      paramLineIterator.add(Format.createTextContainerFormat((String)localObject3, null, (String)localObject2, null, -1, k, str1, i));
      break;
      localObject2 = "application/cea-708";
      i = Integer.parseInt(str2.substring(7));
      break label741;
      if (bool1) {
        paramLineIterator = Collections.emptyList();
      }
      for (;;)
      {
        return new HlsMasterPlaylist(paramString, localArrayList4, localArrayList1, localArrayList2, localArrayList3, localObject1, paramLineIterator);
      }
    }
  }
  
  private static HlsMediaPlaylist parseMediaPlaylist(HlsPlaylistParser.LineIterator paramLineIterator, String paramString)
  {
    Object localObject3 = null;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    long l9 = 0L;
    long l1 = 0L;
    long l2 = -1L;
    boolean bool1 = false;
    Object localObject5 = null;
    Object localObject4 = null;
    int j = 1;
    long l7 = 0L;
    long l5 = -9223372036854775807L;
    int i = 0;
    int k = 0;
    boolean bool2 = false;
    long l4 = 0L;
    long l6 = -9223372036854775807L;
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject1 = null;
    long l8 = 0L;
    long l3 = 0L;
    int m = 0;
    Object localObject7;
    Object localObject2;
    if (paramLineIterator.hasNext())
    {
      localObject7 = paramLineIterator.next();
      if (((String)localObject7).startsWith("#EXT")) {
        localArrayList2.add(localObject7);
      }
      if (((String)localObject7).startsWith("#EXT-X-PLAYLIST-TYPE"))
      {
        localObject2 = parseStringAttr((String)localObject7, REGEX_PLAYLIST_TYPE);
        if ("VOD".equals(localObject2)) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      break;
      if ("EVENT".equals(localObject2))
      {
        i = 2;
        continue;
        if (((String)localObject7).startsWith("#EXT-X-START"))
        {
          l5 = (parseDoubleAttr((String)localObject7, REGEX_TIME_OFFSET) * 1000000.0D);
          break;
        }
        if (((String)localObject7).startsWith("#EXT-X-MAP"))
        {
          localObject2 = parseStringAttr((String)localObject7, REGEX_URI);
          localObject3 = parseOptionalStringAttr((String)localObject7, REGEX_ATTR_BYTERANGE);
          if (localObject3 == null) {
            break label1040;
          }
          localObject3 = ((String)localObject3).split("@");
          long l10 = Long.parseLong(localObject3[0]);
          l2 = l10;
          if (localObject3.length <= 1) {
            break label1040;
          }
          l1 = Long.parseLong(localObject3[1]);
          l2 = l10;
        }
        label1034:
        label1037:
        label1040:
        for (;;)
        {
          localObject3 = new HlsMediaPlaylist.Segment((String)localObject2, l1, l2);
          l2 = -1L;
          l1 = 0L;
          break;
          if (((String)localObject7).startsWith("#EXT-X-TARGETDURATION"))
          {
            l6 = parseIntAttr((String)localObject7, REGEX_TARGET_DURATION) * 1000000L;
            break;
          }
          if (((String)localObject7).startsWith("#EXT-X-MEDIA-SEQUENCE"))
          {
            l7 = parseLongAttr((String)localObject7, REGEX_MEDIA_SEQUENCE);
            l3 = l7;
            break;
          }
          if (((String)localObject7).startsWith("#EXT-X-VERSION"))
          {
            j = parseIntAttr((String)localObject7, REGEX_VERSION);
            break;
          }
          if (((String)localObject7).startsWith("#EXTINF"))
          {
            l4 = (parseDoubleAttr((String)localObject7, REGEX_MEDIA_DURATION) * 1000000.0D);
            break;
          }
          if (((String)localObject7).startsWith("#EXT-X-KEY"))
          {
            String str2 = parseOptionalStringAttr((String)localObject7, REGEX_METHOD);
            String str3 = parseOptionalStringAttr((String)localObject7, REGEX_KEYFORMAT);
            localObject5 = null;
            localObject2 = null;
            localObject1 = localObject5;
            Object localObject6 = localObject4;
            String str1;
            if (!"NONE".equals(str2))
            {
              str1 = parseOptionalStringAttr((String)localObject7, REGEX_IV);
              if ((!"identity".equals(str3)) && (str3 != null)) {
                break label541;
              }
              localObject2 = str1;
              localObject1 = localObject5;
              localObject6 = localObject4;
              if ("AES-128".equals(str2))
              {
                localObject1 = parseStringAttr((String)localObject7, REGEX_URI);
                localObject6 = localObject4;
                localObject2 = str1;
              }
            }
            label541:
            do
            {
              do
              {
                localObject5 = localObject1;
                localObject1 = localObject2;
                localObject4 = localObject6;
                break;
                localObject2 = str1;
                localObject1 = localObject5;
                localObject6 = localObject4;
              } while (str2 == null);
              localObject7 = parseWidevineSchemeData((String)localObject7, str3);
              localObject2 = str1;
              localObject1 = localObject5;
              localObject6 = localObject4;
            } while (localObject7 == null);
            if (("SAMPLE-AES-CENC".equals(str2)) || ("SAMPLE-AES-CTR".equals(str2))) {}
            for (localObject1 = "cenc";; localObject1 = "cbcs")
            {
              localObject6 = new DrmInitData((String)localObject1, new DrmInitData.SchemeData[] { localObject7 });
              localObject2 = str1;
              localObject1 = localObject5;
              break;
            }
          }
          if (((String)localObject7).startsWith("#EXT-X-BYTERANGE"))
          {
            localObject2 = parseStringAttr((String)localObject7, REGEX_BYTERANGE).split("@");
            l2 = Long.parseLong(localObject2[0]);
            if (localObject2.length <= 1) {
              break label1037;
            }
            l1 = Long.parseLong(localObject2[1]);
          }
          for (;;)
          {
            break;
            if (((String)localObject7).startsWith("#EXT-X-DISCONTINUITY-SEQUENCE"))
            {
              k = Integer.parseInt(((String)localObject7).substring(((String)localObject7).indexOf(':') + 1));
              bool2 = true;
              break;
            }
            if (((String)localObject7).equals("#EXT-X-DISCONTINUITY"))
            {
              m += 1;
              break;
            }
            if (((String)localObject7).startsWith("#EXT-X-PROGRAM-DATE-TIME"))
            {
              if (l8 != 0L) {
                break;
              }
              l8 = C.msToUs(Util.parseXsDateTime(((String)localObject7).substring(((String)localObject7).indexOf(':') + 1))) - l9;
              break;
            }
            if (((String)localObject7).equals("#EXT-X-GAP"))
            {
              bool1 = true;
              break;
            }
            if (((String)localObject7).equals("#EXT-X-INDEPENDENT-SEGMENTS"))
            {
              bool4 = true;
              break;
            }
            if (((String)localObject7).equals("#EXT-X-ENDLIST"))
            {
              bool3 = true;
              break;
            }
            if (((String)localObject7).startsWith("#")) {
              break;
            }
            if (localObject5 == null)
            {
              localObject2 = null;
              label868:
              if (l2 != -1L) {
                break label1034;
              }
              l1 = 0L;
            }
            for (;;)
            {
              localArrayList1.add(new HlsMediaPlaylist.Segment((String)localObject7, l4, m, l9, localObject5, (String)localObject2, l1, l2, bool1));
              l9 += l4;
              if (l2 != -1L) {
                l1 += l2;
              }
              for (;;)
              {
                l2 = -1L;
                bool1 = false;
                l3 += 1L;
                l4 = 0L;
                break;
                if (localObject1 != null)
                {
                  localObject2 = localObject1;
                  break label868;
                }
                localObject2 = Long.toHexString(l3);
                break label868;
                if (l8 != 0L) {}
                for (bool1 = true;; bool1 = false) {
                  return new HlsMediaPlaylist(i, paramString, localArrayList2, l5, l8, bool2, k, l7, j, l6, bool4, bool3, bool1, localObject4, (HlsMediaPlaylist.Segment)localObject3, localArrayList1);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static String parseOptionalStringAttr(String paramString, Pattern paramPattern)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  private static int parseSelectionFlags(String paramString)
  {
    int k = 0;
    int i;
    if (parseBooleanAttribute(paramString, REGEX_DEFAULT, false))
    {
      i = 1;
      if (!parseBooleanAttribute(paramString, REGEX_FORCED, false)) {
        break label52;
      }
    }
    label52:
    for (int j = 2;; j = 0)
    {
      if (parseBooleanAttribute(paramString, REGEX_AUTOSELECT, false)) {
        k = 4;
      }
      return i | j | k;
      i = 0;
      break;
    }
  }
  
  private static String parseStringAttr(String paramString, Pattern paramPattern)
  {
    Matcher localMatcher = paramPattern.matcher(paramString);
    if ((localMatcher.find()) && (localMatcher.groupCount() == 1)) {
      return localMatcher.group(1);
    }
    throw new ParserException("Couldn't match " + paramPattern.pattern() + " in " + paramString);
  }
  
  private static DrmInitData.SchemeData parseWidevineSchemeData(String paramString1, String paramString2)
  {
    if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(paramString2))
    {
      paramString1 = parseStringAttr(paramString1, REGEX_URI);
      return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "video/mp4", Base64.decode(paramString1.substring(paramString1.indexOf(',')), 0));
    }
    if ("com.widevine".equals(paramString2)) {
      try
      {
        paramString1 = new DrmInitData.SchemeData(C.WIDEVINE_UUID, "hls", paramString1.getBytes("UTF-8"));
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        throw new ParserException(paramString1);
      }
    }
    return null;
  }
  
  private static int skipIgnorableWhitespace(BufferedReader paramBufferedReader, boolean paramBoolean, int paramInt)
  {
    while ((paramInt != -1) && (Character.isWhitespace(paramInt)) && ((paramBoolean) || (!Util.isLinebreak(paramInt)))) {
      paramInt = paramBufferedReader.read();
    }
    return paramInt;
  }
  
  public HlsPlaylist parse(Uri paramUri, InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    ArrayDeque localArrayDeque = new ArrayDeque();
    try
    {
      if (!checkPlaylistHeader(paramInputStream)) {
        throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", paramUri);
      }
    }
    finally
    {
      Util.closeQuietly(paramInputStream);
    }
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      str = str.trim();
      if (!str.isEmpty())
      {
        if (str.startsWith("#EXT-X-STREAM-INF"))
        {
          localArrayDeque.add(str);
          paramUri = parseMasterPlaylist(new HlsPlaylistParser.LineIterator(localArrayDeque, paramInputStream), paramUri.toString());
          Util.closeQuietly(paramInputStream);
          return paramUri;
        }
        if ((str.startsWith("#EXT-X-TARGETDURATION")) || (str.startsWith("#EXT-X-MEDIA-SEQUENCE")) || (str.startsWith("#EXTINF")) || (str.startsWith("#EXT-X-KEY")) || (str.startsWith("#EXT-X-BYTERANGE")) || (str.equals("#EXT-X-DISCONTINUITY")) || (str.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) || (str.equals("#EXT-X-ENDLIST")))
        {
          localArrayDeque.add(str);
          paramUri = parseMediaPlaylist(new HlsPlaylistParser.LineIterator(localArrayDeque, paramInputStream), paramUri.toString());
          Util.closeQuietly(paramInputStream);
          return paramUri;
        }
        localArrayDeque.add(str);
      }
    }
    Util.closeQuietly(paramInputStream);
    throw new ParserException("Failed to parse the playlist, could not identify any tags.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser
 * JD-Core Version:    0.7.0.1
 */