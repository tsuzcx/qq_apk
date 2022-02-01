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
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.util.BitmapUtil;
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
  private static final String jdField_a_of_type_JavaLangString = "AIFilterProxyBase";
  protected int a;
  private PhotoAIFilter jdField_a_of_type_ComTencentTtpicFilterAifilterPhotoAIFilter = new PhotoAIFilter();
  protected List<Bitmap> a;
  private WeakReference<AEEditorAIFilterManager.AIFilterObserver> jdField_a_of_type_MqqUtilWeakReference;
  protected List<Bitmap> b = new ArrayList();
  
  public AIFilterProxyBase()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private SmartFilterReqItem a(Context paramContext, Bitmap paramBitmap, ArrayList<FaceRects> paramArrayList)
  {
    if (paramBitmap == null) {
      return null;
    }
    double d1 = Math.sqrt(25600.0F / this.jdField_a_of_type_Int);
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
      float f = (float)Math.max(d2, d1 / d3);
      paramContext.postScale(f, f);
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
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("parseLutBySceneLabel--select lut=");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(", path=");
    ((StringBuilder)localObject2).append(paramString);
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    if ((paramString == null) || (!new File(paramString).exists()))
    {
      localObject1 = jdField_a_of_type_JavaLangString;
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
        AEQLog.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--download SUCCESS");
      }
    }
    else
    {
      return paramString;
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--download FAIL");
    return null;
  }
  
  protected static String a(List<AIFilterResponse> paramList)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "voteLable");
    Object localObject1 = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      if (((Map)localObject1).containsKey(paramList.get(i))) {
        ((Map)localObject1).put(((AIFilterResponse)paramList.get(i)).jdField_a_of_type_JavaLangString, Integer.valueOf(((Integer)((Map)localObject1).get(paramList.get(i))).intValue() + 1));
      } else {
        ((Map)localObject1).put(((AIFilterResponse)paramList.get(i)).jdField_a_of_type_JavaLangString, Integer.valueOf(0));
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
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Integer)((Map.Entry)localObject2).getValue();
      if (paramList.intValue() < ((Integer)localObject2).intValue())
      {
        paramList = (List<AIFilterResponse>)localObject2;
        localObject1 = str;
      }
    }
    return localObject1;
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
        CropConfig localCropConfig = ((AEEditorImageInfo)paramList1.get(j)).jdField_a_of_type_ComTencentTavcutBeanCropConfig;
        int m = Math.max(((AEEditorImageInfo)paramList1.get(j)).jdField_a_of_type_Int, ((AEEditorImageInfo)paramList1.get(j)).b);
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
        AEQLog.a(jdField_a_of_type_JavaLangString, "decodeBitmap: start ");
        localObject = BitmapUtil.cropBitmap((String)localObject, localCropConfig, k);
        AEQLog.a(jdField_a_of_type_JavaLangString, "decodeBitmap: end ");
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
    Object localObject2 = jdField_a_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("parseLutBySceneLabel--select lut=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", path=");
    ((StringBuilder)localObject3).append(paramString);
    AEQLog.b((String)localObject2, ((StringBuilder)localObject3).toString());
    if ((paramString != null) && (new File(paramString).exists())) {
      return paramString;
    }
    localObject2 = jdField_a_of_type_JavaLangString;
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
      AEQLog.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--download SUCCESS");
      return paramString;
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--download FAIL");
    return null;
  }
  
  private void b(Context paramContext, List<Bitmap> paramList, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "doFaceDetect");
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
      AEQLog.a(jdField_a_of_type_JavaLangString, "doFaceDetect start");
      float f = Math.max(localBitmap.getHeight(), localBitmap.getWidth());
      localArrayList.add(this.jdField_a_of_type_ComTencentTtpicFilterAifilterPhotoAIFilter.doFaceDetect(localBitmap));
      AEQLog.a(jdField_a_of_type_JavaLangString, "doFaceDetect end");
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
  
  public AEEditorAIFilterManager.AIFilterObserver a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (AEEditorAIFilterManager.AIFilterObserver)localWeakReference.get();
  }
  
  protected AIFilterResult a()
  {
    return a(null);
  }
  
  protected abstract AIFilterResult a(List<AIFilterResponse> paramList);
  
  protected SingleImageAIFilterResult a(AIFilterResponse paramAIFilterResponse)
  {
    SingleImageAIFilterResult localSingleImageAIFilterResult = new SingleImageAIFilterResult();
    if (a(this.jdField_a_of_type_JavaUtilList)) {
      try
      {
        localSingleImageAIFilterResult.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData = PhotoAIFilter.preprocessImages(this.jdField_a_of_type_JavaUtilList);
      }
      catch (Exception localException)
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(localException));
      }
    }
    localSingleImageAIFilterResult.jdField_a_of_type_ArrayOfFloat = AEEditorAIFilterManager.a(localSingleImageAIFilterResult.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
    Object localObject1 = new ArrayList();
    if (paramAIFilterResponse == null)
    {
      localObject2 = NewEnhanceCategories.COMMON.serverLabel;
      localSingleImageAIFilterResult.jdField_a_of_type_Boolean = true;
      AEQLog.b(jdField_a_of_type_JavaLangString, "result is exception");
      paramAIFilterResponse = (AIFilterResponse)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = paramAIFilterResponse.jdField_a_of_type_JavaLangString;
      paramAIFilterResponse = paramAIFilterResponse.jdField_a_of_type_JavaUtilList;
    }
    Object localObject2 = jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sceneLabel: ");
    ((StringBuilder)localObject3).append((String)localObject1);
    AEQLog.b((String)localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = paramAIFilterResponse.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (YoutuResultItem)((Iterator)localObject2).next();
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("label: ");
      localStringBuilder.append(((YoutuResultItem)localObject3).Label);
      localStringBuilder.append(", confidence: ");
      localStringBuilder.append(((YoutuResultItem)localObject3).Confidence);
      AEQLog.b(str, localStringBuilder.toString());
    }
    localSingleImageAIFilterResult.jdField_a_of_type_JavaLangString = ((String)localObject1);
    localSingleImageAIFilterResult.jdField_a_of_type_JavaUtilList = paramAIFilterResponse;
    PhotoAIFilter.setAIImageJsonPath(AEEditorResourceManager.a().a());
    PhotoAIFilter.setLutImagePath("");
    paramAIFilterResponse = PhotoAIFilter.parseAIImageParamsBySceneLabel(localSingleImageAIFilterResult.jdField_a_of_type_JavaLangString);
    localSingleImageAIFilterResult.jdField_b_of_type_JavaLangString = a(paramAIFilterResponse.lutPath);
    localSingleImageAIFilterResult.jdField_a_of_type_Float = paramAIFilterResponse.lutStrengt;
    localSingleImageAIFilterResult.jdField_a_of_type_JavaUtilHashMap = paramAIFilterResponse.adjustParam;
    localSingleImageAIFilterResult.c = paramAIFilterResponse.smoothLevel;
    localSingleImageAIFilterResult.jdField_b_of_type_Float = paramAIFilterResponse.glowStrength;
    return localSingleImageAIFilterResult;
  }
  
  public void a()
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "removeObserver");
    this.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  protected abstract void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback);
  
  protected void a(Context paramContext, List<Bitmap> paramList, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "faceDetect");
    if ((paramList != null) && (a(paramList)))
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
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAIFilterObserver);
  }
  
  public abstract boolean a();
  
  protected boolean a(List<Bitmap> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!BitmapUtils.isLegal((Bitmap)paramList.next())) {
        return false;
      }
    }
    return true;
  }
  
  public void b()
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "clear");
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        BitmapUtils.recycle((Bitmap)((Iterator)localObject).next());
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        BitmapUtils.recycle((Bitmap)((Iterator)localObject).next());
      }
      this.b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterProxyBase
 * JD-Core Version:    0.7.0.1
 */