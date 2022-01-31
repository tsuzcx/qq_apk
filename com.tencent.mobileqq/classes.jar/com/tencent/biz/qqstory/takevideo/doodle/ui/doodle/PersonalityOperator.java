package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.view.RendererUtils;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import okc;

public class PersonalityOperator
  extends DoodleOperator
{
  protected double a;
  public int a;
  DoodleLineListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener;
  PersonalityLinePath jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath = null;
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame jdField_a_of_type_ComTencentFilterFrame = new Frame();
  VideoMaterial jdField_a_of_type_ComTencentTtpicModelVideoMaterial;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_a_of_type_Boolean = false;
  protected int[] a;
  public int b;
  BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame jdField_b_of_type_ComTencentFilterFrame = new Frame();
  boolean jdField_b_of_type_Boolean = false;
  int[] jdField_b_of_type_ArrayOfInt = new int[1];
  int jdField_c_of_type_Int = 320;
  Frame jdField_c_of_type_ComTencentFilterFrame = new Frame();
  boolean jdField_c_of_type_Boolean = false;
  int[] jdField_c_of_type_ArrayOfInt = new int[1];
  int jdField_d_of_type_Int = 480;
  Frame jdField_d_of_type_ComTencentFilterFrame = new Frame();
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
    this.jdField_g_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener = paramDoodleLineListener;
  }
  
  public static VideoFilterBase a(QQVideoMaterial paramQQVideoMaterial)
  {
    if (paramQQVideoMaterial == null) {}
    do
    {
      return null;
      if (paramQQVideoMaterial.getShaderType() == 13) {
        return b(paramQQVideoMaterial);
      }
      if (paramQQVideoMaterial.getShaderType() == 15) {
        return c(paramQQVideoMaterial);
      }
    } while (paramQQVideoMaterial.getShaderType() != 14);
    return d(paramQQVideoMaterial);
  }
  
  static VideoFilterBase b(QQVideoMaterial paramQQVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramQQVideoMaterial instanceof QQVideoMaterial))
    {
      DoodleItem localDoodleItem = paramQQVideoMaterial.a();
      localObject1 = localObject2;
      if (localDoodleItem != null) {
        localObject1 = new PersonalityImageFilter(localDoodleItem, paramQQVideoMaterial.getDataPath());
      }
    }
    return localObject1;
  }
  
  static VideoFilterBase c(QQVideoMaterial paramQQVideoMaterial)
  {
    PersonalityFireworksFilter localPersonalityFireworksFilter = null;
    if ((paramQQVideoMaterial instanceof QQVideoMaterial)) {
      localPersonalityFireworksFilter = new PersonalityFireworksFilter();
    }
    return localPersonalityFireworksFilter;
  }
  
  static VideoFilterBase d(QQVideoMaterial paramQQVideoMaterial)
  {
    PersonalityGlareFilter localPersonalityGlareFilter = null;
    if ((paramQQVideoMaterial instanceof QQVideoMaterial)) {
      localPersonalityGlareFilter = new PersonalityGlareFilter(paramQQVideoMaterial.a(), paramQQVideoMaterial.getDataPath());
    }
    return localPersonalityGlareFilter;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = RendererUtils.saveTexture(this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2);
    if (localBitmap != null)
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(1.0F, (float)-this.jdField_a_of_type_Double);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      localBitmap.recycle();
      return BitmapUtils.a((Bitmap)localObject, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, true);
    }
    return null;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = new int[(paramInt2 + paramInt4) * paramInt3];
    int[] arrayOfInt2 = new int[paramInt3 * paramInt4];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    GLES20.glReadPixels(0, 0, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
    paramInt2 = 0;
    paramInt1 = 0;
    boolean bool = true;
    int i;
    label64:
    int j;
    int i1;
    int m;
    int n;
    int k;
    if (paramInt1 < paramInt4)
    {
      i = 0;
      if (i < paramInt3)
      {
        j = arrayOfInt1[(paramInt1 * paramInt3 + i)];
        i1 = j >>> 24;
        m = j >> 16 & 0xFF;
        n = j >> 8 & 0xFF;
        int i2 = j & 0xFF;
        k = Color.argb(i1, i2, n, m);
        j = k;
        if (i1 > 0)
        {
          j = k;
          if (i1 != 255)
          {
            j = (int)(i2 * 1.0F / (i1 * 1.0F) * 255.0F);
            if (j <= 255) {
              break label360;
            }
            j = 255;
          }
        }
      }
    }
    label360:
    for (;;)
    {
      k = (int)(n * 1.0F / (i1 * 1.0F) * 255.0F);
      if (k > 255) {
        k = 255;
      }
      for (;;)
      {
        n = (int)(m * 1.0F / (i1 * 1.0F) * 255.0F);
        m = n;
        if (n > 255) {
          m = 255;
        }
        j = Color.argb(i1, j, k, m);
        arrayOfInt2[((paramInt4 - paramInt2 - 1) * paramInt3 + i)] = j;
        if (j > 0) {
          bool = false;
        }
        for (;;)
        {
          i += 1;
          break label64;
          paramInt2 += 1;
          paramInt1 += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("PersonalityOperator", 2, "saveTextureToBitmap blank:" + bool);
          }
          if (!bool) {
            return Bitmap.createBitmap(arrayOfInt2, paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
          }
          return null;
        }
      }
    }
  }
  
  public void a()
  {
    c();
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_b_of_type_ComTencentFilterBaseFilter.ApplyGLSLFilter();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ApplyGLSLFilter();
    GLES20.glGenTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
    GLES20.glGenTextures(this.jdField_c_of_type_ArrayOfInt.length, this.jdField_c_of_type_ArrayOfInt, 0);
    GLES20.glGenTextures(this.jdField_d_of_type_ArrayOfInt.length, this.jdField_d_of_type_ArrayOfInt, 0);
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    paramFloat1 = this.jdField_a_of_type_Int / this.jdField_c_of_type_Int;
    localPointF.x *= paramFloat1;
    localPointF.y = (paramFloat1 * localPointF.y);
    localPointF = new PointF(localPointF.x - this.jdField_a_of_type_Int * 0.5F, localPointF.y - this.jdField_b_of_type_Int * 0.5F);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localPointF);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(int paramInt)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_g_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    float f1 = Math.min(720.0F / Math.min(paramInt1, paramInt2), 1.0F);
    this.jdField_a_of_type_Int = ((int)(paramInt1 * f1));
    this.jdField_b_of_type_Int = ((int)(f1 * paramInt2));
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0D);
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    if ((this.jdField_c_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener instanceof DoodleOpController)))
    {
      ((DoodleOpController)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener).h();
      a(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramInt1 / paramInt2 > 0.75D) {
      paramInt2 = (int)(paramInt1 / 0.75D);
    }
    while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      return;
      paramInt1 = (int)(paramInt2 * 0.75D);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
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
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() < 1)) {
      return;
    }
    Frame localFrame = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    VideoFilterUtil.a(true);
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt3, paramInt4, 1.0D);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), paramInt3, paramInt4, paramInt2, 1.0D, localFrame);
    VideoFilterUtil.a(false);
  }
  
  public void a(int paramInt1, int paramInt2, PersonalityLinePath paramPersonalityLinePath)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() < 1)) {
      return;
    }
    Frame localFrame = new Frame(this.jdField_a_of_type_ComTencentFilterFrame.getFBO(), this.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2);
    VideoFilterUtil.a(true);
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentFilterFrame.getFBO());
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramPersonalityLinePath.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2, this.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), 1.0D, localFrame);
    VideoFilterUtil.a(false);
    paramPersonalityLinePath.jdField_a_of_type_Boolean = true;
  }
  
  public void a(PersonalityLinePath paramPersonalityLinePath)
  {
    if ((paramPersonalityLinePath.jdField_d_of_type_Boolean) && (paramPersonalityLinePath.jdField_a_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_Boolean);
      if ((!paramPersonalityLinePath.jdField_a_of_type_Boolean) && (paramPersonalityLinePath.jdField_b_of_type_Boolean))
      {
        if (paramPersonalityLinePath.jdField_c_of_type_Boolean) {
          a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramPersonalityLinePath);
        }
        this.jdField_f_of_type_Boolean = true;
        return;
      }
    } while (paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 1);
    a(this.jdField_d_of_type_ComTencentFilterFrame, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramPersonalityLinePath);
  }
  
  public void a(Frame paramFrame, int paramInt1, int paramInt2, PersonalityLinePath paramPersonalityLinePath)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() < 1)) {
      return;
    }
    VideoFilterUtil.a(true);
    GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
    ArrayList localArrayList = new ArrayList();
    boolean bool = paramPersonalityLinePath.jdField_d_of_type_Boolean;
    localArrayList.addAll(paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    Object localObject = (VideoFilterBase)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPersonalityLinePath.jdField_a_of_type_JavaLangString);
    if ((localObject instanceof PersonalityImageFilter))
    {
      localObject = (PersonalityImageFilter)localObject;
      ((PersonalityImageFilter)localObject).a(localArrayList);
      ((PersonalityImageFilter)localObject).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
      if (bool)
      {
        this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt1, paramInt2, 1.0D);
        GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentFilterFrame.getFBO());
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        ((PersonalityImageFilter)localObject).a(paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
        ((PersonalityImageFilter)localObject).renderTexture(this.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2);
        paramPersonalityLinePath.b();
      }
    }
    for (;;)
    {
      VideoFilterUtil.a(false);
      if ((!paramPersonalityLinePath.jdField_d_of_type_Boolean) || (!paramPersonalityLinePath.jdField_c_of_type_Boolean)) {
        break;
      }
      paramFrame = paramPersonalityLinePath.a(paramInt1, paramInt2);
      a(paramFrame.getFBO(), paramFrame.getTextureId(), paramInt1, paramInt2);
      return;
      if ((localObject instanceof PersonalityFireworksFilter))
      {
        localObject = (PersonalityFireworksFilter)localObject;
        ((PersonalityFireworksFilter)localObject).a();
        ((PersonalityFireworksFilter)localObject).a(localArrayList, bool, paramPersonalityLinePath);
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
        ((PersonalityFireworksFilter)localObject).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
        if (bool)
        {
          this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt1, paramInt2, 1.0D);
          GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentFilterFrame.getFBO());
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
          ((PersonalityFireworksFilter)localObject).a(this.jdField_a_of_type_ComTencentFilterFrame.getTextureId());
          paramPersonalityLinePath.b();
        }
      }
      else if ((localObject instanceof PersonalityGlareFilter))
      {
        localObject = (PersonalityGlareFilter)localObject;
        ((PersonalityGlareFilter)localObject).a(localArrayList);
        PersonalityUtils.a(this.jdField_b_of_type_ComTencentFilterFrame, this.jdField_d_of_type_ArrayOfInt[0], paramInt1, paramInt2, true);
        ((PersonalityGlareFilter)localObject).a();
        PersonalityUtils.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, paramFrame, this.jdField_b_of_type_ComTencentFilterFrame, this.jdField_d_of_type_ArrayOfInt[0], paramInt1, paramInt2);
        if (bool)
        {
          ((PersonalityGlareFilter)localObject).a(paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
          this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt1, paramInt2, 1.0D);
          PersonalityUtils.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, this.jdField_a_of_type_ComTencentFilterFrame, this.jdField_b_of_type_ComTencentFilterFrame, this.jdField_d_of_type_ArrayOfInt[0], paramInt1, paramInt2);
          paramPersonalityLinePath.b();
        }
      }
    }
  }
  
  public void a(QQVideoMaterial paramQQVideoMaterial)
  {
    if (paramQQVideoMaterial != null)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramQQVideoMaterial.getId()))
      {
        VideoFilterBase localVideoFilterBase = a(paramQQVideoMaterial);
        if (localVideoFilterBase != null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQVideoMaterial.getId(), localVideoFilterBase);
        }
      }
      this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial = paramQQVideoMaterial;
      paramQQVideoMaterial = new okc(this, paramQQVideoMaterial);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a(paramQQVideoMaterial);
      }
      return;
    }
    SLog.b("PersonalityOperator", "material is null!");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return;
    }
    paramString = (VideoFilterBase)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    paramString.ApplyGLSLFilter();
    paramString.setRenderMode(1);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
      }
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {}
    do
    {
      return true;
      if ((this.jdField_f_of_type_Int + 1 <= 50) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath.jdField_d_of_type_Boolean)) {
        break;
      }
    } while (paramMotionEvent.getAction() != 0);
    QQStoryContext.a();
    QQToast.a(QQStoryContext.a().getApp(), "个性笔触笔数已达上限", 0).a();
    return true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 2) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath != null)
      {
        a(f1, f2, false);
        int i = this.jdField_e_of_type_Int + 1;
        this.jdField_e_of_type_Int = i;
        this.jdField_e_of_type_Int = (i % 4);
        if (this.jdField_e_of_type_Int != 0) {}
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
      return true;
      if (paramMotionEvent.getAction() == 0)
      {
        if ((this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getId())))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath = new PersonalityLinePath(102, this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getId());
          this.jdField_f_of_type_Int += 1;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath.jdField_c_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath);
          }
          a(f1, f2, false);
          this.jdField_e_of_type_Int = 0;
        }
      }
      else if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath != null)) {
        a(f1, f2, true);
      }
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_ComTencentFilterFrame.clear();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_g_of_type_Int = paramInt;
      Bitmap localBitmap = a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (localBitmap == null)
      {
        this.jdField_g_of_type_Boolean = false;
        SLog.e("PersonalityOperator", "saveTextureToBitmap failed, bitmapFromTexture is null");
        return;
      }
      localBitmap = BitmapUtils.a(localBitmap, 1.0F * this.jdField_g_of_type_Int / this.jdField_c_of_type_Int, true);
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a(localBitmap);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Personality", 2, localOutOfMemoryError, new Object[0]);
      }
    }
  }
  
  public void c()
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          ((VideoFilterBase)((Map.Entry)localIterator.next()).getValue()).clearGLSLSelf();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
    }
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    GLES20.glDeleteTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
    GLES20.glDeleteTextures(this.jdField_c_of_type_ArrayOfInt.length, this.jdField_c_of_type_ArrayOfInt, 0);
    GLES20.glDeleteTextures(this.jdField_d_of_type_ArrayOfInt.length, this.jdField_d_of_type_ArrayOfInt, 0);
  }
  
  public void d()
  {
    com.tencent.view.FilterDefault.currentShareIndex = -1;
    this.jdField_d_of_type_ComTencentFilterFrame.bindFrame(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Double);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, this.jdField_a_of_type_Double, this.jdField_c_of_type_ComTencentFilterFrame);
    if (!this.jdField_b_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label126;
      }
      this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0D);
      PersonalityUtils.a();
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      return;
      label126:
      a(this.jdField_d_of_type_ComTencentFilterFrame.getFBO(), this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
  }
  
  public void e()
  {
    if (this.jdField_f_of_type_Boolean) {
      a(this.jdField_d_of_type_ComTencentFilterFrame.getFBO(), this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 0, this.jdField_a_of_type_Double, this.jdField_c_of_type_ComTencentFilterFrame);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener instanceof DoodleOpController))) {
      ((DoodleOpController)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener).f();
    }
    Object localObject4;
    Object localObject5;
    Bitmap localBitmap1;
    long l1;
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = false;
      localObject4 = null;
      localObject5 = null;
      localBitmap1 = null;
      if (QLog.isColorLevel()) {
        QLog.d("PersonalityOperator", 2, "capture personality start");
      }
      l1 = System.currentTimeMillis();
      localObject3 = localObject4;
      localObject2 = localObject5;
    }
    try
    {
      Bitmap localBitmap2 = a(0, 0, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      if (localBitmap2 != null)
      {
        localObject3 = localObject4;
        localObject2 = localObject5;
        localBitmap1 = BitmapUtils.a(localBitmap2, 1.0F * this.jdField_g_of_type_Int / this.jdField_c_of_type_Int, true);
      }
      localObject3 = localBitmap1;
      localObject2 = localBitmap1;
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a(localBitmap1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject3;
          QLog.e("Personality", 2, localException, new Object[0]);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a((Bitmap)localObject3);
        }
      }
    }
    finally
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener == null) {
        break label329;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a((Bitmap)localObject2);
    }
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PersonalityOperator", 2, "capture personality end " + (l2 - l1));
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Int -= 1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator
 * JD-Core Version:    0.7.0.1
 */