package com.tencent.av.ui.redbag;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import khf;
import khg;
import khh;
import khi;
import khj;

public class GuideTip2
  extends SubHandleBase
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener
{
  public Bitmap a;
  public ControlUIObserver a;
  GuideTip2.OnGuideTipListener a;
  public Bitmap b;
  
  public GuideTip2(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {
      return;
    }
    paramVideoAppInterface = paramVideoAppInterface.getApp().getSharedPreferences(paramVideoAppInterface.getCurrentAccountUin() + "qav_SP", 0).edit();
    paramVideoAppInterface.putBoolean("qav_UserGuide2_for_av_redbag", false);
    paramVideoAppInterface.commit();
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (AudioHelper.a(5) == 1) {
      return true;
    }
    return paramVideoAppInterface.getApp().getSharedPreferences(paramVideoAppInterface.getCurrentAccountUin() + "qav_SP", 0).getBoolean("qav_UserGuide2_for_av_redbag", true);
  }
  
  RelativeLayout a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAVActivity.findViewById(2131366240);
    if (localRelativeLayout != null) {
      paramAVActivity = localRelativeLayout;
    }
    for (;;)
    {
      return paramAVActivity;
      localRelativeLayout = (RelativeLayout)paramAVActivity.getLayoutInflater().inflate(2130969345, (RelativeLayout)paramAVActivity.findViewById(2131365828)).findViewById(2131366240);
      a(localRelativeLayout);
      b();
      localRelativeLayout.findViewById(2131366243).setOnClickListener(new khf(this));
      Object localObject = localRelativeLayout.findViewById(2131366244);
      if (this.b == null) {
        this.b = RedBagUtil.a("qav_redpacket_result_close.png", true);
      }
      if (this.b != null) {
        ((View)localObject).setBackgroundDrawable(TintStateDrawable.a(paramAVActivity.getResources(), this.b, 2131494077));
      }
      ((View)localObject).setOnClickListener(new khg(this));
      localObject = (VideoView)localRelativeLayout.findViewById(2131366241);
      String str = RedBagUtil.b() + "qav_redpacket_guide.mp4";
      ((VideoView)localObject).setVideoPath(str);
      ((VideoView)localObject).setZOrderOnTop(true);
      ((VideoView)localObject).setOnPreparedListener(this);
      ((VideoView)localObject).setOnErrorListener(this);
      ((VideoView)localObject).setZOrderMediaOverlay(true);
      ((VideoView)localObject).setOnInfoListener(this);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        paramAVActivity = new MediaMetadataRetriever();
      }
      try
      {
        paramAVActivity.setDataSource(str);
        this.jdField_a_of_type_AndroidGraphicsBitmap = paramAVActivity.getFrameAtTime(0L);
        paramAVActivity.release();
        paramAVActivity = localRelativeLayout;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          continue;
        }
        ((VideoView)localObject).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
        return localRelativeLayout;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.i, 2, "initDialog e = " + localException);
          }
        }
      }
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiControlUIObserver != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    }
  }
  
  void a(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setOnTouchListener(new khh(this));
  }
  
  public boolean a(GuideTip2.OnGuideTipListener paramOnGuideTipListener)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2$OnGuideTipListener = paramOnGuideTipListener;
    a(localAVActivity).setVisibility(0);
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    RedBagReport.j();
    return true;
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    a();
    Object localObject = a();
    if (localObject != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)localObject).findViewById(2131366240);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.setOnTouchListener(null);
        localObject = (RelativeLayout)((Activity)localObject).findViewById(2131365828);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          VideoView localVideoView = (VideoView)localRelativeLayout.findViewById(2131366241);
          if (localVideoView != null) {
            localVideoView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
          }
        }
        ((RelativeLayout)localObject).post(new khj(this, (RelativeLayout)localObject, localRelativeLayout));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2$OnGuideTipListener != null)
      {
        this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2$OnGuideTipListener.a(paramBoolean);
        this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2$OnGuideTipListener = null;
      }
      QLog.w(this.i, 1, "closeUI, bSend[" + paramBoolean + "], closeType[" + paramInt + "]");
      RedBagReport.b(paramBoolean, paramInt);
      return bool;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiControlUIObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = new khi(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.w(this.i, 1, "WL_DEBUG onError what = " + paramInt1 + ", extra = " + paramInt2);
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      paramMediaPlayer = a();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer = (VideoView)paramMediaPlayer.findViewById(2131366241);
        if (paramMediaPlayer != null) {
          paramMediaPlayer.setBackgroundDrawable(null);
        }
      }
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QLog.w(this.i, 1, "WL_DEBUG onPrepared");
    Object localObject = a();
    if (localObject != null)
    {
      localObject = (VideoView)((AVActivity)localObject).findViewById(2131366241);
      if (localObject != null)
      {
        ((VideoView)localObject).start();
        paramMediaPlayer.setLooping(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GuideTip2
 * JD-Core Version:    0.7.0.1
 */