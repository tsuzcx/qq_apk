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
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.qq.im.capture.music.QQMusicDownloader;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bkqj
  extends bjxl
{
  private final acts jdField_a_of_type_Acts = new bkql(this);
  private View jdField_a_of_type_AndroidViewView;
  private bjdv jdField_a_of_type_Bjdv = new bkqk(this);
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bkqj(bkpw parambkpw, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    super(parambkpw);
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = paramQzoneVerticalVideoTopicInfo;
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = QQMusicDownloader.a(paramMusicItemInfo.mUrl, paramMusicItemInfo.getLocalPath(), this.jdField_a_of_type_Bjdv);
    if (paramMusicItemInfo != null) {
      QQMusicDownloader.a(paramMusicItemInfo, this.jdField_a_of_type_Bjdv);
    }
  }
  
  private boolean a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {}
    while (((paramMusicItemInfo.mType == 5) || (paramMusicItemInfo.mType == 1)) && (!bbdx.b(paramMusicItemInfo.getLocalPath()))) {
      return false;
    }
    return true;
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (this.b) {}
    do
    {
      return;
      k();
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) || (paramMusicItemInfo == null) || (!a(paramMusicItemInfo)));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(paramMusicItemInfo.getLocalPath());
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561854, null);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378373)).setText(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.e());
    Object localObject = (URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368637);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.g())) {
      ((URLImageView)localObject).setBackgroundURL(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.g());
    }
    for (;;)
    {
      localObject = (RelativeLayout)a(2131365522);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = actj.a(110.0F, a());
      localLayoutParams.leftMargin = actj.a(10.0F, a());
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      ((URLImageView)localObject).setVisibility(8);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = new MusicItemInfo();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mSongMid = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.c();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mType = 1;
      bjxx localbjxx = (bjxx)this.jdField_a_of_type_Bjxn.a(bjxx.class);
      if (localbjxx != null) {
        localbjxx.a(true);
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
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(a(), this.jdField_a_of_type_Acts);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    }
  }
  
  private void l()
  {
    if (this.b) {
      return;
    }
    this.jdField_a_of_type_Bjxn.a(Message.obtain(null, 3, 1, 0));
    n();
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  private void n()
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
    d();
    j();
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath())))
    {
      parambkld.a.backgroundMusicPath = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath();
      parambkld.a.isMuteRecordVoice = true;
      parambkld.a.backgroundMusicOffset = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
      parambkld.a.backgroundMusicDuration = ((int)ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()));
      if (parambkld.a.backgroundMusicDuration <= 0) {
        parambkld.a.backgroundMusicPath = null;
      }
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      n();
      b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
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
  
  public void ba_()
  {
    this.b = true;
    super.ba_();
    n();
  }
  
  public void f()
  {
    this.b = false;
    super.f();
    if (this.jdField_a_of_type_Boolean) {
      l();
    }
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqj
 * JD-Core Version:    0.7.0.1
 */