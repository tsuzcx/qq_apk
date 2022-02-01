package com.tencent.av.opengl.multiplevideos;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIAttrProvider;
import com.tencent.av.opengl.multiplevideos.renderbase.Filter;
import com.tencent.av.opengl.multiplevideos.renderbase.RefFrame;
import com.tencent.av.opengl.multiplevideos.renderbase.RefFrame.FaceData;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.openapi.filter.FacePointsFilter;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Lcom.tencent.av.opengl.multiplevideos.renderbase.RefFrame;>;
import org.jetbrains.annotations.NotNull;

public class AEFilter
  extends Filter
{
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private AIAttr jdField_a_of_type_ComTencentAekitPluginCoreAIAttr = new AIAttr(new AIAttrProvider(null));
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter;
  private FacePointsFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter;
  private LightNode jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private final String jdField_a_of_type_JavaLangString = "AEFilter-" + Integer.toHexString(hashCode());
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  
  public AEFilter()
  {
    super(1);
  }
  
  private Frame a(List<RefFrame.FaceData> paramList, Frame paramFrame)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      float[][] arrayOfFloat = ((TTFaceOriginDataModel)((RefFrame.FaceData)paramList.get(i)).jdField_a_of_type_JavaUtilList.get(0)).facePoint;
      ArrayList localArrayList2 = new ArrayList(arrayOfFloat.length);
      int j = 0;
      while (j < arrayOfFloat.length)
      {
        localArrayList2.add(new PointF(arrayOfFloat[j][0], arrayOfFloat[j][1]));
        j += 1;
      }
      localArrayList1.add(localArrayList2);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.updateVideoSize(paramFrame.width, paramFrame.height, 1.0D);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.updateMultiPoints(localArrayList1);
    return this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.render(paramFrame);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode == null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null))
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode = new LightNode();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.updateAsset(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getLightAsset());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.apply();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.clear();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode = null;
    }
  }
  
  @NotNull
  public Frame a(List<RefFrame> paramList, long paramLong)
  {
    RefFrame localRefFrame = (RefFrame)paramList.get(0);
    paramList = ((RefFrame)paramList.get(0)).jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramList.getTextureId(), paramList.width, paramList.height, -1, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
    Object localObject1 = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    Object localObject2 = new ArrayList();
    if (localRefFrame.a())
    {
      int i = 0;
      while (i < localRefFrame.jdField_a_of_type_JavaUtilList.size())
      {
        ((List)localObject2).addAll(((RefFrame.FaceData)localRefFrame.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaUtilList);
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode != null)
    {
      paramList = FaceDetectUtil.genFaceAttr((List)localObject2, paramList.width, paramList.height, 0);
      this.jdField_a_of_type_ComTencentAekitPluginCoreAIAttr.setFaceAttr(paramList);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.updatePreviewSize(((Frame)localObject1).width, ((Frame)localObject1).height);
      localObject2 = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode.render((Frame)localObject1);
      paramList = (List<RefFrame>)localObject2;
      if (localObject1 != localObject2)
      {
        paramList = (List<RefFrame>)localObject2;
        if (!((Frame)localObject1).unlock()) {
          ((Frame)localObject1).clear();
        }
      }
    }
    for (paramList = (List<RefFrame>)localObject2;; paramList = (List<RefFrame>)localObject1)
    {
      localObject1 = paramList;
      if (this.d)
      {
        localObject1 = paramList;
        if (localRefFrame.a())
        {
          localObject1 = a(localRefFrame.jdField_a_of_type_JavaUtilList, paramList);
          if ((localObject1 != paramList) && (!paramList.unlock())) {
            paramList.clear();
          }
        }
      }
      paramList = this.jdField_a_of_type_ComTencentFilterBaseFilter.render((Frame)localObject1);
      if (localObject1 != paramList) {
        ((Frame)localObject1).unlock();
      }
      return paramList;
    }
  }
  
  public void a()
  {
    d();
    if ((this.d) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter == null))
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter = new FacePointsFilter();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.apply();
    }
    this.jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit: create filter#" + Integer.toHexString(this.jdField_a_of_type_ComTencentFilterBaseFilter.hashCode()));
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit: create frame#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.hashCode()));
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      e();
      return;
    }
    e();
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = VideoSDKMaterialParser.parseVideoMaterial(this.jdField_b_of_type_JavaLangString, "params");
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: parse material=" + this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getId());
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.isGestureDetectMaterial();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needBodyDetect();
    this.c = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needBodySegment();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: gesture=" + this.jdField_a_of_type_Boolean + ", body=" + this.jdField_b_of_type_Boolean + ", segment=" + this.c);
    d();
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame != null)
    {
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy: frame#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.hashCode()) + " cleared");
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.clear();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.AEFilter
 * JD-Core Version:    0.7.0.1
 */