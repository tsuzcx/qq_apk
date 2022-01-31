package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.OnGetSink;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import jsn;
import jso;
import mqq.app.MobileQQ;

public abstract class BaseInviteFloatBarUICtr
{
  public static int a;
  public long a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  public SessionInfo a;
  public VideoAppInterface a;
  BaseGaInvite.GetGaFaceRunnable.OnGetSink jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink = new jsn(this);
  BaseGaInvite.GetGaFaceRunnable jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
  public VideoInviteFloatBar a;
  Runnable jdField_a_of_type_JavaLangRunnable = new jso(this);
  public final String a;
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong = null;
  public int b;
  public long b;
  public String b;
  int c;
  public String c;
  public String d = null;
  
  static
  {
    jdField_a_of_type_Int = 6000;
  }
  
  public BaseInviteFloatBarUICtr()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.a());
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy");
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable != null) {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar = null;
    }
    b();
  }
  
  public void a(String paramString)
  {
    String str = String.valueOf(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {}
    for (TextView localTextView = this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a();; localTextView = null)
    {
      this.jdField_b_of_type_JavaLangString = BaseGaInvite.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localTextView, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, str, this.jdField_a_of_type_ArrayOfLong);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, str, null, true, false);
      if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable == null) {
        this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = new BaseGaInvite.GetGaFaceRunnable(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink);
      }
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a(paramString);
      return;
    }
  }
  
  boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshUI, isMultiCall[" + a(this.jdField_b_of_type_Int) + "], mUinType[" + this.jdField_b_of_type_Int + "], mIsAudioMode[" + this.jdField_a_of_type_Boolean + "]");
    }
    String str = this.jdField_c_of_type_JavaLangString;
    int k = this.jdField_b_of_type_Int;
    int j;
    Object localObject;
    if (a(this.jdField_b_of_type_Int))
    {
      j = 3;
      a("refreshUI");
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar == null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar = new VideoInviteFloatBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_JavaLangString);
        localObject = new Date();
        localObject = new SimpleDateFormat("HH:mm").format((Date)localObject);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.b((String)localObject);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(j, false);
        if (a(this.jdField_b_of_type_Int)) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Int);
        }
      }
      localObject = (Vibrator)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getSystemService("vibrator");
      if (localObject != null) {
        ((Vibrator)localObject).vibrate(200L);
      }
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {}
    for (int i = 0;; i = 1)
    {
      j = k;
      localObject = str;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
      {
        j = k;
        localObject = str;
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.A == 1)
        {
          j = k;
          localObject = str;
          if (this.jdField_b_of_type_Int == 9500)
          {
            j = k;
            localObject = str;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvAppSessionInfo.n))
            {
              localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo.n;
              j = 0;
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(j, (String)localObject, this.d, true, true);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(j, (String)localObject, this.d);
      j = i;
      if (this.jdField_b_of_type_Int != 25) {
        break;
      }
      j = i;
      if (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.g;
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 2, "refreshUI mPeerName = " + this.jdField_b_of_type_JavaLangString);
      j = i;
      break;
    }
  }
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.BaseInviteFloatBarUICtr
 * JD-Core Version:    0.7.0.1
 */