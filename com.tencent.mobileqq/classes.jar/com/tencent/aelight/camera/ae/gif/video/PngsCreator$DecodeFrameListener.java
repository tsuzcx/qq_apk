package com.tencent.aelight.camera.ae.gif.video;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.gif.filter.GifFilterProcess;
import com.tencent.aelight.camera.aebase.Util;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.Builder;
import com.tencent.view.RendererUtils;
import java.util.LinkedList;
import java.util.List;

class PngsCreator$DecodeFrameListener
  implements SurfaceTexture.OnFrameAvailableListener
{
  PngsCreator$DecodeFrameListener(PngsCreator paramPngsCreator) {}
  
  private PTFaceAttr a(PTFaceAttr paramPTFaceAttr)
  {
    if (paramPTFaceAttr == null) {
      return null;
    }
    return new PTFaceAttr(new PTFaceAttr.Builder().facePoints(a(paramPTFaceAttr.getAllFacePoints())).facePoint94(a(paramPTFaceAttr.getAllFacePoints94())).faceAngles(b(paramPTFaceAttr.getAllFaceAngles())).faceDetectScale(paramPTFaceAttr.getFaceDetectScale()));
  }
  
  private List<List<PointF>> a(List<List<PointF>> paramList)
  {
    LinkedList localLinkedList1 = new LinkedList();
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      List localList = (List)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int m = localList.size();
      int j = 0;
      while (j < m)
      {
        PointF localPointF = (PointF)localList.get(j);
        localLinkedList2.add(new PointF(localPointF.x, localPointF.y));
        j += 1;
      }
      localLinkedList1.add(localLinkedList2);
      i += 1;
    }
    return localLinkedList1;
  }
  
  private List<float[]> b(List<float[]> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      float[] arrayOfFloat1 = (float[])paramList.get(i);
      float[] arrayOfFloat2 = new float[arrayOfFloat1.length];
      int j = 0;
      while (j < arrayOfFloat1.length)
      {
        arrayOfFloat2[j] = arrayOfFloat1[j];
        j += 1;
      }
      localLinkedList.add(arrayOfFloat2);
      i += 1;
    }
    return localLinkedList;
  }
  
  @TargetApi(19)
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(PngsCreator.b(), 4, "PngsCreator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    PngsCreator.b(this.a).RenderProcess(PngsCreator.a(this.a), 960, 480, -1, 0.0D, PngsCreator.f(this.a));
    Object localObject = PngsCreator.c(this.a);
    Frame localFrame = PngsCreator.f(this.a);
    if (PngsCreator.h(this.a) < PngsCreator.i(this.a).size()) {
      paramSurfaceTexture = a((PTFaceAttr)PngsCreator.i(this.a).get(PngsCreator.h(this.a)));
    } else {
      paramSurfaceTexture = new PTFaceAttr(new PTFaceAttr.Builder());
    }
    paramSurfaceTexture = RendererUtils.saveTexture(((GifFilterProcess)localObject).a(localFrame, 480, 480, paramSurfaceTexture));
    paramSurfaceTexture.setPremultiplied(false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PngsCreator.j(this.a));
    ((StringBuilder)localObject).append("/frame_%03d.png");
    Util.a(String.format(((StringBuilder)localObject).toString(), new Object[] { Integer.valueOf(PngsCreator.h(this.a)) }), paramSurfaceTexture);
    paramSurfaceTexture.recycle();
    PngsCreator.k(this.a);
    if (!PngsCreator.e(this.a).a())
    {
      paramSurfaceTexture = PngsCreator.b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pngs create duration = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - PngsCreator.l(this.a));
      QLog.d(paramSurfaceTexture, 4, ((StringBuilder)localObject).toString());
      PngsCreator.m(this.a).a(PngsCreator.j(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreator.DecodeFrameListener
 * JD-Core Version:    0.7.0.1
 */