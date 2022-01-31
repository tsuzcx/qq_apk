import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.1;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class arsj
{
  public static int a;
  private static List<String> a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static final int g;
  public static final int h;
  
  static
  {
    jdField_a_of_type_Int = 232;
    b = 750;
    c = 130;
    d = 421;
    if (BaseChatItemLayout.e > 0)
    {
      jdField_a_of_type_Int = BaseChatItemLayout.e;
      c = (int)(BaseChatItemLayout.e * 0.5625F);
    }
    e = jdField_a_of_type_Int;
    f = c;
    float f1 = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density;
    if (f1 != 0.0F)
    {
      e = (int)(jdField_a_of_type_Int / f1);
      f = (int)(c / f1);
    }
    g = c;
    h = jdField_a_of_type_Int;
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      paramInt2 = 0;
      return paramInt2;
    }
    int j = 1;
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      i >>= 1;
      paramInt2 >>= 1;
      if ((i < paramInt3) || (paramInt2 < paramInt3))
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= 1) {
          break;
        }
        return 1;
      }
      paramInt1 *= 2;
    }
  }
  
  public static long a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      if (jdField_a_of_type_JavaUtilList.contains(paramString)) {
        return -1L;
      }
      jdField_a_of_type_JavaUtilList.add(paramString);
      return 1L;
    }
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 89	java/io/BufferedInputStream
    //   5: dup
    //   6: new 91	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 97	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: aconst_null
    //   22: aload_1
    //   23: invokestatic 103	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: ifnull +9 -> 39
    //   33: aload_2
    //   34: invokevirtual 108	java/io/InputStream:close	()V
    //   37: aload_1
    //   38: astore_0
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +14 -> 63
    //   52: aload_2
    //   53: astore_0
    //   54: ldc 116
    //   56: iconst_2
    //   57: ldc 118
    //   59: aload_1
    //   60: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   63: aload_3
    //   64: astore_0
    //   65: aload_2
    //   66: ifnull -27 -> 39
    //   69: aload_2
    //   70: invokevirtual 108	java/io/InputStream:close	()V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_0
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: astore_0
    //   83: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +14 -> 100
    //   89: aload_2
    //   90: astore_0
    //   91: ldc 116
    //   93: iconst_2
    //   94: ldc 123
    //   96: aload_1
    //   97: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_3
    //   101: astore_0
    //   102: aload_2
    //   103: ifnull -64 -> 39
    //   106: aload_2
    //   107: invokevirtual 108	java/io/InputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 108	java/io/InputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_0
    //   129: aload_1
    //   130: areturn
    //   131: astore_0
    //   132: goto -6 -> 126
    //   135: astore_1
    //   136: goto -18 -> 118
    //   139: astore_1
    //   140: goto -59 -> 81
    //   143: astore_1
    //   144: goto -100 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   0	147	1	paramOptions	BitmapFactory.Options
    //   17	90	2	localBufferedInputStream	java.io.BufferedInputStream
    //   1	100	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	41	java/lang/OutOfMemoryError
    //   69	73	75	java/io/IOException
    //   2	18	78	java/lang/Exception
    //   106	110	112	java/io/IOException
    //   2	18	115	finally
    //   33	37	128	java/io/IOException
    //   122	126	131	java/io/IOException
    //   20	27	135	finally
    //   46	52	135	finally
    //   54	63	135	finally
    //   83	89	135	finally
    //   91	100	135	finally
    //   20	27	139	java/lang/Exception
    //   20	27	143	java/lang/OutOfMemoryError
  }
  
  public static arsk a(int paramInt1, int paramInt2, arsl paramarsl, boolean paramBoolean)
  {
    int i1 = jdField_a_of_type_Int;
    int i2 = c;
    int j;
    int i;
    int k;
    int m;
    int i3;
    int n;
    switch (paramarsl.b)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      j = paramInt2;
      i = paramInt1;
      k = paramInt2;
      m = paramInt1;
      if (i > j)
      {
        i3 = i;
        n = j;
        switch (paramarsl.jdField_a_of_type_Int)
        {
        default: 
          paramarsl = new arsk();
          paramarsl.jdField_a_of_type_Int = paramInt1;
          paramarsl.b = paramInt2;
          return paramarsl;
        }
      }
      break;
    case 1: 
    case 3: 
    case 6: 
      label79:
      if (paramInt1 > paramInt2)
      {
        i = paramInt2;
        k = (int)(i * 1.777778F);
        if (paramInt1 <= paramInt2) {
          break label199;
        }
        j = i;
        i = k;
        if (k > paramInt1) {
          i = paramInt1;
        }
        if (j <= paramInt2) {
          break label474;
        }
      }
      label140:
      label158:
      break;
    }
    for (;;)
    {
      j = paramInt2;
      k = paramInt2;
      m = i;
      paramInt1 = i;
      break;
      i = paramInt1;
      break label140;
      label199:
      j = k;
      k = i;
      break label158;
      i3 = j;
      n = i;
      break label79;
      float f1 = i2 / (n * 1.0F);
      n = (int)(i3 * f1);
      if (m > paramInt1) {}
      for (;;)
      {
        if (k > paramInt2) {}
        for (;;)
        {
          k = Math.round(paramInt1 * f1);
          m = Math.round(paramInt2 * f1);
          if (i > j)
          {
            paramInt2 = i2;
            i = i1;
            label287:
            paramInt1 = i;
            if (i > k) {
              paramInt1 = k;
            }
            if (paramInt2 <= m) {
              break label459;
            }
            paramInt2 = m;
          }
          label405:
          label441:
          label459:
          for (;;)
          {
            break;
            paramInt2 = i1;
            i = i2;
            break label287;
            f1 = i1 / (i3 * 1.0F);
            n = (int)(n * f1);
            if ((i <= j) || (m > paramInt1)) {}
            for (;;)
            {
              if (k > paramInt2) {}
              for (;;)
              {
                paramInt1 = Math.round(paramInt1 * f1);
                paramInt2 = Math.round(paramInt2 * f1);
                break;
                break;
                k = (int)(n * 1.777778F);
                if (i > j)
                {
                  i = n;
                  j = k;
                  if (k > paramInt1) {
                    j = paramInt1;
                  }
                  if (i <= paramInt2) {
                    break label441;
                  }
                }
                for (;;)
                {
                  paramInt1 = j;
                  break;
                  i = k;
                  k = n;
                  break label405;
                  paramInt2 = i;
                }
                paramInt2 = k;
              }
              paramInt1 = m;
            }
          }
          paramInt2 = k;
        }
        paramInt1 = m;
      }
      label474:
      paramInt2 = j;
    }
  }
  
  public static arsk a(int paramInt1, int paramInt2, String paramString)
  {
    int i = g;
    int j = h;
    arsk localarsk = new arsk();
    float f1;
    if (bdhb.b(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      a(paramString, localOptions);
      localarsk.jdField_a_of_type_Int = localOptions.outWidth;
      localarsk.b = localOptions.outHeight;
      paramString = localarsk;
      paramInt2 = paramString.jdField_a_of_type_Int;
      paramInt1 = paramString.b;
      f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      if ((paramInt2 >= f) && (paramInt1 >= f)) {
        break label234;
      }
      if (paramInt2 < paramInt1)
      {
        f1 = c / paramInt2;
        i = c;
        j = (int)(f1 * paramInt1 + 0.5F);
        paramInt1 = j;
        paramInt2 = i;
        if (j > jdField_a_of_type_Int)
        {
          paramInt1 = jdField_a_of_type_Int;
          paramInt2 = i;
        }
        label157:
        paramString.jdField_a_of_type_Int = paramInt2;
        paramString.b = paramInt1;
        return paramString;
      }
    }
    else
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break label379;
      }
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramString = a(paramInt2, i, false);
      break;
      paramInt2 = (int)(c / paramInt1 * paramInt2 + 0.5F);
      paramInt1 = paramInt2;
      if (paramInt2 > jdField_a_of_type_Int) {
        paramInt1 = jdField_a_of_type_Int;
      }
      i = c;
      paramInt2 = paramInt1;
      paramInt1 = i;
      break label157;
      label234:
      if ((paramInt2 < e) && (paramInt1 < e))
      {
        paramInt2 = (int)(paramInt2 * f1 + 0.5F);
        paramInt1 = (int)(f1 * paramInt1 + 0.5F);
        break label157;
      }
      if (paramInt2 > paramInt1)
      {
        f1 = jdField_a_of_type_Int / paramInt2;
        label282:
        if (paramInt2 <= paramInt1) {
          break label367;
        }
      }
      label367:
      for (float f2 = c / paramInt1;; f2 = c / paramInt2)
      {
        f1 = Math.max(f1, f2);
        paramInt2 = (int)(paramInt2 * f1 + 0.5F);
        paramInt1 = (int)(f1 * paramInt1 + 0.5F);
        paramInt2 = Math.min(paramInt2, jdField_a_of_type_Int);
        paramInt1 = Math.min(paramInt1, jdField_a_of_type_Int);
        paramInt2 = Math.max(paramInt2, c);
        paramInt1 = Math.max(paramInt1, c);
        break;
        f1 = jdField_a_of_type_Int / paramInt1;
        break label282;
      }
      label379:
      paramInt1 = j;
      paramInt2 = i;
      i = paramInt1;
    }
  }
  
  public static arsk a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    for (int j = paramInt1;; j = paramInt2)
    {
      arsl localarsl = a(i, j);
      i = a(paramInt1, paramInt2, jdField_a_of_type_Int);
      return a(paramInt1 * i, i * paramInt2, localarsl, false);
      i = paramInt1;
    }
  }
  
  public static arsk a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    arsk localarsk = new arsk();
    int j;
    int i;
    float f1;
    int k;
    if (bdhb.b(paramFileManagerEntity.strMiddleThumPath))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      a(paramFileManagerEntity.strMiddleThumPath, localOptions);
      localarsk.jdField_a_of_type_Int = localOptions.outWidth;
      localarsk.b = localOptions.outHeight;
      paramFileManagerEntity = localarsk;
      j = paramFileManagerEntity.jdField_a_of_type_Int;
      i = paramFileManagerEntity.b;
      f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      if ((j >= f) && (i >= f)) {
        break label272;
      }
      if (j >= i) {
        break label226;
      }
      f1 = c / j;
      k = c;
      int m = (int)(f1 * i + 0.5F);
      i = m;
      j = k;
      if (m > jdField_a_of_type_Int)
      {
        i = jdField_a_of_type_Int;
        j = k;
      }
    }
    for (;;)
    {
      paramFileManagerEntity.jdField_a_of_type_Int = j;
      paramFileManagerEntity.b = i;
      return paramFileManagerEntity;
      if ((paramFileManagerEntity.imgWidth > 0) && (paramFileManagerEntity.imgHeight > 0)) {
        j = paramFileManagerEntity.imgWidth;
      }
      for (i = paramFileManagerEntity.imgHeight;; i = h)
      {
        paramFileManagerEntity = a(j, i, false);
        break;
        j = g;
      }
      label226:
      j = (int)(c / i * j + 0.5F);
      i = j;
      if (j > jdField_a_of_type_Int) {
        i = jdField_a_of_type_Int;
      }
      k = c;
      j = i;
      i = k;
      continue;
      label272:
      if ((j >= e) || (i >= e)) {
        break label310;
      }
      j = (int)(j * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
    }
    label310:
    if (j > i)
    {
      f1 = jdField_a_of_type_Int / j;
      label325:
      if (j <= i) {
        break label379;
      }
    }
    label379:
    for (float f2 = c / i;; f2 = c / j)
    {
      f1 = Math.max(f1, f2);
      j = (int)(j * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
      break;
      f1 = jdField_a_of_type_Int / i;
      break label325;
    }
  }
  
  private static arsl a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 1;
    int k = jdField_a_of_type_Int;
    int m = c;
    if (paramInt1 > k) {
      if (a(paramInt1, paramInt2))
      {
        paramInt2 = 1;
        paramInt1 = j;
      }
    }
    for (;;)
    {
      arsl localarsl = new arsl();
      localarsl.jdField_a_of_type_Int = paramInt2;
      localarsl.b = paramInt1;
      return localarsl;
      paramInt1 = 2;
      paramInt2 = 2;
      continue;
      if ((paramInt1 <= k) && (paramInt1 > m))
      {
        if (paramInt2 > k)
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt2 = 1;
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 4;
          paramInt2 = 2;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          paramInt1 = 5;
          paramInt2 = 3;
        }
      }
      else if ((paramInt1 <= m) && (paramInt1 > 0))
      {
        if (paramInt2 > k)
        {
          paramInt1 = 6;
          paramInt2 = 4;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 7;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 8;
          paramInt2 = 3;
          continue;
        }
        if ((paramInt2 <= m) && (paramInt2 > 0))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 9;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 10;
          paramInt2 = 3;
          continue;
        }
      }
      paramInt1 = 0;
      paramInt2 = i;
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "getThumbPath entity is null, so return null");
      localObject = null;
      return localObject;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
      paramFileManagerEntity = bhqh.a(paramFileManagerEntity.strFileMd5);
    }
    for (;;)
    {
      localObject = paramFileManagerEntity;
      if (paramFileManagerEntity == null) {
        break;
      }
      return paramFileManagerEntity.replace("/", "");
      if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))
      {
        paramFileManagerEntity = bhqh.a(paramFileManagerEntity.Uuid);
      }
      else if (arso.b(paramFileManagerEntity.getFilePath()))
      {
        localObject = arrr.d(paramFileManagerEntity.getFilePath());
        if ((localObject != null) && (localObject.length > 0)) {
          paramFileManagerEntity = bdhe.a((byte[])localObject).toUpperCase();
        } else {
          paramFileManagerEntity = bhqh.a(paramFileManagerEntity.fileName);
        }
      }
      else
      {
        paramFileManagerEntity = bhqh.a(paramFileManagerEntity.fileName);
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (!arso.b(paramString)) {}
    label141:
    for (;;)
    {
      return null;
      String str1 = bdhe.a(arrr.d(paramString));
      a();
      str1 = arqx.a().d() + a(5, str1);
      String str2 = str1 + "_original_.tmp";
      if (bdhb.b(paramString)) {}
      for (;;)
      {
        for (;;)
        {
          if (paramString == null) {
            break label141;
          }
          try
          {
            if (!bdhb.b(str2)) {
              awkr.a(paramString, str2, true, "", 1);
            }
            if ((!bdhb.b(str2)) || (bdhb.b(new File(str2), new File(str1)) != true)) {
              break;
            }
            return str1;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
        paramString = null;
      }
    }
  }
  
  private static String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    if (a(paramString2) == -1L)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile temp Thumb file " + paramString2 + " is creating");
      return null;
    }
    if (!bdhb.b(paramString1))
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile file " + paramString1 + " is not exist");
      paramString1 = localObject;
    }
    for (;;)
    {
      a(paramString2);
      return paramString1;
      a();
      String str = paramString2 + ".tmp";
      try
      {
        awkr.a(paramString1, str, true, "", paramInt);
        if (bdhb.b(str)) {
          break label220;
        }
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile created tmp Thumb file " + str + " failed");
        paramString1 = localObject;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile created tmp Thumb file " + str + " failed");
        paramString1 = localObject;
      }
      continue;
      label220:
      if (!bdhb.b(new File(str), new File(paramString2)))
      {
        bdhb.a(str, true);
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile rename tmp Thumb file " + str + " failed");
        paramString1 = localObject;
      }
      else
      {
        paramString1 = paramString2;
      }
    }
  }
  
  public static URL a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    String str;
    do
    {
      return null;
      int j = 0;
      int i = j;
      if (paramFileManagerEntity.getCloudType() == 3)
      {
        i = j;
        if (!bdhb.b(paramFileManagerEntity.strMiddleThumPath)) {
          i = 1;
        }
      }
      if (i == 0) {
        break;
      }
      str = a(paramFileManagerEntity.getFilePath());
    } while (str == null);
    Object localObject2 = paramFileManagerEntity.strFileMd5;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramFileManagerEntity.Uuid;
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = bdhe.a(arrr.d(paramFileManagerEntity.getFilePath())).toUpperCase();
    }
    localObject1 = arqx.a().d() + a(5, bhqh.a((String)localObject2));
    if ((bdhb.b(str)) && (!arso.b(paramFileManagerEntity.strMiddleThumPath)) && (bdhb.b(new File(str), new File((String)localObject1)) == true)) {
      paramFileManagerEntity.strMiddleThumPath = ((String)localObject1);
    }
    return b(paramFileManagerEntity);
  }
  
  private static void a()
  {
    File localFile = new File(arqx.a().d());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithOrig entity is null, so return null");
      return;
    }
    if (bdhb.b(paramFileManagerEntity.strMiddleThumPath))
    {
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithOrig Thumb file " + paramFileManagerEntity.strMiddleThumPath + " already exist");
      return;
    }
    a(paramFileManagerEntity, paramFileManagerEntity.getFilePath());
  }
  
  private static void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    String str = a(paramFileManagerEntity);
    paramString = a(paramString, arqx.a().d() + a(5, str), 1);
    if (paramString == null) {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge failed");
    }
    do
    {
      return;
      paramFileManagerEntity.strMiddleThumPath = paramString;
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramString == null);
    paramString.a().c(paramFileManagerEntity);
    paramString.a().a(true, 3, null);
  }
  
  private static void a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      jdField_a_of_type_JavaUtilList.remove(paramString);
      return;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 > (int)(paramInt1 * 1.777778F);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.status == 16) && (!arrr.e(paramFileManagerEntity))) {}
    while ((paramFileManagerEntity.cloudType == 1) && (arrr.a(paramFileManagerEntity))) {
      return true;
    }
    return false;
  }
  
  public static URL b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    Object localObject2 = paramFileManagerEntity.strMiddleThumPath;
    Object localObject1 = localObject2;
    if (paramFileManagerEntity.status == 16)
    {
      localObject1 = localObject2;
      if (!arso.b((String)localObject2))
      {
        if (!arso.b(paramFileManagerEntity.strLargeThumPath)) {
          break label129;
        }
        localObject1 = paramFileManagerEntity.strLargeThumPath;
      }
    }
    label46:
    localObject2 = localObject1;
    if (!arso.b((String)localObject1))
    {
      localObject2 = localObject1;
      if (arso.b(paramFileManagerEntity.strLargeThumPath))
      {
        localObject1 = paramFileManagerEntity.strLargeThumPath;
        localObject2 = localObject1;
        if (b(paramFileManagerEntity))
        {
          ThreadManager.post(new FilePicURLDrawlableHelper.1(paramFileManagerEntity), 8, null, false);
          localObject2 = localObject1;
        }
      }
    }
    if (bdhb.b((String)localObject2)) {}
    for (;;)
    {
      label129:
      try
      {
        paramFileManagerEntity = AsyncImageView.a((String)localObject2, -1, -1, new File((String)localObject2), false, false, true);
        if (paramFileManagerEntity == null) {
          break;
        }
        return paramFileManagerEntity;
      }
      catch (Exception paramFileManagerEntity) {}
      localObject1 = localObject2;
      if (!arso.b(paramFileManagerEntity.strThumbPath)) {
        break label46;
      }
      localObject1 = paramFileManagerEntity.strThumbPath;
      break label46;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FilePicURLDrawlableHelper<FileAssistant>", 1, "createFilePicDrawlableURL generateAIOThumbURL error!");
      return null;
      paramFileManagerEntity = null;
    }
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQXLarge entity is null, so return null");
      return;
    }
    if (bdhb.b(paramFileManagerEntity.strMiddleThumPath))
    {
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQXLarge Thumb file " + paramFileManagerEntity.strMiddleThumPath + " already exist");
      return;
    }
    a(paramFileManagerEntity, paramFileManagerEntity.strLargeThumPath);
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramInt1 <= 0)) {}
    for (;;)
    {
      return true;
      int i;
      if (paramInt1 > paramInt2)
      {
        i = paramInt2;
        paramInt2 = paramInt1;
      }
      while (!a(i, paramInt2))
      {
        return false;
        i = paramInt1;
      }
    }
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return b(paramFileManagerEntity.imgWidth, paramFileManagerEntity.imgHeight);
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge entity is null, so return null");
      return;
    }
    if (bdhb.b(paramFileManagerEntity.strMiddleThumPath)) {}
    a(paramFileManagerEntity, paramFileManagerEntity.strMiddleThumPath);
  }
  
  public static void d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig entity is null, so return");
      return;
    }
    if (paramFileManagerEntity.nFileType != 0)
    {
      QLog.i("FilePicURLDrawlableHelper<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] createQXlargeThumbWithOrig is not image file!");
      return;
    }
    if (bdhb.b(paramFileManagerEntity.strLargeThumPath))
    {
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig Thumb file " + paramFileManagerEntity.strLargeThumPath + " already exist");
      return;
    }
    String str = a(paramFileManagerEntity);
    str = arqx.a().d() + a(7, str);
    str = a(paramFileManagerEntity.getFilePath(), str, 2);
    if (str == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig failed");
      return;
    }
    paramFileManagerEntity.strLargeThumPath = str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsj
 * JD-Core Version:    0.7.0.1
 */