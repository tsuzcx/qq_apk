package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.AECaptureParam;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.FaceunlockBgDrawable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class QFaceUnlockCameraCaptureUnit
  extends AEPituCameraUnit
  implements View.OnClickListener
{
  private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FaceunlockBgDrawable jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QFaceUnlockCameraCaptureUnit.1(this);
  private Handler jdField_b_of_type_AndroidOsHandler;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private View d;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private int f = 0;
  private int g = 155;
  private int h = 211;
  
  public QFaceUnlockCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
  }
  
  private Camera.Size a(List<Camera.Size> paramList1, List<Camera.Size> paramList2)
  {
    List<Camera.Size> localList = null;
    Object localObject = null;
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return null;
      }
      HashSet localHashSet = new HashSet(paramList1);
      int i = -1;
      Iterator localIterator = paramList2.iterator();
      paramList1 = localObject;
      for (;;)
      {
        localList = paramList1;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList2 = (Camera.Size)localIterator.next();
        if (localHashSet.contains(paramList2))
        {
          int j = paramList2.width * paramList2.height;
          if (j > i)
          {
            paramList1 = paramList2;
            i = j;
          }
        }
      }
    }
    return localList;
  }
  
  private void i(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.3(this, paramBoolean));
  }
  
  private void j(boolean paramBoolean)
  {
    MediaRecorder localMediaRecorder = this.jdField_a_of_type_AndroidMediaMediaRecorder;
    if (localMediaRecorder != null)
    {
      localMediaRecorder.setPreviewDisplay(null);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnErrorListener(null);
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "releaseRecord begin");
        }
        this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
        if (paramBoolean) {
          this.jdField_b_of_type_AndroidOsHandler.post(new QFaceUnlockCameraCaptureUnit.4(this));
        }
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "releaseRecord end");
        }
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("releaseRecord failed, Exception: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, localStringBuilder.toString());
      }
      catch (IllegalStateException localIllegalStateException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("releaseRecord failed, IllegalStateException: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
  }
  
  private void s()
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131698929);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.f = 0;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void t()
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.2(this));
  }
  
  public void C() {}
  
  public void E() {}
  
  public void R()
  {
    s();
    this.d.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected int a()
  {
    return 2064318595;
  }
  
  public View a()
  {
    View localView = super.a();
    ((TextView)localView.findViewById(2064122021)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2064122521));
    this.jdField_e_of_type_AndroidViewView = localView.findViewById(2064122095);
    this.d = localView.findViewById(2064122215);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2064122036);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122637));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2064122542));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122183));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2064122180));
    R();
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131698929);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.f = 0;
    int i = AIOUtils.b(this.g, a().getResources());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable = new FaceunlockBgDrawable();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable.a(AIOUtils.b(this.g + this.h, a().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable.a(i);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable.b(1);
    if (Build.VERSION.SDK_INT > 15) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackground(this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable);
    } else {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    return localView;
  }
  
  protected AECaptureParam a()
  {
    AECaptureParam localAECaptureParam = super.a();
    localAECaptureParam.g(1);
    return localAECaptureParam;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityResult");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    a().getWindow().setFlags(1024, 1024);
    a().requestWindowFeature(1);
    super.a(paramBundle);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getIntent().getStringExtra("key_face_unlock_code");
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = "6978";
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "verification code is null, use default code");
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    QLog.e("QFaceUnlockCameraCaptureUnit", 1, "Camera start fail!");
  }
  
  protected boolean d()
  {
    return false;
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityResume");
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityPause");
    }
    i(false);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onDestroy");
    }
  }
  
  public boolean i()
  {
    return super.i();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2064122021)
    {
      a().finish();
      a().overridePendingTransition(2130772065, 2130772282);
      return;
    }
    super.onClick(paramView);
    if (paramView.getId() != 2064122521) {
      return;
    }
    int i = this.jdField_e_of_type_Int;
    if (i == 0)
    {
      this.jdField_e_of_type_Int = 1;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131698931);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      t();
      return;
    }
    if (i == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_e_of_type_Int = 2;
      i(true);
    }
  }
  
  protected void x() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QFaceUnlockCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */