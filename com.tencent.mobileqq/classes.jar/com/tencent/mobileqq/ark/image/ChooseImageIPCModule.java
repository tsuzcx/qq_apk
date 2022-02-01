package com.tencent.mobileqq.ark.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

public class ChooseImageIPCModule
  extends QIPCModule
{
  public static int a;
  private static volatile ChooseImageIPCModule b;
  private ChooseImageIPCModule.ChooseImageCallBack c = null;
  private ChooseImageIPCModule.IReportCallBack d = null;
  
  public ChooseImageIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramBitmap == null) {
        return paramBitmap;
      }
      Object localObject2 = null;
      Bitmap localBitmap1 = null;
      Bitmap localBitmap2 = localBitmap1;
      Object localObject1 = localObject2;
      try
      {
        Matrix localMatrix = new Matrix();
        localBitmap2 = localBitmap1;
        localObject1 = localObject2;
        localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
        localBitmap2 = localBitmap1;
        localObject1 = localObject2;
        localBitmap1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
        localBitmap2 = localBitmap1;
        localObject1 = localBitmap1;
        paramBitmap.recycle();
        localBitmap2 = localBitmap1;
        localObject1 = localBitmap1;
        paramBitmap = localBitmap1;
        if (QLog.isColorLevel())
        {
          localBitmap2 = localBitmap1;
          localObject1 = localBitmap1;
          QLog.d("ArkApp.ChooseImageIPCModule", 2, new Object[] { "rotateBitmap rotate = ", Integer.valueOf(paramInt) });
          return localBitmap1;
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        QLog.d("ArkApp.ChooseImageIPCModule", 1, "rotateBitmap OutOfMemoryError:", paramBitmap);
        return localBitmap2;
      }
      catch (Exception paramBitmap)
      {
        QLog.d("ArkApp.ChooseImageIPCModule", 1, "rotateBitmap Exception:", paramBitmap);
        paramBitmap = (Bitmap)localObject1;
      }
      return paramBitmap;
    }
    return paramBitmap;
  }
  
  public static ChooseImageIPCModule a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new ChooseImageIPCModule("ChooseImageIPCModule");
        }
      }
      finally {}
    }
    return b;
  }
  
  public static String a(String paramString, BitmapFactory.Options paramOptions)
  {
    paramOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeFile(paramString, paramOptions);
    }
    catch (Exception paramString) {}catch (OutOfMemoryError paramString)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label62;
        }
        QLog.e("ArkApp.ChooseImageIPCModule", 2, "", paramString);
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("ArkApp.ChooseImageIPCModule", 1, "OutOfMemoryError", paramString);
      }
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ChooseImageIPCModule", 2, "", paramString);
      }
    }
    label62:
    if ((paramOptions.outWidth > 0) && (paramOptions.outHeight > 0) && (paramOptions.outMimeType == null)) {
      return "webp";
    }
    if (paramOptions.outMimeType != null)
    {
      int i = paramOptions.outMimeType.indexOf('/');
      if (i != -1) {
        return paramOptions.outMimeType.substring(i + 1);
      }
    }
    return "png";
  }
  
  public static String a(ArrayList<String> paramArrayList, String paramString1, boolean paramBoolean, String paramString2)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      a += 1;
      int i = a;
      if ((i >= 100) || (i < 0)) {
        a = 0;
      }
      String str2 = String.format("tmp_%d_%02d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(a) });
      paramArrayList = new StringBuilder();
      paramArrayList.append(paramString1);
      paramArrayList.append("/");
      paramArrayList.append(str2);
      String str3 = paramArrayList.toString();
      Object localObject1 = BitmapUtils.getOptions();
      String str4 = a(str1, (BitmapFactory.Options)localObject1);
      paramArrayList = Bitmap.CompressFormat.JPEG;
      if ((!"jpg".equalsIgnoreCase(str4)) && (!"jpeg".equalsIgnoreCase(str4)))
      {
        if ("png".equalsIgnoreCase(str4))
        {
          paramArrayList = Bitmap.CompressFormat.PNG;
        }
        else
        {
          i = 0;
          break label200;
        }
      }
      else {
        paramArrayList = Bitmap.CompressFormat.JPEG;
      }
      i = 1;
      label200:
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ChooseImageIPCModule", 2, String.format("image size origin[%d,%d]", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight) }));
      }
      boolean bool;
      if (paramBoolean)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str3);
        ((StringBuilder)localObject2).append("_compress");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (i != 0)
        {
          if (a(str1, (String)localObject2, paramArrayList, 80, (BitmapFactory.Options)localObject1))
          {
            bool = FileUtils.rename((String)localObject2, str3);
          }
          else
          {
            FileUtils.deleteFile((String)localObject2);
            bool = a(str1, str3, paramArrayList);
          }
        }
        else {
          bool = a(str1, str3, paramArrayList);
        }
      }
      else
      {
        bool = a(str1, str3, paramArrayList);
      }
      if (bool)
      {
        long l = new File(str3).length();
        paramArrayList = new ChooseImageInfo();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(str2);
        paramArrayList.path = ((StringBuilder)localObject1).toString();
        paramArrayList.format = str4;
        paramArrayList.size = l;
        localJSONArray.put(JSONUtils.a(paramArrayList));
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ChooseImageIPCModule", 2, String.format("copy Image success ![%s]->[%s].", new Object[] { str1, str3 }));
        }
      }
      else
      {
        QLog.e("ArkApp.ChooseImageIPCModule", 1, String.format("copy Image fail! [%s]->[%s].", new Object[] { str1, str3 }));
      }
    }
    paramArrayList = localJSONArray.toString();
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ChooseImageIPCModule", 1, new Object[] { "copy Image imageinfo=", paramArrayList });
    }
    return paramArrayList;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: new 230	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 11
    //   10: aload 11
    //   12: invokevirtual 275	java/io/File:exists	()Z
    //   15: istore 7
    //   17: iconst_0
    //   18: istore 9
    //   20: iconst_0
    //   21: istore 10
    //   23: iconst_0
    //   24: istore 6
    //   26: iconst_0
    //   27: istore 5
    //   29: iload 6
    //   31: istore 4
    //   33: iload 7
    //   35: ifeq +584 -> 619
    //   38: aload_0
    //   39: invokestatic 280	com/tencent/mobileqq/utils/BaseImageUtil:d	(Ljava/lang/String;)I
    //   42: istore_3
    //   43: iload_3
    //   44: ifeq +485 -> 529
    //   47: iload_3
    //   48: bipush 90
    //   50: irem
    //   51: ifne +478 -> 529
    //   54: getstatic 195	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   57: aload_2
    //   58: if_acmpeq +10 -> 68
    //   61: getstatic 206	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   64: aload_2
    //   65: if_acmpne +464 -> 529
    //   68: aconst_null
    //   69: astore 16
    //   71: aconst_null
    //   72: astore 17
    //   74: aconst_null
    //   75: astore 18
    //   77: aconst_null
    //   78: astore 15
    //   80: aload 15
    //   82: astore 11
    //   84: aload 16
    //   86: astore 12
    //   88: iload 5
    //   90: istore 6
    //   92: aload 17
    //   94: astore 13
    //   96: iload 9
    //   98: istore 7
    //   100: aload 18
    //   102: astore 14
    //   104: iload 10
    //   106: istore 8
    //   108: new 282	java/io/BufferedInputStream
    //   111: dup
    //   112: new 284	java/io/FileInputStream
    //   115: dup
    //   116: aload_0
    //   117: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   120: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore 19
    //   125: aload 15
    //   127: astore 11
    //   129: aload 16
    //   131: astore 12
    //   133: iload 5
    //   135: istore 6
    //   137: aload 17
    //   139: astore 13
    //   141: iload 9
    //   143: istore 7
    //   145: aload 18
    //   147: astore 14
    //   149: iload 10
    //   151: istore 8
    //   153: aload 19
    //   155: invokestatic 292	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   158: astore_0
    //   159: aload_0
    //   160: astore 11
    //   162: aload_0
    //   163: astore 12
    //   165: iload 5
    //   167: istore 6
    //   169: aload_0
    //   170: astore 13
    //   172: iload 9
    //   174: istore 7
    //   176: aload_0
    //   177: astore 14
    //   179: iload 10
    //   181: istore 8
    //   183: aload_0
    //   184: iload_3
    //   185: invokestatic 294	com/tencent/mobileqq/ark/image/ChooseImageIPCModule:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   188: astore_0
    //   189: aload_0
    //   190: astore 11
    //   192: aload_0
    //   193: astore 12
    //   195: iload 5
    //   197: istore 6
    //   199: aload_0
    //   200: astore 13
    //   202: iload 9
    //   204: istore 7
    //   206: aload_0
    //   207: astore 14
    //   209: iload 10
    //   211: istore 8
    //   213: new 296	java/io/FileOutputStream
    //   216: dup
    //   217: aload_1
    //   218: invokespecial 297	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   221: astore_1
    //   222: aload_0
    //   223: astore 11
    //   225: aload_0
    //   226: astore 12
    //   228: iload 5
    //   230: istore 6
    //   232: aload_0
    //   233: astore 13
    //   235: iload 9
    //   237: istore 7
    //   239: aload_0
    //   240: astore 14
    //   242: iload 10
    //   244: istore 8
    //   246: aload_0
    //   247: aload_2
    //   248: bipush 90
    //   250: aload_1
    //   251: invokevirtual 301	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   254: istore 5
    //   256: aload_0
    //   257: astore 11
    //   259: aload_0
    //   260: astore 12
    //   262: iload 5
    //   264: istore 6
    //   266: aload_0
    //   267: astore 13
    //   269: iload 5
    //   271: istore 7
    //   273: aload_0
    //   274: astore 14
    //   276: iload 5
    //   278: istore 8
    //   280: aload_1
    //   281: invokevirtual 304	java/io/FileOutputStream:flush	()V
    //   284: aload_0
    //   285: astore 11
    //   287: aload_0
    //   288: astore 12
    //   290: iload 5
    //   292: istore 6
    //   294: aload_0
    //   295: astore 13
    //   297: iload 5
    //   299: istore 7
    //   301: aload_0
    //   302: astore 14
    //   304: iload 5
    //   306: istore 8
    //   308: aload_1
    //   309: invokevirtual 307	java/io/FileOutputStream:close	()V
    //   312: aload_0
    //   313: astore 11
    //   315: aload_0
    //   316: astore 12
    //   318: iload 5
    //   320: istore 6
    //   322: aload_0
    //   323: astore 13
    //   325: iload 5
    //   327: istore 7
    //   329: aload_0
    //   330: astore 14
    //   332: iload 5
    //   334: istore 8
    //   336: aload 19
    //   338: invokevirtual 308	java/io/BufferedInputStream:close	()V
    //   341: iload 5
    //   343: istore 4
    //   345: aload_0
    //   346: ifnull +273 -> 619
    //   349: iload 5
    //   351: istore 4
    //   353: aload_0
    //   354: invokevirtual 311	android/graphics/Bitmap:isRecycled	()Z
    //   357: ifne +262 -> 619
    //   360: aload_0
    //   361: invokevirtual 52	android/graphics/Bitmap:recycle	()V
    //   364: iload 5
    //   366: ireturn
    //   367: astore_0
    //   368: goto +141 -> 509
    //   371: astore_0
    //   372: aload 12
    //   374: astore 11
    //   376: ldc 60
    //   378: iconst_1
    //   379: ldc_w 313
    //   382: aload_0
    //   383: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   386: iload 6
    //   388: istore 4
    //   390: aload 12
    //   392: ifnull +227 -> 619
    //   395: iload 6
    //   397: istore 4
    //   399: aload 12
    //   401: invokevirtual 311	android/graphics/Bitmap:isRecycled	()Z
    //   404: ifne +215 -> 619
    //   407: aload 12
    //   409: astore_0
    //   410: iload 6
    //   412: istore 5
    //   414: goto -54 -> 360
    //   417: astore_0
    //   418: aload 13
    //   420: astore 11
    //   422: ldc 60
    //   424: iconst_1
    //   425: ldc_w 315
    //   428: aload_0
    //   429: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   432: iload 7
    //   434: istore 4
    //   436: aload 13
    //   438: ifnull +181 -> 619
    //   441: iload 7
    //   443: istore 4
    //   445: aload 13
    //   447: invokevirtual 311	android/graphics/Bitmap:isRecycled	()Z
    //   450: ifne +169 -> 619
    //   453: aload 13
    //   455: astore_0
    //   456: iload 7
    //   458: istore 5
    //   460: goto -100 -> 360
    //   463: astore_0
    //   464: aload 14
    //   466: astore 11
    //   468: ldc 60
    //   470: iconst_1
    //   471: ldc_w 317
    //   474: aload_0
    //   475: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   478: iload 8
    //   480: istore 4
    //   482: aload 14
    //   484: ifnull +135 -> 619
    //   487: iload 8
    //   489: istore 4
    //   491: aload 14
    //   493: invokevirtual 311	android/graphics/Bitmap:isRecycled	()Z
    //   496: ifne +123 -> 619
    //   499: aload 14
    //   501: astore_0
    //   502: iload 8
    //   504: istore 5
    //   506: goto -146 -> 360
    //   509: aload 11
    //   511: ifnull +16 -> 527
    //   514: aload 11
    //   516: invokevirtual 311	android/graphics/Bitmap:isRecycled	()Z
    //   519: ifne +8 -> 527
    //   522: aload 11
    //   524: invokevirtual 52	android/graphics/Bitmap:recycle	()V
    //   527: aload_0
    //   528: athrow
    //   529: aload 11
    //   531: aload_1
    //   532: invokestatic 321	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   535: invokestatic 325	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   538: istore 4
    //   540: iload 4
    //   542: ireturn
    //   543: astore_2
    //   544: new 170	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   551: astore 11
    //   553: aload 11
    //   555: ldc_w 327
    //   558: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload 11
    //   564: aload_0
    //   565: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 11
    //   571: ldc_w 329
    //   574: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 11
    //   580: aload_1
    //   581: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 11
    //   587: ldc_w 331
    //   590: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 11
    //   596: aload_2
    //   597: invokevirtual 334	java/io/IOException:getMessage	()Ljava/lang/String;
    //   600: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: ldc 60
    //   606: iconst_1
    //   607: aload 11
    //   609: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: iload 6
    //   617: istore 4
    //   619: iload 4
    //   621: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	paramString1	String
    //   0	622	1	paramString2	String
    //   0	622	2	paramCompressFormat	Bitmap.CompressFormat
    //   42	143	3	i	int
    //   31	589	4	bool1	boolean
    //   27	478	5	bool2	boolean
    //   24	592	6	bool3	boolean
    //   15	442	7	bool4	boolean
    //   106	397	8	bool5	boolean
    //   18	218	9	bool6	boolean
    //   21	222	10	bool7	boolean
    //   8	600	11	localObject1	Object
    //   86	322	12	localObject2	Object
    //   94	360	13	localObject3	Object
    //   102	398	14	localObject4	Object
    //   78	48	15	localObject5	Object
    //   69	61	16	localObject6	Object
    //   72	66	17	localObject7	Object
    //   75	71	18	localObject8	Object
    //   123	214	19	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   108	125	367	finally
    //   153	159	367	finally
    //   183	189	367	finally
    //   213	222	367	finally
    //   246	256	367	finally
    //   280	284	367	finally
    //   308	312	367	finally
    //   336	341	367	finally
    //   376	386	367	finally
    //   422	432	367	finally
    //   468	478	367	finally
    //   108	125	371	java/io/IOException
    //   153	159	371	java/io/IOException
    //   183	189	371	java/io/IOException
    //   213	222	371	java/io/IOException
    //   246	256	371	java/io/IOException
    //   280	284	371	java/io/IOException
    //   308	312	371	java/io/IOException
    //   336	341	371	java/io/IOException
    //   108	125	417	java/lang/OutOfMemoryError
    //   153	159	417	java/lang/OutOfMemoryError
    //   183	189	417	java/lang/OutOfMemoryError
    //   213	222	417	java/lang/OutOfMemoryError
    //   246	256	417	java/lang/OutOfMemoryError
    //   280	284	417	java/lang/OutOfMemoryError
    //   308	312	417	java/lang/OutOfMemoryError
    //   336	341	417	java/lang/OutOfMemoryError
    //   108	125	463	java/io/FileNotFoundException
    //   153	159	463	java/io/FileNotFoundException
    //   183	189	463	java/io/FileNotFoundException
    //   213	222	463	java/io/FileNotFoundException
    //   246	256	463	java/io/FileNotFoundException
    //   280	284	463	java/io/FileNotFoundException
    //   308	312	463	java/io/FileNotFoundException
    //   336	341	463	java/io/FileNotFoundException
    //   529	540	543	java/io/IOException
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, Bitmap.CompressFormat paramCompressFormat, int paramInt, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload 4
    //   2: iconst_0
    //   3: putfield 93	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   6: aload 4
    //   8: getfield 109	android/graphics/BitmapFactory$Options:outWidth	I
    //   11: istore 7
    //   13: aload 4
    //   15: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   18: istore 8
    //   20: iload 7
    //   22: iload 8
    //   24: if_icmple +33 -> 57
    //   27: iload 7
    //   29: i2f
    //   30: ldc_w 335
    //   33: fcmpl
    //   34: ifle +23 -> 57
    //   37: aload 4
    //   39: getfield 109	android/graphics/BitmapFactory$Options:outWidth	I
    //   42: istore 5
    //   44: iload 5
    //   46: i2f
    //   47: ldc_w 335
    //   50: fdiv
    //   51: f2i
    //   52: istore 5
    //   54: goto +33 -> 87
    //   57: iload 7
    //   59: iload 8
    //   61: if_icmpge +23 -> 84
    //   64: iload 8
    //   66: i2f
    //   67: ldc_w 335
    //   70: fcmpl
    //   71: ifle +13 -> 84
    //   74: aload 4
    //   76: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   79: istore 5
    //   81: goto -37 -> 44
    //   84: iconst_1
    //   85: istore 5
    //   87: iload 5
    //   89: istore 6
    //   91: iload 5
    //   93: ifgt +6 -> 99
    //   96: iconst_1
    //   97: istore 6
    //   99: aload 4
    //   101: iload 6
    //   103: putfield 338	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   106: aload_0
    //   107: aload 4
    //   109: invokestatic 99	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   112: astore 15
    //   114: aload_1
    //   115: invokestatic 340	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   118: astore 18
    //   120: aload_0
    //   121: invokestatic 280	com/tencent/mobileqq/utils/BaseImageUtil:d	(Ljava/lang/String;)I
    //   124: istore 5
    //   126: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +27 -> 156
    //   132: ldc 60
    //   134: iconst_1
    //   135: iconst_2
    //   136: anewarray 62	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: ldc_w 342
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: iload 5
    //   149: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   156: aload 15
    //   158: astore 16
    //   160: iload 5
    //   162: ifeq +24 -> 186
    //   165: aload 15
    //   167: astore 16
    //   169: iload 5
    //   171: bipush 90
    //   173: irem
    //   174: ifne +12 -> 186
    //   177: aload 15
    //   179: iload 5
    //   181: invokestatic 294	com/tencent/mobileqq/ark/image/ChooseImageIPCModule:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   184: astore 16
    //   186: lconst_0
    //   187: lstore 9
    //   189: new 344	java/io/BufferedOutputStream
    //   192: dup
    //   193: new 296	java/io/FileOutputStream
    //   196: dup
    //   197: aload 18
    //   199: invokespecial 347	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   202: invokespecial 350	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   205: astore 15
    //   207: aload 16
    //   209: aload_2
    //   210: iload_3
    //   211: aload 15
    //   213: invokevirtual 301	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   216: istore 14
    //   218: aload 15
    //   220: invokevirtual 353	java/io/OutputStream:close	()V
    //   223: aload 16
    //   225: ifnull +16 -> 241
    //   228: aload 16
    //   230: invokevirtual 311	android/graphics/Bitmap:isRecycled	()Z
    //   233: ifne +8 -> 241
    //   236: aload 16
    //   238: invokevirtual 52	android/graphics/Bitmap:recycle	()V
    //   241: iload 14
    //   243: istore 13
    //   245: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +460 -> 708
    //   251: new 230	java/io/File
    //   254: dup
    //   255: aload_0
    //   256: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   259: invokevirtual 234	java/io/File:length	()J
    //   262: lstore 11
    //   264: aload 18
    //   266: ifnull +10 -> 276
    //   269: aload 18
    //   271: invokevirtual 234	java/io/File:length	()J
    //   274: lstore 9
    //   276: ldc 60
    //   278: iconst_2
    //   279: ldc_w 355
    //   282: bipush 8
    //   284: anewarray 62	java/lang/Object
    //   287: dup
    //   288: iconst_0
    //   289: aload_0
    //   290: aastore
    //   291: dup
    //   292: iconst_1
    //   293: lload 11
    //   295: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   298: aastore
    //   299: dup
    //   300: iconst_2
    //   301: iload 7
    //   303: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   306: aastore
    //   307: dup
    //   308: iconst_3
    //   309: iload 8
    //   311: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   314: aastore
    //   315: dup
    //   316: iconst_4
    //   317: aload_1
    //   318: aastore
    //   319: dup
    //   320: iconst_5
    //   321: lload 9
    //   323: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   326: aastore
    //   327: dup
    //   328: bipush 6
    //   330: aload 4
    //   332: getfield 109	android/graphics/BitmapFactory$Options:outWidth	I
    //   335: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: aastore
    //   339: dup
    //   340: bipush 7
    //   342: aload 4
    //   344: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   347: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: aastore
    //   351: invokestatic 168	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   354: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: iload 14
    //   359: ireturn
    //   360: astore_2
    //   361: goto +358 -> 719
    //   364: astore 17
    //   366: goto +20 -> 386
    //   369: astore 17
    //   371: goto +175 -> 546
    //   374: astore_2
    //   375: aconst_null
    //   376: astore 15
    //   378: goto +341 -> 719
    //   381: astore 17
    //   383: aconst_null
    //   384: astore 15
    //   386: aload 15
    //   388: astore_2
    //   389: ldc 60
    //   391: iconst_1
    //   392: ldc_w 357
    //   395: aload 17
    //   397: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: aload 15
    //   402: ifnull +11 -> 413
    //   405: aload 15
    //   407: invokevirtual 353	java/io/OutputStream:close	()V
    //   410: goto +3 -> 413
    //   413: aload 16
    //   415: ifnull +16 -> 431
    //   418: aload 16
    //   420: invokevirtual 311	android/graphics/Bitmap:isRecycled	()Z
    //   423: ifne +8 -> 431
    //   426: aload 16
    //   428: invokevirtual 52	android/graphics/Bitmap:recycle	()V
    //   431: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +271 -> 705
    //   437: new 230	java/io/File
    //   440: dup
    //   441: aload_0
    //   442: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   445: invokevirtual 234	java/io/File:length	()J
    //   448: lstore 11
    //   450: aload 18
    //   452: ifnull +10 -> 462
    //   455: aload 18
    //   457: invokevirtual 234	java/io/File:length	()J
    //   460: lstore 9
    //   462: ldc_w 355
    //   465: bipush 8
    //   467: anewarray 62	java/lang/Object
    //   470: dup
    //   471: iconst_0
    //   472: aload_0
    //   473: aastore
    //   474: dup
    //   475: iconst_1
    //   476: lload 11
    //   478: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   481: aastore
    //   482: dup
    //   483: iconst_2
    //   484: iload 7
    //   486: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   489: aastore
    //   490: dup
    //   491: iconst_3
    //   492: iload 8
    //   494: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   497: aastore
    //   498: dup
    //   499: iconst_4
    //   500: aload_1
    //   501: aastore
    //   502: dup
    //   503: iconst_5
    //   504: lload 9
    //   506: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: aastore
    //   510: dup
    //   511: bipush 6
    //   513: aload 4
    //   515: getfield 109	android/graphics/BitmapFactory$Options:outWidth	I
    //   518: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   521: aastore
    //   522: dup
    //   523: bipush 7
    //   525: aload 4
    //   527: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   530: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: aastore
    //   534: invokestatic 168	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   537: astore_0
    //   538: goto +160 -> 698
    //   541: astore 17
    //   543: aconst_null
    //   544: astore 15
    //   546: aload 15
    //   548: astore_2
    //   549: ldc 60
    //   551: iconst_1
    //   552: ldc_w 359
    //   555: aload 17
    //   557: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   560: aload 15
    //   562: ifnull +11 -> 573
    //   565: aload 15
    //   567: invokevirtual 353	java/io/OutputStream:close	()V
    //   570: goto +3 -> 573
    //   573: aload 16
    //   575: ifnull +16 -> 591
    //   578: aload 16
    //   580: invokevirtual 311	android/graphics/Bitmap:isRecycled	()Z
    //   583: ifne +8 -> 591
    //   586: aload 16
    //   588: invokevirtual 52	android/graphics/Bitmap:recycle	()V
    //   591: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   594: ifeq +111 -> 705
    //   597: new 230	java/io/File
    //   600: dup
    //   601: aload_0
    //   602: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   605: invokevirtual 234	java/io/File:length	()J
    //   608: lstore 11
    //   610: aload 18
    //   612: ifnull +10 -> 622
    //   615: aload 18
    //   617: invokevirtual 234	java/io/File:length	()J
    //   620: lstore 9
    //   622: ldc_w 355
    //   625: bipush 8
    //   627: anewarray 62	java/lang/Object
    //   630: dup
    //   631: iconst_0
    //   632: aload_0
    //   633: aastore
    //   634: dup
    //   635: iconst_1
    //   636: lload 11
    //   638: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   641: aastore
    //   642: dup
    //   643: iconst_2
    //   644: iload 7
    //   646: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   649: aastore
    //   650: dup
    //   651: iconst_3
    //   652: iload 8
    //   654: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   657: aastore
    //   658: dup
    //   659: iconst_4
    //   660: aload_1
    //   661: aastore
    //   662: dup
    //   663: iconst_5
    //   664: lload 9
    //   666: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   669: aastore
    //   670: dup
    //   671: bipush 6
    //   673: aload 4
    //   675: getfield 109	android/graphics/BitmapFactory$Options:outWidth	I
    //   678: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   681: aastore
    //   682: dup
    //   683: bipush 7
    //   685: aload 4
    //   687: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   690: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   693: aastore
    //   694: invokestatic 168	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   697: astore_0
    //   698: ldc 60
    //   700: iconst_2
    //   701: aload_0
    //   702: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: iconst_1
    //   706: istore 13
    //   708: iload 13
    //   710: ireturn
    //   711: astore 17
    //   713: aload_2
    //   714: astore 15
    //   716: aload 17
    //   718: astore_2
    //   719: aload 15
    //   721: ifnull +11 -> 732
    //   724: aload 15
    //   726: invokevirtual 353	java/io/OutputStream:close	()V
    //   729: goto +3 -> 732
    //   732: aload 16
    //   734: ifnull +16 -> 750
    //   737: aload 16
    //   739: invokevirtual 311	android/graphics/Bitmap:isRecycled	()Z
    //   742: ifne +8 -> 750
    //   745: aload 16
    //   747: invokevirtual 52	android/graphics/Bitmap:recycle	()V
    //   750: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   753: ifeq +109 -> 862
    //   756: new 230	java/io/File
    //   759: dup
    //   760: aload_0
    //   761: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   764: invokevirtual 234	java/io/File:length	()J
    //   767: lstore 11
    //   769: aload 18
    //   771: ifnull +10 -> 781
    //   774: aload 18
    //   776: invokevirtual 234	java/io/File:length	()J
    //   779: lstore 9
    //   781: ldc 60
    //   783: iconst_2
    //   784: ldc_w 355
    //   787: bipush 8
    //   789: anewarray 62	java/lang/Object
    //   792: dup
    //   793: iconst_0
    //   794: aload_0
    //   795: aastore
    //   796: dup
    //   797: iconst_1
    //   798: lload 11
    //   800: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   803: aastore
    //   804: dup
    //   805: iconst_2
    //   806: iload 7
    //   808: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   811: aastore
    //   812: dup
    //   813: iconst_3
    //   814: iload 8
    //   816: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   819: aastore
    //   820: dup
    //   821: iconst_4
    //   822: aload_1
    //   823: aastore
    //   824: dup
    //   825: iconst_5
    //   826: lload 9
    //   828: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   831: aastore
    //   832: dup
    //   833: bipush 6
    //   835: aload 4
    //   837: getfield 109	android/graphics/BitmapFactory$Options:outWidth	I
    //   840: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   843: aastore
    //   844: dup
    //   845: bipush 7
    //   847: aload 4
    //   849: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   852: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   855: aastore
    //   856: invokestatic 168	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   859: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   862: goto +5 -> 867
    //   865: aload_2
    //   866: athrow
    //   867: goto -2 -> 865
    //   870: astore_2
    //   871: goto -648 -> 223
    //   874: astore_2
    //   875: goto -462 -> 413
    //   878: astore_2
    //   879: goto -306 -> 573
    //   882: astore 15
    //   884: goto -152 -> 732
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	paramString1	String
    //   0	887	1	paramString2	String
    //   0	887	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	887	3	paramInt	int
    //   0	887	4	paramOptions	BitmapFactory.Options
    //   42	138	5	i	int
    //   89	13	6	j	int
    //   11	796	7	k	int
    //   18	797	8	m	int
    //   187	640	9	l1	long
    //   262	537	11	l2	long
    //   243	466	13	bool1	boolean
    //   216	142	14	bool2	boolean
    //   112	613	15	localObject1	Object
    //   882	1	15	localIOException	java.io.IOException
    //   158	588	16	localObject2	Object
    //   364	1	17	localOutOfMemoryError1	OutOfMemoryError
    //   369	1	17	localException1	Exception
    //   381	15	17	localOutOfMemoryError2	OutOfMemoryError
    //   541	15	17	localException2	Exception
    //   711	6	17	localObject3	Object
    //   118	657	18	localFile	File
    // Exception table:
    //   from	to	target	type
    //   207	218	360	finally
    //   207	218	364	java/lang/OutOfMemoryError
    //   207	218	369	java/lang/Exception
    //   189	207	374	finally
    //   189	207	381	java/lang/OutOfMemoryError
    //   189	207	541	java/lang/Exception
    //   389	400	711	finally
    //   549	560	711	finally
    //   218	223	870	java/io/IOException
    //   405	410	874	java/io/IOException
    //   565	570	878	java/io/IOException
    //   724	729	882	java/io/IOException
  }
  
  public void a(ChooseImageIPCModule.ChooseImageCallBack paramChooseImageCallBack)
  {
    this.c = paramChooseImageCallBack;
  }
  
  public void a(ChooseImageIPCModule.IReportCallBack paramIReportCallBack)
  {
    this.d = paramIReportCallBack;
  }
  
  public void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("ChooseImageIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("chooseimage action = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", callbackid=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("ArkApp.ChooseImageIPCModule", 1, ((StringBuilder)localObject).toString());
    BaseApplicationImpl.getApplication().getRuntime();
    if ("callbackArk".equals(paramString))
    {
      if (paramBundle != null) {
        localObject = paramBundle.getString("bundle_key_info");
      } else {
        localObject = null;
      }
      ChooseImageIPCModule.ChooseImageCallBack localChooseImageCallBack = this.c;
      if (localChooseImageCallBack != null) {
        localChooseImageCallBack.a((String)localObject);
      }
    }
    if ("callReportUrlCheck".equals(paramString))
    {
      if (paramBundle != null) {
        paramBundle = paramBundle.getString("reportContent");
      } else {
        paramBundle = null;
      }
      localObject = this.d;
      if (localObject != null) {
        ((ChooseImageIPCModule.IReportCallBack)localObject).a(paramBundle);
      }
    }
    if ("callDisableReport".equals(paramString))
    {
      paramString = this.d;
      if (paramString != null) {
        paramString.a();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.ChooseImageIPCModule
 * JD-Core Version:    0.7.0.1
 */