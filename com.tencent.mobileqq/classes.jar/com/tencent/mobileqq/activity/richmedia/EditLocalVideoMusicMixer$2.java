package com.tencent.mobileqq.activity.richmedia;

import android.widget.ImageButton;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.IP2VMusicEditListener;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class EditLocalVideoMusicMixer$2
  implements P2VEditMusicDialog.IP2VMusicEditListener
{
  EditLocalVideoMusicMixer$2(EditLocalVideoMusicMixer paramEditLocalVideoMusicMixer) {}
  
  public QQStoryMusicInfo a()
  {
    if (EditLocalVideoMusicMixer.c(this.a) != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurFragmentMusic: ");
      localStringBuilder.append(EditLocalVideoMusicMixer.c(this.a).a());
      QZLog.d("EditLocalVideoMusicMixe", 2, localStringBuilder.toString());
    }
    return EditLocalVideoMusicMixer.c(this.a);
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangeMusicBtnType: ");
    localStringBuilder.append(paramInt);
    QZLog.d("EditLocalVideoMusicMixe", 2, localStringBuilder.toString());
    if (EditLocalVideoMusicMixer.e(this.a) != null)
    {
      if (paramInt == 0)
      {
        EditLocalVideoMusicMixer.e(this.a).setImageResource(2130848443);
        return;
      }
      if (paramInt == 3)
      {
        EditLocalVideoMusicMixer.e(this.a).setImageResource(2130848442);
        return;
      }
      EditLocalVideoMusicMixer.e(this.a).setImageResource(2130848436);
    }
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    if (paramQQStoryMusicInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeCurFragmentMusic: ");
      localStringBuilder.append(paramQQStoryMusicInfo.a());
      localStringBuilder.append(" ");
      localStringBuilder.append(paramQQStoryMusicInfo.n);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramQQStoryMusicInfo.o);
      QZLog.d("EditLocalVideoMusicMixe", 2, localStringBuilder.toString());
      if (paramQQStoryMusicInfo.k == 0)
      {
        EditLocalVideoMusicMixer.a(this.a, false);
        EditLocalVideoMusicMixer.b(this.a, true);
      }
      else if (paramQQStoryMusicInfo.k == 1)
      {
        EditLocalVideoMusicMixer.a(this.a, false);
        EditLocalVideoMusicMixer.b(this.a, false);
      }
    }
    else
    {
      EditLocalVideoMusicMixer.a(this.a, false);
    }
    EditLocalVideoMusicMixer.a(this.a, paramQQStoryMusicInfo);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetCurFragmentMusicPath: ");
    localStringBuilder.append(paramString);
    QZLog.d("EditLocalVideoMusicMixe", 2, localStringBuilder.toString());
    if (EditLocalVideoMusicMixer.c(this.a) != null) {
      EditLocalVideoMusicMixer.c(this.a).m = paramString;
    }
  }
  
  public void b()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (EditLocalVideoMusicMixer.d(this.a) != null)
    {
      EditLocalVideoMusicMixer localEditLocalVideoMusicMixer = this.a;
      EditLocalVideoMusicMixer.a(localEditLocalVideoMusicMixer, EditLocalVideoMusicMixer.d(localEditLocalVideoMusicMixer).h());
    }
    EditLocalVideoMusicMixer.a(this.a, true);
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onStopCurFragmentMusic: ");
    EditLocalVideoMusicMixer.a(this.a, 0);
    EditLocalVideoMusicMixer.a(this.a, false);
  }
  
  public void d()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    EditLocalVideoMusicMixer.b(this.a);
  }
  
  public void e()
  {
    EditLocalVideoMusicMixer.b(this.a, false);
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean g()
  {
    return (EditLocalVideoMusicMixer.f(this.a) == null) || (!EditLocalVideoMusicMixer.f(this.a).hasMusic());
  }
  
  public boolean h()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixer.2
 * JD-Core Version:    0.7.0.1
 */