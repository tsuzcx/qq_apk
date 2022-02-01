package com.tencent.aelight.camera.ae.gif.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextDrawer;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GifFilterProcess
{
  private int a = 0;
  private int b = 0;
  private ComposeFilter c = new ComposeFilter();
  private PreMultiplyFilter d = new PreMultiplyFilter();
  private Frame e = new Frame();
  private boolean f = true;
  private String g;
  private BaseFilter h = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private BaseFilter i = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private BaseFilter j = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame k = new Frame();
  private Frame l = new Frame();
  private LightNode m;
  private boolean n = false;
  private GifFilterProcess.TextConfig o;
  
  private Frame a(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    HashMap localHashMap;
    if (this.m == null)
    {
      this.m = new LightNode();
      this.m.initPreviewSize(this.a, this.b);
      this.m.apply();
      this.m.setSyncMode(true);
      localHashMap = new HashMap();
      localHashMap.put("ai.segmentation.bg.enable", "false");
      localHashMap.put("ai.face.enable", "false");
      localHashMap.put("basicFaceBeauty.enable", "false");
      localHashMap.put("transparentMode", "1");
      this.m.updateCameraConfigData(localHashMap);
    }
    if (!TextUtils.isEmpty(this.g))
    {
      this.m.updateAsset(this.g);
      this.g = "";
      localHashMap = new HashMap();
      localHashMap.put("ai.segmentation.bg.enable", "false");
      localHashMap.put("ai.face.enable", "false");
      localHashMap.put("basicFaceBeauty.enable", "false");
      localHashMap.put("transparentMode", "1");
      this.m.updateCameraConfigData(localHashMap);
    }
    this.m.setPtFaceAttr(paramPTFaceAttr);
    return this.m.render(paramFrame);
  }
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2, PTFaceAttr paramPTFaceAttr)
  {
    if (this.f)
    {
      this.c.a(paramFrame, paramInt1, paramInt2, this.e);
      paramFrame = this.e;
    }
    if ((this.n) && (this.o != null))
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      float f1 = this.o.b * 2.0F - 1.0F;
      float f2 = this.o.c * 2.0F - 1.0F;
      float f3 = this.o.d * 2.0F + f1;
      float f4 = this.o.e * 2.0F + f2;
      this.h.setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
      this.h.RenderProcess(this.o.a, paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
      GLES20.glDisable(3042);
    }
    this.j.setRotationAndFlip(0, 0, 1);
    this.j.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.l);
    this.i.RenderProcess(this.l.getTextureId(), 320, 320, -1, 0.0D, this.k);
    paramFrame = this.d.RenderProcess(this.k.getTextureId(), 320, 320);
    paramPTFaceAttr = a(paramFrame, paramPTFaceAttr);
    paramFrame.unlock();
    return paramPTFaceAttr;
  }
  
  public void a()
  {
    this.c.apply();
    this.d.apply();
    this.h.apply();
    this.i.apply();
    this.j.apply();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(String paramString)
  {
    if (this.m != null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.g = AEResUtil.l();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("template.json");
      this.g = localStringBuilder.toString();
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.o = new GifFilterProcess.TextConfig(this);
    AEGIFTextDrawer localAEGIFTextDrawer = new AEGIFTextDrawer((int)(paramFloat3 * 320.0F), (int)(320.0F * paramFloat4));
    localAEGIFTextDrawer.a(paramString1);
    localAEGIFTextDrawer.a(paramInt1);
    localAEGIFTextDrawer.b(paramString2);
    localAEGIFTextDrawer.c(paramString3);
    localAEGIFTextDrawer.a(paramInt2);
    localAEGIFTextDrawer.d(paramString4);
    localAEGIFTextDrawer.a();
    paramString1 = localAEGIFTextDrawer.b();
    this.o.a = RendererUtils.createTexture(paramString1);
    localAEGIFTextDrawer.c();
    paramString1 = this.o;
    paramString1.b = paramFloat1;
    paramString1.c = paramFloat2;
    paramString1.d = paramFloat3;
    paramString1.e = paramFloat4;
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void b()
  {
    this.c.clearGLSL();
    this.d.clearGLSL();
    this.e.clear();
    this.h.clearGLSL();
    this.i.clearGLSL();
    this.j.clearGLSL();
    this.k.clear();
    this.l.clear();
    Object localObject = this.m;
    if (localObject != null) {
      ((LightNode)localObject).clear();
    }
    localObject = this.o;
    if (localObject != null)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = ((GifFilterProcess.TextConfig)localObject).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.filter.GifFilterProcess
 * JD-Core Version:    0.7.0.1
 */