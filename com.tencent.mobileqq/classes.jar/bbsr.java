import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbbuf;>;

@TargetApi(21)
public class bbsr
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
  private static bbuf a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, bbsl parambbsl)
  {
    if (parambbsl != null) {}
    Object localObject2;
    for (;;)
    {
      ArrayList localArrayList;
      float f2;
      try
      {
        if (!parambbsl.a())
        {
          a(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
        Object localObject1 = (StreamConfigurationMap)parambbsl.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null)
        {
          a(2, "[Camera2]getPictureSize map null!");
          return null;
        }
        parambbsl = new bbuf();
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
          ((List)localObject1).add(new bbuf(localArrayList.getWidth(), localArrayList.getHeight()));
          i += 1;
          continue;
        }
        localObject2 = new bbuf();
        f1 = 10000.0F;
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        float f3 = paramInt1 / i;
        localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          bbuf localbbuf = (bbuf)localIterator.next();
          a(1, "[Camera2] setPictureSize[list]: width=" + localbbuf.a + " height=" + localbbuf.b + " w/h=" + localbbuf.a / localbbuf.b);
          float f4 = localbbuf.a / localbbuf.b;
          if (Math.abs(f4 - f3) <= bbuc.a) {
            localArrayList.add(localbbuf);
          }
          f2 = f1;
          if (localbbuf.a < paramInt1) {
            break label685;
          }
          f2 = f1;
          if (f1 <= Math.abs(f4 - f3)) {
            break label685;
          }
          f2 = Math.abs(f4 - f3);
          ((bbuf)localObject2).a = localbbuf.a;
          ((bbuf)localObject2).b = localbbuf.b;
          break label685;
        }
        if ((localArrayList.isEmpty()) && (((bbuf)localObject2).a >= paramInt1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + ((bbuf)localObject2).a + " height=" + ((bbuf)localObject2).b + " w/h=" + ((bbuf)localObject2).a / ((bbuf)localObject2).b);
          break;
        }
        if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
        {
          parambbsl.a = ((bbuf)((List)localObject1).get(0)).a;
          parambbsl.b = ((bbuf)((List)localObject1).get(0)).b;
          return parambbsl;
        }
        if (localArrayList.isEmpty()) {
          return null;
        }
        if (paramInt5 == -1)
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bbuf)((Iterator)localObject1).next();
            if (parambbsl.a >= ((bbuf)localObject2).a) {
              continue;
            }
            parambbsl.a = ((bbuf)localObject2).a;
            parambbsl.b = ((bbuf)localObject2).b;
            continue;
          }
          if (parambbsl.a != 0) {
            break label682;
          }
        }
      }
      catch (Exception parambbsl)
      {
        a(2, "[Camera2]getPictureSize" + parambbsl);
        return null;
      }
      for (;;)
      {
        return null;
        parambbsl = a(paramInt3, paramInt4, paramInt5, localArrayList);
      }
      label682:
      return parambbsl;
      label685:
      float f1 = f2;
    }
    return localObject2;
  }
  
  public static bbuf a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, bbsl parambbsl)
  {
    int j = 0;
    if (parambbsl != null) {}
    try
    {
      if (!parambbsl.a())
      {
        a(2, "[Camera2]getPreviewSizeV2 camera2Info: " + parambbsl);
        return null;
      }
      localObject1 = (StreamConfigurationMap)parambbsl.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      parambbsl = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      int i;
      if (localObject1 != null)
      {
        int k = localObject1.length;
        i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          parambbsl.add(new bbuf(localObject2.getWidth(), localObject2.getHeight()));
          i += 1;
        }
      }
      if (parambbsl.size() > 0)
      {
        i = 0;
        while (i < parambbsl.size())
        {
          a(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((bbuf)parambbsl.get(i)).a + " height=" + ((bbuf)parambbsl.get(i)).b + " w/h=" + ((bbuf)parambbsl.get(i)).a / ((bbuf)parambbsl.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(parambbsl, paramInt1, paramInt2);
      if (localObject1 != null)
      {
        parambbsl = (bbsl)localObject1;
        if (!QLog.isColorLevel()) {
          break label422;
        }
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + ((bbuf)localObject1).toString());
        return localObject1;
      }
    }
    catch (Exception parambbsl)
    {
      a(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
    }
    Object localObject1 = a(parambbsl, 960, 720);
    if (localObject1 != null)
    {
      parambbsl = (bbsl)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
        return localObject1;
      }
    }
    else
    {
      localObject1 = a(parambbsl, paramInt1, paramInt2, paramInt3, paramInt4);
      parambbsl = (bbsl)localObject1;
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
      aktv.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject1;
      paramInt3 = ((bbuf)localObject1).a;
      label422:
      label425:
      while (localObject1 != null)
      {
        paramInt4 = ((bbuf)localObject1).b;
        break;
        return parambbsl;
      }
      paramInt4 = j;
    }
  }
  
  private static bbuf a(int paramInt1, int paramInt2, int paramInt3, List<bbuf> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    bbuf localbbuf1 = new bbuf(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      bbuf localbbuf2 = (bbuf)paramList.next();
      paramInt2 = Math.abs(localbbuf2.a - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label126;
      }
      localbbuf1.a = localbbuf2.a;
      localbbuf1.b = localbbuf2.b;
      paramInt1 = paramInt2;
    }
    label126:
    for (;;)
    {
      break;
      return localbbuf1;
    }
  }
  
  private static bbuf a(List<bbuf> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    bbuf localbbuf1 = new bbuf();
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
          bbuf localbbuf2 = (bbuf)paramList.next();
          if ((localbbuf2 == null) || (localbbuf2.b != paramInt2) || (localbbuf2.a < paramInt1) || ((i >= 0) && (localbbuf2.a > i))) {
            break label235;
          }
          i = localbbuf2.a;
        }
      }
    }
    label235:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localbbuf1.b = paramInt2;
        localbbuf1.a = i;
        if (localbbuf1.a / 4 == localbbuf1.b / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
          }
          return localbbuf1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + localbbuf1.toString());
        }
        return localbbuf1;
      }
      return null;
    }
  }
  
  private static bbuf a(List<bbuf> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d);
    }
    bbuf localbbuf1 = new bbuf();
    Iterator localIterator;
    long l1;
    bbuf localbbuf2;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localbbuf2 = (bbuf)localIterator.next();
        if ((localbbuf2 != null) && (localbbuf2.a >= paramInt1) && (localbbuf2.b >= paramInt2) && (localbbuf2.a / localbbuf2.b >= d))
        {
          l2 = localbbuf2.a * localbbuf2.b;
          if (l2 < l1)
          {
            localbbuf1.a = localbbuf2.a;
            localbbuf1.b = localbbuf2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localbbuf2.a < localbbuf1.a))
          {
            localbbuf1.a = localbbuf2.a;
            localbbuf1.b = localbbuf2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localbbuf1.a <= 0) || (localbbuf1.b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localbbuf2 = (bbuf)localIterator.next();
        if ((localbbuf2 != null) && (localbbuf2.a / localbbuf2.b >= d))
        {
          l2 = localbbuf2.a * localbbuf2.b;
          if (l2 > l1)
          {
            localbbuf1.a = localbbuf2.a;
            localbbuf1.b = localbbuf2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localbbuf2.a < localbbuf1.a))
          {
            localbbuf1.a = localbbuf2.a;
            localbbuf1.b = localbbuf2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + localbbuf1.a + "  cSize.height=" + localbbuf1.b);
    }
    if ((localbbuf1.a > 0) && (localbbuf1.b > 0)) {
      return localbbuf1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localbbuf1.a = ((bbuf)paramList.get(0)).a;
      localbbuf1.b = ((bbuf)paramList.get(0)).b;
      return localbbuf1;
    }
    return null;
  }
  
  private static bbuf a(List<bbuf> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
      bbuf localbbuf;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localbbuf = (bbuf)paramList.next();
        if (localbbuf == null) {
          continue;
        }
        i = Math.max(localbbuf.a, localbbuf.b);
        j = Math.min(localbbuf.a, localbbuf.b);
        if ((localbbuf.b != paramInt2) || (i != paramInt1)) {
          break label347;
        }
        ((List)localObject1).add(new bbuf(paramInt1, paramInt2));
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
          localbbuf = (bbuf)paramList.next();
          if (localbbuf == null) {
            break label880;
          }
          paramInt1 = Math.max(localbbuf.a, localbbuf.b);
          paramInt2 = Math.min(localbbuf.a, localbbuf.b);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < bbuc.a) {
            ((List)localObject1).add(localbbuf);
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
        ((List)localObject2).add(new bbuf(i, j));
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
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((bbuf)((List)localObject1).get(paramInt1)).a + " height=" + ((bbuf)((List)localObject1).get(paramInt1)).b + " w/h=" + ((bbuf)((List)localObject1).get(paramInt1)).a / ((bbuf)((List)localObject1).get(paramInt1)).b);
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
            localObject2 = (bbuf)paramList.next();
            if (localObject2 != null)
            {
              paramInt1 = Math.max(((bbuf)localObject2).a, ((bbuf)localObject2).b);
              paramInt2 = Math.min(((bbuf)localObject2).a, ((bbuf)localObject2).b);
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < bbuc.a) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((bbuf)((List)localObject1).get(paramInt1)).a + " height=" + ((bbuf)((List)localObject1).get(paramInt1)).b + " w/h=" + ((bbuf)((List)localObject1).get(paramInt1)).a / ((bbuf)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (bbuf)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label874;
          }
          localObject1 = (bbuf)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((bbuf)localObject1).a * ((bbuf)localObject1).b <= paramList.a * paramList.b)) {
            break label877;
          }
          paramList = (List<bbuf>)localObject1;
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
  
  public static bbuf[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bbsl parambbsl)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    bbuf[] arrayOfbbuf = new bbuf[2];
    bbuf localbbuf = a(paramInt1, paramInt2, paramInt3, paramInt4, true, parambbsl);
    if (localbbuf != null)
    {
      arrayOfbbuf[0] = localbbuf;
      a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + localbbuf.a + " " + localbbuf.b);
      parambbsl = a(localbbuf.a, localbbuf.b, paramInt3, paramInt4, 1, parambbsl);
      arrayOfbbuf[1] = parambbsl;
      if (parambbsl != null) {
        a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + parambbsl.a + " " + parambbsl.b);
      }
    }
    return arrayOfbbuf;
  }
  
  @TargetApi(21)
  private static bbuf b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, bbsl parambbsl)
  {
    if (parambbsl != null) {}
    try
    {
      if (!parambbsl.a())
      {
        a(2, "[Camera2]getPreviewSizeV3 camera2Info: " + parambbsl);
        return null;
      }
      Object localObject1 = (StreamConfigurationMap)parambbsl.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      parambbsl = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      if (localObject1 == null) {
        return null;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        parambbsl.add(new bbuf(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (parambbsl.size() > 0)
      {
        i = 0;
        while (i < parambbsl.size())
        {
          a(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((bbuf)parambbsl.get(i)).a + " height=" + ((bbuf)parambbsl.get(i)).b + " w/h=" + ((bbuf)parambbsl.get(i)).a / ((bbuf)parambbsl.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(parambbsl, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + localObject1);
        }
        if (paramBoolean) {
          aktv.a(2, paramInt1, paramInt2, ((bbuf)localObject1).a, ((bbuf)localObject1).b);
        }
      }
      else
      {
        localObject1 = a(parambbsl, paramInt1, paramInt2, 2600, 1500, 1000, 700);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + localObject1);
          }
          if (!paramBoolean) {
            break label519;
          }
          aktv.a(3, paramInt1, paramInt2, ((bbuf)localObject1).a, ((bbuf)localObject1).b);
          break label519;
        }
        parambbsl = a(parambbsl, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean)
        {
          if (parambbsl != null) {
            break label495;
          }
          paramInt3 = 0;
          break label522;
        }
      }
      for (;;)
      {
        aktv.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
        if (QLog.isColorLevel())
        {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + parambbsl);
          return parambbsl;
          label495:
          paramInt3 = parambbsl.a;
        }
        label519:
        label522:
        while (parambbsl != null)
        {
          paramInt4 = parambbsl.b;
          break;
          return parambbsl;
          return localObject1;
          return localObject1;
        }
        paramInt4 = 0;
      }
      return null;
    }
    catch (Exception parambbsl) {}
  }
  
  public static bbuf[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bbsl parambbsl)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    if (parambbsl == null)
    {
      a(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + parambbsl);
      return null;
    }
    bbuf[] arrayOfbbuf = new bbuf[2];
    bbuf localbbuf = b(paramInt1, paramInt2, paramInt3, paramInt4, true, parambbsl);
    if (localbbuf != null)
    {
      arrayOfbbuf[0] = localbbuf;
      a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + localbbuf.a + " " + localbbuf.b);
      parambbsl = a(localbbuf.a, localbbuf.b, paramInt3, paramInt4, 1, parambbsl);
      arrayOfbbuf[1] = parambbsl;
      if (parambbsl != null) {
        a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + parambbsl.a + " " + parambbsl.b);
      }
    }
    return arrayOfbbuf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsr
 * JD-Core Version:    0.7.0.1
 */