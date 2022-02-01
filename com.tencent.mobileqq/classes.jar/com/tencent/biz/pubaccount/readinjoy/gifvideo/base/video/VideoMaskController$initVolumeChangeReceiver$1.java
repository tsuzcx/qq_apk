package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoMaskController$initVolumeChangeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoMaskController$initVolumeChangeReceiver$1
  extends BroadcastReceiver
{
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    boolean bool2 = true;
    if (paramContext != null)
    {
      String str = this.a.a();
      StringBuilder localStringBuilder = new StringBuilder().append("[onReceive], volume change, action = ");
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getAction();; paramIntent = null)
      {
        QLog.i(str, 1, paramIntent);
        paramIntent = ReadInJoyUtils.a();
        if (paramIntent != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
      if (RIJAppSetting.b((QQAppInterface)paramIntent)) {
        QLog.i(this.a.a(), 1, "[onReceive] app is in background, do not change volume.");
      }
    }
    else
    {
      return;
    }
    boolean bool3 = VideoAudioControlUtil.a.a(paramContext);
    if (bool3)
    {
      this.a.a().setImageResource(2130843215);
      label127:
      paramContext = VideoMaskController.a(this.a);
      if (bool3) {
        break label184;
      }
      bool1 = true;
      label142:
      paramContext.setMute(bool1);
      paramContext = VideoAudioControlUtil.a;
      if (bool3) {
        break label189;
      }
    }
    label184:
    label189:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.a(bool1, "ADJUST_VOLUME");
      break;
      this.a.a().setImageResource(2130843214);
      break label127;
      bool1 = false;
      break label142;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController.initVolumeChangeReceiver.1
 * JD-Core Version:    0.7.0.1
 */