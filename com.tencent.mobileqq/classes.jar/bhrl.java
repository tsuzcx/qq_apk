import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import common.config.service.QzoneConfig;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.1;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.3;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.4;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.6;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.7;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class bhrl
  extends bhrq
  implements bhko
{
  static File jdField_a_of_type_JavaIoFile;
  public static final String a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static String jdField_d_of_type_JavaLangString;
  private byte jdField_a_of_type_Byte = 111;
  int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bhrm(this);
  public Handler a;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString = "";
  private List<QzonePhotoInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 274;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 30;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = bhbz.p;
  }
  
  public bhrl()
  {
    this.jdField_a_of_type_AndroidOsHandler = new bhrn(this);
  }
  
  public static double a(bhro parambhro)
  {
    if (jdField_a_of_type_ArrayOfInt == null) {
      jdField_a_of_type_ArrayOfInt = a();
    }
    if (parambhro != null)
    {
      int i = parambhro.jdField_a_of_type_Int;
      int j = parambhro.jdField_b_of_type_Int;
      int k;
      if (i < j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        double d3;
        if ((k <= jdField_a_of_type_ArrayOfInt[0]) && (j <= jdField_a_of_type_ArrayOfInt[1]))
        {
          d3 = 0.0D;
          return d3;
        }
        double d1;
        if (k > j) {
          d1 = k / jdField_a_of_type_ArrayOfInt[0];
        }
        for (double d2 = j / jdField_a_of_type_ArrayOfInt[1];; d2 = k / jdField_a_of_type_ArrayOfInt[1])
        {
          d3 = d1;
          if (d1 > d2) {
            break;
          }
          return d2;
          d1 = j / jdField_a_of_type_ArrayOfInt[0];
        }
        k = i;
      }
    }
    return 0.0D;
  }
  
  public static double a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      label27:
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      double d1 = 0.0D;
      if ((paramInt1 != -1) && (paramInt2 != -1))
      {
        d1 = i / paramInt1;
        d2 = j / paramInt2;
        if (d1 > d2) {
          return d1;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      int j;
      do
      {
        int i;
        double d2;
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
        return d2;
        if (paramInt1 != -1) {
          return i / paramInt1;
        }
      } while (paramInt2 == -1);
      return j / paramInt2;
    }
    catch (OutOfMemoryError paramInputStream)
    {
      break label27;
    }
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = JpegExifReader.getRotationDegree(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  public static BitmapFactory.Options a(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d1 = a(localInputStream, paramInt1, paramInt2);
    paramInt2 = (int)d1;
    paramInt1 = paramInt2;
    if (d1 > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    localInputStream.close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "getSizeCrop" + paramContext);
      }
    }
  }
  
  public static bhro a(String paramString)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeFile(paramString, localOptions);
      localOptions.inJustDecodeBounds = false;
      return new bhro(localOptions.outWidth, localOptions.outHeight);
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "getBitmapSize: OutOfMemoryError" + paramString);
      }
    }
  }
  
  @TargetApi(11)
  public static WebResourceResponse a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse start :" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return null;
        String str = paramString.replace("http://www.dynamicalbumlocalimage.com", "");
        try
        {
          str = URLDecoder.decode(str, "UTF-8");
          if (QLog.isDevelopLevel()) {
            QLog.i("QzoneDynamicAlbumPlugin", 4, "image filePath :" + str);
          }
          localFile = new File(str);
          if ((jdField_d_of_type_JavaLangString != null) && (jdField_d_of_type_JavaLangString.equals("https://h5.qzone.qq.com/dynamic/album/list?_ws&_wv=2098179&_wwv=4&_proxy=1")))
          {
            QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse -  getThumbnail:" + paramString);
            InputStream localInputStream = a(str);
            if (localInputStream != null) {
              return new WebResourceResponse("image/*", "utf-8", localInputStream);
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          File localFile;
          Object localObject;
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            localObject = null;
          }
          if (!localFile.exists())
          {
            if (QLog.isDevelopLevel())
            {
              QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse local file not exists :" + (String)localObject);
              return null;
            }
          }
          else {
            try
            {
              localObject = new FileInputStream((String)localObject);
              if (QLog.isDevelopLevel()) {
                QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse ****************** :" + paramString);
              }
              return new WebResourceResponse("image/*", "utf-8", (InputStream)localObject);
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              localFileNotFoundException.printStackTrace();
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("QzoneDynamicAlbumPlugin", 2, "getImageResponse get local file fail:" + paramString);
    return null;
  }
  
  private static InputStream a(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    float f1 = Math.min(((BitmapFactory.Options)localObject).outWidth / 400, ((BitmapFactory.Options)localObject).outHeight / 300);
    int i = 1;
    while (i < f1) {
      i *= 2;
    }
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      localObject = new ByteArrayOutputStream();
      paramString.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      paramString = new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray());
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("QzoneDynamicAlbumPlugin", 1, "getThumbnail:outOfMemortError " + paramString);
    }
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: aload_0
    //   8: iload_2
    //   9: iload_3
    //   10: invokestatic 315	bhrl:a	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   13: astore 6
    //   15: aload_0
    //   16: invokevirtual 158	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: aload_1
    //   20: invokevirtual 164	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   23: astore 5
    //   25: aload 5
    //   27: astore_0
    //   28: aload 5
    //   30: aload 6
    //   32: aload_1
    //   33: invokevirtual 320	android/net/Uri:getPath	()Ljava/lang/String;
    //   36: invokestatic 322	bhrl:a	(Ljava/lang/String;)I
    //   39: iload 4
    //   41: invokestatic 325	bhrl:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;IZ)Ljava/lang/String;
    //   44: astore_1
    //   45: aload 5
    //   47: invokestatic 330	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore 5
    //   57: aload 5
    //   59: astore_0
    //   60: ldc 171
    //   62: iconst_1
    //   63: new 173	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 332
    //   73: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload 5
    //   88: invokestatic 330	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore 5
    //   98: aload_0
    //   99: astore_1
    //   100: aload 5
    //   102: invokestatic 330	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: astore 5
    //   112: goto -12 -> 100
    //   115: astore_1
    //   116: goto -59 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramContext	Context
    //   0	119	1	paramUri	Uri
    //   0	119	2	paramInt1	int
    //   0	119	3	paramInt2	int
    //   0	119	4	paramBoolean	boolean
    //   23	88	5	localObject	Object
    //   13	18	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   6	25	53	java/lang/Exception
    //   6	25	94	finally
    //   28	45	108	finally
    //   60	86	108	finally
    //   28	45	115	java/lang/Exception
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 290	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: invokespecial 291	java/io/ByteArrayOutputStream:<init>	()V
    //   10: astore 7
    //   12: aload 7
    //   14: astore 6
    //   16: aload_1
    //   17: getfield 169	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   20: iconst_1
    //   21: if_icmpgt +25 -> 46
    //   24: aload 7
    //   26: astore 6
    //   28: aload_1
    //   29: getfield 339	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   32: invokestatic 342	bhrl:a	(Ljava/lang/String;)Z
    //   35: ifeq +11 -> 46
    //   38: iload 5
    //   40: istore 4
    //   42: iload_3
    //   43: ifeq +143 -> 186
    //   46: aload 7
    //   48: astore 6
    //   50: aload_1
    //   51: getstatic 348	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   54: putfield 351	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   57: aload 7
    //   59: astore 6
    //   61: aload_1
    //   62: iconst_1
    //   63: putfield 354	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   66: aload 7
    //   68: astore 6
    //   70: aload_1
    //   71: iconst_1
    //   72: putfield 357	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   75: aload 7
    //   77: astore 6
    //   79: aload_0
    //   80: aconst_null
    //   81: aload_1
    //   82: invokestatic 98	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   85: astore 8
    //   87: aload 7
    //   89: astore 6
    //   91: ldc 171
    //   93: iconst_1
    //   94: new 173	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 359
    //   104: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: getfield 106	android/graphics/BitmapFactory$Options:outWidth	I
    //   111: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc_w 364
    //   117: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: getfield 109	android/graphics/BitmapFactory$Options:outHeight	I
    //   124: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 8
    //   135: astore_1
    //   136: iload_2
    //   137: ifeq +14 -> 151
    //   140: aload 7
    //   142: astore 6
    //   144: aload 8
    //   146: iload_2
    //   147: invokestatic 366	bhrl:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   150: astore_1
    //   151: iload 5
    //   153: istore 4
    //   155: aload_1
    //   156: ifnull +30 -> 186
    //   159: aload 7
    //   161: astore 6
    //   163: aload_1
    //   164: getstatic 369	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   167: bipush 60
    //   169: aload 7
    //   171: invokevirtual 301	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   174: pop
    //   175: aload 7
    //   177: astore 6
    //   179: aload_1
    //   180: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   183: iconst_1
    //   184: istore 4
    //   186: iload 4
    //   188: ifne +102 -> 290
    //   191: aload 7
    //   193: astore 6
    //   195: ldc 171
    //   197: iconst_1
    //   198: ldc_w 371
    //   201: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload 7
    //   206: astore 6
    //   208: sipush 4096
    //   211: newarray byte
    //   213: astore_1
    //   214: aload 7
    //   216: astore 6
    //   218: aload_0
    //   219: aload_1
    //   220: invokevirtual 375	java/io/InputStream:read	([B)I
    //   223: istore_2
    //   224: iload_2
    //   225: iconst_m1
    //   226: if_icmpeq +64 -> 290
    //   229: aload 7
    //   231: astore 6
    //   233: aload 7
    //   235: aload_1
    //   236: iconst_0
    //   237: iload_2
    //   238: invokevirtual 379	java/io/ByteArrayOutputStream:write	([BII)V
    //   241: goto -27 -> 214
    //   244: astore_0
    //   245: aload 7
    //   247: astore 6
    //   249: ldc 171
    //   251: iconst_1
    //   252: ldc_w 381
    //   255: aload_0
    //   256: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload 7
    //   261: invokestatic 330	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   264: pop
    //   265: aconst_null
    //   266: areturn
    //   267: astore 8
    //   269: aload 7
    //   271: astore 6
    //   273: ldc 171
    //   275: iconst_1
    //   276: ldc_w 386
    //   279: aload 8
    //   281: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   284: aconst_null
    //   285: astore 8
    //   287: goto -200 -> 87
    //   290: aload 7
    //   292: astore 6
    //   294: aload 7
    //   296: invokevirtual 307	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   299: iconst_2
    //   300: invokestatic 392	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   303: astore_0
    //   304: aload 7
    //   306: invokestatic 330	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   309: pop
    //   310: aload_0
    //   311: areturn
    //   312: astore_0
    //   313: aconst_null
    //   314: astore 7
    //   316: aload 7
    //   318: astore 6
    //   320: ldc 171
    //   322: iconst_1
    //   323: ldc_w 386
    //   326: aload_0
    //   327: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: aload 7
    //   332: invokestatic 330	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   335: pop
    //   336: aconst_null
    //   337: areturn
    //   338: astore_0
    //   339: aconst_null
    //   340: astore 6
    //   342: aload 6
    //   344: invokestatic 330	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   347: pop
    //   348: aload_0
    //   349: athrow
    //   350: astore_0
    //   351: goto -9 -> 342
    //   354: astore_0
    //   355: goto -39 -> 316
    //   358: astore_0
    //   359: aconst_null
    //   360: astore 7
    //   362: goto -117 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramInputStream	InputStream
    //   0	365	1	paramOptions	BitmapFactory.Options
    //   0	365	2	paramInt	int
    //   0	365	3	paramBoolean	boolean
    //   40	147	4	i	int
    //   1	151	5	j	int
    //   14	329	6	localByteArrayOutputStream1	ByteArrayOutputStream
    //   10	351	7	localByteArrayOutputStream2	ByteArrayOutputStream
    //   85	60	8	localBitmap	Bitmap
    //   267	13	8	localOutOfMemoryError	OutOfMemoryError
    //   285	1	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	24	244	java/lang/Exception
    //   28	38	244	java/lang/Exception
    //   50	57	244	java/lang/Exception
    //   61	66	244	java/lang/Exception
    //   70	75	244	java/lang/Exception
    //   79	87	244	java/lang/Exception
    //   91	133	244	java/lang/Exception
    //   144	151	244	java/lang/Exception
    //   163	175	244	java/lang/Exception
    //   179	183	244	java/lang/Exception
    //   195	204	244	java/lang/Exception
    //   208	214	244	java/lang/Exception
    //   218	224	244	java/lang/Exception
    //   233	241	244	java/lang/Exception
    //   273	284	244	java/lang/Exception
    //   294	304	244	java/lang/Exception
    //   79	87	267	java/lang/OutOfMemoryError
    //   3	12	312	java/lang/OutOfMemoryError
    //   3	12	338	finally
    //   16	24	350	finally
    //   28	38	350	finally
    //   50	57	350	finally
    //   61	66	350	finally
    //   70	75	350	finally
    //   79	87	350	finally
    //   91	133	350	finally
    //   144	151	350	finally
    //   163	175	350	finally
    //   179	183	350	finally
    //   195	204	350	finally
    //   208	214	350	finally
    //   218	224	350	finally
    //   233	241	350	finally
    //   249	259	350	finally
    //   273	284	350	finally
    //   294	304	350	finally
    //   320	330	350	finally
    //   16	24	354	java/lang/OutOfMemoryError
    //   28	38	354	java/lang/OutOfMemoryError
    //   50	57	354	java/lang/OutOfMemoryError
    //   61	66	354	java/lang/OutOfMemoryError
    //   70	75	354	java/lang/OutOfMemoryError
    //   91	133	354	java/lang/OutOfMemoryError
    //   144	151	354	java/lang/OutOfMemoryError
    //   163	175	354	java/lang/OutOfMemoryError
    //   179	183	354	java/lang/OutOfMemoryError
    //   195	204	354	java/lang/OutOfMemoryError
    //   208	214	354	java/lang/OutOfMemoryError
    //   218	224	354	java/lang/OutOfMemoryError
    //   233	241	354	java/lang/OutOfMemoryError
    //   273	284	354	java/lang/OutOfMemoryError
    //   294	304	354	java/lang/OutOfMemoryError
    //   3	12	358	java/lang/Exception
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, false);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str1 = paramString;
    if (paramString.startsWith("/")) {}
    try
    {
      str1 = "file:///" + Uri.encode(paramString.substring(1));
      paramString = Uri.parse(str1);
      return a(BaseApplicationImpl.getContext(), paramString, paramInt1, paramInt2, paramBoolean);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "compressImage with some: URL encode failed");
        String str2 = paramString;
      }
    }
  }
  
  private String a(String[] paramArrayOfString)
  {
    bhro localbhro = a(paramArrayOfString[1]);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", "http://www.dynamicalbumlocalimage.com" + paramArrayOfString[1]);
      if (localbhro != null)
      {
        localJSONObject.put("width", localbhro.jdField_a_of_type_Int);
        localJSONObject.put("height", localbhro.jdField_b_of_type_Int);
      }
      paramArrayOfString = a(paramArrayOfString[0]);
      if (paramArrayOfString != null)
      {
        localJSONObject.put("poiX", paramArrayOfString[1]);
        localJSONObject.put("poiY", paramArrayOfString[0]);
        localJSONObject.put("poiName", "");
      }
      paramArrayOfString = localJSONObject.toString();
      return paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return "";
  }
  
  private void a(Intent paramIntent)
  {
    a(paramIntent.getExtras(), false);
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return;
    }
    QLog.d("QzoneDynamicAlbumPlugin", 2, "sendBlogCLoudPhotoToH5 | mJSONArgs:" + this.jdField_c_of_type_JavaLangString);
    a(this.jdField_c_of_type_JavaLangString);
  }
  
  private void a(Bundle paramBundle)
  {
    try
    {
      int i = paramBundle.getInt("param.DynamicMin");
      int j = paramBundle.getInt("param.DynamicMax");
      paramBundle = paramBundle.getString("param.DynamicCmd");
      if (!TextUtils.isEmpty(paramBundle))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 0);
        localJSONObject.put("msg", "success");
        localJSONObject.put("maxNum", j);
        localJSONObject.put("minNum", i);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramBundle, new String[] { localJSONObject.toString() });
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = paramBundle.getParcelableArrayList("param.DynamicCloudPhotolist");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("key_album_id");
    this.jdField_a_of_type_Int = paramBundle.getInt("QZ_ALBUM_THEME");
    this.jdField_b_of_type_Int = paramBundle.getInt("QZ_ALBUM_SORT_TYPE");
    this.jdField_b_of_type_JavaUtilList = ((List)localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("p2vMakeBlog", 1, "mJumpToAlbumID:" + this.jdField_b_of_type_JavaLangString + " mJumpToAlbumTheme:" + this.jdField_a_of_type_Int + " mSortType:" + this.jdField_b_of_type_Int);
    }
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break label203;
      }
      localObject2 = ((QzonePhotoInfo)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      localObject1 = ((QzonePhotoInfo)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_c_of_type_JavaLangString;
      paramBundle = ((QzonePhotoInfo)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      bhkl.a().a().a((String)localObject2, (String)localObject1, paramBundle, this.jdField_b_of_type_JavaUtilList.size());
      return;
      label203:
      Object localObject3 = null;
      localObject2 = null;
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject3;
    }
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString).optString("callback");
          if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
            break label470;
          }
          localObject1 = new JSONArray();
          int j = this.jdField_b_of_type_JavaUtilList.size();
          i = 0;
          if (i >= j) {
            break;
          }
          localJSONObject = new JSONObject();
          Object localObject2 = (QzonePhotoInfo)this.jdField_b_of_type_JavaUtilList.get(i);
          localObject3 = ((QzonePhotoInfo)localObject2).jdField_a_of_type_JavaLangString;
          Object localObject4 = ((QzonePhotoInfo)localObject2).jdField_c_of_type_JavaLangString;
          String str = ((QzonePhotoInfo)localObject2).jdField_b_of_type_JavaLangString;
          int k = ((QzonePhotoInfo)localObject2).jdField_b_of_type_Int;
          int m = ((QzonePhotoInfo)localObject2).jdField_a_of_type_Int;
          long l1 = ((QzonePhotoInfo)localObject2).jdField_a_of_type_Long;
          long l2 = ((QzonePhotoInfo)localObject2).jdField_b_of_type_Long;
          localJSONObject.put("albumid", localObject3);
          localJSONObject.put("lloc", localObject4);
          localJSONObject.put("url", str);
          localJSONObject.put("height", Integer.valueOf(k));
          localJSONObject.put("width", Integer.valueOf(m));
          localJSONObject.put("shoottime", Long.valueOf(l1));
          localJSONObject.put("uploadtime", Long.valueOf(l2));
          localObject2 = ((QzonePhotoInfo)localObject2).jdField_a_of_type_JavaUtilMap;
          if (localObject2 == null) {
            break label338;
          }
          localObject2 = ((Map)localObject2).entrySet().iterator();
          localObject3 = new JSONStringer().object();
          if (((Iterator)localObject2).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject2).next();
            ((JSONStringer)localObject3).key(String.valueOf(((Map.Entry)localObject4).getKey())).value(((Map.Entry)localObject4).getValue());
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      localJSONObject.put("shouzhang_extend_map", ((JSONStringer)localObject3).endObject());
      label338:
      ((JSONArray)localObject1).put(localJSONObject);
      i += 1;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("photoList", localObject1);
    localJSONObject.put("sorttype", this.jdField_b_of_type_Int);
    localJSONObject.put("albumtype", this.jdField_a_of_type_Int);
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("data", localJSONObject);
    QZLog.d("QzoneDynamicAlbumPlugin", 2, "json:" + ((JSONObject)localObject1).toString());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
    return;
    label470:
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", -1);
    ((JSONObject)localObject1).put("msg", "fail");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    QLog.d("QzoneDynamicAlbumPlugin", 4, "pickDynamicAlbumImage start!");
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size();; i = 0)
    {
      new ArrayList();
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        if (jdField_a_of_type_ArrayOfInt == null) {
          jdField_a_of_type_ArrayOfInt = a();
        }
        if (jdField_a_of_type_JavaIoFile == null) {
          jdField_a_of_type_JavaIoFile = new File(jdField_a_of_type_JavaLangString);
        }
        ThreadManager.post(new QzoneDynamicAlbumPlugin.6(this, paramArrayList, i), 5, null, true);
      }
      return;
    }
  }
  
  private void a(List<String> paramList)
  {
    int i = 0;
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin getDynamicAlbumImage " + paramList.size() + " " + (String)paramList.get(0));
      }
      if (jdField_a_of_type_ArrayOfInt != null) {}
    }
    else
    {
      return;
    }
    String[] arrayOfString = new String[paramList.size()];
    while (i < paramList.size()) {
      if (paramList.get(i) == null)
      {
        i += 1;
      }
      else
      {
        Object localObject = (String)paramList.get(i);
        int j = a((String)localObject);
        bhro localbhro = a((String)localObject);
        float[] arrayOfFloat = a((String)localObject);
        double d1 = a(localbhro);
        if (((j == 90) || (j == 270)) && (localbhro != null))
        {
          j = localbhro.jdField_a_of_type_Int;
          localbhro.jdField_a_of_type_Int = localbhro.jdField_b_of_type_Int;
          localbhro.jdField_b_of_type_Int = j;
        }
        localObject = new JSONObject();
        arrayOfString[i] = (jdField_a_of_type_JavaLangString + (new Date().getTime() + i));
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("url", "http://www.dynamicalbumlocalimage.com" + arrayOfString[i]);
            if (localbhro != null)
            {
              if (d1 <= 0.0D) {
                continue;
              }
              ((JSONObject)localObject).put("width", (int)(localbhro.jdField_a_of_type_Int / d1));
              ((JSONObject)localObject).put("height", (int)(localbhro.jdField_b_of_type_Int / d1));
            }
            if (arrayOfFloat != null)
            {
              ((JSONObject)localObject).put("poiX", arrayOfFloat[1]);
              ((JSONObject)localObject).put("poiY", arrayOfFloat[0]);
              ((JSONObject)localObject).put("poiName", "");
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            continue;
          }
          this.jdField_a_of_type_JavaUtilList.add(((JSONObject)localObject).toString());
          break;
          ((JSONObject)localObject).put("width", localbhro.jdField_a_of_type_Int);
          ((JSONObject)localObject).put("height", localbhro.jdField_b_of_type_Int);
        }
      }
    }
    ThreadManager.post(new QzoneDynamicAlbumPlugin.7(this, paramList, arrayOfString), 5, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      armh.a(true, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), false);
      return;
    }
    armh.a(false, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), false);
    ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(null);
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +15 -> 28
    //   16: ldc_w 744
    //   19: iconst_2
    //   20: ldc_w 746
    //   23: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: new 195	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 10
    //   38: aload 10
    //   40: invokevirtual 202	java/io/File:exists	()Z
    //   43: ifne +15 -> 58
    //   46: ldc_w 744
    //   49: iconst_2
    //   50: ldc_w 748
    //   53: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iconst_0
    //   57: ireturn
    //   58: aload_1
    //   59: invokestatic 322	bhrl:a	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: new 272	java/io/FileInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   72: astore 6
    //   74: aload 10
    //   76: invokestatic 752	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   79: aload_0
    //   80: iload_3
    //   81: iload 4
    //   83: invokestatic 754	bhrl:b	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   86: astore_0
    //   87: new 195	java/io/File
    //   90: dup
    //   91: aload_2
    //   92: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: astore_1
    //   96: getstatic 671	bhrl:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   99: invokevirtual 202	java/io/File:exists	()Z
    //   102: ifne +10 -> 112
    //   105: getstatic 671	bhrl:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   108: invokevirtual 757	java/io/File:mkdirs	()Z
    //   111: pop
    //   112: aload_1
    //   113: invokevirtual 202	java/io/File:exists	()Z
    //   116: ifne +8 -> 124
    //   119: aload_1
    //   120: invokevirtual 760	java/io/File:createNewFile	()Z
    //   123: pop
    //   124: new 762	java/io/FileOutputStream
    //   127: dup
    //   128: aload_1
    //   129: invokespecial 765	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore_1
    //   133: aload_0
    //   134: getfield 169	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   137: iconst_1
    //   138: if_icmpgt +13 -> 151
    //   141: aload_0
    //   142: getfield 339	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   145: invokestatic 342	bhrl:a	(Ljava/lang/String;)Z
    //   148: ifne +123 -> 271
    //   151: aload_0
    //   152: getstatic 348	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   155: putfield 351	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   158: aload_0
    //   159: iconst_1
    //   160: putfield 354	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 357	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   168: aload 6
    //   170: aconst_null
    //   171: aload_0
    //   172: invokestatic 98	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   175: astore_0
    //   176: aload_0
    //   177: astore_2
    //   178: iload 5
    //   180: ifeq +10 -> 190
    //   183: aload_0
    //   184: iload 5
    //   186: invokestatic 366	bhrl:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   189: astore_2
    //   190: aload_2
    //   191: ifnull +47 -> 238
    //   194: aload_2
    //   195: getstatic 369	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   198: bipush 60
    //   200: aload_1
    //   201: invokevirtual 301	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   204: pop
    //   205: aload_2
    //   206: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   209: aload_1
    //   210: invokevirtual 768	java/io/OutputStream:close	()V
    //   213: aload 6
    //   215: invokevirtual 103	java/io/InputStream:close	()V
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 768	java/io/OutputStream:close	()V
    //   226: aload 6
    //   228: ifnull +8 -> 236
    //   231: aload 6
    //   233: invokevirtual 103	java/io/InputStream:close	()V
    //   236: iconst_1
    //   237: ireturn
    //   238: ldc_w 744
    //   241: iconst_2
    //   242: ldc_w 770
    //   245: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 768	java/io/OutputStream:close	()V
    //   256: aload 6
    //   258: ifnull -232 -> 26
    //   261: aload 6
    //   263: invokevirtual 103	java/io/InputStream:close	()V
    //   266: iconst_0
    //   267: ireturn
    //   268: astore_0
    //   269: iconst_0
    //   270: ireturn
    //   271: sipush 1024
    //   274: newarray byte
    //   276: astore_0
    //   277: aload 6
    //   279: aload_0
    //   280: invokevirtual 375	java/io/InputStream:read	([B)I
    //   283: istore_3
    //   284: iload_3
    //   285: iconst_m1
    //   286: if_icmpeq -77 -> 209
    //   289: aload_1
    //   290: aload_0
    //   291: iconst_0
    //   292: iload_3
    //   293: invokevirtual 771	java/io/OutputStream:write	([BII)V
    //   296: goto -19 -> 277
    //   299: astore_2
    //   300: aload_1
    //   301: astore_0
    //   302: aload_2
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   308: ldc_w 744
    //   311: iconst_2
    //   312: new 173	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 773
    //   322: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_0
    //   336: ifnull +7 -> 343
    //   339: aload_0
    //   340: invokevirtual 768	java/io/OutputStream:close	()V
    //   343: aload 6
    //   345: ifnull -319 -> 26
    //   348: aload 6
    //   350: invokevirtual 103	java/io/InputStream:close	()V
    //   353: iconst_0
    //   354: ireturn
    //   355: astore_0
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: aconst_null
    //   360: astore_1
    //   361: aload_1
    //   362: ifnull +7 -> 369
    //   365: aload_1
    //   366: invokevirtual 768	java/io/OutputStream:close	()V
    //   369: aload_0
    //   370: athrow
    //   371: astore_1
    //   372: aload 6
    //   374: astore_0
    //   375: aload_1
    //   376: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   379: aload_0
    //   380: ifnull +7 -> 387
    //   383: aload_0
    //   384: invokevirtual 103	java/io/InputStream:close	()V
    //   387: ldc_w 744
    //   390: iconst_2
    //   391: ldc_w 775
    //   394: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: iconst_0
    //   398: ireturn
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_1
    //   402: aload_1
    //   403: ifnull +7 -> 410
    //   406: aload_1
    //   407: invokevirtual 103	java/io/InputStream:close	()V
    //   410: aload_0
    //   411: athrow
    //   412: astore_0
    //   413: aload 7
    //   415: astore_0
    //   416: goto -240 -> 176
    //   419: astore_0
    //   420: goto -164 -> 256
    //   423: astore_0
    //   424: goto -198 -> 226
    //   427: astore_0
    //   428: goto -192 -> 236
    //   431: astore_0
    //   432: goto -89 -> 343
    //   435: astore_1
    //   436: goto -67 -> 369
    //   439: astore_0
    //   440: goto -53 -> 387
    //   443: astore_1
    //   444: goto -34 -> 410
    //   447: astore_0
    //   448: aload 6
    //   450: astore_1
    //   451: goto -49 -> 402
    //   454: astore_2
    //   455: aload_0
    //   456: astore_1
    //   457: aload_2
    //   458: astore_0
    //   459: goto -57 -> 402
    //   462: astore_1
    //   463: aload 9
    //   465: astore_0
    //   466: goto -91 -> 375
    //   469: astore_0
    //   470: goto -109 -> 361
    //   473: astore_2
    //   474: aload_0
    //   475: astore_1
    //   476: aload_2
    //   477: astore_0
    //   478: goto -117 -> 361
    //   481: astore_1
    //   482: aload 8
    //   484: astore_0
    //   485: goto -181 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	paramContext	Context
    //   0	488	1	paramString1	String
    //   0	488	2	paramString2	String
    //   0	488	3	paramInt1	int
    //   0	488	4	paramInt2	int
    //   62	123	5	i	int
    //   72	377	6	localFileInputStream	FileInputStream
    //   7	407	7	localObject1	Object
    //   1	482	8	localObject2	Object
    //   4	460	9	localObject3	Object
    //   36	39	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   261	266	268	java/io/IOException
    //   133	151	299	java/lang/Exception
    //   151	168	299	java/lang/Exception
    //   168	176	299	java/lang/Exception
    //   183	190	299	java/lang/Exception
    //   194	209	299	java/lang/Exception
    //   209	218	299	java/lang/Exception
    //   238	248	299	java/lang/Exception
    //   271	277	299	java/lang/Exception
    //   277	284	299	java/lang/Exception
    //   289	296	299	java/lang/Exception
    //   348	353	355	java/io/IOException
    //   96	112	358	finally
    //   112	124	358	finally
    //   124	133	358	finally
    //   74	96	371	java/lang/Exception
    //   222	226	371	java/lang/Exception
    //   252	256	371	java/lang/Exception
    //   339	343	371	java/lang/Exception
    //   365	369	371	java/lang/Exception
    //   369	371	371	java/lang/Exception
    //   64	74	399	finally
    //   168	176	412	java/lang/OutOfMemoryError
    //   252	256	419	java/io/IOException
    //   222	226	423	java/io/IOException
    //   231	236	427	java/io/IOException
    //   339	343	431	java/io/IOException
    //   365	369	435	java/io/IOException
    //   383	387	439	java/io/IOException
    //   406	410	443	java/io/IOException
    //   74	96	447	finally
    //   222	226	447	finally
    //   252	256	447	finally
    //   339	343	447	finally
    //   365	369	447	finally
    //   369	371	447	finally
    //   375	379	454	finally
    //   64	74	462	java/lang/Exception
    //   133	151	469	finally
    //   151	168	469	finally
    //   168	176	469	finally
    //   183	190	469	finally
    //   194	209	469	finally
    //   209	218	469	finally
    //   238	248	469	finally
    //   271	277	469	finally
    //   277	284	469	finally
    //   289	296	469	finally
    //   304	335	473	finally
    //   96	112	481	java/lang/Exception
    //   112	124	481	java/lang/Exception
    //   124	133	481	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.equalsIgnoreCase("image/jpeg")) && (!paramString.equalsIgnoreCase("image/png")))
      {
        bool1 = bool2;
        if (!paramString.equalsIgnoreCase("image/gif")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static float[] a(String paramString)
  {
    if (JpegExifReader.isCrashJpeg(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new ExifInterface(paramString);
        float[] arrayOfFloat = new float[2];
        boolean bool = paramString.getLatLong(arrayOfFloat);
        if (bool) {
          return arrayOfFloat;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public static int[] a()
  {
    int[] arrayOfInt = new int[2];
    int i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinCpu", 1150);
    long l1 = bbct.a();
    long l2 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRam", 700);
    long l3 = bbct.d() / 1048576L;
    long l4 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRuntimeRam", 150);
    long l5 = bbct.e() / 1048576L;
    if (QLog.isColorLevel()) {
      QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin freeSizeMB " + l5);
    }
    if ((Long.valueOf(l1).longValue() >= i) && (l3 >= l2) && (l5 >= l4))
    {
      arrayOfInt[0] = 1600;
      arrayOfInt[1] = 1600;
      return arrayOfInt;
    }
    arrayOfInt[0] = 640;
    arrayOfInt[1] = 640;
    return arrayOfInt;
  }
  
  public static double b(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      if (i < j) {
        if ((j <= paramInt1) && (i <= paramInt2))
        {
          d3 = 0.0D;
          return d3;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      double d3;
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
      double d1;
      if (j > i) {
        d1 = j / paramInt1;
      }
      for (double d2 = i / paramInt2;; d2 = j / paramInt2)
      {
        d3 = d1;
        if (d1 > d2) {
          break;
        }
        return d2;
        d1 = i / paramInt1;
      }
    }
    catch (OutOfMemoryError paramInputStream)
    {
      for (;;)
      {
        continue;
        int k = i;
        int i = j;
        int j = k;
      }
    }
  }
  
  public static BitmapFactory.Options b(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d1 = b(localInputStream, paramInt1, paramInt2);
    paramInt2 = (int)d1;
    paramInt1 = paramInt2;
    if (d1 > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    localInputStream.close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
      label80:
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      break label80;
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).optJSONObject("songInfo");
      paramString = ((JSONObject)localObject).getString("music_id");
      String str1 = ((JSONObject)localObject).getString("lrc_id");
      String str2 = ((JSONObject)localObject).getString("climax_start");
      localObject = ((JSONObject)localObject).getString("climax_endure");
      bhkl.a().a().b(paramString, str1, str2, (String)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c(String paramString)
  {
    int j = 0;
    QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - start");
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.getJSONArray("photosPath");
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getString(i);
          if (!((String)localObject2).startsWith("http://www.dynamicalbumlocalimage.com")) {
            break label213;
          }
          localObject2 = new File(((String)localObject2).replace("http://www.dynamicalbumlocalimage.com", ""));
          QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - isValid:true");
          if (((File)localObject2).exists()) {
            break label213;
          }
          i = j;
          paramString = paramString.getString("callback");
          localObject1 = new JSONObject();
          if (i != 0)
          {
            QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid SUCCESS!");
            ((JSONObject)localObject1).put("code", 0);
            ((JSONObject)localObject1).put("msg", "success");
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
          QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid FAILE");
          ((JSONObject)localObject1).put("code", -1);
          ((JSONObject)localObject1).put("msg", "fail");
          continue;
        }
        i = 1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      continue;
      label213:
      i += 1;
    }
  }
  
  private void d()
  {
    bhkl.a().a().a((ArrayList)this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  private void d(String paramString)
  {
    try
    {
      QZLog.d("dynamic.Album", 2, "requestPlayMusic start:" + paramString + ";isChating:" + this.f);
      Object localObject = new JSONObject();
      if (this.f)
      {
        ((JSONObject)localObject).put("isCanPlayMusic", "false");
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      ((JSONObject)localObject).put("isCanPlayMusic", "true");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
      if (localObject != null)
      {
        ((AudioManager)localObject).requestAudioFocus(null, 3, 1);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QZLog.e("dynamic.Album", 2, new Object[] { "requestPlayMusic get jsonException, cmd:" + paramString });
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      QZLog.d("dynamic.Album", 2, "requestPlayMusic get an Exception, cmd:" + paramString);
      localException.printStackTrace();
    }
  }
  
  private void e(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).optJSONArray("photoList");
      ((JSONObject)localObject1).getString("callback");
      localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject2 = paramString.get(i);
        if ((localObject2 != null) && ((localObject2 instanceof String)))
        {
          localObject2 = (String)localObject2;
          ((ArrayList)localObject1).add(localObject2);
          if (((String)localObject2).startsWith("http://www.dynamicalbumlocalimage.com")) {
            localArrayList.add(((String)localObject2).replace("http://www.dynamicalbumlocalimage.com", ""));
          }
        }
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void f(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_e_of_type_Int = new JSONObject(paramString).optInt("selectedPhotoNum");
      QLog.d("p2vMakeBlog", 1, "hasSelectSize:" + this.jdField_e_of_type_Int);
      paramString = bgyf.a();
      paramString.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_album_id", this.jdField_b_of_type_JavaLangString);
      localBundle.putLong("key_album_owner_uin", Long.parseLong(paramString.jdField_a_of_type_JavaLangString));
      localBundle.putInt("QZ_ALBUM_THEME", this.jdField_a_of_type_Int);
      localBundle.putInt("key_personal_album_enter_model", 1);
      localBundle.putInt("PhotoConst.from_h5", 1);
      localBundle.putBoolean("key_is_filter_video", true);
      localBundle.putBoolean("key_is_from_make_blog", true);
      localBundle.putInt("has_select_size", this.jdField_e_of_type_Int);
      int i = bhrc.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, 8);
      bgxy.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), paramString, localBundle, i);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("p2vMakeBlog", 1, "json error cmd:" + paramString);
      }
    }
  }
  
  private void g(String paramString)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      int k;
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.optJSONArray("photoList");
        Object localObject1 = paramString.optJSONObject("data");
        String str1 = paramString.getString("callback");
        localJSONObject = new JSONObject();
        ArrayList localArrayList = new ArrayList();
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          k = 0;
          paramString = null;
          if (k < localJSONArray.length())
          {
            localObject2 = localJSONArray.getJSONObject(k);
            localObject3 = ((JSONObject)localObject2).getString("photoUrl");
            if (localObject3 == null) {
              break label780;
            }
            paramString = ((JSONObject)localObject2).getString("albumId");
            str2 = ((JSONObject)localObject2).getString("photoId");
            int j = -1;
            i = 0;
            if (i < this.jdField_b_of_type_JavaUtilList.size())
            {
              if (!((QzonePhotoInfo)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(localObject3)) {
                break label777;
              }
              j = i;
              break label783;
            }
            if ((this.jdField_a_of_type_Boolean) && (j != -1))
            {
              paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"), ((QzonePhotoInfo)this.jdField_b_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString, ((QzonePhotoInfo)this.jdField_b_of_type_JavaUtilList.get(j)).jdField_c_of_type_JavaLangString);
              if (paramString == null) {
                break label790;
              }
              localArrayList.add(paramString);
              break label790;
            }
            if ((paramString != null) && (str2 != null))
            {
              paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"), paramString, str2);
              continue;
            }
            paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"));
            continue;
          }
        }
        paramString = ((JSONObject)localObject1).getString("mgz_name");
        Object localObject3 = ((JSONObject)localObject1).getString("mgz_desc");
        String str2 = ((JSONObject)localObject1).getString("tmplt_id");
        String str3 = ((JSONObject)localObject1).getString("music_id");
        String str4 = ((JSONObject)localObject1).getString("lrc_id");
        String str5 = ((JSONObject)localObject1).getString("climax_start");
        String str6 = ((JSONObject)localObject1).getString("climax_endure");
        i = ((JSONObject)localObject1).getInt("isDraft");
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelableArrayList("DYNAMIC_ALBUM_PHOTOLIST", localArrayList);
        ((Bundle)localObject2).putString("mgz_name", paramString);
        ((Bundle)localObject2).putString("mgz_desc", (String)localObject3);
        ((Bundle)localObject2).putString("tmplt_id", str2);
        ((Bundle)localObject2).putString("music_id", str3);
        ((Bundle)localObject2).putString("lrc_id", str4);
        ((Bundle)localObject2).putString("climax_start", str5);
        ((Bundle)localObject2).putString("climax_endure", str6);
        ((Bundle)localObject2).putBoolean("EDIT_IMAGE", false);
        ((Bundle)localObject2).putBoolean("APPEND_IMAGE", false);
        ((Bundle)localObject2).putBoolean("SHOW_RECNET_IMAGE", false);
        ((Bundle)localObject2).putString("shareSource", ajyc.a(2131711718));
        if (i == 1)
        {
          ((Bundle)localObject2).putBoolean("dynamic_album_is_from_draft", true);
          localObject3 = bgyf.a();
          ((bgyf)localObject3).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
          localObject1 = "";
          paramString = (String)localObject1;
          if (localJSONArray != null)
          {
            paramString = (String)localObject1;
            if (localJSONArray.length() > 0) {
              paramString = localJSONArray.getJSONObject(0).getString("photoUrl");
            }
          }
          if ((localArrayList.size() > 0) && (!TextUtils.isEmpty(paramString)))
          {
            localObject1 = paramString;
            if (paramString.startsWith("http://www.dynamicalbumlocalimage.com")) {
              localObject1 = paramString.replace("http://www.dynamicalbumlocalimage.com", "");
            }
            bgxy.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), (Bundle)localObject2, (bgyf)localObject3, (String)localObject1, ajyc.a(2131711717), null, this.jdField_c_of_type_Int);
            QLog.d("QzoneDynamicAlbumPlugin", 4, "entryWriteMoodAsync SUCCESS!");
            localJSONObject.put("code", 0);
            localJSONObject.put("msg", "success");
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str1, new String[] { localJSONObject.toString() });
          }
        }
        else
        {
          ((Bundle)localObject2).putBoolean("dynamic_album_is_from_draft", false);
          continue;
        }
        QLog.d("QzoneDynamicAlbumPlugin", 4, "entryWriteMoodAsync FAILE");
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      localJSONObject.put("code", -1);
      localJSONObject.put("msg", "fail");
      continue;
      label777:
      break label783;
      label780:
      continue;
      label783:
      i += 1;
      continue;
      label790:
      k += 1;
    }
  }
  
  private void h(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
        {
          localObject = new JSONArray();
          int j = this.jdField_b_of_type_JavaUtilList.size();
          int i = 0;
          while (i < j)
          {
            localJSONObject = new JSONObject();
            QzonePhotoInfo localQzonePhotoInfo = (QzonePhotoInfo)this.jdField_b_of_type_JavaUtilList.get(i);
            String str1 = localQzonePhotoInfo.jdField_a_of_type_JavaLangString;
            String str2 = localQzonePhotoInfo.jdField_c_of_type_JavaLangString;
            String str3 = localQzonePhotoInfo.jdField_b_of_type_JavaLangString;
            int k = localQzonePhotoInfo.jdField_b_of_type_Int;
            int m = localQzonePhotoInfo.jdField_a_of_type_Int;
            localJSONObject.put("albumid", str1);
            localJSONObject.put("lloc", str2);
            localJSONObject.put("url", str3);
            localJSONObject.put("height", Integer.valueOf(k));
            localJSONObject.put("width", Integer.valueOf(m));
            ((JSONArray)localObject).put(localJSONObject);
            i += 1;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("photoList", localObject);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("data", localJSONObject);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
          return;
        }
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("code", -1);
        ((JSONObject)localObject).put("msg", "fail");
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void i(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label174;
        }
        localObject1 = new JSONArray();
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(new JSONObject((String)((Iterator)localObject2).next()));
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("photoList", localObject1);
    ((JSONObject)localObject2).put("totalNumPreSelected", this.jdField_a_of_type_JavaUtilList.size());
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", 0);
    ((JSONObject)localObject1).put("msg", "success");
    ((JSONObject)localObject1).put("data", localObject2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
    return;
    label174:
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", -1);
    ((JSONObject)localObject1).put("msg", "fail");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
  }
  
  private void j(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).getString("callback");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = ((JSONObject)localObject1).optJSONArray("photoList");
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).get(i);
            if ((localObject2 == null) || (!(localObject2 instanceof String))) {
              break label253;
            }
            localObject2 = (String)localObject2;
            if (!((String)localObject2).startsWith("http://www.dynamicalbumlocalimage.com")) {
              break label253;
            }
            localObject2 = ((String)localObject2).replace("http://www.dynamicalbumlocalimage.com", "");
            Object localObject3 = a((String)localObject2);
            if (localObject3 == null) {
              return;
            }
            localObject2 = a((String)localObject2, ((bhro)localObject3).jdField_a_of_type_Int, ((bhro)localObject3).jdField_b_of_type_Int);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("code", 0);
              ((JSONObject)localObject3).put("msg", "success");
              ((JSONObject)localObject3).put("data", localObject2);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject3).toString() });
            }
            else
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("code", -1);
              ((JSONObject)localObject2).put("msg", "fail");
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label253:
      i += 1;
    }
  }
  
  private void k(String paramString)
  {
    try
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_c_of_type_JavaLangString = paramString;
      int i = new JSONObject(paramString).optInt("maxSelectNum");
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), NewPhotoListActivity.class);
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", i);
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", false);
      paramString.putExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", true);
      paramString.putExtra("PhotoConst.IS_NO_PANORAMA", true);
      paramString.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      paramString.putExtras((Bundle)localObject);
      bgxy.c(paramString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if (localObject != null)
      {
        ((WebViewFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramString, this.jdField_a_of_type_Byte);
        return;
      }
      ((AbsBaseWebViewActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a()).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramString, this.jdField_a_of_type_Byte);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public Object a(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (paramString.startsWith("http://www.dynamicalbumlocalimage.com")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin getImageResponse " + paramString);
      }
      return a(paramString);
    }
    return super.a(paramString, paramLong);
  }
  
  public void a()
  {
    super.a();
    bhkl.a().b(this);
    bhkl.a().a().i();
    armh.a(false, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), false);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneDynamicAlbumPlugin", 2, "unregiser fail");
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
    if (paramByte == this.jdField_a_of_type_Byte)
    {
      this.jdField_d_of_type_Boolean = false;
      if (paramInt == -1) {
        a(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      }
    }
    while (paramByte != 8)
    {
      return;
      a(null, 0);
      return;
    }
    a(paramIntent);
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    super.a(paramWebViewPlugin);
    if ((paramWebViewPlugin == null) || (paramWebViewPlugin.mRuntime == null) || (!(paramWebViewPlugin.mRuntime.a() instanceof QQBrowserActivity))) {
      return;
    }
    if (paramWebViewPlugin.mRuntime.a() != null) {}
    for (Object localObject = paramWebViewPlugin.mRuntime.a().h;; localObject = "")
    {
      jdField_d_of_type_JavaLangString = (String)localObject;
      if ((TextUtils.isEmpty(jdField_d_of_type_JavaLangString)) || ((!jdField_d_of_type_JavaLangString.contains("qzone.qq.com/dynamic")) && (!jdField_d_of_type_JavaLangString.contains("blog")))) {
        break;
      }
      if (jdField_a_of_type_JavaIoFile == null) {
        jdField_a_of_type_JavaIoFile = new File(jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_c_of_type_Boolean = true;
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.stopping");
      ((IntentFilter)localObject).addAction("com.tencent.process.starting");
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StopVideoChat");
      paramWebViewPlugin.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      bhkl.a().a(this);
      paramWebViewPlugin.mRuntime.a().getHandler(bhrl.class).post(new QzoneDynamicAlbumPlugin.1(this));
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    int i = localAudioManager.getStreamMaxVolume(3);
    int j = localAudioManager.getStreamVolume(3);
    if (localAudioManager.getRingerMode() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (!TextUtils.isEmpty(paramString)) {
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("type", paramInt);
        paramString.put("isMute", bool);
        paramString.put("maxVolume", i);
        paramString.put("currentVolume", j);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("qbrowserVolumeChange", paramString, paramString);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a(List<String> paramList, int paramInt)
  {
    String str;
    try
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        return;
      }
      str = new JSONObject(this.jdField_c_of_type_JavaLangString).optString("callback");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label194;
      }
      localObject = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((JSONArray)localObject).put(new JSONObject((String)paramList.next()));
      }
      paramList = new JSONObject();
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    paramList.put("photoList", localObject);
    paramList.put("totalNumPreSelected", paramInt);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("code", 0);
    ((JSONObject)localObject).put("msg", "success");
    ((JSONObject)localObject).put("data", paramList);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { ((JSONObject)localObject).toString() });
    return;
    label194:
    paramList = new JSONObject();
    paramList.put("code", -1);
    paramList.put("msg", "fail");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { paramList.toString() });
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (((!paramString2.equals("qzDynamicAlbum")) && (!paramString2.equals("Qzone"))) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (paramJsBridgeListener = "" + paramJsBridgeListener.jdField_a_of_type_Long;; paramJsBridgeListener = paramVarArgs[0])
    {
      QLog.d("QzoneDynamicAlbumPlugin", 4, "NAMESPACE = " + paramString2 + ";method = " + paramString3 + ";args = " + paramJsBridgeListener);
      if (!"deletePhotos".equals(paramString3)) {
        break;
      }
      e(paramJsBridgeListener);
      return true;
    }
    if ("saveDynamicAlbum".equals(paramString3)) {
      return true;
    }
    if ("getPhotos".equals(paramString3))
    {
      QZLog.d("dynamic.Album", 4, "handleJsRequest - getPhotos - isFromAlbum:" + this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Boolean) {
        h(paramJsBridgeListener);
      }
      for (;;)
      {
        return true;
        i(paramJsBridgeListener);
      }
    }
    if ("getBlogCloudPhotoUrls".equals(paramString3))
    {
      a(paramJsBridgeListener);
      return true;
    }
    if ("getCloudPhotoUrl".equals(paramString3)) {
      h(paramJsBridgeListener);
    }
    do
    {
      for (;;)
      {
        return false;
        if ("dynamicSendSuccess".equals(paramString3))
        {
          d();
        }
        else
        {
          if (!"isDraftPhotosValid".equals(paramString3)) {
            break;
          }
          c(paramJsBridgeListener);
        }
      }
      if ("getSelectNum".equals(paramString3))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(bhrl.class).post(new QzoneDynamicAlbumPlugin.3(this, paramJsBridgeListener));
        return true;
      }
      if ("entryWriteMoodAsync".equals(paramString3))
      {
        g(paramJsBridgeListener);
        return true;
      }
      if ("blogOpenQzoneImagePicker".equals(paramString3))
      {
        f(paramJsBridgeListener);
        return true;
      }
      if ("toBase64".equals(paramString3))
      {
        j(paramJsBridgeListener);
        return true;
      }
      if ("openImagePicker".equals(paramString3))
      {
        k(paramJsBridgeListener);
        return true;
      }
      if ("cancel".equals(paramString3))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(bhrl.class).post(new QzoneDynamicAlbumPlugin.4(this));
        return true;
      }
      if ("requestPlayMusic".equals(paramString3))
      {
        d(paramJsBridgeListener);
        return true;
      }
      if ("startPlay".equals(paramString3))
      {
        a(true);
        return true;
      }
      if ("endPlay".equals(paramString3))
      {
        a(false);
        return true;
      }
    } while (!"setDynamicAlbumData".equals(paramString3));
    b(paramJsBridgeListener);
    return true;
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    int i;
    Object localObject;
    int j;
    if ((paramLong == 8589934600L) && ((Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.jdField_a_of_type_Byte) || (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.jdField_c_of_type_Int)))
    {
      i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      localObject = (Intent)paramMap.get("data");
      j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if (i != this.jdField_a_of_type_Byte) {
        break label179;
      }
      if (j != -1) {
        break label170;
      }
      a(((Intent)localObject).getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("qzone.qq.com/dynamic")))
      {
        return super.a(paramString, paramLong, paramMap);
        label170:
        a(null, 0);
        continue;
        label179:
        if ((i != this.jdField_c_of_type_Int) || (j != -1)) {
          continue;
        }
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("isPublishDynamicMood", true);
          JSONObject localJSONObject = new JSONObject();
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put("*.qzone.qq.com");
          localJSONObject.put("echo", false);
          localJSONObject.put("broadcast", true);
          localJSONObject.put("domains", localJSONArray);
          a("publishDynamicMood", (JSONObject)localObject, localJSONObject);
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null)) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    if (paramString.contains("qzone.qq.com/dynamic/album/coverList")) {
      bhkl.a().a().l();
    }
    if (paramLong == 2L)
    {
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        a(null, 0);
      }
    }
    for (;;)
    {
      return super.a(paramString, paramLong, paramMap);
      if (paramLong == 8589934597L) {
        this.jdField_e_of_type_Boolean = false;
      } else if (paramLong == 8589934608L) {
        a("qbrowserVolumeChange", 2);
      } else if (paramLong == 8589934609L) {
        a("qbrowserVolumeChange", 1);
      } else if ((paramLong == 8589934601L) && (paramString.contains("qzone.qq.com/dynamic/album/preview"))) {
        bhkl.a().a().j();
      }
    }
  }
  
  public void b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("com.tencent.qq.qzone.playInterruptBegin", localJSONObject1, localJSONObject2);
  }
  
  public void c()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("com.tencent.qq.qzone.playWillBeInterruptEnd", localJSONObject1, localJSONObject2);
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    QZLog.d("dynamic.Album", 4, "onWebEvent: event - " + paramString);
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramString.equals("cmd.getDynamicPhoto"))
      {
        this.jdField_a_of_type_Boolean = paramBundle.getBoolean("param.DynamicIsFromAlbum", false);
        boolean bool = paramBundle.getBoolean("param.DynamicIsFromMakeBlog", false);
        this.jdField_b_of_type_Boolean = paramBundle.getBoolean("param.DynamicIsFromAlbumSharePanel", false);
        QZLog.d("dynamic.Album", 4, "onWebEvent - getBoolean - isFromAlbum:" + this.jdField_a_of_type_Boolean + " isFromMakeBlog:" + bool);
        if (this.jdField_a_of_type_Boolean)
        {
          if (bool)
          {
            a(paramBundle, false);
            return;
          }
          a(paramBundle, true);
          return;
        }
        a(paramBundle.getStringArrayList("param.DynamicPhotolist"));
        return;
      }
      if (paramString.equals("cmd.getDynamicSelnum"))
      {
        a(paramBundle);
        return;
      }
    } while (!paramString.equals("cmd.getDynamicCloudPhoto"));
    a(paramBundle, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhrl
 * JD-Core Version:    0.7.0.1
 */