package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CaptureComboNormalPaster
  extends CaptureComboBase
  implements IEventReceiver
{
  public static HashMap<String, Drawable> a;
  private float jdField_a_of_type_Float;
  private CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterCaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver;
  NormalFacePackage jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage;
  private final String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private String jdField_b_of_type_JavaLangString;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = 2;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public CaptureComboNormalPaster(NormalFacePackage paramNormalFacePackage, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage = paramNormalFacePackage;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    if (QLog.isColorLevel())
    {
      paramNormalFacePackage = new StringBuilder();
      paramNormalFacePackage.append("create id=");
      paramNormalFacePackage.append(paramString1);
      paramNormalFacePackage.append(" name=");
      paramNormalFacePackage.append(paramString2);
      QLog.d("QComboNPaster", 2, paramNormalFacePackage.toString());
    }
  }
  
  private static Drawable a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    new File(paramString).getName();
    URLDrawable localURLDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
    if (localURLDrawable != null)
    {
      int i = localURLDrawable.getStatus();
      if (i != 1)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("urlDrawable is not  SUCCESSED :");
          localStringBuilder.append(i);
          QLog.e("QComboNPaster", 2, localStringBuilder.toString());
        }
        localURLDrawable.setURLDrawableListener(paramURLDrawableListener);
        if (i == 2) {
          localURLDrawable.restartDownload();
        } else {
          localURLDrawable.startDownload();
        }
        jdField_a_of_type_JavaUtilHashMap.put(paramString, localURLDrawable);
      }
      else
      {
        return localURLDrawable;
      }
    }
    return null;
  }
  
  public static void a(NormalFacePackage paramNormalFacePackage, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, IFaceSelectedListener paramIFaceSelectedListener)
  {
    int i;
    if (paramIFaceSelectedListener != null)
    {
      i = paramNormalFacePackage.a(paramString);
      paramString = paramNormalFacePackage.a(paramString);
      if (!TextUtils.isEmpty(paramString)) {}
    }
    try
    {
      FileUtils.d(paramNormalFacePackage.g);
      label33:
      if (QLog.isColorLevel()) {
        QLog.e("QComboNPaster", 2, "applyNormalPaster uriString error!");
      }
      return;
      paramString = Uri.parse(paramString).getPath();
      String str = new File(paramString).getName();
      CaptureComboNormalPaster.2 local2 = new CaptureComboNormalPaster.2(str, paramString, paramNormalFacePackage, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramIFaceSelectedListener, i);
      if (i != 1) {
        try
        {
          b(Drawable.createFromPath(paramString), str, paramString, paramNormalFacePackage, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramIFaceSelectedListener, i);
          return;
        }
        catch (OutOfMemoryError paramNormalFacePackage)
        {
          SLog.c("QComboNPaster", "createFromPath error", paramNormalFacePackage);
          return;
        }
      }
      Object localObject = new File(paramString);
      try
      {
        if (!ApngDrawable.isApngFile((File)localObject))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("applyNormalPaster isApngFile not valid path=");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("QComboNPaster", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        b(a(paramString, local2), str, paramString, paramNormalFacePackage, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramIFaceSelectedListener, i);
        return;
      }
      throw new IllegalStateException("applyNormalPaster listener is null!");
    }
    catch (Exception paramNormalFacePackage)
    {
      break label33;
    }
  }
  
  private static void b(Drawable paramDrawable, String paramString1, String paramString2, NormalFacePackage paramNormalFacePackage, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, IFaceSelectedListener paramIFaceSelectedListener, int paramInt3)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      int i = paramDrawable.getIntrinsicWidth();
      float f = paramInt1;
      paramFloat3 = f * paramFloat3 / i;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("applyNormalPaster w=");
        localStringBuilder.append(i);
        localStringBuilder.append(" scale=");
        localStringBuilder.append(paramFloat3);
        localStringBuilder.append(" px=");
        localStringBuilder.append(paramFloat1);
        localStringBuilder.append(" py=");
        localStringBuilder.append(paramFloat2);
        QLog.d("QComboNPaster", 2, localStringBuilder.toString());
      }
      paramIFaceSelectedListener.a(new SelectedItem(paramNormalFacePackage.jdField_b_of_type_JavaLangString, paramString1, paramDrawable, paramInt3), f * paramFloat1, paramInt2 * paramFloat2, paramFloat3, paramString2, paramSegmentKeeper);
      return;
    }
    paramDrawable = new StringBuilder();
    paramDrawable.append("can not create drawable from name:");
    paramDrawable.append(paramString1);
    SLog.e("QComboNPaster", paramDrawable.toString());
  }
  
  public float a()
  {
    try
    {
      if (!StringUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.g))
      {
        a();
        return 1.0F;
      }
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_c_of_type_Int != 100.0F) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_c_of_type_Int > 0.0F))
      {
        float f = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.d;
        int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_c_of_type_Int;
        f = f * 1.0F / i;
        return f;
      }
      return 0.0F;
    }
    finally {}
  }
  
  public int a()
  {
    try
    {
      if (!StringUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.g)) {
        this.jdField_c_of_type_Int = 3;
      } else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_Int = 1;
      }
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.a == null) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.a.size() == 0))
    {
      paramActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage;
      paramActivity.a(paramActivity.a());
    }
    ThreadManager.excute(new CaptureComboNormalPaster.1(this, paramInt), 64, null, true);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("apply id=");
      paramActivity.append(this.jdField_a_of_type_JavaLangString);
      paramActivity.append(" name=");
      paramActivity.append(this.jdField_b_of_type_JavaLangString);
      QLog.d("QComboNPaster", 2, paramActivity.toString());
    }
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.a == null) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.a.size() == 0))
    {
      paramActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage;
      paramActivity.a(paramActivity.a());
    }
    paramActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.a(this.jdField_b_of_type_JavaLangString);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unApply id=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" name=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("url=");
      ((StringBuilder)localObject).append(paramActivity);
      QLog.d("QComboNPaster", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramActivity)) {
      return;
    }
    try
    {
      paramActivity = new File(Uri.parse(paramActivity).getPath()).getName();
      localObject = DoodleLayoutConnector.a().a(paramInt);
      if (localObject != null)
      {
        ((DoodleLayout)localObject).a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_b_of_type_JavaLangString, paramActivity);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public int b()
  {
    try
    {
      ((DoodleEmojiManager)QIMManager.a(14)).a(this.jdField_a_of_type_JavaLangString, false);
      a();
      Object localObject1 = StoryDispatcher.a();
      CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver localDoodleEmojiDownloadEventReceiver = new CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterCaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver = localDoodleEmojiDownloadEventReceiver;
      ((Dispatcher)localObject1).registerSubscriber(localDoodleEmojiDownloadEventReceiver);
      this.jdField_c_of_type_Int = 1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create mState=");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Int);
        ((StringBuilder)localObject1).append(" id=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("QComboNPaster", 2, ((StringBuilder)localObject1).toString());
      }
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally {}
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboNormalPaster
 * JD-Core Version:    0.7.0.1
 */