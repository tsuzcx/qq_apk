import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.1;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.2;
import com.tencent.mobileqq.ark.image.ChooseImageInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class aqba
  extends QIPCModule
{
  public static int a;
  private static volatile aqba jdField_a_of_type_Aqba;
  private aqbd jdField_a_of_type_Aqbd;
  private aqbe jdField_a_of_type_Aqbe;
  
  public aqba(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +7 -> 8
    //   4: aload_0
    //   5: ifnonnull +5 -> 10
    //   8: aload_0
    //   9: areturn
    //   10: new 21	android/graphics/Matrix
    //   13: dup
    //   14: invokespecial 24	android/graphics/Matrix:<init>	()V
    //   17: astore_2
    //   18: aload_2
    //   19: iload_1
    //   20: i2f
    //   21: aload_0
    //   22: invokevirtual 30	android/graphics/Bitmap:getWidth	()I
    //   25: iconst_2
    //   26: idiv
    //   27: i2f
    //   28: aload_0
    //   29: invokevirtual 33	android/graphics/Bitmap:getHeight	()I
    //   32: iconst_2
    //   33: idiv
    //   34: i2f
    //   35: invokevirtual 37	android/graphics/Matrix:setRotate	(FFF)V
    //   38: aload_0
    //   39: iconst_0
    //   40: iconst_0
    //   41: aload_0
    //   42: invokevirtual 30	android/graphics/Bitmap:getWidth	()I
    //   45: aload_0
    //   46: invokevirtual 33	android/graphics/Bitmap:getHeight	()I
    //   49: aload_2
    //   50: iconst_1
    //   51: invokestatic 41	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   54: astore_2
    //   55: aload_0
    //   56: invokevirtual 44	android/graphics/Bitmap:recycle	()V
    //   59: aload_2
    //   60: astore_0
    //   61: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq -56 -> 8
    //   67: ldc 52
    //   69: iconst_2
    //   70: iconst_2
    //   71: anewarray 54	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: ldc 56
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: iload_1
    //   82: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   89: aload_2
    //   90: areturn
    //   91: astore_0
    //   92: ldc 52
    //   94: iconst_1
    //   95: ldc 68
    //   97: aload_0
    //   98: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_2
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_2
    //   106: ldc 52
    //   108: iconst_1
    //   109: ldc 73
    //   111: aload_0
    //   112: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_2
    //   116: areturn
    //   117: astore_0
    //   118: goto -12 -> 106
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_2
    //   124: goto -32 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramBitmap	Bitmap
    //   0	127	1	paramInt	int
    //   17	107	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	59	91	java/lang/Exception
    //   61	89	91	java/lang/Exception
    //   10	55	103	java/lang/OutOfMemoryError
    //   55	59	117	java/lang/OutOfMemoryError
    //   61	89	117	java/lang/OutOfMemoryError
    //   10	55	121	java/lang/Exception
  }
  
  public static aqba a()
  {
    if (jdField_a_of_type_Aqba == null) {}
    try
    {
      if (jdField_a_of_type_Aqba == null) {
        jdField_a_of_type_Aqba = new aqba("ChooseImageIPCModule");
      }
      return jdField_a_of_type_Aqba;
    }
    finally {}
  }
  
  /* Error */
  public static String a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 86	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 92	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   10: pop
    //   11: aload_1
    //   12: getfield 95	android/graphics/BitmapFactory$Options:outWidth	I
    //   15: ifle +74 -> 89
    //   18: aload_1
    //   19: getfield 98	android/graphics/BitmapFactory$Options:outHeight	I
    //   22: ifle +67 -> 89
    //   25: aload_1
    //   26: getfield 102	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   29: ifnonnull +60 -> 89
    //   32: ldc 104
    //   34: areturn
    //   35: astore_0
    //   36: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq -28 -> 11
    //   42: ldc 52
    //   44: iconst_2
    //   45: ldc 106
    //   47: aload_0
    //   48: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   51: goto -40 -> 11
    //   54: astore_0
    //   55: aload_0
    //   56: athrow
    //   57: astore_0
    //   58: ldc 52
    //   60: iconst_1
    //   61: ldc 111
    //   63: aload_0
    //   64: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   67: goto -56 -> 11
    //   70: astore_0
    //   71: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq -63 -> 11
    //   77: ldc 52
    //   79: iconst_2
    //   80: ldc 106
    //   82: aload_0
    //   83: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: goto -75 -> 11
    //   89: aload_1
    //   90: getfield 102	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   93: ifnull +29 -> 122
    //   96: aload_1
    //   97: getfield 102	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   100: bipush 47
    //   102: invokevirtual 117	java/lang/String:indexOf	(I)I
    //   105: istore_2
    //   106: iload_2
    //   107: iconst_m1
    //   108: if_icmpeq +14 -> 122
    //   111: aload_1
    //   112: getfield 102	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   115: iload_2
    //   116: iconst_1
    //   117: iadd
    //   118: invokevirtual 121	java/lang/String:substring	(I)Ljava/lang/String;
    //   121: areturn
    //   122: ldc 123
    //   124: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   0	125	1	paramOptions	BitmapFactory.Options
    //   105	13	2	i	int
    // Exception table:
    //   from	to	target	type
    //   5	11	35	java/lang/OutOfMemoryError
    //   5	11	54	finally
    //   36	51	54	finally
    //   71	86	54	finally
    //   55	57	57	java/lang/OutOfMemoryError
    //   5	11	70	java/lang/Exception
  }
  
  public static String a(ArrayList<String> paramArrayList, String paramString1, boolean paramBoolean, String paramString2)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      jdField_a_of_type_Int += 1;
      if ((jdField_a_of_type_Int >= 100) || (jdField_a_of_type_Int < 0)) {
        jdField_a_of_type_Int = 0;
      }
      String str2 = String.format("tmp_%d_%02d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(jdField_a_of_type_Int) });
      String str3 = paramString1 + "/" + str2;
      BitmapFactory.Options localOptions = BitmapUtils.getOptions();
      String str4 = a(str1, localOptions);
      paramArrayList = Bitmap.CompressFormat.JPEG;
      int i = 1;
      label163:
      String str5;
      boolean bool;
      if (("jpg".equalsIgnoreCase(str4)) || ("jpeg".equalsIgnoreCase(str4)))
      {
        paramArrayList = Bitmap.CompressFormat.JPEG;
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ChooseImageIPCModule", 2, String.format("image size origin[%d,%d]", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) }));
        }
        if (!paramBoolean) {
          break label422;
        }
        str5 = str3 + "_compress";
        if (i == 0) {
          break label409;
        }
        if (!a(str1, str5, paramArrayList, 80, localOptions)) {
          break label390;
        }
        bool = FileUtils.rename(str5, str3);
      }
      for (;;)
      {
        if (!bool) {
          break label435;
        }
        long l = new File(str3).length();
        paramArrayList = new ChooseImageInfo();
        paramArrayList.path = (paramString2 + str2);
        paramArrayList.format = str4;
        paramArrayList.size = l;
        localJSONArray.put(bgzr.a(paramArrayList));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ArkApp.ChooseImageIPCModule", 2, String.format("copy Image success ![%s]->[%s].", new Object[] { str1, str3 }));
        break;
        if ("png".equalsIgnoreCase(str4))
        {
          paramArrayList = Bitmap.CompressFormat.PNG;
          break label163;
        }
        i = 0;
        break label163;
        label390:
        FileUtils.deleteFile(str5);
        bool = a(str1, str3, paramArrayList);
        continue;
        label409:
        bool = a(str1, str3, paramArrayList);
        continue;
        label422:
        bool = a(str1, str3, paramArrayList);
      }
      label435:
      QLog.e("ArkApp.ChooseImageIPCModule", 1, String.format("copy Image fail! [%s]->[%s].", new Object[] { str1, str3 }));
    }
    paramArrayList = localJSONArray.toString();
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ChooseImageIPCModule", 1, new Object[] { "copy Image imageinfo=", paramArrayList });
    }
    return paramArrayList;
  }
  
  public static boolean a(String paramString1, String paramString2, Bitmap.CompressFormat paramCompressFormat)
  {
    bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    bool2 = false;
    localObject1 = new File(paramString1);
    int i;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (((File)localObject1).exists())
    {
      i = bheg.a(paramString1);
      if ((i != 0) && (i % 90 == 0) && ((Bitmap.CompressFormat.JPEG == paramCompressFormat) || (Bitmap.CompressFormat.PNG == paramCompressFormat)))
      {
        localObject5 = null;
        localObject6 = null;
        localObject7 = null;
        localObject8 = null;
        localObject9 = null;
        localObject2 = localObject5;
        localObject3 = localObject6;
        localObject4 = localObject7;
        localObject1 = localObject8;
      }
    }
    else
    {
      try
      {
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString1));
        paramString1 = localObject9;
        if (localBufferedInputStream != null)
        {
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject4 = localObject7;
          localObject1 = localObject8;
          paramString1 = BitmapFactory.decodeStream(localBufferedInputStream);
          localObject2 = paramString1;
          localObject3 = paramString1;
          localObject4 = paramString1;
          localObject1 = paramString1;
          paramString1 = a(paramString1, i);
          localObject2 = paramString1;
          localObject3 = paramString1;
          localObject4 = paramString1;
          localObject1 = paramString1;
          paramString2 = new FileOutputStream(paramString2);
          localObject2 = paramString1;
          localObject3 = paramString1;
          localObject4 = paramString1;
          localObject1 = paramString1;
          bool1 = paramString1.compress(paramCompressFormat, 90, paramString2);
          localObject1 = paramString1;
        }
        try
        {
          bool1 = FileUtils.copyFile((File)localObject1, FileUtils.createFile(paramString2));
          return bool1;
        }
        catch (IOException paramCompressFormat)
        {
          QLog.d("ArkApp.ChooseImageIPCModule", 1, "copy fail from " + paramString1 + " to " + paramString2 + " " + paramCompressFormat.getMessage());
          return false;
        }
      }
      catch (FileNotFoundException paramString2)
      {
        do
        {
          do
          {
            paramString2 = paramString2;
            paramString1 = (String)localObject2;
            bool2 = bool3;
            localObject1 = paramString1;
            QLog.d("ArkApp.ChooseImageIPCModule", 1, "FileNotFoundException:", paramString2);
            bool1 = bool2;
          } while (paramString1 == null);
          bool1 = bool2;
        } while (paramString1.isRecycled());
        paramString1.recycle();
        return bool2;
      }
      catch (OutOfMemoryError paramString2)
      {
        do
        {
          do
          {
            paramString1 = (String)localObject3;
            bool2 = bool4;
            localObject1 = paramString1;
            QLog.d("ArkApp.ChooseImageIPCModule", 1, "OutOfMemoryError:", paramString2);
            bool1 = bool2;
          } while (paramString1 == null);
          bool1 = bool2;
        } while (paramString1.isRecycled());
        paramString1.recycle();
        return bool2;
      }
      catch (IOException paramString2)
      {
        do
        {
          do
          {
            paramString1 = (String)localObject4;
            bool2 = bool5;
            localObject1 = paramString1;
            QLog.d("ArkApp.ChooseImageIPCModule", 1, "IOException:", paramString2);
            bool1 = bool2;
          } while (paramString1 == null);
          bool1 = bool2;
        } while (paramString1.isRecycled());
        paramString1.recycle();
        return bool2;
      }
      finally
      {
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
          ((Bitmap)localObject1).recycle();
        }
      }
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, Bitmap.CompressFormat paramCompressFormat, int paramInt, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload 4
    //   2: iconst_0
    //   3: putfield 86	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   6: aload 4
    //   8: getfield 95	android/graphics/BitmapFactory$Options:outWidth	I
    //   11: istore 7
    //   13: aload 4
    //   15: getfield 98	android/graphics/BitmapFactory$Options:outHeight	I
    //   18: istore 8
    //   20: iconst_1
    //   21: istore 6
    //   23: iload 7
    //   25: iload 8
    //   27: if_icmple +308 -> 335
    //   30: iload 7
    //   32: i2f
    //   33: ldc_w 328
    //   36: fcmpl
    //   37: ifle +298 -> 335
    //   40: aload 4
    //   42: getfield 95	android/graphics/BitmapFactory$Options:outWidth	I
    //   45: i2f
    //   46: ldc_w 328
    //   49: fdiv
    //   50: f2i
    //   51: istore 5
    //   53: iload 5
    //   55: istore 6
    //   57: iload 5
    //   59: ifgt +6 -> 65
    //   62: iconst_1
    //   63: istore 6
    //   65: aload 4
    //   67: iload 6
    //   69: putfield 331	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   72: aload_0
    //   73: aload 4
    //   75: invokestatic 92	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   78: astore 16
    //   80: aload_1
    //   81: invokestatic 333	bheg:a	(Ljava/lang/String;)Ljava/io/File;
    //   84: astore 18
    //   86: aconst_null
    //   87: astore 15
    //   89: aconst_null
    //   90: astore 17
    //   92: aload_0
    //   93: invokestatic 273	bheg:a	(Ljava/lang/String;)I
    //   96: istore 5
    //   98: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +27 -> 128
    //   104: ldc 52
    //   106: iconst_1
    //   107: iconst_2
    //   108: anewarray 54	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: ldc_w 335
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: iload 5
    //   121: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   128: iload 5
    //   130: ifeq +804 -> 934
    //   133: iload 5
    //   135: bipush 90
    //   137: irem
    //   138: ifne +796 -> 934
    //   141: aload 16
    //   143: iload 5
    //   145: invokestatic 287	aqba:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   148: astore 16
    //   150: new 337	java/io/BufferedOutputStream
    //   153: dup
    //   154: new 289	java/io/FileOutputStream
    //   157: dup
    //   158: aload 18
    //   160: invokespecial 340	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   163: invokespecial 343	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   166: astore 14
    //   168: aload 14
    //   170: astore 15
    //   172: aload 16
    //   174: aload_2
    //   175: iload_3
    //   176: aload 14
    //   178: invokevirtual 294	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   181: istore 9
    //   183: aload 14
    //   185: ifnull +8 -> 193
    //   188: aload 14
    //   190: invokevirtual 346	java/io/OutputStream:close	()V
    //   193: aload 16
    //   195: ifnull +16 -> 211
    //   198: aload 16
    //   200: invokevirtual 304	android/graphics/Bitmap:isRecycled	()Z
    //   203: ifne +8 -> 211
    //   206: aload 16
    //   208: invokevirtual 44	android/graphics/Bitmap:recycle	()V
    //   211: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +717 -> 931
    //   217: new 214	java/io/File
    //   220: dup
    //   221: aload_0
    //   222: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   225: astore_2
    //   226: aload_2
    //   227: ifnull +698 -> 925
    //   230: aload_2
    //   231: invokevirtual 218	java/io/File:length	()J
    //   234: lstore 10
    //   236: lconst_0
    //   237: lstore 12
    //   239: aload 18
    //   241: ifnull +10 -> 251
    //   244: aload 18
    //   246: invokevirtual 218	java/io/File:length	()J
    //   249: lstore 12
    //   251: ldc 52
    //   253: iconst_2
    //   254: ldc_w 348
    //   257: bipush 8
    //   259: anewarray 54	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload_0
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: lload 10
    //   270: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   273: aastore
    //   274: dup
    //   275: iconst_2
    //   276: iload 7
    //   278: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: aastore
    //   282: dup
    //   283: iconst_3
    //   284: iload 8
    //   286: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: dup
    //   291: iconst_4
    //   292: aload_1
    //   293: aastore
    //   294: dup
    //   295: iconst_5
    //   296: lload 12
    //   298: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   301: aastore
    //   302: dup
    //   303: bipush 6
    //   305: aload 4
    //   307: getfield 95	android/graphics/BitmapFactory$Options:outWidth	I
    //   310: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: aastore
    //   314: dup
    //   315: bipush 7
    //   317: aload 4
    //   319: getfield 98	android/graphics/BitmapFactory$Options:outHeight	I
    //   322: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aastore
    //   326: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   329: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: iload 9
    //   334: ireturn
    //   335: iload 6
    //   337: istore 5
    //   339: iload 7
    //   341: iload 8
    //   343: if_icmpge -290 -> 53
    //   346: iload 6
    //   348: istore 5
    //   350: iload 8
    //   352: i2f
    //   353: ldc_w 328
    //   356: fcmpl
    //   357: ifle -304 -> 53
    //   360: aload 4
    //   362: getfield 98	android/graphics/BitmapFactory$Options:outHeight	I
    //   365: i2f
    //   366: ldc_w 328
    //   369: fdiv
    //   370: f2i
    //   371: istore 5
    //   373: goto -320 -> 53
    //   376: astore_2
    //   377: aconst_null
    //   378: astore 14
    //   380: aload 14
    //   382: astore 15
    //   384: ldc 52
    //   386: iconst_1
    //   387: ldc_w 350
    //   390: aload_2
    //   391: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   394: aload 14
    //   396: ifnull +8 -> 404
    //   399: aload 14
    //   401: invokevirtual 346	java/io/OutputStream:close	()V
    //   404: aload 16
    //   406: ifnull +16 -> 422
    //   409: aload 16
    //   411: invokevirtual 304	android/graphics/Bitmap:isRecycled	()Z
    //   414: ifne +8 -> 422
    //   417: aload 16
    //   419: invokevirtual 44	android/graphics/Bitmap:recycle	()V
    //   422: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +492 -> 917
    //   428: new 214	java/io/File
    //   431: dup
    //   432: aload_0
    //   433: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   436: astore_2
    //   437: aload_2
    //   438: ifnull +481 -> 919
    //   441: aload_2
    //   442: invokevirtual 218	java/io/File:length	()J
    //   445: lstore 10
    //   447: lconst_0
    //   448: lstore 12
    //   450: aload 18
    //   452: ifnull +10 -> 462
    //   455: aload 18
    //   457: invokevirtual 218	java/io/File:length	()J
    //   460: lstore 12
    //   462: ldc 52
    //   464: iconst_2
    //   465: ldc_w 348
    //   468: bipush 8
    //   470: anewarray 54	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload_0
    //   476: aastore
    //   477: dup
    //   478: iconst_1
    //   479: lload 10
    //   481: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   484: aastore
    //   485: dup
    //   486: iconst_2
    //   487: iload 7
    //   489: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: dup
    //   494: iconst_3
    //   495: iload 8
    //   497: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: iconst_4
    //   503: aload_1
    //   504: aastore
    //   505: dup
    //   506: iconst_5
    //   507: lload 12
    //   509: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   512: aastore
    //   513: dup
    //   514: bipush 6
    //   516: aload 4
    //   518: getfield 95	android/graphics/BitmapFactory$Options:outWidth	I
    //   521: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: dup
    //   526: bipush 7
    //   528: aload 4
    //   530: getfield 98	android/graphics/BitmapFactory$Options:outHeight	I
    //   533: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   536: aastore
    //   537: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   540: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: iconst_1
    //   544: ireturn
    //   545: astore 14
    //   547: aload 17
    //   549: astore_2
    //   550: aload_2
    //   551: astore 15
    //   553: ldc 52
    //   555: iconst_1
    //   556: ldc_w 352
    //   559: aload 14
    //   561: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: aload_2
    //   565: ifnull +7 -> 572
    //   568: aload_2
    //   569: invokevirtual 346	java/io/OutputStream:close	()V
    //   572: aload 16
    //   574: ifnull +16 -> 590
    //   577: aload 16
    //   579: invokevirtual 304	android/graphics/Bitmap:isRecycled	()Z
    //   582: ifne +8 -> 590
    //   585: aload 16
    //   587: invokevirtual 44	android/graphics/Bitmap:recycle	()V
    //   590: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   593: ifeq +324 -> 917
    //   596: new 214	java/io/File
    //   599: dup
    //   600: aload_0
    //   601: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   604: astore_2
    //   605: aload_2
    //   606: ifnull +305 -> 911
    //   609: aload_2
    //   610: invokevirtual 218	java/io/File:length	()J
    //   613: lstore 10
    //   615: lconst_0
    //   616: lstore 12
    //   618: aload 18
    //   620: ifnull +10 -> 630
    //   623: aload 18
    //   625: invokevirtual 218	java/io/File:length	()J
    //   628: lstore 12
    //   630: ldc 52
    //   632: iconst_2
    //   633: ldc_w 348
    //   636: bipush 8
    //   638: anewarray 54	java/lang/Object
    //   641: dup
    //   642: iconst_0
    //   643: aload_0
    //   644: aastore
    //   645: dup
    //   646: iconst_1
    //   647: lload 10
    //   649: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   652: aastore
    //   653: dup
    //   654: iconst_2
    //   655: iload 7
    //   657: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   660: aastore
    //   661: dup
    //   662: iconst_3
    //   663: iload 8
    //   665: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   668: aastore
    //   669: dup
    //   670: iconst_4
    //   671: aload_1
    //   672: aastore
    //   673: dup
    //   674: iconst_5
    //   675: lload 12
    //   677: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   680: aastore
    //   681: dup
    //   682: bipush 6
    //   684: aload 4
    //   686: getfield 95	android/graphics/BitmapFactory$Options:outWidth	I
    //   689: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   692: aastore
    //   693: dup
    //   694: bipush 7
    //   696: aload 4
    //   698: getfield 98	android/graphics/BitmapFactory$Options:outHeight	I
    //   701: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   704: aastore
    //   705: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   708: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: iconst_1
    //   712: ireturn
    //   713: astore_2
    //   714: aload 15
    //   716: ifnull +8 -> 724
    //   719: aload 15
    //   721: invokevirtual 346	java/io/OutputStream:close	()V
    //   724: aload 16
    //   726: ifnull +16 -> 742
    //   729: aload 16
    //   731: invokevirtual 304	android/graphics/Bitmap:isRecycled	()Z
    //   734: ifne +8 -> 742
    //   737: aload 16
    //   739: invokevirtual 44	android/graphics/Bitmap:recycle	()V
    //   742: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   745: ifeq +121 -> 866
    //   748: new 214	java/io/File
    //   751: dup
    //   752: aload_0
    //   753: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   756: astore 14
    //   758: aload 14
    //   760: ifnull +145 -> 905
    //   763: aload 14
    //   765: invokevirtual 218	java/io/File:length	()J
    //   768: lstore 10
    //   770: lconst_0
    //   771: lstore 12
    //   773: aload 18
    //   775: ifnull +10 -> 785
    //   778: aload 18
    //   780: invokevirtual 218	java/io/File:length	()J
    //   783: lstore 12
    //   785: ldc 52
    //   787: iconst_2
    //   788: ldc_w 348
    //   791: bipush 8
    //   793: anewarray 54	java/lang/Object
    //   796: dup
    //   797: iconst_0
    //   798: aload_0
    //   799: aastore
    //   800: dup
    //   801: iconst_1
    //   802: lload 10
    //   804: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   807: aastore
    //   808: dup
    //   809: iconst_2
    //   810: iload 7
    //   812: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   815: aastore
    //   816: dup
    //   817: iconst_3
    //   818: iload 8
    //   820: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   823: aastore
    //   824: dup
    //   825: iconst_4
    //   826: aload_1
    //   827: aastore
    //   828: dup
    //   829: iconst_5
    //   830: lload 12
    //   832: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   835: aastore
    //   836: dup
    //   837: bipush 6
    //   839: aload 4
    //   841: getfield 95	android/graphics/BitmapFactory$Options:outWidth	I
    //   844: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   847: aastore
    //   848: dup
    //   849: bipush 7
    //   851: aload 4
    //   853: getfield 98	android/graphics/BitmapFactory$Options:outHeight	I
    //   856: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   859: aastore
    //   860: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   863: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: aload_2
    //   867: athrow
    //   868: astore_2
    //   869: goto -676 -> 193
    //   872: astore_2
    //   873: goto -469 -> 404
    //   876: astore_2
    //   877: goto -305 -> 572
    //   880: astore 14
    //   882: goto -158 -> 724
    //   885: astore_2
    //   886: goto -172 -> 714
    //   889: astore 15
    //   891: aload 14
    //   893: astore_2
    //   894: aload 15
    //   896: astore 14
    //   898: goto -348 -> 550
    //   901: astore_2
    //   902: goto -522 -> 380
    //   905: lconst_0
    //   906: lstore 10
    //   908: goto -138 -> 770
    //   911: lconst_0
    //   912: lstore 10
    //   914: goto -299 -> 615
    //   917: iconst_1
    //   918: ireturn
    //   919: lconst_0
    //   920: lstore 10
    //   922: goto -475 -> 447
    //   925: lconst_0
    //   926: lstore 10
    //   928: goto -692 -> 236
    //   931: iload 9
    //   933: ireturn
    //   934: goto -784 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	937	0	paramString1	String
    //   0	937	1	paramString2	String
    //   0	937	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	937	3	paramInt	int
    //   0	937	4	paramOptions	BitmapFactory.Options
    //   51	321	5	i	int
    //   21	326	6	j	int
    //   11	800	7	k	int
    //   18	801	8	m	int
    //   181	751	9	bool	boolean
    //   234	693	10	l1	long
    //   237	594	12	l2	long
    //   166	234	14	localBufferedOutputStream	java.io.BufferedOutputStream
    //   545	15	14	localOutOfMemoryError1	OutOfMemoryError
    //   756	8	14	localFile1	File
    //   880	12	14	localIOException	IOException
    //   896	1	14	localOutOfMemoryError2	OutOfMemoryError
    //   87	633	15	localObject1	Object
    //   889	6	15	localOutOfMemoryError3	OutOfMemoryError
    //   78	660	16	localBitmap	Bitmap
    //   90	458	17	localObject2	Object
    //   84	695	18	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   150	168	376	java/lang/Exception
    //   150	168	545	java/lang/OutOfMemoryError
    //   150	168	713	finally
    //   553	564	713	finally
    //   188	193	868	java/io/IOException
    //   399	404	872	java/io/IOException
    //   568	572	876	java/io/IOException
    //   719	724	880	java/io/IOException
    //   172	183	885	finally
    //   384	394	885	finally
    //   172	183	889	java/lang/OutOfMemoryError
    //   172	183	901	java/lang/Exception
  }
  
  public void a(aqbd paramaqbd)
  {
    this.jdField_a_of_type_Aqbd = paramaqbd;
  }
  
  public void a(aqbe paramaqbe)
  {
    this.jdField_a_of_type_Aqbe = paramaqbe;
  }
  
  public void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("ChooseImageIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.i("ArkApp.ChooseImageIPCModule", 1, "chooseimage action = " + paramString + ", callbackid=" + paramInt);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject;
    if ("callbackArk".equals(paramString))
    {
      if (paramBundle == null) {
        break label292;
      }
      localObject = paramBundle.getString("bundle_key_info");
      if (this.jdField_a_of_type_Aqbd != null) {
        this.jdField_a_of_type_Aqbd.a((String)localObject);
      }
    }
    if ("callReportUrlCheck".equals(paramString))
    {
      if (paramBundle == null) {
        break label298;
      }
      localObject = paramBundle.getString("reportContent");
      label108:
      if (this.jdField_a_of_type_Aqbe != null) {
        this.jdField_a_of_type_Aqbe.a((String)localObject);
      }
    }
    if (("callDisableReport".equals(paramString)) && (this.jdField_a_of_type_Aqbe != null)) {
      this.jdField_a_of_type_Aqbe.a();
    }
    if ("callSendAppMsg".equals(paramString)) {
      ThreadManager.getNetExcutor().execute(new ChooseImageIPCModule.1(this, localAppRuntime, paramInt, paramBundle));
    }
    if ("callDownload".equals(paramString)) {
      ThreadManager.getNetExcutor().execute(new ChooseImageIPCModule.2(this, paramBundle, paramInt, localAppRuntime));
    }
    if ("callVIPReport".equals(paramString))
    {
      paramString = BaseApplicationImpl.sApplication.getRuntime();
      if (!(paramString instanceof QQAppInterface)) {
        break label309;
      }
    }
    label292:
    label298:
    label304:
    label309:
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramString != null)
      {
        localObject = ((ArkAppCenter)paramString.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
        if (paramBundle == null) {
          break label304;
        }
      }
      for (paramString = paramBundle.getString("reportContent");; paramString = null)
      {
        if ((localObject != null) && (!TextUtils.isEmpty(paramString))) {
          ((apxp)localObject).b(paramString);
        }
        return null;
        localObject = null;
        break;
        localObject = null;
        break label108;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqba
 * JD-Core Version:    0.7.0.1
 */