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
  private int jdField_a_of_type_Int = 0;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private ComposeFilter jdField_a_of_type_ComTencentAelightCameraAeGifFilterComposeFilter = new ComposeFilter();
  private GifFilterProcess.TextConfig jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig;
  private PreMultiplyFilter jdField_a_of_type_ComTencentAelightCameraAeGifFilterPreMultiplyFilter = new PreMultiplyFilter();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private LightNode jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private boolean jdField_b_of_type_Boolean = false;
  private Frame jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private BaseFilter jdField_c_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  
  private Frame a(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    HashMap localHashMap;
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode == null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode = new LightNode();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.initPreviewSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.apply();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.setSyncMode(true);
      localHashMap = new HashMap();
      localHashMap.put("ai.segmentation.bg.enable", "false");
      localHashMap.put("ai.face.enable", "false");
      localHashMap.put("basicFaceBeauty.enable", "false");
      localHashMap.put("transparentMode", "1");
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.updateCameraConfigData(localHashMap);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.updateAsset(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = "";
      localHashMap = new HashMap();
      localHashMap.put("ai.segmentation.bg.enable", "false");
      localHashMap.put("ai.face.enable", "false");
      localHashMap.put("basicFaceBeauty.enable", "false");
      localHashMap.put("transparentMode", "1");
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.updateCameraConfigData(localHashMap);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.setPtFaceAttr(paramPTFaceAttr);
    return this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.render(paramFrame);
  }
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2, PTFaceAttr paramPTFaceAttr)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterComposeFilter.a(paramFrame, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      paramFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig != null))
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      float f1 = this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig.jdField_a_of_type_Float * 2.0F - 1.0F;
      float f2 = this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig.b * 2.0F - 1.0F;
      float f3 = this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig.c * 2.0F + f1;
      float f4 = this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig.d * 2.0F + f2;
      this.jdField_a_of_type_ComTencentFilterBaseFilter.setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
      this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig.jdField_a_of_type_Int, paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
      GLES20.glDisable(3042);
    }
    this.jdField_c_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_c_of_type_ComTencentFilterBaseFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame);
    this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), 320, 320, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
    paramFrame = this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterPreMultiplyFilter.RenderProcess(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), 320, 320);
    paramPTFaceAttr = a(paramFrame, paramPTFaceAttr);
    paramFrame.unlock();
    return paramPTFaceAttr;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterComposeFilter.apply();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterPreMultiplyFilter.apply();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_c_of_type_ComTencentFilterBaseFilter.apply();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode != null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_JavaLangString = AEResUtil.e();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("template.json");
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig = new GifFilterProcess.TextConfig(this);
    AEGIFTextDrawer localAEGIFTextDrawer = new AEGIFTextDrawer((int)(paramFloat3 * 320.0F), (int)(320.0F * paramFloat4));
    localAEGIFTextDrawer.a(paramString1);
    localAEGIFTextDrawer.a(paramInt1);
    localAEGIFTextDrawer.b(paramString2);
    localAEGIFTextDrawer.c(paramString3);
    localAEGIFTextDrawer.a(paramInt2);
    localAEGIFTextDrawer.d(paramString4);
    localAEGIFTextDrawer.a();
    paramString1 = localAEGIFTextDrawer.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig.jdField_a_of_type_Int = RendererUtils.createTexture(paramString1);
    localAEGIFTextDrawer.b();
    paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig;
    paramString1.jdField_a_of_type_Float = paramFloat1;
    paramString1.b = paramFloat2;
    paramString1.c = paramFloat3;
    paramString1.d = paramFloat4;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterComposeFilter.clearGLSL();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterPreMultiplyFilter.clearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.clearGLSL();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.clearGLSL();
    this.jdField_c_of_type_ComTencentFilterBaseFilter.clearGLSL();
    this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode;
    if (localObject != null) {
      ((LightNode)localObject).clear();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess$TextConfig;
    if (localObject != null)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = ((GifFilterProcess.TextConfig)localObject).jdField_a_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.filter.GifFilterProcess
 * JD-Core Version:    0.7.0.1
 */