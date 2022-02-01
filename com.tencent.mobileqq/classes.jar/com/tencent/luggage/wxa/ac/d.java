package com.tencent.luggage.wxa.ac;

import android.net.Uri;
import com.tencent.luggage.wxa.am.u.a;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d
  implements u.a<c>
{
  private static final Pattern a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
  private static final Pattern b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
  private static final Pattern c = Pattern.compile("CODECS=\"(.+?)\"");
  private static final Pattern d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
  private static final Pattern e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
  private static final Pattern f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
  private static final Pattern g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
  private static final Pattern h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
  private static final Pattern i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
  private static final Pattern j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
  private static final Pattern k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
  private static final Pattern l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
  private static final Pattern m = Pattern.compile("METHOD=(NONE|AES-128)");
  private static final Pattern n = Pattern.compile("URI=\"(.+?)\"");
  private static final Pattern o = Pattern.compile("IV=([^,.*]+)");
  private static final Pattern p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
  private static final Pattern q = Pattern.compile("LANGUAGE=\"(.+?)\"");
  private static final Pattern r = Pattern.compile("NAME=\"(.+?)\"");
  private static final Pattern s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
  private static final Pattern t = b("AUTOSELECT");
  private static final Pattern u = b("DEFAULT");
  private static final Pattern v = b("FORCED");
  
  private static int a(BufferedReader paramBufferedReader, boolean paramBoolean, int paramInt)
  {
    while ((paramInt != -1) && (Character.isWhitespace(paramInt)) && ((paramBoolean) || (!x.a(paramInt)))) {
      paramInt = paramBufferedReader.read();
    }
    return paramInt;
  }
  
  private static int a(String paramString)
  {
    Pattern localPattern = u;
    int i2 = 0;
    int i3 = a(paramString, localPattern, false);
    int i1;
    if (a(paramString, v, false)) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    if (a(paramString, t, false)) {
      i2 = 4;
    }
    return i3 | i1 | i2;
  }
  
  private static int a(String paramString, Pattern paramPattern)
  {
    return Integer.parseInt(d(paramString, paramPattern));
  }
  
  private static a a(d.a parama, String paramString)
  {
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    int i2 = 0;
    while (parama.a())
    {
      String str3 = parama.b();
      com.tencent.luggage.wxa.t.b.a("master ExoPlayer", str3, new Object[0]);
      if (str3.startsWith("#EXT")) {
        localArrayList4.add(str3);
      }
      int i3;
      Object localObject2;
      String str1;
      String str2;
      Object localObject4;
      int i1;
      label227:
      int i4;
      if (str3.startsWith("#EXT-X-MEDIA"))
      {
        i3 = a(str3);
        localObject2 = c(str3, n);
        str1 = d(str3, r);
        str2 = c(str3, q);
        localObject4 = d(str3, p);
        i1 = ((String)localObject4).hashCode();
        if (i1 != -959297733)
        {
          if (i1 != -333210994)
          {
            if ((i1 == 62628790) && (((String)localObject4).equals("AUDIO")))
            {
              i1 = 0;
              break label227;
            }
          }
          else if (((String)localObject4).equals("CLOSED-CAPTIONS"))
          {
            i1 = 2;
            break label227;
          }
        }
        else if (((String)localObject4).equals("SUBTITLES"))
        {
          i1 = 1;
          break label227;
        }
        i1 = -1;
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              i4 = i2;
              localObject4 = localObject3;
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = d(str3, s);
              if (((String)localObject2).startsWith("CC"))
              {
                i1 = Integer.parseInt(((String)localObject2).substring(2));
                localObject4 = "application/cea-608";
              }
              else
              {
                i1 = Integer.parseInt(((String)localObject2).substring(7));
                localObject4 = "application/cea-708";
              }
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new ArrayList();
              }
              ((List)localObject2).add(k.a(str1, null, (String)localObject4, null, -1, i3, str2, i1));
              i4 = i2;
              localObject4 = localObject3;
            }
          }
          else
          {
            localArrayList3.add(new a.a((String)localObject2, k.a(str1, "application/x-mpegURL", "text/vtt", null, -1, i3, str2)));
            i4 = i2;
            localObject4 = localObject3;
            localObject2 = localObject1;
          }
        }
        else
        {
          localObject4 = k.a(str1, "application/x-mpegURL", null, null, -1, -1, -1, null, i3, str2);
          if (localObject2 == null)
          {
            i4 = i2;
            localObject2 = localObject1;
          }
          else
          {
            localArrayList2.add(new a.a((String)localObject2, (k)localObject4));
            i4 = i2;
            localObject4 = localObject3;
            localObject2 = localObject1;
          }
        }
      }
      else
      {
        i4 = i2;
        localObject4 = localObject3;
        localObject2 = localObject1;
        if (str3.startsWith("#EXT-X-STREAM-INF"))
        {
          i3 = a(str3, b);
          localObject2 = c(str3, a);
          if (localObject2 != null) {
            i3 = Integer.parseInt((String)localObject2);
          }
          str1 = c(str3, c);
          localObject2 = c(str3, d);
          int i5 = i2 | str3.contains("CLOSED-CAPTIONS=NONE");
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).split("x");
            i1 = Integer.parseInt(localObject2[0]);
            i2 = Integer.parseInt(localObject2[1]);
            if ((i1 > 0) && (i2 > 0)) {
              break label601;
            }
            i2 = -1;
            i1 = -1;
          }
          else
          {
            label601:
            i1 = -1;
            i2 = -1;
          }
          str2 = parama.b();
          i4 = i5;
          localObject4 = localObject3;
          localObject2 = localObject1;
          if (localHashSet.add(str2))
          {
            localArrayList1.add(new a.a(str2, k.a(Integer.toString(localArrayList1.size()), "application/x-mpegURL", null, str1, i3, i1, i2, -1.0F, null, 0)));
            localObject2 = localObject1;
            localObject4 = localObject3;
            i4 = i5;
          }
        }
      }
      i2 = i4;
      localObject3 = localObject4;
      localObject1 = localObject2;
    }
    if (i2 != 0) {
      localObject1 = Collections.emptyList();
    }
    return new a(paramString, localArrayList4, localArrayList1, localArrayList2, localArrayList3, localObject3, (List)localObject1);
  }
  
  private static boolean a(BufferedReader paramBufferedReader)
  {
    int i2 = paramBufferedReader.read();
    int i1 = i2;
    if (i2 == 239) {
      if (paramBufferedReader.read() == 187)
      {
        if (paramBufferedReader.read() != 191) {
          return false;
        }
        i1 = paramBufferedReader.read();
      }
      else
      {
        return false;
      }
    }
    i2 = a(paramBufferedReader, true, i1);
    i1 = 0;
    while (i1 < 7)
    {
      if (i2 != "#EXTM3U".charAt(i1)) {
        return false;
      }
      i2 = paramBufferedReader.read();
      i1 += 1;
    }
    return x.a(a(paramBufferedReader, false, i2));
  }
  
  private static boolean a(String paramString, Pattern paramPattern, boolean paramBoolean)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1).equals("YES");
    }
    return paramBoolean;
  }
  
  private static double b(String paramString, Pattern paramPattern)
  {
    return Double.parseDouble(d(paramString, paramPattern));
  }
  
  private static b b(d.a parama, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    long l14 = -9223372036854775807L;
    long l12 = l14;
    long l13 = 0L;
    long l1 = l13;
    long l2 = l1;
    long l8 = l2;
    int i12 = 0;
    int i11 = 0;
    boolean bool7 = false;
    int i10 = 0;
    int i9 = 0;
    int i8 = 1;
    boolean bool6 = false;
    boolean bool5 = false;
    Object localObject1 = null;
    int i7 = 0;
    long l10 = -1L;
    boolean bool1 = false;
    long l9 = l2;
    long l11 = l1;
    String str1 = null;
    String str2 = null;
    long l3 = l8;
    long l7 = l9;
    l2 = l10;
    int i2 = i7;
    l1 = l11;
    Object localObject2 = localObject1;
    boolean bool4 = bool5;
    boolean bool3 = bool6;
    long l6 = l12;
    int i6 = i8;
    int i5 = i9;
    int i4 = i10;
    boolean bool2 = bool7;
    long l5 = l13;
    long l4 = l14;
    int i1 = i11;
    int i3 = i12;
    for (;;)
    {
      if (!parama.a()) {
        break label974;
      }
      String str3 = parama.b();
      com.tencent.luggage.wxa.t.b.a("ExoPlayer", str3, new Object[0]);
      if (str3.startsWith("#EXT")) {
        localArrayList2.add(str3);
      }
      if (str3.startsWith("#EXT-X-PLAYLIST-TYPE"))
      {
        localObject1 = d(str3, g);
        if ("VOD".equals(localObject1)) {
          i1 = 1;
        } else if ("EVENT".equals(localObject1)) {
          i1 = 2;
        }
      }
      else if (str3.startsWith("#EXT-X-START"))
      {
        l4 = (b(str3, j) * 1000000.0D);
      }
      else if (str3.startsWith("#EXT-X-MAP"))
      {
        localObject1 = d(str3, n);
        localObject2 = c(str3, l);
        l8 = l1;
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).split("@");
          l9 = Long.parseLong(localObject2[0]);
          l8 = l1;
          l2 = l9;
          if (localObject2.length > 1)
          {
            l8 = Long.parseLong(localObject2[1]);
            l2 = l9;
          }
        }
        localObject2 = new b.a((String)localObject1, l8, l2);
        l1 = 0L;
        l2 = -1L;
      }
      else if (str3.startsWith("#EXT-X-TARGETDURATION"))
      {
        l6 = 1000000L * a(str3, e);
      }
      else if (str3.startsWith("#EXT-X-MEDIA-SEQUENCE"))
      {
        i2 = a(str3, h);
        i5 = i2;
      }
      else if (str3.startsWith("#EXT-X-VERSION"))
      {
        i6 = a(str3, f);
      }
      else if (str3.startsWith("#EXTINF"))
      {
        l3 = (b(str3, i) * 1000000.0D);
      }
      else
      {
        if (str3.startsWith("#EXT-X-KEY"))
        {
          boolean bool8 = "AES-128".equals(d(str3, m));
          i12 = i3;
          i11 = i1;
          l14 = l4;
          l13 = l5;
          bool7 = bool2;
          i10 = i4;
          i9 = i5;
          i8 = i6;
          l12 = l6;
          bool6 = bool3;
          bool5 = bool4;
          localObject1 = localObject2;
          l11 = l1;
          i7 = i2;
          l10 = l2;
          bool1 = bool8;
          l9 = l7;
          l8 = l3;
          if (!bool8) {
            break;
          }
          str2 = d(str3, n);
          str1 = c(str3, o);
          bool1 = bool8;
          continue;
        }
        if (str3.startsWith("#EXT-X-BYTERANGE"))
        {
          localObject1 = d(str3, k).split("@");
          l8 = Long.parseLong(localObject1[0]);
          l2 = l8;
          if (localObject1.length > 1)
          {
            l1 = Long.parseLong(localObject1[1]);
            l2 = l8;
          }
        }
        else if (str3.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE"))
        {
          i4 = Integer.parseInt(str3.substring(str3.indexOf(':') + 1));
          bool2 = true;
        }
        else if (str3.equals("#EXT-X-DISCONTINUITY"))
        {
          i3 += 1;
        }
        else if (str3.startsWith("#EXT-X-PROGRAM-DATE-TIME"))
        {
          if (l5 == 0L) {
            l5 = com.tencent.luggage.wxa.h.b.b(x.e(str3.substring(str3.indexOf(':') + 1))) - l7;
          }
        }
        else if (!str3.startsWith("#"))
        {
          if (!bool1) {
            localObject1 = null;
          } else if (str1 != null) {
            localObject1 = str1;
          } else {
            localObject1 = Integer.toHexString(i2);
          }
          if (l2 == -1L) {
            l1 = 0L;
          }
          localArrayList1.add(new b.a(str3, l3, i3, l7, bool1, str2, (String)localObject1, l1, l2));
          l7 += l3;
          l3 = l1;
          if (l2 != -1L) {
            l3 = l1 + l2;
          }
          i2 += 1;
          l8 = 0L;
          l2 = -1L;
          l1 = l3;
          l3 = l8;
        }
        else if (str3.equals("#EXT-X-INDEPENDENT-SEGMENTS"))
        {
          bool3 = true;
        }
        else if (str3.equals("#EXT-X-ENDLIST"))
        {
          bool4 = true;
        }
      }
    }
    label974:
    if (l5 != 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    return new b(i1, paramString, localArrayList2, l4, l5, bool2, i4, i5, i6, l6, bool3, bool4, bool1, (b.a)localObject2, localArrayList1);
  }
  
  private static Pattern b(String paramString)
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
  
  private static String c(String paramString, Pattern paramPattern)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  private static String d(String paramString, Pattern paramPattern)
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
    throw new com.tencent.luggage.wxa.h.p(((StringBuilder)localObject).toString());
  }
  
  public c a(Uri paramUri, InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    LinkedList localLinkedList = new LinkedList();
    try
    {
      if (a(paramInputStream))
      {
        String str;
        for (;;)
        {
          str = paramInputStream.readLine();
          if (str == null) {
            break label237;
          }
          str = str.trim();
          if (!str.isEmpty())
          {
            if (str.startsWith("#EXT-X-STREAM-INF"))
            {
              localLinkedList.add(str);
              paramUri = a(new d.a(localLinkedList, paramInputStream), paramUri.toString());
              x.a(paramInputStream);
              return paramUri;
            }
            if ((str.startsWith("#EXT-X-TARGETDURATION")) || (str.startsWith("#EXT-X-MEDIA-SEQUENCE")) || (str.startsWith("#EXTINF")) || (str.startsWith("#EXT-X-KEY")) || (str.startsWith("#EXT-X-BYTERANGE")) || (str.equals("#EXT-X-DISCONTINUITY")) || (str.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) || (str.equals("#EXT-X-ENDLIST"))) {
              break;
            }
            localLinkedList.add(str);
          }
        }
        localLinkedList.add(str);
        paramUri = b(new d.a(localLinkedList, paramInputStream), paramUri.toString());
        x.a(paramInputStream);
        return paramUri;
        label237:
        x.a(paramInputStream);
        throw new com.tencent.luggage.wxa.h.p("Failed to parse the playlist, could not identify any tags.");
      }
      com.tencent.luggage.wxa.t.b.c("ExoPlayer", "parse, not the #EXTM3U header, uri:%s, reader:%s", new Object[] { paramUri.toString(), paramInputStream.readLine() });
      throw new com.tencent.luggage.wxa.z.p("Input does not start with the #EXTM3U header.", paramUri);
    }
    finally
    {
      x.a(paramInputStream);
    }
    for (;;)
    {
      throw paramUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ac.d
 * JD-Core Version:    0.7.0.1
 */