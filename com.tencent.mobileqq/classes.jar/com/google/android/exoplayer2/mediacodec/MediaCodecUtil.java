package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class MediaCodecUtil
{
  private static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST;
  private static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST;
  private static final String CODEC_ID_AVC1 = "avc1";
  private static final String CODEC_ID_AVC2 = "avc2";
  private static final String CODEC_ID_HEV1 = "hev1";
  private static final String CODEC_ID_HVC1 = "hvc1";
  private static final String GOOGLE_RAW_DECODER_NAME = "OMX.google.raw.decoder";
  private static final Map<String, Integer> HEVC_CODEC_STRING_TO_PROFILE_LEVEL;
  private static final String MTK_RAW_DECODER_NAME = "OMX.MTK.AUDIO.DECODER.RAW";
  private static final MediaCodecInfo PASSTHROUGH_DECODER_INFO = MediaCodecInfo.newPassthroughInstance("OMX.google.raw.decoder");
  private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
  private static final String TAG = "MediaCodecUtil";
  private static final HashMap<MediaCodecUtil.CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap();
  private static int maxH264DecodableFrameSize = -1;
  
  static
  {
    AVC_PROFILE_NUMBER_TO_CONST = new SparseIntArray();
    AVC_PROFILE_NUMBER_TO_CONST.put(66, 1);
    AVC_PROFILE_NUMBER_TO_CONST.put(77, 2);
    AVC_PROFILE_NUMBER_TO_CONST.put(88, 4);
    AVC_PROFILE_NUMBER_TO_CONST.put(100, 8);
    AVC_LEVEL_NUMBER_TO_CONST = new SparseIntArray();
    AVC_LEVEL_NUMBER_TO_CONST.put(10, 1);
    AVC_LEVEL_NUMBER_TO_CONST.put(11, 4);
    AVC_LEVEL_NUMBER_TO_CONST.put(12, 8);
    AVC_LEVEL_NUMBER_TO_CONST.put(13, 16);
    AVC_LEVEL_NUMBER_TO_CONST.put(20, 32);
    AVC_LEVEL_NUMBER_TO_CONST.put(21, 64);
    AVC_LEVEL_NUMBER_TO_CONST.put(22, 128);
    AVC_LEVEL_NUMBER_TO_CONST.put(30, 256);
    AVC_LEVEL_NUMBER_TO_CONST.put(31, 512);
    AVC_LEVEL_NUMBER_TO_CONST.put(32, 1024);
    AVC_LEVEL_NUMBER_TO_CONST.put(40, 2048);
    AVC_LEVEL_NUMBER_TO_CONST.put(41, 4096);
    AVC_LEVEL_NUMBER_TO_CONST.put(42, 8192);
    AVC_LEVEL_NUMBER_TO_CONST.put(50, 16384);
    AVC_LEVEL_NUMBER_TO_CONST.put(51, 32768);
    AVC_LEVEL_NUMBER_TO_CONST.put(52, 65536);
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL = new HashMap();
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L30", Integer.valueOf(1));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L60", Integer.valueOf(4));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L63", Integer.valueOf(16));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L90", Integer.valueOf(64));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L93", Integer.valueOf(256));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L120", Integer.valueOf(1024));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L123", Integer.valueOf(4096));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L150", Integer.valueOf(16384));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L153", Integer.valueOf(65536));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L156", Integer.valueOf(262144));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L180", Integer.valueOf(1048576));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L183", Integer.valueOf(4194304));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L186", Integer.valueOf(16777216));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H30", Integer.valueOf(2));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H60", Integer.valueOf(8));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H63", Integer.valueOf(32));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H90", Integer.valueOf(128));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H93", Integer.valueOf(512));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H120", Integer.valueOf(2048));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H123", Integer.valueOf(8192));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H150", Integer.valueOf(32768));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H153", Integer.valueOf(131072));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H156", Integer.valueOf(524288));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H180", Integer.valueOf(2097152));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H183", Integer.valueOf(8388608));
    HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H186", Integer.valueOf(33554432));
  }
  
  private static void applySoftDecoderSelection(List<MediaCodecInfo> paramList)
  {
    int i = 1;
    while (i < paramList.size())
    {
      if (!isSoftwareCodec(((MediaCodecInfo)paramList.get(i)).name)) {
        paramList.remove(i);
      }
      i += 1;
    }
  }
  
  private static void applyWorkarounds(List<MediaCodecInfo> paramList)
  {
    int i = 1;
    if ((Util.SDK_INT < 26) && (paramList.size() > 1) && ("OMX.MTK.AUDIO.DECODER.RAW".equals(((MediaCodecInfo)paramList.get(0)).name))) {}
    for (;;)
    {
      if (i < paramList.size())
      {
        MediaCodecInfo localMediaCodecInfo = (MediaCodecInfo)paramList.get(i);
        if ("OMX.google.raw.decoder".equals(localMediaCodecInfo.name))
        {
          paramList.remove(i);
          paramList.add(0, localMediaCodecInfo);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private static int avcLevelToMaxFrameSize(int paramInt)
  {
    int i = 25344;
    switch (paramInt)
    {
    default: 
      i = -1;
    case 1: 
    case 2: 
      return i;
    case 8: 
      return 101376;
    case 16: 
      return 101376;
    case 32: 
      return 101376;
    case 64: 
      return 202752;
    case 128: 
      return 414720;
    case 256: 
      return 414720;
    case 512: 
      return 921600;
    case 1024: 
      return 1310720;
    case 2048: 
      return 2097152;
    case 4096: 
      return 2097152;
    case 8192: 
      return 2228224;
    case 16384: 
      return 5652480;
    case 32768: 
      return 9437184;
    }
    return 9437184;
  }
  
  private static boolean codecNeedsDisableAdaptationWorkaround(String paramString)
  {
    return (Util.SDK_INT <= 22) && ((Util.MODEL.equals("ODROID-XU3")) || (Util.MODEL.equals("Nexus 10"))) && (("OMX.Exynos.AVC.Decoder".equals(paramString)) || ("OMX.Exynos.AVC.Decoder.secure".equals(paramString)));
  }
  
  private static Pair<Integer, Integer> getAvcProfileAndLevel(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 2)
    {
      Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + paramString);
      return null;
    }
    Integer localInteger;
    try
    {
      if (paramArrayOfString[1].length() == 6)
      {
        localInteger = Integer.valueOf(Integer.parseInt(paramArrayOfString[1].substring(0, 2), 16));
        int i = Integer.parseInt(paramArrayOfString[1].substring(4), 16);
        paramString = Integer.valueOf(i);
      }
      for (paramArrayOfString = localInteger;; paramArrayOfString = localInteger)
      {
        localInteger = Integer.valueOf(AVC_PROFILE_NUMBER_TO_CONST.get(paramArrayOfString.intValue()));
        if (localInteger != null) {
          break label215;
        }
        Log.w("MediaCodecUtil", "Unknown AVC profile: " + paramArrayOfString);
        return null;
        if (paramArrayOfString.length < 3) {
          break;
        }
        localInteger = Integer.valueOf(Integer.parseInt(paramArrayOfString[1]));
        paramArrayOfString = Integer.valueOf(Integer.parseInt(paramArrayOfString[2]));
        paramString = paramArrayOfString;
      }
      Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + paramString);
      return null;
    }
    catch (NumberFormatException paramArrayOfString)
    {
      Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + paramString);
      return null;
    }
    label215:
    paramArrayOfString = Integer.valueOf(AVC_LEVEL_NUMBER_TO_CONST.get(paramString.intValue()));
    if (paramArrayOfString == null)
    {
      Log.w("MediaCodecUtil", "Unknown AVC level: " + paramString);
      return null;
    }
    return new Pair(localInteger, paramArrayOfString);
  }
  
  public static Pair<Integer, Integer> getCodecProfileAndLevel(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    String[] arrayOfString = paramString.split("\\.");
    String str = arrayOfString[0];
    switch (str.hashCode())
    {
    default: 
      label68:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
      case 0: 
      case 1: 
        return getHevcProfileAndLevel(paramString, arrayOfString);
        if (!str.equals("hev1")) {
          break label68;
        }
        continue;
        if (!str.equals("hvc1")) {
          break label68;
        }
        i = 1;
        continue;
        if (!str.equals("avc1")) {
          break label68;
        }
        i = 2;
        continue;
        if (!str.equals("avc2")) {
          break label68;
        }
        i = 3;
      }
    }
    return getAvcProfileAndLevel(paramString, arrayOfString);
  }
  
  @Nullable
  public static MediaCodecInfo getDecoderInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = getDecoderInfos(paramString, paramBoolean1, paramBoolean2);
    if (paramString.isEmpty()) {
      return null;
    }
    return (MediaCodecInfo)paramString.get(0);
  }
  
  public static List<MediaCodecInfo> getDecoderInfos(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    label285:
    for (;;)
    {
      try
      {
        MediaCodecUtil.CodecKey localCodecKey = new MediaCodecUtil.CodecKey(paramString, paramBoolean1);
        Object localObject1 = (List)decoderInfosCache.get(localCodecKey);
        if (localObject1 != null)
        {
          paramString = (String)localObject1;
          return paramString;
        }
        if (Util.SDK_INT >= 21)
        {
          localObject1 = new MediaCodecUtil.MediaCodecListCompatV21(paramBoolean1);
          ArrayList localArrayList2 = getDecoderInfosInternal(localCodecKey, (MediaCodecUtil.MediaCodecListCompat)localObject1, paramString);
          ArrayList localArrayList1 = localArrayList2;
          Object localObject2 = localObject1;
          if (paramBoolean1)
          {
            localArrayList1 = localArrayList2;
            localObject2 = localObject1;
            if (localArrayList2.isEmpty())
            {
              localArrayList1 = localArrayList2;
              localObject2 = localObject1;
              if (21 <= Util.SDK_INT)
              {
                localArrayList1 = localArrayList2;
                localObject2 = localObject1;
                if (Util.SDK_INT <= 23)
                {
                  localObject2 = new MediaCodecUtil.MediaCodecListCompatV16(null);
                  localArrayList1 = getDecoderInfosInternal(localCodecKey, (MediaCodecUtil.MediaCodecListCompat)localObject2, paramString);
                  if (localArrayList1.isEmpty()) {
                    break label285;
                  }
                  Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + paramString + ". Assuming: " + ((MediaCodecInfo)localArrayList1.get(0)).name);
                  break label285;
                }
              }
            }
          }
          if ("audio/eac3-joc".equals(paramString)) {
            localArrayList1.addAll(getDecoderInfosInternal(new MediaCodecUtil.CodecKey("audio/eac3", localCodecKey.secure), (MediaCodecUtil.MediaCodecListCompat)localObject2, paramString));
          }
          applyWorkarounds(localArrayList1);
          if (paramBoolean2) {
            applySoftDecoderSelection(localArrayList1);
          }
          paramString = Collections.unmodifiableList(localArrayList1);
          decoderInfosCache.put(localCodecKey, paramString);
          continue;
        }
        localObject1 = new MediaCodecUtil.MediaCodecListCompatV16(null);
      }
      finally {}
    }
  }
  
  private static ArrayList<MediaCodecInfo> getDecoderInfosInternal(MediaCodecUtil.CodecKey paramCodecKey, MediaCodecUtil.MediaCodecListCompat paramMediaCodecListCompat, String paramString)
  {
    for (;;)
    {
      int i;
      String str2;
      int j;
      String str3;
      try
      {
        ArrayList localArrayList = new ArrayList();
        String str1 = paramCodecKey.mimeType;
        int k = paramMediaCodecListCompat.getCodecCount();
        boolean bool1 = paramMediaCodecListCompat.secureDecodersExplicit();
        i = 0;
        android.media.MediaCodecInfo localMediaCodecInfo;
        boolean bool2;
        if (i < k)
        {
          localMediaCodecInfo = paramMediaCodecListCompat.getCodecInfoAt(i);
          str2 = localMediaCodecInfo.getName();
          if (!isCodecUsableDecoder(localMediaCodecInfo, str2, bool1, paramString)) {
            break label348;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int m = arrayOfString.length;
          j = 0;
          if (j >= m) {
            break label348;
          }
          str3 = arrayOfString[j];
          bool2 = str3.equalsIgnoreCase(str1);
          if (!bool2) {
            break label355;
          }
        }
        try
        {
          MediaCodecInfo.CodecCapabilities localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(str3);
          bool2 = paramMediaCodecListCompat.isSecurePlaybackSupported(str1, localCodecCapabilities);
          boolean bool3 = codecNeedsDisableAdaptationWorkaround(str2);
          if (((bool1) && (paramCodecKey.secure == bool2)) || ((!bool1) && (!paramCodecKey.secure)))
          {
            localArrayList.add(MediaCodecInfo.newInstance(str2, str1, localCodecCapabilities, bool3, false));
            break label355;
          }
          if ((bool1) || (!bool2)) {
            break label355;
          }
          localArrayList.add(MediaCodecInfo.newInstance(str2 + ".secure", str1, localCodecCapabilities, bool3, true));
          return localArrayList;
        }
        catch (Exception localException)
        {
          if (Util.SDK_INT > 23) {
            break label301;
          }
        }
        if (!localArrayList.isEmpty()) {
          Log.e("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
        }
      }
      catch (Exception paramCodecKey)
      {
        throw new MediaCodecUtil.DecoderQueryException(paramCodecKey, null);
      }
      label301:
      Log.e("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str3 + ")");
      throw localException;
      label348:
      i += 1;
      continue;
      label355:
      j += 1;
    }
  }
  
  private static Pair<Integer, Integer> getHevcProfileAndLevel(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 4)
    {
      Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + paramString);
      return null;
    }
    Matcher localMatcher = PROFILE_PATTERN.matcher(paramArrayOfString[1]);
    if (!localMatcher.matches())
    {
      Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + paramString);
      return null;
    }
    paramString = localMatcher.group(1);
    if ("1".equals(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = (Integer)HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(paramArrayOfString[3]);
      if (paramString != null) {
        break label191;
      }
      Log.w("MediaCodecUtil", "Unknown HEVC level string: " + localMatcher.group(1));
      return null;
      if (!"2".equals(paramString)) {
        break;
      }
    }
    Log.w("MediaCodecUtil", "Unknown HEVC profile string: " + paramString);
    return null;
    label191:
    return new Pair(Integer.valueOf(i), paramString);
  }
  
  public static MediaCodecInfo getPassthroughDecoderInfo()
  {
    return PASSTHROUGH_DECODER_INFO;
  }
  
  private static boolean isCodecUsableDecoder(android.media.MediaCodecInfo paramMediaCodecInfo, String paramString1, boolean paramBoolean, String paramString2)
  {
    if ((paramMediaCodecInfo.isEncoder()) || ((!paramBoolean) && (paramString1.endsWith(".secure")))) {}
    while (((Util.SDK_INT < 21) && (("CIPAACDecoder".equals(paramString1)) || ("CIPMP3Decoder".equals(paramString1)) || ("CIPVorbisDecoder".equals(paramString1)) || ("CIPAMRNBDecoder".equals(paramString1)) || ("AACDecoder".equals(paramString1)) || ("MP3Decoder".equals(paramString1)))) || ((Util.SDK_INT < 18) && ("OMX.SEC.MP3.Decoder".equals(paramString1))) || ((Util.SDK_INT < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(paramString1)) && (("a70".equals(Util.DEVICE)) || (("Xiaomi".equals(Util.MANUFACTURER)) && (Util.DEVICE.startsWith("HM"))))) || ((Util.SDK_INT == 16) && ("OMX.qcom.audio.decoder.mp3".equals(paramString1)) && (("dlxu".equals(Util.DEVICE)) || ("protou".equals(Util.DEVICE)) || ("ville".equals(Util.DEVICE)) || ("villeplus".equals(Util.DEVICE)) || ("villec2".equals(Util.DEVICE)) || (Util.DEVICE.startsWith("gee")) || ("C6602".equals(Util.DEVICE)) || ("C6603".equals(Util.DEVICE)) || ("C6606".equals(Util.DEVICE)) || ("C6616".equals(Util.DEVICE)) || ("L36h".equals(Util.DEVICE)) || ("SO-02E".equals(Util.DEVICE)))) || ((Util.SDK_INT == 16) && ("OMX.qcom.audio.decoder.aac".equals(paramString1)) && (("C1504".equals(Util.DEVICE)) || ("C1505".equals(Util.DEVICE)) || ("C1604".equals(Util.DEVICE)) || ("C1605".equals(Util.DEVICE)))) || ((Util.SDK_INT < 24) && (("OMX.SEC.aac.dec".equals(paramString1)) || ("OMX.Exynos.AAC.Decoder".equals(paramString1))) && (Util.MANUFACTURER.equals("samsung")) && ((Util.DEVICE.startsWith("zeroflte")) || (Util.DEVICE.startsWith("zerolte")) || (Util.DEVICE.startsWith("zenlte")) || (Util.DEVICE.equals("SC-05G")) || (Util.DEVICE.equals("marinelteatt")) || (Util.DEVICE.equals("404SC")) || (Util.DEVICE.equals("SC-04G")) || (Util.DEVICE.equals("SCV31")))) || ((Util.SDK_INT <= 19) && ("OMX.SEC.vp8.dec".equals(paramString1)) && ("samsung".equals(Util.MANUFACTURER)) && ((Util.DEVICE.startsWith("d2")) || (Util.DEVICE.startsWith("serrano")) || (Util.DEVICE.startsWith("jflte")) || (Util.DEVICE.startsWith("santos")) || (Util.DEVICE.startsWith("t0")))) || ((Util.SDK_INT <= 19) && (Util.DEVICE.startsWith("jflte")) && ("OMX.qcom.video.decoder.vp8".equals(paramString1))) || (("audio/eac3-joc".equals(paramString2)) && ("OMX.MTK.AUDIO.DECODER.DSPAC3".equals(paramString1)))) {
      return false;
    }
    return true;
  }
  
  private static boolean isSoftwareCodec(String paramString)
  {
    return (paramString.toLowerCase().startsWith("omx.google.")) || (!paramString.toLowerCase().startsWith("omx."));
  }
  
  public static int maxH264DecodableFrameSize()
  {
    int i = 0;
    int j = 0;
    if (maxH264DecodableFrameSize == -1)
    {
      Object localObject = getDecoderInfo("video/avc", false, false);
      if (localObject != null)
      {
        localObject = ((MediaCodecInfo)localObject).getProfileLevels();
        int k = localObject.length;
        i = 0;
        while (j < k)
        {
          i = Math.max(avcLevelToMaxFrameSize(localObject[j].level), i);
          j += 1;
        }
        if (Util.SDK_INT < 21) {
          break label86;
        }
      }
    }
    label86:
    for (j = 345600;; j = 172800)
    {
      i = Math.max(i, j);
      maxH264DecodableFrameSize = i;
      return maxH264DecodableFrameSize;
    }
  }
  
  public static void warmDecoderInfoCache(String paramString, boolean paramBoolean)
  {
    try
    {
      getDecoderInfos(paramString, paramBoolean, false);
      return;
    }
    catch (MediaCodecUtil.DecoderQueryException paramString)
    {
      Log.e("MediaCodecUtil", "Codec warming failed", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecUtil
 * JD-Core Version:    0.7.0.1
 */