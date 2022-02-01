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
    String str = Build.MODEL;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNotSupportLoopVideo model=");
      localStringBuilder.append(str);
      QLog.d("LoginActivity.GuideVideoHandler", 2, localStringBuilder.toString());
    }
    if (str != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (str.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "handleError");
    }
    GuideVideoHandler.GuideVideoCallBack localGuideVideoCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler$GuideVideoCallBack;
    if (localGuideVideoCallBack != null) {
      localGuideVideoCallBack.a();
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if ((localObject != null) && (((TextureVideoView)localObject).isPlaying()))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_Int);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#pause# , mCurrentPosition = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("LoginActivity.GuideVideoHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @TargetApi(10)
  public void a(Context paramContext, MqqHandler paramMqqHandler, int paramInt)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("getVideoFrame isRetrieve=");
        paramContext.append(this.jdField_d_of_type_Boolean);
        QLog.d("LoginActivity.GuideVideoHandler", 2, paramContext.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MediaPlayer onCompletion has been called.   at ");
      localStringBuilder.append(paramIMediaPlayer.b());
      localStringBuilder.append(" mIsPause");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("LoginActivity.GuideVideoHandler", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      paramIMediaPlayer = new StringBuilder();
      paramIMediaPlayer.append("MediaPlayer onPrepared has been called. talkback=");
      paramIMediaPlayer.append(AppSetting.jdField_d_of_type_Boolean);
      paramIMediaPlayer.append(" videoPrepareTime=");
      paramIMediaPlayer.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.d("LoginActivity.GuideVideoHandler", 2, paramIMediaPlayer.toString());
    }
  }
  
  public boolean a_(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      if (QLog.isColorLevel())
      {
        paramIMediaPlayer = new StringBuilder();
        paramIMediaPlayer.append("onInfo what===>");
        paramIMediaPlayer.append(paramInt1);
        QLog.d("LoginActivity.GuideVideoHandler", 2, paramIMediaPlayer.toString());
      }
      if (a(f)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(103);
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("play has been called. pause :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" isStartVideo:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("LoginActivity.GuideVideoHandler", 2, ((StringBuilder)localObject).toString());
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
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.isPlaying()) && ((this.jdField_b_of_type_Int != this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition()) || (a(f))))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playing. mVideoViewPosition=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition());
        ((StringBuilder)localObject).append(" mPausePosition=");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        QLog.d("LoginActivity.GuideVideoHandler", 2, ((StringBuilder)localObject).toString());
      }
      if ((!a(f)) || (this.jdField_c_of_type_Boolean))
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(103);
        this.jdField_c_of_type_Boolean = false;
      }
    }
    else if (!this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidNetUri;
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoURI((Uri)localObject);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start to play. videoStarTime=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          QLog.d("LoginActivity.GuideVideoHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (localObject == null)
      {
        c();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "not playing.");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(102, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideVideoHandler
 * JD-Core Version:    0.7.0.1
 */