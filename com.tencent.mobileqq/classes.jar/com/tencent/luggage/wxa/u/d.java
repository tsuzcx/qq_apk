package com.tencent.luggage.wxa.u;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.luggage.wxa.ao.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class d
{
  private static final a a = a.a("OMX.google.raw.decoder");
  private static final Pattern b = Pattern.compile("^\\D?(\\d+)$");
  private static final HashMap<d.a, List<a>> c = new HashMap();
  private static final SparseIntArray d;
  private static final SparseIntArray e;
  private static final Map<String, Integer> f;
  private static int g = -1;
  
  static
  {
    d = new SparseIntArray();
    d.put(66, 1);
    d.put(77, 2);
    d.put(88, 4);
    d.put(100, 8);
    e = new SparseIntArray();
    e.put(10, 1);
    e.put(11, 4);
    e.put(12, 8);
    e.put(13, 16);
    e.put(20, 32);
    e.put(21, 64);
    e.put(22, 128);
    e.put(30, 256);
    e.put(31, 512);
    e.put(32, 1024);
    e.put(40, 2048);
    e.put(41, 4096);
    e.put(42, 8192);
    e.put(50, 16384);
    e.put(51, 32768);
    e.put(52, 65536);
    f = new HashMap();
    f.put("L30", Integer.valueOf(1));
    f.put("L60", Integer.valueOf(4));
    f.put("L63", Integer.valueOf(16));
    f.put("L90", Integer.valueOf(64));
    f.put("L93", Integer.valueOf(256));
    f.put("L120", Integer.valueOf(1024));
    f.put("L123", Integer.valueOf(4096));
    f.put("L150", Integer.valueOf(16384));
    f.put("L153", Integer.valueOf(65536));
    f.put("L156", Integer.valueOf(262144));
    f.put("L180", Integer.valueOf(1048576));
    f.put("L183", Integer.valueOf(4194304));
    f.put("L186", Integer.valueOf(16777216));
    f.put("H30", Integer.valueOf(2));
    f.put("H60", Integer.valueOf(8));
    f.put("H63", Integer.valueOf(32));
    f.put("H90", Integer.valueOf(128));
    f.put("H93", Integer.valueOf(512));
    f.put("H120", Integer.valueOf(2048));
    f.put("H123", Integer.valueOf(8192));
    f.put("H150", Integer.valueOf(32768));
    f.put("H153", Integer.valueOf(131072));
    f.put("H156", Integer.valueOf(524288));
    f.put("H180", Integer.valueOf(2097152));
    f.put("H183", Integer.valueOf(8388608));
    f.put("H186", Integer.valueOf(33554432));
  }
  
  private static int a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      switch (paramInt)
      {
      default: 
        return -1;
      case 32768: 
      case 65536: 
        return 9437184;
      case 16384: 
        return 5652480;
      case 8192: 
        return 2228224;
      case 2048: 
      case 4096: 
        return 2097152;
      case 1024: 
        return 1310720;
      case 512: 
        return 921600;
      case 128: 
      case 256: 
        return 414720;
      case 64: 
        return 202752;
      }
      return 101376;
    }
    return 25344;
  }
  
  public static Pair<Integer, Integer> a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String[] arrayOfString = paramString.split("\\.");
    int i = 0;
    String str = arrayOfString[0];
    switch (str.hashCode())
    {
    default: 
      break;
    case 3214780: 
      if (str.equals("hvc1")) {
        i = 1;
      }
      break;
    case 3199032: 
      if (!str.equals("hev1")) {
        break;
      }
      break;
    case 3006244: 
      if (str.equals("avc2")) {
        i = 3;
      }
      break;
    case 3006243: 
      if (str.equals("avc1")) {
        i = 2;
      }
      break;
    }
    i = -1;
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3)) {
        return null;
      }
      return b(paramString, arrayOfString);
    }
    return a(paramString, arrayOfString);
  }
  
  private static Pair<Integer, Integer> a(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 4)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("Ignoring malformed HEVC codec string: ");
      paramArrayOfString.append(paramString);
      Log.w("MediaCodecUtil", paramArrayOfString.toString());
      return null;
    }
    Matcher localMatcher = b.matcher(paramArrayOfString[1]);
    if (!localMatcher.matches())
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("Ignoring malformed HEVC codec string: ");
      paramArrayOfString.append(paramString);
      Log.w("MediaCodecUtil", paramArrayOfString.toString());
      return null;
    }
    paramString = localMatcher.group(1);
    int i;
    if ("1".equals(paramString))
    {
      i = 1;
    }
    else
    {
      if (!"2".equals(paramString)) {
        break label189;
      }
      i = 2;
    }
    paramString = (Integer)f.get(paramArrayOfString[3]);
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("Unknown HEVC level string: ");
      paramString.append(localMatcher.group(1));
      Log.w("MediaCodecUtil", paramString.toString());
      return null;
    }
    return new Pair(Integer.valueOf(i), paramString);
    label189:
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("Unknown HEVC profile string: ");
    paramArrayOfString.append(paramString);
    Log.w("MediaCodecUtil", paramArrayOfString.toString());
    return null;
  }
  
  public static a a()
  {
    return a;
  }
  
  public static a a(String paramString, boolean paramBoolean)
  {
    paramString = b(paramString, paramBoolean);
    if (paramString.isEmpty()) {
      return null;
    }
    return (a)paramString.get(0);
  }
  
  private static List<a> a(d.a parama, d.c paramc)
  {
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
        str2 = parama.a;
        int k = paramc.a();
        bool1 = paramc.b();
        i = 0;
        if (i >= k) {
          continue;
        }
        localMediaCodecInfo = paramc.a(i);
        str1 = localMediaCodecInfo.getName();
        if (!a(localMediaCodecInfo, str1, bool1)) {
          continue;
        }
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        j = 0;
        if (j >= m) {
          continue;
        }
        localObject = arrayOfString[j];
        bool2 = ((String)localObject).equalsIgnoreCase(str2);
        if (!bool2) {
          continue;
        }
      }
      catch (Exception parama)
      {
        ArrayList localArrayList;
        String str2;
        boolean bool1;
        int i;
        MediaCodecInfo localMediaCodecInfo;
        String str1;
        int j;
        Object localObject;
        boolean bool2;
        MediaCodecInfo.CodecCapabilities localCodecCapabilities;
        boolean bool3;
        int n;
        parama = new d.b(parama, null);
        continue;
        throw parama;
        continue;
        continue;
      }
      try
      {
        localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType((String)localObject);
        bool2 = paramc.a(str2, localCodecCapabilities);
        bool3 = b(str1);
        if (bool1) {
          if (parama.b == bool2) {
            continue;
          }
        }
        if ((!bool1) && (!parama.b))
        {
          continue;
          localArrayList.add(a.a(str1, str2, localCodecCapabilities, bool3, false));
        }
        else if ((!bool1) && (bool2))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          localStringBuilder.append(".secure");
          localArrayList.add(a.a(localStringBuilder.toString(), str2, localCodecCapabilities, bool3, true));
          return localArrayList;
        }
      }
      catch (Exception localException)
      {
        n = x.a;
        if ((n <= 23) && (!localArrayList.isEmpty()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Skipping codec ");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(" (failed to query capabilities)");
          Log.e("MediaCodecUtil", ((StringBuilder)localObject).toString());
        }
        else
        {
          parama = new StringBuilder();
          parama.append("Failed to query codec ");
          parama.append(str1);
          parama.append(" (");
          parama.append((String)localObject);
          parama.append(")");
          Log.e("MediaCodecUtil", parama.toString());
          throw localException;
        }
      }
      j += 1;
      continue;
      i += 1;
    }
    return localArrayList;
  }
  
  private static void a(List<a> paramList)
  {
    if (x.a < 26)
    {
      int j = paramList.size();
      int i = 1;
      if ((j > 1) && ("OMX.MTK.AUDIO.DECODER.RAW".equals(((a)paramList.get(0)).a))) {
        while (i < paramList.size())
        {
          a locala = (a)paramList.get(i);
          if ("OMX.google.raw.decoder".equals(locala.a))
          {
            paramList.remove(i);
            paramList.add(0, locala);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  private static boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString, boolean paramBoolean)
  {
    if (!paramMediaCodecInfo.isEncoder())
    {
      if ((!paramBoolean) && (paramString.endsWith(".secure"))) {
        return false;
      }
      if ((x.a < 21) && (("CIPAACDecoder".equals(paramString)) || ("CIPMP3Decoder".equals(paramString)) || ("CIPVorbisDecoder".equals(paramString)) || ("CIPAMRNBDecoder".equals(paramString)) || ("AACDecoder".equals(paramString)) || ("MP3Decoder".equals(paramString)))) {
        return false;
      }
      if ((x.a < 18) && ("OMX.SEC.MP3.Decoder".equals(paramString))) {
        return false;
      }
      if ((x.a < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(paramString)) && (("a70".equals(x.b)) || (("Xiaomi".equals(x.c)) && (x.b.startsWith("HM"))))) {
        return false;
      }
      if ((x.a == 16) && ("OMX.qcom.audio.decoder.mp3".equals(paramString)) && (("dlxu".equals(x.b)) || ("protou".equals(x.b)) || ("ville".equals(x.b)) || ("villeplus".equals(x.b)) || ("villec2".equals(x.b)) || (x.b.startsWith("gee")) || ("C6602".equals(x.b)) || ("C6603".equals(x.b)) || ("C6606".equals(x.b)) || ("C6616".equals(x.b)) || ("L36h".equals(x.b)) || ("SO-02E".equals(x.b)))) {
        return false;
      }
      if ((x.a == 16) && ("OMX.qcom.audio.decoder.aac".equals(paramString)) && (("C1504".equals(x.b)) || ("C1505".equals(x.b)) || ("C1604".equals(x.b)) || ("C1605".equals(x.b)))) {
        return false;
      }
      if ((x.a < 24) && (("OMX.SEC.aac.dec".equals(paramString)) || ("OMX.Exynos.AAC.Decoder".equals(paramString))) && (x.c.equals("samsung")) && ((x.b.startsWith("zeroflte")) || (x.b.startsWith("zerolte")) || (x.b.startsWith("zenlte")) || (x.b.equals("SC-05G")) || (x.b.equals("marinelteatt")) || (x.b.equals("404SC")) || (x.b.equals("SC-04G")) || (x.b.equals("SCV31")))) {
        return false;
      }
      if ((x.a <= 19) && ("OMX.SEC.vp8.dec".equals(paramString)) && ("samsung".equals(x.c)) && ((x.b.startsWith("d2")) || (x.b.startsWith("serrano")) || (x.b.startsWith("jflte")) || (x.b.startsWith("santos")) || (x.b.startsWith("t0")))) {
        return false;
      }
      return (x.a > 19) || (!x.b.startsWith("jflte")) || (!"OMX.qcom.video.decoder.vp8".equals(paramString));
    }
    return false;
  }
  
  public static int b()
  {
    if (g == -1)
    {
      int i = 0;
      int j = 0;
      Object localObject = a("video/avc", false);
      if (localObject != null)
      {
        localObject = ((a)localObject).a();
        int k = localObject.length;
        i = 0;
        while (j < k)
        {
          i = Math.max(a(localObject[j].level), i);
          j += 1;
        }
        if (x.a >= 21) {
          j = 345600;
        } else {
          j = 172800;
        }
        i = Math.max(i, j);
      }
      g = i;
    }
    return g;
  }
  
  private static Pair<Integer, Integer> b(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 2)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("Ignoring malformed AVC codec string: ");
      paramArrayOfString.append(paramString);
      Log.w("MediaCodecUtil", paramArrayOfString.toString());
      return null;
    }
    try
    {
      if (paramArrayOfString[1].length() == 6)
      {
        int i = Integer.parseInt(paramArrayOfString[1].substring(0, 2), 16);
        localInteger = Integer.valueOf(Integer.parseInt(paramArrayOfString[1].substring(4), 16));
        paramArrayOfString = Integer.valueOf(i);
        paramString = localInteger;
      }
      else
      {
        if (paramArrayOfString.length < 3) {
          break label235;
        }
        localInteger = Integer.valueOf(Integer.parseInt(paramArrayOfString[1]));
        paramArrayOfString = Integer.valueOf(Integer.parseInt(paramArrayOfString[2]));
        paramString = paramArrayOfString;
        paramArrayOfString = localInteger;
      }
      Integer localInteger = Integer.valueOf(d.get(paramArrayOfString.intValue()));
      if (localInteger == null)
      {
        paramString = new StringBuilder();
        paramString.append("Unknown AVC profile: ");
        paramString.append(paramArrayOfString);
        Log.w("MediaCodecUtil", paramString.toString());
        return null;
      }
      paramArrayOfString = Integer.valueOf(e.get(paramString.intValue()));
      if (paramArrayOfString == null)
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Unknown AVC level: ");
        paramArrayOfString.append(paramString);
        Log.w("MediaCodecUtil", paramArrayOfString.toString());
        return null;
      }
      return new Pair(localInteger, paramArrayOfString);
      label235:
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("Ignoring malformed AVC codec string: ");
      paramArrayOfString.append(paramString);
      Log.w("MediaCodecUtil", paramArrayOfString.toString());
      return null;
    }
    catch (NumberFormatException paramArrayOfString)
    {
      label269:
      break label269;
    }
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("Ignoring malformed AVC codec string: ");
    paramArrayOfString.append(paramString);
    Log.w("MediaCodecUtil", paramArrayOfString.toString());
    return null;
  }
  
  public static List<a> b(String paramString, boolean paramBoolean)
  {
    try
    {
      d.a locala = new d.a(paramString, paramBoolean);
      Object localObject = (List)c.get(locala);
      if (localObject != null) {
        return localObject;
      }
      if (x.a >= 21) {
        localObject = new d.e(paramBoolean);
      } else {
        localObject = new d.d(null);
      }
      List localList = a(locala, (d.c)localObject);
      localObject = localList;
      if (paramBoolean)
      {
        localObject = localList;
        if (localList.isEmpty())
        {
          localObject = localList;
          if (21 <= x.a)
          {
            localObject = localList;
            if (x.a <= 23)
            {
              localList = a(locala, new d.d(null));
              localObject = localList;
              if (!localList.isEmpty())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("MediaCodecList API didn't list secure decoder for: ");
                ((StringBuilder)localObject).append(paramString);
                ((StringBuilder)localObject).append(". Assuming: ");
                ((StringBuilder)localObject).append(((a)localList.get(0)).a);
                Log.w("MediaCodecUtil", ((StringBuilder)localObject).toString());
                localObject = localList;
              }
            }
          }
        }
      }
      a((List)localObject);
      paramString = Collections.unmodifiableList((List)localObject);
      c.put(locala, paramString);
      return paramString;
    }
    finally {}
  }
  
  private static boolean b(String paramString)
  {
    return (x.a <= 22) && ((x.d.equals("ODROID-XU3")) || (x.d.equals("Nexus 10"))) && (("OMX.Exynos.AVC.Decoder".equals(paramString)) || ("OMX.Exynos.AVC.Decoder.secure".equals(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.u.d
 * JD-Core Version:    0.7.0.1
 */