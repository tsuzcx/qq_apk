import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.InflaterInputStream;

public class avxz
{
  private static int jdField_a_of_type_Int = -1;
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static int b = -1;
  
  public static long a(String paramString)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    try
    {
      l1 = jdField_a_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
      if (QLog.isColorLevel()) {
        QLog.d("OlympicUtil", 2, "data2Millis, date = " + paramString + ",millionSeconds = " + l1);
      }
      return l1;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("OlympicUtil", 2, "", localParseException);
          l1 = l2;
        }
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if ((paramBitmap == null) || (paramFloat == 1.0F) || (paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0)) {}
    do
    {
      return paramBitmap;
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(paramFloat, paramFloat);
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    } while (!QLog.isColorLevel());
    QLog.e("OlympicUtil", 2, "scaleBitmap,", localOutOfMemoryError);
    return paramBitmap;
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject = "olympic_" + paramString;
    paramString = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getBitmapFromCache|key:").append((String)localObject).append(" cache is exists:");
      if (paramString == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.olympic.cache", 2, bool);
      return paramString;
    }
  }
  
  public static Pair<Integer, Bitmap> a(String paramString1, String paramString2, avvy paramavvy, int paramInt)
  {
    localObject1 = null;
    k = 0;
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject2 = new BitmapFactory.Options();
        if (paramavvy == null) {
          continue;
        }
        ((BitmapFactory.Options)localObject2).inPurgeable = true;
        ((BitmapFactory.Options)localObject2).inInputShareable = true;
        if (!paramavvy.d) {
          continue;
        }
        ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (!paramavvy.b) {
          continue;
        }
        ((BitmapFactory.Options)localObject2).inSampleSize = 2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject2;
        if ((paramavvy == null) || (paramavvy.b)) {
          break label519;
        }
        paramavvy.b = true;
        if ((paramInt == 1) && (paramavvy.c)) {
          break label519;
        }
        localObject1 = a(paramString1, paramString2, paramavvy, paramInt);
        paramavvy = (Bitmap)((Pair)localObject1).second;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.olympic", 2, "decodeBitmap OOM|url:" + paramString1);
        i = 0;
        j = 1;
        continue;
        if ((paramInt != 1) || (!paramavvy.c)) {
          continue;
        }
        localOutOfMemoryError.inSampleSize = 2;
        continue;
      }
      catch (Exception paramavvy)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.olympic", 2, "decodeBitmap Exception:" + paramavvy.toString() + ",filePath:" + paramString2);
        paramavvy = null;
        localObject1 = null;
        int i = 1;
        int j = 0;
        continue;
        localOutOfMemoryError.inSampleSize = 1;
        continue;
        localOutOfMemoryError.inPurgeable = true;
        localOutOfMemoryError.inInputShareable = true;
        localOutOfMemoryError.inSampleSize = 1;
        localOutOfMemoryError.inPreferredConfig = Bitmap.Config.RGB_565;
        localOutOfMemoryError.inDither = true;
        continue;
        paramInt = ((Integer)((Pair)localObject1).first).intValue();
        continue;
        if (j == 0) {
          continue;
        }
        paramInt = 2;
        continue;
        paramInt = k;
        if (i == 0) {
          continue;
        }
        paramInt = 3;
        continue;
        l = paramavvy.getRowBytes() * paramavvy.getHeight() / 1024;
        continue;
      }
      localObject2 = BitmapFactory.decodeFile(paramString2, (BitmapFactory.Options)localObject2);
      paramavvy = (avvy)localObject2;
      localObject1 = null;
      i = 0;
      j = 0;
      if (paramavvy != null) {
        a(paramString1, paramavvy);
      }
      if (localObject1 == null) {
        continue;
      }
      if (((Integer)((Pair)localObject1).first).intValue() != 0) {
        continue;
      }
      paramInt = 1;
      if ((paramavvy == null) && (j == 0) && (i == 0)) {}
      try
      {
        paramString1 = new File(paramString2);
        if (paramString1.exists()) {
          paramString1.delete();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.olympic", 2, "decodeBitmap| file.delete()");
        }
      }
      catch (Exception paramString1)
      {
        long l;
        continue;
        Object localObject3 = null;
        paramavvy = (avvy)localObject1;
        localObject1 = localObject3;
        continue;
      }
      paramString1 = new Pair(Integer.valueOf(paramInt), paramavvy);
      if (QLog.isColorLevel())
      {
        if (paramavvy != null) {
          continue;
        }
        l = 0L;
        QLog.d("Q.olympic", 2, "decodeBitmap|size:" + l + "KB,errCode:" + paramInt);
      }
      return paramString1;
      ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject2).inDither = true;
    }
  }
  
  public static String a(long paramLong)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    Object localObject2 = null;
    try
    {
      localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("OlympicUtil", 2, "millis2Date, milliseconds = " + paramLong + ",result = " + (String)localObject1);
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("OlympicUtil", 2, "millis2Date, milliseconds = " + paramLong + ",exception = " + localException.getMessage());
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.startsWith("http://hb.url.cn/myapp/qq_desk/")) {
        return paramString.substring("http://hb.url.cn/myapp/qq_desk/".length());
      }
      str = paramString;
    } while (!paramString.startsWith("http://"));
    return paramString.substring("http://".length());
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("olympic", 0).edit().putLong(paramString, System.currentTimeMillis()).commit();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    a(paramAppInterface, paramString, paramInt, "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramAppInterface.reportClickEvent("CliOper", "", paramString2, paramString1, paramString1, 0, 0, "" + paramInt, "", "", "");
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    paramString = "olympic_" + paramString;
    BaseApplicationImpl.sImageCache.put(paramString, paramBitmap);
    if (QLog.isColorLevel()) {
      QLog.d("Q.olympic.cache", 2, "putBitmapToCache|key:" + paramString + ",size:" + paramBitmap.getRowBytes() * paramBitmap.getHeight() / 1024 + "KB");
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (QLog.isColorLevel()))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (paramVarArgs[i] == null) {
          paramVarArgs[i] = "null";
        }
        i += 1;
      }
      QLog.d(paramString, 2, paramVarArgs);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("olympic", 0).edit().putBoolean("dpc_ar_entrance", paramBoolean).commit();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("olympic", 0).getBoolean("dpc_ar_entrance", true);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (Math.abs(System.currentTimeMillis() - paramContext.getSharedPreferences("olympic", 0).getLong(paramString, -1L)) > 86400000L) {
      bool = true;
    }
    return bool;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxz
 * JD-Core Version:    0.7.0.1
 */