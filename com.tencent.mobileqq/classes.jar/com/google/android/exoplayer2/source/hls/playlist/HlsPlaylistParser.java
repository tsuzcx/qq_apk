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
    if (j == 239) {
      if (paramBufferedReader.read() == 187)
      {
        if (paramBufferedReader.read() != 191) {
          return false;
        }
        i = paramBufferedReader.read();
      }
      else
      {
        return false;
      }
    }
    j = skipIgnorableWhitespace(paramBufferedReader, true, i);
    i = 0;
    while (i < 7)
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("=(");
    localStringBuilder.append("NO");
    localStringBuilder.append("|");
    localStringBuilder.append("YES");
    localStringBuilder.append(")");
    return Pattern.compile(localStringBuilder.toString());
  }
  
  private static boolean parseBooleanAttribute(String paramString, Pattern paramPattern, boolean paramBoolean)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1).equals("YES");
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
    Object localObject1 = new HashSet();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    int j = 0;
    String str1;
    Object localObject3;
    int i;
    label244:
    int m;
    while (paramLineIterator.hasNext())
    {
      str1 = paramLineIterator.next();
      if (str1.startsWith("#EXT")) {
        localArrayList5.add(str1);
      }
      if (str1.startsWith("#EXT-X-MEDIA"))
      {
        localArrayList1.add(str1);
      }
      else if (str1.startsWith("#EXT-X-STREAM-INF"))
      {
        int n = j | str1.contains("CLOSED-CAPTIONS=NONE");
        k = parseIntAttr(str1, REGEX_BANDWIDTH);
        localObject2 = parseOptionalStringAttr(str1, REGEX_AVERAGE_BANDWIDTH);
        if (localObject2 != null) {
          k = Integer.parseInt((String)localObject2);
        }
        localObject2 = parseOptionalStringAttr(str1, REGEX_CODECS);
        localObject3 = parseOptionalStringAttr(str1, REGEX_RESOLUTION);
        if (localObject3 != null)
        {
          localObject3 = ((String)localObject3).split("x");
          j = Integer.parseInt(localObject3[0]);
          i = Integer.parseInt(localObject3[1]);
          if ((j > 0) && (i > 0)) {
            break label244;
          }
          j = -1;
          i = -1;
          m = i;
          i = j;
        }
        else
        {
          i = -1;
          m = -1;
        }
        localObject3 = parseOptionalStringAttr(str1, REGEX_FRAME_RATE);
        float f;
        if (localObject3 != null) {
          f = Float.parseFloat((String)localObject3);
        } else {
          f = -1.0F;
        }
        str1 = parseOptionalStringAttr(str1, REGEX_AUDIO);
        if ((str1 != null) && (localObject2 != null)) {
          localHashMap.put(str1, Util.getCodecsOfType((String)localObject2, 1));
        }
        str1 = paramLineIterator.next();
        j = n;
        if (((HashSet)localObject1).add(str1))
        {
          localArrayList2.add(new HlsMasterPlaylist.HlsUrl(str1, Format.createVideoContainerFormat(Integer.toString(localArrayList2.size()), "application/x-mpegURL", null, (String)localObject2, k, i, m, f, null, 0)));
          j = n;
        }
      }
    }
    int k = 0;
    Object localObject2 = null;
    paramLineIterator = null;
    while (k < localArrayList1.size())
    {
      localObject1 = (String)localArrayList1.get(k);
      m = parseSelectionFlags((String)localObject1);
      str1 = parseOptionalStringAttr((String)localObject1, REGEX_URI);
      localObject3 = parseStringAttr((String)localObject1, REGEX_NAME);
      String str2 = parseOptionalStringAttr((String)localObject1, REGEX_LANGUAGE);
      String str3 = parseOptionalStringAttr((String)localObject1, REGEX_GROUP_ID);
      String str4 = parseStringAttr((String)localObject1, REGEX_TYPE);
      i = str4.hashCode();
      if (i != -959297733)
      {
        if (i != -333210994)
        {
          if ((i == 62628790) && (str4.equals("AUDIO")))
          {
            i = 0;
            break label551;
          }
        }
        else if (str4.equals("CLOSED-CAPTIONS"))
        {
          i = 2;
          break label551;
        }
      }
      else if (str4.equals("SUBTITLES"))
      {
        i = 1;
        break label551;
      }
      i = -1;
      label551:
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            localObject1 = parseStringAttr((String)localObject1, REGEX_INSTREAM_ID);
            if (((String)localObject1).startsWith("CC"))
            {
              i = Integer.parseInt(((String)localObject1).substring(2));
              str1 = "application/cea-608";
            }
            else
            {
              i = Integer.parseInt(((String)localObject1).substring(7));
              str1 = "application/cea-708";
            }
            localObject1 = paramLineIterator;
            if (paramLineIterator == null) {
              localObject1 = new ArrayList();
            }
            ((List)localObject1).add(Format.createTextContainerFormat((String)localObject3, null, str1, null, -1, m, str2, i));
            paramLineIterator = (HlsPlaylistParser.LineIterator)localObject1;
          }
        }
        else {
          localArrayList4.add(new HlsMasterPlaylist.HlsUrl(str1, Format.createTextContainerFormat((String)localObject3, "application/x-mpegURL", "text/vtt", null, -1, m, str2)));
        }
      }
      else
      {
        str3 = (String)localHashMap.get(str3);
        if (str3 != null) {
          localObject1 = MimeTypes.getMediaMimeType(str3);
        } else {
          localObject1 = null;
        }
        localObject1 = Format.createAudioContainerFormat((String)localObject3, "application/x-mpegURL", (String)localObject1, str3, -1, -1, -1, null, m, str2);
        if (str1 == null) {
          localObject2 = localObject1;
        } else {
          localArrayList3.add(new HlsMasterPlaylist.HlsUrl(str1, (Format)localObject1));
        }
      }
      k += 1;
    }
    if (j != 0) {
      paramLineIterator = Collections.emptyList();
    }
    return new HlsMasterPlaylist(paramString, localArrayList5, localArrayList2, localArrayList3, localArrayList4, (Format)localObject2, paramLineIterator);
  }
  
  private static HlsMediaPlaylist parseMediaPlaylist(HlsPlaylistParser.LineIterator paramLineIterator, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    long l10 = -9223372036854775807L;
    long l5 = l10;
    int m = 0;
    int i = 0;
    long l9 = 0L;
    boolean bool3 = false;
    int k = 0;
    long l8 = 0L;
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject4 = null;
    Object localObject3 = null;
    long l1 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    Object localObject1 = null;
    String str1 = null;
    boolean bool4;
    for (;;)
    {
      long l2 = -1L;
      bool4 = false;
      long l7 = 0L;
      long l6 = l3;
      String str2;
      Object localObject2;
      for (;;)
      {
        if (!paramLineIterator.hasNext()) {
          break label960;
        }
        str2 = paramLineIterator.next();
        if (str2.startsWith("#EXT")) {
          localArrayList2.add(str2);
        }
        if (str2.startsWith("#EXT-X-PLAYLIST-TYPE"))
        {
          localObject2 = parseStringAttr(str2, REGEX_PLAYLIST_TYPE);
          if ("VOD".equals(localObject2)) {
            i = 1;
          } else if ("EVENT".equals(localObject2)) {
            i = 2;
          }
        }
        else if (str2.startsWith("#EXT-X-START"))
        {
          l10 = (parseDoubleAttr(str2, REGEX_TIME_OFFSET) * 1000000.0D);
        }
        else if (str2.startsWith("#EXT-X-MAP"))
        {
          localObject2 = parseStringAttr(str2, REGEX_URI);
          localObject3 = parseOptionalStringAttr(str2, REGEX_ATTR_BYTERANGE);
          l3 = l1;
          if (localObject3 != null)
          {
            localObject3 = ((String)localObject3).split("@");
            long l11 = Long.parseLong(localObject3[0]);
            l3 = l1;
            l2 = l11;
            if (localObject3.length > 1)
            {
              l3 = Long.parseLong(localObject3[1]);
              l2 = l11;
            }
          }
          localObject3 = new HlsMediaPlaylist.Segment((String)localObject2, l3, l2);
          l1 = 0L;
          l2 = -1L;
        }
        else if (str2.startsWith("#EXT-X-TARGETDURATION"))
        {
          l5 = 1000000L * parseIntAttr(str2, REGEX_TARGET_DURATION);
        }
        else if (str2.startsWith("#EXT-X-MEDIA-SEQUENCE"))
        {
          l6 = parseLongAttr(str2, REGEX_MEDIA_SEQUENCE);
          l8 = l6;
        }
        else if (str2.startsWith("#EXT-X-VERSION"))
        {
          j = parseIntAttr(str2, REGEX_VERSION);
        }
        else if (str2.startsWith("#EXTINF"))
        {
          l7 = (parseDoubleAttr(str2, REGEX_MEDIA_DURATION) * 1000000.0D);
        }
        else if (str2.startsWith("#EXT-X-KEY"))
        {
          String str3 = parseOptionalStringAttr(str2, REGEX_METHOD);
          localObject2 = parseOptionalStringAttr(str2, REGEX_KEYFORMAT);
          if (!"NONE".equals(str3))
          {
            str1 = parseOptionalStringAttr(str2, REGEX_IV);
            if ((!"identity".equals(localObject2)) && (localObject2 != null))
            {
              localObject1 = localObject4;
              if (str3 != null)
              {
                localObject2 = parseWidevineSchemeData(str2, (String)localObject2);
                localObject1 = localObject4;
                if (localObject2 != null)
                {
                  if ((!"SAMPLE-AES-CENC".equals(str3)) && (!"SAMPLE-AES-CTR".equals(str3))) {
                    localObject1 = "cbcs";
                  } else {
                    localObject1 = "cenc";
                  }
                  localObject1 = new DrmInitData((String)localObject1, new DrmInitData.SchemeData[] { localObject2 });
                }
              }
            }
            else
            {
              localObject1 = localObject4;
              if ("AES-128".equals(str3))
              {
                localObject1 = parseStringAttr(str2, REGEX_URI);
                continue;
              }
            }
            localObject2 = null;
            localObject4 = localObject1;
            localObject1 = localObject2;
          }
          else
          {
            localObject1 = null;
            str1 = null;
          }
        }
        else if (str2.startsWith("#EXT-X-BYTERANGE"))
        {
          localObject2 = parseStringAttr(str2, REGEX_BYTERANGE).split("@");
          l3 = Long.parseLong(localObject2[0]);
          l2 = l3;
          if (localObject2.length > 1)
          {
            l1 = Long.parseLong(localObject2[1]);
            l2 = l3;
          }
        }
        else if (str2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE"))
        {
          k = Integer.parseInt(str2.substring(str2.indexOf(':') + 1));
          bool3 = true;
        }
        else if (str2.equals("#EXT-X-DISCONTINUITY"))
        {
          m += 1;
        }
        else
        {
          if (!str2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
            break label786;
          }
          if (l9 != 0L) {
            break;
          }
          l9 = C.msToUs(Util.parseXsDateTime(str2.substring(str2.indexOf(':') + 1))) - l4;
        }
      }
      label786:
      do
      {
        break;
        if (str2.equals("#EXT-X-GAP"))
        {
          bool4 = true;
          break;
        }
        if (str2.equals("#EXT-X-INDEPENDENT-SEGMENTS"))
        {
          bool2 = true;
          break;
        }
        if (str2.equals("#EXT-X-ENDLIST"))
        {
          bool1 = true;
          break;
        }
      } while (str2.startsWith("#"));
      if (localObject1 == null) {
        localObject2 = null;
      } else if (str1 != null) {
        localObject2 = str1;
      } else {
        localObject2 = Long.toHexString(l6);
      }
      l3 = l1;
      if (l2 == -1L) {
        l3 = 0L;
      }
      localArrayList1.add(new HlsMediaPlaylist.Segment(str2, l7, m, l4, (String)localObject1, (String)localObject2, l3, l2, bool4));
      l4 += l7;
      l1 = l3;
      if (l2 != -1L) {
        l1 = l3 + l2;
      }
      l3 = l6 + 1L;
    }
    label960:
    if (l9 != 0L) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    return new HlsMediaPlaylist(i, paramString, localArrayList2, l10, l9, bool3, k, l8, j, l5, bool2, bool1, bool4, localObject4, (HlsMediaPlaylist.Segment)localObject3, localArrayList1);
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
    Pattern localPattern = REGEX_DEFAULT;
    int j = 0;
    int k = parseBooleanAttribute(paramString, localPattern, false);
    int i;
    if (parseBooleanAttribute(paramString, REGEX_FORCED, false)) {
      i = 2;
    } else {
      i = 0;
    }
    if (parseBooleanAttribute(paramString, REGEX_AUTOSELECT, false)) {
      j = 4;
    }
    return k | i | j;
  }
  
  private static String parseStringAttr(String paramString, Pattern paramPattern)
  {
    Object localObject = paramPattern.matcher(paramString);
    if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 1)) {
      return ((Matcher)localObject).group(1);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Couldn't match ");
    ((StringBuilder)localObject).append(paramPattern.pattern());
    ((StringBuilder)localObject).append(" in ");
    ((StringBuilder)localObject).append(paramString);
    throw new ParserException(((StringBuilder)localObject).toString());
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
      if (checkPlaylistHeader(paramInputStream))
      {
        String str;
        for (;;)
        {
          str = paramInputStream.readLine();
          if (str == null) {
            break label229;
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
            if ((str.startsWith("#EXT-X-TARGETDURATION")) || (str.startsWith("#EXT-X-MEDIA-SEQUENCE")) || (str.startsWith("#EXTINF")) || (str.startsWith("#EXT-X-KEY")) || (str.startsWith("#EXT-X-BYTERANGE")) || (str.equals("#EXT-X-DISCONTINUITY")) || (str.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) || (str.equals("#EXT-X-ENDLIST"))) {
              break;
            }
            localArrayDeque.add(str);
          }
        }
        localArrayDeque.add(str);
        paramUri = parseMediaPlaylist(new HlsPlaylistParser.LineIterator(localArrayDeque, paramInputStream), paramUri.toString());
        Util.closeQuietly(paramInputStream);
        return paramUri;
        label229:
        Util.closeQuietly(paramInputStream);
        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
      }
      throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", paramUri);
    }
    finally
    {
      Util.closeQuietly(paramInputStream);
    }
    for (;;)
    {
      throw paramUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser
 * JD-Core Version:    0.7.0.1
 */