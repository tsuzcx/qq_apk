import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.FaceRects;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.filter.aifilter.AIImageFilterResult;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import com.tencent.ttpic.openapi.PTFaceAttr;
import dov.com.qq.im.ae.play.FaceChangeUtils;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterProxyBase.3;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import mqq.util.WeakReference;

public abstract class bnvy
{
  private static final String jdField_a_of_type_JavaLangString = bnvy.class.getSimpleName();
  public int a;
  private PhotoAIFilter jdField_a_of_type_ComTencentTtpicFilterAifilterPhotoAIFilter = new PhotoAIFilter();
  public List<Bitmap> a;
  private WeakReference<bnvc> jdField_a_of_type_MqqUtilWeakReference;
  public List<Bitmap> b = new ArrayList();
  
  public bnvy()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private SmartFilterReqItem a(Context paramContext, Bitmap paramBitmap, ArrayList<FaceRects> paramArrayList)
  {
    int i = 0;
    if (paramBitmap == null) {
      paramBitmap = null;
    }
    for (;;)
    {
      return paramBitmap;
      double d = Math.sqrt(25600.0F / this.jdField_a_of_type_Int);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      if (paramBitmap.getWidth() <= d)
      {
        paramContext = paramBitmap;
        if (paramBitmap.getHeight() <= d) {}
      }
      else
      {
        paramContext = new Matrix();
        d = Math.max(d / paramBitmap.getWidth(), d / paramBitmap.getHeight());
        paramContext.postScale((float)d, (float)d);
        paramContext = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramContext, true);
        i = 1;
      }
      paramContext.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      paramArrayList = new SmartFilterReqItem(localByteArrayOutputStream.toByteArray(), paramArrayList);
      try
      {
        localByteArrayOutputStream.close();
        paramBitmap = paramArrayList;
        if (i == 0) {
          continue;
        }
        paramBitmap = paramArrayList;
        if (paramContext == null) {
          continue;
        }
        BitmapUtils.recycle(paramContext);
        return paramArrayList;
      }
      catch (IOException paramBitmap)
      {
        for (;;)
        {
          paramBitmap.printStackTrace();
        }
      }
    }
  }
  
  protected static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString.split("\\.")[0];
    paramString = boaf.a().c(str);
    bnrh.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--select lut=" + str + ", path=" + paramString);
    if ((paramString != null) && (new File(paramString).exists())) {}
    for (;;)
    {
      return paramString;
      bnrh.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--used lut not exists, id=" + str);
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      boolean[] arrayOfBoolean = new boolean[1];
      boaf.a().a(str, new bnvz(arrayOfBoolean, localCountDownLatch));
      try
      {
        localCountDownLatch.await();
        if (arrayOfBoolean[0] != 0) {
          bnrh.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--download SUCCESS");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        bnrh.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--download FAIL");
        paramString = null;
      }
    }
  }
  
  protected static String a(List<bnwc> paramList)
  {
    bnrh.b(jdField_a_of_type_JavaLangString, "voteLable");
    Object localObject1 = new HashMap();
    int i = 0;
    if (i < paramList.size())
    {
      if (((Map)localObject1).containsKey(paramList.get(i))) {
        ((Map)localObject1).put(((bnwc)paramList.get(i)).jdField_a_of_type_JavaLangString, Integer.valueOf(((Integer)((Map)localObject1).get(paramList.get(i))).intValue() + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((Map)localObject1).put(((bnwc)paramList.get(i)).jdField_a_of_type_JavaLangString, Integer.valueOf(0));
      }
    }
    Iterator localIterator = ((Map)localObject1).entrySet().iterator();
    localObject1 = (Map.Entry)localIterator.next();
    paramList = (String)((Map.Entry)localObject1).getKey();
    localObject1 = (Integer)((Map.Entry)localObject1).getValue();
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Integer)((Map.Entry)localObject2).getValue();
      if (((Integer)localObject1).intValue() >= ((Integer)localObject2).intValue()) {
        break label233;
      }
      paramList = str;
      localObject1 = localObject2;
    }
    label233:
    for (;;)
    {
      break;
      return paramList;
    }
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
    Iterator localIterator = paramPTFaceAttr.getAllFacePoints().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        float f4 = 0.0F;
        float f1 = 1.4E-45F;
        float f6 = 1.4E-45F;
        float f8 = 3.4028235E+38F;
        float f5 = 0.0F;
        float f3 = 0.0F;
        float f2 = 3.4028235E+38F;
        float f7 = 0.0F;
        while (((Iterator)localObject).hasNext())
        {
          PointF localPointF = (PointF)((Iterator)localObject).next();
          f8 = Math.min(f8, localPointF.x);
          f6 = Math.max(f6, localPointF.x);
          f2 = Math.min(f2, localPointF.y);
          f1 = Math.max(f1, localPointF.y);
          f5 = f8 / paramPTFaceAttr.getFaceDetWidth();
          f3 = f2 / paramPTFaceAttr.getFaceDetHeight();
          f7 = (f6 - f8) / paramPTFaceAttr.getFaceDetWidth();
          f4 = (f1 - f2) / paramPTFaceAttr.getFaceDetHeight();
        }
        localArrayList.add(new FaceRects(f5, f3, f7, f4));
      }
    }
    return localArrayList;
  }
  
  public static List<Bitmap> a(List<String> paramList, List<bnsw> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int j = 0;
      while ((j < paramList.size()) && (j < paramList1.size()))
      {
        Object localObject = (String)paramList.get(j);
        CropConfig localCropConfig = ((bnsw)paramList1.get(j)).jdField_a_of_type_ComTencentTavcutBeanCropConfig;
        int m = Math.max(((bnsw)paramList1.get(j)).jdField_a_of_type_Int, ((bnsw)paramList1.get(j)).b);
        if (m > 400)
        {
          int i = 1;
          for (;;)
          {
            k = i;
            if (m / i <= 400) {
              break;
            }
            i *= 2;
          }
        }
        int k = 1;
        bnrh.a(jdField_a_of_type_JavaLangString, "decodeBitmap: start ");
        localObject = BitmapUtil.cropBitmap((String)localObject, localCropConfig, k);
        bnrh.a(jdField_a_of_type_JavaLangString, "decodeBitmap: end ");
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
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (NewEnhanceCategories)((Iterator)localObject3).next();
      if (!((NewEnhanceCategories)localObject2).serverLabel.equals(paramString)) {
        break label214;
      }
      localObject1 = localObject2;
    }
    label214:
    for (;;)
    {
      break;
      localObject2 = localObject1.fileName.split("\\.")[0];
      paramString = boaf.a().c((String)localObject2);
      bnrh.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--select lut=" + (String)localObject2 + ", path=" + paramString);
      if ((paramString != null) && (new File(paramString).exists())) {
        return paramString;
      }
      bnrh.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--used lut not exists, id=" + (String)localObject2);
      localObject3 = new CountDownLatch(1);
      localObject1 = new boolean[1];
      boaf.a().a((String)localObject2, new bnwa((boolean[])localObject1, (CountDownLatch)localObject3));
      try
      {
        ((CountDownLatch)localObject3).await();
        if (localObject1[0] != 0)
        {
          bnrh.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--download SUCCESS");
          return paramString;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        bnrh.b(jdField_a_of_type_JavaLangString, "parseLutBySceneLabel--download FAIL");
        return null;
      }
    }
  }
  
  private void b(Context paramContext, List<Bitmap> paramList, bnwb parambnwb)
  {
    bnrh.b(jdField_a_of_type_JavaLangString, "doFaceDetect");
    if (paramList == null)
    {
      paramList = null;
      if (paramList != null) {
        break label44;
      }
      if (parambnwb != null) {
        parambnwb.a(-2);
      }
    }
    label44:
    label193:
    do
    {
      do
      {
        return;
        paramList = new LinkedList(paramList);
        break;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)localIterator.next();
          bnrh.a(jdField_a_of_type_JavaLangString, "doFaceDetect start");
          int i = Math.max(localBitmap.getHeight(), localBitmap.getWidth());
          float f = 1.0F;
          if (i > 240.0F) {
            f = 240.0F / i;
          }
          localArrayList.add(this.jdField_a_of_type_ComTencentTtpicFilterAifilterPhotoAIFilter.doFaceDetect(localBitmap, f));
          bnrh.a(jdField_a_of_type_JavaLangString, "doFaceDetect end");
        }
        paramContext = a(paramContext, paramList, localArrayList);
        if ((paramContext != null) && (paramContext.size() != 0)) {
          break label193;
        }
      } while (parambnwb == null);
      parambnwb.a(-3);
      return;
    } while (parambnwb == null);
    parambnwb.a(paramContext);
  }
  
  public bnvc a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return null;
    }
    return (bnvc)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  protected bnwd a()
  {
    return a(null);
  }
  
  protected abstract bnwd a(List<bnwc> paramList);
  
  protected bnwm a(bnwc parambnwc)
  {
    bnwm localbnwm = new bnwm();
    if (a(this.jdField_a_of_type_JavaUtilList)) {}
    try
    {
      localbnwm.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData = PhotoAIFilter.preprocessImages(this.jdField_a_of_type_JavaUtilList);
      localbnwm.jdField_a_of_type_ArrayOfFloat = bnuz.a(localbnwm.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
      Object localObject = new ArrayList();
      if (parambnwc == null)
      {
        String str1 = NewEnhanceCategories.COMMON.serverLabel;
        localbnwm.jdField_a_of_type_Boolean = true;
        bnrh.b(jdField_a_of_type_JavaLangString, "result is exception");
        parambnwc = (bnwc)localObject;
        bnrh.b(jdField_a_of_type_JavaLangString, "sceneLabel: " + str1);
        localObject = parambnwc.iterator();
        while (((Iterator)localObject).hasNext())
        {
          YoutuResultItem localYoutuResultItem = (YoutuResultItem)((Iterator)localObject).next();
          bnrh.b(jdField_a_of_type_JavaLangString, "label: " + localYoutuResultItem.Label + ", confidence: " + localYoutuResultItem.Confidence);
        }
      }
    }
    catch (Exception localException)
    {
      String str2;
      for (;;)
      {
        bnrh.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(localException));
        continue;
        str2 = parambnwc.jdField_a_of_type_JavaLangString;
        parambnwc = parambnwc.jdField_a_of_type_JavaUtilList;
      }
      localbnwm.jdField_a_of_type_JavaLangString = str2;
      localbnwm.jdField_a_of_type_JavaUtilList = parambnwc;
      PhotoAIFilter.setAIImageJsonPath(boaf.a().a());
      PhotoAIFilter.setLutImagePath("");
      parambnwc = PhotoAIFilter.parseAIImageParamsBySceneLabel(localbnwm.jdField_a_of_type_JavaLangString);
      localbnwm.jdField_b_of_type_JavaLangString = a(parambnwc.lutPath);
      localbnwm.jdField_a_of_type_Float = parambnwc.lutStrengt;
      localbnwm.jdField_a_of_type_JavaUtilHashMap = parambnwc.adjustParam;
      localbnwm.c = parambnwc.smoothLevel;
      localbnwm.jdField_b_of_type_Float = parambnwc.glowStrength;
    }
    return localbnwm;
  }
  
  public void a()
  {
    bnrh.b(jdField_a_of_type_JavaLangString, "removeObserver");
    this.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  protected abstract void a(Context paramContext, bnwb parambnwb);
  
  public void a(Context paramContext, List<Bitmap> paramList, bnwb parambnwb)
  {
    bnrh.b(jdField_a_of_type_JavaLangString, "faceDetect");
    if ((paramList == null) || (!a(paramList)))
    {
      if (parambnwb != null) {
        parambnwb.a(-2);
      }
      return;
    }
    FaceChangeUtils.runInGLThread(new AIFilterProxyBase.3(this, paramContext, paramList, parambnwb), false, "");
  }
  
  public void a(bnvc parambnvc)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambnvc);
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
    bnrh.b(jdField_a_of_type_JavaLangString, "clear");
    Iterator localIterator;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        BitmapUtils.recycle((Bitmap)localIterator.next());
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if ((this.b != null) && (this.b.size() > 0))
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        BitmapUtils.recycle((Bitmap)localIterator.next());
      }
      this.b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvy
 * JD-Core Version:    0.7.0.1
 */