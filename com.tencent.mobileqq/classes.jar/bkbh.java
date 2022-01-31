import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.component.media.image.IDecoder;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.SafeBitmapFactory;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import cooperation.qzone.zipanimate.ZipDrawableLoader.3;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class bkbh
{
  public static final byte[] a;
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bkbm jdField_a_of_type_Bkbm;
  private bkbn jdField_a_of_type_Bkbn;
  private bkbo jdField_a_of_type_Bkbo;
  private QzoneZipCacheHelperCallBack jdField_a_of_type_CooperationQzoneWebviewpluginQzoneZipCacheHelperCallBack = new bkbi(this);
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private Set<WeakReference<Bitmap>> jdField_a_of_type_JavaUtilSet;
  private CopyOnWriteArrayList<bkbk> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = -1;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int d = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[24576];
  }
  
  public bkbh(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    }
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  @TargetApi(12)
  private BitmapDrawable a(String paramString)
  {
    int i = 1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((QZLog.isColorLevel()) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      QZLog.i("zip_drawable", 2, "decodeBitmap mZipUrl = " + this.jdField_a_of_type_JavaLangString);
    }
    label293:
    label295:
    for (;;)
    {
      try
      {
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QzoneMainRuntime))
        {
          localObject = ImageManager.getInstance().getDecoder();
          if (localObject == null) {
            break label293;
          }
          paramString = new File(paramString);
          if ((!paramString.exists()) || (paramString.isDirectory())) {
            break label293;
          }
          Bitmap localBitmap = a();
          paramString = ((IDecoder)localObject).decodeBitmap(paramString, this.jdField_c_of_type_Int, this.d, localBitmap);
          break label295;
          if (paramString == null) {
            break;
          }
          paramString.setDensity(160);
          return new BitmapDrawable(paramString);
        }
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        ((BitmapFactory.Options)localObject).inTempStorage = jdField_a_of_type_ArrayOfByte;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if ((this.d < 0) && (this.jdField_c_of_type_Int < 0))
        {
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inSampleSize = i;
          ((BitmapFactory.Options)localObject).inTempStorage = jdField_a_of_type_ArrayOfByte;
          if (Build.VERSION.SDK_INT >= 11) {
            a((BitmapFactory.Options)localObject);
          }
          paramString = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        }
        else
        {
          i = a((BitmapFactory.Options)localObject, this.jdField_c_of_type_Int, this.d);
          continue;
          paramString = null;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QZLog.e("ziploader", "OutOfMemoryError  ");
        return null;
      }
      catch (Exception paramString)
      {
        QZLog.e("ziploader", "decode bitmap exception " + paramString);
        return null;
      }
    }
  }
  
  @TargetApi(11)
  private void a(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = a();
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  private void a(BitmapDrawable paramBitmapDrawable)
  {
    if (paramBitmapDrawable != null)
    {
      if ((Build.VERSION.SDK_INT < 11) || (this.jdField_a_of_type_JavaUtilSet.size() >= this.jdField_a_of_type_Int)) {
        break label50;
      }
      this.jdField_a_of_type_JavaUtilSet.add(new WeakReference(paramBitmapDrawable.getBitmap()));
    }
    label50:
    do
    {
      return;
      paramBitmapDrawable = paramBitmapDrawable.getBitmap();
      if ((paramBitmapDrawable != null) && (!paramBitmapDrawable.isRecycled())) {
        paramBitmapDrawable.recycle();
      }
    } while (!QZLog.isColorLevel());
    QZLog.d("ziploader", 1, " out of max preload num:");
  }
  
  private void a(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        i = 0;
        if (i < paramArrayOfString.length)
        {
          bkbk localbkbk = new bkbk();
          localbkbk.jdField_a_of_type_JavaLangString = (paramString + File.separator + paramArrayOfString[i]);
          if ((!localbkbk.jdField_a_of_type_JavaLangString.endsWith(".jpg")) && (!localbkbk.jdField_a_of_type_JavaLangString.endsWith(".png"))) {
            break label158;
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localbkbk);
          break label158;
        }
        bool = true;
        if (this.jdField_c_of_type_Boolean) {
          a(0, this.jdField_a_of_type_Bkbn);
        }
        if (this.jdField_a_of_type_Bkbo != null) {
          this.jdField_a_of_type_Bkbo.onZipLoaded(bool);
        }
        return;
      }
      finally {}
      boolean bool = false;
      continue;
      label158:
      i += 1;
    }
  }
  
  private boolean a(int paramInt)
  {
    try
    {
      bkbk localbkbk = (bkbk)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
      if (localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      }
      d(this.jdField_b_of_type_Int);
      a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, this.jdField_b_of_type_Int + 1);
      return false;
    }
    finally {}
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      bkbk localbkbk = (bkbk)localIterator.next();
      if (localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
        localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
      }
    }
  }
  
  private void b(int paramInt, bkbn parambkbn)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {}
    do
    {
      do
      {
        return;
        if (((bkbk)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null)
        {
          QzoneHandlerThreadFactory.getHandlerThread("YellowVip_HandlerThread").post(new ZipDrawableLoader.3(this, paramInt, parambkbn));
          return;
        }
        if (parambkbn != null) {
          parambkbn.a(paramInt, ((bkbk)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        }
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Bkbm == null);
    this.jdField_a_of_type_Bkbm.a(((bkbk)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(QzoneZipCacheHelper.getFolderFileNameList(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString), QzoneZipCacheHelper.getBasePath(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
    }
    while (this.jdField_a_of_type_Bkbo == null) {
      return;
    }
    this.jdField_a_of_type_Bkbo.onZipLoaded(paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
  }
  
  private void d(int paramInt)
  {
    int k = paramInt + this.jdField_a_of_type_Int;
    int m = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
    if ((paramInt < 0) || (paramInt >= k) || (paramInt >= m)) {}
    for (;;)
    {
      return;
      int i;
      bkbk localbkbk;
      if (k >= m)
      {
        i = k % m;
        while (i < paramInt)
        {
          localbkbk = (bkbk)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if (localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
          {
            if (this.jdField_b_of_type_Boolean) {
              a(localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
            }
            localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
          }
          i += 1;
        }
      }
      else
      {
        i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= paramInt) {
            break;
          }
          localbkbk = (bkbk)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if (localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
          {
            if (this.jdField_b_of_type_Boolean) {
              a(localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
            }
            localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
          }
          i += 1;
        }
        while (j < m)
        {
          localbkbk = (bkbk)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(j);
          if (localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
          {
            if (this.jdField_b_of_type_Boolean) {
              a(localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
            }
            localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
          }
          j += 1;
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
  }
  
  protected Bitmap a()
  {
    Bitmap localBitmap3 = null;
    Bitmap localBitmap1 = localBitmap3;
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      localBitmap1 = localBitmap3;
      if (!this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
        synchronized (this.jdField_a_of_type_JavaUtilSet)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
          localBitmap1 = null;
          while (localIterator.hasNext())
          {
            localBitmap3 = (Bitmap)((WeakReference)localIterator.next()).get();
            if ((localBitmap3 != null) && (localBitmap3.isMutable()))
            {
              localIterator.remove();
              localBitmap1 = localBitmap3;
            }
            else
            {
              localIterator.remove();
            }
          }
        }
      }
    }
    return localBitmap2;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return String.valueOf(paramString.hashCode());
  }
  
  public CopyOnWriteArrayList<bkbk> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    c(false);
    b();
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	bkbh:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 352	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   9: istore_2
    //   10: iload_1
    //   11: iload_2
    //   12: if_icmplt +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: iload_1
    //   20: putfield 48	bkbh:jdField_b_of_type_Int	I
    //   23: aload_0
    //   24: iload_1
    //   25: invokespecial 430	bkbh:a	(I)Z
    //   28: pop
    //   29: goto -14 -> 15
    //   32: astore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_3
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	bkbh
    //   0	37	1	paramInt	int
    //   9	4	2	i	int
    //   32	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	32	finally
    //   18	29	32	finally
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
  }
  
  /* Error */
  public void a(int paramInt, bkbn parambkbn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	bkbh:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 352	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   9: istore_3
    //   10: iload_3
    //   11: iload_1
    //   12: if_icmpgt +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: iload_1
    //   20: aload_2
    //   21: invokespecial 433	bkbh:b	(ILbkbn;)V
    //   24: aload_0
    //   25: iload_1
    //   26: invokevirtual 435	bkbh:a	(I)V
    //   29: goto -14 -> 15
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	bkbh
    //   0	37	1	paramInt	int
    //   0	37	2	parambkbn	bkbn
    //   9	4	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	32	finally
    //   18	29	32	finally
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public void a(bkbn parambkbn)
  {
    this.jdField_a_of_type_Bkbn = parambkbn;
  }
  
  public void a(bkbo parambkbo)
  {
    this.jdField_a_of_type_Bkbo = parambkbo;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      a(paramString, "zip_drawable", a(paramString), paramInt, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	bkbh:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 289	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   9: aload_1
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 37	bkbh:jdField_a_of_type_Int	I
    //   20: ifgt +8 -> 28
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 37	bkbh:jdField_a_of_type_Int	I
    //   28: aload_0
    //   29: aload_1
    //   30: putfield 144	bkbh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: aload_0
    //   34: aload_3
    //   35: putfield 383	bkbh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   38: aload_0
    //   39: aload_2
    //   40: putfield 338	bkbh:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   43: aload_0
    //   44: iload 5
    //   46: putfield 309	bkbh:jdField_c_of_type_Boolean	Z
    //   49: ldc_w 451
    //   52: invokestatic 360	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;)Lcooperation/qzone/thread/QzoneBaseThread;
    //   55: new 453	cooperation/qzone/zipanimate/ZipDrawableLoader$1
    //   58: dup
    //   59: aload_0
    //   60: iload 4
    //   62: invokespecial 456	cooperation/qzone/zipanimate/ZipDrawableLoader$1:<init>	(Lbkbh;I)V
    //   65: invokevirtual 371	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   68: goto -55 -> 13
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	bkbh
    //   0	76	1	paramString1	String
    //   0	76	2	paramString2	String
    //   0	76	3	paramString3	String
    //   0	76	4	paramInt	int
    //   0	76	5	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	71	finally
    //   16	28	71	finally
    //   28	68	71	finally
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	bkbh:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 289	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   9: aload_1
    //   10: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 37	bkbh:jdField_a_of_type_Int	I
    //   25: ifgt +8 -> 33
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 37	bkbh:jdField_a_of_type_Int	I
    //   33: aload_0
    //   34: iload_2
    //   35: putfield 309	bkbh:jdField_c_of_type_Boolean	Z
    //   38: aload_0
    //   39: aload_1
    //   40: invokestatic 461	cooperation/qzone/webviewplugin/QzoneZipCacheHelper:getFileList	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: aload_1
    //   44: invokespecial 395	bkbh:a	([Ljava/lang/String;Ljava/lang/String;)V
    //   47: goto -29 -> 18
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	bkbh
    //   0	55	1	paramString	String
    //   0	55	2	paramBoolean	boolean
    //   13	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	50	finally
    //   21	33	50	finally
    //   33	47	50	finally
  }
  
  /* Error */
  void a(java.util.List<bkbk> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	bkbh:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 462	java/util/concurrent/CopyOnWriteArrayList:isEmpty	()Z
    //   9: istore 4
    //   11: iload 4
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: iconst_0
    //   20: istore_3
    //   21: iload_3
    //   22: aload_0
    //   23: getfield 37	bkbh:jdField_a_of_type_Int	I
    //   26: if_icmpge -10 -> 16
    //   29: aload_0
    //   30: iload_2
    //   31: iload_3
    //   32: iadd
    //   33: aload_1
    //   34: invokeinterface 465 1 0
    //   39: irem
    //   40: aload_0
    //   41: getfield 311	bkbh:jdField_a_of_type_Bkbn	Lbkbn;
    //   44: invokespecial 433	bkbh:b	(ILbkbn;)V
    //   47: iload_3
    //   48: iconst_1
    //   49: iadd
    //   50: istore_3
    //   51: goto -30 -> 21
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	bkbh
    //   0	59	1	paramList	java.util.List<bkbk>
    //   0	59	2	paramInt	int
    //   20	31	3	i	int
    //   9	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	54	finally
    //   21	47	54	finally
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      int j = this.jdField_b_of_type_Int + 1;
      int k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
      int i = j;
      if (j >= k) {
        i = 0;
      }
      a(i);
      if (i == k - 1) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())) {}
    bkbk localbkbk;
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt;
      localbkbk = (bkbk)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
    } while (localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  }
  
  public void c(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbh
 * JD-Core Version:    0.7.0.1
 */