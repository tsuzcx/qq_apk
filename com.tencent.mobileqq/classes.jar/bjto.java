import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.humrecognition.BubbleTextView;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import java.io.File;

public class bjto
  extends bjwu
  implements Handler.Callback, bjdo
{
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new bjtr(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bfnk jdField_a_of_type_Bfnk = new bfnk(Looper.getMainLooper(), this);
  private bjde jdField_a_of_type_Bjde = new bjtq(this);
  private bjdm jdField_a_of_type_Bjdm = (bjdm)bjae.a().c(8);
  private bjea jdField_a_of_type_Bjea;
  private bjed jdField_a_of_type_Bjed = (bjed)bjae.a().c(10);
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private BubbleTextView jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView;
  public boolean a;
  private bfnk jdField_b_of_type_Bfnk;
  private boolean jdField_b_of_type_Boolean;
  
  public bjto(@NonNull bjww parambjww)
  {
    super(parambjww);
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    ((QIMMusicConfigManager)bjae.a().c(2)).a(paramMusicItemInfo, true);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bjww.a(Message.obtain(null, 3, 1, 0));
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "popupRecognitionBubble: invoked. info: mHumMusicItemInfo = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    Object localObject = ajyc.a(2131703691) + System.getProperty("line.separator") + bjdp.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.a();
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.measure(0, 0);
    int i = this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.getMeasuredWidth() / 2;
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131363767);
    ((RelativeLayout.LayoutParams)localObject).setMargins(372 - i, 0, 0, 4);
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView, (ViewGroup.LayoutParams)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EditRecognitionPart", 2, "popupRecognitionBubble: Failed. info: exception = ", localThrowable);
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "removeRecognitionBubble: invoked.");
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EditRecognitionPart", 2, "removeRecognitionBubble: Failed. info: exception = ", localThrowable);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Bjdm.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      d();
      this.jdField_a_of_type_Bjdm.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bjww.c());
      this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjun.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setVisibility(8);
      k();
      this.jdField_a_of_type_Bjed.b(this);
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mHasCopyright)
      {
        String str = ajyc.a(2131703695) + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName + ajyc.a(2131703694);
        bcpw.a(a(), 0, str, 0).a();
        if (QLog.isColorLevel()) {
          QLog.d("EditRecognitionPart", 2, "url:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl + " playable:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mHasCopyright);
        }
      }
      else
      {
        this.jdField_a_of_type_Bjdm.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bjde);
      }
    }
  }
  
  public float a()
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a();
    float f1;
    if (localLocalMediaInfo == null) {
      f1 = 0.0F;
    }
    float f2;
    do
    {
      return f1;
      f2 = (float)Math.floor(localLocalMediaInfo.mDuration);
      f1 = f2;
    } while (!QLog.isColorLevel());
    QLog.i("EditRecognitionPart", 2, "getAudioDuration: invoked. info: duration = " + f2);
    return f2;
  }
  
  public File a()
  {
    String str = this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a();
    if (!TextUtils.isEmpty(str)) {
      return new File(str);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onCreate: ");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131363765));
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView = new BubbleTextView(a());
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setPadding(vzo.a(a(), 10.0F), vzo.a(a(), 10.0F), vzo.a(a(), 10.0F), vzo.a(a(), 10.0F));
    this.jdField_a_of_type_Bjed.a(this);
    if (this.jdField_a_of_type_Boolean)
    {
      bdid.a().a(ajyc.a(2131703693));
      this.jdField_b_of_type_Bfnk = new bfnk(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_b_of_type_Bfnk.sendEmptyMessage(110);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onActivityResult: invoked. info: requestCode = " + paramInt1 + " resultCode = " + paramInt2 + "data = " + paramIntent);
    }
    if ((paramInt1 == 131) && (paramInt2 == -1) && (paramIntent != null)) {
      this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjun.d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    k();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    Message localMessage = this.jdField_a_of_type_Bfnk.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramMusicItemInfo;
    this.jdField_a_of_type_Bfnk.sendMessage(localMessage);
    if (paramMusicItemInfo != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    bdid.a().a(ajyc.a(2131703696) + paramMusicItemInfo);
  }
  
  public void aV_()
  {
    super.aV_();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onStop: mIsFinishRecognition = " + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void aZ_()
  {
    super.aZ_();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onPause: ");
    }
    this.jdField_a_of_type_Bjdm.d();
  }
  
  void c()
  {
    bbgg localbbgg = bbcv.a((Activity)a(), 2131698321);
    localbbgg.setNegativeButton(2131690596, new bjts(this));
    localbbgg.setPositiveButton(2131694793, new bjtt(this));
    localbbgg.show();
  }
  
  public void f()
  {
    super.f();
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onDestroy: ");
    }
    this.jdField_a_of_type_Bjed.b(this);
    if (this.jdField_b_of_type_Bfnk != null) {
      this.jdField_b_of_type_Bfnk.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Bjde = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return false;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((MusicItemInfo)paramMessage.obj);
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: no match. mHumMusicItemInfo = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mType == 7));
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setOnClickListener(new bjtp(this));
      j();
      this.jdField_b_of_type_Boolean = true;
      return false;
    }
    d();
    this.jdField_a_of_type_Bjdm.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjun.d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjto
 * JD-Core Version:    0.7.0.1
 */