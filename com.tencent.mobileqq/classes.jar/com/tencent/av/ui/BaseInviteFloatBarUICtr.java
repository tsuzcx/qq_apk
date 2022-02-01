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
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseInviteFloatBarUICtr
{
  public static int a = 6000;
  long jdField_a_of_type_Long = 0L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  BaseGaInvite.GetGaFaceRunnable.OnGetSink jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink = new BaseInviteFloatBarUICtr.1(this);
  BaseGaInvite.GetGaFaceRunnable jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
  VideoInviteFloatBar jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar;
  Runnable jdField_a_of_type_JavaLangRunnable = new BaseInviteFloatBarUICtr.2(this);
  final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong = null;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = null;
  String d = null;
  
  public BaseInviteFloatBarUICtr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy");
    Object localObject = this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable;
    if (localObject != null) {
      ((BaseGaInvite.GetGaFaceRunnable)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar;
    if (localObject != null)
    {
      ((VideoInviteFloatBar)localObject).a();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar = null;
    }
    b();
  }
  
  public void a(String paramString)
  {
    String str = String.valueOf(this.jdField_a_of_type_Long);
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar;
    if (localObject != null) {
      localObject = ((VideoInviteFloatBar)localObject).a();
    } else {
      localObject = null;
    }
    this.jdField_b_of_type_JavaLangString = BaseGaInvite.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (TextView)localObject, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, str, this.jdField_a_of_type_ArrayOfLong);
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, str, null, true, false);
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable == null) {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = new BaseGaInvite.GetGaFaceRunnable(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink);
    }
    this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a(paramString);
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshUI, isMultiCall[");
      ((StringBuilder)localObject2).append(AVUtil.b(this.jdField_b_of_type_Int));
      ((StringBuilder)localObject2).append("], multiIncomingCall[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], mUinType[");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject2).append("], mIsAudioMode[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    int j = this.jdField_b_of_type_Int;
    if (AVUtil.b(j))
    {
      a("refreshUI");
    }
    else
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      localObject1 = localObject2;
      int i = j;
      if (localSessionInfo != null)
      {
        localObject1 = localObject2;
        i = j;
        if (localSessionInfo.A == 1)
        {
          localObject1 = localObject2;
          i = j;
          if (this.jdField_b_of_type_Int == 9500)
          {
            localObject1 = localObject2;
            i = j;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvAppSessionInfo.o))
            {
              localObject1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.o;
              i = 0;
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject1, this.d, true, true);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject1, this.d);
      if ((this.jdField_b_of_type_Int == 25) && (this.jdField_b_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
        if (localObject1 != null) {
          this.jdField_b_of_type_JavaLangString = ((SessionInfo)localObject1).g;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("refreshUI mPeerName = ");
          ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar == null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar = new VideoInviteFloatBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_JavaLangString);
      localObject1 = new Date();
      localObject1 = new SimpleDateFormat("HH:mm").format((Date)localObject1);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.b((String)localObject1);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(this.jdField_a_of_type_Boolean, AVUtil.b(this.jdField_b_of_type_Int), paramBoolean);
      if (AVUtil.b(this.jdField_b_of_type_Int)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Int);
      }
    }
    VibratorCompactUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), 200L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.BaseInviteFloatBarUICtr
 * JD-Core Version:    0.7.0.1
 */