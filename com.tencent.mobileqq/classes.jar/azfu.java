import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lazhj;>;

@TargetApi(21)
public class azfu
{
  public static int a(CameraCharacteristics paramCameraCharacteristics, int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 0;
    }
    paramInt = (i + 45) / 90 * 90;
    i = ((Integer)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    paramCameraCharacteristics = (Integer)paramCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
    if ((paramCameraCharacteristics != null) && (paramCameraCharacteristics.intValue() == 0)) {
      return (i - paramInt + 360) % 360;
    }
    return (i + paramInt) % 360;
  }
  
  @TargetApi(21)
  private static azhj a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, azfo paramazfo)
  {
    if (paramazfo != null) {}
    Object localObject2;
    for (;;)
    {
      ArrayList localArrayList;
      float f2;
      try
      {
        if (!paramazfo.a())
        {
          a(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
        Object localObject1 = (StreamConfigurationMap)paramazfo.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null)
        {
          a(2, "[Camera2]getPictureSize map null!");
          return null;
        }
        paramazfo = new azhj();
        localObject2 = ((StreamConfigurationMap)localObject1).getOutputSizes(256);
        if ((localObject2 == null) || (localObject2.length <= 0))
        {
          a(2, "[Camera2]getPictureSize outPutSizes null!");
          return null;
        }
        localObject1 = new ArrayList();
        int j = localObject2.length;
        int i = 0;
        if (i < j)
        {
          localArrayList = localObject2[i];
          ((List)localObject1).add(new azhj(localArrayList.getWidth(), localArrayList.getHeight()));
          i += 1;
          continue;
        }
        localObject2 = new azhj();
        f1 = 10000.0F;
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        float f3 = paramInt1 / i;
        localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          azhj localazhj = (azhj)localIterator.next();
          a(1, "[Camera2] setPictureSize[list]: width=" + localazhj.a + " height=" + localazhj.b + " w/h=" + localazhj.a / localazhj.b);
          float f4 = localazhj.a / localazhj.b;
          if (Math.abs(f4 - f3) <= azhg.a) {
            localArrayList.add(localazhj);
          }
          f2 = f1;
          if (localazhj.a < paramInt1) {
            break label685;
          }
          f2 = f1;
          if (f1 <= Math.abs(f4 - f3)) {
            break label685;
          }
          f2 = Math.abs(f4 - f3);
          ((azhj)localObject2).a = localazhj.a;
          ((azhj)localObject2).b = localazhj.b;
          break label685;
        }
        if ((localArrayList.isEmpty()) && (((azhj)localObject2).a >= paramInt1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + ((azhj)localObject2).a + " height=" + ((azhj)localObject2).b + " w/h=" + ((azhj)localObject2).a / ((azhj)localObject2).b);
          break;
        }
        if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
        {
          paramazfo.a = ((azhj)((List)localObject1).get(0)).a;
          paramazfo.b = ((azhj)((List)localObject1).get(0)).b;
          return paramazfo;
        }
        if (localArrayList.isEmpty()) {
          return null;
        }
        if (paramInt5 == -1)
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (azhj)((Iterator)localObject1).next();
            if (paramazfo.a >= ((azhj)localObject2).a) {
              continue;
            }
            paramazfo.a = ((azhj)localObject2).a;
            paramazfo.b = ((azhj)localObject2).b;
            continue;
          }
          if (paramazfo.a != 0) {
            break label682;
          }
        }
      }
      catch (Exception paramazfo)
      {
        a(2, "[Camera2]getPictureSize" + paramazfo);
        return null;
      }
      for (;;)
      {
        return null;
        paramazfo = a(paramInt3, paramInt4, paramInt5, localArrayList);
      }
      label682:
      return paramazfo;
      label685:
      float f1 = f2;
    }
    return localObject2;
  }
  
  public static azhj a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, azfo paramazfo)
  {
    int j = 0;
    if (paramazfo != null) {}
    try
    {
      if (!paramazfo.a())
      {
        a(2, "[Camera2]getPreviewSizeV2 camera2Info: " + paramazfo);
        return null;
      }
      localObject1 = (StreamConfigurationMap)paramazfo.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramazfo = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        paramazfo.add(new azhj(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (paramazfo.size() > 0)
      {
        i = 0;
        while (i < paramazfo.size())
        {
          a(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((azhj)paramazfo.get(i)).a + " height=" + ((azhj)paramazfo.get(i)).b + " w/h=" + ((azhj)paramazfo.get(i)).a / ((azhj)paramazfo.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramazfo, paramInt1, paramInt2);
      if (localObject1 != null)
      {
        paramazfo = (azfo)localObject1;
        if (!QLog.isColorLevel()) {
          break label417;
        }
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + ((azhj)localObject1).toString());
        return localObject1;
      }
    }
    catch (Exception paramazfo)
    {
      a(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
    }
    Object localObject1 = a(paramazfo, 960, 720);
    if (localObject1 != null)
    {
      paramazfo = (azfo)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
        return localObject1;
      }
    }
    else
    {
      localObject1 = a(paramazfo, paramInt1, paramInt2, paramInt3, paramInt4);
      paramazfo = (azfo)localObject1;
      if (paramBoolean) {
        if (localObject1 == null)
        {
          paramInt3 = 0;
          break label420;
        }
      }
    }
    for (;;)
    {
      ajrw.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject1;
      paramInt3 = ((azhj)localObject1).a;
      label417:
      label420:
      while (localObject1 != null)
      {
        paramInt4 = ((azhj)localObject1).b;
        break;
        return paramazfo;
      }
      paramInt4 = j;
    }
  }
  
  private static azhj a(int paramInt1, int paramInt2, int paramInt3, List<azhj> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    azhj localazhj1 = new azhj(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      azhj localazhj2 = (azhj)paramList.next();
      paramInt2 = Math.abs(localazhj2.a - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label126;
      }
      localazhj1.a = localazhj2.a;
      localazhj1.b = localazhj2.b;
      paramInt1 = paramInt2;
    }
    label126:
    for (;;)
    {
      break;
      return localazhj1;
    }
  }
  
  private static azhj a(List<azhj> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    azhj localazhj1 = new azhj();
    int i = j;
    if (paramList != null)
    {
      i = j;
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        i = -1;
        if (paramList.hasNext())
        {
          azhj localazhj2 = (azhj)paramList.next();
          if ((localazhj2 == null) || (localazhj2.b != paramInt2) || (localazhj2.a < paramInt1) || ((i >= 0) && (localazhj2.a > i))) {
            break label235;
          }
          i = localazhj2.a;
        }
      }
    }
    label235:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localazhj1.b = paramInt2;
        localazhj1.a = i;
        if (localazhj1.a / 4 == localazhj1.b / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
          }
          return localazhj1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + localazhj1.toString());
        }
        return localazhj1;
      }
      return null;
    }
  }
  
  private static azhj a(List<azhj> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d);
    }
    azhj localazhj1 = new azhj();
    Iterator localIterator;
    long l1;
    azhj localazhj2;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localazhj2 = (azhj)localIterator.next();
        if ((localazhj2 != null) && (localazhj2.a >= paramInt1) && (localazhj2.b >= paramInt2) && (localazhj2.a / localazhj2.b >= d))
        {
          l2 = localazhj2.a * localazhj2.b;
          if (l2 < l1)
          {
            localazhj1.a = localazhj2.a;
            localazhj1.b = localazhj2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localazhj2.a < localazhj1.a))
          {
            localazhj1.a = localazhj2.a;
            localazhj1.b = localazhj2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localazhj1.a <= 0) || (localazhj1.b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localazhj2 = (azhj)localIterator.next();
        if ((localazhj2 != null) && (localazhj2.a / localazhj2.b >= d))
        {
          l2 = localazhj2.a * localazhj2.b;
          if (l2 > l1)
          {
            localazhj1.a = localazhj2.a;
            localazhj1.b = localazhj2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localazhj2.a < localazhj1.a))
          {
            localazhj1.a = localazhj2.a;
            localazhj1.b = localazhj2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + localazhj1.a + "  cSize.height=" + localazhj1.b);
    }
    if ((localazhj1.a > 0) && (localazhj1.b > 0)) {
      return localazhj1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localazhj1.a = ((azhj)paramList.get(0)).a;
      localazhj1.b = ((azhj)paramList.get(0)).b;
      return localazhj1;
    }
    return null;
  }
  
  private static azhj a(List<azhj> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    float f3 = paramInt1 / paramInt2;
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramList = paramList.iterator();
    }
    label234:
    label874:
    label877:
    label880:
    label881:
    for (;;)
    {
      azhj localazhj;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localazhj = (azhj)paramList.next();
        if (localazhj == null) {
          continue;
        }
        i = Math.max(localazhj.a, localazhj.b);
        j = Math.min(localazhj.a, localazhj.b);
        if ((localazhj.b != paramInt2) || (i != paramInt1)) {
          break label347;
        }
        ((List)localObject1).add(new azhj(paramInt1, paramInt2));
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 first: width=" + paramInt1 + "  height=" + paramInt2);
        }
      }
      float f1;
      float f2;
      if (((List)localObject1).size() == 0)
      {
        paramList = ((List)localObject2).iterator();
        f1 = 10000.0F;
        if (paramList.hasNext())
        {
          localazhj = (azhj)paramList.next();
          if (localazhj == null) {
            break label880;
          }
          paramInt1 = Math.max(localazhj.a, localazhj.b);
          paramInt2 = Math.min(localazhj.a, localazhj.b);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < azhg.a) {
            ((List)localObject1).add(localazhj);
          }
          if (Math.abs(f3 - f2) >= f1) {
            break label880;
          }
          f1 = Math.abs(f3 - f2);
        }
      }
      for (;;)
      {
        break label234;
        if ((i <= paramInt5) || (i >= paramInt3) || (j <= paramInt6) || (j >= paramInt4)) {
          break label881;
        }
        ((List)localObject2).add(new azhj(i, j));
        break;
        f2 = f1;
        if (QLog.isColorLevel())
        {
          f2 = f1;
          if (localObject1 != null)
          {
            paramInt1 = 0;
            for (;;)
            {
              f2 = f1;
              if (paramInt1 >= ((List)localObject1).size()) {
                break;
              }
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((azhj)((List)localObject1).get(paramInt1)).a + " height=" + ((azhj)((List)localObject1).get(paramInt1)).b + " w/h=" + ((azhj)((List)localObject1).get(paramInt1)).a / ((azhj)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
            f2 = 10000.0F;
          }
        }
        if (((List)localObject1).size() == 0)
        {
          paramList = ((List)localObject2).iterator();
          while (paramList.hasNext())
          {
            localObject2 = (azhj)paramList.next();
            if (localObject2 != null)
            {
              paramInt1 = Math.max(((azhj)localObject2).a, ((azhj)localObject2).b);
              paramInt2 = Math.min(((azhj)localObject2).a, ((azhj)localObject2).b);
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < azhg.a) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((azhj)((List)localObject1).get(paramInt1)).a + " height=" + ((azhj)((List)localObject1).get(paramInt1)).b + " w/h=" + ((azhj)((List)localObject1).get(paramInt1)).a / ((azhj)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (azhj)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label874;
          }
          localObject1 = (azhj)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((azhj)localObject1).a * ((azhj)localObject1).b <= paramList.a * paramList.b)) {
            break label877;
          }
          paramList = (List<azhj>)localObject1;
        }
        for (;;)
        {
          break;
          localObject1 = null;
          return localObject1;
        }
      }
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      QLog.w("Camera2Control", 1, paramString);
    }
    while (paramInt != 2) {
      return;
    }
    QLog.e("Camera2Control", 1, paramString);
  }
  
  public static azhj[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, azfo paramazfo)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    azhj[] arrayOfazhj = new azhj[2];
    azhj localazhj = a(paramInt1, paramInt2, paramInt3, paramInt4, true, paramazfo);
    if (localazhj != null)
    {
      arrayOfazhj[0] = localazhj;
      a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + localazhj.a + " " + localazhj.b);
      paramazfo = a(localazhj.a, localazhj.b, paramInt3, paramInt4, 1, paramazfo);
      arrayOfazhj[1] = paramazfo;
      if (paramazfo != null) {
        a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + paramazfo.a + " " + paramazfo.b);
      }
    }
    return arrayOfazhj;
  }
  
  @TargetApi(21)
  private static azhj b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, azfo paramazfo)
  {
    if (paramazfo != null) {}
    try
    {
      if (!paramazfo.a())
      {
        a(2, "[Camera2]getPreviewSizeV3 camera2Info: " + paramazfo);
        return null;
      }
      Object localObject1 = (StreamConfigurationMap)paramazfo.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramazfo = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      if (localObject1 == null) {
        return null;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        paramazfo.add(new azhj(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (paramazfo.size() > 0)
      {
        i = 0;
        while (i < paramazfo.size())
        {
          a(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((azhj)paramazfo.get(i)).a + " height=" + ((azhj)paramazfo.get(i)).b + " w/h=" + ((azhj)paramazfo.get(i)).a / ((azhj)paramazfo.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramazfo, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + localObject1);
        }
        if (paramBoolean) {
          ajrw.a(2, paramInt1, paramInt2, ((azhj)localObject1).a, ((azhj)localObject1).b);
        }
      }
      else
      {
        localObject1 = a(paramazfo, paramInt1, paramInt2, 2600, 1500, 1000, 700);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + localObject1);
          }
          if (!paramBoolean) {
            break label519;
          }
          ajrw.a(3, paramInt1, paramInt2, ((azhj)localObject1).a, ((azhj)localObject1).b);
          break label519;
        }
        paramazfo = a(paramazfo, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean)
        {
          if (paramazfo != null) {
            break label495;
          }
          paramInt3 = 0;
          break label522;
        }
      }
      for (;;)
      {
        ajrw.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
        if (QLog.isColorLevel())
        {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + paramazfo);
          return paramazfo;
          label495:
          paramInt3 = paramazfo.a;
        }
        label519:
        label522:
        while (paramazfo != null)
        {
          paramInt4 = paramazfo.b;
          break;
          return paramazfo;
          return localObject1;
          return localObject1;
        }
        paramInt4 = 0;
      }
      return null;
    }
    catch (Exception paramazfo) {}
  }
  
  public static azhj[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, azfo paramazfo)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    if (paramazfo == null)
    {
      a(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + paramazfo);
      return null;
    }
    azhj[] arrayOfazhj = new azhj[2];
    azhj localazhj = b(paramInt1, paramInt2, paramInt3, paramInt4, true, paramazfo);
    if (localazhj != null)
    {
      arrayOfazhj[0] = localazhj;
      a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + localazhj.a + " " + localazhj.b);
      paramazfo = a(localazhj.a, localazhj.b, paramInt3, paramInt4, 1, paramazfo);
      arrayOfazhj[1] = paramazfo;
      if (paramazfo != null) {
        a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + paramazfo.a + " " + paramazfo.b);
      }
    }
    return arrayOfazhj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfu
 * JD-Core Version:    0.7.0.1
 */