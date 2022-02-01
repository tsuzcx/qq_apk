package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.FaceRects;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.filter.aifilter.AIImageFilterResult;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResponse;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import mqq.util.WeakReference;

abstract class AIFilterProxyBase
{
  private static final String d = "AIFilterProxyBase";
  protected int a = 1;
  protected List<Bitmap> b = new ArrayList();
  protected List<Bitmap> c = new ArrayList();
  private WeakReference<AEEditorAIFilterManager.AIFilterObserver> e;
  private PhotoAIFilter f = new PhotoAIFilter();
  
  private SmartFilterReqItem a(Context paramContext, Bitmap paramBitmap, ArrayList<FaceRects> paramArrayList)
  {
    if (paramBitmap == null) {
      return null;
    }
    double d1 = Math.sqrt(25600.0F / this.a);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    if ((paramBitmap.getWidth() <= d1) && (paramBitmap.getHeight() <= d1))
    {
      paramContext = paramBitmap;
    }
    else
    {
      paramContext = new Matrix();
      double d2 = paramBitmap.getWidth();
      Double.isNaN(d2);
      d2 = d1 / d2;
      double d3 = paramBitmap.getHeight();
      Double.isNaN(d3);
      float f1 = (float)Math.max(d2, d1 / d3);
      paramContext.postScale(f1, f1);
      paramContext = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramContext, true);
      i = 1;
    }
    paramContext.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    paramBitmap = new SmartFilterReqItem(localByteArrayOutputStream.toByteArray(), paramArrayList);
    try
    {
      localByteArrayOutputStream.close();
    }
    catch (IOException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    if ((i != 0) && (paramContext != null)) {
      BitmapUtils.recycle(paramContext);
    }
    return paramBitmap;
  }
  
  protected static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString.split("\\.")[0];
    paramString = AEEditorResourceManager.a().c(str);
    Object localObject1 = d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("parseLutBySceneLabel--select lut=");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(", path=");
    ((StringBuilder)localObject2).append(paramString);
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    if ((paramString == null) || (!new File(paramString).exists()))
    {
      localObject1 = d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseLutBySceneLabel--used lut not exists, id=");
      ((StringBuilder)localObject2).append(str);
      AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject2 = new CountDownLatch(1);
      localObject1 = new boolean[1];
      AEEditorResourceManager.a().a(str, new AIFilterProxyBase.1((boolean[])localObject1, (CountDownLatch)localObject2));
      try
      {
        ((CountDownLatch)localObject2).await();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (localObject1[0] != 0) {
        AEQLog.b(d, "parseLutBySceneLabel--download SUCCESS");
      }
    }
    else
    {
      return paramString;
    }
    AEQLog.b(d, "parseLutBySceneLabel--download FAIL");
    return null;
  }
  
