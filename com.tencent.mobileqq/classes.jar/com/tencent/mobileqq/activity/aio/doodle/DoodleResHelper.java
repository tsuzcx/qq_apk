package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.doodle.IScribbleResMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.ResCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DoodleResHelper
{
  static volatile DoodleResHelper a;
  private final String b = "DoodleResHelper";
  private Map<Integer, DoodleResHelper.BitmapInfo> c = null;
  private int d = 0;
  
  public static DoodleResHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DoodleResHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Aio_Doodle/Type_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public Drawable a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = d(paramInt1, paramInt2);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    if (paramInt2 > 0)
    {
      localObject1 = new File((String)localObject1);
      Object localObject2 = GlobalImageCache.a;
      Object localObject3 = ((File)localObject1).toURI().toString();
      if (paramBoolean) {
        paramInt2 = 2;
      } else {
        paramInt2 = 3;
      }
      localObject2 = ((MQLruCache)localObject2).get(a((String)localObject3, paramInt2));
      if (localObject2 != null) {
        return (Drawable)localObject2;
      }
      localObject2 = BaseApplication.getContext();
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Context)localObject2).getResources().getDrawable(2130837969);
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Context)localObject2).getResources().getDrawable(2130837969);
      ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = null;
      ((URLDrawable.URLDrawableOptions)localObject3).mUseMemoryCache = false;
      if (paramInt1 == 1)
      {
        ((URLDrawable.URLDrawableOptions)localObject3).mUseUnFinishCache = false;
      }
      else
      {
        ((URLDrawable.URLDrawableOptions)localObject3).mUseUnFinishCache = true;
        if (paramBoolean) {
          ((URLDrawable.URLDrawableOptions)localObject3).isFlashPic = true;
        } else {
          ((URLDrawable.URLDrawableOptions)localObject3).isFlashPic = false;
        }
      }
      if ((paramInt1 != 0) && (paramInt1 != 3))
      {
        if ((paramInt1 == 2) && (paramBoolean)) {
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        } else if ((paramInt1 == 1) && (paramBoolean)) {
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        }
      }
      else {
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
      }
      localObject1 = URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
      if ((paramInt1 == 2) || (paramInt1 == 1)) {
        ((URLDrawable)localObject1).setIgnorePause(true);
      }
      return localObject1;
    }
    return null;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt == 0)
      {
        localArrayList2 = ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).GetPaintVisibleIdList();
        if ((localArrayList2 != null) && (localArrayList2.size() > 0))
        {
          localArrayList1.addAll(localArrayList2);
          return localArrayList1;
        }
      }
    }
    else
    {
      localArrayList2 = ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).GetGifVisibleIdList();
      if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
        localArrayList1.addAll(localArrayList2);
      }
    }
    return localArrayList1;
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, ResCallback paramResCallback)
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new DoodleResHelper.1(this, paramInt1, paramInt2, paramView, paramResCallback));
      return;
    }
    if (paramInt1 == 0)
    {
      ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).StartDownloadRes(3, paramInt2, paramView, paramResCallback);
      return;
    }
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).StartDownloadRes(4, paramInt2, paramView, paramResCallback);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    try
    {
      if (this.c == null) {
        return;
      }
      Object localObject = this.c.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DoodleResHelper.BitmapInfo localBitmapInfo = (DoodleResHelper.BitmapInfo)((Iterator)localObject).next();
        if ((localBitmapInfo.a != null) && (localBitmapInfo.a.get() == paramBitmap))
        {
          localBitmapInfo.b = true;
          paramBitmap = new StringBuilder();
          paramBitmap.append("releaseBitmap succ:");
          paramBitmap.append(this.c.size());
          QLog.d("DoodleResHelper", 2, paramBitmap.toString());
          return;
        }
      }
      localObject = new DoodleResHelper.BitmapInfo(this);
      ((DoodleResHelper.BitmapInfo)localObject).d = paramBitmap.getHeight();
      ((DoodleResHelper.BitmapInfo)localObject).c = paramBitmap.getWidth();
      ((DoodleResHelper.BitmapInfo)localObject).a = new WeakReference(paramBitmap);
      ((DoodleResHelper.BitmapInfo)localObject).b = true;
      paramBitmap = this.c;
      int i = this.d;
      this.d = (i + 1);
      paramBitmap.put(Integer.valueOf(i), localObject);
      paramBitmap = new StringBuilder();
      paramBitmap.append("releaseBitmap add new one:");
      paramBitmap.append(this.c.size());
      QLog.d("DoodleResHelper", 2, paramBitmap.toString());
      return;
    }
    finally {}
    for (;;)
    {
      throw paramBitmap;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return !TextUtils.isEmpty(h(paramInt1, paramInt2));
  }
  
  public void b()
  {
    try
    {
      this.c = null;
      return;
    }
    finally {}
  }
  
  public void b(int paramInt1, int paramInt2, View paramView, ResCallback paramResCallback)
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new DoodleResHelper.2(this, paramInt1, paramInt2, paramView, paramResCallback));
      return;
    }
    if (paramInt1 == 0)
    {
      ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).StartDownloadRes(1, paramInt2, paramView, paramResCallback);
      return;
    }
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).StartDownloadRes(2, paramInt2, paramView, paramResCallback);
    }
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return !TextUtils.isEmpty(d(paramInt1, paramInt2));
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    return (b(paramInt1, paramInt2)) && (a(paramInt1, paramInt2));
  }
  
  public String d(int paramInt1, int paramInt2)
  {
    String str;
    if (paramInt1 == 0)
    {
      str = ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).GetResPath(1, paramInt2);
    }
    else if (paramInt1 == 1)
    {
      str = ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).GetResPath(2, paramInt2);
    }
    else
    {
      StringBuilder localStringBuilder;
      if (paramInt1 == 2)
      {
        str = ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).GetResPath(2, paramInt2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str.substring(0, str.lastIndexOf('.')));
        localStringBuilder.append("ex.gif");
        str = localStringBuilder.toString();
      }
      else if (paramInt1 == 3)
      {
        str = ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).GetResPath(2, paramInt2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str.substring(0, str.lastIndexOf('.')));
        localStringBuilder.append("pre.png");
        str = localStringBuilder.toString();
      }
      else
      {
        str = null;
      }
    }
    if (!FileUtils.fileExists(str)) {
      return null;
    }
    return str;
  }
  
  /* Error */
  public Bitmap e(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: invokevirtual 54	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:d	(II)Ljava/lang/String;
    //   6: astore 12
    //   8: aload 12
    //   10: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: istore_3
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 7
    //   20: aconst_null
    //   21: astore 9
    //   23: aconst_null
    //   24: astore 11
    //   26: aconst_null
    //   27: astore 10
    //   29: aconst_null
    //   30: astore 6
    //   32: iload_3
    //   33: ifeq +5 -> 38
    //   36: aconst_null
    //   37: areturn
    //   38: iload_2
    //   39: ifle +323 -> 362
    //   42: getstatic 70	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   45: aload_0
    //   46: aload 12
    //   48: iconst_0
    //   49: invokespecial 79	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   52: invokevirtual 85	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +9 -> 68
    //   62: aload 5
    //   64: checkcast 248	android/graphics/Bitmap
    //   67: areturn
    //   68: new 315	java/io/FileInputStream
    //   71: dup
    //   72: aload 12
    //   74: invokespecial 316	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   77: astore 5
    //   79: aload 4
    //   81: astore 7
    //   83: aload 5
    //   85: astore 8
    //   87: new 318	java/io/BufferedInputStream
    //   90: dup
    //   91: aload 5
    //   93: invokespecial 321	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   96: astore 4
    //   98: aload 11
    //   100: astore 6
    //   102: aload 10
    //   104: astore 7
    //   106: aload 4
    //   108: invokestatic 327	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   111: astore 8
    //   113: aload 8
    //   115: ifnull +32 -> 147
    //   118: iconst_3
    //   119: iload_1
    //   120: if_icmpeq +27 -> 147
    //   123: aload 8
    //   125: astore 6
    //   127: aload 8
    //   129: astore 7
    //   131: getstatic 70	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   134: aload_0
    //   135: aload 12
    //   137: iconst_0
    //   138: invokespecial 79	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   141: aload 8
    //   143: invokevirtual 328	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: aload 5
    //   149: invokevirtual 333	java/io/InputStream:close	()V
    //   152: aload 4
    //   154: invokevirtual 333	java/io/InputStream:close	()V
    //   157: aload 8
    //   159: areturn
    //   160: astore 6
    //   162: aload 4
    //   164: astore 7
    //   166: aload 6
    //   168: astore 4
    //   170: goto +127 -> 297
    //   173: aload 4
    //   175: astore 6
    //   177: aload 7
    //   179: astore 4
    //   181: goto +49 -> 230
    //   184: aload 6
    //   186: astore 7
    //   188: aload 4
    //   190: astore 6
    //   192: aload 7
    //   194: astore 4
    //   196: goto +138 -> 334
    //   199: aconst_null
    //   200: astore 4
    //   202: goto +28 -> 230
    //   205: aconst_null
    //   206: astore 4
    //   208: aload 9
    //   210: astore 6
    //   212: goto +122 -> 334
    //   215: astore 4
    //   217: aconst_null
    //   218: astore 5
    //   220: goto +77 -> 297
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 4
    //   228: astore 5
    //   230: aload 6
    //   232: astore 7
    //   234: aload 5
    //   236: astore 8
    //   238: invokestatic 336	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +20 -> 261
    //   244: aload 6
    //   246: astore 7
    //   248: aload 5
    //   250: astore 8
    //   252: ldc 21
    //   254: iconst_2
    //   255: ldc_w 338
    //   258: invokestatic 340	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload 5
    //   263: ifnull +11 -> 274
    //   266: aload 5
    //   268: invokevirtual 333	java/io/InputStream:close	()V
    //   271: goto +3 -> 274
    //   274: aload 4
    //   276: astore 5
    //   278: aload 6
    //   280: ifnull +79 -> 359
    //   283: aload 6
    //   285: invokevirtual 333	java/io/InputStream:close	()V
    //   288: aload 4
    //   290: areturn
    //   291: astore 4
    //   293: aload 8
    //   295: astore 5
    //   297: aload 5
    //   299: ifnull +11 -> 310
    //   302: aload 5
    //   304: invokevirtual 333	java/io/InputStream:close	()V
    //   307: goto +3 -> 310
    //   310: aload 7
    //   312: ifnull +8 -> 320
    //   315: aload 7
    //   317: invokevirtual 333	java/io/InputStream:close	()V
    //   320: aload 4
    //   322: athrow
    //   323: aconst_null
    //   324: astore 4
    //   326: aload 4
    //   328: astore 5
    //   330: aload 9
    //   332: astore 6
    //   334: aload 5
    //   336: ifnull +11 -> 347
    //   339: aload 5
    //   341: invokevirtual 333	java/io/InputStream:close	()V
    //   344: goto +3 -> 347
    //   347: aload 4
    //   349: astore 5
    //   351: aload 6
    //   353: ifnull +6 -> 359
    //   356: goto -73 -> 283
    //   359: aload 5
    //   361: areturn
    //   362: aconst_null
    //   363: areturn
    //   364: astore 4
    //   366: goto -43 -> 323
    //   369: astore 4
    //   371: goto -148 -> 223
    //   374: astore 4
    //   376: goto -171 -> 205
    //   379: astore 4
    //   381: goto -182 -> 199
    //   384: astore 7
    //   386: goto -202 -> 184
    //   389: astore 6
    //   391: goto -218 -> 173
    //   394: astore 5
    //   396: goto -244 -> 152
    //   399: astore 4
    //   401: goto -244 -> 157
    //   404: astore 5
    //   406: goto -132 -> 274
    //   409: astore 5
    //   411: aload 4
    //   413: areturn
    //   414: astore 5
    //   416: goto -106 -> 310
    //   419: astore 5
    //   421: goto -101 -> 320
    //   424: astore 5
    //   426: goto -79 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	DoodleResHelper
    //   0	429	1	paramInt1	int
    //   0	429	2	paramInt2	int
    //   13	20	3	bool	boolean
    //   15	192	4	localObject1	Object
    //   215	1	4	localObject2	Object
    //   224	65	4	localBitmap	Bitmap
    //   291	30	4	localObject3	Object
    //   324	24	4	localObject4	Object
    //   364	1	4	localException1	Exception
    //   369	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   374	1	4	localException2	Exception
    //   379	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   399	13	4	localIOException1	java.io.IOException
    //   55	305	5	localObject5	Object
    //   394	1	5	localIOException2	java.io.IOException
    //   404	1	5	localIOException3	java.io.IOException
    //   409	1	5	localIOException4	java.io.IOException
    //   414	1	5	localIOException5	java.io.IOException
    //   419	1	5	localIOException6	java.io.IOException
    //   424	1	5	localIOException7	java.io.IOException
    //   30	96	6	localObject6	Object
    //   160	7	6	localObject7	Object
    //   175	177	6	localObject8	Object
    //   389	1	6	localOutOfMemoryError3	OutOfMemoryError
    //   18	298	7	localObject9	Object
    //   384	1	7	localException3	Exception
    //   85	209	8	localObject10	Object
    //   21	310	9	localObject11	Object
    //   27	76	10	localObject12	Object
    //   24	75	11	localObject13	Object
    //   6	130	12	str	String
    // Exception table:
    //   from	to	target	type
    //   106	113	160	finally
    //   131	147	160	finally
    //   68	79	215	finally
    //   87	98	291	finally
    //   238	244	291	finally
    //   252	261	291	finally
    //   68	79	364	java/lang/Exception
    //   68	79	369	java/lang/OutOfMemoryError
    //   87	98	374	java/lang/Exception
    //   87	98	379	java/lang/OutOfMemoryError
    //   106	113	384	java/lang/Exception
    //   131	147	384	java/lang/Exception
    //   106	113	389	java/lang/OutOfMemoryError
    //   131	147	389	java/lang/OutOfMemoryError
    //   147	152	394	java/io/IOException
    //   152	157	399	java/io/IOException
    //   266	271	404	java/io/IOException
    //   283	288	409	java/io/IOException
    //   302	307	414	java/io/IOException
    //   315	320	419	java/io/IOException
    //   339	344	424	java/io/IOException
  }
  
  /* Error */
  public Bitmap f(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 7
    //   15: iload_2
    //   16: ifge +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: iload_1
    //   23: iload_2
    //   24: invokevirtual 276	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:h	(II)Ljava/lang/String;
    //   27: astore 10
    //   29: aload 10
    //   31: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +5 -> 39
    //   37: aconst_null
    //   38: areturn
    //   39: iload_2
    //   40: ifle +254 -> 294
    //   43: getstatic 70	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   46: aload_0
    //   47: aload 10
    //   49: iconst_0
    //   50: invokespecial 79	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   53: invokevirtual 85	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +8 -> 66
    //   61: aload_3
    //   62: checkcast 248	android/graphics/Bitmap
    //   65: areturn
    //   66: new 315	java/io/FileInputStream
    //   69: dup
    //   70: aload 10
    //   72: invokespecial 316	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   75: astore 4
    //   77: new 318	java/io/BufferedInputStream
    //   80: dup
    //   81: aload 4
    //   83: invokespecial 321	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_3
    //   87: aload 9
    //   89: astore 5
    //   91: aload 8
    //   93: astore 6
    //   95: aload_3
    //   96: invokestatic 327	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   99: astore 7
    //   101: aload 7
    //   103: astore 5
    //   105: aload 7
    //   107: astore 6
    //   109: getstatic 70	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   112: aload_0
    //   113: aload 10
    //   115: iconst_0
    //   116: invokespecial 79	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   119: aload 7
    //   121: invokevirtual 328	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: pop
    //   125: aload 4
    //   127: invokevirtual 333	java/io/InputStream:close	()V
    //   130: aload_3
    //   131: invokevirtual 333	java/io/InputStream:close	()V
    //   134: aload 7
    //   136: areturn
    //   137: astore 6
    //   139: aload_3
    //   140: astore 5
    //   142: aload 6
    //   144: astore_3
    //   145: goto +55 -> 200
    //   148: aload_3
    //   149: astore 5
    //   151: aload 6
    //   153: astore_3
    //   154: goto +76 -> 230
    //   157: aload 5
    //   159: astore 6
    //   161: aload_3
    //   162: astore 5
    //   164: aload 6
    //   166: astore_3
    //   167: goto +100 -> 267
    //   170: astore_3
    //   171: aload 7
    //   173: astore 5
    //   175: goto +25 -> 200
    //   178: aconst_null
    //   179: astore_3
    //   180: goto +50 -> 230
    //   183: aconst_null
    //   184: astore_3
    //   185: aload 6
    //   187: astore 5
    //   189: goto +78 -> 267
    //   192: astore_3
    //   193: aconst_null
    //   194: astore 4
    //   196: aload 7
    //   198: astore 5
    //   200: aload 4
    //   202: ifnull +11 -> 213
    //   205: aload 4
    //   207: invokevirtual 333	java/io/InputStream:close	()V
    //   210: goto +3 -> 213
    //   213: aload 5
    //   215: ifnull +8 -> 223
    //   218: aload 5
    //   220: invokevirtual 333	java/io/InputStream:close	()V
    //   223: aload_3
    //   224: athrow
    //   225: aconst_null
    //   226: astore_3
    //   227: aload_3
    //   228: astore 4
    //   230: aload 4
    //   232: ifnull +11 -> 243
    //   235: aload 4
    //   237: invokevirtual 333	java/io/InputStream:close	()V
    //   240: goto +3 -> 243
    //   243: aload_3
    //   244: astore 4
    //   246: aload 5
    //   248: ifnull +43 -> 291
    //   251: aload 5
    //   253: invokevirtual 333	java/io/InputStream:close	()V
    //   256: aload_3
    //   257: areturn
    //   258: aconst_null
    //   259: astore_3
    //   260: aload_3
    //   261: astore 4
    //   263: aload 6
    //   265: astore 5
    //   267: aload 4
    //   269: ifnull +11 -> 280
    //   272: aload 4
    //   274: invokevirtual 333	java/io/InputStream:close	()V
    //   277: goto +3 -> 280
    //   280: aload_3
    //   281: astore 4
    //   283: aload 5
    //   285: ifnull +6 -> 291
    //   288: goto -37 -> 251
    //   291: aload 4
    //   293: areturn
    //   294: aconst_null
    //   295: areturn
    //   296: astore_3
    //   297: goto -39 -> 258
    //   300: astore_3
    //   301: goto -76 -> 225
    //   304: astore_3
    //   305: goto -122 -> 183
    //   308: astore_3
    //   309: goto -131 -> 178
    //   312: astore 6
    //   314: goto -157 -> 157
    //   317: astore 5
    //   319: goto -171 -> 148
    //   322: astore 4
    //   324: goto -194 -> 130
    //   327: astore_3
    //   328: goto -194 -> 134
    //   331: astore 4
    //   333: goto -120 -> 213
    //   336: astore 4
    //   338: goto -115 -> 223
    //   341: astore 4
    //   343: goto -100 -> 243
    //   346: astore 4
    //   348: aload_3
    //   349: areturn
    //   350: astore 4
    //   352: goto -72 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	DoodleResHelper
    //   0	355	1	paramInt1	int
    //   0	355	2	paramInt2	int
    //   56	111	3	localObject1	Object
    //   170	1	3	localObject2	Object
    //   179	6	3	localObject3	Object
    //   192	32	3	localObject4	Object
    //   226	55	3	localBitmap1	Bitmap
    //   296	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   300	1	3	localException1	Exception
    //   304	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   308	1	3	localException2	Exception
    //   327	22	3	localIOException1	java.io.IOException
    //   75	217	4	localObject5	Object
    //   322	1	4	localIOException2	java.io.IOException
    //   331	1	4	localIOException3	java.io.IOException
    //   336	1	4	localIOException4	java.io.IOException
    //   341	1	4	localIOException5	java.io.IOException
    //   346	1	4	localIOException6	java.io.IOException
    //   350	1	4	localIOException7	java.io.IOException
    //   1	283	5	localObject6	Object
    //   317	1	5	localException3	Exception
    //   4	104	6	localObject7	Object
    //   137	15	6	localObject8	Object
    //   159	105	6	localObject9	Object
    //   312	1	6	localOutOfMemoryError3	OutOfMemoryError
    //   13	184	7	localBitmap2	Bitmap
    //   10	82	8	localObject10	Object
    //   7	81	9	localObject11	Object
    //   27	87	10	str	String
    // Exception table:
    //   from	to	target	type
    //   95	101	137	finally
    //   109	125	137	finally
    //   77	87	170	finally
    //   66	77	192	finally
    //   66	77	296	java/lang/OutOfMemoryError
    //   66	77	300	java/lang/Exception
    //   77	87	304	java/lang/OutOfMemoryError
    //   77	87	308	java/lang/Exception
    //   95	101	312	java/lang/OutOfMemoryError
    //   109	125	312	java/lang/OutOfMemoryError
    //   95	101	317	java/lang/Exception
    //   109	125	317	java/lang/Exception
    //   125	130	322	java/io/IOException
    //   130	134	327	java/io/IOException
    //   205	210	331	java/io/IOException
    //   218	223	336	java/io/IOException
    //   235	240	341	java/io/IOException
    //   251	256	346	java/io/IOException
    //   272	277	350	java/io/IOException
  }
  
  /* Error */
  public Drawable g(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: iload_1
    //   8: iload_2
    //   9: invokevirtual 276	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:h	(II)Ljava/lang/String;
    //   12: astore 6
    //   14: aload 6
    //   16: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: getstatic 70	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   27: aload_0
    //   28: aload 6
    //   30: iconst_1
    //   31: invokespecial 79	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   34: invokevirtual 85	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: astore_3
    //   38: aload_3
    //   39: ifnull +8 -> 47
    //   42: aload_3
    //   43: checkcast 87	android/graphics/drawable/Drawable
    //   46: areturn
    //   47: new 315	java/io/FileInputStream
    //   50: dup
    //   51: aload 6
    //   53: invokespecial 316	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_3
    //   57: new 318	java/io/BufferedInputStream
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 321	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore 4
    //   67: aload 4
    //   69: invokestatic 327	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   72: astore 5
    //   74: new 345	android/graphics/drawable/BitmapDrawable
    //   77: dup
    //   78: invokestatic 93	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   81: invokevirtual 349	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   84: invokevirtual 105	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   87: aload 5
    //   89: invokespecial 352	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   92: astore 5
    //   94: getstatic 70	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   97: aload_0
    //   98: aload 6
    //   100: iconst_1
    //   101: invokespecial 79	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   104: aload 5
    //   106: invokevirtual 328	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: aload_3
    //   111: invokevirtual 333	java/io/InputStream:close	()V
    //   114: aload 4
    //   116: astore 6
    //   118: aload 6
    //   120: invokevirtual 333	java/io/InputStream:close	()V
    //   123: aload 5
    //   125: areturn
    //   126: aload 4
    //   128: astore 6
    //   130: aload 5
    //   132: astore 4
    //   134: goto +100 -> 234
    //   137: aload 4
    //   139: astore 6
    //   141: aload 5
    //   143: astore 4
    //   145: goto +123 -> 268
    //   148: astore 5
    //   150: goto +52 -> 202
    //   153: aconst_null
    //   154: astore 5
    //   156: aload 4
    //   158: astore 6
    //   160: aload 5
    //   162: astore 4
    //   164: goto +70 -> 234
    //   167: aconst_null
    //   168: astore 5
    //   170: aload 4
    //   172: astore 6
    //   174: aload 5
    //   176: astore 4
    //   178: goto +90 -> 268
    //   181: astore 5
    //   183: aconst_null
    //   184: astore 4
    //   186: goto +16 -> 202
    //   189: goto +39 -> 228
    //   192: goto +70 -> 262
    //   195: astore 5
    //   197: aconst_null
    //   198: astore_3
    //   199: aload_3
    //   200: astore 4
    //   202: aload_3
    //   203: ifnull +10 -> 213
    //   206: aload_3
    //   207: invokevirtual 333	java/io/InputStream:close	()V
    //   210: goto +3 -> 213
    //   213: aload 4
    //   215: ifnull +8 -> 223
    //   218: aload 4
    //   220: invokevirtual 333	java/io/InputStream:close	()V
    //   223: aload 5
    //   225: athrow
    //   226: aconst_null
    //   227: astore_3
    //   228: aconst_null
    //   229: astore 6
    //   231: aconst_null
    //   232: astore 4
    //   234: aload_3
    //   235: ifnull +10 -> 245
    //   238: aload_3
    //   239: invokevirtual 333	java/io/InputStream:close	()V
    //   242: goto +3 -> 245
    //   245: aload 4
    //   247: astore_3
    //   248: aload 6
    //   250: ifnull +44 -> 294
    //   253: aload 4
    //   255: astore 5
    //   257: goto -139 -> 118
    //   260: aconst_null
    //   261: astore_3
    //   262: aconst_null
    //   263: astore 6
    //   265: aconst_null
    //   266: astore 4
    //   268: aload_3
    //   269: ifnull +10 -> 279
    //   272: aload_3
    //   273: invokevirtual 333	java/io/InputStream:close	()V
    //   276: goto +3 -> 279
    //   279: aload 4
    //   281: astore_3
    //   282: aload 6
    //   284: ifnull +10 -> 294
    //   287: aload 4
    //   289: astore 5
    //   291: goto -173 -> 118
    //   294: aload_3
    //   295: areturn
    //   296: astore_3
    //   297: goto -37 -> 260
    //   300: astore_3
    //   301: goto -75 -> 226
    //   304: astore 4
    //   306: goto -114 -> 192
    //   309: astore 4
    //   311: goto -122 -> 189
    //   314: astore 5
    //   316: goto -149 -> 167
    //   319: astore 5
    //   321: goto -168 -> 153
    //   324: astore 6
    //   326: goto -189 -> 137
    //   329: astore 6
    //   331: goto -205 -> 126
    //   334: astore_3
    //   335: aload 4
    //   337: astore 6
    //   339: goto -221 -> 118
    //   342: astore_3
    //   343: aload 5
    //   345: areturn
    //   346: astore_3
    //   347: goto -134 -> 213
    //   350: astore_3
    //   351: goto -128 -> 223
    //   354: astore_3
    //   355: goto -110 -> 245
    //   358: astore_3
    //   359: goto -80 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	DoodleResHelper
    //   0	362	1	paramInt1	int
    //   0	362	2	paramInt2	int
    //   37	258	3	localObject1	Object
    //   296	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   300	1	3	localException1	Exception
    //   334	1	3	localIOException1	java.io.IOException
    //   342	1	3	localIOException2	java.io.IOException
    //   346	1	3	localIOException3	java.io.IOException
    //   350	1	3	localIOException4	java.io.IOException
    //   354	1	3	localIOException5	java.io.IOException
    //   358	1	3	localIOException6	java.io.IOException
    //   65	223	4	localObject2	Object
    //   304	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   309	27	4	localException2	Exception
    //   72	70	5	localObject3	Object
    //   148	1	5	localObject4	Object
    //   154	21	5	localObject5	Object
    //   181	1	5	localObject6	Object
    //   195	29	5	localObject7	Object
    //   255	35	5	localObject8	Object
    //   314	1	5	localOutOfMemoryError3	OutOfMemoryError
    //   319	25	5	localException3	Exception
    //   12	271	6	localObject9	Object
    //   324	1	6	localOutOfMemoryError4	OutOfMemoryError
    //   329	1	6	localException4	Exception
    //   337	1	6	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   67	94	148	finally
    //   94	110	148	finally
    //   57	67	181	finally
    //   47	57	195	finally
    //   47	57	296	java/lang/OutOfMemoryError
    //   47	57	300	java/lang/Exception
    //   57	67	304	java/lang/OutOfMemoryError
    //   57	67	309	java/lang/Exception
    //   67	94	314	java/lang/OutOfMemoryError
    //   67	94	319	java/lang/Exception
    //   94	110	324	java/lang/OutOfMemoryError
    //   94	110	329	java/lang/Exception
    //   110	114	334	java/io/IOException
    //   118	123	342	java/io/IOException
    //   206	210	346	java/io/IOException
    //   218	223	350	java/io/IOException
    //   238	242	354	java/io/IOException
    //   272	276	358	java/io/IOException
  }
  
  public String h(int paramInt1, int paramInt2)
  {
    String str;
    if (paramInt1 == 0) {
      str = ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).GetResIconPath(1, paramInt2);
    } else if ((paramInt1 != 2) && (paramInt1 != 1)) {
      str = null;
    } else {
      str = ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).GetResIconPath(2, paramInt2);
    }
    if (!FileUtils.fileExists(str)) {
      return null;
    }
    return str;
  }
  
  public Bitmap i(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      if (paramInt2 <= 0) {
        return null;
      }
    }
    for (;;)
    {
      try
      {
        if (this.c == null) {
          this.c = new HashMap();
        }
        Object localObject4;
        Bitmap localBitmap;
        if (this.c.size() > 0)
        {
          localObject4 = this.c.entrySet().iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject3 = (DoodleResHelper.BitmapInfo)((Map.Entry)((Iterator)localObject4).next()).getValue();
            if ((localObject3 != null) && (((DoodleResHelper.BitmapInfo)localObject3).a != null) && (((DoodleResHelper.BitmapInfo)localObject3).a.get() != null))
            {
              if ((!((DoodleResHelper.BitmapInfo)localObject3).b) || (((DoodleResHelper.BitmapInfo)localObject3).d != paramInt2) || (((DoodleResHelper.BitmapInfo)localObject3).c != paramInt1)) {
                continue;
              }
              if (((DoodleResHelper.BitmapInfo)localObject3).a == null) {
                break label507;
              }
              localBitmap = (Bitmap)((DoodleResHelper.BitmapInfo)localObject3).a.get();
              if (localBitmap == null) {
                continue;
              }
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("getBitmap find idle :");
              ((StringBuilder)localObject4).append(this.c.size());
              QLog.d("DoodleResHelper", 2, ((StringBuilder)localObject4).toString());
              ((DoodleResHelper.BitmapInfo)localObject3).b = false;
              return localBitmap;
            }
            ((Iterator)localObject4).remove();
            QLog.d("DoodleResHelper", 2, "getBitmap remove a invalid item");
            continue;
          }
        }
        QLog.d("DoodleResHelper", 2, "getBitmap add new item");
        Object localObject3 = new DoodleResHelper.BitmapInfo(this);
        ((DoodleResHelper.BitmapInfo)localObject3).d = paramInt2;
        ((DoodleResHelper.BitmapInfo)localObject3).c = paramInt1;
        try
        {
          localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          ((DoodleResHelper.BitmapInfo)localObject3).a = new WeakReference(localBitmap);
          ((DoodleResHelper.BitmapInfo)localObject3).b = false;
          localObject4 = this.c;
          paramInt1 = this.d;
          this.d = (paramInt1 + 1);
          ((Map)localObject4).put(Integer.valueOf(paramInt1), localObject3);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getBitmap create new cache:");
          ((StringBuilder)localObject3).append(this.c.size());
          QLog.d("DoodleResHelper", 2, ((StringBuilder)localObject3).toString());
          return localBitmap;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getBitmap exception:");
            ((StringBuilder)localObject3).append(localException);
            QLog.e("DoodleResHelper", 2, ((StringBuilder)localObject3).toString());
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getBitmap exception OOM!");
            ((StringBuilder)localObject3).append(localOutOfMemoryError.toString());
            QLog.e("DoodleResHelper", 2, ((StringBuilder)localObject3).toString());
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoodleResHelper", 2, "getBitmap error!");
        }
        return null;
      }
      finally {}
      return null;
      label507:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper
 * JD-Core Version:    0.7.0.1
 */