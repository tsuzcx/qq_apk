package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.music.QQMusicDownloader;
import com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPlayerExport;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

public class QzoneEditTopic
  extends EditVideoPart
{
  private QzoneVerticalVideoTopicInfo a;
  private View b;
  private AudioPlayer c;
  private MusicItemInfo d;
  private boolean e;
  private boolean f;
  private MusicDownloadListener g = new QzoneEditTopic.1(this);
  private final AudioPlayerBase.AudioPlayerListener h = new QzoneEditTopic.2(this);
  
  public QzoneEditTopic(QzEditVideoPartManager paramQzEditVideoPartManager, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    super(paramQzEditVideoPartManager);
    this.a = paramQzoneVerticalVideoTopicInfo;
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = QQMusicDownloader.a(paramMusicItemInfo.mUrl, paramMusicItemInfo.getLocalPath(), this.g);
    if (paramMusicItemInfo != null) {
      QQMusicDownloader.a(paramMusicItemInfo, this.g);
    }
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (this.f) {
      return;
    }
    i();
    if ((this.c != null) && (paramMusicItemInfo != null))
    {
      if (!c(paramMusicItemInfo)) {
        return;
      }
      this.c.a(7);
      this.c.a(paramMusicItemInfo.getLocalPath());
    }
  }
  
  private void c()
  {
    this.b = LayoutInflater.from(u()).inflate(2131628681, null);
    ((TextView)this.b.findViewById(2131448801)).setText(this.a.getDescName());
    Object localObject = (URLImageView)this.b.findViewById(2131436489);
    if (!TextUtils.isEmpty(this.a.getThumbImgUrl())) {
      ((URLImageView)localObject).setBackgroundURL(this.a.getThumbImgUrl());
    } else {
      ((URLImageView)localObject).setVisibility(8);
    }
    localObject = (RelativeLayout)d(2063991043);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = AIOUtils.b(110.0F, s());
    localLayoutParams.leftMargin = AIOUtils.b(10.0F, s());
    ((RelativeLayout)localObject).addView(this.b, localLayoutParams);
  }
  
  private boolean c(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {
      return false;
    }
    return ((paramMusicItemInfo.mType != 5) && (paramMusicItemInfo.mType != 1)) || (FileUtils.fileExistsAndNotEmpty(paramMusicItemInfo.getLocalPath()));
  }
  
  private void d()
  {
    if (this.a.hasMusic())
    {
      this.d = new MusicItemInfo();
      this.d.mSongMid = this.a.getMusicId();
      this.d.mMusicName = this.a.getMusicName();
      this.d.mUrl = this.a.getMusicUrl();
      this.d.mType = 1;
      EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)this.t.a(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        localEditVideoPlayerExport.a(true);
      }
      if (c(this.d))
      {
        this.e = true;
        return;
      }
      a(this.d);
    }
  }
  
  private void i()
  {
    if (this.c == null)
    {
      this.c = new AudioPlayer(u(), this.h);
      this.c.c(3);
    }
  }
  
  private void k()
  {
    if (this.f) {
      return;
    }
    this.t.a(Message.obtain(null, 3, 1, 0));
    l();
    b(this.d);
  }
  
  private void l()
  {
    AudioPlayer localAudioPlayer = this.c;
    if (localAudioPlayer != null)
    {
      localAudioPlayer.d();
      this.c = null;
    }
  }
  
  public void a()
  {
    super.a();
    c();
    d();
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    MusicItemInfo localMusicItemInfo = this.d;
    if ((localMusicItemInfo != null) && (!TextUtils.isEmpty(localMusicItemInfo.getLocalPath())))
    {
      paramGenerateContext.d.backgroundMusicPath = this.d.getLocalPath();
      paramGenerateContext.d.isMuteRecordVoice = true;
      paramGenerateContext.d.backgroundMusicOffset = this.d.musicStart;
      paramGenerateContext.d.backgroundMusicDuration = ((int)ShortVideoUtils.a(this.d.getLocalPath()));
      if (paramGenerateContext.d.backgroundMusicDuration <= 0) {
        paramGenerateContext.d.backgroundMusicPath = null;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        paramObject = this.b;
        if (paramObject != null) {
          paramObject.setVisibility(8);
        }
      }
      else
      {
        paramObject = this.b;
        if (paramObject != null) {
          paramObject.setVisibility(8);
        }
      }
    }
    else
    {
      paramObject = this.b;
      if (paramObject != null) {
        paramObject.setVisibility(0);
      }
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 14)
    {
      l();
      b(this.d);
    }
    return super.a(paramMessage);
  }
  
  public void ax_()
  {
    this.f = true;
    super.ax_();
    l();
  }
  
  public void f()
  {
    this.f = false;
    super.f();
    if (this.e) {
      k();
    }
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditTopic
 * JD-Core Version:    0.7.0.1
 */