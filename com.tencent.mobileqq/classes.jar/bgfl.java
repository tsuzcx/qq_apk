import android.graphics.Bitmap.Config;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.component.media.image.ImageLoader.Options;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PanoramaUtil.1;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneHardwareRestriction;
import java.util.ArrayList;

public class bgfl
{
  private static int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaSwitch", 1);
  private static bgfl jdField_a_of_type_Bgfl;
  private static final String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaBlackListValue", "MI 3");
  private static final int jdField_b_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaBlackListLevelValue", 20);
  private static final String c = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaRotationBlackListValue", "KNT-AL20");
  private ArrayList<float[]> jdField_a_of_type_JavaUtilArrayList;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile String d;
  
  public static bgfl a()
  {
    if (jdField_a_of_type_Bgfl == null) {}
    try
    {
      if (jdField_a_of_type_Bgfl == null) {
        jdField_a_of_type_Bgfl = new bgfl();
      }
      return jdField_a_of_type_Bgfl;
    }
    finally {}
  }
  
  private ArrayList<float[]> a(ArrayList<float[]> paramArrayList, float paramFloat, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    QZLog.i("PanoramaUtil", 4, new Object[] { "cylinderList size = ", Integer.valueOf(((ArrayList)localObject).size()) });
    if ((((ArrayList)localObject).size() == 2) && (((ArrayList)localObject).get(0) != null) && (((float[])((ArrayList)localObject).get(0)).length > 0) && (((ArrayList)localObject).get(1) != null) && (((float[])((ArrayList)localObject).get(1)).length > 0)) {
      return localObject;
    }
    ((ArrayList)localObject).clear();
    float f3 = 360.0F / 36;
    int i = (int)(paramFloat / 10.0F) * 6;
    paramArrayList = new float[i * 3];
    float[] arrayOfFloat = new float[i * 2];
    int j = 0;
    i = 0;
    if (paramBoolean) {}
    for (float f1 = paramFloat / 10.0F;; f1 = 1.0F)
    {
      float f4 = 360.0F / paramFloat;
      for (float f2 = 0.0F; Math.ceil(f2) < paramFloat; f2 += f3)
      {
        double d3 = Math.toRadians(f2);
        double d1 = Math.toRadians(f2 + f3);
        double d4 = f4 * d3;
        double d2 = f4 * d1;
        int k = j + 1;
        paramArrayList[j] = ((float)(-100.0F * Math.sin(d3)));
        int m = k + 1;
        paramArrayList[k] = (--55);
        j = m + 1;
        paramArrayList[m] = ((float)(-100.0F * Math.cos(d3)));
        k = i + 1;
        arrayOfFloat[i] = (-(float)(d4 / 6.283185307179586D) * f1);
        i = k + 1;
        arrayOfFloat[k] = 0;
        k = j + 1;
        paramArrayList[j] = ((float)(-100.0F * Math.sin(d1)));
        m = k + 1;
        paramArrayList[k] = -55;
        j = m + 1;
        paramArrayList[m] = ((float)(-100.0F * Math.cos(d1)));
        k = i + 1;
        arrayOfFloat[i] = (-(float)(d2 / 6.283185307179586D) * f1);
        i = k + 1;
        arrayOfFloat[k] = 1;
        k = j + 1;
        paramArrayList[j] = ((float)(-100.0F * Math.sin(d3)));
        m = k + 1;
        paramArrayList[k] = -55;
        j = m + 1;
        paramArrayList[m] = ((float)(-100.0F * Math.cos(d3)));
        k = i + 1;
        arrayOfFloat[i] = (-(float)(d4 / 6.283185307179586D) * f1);
        i = k + 1;
        arrayOfFloat[k] = 1;
        k = j + 1;
        paramArrayList[j] = ((float)(-100.0F * Math.sin(d3)));
        m = k + 1;
        paramArrayList[k] = (--55);
        j = m + 1;
        double d5 = -100.0F;
        paramArrayList[m] = ((float)(Math.cos(d3) * d5));
        k = i + 1;
        arrayOfFloat[i] = (-(float)(d4 / 6.283185307179586D) * f1);
        i = k + 1;
        arrayOfFloat[k] = 0;
        k = j + 1;
        paramArrayList[j] = ((float)(-100.0F * Math.sin(d1)));
        m = k + 1;
        paramArrayList[k] = (--55);
        j = m + 1;
        paramArrayList[m] = ((float)(-100.0F * Math.cos(d1)));
        k = i + 1;
        arrayOfFloat[i] = (-(float)(d2 / 6.283185307179586D) * f1);
        i = k + 1;
        arrayOfFloat[k] = 0;
        k = j + 1;
        paramArrayList[j] = ((float)(-100.0F * Math.sin(d1)));
        m = k + 1;
        paramArrayList[k] = -55;
        j = m + 1;
        d3 = -100.0F;
        paramArrayList[m] = ((float)(Math.cos(d1) * d3));
        k = i + 1;
        arrayOfFloat[i] = (-(float)(d2 / 6.283185307179586D) * f1);
        i = k + 1;
        arrayOfFloat[k] = 1;
      }
    }
    ((ArrayList)localObject).add(paramArrayList);
    ((ArrayList)localObject).add(arrayOfFloat);
    return localObject;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QZLog.i("PanoramaUtil", 1, "buildModel is empty,not show panorama items.命中禁止全景策略");
        return true;
      }
      if (QZLog.isColorLevel()) {
        QZLog.d("PanoramaUtil", 2, "buildModel is '" + str + "'");
      }
      if ((paramString == null) || (paramString.length() == 0)) {
        break label150;
      }
      str = "," + str + ",";
      if (("," + paramString + ",").contains(str))
      {
        QZLog.i("PanoramaUtil", 1, "命中禁止全景黑名单策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
    label150:
    return false;
  }
  
  public int a(ImageLoader.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = 2;
    int i = 1;
    QZLog.i("PanoramaUtil", 4, new Object[] { "computeSampleSize width = ", Integer.valueOf(paramInt1), " height = ", Integer.valueOf(paramInt2) });
    if (paramInt1 / paramInt2 == 2)
    {
      if (paramInt1 > 4096) {
        paramOptions.imageConfig = Bitmap.Config.RGB_565;
      }
      if (paramOptions.imageConfig == Bitmap.Config.RGB_565) {}
      for (;;)
      {
        i = 1;
        for (;;)
        {
          k = i;
          if (paramInt1 / i * (paramInt2 / i) * j / 1024 / 1024 <= 32) {
            break;
          }
          i <<= 1;
        }
        j = 4;
      }
    }
    if (paramInt1 < paramInt2)
    {
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    while (paramInt2 / paramInt1 > 320)
    {
      paramInt1 <<= 1;
      continue;
      paramInt1 = i;
    }
    int k = paramInt1;
    return k;
  }
  
  public ArrayList<float[]> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    QZLog.i("PanoramaUtil", 4, new Object[] { "sphereList size = ", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 2) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null) && (((float[])this.jdField_a_of_type_JavaUtilArrayList.get(0)).length > 0) && (this.jdField_a_of_type_JavaUtilArrayList.get(1) != null) && (((float[])this.jdField_a_of_type_JavaUtilArrayList.get(1)).length > 0)) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    double d1 = 6.283185307179586D / 72;
    double d2 = 1.0F / 72;
    double d3 = 1.0F / 72;
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    int i = 0;
    while (i < 72)
    {
      j = 0;
      while (j < 72)
      {
        float f1 = 4 * (float)(Math.sin(i * d1 / 2.0D) * Math.cos(j * d1));
        float f2 = 4 * (float)(Math.sin(i * d1 / 2.0D) * Math.sin(j * d1));
        float f3 = 4 * (float)Math.cos(i * d1 / 2.0D);
        float f4 = 4;
        float f5 = (float)(Math.sin((i + 1) * d1 / 2.0D) * Math.cos(j * d1));
        float f6 = 4;
        float f7 = (float)(Math.sin((i + 1) * d1 / 2.0D) * Math.sin(j * d1));
        float f8 = 4;
        float f9 = (float)Math.cos((i + 1) * d1 / 2.0D);
        float f10 = 4 * (float)(Math.sin((i + 1) * d1 / 2.0D) * Math.cos((j + 1) * d1));
        float f11 = 4 * (float)(Math.sin((i + 1) * d1 / 2.0D) * Math.sin((j + 1) * d1));
        float f12 = 4 * (float)Math.cos((i + 1) * d1 / 2.0D);
        float f13 = 4;
        float f14 = (float)(Math.sin(i * d1 / 2.0D) * Math.cos((j + 1) * d1));
        float f15 = 4;
        float f16 = (float)(Math.sin(i * d1 / 2.0D) * Math.sin((j + 1) * d1));
        float f17 = 4;
        float f18 = (float)Math.cos(i * d1 / 2.0D);
        ((ArrayList)localObject).add(Float.valueOf(f1));
        ((ArrayList)localObject).add(Float.valueOf(f3));
        ((ArrayList)localObject).add(Float.valueOf(f2));
        ((ArrayList)localObject).add(Float.valueOf(f4 * f5));
        ((ArrayList)localObject).add(Float.valueOf(f8 * f9));
        ((ArrayList)localObject).add(Float.valueOf(f6 * f7));
        ((ArrayList)localObject).add(Float.valueOf(f10));
        ((ArrayList)localObject).add(Float.valueOf(f12));
        ((ArrayList)localObject).add(Float.valueOf(f11));
        ((ArrayList)localObject).add(Float.valueOf(f10));
        ((ArrayList)localObject).add(Float.valueOf(f12));
        ((ArrayList)localObject).add(Float.valueOf(f11));
        ((ArrayList)localObject).add(Float.valueOf(f13 * f14));
        ((ArrayList)localObject).add(Float.valueOf(f17 * f18));
        ((ArrayList)localObject).add(Float.valueOf(f15 * f16));
        ((ArrayList)localObject).add(Float.valueOf(f1));
        ((ArrayList)localObject).add(Float.valueOf(f3));
        ((ArrayList)localObject).add(Float.valueOf(f2));
        f1 = (float)(i * d3);
        f2 = (float)(j * d2);
        f3 = (float)((i + 1) * d3);
        f4 = (float)(j * d2);
        f5 = (float)((i + 1) * d3);
        f6 = (float)((j + 1) * d2);
        f7 = (float)(i * d3);
        f8 = (float)((j + 1) * d2);
        localArrayList.add(Float.valueOf(f2));
        localArrayList.add(Float.valueOf(f1));
        localArrayList.add(Float.valueOf(f4));
        localArrayList.add(Float.valueOf(f3));
        localArrayList.add(Float.valueOf(f6));
        localArrayList.add(Float.valueOf(f5));
        localArrayList.add(Float.valueOf(f6));
        localArrayList.add(Float.valueOf(f5));
        localArrayList.add(Float.valueOf(f8));
        localArrayList.add(Float.valueOf(f7));
        localArrayList.add(Float.valueOf(f2));
        localArrayList.add(Float.valueOf(f1));
        j += 1;
      }
      i += 1;
    }
    int j = ((ArrayList)localObject).size() / 3;
    float[] arrayOfFloat = new float[j * 3];
    i = 0;
    while (i < arrayOfFloat.length)
    {
      arrayOfFloat[i] = ((Float)((ArrayList)localObject).get(i)).floatValue();
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(arrayOfFloat);
    localObject = new float[j * 2];
    i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((Float)localArrayList.get(i)).floatValue();
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    QZLog.i("PanoramaUtil", 4, new Object[] { "currentTime getSphereCoordinate = ", Long.valueOf(System.currentTimeMillis() - l) });
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList<float[]> a(float paramFloat, boolean paramBoolean)
  {
    return a(new ArrayList(), paramFloat, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new PanoramaUtil.1(this, paramString2, paramString1, paramInt));
  }
  
  public boolean a()
  {
    return QzoneHardwareRestriction.getCurrentMemLevel() == 3;
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (jdField_a_of_type_Int == 0) {}
    while (Build.VERSION.SDK_INT <= jdField_b_of_type_Int) {
      return false;
    }
    if (jdField_a_of_type_JavaLangString == null) {
      return true;
    }
    if (!jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Boolean = a(jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    }
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean c()
  {
    if ((c == null) || (Build.VERSION.SDK_INT < 24)) {
      return false;
    }
    if (!c.equals(this.d))
    {
      this.jdField_b_of_type_Boolean = a(c);
      this.d = c;
    }
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgfl
 * JD-Core Version:    0.7.0.1
 */