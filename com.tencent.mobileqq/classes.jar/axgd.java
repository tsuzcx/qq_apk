import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Laxhs;>;

@TargetApi(21)
public class axgd
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
  private static axhs a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, axfx paramaxfx)
  {
    if (paramaxfx != null) {}
    Object localObject2;
    for (;;)
    {
      ArrayList localArrayList;
      float f2;
      try
      {
        if (!paramaxfx.a())
        {
          a(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
        Object localObject1 = (StreamConfigurationMap)paramaxfx.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null)
        {
          a(2, "[Camera2]getPictureSize map null!");
          return null;
        }
        paramaxfx = new axhs();
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
          ((List)localObject1).add(new axhs(localArrayList.getWidth(), localArrayList.getHeight()));
          i += 1;
          continue;
        }
        localObject2 = new axhs();
        f1 = 10000.0F;
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        float f3 = paramInt1 / i;
        localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          axhs localaxhs = (axhs)localIterator.next();
          a(1, "[Camera2] setPictureSize[list]: width=" + localaxhs.a + " height=" + localaxhs.b + " w/h=" + localaxhs.a / localaxhs.b);
          float f4 = localaxhs.a / localaxhs.b;
          if (Math.abs(f4 - f3) <= axhp.a) {
            localArrayList.add(localaxhs);
          }
          f2 = f1;
          if (localaxhs.a < paramInt1) {
            break label685;
          }
          f2 = f1;
          if (f1 <= Math.abs(f4 - f3)) {
            break label685;
          }
          f2 = Math.abs(f4 - f3);
          ((axhs)localObject2).a = localaxhs.a;
          ((axhs)localObject2).b = localaxhs.b;
          break label685;
        }
        if ((localArrayList.isEmpty()) && (((axhs)localObject2).a >= paramInt1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + ((axhs)localObject2).a + " height=" + ((axhs)localObject2).b + " w/h=" + ((axhs)localObject2).a / ((axhs)localObject2).b);
          break;
        }
        if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
        {
          paramaxfx.a = ((axhs)((List)localObject1).get(0)).a;
          paramaxfx.b = ((axhs)((List)localObject1).get(0)).b;
          return paramaxfx;
        }
        if (localArrayList.isEmpty()) {
          return null;
        }
        if (paramInt5 == -1)
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (axhs)((Iterator)localObject1).next();
            if (paramaxfx.a >= ((axhs)localObject2).a) {
              continue;
            }
            paramaxfx.a = ((axhs)localObject2).a;
            paramaxfx.b = ((axhs)localObject2).b;
            continue;
          }
          if (paramaxfx.a != 0) {
            break label682;
          }
        }
      }
      catch (Exception paramaxfx)
      {
        a(2, "[Camera2]getPictureSize" + paramaxfx);
        return null;
      }
      for (;;)
      {
        return null;
        paramaxfx = a(paramInt3, paramInt4, paramInt5, localArrayList);
      }
      label682:
      return paramaxfx;
      label685:
      float f1 = f2;
    }
    return localObject2;
  }
  
  public static axhs a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, axfx paramaxfx)
  {
    int j = 0;
    if (paramaxfx != null) {}
    try
    {
      if (!paramaxfx.a())
      {
        a(2, "[Camera2]getPreviewSizeV2 camera2Info: " + paramaxfx);
        return null;
      }
      localObject1 = (StreamConfigurationMap)paramaxfx.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramaxfx = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        paramaxfx.add(new axhs(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (paramaxfx.size() > 0)
      {
        i = 0;
        while (i < paramaxfx.size())
        {
          a(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((axhs)paramaxfx.get(i)).a + " height=" + ((axhs)paramaxfx.get(i)).b + " w/h=" + ((axhs)paramaxfx.get(i)).a / ((axhs)paramaxfx.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramaxfx, paramInt1, paramInt2);
      if (localObject1 != null)
      {
        paramaxfx = (axfx)localObject1;
        if (!QLog.isColorLevel()) {
          break label417;
        }
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + ((axhs)localObject1).toString());
        return localObject1;
      }
    }
    catch (Exception paramaxfx)
    {
      a(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
    }
    Object localObject1 = a(paramaxfx, 960, 720);
    if (localObject1 != null)
    {
      paramaxfx = (axfx)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
        return localObject1;
      }
    }
    else
    {
      localObject1 = a(paramaxfx, paramInt1, paramInt2, paramInt3, paramInt4);
      paramaxfx = (axfx)localObject1;
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
      ahvz.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject1;
      paramInt3 = ((axhs)localObject1).a;
      label417:
      label420:
      while (localObject1 != null)
      {
        paramInt4 = ((axhs)localObject1).b;
        break;
        return paramaxfx;
      }
      paramInt4 = j;
    }
  }
  
  private static axhs a(int paramInt1, int paramInt2, int paramInt3, List<axhs> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    axhs localaxhs1 = new axhs(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      axhs localaxhs2 = (axhs)paramList.next();
      paramInt2 = Math.abs(localaxhs2.a - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label126;
      }
      localaxhs1.a = localaxhs2.a;
      localaxhs1.b = localaxhs2.b;
      paramInt1 = paramInt2;
    }
    label126:
    for (;;)
    {
      break;
      return localaxhs1;
    }
  }
  
  private static axhs a(List<axhs> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    axhs localaxhs1 = new axhs();
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
          axhs localaxhs2 = (axhs)paramList.next();
          if ((localaxhs2 == null) || (localaxhs2.b != paramInt2) || (localaxhs2.a < paramInt1) || ((i >= 0) && (localaxhs2.a > i))) {
            break label235;
          }
          i = localaxhs2.a;
        }
      }
    }
    label235:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localaxhs1.b = paramInt2;
        localaxhs1.a = i;
        if (localaxhs1.a / 4 == localaxhs1.b / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
          }
          return localaxhs1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + localaxhs1.toString());
        }
        return localaxhs1;
      }
      return null;
    }
  }
  
  private static axhs a(List<axhs> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d);
    }
    axhs localaxhs1 = new axhs();
    Iterator localIterator;
    long l1;
    axhs localaxhs2;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localaxhs2 = (axhs)localIterator.next();
        if ((localaxhs2 != null) && (localaxhs2.a >= paramInt1) && (localaxhs2.b >= paramInt2) && (localaxhs2.a / localaxhs2.b >= d))
        {
          l2 = localaxhs2.a * localaxhs2.b;
          if (l2 < l1)
          {
            localaxhs1.a = localaxhs2.a;
            localaxhs1.b = localaxhs2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localaxhs2.a < localaxhs1.a))
          {
            localaxhs1.a = localaxhs2.a;
            localaxhs1.b = localaxhs2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localaxhs1.a <= 0) || (localaxhs1.b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localaxhs2 = (axhs)localIterator.next();
        if ((localaxhs2 != null) && (localaxhs2.a / localaxhs2.b >= d))
        {
          l2 = localaxhs2.a * localaxhs2.b;
          if (l2 > l1)
          {
            localaxhs1.a = localaxhs2.a;
            localaxhs1.b = localaxhs2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localaxhs2.a < localaxhs1.a))
          {
            localaxhs1.a = localaxhs2.a;
            localaxhs1.b = localaxhs2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + localaxhs1.a + "  cSize.height=" + localaxhs1.b);
    }
    if ((localaxhs1.a > 0) && (localaxhs1.b > 0)) {
      return localaxhs1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localaxhs1.a = ((axhs)paramList.get(0)).a;
      localaxhs1.b = ((axhs)paramList.get(0)).b;
      return localaxhs1;
    }
    return null;
  }
  
  private static axhs a(List<axhs> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
      axhs localaxhs;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localaxhs = (axhs)paramList.next();
        if (localaxhs == null) {
          continue;
        }
        i = Math.max(localaxhs.a, localaxhs.b);
        j = Math.min(localaxhs.a, localaxhs.b);
        if ((localaxhs.b != paramInt2) || (i != paramInt1)) {
          break label347;
        }
        ((List)localObject1).add(new axhs(paramInt1, paramInt2));
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
          localaxhs = (axhs)paramList.next();
          if (localaxhs == null) {
            break label880;
          }
          paramInt1 = Math.max(localaxhs.a, localaxhs.b);
          paramInt2 = Math.min(localaxhs.a, localaxhs.b);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < axhp.a) {
            ((List)localObject1).add(localaxhs);
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
        ((List)localObject2).add(new axhs(i, j));
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
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((axhs)((List)localObject1).get(paramInt1)).a + " height=" + ((axhs)((List)localObject1).get(paramInt1)).b + " w/h=" + ((axhs)((List)localObject1).get(paramInt1)).a / ((axhs)((List)localObject1).get(paramInt1)).b);
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
            localObject2 = (axhs)paramList.next();
            if (localObject2 != null)
            {
              paramInt1 = Math.max(((axhs)localObject2).a, ((axhs)localObject2).b);
              paramInt2 = Math.min(((axhs)localObject2).a, ((axhs)localObject2).b);
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < axhp.a) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((axhs)((List)localObject1).get(paramInt1)).a + " height=" + ((axhs)((List)localObject1).get(paramInt1)).b + " w/h=" + ((axhs)((List)localObject1).get(paramInt1)).a / ((axhs)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (axhs)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label874;
          }
          localObject1 = (axhs)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((axhs)localObject1).a * ((axhs)localObject1).b <= paramList.a * paramList.b)) {
            break label877;
          }
          paramList = (List<axhs>)localObject1;
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
  
  public static axhs[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, axfx paramaxfx)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    axhs[] arrayOfaxhs = new axhs[2];
    axhs localaxhs = a(paramInt1, paramInt2, paramInt3, paramInt4, true, paramaxfx);
    if (localaxhs != null)
    {
      arrayOfaxhs[0] = localaxhs;
      a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + localaxhs.a + " " + localaxhs.b);
      paramaxfx = a(localaxhs.a, localaxhs.b, paramInt3, paramInt4, 1, paramaxfx);
      arrayOfaxhs[1] = paramaxfx;
      if (paramaxfx != null) {
        a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + paramaxfx.a + " " + paramaxfx.b);
      }
    }
    return arrayOfaxhs;
  }
  
  @TargetApi(21)
  private static axhs b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, axfx paramaxfx)
  {
    if (paramaxfx != null) {}
    try
    {
      if (!paramaxfx.a())
      {
        a(2, "[Camera2]getPreviewSizeV3 camera2Info: " + paramaxfx);
        return null;
      }
      Object localObject1 = (StreamConfigurationMap)paramaxfx.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramaxfx = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      if (localObject1 == null) {
        return null;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        paramaxfx.add(new axhs(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (paramaxfx.size() > 0)
      {
        i = 0;
        while (i < paramaxfx.size())
        {
          a(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((axhs)paramaxfx.get(i)).a + " height=" + ((axhs)paramaxfx.get(i)).b + " w/h=" + ((axhs)paramaxfx.get(i)).a / ((axhs)paramaxfx.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramaxfx, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + localObject1);
        }
        if (paramBoolean) {
          ahvz.a(2, paramInt1, paramInt2, ((axhs)localObject1).a, ((axhs)localObject1).b);
        }
      }
      else
      {
        localObject1 = a(paramaxfx, paramInt1, paramInt2, 2600, 1500, 1000, 700);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + localObject1);
          }
          if (!paramBoolean) {
            break label519;
          }
          ahvz.a(3, paramInt1, paramInt2, ((axhs)localObject1).a, ((axhs)localObject1).b);
          break label519;
        }
        paramaxfx = a(paramaxfx, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean)
        {
          if (paramaxfx != null) {
            break label495;
          }
          paramInt3 = 0;
          break label522;
        }
      }
      for (;;)
      {
        ahvz.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
        if (QLog.isColorLevel())
        {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + paramaxfx);
          return paramaxfx;
          label495:
          paramInt3 = paramaxfx.a;
        }
        label519:
        label522:
        while (paramaxfx != null)
        {
          paramInt4 = paramaxfx.b;
          break;
          return paramaxfx;
          return localObject1;
          return localObject1;
        }
        paramInt4 = 0;
      }
      return null;
    }
    catch (Exception paramaxfx) {}
  }
  
  public static axhs[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, axfx paramaxfx)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    if (paramaxfx == null)
    {
      a(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + paramaxfx);
      return null;
    }
    axhs[] arrayOfaxhs = new axhs[2];
    axhs localaxhs = b(paramInt1, paramInt2, paramInt3, paramInt4, true, paramaxfx);
    if (localaxhs != null)
    {
      arrayOfaxhs[0] = localaxhs;
      a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + localaxhs.a + " " + localaxhs.b);
      paramaxfx = a(localaxhs.a, localaxhs.b, paramInt3, paramInt4, 1, paramaxfx);
      arrayOfaxhs[1] = paramaxfx;
      if (paramaxfx != null) {
        a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + paramaxfx.a + " " + paramaxfx.b);
      }
    }
    return arrayOfaxhs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgd
 * JD-Core Version:    0.7.0.1
 */