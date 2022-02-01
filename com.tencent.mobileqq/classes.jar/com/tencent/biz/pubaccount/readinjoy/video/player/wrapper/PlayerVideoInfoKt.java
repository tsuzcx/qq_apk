package com.tencent.biz.pubaccount.readinjoy.video.player.wrapper;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TVIDEO_TYPE_ONLINE_LIVE", "", "TVIDEO_TYPE_ONLINE_VOD", "VIDEO_LIVE_FORMAT_HLS", "VIDEO_LIVE_FORMAT_UNKNOWN", "VIDEO_TYPE_LOCAL_FILE_HLS", "VIDEO_TYPE_LOCAL_FILE_MP4", "VIDEO_TYPE_LOCAL_FILE_UNKNOW", "VIDEO_VOD_FORMAT_HLS", "VIDEO_VOD_FORMAT_MP4", "VIDEO_VOD_FORMAT_UNKNOWN", "generateSPVideoInfo", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "generateTVKUserInfo", "Lcom/tencent/qqlive/mediaplayer/api/TVK_UserInfo;", "generateTVKVideoInfo", "Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;", "transformFormatForSP", "transformPlayTypeForTVK", "transformSourceForSP", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class PlayerVideoInfoKt
{
  private static final int a(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
  {
    switch (paramPlayerVideoInfo.a())
    {
    default: 
      return 3;
    }
    return 1;
  }
  
  @NotNull
  public static final SuperPlayerVideoInfo a(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
  {
    int i = 1;
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramPlayerVideoInfo, "$this$generateSPVideoInfo");
    Object localObject1;
    if (a(paramPlayerVideoInfo) == 1)
    {
      localObject1 = paramPlayerVideoInfo.b();
      if (localObject1 != null)
      {
        i = j;
        if (((CharSequence)localObject1).length() > 0) {
          i = 1;
        }
        if (i != 1) {}
      }
      for (paramPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramPlayerVideoInfo.a(), paramPlayerVideoInfo.b());; paramPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramPlayerVideoInfo.a()))
      {
        Intrinsics.checkExpressionValueIsNotNull(paramPlayerVideoInfo, "if (pid?.isNotEmpty() ==…D_KANDIAN, vid)\n        }");
        return paramPlayerVideoInfo;
      }
    }
    j = b(paramPlayerVideoInfo);
    String str = (String)null;
    if (Aladdin.getConfig(392).getIntegerFromString("enable_p2p", 0) == 1)
    {
      localObject1 = str;
      if (i != 0)
      {
        localObject1 = paramPlayerVideoInfo.a();
        if (localObject1 == null) {
          break label316;
        }
        i = localObject1.length;
        label129:
        localObject1 = str;
        if (i > 0)
        {
          localObject1 = paramPlayerVideoInfo.a();
          if (localObject1 == null) {
            break label321;
          }
        }
      }
    }
    label316:
    label321:
    for (Object localObject2 = localObject1[0];; localObject2 = null)
    {
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (StringsKt.contains$default((CharSequence)localObject2, (CharSequence)"com/", false, 2, null))
        {
          localObject1 = str;
          if (StringsKt.contains$default((CharSequence)localObject2, (CharSequence)"?", false, 2, null))
          {
            localObject1 = localObject2.substring(StringsKt.indexOf$default((CharSequence)localObject2, "com/", 0, false, 6, null) + 4, StringsKt.indexOf$default((CharSequence)localObject2, "?", 0, false, 6, null));
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PlayerVideoInfo", 2, "generateSPVideoInfo: vid=" + paramPlayerVideoInfo.a() + ", fileId=" + (String)localObject1);
      }
      paramPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(paramPlayerVideoInfo.a(), j, paramPlayerVideoInfo.a(), (String)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(paramPlayerVideoInfo, "SuperPlayerFactory.creat…format, duration, fileId)");
      return paramPlayerVideoInfo;
      i = 0;
      break;
      i = 0;
      break label129;
    }
  }
  
  private static final int b(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
  {
    switch (paramPlayerVideoInfo.a())
    {
    default: 
      return 103;
    case 3: 
    case 101: 
      return 101;
    case 4: 
    case 102: 
      return 102;
    case 5: 
    case 103: 
      return 104;
    case 104: 
      return 201;
    }
    return 203;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerVideoInfoKt
 * JD-Core Version:    0.7.0.1
 */