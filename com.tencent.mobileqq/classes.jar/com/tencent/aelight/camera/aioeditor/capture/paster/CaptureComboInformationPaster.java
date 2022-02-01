package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.InformationPasterChangeListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

public class CaptureComboInformationPaster
  extends CaptureComboBase
  implements InformationFacePackage.InformationPasterChangeListener, IEventReceiver
{
  public static HashMap<String, Drawable> a;
  private float jdField_a_of_type_Float;
  private CaptureComboInformationPaster.DownloadProgressCallback jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterCaptureComboInformationPaster$DownloadProgressCallback;
  private QIMInformationPasterManager jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterQIMInformationPasterManager;
  private InformationFacePackage.Item jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item;
  InformationFacePackage jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage;
  private final String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private String jdField_b_of_type_JavaLangString;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = 2;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public CaptureComboInformationPaster(InformationFacePackage paramInformationFacePackage, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage = paramInformationFacePackage;
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat2;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterQIMInformationPasterManager = ((QIMInformationPasterManager)QIMManager.a().c(12));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.a(paramString3);
    this.jdField_c_of_type_JavaLangString = paramString1;
    paramInformationFacePackage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item;
    if (paramInformationFacePackage != null)
    {
      paramInformationFacePackage.a(this);
      paramInformationFacePackage = new StringBuilder();
      paramInformationFacePackage.append("CaptureComboInformationPaster_");
      paramInformationFacePackage.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item.jdField_b_of_type_JavaLangString);
      paramInformationFacePackage.append("_");
      paramInformationFacePackage.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item.jdField_a_of_type_JavaLangString);
      this.d = paramInformationFacePackage.toString();
    }
    if (QLog.isColorLevel())
    {
      paramInformationFacePackage = new StringBuilder();
      paramInformationFacePackage.append("package id=");
      paramInformationFacePackage.append(paramString2);
      paramInformationFacePackage.append(" posterId=");
      paramInformationFacePackage.append(paramString3);
      QLog.d("CaptureComboInformationPaster", 2, paramInformationFacePackage.toString());
    }
  }
  
  private void a(Drawable paramDrawable, String paramString, int paramInt, IFaceSelectedListener paramIFaceSelectedListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyApngInfoPaster w=");
      localStringBuilder.append(paramDrawable.getIntrinsicWidth());
      localStringBuilder.append(" px=");
      localStringBuilder.append(this.jdField_b_of_type_Float);
      localStringBuilder.append(" py=");
      localStringBuilder.append(this.jdField_c_of_type_Float);
      localStringBuilder.append(" scale=");
      localStringBuilder.append(this.jdField_a_of_type_Float);
      QLog.d("CaptureComboInformationPaster", 2, localStringBuilder.toString());
    }
    paramDrawable = new SelectedItem(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_b_of_type_JavaLangString, this.d, paramDrawable, paramInt);
    paramInt = ScreenUtil.SCREEN_WIDTH;
    int i = ScreenUtil.SCREEN_HIGHT;
    paramIFaceSelectedListener.b(paramDrawable, paramInt * this.jdField_b_of_type_Float, i * this.jdField_c_of_type_Float, this.jdField_a_of_type_Float, paramString, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
  
  private void a(InformationFacePackage.Item paramItem, IFaceSelectedListener paramIFaceSelectedListener)
  {
    Object localObject1 = InfoStickerSaveUtils.b(paramItem);
    int i;
    if (paramItem.jdField_a_of_type_Int == 8)
    {
      int j = Calendar.getInstance().get(7) - 1;
      i = j;
      if (j == 0) {
        i = 7;
      }
      paramItem = new StringBuilder();
      paramItem.append((String)localObject1);
      paramItem.append(File.separator);
      paramItem.append(i);
      paramItem.append(".apng");
      paramItem = paramItem.toString();
    }
    else
    {
      paramItem = new StringBuilder();
      paramItem.append((String)localObject1);
      paramItem.append(File.separator);
      paramItem.append("city");
      paramItem.append(".apng");
      paramItem = paramItem.toString();
    }
    Object localObject3 = null;
    localObject1 = new File(paramItem);
    try
    {
      if (!ApngDrawable.isApngFile((File)localObject1))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("applyNormalPaster isApngFile not valid path=");
          ((StringBuilder)localObject1).append(paramItem);
          QLog.d("CaptureComboInformationPaster", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      URLDrawable localURLDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramItem, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      Object localObject2 = localObject3;
      if (localURLDrawable != null)
      {
        i = localURLDrawable.getStatus();
        if (i != 1)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("urlDrawable is not  SUCCESSED :");
            ((StringBuilder)localObject2).append(i);
            QLog.e("CaptureComboInformationPaster", 2, ((StringBuilder)localObject2).toString());
          }
          localURLDrawable.setURLDrawableListener(new CaptureComboInformationPaster.2(this, paramItem, localURLDrawable, paramIFaceSelectedListener));
          jdField_a_of_type_JavaUtilHashMap.put(paramItem, localURLDrawable);
          if (i == 2)
          {
            localURLDrawable.restartDownload();
            localObject2 = localObject3;
          }
          else
          {
            localURLDrawable.startDownload();
            localObject2 = localObject3;
          }
        }
        else
        {
          localObject2 = localURLDrawable;
        }
      }
      if (localObject2 != null)
      {
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        a((Drawable)localObject2, paramItem, 1, paramIFaceSelectedListener);
        return;
      }
      paramItem = new StringBuilder();
      paramItem.append("can not create drawable from name:");
      paramItem.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_b_of_type_JavaLangString);
      SLog.e("CaptureComboInformationPaster", paramItem.toString());
    }
  }
  
  private void a(DoodleLayout paramDoodleLayout, IFaceSelectedListener paramIFaceSelectedListener)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item.jdField_a_of_type_Int == 8)
    {
      if (paramDoodleLayout != null) {
        ThreadManager.excute(new CaptureComboInformationPaster.1(this, paramIFaceSelectedListener), 16, null, true);
      }
    }
    else
    {
      int i = ScreenUtil.SCREEN_WIDTH;
      int j = ScreenUtil.SCREEN_HIGHT;
      paramIFaceSelectedListener.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item, this.d, i * this.jdField_b_of_type_Float, j * this.jdField_c_of_type_Float, this.jdField_a_of_type_Float);
    }
  }
  
  public float a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterCaptureComboInformationPaster$DownloadProgressCallback != null)
      {
        float f = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterCaptureComboInformationPaster$DownloadProgressCallback.a();
        return f;
      }
      return 1.0F;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item != null) {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterQIMInformationPasterManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item)) {
          this.jdField_c_of_type_Int = 3;
        } else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterQIMInformationPasterManager.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item)) {
          this.jdField_c_of_type_Int = 1;
        } else {
          this.jdField_c_of_type_Int = 2;
        }
      }
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = DoodleLayoutConnector.a().a(paramInt);
    if ((paramActivity != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item != null))
    {
      IFaceSelectedListener localIFaceSelectedListener = paramActivity.a();
      if (localIFaceSelectedListener != null)
      {
        a(paramActivity, localIFaceSelectedListener);
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("apply id=");
          paramActivity.append(this.jdField_a_of_type_JavaLangString);
          paramActivity.append(" name=");
          paramActivity.append(this.jdField_b_of_type_JavaLangString);
          paramActivity.append(" state=");
          paramActivity.append(this.jdField_c_of_type_Int);
          QLog.d("CaptureComboInformationPaster", 2, paramActivity.toString());
        }
      }
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = 2;
    super.a(paramInt);
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item != null)
    {
      paramActivity = DoodleLayoutConnector.a().a(paramInt);
      if (paramActivity != null) {
        paramActivity.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage.jdField_b_of_type_JavaLangString, this.d);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("unApply no item =");
      paramActivity.append(this.jdField_b_of_type_JavaLangString);
      QLog.d("CaptureComboInformationPaster", 2, paramActivity.toString());
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("unApply id=");
      paramActivity.append(this.jdField_a_of_type_JavaLangString);
      paramActivity.append(" name=");
      paramActivity.append(this.jdField_b_of_type_JavaLangString);
      paramActivity.append(" state=");
      paramActivity.append(this.jdField_c_of_type_Int);
      QLog.d("CaptureComboInformationPaster", 2, paramActivity.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(0);
    }
  }
  
  public int b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item != null)
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterCaptureComboInformationPaster$DownloadProgressCallback == null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterCaptureComboInformationPaster$DownloadProgressCallback = new CaptureComboInformationPaster.DownloadProgressCallback(this);
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterQIMInformationPasterManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterCaptureComboInformationPaster$DownloadProgressCallback);
        a();
        this.jdField_c_of_type_Int = 1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("create mState=");
          localStringBuilder.append(this.jdField_c_of_type_Int);
          localStringBuilder.append(" id=");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          QLog.d("CaptureComboInformationPaster", 2, localStringBuilder.toString());
        }
      }
      else
      {
        a(4);
      }
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item;
    if (localObject != null)
    {
      if (((InformationFacePackage.Item)localObject).jdField_a_of_type_Int != 7) {
        return;
      }
      localObject = (CaptureComboManager)QIMManager.a(5);
      ComboSet localComboSet = ((CaptureComboManager)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localComboSet != null)
      {
        localComboSet.a();
        ((CaptureComboManager)localObject).a(localComboSet);
      }
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Int == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NP@");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboInformationPaster
 * JD-Core Version:    0.7.0.1
 */