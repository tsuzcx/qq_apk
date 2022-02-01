package com.tencent.aelight.camera.aioeditor.capture.view;

import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class MusicFragmentProviderView$1
  extends MusicDownloadListener
{
  MusicFragmentProviderView$1(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void a(int paramInt)
  {
    this.a.c(paramInt);
  }
  
  public void a(String paramString)
  {
    if ((MusicFragmentProviderView.a(this.a) != null) && (MusicFragmentProviderView.a(this.a).getLocalPath().equals(paramString)))
    {
      MusicFragmentProviderView.a(this.a).mProgress = -1;
      if (this.a.a != null) {
        this.a.a.sendEmptyMessage(3);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicFragmentProviderView", 2, "download onCancel");
    }
    MusicFragmentProviderView.a(this.a).set(false);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.a.a(paramString, paramInt);
    MusicFragmentProviderView.a(this.a).set(true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a.b(-115);
      MusicFragmentProviderView.a(this.a).set(false);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    this.a.b(paramInt);
    if ((paramBoolean) && (MusicFragmentProviderView.a(this.a) != null) && (MusicFragmentProviderView.a(this.a).getLocalPath().equals(paramString)))
    {
      MusicFragmentProviderView.a(this.a).musicStart = 0;
      MusicFragmentProviderView.a(this.a).musicEnd = (MusicFragmentProviderView.a(this.a).musicStart + MusicFragmentProviderView.a(this.a));
      MusicFragmentProviderView.a(this.a).musicDuration = ((int)ShortVideoUtils.a(MusicFragmentProviderView.a(this.a).getLocalPath()));
      if (MusicFragmentProviderView.a(this.a).musicEnd > MusicFragmentProviderView.a(this.a).musicDuration) {
        MusicFragmentProviderView.a(this.a).musicEnd = MusicFragmentProviderView.a(this.a).musicDuration;
      }
      paramString = this.a;
      MusicFragmentProviderView.a(paramString, MusicFragmentProviderView.a(paramString).musicStart);
      paramString = this.a;
      MusicFragmentProviderView.b(paramString, MusicFragmentProviderView.a(paramString).musicEnd);
      paramString = (QIMMusicConfigManager)QIMManager.a(2);
      MusicItemInfo localMusicItemInfo = paramString.a(MusicFragmentProviderView.a(this.a).mItemId);
      if (localMusicItemInfo != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("music exist name =");
          localStringBuilder.append(localMusicItemInfo.mMusicName);
          QLog.d("MusicFragmentProviderView", 2, localStringBuilder.toString());
        }
        paramString.a(MusicFragmentProviderView.a(this.a), false);
      }
      if (this.a.a != null) {
        this.a.a.sendEmptyMessage(2);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("onFinish musicStart=");
        paramString.append(MusicFragmentProviderView.a(this.a).musicStart);
        paramString.append(" musicEnd=");
        paramString.append(MusicFragmentProviderView.a(this.a).musicEnd);
        paramString.append(" musicDuration");
        paramString.append(MusicFragmentProviderView.a(this.a).musicDuration);
        paramString.append(" premusicStart");
        paramString.append(MusicFragmentProviderView.b(this.a));
        paramString.append(" premusicEnd");
        paramString.append(MusicFragmentProviderView.c(this.a));
        paramString.append(" musicName");
        paramString.append(MusicFragmentProviderView.a(this.a).mMusicName);
        QLog.d("MusicFragmentProviderView", 2, paramString.toString());
      }
    }
    MusicFragmentProviderView.a(this.a).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicFragmentProviderView.1
 * JD-Core Version:    0.7.0.1
 */