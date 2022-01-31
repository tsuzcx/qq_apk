import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lazda;>;

@TargetApi(21)
public class azbl
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
  private static azda a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, azbf paramazbf)
  {
    if (paramazbf != null) {}
    Object localObject2;
    for (;;)
    {
      ArrayList localArrayList;
      float f2;
      try
      {
        if (!paramazbf.a())
        {
          a(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
        Object localObject1 = (StreamConfigurationMap)paramazbf.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null)
        {
          a(2, "[Camera2]getPictureSize map null!");
          return null;
        }
        paramazbf = new azda();
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
          ((List)localObject1).add(new azda(localArrayList.getWidth(), localArrayList.getHeight()));
          i += 1;
          continue;
        }
        localObject2 = new azda();
        f1 = 10000.0F;
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        float f3 = paramInt1 / i;
        localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          azda localazda = (azda)localIterator.next();
          a(1, "[Camera2] setPictureSize[list]: width=" + localazda.a + " height=" + localazda.b + " w/h=" + localazda.a / localazda.b);
          float f4 = localazda.a / localazda.b;
          if (Math.abs(f4 - f3) <= azcx.a) {
            localArrayList.add(localazda);
          }
          f2 = f1;
          if (localazda.a < paramInt1) {
            break label685;
          }
          f2 = f1;
          if (f1 <= Math.abs(f4 - f3)) {
            break label685;
          }
          f2 = Math.abs(f4 - f3);
          ((azda)localObject2).a = localazda.a;
          ((azda)localObject2).b = localazda.b;
          break label685;
        }
        if ((localArrayList.isEmpty()) && (((azda)localObject2).a >= paramInt1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + ((azda)localObject2).a + " height=" + ((azda)localObject2).b + " w/h=" + ((azda)localObject2).a / ((azda)localObject2).b);
          break;
        }
        if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
        {
          paramazbf.a = ((azda)((List)localObject1).get(0)).a;
          paramazbf.b = ((azda)((List)localObject1).get(0)).b;
          return paramazbf;
        }
        if (localArrayList.isEmpty()) {
          return null;
        }
        if (paramInt5 == -1)
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (azda)((Iterator)localObject1).next();
            if (paramazbf.a >= ((azda)localObject2).a) {
              continue;
            }
            paramazbf.a = ((azda)localObject2).a;
            paramazbf.b = ((azda)localObject2).b;
            continue;
          }
          if (paramazbf.a != 0) {
            break label682;
          }
        }
      }
      catch (Exception paramazbf)
      {
        a(2, "[Camera2]getPictureSize" + paramazbf);
        return null;
      }
      for (;;)
      {
        return null;
        paramazbf = a(paramInt3, paramInt4, paramInt5, localArrayList);
      }
      label682:
      return paramazbf;
      label685:
      float f1 = f2;
    }
    return localObject2;
  }
  
  public static azda a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, azbf paramazbf)
  {
    int j = 0;
    if (paramazbf != null) {}
    try
    {
      if (!paramazbf.a())
      {
        a(2, "[Camera2]getPreviewSizeV2 camera2Info: " + paramazbf);
        return null;
      }
      localObject1 = (StreamConfigurationMap)paramazbf.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramazbf = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        paramazbf.add(new azda(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (paramazbf.size() > 0)
      {
        i = 0;
        while (i < paramazbf.size())
        {
          a(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((azda)paramazbf.get(i)).a + " height=" + ((azda)paramazbf.get(i)).b + " w/h=" + ((azda)paramazbf.get(i)).a / ((azda)paramazbf.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramazbf, paramInt1, paramInt2);
      if (localObject1 != null)
      {
        paramazbf = (azbf)localObject1;
        if (!QLog.isColorLevel()) {
          break label417;
        }
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + ((azda)localObject1).toString());
        return localObject1;
      }
    }
    catch (Exception paramazbf)
    {
      a(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
    }
    Object localObject1 = a(paramazbf, 960, 720);
    if (localObject1 != null)
    {
      paramazbf = (azbf)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
        return localObject1;
      }
    }
    else
    {
      localObject1 = a(paramazbf, paramInt1, paramInt2, paramInt3, paramInt4);
      paramazbf = (azbf)localObject1;
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
      ajnh.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject1;
      paramInt3 = ((azda)localObject1).a;
      label417:
      label420:
      while (localObject1 != null)
      {
        paramInt4 = ((azda)localObject1).b;
        break;
        return paramazbf;
      }
      paramInt4 = j;
    }
  }
  
  private static azda a(int paramInt1, int paramInt2, int paramInt3, List<azda> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    azda localazda1 = new azda(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      azda localazda2 = (azda)paramList.next();
      paramInt2 = Math.abs(localazda2.a - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label126;
      }
      localazda1.a = localazda2.a;
      localazda1.b = localazda2.b;
      paramInt1 = paramInt2;
    }
    label126:
    for (;;)
    {
      break;
      return localazda1;
    }
  }
  
  private static azda a(List<azda> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    azda localazda1 = new azda();
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
          azda localazda2 = (azda)paramList.next();
          if ((localazda2 == null) || (localazda2.b != paramInt2) || (localazda2.a < paramInt1) || ((i >= 0) && (localazda2.a > i))) {
            break label235;
          }
          i = localazda2.a;
        }
      }
    }
    label235:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localazda1.b = paramInt2;
        localazda1.a = i;
        if (localazda1.a / 4 == localazda1.b / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
          }
          return localazda1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + localazda1.toString());
        }
        return localazda1;
      }
      return null;
    }
  }
  
  private static azda a(List<azda> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d);
    }
    azda localazda1 = new azda();
    Iterator localIterator;
    long l1;
    azda localazda2;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localazda2 = (azda)localIterator.next();
        if ((localazda2 != null) && (localazda2.a >= paramInt1) && (localazda2.b >= paramInt2) && (localazda2.a / localazda2.b >= d))
        {
          l2 = localazda2.a * localazda2.b;
          if (l2 < l1)
          {
            localazda1.a = localazda2.a;
            localazda1.b = localazda2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localazda2.a < localazda1.a))
          {
            localazda1.a = localazda2.a;
            localazda1.b = localazda2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localazda1.a <= 0) || (localazda1.b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localazda2 = (azda)localIterator.next();
        if ((localazda2 != null) && (localazda2.a / localazda2.b >= d))
        {
          l2 = localazda2.a * localazda2.b;
          if (l2 > l1)
          {
            localazda1.a = localazda2.a;
            localazda1.b = localazda2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localazda2.a < localazda1.a))
          {
            localazda1.a = localazda2.a;
            localazda1.b = localazda2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + localazda1.a + "  cSize.height=" + localazda1.b);
    }
    if ((localazda1.a > 0) && (localazda1.b > 0)) {
      return localazda1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localazda1.a = ((azda)paramList.get(0)).a;
      localazda1.b = ((azda)paramList.get(0)).b;
      return localazda1;
    }
    return null;
  }
  
  private static azda a(List<azda> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
      azda localazda;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localazda = (azda)paramList.next();
        if (localazda == null) {
          continue;
        }
        i = Math.max(localazda.a, localazda.b);
        j = Math.min(localazda.a, localazda.b);
        if ((localazda.b != paramInt2) || (i != paramInt1)) {
          break label347;
        }
        ((List)localObject1).add(new azda(paramInt1, paramInt2));
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
          localazda = (azda)paramList.next();
          if (localazda == null) {
            break label880;
          }
          paramInt1 = Math.max(localazda.a, localazda.b);
          paramInt2 = Math.min(localazda.a, localazda.b);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < azcx.a) {
            ((List)localObject1).add(localazda);
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
        ((List)localObject2).add(new azda(i, j));
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
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((azda)((List)localObject1).get(paramInt1)).a + " height=" + ((azda)((List)localObject1).get(paramInt1)).b + " w/h=" + ((azda)((List)localObject1).get(paramInt1)).a / ((azda)((List)localObject1).get(paramInt1)).b);
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
            localObject2 = (azda)paramList.next();
            if (localObject2 != null)
            {
              paramInt1 = Math.max(((azda)localObject2).a, ((azda)localObject2).b);
              paramInt2 = Math.min(((azda)localObject2).a, ((azda)localObject2).b);
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < azcx.a) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((azda)((List)localObject1).get(paramInt1)).a + " height=" + ((azda)((List)localObject1).get(paramInt1)).b + " w/h=" + ((azda)((List)localObject1).get(paramInt1)).a / ((azda)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (azda)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label874;
          }
          localObject1 = (azda)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((azda)localObject1).a * ((azda)localObject1).b <= paramList.a * paramList.b)) {
            break label877;
          }
          paramList = (List<azda>)localObject1;
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
  
  public static azda[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, azbf paramazbf)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    azda[] arrayOfazda = new azda[2];
    azda localazda = a(paramInt1, paramInt2, paramInt3, paramInt4, true, paramazbf);
    if (localazda != null)
    {
      arrayOfazda[0] = localazda;
      a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + localazda.a + " " + localazda.b);
      paramazbf = a(localazda.a, localazda.b, paramInt3, paramInt4, 1, paramazbf);
      arrayOfazda[1] = paramazbf;
      if (paramazbf != null) {
        a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + paramazbf.a + " " + paramazbf.b);
      }
    }
    return arrayOfazda;
  }
  
  @TargetApi(21)
  private static azda b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, azbf paramazbf)
  {
    if (paramazbf != null) {}
    try
    {
      if (!paramazbf.a())
      {
        a(2, "[Camera2]getPreviewSizeV3 camera2Info: " + paramazbf);
        return null;
      }
      Object localObject1 = (StreamConfigurationMap)paramazbf.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramazbf = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      if (localObject1 == null) {
        return null;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        paramazbf.add(new azda(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (paramazbf.size() > 0)
      {
        i = 0;
        while (i < paramazbf.size())
        {
          a(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((azda)paramazbf.get(i)).a + " height=" + ((azda)paramazbf.get(i)).b + " w/h=" + ((azda)paramazbf.get(i)).a / ((azda)paramazbf.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramazbf, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + localObject1);
        }
        if (paramBoolean) {
          ajnh.a(2, paramInt1, paramInt2, ((azda)localObject1).a, ((azda)localObject1).b);
        }
      }
      else
      {
        localObject1 = a(paramazbf, paramInt1, paramInt2, 2600, 1500, 1000, 700);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + localObject1);
          }
          if (!paramBoolean) {
            break label519;
          }
          ajnh.a(3, paramInt1, paramInt2, ((azda)localObject1).a, ((azda)localObject1).b);
          break label519;
        }
        paramazbf = a(paramazbf, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean)
        {
          if (paramazbf != null) {
            break label495;
          }
          paramInt3 = 0;
          break label522;
        }
      }
      for (;;)
      {
        ajnh.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
        if (QLog.isColorLevel())
        {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + paramazbf);
          return paramazbf;
          label495:
          paramInt3 = paramazbf.a;
        }
        label519:
        label522:
        while (paramazbf != null)
        {
          paramInt4 = paramazbf.b;
          break;
          return paramazbf;
          return localObject1;
          return localObject1;
        }
        paramInt4 = 0;
      }
      return null;
    }
    catch (Exception paramazbf) {}
  }
  
  public static azda[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, azbf paramazbf)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    if (paramazbf == null)
    {
      a(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + paramazbf);
      return null;
    }
    azda[] arrayOfazda = new azda[2];
    azda localazda = b(paramInt1, paramInt2, paramInt3, paramInt4, true, paramazbf);
    if (localazda != null)
    {
      arrayOfazda[0] = localazda;
      a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + localazda.a + " " + localazda.b);
      paramazbf = a(localazda.a, localazda.b, paramInt3, paramInt4, 1, paramazbf);
      arrayOfazda[1] = paramazbf;
      if (paramazbf != null) {
        a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + paramazbf.a + " " + paramazbf.b);
      }
    }
    return arrayOfazda;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbl
 * JD-Core Version:    0.7.0.1
 */