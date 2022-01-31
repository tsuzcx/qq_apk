package com.tencent.av.switchface;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.module_switchface.SwitchFaceProcessor;
import com.tencent.ttpic.util.VideoUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import jrh;
import jri;

public class SwitchFaceView
{
  private SwitchFaceProcessor jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private SwitchFaceYUVRender[] jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceYUVRender = new SwitchFaceYUVRender[2];
  
  public SwitchFaceView()
  {
    VideoModule.init(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor = new SwitchFaceProcessor();
    int i = 0;
    while (i < 2)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceYUVRender[i] = new SwitchFaceYUVRender();
      i += 1;
    }
  }
  
  private void a(List paramList)
  {
    float f1 = ((PointF)paramList.get(55)).x;
    float f2 = (((PointF)paramList.get(63)).x - ((PointF)paramList.get(55)).x) / 2.0F;
    float f3 = ((PointF)paramList.get(55)).y;
    paramList.add(new PointF(f1 + f2, (((PointF)paramList.get(63)).y - ((PointF)paramList.get(55)).y) / 2.0F + f3));
    f1 = ((PointF)paramList.get(23)).x;
    f2 = (((PointF)paramList.get(31)).x - ((PointF)paramList.get(23)).x) / 2.0F;
    f3 = ((PointF)paramList.get(23)).y;
    paramList.add(new PointF(f1 + f2, (((PointF)paramList.get(31)).y - ((PointF)paramList.get(23)).y) / 2.0F + f3));
    f1 = ((PointF)paramList.get(59)).x;
    f2 = (((PointF)paramList.get(77)).x - ((PointF)paramList.get(59)).x) / 2.0F;
    f3 = ((PointF)paramList.get(59)).y;
    paramList.add(new PointF(f1 + f2, (((PointF)paramList.get(77)).y - ((PointF)paramList.get(59)).y) / 2.0F + f3));
    f1 = ((PointF)paramList.get(35)).x;
    f2 = ((PointF)paramList.get(35)).x;
    f3 = ((PointF)paramList.get(6)).x;
    float f4 = ((PointF)paramList.get(35)).y;
    paramList.add(new PointF(f1 + (f2 - f3), ((PointF)paramList.get(35)).y - ((PointF)paramList.get(6)).y + f4));
    f1 = ((PointF)paramList.get(64)).x;
    f2 = ((PointF)paramList.get(64)).x;
    f3 = ((PointF)paramList.get(9)).x;
    f4 = ((PointF)paramList.get(64)).y;
    paramList.add(new PointF(f1 + (f2 - f3) * 1.4F, (((PointF)paramList.get(64)).y - ((PointF)paramList.get(9)).y) * 1.4F + f4));
    f1 = ((PointF)paramList.get(45)).x;
    f2 = ((PointF)paramList.get(45)).x;
    f3 = ((PointF)paramList.get(12)).x;
    f4 = ((PointF)paramList.get(45)).y;
    paramList.add(new PointF(f1 + (f2 - f3), ((PointF)paramList.get(45)).y - ((PointF)paramList.get(12)).y + f4));
    f1 = ((PointF)paramList.get(83)).x;
    f2 = ((PointF)paramList.get(83)).x;
    f3 = ((PointF)paramList.get(59)).x;
    f4 = ((PointF)paramList.get(83)).y;
    paramList.add(new PointF(f1 + (f2 - f3), ((PointF)paramList.get(83)).y - ((PointF)paramList.get(59)).y + f4));
  }
  
