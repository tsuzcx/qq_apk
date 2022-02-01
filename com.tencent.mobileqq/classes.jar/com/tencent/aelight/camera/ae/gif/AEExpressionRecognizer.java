package com.tencent.aelight.camera.ae.gif;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.gif.filter.ConcatFilter;
import com.tencent.aelight.camera.ae.gif.filter.FaceCropFilter;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEExpressionRecognizer
{
  private AEExpressionRecognizer.RecommendTextCallback jdField_a_of_type_ComTencentAelightCameraAeGifAEExpressionRecognizer$RecommendTextCallback;
  private ConcatFilter jdField_a_of_type_ComTencentAelightCameraAeGifFilterConcatFilter = new ConcatFilter();
  private FaceCropFilter jdField_a_of_type_ComTencentAelightCameraAeGifFilterFaceCropFilter = new FaceCropFilter();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private List<Frame> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private Bitmap a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterConcatFilter.a(this.jdField_a_of_type_JavaUtilList);
    return RendererUtils.saveTexture(this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterConcatFilter.a());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterFaceCropFilter.apply();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterConcatFilter.apply();
  }
  
  public void a(int paramInt1, List<PointF> paramList, int paramInt2, int paramInt3)
  {
    paramList = this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterFaceCropFilter.a(paramInt1, paramList, paramInt2, paramInt3);
    paramList = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramList.getTextureId(), 64, 64);
    this.jdField_a_of_type_JavaUtilList.add(paramList);
  }
  
  public void a(AEExpressionRecognizer.RecommendTextCallback paramRecommendTextCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifAEExpressionRecognizer$RecommendTextCallback = paramRecommendTextCallback;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      AppInterface localAppInterface = QQStoryContext.a();
      CameraPeakServiceHandler localCameraPeakServiceHandler = (CameraPeakServiceHandler)localAppInterface.getBusinessHandler(PeakAppInterface.d);
      localAppInterface.addObserver(new AEExpressionRecognizer.1(this, localAppInterface));
      localCameraPeakServiceHandler.a(a());
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGifAEExpressionRecognizer$RecommendTextCallback.a(new RecognizedEmotionBean());
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).unlock();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).clear();
    }
    this.jdField_a_of_type_ComTencentFilterBaseFilter.clearGLSLSelf();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterFaceCropFilter.clearGLSLSelf();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifFilterConcatFilter.clearGLSLSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEExpressionRecognizer
 * JD-Core Version:    0.7.0.1
 */