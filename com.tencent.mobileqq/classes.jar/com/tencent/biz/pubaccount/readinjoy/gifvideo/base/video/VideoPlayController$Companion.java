package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController$Companion;", "", "()V", "AUTO_PLAYMODE_ALLPLAY", "", "getAUTO_PLAYMODE_ALLPLAY", "()I", "setAUTO_PLAYMODE_ALLPLAY", "(I)V", "AUTO_PLAYMODE_WIFI_ONLY", "getAUTO_PLAYMODE_WIFI_ONLY", "setAUTO_PLAYMODE_WIFI_ONLY", "autoPlayMode", "getAutoPlayMode", "setAutoPlayMode", "autoPlay", "", "updatePlayConfig", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoPlayController$Companion
{
  public final int a()
  {
    return VideoPlayController.d();
  }
  
  public final void a()
  {
    ((Companion)this).a(Aladdin.getConfig(406).getIntegerFromString("play_config", ((Companion)this).a()));
    QLog.d("VideoPlayController", 1, "auto play mode: " + ((Companion)this).b());
  }
  
  public final void a(int paramInt)
  {
    VideoPlayController.e(paramInt);
  }
  
  public final boolean a()
  {
    if (((Companion)this).b() == ((Companion)this).a()) {
      return (NetworkUtil.b((Context)BaseApplication.getContext()) == 1) || (ReadInJoyHelper.d() == 1);
    }
    return true;
  }
  
  public final int b()
  {
    return VideoPlayController.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController.Companion
 * JD-Core Version:    0.7.0.1
 */