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
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  private DialogInterface.OnShowListener jdField_a_of_type_AndroidContentDialogInterface$OnShowListener;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private QQStoryMusicInfo jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
  private final P2VEditMusicDialog.IP2VMusicEditListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener = new EditLocalVideoMusicMixer.2(this);
  private FixedSizeVideoView jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer;
  private final AudioPlayerBase.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener = new EditLocalVideoMusicMixer.1(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Dialog> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private long b;
  private long c;
  
  private EditLocalVideoMusicMixer(Activity paramActivity, FixedSizeVideoView paramFixedSizeVideoView, ImageButton paramImageButton, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView = paramFixedSizeVideoView;
    this.jdField_a_of_type_AndroidWidgetImageButton = paramImageButton;
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = paramQzoneVerticalVideoTopicInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = a();
  }
  
  private long a()
  {
    return this.b - this.jdField_a_of_type_Long;
  }
  
  private QQStoryMusicInfo a()
  {
    Object localObject = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
    if ((localObject != null) && (((QzoneVerticalVideoTopicInfo)localObject).hasMusic()))
    {
      localObject = new QQStoryMusicInfo();
      ((QQStoryMusicInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicUrl();
      ((QQStoryMusicInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getTopicId();
      ((QQStoryMusicInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicName();
      ((QQStoryMusicInfo)localObject).jdField_b_of_type_Int = 3;
      return localObject;
    }
    return null;
  }
  
  public static EditLocalVideoMusicMixer a(Activity paramActivity, FixedSizeVideoView paramFixedSizeVideoView, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo, ImageButton paramImageButton)
  {
    return new EditLocalVideoMusicMixer(paramActivity, paramFixedSizeVideoView, paramImageButton, paramQzoneVerticalVideoTopicInfo);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {}
    for (;;)
    {
      float f2;
      try
      {
        localObject = VideoView.class.getDeclaredField("mMediaPlayer");
        ((Field)localObject).setAccessible(true);
        localObject = (MediaPlayer)((Field)localObject).get(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView);
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
    AudioPlayer localAudioPlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer;
    if (localAudioPlayer != null)
    {
      int i;
      if (paramBoolean) {
        i = localAudioPlayer.b();
      } else {
        i = 0;
      }
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo == null) {
        b(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = null;
    }
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null) && (a() - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.f > 0L);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = new AudioPlayer(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c(3);
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((QQStoryMusicInfo)localObject).g))
      {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a(11);
        localObject = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer;
        String str = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.g;
        int i = this.jdField_a_of_type_Int;
        if (i == 0) {
          i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_d_of_type_Int;
        }
        ((AudioPlayer)localObject).b(str, i);
        this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(new Intent("action_music_start"));
        b(true);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAudioPlayback: music not downloaded ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_d_of_type_JavaLangString);
      QZLog.e("EditLocalVideoMusicMixe", 2, new Object[] { ((StringBuilder)localObject).toString() });
    }
  }
  
  public void a()
  {
    P2VEditMusicDialog localP2VEditMusicDialog = new P2VEditMusicDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener, (int)a(), true);
    Object localObject = this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
    if (localObject != null) {
      localP2VEditMusicDialog.setOnDismissListener((DialogInterface.OnDismissListener)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener;
    if (localObject != null) {
      localP2VEditMusicDialog.setOnShowListener((DialogInterface.OnShowListener)localObject);
    }
    localP2VEditMusicDialog.setCanceledOnTouchOutside(false);
    localP2VEditMusicDialog.show();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localP2VEditMusicDialog);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 > 0)
    {
      this.jdField_a_of_type_Long = paramInt1;
      this.b = paramInt2;
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null) {
      new P2VEditMusicDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener, (int)paramLong, true);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    a(0, (int)paramLong);
    this.c = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener = paramOnShowListener;
  }
  
  public void a(EditLocalVideoMusicMixer.MusicMixCallback paramMusicMixCallback)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new EditLocalVideoMusicMixRunnable(this.jdField_a_of_type_Long, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo, new EditLocalVideoMusicMixer.3(this, paramMusicMixCallback)));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    return (localWeakReference != null) && (localWeakReference.get() != null) && (((Dialog)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isShowing());
  }
  
  public void b()
  {
    c(false);
    f();
  }
  
  public boolean b()
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
    return (localQQStoryMusicInfo != null) && ((localQQStoryMusicInfo.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_b_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_b_of_type_Int == 2)) && (!this.jdField_a_of_type_Boolean);
  }
  
  public void c()
  {
    c(false);
  }
  
  public void d()
  {
    c(true);
  }
  
  public void e()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixer
 * JD-Core Version:    0.7.0.1
 */