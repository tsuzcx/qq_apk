import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lawim;>;

@TargetApi(21)
public class awgx
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
  private static awim a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, awgr paramawgr)
  {
    if (paramawgr != null) {}
    Object localObject2;
    for (;;)
    {
      ArrayList localArrayList;
      float f2;
      try
      {
        if (!paramawgr.a())
        {
          a(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
        Object localObject1 = (StreamConfigurationMap)paramawgr.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null)
        {
          a(2, "[Camera2]getPictureSize map null!");
          return null;
        }
        paramawgr = new awim();
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
          ((List)localObject1).add(new awim(localArrayList.getWidth(), localArrayList.getHeight()));
          i += 1;
          continue;
        }
        localObject2 = new awim();
        f1 = 10000.0F;
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        float f3 = paramInt1 / i;
        localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          awim localawim = (awim)localIterator.next();
          a(1, "[Camera2] setPictureSize[list]: width=" + localawim.a + " height=" + localawim.b + " w/h=" + localawim.a / localawim.b);
          float f4 = localawim.a / localawim.b;
          if (Math.abs(f4 - f3) <= awij.a) {
            localArrayList.add(localawim);
          }
          f2 = f1;
          if (localawim.a < paramInt1) {
            break label685;
          }
          f2 = f1;
          if (f1 <= Math.abs(f4 - f3)) {
            break label685;
          }
          f2 = Math.abs(f4 - f3);
          ((awim)localObject2).a = localawim.a;
          ((awim)localObject2).b = localawim.b;
          break label685;
        }
        if ((localArrayList.isEmpty()) && (((awim)localObject2).a >= paramInt1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + ((awim)localObject2).a + " height=" + ((awim)localObject2).b + " w/h=" + ((awim)localObject2).a / ((awim)localObject2).b);
          break;
        }
        if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
        {
          paramawgr.a = ((awim)((List)localObject1).get(0)).a;
          paramawgr.b = ((awim)((List)localObject1).get(0)).b;
          return paramawgr;
        }
        if (localArrayList.isEmpty()) {
          return null;
        }
        if (paramInt5 == -1)
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (awim)((Iterator)localObject1).next();
            if (paramawgr.a >= ((awim)localObject2).a) {
              continue;
            }
            paramawgr.a = ((awim)localObject2).a;
            paramawgr.b = ((awim)localObject2).b;
            continue;
          }
          if (paramawgr.a != 0) {
            break label682;
          }
        }
      }
      catch (Exception paramawgr)
      {
        a(2, "[Camera2]getPictureSize" + paramawgr);
        return null;
      }
      for (;;)
      {
        return null;
        paramawgr = a(paramInt3, paramInt4, paramInt5, localArrayList);
      }
      label682:
      return paramawgr;
      label685:
      float f1 = f2;
    }
    return localObject2;
  }
  
  public static awim a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, awgr paramawgr)
  {
    int j = 0;
    if (paramawgr != null) {}
    try
    {
      if (!paramawgr.a())
      {
        a(2, "[Camera2]getPreviewSizeV2 camera2Info: " + paramawgr);
        return null;
      }
      localObject1 = (StreamConfigurationMap)paramawgr.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramawgr = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        paramawgr.add(new awim(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (paramawgr.size() > 0)
      {
        i = 0;
        while (i < paramawgr.size())
        {
          a(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((awim)paramawgr.get(i)).a + " height=" + ((awim)paramawgr.get(i)).b + " w/h=" + ((awim)paramawgr.get(i)).a / ((awim)paramawgr.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramawgr, paramInt1, paramInt2);
      if (localObject1 != null)
      {
        paramawgr = (awgr)localObject1;
        if (!QLog.isColorLevel()) {
          break label417;
        }
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + ((awim)localObject1).toString());
        return localObject1;
      }
    }
    catch (Exception paramawgr)
    {
      a(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
    }
    Object localObject1 = a(paramawgr, 960, 720);
    if (localObject1 != null)
    {
      paramawgr = (awgr)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
        return localObject1;
      }
    }
    else
    {
      localObject1 = a(paramawgr, paramInt1, paramInt2, paramInt3, paramInt4);
      paramawgr = (awgr)localObject1;
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
      ahji.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject1;
      paramInt3 = ((awim)localObject1).a;
      label417:
      label420:
      while (localObject1 != null)
      {
        paramInt4 = ((awim)localObject1).b;
        break;
        return paramawgr;
      }
      paramInt4 = j;
    }
  }
  
  private static awim a(int paramInt1, int paramInt2, int paramInt3, List<awim> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    awim localawim1 = new awim(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      awim localawim2 = (awim)paramList.next();
      paramInt2 = Math.abs(localawim2.a - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label126;
      }
      localawim1.a = localawim2.a;
      localawim1.b = localawim2.b;
      paramInt1 = paramInt2;
    }
    label126:
    for (;;)
    {
      break;
      return localawim1;
    }
  }
  
  private static awim a(List<awim> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    awim localawim1 = new awim();
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
          awim localawim2 = (awim)paramList.next();
          if ((localawim2 == null) || (localawim2.b != paramInt2) || (localawim2.a < paramInt1) || ((i >= 0) && (localawim2.a > i))) {
            break label235;
          }
          i = localawim2.a;
        }
      }
    }
    label235:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localawim1.b = paramInt2;
        localawim1.a = i;
        if (localawim1.a / 4 == localawim1.b / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
          }
          return localawim1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + localawim1.toString());
        }
        return localawim1;
      }
      return null;
    }
  }
  
  private static awim a(List<awim> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d);
    }
    awim localawim1 = new awim();
    Iterator localIterator;
    long l1;
    awim localawim2;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localawim2 = (awim)localIterator.next();
        if ((localawim2 != null) && (localawim2.a >= paramInt1) && (localawim2.b >= paramInt2) && (localawim2.a / localawim2.b >= d))
        {
          l2 = localawim2.a * localawim2.b;
          if (l2 < l1)
          {
            localawim1.a = localawim2.a;
            localawim1.b = localawim2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localawim2.a < localawim1.a))
          {
            localawim1.a = localawim2.a;
            localawim1.b = localawim2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localawim1.a <= 0) || (localawim1.b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localawim2 = (awim)localIterator.next();
        if ((localawim2 != null) && (localawim2.a / localawim2.b >= d))
        {
          l2 = localawim2.a * localawim2.b;
          if (l2 > l1)
          {
            localawim1.a = localawim2.a;
            localawim1.b = localawim2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localawim2.a < localawim1.a))
          {
            localawim1.a = localawim2.a;
            localawim1.b = localawim2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + localawim1.a + "  cSize.height=" + localawim1.b);
    }
    if ((localawim1.a > 0) && (localawim1.b > 0)) {
      return localawim1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localawim1.a = ((awim)paramList.get(0)).a;
      localawim1.b = ((awim)paramList.get(0)).b;
      return localawim1;
    }
    return null;
  }
  
  private static awim a(List<awim> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
      awim localawim;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localawim = (awim)paramList.next();
        if (localawim == null) {
          continue;
        }
        i = Math.max(localawim.a, localawim.b);
        j = Math.min(localawim.a, localawim.b);
        if ((localawim.b != paramInt2) || (i != paramInt1)) {
          break label347;
        }
        ((List)localObject1).add(new awim(paramInt1, paramInt2));
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
          localawim = (awim)paramList.next();
          if (localawim == null) {
            break label880;
          }
          paramInt1 = Math.max(localawim.a, localawim.b);
          paramInt2 = Math.min(localawim.a, localawim.b);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < awij.a) {
            ((List)localObject1).add(localawim);
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
        ((List)localObject2).add(new awim(i, j));
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
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((awim)((List)localObject1).get(paramInt1)).a + " height=" + ((awim)((List)localObject1).get(paramInt1)).b + " w/h=" + ((awim)((List)localObject1).get(paramInt1)).a / ((awim)((List)localObject1).get(paramInt1)).b);
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
            localObject2 = (awim)paramList.next();
            if (localObject2 != null)
            {
              paramInt1 = Math.max(((awim)localObject2).a, ((awim)localObject2).b);
              paramInt2 = Math.min(((awim)localObject2).a, ((awim)localObject2).b);
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < awij.a) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((awim)((List)localObject1).get(paramInt1)).a + " height=" + ((awim)((List)localObject1).get(paramInt1)).b + " w/h=" + ((awim)((List)localObject1).get(paramInt1)).a / ((awim)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (awim)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label874;
          }
          localObject1 = (awim)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((awim)localObject1).a * ((awim)localObject1).b <= paramList.a * paramList.b)) {
            break label877;
          }
          paramList = (List<awim>)localObject1;
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
  
  public static awim[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, awgr paramawgr)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    awim[] arrayOfawim = new awim[2];
    awim localawim = a(paramInt1, paramInt2, paramInt3, paramInt4, true, paramawgr);
    if (localawim != null)
    {
      arrayOfawim[0] = localawim;
      a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + localawim.a + " " + localawim.b);
      paramawgr = a(localawim.a, localawim.b, paramInt3, paramInt4, 1, paramawgr);
      arrayOfawim[1] = paramawgr;
      if (paramawgr != null) {
        a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + paramawgr.a + " " + paramawgr.b);
      }
    }
    return arrayOfawim;
  }
  
  @TargetApi(21)
  private static awim b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, awgr paramawgr)
  {
    if (paramawgr != null) {}
    try
    {
      if (!paramawgr.a())
      {
        a(2, "[Camera2]getPreviewSizeV3 camera2Info: " + paramawgr);
        return null;
      }
      Object localObject1 = (StreamConfigurationMap)paramawgr.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramawgr = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      if (localObject1 == null) {
        return null;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        paramawgr.add(new awim(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (paramawgr.size() > 0)
      {
        i = 0;
        while (i < paramawgr.size())
        {
          a(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((awim)paramawgr.get(i)).a + " height=" + ((awim)paramawgr.get(i)).b + " w/h=" + ((awim)paramawgr.get(i)).a / ((awim)paramawgr.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramawgr, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + localObject1);
        }
        if (paramBoolean) {
          ahji.a(2, paramInt1, paramInt2, ((awim)localObject1).a, ((awim)localObject1).b);
        }
      }
      else
      {
        localObject1 = a(paramawgr, paramInt1, paramInt2, 2600, 1500, 1000, 700);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + localObject1);
          }
          if (!paramBoolean) {
            break label519;
          }
          ahji.a(3, paramInt1, paramInt2, ((awim)localObject1).a, ((awim)localObject1).b);
          break label519;
        }
        paramawgr = a(paramawgr, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean)
        {
          if (paramawgr != null) {
            break label495;
          }
          paramInt3 = 0;
          break label522;
        }
      }
      for (;;)
      {
        ahji.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
        if (QLog.isColorLevel())
        {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + paramawgr);
          return paramawgr;
          label495:
          paramInt3 = paramawgr.a;
        }
        label519:
        label522:
        while (paramawgr != null)
        {
          paramInt4 = paramawgr.b;
          break;
          return paramawgr;
          return localObject1;
          return localObject1;
        }
        paramInt4 = 0;
      }
      return null;
    }
    catch (Exception paramawgr) {}
  }
  
  public static awim[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, awgr paramawgr)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    if (paramawgr == null)
    {
      a(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + paramawgr);
      return null;
    }
    awim[] arrayOfawim = new awim[2];
    awim localawim = b(paramInt1, paramInt2, paramInt3, paramInt4, true, paramawgr);
    if (localawim != null)
    {
      arrayOfawim[0] = localawim;
      a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + localawim.a + " " + localawim.b);
      paramawgr = a(localawim.a, localawim.b, paramInt3, paramInt4, 1, paramawgr);
      arrayOfawim[1] = paramawgr;
      if (paramawgr != null) {
        a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + paramawgr.a + " " + paramawgr.b);
      }
    }
    return arrayOfawim;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awgx
 * JD-Core Version:    0.7.0.1
 */