  private void a(jri paramjri)
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.b();
      this.jdField_a_of_type_Boolean = false;
      int i = 0;
      while (i < paramjri.jdField_a_of_type_ArrayOfJrh.length)
      {
        if (paramjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_ComTencentAvUiGLVideoView != null) {
          paramjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_ComTencentAvUiGLVideoView.a(0, 0, 0);
        }
        this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceYUVRender[i].b();
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG onDestroy e = " + localThrowable);
        }
      }
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < 2)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceYUVRender[i].a();
      i += 1;
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, GLCanvas paramGLCanvas)
  {
    long l5 = System.currentTimeMillis();
    long l3 = 0L;
    long l4 = 0L;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    long l2;
    long l1;
    jri localjri;
    int m;
    int k;
    int j;
    Object localObject;
    int n;
    int i;
    for (VideoLayerUIBase localVideoLayerUIBase = (VideoLayerUIBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localVideoLayerUIBase = null)
    {
      l2 = l3;
      l1 = l4;
      if (localVideoLayerUIBase == null) {
        break label1689;
      }
      localjri = new jri(this);
      localjri.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas = paramGLCanvas;
      m = 0;
      k = 1;
      j = 0;
      while (j < localVideoLayerUIBase.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        paramGLCanvas = localVideoLayerUIBase.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
        localObject = paramGLCanvas.a();
        int i1 = paramGLCanvas.a();
        if (m >= localjri.jdField_a_of_type_ArrayOfJrh.length) {
          break;
        }
        n = k;
        i = m;
        if (paramGLCanvas.f() == 0)
        {
          n = k;
          i = m;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localjri.jdField_a_of_type_ArrayOfJrh[m].jdField_a_of_type_ComTencentAvUiGLVideoView = paramGLCanvas;
            m += 1;
            n = k;
            i = m;
            if (i1 != 0)
            {
              n = 0;
              i = m;
            }
          }
        }
        j += 1;
        k = n;
        m = i;
      }
    }
    boolean bool;
    if ((m == localjri.jdField_a_of_type_ArrayOfJrh.length) && (k != 0) && (paramVideoAppInterface != null) && (paramVideoAppInterface.a(3)))
    {
      paramVideoAppInterface = (FaceItem)((EffectFaceManager)paramVideoAppInterface.a(3)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId())) && ("huanlian".equalsIgnoreCase(paramVideoAppInterface.getId())))
      {
        bool = true;
        if (QLog.isColorLevel())
        {
          paramGLCanvas = new StringBuilder().append("WL_DEBUG isSelectedSwitchFace = ").append(bool).append("|");
          if (paramVideoAppInterface != null) {
            break label1155;
          }
          paramVideoAppInterface = "null";
          label311:
          QLog.d("SwitchFaceView", 2, paramVideoAppInterface);
        }
        if (!bool) {
          break label1969;
        }
        i = 0;
        label333:
        if (i >= 2) {
          break label1312;
        }
        paramVideoAppInterface = localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_ComTencentAvUiGLVideoView.a();
        localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_ArrayOfByte = paramVideoAppInterface.a();
        localjri.jdField_a_of_type_ArrayOfJrh[i].c = paramVideoAppInterface.k();
        localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_Int = paramVideoAppInterface.h();
        localjri.jdField_a_of_type_ArrayOfJrh[i].b = paramVideoAppInterface.i();
        localjri.jdField_a_of_type_ArrayOfJrh[i].d = paramVideoAppInterface.j();
        if (localjri.jdField_a_of_type_ArrayOfJrh[i].d % 2 != 0) {
          break label1163;
        }
        localjri.jdField_a_of_type_ArrayOfJrh[i].e = localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_Int;
        localjri.jdField_a_of_type_ArrayOfJrh[i].f = localjri.jdField_a_of_type_ArrayOfJrh[i].b;
        label489:
        paramGLCanvas = localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_ComTencentAvUiGLVideoView.a();
        paramVideoAppInterface = paramVideoAppInterface.c();
        if (paramVideoAppInterface == null) {
          break label2021;
        }
      }
    }
    label579:
    label2021:
    for (paramVideoAppInterface = new SwitchFaceItem(paramVideoAppInterface);; paramVideoAppInterface = null)
    {
      float f1;
      if ((paramVideoAppInterface != null) && (paramVideoAppInterface.jdField_a_of_type_ArrayOfByte != null))
      {
        localObject = ByteBuffer.wrap(paramVideoAppInterface.jdField_a_of_type_ArrayOfByte);
        localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        if (localVideoLayerUIBase.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b(paramGLCanvas) != 2) {
          break label1210;
        }
        j = 1;
        if (localjri.jdField_a_of_type_ArrayOfJrh[i].e * paramVideoAppInterface.b >= localjri.jdField_a_of_type_ArrayOfJrh[i].f * paramVideoAppInterface.jdField_a_of_type_Short) {
          break label1216;
        }
        k = paramVideoAppInterface.jdField_a_of_type_Short * localjri.jdField_a_of_type_ArrayOfJrh[i].f / paramVideoAppInterface.b;
        m = (localjri.jdField_a_of_type_ArrayOfJrh[i].e - k) / 2;
        k = 0;
        f1 = localjri.jdField_a_of_type_ArrayOfJrh[i].f / paramVideoAppInterface.b / 1000000.0F;
        n = 0;
      }
      for (;;)
      {
        if (n < ((ByteBuffer)localObject).capacity())
        {
          paramVideoAppInterface = new PointF();
          paramVideoAppInterface.x = (m + ((ByteBuffer)localObject).getInt(n) * f1);
          paramVideoAppInterface.y = (k + ((ByteBuffer)localObject).getInt(n + 4) * f1);
          if (j != 0) {
            paramVideoAppInterface.x = (localjri.jdField_a_of_type_ArrayOfJrh[i].e - paramVideoAppInterface.x);
          }
          if ((paramVideoAppInterface.x < 0.0F) || (paramVideoAppInterface.x > localjri.jdField_a_of_type_ArrayOfJrh[i].e) || (paramVideoAppInterface.y < 0.0F) || (paramVideoAppInterface.y > localjri.jdField_a_of_type_ArrayOfJrh[i].f)) {
            localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList = null;
          }
        }
        else
        {
          if (localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.size() == 83) {
              a(localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList);
            }
            f1 = Math.abs(((PointF)localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.get(0)).x - ((PointF)localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f2 = Math.abs(((PointF)localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.get(18)).x - ((PointF)localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f3 = Math.abs(((PointF)localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.get(89)).y - ((PointF)localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            float f4 = Math.abs(((PointF)localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.get(9)).y - ((PointF)localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            if ((6.0F * f1 < f2) || (f1 > f2 * 6.0F) || (6.0F * f3 < f4) || (f3 > f4 * 6.0F)) {
              localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList = null;
            }
          }
          i += 1;
          break label333;
          bool = false;
          break;
          paramVideoAppInterface = paramVideoAppInterface.getId();
          break label311;
          localjri.jdField_a_of_type_ArrayOfJrh[i].e = localjri.jdField_a_of_type_ArrayOfJrh[i].b;
          localjri.jdField_a_of_type_ArrayOfJrh[i].f = localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_Int;
          break label489;
          j = 0;
          break label579;
          k = paramVideoAppInterface.b * localjri.jdField_a_of_type_ArrayOfJrh[i].e / paramVideoAppInterface.jdField_a_of_type_Short;
          m = 0;
          k = (localjri.jdField_a_of_type_ArrayOfJrh[i].f - k) / 2;
          f1 = localjri.jdField_a_of_type_ArrayOfJrh[i].e / paramVideoAppInterface.jdField_a_of_type_Short / 1000000.0F;
          break label681;
        }
        localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_JavaUtilArrayList.add(paramVideoAppInterface);
        n += 8;
      }
      i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceYUVRender[i].a(localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_Int, localjri.jdField_a_of_type_ArrayOfJrh[i].b, localjri.jdField_a_of_type_ArrayOfJrh[i].c, localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_ArrayOfByte, localjri.jdField_a_of_type_ArrayOfJrh[i].d);
        i += 1;
      }
      for (;;)
      {
        try
        {
          if ((GLES20.glCheckFramebufferStatus(36160) == 36053) && (!VideoUtil.isEmpty(localjri.jdField_a_of_type_ArrayOfJrh[0].jdField_a_of_type_JavaUtilArrayList)) && (!VideoUtil.isEmpty(localjri.jdField_a_of_type_ArrayOfJrh[1].jdField_a_of_type_JavaUtilArrayList))) {
            l2 = System.currentTimeMillis();
          }
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          l2 = 0L;
          l1 = 0L;
        }
        try
        {
          if ((!this.jdField_a_of_type_Boolean) && (EffectsRenderController.b()) && (FileUtil.a(SwitchFaceUtils.a)))
          {
            this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.a();
            this.jdField_a_of_type_Boolean = true;
          }
          paramVideoAppInterface = this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.a(this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceYUVRender[0].a(), localjri.jdField_a_of_type_ArrayOfJrh[0].jdField_a_of_type_JavaUtilArrayList, localjri.jdField_a_of_type_ArrayOfJrh[0].e, localjri.jdField_a_of_type_ArrayOfJrh[0].f, this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceYUVRender[1].a(), localjri.jdField_a_of_type_ArrayOfJrh[1].jdField_a_of_type_JavaUtilArrayList, localjri.jdField_a_of_type_ArrayOfJrh[1].e, localjri.jdField_a_of_type_ArrayOfJrh[1].f);
          l1 = System.currentTimeMillis();
          i = 0;
          if (i >= 2) {}
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          for (;;)
          {
            l1 = 0L;
          }
        }
        try
        {
          localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_ComTencentAvUiGLVideoView.a(paramVideoAppInterface[i], localjri.jdField_a_of_type_ArrayOfJrh[i].e, localjri.jdField_a_of_type_ArrayOfJrh[i].f);
          i += 1;
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          break label1847;
          l1 = 0L;
          l2 = 0L;
        }
      }
      l3 = l1;
      l4 = l2;
      if ((localjri.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas instanceof GLES20Canvas))
      {
        GLES20.glViewport(0, 0, ((GLES20Canvas)localjri.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas).c(), ((GLES20Canvas)localjri.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas).d());
        l4 = l2;
        l3 = l1;
      }
      l1 = l3;
      l2 = l4;
      for (;;)
      {
        l3 = System.currentTimeMillis();
        if ((QLog.isColorLevel()) && (l2 != 0L) && (l1 != 0L))
        {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal before SwitchFaceProcessor.process cost = " + (l2 - l5));
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal SwitchFaceProcessor.process cost = " + (l1 - l2));
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal after SwitchFaceProcessor.process cost = " + (l3 - l1));
        }
        return;
        i = 0;
        while (i < 2)
        {
          localjri.jdField_a_of_type_ArrayOfJrh[i].jdField_a_of_type_ComTencentAvUiGLVideoView.a(0, 0, 0);
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal e = " + paramVideoAppInterface);
          paramGLCanvas = paramVideoAppInterface.getStackTrace();
          paramVideoAppInterface = "";
          j = paramGLCanvas.length;
          i = 0;
          while (i < j)
          {
            paramVideoAppInterface = paramVideoAppInterface + "WL_DEBUG processFrame_internal ste[" + i + "]" + paramGLCanvas[i].toString() + "\n";
            i += 1;
          }
          QLog.e("SwitchFaceView", 2, paramVideoAppInterface);
        }
        break;
        a(localjri);
        l3 = 0L;
        l4 = 0L;
        break label1681;
        a(localjri);
        l2 = l3;
        l1 = l4;
      }
    }
  }
  
  public void a(VideoLayerUIBase paramVideoLayerUIBase)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoLayerUIBase);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.b();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG onDestroy e = " + localThrowable);
        }
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.b();
      this.jdField_a_of_type_Boolean = false;
      int i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvSwitchfaceSwitchFaceYUVRender[i].b();
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG onDestroy e = " + localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.switchface.SwitchFaceView
 * JD-Core Version:    0.7.0.1
 */