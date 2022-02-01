package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
    if (Util.SDK_INT < 26)
    {
      int j = paramList.size();
      int i = 1;
      if ((j > 1) && ("OMX.MTK.AUDIO.DECODER.RAW".equals(((MediaCodecInfo)paramList.get(0)).name))) {
        while (i < paramList.size())
        {
          MediaCodecInfo localMediaCodecInfo = (MediaCodecInfo)paramList.get(i);
          if ("OMX.google.raw.decoder".equals(localMediaCodecInfo.name))
          {
            paramList.remove(i);
            paramList.add(0, localMediaCodecInfo);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  private static int avcLevelToMaxFrameSize(int paramInt)
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
  
  private static boolean codecNeedsDisableAdaptationWorkaround(String paramString)
  {
    return (Util.SDK_INT <= 22) && ((Util.MODEL.equals("ODROID-XU3")) || (Util.MODEL.equals("Nexus 10"))) && (("OMX.Exynos.AVC.Decoder".equals(paramString)) || ("OMX.Exynos.AVC.Decoder.secure".equals(paramString)));
  }
  
  private static Pair<Integer, Integer> getAvcProfileAndLevel(String paramString, String[] paramArrayOfString)
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
          break label234;
        }
        localInteger = Integer.valueOf(Integer.parseInt(paramArrayOfString[1]));
        paramArrayOfString = Integer.valueOf(Integer.parseInt(paramArrayOfString[2]));
        paramString = paramArrayOfString;
        paramArrayOfString = localInteger;
      }
      Integer localInteger = Integer.valueOf(AVC_PROFILE_NUMBER_TO_CONST.get(paramArrayOfString.intValue()));
      if (localInteger == null)
      {
        paramString = new StringBuilder();
        paramString.append("Unknown AVC profile: ");
        paramString.append(paramArrayOfString);
        Log.w("MediaCodecUtil", paramString.toString());
        return null;
      }
      paramArrayOfString = Integer.valueOf(AVC_LEVEL_NUMBER_TO_CONST.get(paramString.intValue()));
      if (paramArrayOfString == null)
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Unknown AVC level: ");
        paramArrayOfString.append(paramString);
        Log.w("MediaCodecUtil", paramArrayOfString.toString());
        return null;
      }
      return new Pair(localInteger, paramArrayOfString);
      label234:
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("Ignoring malformed AVC codec string: ");
      paramArrayOfString.append(paramString);
      Log.w("MediaCodecUtil", paramArrayOfString.toString());
      return null;
    }
    catch (NumberFormatException paramArrayOfString)
    {
      label267:
      break label267;
    }
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("Ignoring malformed AVC codec string: ");
    paramArrayOfString.append(paramString);
    Log.w("MediaCodecUtil", paramArrayOfString.toString());
    return null;
  }
  
  public static Pair<Integer, Integer> getCodecProfileAndLevel(String paramString)
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
      return getAvcProfileAndLevel(paramString, arrayOfString);
    }
    return getHevcProfileAndLevel(paramString, arrayOfString);
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
    try
    {
      MediaCodecUtil.CodecKey localCodecKey = new MediaCodecUtil.CodecKey(paramString, paramBoolean1);
      Object localObject1 = (List)decoderInfosCache.get(localCodecKey);
      if (localObject1 != null) {
        return localObject1;
      }
      if (Util.SDK_INT >= 21) {
        localObject1 = new MediaCodecUtil.MediaCodecListCompatV21(paramBoolean1);
      } else {
        localObject1 = new MediaCodecUtil.MediaCodecListCompatV16(null);
      }
      ArrayList localArrayList2 = getDecoderInfosInternal(localCodecKey, (MediaCodecUtil.MediaCodecListCompat)localObject1, paramString);
      Object localObject2 = localObject1;
      ArrayList localArrayList1 = localArrayList2;
      if (paramBoolean1)
      {
        localObject2 = localObject1;
        localArrayList1 = localArrayList2;
        if (localArrayList2.isEmpty())
        {
          localObject2 = localObject1;
          localArrayList1 = localArrayList2;
          if (21 <= Util.SDK_INT)
          {
            localObject2 = localObject1;
            localArrayList1 = localArrayList2;
            if (Util.SDK_INT <= 23)
            {
              localObject1 = new MediaCodecUtil.MediaCodecListCompatV16(null);
              localArrayList2 = getDecoderInfosInternal(localCodecKey, (MediaCodecUtil.MediaCodecListCompat)localObject1, paramString);
              localObject2 = localObject1;
              localArrayList1 = localArrayList2;
              if (!localArrayList2.isEmpty())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("MediaCodecList API didn't list secure decoder for: ");
                ((StringBuilder)localObject2).append(paramString);
                ((StringBuilder)localObject2).append(". Assuming: ");
                ((StringBuilder)localObject2).append(((MediaCodecInfo)localArrayList2.get(0)).name);
                Log.w("MediaCodecUtil", ((StringBuilder)localObject2).toString());
                localArrayList1 = localArrayList2;
                localObject2 = localObject1;
              }
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
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  private static ArrayList<MediaCodecInfo> getDecoderInfosInternal(MediaCodecUtil.CodecKey paramCodecKey, MediaCodecUtil.MediaCodecListCompat paramMediaCodecListCompat, String paramString)
  {
    // Byte code:
    //   0: new 337	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 370	java/util/ArrayList:<init>	()V
    //   7: astore 13
    //   9: aload_0
    //   10: getfield 373	com/google/android/exoplayer2/mediacodec/MediaCodecUtil$CodecKey:mimeType	Ljava/lang/String;
    //   13: astore 14
    //   15: aload_1
    //   16: invokeinterface 378 1 0
    //   21: istore_3
    //   22: aload_1
    //   23: invokeinterface 381 1 0
    //   28: istore 8
    //   30: iconst_0
    //   31: istore 5
    //   33: iload 5
    //   35: iload_3
    //   36: if_icmpge +374 -> 410
    //   39: aload_1
    //   40: iload 5
    //   42: invokeinterface 385 2 0
    //   47: astore 15
    //   49: aload 15
    //   51: invokevirtual 390	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   54: astore 12
    //   56: iload_3
    //   57: istore 4
    //   59: aload 15
    //   61: aload 12
    //   63: iload 8
    //   65: aload_2
    //   66: invokestatic 394	com/google/android/exoplayer2/mediacodec/MediaCodecUtil:isCodecUsableDecoder	(Landroid/media/MediaCodecInfo;Ljava/lang/String;ZLjava/lang/String;)Z
    //   69: ifeq +329 -> 398
    //   72: aload 15
    //   74: invokevirtual 398	android/media/MediaCodecInfo:getSupportedTypes	()[Ljava/lang/String;
    //   77: astore 16
    //   79: aload 16
    //   81: arraylength
    //   82: istore 7
    //   84: iconst_0
    //   85: istore 6
    //   87: iload_3
    //   88: istore 4
    //   90: iload 6
    //   92: iload 7
    //   94: if_icmpge +304 -> 398
    //   97: aload 16
    //   99: iload 6
    //   101: aaload
    //   102: astore 17
    //   104: aload 17
    //   106: aload 14
    //   108: invokevirtual 401	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   111: istore 9
    //   113: iload 9
    //   115: ifeq +274 -> 389
    //   118: aload 15
    //   120: aload 17
    //   122: invokevirtual 405	android/media/MediaCodecInfo:getCapabilitiesForType	(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    //   125: astore 11
    //   127: aload_1
    //   128: aload 14
    //   130: aload 11
    //   132: invokeinterface 409 3 0
    //   137: istore 9
    //   139: aload 12
    //   141: invokestatic 411	com/google/android/exoplayer2/mediacodec/MediaCodecUtil:codecNeedsDisableAdaptationWorkaround	(Ljava/lang/String;)Z
    //   144: istore 10
    //   146: iload 8
    //   148: ifeq +292 -> 440
    //   151: aload_0
    //   152: getfield 351	com/google/android/exoplayer2/mediacodec/MediaCodecUtil$CodecKey:secure	Z
    //   155: iload 9
    //   157: if_icmpeq +275 -> 432
    //   160: goto +3 -> 163
    //   163: iload 8
    //   165: ifne +34 -> 199
    //   168: aload_0
    //   169: getfield 351	com/google/android/exoplayer2/mediacodec/MediaCodecUtil$CodecKey:secure	Z
    //   172: ifne +27 -> 199
    //   175: goto +257 -> 432
    //   178: aload 13
    //   180: aload 12
    //   182: aload 14
    //   184: aload 11
    //   186: iload 10
    //   188: iconst_0
    //   189: invokestatic 415	com/google/android/exoplayer2/mediacodec/MediaCodecInfo:newInstance	(Ljava/lang/String;Ljava/lang/String;Landroid/media/MediaCodecInfo$CodecCapabilities;ZZ)Lcom/google/android/exoplayer2/mediacodec/MediaCodecInfo;
    //   192: invokevirtual 417	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   195: pop
    //   196: goto +193 -> 389
    //   199: iload 8
    //   201: ifne +188 -> 389
    //   204: iload 9
    //   206: ifeq +183 -> 389
    //   209: new 232	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   216: astore 18
    //   218: aload 18
    //   220: aload 12
    //   222: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 18
    //   228: ldc_w 419
    //   231: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 13
    //   237: aload 18
    //   239: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: aload 14
    //   244: aload 11
    //   246: iload 10
    //   248: iconst_1
    //   249: invokestatic 415	com/google/android/exoplayer2/mediacodec/MediaCodecInfo:newInstance	(Ljava/lang/String;Ljava/lang/String;Landroid/media/MediaCodecInfo$CodecCapabilities;ZZ)Lcom/google/android/exoplayer2/mediacodec/MediaCodecInfo;
    //   252: invokevirtual 417	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: aload 13
    //   258: areturn
    //   259: astore 11
    //   261: getstatic 194	com/google/android/exoplayer2/util/Util:SDK_INT	I
    //   264: istore 4
    //   266: iload 4
    //   268: bipush 23
    //   270: if_icmpgt +60 -> 330
    //   273: aload 13
    //   275: invokevirtual 338	java/util/ArrayList:isEmpty	()Z
    //   278: ifne +52 -> 330
    //   281: new 232	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   288: astore 11
    //   290: aload 11
    //   292: ldc_w 421
    //   295: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 11
    //   301: aload 12
    //   303: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 11
    //   309: ldc_w 423
    //   312: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: ldc 41
    //   318: aload 11
    //   320: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 426	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   326: pop
    //   327: goto +62 -> 389
    //   330: new 232	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   337: astore_0
    //   338: aload_0
    //   339: ldc_w 428
    //   342: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_0
    //   347: aload 12
    //   349: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_0
    //   354: ldc_w 430
    //   357: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload_0
    //   362: aload 17
    //   364: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload_0
    //   369: ldc_w 432
    //   372: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: ldc 41
    //   378: aload_0
    //   379: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 426	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   385: pop
    //   386: aload 11
    //   388: athrow
    //   389: iload 6
    //   391: iconst_1
    //   392: iadd
    //   393: istore 6
    //   395: goto -308 -> 87
    //   398: iload 5
    //   400: iconst_1
    //   401: iadd
    //   402: istore 5
    //   404: iload 4
    //   406: istore_3
    //   407: goto -374 -> 33
    //   410: aload 13
    //   412: areturn
    //   413: astore_0
    //   414: new 434	com/google/android/exoplayer2/mediacodec/MediaCodecUtil$DecoderQueryException
    //   417: dup
    //   418: aload_0
    //   419: aconst_null
    //   420: invokespecial 437	com/google/android/exoplayer2/mediacodec/MediaCodecUtil$DecoderQueryException:<init>	(Ljava/lang/Throwable;Lcom/google/android/exoplayer2/mediacodec/MediaCodecUtil$1;)V
    //   423: astore_0
    //   424: goto +5 -> 429
    //   427: aload_0
    //   428: athrow
    //   429: goto -2 -> 427
    //   432: goto -254 -> 178
    //   435: astore 11
    //   437: goto -176 -> 261
    //   440: goto -277 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	paramCodecKey	MediaCodecUtil.CodecKey
    //   0	443	1	paramMediaCodecListCompat	MediaCodecUtil.MediaCodecListCompat
    //   0	443	2	paramString	String
    //   21	386	3	i	int
    //   57	348	4	j	int
    //   31	372	5	k	int
    //   85	309	6	m	int
    //   82	13	7	n	int
    //   28	172	8	bool1	boolean
    //   111	94	9	bool2	boolean
    //   144	103	10	bool3	boolean
    //   125	120	11	localCodecCapabilities	android.media.MediaCodecInfo.CodecCapabilities
    //   259	1	11	localException1	java.lang.Exception
    //   288	99	11	localStringBuilder1	StringBuilder
    //   435	1	11	localException2	java.lang.Exception
    //   54	294	12	str1	String
    //   7	404	13	localArrayList	ArrayList
    //   13	230	14	str2	String
    //   47	72	15	localMediaCodecInfo	android.media.MediaCodecInfo
    //   77	21	16	arrayOfString	String[]
    //   102	261	17	str3	String
    //   216	22	18	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   118	146	259	java/lang/Exception
    //   0	30	413	java/lang/Exception
    //   39	56	413	java/lang/Exception
    //   59	84	413	java/lang/Exception
    //   104	113	413	java/lang/Exception
    //   261	266	413	java/lang/Exception
    //   273	327	413	java/lang/Exception
    //   330	389	413	java/lang/Exception
    //   151	160	435	java/lang/Exception
    //   168	175	435	java/lang/Exception
    //   178	196	435	java/lang/Exception
    //   209	256	435	java/lang/Exception
  }
  
  private static Pair<Integer, Integer> getHevcProfileAndLevel(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 4)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("Ignoring malformed HEVC codec string: ");
      paramArrayOfString.append(paramString);
      Log.w("MediaCodecUtil", paramArrayOfString.toString());
      return null;
    }
    Matcher localMatcher = PROFILE_PATTERN.matcher(paramArrayOfString[1]);
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
        break label194;
      }
      i = 2;
    }
    paramString = (Integer)HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(paramArrayOfString[3]);
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("Unknown HEVC level string: ");
      paramString.append(localMatcher.group(1));
      Log.w("MediaCodecUtil", paramString.toString());
      return null;
    }
    return new Pair(Integer.valueOf(i), paramString);
    label194:
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("Unknown HEVC profile string: ");
    paramArrayOfString.append(paramString);
    Log.w("MediaCodecUtil", paramArrayOfString.toString());
    return null;
  }
  
  public static MediaCodecInfo getPassthroughDecoderInfo()
  {
    return PASSTHROUGH_DECODER_INFO;
  }
  
  private static boolean isCodecUsableDecoder(android.media.MediaCodecInfo paramMediaCodecInfo, String paramString1, boolean paramBoolean, String paramString2)
  {
    if (!paramMediaCodecInfo.isEncoder())
    {
      if ((!paramBoolean) && (paramString1.endsWith(".secure"))) {
        return false;
      }
      if ((Util.SDK_INT < 21) && (("CIPAACDecoder".equals(paramString1)) || ("CIPMP3Decoder".equals(paramString1)) || ("CIPVorbisDecoder".equals(paramString1)) || ("CIPAMRNBDecoder".equals(paramString1)) || ("AACDecoder".equals(paramString1)) || ("MP3Decoder".equals(paramString1)))) {
        return false;
      }
      if ((Util.SDK_INT < 18) && ("OMX.SEC.MP3.Decoder".equals(paramString1))) {
        return false;
      }
      if ((Util.SDK_INT < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(paramString1)) && (("a70".equals(Util.DEVICE)) || (("Xiaomi".equals(Util.MANUFACTURER)) && (Util.DEVICE.startsWith("HM"))))) {
        return false;
      }
      if ((Util.SDK_INT == 16) && ("OMX.qcom.audio.decoder.mp3".equals(paramString1)) && (("dlxu".equals(Util.DEVICE)) || ("protou".equals(Util.DEVICE)) || ("ville".equals(Util.DEVICE)) || ("villeplus".equals(Util.DEVICE)) || ("villec2".equals(Util.DEVICE)) || (Util.DEVICE.startsWith("gee")) || ("C6602".equals(Util.DEVICE)) || ("C6603".equals(Util.DEVICE)) || ("C6606".equals(Util.DEVICE)) || ("C6616".equals(Util.DEVICE)) || ("L36h".equals(Util.DEVICE)) || ("SO-02E".equals(Util.DEVICE)))) {
        return false;
      }
      if ((Util.SDK_INT == 16) && ("OMX.qcom.audio.decoder.aac".equals(paramString1)) && (("C1504".equals(Util.DEVICE)) || ("C1505".equals(Util.DEVICE)) || ("C1604".equals(Util.DEVICE)) || ("C1605".equals(Util.DEVICE)))) {
        return false;
      }
      if ((Util.SDK_INT < 24) && (("OMX.SEC.aac.dec".equals(paramString1)) || ("OMX.Exynos.AAC.Decoder".equals(paramString1))) && (Util.MANUFACTURER.equals("samsung")) && ((Util.DEVICE.startsWith("zeroflte")) || (Util.DEVICE.startsWith("zerolte")) || (Util.DEVICE.startsWith("zenlte")) || (Util.DEVICE.equals("SC-05G")) || (Util.DEVICE.equals("marinelteatt")) || (Util.DEVICE.equals("404SC")) || (Util.DEVICE.equals("SC-04G")) || (Util.DEVICE.equals("SCV31")))) {
        return false;
      }
      if ((Util.SDK_INT <= 19) && ("OMX.SEC.vp8.dec".equals(paramString1)) && ("samsung".equals(Util.MANUFACTURER)) && ((Util.DEVICE.startsWith("d2")) || (Util.DEVICE.startsWith("serrano")) || (Util.DEVICE.startsWith("jflte")) || (Util.DEVICE.startsWith("santos")) || (Util.DEVICE.startsWith("t0")))) {
        return false;
      }
      if ((Util.SDK_INT <= 19) && (Util.DEVICE.startsWith("jflte")) && ("OMX.qcom.video.decoder.vp8".equals(paramString1))) {
        return false;
      }
      return (!"audio/eac3-joc".equals(paramString2)) || (!"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(paramString1));
    }
    return false;
  }
  
  private static boolean isSoftwareCodec(String paramString)
  {
    return (paramString.toLowerCase().startsWith("omx.google.")) || (!paramString.toLowerCase().startsWith("omx."));
  }
  
  public static int maxH264DecodableFrameSize()
  {
    if (maxH264DecodableFrameSize == -1)
    {
      int i = 0;
      int j = 0;
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
        if (Util.SDK_INT >= 21) {
          j = 345600;
        } else {
          j = 172800;
        }
        i = Math.max(i, j);
      }
      maxH264DecodableFrameSize = i;
    }
    return maxH264DecodableFrameSize;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecUtil
 * JD-Core Version:    0.7.0.1
 */