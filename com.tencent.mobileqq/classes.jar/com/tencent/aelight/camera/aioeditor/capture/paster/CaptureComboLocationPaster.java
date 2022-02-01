package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;

public class CaptureComboLocationPaster
  extends CaptureComboBase
  implements URLDrawable.URLDrawableListener
{
  private final float jdField_a_of_type_Float;
  LocationFacePackage jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  String jdField_a_of_type_JavaLangString;
  private final float jdField_b_of_type_Float;
  private final String jdField_b_of_type_JavaLangString;
  private final float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = 0;
  int d = 2;
  
  public CaptureComboLocationPaster(LocationFacePackage paramLocationFacePackage, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage = paramLocationFacePackage;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    if (QLog.isColorLevel())
    {
      paramLocationFacePackage = new StringBuilder();
      paramLocationFacePackage.append("create id=");
      paramLocationFacePackage.append(paramString1);
      paramLocationFacePackage.append(" name=");
      paramLocationFacePackage.append(paramString2);
      QLog.d("QCombo.LPaster", 2, paramLocationFacePackage.toString());
    }
  }
  
  private URLDrawable a()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
    LocationFacePackage.Item localItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.a(this.jdField_a_of_type_JavaLangString);
    if (localItem != null) {
      return URLDrawable.getDrawable(localItem.d, (URLDrawable.URLDrawableOptions)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createUrlDrawable no item =");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("QCombo.LPaster", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public float a()
  {
    return 1.0F;
  }
  
  public int a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = a();
      }
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        if (this.d != 3)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.a(this.jdField_a_of_type_JavaLangString);
          if (localObject1 != null)
          {
            if (AbsDownloader.getFile(((LocationFacePackage.Item)localObject1).d) == null)
            {
              this.d = 2;
            }
            else
            {
              this.d = 3;
              this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getState no item =");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
            QLog.d("QCombo.LPaster", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      else {
        this.d = 2;
      }
      int i = this.d;
      return i;
    }
    finally {}
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = DoodleLayoutConnector.a().a(paramInt);
    if (paramActivity != null)
    {
      a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage, this.jdField_a_of_type_JavaLangString, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, paramActivity.a());
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("apply id=");
        paramActivity.append(this.jdField_b_of_type_JavaLangString);
        paramActivity.append(" name=");
        paramActivity.append(this.jdField_a_of_type_JavaLangString);
        paramActivity.append(" state=");
        paramActivity.append(this.d);
        QLog.d("QCombo.LPaster", 2, paramActivity.toString());
      }
    }
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    paramActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.a(this.jdField_a_of_type_JavaLangString);
    if (paramActivity != null)
    {
      DoodleLayout localDoodleLayout = DoodleLayoutConnector.a().a(paramInt);
      if (localDoodleLayout != null) {
        localDoodleLayout.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.jdField_b_of_type_JavaLangString, paramActivity.c);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("unApply no item =");
      paramActivity.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("QCombo.LPaster", 2, paramActivity.toString());
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("apply id=");
      paramActivity.append(this.jdField_b_of_type_JavaLangString);
      paramActivity.append(" name=");
      paramActivity.append(this.jdField_a_of_type_JavaLangString);
      paramActivity.append(" state=");
      paramActivity.append(this.d);
      QLog.d("QCombo.LPaster", 2, paramActivity.toString());
    }
  }
  
  public void a(LocationFacePackage paramLocationFacePackage, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, IFaceSelectedListener paramIFaceSelectedListener)
  {
    if (paramIFaceSelectedListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "try apply but no listener");
      }
      return;
    }
    paramLocationFacePackage = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (paramLocationFacePackage != null)
    {
      paramLocationFacePackage.setBounds(0, 0, paramLocationFacePackage.getIntrinsicWidth(), paramLocationFacePackage.getIntrinsicHeight());
      paramString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage.a(this.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        paramString.a = paramLocationFacePackage;
        paramIFaceSelectedListener.a(paramString, paramInt1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramLocationFacePackage = new StringBuilder();
        paramLocationFacePackage.append("applyLocationPaster no item =");
        paramLocationFacePackage.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("QCombo.LPaster", 2, paramLocationFacePackage.toString());
      }
    }
    else
    {
      paramLocationFacePackage = new StringBuilder();
      paramLocationFacePackage.append("can create drawable from urldrawable:");
      paramLocationFacePackage.append(this.jdField_a_of_type_ComTencentImageURLDrawable);
      SLog.e("QCombo.LPaster", paramLocationFacePackage.toString());
    }
  }
  
  public int b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = a();
      }
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
        {
          this.d = 3;
          this.jdField_c_of_type_Int = 100;
        }
        else
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
          this.d = 1;
          this.jdField_c_of_type_Int = 0;
          a();
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("download id=");
          localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
          localStringBuilder.append(" name=");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(" dstate=");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
          QLog.d("QCombo.LPaster", 2, localStringBuilder.toString());
        }
      }
      int i = this.d;
      return i;
    }
    finally {}
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_c_of_type_Int = 0;
    this.d = 2;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_c_of_type_Int = 0;
    this.d = 2;
    a(4);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.d = 1;
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_c_of_type_Int = 100;
    this.d = 3;
    b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LP@");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("@");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboLocationPaster
 * JD-Core Version:    0.7.0.1
 */