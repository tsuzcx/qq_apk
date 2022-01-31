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

public class bicr
  extends bifz
  implements Handler.Callback, bhiw
{
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new bicu(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private befq jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
  private bhim jdField_a_of_type_Bhim = new bict(this);
  private bhiu jdField_a_of_type_Bhiu = (bhiu)bhfm.a().c(8);
  private bhji jdField_a_of_type_Bhji;
  private bhjl jdField_a_of_type_Bhjl = (bhjl)bhfm.a().c(10);
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private BubbleTextView jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView;
  public boolean a;
  private befq jdField_b_of_type_Befq;
  private boolean jdField_b_of_type_Boolean;
  
  public bicr(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    ((QIMMusicConfigManager)bhfm.a().c(2)).a(paramMusicItemInfo, true);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bigb.a(Message.obtain(null, 3, 1, 0));
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "popupRecognitionBubble: invoked. info: mHumMusicItemInfo = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    Object localObject = ajjy.a(2131637906) + System.getProperty("line.separator") + bhix.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.a();
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.measure(0, 0);
    int i = this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.getMeasuredWidth() / 2;
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131298212);
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
    if (this.jdField_a_of_type_Bhiu.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      d();
      this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bigb.c());
      this.jdField_a_of_type_Bigb.jdField_a_of_type_Bidq.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setVisibility(8);
      k();
      this.jdField_a_of_type_Bhjl.b(this);
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mHasCopyright)
      {
        String str = ajjy.a(2131637910) + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName + ajjy.a(2131637909);
        bbmy.a(a(), 0, str, 0).a();
        if (QLog.isColorLevel()) {
          QLog.d("EditRecognitionPart", 2, "url:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl + " playable:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mHasCopyright);
        }
      }
      else
      {
        this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bhim);
      }
    }
  }
  
  public float a()
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a();
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
    String str = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a();
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131298210));
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView = new BubbleTextView(a());
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setPadding(vms.a(a(), 10.0F), vms.a(a(), 10.0F), vms.a(a(), 10.0F), vms.a(a(), 10.0F));
    this.jdField_a_of_type_Bhjl.a(this);
    if (this.jdField_a_of_type_Boolean)
    {
      bcec.a().a(ajjy.a(2131637908));
      this.jdField_b_of_type_Befq = new befq(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_b_of_type_Befq.sendEmptyMessage(110);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onActivityResult: invoked. info: requestCode = " + paramInt1 + " resultCode = " + paramInt2 + "data = " + paramIntent);
    }
    if ((paramInt1 == 131) && (paramInt2 == -1) && (paramIntent != null)) {
      this.jdField_a_of_type_Bigb.jdField_a_of_type_Bidq.d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    k();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    Message localMessage = this.jdField_a_of_type_Befq.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramMusicItemInfo;
    this.jdField_a_of_type_Befq.sendMessage(localMessage);
    if (paramMusicItemInfo != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    bcec.a().a(ajjy.a(2131637911) + paramMusicItemInfo);
  }
  
  public void bb_()
  {
    super.bb_();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onStop: mIsFinishRecognition = " + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void bf_()
  {
    super.bf_();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onPause: ");
    }
    this.jdField_a_of_type_Bhiu.d();
  }
  
  void c()
  {
    bafb localbafb = babr.a((Activity)a(), 2131632585);
    localbafb.setNegativeButton(2131625035, new bicv(this));
    localbafb.setPositiveButton(2131629116, new bicw(this));
    localbafb.show();
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
    this.jdField_a_of_type_Bhjl.b(this);
    if (this.jdField_b_of_type_Befq != null) {
      this.jdField_b_of_type_Befq.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Bhim = null;
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
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setOnClickListener(new bics(this));
      j();
      this.jdField_b_of_type_Boolean = true;
      return false;
    }
    d();
    this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    this.jdField_a_of_type_Bigb.jdField_a_of_type_Bidq.d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bicr
 * JD-Core Version:    0.7.0.1
 */