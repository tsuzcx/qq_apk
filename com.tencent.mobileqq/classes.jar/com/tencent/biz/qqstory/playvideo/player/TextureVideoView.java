package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnCompletionListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.onTextureUpdateListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.MediaPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.IOException;
import java.util.Map;

@TargetApi(14)
public class TextureVideoView
  extends TextureView
  implements TextureView.SurfaceTextureListener, MediaController.MediaPlayerControl
{
  protected int a;
  protected Uri a;
  protected Surface a;
  protected MediaController a;
  private IMediaPlayer.OnBufferingUpdateListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnBufferingUpdateListener = new TextureVideoView.6(this);
  protected IMediaPlayer.OnCompletionListener a;
  protected IMediaPlayer.OnErrorListener a;
  protected IMediaPlayer.OnInfoListener a;
  protected IMediaPlayer.OnPreparedListener a;
  protected IMediaPlayer.OnSeekCompleteListener a;
  IMediaPlayer.OnVideoSizeChangedListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnVideoSizeChangedListener = new TextureVideoView.1(this);
  protected IMediaPlayer.onTextureUpdateListener a;
  protected IMediaPlayer a;
  protected String a;
  protected Map<String, String> a;
  protected int b;
  private IMediaPlayer.OnCompletionListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener = new TextureVideoView.3(this);
  private IMediaPlayer.OnErrorListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener = new TextureVideoView.5(this);
  private IMediaPlayer.OnInfoListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnInfoListener = new TextureVideoView.4(this);
  IMediaPlayer.OnPreparedListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener = new TextureVideoView.2(this);
  protected boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  protected boolean d;
  protected int e;
  protected boolean e;
  protected int f;
  public boolean f;
  protected int g;
  protected boolean g;
  
  public TextureVideoView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.player.TextureVideoView";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer = null;
    this.jdField_g_of_type_Boolean = false;
    b();
  }
  
  private Activity a()
  {
    try
    {
      for (Context localContext = getContext(); (localContext instanceof ContextWrapper); localContext = ((ContextWrapper)localContext).getBaseContext()) {
        if ((localContext instanceof Activity)) {
          return (Activity)localContext;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidNetUri != null)
    {
      if (this.jdField_a_of_type_AndroidViewSurface == null) {
        return;
      }
      b(false);
      String str;
      StringBuilder localStringBuilder;
      if (paramBoolean) {
        try
        {
          ((AudioManager)super.getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            str = this.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("requestAudioFocus Exception: ");
            localStringBuilder.append(QLog.getStackTraceString(localException));
            QLog.w(str, 2, localStringBuilder.toString());
          }
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer = a();
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(this.jdField_e_of_type_Boolean);
        if (this.jdField_c_of_type_Int != 0) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.b(this.jdField_c_of_type_Int);
        } else {
          this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.e();
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnVideoSizeChangedListener);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnInfoListener);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnBufferingUpdateListener);
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener);
        }
        this.jdField_f_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(getContext().getApplicationContext(), this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaUtilMap);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(this.jdField_a_of_type_AndroidViewSurface);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.c(3);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.b(true);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.b();
        this.jdField_a_of_type_Int = 1;
        d();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "prepareAsync cause  IllegalStateException", localIllegalStateException);
        }
        this.jdField_a_of_type_Int = -1;
        this.jdField_b_of_type_Int = -1;
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer, 1, 0);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel())
        {
          str = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unable to open content: ");
          localStringBuilder.append(this.jdField_a_of_type_AndroidNetUri);
          QLog.w(str, 2, localStringBuilder.toString(), localIllegalArgumentException);
        }
        this.jdField_a_of_type_Int = -1;
        this.jdField_b_of_type_Int = -1;
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer, 1, 0);
        return;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel())
        {
          str = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unable to open content: ");
          localStringBuilder.append(this.jdField_a_of_type_AndroidNetUri);
          QLog.w(str, 2, localStringBuilder.toString(), localIOException);
        }
        this.jdField_a_of_type_Int = -1;
        this.jdField_b_of_type_Int = -1;
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer, 1, 0);
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null)
    {
      int i = this.jdField_a_of_type_Int;
      if ((i != -1) && (i != 0) && (i != 1)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    super.setSurfaceTextureListener(this);
    super.setFocusable(true);
    super.setFocusableInTouchMode(true);
    super.requestFocus();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  private void b(boolean paramBoolean)
  {
    IMediaPlayer localIMediaPlayer = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer;
    if (localIMediaPlayer != null)
    {
      localIMediaPlayer.e();
      try
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.g();
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.f();
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        IllegalStateException localIllegalStateException2 = new IllegalStateException("CatchedException, caused by: ", localIllegalStateException1);
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mMediaPlayer.release() throw a exception!!", localIllegalStateException2);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer = null;
      this.jdField_a_of_type_Int = 0;
      if (paramBoolean) {
        this.jdField_b_of_type_Int = 0;
      }
      ((AudioManager)super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void c()
  {
    a(this.jdField_f_of_type_Boolean ^ true);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetMediaController;
      if (localObject != null)
      {
        ((MediaController)localObject).setMediaPlayer(this);
        if ((getParent() instanceof View)) {
          localObject = (View)getParent();
        } else {
          localObject = this;
        }
        this.jdField_a_of_type_AndroidWidgetMediaController.setAnchorView((View)localObject);
        this.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(a());
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetMediaController.isShowing())
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetMediaController.show();
  }
  
  protected IMediaPlayer a()
  {
    return new MediaPlayerWrapper();
  }
  
  public void a()
  {
    IMediaPlayer localIMediaPlayer = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer;
    if (localIMediaPlayer != null)
    {
      localIMediaPlayer.e();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.f();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer = null;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      ((AudioManager)super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  public boolean canPause()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean canSeekBackward()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean canSeekForward()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int getAudioSessionId()
  {
    if (this.jdField_c_of_type_Int == 0)
    {
      ReportMediaPlayer localReportMediaPlayer = new ReportMediaPlayer();
      this.jdField_c_of_type_Int = localReportMediaPlayer.getAudioSessionId();
      localReportMediaPlayer.release();
    }
    return this.jdField_c_of_type_Int;
  }
  
  public int getBufferPercentage()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null) {
      return this.jdField_f_of_type_Int;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.b();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (a()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a());
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TextureVideoView.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i;
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 164) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((a()) && (i != 0) && (this.jdField_a_of_type_AndroidWidgetMediaController != null)) {
      if ((paramInt != 79) && (paramInt != 85))
      {
        if (paramInt == 126)
        {
          if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a())
          {
            start();
            this.jdField_a_of_type_AndroidWidgetMediaController.hide();
          }
          return true;
        }
        if ((paramInt != 86) && (paramInt != 127))
        {
          e();
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a())
          {
            pause();
            this.jdField_a_of_type_AndroidWidgetMediaController.show();
          }
          return true;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a())
        {
          pause();
          this.jdField_a_of_type_AndroidWidgetMediaController.show();
          return true;
        }
        start();
        this.jdField_a_of_type_AndroidWidgetMediaController.hide();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = TextureView.getDefaultSize(this.jdField_d_of_type_Int, paramInt1);
    int m = TextureView.getDefaultSize(this.jdField_e_of_type_Int, paramInt2);
    int j = k;
    int i = m;
    if (this.jdField_d_of_type_Int > 0)
    {
      j = k;
      i = m;
      if (this.jdField_e_of_type_Int > 0)
      {
        k = View.MeasureSpec.getMode(paramInt1);
        i = View.MeasureSpec.getSize(paramInt1);
        m = View.MeasureSpec.getMode(paramInt2);
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
        if ((k == 1073741824) && (m == 1073741824))
        {
          j = this.jdField_d_of_type_Int;
          k = this.jdField_e_of_type_Int;
          if (j * paramInt1 < i * k) {
            if (!this.jdField_g_of_type_Boolean) {}
          }
          for (j = j * paramInt1 / k;; j = j * paramInt1 / k)
          {
            i = paramInt1;
            break label343;
            paramInt1 = k * i / j;
            paramInt2 = i;
            break;
            paramInt2 = i;
            if (j * paramInt1 <= i * k) {
              break;
            }
            if (this.jdField_g_of_type_Boolean)
            {
              paramInt1 = k * i / j;
              paramInt2 = i;
              break;
            }
          }
        }
        if (k == 1073741824)
        {
          paramInt2 = this.jdField_e_of_type_Int * i / this.jdField_d_of_type_Int;
          if ((m != -2147483648) || (paramInt2 <= paramInt1))
          {
            paramInt1 = paramInt2;
            paramInt2 = i;
            break label348;
          }
        }
        else
        {
          if (m != 1073741824) {
            break label272;
          }
          paramInt2 = this.jdField_d_of_type_Int * paramInt1 / this.jdField_e_of_type_Int;
          if ((k != -2147483648) || (paramInt2 <= i)) {
            break label269;
          }
        }
        paramInt2 = i;
        label269:
        break label348;
        label272:
        paramInt2 = this.jdField_d_of_type_Int;
        j = this.jdField_e_of_type_Int;
        if ((m == -2147483648) && (j > paramInt1)) {
          paramInt2 = paramInt2 * paramInt1 / j;
        } else {
          paramInt1 = j;
        }
        if ((k == -2147483648) && (paramInt2 > i))
        {
          paramInt1 = this.jdField_e_of_type_Int * i / this.jdField_d_of_type_Int;
          paramInt2 = i;
          break label348;
        }
        break label348;
      }
    }
    label343:
    paramInt2 = j;
    paramInt1 = i;
    label348:
    super.setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewSurface = new Surface(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onSurfaceTextureAvailable: openVideo");
    }
    c();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.jdField_a_of_type_AndroidViewSurface;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    paramSurfaceTexture = this.jdField_a_of_type_AndroidWidgetMediaController;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.hide();
    }
    b(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int i = this.jdField_b_of_type_Int;
    int j = 1;
    if (i == 3) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramInt1 = j;
    } else {
      paramInt1 = 0;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null) && (i != 0) && (paramInt1 != 0))
    {
      paramInt1 = this.jdField_g_of_type_Int;
      if (paramInt1 != 0) {
        seekTo(paramInt1);
      }
      start();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    IMediaPlayer.onTextureUpdateListener localonTextureUpdateListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$onTextureUpdateListener;
    if (localonTextureUpdateListener != null) {
      localonTextureUpdateListener.a(paramSurfaceTexture);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetMediaController != null)) {
      e();
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetMediaController != null)) {
      e();
    }
    return false;
  }
  
  public void pause()
  {
    if ((a()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.d();
      this.jdField_a_of_type_Int = 4;
    }
    this.jdField_b_of_type_Int = 4;
  }
  
  public void seekTo(int paramInt)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(paramInt);
      this.jdField_g_of_type_Int = 0;
      return;
    }
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void setCenterInside(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    IMediaPlayer localIMediaPlayer = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer;
    if (localIMediaPlayer != null) {
      localIMediaPlayer.a(paramBoolean);
    }
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnInfoListener = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener = paramOnSeekCompleteListener;
    IMediaPlayer localIMediaPlayer = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer;
    if (localIMediaPlayer != null) {
      localIMediaPlayer.a(paramOnSeekCompleteListener);
    }
  }
  
  public void setVideoPath(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = Uri.parse(paramString);
    }
    setVideoURI(paramString);
  }
  
  public void setVideoURI(Uri paramUri)
  {
    setVideoURI(paramUri, null);
  }
  
  public void setVideoURI(Uri paramUri, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_AndroidNetUri = paramUri;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_g_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setVideoURI: openVideo");
    }
    c();
    super.requestLayout();
    super.invalidate();
  }
  
  public void setmOnTextureUpdateListener(IMediaPlayer.onTextureUpdateListener paramonTextureUpdateListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$onTextureUpdateListener = paramonTextureUpdateListener;
  }
  
  public void start()
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.c();
      this.jdField_a_of_type_Int = 3;
    }
    this.jdField_b_of_type_Int = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView
 * JD-Core Version:    0.7.0.1
 */