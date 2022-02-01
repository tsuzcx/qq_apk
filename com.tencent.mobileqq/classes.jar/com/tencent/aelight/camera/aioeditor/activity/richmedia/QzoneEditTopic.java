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
  private View jdField_a_of_type_AndroidViewView;
  private MusicDownloadListener jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener = new QzoneEditTopic.1(this);
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer;
  private final AudioPlayerBase.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener = new QzoneEditTopic.2(this);
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public QzoneEditTopic(QzEditVideoPartManager paramQzEditVideoPartManager, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    super(paramQzEditVideoPartManager);
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = paramQzoneVerticalVideoTopicInfo;
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = QQMusicDownloader.a(paramMusicItemInfo.mUrl, paramMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener);
    if (paramMusicItemInfo != null) {
      QQMusicDownloader.a(paramMusicItemInfo, this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener);
    }
  }
  
  private boolean a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {
      return false;
    }
    return ((paramMusicItemInfo.mType != 5) && (paramMusicItemInfo.mType != 1)) || (FileUtils.fileExistsAndNotEmpty(paramMusicItemInfo.getLocalPath()));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562253, null);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379920)).setText(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getDescName());
    Object localObject = (URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369437);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getThumbImgUrl())) {
      ((URLImageView)localObject).setBackgroundURL(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getThumbImgUrl());
    } else {
      ((URLImageView)localObject).setVisibility(8);
    }
    localObject = (RelativeLayout)a(2064122153);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = AIOUtils.b(110.0F, a());
    localLayoutParams.leftMargin = AIOUtils.b(10.0F, a());
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (this.b) {
      return;
    }
    h();
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null) && (paramMusicItemInfo != null))
    {
      if (!a(paramMusicItemInfo)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a(7);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a(paramMusicItemInfo.getLocalPath());
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.hasMusic())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = new MusicItemInfo();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mSongMid = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicId();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicName();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicUrl();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mType = 1;
      EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        localEditVideoPlayerExport.a(true);
      }
      if (a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
      {
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = new AudioPlayer(a(), this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c(3);
    }
  }
  
  private void j()
  {
    if (this.b) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
    k();
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  private void k()
  {
    AudioPlayer localAudioPlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer;
    if (localAudioPlayer != null)
    {
      localAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = null;
    }
  }
  
  public void a()
  {
    super.a();
    b();
    g();
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    if ((localMusicItemInfo != null) && (!TextUtils.isEmpty(localMusicItemInfo.getLocalPath())))
    {
      paramGenerateContext.a.backgroundMusicPath = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath();
      paramGenerateContext.a.isMuteRecordVoice = true;
      paramGenerateContext.a.backgroundMusicOffset = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
      paramGenerateContext.a.backgroundMusicDuration = ((int)ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()));
      if (paramGenerateContext.a.backgroundMusicDuration <= 0) {
        paramGenerateContext.a.backgroundMusicPath = null;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        paramObject = this.jdField_a_of_type_AndroidViewView;
        if (paramObject != null) {
          paramObject.setVisibility(8);
        }
      }
      else
      {
        paramObject = this.jdField_a_of_type_AndroidViewView;
        if (paramObject != null) {
          paramObject.setVisibility(8);
        }
      }
    }
    else
    {
      paramObject = this.jdField_a_of_type_AndroidViewView;
      if (paramObject != null) {
        paramObject.setVisibility(0);
      }
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 14)
    {
      k();
      b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    return super.a(paramMessage);
  }
  
  public void d()
  {
    this.b = false;
    super.d();
    if (this.jdField_a_of_type_Boolean) {
      j();
    }
  }
  
  public void e()
  {
    super.e();
  }
  
  public void z_()
  {
    this.b = true;
    super.z_();
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditTopic
 * JD-Core Version:    0.7.0.1
 */