package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.scribble.ResCallback;
import com.tencent.mobileqq.scribble.ResInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DoodleDrawer
  implements LoadDataJob.LoadDataJobListener, ResCallback
{
  boolean a = false;
  private int b = -1;
  private boolean c = false;
  private int d = 0;
  private DoodleParam e = new DoodleParam();
  private List<PathDrawer> f = new ArrayList();
  private Bitmap g;
  private Canvas h;
  private int i = 0;
  private int j = 0;
  private Object k = new Object();
  private long l = -1L;
  private Paint m;
  private long n = -1L;
  private WeakReference<DoodleDrawer.DoodleDrawerListener> o;
  private boolean p = false;
  private String q;
  private View r;
  private DoodleDrawer.DrawThread s = new DoodleDrawer.DrawThread(this);
  private LoadDataJob t = null;
  private Map<Integer, Integer> u = new HashMap();
  
  private void a(int paramInt)
  {
    synchronized (this.f)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        PathDrawer localPathDrawer = (PathDrawer)localIterator.next();
        if (localPathDrawer.a() == paramInt) {
          localPathDrawer.b(paramInt);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  /* Error */
  private void a(String paramString, long paramLong, List<PathDrawer> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:b	I
    //   4: istore 5
    //   6: iload 5
    //   8: iconst_3
    //   9: if_icmpeq +9 -> 18
    //   12: iload 5
    //   14: ifeq +4 -> 18
    //   17: return
    //   18: aload 4
    //   20: ifnonnull +4 -> 24
    //   23: return
    //   24: aload_0
    //   25: invokespecial 128	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:k	()Z
    //   28: ifne +13 -> 41
    //   31: aload_0
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   37: invokespecial 131	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:b	(Ljava/lang/String;J)V
    //   40: return
    //   41: lload_2
    //   42: aload_0
    //   43: getfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   46: lcmp
    //   47: ifge +7 -> 54
    //   50: aload_0
    //   51: invokespecial 133	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:h	()V
    //   54: lload_2
    //   55: lconst_0
    //   56: lcmp
    //   57: ifge +13 -> 70
    //   60: aload_0
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   66: invokespecial 131	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:b	(Ljava/lang/String;J)V
    //   69: return
    //   70: aload_0
    //   71: aload 4
    //   73: invokevirtual 136	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/util/List;)J
    //   76: lstore 6
    //   78: aload_0
    //   79: getfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   82: lstore 8
    //   84: lload 8
    //   86: lload 6
    //   88: lcmp
    //   89: iflt +11 -> 100
    //   92: aload_0
    //   93: aload_1
    //   94: lload 8
    //   96: invokespecial 131	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:b	(Ljava/lang/String;J)V
    //   99: return
    //   100: lload_2
    //   101: lload 6
    //   103: lcmp
    //   104: iflt +51 -> 155
    //   107: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +11 -> 121
    //   113: ldc 143
    //   115: iconst_2
    //   116: ldc 145
    //   118: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_0
    //   122: aload_1
    //   123: lload 6
    //   125: invokespecial 151	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/lang/String;J)Z
    //   128: ifeq +27 -> 155
    //   131: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +11 -> 145
    //   137: ldc 143
    //   139: iconst_2
    //   140: ldc 153
    //   142: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_0
    //   146: aload_1
    //   147: aload_0
    //   148: getfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   151: invokespecial 131	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:b	(Ljava/lang/String;J)V
    //   154: return
    //   155: aload_0
    //   156: getfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   159: lstore 8
    //   161: lload_2
    //   162: lload 6
    //   164: lcmp
    //   165: ifle +9 -> 174
    //   168: lload 6
    //   170: lstore_2
    //   171: goto +3 -> 174
    //   174: aload_0
    //   175: getfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   178: lload_2
    //   179: lcmp
    //   180: iflt +4 -> 184
    //   183: return
    //   184: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   187: lstore 10
    //   189: aload_0
    //   190: getfield 73	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:k	Ljava/lang/Object;
    //   193: astore 13
    //   195: aload 13
    //   197: monitorenter
    //   198: aload_0
    //   199: getfield 161	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:h	Landroid/graphics/Canvas;
    //   202: astore 14
    //   204: aload 13
    //   206: astore 12
    //   208: aload_0
    //   209: aload 14
    //   211: lload 8
    //   213: lload_2
    //   214: lload 6
    //   216: aload 4
    //   218: invokespecial 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Landroid/graphics/Canvas;JJJLjava/util/List;)Z
    //   221: ifeq +28 -> 249
    //   224: aload 13
    //   226: astore 12
    //   228: aload_0
    //   229: getfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   232: lload_2
    //   233: lcmp
    //   234: ifge +173 -> 407
    //   237: aload 13
    //   239: astore 12
    //   241: aload_0
    //   242: lload_2
    //   243: putfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   246: goto +161 -> 407
    //   249: aload 13
    //   251: astore 12
    //   253: aload_0
    //   254: lload 6
    //   256: putfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   259: aload 13
    //   261: astore 12
    //   263: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   266: lload 10
    //   268: lsub
    //   269: lstore 8
    //   271: lload 8
    //   273: ldc2_w 165
    //   276: lcmp
    //   277: ifle +130 -> 407
    //   280: lload_2
    //   281: lload 6
    //   283: lcmp
    //   284: iflt +123 -> 407
    //   287: aload 13
    //   289: astore 12
    //   291: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +78 -> 372
    //   297: aload 13
    //   299: astore 12
    //   301: new 168	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   308: astore 4
    //   310: aload 13
    //   312: astore 12
    //   314: aload 4
    //   316: ldc 171
    //   318: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 13
    //   324: astore 12
    //   326: aload 4
    //   328: lload 8
    //   330: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 13
    //   336: astore 12
    //   338: aload 4
    //   340: ldc 180
    //   342: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 13
    //   348: astore 12
    //   350: aload 4
    //   352: aload_1
    //   353: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 13
    //   359: astore 12
    //   361: ldc 143
    //   363: iconst_2
    //   364: aload 4
    //   366: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload 13
    //   374: astore 12
    //   376: aload_0
    //   377: aload_1
    //   378: aload_0
    //   379: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   382: invokespecial 189	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   385: aload 13
    //   387: astore 12
    //   389: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +15 -> 407
    //   395: aload 13
    //   397: astore 12
    //   399: ldc 143
    //   401: iconst_2
    //   402: ldc 191
    //   404: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload 13
    //   409: astore 12
    //   411: aload 13
    //   413: monitorexit
    //   414: aload_0
    //   415: aload_1
    //   416: aload_0
    //   417: getfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   420: invokespecial 131	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:b	(Ljava/lang/String;J)V
    //   423: return
    //   424: astore 4
    //   426: aload 12
    //   428: astore_1
    //   429: goto +8 -> 437
    //   432: astore 4
    //   434: aload 13
    //   436: astore_1
    //   437: aload_1
    //   438: astore 12
    //   440: aload_1
    //   441: monitorexit
    //   442: aload 4
    //   444: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	DoodleDrawer
    //   0	445	1	paramString	String
    //   0	445	2	paramLong	long
    //   0	445	4	paramList	List<PathDrawer>
    //   4	9	5	i1	int
    //   76	206	6	l1	long
    //   82	247	8	l2	long
    //   187	80	10	l3	long
    //   206	233	12	localObject1	Object
    //   193	242	13	localObject2	Object
    //   202	8	14	localCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   208	224	424	finally
    //   228	237	424	finally
    //   241	246	424	finally
    //   253	259	424	finally
    //   263	271	424	finally
    //   291	297	424	finally
    //   301	310	424	finally
    //   314	322	424	finally
    //   326	334	424	finally
    //   338	346	424	finally
    //   350	357	424	finally
    //   361	372	424	finally
    //   376	385	424	finally
    //   389	395	424	finally
    //   399	407	424	finally
    //   411	414	424	finally
    //   440	442	424	finally
    //   198	204	432	finally
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBitmap == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, paramString.lastIndexOf('_')));
      ((StringBuilder)localObject).append("_cache");
      paramString = ((StringBuilder)localObject).toString();
      if (FileUtils.fileExists(paramString)) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("tmp");
      localObject = ((StringBuilder)localObject).toString();
      if (FileUtils.fileExists((String)localObject)) {
        FileUtils.deleteFile((String)localObject);
      }
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream((String)localObject);
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        FileUtils.rename((String)localObject, paramString);
        return;
      }
      catch (Exception paramBitmap)
      {
        paramBitmap.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("saveFileCache exception:");
          ((StringBuilder)localObject).append(paramBitmap);
          QLog.e("DoodleDrawer", 2, ((StringBuilder)localObject).toString());
        }
        FileUtils.delete(paramString, true);
      }
    }
  }
  
  private boolean a(Canvas paramCanvas, long paramLong1, long paramLong2, long paramLong3, List<PathDrawer> paramList)
  {
    if ((paramLong1 <= paramLong2) && (paramCanvas != null))
    {
      int i1 = this.b;
      if ((i1 != 3) && (i1 != 0)) {
        return false;
      }
      paramList = paramList.iterator();
      long l2 = 0L;
      long l1 = l2;
      while (paramList.hasNext())
      {
        PathDrawer localPathDrawer = (PathDrawer)paramList.next();
        if (b() == 1) {
          l3 = localPathDrawer.d();
        } else {
          l3 = localPathDrawer.c();
        }
        long l3 = l2 + l3;
        long l4 = l3 + l1;
        if (l4 <= paramLong1)
        {
          l1 += 100L;
          l2 = l3;
        }
        else
        {
          if (l4 <= paramLong2)
          {
            if (this.l < paramLong2) {
              localPathDrawer.a(paramCanvas);
            }
          }
          else
          {
            if (paramLong1 > l2 + l1) {
              l3 = paramLong1 - l2 - l1;
            } else {
              l3 = 0L;
            }
            localPathDrawer.a(paramCanvas, l3, paramLong2 - l2 - l1);
            l3 = paramLong2 - l1;
          }
          l4 = l1 + 100L;
          l2 = l3;
          l1 = l4;
          if (l3 + l4 > paramLong2)
          {
            l2 = l3;
            l1 = l4;
          }
        }
      }
      return l2 + l1 - 100L < paramLong3;
    }
    if (QLog.isColorLevel())
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("drawSegmentsInner:param error: ");
      paramCanvas.append(paramLong1);
      paramCanvas.append(" ");
      paramCanvas.append(paramLong2);
      QLog.e("DoodleDrawer", 2, paramCanvas.toString());
    }
    return false;
  }
  
  private boolean a(String arg1, long paramLong)
  {
    try
    {
      ??? = c(???);
      if (TextUtils.isEmpty(???)) {
        return false;
      }
      Bitmap localBitmap = BitmapFactory.decodeFile(???);
      if (localBitmap != null)
      {
        Paint localPaint = new Paint();
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        localPaint.setAntiAlias(true);
        synchronized (this.k)
        {
          if (this.h != null)
          {
            Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
            Rect localRect2 = new Rect(0, 0, this.g.getWidth(), this.g.getHeight());
            this.h.drawBitmap(localBitmap, localRect1, localRect2, localPaint);
          }
          this.l = paramLong;
          localBitmap.recycle();
          return true;
        }
      }
      return false;
    }
    catch (Exception|OutOfMemoryError ???) {}
    return false;
  }
  
  private void b(String paramString, long paramLong)
  {
    ??? = this.q;
    if (??? != null)
    {
      if (!((String)???).equalsIgnoreCase(paramString)) {
        return;
      }
      ??? = this.o;
      if (??? != null)
      {
        DoodleDrawer.DoodleDrawerListener localDoodleDrawerListener = (DoodleDrawer.DoodleDrawerListener)((WeakReference)???).get();
        if (localDoodleDrawerListener != null) {
          synchronized (this.k)
          {
            localDoodleDrawerListener.a(paramString, paramLong, this.g);
            try
            {
              int i2 = this.b;
              int i1 = 0;
              if (i2 == 3)
              {
                this.b = 0;
                i1 = 1;
              }
              if (i1 != 0)
              {
                localDoodleDrawerListener.a(paramString, this.b);
                return;
              }
            }
            finally {}
          }
        }
      }
    }
  }
  
  private boolean b(String paramString)
  {
    try
    {
      if ((this.q != null) && (this.q.equalsIgnoreCase(paramString))) {
        return true;
      }
      this.q = paramString;
      return false;
    }
    finally {}
  }
  
  private String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(0, paramString.lastIndexOf('_')));
      localStringBuilder.append("_cache");
      paramString = localStringBuilder.toString();
      boolean bool = FileUtils.fileExists(paramString);
      if (bool) {
        return paramString;
      }
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void g()
  {
    synchronized (this.f)
    {
      this.f.clear();
      this.n = -1L;
      return;
    }
  }
  
  private void h()
  {
    synchronized (this.k)
    {
      if (this.m == null)
      {
        this.m = new Paint();
        this.m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
      if ((this.h != null) && (this.m != null)) {
        this.h.drawPaint(this.m);
      }
      this.l = -1L;
      return;
    }
  }
  
  private void i()
  {
    Object localObject1 = this.s;
    if (localObject1 != null) {
      ((DoodleDrawer.DrawThread)localObject1).c();
    }
    a(-1L, false);
    try
    {
      this.b = -1;
      this.c = false;
      if (this.t != null)
      {
        ThreadManager.removeJobFromThreadPool(this.t, 16);
        this.t = null;
      }
      this.t = new LoadDataJob(this.q, this.i, this.j, this);
      ThreadManager.excute(this.t, 16, null, true);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("run task now:");
      ((StringBuilder)localObject1).append(this.q);
      QLog.d("DoodleDrawer", 2, ((StringBuilder)localObject1).toString());
      this.b = 1;
      return;
    }
    finally {}
  }
  
  private void j()
  {
    StringBuilder localStringBuilder;
    if (this.b != 3)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTextureReady: state error:");
        localStringBuilder.append(this.b);
        QLog.d("DoodleDrawer", 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTextureReady: prepare:");
      localStringBuilder.append(this.p);
      QLog.d("DoodleDrawer", 2, localStringBuilder.toString());
    }
    if (this.p)
    {
      a(2147483647L, false);
      return;
    }
    a(-1L, false);
  }
  
  /* Error */
  private boolean k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:j	I
    //   4: istore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_1
    //   8: ifle +289 -> 297
    //   11: aload_0
    //   12: getfield 69	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:i	I
    //   15: ifgt +6 -> 21
    //   18: goto +279 -> 297
    //   21: aload_0
    //   22: getfield 73	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:k	Ljava/lang/Object;
    //   25: astore_3
    //   26: aload_3
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   32: ifnull +14 -> 46
    //   35: aload_0
    //   36: getfield 161	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:h	Landroid/graphics/Canvas;
    //   39: ifnull +7 -> 46
    //   42: aload_3
    //   43: monitorexit
    //   44: iconst_1
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   50: ifnull +18 -> 68
    //   53: invokestatic 408	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   56: aload_0
    //   57: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   60: invokevirtual 411	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   68: aload_0
    //   69: invokestatic 408	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   72: aload_0
    //   73: getfield 69	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:i	I
    //   76: aload_0
    //   77: getfield 71	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:j	I
    //   80: invokevirtual 414	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:i	(II)Landroid/graphics/Bitmap;
    //   83: putfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   86: aload_0
    //   87: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   90: ifnull +56 -> 146
    //   93: aload_0
    //   94: new 330	android/graphics/Canvas
    //   97: dup
    //   98: aload_0
    //   99: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   102: invokespecial 416	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   105: putfield 161	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:h	Landroid/graphics/Canvas;
    //   108: aload_0
    //   109: getfield 161	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:h	Landroid/graphics/Canvas;
    //   112: new 418	android/graphics/PaintFlagsDrawFilter
    //   115: dup
    //   116: iconst_0
    //   117: iconst_3
    //   118: invokespecial 421	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   121: invokevirtual 425	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   129: invokevirtual 322	android/graphics/Bitmap:getWidth	()I
    //   132: putfield 69	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:i	I
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   140: invokevirtual 325	android/graphics/Bitmap:getHeight	()I
    //   143: putfield 71	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:j	I
    //   146: aload_0
    //   147: invokespecial 133	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:h	()V
    //   150: iconst_1
    //   151: istore_2
    //   152: goto +134 -> 286
    //   155: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +12 -> 170
    //   161: ldc 143
    //   163: iconst_2
    //   164: ldc_w 427
    //   167: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_0
    //   171: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   174: ifnull +18 -> 192
    //   177: invokestatic 408	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   180: aload_0
    //   181: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   184: invokevirtual 411	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   192: aload_0
    //   193: aconst_null
    //   194: putfield 161	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:h	Landroid/graphics/Canvas;
    //   197: aload_0
    //   198: ldc2_w 74
    //   201: putfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   204: goto +82 -> 286
    //   207: astore 4
    //   209: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +40 -> 252
    //   215: new 168	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   222: astore 5
    //   224: aload 5
    //   226: ldc_w 429
    //   229: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 5
    //   235: aload 4
    //   237: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: ldc 143
    //   243: iconst_2
    //   244: aload 5
    //   246: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aload_0
    //   253: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   256: ifnull +18 -> 274
    //   259: invokestatic 408	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   262: aload_0
    //   263: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   266: invokevirtual 411	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   269: aload_0
    //   270: aconst_null
    //   271: putfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   274: aload_0
    //   275: aconst_null
    //   276: putfield 161	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:h	Landroid/graphics/Canvas;
    //   279: aload_0
    //   280: ldc2_w 74
    //   283: putfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   286: aload_3
    //   287: monitorexit
    //   288: iload_2
    //   289: ireturn
    //   290: astore 4
    //   292: aload_3
    //   293: monitorexit
    //   294: aload 4
    //   296: athrow
    //   297: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +54 -> 354
    //   303: new 168	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   310: astore_3
    //   311: aload_3
    //   312: ldc_w 431
    //   315: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_3
    //   320: aload_0
    //   321: getfield 69	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:i	I
    //   324: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_3
    //   329: ldc 180
    //   331: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_3
    //   336: aload_0
    //   337: getfield 71	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:j	I
    //   340: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: ldc 143
    //   346: iconst_2
    //   347: aload_3
    //   348: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: iconst_0
    //   355: ireturn
    //   356: astore 4
    //   358: goto -203 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	DoodleDrawer
    //   4	4	1	i1	int
    //   6	283	2	bool	boolean
    //   25	323	3	localObject1	Object
    //   207	29	4	localException	Exception
    //   290	5	4	localObject2	Object
    //   356	1	4	localOutOfMemoryError	OutOfMemoryError
    //   222	23	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	68	207	java/lang/Exception
    //   68	146	207	java/lang/Exception
    //   146	150	207	java/lang/Exception
    //   28	44	290	finally
    //   46	68	290	finally
    //   68	146	290	finally
    //   146	150	290	finally
    //   155	170	290	finally
    //   170	192	290	finally
    //   192	204	290	finally
    //   209	252	290	finally
    //   252	274	290	finally
    //   274	286	290	finally
    //   286	288	290	finally
    //   292	294	290	finally
    //   46	68	356	java/lang/OutOfMemoryError
    //   68	146	356	java/lang/OutOfMemoryError
    //   146	150	356	java/lang/OutOfMemoryError
  }
  
  public long a(List<PathDrawer> paramList)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return 0L;
      }
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        PathDrawer localPathDrawer = (PathDrawer)localIterator.next();
        if (b() == 1) {}
        for (l2 = localPathDrawer.d();; l2 = localPathDrawer.c())
        {
          l1 += l2;
          break;
          if (b() != 0) {
            break;
          }
        }
      }
      l2 = l1 + (paramList.size() - 1) * 100;
    }
    return l2;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_m1
    //   4: putfield 53	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:b	I
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 55	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:c	Z
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 344	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:o	Ljava/lang/ref/WeakReference;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 437	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:r	Landroid/view/View;
    //   24: aload_0
    //   25: ldc_w 439
    //   28: putfield 339	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:q	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 90	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:t	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   35: ifnull +18 -> 53
    //   38: aload_0
    //   39: getfield 90	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:t	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   42: bipush 16
    //   44: invokestatic 380	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   47: pop
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 90	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:t	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_0
    //   56: getfield 88	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:s	Lcom/tencent/mobileqq/activity/aio/doodle/DoodleDrawer$DrawThread;
    //   59: invokevirtual 441	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer$DrawThread:b	()V
    //   62: aload_0
    //   63: getfield 73	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:k	Ljava/lang/Object;
    //   66: astore_2
    //   67: aload_2
    //   68: monitorenter
    //   69: aload_0
    //   70: ldc2_w 74
    //   73: putfield 77	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:l	J
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 161	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:h	Landroid/graphics/Canvas;
    //   81: aload_0
    //   82: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   85: ifnull +13 -> 98
    //   88: aload_0
    //   89: getfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   92: astore_1
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 186	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	Landroid/graphics/Bitmap;
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 71	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:j	I
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 69	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:i	I
    //   108: aload_2
    //   109: monitorexit
    //   110: aload_1
    //   111: ifnull +10 -> 121
    //   114: invokestatic 408	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   117: aload_1
    //   118: invokevirtual 411	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   121: aload_0
    //   122: invokespecial 443	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:g	()V
    //   125: ldc 143
    //   127: iconst_2
    //   128: ldc_w 445
    //   131: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: return
    //   135: astore_1
    //   136: aload_2
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	DoodleDrawer
    //   13	105	1	localBitmap	Bitmap
    //   135	4	1	localObject1	Object
    //   140	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   69	81	135	finally
    //   81	98	135	finally
    //   98	110	135	finally
    //   136	138	135	finally
    //   2	12	140	finally
    //   14	53	140	finally
    //   53	55	140	finally
    //   141	143	140	finally
  }
  
  public void a(View paramView, int paramInt1, ResInfo paramResInfo, int paramInt2)
  {
    if (paramResInfo != null)
    {
      if (paramView == null) {
        return;
      }
      DoodleDrawer.DoodleDrawerListener localDoodleDrawerListener = null;
      WeakReference localWeakReference = this.o;
      if (localWeakReference != null) {
        localDoodleDrawerListener = (DoodleDrawer.DoodleDrawerListener)localWeakReference.get();
      }
      if ((localDoodleDrawerListener != null) && (this.r == paramView))
      {
        if (paramInt1 != 1) {
          return;
        }
        if (this.b != 2) {
          return;
        }
        int i1 = 0;
        paramInt1 = 0;
        if (1 == paramInt2) {
          try
          {
            this.u.remove(Integer.valueOf(paramResInfo.b));
            a(paramResInfo.b);
            paramInt1 = i1;
          }
          finally {}
        } else if (4 == paramInt2) {
          paramInt1 = i1;
        }
        try
        {
          if (this.u.get(Integer.valueOf(paramResInfo.b)) != null)
          {
            this.u.remove(Integer.valueOf(paramResInfo.b));
            this.u.put(Integer.valueOf(paramResInfo.b), Integer.valueOf(4));
            paramInt1 = 1;
          }
          if (paramInt1 != 0) {}
          try
          {
            this.b = 4;
            if (localDoodleDrawerListener != null)
            {
              localDoodleDrawerListener.a(this.q, 4);
              break label239;
              if (this.u.size() == 0)
              {
                this.b = 3;
                j();
              }
            }
            label239:
            return;
          }
          finally {}
          return;
        }
        finally {}
      }
    }
  }
  
  public void a(DoodleDrawer.DoodleDrawerListener paramDoodleDrawerListener, int paramInt1, int paramInt2, int paramInt3)
  {
    this.o = new WeakReference(paramDoodleDrawerListener);
    this.d = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
    k();
    this.b = -1;
    this.c = false;
  }
  
  public void a(String paramString, int paramInt, DoodleParam arg3, List<PathDrawer> paramList, Map<Integer, Integer> paramMap)
  {
    if ((??? != null) && (paramList != null)) {
      try
      {
        if (this.s != null) {
          this.s.a();
        }
        if ((this.q != null) && (this.q.equalsIgnoreCase(paramString)))
        {
          if (paramInt == 4)
          {
            this.b = 4;
            this.c = true;
            if (this.o != null)
            {
              ??? = (DoodleDrawer.DoodleDrawerListener)this.o.get();
              if (??? != null) {
                ???.a(paramString, 4);
              }
            }
            return;
          }
          this.b = 2;
          g();
          h();
          this.t = null;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onResult:");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" result:");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" State:");
            localStringBuilder.append(this.b);
            QLog.d("DoodleDrawer", 2, localStringBuilder.toString());
          }
          this.c = false;
          if (this.b == 1)
          {
            QLog.d("DoodleDrawer", 2, "onResult: reset data, state is loading now");
            return;
          }
          this.e.a(???);
          synchronized (this.f)
          {
            this.f.clear();
            this.f.addAll(paramList);
            try
            {
              this.u.clear();
              if ((paramMap != null) && (paramMap.size() > 0))
              {
                ??? = paramMap.entrySet().iterator();
                while (???.hasNext())
                {
                  paramList = (Map.Entry)???.next();
                  if (((Integer)paramList.getValue()).intValue() == 4)
                  {
                    this.u.put(paramList.getKey(), Integer.valueOf(1));
                    DoodleResHelper.a().b(0, ((Integer)paramList.getKey()).intValue(), this.r, this);
                  }
                }
              }
              if (this.u.size() > 0)
              {
                if (QLog.isColorLevel())
                {
                  ??? = new StringBuilder();
                  ???.append("onResult:");
                  ???.append(paramString);
                  ???.append(" waitting res");
                  QLog.d("DoodleDrawer", 2, ???.toString());
                }
                return;
              }
              this.b = 3;
              j();
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ???.append("onResult end:");
                ???.append(paramString);
                QLog.d("DoodleDrawer", 2, ???.toString());
              }
              return;
            }
            finally {}
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoodleDrawer", 2, "onResult is not current data");
        }
        return;
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.e("DoodleDrawer", 2, "onResult param error");
    }
    this.c = true;
    this.b = 4;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if (paramLong > 0L)
    {
      int i1 = this.b;
      if ((i1 != 3) && (i1 != 0)) {
        return false;
      }
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.f)
    {
      localArrayList.addAll(this.f);
      if (!paramBoolean)
      {
        ??? = this.q;
        this.s.a(new DoodleDrawer.1(this, (String)???, paramLong, localArrayList));
      }
      else
      {
        a(this.q, paramLong, localArrayList);
      }
      return paramLong < f();
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if (this.q == null) {
        return false;
      }
      if (!this.q.equalsIgnoreCase(paramString)) {
        return false;
      }
      if (this.a)
      {
        this.b = -1;
        this.q = "";
        return false;
      }
      return true;
    }
    finally {}
  }
  
  public boolean a(String paramString, boolean paramBoolean, Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setData ：");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" state:");
      localStringBuilder.append(this.b);
      QLog.d("DoodleDrawer", 2, localStringBuilder.toString());
    }
    boolean bool = TextUtils.isEmpty(paramString);
    long l1 = -1L;
    if (bool)
    {
      QLog.e("DoodleDrawer", 2, "setContent filename is null");
      this.q = "";
      this.b = -1;
      a(-1L, false);
      return false;
    }
    if (b(paramString)) {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("checkdigest, no change:");
        paramString.append(this.b);
        paramString.append(" old prepare:");
        paramString.append(this.p);
        QLog.d("DoodleDrawer", 2, paramString.toString());
      }
    }
    for (;;)
    {
      try
      {
        if (this.p == paramBoolean)
        {
          if (this.b == 0) {
            return false;
          }
          if (this.b == 4)
          {
            c();
            return false;
          }
          return true;
        }
        this.p = paramBoolean;
        if ((this.b != -1) && (this.b != 1) && (this.b != 2))
        {
          if ((this.b != 0) && (this.b != 3))
          {
            c();
            paramString = new StringBuilder();
            paramString.append("checkdigest, state error:");
            paramString.append(this.b);
            QLog.d("DoodleDrawer", 2, paramString.toString());
            return false;
          }
          this.b = 3;
          if (paramBoolean) {
            break label424;
          }
          a(l1, false);
          paramString = new StringBuilder();
          paramString.append("checkdigest, preapre:");
          paramString.append(l1);
          QLog.d("DoodleDrawer", 2, paramString.toString());
          return true;
        }
        QLog.d("DoodleDrawer", 2, "checkdigest, waitting event");
        return true;
      }
      finally {}
      try
      {
        this.r = new View(paramContext);
        this.r.setVisibility(4);
        this.p = paramBoolean;
        i();
        return true;
      }
      finally {}
      label424:
      l1 = 9223372036854775807L;
    }
  }
  
  public final int b()
  {
    return this.d;
  }
  
  public void c()
  {
    int i1 = this.b;
    Object localObject1;
    if (i1 == 0)
    {
      localObject1 = this.o;
      if (localObject1 != null)
      {
        localObject1 = (DoodleDrawer.DoodleDrawerListener)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((DoodleDrawer.DoodleDrawerListener)localObject1).a(this.q, 0);
        }
      }
      return;
    }
    if (i1 != 1)
    {
      if (i1 == -1) {
        return;
      }
      if (this.c == true)
      {
        i();
        return;
      }
      try
      {
        this.b = 2;
        if (this.u.size() > 0)
        {
          localObject1 = this.u.entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
            i1 = ((Integer)localEntry.getKey()).intValue();
            if (DoodleResHelper.a().b(0, i1))
            {
              ((Iterator)localObject1).remove();
              a(i1);
            }
            else
            {
              localEntry.setValue(Integer.valueOf(1));
              DoodleResHelper.a().b(0, i1, this.r, this);
            }
          }
        }
        if (this.u.size() > 0)
        {
          if (this.o != null)
          {
            localObject1 = (DoodleDrawer.DoodleDrawerListener)this.o.get();
            if (localObject1 != null) {
              ((DoodleDrawer.DoodleDrawerListener)localObject1).a(this.q, 2);
            }
          }
        }
        else
        {
          this.b = 3;
          j();
        }
        return;
      }
      finally {}
    }
  }
  
  public int d()
  {
    try
    {
      int i1 = this.b;
      return i1;
    }
    finally {}
  }
  
  public int e()
  {
    synchronized (this.f)
    {
      int i1 = this.f.size();
      return i1;
    }
  }
  
  public long f()
  {
    long l2 = this.n;
    long l1 = 0L;
    if (l2 <= 0L) {}
    label155:
    synchronized (this.f)
    {
      if (this.f.size() == 0)
      {
        this.n = 0L;
      }
      else
      {
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext())
        {
          PathDrawer localPathDrawer = (PathDrawer)localIterator.next();
          if (b() == 1)
          {
            l2 = localPathDrawer.d();
            break label155;
          }
          if (b() == 0)
          {
            l2 = localPathDrawer.c();
            break label155;
          }
        }
        this.n = (l1 + (this.f.size() - 1) * 100);
      }
      return this.n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer
 * JD-Core Version:    0.7.0.1
 */