package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class PersonalityOperator
  implements DoodleOperator
{
  protected double a;
  protected int a;
  Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  DoodleLineListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
  PersonalityLinePath jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityLinePath = null;
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  HashMap<String, VideoFilterBase> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  protected int[] a;
  protected int b;
  Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  boolean jdField_b_of_type_Boolean = false;
  int[] jdField_b_of_type_ArrayOfInt = new int[1];
  int jdField_c_of_type_Int = 320;
  Frame jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  boolean jdField_c_of_type_Boolean = false;
  int[] jdField_c_of_type_ArrayOfInt = new int[1];
  int jdField_d_of_type_Int = 480;
  Frame jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  public boolean d;
  int[] jdField_d_of_type_ArrayOfInt = new int[1];
  int jdField_e_of_type_Int = 0;
  boolean jdField_e_of_type_Boolean = true;
  int jdField_f_of_type_Int = 0;
  boolean jdField_f_of_type_Boolean = false;
  public int g;
  public boolean g;
  
  public PersonalityOperator(DoodleLineListener paramDoodleLineListener)
  {
    this.jdField_a_of_type_Double = 0.75D;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_d_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_g_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener = paramDoodleLineListener;
  }
  
  public static VideoFilterBase a(VideoMaterial paramVideoMaterial)
  {
    VideoFilterBase localVideoFilterBase = null;
    if (paramVideoMaterial == null) {
      return null;
    }
    if ((paramVideoMaterial.getDoodleItem() == null) && (QLog.isColorLevel())) {
      QLog.w("PersonalityOperator", 2, "material.getDoodleItem is null!");
    }
    if (paramVideoMaterial.getShaderType() == 13) {
      return b(paramVideoMaterial);
    }
    if (paramVideoMaterial.getShaderType() == 15) {
      return c(paramVideoMaterial);
    }
    if (paramVideoMaterial.getShaderType() == 14) {
      localVideoFilterBase = d(paramVideoMaterial);
    }
    return localVideoFilterBase;
  }
  
  static VideoFilterBase b(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      DoodleItem localDoodleItem = paramVideoMaterial.getDoodleItem();
      if (localDoodleItem != null) {
        return new PersonalityImageFilter(localDoodleItem, paramVideoMaterial.getDataPath());
      }
    }
    return null;
  }
  
  static VideoFilterBase c(VideoMaterial paramVideoMaterial)
  {
    return new PersonalityFireworksFilter();
  }
  
  static VideoFilterBase d(VideoMaterial paramVideoMaterial)
  {
    return new PersonalityGlareFilter(paramVideoMaterial.getDoodleItem(), paramVideoMaterial.getDataPath());
  }
  
  public void a()
  {
    c();
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.jdField_b_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    arrayOfInt = this.jdField_d_of_type_ArrayOfInt;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    paramFloat1 = this.jdField_a_of_type_Int / this.jdField_c_of_type_Int;
    localPointF.x *= paramFloat1;
    localPointF.y *= paramFloat1;
    localPointF = new PointF(localPointF.x - this.jdField_a_of_type_Int * 0.5F, localPointF.y - this.jdField_b_of_type_Int * 0.5F);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localPointF);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityLinePath.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(int paramInt)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_g_of_type_Int = paramInt;
    DoodleLineListener localDoodleLineListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
    if (localDoodleLineListener != null) {
      localDoodleLineListener.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    float f1 = Math.min(720.0F / Math.min(paramInt1, paramInt2), 1.0F);
    this.jdField_a_of_type_Int = ((int)(paramInt1 * f1));
    this.jdField_b_of_type_Int = ((int)(paramInt2 * f1));
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0D);
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_c_of_type_Boolean) {
      a(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, double paramDouble)
  {
    float f1 = paramInt1;
    float f2 = paramInt2;
    double d1;
    if (f1 / f2 > 0.75D)
    {
      d1 = f1;
      Double.isNaN(d1);
      paramInt2 = (int)(d1 / 0.75D);
    }
    else
    {
      d1 = f2;
      Double.isNaN(d1);
      paramInt1 = (int)(d1 * 0.75D);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)((Map.Entry)localIterator.next()).getValue()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_b_of_type_ArrayOfInt[0]);
    GLES20.glTexImage2D(3553, 0, 6402, paramInt1, paramInt2, 0, 6402, 5123, null);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10241, 9728);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      if (((HashMap)localObject).size() < 1) {
        return;
      }
      localObject = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
      GlUtil.setBlendMode(true);
      GLES20.glBindFramebuffer(36160, paramInt1);
      GLES20.glViewport(0, 0, paramInt3, paramInt4);
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt3, paramInt4, 1.0D);
      this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), paramInt3, paramInt4, paramInt2, 1.0D, (Frame)localObject);
      GlUtil.setBlendMode(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, PersonalityLinePath paramPersonalityLinePath)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      if (((HashMap)localObject).size() < 1) {
        return;
      }
      localObject = new Frame(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getFBO(), this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), paramInt1, paramInt2);
      GlUtil.setBlendMode(true);
      GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getFBO());
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramPersonalityLinePath.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), paramInt1, paramInt2, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), 1.0D, (Frame)localObject);
      GlUtil.setBlendMode(false);
      paramPersonalityLinePath.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(Frame paramFrame, int paramInt1, int paramInt2, PersonalityLinePath paramPersonalityLinePath)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject1 != null)
    {
      if (((HashMap)localObject1).size() < 1) {
        return;
      }
      GlUtil.setBlendMode(true);
      GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
      localObject1 = new ArrayList();
      boolean bool = paramPersonalityLinePath.jdField_d_of_type_Boolean;
      ((List)localObject1).addAll(paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      Object localObject2 = (VideoFilterBase)this.jdField_a_of_type_JavaUtilHashMap.get(paramPersonalityLinePath.jdField_a_of_type_JavaLangString);
      if ((localObject2 instanceof PersonalityImageFilter))
      {
        localObject2 = (PersonalityImageFilter)localObject2;
        ((PersonalityImageFilter)localObject2).a((List)localObject1);
        ((PersonalityImageFilter)localObject2).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
        if (bool)
        {
          this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt1, paramInt2, 1.0D);
          GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getFBO());
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
          ((PersonalityImageFilter)localObject2).a(paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
          ((PersonalityImageFilter)localObject2).renderTexture(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), paramInt1, paramInt2);
          paramPersonalityLinePath.b();
        }
      }
      else if ((localObject2 instanceof PersonalityFireworksFilter))
      {
        localObject2 = (PersonalityFireworksFilter)localObject2;
        ((PersonalityFireworksFilter)localObject2).a();
        ((PersonalityFireworksFilter)localObject2).a((List)localObject1, bool, paramPersonalityLinePath);
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
        ((PersonalityFireworksFilter)localObject2).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
        if (bool)
        {
          this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt1, paramInt2, 1.0D);
          GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getFBO());
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
          ((PersonalityFireworksFilter)localObject2).a(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId());
          paramPersonalityLinePath.b();
        }
      }
      else if ((localObject2 instanceof PersonalityGlareFilter))
      {
        localObject2 = (PersonalityGlareFilter)localObject2;
        ((PersonalityGlareFilter)localObject2).a((List)localObject1);
        PersonalityUtils.a(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame, this.jdField_d_of_type_ArrayOfInt[0], paramInt1, paramInt2, true);
        ((PersonalityGlareFilter)localObject2).a();
        PersonalityUtils.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, paramFrame, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame, this.jdField_d_of_type_ArrayOfInt[0], paramInt1, paramInt2);
        if (bool)
        {
          ((PersonalityGlareFilter)localObject2).a(paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
          this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt1, paramInt2, 1.0D);
          PersonalityUtils.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame, this.jdField_d_of_type_ArrayOfInt[0], paramInt1, paramInt2);
          paramPersonalityLinePath.b();
        }
      }
      GlUtil.setBlendMode(false);
      if ((paramPersonalityLinePath.jdField_d_of_type_Boolean) && (paramPersonalityLinePath.jdField_c_of_type_Boolean))
      {
        paramFrame = paramPersonalityLinePath.a(paramInt1, paramInt2);
        a(paramFrame.getFBO(), paramFrame.getTextureId(), paramInt1, paramInt2);
      }
    }
  }
  
  public void a(PersonalityLinePath paramPersonalityLinePath)
  {
    if ((paramPersonalityLinePath.jdField_d_of_type_Boolean) && (paramPersonalityLinePath.jdField_a_of_type_Boolean)) {
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((!paramPersonalityLinePath.jdField_a_of_type_Boolean) && (paramPersonalityLinePath.jdField_b_of_type_Boolean))
    {
      if (paramPersonalityLinePath.jdField_c_of_type_Boolean) {
        a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramPersonalityLinePath);
      }
      this.jdField_f_of_type_Boolean = true;
      return;
    }
    if (paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 1) {
      a(this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramPersonalityLinePath);
    }
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramVideoMaterial.getId()))
      {
        localObject = a(paramVideoMaterial);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramVideoMaterial.getId(), localObject);
        }
      }
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
      paramVideoMaterial = new PersonalityOperator.1(this, paramVideoMaterial);
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
      if (localObject != null) {
        ((DoodleLineListener)localObject).a(paramVideoMaterial);
      }
    }
    else
    {
      SLog.b("PersonalityOperator", "material is null!");
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      return;
    }
    paramString = (VideoFilterBase)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    paramString.ApplyGLSLFilter();
    paramString.setRenderMode(1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = (paramBoolean ^ true);
    DoodleLineListener localDoodleLineListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
    if (localDoodleLineListener != null) {
      localDoodleLineListener.a();
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      if ((QLog.isColorLevel()) && (paramMotionEvent.getAction() == 0)) {
        QLog.w("PersonalityOperator", 2, "onTouch filterMap is empty");
      }
      return true;
    }
    Object localObject;
    if (this.jdField_f_of_type_Int + 1 > 50)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityLinePath;
      if ((localObject != null) && (((PersonalityLinePath)localObject).jdField_d_of_type_Boolean))
      {
        if (paramMotionEvent.getAction() == 0)
        {
          QQStoryContext.a();
          QQToast.a(QQStoryContext.a().getApp(), HardCodeUtil.a(2131707958), 0).a();
        }
        return true;
      }
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i;
    if (paramMotionEvent.getAction() == 2)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityLinePath != null)
      {
        a(f1, f2, false);
        i = this.jdField_e_of_type_Int + 1;
        this.jdField_e_of_type_Int = i;
        this.jdField_e_of_type_Int = (i % 4);
        i = this.jdField_e_of_type_Int;
      }
    }
    else if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
      if ((paramMotionEvent != null) && (!TextUtils.isEmpty(paramMotionEvent.getId())))
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getId();
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
        if (localObject != null) {
          i = ((DoodleLineListener)localObject).a();
        } else {
          i = 0;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityLinePath = new PersonalityLinePath(102, paramMotionEvent, i);
        this.jdField_f_of_type_Int += 1;
        paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityLinePath;
        paramMotionEvent.jdField_c_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
        if (localObject != null) {
          ((DoodleLineListener)localObject).a(paramMotionEvent);
        }
        a(f1, f2, false);
        this.jdField_e_of_type_Int = 0;
      }
    }
    else if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityLinePath != null))
    {
      a(f1, f2, true);
    }
    this.jdField_d_of_type_Boolean = true;
    paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
    if (paramMotionEvent != null) {
      paramMotionEvent.a();
    }
    return true;
  }
  
  public void b()
  {
    this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void c()
  {
    this.jdField_f_of_type_Int = 0;
    try
    {
      this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      this.jdField_b_of_type_ComTencentFilterBaseFilter.clearGLSL();
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (localIterator.hasNext()) {
            ((VideoFilterBase)((Map.Entry)localIterator.next()).getValue()).clearGLSLSelf();
          }
          this.jdField_a_of_type_JavaUtilHashMap.clear();
        }
      }
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      this.jdField_a_of_type_ComTencentFilterBaseFilter.clearGLSL();
      GLES20.glDeleteTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
      GLES20.glDeleteTextures(this.jdField_c_of_type_ArrayOfInt.length, this.jdField_c_of_type_ArrayOfInt, 0);
      GLES20.glDeleteTextures(this.jdField_d_of_type_ArrayOfInt.length, this.jdField_d_of_type_ArrayOfInt, 0);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clear ");
        localStringBuilder.append(localThrowable.toString());
        QLog.e("PersonalityOperator", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void d()
  {
    this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Double);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
    if (Build.VERSION.SDK_INT < 30) {
      this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, this.jdField_a_of_type_Double, this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame);
    }
    if (!this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0D);
        PersonalityUtils.a();
        this.jdField_a_of_type_Boolean = false;
      }
      else
      {
        a(this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.getFBO(), this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
    this.jdField_f_of_type_Boolean = false;
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_f_of_type_Boolean	Z
    //   4: ifeq +29 -> 33
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 72	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame	Lcom/tencent/aekit/openrender/internal/Frame;
    //   12: invokevirtual 293	com/tencent/aekit/openrender/internal/Frame:getFBO	()I
    //   15: aload_0
    //   16: getfield 72	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame	Lcom/tencent/aekit/openrender/internal/Frame;
    //   19: invokevirtual 285	com/tencent/aekit/openrender/internal/Frame:getTextureId	()I
    //   22: aload_0
    //   23: getfield 94	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_Int	I
    //   26: aload_0
    //   27: getfield 172	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_b_of_type_Int	I
    //   30: invokevirtual 345	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:a	(IIII)V
    //   33: aload_0
    //   34: getfield 68	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_b_of_type_ComTencentFilterBaseFilter	Lcom/tencent/filter/BaseFilter;
    //   37: aload_0
    //   38: getfield 72	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame	Lcom/tencent/aekit/openrender/internal/Frame;
    //   41: invokevirtual 285	com/tencent/aekit/openrender/internal/Frame:getTextureId	()I
    //   44: aload_0
    //   45: getfield 31	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   48: aload_0
    //   49: getfield 33	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Int	I
    //   52: iconst_0
    //   53: aload_0
    //   54: getfield 37	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_Double	D
    //   57: aload_0
    //   58: getfield 70	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame	Lcom/tencent/aekit/openrender/internal/Frame;
    //   61: invokevirtual 289	com/tencent/filter/BaseFilter:RenderProcess	(IIIIDLcom/tencent/aekit/openrender/internal/Frame;)V
    //   64: aload_0
    //   65: getfield 98	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   68: astore 6
    //   70: aload 6
    //   72: ifnull +19 -> 91
    //   75: aload 6
    //   77: instanceof 499
    //   80: ifeq +11 -> 91
    //   83: aload 6
    //   85: checkcast 499	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController
    //   88: invokevirtual 501	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController:f	()V
    //   91: aload_0
    //   92: getfield 92	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_g_of_type_Boolean	Z
    //   95: ifeq +547 -> 642
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 92	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_g_of_type_Boolean	Z
    //   103: aconst_null
    //   104: astore 10
    //   106: aconst_null
    //   107: astore 11
    //   109: aconst_null
    //   110: astore 12
    //   112: aconst_null
    //   113: astore 6
    //   115: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +12 -> 130
    //   121: ldc 114
    //   123: iconst_2
    //   124: ldc_w 503
    //   127: invokestatic 505	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   133: lstore_2
    //   134: aload 10
    //   136: astore 7
    //   138: aload 11
    //   140: astore 8
    //   142: aload 12
    //   144: astore 9
    //   146: aload_0
    //   147: getfield 31	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   150: aload_0
    //   151: getfield 33	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Int	I
    //   154: imul
    //   155: invokestatic 517	java/nio/IntBuffer:allocate	(I)Ljava/nio/IntBuffer;
    //   158: astore 13
    //   160: aload 10
    //   162: astore 7
    //   164: aload 11
    //   166: astore 8
    //   168: aload 12
    //   170: astore 9
    //   172: iconst_0
    //   173: iconst_0
    //   174: aload_0
    //   175: getfield 31	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   178: aload_0
    //   179: getfield 33	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Int	I
    //   182: sipush 6408
    //   185: sipush 5121
    //   188: aload 13
    //   190: invokestatic 521	android/opengl/GLES20:glReadPixels	(IIIIIILjava/nio/Buffer;)V
    //   193: aload 10
    //   195: astore 7
    //   197: aload 11
    //   199: astore 8
    //   201: aload 12
    //   203: astore 9
    //   205: aload 13
    //   207: invokevirtual 525	java/nio/IntBuffer:array	()[I
    //   210: astore 14
    //   212: aload 10
    //   214: astore 7
    //   216: aload 11
    //   218: astore 8
    //   220: aload 12
    //   222: astore 9
    //   224: aload_0
    //   225: getfield 31	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   228: aload_0
    //   229: getfield 33	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Int	I
    //   232: getstatic 531	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   235: invokestatic 537	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   238: astore 13
    //   240: aload 10
    //   242: astore 7
    //   244: aload 11
    //   246: astore 8
    //   248: aload 12
    //   250: astore 9
    //   252: aload 13
    //   254: aload 14
    //   256: invokestatic 541	java/nio/IntBuffer:wrap	([I)Ljava/nio/IntBuffer;
    //   259: invokevirtual 545	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   262: aload 13
    //   264: ifnull +131 -> 395
    //   267: aload 10
    //   269: astore 7
    //   271: aload 11
    //   273: astore 8
    //   275: aload 12
    //   277: astore 9
    //   279: aload_0
    //   280: getfield 96	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_g_of_type_Int	I
    //   283: i2f
    //   284: fconst_1
    //   285: fmul
    //   286: aload_0
    //   287: getfield 31	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   290: i2f
    //   291: fdiv
    //   292: fstore_1
    //   293: aload 10
    //   295: astore 7
    //   297: aload 11
    //   299: astore 8
    //   301: aload 12
    //   303: astore 9
    //   305: new 547	android/graphics/Matrix
    //   308: dup
    //   309: invokespecial 548	android/graphics/Matrix:<init>	()V
    //   312: astore 6
    //   314: aload 10
    //   316: astore 7
    //   318: aload 11
    //   320: astore 8
    //   322: aload 12
    //   324: astore 9
    //   326: aload 6
    //   328: ldc_w 549
    //   331: invokevirtual 553	android/graphics/Matrix:postRotate	(F)Z
    //   334: pop
    //   335: aload 10
    //   337: astore 7
    //   339: aload 11
    //   341: astore 8
    //   343: aload 12
    //   345: astore 9
    //   347: aload 6
    //   349: ldc_w 554
    //   352: fload_1
    //   353: fmul
    //   354: fload_1
    //   355: fconst_1
    //   356: fmul
    //   357: invokevirtual 558	android/graphics/Matrix:postScale	(FF)Z
    //   360: pop
    //   361: aload 10
    //   363: astore 7
    //   365: aload 11
    //   367: astore 8
    //   369: aload 12
    //   371: astore 9
    //   373: aload 13
    //   375: iconst_0
    //   376: iconst_0
    //   377: aload 13
    //   379: invokevirtual 561	android/graphics/Bitmap:getWidth	()I
    //   382: aload 13
    //   384: invokevirtual 564	android/graphics/Bitmap:getHeight	()I
    //   387: aload 6
    //   389: iconst_0
    //   390: invokestatic 567	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   393: astore 6
    //   395: aload 6
    //   397: astore 7
    //   399: aload 6
    //   401: astore 8
    //   403: aload 6
    //   405: astore 9
    //   407: aload_0
    //   408: iconst_0
    //   409: putfield 84	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Boolean	Z
    //   412: aload_0
    //   413: getfield 98	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   416: astore 7
    //   418: aload 7
    //   420: ifnull +148 -> 568
    //   423: goto +136 -> 559
    //   426: astore 6
    //   428: goto +191 -> 619
    //   431: astore 6
    //   433: aload 8
    //   435: astore 7
    //   437: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   440: ifeq +57 -> 497
    //   443: aload 8
    //   445: astore 7
    //   447: new 464	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 465	java/lang/StringBuilder:<init>	()V
    //   454: astore 9
    //   456: aload 8
    //   458: astore 7
    //   460: aload 9
    //   462: ldc_w 569
    //   465: invokevirtual 471	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 8
    //   471: astore 7
    //   473: aload 9
    //   475: aload 6
    //   477: invokevirtual 572	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 8
    //   483: astore 7
    //   485: ldc_w 574
    //   488: iconst_2
    //   489: aload 9
    //   491: invokevirtual 475	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 477	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: aload_0
    //   498: getfield 98	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   501: astore 7
    //   503: aload 7
    //   505: ifnull +63 -> 568
    //   508: aload 8
    //   510: astore 6
    //   512: goto +47 -> 559
    //   515: astore 6
    //   517: aload 9
    //   519: astore 7
    //   521: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +20 -> 544
    //   527: aload 9
    //   529: astore 7
    //   531: ldc_w 574
    //   534: iconst_2
    //   535: aload 6
    //   537: iconst_0
    //   538: anewarray 4	java/lang/Object
    //   541: invokestatic 577	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   544: aload_0
    //   545: getfield 98	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   548: astore 7
    //   550: aload 7
    //   552: ifnull +16 -> 568
    //   555: aload 9
    //   557: astore 6
    //   559: aload 7
    //   561: aload 6
    //   563: invokeinterface 580 2 0
    //   568: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   571: lstore 4
    //   573: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq +66 -> 642
    //   579: new 464	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 465	java/lang/StringBuilder:<init>	()V
    //   586: astore 6
    //   588: aload 6
    //   590: ldc_w 582
    //   593: invokevirtual 471	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 6
    //   599: lload 4
    //   601: lload_2
    //   602: lsub
    //   603: invokevirtual 585	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: ldc 114
    //   609: iconst_2
    //   610: aload 6
    //   612: invokevirtual 475	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 505	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: return
    //   619: aload_0
    //   620: getfield 98	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   623: astore 8
    //   625: aload 8
    //   627: ifnull +12 -> 639
    //   630: aload 8
    //   632: aload 7
    //   634: invokeinterface 580 2 0
    //   639: aload 6
    //   641: athrow
    //   642: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	this	PersonalityOperator
    //   292	63	1	f1	float
    //   133	469	2	l1	long
    //   571	29	4	l2	long
    //   68	336	6	localObject1	Object
    //   426	1	6	localObject2	Object
    //   431	45	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   510	1	6	localObject3	Object
    //   515	21	6	localException	java.lang.Exception
    //   557	83	6	localObject4	Object
    //   136	497	7	localObject5	Object
    //   140	491	8	localObject6	Object
    //   144	412	9	localObject7	Object
    //   104	258	10	localObject8	Object
    //   107	259	11	localObject9	Object
    //   110	260	12	localObject10	Object
    //   158	225	13	localObject11	Object
    //   210	45	14	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   146	160	426	finally
    //   172	193	426	finally
    //   205	212	426	finally
    //   224	240	426	finally
    //   252	262	426	finally
    //   279	293	426	finally
    //   305	314	426	finally
    //   326	335	426	finally
    //   347	361	426	finally
    //   373	395	426	finally
    //   407	412	426	finally
    //   437	443	426	finally
    //   447	456	426	finally
    //   460	469	426	finally
    //   473	481	426	finally
    //   485	497	426	finally
    //   521	527	426	finally
    //   531	544	426	finally
    //   146	160	431	java/lang/OutOfMemoryError
    //   172	193	431	java/lang/OutOfMemoryError
    //   205	212	431	java/lang/OutOfMemoryError
    //   224	240	431	java/lang/OutOfMemoryError
    //   252	262	431	java/lang/OutOfMemoryError
    //   279	293	431	java/lang/OutOfMemoryError
    //   305	314	431	java/lang/OutOfMemoryError
    //   326	335	431	java/lang/OutOfMemoryError
    //   347	361	431	java/lang/OutOfMemoryError
    //   373	395	431	java/lang/OutOfMemoryError
    //   407	412	431	java/lang/OutOfMemoryError
    //   146	160	515	java/lang/Exception
    //   172	193	515	java/lang/Exception
    //   205	212	515	java/lang/Exception
    //   224	240	515	java/lang/Exception
    //   252	262	515	java/lang/Exception
    //   279	293	515	java/lang/Exception
    //   305	314	515	java/lang/Exception
    //   326	335	515	java/lang/Exception
    //   347	361	515	java/lang/Exception
    //   373	395	515	java/lang/Exception
    //   407	412	515	java/lang/Exception
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Int -= 1;
    DoodleLineListener localDoodleLineListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
    if (localDoodleLineListener != null) {
      localDoodleLineListener.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 0;
    DoodleLineListener localDoodleLineListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
    if (localDoodleLineListener != null) {
      localDoodleLineListener.a();
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = true;
    DoodleLineListener localDoodleLineListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
    if (localDoodleLineListener != null) {
      localDoodleLineListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PersonalityOperator
 * JD-Core Version:    0.7.0.1
 */