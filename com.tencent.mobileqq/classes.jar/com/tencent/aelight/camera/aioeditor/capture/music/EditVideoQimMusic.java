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
  private QimMusicPlayer jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  
  public EditVideoQimMusic(@NonNull EditVideoPartManager paramEditVideoPartManager, boolean paramBoolean)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bundle a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return null;
  }
  
  private MusicItemInfo a()
  {
    Bundle localBundle = a();
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
  
  private void a(int paramInt, GenerateContext paramGenerateContext, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = paramGenerateContext.a.getBooleanExtra("isMixOriginal", this.jdField_a_of_type_Boolean);
    if (paramMusicItemInfo != null)
    {
      paramGenerateContext.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.e()) {
        i = Math.min(j, (int)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(paramInt));
      }
      paramGenerateContext.a.backgroundMusicDuration = i;
      paramGenerateContext.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      paramGenerateContext.a.isMuteRecordVoice = (bool ^ true);
      paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
      paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
      paramGenerateContext.a.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
      paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      return;
    }
    paramMusicItemInfo = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.b();
    if ((paramMusicItemInfo != null) && ((paramMusicItemInfo.mType == 3) || (paramMusicItemInfo.isDownloading()))) {
      paramGenerateContext.a.backgroundMusicPath = null;
    }
  }
  
  private void b(int paramInt, @NonNull GenerateContext paramGenerateContext, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null)
    {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        paramGenerateContext.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(paramInt));
        paramGenerateContext.a.backgroundMusicDuration = paramInt;
      }
      else
      {
        paramGenerateContext.a.backgroundMusicOffset = 0;
        paramGenerateContext.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(paramInt));
      }
      paramGenerateContext.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      paramGenerateContext.a.isMuteRecordVoice = true;
      return;
    }
    paramMusicItemInfo = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.b();
    if ((paramMusicItemInfo != null) && (paramMusicItemInfo.mType == 3))
    {
      paramGenerateContext.a.backgroundMusicPath = null;
      paramGenerateContext.a.isMuteRecordVoice = true;
    }
  }
  
  public void A_()
  {
    super.A_();
  }
  
  public void a()
  {
    super.a();
    a(EditMusicExport.class, this);
    QimMusicPlayer localQimMusicPlayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localQimMusicPlayer != null)
    {
      localQimMusicPlayer.a(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localObject1 == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = ((QimMusicPlayer)localObject1).a();
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
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a == 14))
    {
      a(paramInt, paramGenerateContext, localMusicItemInfo);
      return;
    }
    b(paramInt, paramGenerateContext, localMusicItemInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.a(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer == null) {
      return;
    }
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("playBgMusic in = null isPause=");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
        QLog.d("EditVideoQimMusic", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = ((QimMusicPlayer)QIMManager.a().c(8));
    Object localObject2;
    if (this.c)
    {
      this.c = false;
      localObject2 = a();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.e();
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a();
    }
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("playBgMusic in mPreTime=");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject2).append(" currentTime=");
      ((StringBuilder)localObject2).append(l);
      QLog.d("EditVideoQimMusic", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a((MusicItemInfo)localObject1, true, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c());
  }
  
  public void d()
  {
    super.d();
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "onResume");
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(null);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = null;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
  }
  
  public void z_()
  {
    super.z_();
    this.jdField_b_of_type_Boolean = true;
    QimMusicPlayer localQimMusicPlayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localQimMusicPlayer != null) {
      localQimMusicPlayer.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.EditVideoQimMusic
 * JD-Core Version:    0.7.0.1
 */