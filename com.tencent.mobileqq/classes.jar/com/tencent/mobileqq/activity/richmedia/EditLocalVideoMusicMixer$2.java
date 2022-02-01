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
    if (EditLocalVideoMusicMixer.a(this.a) != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurFragmentMusic: ");
      localStringBuilder.append(EditLocalVideoMusicMixer.a(this.a).a());
      QZLog.d("EditLocalVideoMusicMixe", 2, localStringBuilder.toString());
    }
    return EditLocalVideoMusicMixer.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (EditLocalVideoMusicMixer.a(this.a) != null)
    {
      EditLocalVideoMusicMixer localEditLocalVideoMusicMixer = this.a;
      EditLocalVideoMusicMixer.a(localEditLocalVideoMusicMixer, EditLocalVideoMusicMixer.a(localEditLocalVideoMusicMixer).b());
    }
    EditLocalVideoMusicMixer.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangeMusicBtnType: ");
    localStringBuilder.append(paramInt);
    QZLog.d("EditLocalVideoMusicMixe", 2, localStringBuilder.toString());
    if (EditLocalVideoMusicMixer.a(this.a) != null)
    {
      if (paramInt == 0)
      {
        EditLocalVideoMusicMixer.a(this.a).setImageResource(2130846891);
        return;
      }
      if (paramInt == 3)
      {
        EditLocalVideoMusicMixer.a(this.a).setImageResource(2130846890);
        return;
      }
      EditLocalVideoMusicMixer.a(this.a).setImageResource(2130846884);
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
      localStringBuilder.append(paramQQStoryMusicInfo.d);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramQQStoryMusicInfo.e);
      QZLog.d("EditLocalVideoMusicMixe", 2, localStringBuilder.toString());
      if (paramQQStoryMusicInfo.b == 0)
      {
        EditLocalVideoMusicMixer.a(this.a, false);
        EditLocalVideoMusicMixer.b(this.a, true);
      }
      else if (paramQQStoryMusicInfo.b == 1)
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
    if (EditLocalVideoMusicMixer.a(this.a) != null) {
      EditLocalVideoMusicMixer.a(this.a).g = paramString;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onStopCurFragmentMusic: ");
    EditLocalVideoMusicMixer.a(this.a, 0);
    EditLocalVideoMusicMixer.a(this.a, false);
  }
  
  public boolean b()
  {
    return (EditLocalVideoMusicMixer.a(this.a) == null) || (!EditLocalVideoMusicMixer.a(this.a).hasMusic());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    EditLocalVideoMusicMixer.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    EditLocalVideoMusicMixer.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixer.2
 * JD-Core Version:    0.7.0.1
 */