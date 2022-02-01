package com.tencent.aelight.camera.aioeditor.capture.text;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.LayerParams;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class CaptureComboText
  extends CaptureComboBase
{
  private float jdField_a_of_type_Float;
  private DynamicTextConfigManager.DynamicTextConfigBean jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean;
  private DynamicTextConfigManager.IDynamicTextResDownloadCallback jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$IDynamicTextResDownloadCallback = new CaptureComboText.2(this);
  private DynamicTextConfigManager jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private float b;
  private float jdField_c_of_type_Float;
  private volatile int jdField_c_of_type_Int = 2;
  private volatile float d;
  
  public CaptureComboText(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)QIMManager.a(7));
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("CaptureComboText id is: ");
      paramList.append(paramString);
      QLog.i("QComboDText", 2, paramList.toString());
    }
  }
  
  public float a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CaptureComboText getProgress, progress is: ");
      localStringBuilder.append(this.d);
      QLog.i("QComboDText", 2, localStringBuilder.toString());
    }
    return this.d * 0.01F;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.c();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_JavaLangString);
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean;
    int i;
    if (localObject == null) {
      i = 2;
    } else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) && (this.jdField_c_of_type_Int == 2)) {
      i = 3;
    } else {
      i = this.jdField_c_of_type_Int;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CaptureComboText getState, state is: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" id is: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("QComboDText", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QComboDText", 2, "apply ComboText");
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean;
    if (localObject != null)
    {
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) {
        return 0;
      }
      if (paramActivity != null)
      {
        localObject = DoodleLayoutConnector.a().a(paramInt);
        if ((localObject != null) && (((DoodleLayout)localObject).a() != null))
        {
          ((DoodleLayout)localObject).a().a(4);
          DynamicTextItem localDynamicTextItem = new DynamicTextBuilder().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), this.jdField_a_of_type_JavaUtilList);
          if (localDynamicTextItem != null)
          {
            float f = ScreenUtil.SCREEN_WIDTH * this.jdField_c_of_type_Float / localDynamicTextItem.a();
            TextLayer.LayerParams localLayerParams = new TextLayer.LayerParams(this.jdField_a_of_type_Float * ScreenUtil.SCREEN_WIDTH, this.b * ScreenUtil.SCREEN_WIDTH, f, 0.0F, 0.0F, 0.0F, localDynamicTextItem.a(), localDynamicTextItem.b());
            if (((DoodleLayout)localObject).a().a(localLayerParams, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper, ((DoodleLayout)localObject).d()) != null)
            {
              localDynamicTextItem.a(true);
              ((DoodleLayout)localObject).a().b(localDynamicTextItem);
              ((DoodleLayout)localObject).a().k();
              return 0;
            }
            QQToast.a(paramActivity, paramActivity.getString(2131698367), 0).a();
            ThreadManager.getUIHandler().post(new CaptureComboText.1(this, (DoodleLayout)localObject));
          }
        }
      }
    }
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null)
    {
      paramActivity = DoodleLayoutConnector.a().a(paramInt);
      if ((paramActivity != null) && (paramActivity.a() != null))
      {
        paramActivity.a().a(4);
        paramActivity.a().g();
        paramActivity.a().k();
      }
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CaptureComboText download, state is: ");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      QLog.i("QComboDText", 2, localStringBuilder.toString());
    }
    if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 3))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.c();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QComboDText", 2, "CaptureComboText download, bean is null.");
        }
        this.jdField_c_of_type_Int = 2;
        return 2;
      }
      a();
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QComboDText", 2, "startDownload dynamicText is usable.");
        }
        b();
        this.jdField_c_of_type_Int = 3;
        return 2;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$IDynamicTextResDownloadCallback);
      this.jdField_c_of_type_Int = 1;
      return 1;
    }
    return this.jdField_c_of_type_Int;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Text@");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray()));
    localStringBuilder.append("@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.CaptureComboText
 * JD-Core Version:    0.7.0.1
 */