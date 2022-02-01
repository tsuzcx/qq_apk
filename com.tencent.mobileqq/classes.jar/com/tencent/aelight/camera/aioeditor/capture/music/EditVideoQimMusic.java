package com.tencent.aelight.camera.aioeditor.capture.music;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditMusicExport;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPlayerExport;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;

public class EditVideoQimMusic
  extends EditVideoPart
  implements View.OnClickListener, MusicMuteListener, EditMusicExport
{
  private boolean a;
  private long b = -1L;
  private QimMusicPlayer c = (QimMusicPlayer)QIMManager.a().d(8);
  private boolean d = false;
  private boolean e = true;
  
  public EditVideoQimMusic(@NonNull EditVideoPartManager paramEditVideoPartManager, boolean paramBoolean)
  {
    super(paramEditVideoPartManager);
    this.a = paramBoolean;
  }
  
  private void a(int paramInt, GenerateContext paramGenerateContext, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = paramGenerateContext.d.getBooleanExtra("isMixOriginal", this.a);
    if (paramMusicItemInfo != null)
    {
      paramGenerateContext.d.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.t.l()) {
        i = Math.min(j, (int)this.t.b(paramInt));
      }
      paramGenerateContext.d.backgroundMusicDuration = i;
      paramGenerateContext.d.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      paramGenerateContext.d.isMuteRecordVoice = (bool ^ true);
      paramGenerateContext.d.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
      paramGenerateContext.d.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
      paramGenerateContext.d.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
      paramGenerateContext.d.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      return;
    }
    paramMusicItemInfo = this.c.j();
    if ((paramMusicItemInfo != null) && ((paramMusicItemInfo.mType == 3) || (paramMusicItemInfo.isDownloading()))) {
      paramGenerateContext.d.backgroundMusicPath = null;
    }
  }
  
  private void b(int paramInt, @NonNull GenerateContext paramGenerateContext, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null)
    {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        paramGenerateContext.d.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.t.b(paramInt));
        paramGenerateContext.d.backgroundMusicDuration = paramInt;
      }
      else
      {
        paramGenerateContext.d.backgroundMusicOffset = 0;
        paramGenerateContext.d.backgroundMusicDuration = ((int)this.t.b(paramInt));
      }
      paramGenerateContext.d.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      paramGenerateContext.d.isMuteRecordVoice = true;
      return;
    }
    paramMusicItemInfo = this.c.j();
    if ((paramMusicItemInfo != null) && (paramMusicItemInfo.mType == 3))
    {
      paramGenerateContext.d.backgroundMusicPath = null;
      paramGenerateContext.d.isMuteRecordVoice = true;
    }
  }
  
  private MusicItemInfo c()
  {
    Bundle localBundle = i();
    Object localObject = null;
    if (localBundle != null) {
      localBundle = localBundle.getBundle(MusicProviderView.class.getSimpleName());
    } else {
      localBundle = null;
    }
    if (localBundle != null)
    {
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)localBundle.getParcelable("select_music");
      localObject = localBundle.getString("select_music_local_path");
      boolean bool = localBundle.getBoolean("select_mute");
      if (localMusicItemInfo != null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localMusicItemInfo.setPath((String)localObject);
        }
        localObject = localMusicItemInfo;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("restore music");
          ((StringBuilder)localObject).append(localMusicItemInfo.mMusicName);
          QLog.i("EditVideoQimMusic", 2, ((StringBuilder)localObject).toString());
          return localMusicItemInfo;
        }
      }
      else
      {
        localObject = localMusicItemInfo;
        if (bool)
        {
          localObject = new MusicItemInfo();
          ((MusicItemInfo)localObject).mType = 3;
          ((MusicItemInfo)localObject).mItemId = -2;
        }
      }
    }
    return localObject;
  }
  
  private Bundle i()
  {
    if (this.t.ad != null) {
      return this.t.ad.getBundle("container");
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    a(EditMusicExport.class, this);
    QimMusicPlayer localQimMusicPlayer = this.c;
    if (localQimMusicPlayer != null)
    {
      localQimMusicPlayer.a(this);
      this.c.a(this.a);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    Object localObject1 = this.c;
    if (localObject1 == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = ((QimMusicPlayer)localObject1).i();
    if (localMusicItemInfo != null)
    {
      Object localObject2 = localMusicItemInfo.mTagName;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "none";
      }
      localObject2 = (IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_");
      localStringBuilder.append(localMusicItemInfo.mItemId);
      ((IAEBaseReportParam)localObject2).setEditMusicId(localStringBuilder.toString());
    }
    if ((this.t.I != null) && (this.t.I.a == 14))
    {
      a(paramInt, paramGenerateContext, localMusicItemInfo);
      return;
    }
    b(paramInt, paramGenerateContext, localMusicItemInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)this.t.a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.a(paramBoolean);
    }
  }
  
  public void at_()
  {
    super.at_();
  }
  
  public void ax_()
  {
    super.ax_();
    this.d = true;
    QimMusicPlayer localQimMusicPlayer = this.c;
    if (localQimMusicPlayer != null) {
      localQimMusicPlayer.b();
    }
  }
  
  public void d()
  {
    if (this.c == null) {
      return;
    }
    Object localObject1;
    if (this.d)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("playBgMusic in = null isPause=");
        ((StringBuilder)localObject1).append(this.d);
        QLog.d("EditVideoQimMusic", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    this.c = ((QimMusicPlayer)QIMManager.a().d(8));
    Object localObject2;
    if (this.e)
    {
      this.e = false;
      localObject2 = c();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        this.c.e();
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = this.c.i();
    }
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("playBgMusic in mPreTime=");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" currentTime=");
      ((StringBuilder)localObject2).append(l);
      QLog.d("EditVideoQimMusic", 2, ((StringBuilder)localObject2).toString());
    }
    this.c.a((MusicItemInfo)localObject1, true, this.t.y());
  }
  
  public void f()
  {
    super.f();
    this.d = false;
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "onResume");
    }
  }
  
  public void g()
  {
    super.g();
    this.c.a(null);
    this.c = null;
  }
  
  public void onClick(View paramView)
  {
    this.t.d(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.EditVideoQimMusic
 * JD-Core Version:    0.7.0.1
 */