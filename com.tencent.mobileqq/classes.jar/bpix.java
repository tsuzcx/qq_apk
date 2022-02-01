import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.qq.im.capture.music.QQMusicDownloader;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bpix
  extends botu
{
  private final afpx jdField_a_of_type_Afpx = new bpiz(this);
  private View jdField_a_of_type_AndroidViewView;
  private boiw jdField_a_of_type_Boiw = new bpiy(this);
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bpix(bpik parambpik, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    super(parambpik);
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = paramQzoneVerticalVideoTopicInfo;
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = QQMusicDownloader.a(paramMusicItemInfo.mUrl, paramMusicItemInfo.getLocalPath(), this.jdField_a_of_type_Boiw);
    if (paramMusicItemInfo != null) {
      QQMusicDownloader.a(paramMusicItemInfo, this.jdField_a_of_type_Boiw);
    }
  }
  
  private boolean a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {}
    while (((paramMusicItemInfo.mType == 5) || (paramMusicItemInfo.mType == 1)) && (!FileUtils.fileExistsAndNotEmpty(paramMusicItemInfo.getLocalPath()))) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562279, null);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380198)).setText(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getDescName());
    Object localObject = (URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369488);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getThumbImgUrl())) {
      ((URLImageView)localObject).setBackgroundURL(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getThumbImgUrl());
    }
    for (;;)
    {
      localObject = (RelativeLayout)a(2131366018);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = AIOUtils.dp2px(110.0F, a());
      localLayoutParams.leftMargin = AIOUtils.dp2px(10.0F, a());
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      ((URLImageView)localObject).setVisibility(8);
    }
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (this.b) {}
    do
    {
      return;
      d();
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) || (paramMusicItemInfo == null) || (!a(paramMusicItemInfo)));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(paramMusicItemInfo.getLocalPath());
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.hasMusic())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = new MusicItemInfo();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mSongMid = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicId();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicName();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicUrl();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mType = 1;
      boud localboud = (boud)this.jdField_a_of_type_Botw.a(boud.class);
      if (localboud != null) {
        localboud.a(true);
      }
      if (a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(a(), this.jdField_a_of_type_Afpx);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    }
  }
  
  private void i()
  {
    if (this.b) {
      return;
    }
    this.jdField_a_of_type_Botw.a(Message.obtain(null, 3, 1, 0));
    k();
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    }
  }
  
  public void a()
  {
    super.a();
    b();
    c();
  }
  
  public void a(int paramInt, @NonNull bpel parambpel)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath())))
    {
      parambpel.a.backgroundMusicPath = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath();
      parambpel.a.isMuteRecordVoice = true;
      parambpel.a.backgroundMusicOffset = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
      parambpel.a.backgroundMusicDuration = ((int)ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()));
      if (parambpel.a.backgroundMusicDuration <= 0) {
        parambpel.a.backgroundMusicPath = null;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      k();
      b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
  
  public void aH_()
  {
    this.b = true;
    super.aH_();
    k();
  }
  
  public void aI_()
  {
    this.b = false;
    super.aI_();
    if (this.jdField_a_of_type_Boolean) {
      i();
    }
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpix
 * JD-Core Version:    0.7.0.1
 */