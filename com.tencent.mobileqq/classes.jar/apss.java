import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class apss
{
  private byte jdField_a_of_type_Byte = 3;
  protected float a;
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new apst(this);
  protected Context a;
  public Bitmap a;
  protected Handler a;
  protected LruCache<String, Bitmap> a;
  protected ArrayList<String> a;
  protected HashSet<String> a;
  final List<apsw> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  protected Handler b;
  protected LruCache<String, String> b;
  
  public apss(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(120);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new apsu(this, Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new apsv(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = paramInt;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = bgmo.a();
      return;
    }
    catch (OutOfMemoryError paramContext) {}
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    float f2 = this.jdField_a_of_type_Float;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < 50 * f2) {
        f1 = i / 50;
      }
    }
    i = (int)(50 * f1);
    int j = (int)(f1 * 50);
    return bgmo.a(paramBitmap, i, i, j);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    try
    {
      localObject = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("NonMainAppHeadLoader", 2, "getFaceBitmap, hit cache:" + paramString);
          return localObject;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppHeadLoader", 2, "getFaceBitmap, not in cache:" + paramString);
        }
        if (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString)))
        {
          localObject = new ArrayList(1);
          Message localMessage = Message.obtain();
          ((ArrayList)localObject).add(paramString);
          localMessage.obj = localObject;
          localMessage.what = 1001;
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        else if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 50L);
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.e("NonMainAppHeadLoader", 2, "getFaceBitmap, exception:" + paramString.toString());
        return paramBitmap;
        return localObject;
      }
    }
    return paramBitmap;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("NonMainAppHeadLoader", 1, "init register receiver fail!");
    }
  }
  
  public void a(byte paramByte)
  {
    this.jdField_a_of_type_Byte = paramByte;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(apsw paramapsw)
  {
    if (paramapsw == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramapsw)) {
        this.jdField_a_of_type_JavaUtilList.add(paramapsw);
      }
      return;
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppHeadLoader", 2, "sendQQHeadRequest, reqSize:" + this.jdField_a_of_type_JavaUtilHashSet.size() + " cacheSize:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size() + " " + this.jdField_b_of_type_AndroidSupportV4UtilLruCache.size());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str)) {
        localArrayList.add(str);
      }
    }
    paramArrayList = new Intent("com.tencent.qqhead.getheadreq");
    paramArrayList.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    paramArrayList.putExtra("faceType", this.jdField_a_of_type_Int);
    paramArrayList.putStringArrayListExtra("uinList", localArrayList);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramArrayList, "com.tencent.qqhead.permission.getheadresp");
    this.jdField_a_of_type_JavaUtilHashSet.addAll(localArrayList);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 148
    //   8: iconst_2
    //   9: ldc_w 310
    //   12: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 92	apss:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   19: aload_0
    //   20: getfield 65	apss:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   23: invokevirtual 314	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   26: aload_0
    //   27: getfield 56	apss:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: astore_1
    //   31: aload_1
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield 56	apss:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   37: invokeinterface 317 1 0
    //   42: aload_1
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield 43	apss:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   48: invokevirtual 318	java/util/HashSet:clear	()V
    //   51: aload_0
    //   52: getfield 78	apss:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   55: aconst_null
    //   56: invokevirtual 322	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 88	apss:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   63: aconst_null
    //   64: invokevirtual 322	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   67: aload_0
    //   68: getfield 38	apss:jdField_b_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   71: invokevirtual 325	android/support/v4/util/LruCache:evictAll	()V
    //   74: aload_0
    //   75: getfield 36	apss:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   78: invokevirtual 325	android/support/v4/util/LruCache:evictAll	()V
    //   81: return
    //   82: astore_1
    //   83: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq -60 -> 26
    //   89: ldc 148
    //   91: iconst_2
    //   92: new 150	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 327
    //   102: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 328	java/lang/Throwable:toString	()Ljava/lang/String;
    //   109: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: goto -92 -> 26
    //   121: astore_2
    //   122: aload_1
    //   123: monitorexit
    //   124: aload_2
    //   125: athrow
    //   126: astore_1
    //   127: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq -49 -> 81
    //   133: ldc 148
    //   135: iconst_2
    //   136: new 150	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 327
    //   146: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   153: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	apss
    //   82	41	1	localThrowable	Throwable
    //   126	24	1	localException	Exception
    //   121	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	26	82	java/lang/Throwable
    //   33	44	121	finally
    //   122	124	121	finally
    //   26	33	126	java/lang/Exception
    //   44	81	126	java/lang/Exception
    //   124	126	126	java/lang/Exception
  }
  
  public void b(apsw paramapsw)
  {
    if (paramapsw == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramapsw);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apss
 * JD-Core Version:    0.7.0.1
 */