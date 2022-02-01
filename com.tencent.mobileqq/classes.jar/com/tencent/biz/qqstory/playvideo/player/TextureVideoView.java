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
  protected boolean A = false;
  IMediaPlayer.OnVideoSizeChangedListener B = new TextureVideoView.1(this);
  IMediaPlayer.OnPreparedListener C = new TextureVideoView.2(this);
  private IMediaPlayer.OnErrorListener D = new TextureVideoView.5(this);
  private IMediaPlayer.OnBufferingUpdateListener E = new TextureVideoView.6(this);
  private IMediaPlayer.OnCompletionListener a = new TextureVideoView.3(this);
  private IMediaPlayer.OnInfoListener b = new TextureVideoView.4(this);
  protected String c = "Q.qqstory.player.TextureVideoView";
  protected Uri d;
  protected Map<String, String> e;
  protected int f = 0;
  protected int g = 0;
  protected Surface h = null;
  protected IMediaPlayer i = null;
  protected int j;
  protected int k;
  protected int l;
  protected MediaController m;
  protected IMediaPlayer.OnCompletionListener n;
  protected IMediaPlayer.OnPreparedListener o;
  protected IMediaPlayer.OnSeekCompleteListener p;
  protected int q;
  protected IMediaPlayer.OnErrorListener r;
  protected IMediaPlayer.OnInfoListener s;
  protected int t;
  protected boolean u;
  protected boolean v;
  protected boolean w;
  protected boolean x;
  public boolean y;
  protected IMediaPlayer.onTextureUpdateListener z;
  
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
    c();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.d != null)
    {
      if (this.h == null) {
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
            str = this.c;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("requestAudioFocus Exception: ");
            localStringBuilder.append(QLog.getStackTraceString(localException));
            QLog.w(str, 2, localStringBuilder.toString());
          }
        }
      }
      try
      {
        this.i = a();
        this.i.a(this.x);
        if (this.j != 0) {
          this.i.b(this.j);
        } else {
          this.j = this.i.o();
        }
        this.i.a(this.C);
        this.i.a(this.B);
        this.i.a(this.a);
        this.i.a(this.D);
        this.i.a(this.b);
        this.i.a(this.E);
        if (this.p != null) {
          this.i.a(this.p);
        }
        this.q = 0;
        this.i.a(getContext().getApplicationContext(), this.d, this.e);
        this.i.a(this.h);
        this.i.c(3);
        this.i.b(true);
        this.i.b();
        this.f = 1;
        e();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.c, 2, "prepareAsync cause  IllegalStateException", localIllegalStateException);
        }
        this.f = -1;
        this.g = -1;
        this.D.a(this.i, 1, 0);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel())
        {
          str = this.c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unable to open content: ");
          localStringBuilder.append(this.d);
          QLog.w(str, 2, localStringBuilder.toString(), localIllegalArgumentException);
        }
        this.f = -1;
        this.g = -1;
        this.D.a(this.i, 1, 0);
        return;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel())
        {
          str = this.c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unable to open content: ");
          localStringBuilder.append(this.d);
          QLog.w(str, 2, localStringBuilder.toString(), localIOException);
        }
        this.f = -1;
        this.g = -1;
        this.D.a(this.i, 1, 0);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    IMediaPlayer localIMediaPlayer = this.i;
    if (localIMediaPlayer != null)
    {
      localIMediaPlayer.f();
      try
      {
        this.i.h();
        this.i.g();
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        IllegalStateException localIllegalStateException2 = new IllegalStateException("CatchedException, caused by: ", localIllegalStateException1);
        QLog.e(this.c, 1, "mMediaPlayer.release() throw a exception!!", localIllegalStateException2);
      }
      this.i = null;
      this.f = 0;
      if (paramBoolean) {
        this.g = 0;
      }
      ((AudioManager)super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void c()
  {
    this.k = 0;
    this.l = 0;
    super.setSurfaceTextureListener(this);
    super.setFocusable(true);
    super.setFocusableInTouchMode(true);
    super.requestFocus();
    this.f = 0;
    this.g = 0;
  }
  
  private void d()
  {
    a(this.y ^ true);
  }
  
  private void e()
  {
    if (this.i != null)
    {
      Object localObject = this.m;
      if (localObject != null)
      {
        ((MediaController)localObject).setMediaPlayer(this);
        if ((getParent() instanceof View)) {
          localObject = (View)getParent();
        } else {
          localObject = this;
        }
        this.m.setAnchorView((View)localObject);
        this.m.setEnabled(g());
      }
    }
  }
  
  private void f()
  {
    if (this.m.isShowing())
    {
      this.m.hide();
      return;
    }
    this.m.show();
  }
  
  private boolean g()
  {
    if (this.i != null)
    {
      int i1 = this.f;
      if ((i1 != -1) && (i1 != 0) && (i1 != 1)) {
        return true;
      }
    }
    return false;
  }
  
  private Activity getActivity()
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
  
  protected IMediaPlayer a()
  {
    return new MediaPlayerWrapper();
  }
  
  public void b()
  {
    IMediaPlayer localIMediaPlayer = this.i;
    if (localIMediaPlayer != null)
    {
      localIMediaPlayer.f();
      this.i.g();
      this.i.a(null);
      this.i.a(null);
      this.i.a(null);
      this.i.a(null);
      this.i.a(null);
      this.i.a(null);
      this.i.a(null);
      this.i = null;
      this.f = 0;
      this.g = 0;
      ((AudioManager)super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  public boolean canPause()
  {
    return this.u;
  }
  
  public boolean canSeekBackward()
  {
    return this.v;
  }
  
  public boolean canSeekForward()
  {
    return this.w;
  }
  
  public int getAudioSessionId()
  {
    if (this.j == 0)
    {
      ReportMediaPlayer localReportMediaPlayer = new ReportMediaPlayer();
      this.j = localReportMediaPlayer.getAudioSessionId();
      localReportMediaPlayer.release();
    }
    return this.j;
  }
  
  public int getBufferPercentage()
  {
    if (this.i != null) {
      return this.q;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (g()) {
      return this.i.k();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (g()) {
      return this.i.j();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (g()) && (this.i.e());
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
    int i1;
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 164) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((g()) && (i1 != 0) && (this.m != null)) {
      if ((paramInt != 79) && (paramInt != 85))
      {
        if (paramInt == 126)
        {
          if (!this.i.e())
          {
            start();
            this.m.hide();
          }
          return true;
        }
        if ((paramInt != 86) && (paramInt != 127))
        {
          f();
        }
        else
        {
          if (this.i.e())
          {
            pause();
            this.m.show();
          }
          return true;
        }
      }
      else
      {
        if (this.i.e())
        {
          pause();
          this.m.show();
          return true;
        }
        start();
        this.m.hide();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = TextureView.getDefaultSize(this.k, paramInt1);
    int i4 = TextureView.getDefaultSize(this.l, paramInt2);
    int i2 = i3;
    int i1 = i4;
    if (this.k > 0)
    {
      i2 = i3;
      i1 = i4;
      if (this.l > 0)
      {
        i3 = View.MeasureSpec.getMode(paramInt1);
        i1 = View.MeasureSpec.getSize(paramInt1);
        i4 = View.MeasureSpec.getMode(paramInt2);
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
        if ((i3 == 1073741824) && (i4 == 1073741824))
        {
          i2 = this.k;
          i3 = this.l;
          if (i2 * paramInt1 < i1 * i3) {
            if (!this.A) {}
          }
          for (i2 = i2 * paramInt1 / i3;; i2 = i2 * paramInt1 / i3)
          {
            i1 = paramInt1;
            break label343;
            paramInt1 = i3 * i1 / i2;
            paramInt2 = i1;
            break;
            paramInt2 = i1;
            if (i2 * paramInt1 <= i1 * i3) {
              break;
            }
            if (this.A)
            {
              paramInt1 = i3 * i1 / i2;
              paramInt2 = i1;
              break;
            }
          }
        }
        if (i3 == 1073741824)
        {
          paramInt2 = this.l * i1 / this.k;
          if ((i4 != -2147483648) || (paramInt2 <= paramInt1))
          {
            paramInt1 = paramInt2;
            paramInt2 = i1;
            break label348;
          }
        }
        else
        {
          if (i4 != 1073741824) {
            break label272;
          }
          paramInt2 = this.k * paramInt1 / this.l;
          if ((i3 != -2147483648) || (paramInt2 <= i1)) {
            break label269;
          }
        }
        paramInt2 = i1;
        label269:
        break label348;
        label272:
        paramInt2 = this.k;
        i2 = this.l;
        if ((i4 == -2147483648) && (i2 > paramInt1)) {
          paramInt2 = paramInt2 * paramInt1 / i2;
        } else {
          paramInt1 = i2;
        }
        if ((i3 == -2147483648) && (paramInt2 > i1))
        {
          paramInt1 = this.l * i1 / this.k;
          paramInt2 = i1;
          break label348;
        }
        break label348;
      }
    }
    label343:
    paramInt2 = i2;
    paramInt1 = i1;
    label348:
    super.setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.h = new Surface(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.w(this.c, 1, "onSurfaceTextureAvailable: openVideo");
    }
    d();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.h;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.release();
      this.h = null;
    }
    paramSurfaceTexture = this.m;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.hide();
    }
    b(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int i1 = this.g;
    int i2 = 1;
    if (i1 == 3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramInt1 = i2;
    } else {
      paramInt1 = 0;
    }
    if ((this.i != null) && (i1 != 0) && (paramInt1 != 0))
    {
      paramInt1 = this.t;
      if (paramInt1 != 0) {
        seekTo(paramInt1);
      }
      start();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    IMediaPlayer.onTextureUpdateListener localonTextureUpdateListener = this.z;
    if (localonTextureUpdateListener != null) {
      localonTextureUpdateListener.a(paramSurfaceTexture);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((g()) && (this.m != null)) {
      f();
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((g()) && (this.m != null)) {
      f();
    }
    return false;
  }
  
  public void pause()
  {
    if ((g()) && (this.i.e()))
    {
      this.i.d();
      this.f = 4;
    }
    this.g = 4;
  }
  
  public void seekTo(int paramInt)
  {
    if (g())
    {
      this.i.a(paramInt);
      this.t = 0;
      return;
    }
    this.t = paramInt;
  }
  
  public void setCenterInside(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.x = paramBoolean;
    IMediaPlayer localIMediaPlayer = this.i;
    if (localIMediaPlayer != null) {
      localIMediaPlayer.a(paramBoolean);
    }
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.n = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.r = paramOnErrorListener;
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.s = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.o = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.p = paramOnSeekCompleteListener;
    IMediaPlayer localIMediaPlayer = this.i;
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
    this.d = paramUri;
    this.e = paramMap;
    this.t = 0;
    if (QLog.isColorLevel()) {
      QLog.w(this.c, 1, "setVideoURI: openVideo");
    }
    d();
    super.requestLayout();
    super.invalidate();
  }
  
  public void setmOnTextureUpdateListener(IMediaPlayer.onTextureUpdateListener paramonTextureUpdateListener)
  {
    this.z = paramonTextureUpdateListener;
  }
  
  public void start()
  {
    if (g())
    {
      this.i.c();
      this.f = 3;
    }
    this.g = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView
 * JD-Core Version:    0.7.0.1
 */