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
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private View jdField_a_of_type_AndroidViewView;
  private DoodleDrawer.DrawThread jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DrawThread = new DoodleDrawer.DrawThread(this);
  private DoodleParam jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam = new DoodleParam();
  private LoadDataJob jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<DoodleDrawer.DoodleDrawerListener> jdField_a_of_type_JavaLangRefWeakReference;
  private List<PathDrawer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = 0;
  
  private String a(String paramString)
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
  
  private void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
  
  private void a(String paramString, long paramLong)
  {
    ??? = this.jdField_a_of_type_JavaLangString;
    if (??? != null)
    {
      if (!((String)???).equalsIgnoreCase(paramString)) {
        return;
      }
      ??? = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (??? != null)
      {
        DoodleDrawer.DoodleDrawerListener localDoodleDrawerListener = (DoodleDrawer.DoodleDrawerListener)((WeakReference)???).get();
        if (localDoodleDrawerListener != null) {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            localDoodleDrawerListener.a(paramString, paramLong, this.jdField_a_of_type_AndroidGraphicsBitmap);
            try
            {
              int j = this.jdField_a_of_type_Int;
              int i = 0;
              if (j == 3)
              {
                this.jdField_a_of_type_Int = 0;
                i = 1;
              }
              if (i != 0)
              {
                localDoodleDrawerListener.a(paramString, this.jdField_a_of_type_Int);
                return;
              }
            }
            finally {}
          }
        }
      }
    }
  }
  
  /* Error */
  private void a(String paramString, long paramLong, List<PathDrawer> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Int	I
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
    //   25: invokespecial 172	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	()Z
    //   28: ifne +13 -> 41
    //   31: aload_0
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   37: invokespecial 174	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/lang/String;J)V
    //   40: return
    //   41: lload_2
    //   42: aload_0
    //   43: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   46: lcmp
    //   47: ifge +7 -> 54
    //   50: aload_0
    //   51: invokespecial 176	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:d	()V
    //   54: lload_2
    //   55: lconst_0
    //   56: lcmp
    //   57: ifge +13 -> 70
    //   60: aload_0
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   66: invokespecial 174	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/lang/String;J)V
    //   69: return
    //   70: aload_0
    //   71: aload 4
    //   73: invokevirtual 179	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/util/List;)J
    //   76: lstore 6
    //   78: aload_0
    //   79: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   82: lstore 8
    //   84: lload 8
    //   86: lload 6
    //   88: lcmp
    //   89: iflt +11 -> 100
    //   92: aload_0
    //   93: aload_1
    //   94: lload 8
    //   96: invokespecial 174	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/lang/String;J)V
    //   99: return
    //   100: lload_2
    //   101: lload 6
    //   103: lcmp
    //   104: iflt +51 -> 155
    //   107: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +11 -> 121
    //   113: ldc 186
    //   115: iconst_2
    //   116: ldc 188
    //   118: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_0
    //   122: aload_1
    //   123: lload 6
    //   125: invokespecial 194	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/lang/String;J)Z
    //   128: ifeq +27 -> 155
    //   131: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +11 -> 145
    //   137: ldc 186
    //   139: iconst_2
    //   140: ldc 196
    //   142: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_0
    //   146: aload_1
    //   147: aload_0
    //   148: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   151: invokespecial 174	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/lang/String;J)V
    //   154: return
    //   155: aload_0
    //   156: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   159: lstore 8
    //   161: lload_2
    //   162: lload 6
    //   164: lcmp
    //   165: ifle +9 -> 174
    //   168: lload 6
    //   170: lstore_2
    //   171: goto +3 -> 174
    //   174: aload_0
    //   175: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   178: lload_2
    //   179: lcmp
    //   180: iflt +4 -> 184
    //   183: return
    //   184: invokestatic 202	java/lang/System:currentTimeMillis	()J
    //   187: lstore 10
    //   189: aload_0
    //   190: getfield 56	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   193: astore 13
    //   195: aload 13
    //   197: monitorenter
    //   198: aload_0
    //   199: getfield 204	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   202: astore 14
    //   204: aload 13
    //   206: astore 12
    //   208: aload_0
    //   209: aload 14
    //   211: lload 8
    //   213: lload_2
    //   214: lload 6
    //   216: aload 4
    //   218: invokespecial 207	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Landroid/graphics/Canvas;JJJLjava/util/List;)Z
    //   221: ifeq +28 -> 249
    //   224: aload 13
    //   226: astore 12
    //   228: aload_0
    //   229: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   232: lload_2
    //   233: lcmp
    //   234: ifge +173 -> 407
    //   237: aload 13
    //   239: astore 12
    //   241: aload_0
    //   242: lload_2
    //   243: putfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   246: goto +161 -> 407
    //   249: aload 13
    //   251: astore 12
    //   253: aload_0
    //   254: lload 6
    //   256: putfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   259: aload 13
    //   261: astore 12
    //   263: invokestatic 202	java/lang/System:currentTimeMillis	()J
    //   266: lload 10
    //   268: lsub
    //   269: lstore 8
    //   271: lload 8
    //   273: ldc2_w 208
    //   276: lcmp
    //   277: ifle +130 -> 407
    //   280: lload_2
    //   281: lload 6
    //   283: lcmp
    //   284: iflt +123 -> 407
    //   287: aload 13
    //   289: astore 12
    //   291: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +78 -> 372
    //   297: aload 13
    //   299: astore 12
    //   301: new 92	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   308: astore 4
    //   310: aload 13
    //   312: astore 12
    //   314: aload 4
    //   316: ldc 211
    //   318: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 13
    //   324: astore 12
    //   326: aload 4
    //   328: lload 8
    //   330: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 13
    //   336: astore 12
    //   338: aload 4
    //   340: ldc 216
    //   342: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 13
    //   348: astore 12
    //   350: aload 4
    //   352: aload_1
    //   353: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 13
    //   359: astore 12
    //   361: ldc 186
    //   363: iconst_2
    //   364: aload 4
    //   366: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload 13
    //   374: astore 12
    //   376: aload_0
    //   377: aload_1
    //   378: aload_0
    //   379: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   382: invokespecial 219	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   385: aload 13
    //   387: astore 12
    //   389: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +15 -> 407
    //   395: aload 13
    //   397: astore 12
    //   399: ldc 186
    //   401: iconst_2
    //   402: ldc 221
    //   404: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload 13
    //   409: astore 12
    //   411: aload 13
    //   413: monitorexit
    //   414: aload_0
    //   415: aload_1
    //   416: aload_0
    //   417: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   420: invokespecial 174	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:a	(Ljava/lang/String;J)V
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
    //   4	9	5	i	int
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
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:d	I
    //   4: istore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_1
    //   8: ifle +289 -> 297
    //   11: aload_0
    //   12: getfield 52	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_c_of_type_Int	I
    //   15: ifgt +6 -> 21
    //   18: goto +279 -> 297
    //   21: aload_0
    //   22: getfield 56	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   25: astore_3
    //   26: aload_3
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   32: ifnull +14 -> 46
    //   35: aload_0
    //   36: getfield 204	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   39: ifnull +7 -> 46
    //   42: aload_3
    //   43: monitorexit
    //   44: iconst_1
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   50: ifnull +18 -> 68
    //   53: invokestatic 277	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   56: aload_0
    //   57: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   60: invokevirtual 280	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   68: aload_0
    //   69: invokestatic 277	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   72: aload_0
    //   73: getfield 52	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_c_of_type_Int	I
    //   76: aload_0
    //   77: getfield 54	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:d	I
    //   80: invokevirtual 283	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:c	(II)Landroid/graphics/Bitmap;
    //   83: putfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   86: aload_0
    //   87: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   90: ifnull +56 -> 146
    //   93: aload_0
    //   94: new 285	android/graphics/Canvas
    //   97: dup
    //   98: aload_0
    //   99: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   102: invokespecial 287	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   105: putfield 204	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   108: aload_0
    //   109: getfield 204	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   112: new 289	android/graphics/PaintFlagsDrawFilter
    //   115: dup
    //   116: iconst_0
    //   117: iconst_3
    //   118: invokespecial 292	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   121: invokevirtual 296	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   129: invokevirtual 299	android/graphics/Bitmap:getWidth	()I
    //   132: putfield 52	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_c_of_type_Int	I
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   140: invokevirtual 302	android/graphics/Bitmap:getHeight	()I
    //   143: putfield 54	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:d	I
    //   146: aload_0
    //   147: invokespecial 176	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:d	()V
    //   150: iconst_1
    //   151: istore_2
    //   152: goto +134 -> 286
    //   155: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +12 -> 170
    //   161: ldc 186
    //   163: iconst_2
    //   164: ldc_w 304
    //   167: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_0
    //   171: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   174: ifnull +18 -> 192
    //   177: invokestatic 277	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   180: aload_0
    //   181: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   184: invokevirtual 280	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   192: aload_0
    //   193: aconst_null
    //   194: putfield 204	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   197: aload_0
    //   198: ldc2_w 57
    //   201: putfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   204: goto +82 -> 286
    //   207: astore 4
    //   209: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +40 -> 252
    //   215: new 92	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   222: astore 5
    //   224: aload 5
    //   226: ldc_w 306
    //   229: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 5
    //   235: aload 4
    //   237: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: ldc 186
    //   243: iconst_2
    //   244: aload 5
    //   246: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aload_0
    //   253: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   256: ifnull +18 -> 274
    //   259: invokestatic 277	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   262: aload_0
    //   263: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   266: invokevirtual 280	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   269: aload_0
    //   270: aconst_null
    //   271: putfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   274: aload_0
    //   275: aconst_null
    //   276: putfield 204	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   279: aload_0
    //   280: ldc2_w 57
    //   283: putfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   286: aload_3
    //   287: monitorexit
    //   288: iload_2
    //   289: ireturn
    //   290: astore 4
    //   292: aload_3
    //   293: monitorexit
    //   294: aload 4
    //   296: athrow
    //   297: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +54 -> 354
    //   303: new 92	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   310: astore_3
    //   311: aload_3
    //   312: ldc_w 308
    //   315: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_3
    //   320: aload_0
    //   321: getfield 52	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_c_of_type_Int	I
    //   324: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_3
    //   329: ldc 216
    //   331: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_3
    //   336: aload_0
    //   337: getfield 54	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:d	I
    //   340: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: ldc 186
    //   346: iconst_2
    //   347: aload_3
    //   348: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: iconst_0
    //   355: ireturn
    //   356: astore 4
    //   358: goto -203 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	DoodleDrawer
    //   4	4	1	i	int
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
  
  private boolean a(Canvas paramCanvas, long paramLong1, long paramLong2, long paramLong3, List<PathDrawer> paramList)
  {
    if ((paramLong1 <= paramLong2) && (paramCanvas != null))
    {
      int i = this.jdField_a_of_type_Int;
      if ((i != 3) && (i != 0)) {
        return false;
      }
      paramList = paramList.iterator();
      long l2 = 0L;
      long l1 = l2;
      while (paramList.hasNext())
      {
        PathDrawer localPathDrawer = (PathDrawer)paramList.next();
        if (a() == 1) {
          l3 = localPathDrawer.a();
        } else {
          l3 = localPathDrawer.b();
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
            if (this.jdField_a_of_type_Long < paramLong2) {
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
      ??? = a(???);
      if (TextUtils.isEmpty(???)) {
        return false;
      }
      Bitmap localBitmap = BitmapFactory.decodeFile(???);
      if (localBitmap != null)
      {
        Paint localPaint = new Paint();
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        localPaint.setAntiAlias(true);
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_AndroidGraphicsCanvas != null)
          {
            Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
            Rect localRect2 = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
            this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(localBitmap, localRect1, localRect2, localPaint);
          }
          this.jdField_a_of_type_Long = paramLong;
          localBitmap.recycle();
          return true;
        }
      }
      return false;
    }
    catch (Exception|OutOfMemoryError ???) {}
    return false;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
        return true;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      return false;
    }
    finally {}
  }
  
  private void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_Long = -1L;
      return;
    }
  }
  
  private void d()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
      if ((this.jdField_a_of_type_AndroidGraphicsCanvas != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null)) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_Long = -1L;
      return;
    }
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DrawThread;
    if (localObject1 != null) {
      ((DoodleDrawer.DrawThread)localObject1).c();
    }
    a(-1L, false);
    try
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob != null)
      {
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob, 16);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = new LoadDataJob(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.d, this);
      ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob, 16, null, true);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("run task now:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("DoodleDrawer", 2, ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_Int = 1;
      return;
    }
    finally {}
  }
  
  private void f()
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Int != 3)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTextureReady: state error:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("DoodleDrawer", 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTextureReady: prepare:");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("DoodleDrawer", 2, localStringBuilder.toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      a(2147483647L, false);
      return;
    }
    a(-1L, false);
  }
  
  public final int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    long l2 = this.jdField_b_of_type_Long;
    long l1 = 0L;
    if (l2 <= 0L) {}
    label155:
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.jdField_b_of_type_Long = 0L;
      }
      else
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          PathDrawer localPathDrawer = (PathDrawer)localIterator.next();
          if (a() == 1)
          {
            l2 = localPathDrawer.a();
            break label155;
          }
          if (a() == 0)
          {
            l2 = localPathDrawer.b();
            break label155;
          }
        }
        this.jdField_b_of_type_Long = (l1 + (this.jdField_a_of_type_JavaUtilList.size() - 1) * 100);
      }
      return this.jdField_b_of_type_Long;
    }
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
        if (a() == 1) {}
        for (l2 = localPathDrawer.a();; l2 = localPathDrawer.b())
        {
          l1 += l2;
          break;
          if (a() != 0) {
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
    //   4: putfield 36	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Int	I
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 38	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_b_of_type_Boolean	Z
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 155	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 421	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   24: aload_0
    //   25: ldc_w 423
    //   28: putfield 150	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 73	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   35: ifnull +18 -> 53
    //   38: aload_0
    //   39: getfield 73	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   42: bipush 16
    //   44: invokestatic 394	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   47: pop
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 73	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_0
    //   56: getfield 71	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DrawThread	Lcom/tencent/mobileqq/activity/aio/doodle/DoodleDrawer$DrawThread;
    //   59: invokevirtual 425	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer$DrawThread:b	()V
    //   62: aload_0
    //   63: getfield 56	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   66: astore_2
    //   67: aload_2
    //   68: monitorenter
    //   69: aload_0
    //   70: ldc2_w 57
    //   73: putfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 204	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   81: aload_0
    //   82: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   85: ifnull +13 -> 98
    //   88: aload_0
    //   89: getfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   92: astore_1
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 164	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 54	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:d	I
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 52	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_c_of_type_Int	I
    //   108: aload_2
    //   109: monitorexit
    //   110: aload_1
    //   111: ifnull +10 -> 121
    //   114: invokestatic 277	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   117: aload_1
    //   118: invokevirtual 280	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   121: aload_0
    //   122: invokespecial 426	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:c	()V
    //   125: ldc 186
    //   127: iconst_2
    //   128: ldc_w 428
    //   131: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
      WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localWeakReference != null) {
        localDoodleDrawerListener = (DoodleDrawer.DoodleDrawerListener)localWeakReference.get();
      }
      if ((localDoodleDrawerListener != null) && (this.jdField_a_of_type_AndroidViewView == paramView))
      {
        if (paramInt1 != 1) {
          return;
        }
        if (this.jdField_a_of_type_Int != 2) {
          return;
        }
        int i = 0;
        paramInt1 = 0;
        if (1 == paramInt2) {
          try
          {
            this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramResInfo.jdField_b_of_type_Int));
            a(paramResInfo.jdField_b_of_type_Int);
            paramInt1 = i;
          }
          finally {}
        } else if (4 == paramInt2) {
          paramInt1 = i;
        }
        try
        {
          if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramResInfo.jdField_b_of_type_Int)) != null)
          {
            this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramResInfo.jdField_b_of_type_Int));
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramResInfo.jdField_b_of_type_Int), Integer.valueOf(4));
            paramInt1 = 1;
          }
          if (paramInt1 != 0) {}
          try
          {
            this.jdField_a_of_type_Int = 4;
            if (localDoodleDrawerListener != null)
            {
              localDoodleDrawerListener.a(this.jdField_a_of_type_JavaLangString, 4);
              break label239;
              if (this.jdField_a_of_type_JavaUtilMap.size() == 0)
              {
                this.jdField_a_of_type_Int = 3;
                f();
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
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDoodleDrawerListener);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.d = paramInt3;
    a();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, DoodleParam arg3, List<PathDrawer> paramList, Map<Integer, Integer> paramMap)
  {
    if ((??? != null) && (paramList != null)) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DrawThread != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DrawThread.a();
        }
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)))
        {
          if (paramInt == 4)
          {
            this.jdField_a_of_type_Int = 4;
            this.jdField_b_of_type_Boolean = true;
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              ??? = (DoodleDrawer.DoodleDrawerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
              if (??? != null) {
                ???.a(paramString, 4);
              }
            }
            return;
          }
          this.jdField_a_of_type_Int = 2;
          c();
          d();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = null;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onResult:");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" result:");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" State:");
            localStringBuilder.append(this.jdField_a_of_type_Int);
            QLog.d("DoodleDrawer", 2, localStringBuilder.toString());
          }
          this.jdField_b_of_type_Boolean = false;
          if (this.jdField_a_of_type_Int == 1)
          {
            QLog.d("DoodleDrawer", 2, "onResult: reset data, state is loading now");
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(???);
          synchronized (this.jdField_a_of_type_JavaUtilList)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramList);
            try
            {
              this.jdField_a_of_type_JavaUtilMap.clear();
              if ((paramMap != null) && (paramMap.size() > 0))
              {
                ??? = paramMap.entrySet().iterator();
                while (???.hasNext())
                {
                  paramList = (Map.Entry)???.next();
                  if (((Integer)paramList.getValue()).intValue() == 4)
                  {
                    this.jdField_a_of_type_JavaUtilMap.put(paramList.getKey(), Integer.valueOf(1));
                    DoodleResHelper.a().b(0, ((Integer)paramList.getKey()).intValue(), this.jdField_a_of_type_AndroidViewView, this);
                  }
                }
              }
              if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
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
              this.jdField_a_of_type_Int = 3;
              f();
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
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 4;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if (paramLong > 0L)
    {
      int i = this.jdField_a_of_type_Int;
      if ((i != 3) && (i != 0)) {
        return false;
      }
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      if (!paramBoolean)
      {
        ??? = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DrawThread.a(new DoodleDrawer.1(this, (String)???, paramLong, localArrayList));
      }
      else
      {
        a(this.jdField_a_of_type_JavaLangString, paramLong, localArrayList);
      }
      return paramLong < a();
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        return false;
      }
      if (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {
        return false;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_JavaLangString = "";
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
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("DoodleDrawer", 2, localStringBuilder.toString());
    }
    boolean bool = TextUtils.isEmpty(paramString);
    long l = -1L;
    if (bool)
    {
      QLog.e("DoodleDrawer", 2, "setContent filename is null");
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_Int = -1;
      a(-1L, false);
      return false;
    }
    if (b(paramString)) {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("checkdigest, no change:");
        paramString.append(this.jdField_a_of_type_Int);
        paramString.append(" old prepare:");
        paramString.append(this.jdField_c_of_type_Boolean);
        QLog.d("DoodleDrawer", 2, paramString.toString());
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_c_of_type_Boolean == paramBoolean)
        {
          if (this.jdField_a_of_type_Int == 0) {
            return false;
          }
          if (this.jdField_a_of_type_Int == 4)
          {
            b();
            return false;
          }
          return true;
        }
        this.jdField_c_of_type_Boolean = paramBoolean;
        if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2))
        {
          if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 3))
          {
            b();
            paramString = new StringBuilder();
            paramString.append("checkdigest, state error:");
            paramString.append(this.jdField_a_of_type_Int);
            QLog.d("DoodleDrawer", 2, paramString.toString());
            return false;
          }
          this.jdField_a_of_type_Int = 3;
          if (paramBoolean) {
            break label424;
          }
          a(l, false);
          paramString = new StringBuilder();
          paramString.append("checkdigest, preapre:");
          paramString.append(l);
          QLog.d("DoodleDrawer", 2, paramString.toString());
          return true;
        }
        QLog.d("DoodleDrawer", 2, "checkdigest, waitting event");
        return true;
      }
      finally {}
      try
      {
        this.jdField_a_of_type_AndroidViewView = new View(paramContext);
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_c_of_type_Boolean = paramBoolean;
        e();
        return true;
      }
      finally {}
      label424:
      l = 9223372036854775807L;
    }
  }
  
  public int b()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject1;
    if (i == 0)
    {
      localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 != null)
      {
        localObject1 = (DoodleDrawer.DoodleDrawerListener)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((DoodleDrawer.DoodleDrawerListener)localObject1).a(this.jdField_a_of_type_JavaLangString, 0);
        }
      }
      return;
    }
    if (i != 1)
    {
      if (i == -1) {
        return;
      }
      if (this.jdField_b_of_type_Boolean == true)
      {
        e();
        return;
      }
      try
      {
        this.jdField_a_of_type_Int = 2;
        if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
        {
          localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
            i = ((Integer)localEntry.getKey()).intValue();
            if (DoodleResHelper.a().b(0, i))
            {
              ((Iterator)localObject1).remove();
              a(i);
            }
            else
            {
              localEntry.setValue(Integer.valueOf(1));
              DoodleResHelper.a().b(0, i, this.jdField_a_of_type_AndroidViewView, this);
            }
          }
        }
        if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
        {
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            localObject1 = (DoodleDrawer.DoodleDrawerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (localObject1 != null) {
              ((DoodleDrawer.DoodleDrawerListener)localObject1).a(this.jdField_a_of_type_JavaLangString, 2);
            }
          }
        }
        else
        {
          this.jdField_a_of_type_Int = 3;
          f();
        }
        return;
      }
      finally {}
    }
  }
  
  public int c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer
 * JD-Core Version:    0.7.0.1
 */