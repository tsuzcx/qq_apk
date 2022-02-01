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
  private List<Frame> a = new ArrayList();
  private BaseFilter b = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private FaceCropFilter c = new FaceCropFilter();
  private ConcatFilter d = new ConcatFilter();
  private AEExpressionRecognizer.RecommendTextCallback e;
  
  private Bitmap f()
  {
    this.d.a(this.a);
    return RendererUtils.saveTexture(this.d.a());
  }
  
  public void a()
  {
    this.b.apply();
    this.c.apply();
    this.d.apply();
  }
  
  public void a(int paramInt1, List<PointF> paramList, int paramInt2, int paramInt3)
  {
    paramList = this.c.a(paramInt1, paramList, paramInt2, paramInt3);
    paramList = this.b.RenderProcess(paramList.getTextureId(), 64, 64);
    this.a.add(paramList);
  }
  
  public void a(AEExpressionRecognizer.RecommendTextCallback paramRecommendTextCallback)
  {
    this.e = paramRecommendTextCallback;
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  public void c()
  {
    if (!this.a.isEmpty())
    {
      AppInterface localAppInterface = QQStoryContext.k();
      CameraPeakServiceHandler localCameraPeakServiceHandler = (CameraPeakServiceHandler)localAppInterface.getBusinessHandler(PeakAppInterface.e);
      localAppInterface.addObserver(new AEExpressionRecognizer.1(this, localAppInterface));
      localCameraPeakServiceHandler.a(f());
      return;
    }
    this.e.a(new RecognizedEmotionBean());
  }
  
  public void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).unlock();
    }
    this.a.clear();
  }
  
  public void e()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).clear();
    }
    this.b.clearGLSLSelf();
    this.c.clearGLSLSelf();
    this.d.clearGLSLSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEExpressionRecognizer
 * JD-Core Version:    0.7.0.1
 */