import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.pfc.opencv.QzoneVision;
import cooperation.qzone.util.GifAntishakeModule.1;
import cooperation.qzone.util.GifAntishakeModule.2;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class bmik
{
  public static int a;
  public static bmik a;
  public static String a;
  private static ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static int jdField_c_of_type_Int = 16;
  private static int jdField_d_of_type_Int;
  private float jdField_a_of_type_Float = Float.parseFloat(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMinSimilarity", "0.6"));
  private long jdField_a_of_type_Long = Long.parseLong(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxGroupShootTime", "60000"));
  private bmil jdField_a_of_type_Bmil;
  private long jdField_b_of_type_Long = Long.parseLong(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxFrameShootTime", "3000"));
  private String jdField_b_of_type_JavaLangString = anhk.aZ + "/tencent/Qzone/AntishakeGif/";
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString = ".nomedia";
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GIFANTISHAKEMODULE_STATUS";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(bgln.b(), bgln.b() + 5, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    a();
  }
  
  public bmik()
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeNeedToCheckShootTime", 0) == 1)
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeNeedToCheckSimilarity", 1) != 1) {
        break label173;
      }
    }
    label173:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_d_of_type_Boolean = bool1;
      bool1 = bool2;
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeUseDHash", 1) == 1) {
        bool1 = true;
      }
      this.e = bool1;
      this.f = true;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int j = 0;
    int k;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramString1.length() != paramString2.length()))
    {
      k = jdField_c_of_type_Int;
      return k;
    }
    for (int i = 0;; i = k)
    {
      k = i;
      if (j >= paramString1.length()) {
        break;
      }
      k = i;
      if (paramString1.charAt(j) != paramString2.charAt(j)) {
        k = i + 1;
      }
      j += 1;
    }
  }
  
  public static long a(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = new ExifInterface(paramString);
      l2 = 0L;
      l1 = l2;
      if (paramString != null)
      {
        paramString.getAttribute("DateTime");
        paramString = paramString.getAttribute("DateTime");
        l1 = l2;
        if (paramString != null) {
          localSimpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        }
      }
    }
    catch (IOException paramString)
    {
      try
      {
        long l2;
        SimpleDateFormat localSimpleDateFormat;
        paramString = localSimpleDateFormat.parse(paramString);
        long l1 = l2;
        if (paramString != null) {
          l1 = paramString.getTime();
        }
        return l1;
        paramString = paramString;
        paramString.printStackTrace();
        paramString = null;
      }
      catch (ParseException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localObject;
        }
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    paramBitmap.getHeight();
    paramBitmap.getWidth();
    Bitmap localBitmap = Bitmap.createBitmap(9, 8, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  public static bmik a()
  {
    try
    {
      if (jdField_a_of_type_Bmik == null) {
        jdField_a_of_type_Bmik = new bmik();
      }
      bmik localbmik = jdField_a_of_type_Bmik;
      return localbmik;
    }
    finally {}
  }
  
  private String a()
  {
    File localFile;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      localFile = new File(bhgg.a(this.jdField_b_of_type_JavaLangString));
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(bhgg.a(this.jdField_b_of_type_JavaLangString + this.jdField_c_of_type_JavaLangString));
      if (localFile.exists()) {}
    }
    try
    {
      localFile.createNewFile();
      return this.jdField_b_of_type_JavaLangString;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("QzoneVision", 1, "getAntishakeGifFilePath: create .nomedia file fail");
      }
    }
  }
  
  public static String a(Bitmap paramBitmap)
  {
    Object localObject = "";
    int i;
    int j;
    boolean bool;
    for (;;)
    {
      try
      {
        paramBitmap = a(Bitmap.createScaledBitmap(paramBitmap, 9, 8, true));
        localArrayList = new ArrayList();
        i = 0;
      }
      catch (Throwable paramBitmap)
      {
        ArrayList localArrayList;
        label58:
        localObject = "";
        QLog.e("QzoneVision", 1, "getDhash failed t:", paramBitmap);
      }
      if (j >= 8) {
        break label236;
      }
      if (paramBitmap.getPixel(j, i) <= paramBitmap.getPixel(j + 1, i)) {
        break label230;
      }
      bool = true;
      localArrayList.add(Boolean.valueOf(bool));
      j += 1;
    }
    label214:
    label230:
    label236:
    label241:
    for (;;)
    {
      System.gc();
      int m = localArrayList.size();
      int k = 0;
      i = 0;
      paramBitmap = (Bitmap)localObject;
      localObject = paramBitmap;
      if (k < m) {
        if (!((Boolean)localArrayList.get(k)).booleanValue()) {
          break label214;
        }
      }
      for (j = (k % 8 ^ 0x2) + i;; j = i)
      {
        i = j;
        localObject = paramBitmap;
        if (k % 8 == 7)
        {
          localObject = String.format("%s%s", new Object[] { paramBitmap, String.format("%02x", new Object[] { Integer.valueOf(j) }) });
          i = 0;
        }
        k += 1;
        paramBitmap = (Bitmap)localObject;
        break;
        return localObject;
      }
      for (;;)
      {
        if (i >= 8) {
          break label241;
        }
        j = 0;
        break;
        bool = false;
        break label58;
        i += 1;
      }
    }
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      if ((QzoneVision.b()) && (a().a())) {
        jdField_a_of_type_Boolean = QzoneVision.a();
      }
    }
    else {
      return;
    }
    jdField_a_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bmil != null) {
      this.jdField_a_of_type_Bmil.a(paramInt);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 10) {
      return true;
    }
    if ((paramInt2 == 10) && (this.f) && (paramInt1 > 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "用掉了唯一一次10的机会");
      }
      this.f = false;
      return true;
    }
    return false;
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxFrameNum", 5);
  }
  
  public Boolean a(ArrayList<Bitmap> paramArrayList)
  {
    long l = System.currentTimeMillis();
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean) {
        return Boolean.valueOf(false);
      }
    }
    if ((paramArrayList == null) || (paramArrayList.size() < 2) || (paramArrayList.get(0) == null)) {
      return Boolean.valueOf(false);
    }
    int j = paramArrayList.size() - 1;
    CountDownLatch localCountDownLatch = new CountDownLatch(j);
    boolean[] arrayOfBoolean = new boolean[paramArrayList.size()];
    arrayOfBoolean[0] = true;
    Bitmap localBitmap = (Bitmap)paramArrayList.get(0);
    this.f = true;
    int i = 1;
    while (i < paramArrayList.size())
    {
      jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(new GifAntishakeModule.2(this, paramArrayList, i, localCountDownLatch, localBitmap, j + 1, arrayOfBoolean));
      i += 1;
    }
    try
    {
      localCountDownLatch.await();
      i = 0;
      if (i < paramArrayList.size()) {
        if (arrayOfBoolean[i] == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QzoneVision", 2, "总共用时:" + (System.currentTimeMillis() - l));
          }
          return Boolean.valueOf(false);
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "总共用时:" + (System.currentTimeMillis() - l));
      }
    }
    return Boolean.valueOf(true);
  }
  
  public ArrayList<String> a(ArrayList<Bitmap> paramArrayList)
  {
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean) {
        return null;
      }
    }
    if ((paramArrayList == null) || ((paramArrayList != null) && (paramArrayList.size() < 2))) {
      return null;
    }
    LocalMultiProcConfig.putInt(jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVision", 2, "startantishake at " + l1);
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    if (j < 2) {
      return null;
    }
    Bitmap localBitmap1 = (Bitmap)paramArrayList.get(0);
    int k = localBitmap1.getWidth();
    int m = localBitmap1.getHeight();
    String[] arrayOfString = new String[j];
    int n = k / 10;
    int i1 = m / 10;
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, n, i1, localBitmap1.getWidth() - n * 2, localBitmap1.getHeight() - i1 * 2);
    Object localObject = PhotoUtils.a(a(), ".IMG0", ".jpg");
    File localFile = new File((String)localObject);
    try
    {
      bgmo.a(localBitmap2, localFile);
      arrayOfString[0] = localObject;
      jdField_d_of_type_Int = 1;
      a(jdField_d_of_type_Int);
      localObject = new CountDownLatch(j - 1);
      i = 1;
      while (i < j)
      {
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(new GifAntishakeModule.1(this, i, k, m, paramArrayList, localBitmap1, n, i1, arrayOfString, (CountDownLatch)localObject));
        i += 1;
      }
    }
    catch (IOException localIOException)
    {
      int i;
      for (;;)
      {
        localIOException.printStackTrace();
      }
      try
      {
        ((CountDownLatch)localObject).await();
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i] != null) {
            localArrayList.add(arrayOfString[i]);
          }
          i += 1;
        }
      }
      catch (InterruptedException paramArrayList)
      {
        for (;;)
        {
          paramArrayList.printStackTrace();
        }
        jdField_d_of_type_Int = 0;
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "endantishake at " + l2 + ", cost " + (l2 - l1) / 1000L + "s");
        }
        System.gc();
        this.jdField_a_of_type_Bmil = null;
        LocalMultiProcConfig.putInt(jdField_a_of_type_JavaLangString, jdField_a_of_type_Int);
      }
    }
    return localArrayList;
  }
  
  public void a(bmil parambmil)
  {
    this.jdField_a_of_type_Bmil = parambmil;
  }
  
  public boolean a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeSwitch", 1) == 1;
  }
  
  public boolean a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return false;
    }
    String str = anhk.aZ + "/tencent/Qzone/AlbumAutoVConvGif/";
    if (((String)paramArrayList.get(0)).startsWith(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "checkFolder false:来自视频转GIF文件夹");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVision", 2, "checkFolder true");
    }
    return true;
  }
  
  public boolean a(ArrayList<String> paramArrayList, LruCache<Integer, BitmapDrawable> paramLruCache)
  {
    boolean bool1 = true;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2;
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean) {
        bool2 = bool3;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return bool2;
                      if (LocalMultiProcConfig.getInt(jdField_a_of_type_JavaLangString, jdField_a_of_type_Int) != jdField_b_of_type_Int) {
                        break;
                      }
                      bool2 = bool3;
                    } while (!QLog.isColorLevel());
                    QLog.d("QzoneVision", 2, "本地记录防抖正在进行或者没有正常结束 以后就不防抖了");
                    return false;
                    bool2 = bool3;
                  } while (paramArrayList == null);
                  bool2 = bool3;
                } while (paramArrayList.size() < 2);
                bool2 = bool3;
              } while (paramLruCache == null);
              bool2 = bool3;
            } while (paramLruCache.size() < 2);
            bool2 = bool3;
          } while (!a());
          bool2 = bool3;
        } while (paramArrayList.size() > a());
        bool2 = bool3;
      } while (!blsb.d());
      bool2 = bool3;
    } while (!a(paramArrayList));
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVision", 2, "DeviceInfoUtil.getMemoryClass() = " + bgln.f() / 1048576L + "M, DeviceInfoUtil.getSystemAvaialbeMemory() = " + bgln.e() / 1048576L + "M");
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
    {
      bool1 = bool4;
      if (b(paramArrayList))
      {
        paramArrayList = new ArrayList();
        if (paramLruCache == null) {
          break label580;
        }
      }
    }
    label427:
    label575:
    label580:
    for (int i = paramLruCache.size();; i = 0)
    {
      int j = 0;
      for (;;)
      {
        if (j < i) {
          if ((paramLruCache != null) && (paramLruCache.get(Integer.valueOf(j)) != null))
          {
            paramArrayList.add(((BitmapDrawable)paramLruCache.get(Integer.valueOf(j))).getBitmap());
            j += 1;
          }
          else
          {
            bool2 = bool3;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("QzoneVision", 2, "suitableForAntishake false:mMemoryCache == null || mMemoryCache.get(i) == null");
            return false;
          }
        }
      }
      bool1 = bool4;
      if (a(paramArrayList).booleanValue()) {
        bool1 = true;
      }
      for (;;)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QzoneVision", 2, "suitableForAntishake " + bool1);
        return bool1;
        if ((!this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
          break label427;
        }
        bool1 = bool4;
        if (b(paramArrayList)) {
          bool1 = true;
        }
      }
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
      {
        paramArrayList = new ArrayList();
        if (paramLruCache == null) {
          break label575;
        }
      }
      for (i = paramLruCache.size();; i = 0)
      {
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            BitmapDrawable localBitmapDrawable = (BitmapDrawable)paramLruCache.get(Integer.valueOf(j));
            if (localBitmapDrawable != null)
            {
              paramArrayList.add(localBitmapDrawable.getBitmap());
              j += 1;
            }
            else
            {
              bool2 = bool3;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QzoneVision", 2, "suitableForAntishake false:mMemoryCache == null || mMemoryCache.get(i) == null");
              return false;
            }
          }
        }
        if (a(paramArrayList).booleanValue()) {}
        for (;;)
        {
          break;
          bool1 = bool4;
          if (this.jdField_c_of_type_Boolean) {
            break;
          }
          bool1 = bool4;
          if (this.jdField_d_of_type_Boolean) {
            break;
          }
          bool1 = true;
          break;
          bool1 = false;
        }
      }
    }
  }
  
  public boolean b(ArrayList<String> paramArrayList)
  {
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean) {
        return false;
      }
    }
    if ((paramArrayList == null) || (paramArrayList.size() < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "checkShootTimeForAntishake false:filePath == null || filePath.size() < 2 || !mNativeLibLoaded");
      }
      return false;
    }
    int j = paramArrayList.size();
    long l = a((String)paramArrayList.get(0));
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "checkShootTimeForAntishake false:firstFrameTime == 0");
      }
      return false;
    }
    if ((a((String)paramArrayList.get(j - 1)) - l > this.jdField_a_of_type_Long) || (a((String)paramArrayList.get(j - 1)) - a((String)paramArrayList.get(0)) < 0L)) {
      return false;
    }
    int i = 1;
    while (i < j) {
      if (a((String)paramArrayList.get(i)) - l < this.jdField_b_of_type_Long)
      {
        l = a((String)paramArrayList.get(i));
        i += 1;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "checkShootTimeForAntishake false:getExifShootTime(filePath.get(i)) - last >= antishakeMaxFrameGapTime");
        }
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVision", 2, "checkShootTimeForAntishake true");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmik
 * JD-Core Version:    0.7.0.1
 */