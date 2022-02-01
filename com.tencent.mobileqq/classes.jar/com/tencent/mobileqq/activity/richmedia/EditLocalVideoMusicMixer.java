package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.VideoView;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.IP2VMusicEditListener;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class EditLocalVideoMusicMixer
{
  private Activity a;
  private FixedSizeVideoView b;
  private ImageButton c;
  private QQProgressDialog d;
  private WeakReference<Dialog> e;
  private long f;
  private long g;
  private long h;
  private String i;
  private AudioPlayer j;
  private QQStoryMusicInfo k;
  private int l = 0;
  private boolean m = false;
  private QzoneVerticalVideoTopicInfo n;
  private DialogInterface.OnShowListener o;
  private DialogInterface.OnDismissListener p;
  private final AudioPlayerBase.AudioPlayerListener q = new EditLocalVideoMusicMixer.1(this);
  private final P2VEditMusicDialog.IP2VMusicEditListener r = new EditLocalVideoMusicMixer.2(this);
  
  private EditLocalVideoMusicMixer(Activity paramActivity, FixedSizeVideoView paramFixedSizeVideoView, ImageButton paramImageButton, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    this.a = paramActivity;
    this.b = paramFixedSizeVideoView;
    this.c = paramImageButton;
    this.n = paramQzoneVerticalVideoTopicInfo;
    this.k = k();
  }
  
  public static EditLocalVideoMusicMixer a(Activity paramActivity, FixedSizeVideoView paramFixedSizeVideoView, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo, ImageButton paramImageButton)
  {
    return new EditLocalVideoMusicMixer(paramActivity, paramFixedSizeVideoView, paramImageButton, paramQzoneVerticalVideoTopicInfo);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.b != null) {}
    for (;;)
    {
      float f2;
      try
      {
        localObject = VideoView.class.getDeclaredField("mMediaPlayer");
        ((Field)localObject).setAccessible(true);
        localObject = (MediaPlayer)((Field)localObject).get(this.b);
        if (localObject == null) {
          break label89;
        }
        f2 = 0.0F;
        if (!paramBoolean) {
          break label90;
        }
        f1 = 0.0F;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Object localObject;
        QZLog.e("EditLocalVideoMusicMixe", 2, localIllegalAccessException, new Object[0]);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        QZLog.e("EditLocalVideoMusicMixe", 2, localNoSuchFieldException, new Object[0]);
      }
      ((MediaPlayer)localObject).setVolume(f1, f2);
      return;
      label89:
      return;
      label90:
      float f1 = 1.0F;
      if (!paramBoolean) {
        f2 = 1.0F;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    AudioPlayer localAudioPlayer = this.j;
    if (localAudioPlayer != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = localAudioPlayer.h();
      } else {
        i1 = 0;
      }
      this.l = i1;
      if (this.k == null) {
        b(false);
      }
      this.j.d();
      this.j = null;
    }
  }
  
  private long h()
  {
    return this.g - this.f;
  }
  
  private boolean i()
  {
    return (this.k != null) && (h() - this.k.p > 0L);
  }
  
  private void j()
  {
    if (this.j == null)
    {
      this.j = new AudioPlayer(this.a, this.q);
      this.j.c(3);
    }
    Object localObject = this.k;
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((QQStoryMusicInfo)localObject).m))
      {
        this.j.a(11);
        localObject = this.j;
        String str = this.k.m;
        int i1 = this.l;
        if (i1 == 0) {
          i1 = this.k.n;
        }
        ((AudioPlayer)localObject).c(str, i1);
        this.a.sendBroadcast(new Intent("action_music_start"));
        b(true);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAudioPlayback: music not downloaded ");
      ((StringBuilder)localObject).append(this.k.g);
      QZLog.e("EditLocalVideoMusicMixe", 2, new Object[] { ((StringBuilder)localObject).toString() });
    }
  }
  
  private QQStoryMusicInfo k()
  {
    Object localObject = this.n;
    if ((localObject != null) && (((QzoneVerticalVideoTopicInfo)localObject).hasMusic()))
    {
      localObject = new QQStoryMusicInfo();
      ((QQStoryMusicInfo)localObject).g = this.n.getMusicUrl();
      ((QQStoryMusicInfo)localObject).d = this.n.getTopicId();
      ((QQStoryMusicInfo)localObject).e = this.n.getMusicName();
      ((QQStoryMusicInfo)localObject).k = 3;
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    P2VEditMusicDialog localP2VEditMusicDialog = new P2VEditMusicDialog(this.a, this.r, (int)h(), true);
    Object localObject = this.p;
    if (localObject != null) {
      localP2VEditMusicDialog.setOnDismissListener((DialogInterface.OnDismissListener)localObject);
    }
    localObject = this.o;
    if (localObject != null) {
      localP2VEditMusicDialog.setOnShowListener((DialogInterface.OnShowListener)localObject);
    }
    localP2VEditMusicDialog.setCanceledOnTouchOutside(false);
    localP2VEditMusicDialog.show();
    this.e = new WeakReference(localP2VEditMusicDialog);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 > 0)
    {
      this.f = paramInt1;
      this.g = paramInt2;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateVideoFrameClippedRange: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt2);
      Log.d("EditLocalVideoMusicMixe", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFrameClippedRange: duration less or equal than zero ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt1);
    Log.w("EditLocalVideoMusicMixe", localStringBuilder.toString());
  }
  
  public void a(long paramLong)
  {
    if (this.k != null) {
      new P2VEditMusicDialog(this.a, this.r, (int)paramLong, true);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    a(0, (int)paramLong);
    this.h = paramLong;
    this.i = paramString;
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.p = paramOnDismissListener;
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.o = paramOnShowListener;
  }
  
  public void a(EditLocalVideoMusicMixer.MusicMixCallback paramMusicMixCallback)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new EditLocalVideoMusicMixRunnable(this.f, this.g, this.h, this.i, this.k, new EditLocalVideoMusicMixer.3(this, paramMusicMixCallback)));
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean b()
  {
    WeakReference localWeakReference = this.e;
    return (localWeakReference != null) && (localWeakReference.get() != null) && (((Dialog)this.e.get()).isShowing());
  }
  
  public void c()
  {
    c(false);
    j();
  }
  
  public void d()
  {
    c(false);
  }
  
  public void e()
  {
    c(true);
  }
  
  public void f()
  {
    j();
  }
  
  public boolean g()
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.k;
    return (localQQStoryMusicInfo != null) && ((localQQStoryMusicInfo.k == 0) || (this.k.k == 3) || (this.k.k == 2)) && (!this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixer
 * JD-Core Version:    0.7.0.1
 */