  private ArrayList<SmartFilterReqItem> a(Context paramContext, List<Bitmap> paramList, List<PTFaceAttr> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      Bitmap localBitmap = (Bitmap)paramList.get(i);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramList1 != null)
      {
        localObject1 = localObject2;
        if (paramList1.size() > i) {
          localObject1 = a((PTFaceAttr)paramList1.get(i));
        }
      }
      localArrayList.add(a(paramContext, localBitmap, (ArrayList)localObject1));
      i += 1;
    }
    return localArrayList;
  }
  
  public static ArrayList<FaceRects> a(PTFaceAttr paramPTFaceAttr)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramPTFaceAttr != null)
    {
      Iterator localIterator = paramPTFaceAttr.getAllFacePoints().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (List)localIterator.next();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          float f6 = 0.0F;
          float f4 = 0.0F;
          float f5 = 0.0F;
          float f7 = 0.0F;
          float f8 = 3.4028235E+38F;
          float f3 = 1.4E-45F;
          float f2 = 3.4028235E+38F;
          float f1 = 1.4E-45F;
          while (((Iterator)localObject).hasNext())
          {
            PointF localPointF = (PointF)((Iterator)localObject).next();
            f8 = Math.min(f8, localPointF.x);
            f3 = Math.max(f3, localPointF.x);
            f2 = Math.min(f2, localPointF.y);
            f1 = Math.max(f1, localPointF.y);
            f6 = f8 / paramPTFaceAttr.getFaceDetWidth();
            f4 = f2 / paramPTFaceAttr.getFaceDetHeight();
            f5 = (f3 - f8) / paramPTFaceAttr.getFaceDetWidth();
            f7 = (f1 - f2) / paramPTFaceAttr.getFaceDetHeight();
          }
          localArrayList.add(new FaceRects(f6, f4, f5, f7));
        }
      }
    }
    return localArrayList;
  }
  
  public static List<Bitmap> a(List<String> paramList, List<AEEditorImageInfo> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int j = 0;
      while ((j < paramList.size()) && (j < paramList1.size()))
      {
        Object localObject = (String)paramList.get(j);
        CropConfig localCropConfig = ((AEEditorImageInfo)paramList1.get(j)).d;
        int m = Math.max(((AEEditorImageInfo)paramList1.get(j)).b, ((AEEditorImageInfo)paramList1.get(j)).c);
        int k = 1;
        int i = 1;
        if (m > 400) {
          for (;;)
          {
            k = i;
            if (m / i <= 400) {
              break;
            }
            i *= 2;
          }
        }
        AEQLog.a(d, "decodeBitmap: start ");
        localObject = BitmapUtil.cropBitmap((String)localObject, localCropConfig, k);
        AEQLog.a(d, "decodeBitmap: end ");
        localArrayList.add(localObject);
        j += 1;
      }
    }
    return localArrayList;
  }
  
  protected static String b(String paramString)
  {
    Object localObject1 = NewEnhanceCategories.COMMON;
    Object localObject3 = NewEnhanceCategories.newEnhanceTypes.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (NewEnhanceCategories)((Iterator)localObject3).next();
      if (((NewEnhanceCategories)localObject2).serverLabel.equals(paramString)) {
        localObject1 = localObject2;
      }
    }
    localObject1 = localObject1.fileName.split("\\.")[0];
    paramString = AEEditorResourceManager.a().c((String)localObject1);
    Object localObject2 = d;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("parseLutBySceneLabel--select lut=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", path=");
    ((StringBuilder)localObject3).append(paramString);
    AEQLog.b((String)localObject2, ((StringBuilder)localObject3).toString());
    if ((paramString != null) && (new File(paramString).exists())) {
      return paramString;
    }
    localObject2 = d;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("parseLutBySceneLabel--used lut not exists, id=");
    ((StringBuilder)localObject3).append((String)localObject1);
    AEQLog.b((String)localObject2, ((StringBuilder)localObject3).toString());
    localObject3 = new CountDownLatch(1);
    localObject2 = new boolean[1];
    AEEditorResourceManager.a().a((String)localObject1, new AIFilterProxyBase.2((boolean[])localObject2, (CountDownLatch)localObject3));
    try
    {
      ((CountDownLatch)localObject3).await();
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    if (localObject2[0] != 0)
    {
      AEQLog.b(d, "parseLutBySceneLabel--download SUCCESS");
      return paramString;
    }
    AEQLog.b(d, "parseLutBySceneLabel--download FAIL");
    return null;
  }
  
  protected static String b(List<AIFilterResponse> paramList)
  {
    AEQLog.b(d, "voteLable");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject1 = new HashMap();
      int i = 0;
      String str;
      while (i < paramList.size())
      {
        str = ((AIFilterResponse)paramList.get(i)).a;
        if (((Map)localObject1).containsKey(str)) {
          ((Map)localObject1).put(str, Integer.valueOf(((Integer)((Map)localObject1).get(str)).intValue() + 1));
        } else {
          ((Map)localObject1).put(str, Integer.valueOf(0));
        }
        i += 1;
      }
      Iterator localIterator = ((Map)localObject1).entrySet().iterator();
      paramList = (Map.Entry)localIterator.next();
      localObject1 = (String)paramList.getKey();
      paramList = (Integer)paramList.getValue();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (Integer)((Map.Entry)localObject2).getValue();
        if (paramList.intValue() < ((Integer)localObject2).intValue())
        {
          paramList = (List<AIFilterResponse>)localObject2;
          localObject1 = str;
        }
      }
      return localObject1;
    }
    return null;
  }
  
  private void b(Context paramContext, List<Bitmap> paramList, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    AEQLog.b(d, "doFaceDetect");
    if (paramList == null) {
      paramList = null;
    } else {
      paramList = new LinkedList(paramList);
    }
    if (paramList == null)
    {
      if (paramAIFilterProxyCallback != null) {
        paramAIFilterProxyCallback.a(-2);
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      AEQLog.a(d, "doFaceDetect start");
      float f1 = Math.max(localBitmap.getHeight(), localBitmap.getWidth());
      localArrayList.add(this.f.doFaceDetect(localBitmap));
      AEQLog.a(d, "doFaceDetect end");
    }
    paramContext = a(paramContext, paramList, localArrayList);
    if ((paramContext != null) && (paramContext.size() != 0))
    {
      if (paramAIFilterProxyCallback != null) {
        paramAIFilterProxyCallback.a(paramContext);
      }
      return;
    }
    if (paramAIFilterProxyCallback != null) {
      paramAIFilterProxyCallback.a(-3);
    }
  }
  
  protected abstract AIFilterResult a(List<AIFilterResponse> paramList);
  
  protected SingleImageAIFilterResult a(AIFilterResponse paramAIFilterResponse)
  {
    SingleImageAIFilterResult localSingleImageAIFilterResult = new SingleImageAIFilterResult();
    if (c(this.b)) {
      try
      {
        localSingleImageAIFilterResult.b = PhotoAIFilter.preprocessImages(this.b);
      }
      catch (Exception localException)
      {
        AEQLog.d(d, Log.getStackTraceString(localException));
      }
    }
    localSingleImageAIFilterResult.f = AEEditorAIFilterManager.a(localSingleImageAIFilterResult.b);
    Object localObject1 = new ArrayList();
    if (paramAIFilterResponse == null)
    {
      localObject2 = NewEnhanceCategories.COMMON.serverLabel;
      localSingleImageAIFilterResult.a = true;
      AEQLog.b(d, "result is exception");
      paramAIFilterResponse = (AIFilterResponse)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = paramAIFilterResponse.a;
      paramAIFilterResponse = paramAIFilterResponse.b;
    }
    Object localObject2 = d;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sceneLabel: ");
    ((StringBuilder)localObject3).append((String)localObject1);
    AEQLog.b((String)localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = paramAIFilterResponse.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (YoutuResultItem)((Iterator)localObject2).next();
      String str = d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("label: ");
      localStringBuilder.append(((YoutuResultItem)localObject3).Label);
      localStringBuilder.append(", confidence: ");
      localStringBuilder.append(((YoutuResultItem)localObject3).Confidence);
      AEQLog.b(str, localStringBuilder.toString());
    }
    localSingleImageAIFilterResult.d = ((String)localObject1);
    localSingleImageAIFilterResult.c = paramAIFilterResponse;
    PhotoAIFilter.setAIImageJsonPath(AEEditorResourceManager.a().l());
    PhotoAIFilter.setLutImagePath("");
    paramAIFilterResponse = PhotoAIFilter.parseAIImageParamsBySceneLabel(localSingleImageAIFilterResult.d);
    localSingleImageAIFilterResult.e = a(paramAIFilterResponse.lutPath);
    localSingleImageAIFilterResult.g = paramAIFilterResponse.lutStrengt;
    localSingleImageAIFilterResult.i = paramAIFilterResponse.adjustParam;
    localSingleImageAIFilterResult.j = paramAIFilterResponse.smoothLevel;
    localSingleImageAIFilterResult.h = paramAIFilterResponse.glowStrength;
    return localSingleImageAIFilterResult;
  }
  
  protected abstract void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback);
  
  protected void a(Context paramContext, List<Bitmap> paramList, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    AEQLog.b(d, "faceDetect");
    if ((paramList != null) && (c(paramList)))
    {
      FaceChangeUtils.runInGLThread(new AIFilterProxyBase.3(this, paramContext, paramList, paramAIFilterProxyCallback), false, "");
      return;
    }
    if (paramAIFilterProxyCallback != null) {
      paramAIFilterProxyCallback.a(-2);
    }
  }
  
  public void a(AEEditorAIFilterManager.AIFilterObserver paramAIFilterObserver)
  {
    this.e = new WeakReference(paramAIFilterObserver);
  }
  
  public abstract boolean a();
  
  public void b()
  {
    AEQLog.b(d, "removeObserver");
    this.e = null;
  }
  
  public AEEditorAIFilterManager.AIFilterObserver c()
  {
    WeakReference localWeakReference = this.e;
    if (localWeakReference == null) {
      return null;
    }
    return (AEEditorAIFilterManager.AIFilterObserver)localWeakReference.get();
  }
  
  protected boolean c(List<Bitmap> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!BitmapUtils.isLegal((Bitmap)paramList.next())) {
        return false;
      }
    }
    return true;
  }
  
  protected AIFilterResult d()
  {
    return a(null);
  }
  
  public void e()
  {
    AEQLog.b(d, "clear");
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        BitmapUtils.recycle((Bitmap)((Iterator)localObject).next());
      }
      this.b.clear();
    }
    localObject = this.c;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext()) {
        BitmapUtils.recycle((Bitmap)((Iterator)localObject).next());
      }
      this.c.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterProxyBase
 * JD-Core Version:    0.7.0.1
 */