import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbdba;>;

@TargetApi(21)
public class bczm
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
  private static bdba a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, bczg parambczg)
  {
    if (parambczg != null) {}
    Object localObject2;
    for (;;)
    {
      ArrayList localArrayList;
      float f2;
      try
      {
        if (!parambczg.a())
        {
          a(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
        Object localObject1 = (StreamConfigurationMap)parambczg.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null)
        {
          a(2, "[Camera2]getPictureSize map null!");
          return null;
        }
        parambczg = new bdba();
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
          ((List)localObject1).add(new bdba(localArrayList.getWidth(), localArrayList.getHeight()));
          i += 1;
          continue;
        }
        localObject2 = new bdba();
        f1 = 10000.0F;
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        float f3 = paramInt1 / i;
        localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          bdba localbdba = (bdba)localIterator.next();
          a(1, "[Camera2] setPictureSize[list]: width=" + localbdba.a + " height=" + localbdba.b + " w/h=" + localbdba.a / localbdba.b);
          float f4 = localbdba.a / localbdba.b;
          if (Math.abs(f4 - f3) <= bdax.a) {
            localArrayList.add(localbdba);
          }
          f2 = f1;
          if (localbdba.a < paramInt1) {
            break label685;
          }
          f2 = f1;
          if (f1 <= Math.abs(f4 - f3)) {
            break label685;
          }
          f2 = Math.abs(f4 - f3);
          ((bdba)localObject2).a = localbdba.a;
          ((bdba)localObject2).b = localbdba.b;
          break label685;
        }
        if ((localArrayList.isEmpty()) && (((bdba)localObject2).a >= paramInt1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + ((bdba)localObject2).a + " height=" + ((bdba)localObject2).b + " w/h=" + ((bdba)localObject2).a / ((bdba)localObject2).b);
          break;
        }
        if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
        {
          parambczg.a = ((bdba)((List)localObject1).get(0)).a;
          parambczg.b = ((bdba)((List)localObject1).get(0)).b;
          return parambczg;
        }
        if (localArrayList.isEmpty()) {
          return null;
        }
        if (paramInt5 == -1)
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bdba)((Iterator)localObject1).next();
            if (parambczg.a >= ((bdba)localObject2).a) {
              continue;
            }
            parambczg.a = ((bdba)localObject2).a;
            parambczg.b = ((bdba)localObject2).b;
            continue;
          }
          if (parambczg.a != 0) {
            break label682;
          }
        }
      }
      catch (Exception parambczg)
      {
        a(2, "[Camera2]getPictureSize" + parambczg);
        return null;
      }
      for (;;)
      {
        return null;
        parambczg = a(paramInt3, paramInt4, paramInt5, localArrayList);
      }
      label682:
      return parambczg;
      label685:
      float f1 = f2;
    }
    return localObject2;
  }
  
  public static bdba a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, bczg parambczg)
  {
    int j = 0;
    if (parambczg != null) {}
    try
    {
      if (!parambczg.a())
      {
        a(2, "[Camera2]getPreviewSizeV2 camera2Info: " + parambczg);
        return null;
      }
      localObject1 = (StreamConfigurationMap)parambczg.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      parambczg = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      int i;
      if (localObject1 != null)
      {
        int k = localObject1.length;
        i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          parambczg.add(new bdba(localObject2.getWidth(), localObject2.getHeight()));
          i += 1;
        }
      }
      if (parambczg.size() > 0)
      {
        i = 0;
        while (i < parambczg.size())
        {
          a(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((bdba)parambczg.get(i)).a + " height=" + ((bdba)parambczg.get(i)).b + " w/h=" + ((bdba)parambczg.get(i)).a / ((bdba)parambczg.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(parambczg, paramInt1, paramInt2);
      if (localObject1 != null)
      {
        parambczg = (bczg)localObject1;
        if (!QLog.isColorLevel()) {
          break label422;
        }
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + ((bdba)localObject1).toString());
        return localObject1;
      }
    }
    catch (Exception parambczg)
    {
      a(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
    }
    Object localObject1 = a(parambczg, 960, 720);
    if (localObject1 != null)
    {
      parambczg = (bczg)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
        return localObject1;
      }
    }
    else
    {
      localObject1 = a(parambczg, paramInt1, paramInt2, paramInt3, paramInt4);
      parambczg = (bczg)localObject1;
      if (paramBoolean) {
        if (localObject1 == null)
        {
          paramInt3 = 0;
          break label425;
        }
      }
    }
    for (;;)
    {
      alrr.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject1;
      paramInt3 = ((bdba)localObject1).a;
      label422:
      label425:
      while (localObject1 != null)
      {
        paramInt4 = ((bdba)localObject1).b;
        break;
        return parambczg;
      }
      paramInt4 = j;
    }
  }
  
  private static bdba a(int paramInt1, int paramInt2, int paramInt3, List<bdba> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    bdba localbdba1 = new bdba(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      bdba localbdba2 = (bdba)paramList.next();
      paramInt2 = Math.abs(localbdba2.a - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label126;
      }
      localbdba1.a = localbdba2.a;
      localbdba1.b = localbdba2.b;
      paramInt1 = paramInt2;
    }
    label126:
    for (;;)
    {
      break;
      return localbdba1;
    }
  }
  
  private static bdba a(List<bdba> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    bdba localbdba1 = new bdba();
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
          bdba localbdba2 = (bdba)paramList.next();
          if ((localbdba2 == null) || (localbdba2.b != paramInt2) || (localbdba2.a < paramInt1) || ((i >= 0) && (localbdba2.a > i))) {
            break label235;
          }
          i = localbdba2.a;
        }
      }
    }
    label235:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localbdba1.b = paramInt2;
        localbdba1.a = i;
        if (localbdba1.a / 4 == localbdba1.b / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
          }
          return localbdba1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + localbdba1.toString());
        }
        return localbdba1;
      }
      return null;
    }
  }
  
  private static bdba a(List<bdba> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d);
    }
    bdba localbdba1 = new bdba();
    Iterator localIterator;
    long l1;
    bdba localbdba2;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localbdba2 = (bdba)localIterator.next();
        if ((localbdba2 != null) && (localbdba2.a >= paramInt1) && (localbdba2.b >= paramInt2) && (localbdba2.a / localbdba2.b >= d))
        {
          l2 = localbdba2.a * localbdba2.b;
          if (l2 < l1)
          {
            localbdba1.a = localbdba2.a;
            localbdba1.b = localbdba2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localbdba2.a < localbdba1.a))
          {
            localbdba1.a = localbdba2.a;
            localbdba1.b = localbdba2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localbdba1.a <= 0) || (localbdba1.b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localbdba2 = (bdba)localIterator.next();
        if ((localbdba2 != null) && (localbdba2.a / localbdba2.b >= d))
        {
          l2 = localbdba2.a * localbdba2.b;
          if (l2 > l1)
          {
            localbdba1.a = localbdba2.a;
            localbdba1.b = localbdba2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localbdba2.a < localbdba1.a))
          {
            localbdba1.a = localbdba2.a;
            localbdba1.b = localbdba2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + localbdba1.a + "  cSize.height=" + localbdba1.b);
    }
    if ((localbdba1.a > 0) && (localbdba1.b > 0)) {
      return localbdba1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localbdba1.a = ((bdba)paramList.get(0)).a;
      localbdba1.b = ((bdba)paramList.get(0)).b;
      return localbdba1;
    }
    return null;
  }
  
  private static bdba a(List<bdba> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
      bdba localbdba;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localbdba = (bdba)paramList.next();
        if (localbdba == null) {
          continue;
        }
        i = Math.max(localbdba.a, localbdba.b);
        j = Math.min(localbdba.a, localbdba.b);
        if ((localbdba.b != paramInt2) || (i != paramInt1)) {
          break label347;
        }
        ((List)localObject1).add(new bdba(paramInt1, paramInt2));
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
          localbdba = (bdba)paramList.next();
          if (localbdba == null) {
            break label880;
          }
          paramInt1 = Math.max(localbdba.a, localbdba.b);
          paramInt2 = Math.min(localbdba.a, localbdba.b);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < bdax.a) {
            ((List)localObject1).add(localbdba);
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
        ((List)localObject2).add(new bdba(i, j));
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
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((bdba)((List)localObject1).get(paramInt1)).a + " height=" + ((bdba)((List)localObject1).get(paramInt1)).b + " w/h=" + ((bdba)((List)localObject1).get(paramInt1)).a / ((bdba)((List)localObject1).get(paramInt1)).b);
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
            localObject2 = (bdba)paramList.next();
            if (localObject2 != null)
            {
              paramInt1 = Math.max(((bdba)localObject2).a, ((bdba)localObject2).b);
              paramInt2 = Math.min(((bdba)localObject2).a, ((bdba)localObject2).b);
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < bdax.a) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((bdba)((List)localObject1).get(paramInt1)).a + " height=" + ((bdba)((List)localObject1).get(paramInt1)).b + " w/h=" + ((bdba)((List)localObject1).get(paramInt1)).a / ((bdba)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (bdba)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label874;
          }
          localObject1 = (bdba)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((bdba)localObject1).a * ((bdba)localObject1).b <= paramList.a * paramList.b)) {
            break label877;
          }
          paramList = (List<bdba>)localObject1;
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
  
  public static bdba[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bczg parambczg)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    bdba[] arrayOfbdba = new bdba[2];
    bdba localbdba = a(paramInt1, paramInt2, paramInt3, paramInt4, true, parambczg);
    if (localbdba != null)
    {
      arrayOfbdba[0] = localbdba;
      a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + localbdba.a + " " + localbdba.b);
      parambczg = a(localbdba.a, localbdba.b, paramInt3, paramInt4, 1, parambczg);
      arrayOfbdba[1] = parambczg;
      if (parambczg != null) {
        a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + parambczg.a + " " + parambczg.b);
      }
    }
    return arrayOfbdba;
  }
  
  @TargetApi(21)
  private static bdba b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, bczg parambczg)
  {
    if (parambczg != null) {}
    try
    {
      if (!parambczg.a())
      {
        a(2, "[Camera2]getPreviewSizeV3 camera2Info: " + parambczg);
        return null;
      }
      Object localObject1 = (StreamConfigurationMap)parambczg.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      parambczg = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      if (localObject1 == null) {
        return null;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        parambczg.add(new bdba(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (parambczg.size() > 0)
      {
        i = 0;
        while (i < parambczg.size())
        {
          a(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((bdba)parambczg.get(i)).a + " height=" + ((bdba)parambczg.get(i)).b + " w/h=" + ((bdba)parambczg.get(i)).a / ((bdba)parambczg.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(parambczg, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + localObject1);
        }
        if (paramBoolean) {
          alrr.a(2, paramInt1, paramInt2, ((bdba)localObject1).a, ((bdba)localObject1).b);
        }
      }
      else
      {
        localObject1 = a(parambczg, paramInt1, paramInt2, 2600, 1500, 1000, 700);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + localObject1);
          }
          if (!paramBoolean) {
            break label519;
          }
          alrr.a(3, paramInt1, paramInt2, ((bdba)localObject1).a, ((bdba)localObject1).b);
          break label519;
        }
        parambczg = a(parambczg, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean)
        {
          if (parambczg != null) {
            break label495;
          }
          paramInt3 = 0;
          break label522;
        }
      }
      for (;;)
      {
        alrr.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
        if (QLog.isColorLevel())
        {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + parambczg);
          return parambczg;
          label495:
          paramInt3 = parambczg.a;
        }
        label519:
        label522:
        while (parambczg != null)
        {
          paramInt4 = parambczg.b;
          break;
          return parambczg;
          return localObject1;
          return localObject1;
        }
        paramInt4 = 0;
      }
      return null;
    }
    catch (Exception parambczg) {}
  }
  
  public static bdba[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bczg parambczg)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    if (parambczg == null)
    {
      a(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + parambczg);
      return null;
    }
    bdba[] arrayOfbdba = new bdba[2];
    bdba localbdba = b(paramInt1, paramInt2, paramInt3, paramInt4, true, parambczg);
    if (localbdba != null)
    {
      arrayOfbdba[0] = localbdba;
      a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + localbdba.a + " " + localbdba.b);
      parambczg = a(localbdba.a, localbdba.b, paramInt3, paramInt4, 1, parambczg);
      arrayOfbdba[1] = parambczg;
      if (parambczg != null) {
        a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + parambczg.a + " " + parambczg.b);
      }
    }
    return arrayOfbdba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczm
 * JD-Core Version:    0.7.0.1
 */