package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.compat.VibratorCompactUtil;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.OnGetSink;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseInviteFloatBarUICtr
{
  public static int a;
  long jdField_a_of_type_Long = 0L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  BaseGaInvite.GetGaFaceRunnable.OnGetSink jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink = new BaseInviteFloatBarUICtr.1(this);
  BaseGaInvite.GetGaFaceRunnable jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
  VideoInviteFloatBar jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar;
  Runnable jdField_a_of_type_JavaLangRunnable = new BaseInviteFloatBarUICtr.2(this);
  final String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "_" + AudioHelper.b();
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong = null;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = null;
  String d = null;
  
  static
  {
    jdField_a_of_type_Int = 6000;
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
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshUI, isMultiCall[" + AVUtil.b(this.jdField_b_of_type_Int) + "], multiIncomingCall[" + paramBoolean + "], mUinType[" + this.jdField_b_of_type_Int + "], mIsAudioMode[" + this.jdField_a_of_type_Boolean + "]");
    }
    String str = this.jdField_c_of_type_JavaLangString;
    int j = this.jdField_b_of_type_Int;
    if (AVUtil.b(this.jdField_b_of_type_Int)) {
      a("refreshUI");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar == null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar = new VideoInviteFloatBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_JavaLangString);
        localObject = new Date();
        localObject = new SimpleDateFormat("HH:mm").format((Date)localObject);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.b((String)localObject);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(this.jdField_a_of_type_Boolean, AVUtil.b(this.jdField_b_of_type_Int), paramBoolean);
        if (AVUtil.b(this.jdField_b_of_type_Int)) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Int);
        }
      }
      VibratorCompactUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), 200L);
      return;
      int i = j;
      Object localObject = str;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
      {
        i = j;
        localObject = str;
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.A == 1)
        {
          i = j;
          localObject = str;
          if (this.jdField_b_of_type_Int == 9500)
          {
            i = j;
            localObject = str;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvAppSessionInfo.p))
            {
              localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo.p;
              i = 0;
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject, this.d, true, true);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject, this.d);
      if ((this.jdField_b_of_type_Int == 25) && (this.jdField_b_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
      {
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.a();
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "refreshUI mPeerName = " + this.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.BaseInviteFloatBarUICtr
 * JD-Core Version:    0.7.0.1
 */