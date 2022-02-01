package com.tencent.biz.qqcircle.picload;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.widget.ImageView;
import bhjc;
import bhmi;
import bjtz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import uym;
import vrd;
import vre;
import vrf;
import vrh;
import vri;
import vts;

public class QCircleFeedPicLoader
{
  public static int a;
  private static QCircleFeedPicLoader jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader;
  public static String a;
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  public static int b;
  private static final String jdField_b_of_type_JavaLangString = uym.e + "feed_pic/";
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  private static int i;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MQLruCache<String, Object> jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  private ConcurrentHashMap<String, QCircleFeedPicLoader.PicDownLoadTask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(10000);
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[1];
  private ConcurrentHashMap<String, QCircleFeedPicLoader.PicDeCodeTask> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ThreadPoolExecutor jdField_b_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private ThreadPoolExecutor c;
  private ThreadPoolExecutor d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QCircleFeedPicLoader";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
    e = 5;
    f = 6;
    g = 7;
    h = 8;
    i = 259200000;
  }
  
  private QCircleFeedPicLoader()
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache == null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
    }
    int j = Runtime.getRuntime().availableProcessors();
    if (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
      this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = a(j + 1, j * 2 + 1);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
      this.jdField_b_of_type_JavaUtilConcurrentThreadPoolExecutor = a(j + 1, j * 2 + 1);
    }
    if (this.jdField_d_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
      this.jdField_d_of_type_JavaUtilConcurrentThreadPoolExecutor = a(j + 1, j * 2 + 1);
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
      this.jdField_c_of_type_JavaUtilConcurrentThreadPoolExecutor = a(j + 1, j * 2 + 1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    ThreadManager.getFileThreadHandler().post(new QCircleFeedPicLoader.1(this));
  }
  
  private Drawable a(vrd paramvrd, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return new BitmapDrawable(BaseApplicationImpl.getContext().getResources());
    }
    byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk(arrayOfByte))
    {
      paramBitmap = new NinePatchDrawable(BaseApplicationImpl.getContext().getResources(), paramBitmap, arrayOfByte, new Rect(), null);
      paramvrd.jdField_c_of_type_Int = 2;
      return paramBitmap;
    }
    return new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), paramBitmap);
  }
  
  public static QCircleFeedPicLoader a()
  {
    if (jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader == null) {
        jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader = new QCircleFeedPicLoader();
      }
      return jdField_a_of_type_ComTencentBizQqcirclePicloadQCircleFeedPicLoader;
    }
    finally {}
  }
  
  private Object a(String paramString)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      paramString = this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      return paramString;
    }
  }
  
  public static String a(String paramString)
  {
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      }
      j = paramString.indexOf("://");
      if (j == -1) {
        break label145;
      }
    }
    label145:
    for (Object localObject2 = paramString.substring(j + 3);; localObject2 = paramString)
    {
      j = ((String)localObject2).indexOf("/");
      Object localObject1 = localObject2;
      if (j != -1) {
        localObject1 = ((String)localObject2).substring(j);
      }
      j = ((String)localObject1).lastIndexOf("#");
      localObject2 = localObject1;
      if (j != -1) {
        localObject2 = ((String)localObject1).substring(0, j);
      }
      j = ((String)localObject2).indexOf("tm=");
      localObject1 = localObject2;
      if (j != -1) {
        localObject1 = ((String)localObject2).substring(0, j);
      }
      j = ((String)localObject1).indexOf("ek=1");
      localObject2 = localObject1;
      if (j != -1) {
        localObject2 = ((String)localObject1).substring(0, j);
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject2);
      return localObject2;
      return "";
    }
  }
  
  private ThreadPoolExecutor a(int paramInt1, int paramInt2)
  {
    return new ThreadPoolExecutor(paramInt1, paramInt2, 120L, TimeUnit.SECONDS, new PriorityBlockingQueue(200, new vre(this)), Executors.defaultThreadFactory(), new vrf(this));
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return;
    }
  }
  
  private void a(vrd paramvrd, int paramInt)
  {
    if (paramvrd != null)
    {
      double d1 = -1.0D;
      if (paramvrd.a != null) {
        d1 = (float)(System.currentTimeMillis() - paramvrd.a.longValue()) / 1000.0F;
      }
      vts.a("image_load_ret", String.valueOf(d1), String.valueOf(paramInt), paramvrd.a(), paramvrd.jdField_d_of_type_Int);
    }
  }
  
  private void a(vrd paramvrd, Bitmap paramBitmap)
  {
    if ((paramvrd != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap = a(paramvrd, paramBitmap);
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label207;
      }
      if (paramvrd.c())
      {
        if (paramvrd.a() != null)
        {
          paramvrd.a().setImageDrawable(null);
          paramvrd.a().setImageDrawable(paramBitmap);
        }
        a(paramvrd, 0);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + " the total time " + (System.currentTimeMillis() - paramvrd.a.longValue()) + " pic is valid");
      }
    }
    else
    {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + " the total time " + (System.currentTimeMillis() - paramvrd.a.longValue()) + " pic is unValid");
    return;
    label207:
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicLoader.5(this, paramvrd, paramBitmap));
  }
  
  private void a(vrd paramvrd, Drawable paramDrawable)
  {
    if ((paramvrd != null) && (paramDrawable != null))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label187;
      }
      if (paramvrd.c())
      {
        if (paramvrd.a() != null)
        {
          paramvrd.a().setImageDrawable(null);
          paramvrd.a().setImageDrawable(paramDrawable);
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + " showDrawable time " + (System.currentTimeMillis() - paramvrd.a.longValue()) + "pic is valid");
      }
    }
    else
    {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + " showDrawable time " + (System.currentTimeMillis() - paramvrd.a.longValue()) + "pic is unValid");
    return;
    label187:
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicLoader.6(this, paramvrd, paramDrawable));
  }
  
  private void a(@NotNull vrd paramvrd, vrh paramvrh)
  {
    String str = a(paramvrd);
    if ((paramvrd.b()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))) {}
    do
    {
      return;
      localPicDownLoadTask = (QCircleFeedPicLoader.PicDownLoadTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    } while ((localPicDownLoadTask != null) && (localPicDownLoadTask.a.a() == paramvrd.a()));
    paramvrd.b = Long.valueOf(System.currentTimeMillis());
    QCircleFeedPicLoader.PicDownLoadTask localPicDownLoadTask = new QCircleFeedPicLoader.PicDownLoadTask(this, paramvrd);
    localPicDownLoadTask.a(paramvrh);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localPicDownLoadTask);
    if (paramvrd.b())
    {
      this.jdField_c_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(localPicDownLoadTask);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(localPicDownLoadTask);
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      QCircleFeedPicLoader.PicDeCodeTask localPicDeCodeTask = (QCircleFeedPicLoader.PicDeCodeTask)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localPicDeCodeTask != null) && (localPicDeCodeTask.a.b()))
      {
        this.jdField_d_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().remove(localPicDeCodeTask);
        this.jdField_b_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().remove(localPicDeCodeTask);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        localPicDeCodeTask.a();
      }
    }
  }
  
  private void b(vrd paramvrd, int paramInt)
  {
    if (paramvrd != null)
    {
      double d1 = -1.0D;
      if (paramvrd.b != null) {
        d1 = (float)(System.currentTimeMillis() - paramvrd.b.longValue()) / 1000.0F;
      }
      vts.a("image_download_ret", String.valueOf(d1), String.valueOf(paramInt), paramvrd.a(), paramvrd.jdField_c_of_type_Int);
    }
  }
  
  private void b(@NotNull vrd paramvrd, vrh paramvrh)
  {
    String str = a(paramvrd);
    if ((paramvrd.b()) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))) {}
    do
    {
      return;
      localPicDeCodeTask = (QCircleFeedPicLoader.PicDeCodeTask)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    } while ((localPicDeCodeTask != null) && (localPicDeCodeTask.a.a() == paramvrd.a()));
    paramvrd.jdField_c_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
    QCircleFeedPicLoader.PicDeCodeTask localPicDeCodeTask = new QCircleFeedPicLoader.PicDeCodeTask(this, paramvrd);
    localPicDeCodeTask.a(paramvrh);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localPicDeCodeTask);
    if (paramvrd.b())
    {
      this.jdField_d_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(localPicDeCodeTask);
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(localPicDeCodeTask);
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    String str = bhjc.a(BaseApplicationImpl.getApplication(), "qcircle_pic_cache_time");
    if (!TextUtils.isEmpty(str))
    {
      if (l - Long.valueOf(str).longValue() >= i)
      {
        bhmi.a(jdField_b_of_type_JavaLangString);
        bhjc.a(BaseApplicationImpl.getApplication(), "qcircle_pic_cache_time", String.valueOf(l));
      }
      return;
    }
    bhjc.a(BaseApplicationImpl.getApplication(), "qcircle_pic_cache_time", String.valueOf(l));
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (TextUtils.isEmpty(paramString)))
    {
      QCircleFeedPicLoader.PicDownLoadTask localPicDownLoadTask = (QCircleFeedPicLoader.PicDownLoadTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localPicDownLoadTask != null) && (localPicDownLoadTask.a.b()))
      {
        this.jdField_c_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().remove(localPicDownLoadTask);
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().remove(localPicDownLoadTask);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        localPicDownLoadTask.a();
      }
    }
  }
  
  private void c(vrd paramvrd, int paramInt)
  {
    if (paramvrd != null)
    {
      double d1 = -1.0D;
      if (paramvrd.jdField_c_of_type_JavaLangLong != null) {
        d1 = (float)(System.currentTimeMillis() - paramvrd.jdField_c_of_type_JavaLangLong.longValue()) / 1000.0F;
      }
      vts.a("image_decode_ret", String.valueOf(d1), String.valueOf(paramInt), paramvrd.a(), paramvrd.jdField_c_of_type_Int);
    }
  }
  
  public String a(vrd paramvrd)
  {
    if (!TextUtils.isEmpty(paramvrd.a()))
    {
      Object localObject2 = bjtz.b(a(paramvrd.a()));
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = bjtz.a(paramvrd.a());
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramvrd.a();
      }
      localObject1 = new StringBuilder((String)localObject2);
      ((StringBuilder)localObject1).append("#").append(paramvrd.c()).append("_").append(paramvrd.b());
      paramvrd.b(((StringBuilder)localObject1).toString());
      return ((StringBuilder)localObject1).toString();
    }
    return "";
  }
  
  public String a(@NotNull vrd paramvrd, vrh paramvrh)
  {
    String str = a(paramvrd);
    Object localObject = a(str);
    paramvrd.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
    paramvrd.a = Long.valueOf(System.currentTimeMillis());
    QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + " url = " + paramvrd.a());
    if ((localObject instanceof Bitmap))
    {
      long l = System.currentTimeMillis();
      paramvrd.jdField_d_of_type_Int = 0;
      a(paramvrd, (Bitmap)localObject);
      if (paramvrh != null) {
        paramvrh.a(f, paramvrd);
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + " return in cache: " + paramvrd.b() + " costTime:" + (System.currentTimeMillis() - l));
      return str;
    }
    this.jdField_b_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(new QCircleFeedPicLoader.4(this, paramvrd, paramvrh));
    return str;
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleFeedPicLoader.7(this));
  }
  
  public void a(@NotNull String paramString)
  {
    c(paramString);
    b(paramString);
  }
  
  public String b(vrd paramvrd)
  {
    if (bhmi.c(paramvrd.a()))
    {
      localObject1 = paramvrd.a();
      paramvrd.c((String)localObject1);
      return localObject1;
    }
    Object localObject2 = bjtz.b(a(paramvrd.a()));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = bjtz.a(paramvrd.a());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramvrd.a();
    }
    localObject1 = jdField_b_of_type_JavaLangString + (String)localObject2 + ".suf";
    paramvrd.c((String)localObject1);
    return localObject1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().clear();
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().clear();
    this.jdField_d_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().clear();
    this.jdField_c_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    vri.a().a();
    QLog.d(jdField_a_of_type_JavaLangString, 1, "feed pic release");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader
 * JD-Core Version:    0.7.0.1
 */