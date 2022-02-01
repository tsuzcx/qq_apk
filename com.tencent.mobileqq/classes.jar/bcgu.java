import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbcij;>;

@TargetApi(21)
public class bcgu
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
  private static bcij a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, bcgo parambcgo)
  {
    if (parambcgo != null) {}
    Object localObject2;
    for (;;)
    {
      ArrayList localArrayList;
      float f2;
      try
      {
        if (!parambcgo.a())
        {
          a(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
        Object localObject1 = (StreamConfigurationMap)parambcgo.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null)
        {
          a(2, "[Camera2]getPictureSize map null!");
          return null;
        }
        parambcgo = new bcij();
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
          ((List)localObject1).add(new bcij(localArrayList.getWidth(), localArrayList.getHeight()));
          i += 1;
          continue;
        }
        localObject2 = new bcij();
        f1 = 10000.0F;
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        float f3 = paramInt1 / i;
        localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          bcij localbcij = (bcij)localIterator.next();
          a(1, "[Camera2] setPictureSize[list]: width=" + localbcij.a + " height=" + localbcij.b + " w/h=" + localbcij.a / localbcij.b);
          float f4 = localbcij.a / localbcij.b;
          if (Math.abs(f4 - f3) <= bcig.a) {
            localArrayList.add(localbcij);
          }
          f2 = f1;
          if (localbcij.a < paramInt1) {
            break label685;
          }
          f2 = f1;
          if (f1 <= Math.abs(f4 - f3)) {
            break label685;
          }
          f2 = Math.abs(f4 - f3);
          ((bcij)localObject2).a = localbcij.a;
          ((bcij)localObject2).b = localbcij.b;
          break label685;
        }
        if ((localArrayList.isEmpty()) && (((bcij)localObject2).a >= paramInt1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + ((bcij)localObject2).a + " height=" + ((bcij)localObject2).b + " w/h=" + ((bcij)localObject2).a / ((bcij)localObject2).b);
          break;
        }
        if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
        {
          parambcgo.a = ((bcij)((List)localObject1).get(0)).a;
          parambcgo.b = ((bcij)((List)localObject1).get(0)).b;
          return parambcgo;
        }
        if (localArrayList.isEmpty()) {
          return null;
        }
        if (paramInt5 == -1)
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bcij)((Iterator)localObject1).next();
            if (parambcgo.a >= ((bcij)localObject2).a) {
              continue;
            }
            parambcgo.a = ((bcij)localObject2).a;
            parambcgo.b = ((bcij)localObject2).b;
            continue;
          }
          if (parambcgo.a != 0) {
            break label682;
          }
        }
      }
      catch (Exception parambcgo)
      {
        a(2, "[Camera2]getPictureSize" + parambcgo);
        return null;
      }
      for (;;)
      {
        return null;
        parambcgo = a(paramInt3, paramInt4, paramInt5, localArrayList);
      }
      label682:
      return parambcgo;
      label685:
      float f1 = f2;
    }
    return localObject2;
  }
  
  public static bcij a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, bcgo parambcgo)
  {
    int j = 0;
    if (parambcgo != null) {}
    try
    {
      if (!parambcgo.a())
      {
        a(2, "[Camera2]getPreviewSizeV2 camera2Info: " + parambcgo);
        return null;
      }
      localObject1 = (StreamConfigurationMap)parambcgo.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      parambcgo = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        parambcgo.add(new bcij(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (parambcgo.size() > 0)
      {
        i = 0;
        while (i < parambcgo.size())
        {
          a(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((bcij)parambcgo.get(i)).a + " height=" + ((bcij)parambcgo.get(i)).b + " w/h=" + ((bcij)parambcgo.get(i)).a / ((bcij)parambcgo.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(parambcgo, paramInt1, paramInt2);
      if (localObject1 != null)
      {
        parambcgo = (bcgo)localObject1;
        if (!QLog.isColorLevel()) {
          break label417;
        }
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + ((bcij)localObject1).toString());
        return localObject1;
      }
    }
    catch (Exception parambcgo)
    {
      a(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
    }
    Object localObject1 = a(parambcgo, 960, 720);
    if (localObject1 != null)
    {
      parambcgo = (bcgo)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
        return localObject1;
      }
    }
    else
    {
      localObject1 = a(parambcgo, paramInt1, paramInt2, paramInt3, paramInt4);
      parambcgo = (bcgo)localObject1;
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
      alkm.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject1;
      paramInt3 = ((bcij)localObject1).a;
      label417:
      label420:
      while (localObject1 != null)
      {
        paramInt4 = ((bcij)localObject1).b;
        break;
        return parambcgo;
      }
      paramInt4 = j;
    }
  }
  
  private static bcij a(int paramInt1, int paramInt2, int paramInt3, List<bcij> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    bcij localbcij1 = new bcij(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      bcij localbcij2 = (bcij)paramList.next();
      paramInt2 = Math.abs(localbcij2.a - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label126;
      }
      localbcij1.a = localbcij2.a;
      localbcij1.b = localbcij2.b;
      paramInt1 = paramInt2;
    }
    label126:
    for (;;)
    {
      break;
      return localbcij1;
    }
  }
  
  private static bcij a(List<bcij> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    bcij localbcij1 = new bcij();
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
          bcij localbcij2 = (bcij)paramList.next();
          if ((localbcij2 == null) || (localbcij2.b != paramInt2) || (localbcij2.a < paramInt1) || ((i >= 0) && (localbcij2.a > i))) {
            break label235;
          }
          i = localbcij2.a;
        }
      }
    }
    label235:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localbcij1.b = paramInt2;
        localbcij1.a = i;
        if (localbcij1.a / 4 == localbcij1.b / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
          }
          return localbcij1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + localbcij1.toString());
        }
        return localbcij1;
      }
      return null;
    }
  }
  
  private static bcij a(List<bcij> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d);
    }
    bcij localbcij1 = new bcij();
    Iterator localIterator;
    long l1;
    bcij localbcij2;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localbcij2 = (bcij)localIterator.next();
        if ((localbcij2 != null) && (localbcij2.a >= paramInt1) && (localbcij2.b >= paramInt2) && (localbcij2.a / localbcij2.b >= d))
        {
          l2 = localbcij2.a * localbcij2.b;
          if (l2 < l1)
          {
            localbcij1.a = localbcij2.a;
            localbcij1.b = localbcij2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localbcij2.a < localbcij1.a))
          {
            localbcij1.a = localbcij2.a;
            localbcij1.b = localbcij2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localbcij1.a <= 0) || (localbcij1.b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localbcij2 = (bcij)localIterator.next();
        if ((localbcij2 != null) && (localbcij2.a / localbcij2.b >= d))
        {
          l2 = localbcij2.a * localbcij2.b;
          if (l2 > l1)
          {
            localbcij1.a = localbcij2.a;
            localbcij1.b = localbcij2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localbcij2.a < localbcij1.a))
          {
            localbcij1.a = localbcij2.a;
            localbcij1.b = localbcij2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + localbcij1.a + "  cSize.height=" + localbcij1.b);
    }
    if ((localbcij1.a > 0) && (localbcij1.b > 0)) {
      return localbcij1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localbcij1.a = ((bcij)paramList.get(0)).a;
      localbcij1.b = ((bcij)paramList.get(0)).b;
      return localbcij1;
    }
    return null;
  }
  
  private static bcij a(List<bcij> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
      bcij localbcij;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localbcij = (bcij)paramList.next();
        if (localbcij == null) {
          continue;
        }
        i = Math.max(localbcij.a, localbcij.b);
        j = Math.min(localbcij.a, localbcij.b);
        if ((localbcij.b != paramInt2) || (i != paramInt1)) {
          break label347;
        }
        ((List)localObject1).add(new bcij(paramInt1, paramInt2));
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
          localbcij = (bcij)paramList.next();
          if (localbcij == null) {
            break label880;
          }
          paramInt1 = Math.max(localbcij.a, localbcij.b);
          paramInt2 = Math.min(localbcij.a, localbcij.b);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < bcig.a) {
            ((List)localObject1).add(localbcij);
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
        ((List)localObject2).add(new bcij(i, j));
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
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((bcij)((List)localObject1).get(paramInt1)).a + " height=" + ((bcij)((List)localObject1).get(paramInt1)).b + " w/h=" + ((bcij)((List)localObject1).get(paramInt1)).a / ((bcij)((List)localObject1).get(paramInt1)).b);
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
            localObject2 = (bcij)paramList.next();
            if (localObject2 != null)
            {
              paramInt1 = Math.max(((bcij)localObject2).a, ((bcij)localObject2).b);
              paramInt2 = Math.min(((bcij)localObject2).a, ((bcij)localObject2).b);
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < bcig.a) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((bcij)((List)localObject1).get(paramInt1)).a + " height=" + ((bcij)((List)localObject1).get(paramInt1)).b + " w/h=" + ((bcij)((List)localObject1).get(paramInt1)).a / ((bcij)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (bcij)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label874;
          }
          localObject1 = (bcij)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((bcij)localObject1).a * ((bcij)localObject1).b <= paramList.a * paramList.b)) {
            break label877;
          }
          paramList = (List<bcij>)localObject1;
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
  
  public static bcij[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bcgo parambcgo)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    bcij[] arrayOfbcij = new bcij[2];
    bcij localbcij = a(paramInt1, paramInt2, paramInt3, paramInt4, true, parambcgo);
    if (localbcij != null)
    {
      arrayOfbcij[0] = localbcij;
      a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + localbcij.a + " " + localbcij.b);
      parambcgo = a(localbcij.a, localbcij.b, paramInt3, paramInt4, 1, parambcgo);
      arrayOfbcij[1] = parambcgo;
      if (parambcgo != null) {
        a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + parambcgo.a + " " + parambcgo.b);
      }
    }
    return arrayOfbcij;
  }
  
  @TargetApi(21)
  private static bcij b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, bcgo parambcgo)
  {
    if (parambcgo != null) {}
    try
    {
      if (!parambcgo.a())
      {
        a(2, "[Camera2]getPreviewSizeV3 camera2Info: " + parambcgo);
        return null;
      }
      Object localObject1 = (StreamConfigurationMap)parambcgo.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      parambcgo = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      if (localObject1 == null) {
        return null;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        parambcgo.add(new bcij(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (parambcgo.size() > 0)
      {
        i = 0;
        while (i < parambcgo.size())
        {
          a(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((bcij)parambcgo.get(i)).a + " height=" + ((bcij)parambcgo.get(i)).b + " w/h=" + ((bcij)parambcgo.get(i)).a / ((bcij)parambcgo.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(parambcgo, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + localObject1);
        }
        if (paramBoolean) {
          alkm.a(2, paramInt1, paramInt2, ((bcij)localObject1).a, ((bcij)localObject1).b);
        }
      }
      else
      {
        localObject1 = a(parambcgo, paramInt1, paramInt2, 2600, 1500, 1000, 700);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + localObject1);
          }
          if (!paramBoolean) {
            break label519;
          }
          alkm.a(3, paramInt1, paramInt2, ((bcij)localObject1).a, ((bcij)localObject1).b);
          break label519;
        }
        parambcgo = a(parambcgo, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean)
        {
          if (parambcgo != null) {
            break label495;
          }
          paramInt3 = 0;
          break label522;
        }
      }
      for (;;)
      {
        alkm.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
        if (QLog.isColorLevel())
        {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + parambcgo);
          return parambcgo;
          label495:
          paramInt3 = parambcgo.a;
        }
        label519:
        label522:
        while (parambcgo != null)
        {
          paramInt4 = parambcgo.b;
          break;
          return parambcgo;
          return localObject1;
          return localObject1;
        }
        paramInt4 = 0;
      }
      return null;
    }
    catch (Exception parambcgo) {}
  }
  
  public static bcij[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bcgo parambcgo)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    if (parambcgo == null)
    {
      a(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + parambcgo);
      return null;
    }
    bcij[] arrayOfbcij = new bcij[2];
    bcij localbcij = b(paramInt1, paramInt2, paramInt3, paramInt4, true, parambcgo);
    if (localbcij != null)
    {
      arrayOfbcij[0] = localbcij;
      a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + localbcij.a + " " + localbcij.b);
      parambcgo = a(localbcij.a, localbcij.b, paramInt3, paramInt4, 1, parambcgo);
      arrayOfbcij[1] = parambcgo;
      if (parambcgo != null) {
        a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + parambcgo.a + " " + parambcgo.b);
      }
    }
    return arrayOfbcij;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgu
 * JD-Core Version:    0.7.0.1
 */