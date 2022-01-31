import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.ImageUtil.1;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bdhj
{
  private static int jdField_a_of_type_Int = 1280;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public static double a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    double d3 = 1.0D;
    if ((i <= paramInt1) && (j <= paramInt2)) {
      return d3;
    }
    double d1;
    if (i > j) {
      d1 = i / paramInt1;
    }
    for (double d2 = j / paramInt2;; d2 = i / paramInt2)
    {
      d3 = d1;
      if (d1 > d2) {
        break;
      }
      return d2;
      d1 = j / paramInt1;
    }
  }
  
  public static int a(int paramInt)
  {
    int i = 10;
    if (paramInt < 100) {
      i = 3;
    }
    while (paramInt >= 140) {
      return i;
    }
    return 7;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 1;
    int i = j;
    if (paramInt1 != 0)
    {
      i = j;
      if (paramInt2 != 0)
      {
        i = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i = j;
        }
      }
    }
    return i;
    label43:
    float f = paramOptions.outWidth * paramOptions.outHeight / (paramInt1 * paramInt2);
    paramInt1 = k;
    for (;;)
    {
      i = paramInt1;
      if (f <= 1.0F) {
        break;
      }
      paramInt1 *= 2;
      f /= 4.0F;
    }
  }
  
  public static int a(ExifInterface paramExifInterface)
  {
    int j = 0;
    int i = j;
    if (paramExifInterface != null)
    {
      int k = paramExifInterface.getAttributeInt("Orientation", -1);
      a("getExifOrientation  orientation  =====" + k + "=====");
      i = j;
      if (k != -1)
      {
        i = j;
        switch (k)
        {
        default: 
          i = j;
        }
      }
    }
    for (;;)
    {
      a("getExifOrientation degree =======" + i + "==========");
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  public static int a(String paramString)
  {
    try
    {
      paramString = Class.forName("android.media.ExifInterface").getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      if (paramString == null) {}
    }
    catch (Exception paramString)
    {
      try
      {
        i = ((Integer)paramString.getClass().getMethod("getAttributeInt", new Class[] { String.class, Integer.TYPE }).invoke(paramString, new Object[] { "Orientation", Integer.valueOf(-1) })).intValue();
        if (i != -1) {}
        switch (i)
        {
        case 4: 
        case 5: 
        case 7: 
        default: 
          return 0;
          paramString = paramString;
          if (QLog.isColorLevel()) {
            QLog.e("reflection", 2, "e = " + paramString.toString());
          }
          paramString = null;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("reflection", 2, "e = " + paramString.toString());
          }
          int i = 0;
        }
        return 90;
      }
    }
    return 180;
    return 270;
  }
  
  public static Bitmap a()
  {
    return a(false);
  }
  
  public static Bitmap a(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramInt == 0) || (paramInt == 2))
    {
      localObject2 = localObject1;
      if (BaseApplicationImpl.sImageCache != null) {
        localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://DefaultQQStoryRoundFace");
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = c(bdal.b(BaseApplicationImpl.getApplication().getResources(), 2130846012), 10.0F, 70, 70);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put("static://DefaultQQStoryRoundFace", localObject2);
            localObject1 = localObject2;
          }
        }
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
            return localObject1;
            localObject1 = localObject3;
          } while (paramInt != 1);
          if (BaseApplicationImpl.sImageCache != null) {
            localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://DefaultQQStoryFace");
          }
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject2 = c(bdal.b(BaseApplicationImpl.getApplication().getResources(), 2130846012), 70, 70);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (BaseApplicationImpl.sImageCache == null);
    BaseApplicationImpl.sImageCache.put("static://DefaultQQStoryFace", localObject2);
    return localObject2;
  }
  
  private static Bitmap a(int paramInt1, Context paramContext, File paramFile, int paramInt2, ImageInfo paramImageInfo)
  {
    Object localObject2 = null;
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    BitmapFactory.Options localOptions2 = a(localOptions1, paramFile.getPath(), paramInt2);
    if ((localOptions1.outWidth > 960) || (localOptions1.outHeight > 960)) {
      a("report_sendphoto_not_larger_960", paramContext, true);
    }
    for (;;)
    {
      paramInt2 = 1;
      paramInt1 = 0;
      Bitmap localBitmap = null;
      for (;;)
      {
        if (((localBitmap != null) || (localOptions2.inSampleSize <= 0) || (localOptions2.inSampleSize > 4)) && (paramInt2 == 0)) {
          break label291;
        }
        if (paramInt2 == 0) {
          localOptions2.inSampleSize *= 2;
        }
        try
        {
          localBitmap = SafeBitmapFactory.decodeFile(paramFile.getPath(), localOptions2);
          paramInt2 = 0;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          a("compress : compressNoLargePhoto  getBitmap  OOM " + localOptions2.inSampleSize);
          paramInt1 = localOptions1.outWidth * localOptions1.outHeight;
          if ((paramInt1 > bayu.jdField_a_of_type_Int) || (paramInt1 <= 0)) {
            break label195;
          }
          bhsi.a(((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getCurrentAccountUin());
          if (!bdin.h(paramContext)) {
            break label281;
          }
        }
      }
      a("report_sendphoto_not_larger_960", paramContext, false);
    }
    label195:
    paramImageInfo.jdField_i_of_type_Int = 1;
    paramImageInfo.g = true;
    if (paramImageInfo.jdField_c_of_type_Int == 0)
    {
      paramImageInfo.jdField_h_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ImageUtil", 2, "WIFI oom ,c2c send srcfile by raw");
      }
      label242:
      paramInt1 = 1;
    }
    label281:
    Object localObject1;
    label291:
    for (paramContext = localObject2;; paramContext = localObject1)
    {
      if ((paramContext == null) && (paramInt1 != 0)) {
        paramImageInfo.g = true;
      }
      return paramContext;
      if (!QLog.isColorLevel()) {
        break label242;
      }
      QLog.d("ImageUtil", 2, "WIFI oom ,not c2c send srcfile by nor");
      break label242;
      paramInt2 = 0;
      paramInt1 = 1;
      localObject1 = null;
      break;
    }
  }
  
  @TargetApi(17)
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT < 17) {
      return null;
    }
    Object localObject1 = Bitmap.createScaledBitmap(paramBitmap, Math.round(paramBitmap.getWidth() * paramFloat1), Math.round(paramBitmap.getHeight() * paramFloat1), false);
    paramBitmap = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject2 = RenderScript.create(paramContext);
    paramContext = ScriptIntrinsicBlur.create((RenderScript)localObject2, Element.U8_4((RenderScript)localObject2));
    localObject1 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject1);
    localObject2 = Allocation.createFromBitmap((RenderScript)localObject2, paramBitmap);
    paramContext.setRadius(paramFloat2);
    paramContext.setInput((Allocation)localObject1);
    paramContext.forEach((Allocation)localObject2);
    ((Allocation)localObject2).copyTo(paramBitmap);
    return paramBitmap;
  }
  
  /* Error */
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 338	android/util/TypedValue
    //   5: dup
    //   6: invokespecial 339	android/util/TypedValue:<init>	()V
    //   9: astore 4
    //   11: new 341	java/io/BufferedInputStream
    //   14: dup
    //   15: aload_0
    //   16: iload_1
    //   17: aload 4
    //   19: invokevirtual 347	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   22: invokespecial 350	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_2
    //   26: aload_0
    //   27: aload 4
    //   29: aload_2
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokestatic 356	android/graphics/BitmapFactory:decodeResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   35: astore_0
    //   36: aload_0
    //   37: astore_3
    //   38: aload_3
    //   39: astore_0
    //   40: aload_2
    //   41: ifnull +9 -> 50
    //   44: aload_2
    //   45: invokevirtual 361	java/io/InputStream:close	()V
    //   48: aload_3
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_3
    //   56: astore_0
    //   57: aload_2
    //   58: ifnull -8 -> 50
    //   61: aload_2
    //   62: invokevirtual 361	java/io/InputStream:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: areturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_3
    //   74: astore_0
    //   75: aload_2
    //   76: ifnull -26 -> 50
    //   79: aload_2
    //   80: invokevirtual 361	java/io/InputStream:close	()V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +7 -> 99
    //   95: aload_2
    //   96: invokevirtual 361	java/io/InputStream:close	()V
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: aload_3
    //   103: areturn
    //   104: astore_2
    //   105: goto -6 -> 99
    //   108: astore_0
    //   109: goto -18 -> 91
    //   112: astore_0
    //   113: goto -40 -> 73
    //   116: astore_0
    //   117: goto -62 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramResources	Resources
    //   0	120	1	paramInt	int
    //   25	71	2	localBufferedInputStream	java.io.BufferedInputStream
    //   104	1	2	localIOException	IOException
    //   1	102	3	localResources	Resources
    //   9	19	4	localTypedValue	android.util.TypedValue
    // Exception table:
    //   from	to	target	type
    //   2	26	52	java/lang/OutOfMemoryError
    //   61	65	67	java/io/IOException
    //   2	26	70	java/lang/Throwable
    //   79	83	85	java/io/IOException
    //   2	26	88	finally
    //   44	48	101	java/io/IOException
    //   95	99	104	java/io/IOException
    //   26	36	108	finally
    //   26	36	112	java/lang/Throwable
    //   26	36	116	java/lang/OutOfMemoryError
  }
  
  public static final Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      localObject = paramBitmap;
      if (localBitmap != null)
      {
        localObject = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        ColorMatrix localColorMatrix = new ColorMatrix();
        localColorMatrix.setSaturation(0.0F);
        localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
        ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
        localObject = localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        Object localObject = paramBitmap;
      } while (!QLog.isColorLevel());
      QLog.d("ImageUtil", 2, "grey bitmap, oom, stack:" + MsfSdkUtils.getStackTraceString(localOutOfMemoryError));
    }
    return localObject;
    return paramBitmap;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {}
    do
    {
      return localObject2;
      try
      {
        localObject2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Paint localPaint;
          Rect localRect;
          RectF localRectF;
          a("OOM occurred in ImageUtil.round" + localOutOfMemoryError.getMessage());
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    localObject2 = new Canvas(localObject1);
    localPaint = new Paint();
    localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    ((Canvas)localObject2).drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject2).drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localObject1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        a("cutOurImg() img:[" + f1 + ", " + f2 + "], default: [" + paramFloat1 + ", " + paramFloat2 + "]");
        float f3 = paramFloat1 / f1;
        float f4 = paramFloat2 / f2;
        if (f3 > f4)
        {
          j = (int)paramFloat1;
          i = (int)(f3 * f2);
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(j / f1, i / f2);
          localMatrix.postTranslate((paramFloat1 - j) / 2.0F, (paramFloat2 - i) / 2.0F);
          Bitmap localBitmap = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.RGB_565);
          new Canvas(localBitmap).drawBitmap(paramBitmap, localMatrix, null);
          paramBitmap = localBitmap;
          return paramBitmap;
        }
        int j = (int)(f1 * f4);
        int i = (int)paramFloat2;
        continue;
        paramBitmap = null;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        return null;
      }
      catch (Exception paramBitmap)
      {
        return null;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    return a(paramBitmap, paramFloat, false, paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        int j = paramBitmap.getWidth();
        int i = paramBitmap.getHeight();
        if (j > i)
        {
          m = (j - i) / 2;
          k = 0;
          paramInt1 = paramInt2;
          j = i;
          break label257;
          Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(m, k, j + m, i + k);
          Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-12434878);
          localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
          return localBitmap;
        }
        else if (i > j)
        {
          k = (i - j) / 2;
          int n = 0;
          paramInt2 = paramInt1;
          m = j;
          i = j;
          j = m;
          m = n;
        }
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
        return null;
      }
      int k = 0;
      int m = 0;
      label257:
      if (!paramBoolean) {
        paramFloat = paramInt1;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {
      return localObject2;
    }
    localObject2 = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f = paramInt / (Math.max(i, j) * 1.0F);
    if ((f != 1.0F) && (f > 0.0F)) {}
    for (;;)
    {
      try
      {
        ((Matrix)localObject2).postScale(f, f);
        localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject2, true);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        a("compress :" + localException.getMessage());
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        a("compress :  scaleBitmap OOM");
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (paramBitmap == null) {
          break;
        }
        localObject2 = localObject1;
        if (paramBitmap.isRecycled()) {
          break;
        }
        localObject2 = localObject1;
        if (paramBitmap.equals(localObject1)) {
          break;
        }
        paramBitmap.recycle();
        return localObject1;
      }
      return paramBitmap;
      localObject1 = null;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < paramInt1 * f2) {
        f1 = i / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    paramBitmap = b(paramBitmap, paramInt1, paramInt2);
    if (paramBitmap != null) {
      return c(paramBitmap, paramFloat, paramInt1, paramInt2);
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        float f = Math.min(paramBitmap.getWidth() / paramInt1, paramBitmap.getHeight() / paramInt2);
        int m = (int)Math.ceil(paramBitmap.getWidth() / f);
        int n = (int)Math.ceil(paramBitmap.getHeight() / f);
        Bitmap localBitmap1;
        if (m == paramInt1)
        {
          localBitmap1 = paramBitmap;
          if (n == paramInt2) {}
        }
        else
        {
          paramBitmap = Bitmap.createScaledBitmap(paramBitmap, m, n, true);
          int i = (m - paramInt1) / 2;
          if (i >= 0) {
            break label460;
          }
          i = 0;
          int k = (n - paramInt2) / 2;
          int j = k;
          if (k < 0) {
            j = 0;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("ImageUtil", 2, "ROUND_CORNER_DECODER scale = " + f + ", scaledWidth = " + m + ", scaledHeight = " + n + ", xTopLeft = " + i + ", yTopLeft = " + j + ", width = " + paramInt1 + ", height = " + paramInt2);
          }
          localBitmap1 = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2);
          paramBitmap.recycle();
        }
        Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
        Canvas localCanvas = new Canvas(localBitmap2);
        Paint localPaint = new Paint();
        Rect localRect1 = new Rect(0, 0, localBitmap1.getWidth(), localBitmap1.getHeight());
        Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
        RectF localRectF = new RectF(localRect2);
        switch (paramInt4)
        {
        case 1: 
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-16777216);
          localCanvas.drawRoundRect(localRectF, paramInt3, paramInt3, localPaint);
          if (paramBitmap != null) {
            localCanvas.drawRect(paramBitmap, localPaint);
          }
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(localBitmap1, localRect1, localRect2, localPaint);
          localBitmap1.recycle();
          return localBitmap2;
        }
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
        if (QLog.isDevelopLevel()) {
          QLog.w("ImageUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", paramBitmap);
        }
        return null;
      }
      label460:
      continue;
      paramBitmap = new Rect(0, paramInt3, paramInt1, paramInt2 + paramInt3);
      continue;
      paramBitmap = new Rect(0, -paramInt3, paramInt1, paramInt2 - paramInt3);
      continue;
      paramBitmap = new Rect(paramInt3, 0, paramInt1 + paramInt3, paramInt2);
      continue;
      paramBitmap = new Rect(-paramInt3, 0, paramInt1 - paramInt3, paramInt2);
      continue;
      paramBitmap = null;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramBitmap == null) || (paramInt1 == 0)) {
      return null;
    }
    for (;;)
    {
      try
      {
        Resources localResources = BaseApplicationImpl.getApplication().getResources();
        Drawable localDrawable = localResources.getDrawable(paramInt1);
        Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
        localBitmap.setDensity(localResources.getDisplayMetrics().densityDpi);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        localCanvas.drawARGB(0, 0, 0, 0);
        Rect localRect2 = new Rect(0, 0, paramInt2, paramInt3);
        localDrawable.setBounds(localRect2);
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
        paramInt1 = aepi.a(55.0F, localResources);
        if ((paramBoolean) && (paramInt3 > paramInt1))
        {
          localPaint.setShader(new LinearGradient(0.0F, paramInt3 - paramInt1, 0.0F, paramInt3, 0, -1728053248, Shader.TileMode.CLAMP));
          localCanvas.drawRect(localRect2, localPaint);
        }
        if ((localDrawable instanceof SkinnableNinePatchDrawable))
        {
          ((SkinnableNinePatchDrawable)localDrawable).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          localDrawable.draw(localCanvas);
          return localBitmap;
        }
        if ((localDrawable instanceof NinePatchDrawable)) {
          ((NinePatchDrawable)localDrawable).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        } else {
          QLog.e("ImageUtil", 1, "invalid drawable resource :" + localDrawable.getClass().getName());
        }
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("ImageUtil", 1, "clip bitmap error:" + paramBitmap.getMessage());
        return null;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, Rect paramRect, int paramInt)
  {
    if (paramBitmap != null) {
      try
      {
        if ((paramRect.left >= 0) && (paramRect.top >= 0) && (paramRect.right <= paramBitmap.getWidth()) && (paramRect.bottom <= paramBitmap.getHeight()))
        {
          Paint localPaint = new Paint();
          Rect localRect = new Rect(0, 0, paramRect.width() / paramInt, paramRect.height() / paramInt);
          RectF localRectF = new RectF(localRect);
          Bitmap localBitmap = Bitmap.createBitmap(localRect.width(), localRect.height(), Bitmap.Config.RGB_565);
          Canvas localCanvas = new Canvas(localBitmap);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-12434878);
          localCanvas.drawRect(localRectF, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, paramRect, localRect, localPaint);
          paramRect = localBitmap;
          if (paramBitmap.isRecycled()) {
            return paramRect;
          }
          paramBitmap.recycle();
          return localBitmap;
        }
      }
      catch (Throwable paramBitmap)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImageUtil", 2, "getClipRectBitmap throw error ... " + paramBitmap.getMessage());
        }
        return null;
      }
    } else {
      paramRect = null;
    }
    return paramRect;
  }
  
  public static Bitmap a(Bitmap paramBitmap, File paramFile)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = new Matrix();
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int k = Math.max(i, j);
      float f = jdField_a_of_type_Int / (k * 1.0F);
      k = b(paramFile.getPath());
      if (f < 1.0F) {}
      try
      {
        ((Matrix)localObject).postScale(f, f);
        if ((k != 0) && (k % 90 == 0)) {
          ((Matrix)localObject).postRotate(k, i / 2.0F, j / 2.0F);
        }
        paramFile = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, true);
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          a("compress : " + paramFile.getMessage());
          paramFile = null;
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        for (;;)
        {
          a("compress :  scaleBitmap OOM");
          paramFile = null;
        }
      }
      localObject = paramBitmap;
    } while (paramFile == null);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!paramBitmap.equals(paramFile))) {
      paramBitmap.recycle();
    }
    return paramFile;
  }
  
  public static Bitmap a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localObject = paramBitmap;
      if (localBitmap == null) {
        break label194;
      }
      localObject = new Canvas(localBitmap);
      if (((Canvas)localObject).getDensity() != paramBitmap.getDensity()) {
        ((Canvas)localObject).setDensity(paramBitmap.getDensity());
      }
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setColor(Color.parseColor("#80000000"));
      RectF localRectF = new RectF(0.0F, 0.0F, i, j);
      if (paramBoolean) {
        ((Canvas)localObject).drawRoundRect(localRectF, i / 2, j / 2, localPaint);
      } else {
        ((Canvas)localObject).drawRect(localRectF, localPaint);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject = paramBitmap;
      if (!QLog.isColorLevel()) {
        break label194;
      }
    }
    QLog.d("ImageUtil", 2, "grey bitmap, oom, stack:" + MsfSdkUtils.getStackTraceString(localOutOfMemoryError));
    return paramBitmap;
    Object localObject = localOutOfMemoryError;
    label194:
    return localObject;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Bitmap localBitmap = null;
    Object localObject;
    if (paramDrawable == null) {
      localObject = localBitmap;
    }
    for (;;)
    {
      return localObject;
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicWidth();
      localObject = localBitmap;
      if (i <= 0) {
        continue;
      }
      localObject = localBitmap;
      if (j <= 0) {
        continue;
      }
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
        {
          localBitmap = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
          localObject = localBitmap;
          if (localBitmap == null) {
            break;
          }
          localObject = new Canvas(localBitmap);
          paramDrawable.setBounds(0, 0, i, j);
          paramDrawable.draw((Canvas)localObject);
          return localBitmap;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable == null) {
      return null;
    }
    int m = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    if ((m <= 0) || (k <= 0)) {
      return null;
    }
    int j = k;
    int i = m;
    float f1;
    float f2;
    if (paramInt1 > 0)
    {
      j = k;
      i = m;
      if (paramInt2 > 0)
      {
        f1 = paramInt1 / m;
        f2 = paramInt2 / k;
        if (f1 >= f2) {
          break label165;
        }
      }
    }
    for (;;)
    {
      j = k;
      i = m;
      if (f1 < 1.0F)
      {
        i = (int)(m * f1);
        j = (int)(k * f1);
      }
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
        {
          localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
          if (localObject != null)
          {
            Canvas localCanvas = new Canvas((Bitmap)localObject);
            paramDrawable.setBounds(0, 0, i, j);
            paramDrawable.draw(localCanvas);
          }
          return localObject;
          label165:
          f1 = f2;
          break;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: aload_0
    //   8: ifnull +143 -> 151
    //   11: new 15	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 18	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore 7
    //   20: aload 7
    //   22: iconst_1
    //   23: putfield 22	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   26: new 341	java/io/BufferedInputStream
    //   29: dup
    //   30: new 693	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 695	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   38: invokespecial 350	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: astore 5
    //   43: aload 5
    //   45: aconst_null
    //   46: aload 7
    //   48: invokestatic 28	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   51: pop
    //   52: aload 7
    //   54: getfield 31	android/graphics/BitmapFactory$Options:outWidth	I
    //   57: istore_3
    //   58: aload 7
    //   60: getfield 34	android/graphics/BitmapFactory$Options:outHeight	I
    //   63: istore 4
    //   65: new 15	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 18	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 7
    //   74: aload 7
    //   76: iload_3
    //   77: iload_1
    //   78: idiv
    //   79: iload 4
    //   81: iload_2
    //   82: idiv
    //   83: invokestatic 494	java/lang/Math:max	(II)I
    //   86: putfield 208	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   89: aload 7
    //   91: iconst_0
    //   92: putfield 22	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   95: aload 7
    //   97: iconst_1
    //   98: putfield 698	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   101: aload 5
    //   103: invokevirtual 361	java/io/InputStream:close	()V
    //   106: new 341	java/io/BufferedInputStream
    //   109: dup
    //   110: new 693	java/io/FileInputStream
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 695	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   118: invokespecial 350	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: astore_0
    //   122: aload_0
    //   123: aconst_null
    //   124: aload 7
    //   126: invokestatic 28	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   129: astore 5
    //   131: aload 5
    //   133: astore 6
    //   135: aload 6
    //   137: astore 5
    //   139: aload_0
    //   140: ifnull +11 -> 151
    //   143: aload_0
    //   144: invokevirtual 361	java/io/InputStream:close	()V
    //   147: aload 6
    //   149: astore 5
    //   151: aload 5
    //   153: areturn
    //   154: astore 5
    //   156: aconst_null
    //   157: astore_0
    //   158: aload 5
    //   160: invokevirtual 489	java/lang/Throwable:printStackTrace	()V
    //   163: aload 6
    //   165: astore 5
    //   167: aload_0
    //   168: ifnull -17 -> 151
    //   171: aload_0
    //   172: invokevirtual 361	java/io/InputStream:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: aconst_null
    //   182: astore 5
    //   184: aload 5
    //   186: ifnull +8 -> 194
    //   189: aload 5
    //   191: invokevirtual 361	java/io/InputStream:close	()V
    //   194: aload_0
    //   195: athrow
    //   196: astore_0
    //   197: aload 6
    //   199: areturn
    //   200: astore 5
    //   202: goto -8 -> 194
    //   205: astore_0
    //   206: goto -22 -> 184
    //   209: astore 6
    //   211: aload_0
    //   212: astore 5
    //   214: aload 6
    //   216: astore_0
    //   217: goto -33 -> 184
    //   220: astore 6
    //   222: aload_0
    //   223: astore 5
    //   225: aload 6
    //   227: astore_0
    //   228: goto -44 -> 184
    //   231: astore 7
    //   233: aload 5
    //   235: astore_0
    //   236: aload 7
    //   238: astore 5
    //   240: goto -82 -> 158
    //   243: astore 5
    //   245: goto -87 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramString	String
    //   0	248	1	paramInt1	int
    //   0	248	2	paramInt2	int
    //   57	22	3	i	int
    //   63	20	4	j	int
    //   5	147	5	localObject1	Object
    //   154	5	5	localThrowable1	Throwable
    //   165	25	5	localObject2	Object
    //   200	1	5	localIOException	IOException
    //   212	27	5	localObject3	Object
    //   243	1	5	localThrowable2	Throwable
    //   1	197	6	localObject4	Object
    //   209	6	6	localObject5	Object
    //   220	6	6	localObject6	Object
    //   18	107	7	localOptions	BitmapFactory.Options
    //   231	6	7	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   11	43	154	java/lang/Throwable
    //   171	175	177	java/io/IOException
    //   11	43	180	finally
    //   143	147	196	java/io/IOException
    //   189	194	200	java/io/IOException
    //   43	122	205	finally
    //   122	131	209	finally
    //   158	163	220	finally
    //   43	122	231	java/lang/Throwable
    //   122	131	243	java/lang/Throwable
  }
  
  /* Error */
  @java.lang.Deprecated
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +52 -> 55
    //   6: aload_1
    //   7: getfield 22	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   10: ifeq +45 -> 55
    //   13: new 341	java/io/BufferedInputStream
    //   16: dup
    //   17: new 693	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 695	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: sipush 2048
    //   28: invokespecial 702	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   31: astore_0
    //   32: aload_0
    //   33: astore_2
    //   34: aload_0
    //   35: aconst_null
    //   36: aload_1
    //   37: invokestatic 703	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload_0
    //   44: ifnull +9 -> 53
    //   47: aload_0
    //   48: invokevirtual 361	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: astore_2
    //   53: aload_2
    //   54: areturn
    //   55: new 341	java/io/BufferedInputStream
    //   58: dup
    //   59: new 693	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 695	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   67: invokespecial 350	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_0
    //   71: goto -39 -> 32
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: astore_2
    //   79: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +15 -> 97
    //   85: aload_0
    //   86: astore_2
    //   87: ldc 251
    //   89: iconst_2
    //   90: ldc_w 705
    //   93: aload_1
    //   94: invokestatic 707	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   97: aload_3
    //   98: astore_2
    //   99: aload_0
    //   100: ifnull -47 -> 53
    //   103: aload_0
    //   104: invokevirtual 361	java/io/InputStream:close	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_0
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 361	java/io/InputStream:close	()V
    //   123: aload_0
    //   124: athrow
    //   125: astore_0
    //   126: aload_1
    //   127: areturn
    //   128: astore_1
    //   129: goto -6 -> 123
    //   132: astore_0
    //   133: goto -18 -> 115
    //   136: astore_1
    //   137: goto -60 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   0	140	1	paramOptions	BitmapFactory.Options
    //   33	87	2	localObject1	Object
    //   1	97	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	32	74	java/lang/Exception
    //   55	71	74	java/lang/Exception
    //   103	107	109	java/io/IOException
    //   6	32	112	finally
    //   55	71	112	finally
    //   47	51	125	java/io/IOException
    //   119	123	128	java/io/IOException
    //   34	41	132	finally
    //   79	85	132	finally
    //   87	97	132	finally
    //   34	41	136	java/lang/Exception
  }
  
  public static Bitmap a(boolean paramBoolean)
  {
    String str;
    if ((!paramBoolean) && (azmk.a())) {
      str = "static://DefaultFace_square";
    }
    for (int i = 2130840086;; i = 2130840085)
    {
      if (BaseApplicationImpl.sImageCache != null) {}
      for (Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str);; localBitmap1 = null)
      {
        Bitmap localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap1 = bdal.b(BaseApplicationImpl.getApplication().getResources(), i);
          if ((localBitmap1 != null) && (BaseApplicationImpl.sImageCache != null)) {
            BaseApplicationImpl.sImageCache.put(str, localBitmap1);
          }
          localBitmap2 = localBitmap1;
          if (QLog.isColorLevel())
          {
            QLog.d("ImageUtil", 2, "getDefaultFaceBitmap, bitmap=" + localBitmap1);
            localBitmap2 = localBitmap1;
          }
        }
        return localBitmap2;
      }
      str = "static://DefaultFace";
    }
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    int m = 1;
    paramOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, paramOptions);
    int i = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int j = 1;
    if ((i > paramInt) || (k > paramInt))
    {
      if (Math.round(Math.max(i, k) / (paramInt * 1.0F)) < 2) {
        break label144;
      }
      k /= 2;
      i /= 2;
      if ((k >= paramInt) || (i >= paramInt)) {
        break label113;
      }
      paramOptions.inSampleSize = j;
    }
    label144:
    for (;;)
    {
      paramOptions.inJustDecodeBounds = false;
      paramInt = m;
      if (paramOptions.inSampleSize >= 1) {
        paramInt = paramOptions.inSampleSize;
      }
      paramOptions.inSampleSize = paramInt;
      return paramOptions;
      label113:
      if ((k == paramInt) || (i == paramInt))
      {
        paramOptions.inSampleSize = (j * 2);
      }
      else
      {
        j *= 2;
        break;
        paramOptions.inSampleSize = j;
      }
    }
  }
  
  private static BitmapFactory.Options a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramFile.getPath(), localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options a(File paramFile, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    double d = a(localFileInputStream, paramInt1, paramInt2);
    localFileInputStream.close();
    localOptions.inSampleSize = ((int)d);
    localOptions.inJustDecodeBounds = true;
    localFileInputStream = new FileInputStream(paramFile);
    SafeBitmapFactory.decodeStream(localFileInputStream, null, localOptions);
    localFileInputStream.close();
    paramInt2 = 0;
    for (;;)
    {
      if (localOptions.outWidth > paramInt1)
      {
        localOptions.inSampleSize += 1;
        localFileInputStream = new FileInputStream(paramFile);
        SafeBitmapFactory.decodeStream(localFileInputStream, null, localOptions);
        localFileInputStream.close();
        if (paramInt2 <= 3) {}
      }
      else
      {
        localOptions.inJustDecodeBounds = false;
        return localOptions;
      }
      paramInt2 += 1;
    }
  }
  
  public static BitmapFactory.Options a(String paramString, int paramInt)
  {
    int m = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outHeight;
    int k = localOptions.outWidth;
    a("compressAIOThumbImg  org width:" + k + ",height:" + i);
    int j = 1;
    if ((i > paramInt) && (k > paramInt))
    {
      if (Math.min(Math.round(i / paramInt), Math.round(k / paramInt)) < 2) {
        break label198;
      }
      k /= 2;
      i /= 2;
      if ((k >= paramInt) && (i >= paramInt)) {
        break label169;
      }
      localOptions.inSampleSize = j;
    }
    for (;;)
    {
      localOptions.inJustDecodeBounds = false;
      paramInt = m;
      if (localOptions.inSampleSize >= 1) {
        paramInt = localOptions.inSampleSize;
      }
      localOptions.inSampleSize = paramInt;
      return localOptions;
      label169:
      if ((k == paramInt) || (i == paramInt))
      {
        localOptions.inSampleSize = (j * 2);
      }
      else
      {
        j *= 2;
        break;
        label198:
        localOptions.inSampleSize = j;
      }
    }
  }
  
  public static Rect a(Rect paramRect, int paramInt, float paramFloat)
  {
    if ((paramRect != null) && (paramInt > 0) && (paramFloat > 0.0F))
    {
      int k = (int)(paramInt * paramFloat);
      int i = paramRect.width();
      int j = paramRect.width();
      if (i > j) {}
      for (paramInt = i; paramInt < k; paramInt = j)
      {
        paramRect = new Rect();
        a(paramRect, i, j, k);
        return paramRect;
      }
    }
    return null;
  }
  
  public static Rect a(Drawable paramDrawable, int paramInt1, int paramInt2, float paramFloat)
  {
    Rect localRect = new Rect();
    int j;
    int k;
    if ((paramDrawable != null) && (paramInt2 > 0) && (paramInt1 > 0) && (paramInt2 > paramInt1) && (paramFloat > 0.0F))
    {
      j = paramDrawable.getIntrinsicWidth();
      k = paramDrawable.getIntrinsicHeight();
      if (j <= k) {
        break label78;
      }
    }
    label78:
    for (int i = j; i < paramInt1; i = k)
    {
      a(localRect, j, k, (int)(paramInt1 * paramFloat));
      return localRect;
    }
    if ((i >= paramInt1) && (i < paramInt2))
    {
      localRect.set(0, 0, (int)(j * paramFloat), (int)(k * paramFloat));
      return localRect;
    }
    a(localRect, j, k, (int)(paramInt2 * paramFloat));
    return localRect;
  }
  
  public static Drawable a()
  {
    return new BitmapDrawable(c());
  }
  
  public static Drawable a(int paramInt)
  {
    return new BitmapDrawable(a(paramInt));
  }
  
  public static Drawable a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {}
    for (paramDrawable = ((SkinnableBitmapDrawable)paramDrawable).mutate2();; paramDrawable = paramDrawable.getConstantState().newDrawable().mutate())
    {
      paramDrawable.setColorFilter(new LightingColorFilter(0, paramInt));
      return paramDrawable;
    }
  }
  
  public static Drawable a(boolean paramBoolean)
  {
    return new BitmapDrawable(a(paramBoolean));
  }
  
  public static StateListDrawable a(int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getResources().getDrawable(paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Object localObject;
    if (Build.VERSION.SDK_INT <= 19)
    {
      paramInt = paramContext.getIntrinsicWidth();
      int i = paramContext.getIntrinsicHeight();
      localObject = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramContext.setAlpha(102);
      paramContext.setBounds(0, 0, paramInt, i);
      paramContext.draw(localCanvas);
      localObject = new BitmapDrawable((Bitmap)localObject);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
    }
    for (;;)
    {
      localStateListDrawable.addState(new int[0], paramContext);
      return localStateListDrawable;
      localObject = paramContext.getConstantState().newDrawable();
      ((Drawable)localObject).mutate().setAlpha(102);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
    }
  }
  
  public static File a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    File localFile = new File(paramString);
    try
    {
      if (!localFile.exists())
      {
        int i = paramString.lastIndexOf('/');
        if ((i > 0) && (i < paramString.length() - 1))
        {
          paramString = new File(paramString.substring(0, i));
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
        }
      }
      for (;;)
      {
        localFile.createNewFile();
        return localFile;
        localFile.delete();
      }
      return null;
    }
    catch (IOException paramString) {}
  }
  
  public static String a(double paramDouble)
  {
    int m = (int)paramDouble;
    paramDouble = paramDouble % 1.0D * 60.0D;
    int j = (int)paramDouble;
    int i = j;
    if (j < 0) {
      i = j * -1;
    }
    int k = (int)(paramDouble % 1.0D * 60.0D);
    j = k;
    if (k < 0) {
      j = k * -1;
    }
    return String.valueOf(m) + "/1," + String.valueOf(i) + "/1," + String.valueOf(j) + "/1";
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    Object localObject = alof.aX + "thumb/";
    if (paramUri == null) {
      paramContext = "";
    }
    do
    {
      do
      {
        return paramContext;
        paramUri = b(paramContext, paramUri);
        paramContext = paramUri;
      } while (paramUri.startsWith((String)localObject));
      paramContext = paramUri.substring(paramUri.lastIndexOf("/") + 1);
      paramUri = (String)localObject + paramUri.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramContext = paramUri;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramUri;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      paramContext = "";
    }
    Object localObject;
    do
    {
      do
      {
        return paramContext;
        localObject = alof.aX + "thumb/";
        paramContext = paramString;
      } while (paramString.startsWith((String)localObject));
      paramContext = paramString.substring(paramString.lastIndexOf("/") + 1);
      paramString = (String)localObject + paramString.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramContext = paramString;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramString;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext, paramString, paramInt, 0);
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramString == null) {
      return "";
    }
    Object localObject = new File(paramString);
    long l = 0L;
    if (((File)localObject).exists()) {
      l = ((File)localObject).lastModified();
    }
    localObject = paramString.substring(paramString.lastIndexOf("/") + 1);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(alof.aX).append("photo/");
    if (bdin.a(paramContext)) {
      localStringBuffer.append("WIFI");
    }
    if ((paramInt1 == 1) || (paramInt1 == 1001) || (paramInt1 == 10002) || (paramInt1 == 3000))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label193;
      }
    }
    label193:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localStringBuffer.append(paramInt1);
      localStringBuffer.append("s").append(paramInt2);
      localStringBuffer.append((paramString + l).hashCode()).append((String)localObject);
      return localStringBuffer.toString();
      paramInt1 = 0;
      break;
    }
  }
  
  public static String a(FileInputStream paramFileInputStream)
  {
    Object localObject = new byte[8];
    try
    {
      paramFileInputStream.read((byte[])localObject, 0, localObject.length);
      localObject = bdhe.a((byte[])localObject).toUpperCase();
      if (((String)localObject).contains("FFD8FF"))
      {
        paramFileInputStream = "jpg";
        return paramFileInputStream;
      }
    }
    catch (IOException paramFileInputStream)
    {
      do
      {
        for (;;)
        {
          paramFileInputStream.printStackTrace();
        }
        if (((String)localObject).contains("89504E470D0A1A0A")) {
          return "png";
        }
        if (((String)localObject).contains("47494638")) {
          return "gif";
        }
        if (((String)localObject).contains("49492A00")) {
          return "tif";
        }
        if (((String)localObject).contains("424D")) {
          return "bmp";
        }
        if (((String)localObject).contains("0A")) {
          return "pcx";
        }
        if ((((String)localObject).contains("4D4D")) || (((String)localObject).contains("4949"))) {
          return "tiff";
        }
        if (((String)localObject).contains("464F524D")) {
          return "iff";
        }
        if (((String)localObject).contains("52494646")) {
          return "ani";
        }
        if (((String)localObject).contains("0000020000")) {
          return "tga";
        }
        if (((String)localObject).contains("0000100000")) {
          return "rle";
        }
        if (((String)localObject).contains("0000010001002020")) {
          return "ico";
        }
        paramFileInputStream = (FileInputStream)localObject;
      } while (!((String)localObject).contains("0000020001002020"));
    }
    return "cur";
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 289	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   4: putfield 960	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   7: aload_0
    //   8: aconst_null
    //   9: aload_1
    //   10: invokestatic 28	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_2
    //   23: invokestatic 962	bdhj:a	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_3
    //   27: new 964	java/io/BufferedOutputStream
    //   30: dup
    //   31: new 966	java/io/FileOutputStream
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: invokespecial 970	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   42: astore_0
    //   43: aload 4
    //   45: getstatic 976	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   48: bipush 100
    //   50: aload_0
    //   51: invokevirtual 980	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   54: pop
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 983	java/io/OutputStream:close	()V
    //   63: aload 4
    //   65: ifnull +16 -> 81
    //   68: aload 4
    //   70: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   73: ifne +8 -> 81
    //   76: aload 4
    //   78: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   81: aload_2
    //   82: astore_0
    //   83: aload_2
    //   84: ifnonnull +25 -> 109
    //   87: aload_2
    //   88: astore_0
    //   89: aload_3
    //   90: ifnull +19 -> 109
    //   93: aload_2
    //   94: astore_0
    //   95: aload_3
    //   96: invokevirtual 801	java/io/File:exists	()Z
    //   99: ifeq +10 -> 109
    //   102: aload_3
    //   103: invokevirtual 820	java/io/File:delete	()Z
    //   106: pop
    //   107: aload_2
    //   108: astore_0
    //   109: aload_0
    //   110: areturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 983	java/io/OutputStream:close	()V
    //   122: aload 4
    //   124: ifnull +16 -> 140
    //   127: aload 4
    //   129: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   132: ifne +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   140: iconst_0
    //   141: ifne +157 -> 298
    //   144: aload_3
    //   145: ifnull +153 -> 298
    //   148: aload_3
    //   149: invokevirtual 801	java/io/File:exists	()Z
    //   152: ifeq +146 -> 298
    //   155: aload_3
    //   156: invokevirtual 820	java/io/File:delete	()Z
    //   159: pop
    //   160: aconst_null
    //   161: astore_0
    //   162: goto -53 -> 109
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 983	java/io/OutputStream:close	()V
    //   176: aload 4
    //   178: ifnull +16 -> 194
    //   181: aload 4
    //   183: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   186: ifne +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   194: iconst_0
    //   195: ifne +103 -> 298
    //   198: aload_3
    //   199: ifnull +99 -> 298
    //   202: aload_3
    //   203: invokevirtual 801	java/io/File:exists	()Z
    //   206: ifeq +92 -> 298
    //   209: aload_3
    //   210: invokevirtual 820	java/io/File:delete	()Z
    //   213: pop
    //   214: aconst_null
    //   215: astore_0
    //   216: goto -107 -> 109
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_0
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 983	java/io/OutputStream:close	()V
    //   230: aload 4
    //   232: ifnull +16 -> 248
    //   235: aload 4
    //   237: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   240: ifne +8 -> 248
    //   243: aload 4
    //   245: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   248: aload_2
    //   249: ifnonnull +19 -> 268
    //   252: aload_3
    //   253: ifnull +15 -> 268
    //   256: aload_3
    //   257: invokevirtual 801	java/io/File:exists	()Z
    //   260: ifeq +8 -> 268
    //   263: aload_3
    //   264: invokevirtual 820	java/io/File:delete	()Z
    //   267: pop
    //   268: aload_1
    //   269: athrow
    //   270: astore_0
    //   271: goto -208 -> 63
    //   274: astore_0
    //   275: goto -153 -> 122
    //   278: astore_0
    //   279: goto -103 -> 176
    //   282: astore_0
    //   283: goto -53 -> 230
    //   286: astore_1
    //   287: goto -65 -> 222
    //   290: astore_1
    //   291: goto -123 -> 168
    //   294: astore_1
    //   295: goto -181 -> 114
    //   298: aconst_null
    //   299: astore_0
    //   300: goto -191 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramInputStream	InputStream
    //   0	303	1	paramOptions	BitmapFactory.Options
    //   0	303	2	paramString	String
    //   26	238	3	localFile	File
    //   13	231	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   27	43	111	java/lang/Exception
    //   27	43	165	java/lang/OutOfMemoryError
    //   27	43	219	finally
    //   59	63	270	java/io/IOException
    //   118	122	274	java/io/IOException
    //   172	176	278	java/io/IOException
    //   226	230	282	java/io/IOException
    //   43	55	286	finally
    //   43	55	290	java/lang/OutOfMemoryError
    //   43	55	294	java/lang/Exception
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: aload_1
    //   3: invokestatic 28	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +45 -> 61
    //   19: ldc 251
    //   21: iconst_2
    //   22: new 49	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 986
    //   32: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 270	android/graphics/Bitmap:getWidth	()I
    //   39: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc_w 988
    //   45: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 279	android/graphics/Bitmap:getHeight	()I
    //   52: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 990	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_2
    //   62: invokestatic 962	bdhj:a	(Ljava/lang/String;)Ljava/io/File;
    //   65: astore_1
    //   66: new 966	java/io/FileOutputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: aload_0
    //   76: getstatic 993	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   79: bipush 100
    //   81: iload_3
    //   82: invokestatic 737	java/lang/Math:min	(II)I
    //   85: aload_1
    //   86: invokevirtual 980	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   89: pop
    //   90: aload_2
    //   91: astore_0
    //   92: aload_1
    //   93: ifnull +9 -> 102
    //   96: aload_1
    //   97: invokevirtual 983	java/io/OutputStream:close	()V
    //   100: aload_2
    //   101: astore_0
    //   102: aload_0
    //   103: areturn
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +49 -> 157
    //   111: aload_1
    //   112: invokevirtual 983	java/io/OutputStream:close	()V
    //   115: aconst_null
    //   116: astore_0
    //   117: goto -15 -> 102
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -21 -> 102
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 983	java/io/OutputStream:close	()V
    //   137: aload_0
    //   138: athrow
    //   139: astore_0
    //   140: aload_2
    //   141: astore_0
    //   142: goto -40 -> 102
    //   145: astore_1
    //   146: goto -9 -> 137
    //   149: astore_0
    //   150: goto -21 -> 129
    //   153: astore_0
    //   154: goto -47 -> 107
    //   157: aconst_null
    //   158: astore_0
    //   159: goto -57 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramInputStream	InputStream
    //   0	162	1	paramOptions	BitmapFactory.Options
    //   0	162	2	paramString	String
    //   0	162	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   66	75	104	java/lang/Exception
    //   111	115	120	java/io/IOException
    //   66	75	126	finally
    //   96	100	139	java/io/IOException
    //   133	137	145	java/io/IOException
    //   75	90	149	finally
    //   75	90	153	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 194	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 798	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: iload_2
    //   14: iload_3
    //   15: invokestatic 998	bdhj:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   18: astore 6
    //   20: new 693	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 728	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: aload 6
    //   32: aload_1
    //   33: bipush 100
    //   35: iload 4
    //   37: invokestatic 737	java/lang/Math:min	(II)I
    //   40: invokestatic 1000	bdhj:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: astore 5
    //   47: aload 5
    //   49: astore_1
    //   50: aload_0
    //   51: ifnull +10 -> 61
    //   54: aload_0
    //   55: invokevirtual 361	java/io/InputStream:close	()V
    //   58: aload 5
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: aload 5
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull -9 -> 61
    //   73: aload_0
    //   74: invokevirtual 361	java/io/InputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_0
    //   85: aload 5
    //   87: astore_1
    //   88: aload_0
    //   89: ifnull -28 -> 61
    //   92: aload_0
    //   93: invokevirtual 361	java/io/InputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 361	java/io/InputStream:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: astore_0
    //   115: aload 5
    //   117: areturn
    //   118: astore_0
    //   119: goto -7 -> 112
    //   122: astore_1
    //   123: goto -19 -> 104
    //   126: astore_1
    //   127: goto -42 -> 85
    //   130: astore_1
    //   131: goto -65 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString1	String
    //   0	134	1	paramString2	String
    //   0	134	2	paramInt1	int
    //   0	134	3	paramInt2	int
    //   0	134	4	paramInt3	int
    //   1	115	5	str	String
    //   18	13	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   3	29	63	java/lang/Exception
    //   73	77	79	java/io/IOException
    //   3	29	82	java/lang/Error
    //   92	96	98	java/io/IOException
    //   3	29	101	finally
    //   54	58	114	java/io/IOException
    //   108	112	118	java/io/IOException
    //   29	44	122	finally
    //   29	44	126	java/lang/Error
    //   29	44	130	java/lang/Exception
  }
  
  private static void a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean, String paramString)
  {
    a(paramInt1, paramInt2, paramContext, paramBoolean, null, paramString);
  }
  
  private static void a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 7) || (paramInt2 < 0) || (paramInt2 > 9)) {
      return;
    }
    String str2 = null;
    String str1 = str2;
    if (paramContext != null) {
      str1 = str2;
    }
    try
    {
      if ((paramContext instanceof BaseActivity)) {
        str1 = ((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getCurrentAccountUin();
      }
      localHashMap = new HashMap();
      if (paramBoolean) {
        break label231;
      }
      String str3 = String.valueOf(paramInt2 * 10 + paramInt1 + 88100);
      localHashMap.put("param_FailCode", str3);
      str2 = paramString2;
      if (paramString2 == null) {
        str2 = baqo.a(new RuntimeException(str3));
      }
      if (!(paramContext instanceof Activity)) {
        break label213;
      }
      paramContext = ((Activity)paramContext).getCallingActivity();
      if (paramContext == null) {
        break label213;
      }
      localHashMap.put("param_callingActivity", paramContext.getClassName());
    }
    catch (Exception paramContext)
    {
      HashMap localHashMap;
      return;
    }
    localHashMap.put("param_sdCardSize", Long.toString(bdeu.b()));
    label170:
    localHashMap.put("param_failMsg", str2);
    for (;;)
    {
      label184:
      azri.a(BaseApplication.getContext()).a(str1, paramContext, paramBoolean, 0L, 0L, localHashMap, "");
      return;
      label213:
      label231:
      do
      {
        paramContext = paramString1;
        break label184;
        if ((paramInt2 == 9) || (paramInt2 == 0)) {
          break;
        }
        if (paramInt2 != 5) {
          break label170;
        }
        break;
      } while (paramString1 != null);
      paramContext = "report_sendphoto_file_error";
    }
  }
  
  /* Error */
  private static void a(int paramInt1, Context paramContext, File paramFile1, File paramFile2, ImageInfo paramImageInfo, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc_w 1063
    //   5: new 49	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 1065
    //   15: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload 7
    //   20: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 1067
    //   26: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   40: iload 8
    //   42: ifeq +103 -> 145
    //   45: aload_1
    //   46: invokestatic 873	bdin:a	(Landroid/content/Context;)Z
    //   49: ifeq +89 -> 138
    //   52: bipush 80
    //   54: istore 6
    //   56: iconst_0
    //   57: istore 7
    //   59: aload 4
    //   61: getfield 249	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Int	I
    //   64: ifne +8 -> 72
    //   67: sipush 960
    //   70: istore 7
    //   72: aconst_null
    //   73: astore 14
    //   75: aconst_null
    //   76: astore 13
    //   78: iload_0
    //   79: aload_1
    //   80: aload_2
    //   81: iload 7
    //   83: aload 4
    //   85: invokestatic 1072	bdhj:a	(ILandroid/content/Context;Ljava/io/File;ILcom/tencent/mobileqq/activity/photo/ImageInfo;)Landroid/graphics/Bitmap;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnonnull +62 -> 152
    //   93: aload 4
    //   95: iconst_0
    //   96: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   99: aload_3
    //   100: invokevirtual 820	java/io/File:delete	()Z
    //   103: pop
    //   104: ldc_w 1076
    //   107: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   110: iconst_0
    //   111: ifeq +11 -> 122
    //   114: new 1078	java/lang/NullPointerException
    //   117: dup
    //   118: invokespecial 1079	java/lang/NullPointerException:<init>	()V
    //   121: athrow
    //   122: aload_1
    //   123: ifnull +14 -> 137
    //   126: aload_1
    //   127: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   130: ifne +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   137: return
    //   138: bipush 70
    //   140: istore 6
    //   142: goto -86 -> 56
    //   145: bipush 80
    //   147: istore 6
    //   149: goto -93 -> 56
    //   152: aload 4
    //   154: iconst_1
    //   155: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   158: iload 9
    //   160: ifne +102 -> 262
    //   163: aload_1
    //   164: invokevirtual 270	android/graphics/Bitmap:getWidth	()I
    //   167: istore 10
    //   169: aload_1
    //   170: invokevirtual 279	android/graphics/Bitmap:getHeight	()I
    //   173: istore_0
    //   174: iload 10
    //   176: iload 7
    //   178: if_icmpgt +12 -> 190
    //   181: aload_1
    //   182: astore 13
    //   184: iload_0
    //   185: iload 7
    //   187: if_icmple +11 -> 198
    //   190: aload_1
    //   191: iload 7
    //   193: invokestatic 1081	bdhj:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   196: astore 13
    //   198: aload 13
    //   200: astore_1
    //   201: aload_1
    //   202: ifnonnull +73 -> 275
    //   205: aload_1
    //   206: astore 13
    //   208: aload_1
    //   209: astore 14
    //   211: aload 4
    //   213: ldc_w 1063
    //   216: ldc_w 1083
    //   219: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_1
    //   223: astore 13
    //   225: aload_1
    //   226: astore 14
    //   228: aload 4
    //   230: iconst_1
    //   231: putfield 1086	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   234: iconst_0
    //   235: ifeq +11 -> 246
    //   238: new 1078	java/lang/NullPointerException
    //   241: dup
    //   242: invokespecial 1079	java/lang/NullPointerException:<init>	()V
    //   245: athrow
    //   246: aload_1
    //   247: ifnull -110 -> 137
    //   250: aload_1
    //   251: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   254: ifne -117 -> 137
    //   257: aload_1
    //   258: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   261: return
    //   262: aload_1
    //   263: aload_2
    //   264: invokestatic 1088	bdhj:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Landroid/graphics/Bitmap;
    //   267: astore 13
    //   269: aload 13
    //   271: astore_1
    //   272: goto -71 -> 201
    //   275: new 966	java/io/FileOutputStream
    //   278: dup
    //   279: aload_3
    //   280: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   283: astore 16
    //   285: aload 16
    //   287: astore 13
    //   289: aload 4
    //   291: aload_1
    //   292: getstatic 993	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   295: iload 6
    //   297: aload 16
    //   299: invokevirtual 980	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   302: putfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   305: aload 16
    //   307: astore 13
    //   309: aload 4
    //   311: iconst_1
    //   312: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   315: aload 16
    //   317: astore 13
    //   319: aload 4
    //   321: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   324: ifeq +12 -> 336
    //   327: aload 16
    //   329: astore 13
    //   331: aload 16
    //   333: invokestatic 1097	bdhj:a	(Ljava/io/FileOutputStream;)V
    //   336: aload 16
    //   338: astore 13
    //   340: new 49	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 1099
    //   350: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 4
    //   355: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   358: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   361: ldc_w 1104
    //   364: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_3
    //   368: invokevirtual 1106	java/io/File:length	()J
    //   371: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   380: aload 16
    //   382: astore 13
    //   384: aload 16
    //   386: ifnull +26 -> 412
    //   389: aload 16
    //   391: astore 15
    //   393: aload_1
    //   394: astore 21
    //   396: aload 16
    //   398: astore 14
    //   400: aload_1
    //   401: astore 18
    //   403: aload 16
    //   405: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   408: aload 16
    //   410: astore 13
    //   412: iload 5
    //   414: iconst_1
    //   415: if_icmpeq +34 -> 449
    //   418: iload 5
    //   420: sipush 1001
    //   423: if_icmpeq +26 -> 449
    //   426: iload 5
    //   428: sipush 10002
    //   431: if_icmpeq +18 -> 449
    //   434: aload 13
    //   436: astore 19
    //   438: aload_1
    //   439: astore 20
    //   441: iload 5
    //   443: sipush 3000
    //   446: if_icmpne +844 -> 1290
    //   449: iload 5
    //   451: sipush 1001
    //   454: if_icmpeq +11 -> 465
    //   457: iload 5
    //   459: sipush 10002
    //   462: if_icmpne +574 -> 1036
    //   465: aload 13
    //   467: astore 15
    //   469: aload_1
    //   470: astore 21
    //   472: aload 13
    //   474: astore 14
    //   476: aload_1
    //   477: astore 18
    //   479: getstatic 1110	com/tencent/common/config/AppSetting:jdField_c_of_type_Int	I
    //   482: i2l
    //   483: lstore 11
    //   485: lload 11
    //   487: l2i
    //   488: istore 10
    //   490: aload 13
    //   492: astore 15
    //   494: aload_1
    //   495: astore 21
    //   497: aload 13
    //   499: astore 14
    //   501: aload_1
    //   502: astore 18
    //   504: new 49	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 1112
    //   514: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: iload 10
    //   519: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   528: aload 13
    //   530: astore 15
    //   532: aload_1
    //   533: astore 21
    //   535: aload 13
    //   537: astore 14
    //   539: aload_1
    //   540: astore 18
    //   542: new 49	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 1114
    //   552: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_3
    //   556: invokevirtual 1106	java/io/File:length	()J
    //   559: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   562: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   568: aload 13
    //   570: astore 17
    //   572: aload_1
    //   573: astore 16
    //   575: aload_3
    //   576: invokevirtual 1106	java/io/File:length	()J
    //   579: iload 10
    //   581: i2l
    //   582: lcmp
    //   583: ifle +607 -> 1190
    //   586: aload 13
    //   588: astore 17
    //   590: aload_1
    //   591: astore 16
    //   593: aload_2
    //   594: invokestatic 1120	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   597: ifne +593 -> 1190
    //   600: aload 4
    //   602: ldc_w 1063
    //   605: ldc_w 1122
    //   608: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   611: aload 13
    //   613: astore 17
    //   615: aload_1
    //   616: astore 16
    //   618: aload_3
    //   619: invokevirtual 820	java/io/File:delete	()Z
    //   622: ifeq +568 -> 1190
    //   625: aload_3
    //   626: invokevirtual 817	java/io/File:createNewFile	()Z
    //   629: istore 8
    //   631: aload 13
    //   633: astore 17
    //   635: aload_1
    //   636: astore 16
    //   638: iload 8
    //   640: ifeq +550 -> 1190
    //   643: iconst_1
    //   644: istore 5
    //   646: iload 7
    //   648: istore_0
    //   649: iload 5
    //   651: iconst_1
    //   652: iadd
    //   653: istore 7
    //   655: iload 5
    //   657: iconst_4
    //   658: if_icmpge +502 -> 1160
    //   661: aload_1
    //   662: astore 14
    //   664: aload_1
    //   665: astore 15
    //   667: aload_3
    //   668: invokevirtual 1106	java/io/File:length	()J
    //   671: iload 10
    //   673: i2l
    //   674: lcmp
    //   675: ifle +485 -> 1160
    //   678: aload_1
    //   679: astore 14
    //   681: aload_1
    //   682: astore 15
    //   684: new 49	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   691: ldc_w 1124
    //   694: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: iload 7
    //   699: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   702: ldc_w 1126
    //   705: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload_3
    //   709: invokevirtual 1106	java/io/File:length	()J
    //   712: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   715: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   721: iload_0
    //   722: iconst_1
    //   723: ishr
    //   724: istore_0
    //   725: iload_0
    //   726: ifne +1055 -> 1781
    //   729: iconst_1
    //   730: istore_0
    //   731: aload_1
    //   732: astore 14
    //   734: aload_1
    //   735: astore 15
    //   737: aload_1
    //   738: iload_0
    //   739: invokestatic 1081	bdhj:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   742: astore_1
    //   743: aload_1
    //   744: ifnonnull +364 -> 1108
    //   747: aload_1
    //   748: astore 14
    //   750: aload_1
    //   751: astore 15
    //   753: aload 4
    //   755: iconst_1
    //   756: putfield 1086	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   759: aload 13
    //   761: ifnull +21 -> 782
    //   764: aload_1
    //   765: astore 16
    //   767: aload 13
    //   769: astore 15
    //   771: aload_1
    //   772: astore_3
    //   773: aload 13
    //   775: astore 14
    //   777: aload 13
    //   779: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   782: aload_1
    //   783: ifnull +40 -> 823
    //   786: aload_1
    //   787: astore 16
    //   789: aload 13
    //   791: astore 15
    //   793: aload_1
    //   794: astore_3
    //   795: aload 13
    //   797: astore 14
    //   799: aload_1
    //   800: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   803: ifne +20 -> 823
    //   806: aload_1
    //   807: astore 16
    //   809: aload 13
    //   811: astore 15
    //   813: aload_1
    //   814: astore_3
    //   815: aload 13
    //   817: astore 14
    //   819: aload_1
    //   820: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   823: aload 13
    //   825: ifnull +8 -> 833
    //   828: aload 13
    //   830: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   833: aload_1
    //   834: ifnull -697 -> 137
    //   837: aload_1
    //   838: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   841: ifne -704 -> 137
    //   844: aload_1
    //   845: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   848: return
    //   849: astore 13
    //   851: aconst_null
    //   852: astore 16
    //   854: aload 16
    //   856: astore 13
    //   858: aload 4
    //   860: iconst_0
    //   861: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   864: aload 16
    //   866: astore 13
    //   868: aload 4
    //   870: invokestatic 1127	bdhj:a	()Z
    //   873: putfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   876: aload 16
    //   878: astore 13
    //   880: ldc_w 1132
    //   883: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   886: aload 16
    //   888: astore 13
    //   890: aload 16
    //   892: ifnull -480 -> 412
    //   895: aload 16
    //   897: astore 15
    //   899: aload_1
    //   900: astore 21
    //   902: aload 16
    //   904: astore 14
    //   906: aload_1
    //   907: astore 18
    //   909: aload 16
    //   911: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   914: aload 16
    //   916: astore 13
    //   918: goto -506 -> 412
    //   921: astore 13
    //   923: aload 16
    //   925: astore 13
    //   927: goto -515 -> 412
    //   930: astore_3
    //   931: aconst_null
    //   932: astore_2
    //   933: aload_2
    //   934: ifnull +19 -> 953
    //   937: aload_2
    //   938: astore 15
    //   940: aload_1
    //   941: astore 21
    //   943: aload_2
    //   944: astore 14
    //   946: aload_1
    //   947: astore 18
    //   949: aload_2
    //   950: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   953: aload_2
    //   954: astore 15
    //   956: aload_1
    //   957: astore 21
    //   959: aload_2
    //   960: astore 14
    //   962: aload_1
    //   963: astore 18
    //   965: aload_3
    //   966: athrow
    //   967: astore_1
    //   968: aload 21
    //   970: astore_1
    //   971: aload 15
    //   973: astore 14
    //   975: aload_1
    //   976: astore 18
    //   978: aload 4
    //   980: iconst_0
    //   981: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   984: aload 15
    //   986: astore 14
    //   988: aload_1
    //   989: astore 18
    //   991: aload 4
    //   993: iconst_1
    //   994: putfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   997: aload 15
    //   999: astore 14
    //   1001: aload_1
    //   1002: astore 18
    //   1004: ldc_w 1134
    //   1007: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1010: aload 15
    //   1012: ifnull +8 -> 1020
    //   1015: aload 15
    //   1017: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   1020: aload_1
    //   1021: ifnull -884 -> 137
    //   1024: aload_1
    //   1025: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   1028: ifne -891 -> 137
    //   1031: aload_1
    //   1032: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   1035: return
    //   1036: aload 13
    //   1038: astore 15
    //   1040: aload_1
    //   1041: astore 21
    //   1043: aload 13
    //   1045: astore 14
    //   1047: aload_1
    //   1048: astore 18
    //   1050: invokestatic 1137	bazm:b	()J
    //   1053: lstore 11
    //   1055: goto -570 -> 485
    //   1058: astore_2
    //   1059: aload_1
    //   1060: astore 16
    //   1062: aload 13
    //   1064: astore 15
    //   1066: aload_1
    //   1067: astore_3
    //   1068: aload 13
    //   1070: astore 14
    //   1072: new 49	java/lang/StringBuilder
    //   1075: dup
    //   1076: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1079: ldc_w 1139
    //   1082: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: aload_2
    //   1086: invokevirtual 1140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1089: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1098: goto -316 -> 782
    //   1101: astore_1
    //   1102: aload 16
    //   1104: astore_1
    //   1105: goto -134 -> 971
    //   1108: aload_1
    //   1109: astore 14
    //   1111: aload_1
    //   1112: astore 15
    //   1114: new 966	java/io/FileOutputStream
    //   1117: dup
    //   1118: aload_3
    //   1119: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1122: astore_2
    //   1123: aload 4
    //   1125: aload_1
    //   1126: getstatic 993	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1129: iload 6
    //   1131: aload_2
    //   1132: invokevirtual 980	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1135: putfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1138: aload 4
    //   1140: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1143: ifeq +628 -> 1771
    //   1146: aload_2
    //   1147: invokestatic 1097	bdhj:a	(Ljava/io/FileOutputStream;)V
    //   1150: iload 7
    //   1152: istore 5
    //   1154: aload_2
    //   1155: astore 13
    //   1157: goto -508 -> 649
    //   1160: iload 7
    //   1162: iconst_4
    //   1163: if_icmplt +20 -> 1183
    //   1166: aload_1
    //   1167: astore 14
    //   1169: aload_1
    //   1170: astore 15
    //   1172: aload 4
    //   1174: ldc_w 1063
    //   1177: ldc_w 1142
    //   1180: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1183: aload_1
    //   1184: astore 16
    //   1186: aload 13
    //   1188: astore 17
    //   1190: aload 17
    //   1192: ifnull +24 -> 1216
    //   1195: aload 17
    //   1197: astore 15
    //   1199: aload 16
    //   1201: astore 21
    //   1203: aload 17
    //   1205: astore 14
    //   1207: aload 16
    //   1209: astore 18
    //   1211: aload 17
    //   1213: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   1216: aload 17
    //   1218: astore 19
    //   1220: aload 16
    //   1222: astore 20
    //   1224: aload 16
    //   1226: ifnull +64 -> 1290
    //   1229: aload 17
    //   1231: astore 15
    //   1233: aload 16
    //   1235: astore 21
    //   1237: aload 17
    //   1239: astore 19
    //   1241: aload 16
    //   1243: astore 20
    //   1245: aload 17
    //   1247: astore 14
    //   1249: aload 16
    //   1251: astore 18
    //   1253: aload 16
    //   1255: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   1258: ifne +32 -> 1290
    //   1261: aload 17
    //   1263: astore 15
    //   1265: aload 16
    //   1267: astore 21
    //   1269: aload 17
    //   1271: astore 14
    //   1273: aload 16
    //   1275: astore 18
    //   1277: aload 16
    //   1279: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   1282: aload 16
    //   1284: astore 20
    //   1286: aload 17
    //   1288: astore 19
    //   1290: aload 19
    //   1292: ifnull +8 -> 1300
    //   1295: aload 19
    //   1297: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   1300: aload 20
    //   1302: ifnull -1165 -> 137
    //   1305: aload 20
    //   1307: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   1310: ifne -1173 -> 137
    //   1313: aload 20
    //   1315: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   1318: return
    //   1319: astore_1
    //   1320: aload 17
    //   1322: astore 15
    //   1324: aload 16
    //   1326: astore 21
    //   1328: aload 17
    //   1330: astore 14
    //   1332: aload 16
    //   1334: astore 18
    //   1336: new 49	java/lang/StringBuilder
    //   1339: dup
    //   1340: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1343: ldc_w 1139
    //   1346: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: aload_1
    //   1350: invokevirtual 1140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1353: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1359: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1362: goto -146 -> 1216
    //   1365: astore_1
    //   1366: aload 18
    //   1368: astore_2
    //   1369: aload 14
    //   1371: ifnull +8 -> 1379
    //   1374: aload 14
    //   1376: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   1379: aload_2
    //   1380: ifnull +14 -> 1394
    //   1383: aload_2
    //   1384: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   1387: ifne +7 -> 1394
    //   1390: aload_2
    //   1391: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   1394: aload_1
    //   1395: athrow
    //   1396: astore_2
    //   1397: aload_1
    //   1398: astore_2
    //   1399: aload 13
    //   1401: astore_1
    //   1402: aload 4
    //   1404: iconst_0
    //   1405: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1408: aload 4
    //   1410: invokestatic 1127	bdhj:a	()Z
    //   1413: putfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1416: ldc_w 1144
    //   1419: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1422: aload_1
    //   1423: ifnull +7 -> 1430
    //   1426: aload_1
    //   1427: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   1430: aload_2
    //   1431: ifnull +331 -> 1762
    //   1434: aload_2
    //   1435: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   1438: ifne +324 -> 1762
    //   1441: aload_2
    //   1442: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   1445: aload_1
    //   1446: astore 19
    //   1448: aload_2
    //   1449: astore 20
    //   1451: goto -161 -> 1290
    //   1454: astore_3
    //   1455: new 49	java/lang/StringBuilder
    //   1458: dup
    //   1459: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1462: ldc_w 1139
    //   1465: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: aload_3
    //   1469: invokevirtual 1140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1472: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1478: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1481: goto -51 -> 1430
    //   1484: astore_3
    //   1485: aload_1
    //   1486: astore 15
    //   1488: aload_2
    //   1489: astore_1
    //   1490: goto -519 -> 971
    //   1493: astore_2
    //   1494: aload 13
    //   1496: ifnull +21 -> 1517
    //   1499: aload_1
    //   1500: astore 16
    //   1502: aload 13
    //   1504: astore 15
    //   1506: aload_1
    //   1507: astore_3
    //   1508: aload 13
    //   1510: astore 14
    //   1512: aload 13
    //   1514: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   1517: aload_1
    //   1518: ifnull +40 -> 1558
    //   1521: aload_1
    //   1522: astore 16
    //   1524: aload 13
    //   1526: astore 15
    //   1528: aload_1
    //   1529: astore_3
    //   1530: aload 13
    //   1532: astore 14
    //   1534: aload_1
    //   1535: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   1538: ifne +20 -> 1558
    //   1541: aload_1
    //   1542: astore 16
    //   1544: aload 13
    //   1546: astore 15
    //   1548: aload_1
    //   1549: astore_3
    //   1550: aload 13
    //   1552: astore 14
    //   1554: aload_1
    //   1555: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   1558: aload_1
    //   1559: astore 16
    //   1561: aload 13
    //   1563: astore 15
    //   1565: aload_1
    //   1566: astore_3
    //   1567: aload 13
    //   1569: astore 14
    //   1571: aload_2
    //   1572: athrow
    //   1573: astore 17
    //   1575: aload_1
    //   1576: astore 16
    //   1578: aload 13
    //   1580: astore 15
    //   1582: aload_1
    //   1583: astore_3
    //   1584: aload 13
    //   1586: astore 14
    //   1588: new 49	java/lang/StringBuilder
    //   1591: dup
    //   1592: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1595: ldc_w 1139
    //   1598: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: aload 17
    //   1603: invokevirtual 1140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1606: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1612: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1615: goto -98 -> 1517
    //   1618: astore_2
    //   1619: goto -1497 -> 122
    //   1622: astore_2
    //   1623: goto -1377 -> 246
    //   1626: astore 13
    //   1628: aload 16
    //   1630: astore 13
    //   1632: goto -1220 -> 412
    //   1635: astore 13
    //   1637: goto -684 -> 953
    //   1640: astore_2
    //   1641: goto -808 -> 833
    //   1644: astore_1
    //   1645: goto -345 -> 1300
    //   1648: astore_2
    //   1649: goto -629 -> 1020
    //   1652: astore_3
    //   1653: goto -274 -> 1379
    //   1656: astore_1
    //   1657: aconst_null
    //   1658: astore 14
    //   1660: aload 13
    //   1662: astore_2
    //   1663: goto -294 -> 1369
    //   1666: astore_3
    //   1667: aload_1
    //   1668: astore_2
    //   1669: aconst_null
    //   1670: astore 14
    //   1672: aload_3
    //   1673: astore_1
    //   1674: goto -305 -> 1369
    //   1677: astore_3
    //   1678: aload_1
    //   1679: astore 14
    //   1681: aload_3
    //   1682: astore_1
    //   1683: goto -314 -> 1369
    //   1686: astore_1
    //   1687: aconst_null
    //   1688: astore 15
    //   1690: aload 14
    //   1692: astore_1
    //   1693: goto -722 -> 971
    //   1696: astore_2
    //   1697: aconst_null
    //   1698: astore 15
    //   1700: goto -729 -> 971
    //   1703: astore_2
    //   1704: aload 14
    //   1706: astore_1
    //   1707: goto -213 -> 1494
    //   1710: astore_3
    //   1711: aload_2
    //   1712: astore 13
    //   1714: aload_3
    //   1715: astore_2
    //   1716: goto -222 -> 1494
    //   1719: astore_3
    //   1720: aload_1
    //   1721: astore 13
    //   1723: aload_2
    //   1724: astore_1
    //   1725: aload_3
    //   1726: astore_2
    //   1727: goto -233 -> 1494
    //   1730: astore_1
    //   1731: aload 15
    //   1733: astore_2
    //   1734: aload 13
    //   1736: astore_1
    //   1737: goto -335 -> 1402
    //   1740: astore_3
    //   1741: aload_1
    //   1742: astore_3
    //   1743: aload_2
    //   1744: astore_1
    //   1745: aload_3
    //   1746: astore_2
    //   1747: goto -345 -> 1402
    //   1750: astore_3
    //   1751: aload 13
    //   1753: astore_2
    //   1754: goto -821 -> 933
    //   1757: astore 13
    //   1759: goto -905 -> 854
    //   1762: aload_1
    //   1763: astore 19
    //   1765: aload_2
    //   1766: astore 20
    //   1768: goto -478 -> 1290
    //   1771: iload 7
    //   1773: istore 5
    //   1775: aload_2
    //   1776: astore 13
    //   1778: goto -1129 -> 649
    //   1781: goto -1050 -> 731
    //   1784: astore_1
    //   1785: aload_3
    //   1786: astore_2
    //   1787: goto -418 -> 1369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1790	0	paramInt1	int
    //   0	1790	1	paramContext	Context
    //   0	1790	2	paramFile1	File
    //   0	1790	3	paramFile2	File
    //   0	1790	4	paramImageInfo	ImageInfo
    //   0	1790	5	paramInt2	int
    //   0	1790	6	paramInt3	int
    //   0	1790	7	paramInt4	int
    //   0	1790	8	paramBoolean1	boolean
    //   0	1790	9	paramBoolean2	boolean
    //   167	505	10	i	int
    //   483	571	11	l	long
    //   76	753	13	localObject1	Object
    //   849	1	13	localIOException1	IOException
    //   856	61	13	localObject2	Object
    //   921	1	13	localIOException2	IOException
    //   925	660	13	localObject3	Object
    //   1626	1	13	localIOException3	IOException
    //   1630	1	13	localObject4	Object
    //   1635	26	13	localIOException4	IOException
    //   1712	40	13	localObject5	Object
    //   1757	1	13	localIOException5	IOException
    //   1776	1	13	localFile	File
    //   73	1632	14	localObject6	Object
    //   391	1341	15	localObject7	Object
    //   283	1346	16	localObject8	Object
    //   570	759	17	localObject9	Object
    //   1573	29	17	localIOException6	IOException
    //   401	966	18	localObject10	Object
    //   436	1328	19	localObject11	Object
    //   439	1328	20	localObject12	Object
    //   394	933	21	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   275	285	849	java/io/IOException
    //   909	914	921	java/io/IOException
    //   275	285	930	finally
    //   403	408	967	java/lang/OutOfMemoryError
    //   479	485	967	java/lang/OutOfMemoryError
    //   504	528	967	java/lang/OutOfMemoryError
    //   542	568	967	java/lang/OutOfMemoryError
    //   909	914	967	java/lang/OutOfMemoryError
    //   949	953	967	java/lang/OutOfMemoryError
    //   965	967	967	java/lang/OutOfMemoryError
    //   1050	1055	967	java/lang/OutOfMemoryError
    //   1211	1216	967	java/lang/OutOfMemoryError
    //   1253	1261	967	java/lang/OutOfMemoryError
    //   1277	1282	967	java/lang/OutOfMemoryError
    //   1336	1362	967	java/lang/OutOfMemoryError
    //   777	782	1058	java/io/IOException
    //   777	782	1101	java/lang/OutOfMemoryError
    //   799	806	1101	java/lang/OutOfMemoryError
    //   819	823	1101	java/lang/OutOfMemoryError
    //   1072	1098	1101	java/lang/OutOfMemoryError
    //   1512	1517	1101	java/lang/OutOfMemoryError
    //   1534	1541	1101	java/lang/OutOfMemoryError
    //   1554	1558	1101	java/lang/OutOfMemoryError
    //   1571	1573	1101	java/lang/OutOfMemoryError
    //   1588	1615	1101	java/lang/OutOfMemoryError
    //   1211	1216	1319	java/io/IOException
    //   403	408	1365	finally
    //   479	485	1365	finally
    //   504	528	1365	finally
    //   542	568	1365	finally
    //   909	914	1365	finally
    //   949	953	1365	finally
    //   965	967	1365	finally
    //   978	984	1365	finally
    //   991	997	1365	finally
    //   1004	1010	1365	finally
    //   1050	1055	1365	finally
    //   1211	1216	1365	finally
    //   1253	1261	1365	finally
    //   1277	1282	1365	finally
    //   1336	1362	1365	finally
    //   575	586	1396	java/io/IOException
    //   593	611	1396	java/io/IOException
    //   618	631	1396	java/io/IOException
    //   1426	1430	1454	java/io/IOException
    //   1426	1430	1484	java/lang/OutOfMemoryError
    //   1434	1445	1484	java/lang/OutOfMemoryError
    //   1455	1481	1484	java/lang/OutOfMemoryError
    //   575	586	1493	finally
    //   593	611	1493	finally
    //   618	631	1493	finally
    //   1512	1517	1573	java/io/IOException
    //   114	122	1618	java/io/IOException
    //   238	246	1622	java/io/IOException
    //   403	408	1626	java/io/IOException
    //   949	953	1635	java/io/IOException
    //   828	833	1640	java/io/IOException
    //   1295	1300	1644	java/io/IOException
    //   1015	1020	1648	java/io/IOException
    //   1374	1379	1652	java/io/IOException
    //   78	89	1656	finally
    //   211	222	1656	finally
    //   228	234	1656	finally
    //   93	110	1666	finally
    //   152	158	1666	finally
    //   163	174	1666	finally
    //   190	198	1666	finally
    //   262	269	1666	finally
    //   1426	1430	1677	finally
    //   1434	1445	1677	finally
    //   1455	1481	1677	finally
    //   78	89	1686	java/lang/OutOfMemoryError
    //   211	222	1686	java/lang/OutOfMemoryError
    //   228	234	1686	java/lang/OutOfMemoryError
    //   93	110	1696	java/lang/OutOfMemoryError
    //   152	158	1696	java/lang/OutOfMemoryError
    //   163	174	1696	java/lang/OutOfMemoryError
    //   190	198	1696	java/lang/OutOfMemoryError
    //   262	269	1696	java/lang/OutOfMemoryError
    //   667	678	1703	finally
    //   684	721	1703	finally
    //   737	743	1703	finally
    //   753	759	1703	finally
    //   1114	1123	1703	finally
    //   1172	1183	1703	finally
    //   1123	1150	1710	finally
    //   1402	1422	1719	finally
    //   667	678	1730	java/io/IOException
    //   684	721	1730	java/io/IOException
    //   737	743	1730	java/io/IOException
    //   753	759	1730	java/io/IOException
    //   1114	1123	1730	java/io/IOException
    //   1172	1183	1730	java/io/IOException
    //   1123	1150	1740	java/io/IOException
    //   289	305	1750	finally
    //   309	315	1750	finally
    //   319	327	1750	finally
    //   331	336	1750	finally
    //   340	380	1750	finally
    //   858	864	1750	finally
    //   868	876	1750	finally
    //   880	886	1750	finally
    //   289	305	1757	java/io/IOException
    //   309	315	1757	java/io/IOException
    //   319	327	1757	java/io/IOException
    //   331	336	1757	java/io/IOException
    //   340	380	1757	java/io/IOException
    //   777	782	1784	finally
    //   799	806	1784	finally
    //   819	823	1784	finally
    //   1072	1098	1784	finally
    //   1512	1517	1784	finally
    //   1534	1541	1784	finally
    //   1554	1558	1784	finally
    //   1571	1573	1784	finally
    //   1588	1615	1784	finally
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    baws.b(paramInt1, paramBoolean, paramInt2, String.valueOf(paramLong), paramString1, paramString2);
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramLong, paramInt, 1, paramBoolean, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    String str = paramFile.getAbsolutePath();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
    localObject = ((BitmapFactory.Options)localObject).outMimeType;
    int i = fa.a(str);
    ContentValues localContentValues = new ContentValues(7);
    localContentValues.put("title", paramFile.getName());
    localContentValues.put("_display_name", paramFile.getName());
    localContentValues.put("date_modified", Long.valueOf(paramFile.lastModified() / 1000L));
    localContentValues.put("mime_type", (String)localObject);
    localContentValues.put("orientation", Integer.valueOf(i));
    localContentValues.put("_data", str);
    localContentValues.put("_size", Long.valueOf(paramFile.length()));
    if (paramContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues) == null) {}
    try
    {
      MediaStore.Images.Media.insertImage(paramContext.getContentResolver(), str, paramFile.getName(), null);
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    FileProvider7Helper.savePhotoToSysAlbum(paramContext, paramString);
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 194	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 798	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: iload_3
    //   11: iload 4
    //   13: invokestatic 998	bdhj:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   16: astore 5
    //   18: new 341	java/io/BufferedInputStream
    //   21: dup
    //   22: new 693	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 728	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 350	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: aload 5
    //   39: aload_2
    //   40: invokestatic 1233	bdhj:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;)Ljava/lang/String;
    //   43: pop
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 361	java/io/InputStream:close	()V
    //   52: return
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: new 49	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 1235
    //   68: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual 510	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   75: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: ifnull -33 -> 52
    //   88: aload_1
    //   89: invokevirtual 361	java/io/InputStream:close	()V
    //   92: return
    //   93: astore_0
    //   94: return
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 361	java/io/InputStream:close	()V
    //   106: aload_1
    //   107: athrow
    //   108: astore_0
    //   109: return
    //   110: astore_0
    //   111: goto -5 -> 106
    //   114: astore_1
    //   115: goto -17 -> 98
    //   118: astore_2
    //   119: goto -63 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramString1	String
    //   0	122	2	paramString2	String
    //   0	122	3	paramInt1	int
    //   0	122	4	paramInt2	int
    //   16	22	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   0	34	53	java/lang/Exception
    //   88	92	93	java/io/IOException
    //   0	34	95	finally
    //   48	52	108	java/io/IOException
    //   102	106	110	java/io/IOException
    //   36	44	114	finally
    //   58	84	114	finally
    //   36	44	118	java/lang/Exception
  }
  
  public static void a(Context paramContext, List<ImageInfo> paramList, int paramInt)
  {
    if ((paramContext == null) || (paramList == null)) {}
    int i;
    label18:
    ImageInfo localImageInfo;
    do
    {
      return;
      paramList = paramList.iterator();
      i = 0;
      if (!paramList.hasNext()) {
        break;
      }
      localImageInfo = (ImageInfo)paramList.next();
    } while ((localImageInfo == null) || (localImageInfo.b == null));
    File localFile = new File(localImageInfo.b);
    long l = bazm.a();
    switch (paramInt)
    {
    default: 
      label120:
      if ((localFile.length() > l) && (!localImageInfo.p)) {
        i = 1;
      }
      break;
    }
    for (;;)
    {
      break label18;
      l = bazm.a();
      break label120;
      l = bazm.b();
      break label120;
      if ((paramContext != null) && ((paramContext instanceof BaseActivity)))
      {
        if (!((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).a(localImageInfo.jdField_c_of_type_JavaLangString)) {
          break label120;
        }
        l = bazm.a();
        break label120;
      }
      l = AppSetting.jdField_c_of_type_Int;
      break label120;
      if ((localImageInfo.g) && (!bdin.h(paramContext)))
      {
        i = 1;
        continue;
        if (i == 0) {
          break;
        }
        QQToast.a(paramContext, alud.a(2131706127), 0).b(paramContext.getResources().getDimensionPixelSize(2131298914));
        return;
      }
    }
  }
  
  public static void a(Resources paramResources, View paramView, int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inInputShareable = true;
      localOptions.inPurgeable = true;
      localOptions.inJustDecodeBounds = false;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localOptions.inSampleSize = 2;
      paramView.setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeResource(paramResources, paramInt, localOptions)));
      return;
    }
    catch (OutOfMemoryError paramResources) {}
  }
  
  /* Error */
  public static void a(Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: new 194	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 1299	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 798	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 801	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_2
    //   20: invokevirtual 1302	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_2
    //   27: invokevirtual 814	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 801	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_1
    //   39: invokevirtual 1305	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_1
    //   46: invokevirtual 817	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_2
    //   52: new 964	java/io/BufferedOutputStream
    //   55: dup
    //   56: new 966	java/io/FileOutputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 970	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_1
    //   68: aload_0
    //   69: getstatic 976	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   72: bipush 100
    //   74: aload_1
    //   75: invokevirtual 980	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   78: pop
    //   79: aload_1
    //   80: invokevirtual 1308	java/io/BufferedOutputStream:flush	()V
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 1309	java/io/BufferedOutputStream:close	()V
    //   91: return
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull -5 -> 91
    //   99: aload_1
    //   100: invokevirtual 1309	java/io/BufferedOutputStream:close	()V
    //   103: return
    //   104: astore_0
    //   105: aload_2
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 1309	java/io/BufferedOutputStream:close	()V
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: goto -11 -> 107
    //   121: astore_0
    //   122: goto -27 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramBitmap	Bitmap
    //   0	125	1	paramFile	File
    //   11	95	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   52	68	92	java/io/IOException
    //   52	68	104	finally
    //   68	83	117	finally
    //   68	83	121	java/io/IOException
  }
  
  private static void a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt2)
    {
      paramRect.set(0, 0, paramInt3, (int)(paramInt3 / paramInt1 * paramInt2));
      return;
    }
    paramRect.set(0, 0, (int)(paramInt3 / paramInt2 * paramInt1), paramInt3);
  }
  
  public static void a(ImageInfo paramImageInfo, String paramString1, String paramString2)
  {
    if (paramImageInfo == null)
    {
      a(-1L, -1, true, paramString1, "@ImageUtil.log ImageInfo is null@ " + paramString2);
      return;
    }
    boolean bool = bdil.b(paramImageInfo.jdField_d_of_type_Int);
    if (paramImageInfo.jdField_h_of_type_Int == 2)
    {
      a(paramImageInfo.jdField_d_of_type_Long, paramImageInfo.jdField_c_of_type_Int, 131075, bool, paramString1, paramString2);
      return;
    }
    a(paramImageInfo.jdField_d_of_type_Long, paramImageInfo.jdField_c_of_type_Int, bool, paramString1, paramString2);
  }
  
  private static final void a(FileOutputStream paramFileOutputStream)
  {
    paramFileOutputStream.flush();
    paramFileOutputStream = paramFileOutputStream.getFD();
    if ((paramFileOutputStream != null) && (paramFileOutputStream.valid())) {
      paramFileOutputStream.sync();
    }
  }
  
  private static void a(String paramString)
  {
    if ((QLog.isColorLevel()) || (baws.a())) {
      QLog.e("ImageUtil", 2, paramString);
    }
  }
  
  private static void a(String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramContext != null) && ((paramContext instanceof BaseActivity))) {
      ThreadManager.post(new ImageUtil.1((QQAppInterface)((BaseActivity)paramContext).getAppRuntime(), paramString, paramBoolean), 2, null, false);
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 194	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 798	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_1
    //   16: invokestatic 962	bdhj:a	(Ljava/lang/String;)Ljava/io/File;
    //   19: astore_1
    //   20: new 693	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 728	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: new 966	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore 5
    //   39: sipush 2048
    //   42: newarray byte
    //   44: astore_1
    //   45: lconst_0
    //   46: lstore_3
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 1354	java/io/InputStream:read	([B)I
    //   52: istore_2
    //   53: iload_2
    //   54: iflt +42 -> 96
    //   57: lload_3
    //   58: iload_2
    //   59: i2l
    //   60: ladd
    //   61: lstore_3
    //   62: aload 5
    //   64: aload_1
    //   65: iconst_0
    //   66: iload_2
    //   67: invokevirtual 1358	java/io/OutputStream:write	([BII)V
    //   70: goto -23 -> 47
    //   73: astore_1
    //   74: aload_0
    //   75: astore_1
    //   76: aload 5
    //   78: astore_0
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 361	java/io/InputStream:close	()V
    //   87: aload_0
    //   88: ifnull +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 983	java/io/OutputStream:close	()V
    //   95: return
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 361	java/io/InputStream:close	()V
    //   104: aload 5
    //   106: ifnull -11 -> 95
    //   109: aload 5
    //   111: invokevirtual 983	java/io/OutputStream:close	()V
    //   114: return
    //   115: astore_0
    //   116: return
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload 6
    //   122: astore 5
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 361	java/io/InputStream:close	()V
    //   132: aload 5
    //   134: ifnull +8 -> 142
    //   137: aload 5
    //   139: invokevirtual 983	java/io/OutputStream:close	()V
    //   142: aload_1
    //   143: athrow
    //   144: astore_0
    //   145: goto -41 -> 104
    //   148: astore_1
    //   149: goto -62 -> 87
    //   152: astore_0
    //   153: return
    //   154: astore_0
    //   155: goto -23 -> 132
    //   158: astore_0
    //   159: goto -17 -> 142
    //   162: astore_1
    //   163: aload 6
    //   165: astore 5
    //   167: goto -43 -> 124
    //   170: astore_1
    //   171: goto -47 -> 124
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_0
    //   177: aload 5
    //   179: astore_1
    //   180: goto -101 -> 79
    //   183: astore_1
    //   184: aconst_null
    //   185: astore 5
    //   187: aload_0
    //   188: astore_1
    //   189: aload 5
    //   191: astore_0
    //   192: goto -113 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramString1	String
    //   0	195	1	paramString2	String
    //   52	15	2	i	int
    //   46	16	3	l	long
    //   4	186	5	localObject1	Object
    //   1	163	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   39	45	73	java/lang/Exception
    //   47	53	73	java/lang/Exception
    //   62	70	73	java/lang/Exception
    //   109	114	115	java/io/IOException
    //   6	29	117	finally
    //   100	104	144	java/io/IOException
    //   83	87	148	java/io/IOException
    //   91	95	152	java/io/IOException
    //   128	132	154	java/io/IOException
    //   137	142	158	java/io/IOException
    //   29	39	162	finally
    //   39	45	170	finally
    //   47	53	170	finally
    //   62	70	170	finally
    //   6	29	174	java/lang/Exception
    //   29	39	183	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString1, localOptions);
      if ((localOptions.outWidth < paramInt1) && (localOptions.outHeight < paramInt2))
      {
        a(paramString1, paramString2, paramInt1, paramInt2, 100);
        return;
      }
      paramString2 = SafeBitmapFactory.decodeFile(paramString1);
      if (paramString2.getWidth() >= paramInt1) {
        break label99;
      }
      paramString2.getWidth();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a(paramString1.toString());
        return;
        if (paramString2.getHeight() < paramInt2) {
          paramString2.getHeight();
        }
      }
    }
    catch (Error paramString1)
    {
      label99:
      a(paramString1.toString());
    }
    a(a(paramString2, paramInt1, paramInt2), new File(paramString1));
    return;
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if ((QLog.isColorLevel()) || (baws.a())) {
      QLog.e("ImageUtil", 2, paramString, paramThrowable);
    }
  }
  
  private static boolean a()
  {
    return bdeu.b() >> 20 < 2L;
  }
  
  public static boolean a(int paramInt1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ImageInfo paramImageInfo, int paramInt2)
  {
    baws.a("compressPic", AppSetting.a(), a(), 10000, 600000L);
    File localFile;
    if (bdhb.a(paramString2))
    {
      localFile = new File(paramString2);
      if (!a(paramString2)) {
        localFile.delete();
      }
    }
    else
    {
      boolean bool = false;
      if (paramInt1 == 8) {
        bool = true;
      }
      paramBoolean = a(paramInt1, paramContext, paramString1, paramString2, paramBoolean, paramImageInfo, paramInt2, bool);
      if ((paramBoolean) && (!bool)) {
        a(paramString1, paramString2);
      }
      return paramBoolean;
    }
    paramImageInfo.b = localFile.getPath();
    paramImageInfo.a = localFile.length();
    paramImageInfo.o = true;
    paramImageInfo.jdField_h_of_type_Boolean = true;
    if (paramImageInfo.jdField_j_of_type_Int > 0)
    {
      a("compress succ with retry : " + paramImageInfo.jdField_j_of_type_Int);
      a(paramInt1, 8, paramContext, false, null);
      if (paramImageInfo.jdField_j_of_type_Int <= 0) {
        break label207;
      }
    }
    label207:
    for (paramBoolean = true;; paramBoolean = false)
    {
      baws.a("compressPic", paramBoolean, "compressPic");
      return true;
      a(paramInt1, 0, paramContext, true, null);
      break;
    }
  }
  
  /* Error */
  private static boolean a(int paramInt1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, ImageInfo paramImageInfo, int paramInt2, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 1410
    //   3: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   6: aload_3
    //   7: ifnull +16 -> 23
    //   10: aload_2
    //   11: ifnull +12 -> 23
    //   14: aload 5
    //   16: ifnull +7 -> 23
    //   19: aload_1
    //   20: ifnonnull +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: new 194	java/io/File
    //   28: dup
    //   29: new 49	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   36: getstatic 837	alof:aX	Ljava/lang/String;
    //   39: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 1412
    //   45: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 798	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore 14
    //   56: aload 14
    //   58: invokevirtual 801	java/io/File:exists	()Z
    //   61: ifne +23 -> 84
    //   64: ldc_w 1414
    //   67: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   70: aload 14
    //   72: invokevirtual 814	java/io/File:mkdirs	()Z
    //   75: ifne +9 -> 84
    //   78: ldc_w 1416
    //   81: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   84: new 194	java/io/File
    //   87: dup
    //   88: aload_3
    //   89: invokespecial 798	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore 16
    //   94: new 194	java/io/File
    //   97: dup
    //   98: aload_2
    //   99: invokespecial 798	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 17
    //   104: aload 5
    //   106: ldc_w 1418
    //   109: new 49	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 1420
    //   119: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 5
    //   124: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   127: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc_w 1422
    //   133: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload 5
    //   138: getfield 249	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Int	I
    //   141: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_2
    //   151: invokestatic 1389	bdhb:a	(Ljava/lang/String;)Z
    //   154: ifne +13 -> 167
    //   157: iload_0
    //   158: iconst_1
    //   159: aload_1
    //   160: iconst_0
    //   161: aconst_null
    //   162: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   165: iconst_0
    //   166: ireturn
    //   167: aload_2
    //   168: invokestatic 1424	bdhb:b	(Ljava/lang/String;)Z
    //   171: ifne +13 -> 184
    //   174: iload_0
    //   175: iconst_2
    //   176: aload_1
    //   177: iconst_0
    //   178: aconst_null
    //   179: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   182: iconst_0
    //   183: ireturn
    //   184: aload_2
    //   185: invokestatic 1390	bdhj:a	(Ljava/lang/String;)Z
    //   188: ifne +13 -> 201
    //   191: iload_0
    //   192: iconst_4
    //   193: aload_1
    //   194: iconst_0
    //   195: aconst_null
    //   196: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   199: iconst_0
    //   200: ireturn
    //   201: aload 5
    //   203: aload 17
    //   205: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   208: putfield 1253	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   211: aload 5
    //   213: aload 17
    //   215: invokevirtual 1106	java/io/File:length	()J
    //   218: putfield 1398	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   221: aload 17
    //   223: invokestatic 1426	bdhj:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   226: astore 14
    //   228: new 49	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 1428
    //   238: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 17
    //   243: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: ldc_w 1430
    //   249: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 17
    //   254: invokevirtual 1106	java/io/File:length	()J
    //   257: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: ldc_w 1432
    //   263: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 14
    //   268: getfield 31	android/graphics/BitmapFactory$Options:outWidth	I
    //   271: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: ldc_w 1434
    //   277: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 14
    //   282: getfield 34	android/graphics/BitmapFactory$Options:outHeight	I
    //   285: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   294: aload_3
    //   295: invokestatic 1389	bdhb:a	(Ljava/lang/String;)Z
    //   298: ifeq +16 -> 314
    //   301: aload_3
    //   302: invokestatic 1390	bdhj:a	(Ljava/lang/String;)Z
    //   305: ifne +490 -> 795
    //   308: aload 16
    //   310: invokevirtual 820	java/io/File:delete	()Z
    //   313: pop
    //   314: aload 17
    //   316: invokestatic 1120	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   319: istore 11
    //   321: aload 5
    //   323: iload 11
    //   325: putfield 1258	com/tencent/mobileqq/activity/photo/ImageInfo:p	Z
    //   328: iload 11
    //   330: ifne +155 -> 485
    //   333: aload 16
    //   335: invokevirtual 817	java/io/File:createNewFile	()Z
    //   338: ifeq +147 -> 485
    //   341: ldc_w 1436
    //   344: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   347: new 15	android/graphics/BitmapFactory$Options
    //   350: dup
    //   351: invokespecial 18	android/graphics/BitmapFactory$Options:<init>	()V
    //   354: astore 14
    //   356: aload 14
    //   358: iconst_1
    //   359: putfield 22	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   362: new 341	java/io/BufferedInputStream
    //   365: dup
    //   366: new 693	java/io/FileInputStream
    //   369: dup
    //   370: aload 17
    //   372: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   375: invokespecial 695	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   378: invokespecial 350	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   381: astore 15
    //   383: aload 15
    //   385: aconst_null
    //   386: aload 14
    //   388: invokestatic 703	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   391: pop
    //   392: aload 15
    //   394: ifnull +8 -> 402
    //   397: aload 15
    //   399: invokevirtual 361	java/io/InputStream:close	()V
    //   402: aload 14
    //   404: getfield 34	android/graphics/BitmapFactory$Options:outHeight	I
    //   407: istore 8
    //   409: aload 14
    //   411: getfield 31	android/graphics/BitmapFactory$Options:outWidth	I
    //   414: istore 9
    //   416: iload 8
    //   418: iconst_m1
    //   419: if_icmpeq +66 -> 485
    //   422: iload 9
    //   424: iconst_m1
    //   425: if_icmpeq +60 -> 485
    //   428: iload 7
    //   430: ifne +1556 -> 1986
    //   433: iload 4
    //   435: ifeq +1551 -> 1986
    //   438: iload 8
    //   440: iload 9
    //   442: iconst_3
    //   443: imul
    //   444: if_icmpgt +12 -> 456
    //   447: iload 9
    //   449: iload 8
    //   451: iconst_3
    //   452: imul
    //   453: if_icmple +1533 -> 1986
    //   456: iload_0
    //   457: aload_1
    //   458: aload 17
    //   460: aload 16
    //   462: aload 5
    //   464: iload 6
    //   466: iload 8
    //   468: iload 9
    //   470: iload 4
    //   472: iload 7
    //   474: invokestatic 1438	bdhj:b	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   477: ldc_w 1440
    //   480: aload_1
    //   481: iconst_1
    //   482: invokestatic 205	bdhj:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   485: aload 5
    //   487: getfield 242	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   490: iconst_1
    //   491: if_icmpeq +12 -> 503
    //   494: aload 5
    //   496: getfield 242	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   499: iconst_1
    //   500: if_icmpne +1839 -> 2339
    //   503: iconst_1
    //   504: istore 10
    //   506: aload_3
    //   507: invokestatic 1424	bdhb:b	(Ljava/lang/String;)Z
    //   510: istore 12
    //   512: aload 5
    //   514: ldc_w 1442
    //   517: new 49	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 1444
    //   527: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 5
    //   532: getfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   535: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   538: ldc_w 1446
    //   541: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 5
    //   546: getfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   549: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   552: ldc_w 1448
    //   555: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: iload 12
    //   560: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   563: ldc_w 1450
    //   566: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: iload 10
    //   571: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   574: ldc_w 1452
    //   577: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 5
    //   582: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   585: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   588: ldc_w 1454
    //   591: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload 5
    //   596: getfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   599: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   602: ldc_w 1456
    //   605: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokestatic 1038	bdeu:b	()J
    //   611: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   614: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload 5
    //   622: getfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   625: ifne +1731 -> 2356
    //   628: aload 5
    //   630: getfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   633: ifeq +1712 -> 2345
    //   636: iload_0
    //   637: iconst_3
    //   638: aload_1
    //   639: iconst_0
    //   640: aconst_null
    //   641: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   644: iload 12
    //   646: ifeq +27 -> 673
    //   649: aload 16
    //   651: invokevirtual 1106	java/io/File:length	()J
    //   654: aload 17
    //   656: invokevirtual 1106	java/io/File:length	()J
    //   659: lcmp
    //   660: ifgt +13 -> 673
    //   663: iload 10
    //   665: ifne +8 -> 673
    //   668: iload 11
    //   670: ifeq +2010 -> 2680
    //   673: aload 5
    //   675: aload 17
    //   677: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   680: putfield 1253	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   683: aload 5
    //   685: aload 17
    //   687: invokevirtual 1106	java/io/File:length	()J
    //   690: putfield 1398	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   693: aload 5
    //   695: iconst_0
    //   696: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   699: aload 5
    //   701: iconst_0
    //   702: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   705: aload 16
    //   707: ifnull +17 -> 724
    //   710: aload 16
    //   712: invokevirtual 801	java/io/File:exists	()Z
    //   715: ifeq +9 -> 724
    //   718: aload 16
    //   720: invokevirtual 820	java/io/File:delete	()Z
    //   723: pop
    //   724: iload 10
    //   726: ifne +8 -> 734
    //   729: iload 11
    //   731: ifeq +1788 -> 2519
    //   734: new 49	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   741: ldc_w 1458
    //   744: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: aload 17
    //   749: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   752: ldc_w 1430
    //   755: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 17
    //   760: invokevirtual 1106	java/io/File:length	()J
    //   763: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   766: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   772: ldc_w 1376
    //   775: iconst_0
    //   776: ldc_w 1376
    //   779: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   782: aload 5
    //   784: ldc_w 1460
    //   787: ldc_w 1462
    //   790: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   793: iconst_0
    //   794: ireturn
    //   795: aload 5
    //   797: ldc_w 1063
    //   800: ldc_w 1464
    //   803: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   806: aload 5
    //   808: getfield 242	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   811: iconst_1
    //   812: if_icmpeq +12 -> 824
    //   815: aload 5
    //   817: getfield 242	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   820: iconst_1
    //   821: if_icmpne +380 -> 1201
    //   824: iconst_1
    //   825: istore 10
    //   827: aload_3
    //   828: invokestatic 1424	bdhb:b	(Ljava/lang/String;)Z
    //   831: istore 11
    //   833: aload 5
    //   835: ldc_w 1442
    //   838: new 49	java/lang/StringBuilder
    //   841: dup
    //   842: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   845: ldc_w 1444
    //   848: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: aload 5
    //   853: getfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   856: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   859: ldc_w 1446
    //   862: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: aload 5
    //   867: getfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   870: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   873: ldc_w 1448
    //   876: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: iload 11
    //   881: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   884: ldc_w 1450
    //   887: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: iload 10
    //   892: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   895: ldc_w 1452
    //   898: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload 5
    //   903: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   906: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   909: ldc_w 1454
    //   912: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 5
    //   917: getfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   920: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   923: ldc_w 1456
    //   926: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: invokestatic 1038	bdeu:b	()J
    //   932: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   935: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   941: aload 5
    //   943: getfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   946: ifne +272 -> 1218
    //   949: aload 5
    //   951: getfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   954: ifeq +253 -> 1207
    //   957: iload_0
    //   958: iconst_3
    //   959: aload_1
    //   960: iconst_0
    //   961: aconst_null
    //   962: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   965: iload 11
    //   967: ifeq +409 -> 1376
    //   970: aload 16
    //   972: invokevirtual 1106	java/io/File:length	()J
    //   975: aload 17
    //   977: invokevirtual 1106	java/io/File:length	()J
    //   980: lcmp
    //   981: ifgt +395 -> 1376
    //   984: iload 10
    //   986: ifne +390 -> 1376
    //   989: aload 5
    //   991: aload 16
    //   993: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   996: putfield 1253	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   999: aload 5
    //   1001: aload 16
    //   1003: invokevirtual 1106	java/io/File:length	()J
    //   1006: putfield 1398	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1009: aload 5
    //   1011: iconst_1
    //   1012: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1015: aload 5
    //   1017: iconst_1
    //   1018: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1021: aload 16
    //   1023: invokestatic 1426	bdhj:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   1026: astore_2
    //   1027: new 49	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1034: ldc_w 1466
    //   1037: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: aload 17
    //   1042: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1045: ldc_w 1468
    //   1048: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: aload_3
    //   1052: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: ldc_w 1430
    //   1058: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload 16
    //   1063: invokevirtual 1106	java/io/File:length	()J
    //   1066: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1069: ldc_w 1432
    //   1072: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: aload_2
    //   1076: getfield 31	android/graphics/BitmapFactory$Options:outWidth	I
    //   1079: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1082: ldc_w 1434
    //   1085: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: aload_2
    //   1089: getfield 34	android/graphics/BitmapFactory$Options:outHeight	I
    //   1092: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1095: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1101: aload 5
    //   1103: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1106: ifle +548 -> 1654
    //   1109: new 49	java/lang/StringBuilder
    //   1112: dup
    //   1113: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1116: ldc_w 1403
    //   1119: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: aload 5
    //   1124: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1127: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1130: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1133: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1136: iload_0
    //   1137: bipush 8
    //   1139: aload_1
    //   1140: iconst_0
    //   1141: aconst_null
    //   1142: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1145: aload 5
    //   1147: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1150: ifle +515 -> 1665
    //   1153: iconst_1
    //   1154: istore 4
    //   1156: ldc_w 1376
    //   1159: iload 4
    //   1161: ldc_w 1376
    //   1164: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1167: aload 5
    //   1169: ldc_w 1460
    //   1172: new 49	java/lang/StringBuilder
    //   1175: dup
    //   1176: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1179: ldc_w 1470
    //   1182: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: aload 5
    //   1187: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1190: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1193: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1196: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1199: iconst_1
    //   1200: ireturn
    //   1201: iconst_0
    //   1202: istore 10
    //   1204: goto -377 -> 827
    //   1207: iload_0
    //   1208: iconst_4
    //   1209: aload_1
    //   1210: iconst_0
    //   1211: aconst_null
    //   1212: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1215: goto -250 -> 965
    //   1218: iload 11
    //   1220: ifne -255 -> 965
    //   1223: iload 10
    //   1225: ifne -260 -> 965
    //   1228: aload 5
    //   1230: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1233: istore 8
    //   1235: aload 5
    //   1237: iload 8
    //   1239: iconst_1
    //   1240: iadd
    //   1241: putfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1244: iload 8
    //   1246: iconst_2
    //   1247: if_icmpge +33 -> 1280
    //   1250: aload 5
    //   1252: iconst_1
    //   1253: putfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1256: ldc_w 1472
    //   1259: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1262: iload_0
    //   1263: aload_1
    //   1264: aload_2
    //   1265: aload_3
    //   1266: iload 4
    //   1268: aload 5
    //   1270: iload 6
    //   1272: iload 7
    //   1274: invokestatic 1393	bdhj:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   1277: pop
    //   1278: iconst_0
    //   1279: ireturn
    //   1280: aload 5
    //   1282: getfield 1086	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   1285: ifeq +15 -> 1300
    //   1288: iload_0
    //   1289: bipush 6
    //   1291: aload_1
    //   1292: iconst_0
    //   1293: aconst_null
    //   1294: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1297: goto -332 -> 965
    //   1300: aload 5
    //   1302: getfield 1474	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   1305: ifeq +15 -> 1320
    //   1308: iload_0
    //   1309: bipush 7
    //   1311: aload_1
    //   1312: iconst_0
    //   1313: aconst_null
    //   1314: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1317: goto -352 -> 965
    //   1320: aload 5
    //   1322: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1325: ifne +15 -> 1340
    //   1328: iload_0
    //   1329: bipush 9
    //   1331: aload_1
    //   1332: iconst_0
    //   1333: aconst_null
    //   1334: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1337: goto -372 -> 965
    //   1340: aload 5
    //   1342: getfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1345: ifeq +14 -> 1359
    //   1348: iload_0
    //   1349: iconst_0
    //   1350: aload_1
    //   1351: iconst_0
    //   1352: aconst_null
    //   1353: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1356: goto -391 -> 965
    //   1359: ldc_w 1476
    //   1362: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1365: iload_0
    //   1366: iconst_5
    //   1367: aload_1
    //   1368: iconst_0
    //   1369: aconst_null
    //   1370: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1373: goto -408 -> 965
    //   1376: aload 5
    //   1378: aload 17
    //   1380: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   1383: putfield 1253	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   1386: aload 5
    //   1388: aload 17
    //   1390: invokevirtual 1106	java/io/File:length	()J
    //   1393: putfield 1398	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1396: aload 5
    //   1398: iconst_0
    //   1399: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1402: aload 5
    //   1404: iconst_0
    //   1405: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1408: aload 16
    //   1410: ifnull +17 -> 1427
    //   1413: aload 16
    //   1415: invokevirtual 801	java/io/File:exists	()Z
    //   1418: ifeq +9 -> 1427
    //   1421: aload 16
    //   1423: invokevirtual 820	java/io/File:delete	()Z
    //   1426: pop
    //   1427: iload 10
    //   1429: ifne +155 -> 1584
    //   1432: new 49	java/lang/StringBuilder
    //   1435: dup
    //   1436: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1439: ldc_w 1478
    //   1442: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: aload_3
    //   1446: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: ldc_w 1430
    //   1452: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: aload 16
    //   1457: invokevirtual 1106	java/io/File:length	()J
    //   1460: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1463: ldc_w 1480
    //   1466: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: aload 17
    //   1471: invokevirtual 1106	java/io/File:length	()J
    //   1474: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1477: ldc_w 1482
    //   1480: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: iload 10
    //   1485: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1488: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1491: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1494: new 49	java/lang/StringBuilder
    //   1497: dup
    //   1498: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1501: ldc_w 1484
    //   1504: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: iconst_0
    //   1508: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1511: ldc_w 1486
    //   1514: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: aload_3
    //   1518: invokestatic 1389	bdhb:a	(Ljava/lang/String;)Z
    //   1521: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1524: ldc_w 1488
    //   1527: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: astore_1
    //   1531: aload 16
    //   1533: invokevirtual 1106	java/io/File:length	()J
    //   1536: lconst_0
    //   1537: lcmp
    //   1538: ifgt +97 -> 1635
    //   1541: iconst_1
    //   1542: istore 4
    //   1544: aload_1
    //   1545: iload 4
    //   1547: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1550: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1553: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1556: iload 11
    //   1558: ifne +83 -> 1641
    //   1561: ldc_w 1376
    //   1564: iconst_1
    //   1565: ldc_w 1376
    //   1568: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1571: aload 5
    //   1573: ldc_w 1460
    //   1576: ldc_w 1462
    //   1579: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1582: iconst_1
    //   1583: ireturn
    //   1584: new 49	java/lang/StringBuilder
    //   1587: dup
    //   1588: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1591: ldc_w 1458
    //   1594: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: aload 17
    //   1599: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1602: ldc_w 1430
    //   1605: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: aload 17
    //   1610: invokevirtual 1106	java/io/File:length	()J
    //   1613: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1616: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1619: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1622: ldc_w 1376
    //   1625: iconst_0
    //   1626: ldc_w 1376
    //   1629: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1632: goto -61 -> 1571
    //   1635: iconst_0
    //   1636: istore 4
    //   1638: goto -94 -> 1544
    //   1641: ldc_w 1376
    //   1644: iconst_0
    //   1645: ldc_w 1376
    //   1648: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1651: goto -80 -> 1571
    //   1654: iload_0
    //   1655: iconst_0
    //   1656: aload_1
    //   1657: iconst_1
    //   1658: aconst_null
    //   1659: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1662: goto -517 -> 1145
    //   1665: iconst_0
    //   1666: istore 4
    //   1668: goto -512 -> 1156
    //   1671: astore 14
    //   1673: aconst_null
    //   1674: astore 15
    //   1676: aload 15
    //   1678: ifnull +8 -> 1686
    //   1681: aload 15
    //   1683: invokevirtual 361	java/io/InputStream:close	()V
    //   1686: aload 14
    //   1688: athrow
    //   1689: astore 14
    //   1691: iload 11
    //   1693: istore 10
    //   1695: iconst_1
    //   1696: istore 12
    //   1698: ldc_w 1490
    //   1701: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1704: aload 5
    //   1706: getfield 242	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   1709: iconst_1
    //   1710: if_icmpeq +12 -> 1722
    //   1713: aload 5
    //   1715: getfield 242	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   1718: iconst_1
    //   1719: if_icmpne +1190 -> 2909
    //   1722: iconst_1
    //   1723: istore 11
    //   1725: aload_3
    //   1726: invokestatic 1424	bdhb:b	(Ljava/lang/String;)Z
    //   1729: istore 12
    //   1731: aload 5
    //   1733: ldc_w 1442
    //   1736: new 49	java/lang/StringBuilder
    //   1739: dup
    //   1740: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1743: ldc_w 1444
    //   1746: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: aload 5
    //   1751: getfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1754: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1757: ldc_w 1446
    //   1760: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: aload 5
    //   1765: getfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   1768: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1771: ldc_w 1448
    //   1774: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: iload 12
    //   1779: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1782: ldc_w 1450
    //   1785: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: iload 11
    //   1790: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1793: ldc_w 1452
    //   1796: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: aload 5
    //   1801: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1804: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1807: ldc_w 1454
    //   1810: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1813: aload 5
    //   1815: getfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1818: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1821: ldc_w 1456
    //   1824: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: invokestatic 1038	bdeu:b	()J
    //   1830: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1833: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1836: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1839: aload 5
    //   1841: getfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1844: ifne +1082 -> 2926
    //   1847: aload 5
    //   1849: getfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   1852: ifeq +1063 -> 2915
    //   1855: iload_0
    //   1856: iconst_3
    //   1857: aload_1
    //   1858: iconst_0
    //   1859: aconst_null
    //   1860: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1863: aload 5
    //   1865: aload 17
    //   1867: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   1870: putfield 1253	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   1873: aload 5
    //   1875: aload 17
    //   1877: invokevirtual 1106	java/io/File:length	()J
    //   1880: putfield 1398	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1883: aload 5
    //   1885: iconst_0
    //   1886: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1889: aload 5
    //   1891: iconst_0
    //   1892: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1895: aload 16
    //   1897: ifnull +17 -> 1914
    //   1900: aload 16
    //   1902: invokevirtual 801	java/io/File:exists	()Z
    //   1905: ifeq +9 -> 1914
    //   1908: aload 16
    //   1910: invokevirtual 820	java/io/File:delete	()Z
    //   1913: pop
    //   1914: iload 11
    //   1916: ifne +8 -> 1924
    //   1919: iload 10
    //   1921: ifeq +1168 -> 3089
    //   1924: new 49	java/lang/StringBuilder
    //   1927: dup
    //   1928: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1931: ldc_w 1458
    //   1934: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1937: aload 17
    //   1939: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1942: ldc_w 1430
    //   1945: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: aload 17
    //   1950: invokevirtual 1106	java/io/File:length	()J
    //   1953: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1956: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1959: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1962: ldc_w 1376
    //   1965: iconst_0
    //   1966: ldc_w 1376
    //   1969: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1972: aload 5
    //   1974: ldc_w 1460
    //   1977: ldc_w 1462
    //   1980: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1983: goto -1190 -> 793
    //   1986: iload_0
    //   1987: aload_1
    //   1988: aload 17
    //   1990: aload 16
    //   1992: aload 5
    //   1994: iload 6
    //   1996: iload 8
    //   1998: iload 9
    //   2000: iload 4
    //   2002: iload 7
    //   2004: invokestatic 1492	bdhj:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   2007: ldc_w 1440
    //   2010: aload_1
    //   2011: iconst_0
    //   2012: invokestatic 205	bdhj:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   2015: goto -1530 -> 485
    //   2018: astore 14
    //   2020: iconst_0
    //   2021: istore 10
    //   2023: aload 5
    //   2025: getfield 242	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   2028: iconst_1
    //   2029: if_icmpeq +12 -> 2041
    //   2032: aload 5
    //   2034: getfield 242	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   2037: iconst_1
    //   2038: if_icmpne +1194 -> 3232
    //   2041: iconst_1
    //   2042: istore 12
    //   2044: aload_3
    //   2045: invokestatic 1424	bdhb:b	(Ljava/lang/String;)Z
    //   2048: istore 13
    //   2050: aload 5
    //   2052: ldc_w 1442
    //   2055: new 49	java/lang/StringBuilder
    //   2058: dup
    //   2059: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   2062: ldc_w 1444
    //   2065: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: aload 5
    //   2070: getfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2073: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2076: ldc_w 1446
    //   2079: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: aload 5
    //   2084: getfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   2087: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2090: ldc_w 1448
    //   2093: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2096: iload 13
    //   2098: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2101: ldc_w 1450
    //   2104: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: iload 12
    //   2109: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2112: ldc_w 1452
    //   2115: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: aload 5
    //   2120: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2123: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2126: ldc_w 1454
    //   2129: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: aload 5
    //   2134: getfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2137: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2140: ldc_w 1456
    //   2143: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2146: invokestatic 1038	bdeu:b	()J
    //   2149: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2152: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2155: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2158: aload 5
    //   2160: getfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2163: ifne +1086 -> 3249
    //   2166: aload 5
    //   2168: getfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   2171: ifeq +1067 -> 3238
    //   2174: iload_0
    //   2175: iconst_3
    //   2176: aload_1
    //   2177: iconst_0
    //   2178: aconst_null
    //   2179: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2182: iload 10
    //   2184: ifne +32 -> 2216
    //   2187: iload 13
    //   2189: ifeq +27 -> 2216
    //   2192: aload 16
    //   2194: invokevirtual 1106	java/io/File:length	()J
    //   2197: aload 17
    //   2199: invokevirtual 1106	java/io/File:length	()J
    //   2202: lcmp
    //   2203: ifgt +13 -> 2216
    //   2206: iload 12
    //   2208: ifne +8 -> 2216
    //   2211: iload 11
    //   2213: ifeq +1366 -> 3579
    //   2216: aload 5
    //   2218: aload 17
    //   2220: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   2223: putfield 1253	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   2226: aload 5
    //   2228: aload 17
    //   2230: invokevirtual 1106	java/io/File:length	()J
    //   2233: putfield 1398	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   2236: aload 5
    //   2238: iconst_0
    //   2239: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   2242: aload 5
    //   2244: iconst_0
    //   2245: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2248: aload 16
    //   2250: ifnull +17 -> 2267
    //   2253: aload 16
    //   2255: invokevirtual 801	java/io/File:exists	()Z
    //   2258: ifeq +9 -> 2267
    //   2261: aload 16
    //   2263: invokevirtual 820	java/io/File:delete	()Z
    //   2266: pop
    //   2267: iload 12
    //   2269: ifne +8 -> 2277
    //   2272: iload 11
    //   2274: ifeq +1138 -> 3412
    //   2277: new 49	java/lang/StringBuilder
    //   2280: dup
    //   2281: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   2284: ldc_w 1458
    //   2287: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2290: aload 17
    //   2292: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2295: ldc_w 1430
    //   2298: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: aload 17
    //   2303: invokevirtual 1106	java/io/File:length	()J
    //   2306: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2309: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2312: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   2315: ldc_w 1376
    //   2318: iconst_0
    //   2319: ldc_w 1376
    //   2322: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2325: aload 5
    //   2327: ldc_w 1460
    //   2330: ldc_w 1462
    //   2333: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2336: aload 14
    //   2338: athrow
    //   2339: iconst_0
    //   2340: istore 10
    //   2342: goto -1836 -> 506
    //   2345: iload_0
    //   2346: iconst_4
    //   2347: aload_1
    //   2348: iconst_0
    //   2349: aconst_null
    //   2350: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2353: goto -1709 -> 644
    //   2356: iload 12
    //   2358: ifne -1714 -> 644
    //   2361: iload 10
    //   2363: ifne -1719 -> 644
    //   2366: iload 11
    //   2368: ifne -1724 -> 644
    //   2371: aload 5
    //   2373: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2376: istore 8
    //   2378: aload 5
    //   2380: iload 8
    //   2382: iconst_1
    //   2383: iadd
    //   2384: putfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2387: iload 8
    //   2389: iconst_2
    //   2390: if_icmpge +33 -> 2423
    //   2393: aload 5
    //   2395: iconst_1
    //   2396: putfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2399: ldc_w 1472
    //   2402: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   2405: iload_0
    //   2406: aload_1
    //   2407: aload_2
    //   2408: aload_3
    //   2409: iload 4
    //   2411: aload 5
    //   2413: iload 6
    //   2415: iload 7
    //   2417: invokestatic 1393	bdhj:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   2420: pop
    //   2421: iconst_0
    //   2422: ireturn
    //   2423: aload 5
    //   2425: getfield 1086	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   2428: ifeq +15 -> 2443
    //   2431: iload_0
    //   2432: bipush 6
    //   2434: aload_1
    //   2435: iconst_0
    //   2436: aconst_null
    //   2437: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2440: goto -1796 -> 644
    //   2443: aload 5
    //   2445: getfield 1474	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   2448: ifeq +15 -> 2463
    //   2451: iload_0
    //   2452: bipush 7
    //   2454: aload_1
    //   2455: iconst_0
    //   2456: aconst_null
    //   2457: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2460: goto -1816 -> 644
    //   2463: aload 5
    //   2465: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2468: ifne +15 -> 2483
    //   2471: iload_0
    //   2472: bipush 9
    //   2474: aload_1
    //   2475: iconst_0
    //   2476: aconst_null
    //   2477: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2480: goto -1836 -> 644
    //   2483: aload 5
    //   2485: getfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2488: ifeq +14 -> 2502
    //   2491: iload_0
    //   2492: iconst_0
    //   2493: aload_1
    //   2494: iconst_0
    //   2495: aconst_null
    //   2496: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2499: goto -1855 -> 644
    //   2502: ldc_w 1476
    //   2505: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   2508: iload_0
    //   2509: iconst_5
    //   2510: aload_1
    //   2511: iconst_0
    //   2512: aconst_null
    //   2513: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2516: goto -1872 -> 644
    //   2519: new 49	java/lang/StringBuilder
    //   2522: dup
    //   2523: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   2526: ldc_w 1478
    //   2529: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2532: aload_3
    //   2533: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2536: ldc_w 1430
    //   2539: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2542: aload 16
    //   2544: invokevirtual 1106	java/io/File:length	()J
    //   2547: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2550: ldc_w 1480
    //   2553: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: aload 17
    //   2558: invokevirtual 1106	java/io/File:length	()J
    //   2561: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2564: ldc_w 1482
    //   2567: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: iload 10
    //   2572: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2575: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2578: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   2581: new 49	java/lang/StringBuilder
    //   2584: dup
    //   2585: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   2588: ldc_w 1484
    //   2591: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2594: iconst_0
    //   2595: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2598: ldc_w 1486
    //   2601: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2604: aload_3
    //   2605: invokestatic 1389	bdhb:a	(Ljava/lang/String;)Z
    //   2608: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2611: ldc_w 1488
    //   2614: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2617: astore_1
    //   2618: aload 16
    //   2620: invokevirtual 1106	java/io/File:length	()J
    //   2623: lconst_0
    //   2624: lcmp
    //   2625: ifgt +36 -> 2661
    //   2628: iconst_1
    //   2629: istore 4
    //   2631: aload_1
    //   2632: iload 4
    //   2634: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2637: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2640: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   2643: iload 12
    //   2645: ifne +22 -> 2667
    //   2648: ldc_w 1376
    //   2651: iconst_1
    //   2652: ldc_w 1376
    //   2655: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2658: goto -1876 -> 782
    //   2661: iconst_0
    //   2662: istore 4
    //   2664: goto -33 -> 2631
    //   2667: ldc_w 1376
    //   2670: iconst_0
    //   2671: ldc_w 1376
    //   2674: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2677: goto -1895 -> 782
    //   2680: aload 5
    //   2682: aload 16
    //   2684: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   2687: putfield 1253	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   2690: aload 5
    //   2692: aload 16
    //   2694: invokevirtual 1106	java/io/File:length	()J
    //   2697: putfield 1398	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   2700: aload 5
    //   2702: iconst_1
    //   2703: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   2706: aload 5
    //   2708: iconst_1
    //   2709: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2712: aload 16
    //   2714: invokestatic 1426	bdhj:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   2717: astore_2
    //   2718: new 49	java/lang/StringBuilder
    //   2721: dup
    //   2722: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   2725: ldc_w 1466
    //   2728: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2731: aload 17
    //   2733: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2736: ldc_w 1468
    //   2739: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2742: aload_3
    //   2743: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2746: ldc_w 1430
    //   2749: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2752: aload 16
    //   2754: invokevirtual 1106	java/io/File:length	()J
    //   2757: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2760: ldc_w 1432
    //   2763: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2766: aload_2
    //   2767: getfield 31	android/graphics/BitmapFactory$Options:outWidth	I
    //   2770: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2773: ldc_w 1434
    //   2776: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2779: aload_2
    //   2780: getfield 34	android/graphics/BitmapFactory$Options:outHeight	I
    //   2783: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2786: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2789: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   2792: aload 5
    //   2794: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2797: ifle +95 -> 2892
    //   2800: new 49	java/lang/StringBuilder
    //   2803: dup
    //   2804: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   2807: ldc_w 1403
    //   2810: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: aload 5
    //   2815: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2818: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2821: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2824: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   2827: iload_0
    //   2828: bipush 8
    //   2830: aload_1
    //   2831: iconst_0
    //   2832: aconst_null
    //   2833: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2836: aload 5
    //   2838: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2841: ifle +62 -> 2903
    //   2844: iconst_1
    //   2845: istore 4
    //   2847: ldc_w 1376
    //   2850: iload 4
    //   2852: ldc_w 1376
    //   2855: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2858: aload 5
    //   2860: ldc_w 1460
    //   2863: new 49	java/lang/StringBuilder
    //   2866: dup
    //   2867: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   2870: ldc_w 1470
    //   2873: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: aload 5
    //   2878: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2881: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2884: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2887: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2890: iconst_1
    //   2891: ireturn
    //   2892: iload_0
    //   2893: iconst_0
    //   2894: aload_1
    //   2895: iconst_1
    //   2896: aconst_null
    //   2897: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2900: goto -64 -> 2836
    //   2903: iconst_0
    //   2904: istore 4
    //   2906: goto -59 -> 2847
    //   2909: iconst_0
    //   2910: istore 11
    //   2912: goto -1187 -> 1725
    //   2915: iload_0
    //   2916: iconst_4
    //   2917: aload_1
    //   2918: iconst_0
    //   2919: aconst_null
    //   2920: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2923: goto -1060 -> 1863
    //   2926: iload 12
    //   2928: ifne -1065 -> 1863
    //   2931: iload 11
    //   2933: ifne -1070 -> 1863
    //   2936: iload 10
    //   2938: ifne -1075 -> 1863
    //   2941: aload 5
    //   2943: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2946: istore 8
    //   2948: aload 5
    //   2950: iload 8
    //   2952: iconst_1
    //   2953: iadd
    //   2954: putfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2957: iload 8
    //   2959: iconst_2
    //   2960: if_icmpge +33 -> 2993
    //   2963: aload 5
    //   2965: iconst_1
    //   2966: putfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2969: ldc_w 1472
    //   2972: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   2975: iload_0
    //   2976: aload_1
    //   2977: aload_2
    //   2978: aload_3
    //   2979: iload 4
    //   2981: aload 5
    //   2983: iload 6
    //   2985: iload 7
    //   2987: invokestatic 1393	bdhj:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   2990: pop
    //   2991: iconst_0
    //   2992: ireturn
    //   2993: aload 5
    //   2995: getfield 1086	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   2998: ifeq +15 -> 3013
    //   3001: iload_0
    //   3002: bipush 6
    //   3004: aload_1
    //   3005: iconst_0
    //   3006: aconst_null
    //   3007: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3010: goto -1147 -> 1863
    //   3013: aload 5
    //   3015: getfield 1474	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   3018: ifeq +15 -> 3033
    //   3021: iload_0
    //   3022: bipush 7
    //   3024: aload_1
    //   3025: iconst_0
    //   3026: aconst_null
    //   3027: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3030: goto -1167 -> 1863
    //   3033: aload 5
    //   3035: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   3038: ifne +15 -> 3053
    //   3041: iload_0
    //   3042: bipush 9
    //   3044: aload_1
    //   3045: iconst_0
    //   3046: aconst_null
    //   3047: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3050: goto -1187 -> 1863
    //   3053: aload 5
    //   3055: getfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   3058: ifeq +14 -> 3072
    //   3061: iload_0
    //   3062: iconst_0
    //   3063: aload_1
    //   3064: iconst_0
    //   3065: aconst_null
    //   3066: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3069: goto -1206 -> 1863
    //   3072: ldc_w 1476
    //   3075: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   3078: iload_0
    //   3079: iconst_5
    //   3080: aload_1
    //   3081: iconst_0
    //   3082: aconst_null
    //   3083: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3086: goto -1223 -> 1863
    //   3089: new 49	java/lang/StringBuilder
    //   3092: dup
    //   3093: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   3096: ldc_w 1478
    //   3099: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: aload_3
    //   3103: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3106: ldc_w 1430
    //   3109: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3112: aload 16
    //   3114: invokevirtual 1106	java/io/File:length	()J
    //   3117: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3120: ldc_w 1480
    //   3123: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3126: aload 17
    //   3128: invokevirtual 1106	java/io/File:length	()J
    //   3131: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3134: ldc_w 1482
    //   3137: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3140: iload 11
    //   3142: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3145: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3148: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   3151: new 49	java/lang/StringBuilder
    //   3154: dup
    //   3155: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   3158: ldc_w 1484
    //   3161: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3164: iconst_1
    //   3165: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3168: ldc_w 1486
    //   3171: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3174: aload_3
    //   3175: invokestatic 1389	bdhb:a	(Ljava/lang/String;)Z
    //   3178: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3181: ldc_w 1488
    //   3184: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3187: astore_1
    //   3188: aload 16
    //   3190: invokevirtual 1106	java/io/File:length	()J
    //   3193: lconst_0
    //   3194: lcmp
    //   3195: ifgt +31 -> 3226
    //   3198: iconst_1
    //   3199: istore 4
    //   3201: aload_1
    //   3202: iload 4
    //   3204: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3207: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3210: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   3213: ldc_w 1376
    //   3216: iconst_1
    //   3217: ldc_w 1376
    //   3220: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3223: goto -1251 -> 1972
    //   3226: iconst_0
    //   3227: istore 4
    //   3229: goto -28 -> 3201
    //   3232: iconst_0
    //   3233: istore 12
    //   3235: goto -1191 -> 2044
    //   3238: iload_0
    //   3239: iconst_4
    //   3240: aload_1
    //   3241: iconst_0
    //   3242: aconst_null
    //   3243: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3246: goto -1064 -> 2182
    //   3249: iload 13
    //   3251: ifne -1069 -> 2182
    //   3254: iload 12
    //   3256: ifne -1074 -> 2182
    //   3259: iload 11
    //   3261: ifne -1079 -> 2182
    //   3264: aload 5
    //   3266: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3269: istore 8
    //   3271: aload 5
    //   3273: iload 8
    //   3275: iconst_1
    //   3276: iadd
    //   3277: putfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3280: iload 8
    //   3282: iconst_2
    //   3283: if_icmpge +33 -> 3316
    //   3286: aload 5
    //   3288: iconst_1
    //   3289: putfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   3292: ldc_w 1472
    //   3295: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   3298: iload_0
    //   3299: aload_1
    //   3300: aload_2
    //   3301: aload_3
    //   3302: iload 4
    //   3304: aload 5
    //   3306: iload 6
    //   3308: iload 7
    //   3310: invokestatic 1393	bdhj:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   3313: pop
    //   3314: iconst_0
    //   3315: ireturn
    //   3316: aload 5
    //   3318: getfield 1086	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   3321: ifeq +15 -> 3336
    //   3324: iload_0
    //   3325: bipush 6
    //   3327: aload_1
    //   3328: iconst_0
    //   3329: aconst_null
    //   3330: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3333: goto -1151 -> 2182
    //   3336: aload 5
    //   3338: getfield 1474	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   3341: ifeq +15 -> 3356
    //   3344: iload_0
    //   3345: bipush 7
    //   3347: aload_1
    //   3348: iconst_0
    //   3349: aconst_null
    //   3350: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3353: goto -1171 -> 2182
    //   3356: aload 5
    //   3358: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   3361: ifne +15 -> 3376
    //   3364: iload_0
    //   3365: bipush 9
    //   3367: aload_1
    //   3368: iconst_0
    //   3369: aconst_null
    //   3370: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3373: goto -1191 -> 2182
    //   3376: aload 5
    //   3378: getfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   3381: ifeq +14 -> 3395
    //   3384: iload_0
    //   3385: iconst_0
    //   3386: aload_1
    //   3387: iconst_0
    //   3388: aconst_null
    //   3389: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3392: goto -1210 -> 2182
    //   3395: ldc_w 1476
    //   3398: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   3401: iload_0
    //   3402: iconst_5
    //   3403: aload_1
    //   3404: iconst_0
    //   3405: aconst_null
    //   3406: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3409: goto -1227 -> 2182
    //   3412: new 49	java/lang/StringBuilder
    //   3415: dup
    //   3416: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   3419: ldc_w 1478
    //   3422: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: aload_3
    //   3426: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3429: ldc_w 1430
    //   3432: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3435: aload 16
    //   3437: invokevirtual 1106	java/io/File:length	()J
    //   3440: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3443: ldc_w 1480
    //   3446: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3449: aload 17
    //   3451: invokevirtual 1106	java/io/File:length	()J
    //   3454: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3457: ldc_w 1482
    //   3460: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3463: iload 12
    //   3465: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3468: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3471: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   3474: new 49	java/lang/StringBuilder
    //   3477: dup
    //   3478: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   3481: ldc_w 1484
    //   3484: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3487: iload 10
    //   3489: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3492: ldc_w 1486
    //   3495: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3498: aload_3
    //   3499: invokestatic 1389	bdhb:a	(Ljava/lang/String;)Z
    //   3502: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3505: ldc_w 1488
    //   3508: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3511: astore_1
    //   3512: aload 16
    //   3514: invokevirtual 1106	java/io/File:length	()J
    //   3517: lconst_0
    //   3518: lcmp
    //   3519: ifgt +41 -> 3560
    //   3522: iconst_1
    //   3523: istore 4
    //   3525: aload_1
    //   3526: iload 4
    //   3528: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3531: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3534: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   3537: iload 10
    //   3539: ifne +8 -> 3547
    //   3542: iload 13
    //   3544: ifne +22 -> 3566
    //   3547: ldc_w 1376
    //   3550: iconst_1
    //   3551: ldc_w 1376
    //   3554: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3557: goto -1232 -> 2325
    //   3560: iconst_0
    //   3561: istore 4
    //   3563: goto -38 -> 3525
    //   3566: ldc_w 1376
    //   3569: iconst_0
    //   3570: ldc_w 1376
    //   3573: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3576: goto -1251 -> 2325
    //   3579: aload 5
    //   3581: aload 16
    //   3583: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   3586: putfield 1253	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   3589: aload 5
    //   3591: aload 16
    //   3593: invokevirtual 1106	java/io/File:length	()J
    //   3596: putfield 1398	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   3599: aload 5
    //   3601: iconst_1
    //   3602: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   3605: aload 5
    //   3607: iconst_1
    //   3608: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   3611: aload 16
    //   3613: invokestatic 1426	bdhj:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   3616: astore_2
    //   3617: new 49	java/lang/StringBuilder
    //   3620: dup
    //   3621: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   3624: ldc_w 1466
    //   3627: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3630: aload 17
    //   3632: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3635: ldc_w 1468
    //   3638: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3641: aload_3
    //   3642: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3645: ldc_w 1430
    //   3648: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3651: aload 16
    //   3653: invokevirtual 1106	java/io/File:length	()J
    //   3656: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3659: ldc_w 1432
    //   3662: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3665: aload_2
    //   3666: getfield 31	android/graphics/BitmapFactory$Options:outWidth	I
    //   3669: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3672: ldc_w 1434
    //   3675: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3678: aload_2
    //   3679: getfield 34	android/graphics/BitmapFactory$Options:outHeight	I
    //   3682: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3685: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3688: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   3691: aload 5
    //   3693: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3696: ifle +95 -> 3791
    //   3699: new 49	java/lang/StringBuilder
    //   3702: dup
    //   3703: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   3706: ldc_w 1403
    //   3709: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3712: aload 5
    //   3714: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3717: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3720: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3723: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   3726: iload_0
    //   3727: bipush 8
    //   3729: aload_1
    //   3730: iconst_0
    //   3731: aconst_null
    //   3732: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3735: aload 5
    //   3737: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3740: ifle +62 -> 3802
    //   3743: iconst_1
    //   3744: istore 4
    //   3746: ldc_w 1376
    //   3749: iload 4
    //   3751: ldc_w 1376
    //   3754: invokestatic 1408	baws:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3757: aload 5
    //   3759: ldc_w 1460
    //   3762: new 49	java/lang/StringBuilder
    //   3765: dup
    //   3766: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   3769: ldc_w 1470
    //   3772: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3775: aload 5
    //   3777: getfield 1401	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3780: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3783: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3786: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3789: iconst_1
    //   3790: ireturn
    //   3791: iload_0
    //   3792: iconst_0
    //   3793: aload_1
    //   3794: iconst_1
    //   3795: aconst_null
    //   3796: invokestatic 1405	bdhj:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3799: goto -64 -> 3735
    //   3802: iconst_0
    //   3803: istore 4
    //   3805: goto -59 -> 3746
    //   3808: astore 15
    //   3810: goto -3408 -> 402
    //   3813: astore 15
    //   3815: goto -2129 -> 1686
    //   3818: astore 14
    //   3820: iconst_0
    //   3821: istore 11
    //   3823: iconst_0
    //   3824: istore 10
    //   3826: goto -1803 -> 2023
    //   3829: astore 14
    //   3831: iload 10
    //   3833: istore 11
    //   3835: iload 12
    //   3837: istore 10
    //   3839: goto -1816 -> 2023
    //   3842: astore 14
    //   3844: iconst_0
    //   3845: istore 10
    //   3847: goto -2152 -> 1695
    //   3850: astore 14
    //   3852: goto -2176 -> 1676
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3855	0	paramInt1	int
    //   0	3855	1	paramContext	Context
    //   0	3855	2	paramString1	String
    //   0	3855	3	paramString2	String
    //   0	3855	4	paramBoolean1	boolean
    //   0	3855	5	paramImageInfo	ImageInfo
    //   0	3855	6	paramInt2	int
    //   0	3855	7	paramBoolean2	boolean
    //   407	2877	8	i	int
    //   414	1585	9	j	int
    //   504	3342	10	bool1	boolean
    //   319	3515	11	bool2	boolean
    //   510	3326	12	bool3	boolean
    //   2048	1495	13	bool4	boolean
    //   54	356	14	localObject1	Object
    //   1671	16	14	localObject2	Object
    //   1689	1	14	localIOException1	IOException
    //   2018	319	14	localObject3	Object
    //   3818	1	14	localObject4	Object
    //   3829	1	14	localObject5	Object
    //   3842	1	14	localIOException2	IOException
    //   3850	1	14	localObject6	Object
    //   381	1301	15	localBufferedInputStream	java.io.BufferedInputStream
    //   3808	1	15	localIOException3	IOException
    //   3813	1	15	localIOException4	IOException
    //   92	3560	16	localFile1	File
    //   102	3529	17	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   362	383	1671	finally
    //   321	328	1689	java/io/IOException
    //   333	362	1689	java/io/IOException
    //   402	416	1689	java/io/IOException
    //   456	485	1689	java/io/IOException
    //   1686	1689	1689	java/io/IOException
    //   1986	2015	1689	java/io/IOException
    //   321	328	2018	finally
    //   333	362	2018	finally
    //   397	402	2018	finally
    //   402	416	2018	finally
    //   456	485	2018	finally
    //   1681	1686	2018	finally
    //   1686	1689	2018	finally
    //   1986	2015	2018	finally
    //   397	402	3808	java/io/IOException
    //   1681	1686	3813	java/io/IOException
    //   201	314	3818	finally
    //   314	321	3818	finally
    //   795	806	3818	finally
    //   1698	1704	3829	finally
    //   201	314	3842	java/io/IOException
    //   314	321	3842	java/io/IOException
    //   795	806	3842	java/io/IOException
    //   383	392	3850	finally
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "image_upload";
    }
    if (!bdhb.b(paramString1)) {
      try
      {
        if (!bdhb.a(paramString1))
        {
          if (QLog.isColorLevel()) {
            QLog.e(str, 2, paramString3 + ",filePath not exist,filePath=" + paramString1);
          }
          throw new RuntimeException(paramString3 + " file not exists,path=" + paramString1);
        }
      }
      catch (Exception paramString2)
      {
        paramString2 = baqo.a(paramString2);
        if (!bdhb.a(paramString1))
        {
          a(paramInt, 1, paramContext, false, "report_sendphoto_file_error", paramString2);
          return false;
          if (QLog.isColorLevel()) {
            QLog.e(str, 2, paramString3 + ",filePath size is 0,filePath=" + paramString1);
          }
          throw new RuntimeException(paramString3 + " file size==0,path=" + paramString1);
        }
        a(paramInt, 2, paramContext, false, "report_sendphoto_file_error", paramString2);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(str, 2, paramString3 + ",filePath not exist,filePath=" + paramString1);
    }
    a(paramInt, 0, paramContext, true, "report_sendphoto_file_error");
    return true;
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, int paramInt, File paramFile)
  {
    // Byte code:
    //   0: new 194	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 1299	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 798	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 801	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_3
    //   20: invokevirtual 1302	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_3
    //   27: invokevirtual 814	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 801	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_2
    //   39: invokevirtual 1305	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 817	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: new 964	java/io/BufferedOutputStream
    //   53: dup
    //   54: new 966	java/io/FileOutputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 970	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_3
    //   66: aload_3
    //   67: astore_2
    //   68: aload_0
    //   69: getstatic 976	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   72: iload_1
    //   73: aload_3
    //   74: invokevirtual 980	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   77: pop
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: invokevirtual 1308	java/io/BufferedOutputStream:flush	()V
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 1309	java/io/BufferedOutputStream:close	()V
    //   92: iconst_1
    //   93: ireturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 1309	java/io/BufferedOutputStream:close	()V
    //   108: aload_0
    //   109: athrow
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_2
    //   113: goto -13 -> 100
    //   116: astore_0
    //   117: aload_3
    //   118: astore_2
    //   119: goto -22 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramBitmap	Bitmap
    //   0	122	1	paramInt	int
    //   0	122	2	paramFile	File
    //   11	107	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   50	66	94	java/io/IOException
    //   68	78	99	finally
    //   80	84	99	finally
    //   97	99	99	finally
    //   50	66	110	finally
    //   68	78	116	java/io/IOException
    //   80	84	116	java/io/IOException
  }
  
  public static boolean a(Bitmap paramBitmap, File paramFile)
  {
    return b(paramBitmap, 100, paramFile);
  }
  
  public static boolean a(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2)
  {
    return a(paramExifInterface1, paramExifInterface2, true);
  }
  
  public static boolean a(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2, boolean paramBoolean)
  {
    if ((paramExifInterface1 == null) || (paramExifInterface2 == null)) {
      return false;
    }
    paramBoolean = bazk.a();
    String str3 = paramExifInterface1.getAttribute("DateTime");
    String str4 = paramExifInterface1.getAttribute("Flash");
    String str5 = paramExifInterface1.getAttribute("FocalLength");
    String str6 = paramExifInterface1.getAttribute("GPSAltitude");
    String str7 = paramExifInterface1.getAttribute("GPSAltitudeRef");
    String str8 = paramExifInterface1.getAttribute("GPSDateStamp");
    String str9 = paramExifInterface1.getAttribute("GPSLatitude");
    String str10 = paramExifInterface1.getAttribute("GPSLatitudeRef");
    String str11 = paramExifInterface1.getAttribute("GPSLongitude");
    String str12 = paramExifInterface1.getAttribute("GPSLongitudeRef");
    String str13 = paramExifInterface1.getAttribute("GPSProcessingMethod");
    String str14 = paramExifInterface1.getAttribute("GPSTimeStamp");
    String str1 = paramExifInterface1.getAttribute("ImageLength");
    String str2 = paramExifInterface1.getAttribute("ImageWidth");
    String str15 = paramExifInterface1.getAttribute("ISOSpeedRatings");
    String str16 = paramExifInterface1.getAttribute("Make");
    String str17 = paramExifInterface1.getAttribute("Model");
    String str18 = paramExifInterface1.getAttribute("WhiteBalance");
    String str19 = paramExifInterface1.getAttribute("UserComment");
    paramExifInterface1 = paramExifInterface1.getAttribute("ImageDescription");
    if ((paramExifInterface1 != null) && (QLog.isColorLevel())) {
      QLog.d("ImageUtil", 2, "E D = " + paramExifInterface1);
    }
    if ((str3 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("DateTime", str3);
    }
    for (;;)
    {
      if (str4 != null) {
        paramExifInterface2.setAttribute("Flash", str4);
      }
      if (str5 != null) {
        paramExifInterface2.setAttribute("FocalLength", str5);
      }
      if ((str6 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSAltitude", str6);
      }
      if ((str7 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSAltitudeRef", str7);
      }
      if ((str8 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSDateStamp", str8);
      }
      if ((str9 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSLatitude", str9);
      }
      if ((str10 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSLatitudeRef", str10);
      }
      if ((str11 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSLongitude", str11);
      }
      if ((str12 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSLongitudeRef", str12);
      }
      if ((str13 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSProcessingMethod", str13);
      }
      if ((str14 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSTimeStamp", str14);
      }
      if (str1 != null) {
        paramExifInterface2.setAttribute("ImageLength", str1);
      }
      if (str2 != null) {
        paramExifInterface2.setAttribute("ImageWidth", str2);
      }
      if (str15 != null) {
        paramExifInterface2.setAttribute("ISOSpeedRatings", str15);
      }
      if ((str16 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("Make", str16);
      }
      if ((str17 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("Model", str17);
      }
      if (str18 != null) {
        paramExifInterface2.setAttribute("WhiteBalance", str18);
      }
      if ((str19 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("UserComment", str19);
      }
      if (asrc.a().g()) {}
      try
      {
        paramExifInterface1 = new JSONObject();
        if (str1 != null) {
          paramExifInterface1.put("ImageLength", str1);
        }
        if (str2 != null) {
          paramExifInterface1.put("ImageWidth", str2);
        }
        paramExifInterface2.setAttribute("ImageDescription", paramExifInterface1.toString());
        if (QLog.isColorLevel()) {
          QLog.d("ImageUtil", 2, "s E D = " + paramExifInterface1.toString());
        }
      }
      catch (Throwable paramExifInterface1)
      {
        for (;;)
        {
          a("F s d " + paramExifInterface1.getMessage());
        }
      }
      try
      {
        paramExifInterface2.saveAttributes();
        return true;
      }
      catch (Exception paramExifInterface1)
      {
        a("Failed to save EXIF. " + paramExifInterface1.getMessage());
      }
      paramExifInterface2.setAttribute("DateTime", "");
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (!bdhb.b(paramString)) {}
    for (;;)
    {
      return false;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0)) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      catch (OutOfMemoryError paramString) {}
    }
    return false;
  }
  
  public static boolean a(String paramString, double paramDouble1, double paramDouble2)
  {
    if ((paramString != null) && (!JpegExifReader.isCrashJpeg(paramString))) {}
    for (;;)
    {
      try
      {
        ExifInterface localExifInterface = new ExifInterface(paramString);
        localExifInterface.setAttribute("GPSLatitude", a(paramDouble1));
        if (paramDouble1 > 0.0D)
        {
          paramString = "N";
          localExifInterface.setAttribute("GPSLatitudeRef", paramString);
          localExifInterface.setAttribute("GPSLongitude", a(paramDouble2));
          if (paramDouble2 > 0.0D)
          {
            paramString = "E";
            localExifInterface.setAttribute("GPSLongitudeRef", paramString);
            localExifInterface.saveAttributes();
            if (QLog.isDevelopLevel()) {
              QLog.d("ImageUtil", 4, "[updateLBSExif]GPSLatitude = " + localExifInterface.getAttribute("GPSLatitude") + ", GPSLongitude = " + localExifInterface.getAttribute("GPSLongitude"));
            }
          }
          else
          {
            paramString = "W";
            continue;
          }
          return true;
        }
      }
      catch (NullPointerException paramString)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ImageUtil", 4, "[updateLBSExif] failed");
        }
        return false;
      }
      catch (IOException paramString)
      {
        continue;
      }
      paramString = "S";
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!paramString1.equals(paramString2))
      {
        bool1 = bool2;
        if (JpegExifReader.isCrashJpeg(paramString1)) {}
      }
    }
    try
    {
      paramString1 = new ExifInterface(paramString1);
      ExifInterface localExifInterface = new ExifInterface(paramString2);
      int i = paramString1.getAttributeInt("Orientation", 0);
      localExifInterface.setAttribute("Orientation", i + "");
      paramString2 = paramString1.getAttribute("DateTime");
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localExifInterface.setAttribute("DateTime", paramString1);
      localExifInterface.saveAttributes();
      bool1 = true;
    }
    catch (IOException paramString1)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("ImageUtil", 2, "copyExif ", paramString1);
      return false;
    }
    catch (UnsupportedOperationException paramString1)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("ImageUtil", 2, "copyExif ", paramString1);
    }
    return bool1;
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (JpegExifReader.isCrashJpeg(paramString1))) {
      return false;
    }
    try
    {
      paramString1 = new ExifInterface(paramString1);
      paramString1.setAttribute("Orientation", paramString3);
      paramString1.saveAttributes();
      if (QLog.isDevelopLevel()) {
        QLog.d("ImageUtil", 4, "[updateExif]tag=" + paramString2 + ", value=" + paramString3);
      }
      return true;
    }
    catch (UnsupportedOperationException paramString1)
    {
      return false;
    }
    catch (NullPointerException paramString1)
    {
      return false;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  private static String[] a()
  {
    if (jdField_a_of_type_ArrayOfJavaLangString != null) {
      return jdField_a_of_type_ArrayOfJavaLangString;
    }
    String[] arrayOfString = baws.b();
    jdField_a_of_type_ArrayOfJavaLangString = new String[arrayOfString.length + 1];
    int i = 0;
    while (i < arrayOfString.length)
    {
      jdField_a_of_type_ArrayOfJavaLangString[i] = arrayOfString[i];
      i += 1;
    }
    jdField_a_of_type_ArrayOfJavaLangString[(jdField_a_of_type_ArrayOfJavaLangString.length - 1)] = "ImageUtil";
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public static int b(String paramString)
  {
    if (aiub.c(paramString))
    {
      switch (Utils.getHeifOrientation(paramString))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    return JpegExifReader.getRotationDegree(paramString);
  }
  
  public static Bitmap b()
  {
    String str;
    if (azmk.a()) {
      str = "static://DefaultPhoneContactFace_square";
    }
    for (int i = 2130840163;; i = 2130840162)
    {
      if (BaseApplicationImpl.sImageCache != null) {}
      for (Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str);; localBitmap1 = null)
      {
        Bitmap localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap1 = bdal.b(BaseApplicationImpl.getApplication().getResources(), i);
          if ((localBitmap1 != null) && (BaseApplicationImpl.sImageCache != null)) {
            BaseApplicationImpl.sImageCache.put(str, localBitmap1);
          }
          localBitmap2 = localBitmap1;
          if (QLog.isColorLevel())
          {
            QLog.d("ImageUtil", 2, "getDefaultPhoneContactBitmap, bitmap=" + localBitmap1);
            localBitmap2 = localBitmap1;
          }
        }
        return localBitmap2;
      }
      str = "static://DefaultPhoneContactFace";
    }
  }
  
  public static Bitmap b(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt == 102)
    {
      localObject2 = localObject1;
      if (BaseApplicationImpl.sImageCache != null) {
        localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://DefaultDataLineFace");
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = bdal.b(BaseApplicationImpl.getApplication().getResources(), 2130843834);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put("static://DefaultDataLineFace", localObject2, (byte)0);
            localObject1 = localObject2;
          }
        }
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
            return localObject1;
            localObject1 = localObject3;
          } while (paramInt != 107);
          if (BaseApplicationImpl.sImageCache != null) {
            localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://DefaultDataLineFaceIpad");
          }
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject2 = bdal.b(BaseApplicationImpl.getApplication().getResources(), 2130843832);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (BaseApplicationImpl.sImageCache == null);
    BaseApplicationImpl.sImageCache.put("static://DefaultDataLineFaceIpad", localObject2, (byte)0);
    return localObject2;
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    int m;
    int i;
    int j;
    if (paramBitmap != null)
    {
      k = paramBitmap.getWidth();
      m = paramBitmap.getHeight();
      if (k <= m) {
        break label63;
      }
      i = m;
      if (k <= m) {
        break label68;
      }
      j = (k - m) / 2;
      label40:
      if (k <= m) {
        break label73;
      }
    }
    label63:
    label68:
    label73:
    for (int k = 0;; k = (m - k) / 2)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, j, k, i, i, null, false);
      return localBitmap;
      i = k;
      break;
      j = 0;
      break label40;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    double d2 = Math.toRadians(paramFloat);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    double d1 = Math.abs(Math.cos(d2));
    d2 = Math.abs(Math.sin(d2));
    int k = (int)(j * d2 + i * d1);
    int m = (int)(d2 * i + d1 * j);
    float f1 = (k - i) / 2.0F;
    float f2 = (m - j) / 2.0F;
    Bitmap localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.rotate(paramFloat, k / 2.0F, m / 2.0F);
    localCanvas.drawBitmap(paramBitmap, f1, f2, null);
    return localBitmap;
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap.setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = 0;
    Object localObject;
    if ((paramBitmap == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int m;
      int k;
      try
      {
        m = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        localObject = new Paint();
        if (m <= paramInt1) {
          break label272;
        }
        i = (m - paramInt1) / 2;
        if (k <= paramInt2) {
          break label292;
        }
        j = (k - paramInt2) / 2;
      }
      catch (Throwable paramBitmap)
      {
        Rect localRect1;
        Rect localRect2;
        RectF localRectF;
        Bitmap localBitmap;
        Canvas localCanvas;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ImageUtil", 2, "getClipCenterRectBitmap throw error ... " + paramBitmap.getMessage());
        return null;
      }
      localRect1 = new Rect(i, j, paramInt1, paramInt2);
      localRect2 = new Rect(0, 0, paramInt1 - i, paramInt2 - j);
      localRectF = new RectF(localRect2);
      localBitmap = Bitmap.createBitmap(localRect2.right, localRect2.bottom, Bitmap.Config.RGB_565);
      localCanvas = new Canvas(localBitmap);
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setDither(true);
      ((Paint)localObject).setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      ((Paint)localObject).setColor(-12434878);
      localCanvas.drawRect(localRectF, (Paint)localObject);
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, (Paint)localObject);
      localObject = localBitmap;
      if (paramBitmap.isRecycled()) {
        break;
      }
      paramBitmap.recycle();
      return localBitmap;
      label272:
      int i = 0;
      continue;
      label277:
      for (paramInt1 = i + paramInt1; j + paramInt2 <= k; paramInt1 = m)
      {
        paramInt2 = j + paramInt2;
        break;
        label292:
        if (i + paramInt1 <= m) {
          break label277;
        }
      }
      paramInt2 = k;
    }
  }
  
  public static Bitmap b(Drawable paramDrawable)
  {
    Bitmap localBitmap = null;
    Object localObject;
    if (paramDrawable == null) {
      localObject = localBitmap;
    }
    for (;;)
    {
      return localObject;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      localObject = localBitmap;
      if (i <= 0) {
        continue;
      }
      localObject = localBitmap;
      if (j <= 0) {
        continue;
      }
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
        {
          localBitmap = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
          localObject = localBitmap;
          if (localBitmap == null) {
            break;
          }
          localObject = new Canvas(localBitmap);
          paramDrawable.setBounds(0, 0, i, j);
          paramDrawable.draw((Canvas)localObject);
          return localBitmap;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  public static Drawable b()
  {
    return new BitmapDrawable(a());
  }
  
  public static Drawable b(int paramInt)
  {
    return new BitmapDrawable(b(paramInt));
  }
  
  public static String b(Context paramContext, Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(paramContext, paramUri);
  }
  
  public static String b(Context paramContext, String paramString, int paramInt)
  {
    String str = alof.aX + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    int j = 600;
    int i = 800;
    try
    {
      a(paramContext, paramString, str, 600, 800);
      int k = 0;
      for (;;)
      {
        localObject1 = new File(str);
        if ((localObject1 == null) || (((File)localObject1).length() <= paramInt) || (k >= 3)) {
          break;
        }
        k += 1;
        j -= 100;
        i -= 100;
        a(paramContext, paramString, str, Math.max(100, j), Math.max(100, i));
      }
      localObject2 = a(paramContext, Uri.parse(paramString));
    }
    catch (Exception paramContext)
    {
      a("compressImageForGroup exception", paramContext);
      return paramString;
    }
    Object localObject1 = a(paramContext, Uri.parse(str));
    Object localObject2 = new File((String)localObject2);
    if (((File)localObject2).exists()) {
      ((File)localObject2).renameTo(new File((String)localObject1));
    } else {
      a(paramContext, str, (String)localObject1, 160, 160);
    }
    return str;
  }
  
  /* Error */
  private static void b(int paramInt1, Context paramContext, File paramFile1, File paramFile2, ImageInfo paramImageInfo, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc_w 1063
    //   5: new 49	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 1705
    //   15: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload 7
    //   20: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 1067
    //   26: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 4
    //   42: iconst_1
    //   43: putfield 1707	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Boolean	Z
    //   46: aload_2
    //   47: invokevirtual 197	java/io/File:getPath	()Ljava/lang/String;
    //   50: invokestatic 1364	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   53: astore 20
    //   55: getstatic 1110	com/tencent/common/config/AppSetting:jdField_c_of_type_Int	I
    //   58: i2l
    //   59: lstore 14
    //   61: aload 4
    //   63: getfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   66: ifeq +8 -> 74
    //   69: aload 20
    //   71: ifnonnull +395 -> 466
    //   74: aload 4
    //   76: ldc_w 1063
    //   79: ldc_w 1709
    //   82: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   85: iload 5
    //   87: sipush 1001
    //   90: if_icmpeq +15 -> 105
    //   93: lload 14
    //   95: lstore 16
    //   97: iload 5
    //   99: sipush 10002
    //   102: if_icmpne +52 -> 154
    //   105: lload 14
    //   107: lstore 16
    //   109: aload_1
    //   110: ifnull +44 -> 154
    //   113: lload 14
    //   115: lstore 16
    //   117: aload_1
    //   118: instanceof 219
    //   121: ifeq +33 -> 154
    //   124: lload 14
    //   126: lstore 16
    //   128: aload_1
    //   129: checkcast 219	com/tencent/mobileqq/app/BaseActivity
    //   132: invokevirtual 223	com/tencent/mobileqq/app/BaseActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   135: checkcast 225	com/tencent/mobileqq/app/QQAppInterface
    //   138: aload 4
    //   140: getfield 1260	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   143: invokevirtual 1262	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;)Z
    //   146: ifeq +8 -> 154
    //   149: invokestatic 1255	bazm:a	()J
    //   152: lstore 16
    //   154: iload 5
    //   156: ifne +240 -> 396
    //   159: aload_2
    //   160: invokevirtual 1106	java/io/File:length	()J
    //   163: invokestatic 1255	bazm:a	()J
    //   166: lcmp
    //   167: ifle +229 -> 396
    //   170: iconst_1
    //   171: istore 11
    //   173: iload 5
    //   175: sipush 1001
    //   178: if_icmpeq +11 -> 189
    //   181: iload 5
    //   183: sipush 10002
    //   186: if_icmpne +216 -> 402
    //   189: aload_2
    //   190: invokevirtual 1106	java/io/File:length	()J
    //   193: lload 16
    //   195: lcmp
    //   196: ifle +206 -> 402
    //   199: iconst_1
    //   200: istore 12
    //   202: iload 5
    //   204: iconst_1
    //   205: if_icmpeq +11 -> 216
    //   208: iload 5
    //   210: sipush 3000
    //   213: if_icmpne +195 -> 408
    //   216: aload_2
    //   217: invokevirtual 1106	java/io/File:length	()J
    //   220: invokestatic 1137	bazm:b	()J
    //   223: lcmp
    //   224: ifle +184 -> 408
    //   227: iconst_1
    //   228: istore 13
    //   230: iload 11
    //   232: ifne +13 -> 245
    //   235: iload 12
    //   237: ifne +8 -> 245
    //   240: iload 13
    //   242: ifeq +172 -> 414
    //   245: aload 4
    //   247: ldc_w 1063
    //   250: new 49	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   257: ldc_w 1711
    //   260: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_2
    //   264: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: ldc_w 1713
    //   270: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload 11
    //   275: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   278: ldc_w 1715
    //   281: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: iload 12
    //   286: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: ldc_w 1717
    //   292: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload 13
    //   297: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   300: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   306: iload_0
    //   307: aload_1
    //   308: aload_2
    //   309: aload_3
    //   310: aload 4
    //   312: iload 5
    //   314: iload 6
    //   316: iload 7
    //   318: iload 8
    //   320: iload 9
    //   322: invokestatic 1492	bdhj:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   325: return
    //   326: astore 18
    //   328: new 49	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 1719
    //   338: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_2
    //   342: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   351: aconst_null
    //   352: astore 20
    //   354: aload_1
    //   355: invokestatic 873	bdin:a	(Landroid/content/Context;)Z
    //   358: ifeq +18 -> 376
    //   361: aload 4
    //   363: iconst_1
    //   364: putfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   367: aload 4
    //   369: iconst_0
    //   370: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   373: goto -318 -> 55
    //   376: iload_0
    //   377: aload_1
    //   378: aload_2
    //   379: aload_3
    //   380: aload 4
    //   382: iload 5
    //   384: iload 6
    //   386: iload 7
    //   388: iload 8
    //   390: iload 9
    //   392: invokestatic 1492	bdhj:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   395: return
    //   396: iconst_0
    //   397: istore 11
    //   399: goto -226 -> 173
    //   402: iconst_0
    //   403: istore 12
    //   405: goto -203 -> 202
    //   408: iconst_0
    //   409: istore 13
    //   411: goto -181 -> 230
    //   414: aload 4
    //   416: iconst_1
    //   417: putfield 242	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   420: aload 4
    //   422: iconst_0
    //   423: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   426: iload 5
    //   428: ifne +9 -> 437
    //   431: aload 4
    //   433: iconst_2
    //   434: putfield 249	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Int	I
    //   437: aload 4
    //   439: ldc_w 1063
    //   442: new 49	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 1721
    //   452: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_2
    //   456: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   465: return
    //   466: aload_1
    //   467: invokestatic 873	bdin:a	(Landroid/content/Context;)Z
    //   470: ifeq +279 -> 749
    //   473: bipush 80
    //   475: istore 10
    //   477: aconst_null
    //   478: astore 19
    //   480: new 966	java/io/FileOutputStream
    //   483: dup
    //   484: aload_3
    //   485: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   488: astore 18
    //   490: aload 18
    //   492: astore 19
    //   494: aload 4
    //   496: aload 20
    //   498: getstatic 993	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   501: iload 10
    //   503: aload 18
    //   505: invokevirtual 980	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   508: putfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   511: aload 18
    //   513: astore 19
    //   515: aload 4
    //   517: iconst_1
    //   518: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   521: aload 18
    //   523: astore 19
    //   525: aload 4
    //   527: getfield 1091	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   530: ifeq +607 -> 1137
    //   533: aload 18
    //   535: astore 19
    //   537: aload 18
    //   539: invokestatic 1097	bdhj:a	(Ljava/io/FileOutputStream;)V
    //   542: goto +595 -> 1137
    //   545: lload 16
    //   547: l2i
    //   548: istore 10
    //   550: aload 18
    //   552: astore 19
    //   554: ldc_w 1723
    //   557: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   560: aload 18
    //   562: astore 19
    //   564: aload_3
    //   565: invokevirtual 1106	java/io/File:length	()J
    //   568: iload 10
    //   570: i2l
    //   571: lcmp
    //   572: ifle +559 -> 1131
    //   575: aload 18
    //   577: astore 19
    //   579: aload_2
    //   580: invokestatic 1120	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   583: istore 11
    //   585: iload 11
    //   587: ifne +544 -> 1131
    //   590: iconst_1
    //   591: istore 10
    //   593: aload 18
    //   595: ifnull +8 -> 603
    //   598: aload 18
    //   600: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   603: aload 20
    //   605: ifnull +523 -> 1128
    //   608: aload 20
    //   610: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   613: ifne +515 -> 1128
    //   616: aload 20
    //   618: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   621: iload 10
    //   623: ifeq -298 -> 325
    //   626: aload_3
    //   627: invokevirtual 801	java/io/File:exists	()Z
    //   630: ifeq +449 -> 1079
    //   633: aload_3
    //   634: invokevirtual 820	java/io/File:delete	()Z
    //   637: ifeq +442 -> 1079
    //   640: aload_3
    //   641: invokevirtual 817	java/io/File:createNewFile	()Z
    //   644: ifeq +435 -> 1079
    //   647: iconst_1
    //   648: istore 11
    //   650: aload 4
    //   652: ldc_w 1063
    //   655: new 49	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 1725
    //   665: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_3
    //   669: invokevirtual 1106	java/io/File:length	()J
    //   672: invokevirtual 883	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: ldc_w 1727
    //   678: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: iload 11
    //   683: invokevirtual 1102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   686: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 1070	bdhj:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   692: iload 11
    //   694: ifeq -369 -> 325
    //   697: aload 4
    //   699: iconst_0
    //   700: putfield 1074	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   703: aload 4
    //   705: iconst_0
    //   706: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   709: aload 4
    //   711: iconst_0
    //   712: putfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   715: iload_0
    //   716: aload_1
    //   717: aload_2
    //   718: aload_3
    //   719: aload 4
    //   721: iload 5
    //   723: iload 6
    //   725: iload 7
    //   727: iload 8
    //   729: iload 9
    //   731: invokestatic 1492	bdhj:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   734: return
    //   735: astore_1
    //   736: ldc_w 1729
    //   739: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   742: aload 4
    //   744: iconst_0
    //   745: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   748: return
    //   749: bipush 70
    //   751: istore 10
    //   753: goto -276 -> 477
    //   756: aload 18
    //   758: astore 19
    //   760: invokestatic 1137	bazm:b	()J
    //   763: lstore 16
    //   765: goto -220 -> 545
    //   768: astore 18
    //   770: new 49	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   777: ldc_w 1731
    //   780: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload 18
    //   785: invokevirtual 1140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   788: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   797: goto -194 -> 603
    //   800: astore 18
    //   802: aconst_null
    //   803: astore 18
    //   805: ldc_w 1733
    //   808: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   811: aload 4
    //   813: iconst_0
    //   814: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   817: aload 4
    //   819: invokestatic 1127	bdhj:a	()Z
    //   822: putfield 1130	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   825: aload 18
    //   827: ifnull +8 -> 835
    //   830: aload 18
    //   832: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   835: aload_3
    //   836: ifnull +8 -> 844
    //   839: aload_3
    //   840: invokevirtual 820	java/io/File:delete	()Z
    //   843: pop
    //   844: aload 20
    //   846: ifnull +276 -> 1122
    //   849: aload 20
    //   851: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   854: ifne +268 -> 1122
    //   857: aload 20
    //   859: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   862: iconst_0
    //   863: istore 10
    //   865: goto -244 -> 621
    //   868: astore 18
    //   870: new 49	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 1731
    //   880: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload 18
    //   885: invokevirtual 1140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   888: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   897: goto -62 -> 835
    //   900: astore 18
    //   902: aconst_null
    //   903: astore 18
    //   905: aload 18
    //   907: astore 19
    //   909: ldc_w 1735
    //   912: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   915: aload 4
    //   917: iconst_1
    //   918: putfield 245	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   921: aload 4
    //   923: iconst_0
    //   924: putfield 1094	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   927: aload 18
    //   929: ifnull +8 -> 937
    //   932: aload 18
    //   934: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   937: aload_3
    //   938: ifnull +8 -> 946
    //   941: aload_3
    //   942: invokevirtual 820	java/io/File:delete	()Z
    //   945: pop
    //   946: aload 20
    //   948: ifnull +174 -> 1122
    //   951: aload 20
    //   953: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   956: ifne +166 -> 1122
    //   959: aload 20
    //   961: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   964: iconst_0
    //   965: istore 10
    //   967: goto -346 -> 621
    //   970: astore 18
    //   972: new 49	java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   979: ldc_w 1731
    //   982: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: aload 18
    //   987: invokevirtual 1140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   990: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   996: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   999: goto -62 -> 937
    //   1002: astore_1
    //   1003: iconst_0
    //   1004: istore_0
    //   1005: aload 19
    //   1007: astore_2
    //   1008: aload_2
    //   1009: ifnull +7 -> 1016
    //   1012: aload_2
    //   1013: invokevirtual 1107	java/io/FileOutputStream:close	()V
    //   1016: iload_0
    //   1017: ifeq +12 -> 1029
    //   1020: aload_3
    //   1021: ifnull +8 -> 1029
    //   1024: aload_3
    //   1025: invokevirtual 820	java/io/File:delete	()Z
    //   1028: pop
    //   1029: aload 20
    //   1031: ifnull +16 -> 1047
    //   1034: aload 20
    //   1036: invokevirtual 500	android/graphics/Bitmap:isRecycled	()Z
    //   1039: ifne +8 -> 1047
    //   1042: aload 20
    //   1044: invokevirtual 507	android/graphics/Bitmap:recycle	()V
    //   1047: aload_1
    //   1048: athrow
    //   1049: astore_2
    //   1050: new 49	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1057: ldc_w 1731
    //   1060: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload_2
    //   1064: invokevirtual 1140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1067: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: invokestatic 68	bdhj:a	(Ljava/lang/String;)V
    //   1076: goto -60 -> 1016
    //   1079: iconst_0
    //   1080: istore 11
    //   1082: goto -432 -> 650
    //   1085: astore_1
    //   1086: aload 19
    //   1088: astore_2
    //   1089: iconst_0
    //   1090: istore_0
    //   1091: goto -83 -> 1008
    //   1094: astore_1
    //   1095: aload 18
    //   1097: astore_2
    //   1098: iconst_0
    //   1099: istore_0
    //   1100: goto -92 -> 1008
    //   1103: astore_1
    //   1104: aload 18
    //   1106: astore_2
    //   1107: iconst_1
    //   1108: istore_0
    //   1109: goto -101 -> 1008
    //   1112: astore 19
    //   1114: goto -209 -> 905
    //   1117: astore 19
    //   1119: goto -314 -> 805
    //   1122: iconst_0
    //   1123: istore 10
    //   1125: goto -504 -> 621
    //   1128: goto -507 -> 621
    //   1131: iconst_0
    //   1132: istore 10
    //   1134: goto -541 -> 593
    //   1137: iload 5
    //   1139: iconst_1
    //   1140: if_icmpeq +27 -> 1167
    //   1143: iload 5
    //   1145: sipush 1001
    //   1148: if_icmpeq +19 -> 1167
    //   1151: iload 5
    //   1153: sipush 10002
    //   1156: if_icmpeq +11 -> 1167
    //   1159: iload 5
    //   1161: sipush 3000
    //   1164: if_icmpne -33 -> 1131
    //   1167: lload 14
    //   1169: lstore 16
    //   1171: iload 5
    //   1173: sipush 1001
    //   1176: if_icmpeq -631 -> 545
    //   1179: iload 5
    //   1181: sipush 10002
    //   1184: if_icmpne -428 -> 756
    //   1187: lload 14
    //   1189: lstore 16
    //   1191: goto -646 -> 545
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1194	0	paramInt1	int
    //   0	1194	1	paramContext	Context
    //   0	1194	2	paramFile1	File
    //   0	1194	3	paramFile2	File
    //   0	1194	4	paramImageInfo	ImageInfo
    //   0	1194	5	paramInt2	int
    //   0	1194	6	paramInt3	int
    //   0	1194	7	paramInt4	int
    //   0	1194	8	paramBoolean1	boolean
    //   0	1194	9	paramBoolean2	boolean
    //   475	658	10	i	int
    //   171	910	11	bool1	boolean
    //   200	204	12	bool2	boolean
    //   228	182	13	bool3	boolean
    //   59	1129	14	l1	long
    //   95	1095	16	l2	long
    //   326	1	18	localOutOfMemoryError1	OutOfMemoryError
    //   488	269	18	localFileOutputStream	FileOutputStream
    //   768	16	18	localIOException1	IOException
    //   800	1	18	localException1	Exception
    //   803	28	18	localObject1	Object
    //   868	16	18	localIOException2	IOException
    //   900	1	18	localOutOfMemoryError2	OutOfMemoryError
    //   903	30	18	localObject2	Object
    //   970	135	18	localIOException3	IOException
    //   478	609	19	localObject3	Object
    //   1112	1	19	localOutOfMemoryError3	OutOfMemoryError
    //   1117	1	19	localException2	Exception
    //   53	990	20	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   46	55	326	java/lang/OutOfMemoryError
    //   626	647	735	java/io/IOException
    //   650	692	735	java/io/IOException
    //   697	734	735	java/io/IOException
    //   598	603	768	java/io/IOException
    //   480	490	800	java/lang/Exception
    //   830	835	868	java/io/IOException
    //   480	490	900	java/lang/OutOfMemoryError
    //   932	937	970	java/io/IOException
    //   480	490	1002	finally
    //   1012	1016	1049	java/io/IOException
    //   494	511	1085	finally
    //   515	521	1085	finally
    //   525	533	1085	finally
    //   537	542	1085	finally
    //   554	560	1085	finally
    //   564	575	1085	finally
    //   579	585	1085	finally
    //   760	765	1085	finally
    //   909	915	1085	finally
    //   805	825	1094	finally
    //   915	927	1103	finally
    //   494	511	1112	java/lang/OutOfMemoryError
    //   515	521	1112	java/lang/OutOfMemoryError
    //   525	533	1112	java/lang/OutOfMemoryError
    //   537	542	1112	java/lang/OutOfMemoryError
    //   554	560	1112	java/lang/OutOfMemoryError
    //   564	575	1112	java/lang/OutOfMemoryError
    //   579	585	1112	java/lang/OutOfMemoryError
    //   760	765	1112	java/lang/OutOfMemoryError
    //   494	511	1117	java/lang/Exception
    //   515	521	1117	java/lang/Exception
    //   525	533	1117	java/lang/Exception
    //   537	542	1117	java/lang/Exception
    //   554	560	1117	java/lang/Exception
    //   564	575	1117	java/lang/Exception
    //   579	585	1117	java/lang/Exception
    //   760	765	1117	java/lang/Exception
  }
  
  /* Error */
  public static boolean b(Bitmap paramBitmap, int paramInt, File paramFile)
  {
    // Byte code:
    //   0: new 194	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 1299	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 798	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 801	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_3
    //   20: invokevirtual 1302	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_3
    //   27: invokevirtual 814	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 801	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_2
    //   39: invokevirtual 1305	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 817	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: new 964	java/io/BufferedOutputStream
    //   53: dup
    //   54: new 966	java/io/FileOutputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 970	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_3
    //   66: aload_3
    //   67: astore_2
    //   68: aload_0
    //   69: getstatic 993	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   72: iload_1
    //   73: aload_3
    //   74: invokevirtual 980	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   77: pop
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: invokevirtual 1308	java/io/BufferedOutputStream:flush	()V
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 1309	java/io/BufferedOutputStream:close	()V
    //   92: iconst_1
    //   93: ireturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 1309	java/io/BufferedOutputStream:close	()V
    //   108: aload_0
    //   109: athrow
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_2
    //   113: goto -13 -> 100
    //   116: astore_0
    //   117: aload_3
    //   118: astore_2
    //   119: goto -22 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramBitmap	Bitmap
    //   0	122	1	paramInt	int
    //   0	122	2	paramFile	File
    //   11	107	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   50	66	94	java/io/IOException
    //   68	78	99	finally
    //   80	84	99	finally
    //   97	99	99	finally
    //   50	66	110	finally
    //   68	78	116	java/io/IOException
    //   80	84	116	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new FileInputStream(paramString);
        boolean bool = "jpg".equals(a(paramString));
        if (bool) {
          bool = true;
        }
        bool = false;
      }
      catch (Exception paramString)
      {
        try
        {
          paramString.close();
          return bool;
        }
        catch (Exception paramString)
        {
          continue;
        }
        paramString = paramString;
        bool = false;
        a(paramString.toString());
        return bool;
      }
    }
  }
  
  public static int c(String paramString)
  {
    if (aiub.c(paramString)) {
      return Utils.getHeifOrientation(paramString);
    }
    return JpegExifReader.readOrientation(paramString);
  }
  
  public static Bitmap c()
  {
    String str;
    if (azmk.a()) {
      str = "static://DefaultFace140_140_square";
    }
    for (int i = 2130840088;; i = 2130840087)
    {
      if (BaseApplicationImpl.sImageCache != null) {}
      for (Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str);; localBitmap1 = null)
      {
        Bitmap localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap1 = bdal.b(BaseApplicationImpl.getApplication().getResources(), i);
          if ((localBitmap1 != null) && (BaseApplicationImpl.sImageCache != null)) {
            BaseApplicationImpl.sImageCache.put(str, localBitmap1);
          }
          localBitmap2 = localBitmap1;
          if (QLog.isColorLevel())
          {
            QLog.d("ImageUtil", 2, "getDefaultFaceBitmap140_140, bitmap=" + localBitmap1);
            localBitmap2 = localBitmap1;
          }
        }
        return localBitmap2;
      }
      str = "static://DefaultFace140_140";
    }
  }
  
  public static Bitmap c(Bitmap paramBitmap)
  {
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramBitmap.setPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    return paramBitmap;
  }
  
  public static Bitmap c(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramBitmap == null) {}
    for (;;)
    {
      return null;
      try
      {
        float f = Math.min(paramBitmap.getWidth() / paramInt1, paramBitmap.getHeight() / paramInt2);
        int m = (int)Math.ceil(paramBitmap.getWidth() / f);
        int n = (int)Math.ceil(paramBitmap.getHeight() / f);
        Bitmap localBitmap;
        int i;
        int k;
        if (m == paramInt1)
        {
          localBitmap = paramBitmap;
          if (n == paramInt2) {}
        }
        else
        {
          paramBitmap = Bitmap.createScaledBitmap(paramBitmap, m, n, true);
          i = (m - paramInt1) / 2;
          if (i >= 0) {
            break label382;
          }
          i = 0;
          k = (n - paramInt2) / 2;
          if (k >= 0) {
            break label385;
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ImageUtil", 2, "ROUND_CORNER_DECODER scale = " + f + ", scaledWidth = " + m + ", scaledHeight = " + n + ", xTopLeft = " + i + ", yTopLeft = " + j + ", width = " + paramInt1 + ", height = " + paramInt2);
          }
          localBitmap = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2);
          paramBitmap.recycle();
          paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
          Canvas localCanvas = new Canvas(paramBitmap);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
          Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-16777216);
          localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(localBitmap, localRect1, localRect2, localPaint);
          localBitmap.recycle();
          return paramBitmap;
          label382:
          break;
          label385:
          j = k;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
    QLog.w("ImageUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", paramBitmap);
    return null;
  }
  
  public static Bitmap c(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f2 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < paramInt1 * f2) {
        f1 = i / paramInt1;
      }
    }
    i = (paramInt1 + paramInt2) / 2;
    if (i < 35) {
      i = (int)(2.0F * f1);
    }
    for (;;)
    {
      paramInt1 = (int)(paramInt1 * f1);
      paramInt2 = (int)(f1 * paramInt2);
      return a(paramBitmap, i, paramInt1, paramInt2);
      if (i < 50) {
        i = (int)(3.0F * f1);
      } else if (i < 64) {
        i = (int)(5.0F * f1);
      } else {
        i = (int)(6.0F * f1);
      }
    }
  }
  
  public static Bitmap c(Drawable paramDrawable)
  {
    Paint localPaint = null;
    Object localObject;
    if (paramDrawable == null) {
      localObject = localPaint;
    }
    for (;;)
    {
      return localObject;
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicWidth();
      localObject = localPaint;
      if (i <= 0) {
        continue;
      }
      localObject = localPaint;
      if (j <= 0) {
        continue;
      }
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (paramDrawable = Bitmap.Config.ARGB_8888;; paramDrawable = Bitmap.Config.RGB_565)
        {
          paramDrawable = Bitmap.createBitmap(i, j, paramDrawable);
          localObject = paramDrawable;
          if (paramDrawable == null) {
            break;
          }
          localObject = new Canvas(paramDrawable);
          localPaint = new Paint();
          ((Canvas)localObject).drawBitmap(paramDrawable, new Matrix(), localPaint);
          return paramDrawable;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  public static Drawable c()
  {
    return new BitmapDrawable(f());
  }
  
  public static int d(String paramString)
  {
    int i = 3;
    int j = JpegExifReader.readOrientation(paramString);
    if (j == 6) {
      i = 1;
    }
    do
    {
      return i;
      if (j == 3) {
        return 2;
      }
    } while (j == 8);
    return 0;
  }
  
  public static Bitmap d()
  {
    Object localObject = swy.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 2);
    if ((localObject != null) && (((swz)localObject).a() != null))
    {
      localObject = ((swz)localObject).a();
      if ((localObject instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localObject).getBitmap();
      }
      return ((BitmapDrawable)localObject).getBitmap();
    }
    localObject = swy.a(BaseApplicationImpl.sApplication, 2);
    if ((localObject instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)localObject).getBitmap();
    }
    return ((BitmapDrawable)localObject).getBitmap();
  }
  
  public static Bitmap d(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      float f = Math.min(paramBitmap.getWidth() / paramInt1, paramBitmap.getHeight() / paramInt2);
      int m = (int)Math.ceil(paramBitmap.getWidth() / f);
      int n = (int)Math.ceil(paramBitmap.getHeight() / f);
      Bitmap localBitmap;
      int i;
      int k;
      if (m == paramInt1)
      {
        localBitmap = paramBitmap;
        if (n == paramInt2) {}
      }
      else
      {
        paramBitmap = Bitmap.createScaledBitmap(paramBitmap, m, n, true);
        i = (m - paramInt1) / 2;
        if (i >= 0) {
          break label417;
        }
        i = 0;
        k = (n - paramInt2) / 2;
        if (k >= 0) {
          break label420;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageUtil", 2, "HALF_ROUND_CORNER_DECODER scale = " + f + ", scaledWidth = " + m + ", scaledHeight = " + n + ", xTopLeft = " + i + ", yTopLeft = " + j + ", width = " + paramInt1 + ", height = " + paramInt2 + " roundPx: " + paramFloat);
        }
        localBitmap = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2);
        paramBitmap.recycle();
        paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(paramBitmap);
        Paint localPaint = new Paint();
        Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
        Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
        Rect localRect3 = new Rect(0, (int)(paramInt2 - paramFloat), paramInt1, (int)(paramInt2 + paramFloat));
        RectF localRectF = new RectF(localRect2);
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-12434878);
        localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
        localCanvas.drawRect(localRect3, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(localBitmap, localRect1, localRect2, localPaint);
        return paramBitmap;
        label417:
        break;
        label420:
        j = k;
      }
      return null;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public static Bitmap d(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i = paramInt2 * 2 + paramBitmap.getWidth();
      int j = paramInt2 * 2 + paramBitmap.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(paramInt2, paramInt2, paramBitmap.getWidth() + paramInt2, paramBitmap.getHeight() + paramInt2);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      localPaint.setColor(paramInt1);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(paramInt2);
      localCanvas.drawCircle(i / 2, j / 2, i / 2 - paramInt2 / 2, localPaint);
      paramBitmap.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  public static Drawable d()
  {
    return new BitmapDrawable(g());
  }
  
  public static Bitmap e()
  {
    Object localObject = swy.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 3);
    if ((localObject != null) && (((swz)localObject).a() != null))
    {
      localObject = ((swz)localObject).a();
      if ((localObject instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localObject).getBitmap();
      }
      return ((BitmapDrawable)localObject).getBitmap();
    }
    localObject = swy.a(BaseApplicationImpl.sApplication, 3);
    if ((localObject instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)localObject).getBitmap();
    }
    return ((BitmapDrawable)localObject).getBitmap();
  }
  
  public static Bitmap e(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(i - paramInt1, j - paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, paramInt2, i - paramInt1, j);
      Rect localRect2 = new Rect(0, 0, i - paramInt1, j - paramInt2);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Drawable e()
  {
    return new BitmapDrawable(h());
  }
  
  public static Bitmap f()
  {
    String str;
    if (azmk.a()) {
      str = "static://DefaultTroopFace_square";
    }
    for (int i = 2130840086;; i = 2130840313)
    {
      if (BaseApplicationImpl.sImageCache != null) {}
      for (Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str);; localBitmap1 = null)
      {
        Bitmap localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap1 = c(bdal.b(BaseApplicationImpl.getApplication().getResources(), i), 50, 50);
          localBitmap2 = localBitmap1;
          if (localBitmap1 != null)
          {
            localBitmap2 = localBitmap1;
            if (BaseApplicationImpl.sImageCache != null)
            {
              BaseApplicationImpl.sImageCache.put(str, localBitmap1);
              localBitmap2 = localBitmap1;
            }
          }
        }
        return localBitmap2;
      }
      str = "static://DefaultTroopFace";
    }
  }
  
  public static Drawable f()
  {
    return new BitmapDrawable(j());
  }
  
  public static Bitmap g()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://DefaultTroopFaceNew");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = c(bdal.b(BaseApplicationImpl.getApplication().getResources(), 2130840314), 50, 50);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.sImageCache.put("static://DefaultTroopFaceNew", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap h()
  {
    String str;
    if (azmk.a()) {
      str = "static://DefaultDiscusionFace_square";
    }
    for (int i = 2130840086;; i = 2130840313)
    {
      if (BaseApplicationImpl.sImageCache != null) {}
      for (Object localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str);; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {}
        try
        {
          localObject2 = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), i);
          localObject1 = localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          label50:
          break label50;
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put(str, localObject1);
            localObject2 = localObject1;
          }
        }
        return localObject2;
      }
      str = "static://DefaultDiscusionFace";
    }
  }
  
  public static Bitmap i()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://DefaultSystemIcon");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bdal.b(BaseApplicationImpl.getApplication().getResources(), 2130849894);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.sImageCache.put("static://DefaultSystemIcon", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap j()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://DefaultSubAccountFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bdal.b(BaseApplicationImpl.getApplication().getResources(), 2130840178);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.sImageCache.put("static://DefaultSubAccountFace", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhj
 * JD-Core Version:    0.7.0.1
 */