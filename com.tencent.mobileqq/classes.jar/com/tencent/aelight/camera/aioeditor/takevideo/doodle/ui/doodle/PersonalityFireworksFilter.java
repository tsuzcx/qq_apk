package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

@TargetApi(9)
public class PersonalityFireworksFilter
  extends VideoFilterBase
{
  public static final String a = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/DoodleFireworksAndLighterVertexShader.dat");
  public static final String b = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/DoodleFireworksFragmentShader.dat");
  public static final float[] c = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  Point d;
  int e;
  int f;
  int[] g = new int[1];
  Frame h = new Frame();
  int i = -1;
  boolean j;
  float k = 0.35F;
  Queue<DoodleMagicAlgoHandler.RenderPoint> l = new LinkedBlockingDeque();
  int m = 0;
  boolean n = false;
  float o;
  float p;
  private boolean q = false;
  
  public PersonalityFireworksFilter()
  {
    super(a, b);
    initParams();
  }
  
  private void a(DoodleMagicAlgoHandler.RenderPoint paramRenderPoint, int paramInt)
  {
    super.addParam(new UniformParam.IntParam("drawType", paramInt));
    int i7 = paramRenderPoint.xList.length;
    float[] arrayOfFloat1 = new float[i7 * 2];
    float[] arrayOfFloat2 = new float[i7];
    int i6 = 0;
    int i2 = 0;
    int i1 = 0;
    int i3;
    int i5;
    int i4;
    for (paramInt = 0;; paramInt = i3)
    {
      i3 = i6;
      i5 = i1;
      i4 = paramInt;
      if (i2 >= i7) {
        break;
      }
      i4 = i1;
      i3 = paramInt;
      if (paramRenderPoint.aList[i2] > 0.8F)
      {
        i3 = i1 + 1;
        arrayOfFloat1[i1] = paramRenderPoint.xList[i2];
        i4 = i3 + 1;
        arrayOfFloat1[i3] = paramRenderPoint.yList[i2];
        arrayOfFloat2[paramInt] = paramRenderPoint.aList[i2];
        i3 = paramInt + 1;
      }
      i2 += 1;
      i1 = i4;
    }
    while (i3 < i7)
    {
      i1 = i5;
      paramInt = i4;
      if (paramRenderPoint.aList[i3] <= 0.8F)
      {
        paramInt = i5 + 1;
        arrayOfFloat1[i5] = paramRenderPoint.xList[i3];
        i1 = paramInt + 1;
        arrayOfFloat1[paramInt] = paramRenderPoint.yList[i3];
        arrayOfFloat2[i4] = paramRenderPoint.aList[i3];
        paramInt = i4 + 1;
      }
      i3 += 1;
      i5 = i1;
      i4 = paramInt;
    }
    super.setPositions(arrayOfFloat1);
    super.setTexCords(arrayOfFloat1);
    super.addAttribParam(new AttributeParam("inputBlendAlpha", arrayOfFloat2, 1));
    super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
  }
  
  private void b()
  {
    super.addParam(new UniformParam.IntParam("drawType", 0));
    super.setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    super.addAttribParam(new AttributeParam("inputBlendAlpha", c, 1));
  }
  
  public void ApplyGLSLFilter()
  {
    if (!this.q)
    {
      this.q = true;
      super.ApplyGLSLFilter();
    }
  }
  
  public void a()
  {
    if (!this.j)
    {
      int[] arrayOfInt = this.g;
      GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
      this.h.bindFrame(this.g[0], this.e, this.f, 1.0D);
      this.i = this.h.getTextureId();
      this.j = true;
    }
  }
  
  public void a(int paramInt)
  {
    UniformParam.TextureParam localTextureParam = new UniformParam.TextureParam("inputImageTexture2", this.i, 33986);
    localTextureParam.initialParams(super.getProgramIds());
    super.addParam(localTextureParam);
    super.addParam(new UniformParam.IntParam("drawType", 0));
    a(paramInt, this.e, this.f);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.setPositions(AlgoUtils.calPositions(0.0F, this.f, this.e + 0.0F, 0.0F, paramInt2, paramInt3));
    super.addParam(new UniformParam.Float2fParam("texAnchor", this.d.x, this.d.y));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    GLES20.glFlush();
    super.OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(DoodleMagicAlgoHandler.RenderPoint paramRenderPoint)
  {
    if (paramRenderPoint.xList.length != 0) {
      this.l.add(paramRenderPoint);
    }
  }
  
  public boolean a(List<PointF> paramList, boolean paramBoolean, PersonalityLinePath paramPersonalityLinePath)
  {
    GLES20.glBlendFuncSeparate(1, 771, 1, 1);
    this.h.bindFrame(this.g[0], this.e, this.f, 1.0D);
    GLES20.glBindFramebuffer(36160, this.h.getFBO());
    GLES20.glViewport(0, 0, this.e, this.f);
    if ((this.m == 0) && (this.j))
    {
      this.h.bindFrame(this.g[0], this.e, this.f, 1.0D);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      GLES20.glFlush();
    }
    int i1 = this.m;
    PointF localPointF;
    while (i1 < paramList.size())
    {
      localPointF = (PointF)paramList.get(i1);
      localPointF = new PointF(localPointF.x + this.d.x, localPointF.y + this.d.y);
      if (i1 == 0)
      {
        this.o = localPointF.x;
        this.p = localPointF.y;
        DoodleMagicAlgoHandler.onTouchEvent(0, localPointF.x, localPointF.y);
      }
      else
      {
        DoodleMagicAlgoHandler.onTouchEvent(1, localPointF.x, localPointF.y);
      }
      i1 += 1;
    }
    if (paramBoolean)
    {
      paramList = (PointF)paramList.get(paramList.size() - 1);
      localPointF = new PointF(this.e / 2, this.f / 2);
      paramList = new PointF(paramList.x + localPointF.x, paramList.y + localPointF.y);
      if ((paramList.x == this.o) && (paramList.y == this.p))
      {
        paramList.x += 1.0F;
        paramList.y += 1.0F;
      }
      DoodleMagicAlgoHandler.onTouchEvent(2, paramList.x, paramList.y);
      this.m = 0;
      this.o = -1.0F;
      this.o = -1.0F;
    }
    else
    {
      this.m = (paramList.size() - 1);
    }
    this.n = paramBoolean;
    while (!this.l.isEmpty())
    {
      paramList = (DoodleMagicAlgoHandler.RenderPoint)this.l.poll();
      if (paramList != null)
      {
        paramPersonalityLinePath.m.add(paramList);
        b(paramList);
      }
    }
    return true;
  }
  
  public void b(DoodleMagicAlgoHandler.RenderPoint paramRenderPoint)
  {
    a(paramRenderPoint, 4);
    super.OnDrawFrameGLSL();
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.i);
    GLES20.glDrawArrays(5, 0, paramRenderPoint.xList.length);
    GLES20.glFlush();
    b();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    super.addAttribParam(new AttributeParam("inputBlendAlpha", c, 1));
  }
  
  public void initParams()
  {
    super.addParam(new UniformParam.IntParam("texNeedTransform", 1));
    super.addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    super.addParam(new UniformParam.IntParam("blendMode", -1));
    super.addParam(new UniformParam.IntParam("drawType", 0));
    super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBlendFuncSeparate(770, 771, 1, 1);
    UniformParam.TextureParam localTextureParam = new UniformParam.TextureParam("inputImageTexture2", this.i, 33986);
    localTextureParam.initialParams(super.getProgramIds());
    super.addParam(localTextureParam);
    a(paramInt1, this.e, this.f);
    return true;
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.d = new Point(paramInt1 / 2, paramInt2 / 2);
    this.e = paramInt1;
    this.f = paramInt2;
    super.addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
    DoodleMagicAlgoHandler.OnUpdateSize(this.e, this.f, this.k);
    DoodleMagicAlgoHandler.setFilter(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PersonalityFireworksFilter
 * JD-Core Version:    0.7.0.1
 */