package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import agva;
import agvb;
import agvc;
import agvd;
import agve;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import awnv;
import babp;
import befq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;
import java.util.Map;

public class SpringHbVideoView
  extends RelativeLayout
  implements Handler.Callback
{
  private agve jdField_a_of_type_Agve;
  private View jdField_a_of_type_AndroidViewView;
  private befq jdField_a_of_type_Befq;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public SpringHbVideoView(Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public SpringHbVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  private void h()
  {
    this.jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
    Context localContext = getContext();
    awnv.b(BaseApplicationImpl.getContext());
    TVK_SDKMgr.setDebugEnable(true);
    if (TVK_SDKMgr.isInstalled(localContext))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (localTVK_IProxyFactory != null)
      {
        this.jdField_a_of_type_AndroidViewView = ((View)localTVK_IProxyFactory.createVideoView_Scroll(localContext));
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
          this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
          localLayoutParams.addRule(13, -1);
          this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_a_of_type_AndroidViewView.setTag("video");
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = localTVK_IProxyFactory.createMediaPlayer(localContext, (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
            break label258;
          }
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
          setFitView(false);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new agva(this));
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new agvb(this));
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new agvc(this));
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new agvd(this));
          super.addView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringHbVideoView", 2, "initVideoView end");
      }
      return;
      label258:
      QLog.e("springHb_SpringHbVideoView", 1, "videoFactory.createMediaPlayer error");
      break;
      QLog.e("springHb_SpringHbVideoView", 1, "TVK_SDKMgr.isInstalled:false");
    }
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      l = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbVideoView", 2, "getDuration:" + l);
    }
    return l;
  }
  
  public TVK_IMediaPlayer a()
  {
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.e("springHb_SpringHbVideoView", 1, "start but mPlayerPrepared is false");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbVideoView", 2, "start");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
    }
    this.jdField_a_of_type_Befq.removeMessages(100);
    this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(100, 150L);
  }
  
  public long b()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      l = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbVideoView", 2, "getCurrentPosition:" + l);
    }
    return l;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Befq.post(new SpringHbVideoView.8(this));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Befq.post(new SpringHbVideoView.9(this));
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbVideoView", 2, "resumeVideo");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbVideoView", 2, "pauseVideo");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbVideoView", 2, "stopVideo");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
  }
  
  public void g()
  {
    QLog.i("springHb_SpringHbVideoView", 1, "onDestroy");
    ThreadManagerV2.excute(new SpringHbVideoView.10(this), 16, null, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.c);
      }
    }
  }
  
  public void setDataByLocalPath(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbVideoView", 2, new Object[] { "setData videoLocalPath:", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      this.b = paramBoolean1;
    } while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()));
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_spring_festival_hb");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.setPlayType(4);
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    ThreadManagerV2.excute(new SpringHbVideoView.6(this, paramString, localTVK_PlayerVideoInfo), 16, null, true);
  }
  
  public void setDataByOnLineUrl(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbVideoView", 2, new Object[] { "setDataByOnLineUrl url:", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.b = paramBoolean1;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
    } while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()));
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "shouq_fudai_video");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.setPlayType(2);
    if (paramLong1 > 0L) {
      localTVK_PlayerVideoInfo.setConfigMap("filesize", String.valueOf(paramLong1));
    }
    if (paramLong2 > 0L) {
      localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramLong2));
    }
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    ThreadManagerV2.excute(new SpringHbVideoView.7(this, paramString), 16, null, true);
  }
  
  public void setFitView(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(1);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(0);
  }
  
  public void setFullScreenVideoXYMode(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (1.777778F > ((float)babp.j() + 0.0F) / (float)babp.i()) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(4);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(3);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void setVideoListener(agve paramagve)
  {
    this.jdField_a_of_type_Agve = paramagve;
  }
  
  public void setVideoViewBlackColor(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView
 * JD-Core Version:    0.7.0.1
 */