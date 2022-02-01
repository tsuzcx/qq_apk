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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.humrecognition.BubbleTextView;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import java.io.File;

public class bqdc
  extends bqgi
  implements Handler.Callback, bppb
{
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new bqdf(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private blhq jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
  private bpor jdField_a_of_type_Bpor = new bqde(this);
  private bpoz jdField_a_of_type_Bpoz = (bpoz)bplq.a().c(8);
  private bppn jdField_a_of_type_Bppn;
  private bppq jdField_a_of_type_Bppq = (bppq)bplq.a().c(10);
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private BubbleTextView jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView;
  public boolean a;
  private blhq jdField_b_of_type_Blhq;
  private boolean jdField_b_of_type_Boolean;
  
  public bqdc(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    ((QIMMusicConfigManager)bplq.a().c(2)).a(paramMusicItemInfo, true);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bqgk.a(Message.obtain(null, 3, 1, 0));
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "popupRecognitionBubble: invoked. info: mHumMusicItemInfo = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    Object localObject = anzj.a(2131702590) + System.getProperty("line.separator") + bppc.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.a();
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.measure(0, 0);
    int i = this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.getMeasuredWidth() / 2;
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131364056);
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
    if (this.jdField_a_of_type_Bpoz.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      d();
      this.jdField_a_of_type_Bpoz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bqgk.c());
      this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeb.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setVisibility(8);
      k();
      this.jdField_a_of_type_Bppq.b(this);
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mHasCopyright)
      {
        String str = anzj.a(2131702594) + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName + anzj.a(2131702593);
        QQToast.a(a(), 0, str, 0).a();
        if (QLog.isColorLevel()) {
          QLog.d("EditRecognitionPart", 2, "url:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl + " playable:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mHasCopyright);
        }
      }
      else
      {
        this.jdField_a_of_type_Bpoz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bpor);
      }
    }
  }
  
  public float a()
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a();
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
    String str = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a();
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364054));
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView = new BubbleTextView(a());
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setPadding(zps.a(a(), 10.0F), zps.a(a(), 10.0F), zps.a(a(), 10.0F), zps.a(a(), 10.0F));
    this.jdField_a_of_type_Bppq.a(this);
    if (this.jdField_a_of_type_Boolean)
    {
      bjuh.a().a(anzj.a(2131702592));
      this.jdField_b_of_type_Blhq = new blhq(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_b_of_type_Blhq.sendEmptyMessage(110);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onActivityResult: invoked. info: requestCode = " + paramInt1 + " resultCode = " + paramInt2 + "data = " + paramIntent);
    }
    if ((paramInt1 == 131) && (paramInt2 == -1) && (paramIntent != null)) {
      this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeb.d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    k();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    Message localMessage = this.jdField_a_of_type_Blhq.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramMusicItemInfo;
    this.jdField_a_of_type_Blhq.sendMessage(localMessage);
    if (paramMusicItemInfo != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    bjuh.a().a(anzj.a(2131702595) + paramMusicItemInfo);
  }
  
  public void aU_()
  {
    super.aU_();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onStop: mIsFinishRecognition = " + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void aY_()
  {
    super.aY_();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onPause: ");
    }
    this.jdField_a_of_type_Bpoz.d();
  }
  
  void c()
  {
    bhpc localbhpc = bhlq.a((Activity)a(), 2131697602);
    localbhpc.setNegativeButton(2131690580, new bqdg(this));
    localbhpc.setPositiveButton(2131694098, new bqdh(this));
    localbhpc.show();
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
    this.jdField_a_of_type_Bppq.b(this);
    if (this.jdField_b_of_type_Blhq != null) {
      this.jdField_b_of_type_Blhq.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Bpor = null;
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
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setOnClickListener(new bqdd(this));
      j();
      this.jdField_b_of_type_Boolean = true;
      return false;
    }
    d();
    this.jdField_a_of_type_Bpoz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeb.d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqdc
 * JD-Core Version:    0.7.0.1
 */