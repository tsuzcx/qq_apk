package com.tencent.biz.pubaccount.readinjoy.gifvideo.utils;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/utils/VideoAudioControlUtil;", "", "()V", "SCENE_ADJUST_VOLUME", "", "SCENE_APP_BACKGROUND", "SCENE_BTN_CLICK", "SCENE_ENTER_DAILY_FEEDS", "SCENE_ENTER_KD_TAB", "SCENE_LEAVE_DAILY_FEEDS", "SCENE_LEAVE_KD_TAB", "TAG", "isMute", "", "isMuteConfig", "getMute", "getMuteConfig", "initConfig", "", "isVolumeLargeThanZero", "context", "Landroid/content/Context;", "setMute", "scene", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoAudioControlUtil
{
  public static final VideoAudioControlUtil a;
  private static boolean a;
  private static boolean b = true;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoUtilsVideoAudioControlUtil = new VideoAudioControlUtil();
    jdField_a_of_type_Boolean = true;
  }
  
  public final void a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(402);
    int i;
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("isMute", 1);
      if (i != 1) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      QLog.i("VideoAudioControlUtil", 1, "[initConfig] isMuteConfig = " + b);
      return;
      i = 1;
      break;
    }
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "scene");
    QLog.i("VideoAudioControlUtil", 1, "[setMute] scene = " + paramString + ", isMute = " + paramBoolean);
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    QLog.i("VideoAudioControlUtil", 1, "[getMuteConfig] isMuteConfig = " + b);
    return b;
  }
  
  public final boolean a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
    }
    int i = ((AudioManager)paramContext).getStreamVolume(3);
    QLog.i("VideoAudioControlUtil", 1, "[isVolumeNotZero], volume = " + i);
    return i > 0;
  }
  
  public final boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoAudioControlUtil
 * JD-Core Version:    0.7.0.1
 */