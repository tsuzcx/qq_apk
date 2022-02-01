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
    if (EditLocalVideoMusicMixer.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + EditLocalVideoMusicMixer.a(this.a).a());
    }
    return EditLocalVideoMusicMixer.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (EditLocalVideoMusicMixer.a(this.a) != null) {
      EditLocalVideoMusicMixer.a(this.a, EditLocalVideoMusicMixer.a(this.a).c());
    }
    EditLocalVideoMusicMixer.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (EditLocalVideoMusicMixer.a(this.a) != null)
    {
      if (paramInt == 0) {
        EditLocalVideoMusicMixer.a(this.a).setImageResource(2130847013);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      EditLocalVideoMusicMixer.a(this.a).setImageResource(2130847012);
      return;
    }
    EditLocalVideoMusicMixer.a(this.a).setImageResource(2130847006);
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    if (paramQQStoryMusicInfo != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramQQStoryMusicInfo.a() + " " + paramQQStoryMusicInfo.d + " to " + paramQQStoryMusicInfo.e);
      if (paramQQStoryMusicInfo.b == 0)
      {
        EditLocalVideoMusicMixer.a(this.a, false);
        EditLocalVideoMusicMixer.b(this.a, true);
      }
    }
    for (;;)
    {
      EditLocalVideoMusicMixer.a(this.a, paramQQStoryMusicInfo);
      return;
      if (paramQQStoryMusicInfo.b == 1)
      {
        EditLocalVideoMusicMixer.a(this.a, false);
        EditLocalVideoMusicMixer.b(this.a, false);
        continue;
        EditLocalVideoMusicMixer.a(this.a, false);
      }
    }
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixer.2
 * JD-Core Version:    0.7.0.1
 */