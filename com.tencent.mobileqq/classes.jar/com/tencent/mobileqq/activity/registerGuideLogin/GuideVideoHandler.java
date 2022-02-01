package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnCompletionListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class GuideVideoHandler
  implements IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPreparedListener
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "N1T", "ZTE A2015", "MI 1S", "GT-S7568I", "ZTE N909" };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "SM-A7000", "HM NOTE 1S", "MI 2S" };
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString = { "vivo X6D" };
  private static final String[] jdField_d_of_type_ArrayOfJavaLangString = { "MI 4" };
  private static final String[] e = { "Nexus 5" };
  private static final String[] f = { "Nexus 5" };
  private static final String[] g = { "OPPO R7sm" };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Uri jdField_a_of_type_AndroidNetUri;
  private TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  private GuideVideoHandler.GuideVideoCallBack jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler$GuideVideoCallBack;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private volatile boolean jdField_d_of_type_Boolean;
  
  public static boolean a(String[] paramArrayOfString)
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "isNotSupportLoopVideo model=" + str);
    }
    boolean bool1 = bool2;
    int j;
    int i;
    if (str != null)
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (str.equals(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "handleError");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler$GuideVideoCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler$GuideVideoCallBack.a();
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.isPlaying()))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "#pause# , mCurrentPosition = " + this.jdField_a_of_type_Int);
    }
  }
  
  @TargetApi(10)
  public void a(Context paramContext, MqqHandler paramMqqHandler, int paramInt)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "getVideoFrame isRetrieve=" + this.jdField_d_of_type_Boolean);
      }
      return;
    }
    if (Build.VERSION.SDK_INT < 10)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD_MR1");
      }
      paramMqqHandler.sendEmptyMessage(101);
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    ThreadManager.postImmediately(new GuideVideoHandler.2(this, paramContext, paramInt, paramMqqHandler), null, false);
  }
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "MediaPlayer onCompletion has been called.   at " + paramIMediaPlayer.b() + " mIsPause" + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_Int = paramIMediaPlayer.b();
    if (!this.jdField_a_of_type_Boolean)
    {
      paramIMediaPlayer.c();
      paramIMediaPlayer.a(true);
    }
    if ((a(jdField_c_of_type_ArrayOfJavaLangString)) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoURI(this.jdField_a_of_type_AndroidNetUri);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
    }
  }
  
  public boolean a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    paramIMediaPlayer = new StringBuilder(64);
    paramIMediaPlayer.append("bgVideo error-- what=");
    paramIMediaPlayer.append(paramInt1);
    paramIMediaPlayer.append(" extra=");
    paramIMediaPlayer.append(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, paramIMediaPlayer.toString());
    }
    c();
    paramIMediaPlayer = Build.MODEL;
    if (paramIMediaPlayer != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("crashModel", paramIMediaPlayer);
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()).collectPerformance(null, "newHandGuide_error", true, 0L, 0L, localHashMap, "", false);
    }
    return true;
  }
  
  public void a_(IMediaPlayer paramIMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.setTalkbackSwitch();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "MediaPlayer onPrepared has been called. talkback=" + AppSetting.jdField_d_of_type_Boolean + " videoPrepareTime=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
  }
  
  public boolean a_(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "onInfo what===>" + paramInt1);
      }
      if (a(f)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(103);
      }
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "play has been called. pause :" + this.jdField_a_of_type_Boolean + " isStartVideo:" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.seekTo(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "resume play.");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(102, 100L);
    }
    label315:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.isPlaying()) || ((this.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition()) && (!a(f)))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("LoginActivity.GuideVideoHandler", 2, "playing. mVideoViewPosition=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition() + " mPausePosition=" + this.jdField_b_of_type_Int);
            }
          } while ((a(f)) && (!this.jdField_c_of_type_Boolean));
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(103);
          this.jdField_c_of_type_Boolean = false;
          return;
          if (this.jdField_b_of_type_Boolean) {
            break label315;
          }
          if (this.jdField_a_of_type_AndroidNetUri == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoURI(this.jdField_a_of_type_AndroidNetUri);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        } while (!QLog.isColorLevel());
        QLog.d("LoginActivity.GuideVideoHandler", 2, "start to play. videoStarTime=" + this.jdField_a_of_type_Long);
        return;
      } while (this.jdField_a_of_type_AndroidNetUri != null);
      c();
      return;
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "not playing.");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(102, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideVideoHandler
 * JD-Core Version:    0.7.0.1
 */