package com.tencent.mobileqq.activity.faceunlock;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.FaceunlockBgDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.camera.AECaptureParam;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class QFaceUnlockCameraCaptureUnit
  extends AEPituCameraUnit
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FaceunlockBgDrawable jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QFaceUnlockCameraCaptureUnit.1(this);
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 0;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private View d;
  private View e;
  private int g = 155;
  private int h = 211;
  
  public QFaceUnlockCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
  }
  
  private void A()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131698851);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void B()
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.2(this));
  }
  
  private Camera.Size a(List<Camera.Size> paramList1, List<Camera.Size> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null))
    {
      paramList2 = null;
      return paramList2;
    }
    HashSet localHashSet = new HashSet(paramList1);
    Iterator localIterator = paramList2.iterator();
    paramList1 = null;
    int i = -1;
    for (;;)
    {
      paramList2 = paramList1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList2 = (Camera.Size)localIterator.next();
      if (localHashSet.contains(paramList2))
      {
        int j = paramList2.width * paramList2.height;
        if (j > i)
        {
          i = j;
          paramList1 = paramList2;
        }
      }
    }
  }
  
  private void h(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.3(this, paramBoolean));
  }
  
  private void i(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setPreviewDisplay(null);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnErrorListener(null);
    }
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
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "releaseRecord failed, IllegalStateException: " + localIllegalStateException.getMessage());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "releaseRecord failed, Exception: " + localException.getMessage());
      }
    }
    this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
  }
  
  public int a()
  {
    return 2131558609;
  }
  
  public View a()
  {
    View localView = super.a();
    ((TextView)localView.findViewById(2131364357)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131374382));
    this.e = localView.findViewById(2131365536);
    this.d = localView.findViewById(2131367119);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131364549);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378425));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376835));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366581));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131366578));
    e();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131698851);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_Int = 0;
    int i = AIOUtils.a(this.g, a().getResources());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable = new FaceunlockBgDrawable();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable.a(AIOUtils.a(this.g + this.h, a().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable.a(i);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable.b(1);
    if (Build.VERSION.SDK_INT > 15) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackground(this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      return localView;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetFaceunlockBgDrawable);
    }
  }
  
  public AECaptureParam a()
  {
    AECaptureParam localAECaptureParam = super.a();
    localAECaptureParam.g(1);
    return localAECaptureParam;
  }
  
  public void a() {}
  
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
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getStringExtra("key_face_unlock_code");
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = "6978";
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "verification code is null, use default code");
    }
  }
  
  public void a(boolean paramBoolean) {}
  
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
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityPause");
    }
    h(false);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean b()
  {
    return super.b();
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onDestroy");
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityResume");
    }
  }
  
  public void e()
  {
    A();
    this.d.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void f() {}
  
  public void g() {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364357)
    {
      a().finish();
      a().overridePendingTransition(2130772043, 2130772254);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131374382: 
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131698853);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          B();
        }
        else if (this.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_Int = 2;
          h(true);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */