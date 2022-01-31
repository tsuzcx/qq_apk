package com.tencent.mobileqq.activity.qwallet.utils;

import LBS.Attr;
import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.ShowInfo;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import xek;
import xel;
import xem;

public class QWalletTools
{
  public static final Pattern a = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">", 2);
  
  public static long a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return -1L;
      try
      {
        long l = localSimpleDateFormat.parse(paramString).getTime();
        return l;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QWalletTools", 2, "getFormatTime exception|" + paramString);
    return -1L;
  }
  
  public static LBSInfo a()
  {
    LBSInfo localLBSInfo = new LBSInfo();
    ArrayList localArrayList;
    Object localObject3;
    GPS localGPS2;
    for (;;)
    {
      try
      {
        localObject1 = SosoInterface.a();
        if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
          break label344;
        }
        if ((((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c == 0.0D) && (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d == 0.0D))
        {
          GPS localGPS1 = new GPS((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a * 1000000.0D), (int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b * 1000000.0D), -1, 1);
          localArrayList = new ArrayList();
          if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList == null) {
            break;
          }
          localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
          localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject3).b, ((SosoInterface.SosoCell)localObject3).c, ((SosoInterface.SosoCell)localObject3).d, (short)((SosoInterface.SosoCell)localObject3).e));
          continue;
          return localLBSInfo;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localGPS2 = new GPS((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D), (int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D), -1, 0);
    }
    Object localObject2 = new ArrayList();
    if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
    {
      localObject3 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)((Iterator)localObject3).next();
        ((ArrayList)localObject2).add(new Wifi(localSosoWifi.jdField_a_of_type_Long, (short)localSosoWifi.jdField_a_of_type_Int));
      } while (((ArrayList)localObject2).size() < 10);
    }
    if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {}
    for (Object localObject1 = new Attr(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a, ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.b, ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.c);; localObject1 = null)
    {
      return new LBSInfo(localGPS2, (ArrayList)localObject2, localArrayList, (Attr)localObject1);
      label344:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QWalletTools", 2, "lbs cache is null");
      break;
    }
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static CharSequence a(String paramString, Context paramContext, QWalletTools.TextUrlClickListener paramTextUrlClickListener)
  {
    int i = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null) || (paramTextUrlClickListener == null)) {}
    for (;;)
    {
      return paramString;
      try
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
        Matcher localMatcher = a.matcher(paramString);
        int j = 0;
        int k = 0;
        while (localMatcher.find())
        {
          int m = localMatcher.start(0);
          k = localMatcher.end(0);
          String str1 = paramString.substring(localMatcher.start(1), localMatcher.end(1));
          String str2 = paramString.substring(localMatcher.start(2), localMatcher.end(2));
          j = i;
          if (i != m)
          {
            localSpannableStringBuilder.append(paramString.substring(i, m));
            j = k;
          }
          SpannableString localSpannableString = new SpannableString(str1);
          localSpannableString.setSpan(new xel(paramTextUrlClickListener, str2), 0, str1.length(), 33);
          localSpannableString.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131493044)), 0, str1.length(), 33);
          localSpannableStringBuilder.append(localSpannableString);
          m = 1;
          i = j;
          j = m;
        }
        if (j != 0)
        {
          localSpannableStringBuilder.append(paramString.substring(k));
          return localSpannableStringBuilder;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static Long a(EditText paramEditText)
  {
    Long localLong = null;
    if (paramEditText != null) {
      paramEditText = paramEditText.getEditableText().toString();
    }
    try
    {
      long l = Math.round(Double.valueOf(paramEditText).doubleValue() * 100.0D);
      localLong = Long.valueOf(l);
      return localLong;
    }
    catch (NumberFormatException paramEditText)
    {
      throw paramEditText;
    }
  }
  
  /* Error */
  public static Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 317	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 321	java/io/File:exists	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +63 -> 81
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 323	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 324	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: iconst_0
    //   34: ifeq +11 -> 45
    //   37: new 323	java/lang/NullPointerException
    //   40: dup
    //   41: invokespecial 324	java/lang/NullPointerException:<init>	()V
    //   44: athrow
    //   45: iconst_0
    //   46: ifeq +11 -> 57
    //   49: new 323	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 324	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: aload 8
    //   59: astore_3
    //   60: iconst_0
    //   61: ifeq +11 -> 72
    //   64: new 323	java/lang/NullPointerException
    //   67: dup
    //   68: invokespecial 324	java/lang/NullPointerException:<init>	()V
    //   71: athrow
    //   72: aload_3
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: new 327	java/io/FileInputStream
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 330	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore 4
    //   91: new 332	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: invokespecial 333	java/io/ByteArrayOutputStream:<init>	()V
    //   98: astore 5
    //   100: sipush 1024
    //   103: newarray byte
    //   105: astore_0
    //   106: aload 4
    //   108: aload_0
    //   109: invokevirtual 337	java/io/FileInputStream:read	([B)I
    //   112: istore_1
    //   113: iload_1
    //   114: iconst_m1
    //   115: if_icmpeq +102 -> 217
    //   118: aload 5
    //   120: aload_0
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 341	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -20 -> 106
    //   129: astore 6
    //   131: aconst_null
    //   132: astore 8
    //   134: aload 5
    //   136: astore_3
    //   137: aconst_null
    //   138: astore 7
    //   140: aload 4
    //   142: astore_0
    //   143: aload 8
    //   145: astore 5
    //   147: aload 7
    //   149: astore 4
    //   151: aload 6
    //   153: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   156: aload 6
    //   158: athrow
    //   159: astore 8
    //   161: aload 5
    //   163: astore 6
    //   165: aload_3
    //   166: astore 5
    //   168: aload_0
    //   169: astore 7
    //   171: aload 6
    //   173: astore_3
    //   174: aload 8
    //   176: astore_0
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 346	java/io/ObjectInputStream:close	()V
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 349	java/io/ByteArrayInputStream:close	()V
    //   195: aload 5
    //   197: ifnull +8 -> 205
    //   200: aload 5
    //   202: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   205: aload 7
    //   207: ifnull +8 -> 215
    //   210: aload 7
    //   212: invokevirtual 351	java/io/FileInputStream:close	()V
    //   215: aload_0
    //   216: athrow
    //   217: new 348	java/io/ByteArrayInputStream
    //   220: dup
    //   221: aload 5
    //   223: invokevirtual 355	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   226: invokespecial 358	java/io/ByteArrayInputStream:<init>	([B)V
    //   229: astore 6
    //   231: new 343	java/io/ObjectInputStream
    //   234: dup
    //   235: aload 6
    //   237: invokespecial 361	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   240: astore_3
    //   241: aload_3
    //   242: invokevirtual 364	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   245: astore_0
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 346	java/io/ObjectInputStream:close	()V
    //   254: aload 6
    //   256: ifnull +8 -> 264
    //   259: aload 6
    //   261: invokevirtual 349	java/io/ByteArrayInputStream:close	()V
    //   264: aload 5
    //   266: ifnull +8 -> 274
    //   269: aload 5
    //   271: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   274: aload_0
    //   275: astore_3
    //   276: aload 4
    //   278: ifnull -206 -> 72
    //   281: aload 4
    //   283: invokevirtual 351	java/io/FileInputStream:close	()V
    //   286: aload_0
    //   287: areturn
    //   288: astore_3
    //   289: aload_3
    //   290: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   293: aload_0
    //   294: areturn
    //   295: astore_3
    //   296: aconst_null
    //   297: astore 7
    //   299: aconst_null
    //   300: astore 5
    //   302: aconst_null
    //   303: astore 4
    //   305: aconst_null
    //   306: astore_0
    //   307: aload_3
    //   308: invokevirtual 365	java/lang/OutOfMemoryError:printStackTrace	()V
    //   311: aload_0
    //   312: ifnull +7 -> 319
    //   315: aload_0
    //   316: invokevirtual 346	java/io/ObjectInputStream:close	()V
    //   319: aload 4
    //   321: ifnull +8 -> 329
    //   324: aload 4
    //   326: invokevirtual 349	java/io/ByteArrayInputStream:close	()V
    //   329: aload 5
    //   331: ifnull +8 -> 339
    //   334: aload 5
    //   336: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   339: aload 8
    //   341: astore_3
    //   342: aload 7
    //   344: ifnull -272 -> 72
    //   347: aload 7
    //   349: invokevirtual 351	java/io/FileInputStream:close	()V
    //   352: aconst_null
    //   353: areturn
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   359: aconst_null
    //   360: areturn
    //   361: astore_3
    //   362: aload_3
    //   363: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   366: goto -151 -> 215
    //   369: astore_0
    //   370: aconst_null
    //   371: astore 7
    //   373: aconst_null
    //   374: astore 5
    //   376: aconst_null
    //   377: astore 4
    //   379: aconst_null
    //   380: astore_3
    //   381: goto -204 -> 177
    //   384: astore_0
    //   385: aconst_null
    //   386: astore 5
    //   388: aconst_null
    //   389: astore 6
    //   391: aconst_null
    //   392: astore_3
    //   393: aload 4
    //   395: astore 7
    //   397: aload 6
    //   399: astore 4
    //   401: goto -224 -> 177
    //   404: astore_0
    //   405: aconst_null
    //   406: astore 6
    //   408: aconst_null
    //   409: astore_3
    //   410: aload 4
    //   412: astore 7
    //   414: aload 6
    //   416: astore 4
    //   418: goto -241 -> 177
    //   421: astore_0
    //   422: aconst_null
    //   423: astore_3
    //   424: aload 4
    //   426: astore 7
    //   428: aload 6
    //   430: astore 4
    //   432: goto -255 -> 177
    //   435: astore_0
    //   436: aload 4
    //   438: astore 7
    //   440: aload 6
    //   442: astore 4
    //   444: goto -267 -> 177
    //   447: astore 6
    //   449: aload_0
    //   450: astore_3
    //   451: aload 6
    //   453: astore_0
    //   454: goto -277 -> 177
    //   457: astore_3
    //   458: aconst_null
    //   459: astore 5
    //   461: aconst_null
    //   462: astore 6
    //   464: aconst_null
    //   465: astore_0
    //   466: aload 4
    //   468: astore 7
    //   470: aload 6
    //   472: astore 4
    //   474: goto -167 -> 307
    //   477: astore_3
    //   478: aconst_null
    //   479: astore 6
    //   481: aconst_null
    //   482: astore_0
    //   483: aload 4
    //   485: astore 7
    //   487: aload 6
    //   489: astore 4
    //   491: goto -184 -> 307
    //   494: astore_3
    //   495: aconst_null
    //   496: astore_0
    //   497: aload 4
    //   499: astore 7
    //   501: aload 6
    //   503: astore 4
    //   505: goto -198 -> 307
    //   508: astore 7
    //   510: aload_3
    //   511: astore_0
    //   512: aload 7
    //   514: astore_3
    //   515: aload 4
    //   517: astore 7
    //   519: aload 6
    //   521: astore 4
    //   523: goto -216 -> 307
    //   526: astore 6
    //   528: aconst_null
    //   529: astore_3
    //   530: aconst_null
    //   531: astore 4
    //   533: aconst_null
    //   534: astore 5
    //   536: aconst_null
    //   537: astore_0
    //   538: goto -387 -> 151
    //   541: astore 6
    //   543: aconst_null
    //   544: astore 7
    //   546: aconst_null
    //   547: astore 5
    //   549: aload 4
    //   551: astore_0
    //   552: aconst_null
    //   553: astore_3
    //   554: aload 7
    //   556: astore 4
    //   558: goto -407 -> 151
    //   561: astore 7
    //   563: aload 4
    //   565: astore_0
    //   566: aload 5
    //   568: astore_3
    //   569: aload 6
    //   571: astore 4
    //   573: aconst_null
    //   574: astore 5
    //   576: aload 7
    //   578: astore 6
    //   580: goto -429 -> 151
    //   583: astore 9
    //   585: aload 5
    //   587: astore 7
    //   589: aload 6
    //   591: astore 5
    //   593: aload_3
    //   594: astore 8
    //   596: aload 4
    //   598: astore_0
    //   599: aload 9
    //   601: astore 6
    //   603: aload 7
    //   605: astore_3
    //   606: aload 5
    //   608: astore 4
    //   610: aload 8
    //   612: astore 5
    //   614: goto -463 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	paramString	String
    //   112	11	1	i	int
    //   16	2	2	bool	boolean
    //   59	217	3	localObject1	Object
    //   288	2	3	localIOException1	java.io.IOException
    //   295	13	3	localOutOfMemoryError1	OutOfMemoryError
    //   341	1	3	localObject2	Object
    //   361	2	3	localIOException2	java.io.IOException
    //   380	71	3	str	String
    //   457	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   477	1	3	localOutOfMemoryError3	OutOfMemoryError
    //   494	17	3	localOutOfMemoryError4	OutOfMemoryError
    //   514	92	3	localObject3	Object
    //   89	520	4	localObject4	Object
    //   98	515	5	localObject5	Object
    //   129	28	6	localException1	Exception
    //   163	278	6	localObject6	Object
    //   447	5	6	localObject7	Object
    //   462	58	6	localObject8	Object
    //   526	1	6	localException2	Exception
    //   541	29	6	localException3	Exception
    //   578	24	6	localObject9	Object
    //   138	362	7	localObject10	Object
    //   508	5	7	localOutOfMemoryError5	OutOfMemoryError
    //   517	38	7	localObject11	Object
    //   561	16	7	localException4	Exception
    //   587	17	7	localObject12	Object
    //   1	143	8	localObject13	Object
    //   159	181	8	localObject14	Object
    //   594	17	8	localObject15	Object
    //   583	17	9	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   25	33	74	java/io/IOException
    //   37	45	74	java/io/IOException
    //   49	57	74	java/io/IOException
    //   64	72	74	java/io/IOException
    //   100	106	129	java/lang/Exception
    //   106	113	129	java/lang/Exception
    //   118	126	129	java/lang/Exception
    //   217	231	129	java/lang/Exception
    //   151	159	159	finally
    //   250	254	288	java/io/IOException
    //   259	264	288	java/io/IOException
    //   269	274	288	java/io/IOException
    //   281	286	288	java/io/IOException
    //   3	17	295	java/lang/OutOfMemoryError
    //   81	91	295	java/lang/OutOfMemoryError
    //   315	319	354	java/io/IOException
    //   324	329	354	java/io/IOException
    //   334	339	354	java/io/IOException
    //   347	352	354	java/io/IOException
    //   181	185	361	java/io/IOException
    //   190	195	361	java/io/IOException
    //   200	205	361	java/io/IOException
    //   210	215	361	java/io/IOException
    //   3	17	369	finally
    //   81	91	369	finally
    //   91	100	384	finally
    //   100	106	404	finally
    //   106	113	404	finally
    //   118	126	404	finally
    //   217	231	404	finally
    //   231	241	421	finally
    //   241	246	435	finally
    //   307	311	447	finally
    //   91	100	457	java/lang/OutOfMemoryError
    //   100	106	477	java/lang/OutOfMemoryError
    //   106	113	477	java/lang/OutOfMemoryError
    //   118	126	477	java/lang/OutOfMemoryError
    //   217	231	477	java/lang/OutOfMemoryError
    //   231	241	494	java/lang/OutOfMemoryError
    //   241	246	508	java/lang/OutOfMemoryError
    //   3	17	526	java/lang/Exception
    //   81	91	526	java/lang/Exception
    //   91	100	541	java/lang/Exception
    //   231	241	561	java/lang/Exception
    //   241	246	583	java/lang/Exception
  }
  
  public static String a(Context paramContext)
  {
    Object localObject;
    if (paramContext == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      i = bool;
    }
    catch (Exception localException)
    {
      label22:
      break label22;
    }
    if (i != 0) {}
    for (paramContext = QWalletValues.c;; paramContext = paramContext.getApplicationContext().getFilesDir() + "/QWallet/.tmp/")
    {
      File localFile = new File(paramContext);
      localObject = paramContext;
      if (localFile.exists()) {
        break;
      }
      localFile.mkdirs();
      return paramContext;
    }
  }
  
  public static String a(Context paramContext, String paramString, float paramFloat, TextPaint paramTextPaint)
  {
    if (paramFloat == 0.0F) {}
    for (;;)
    {
      return paramString;
      int j = AIOUtils.a(paramFloat, paramContext.getResources());
      if (paramTextPaint.measureText(paramString) > j)
      {
        int i = paramString.length();
        while (i > 0)
        {
          paramContext = paramString.substring(0, i - 1);
          if (paramTextPaint.measureText(paramContext + "...") <= j) {
            return paramContext + "...";
          }
          i -= 1;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Utils.a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a(int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tenpay_mqq");
    localStringBuilder.append("|");
    localStringBuilder.append(localQQAppInterface.getLongAccountUin());
    localStringBuilder.append("||");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|0|1|0|android.");
    try
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(BaseApplicationImpl.getContext().getPackageName(), 0).versionName);
      localStringBuilder.append("|");
      localStringBuilder.append(CommonUtil.a());
      localStringBuilder.append("|");
      localStringBuilder.append("|");
      localStringBuilder.append("|");
      StatisticCollector.a(BaseApplicationImpl.getContext()).b(localQQAppInterface, localStringBuilder.toString());
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramDrawable.setCallback(null);
          if ((paramDrawable instanceof BitmapDrawable))
          {
            paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
            if ((paramDrawable != null) && (!paramDrawable.isRecycled()))
            {
              paramDrawable.recycle();
              return;
            }
          }
        }
        catch (Exception paramDrawable) {}
      }
    } while (!QLog.isDevelopLevel());
    paramDrawable.printStackTrace();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, int paramInt)
  {
    paramQQAppInterface = (QWalletRedManager)paramQQAppInterface.getManager(272);
    QWalletRedManager.ShowInfo localShowInfo = paramQQAppInterface.a("2001");
    if ((localShowInfo.a) && (a(localShowInfo.b, paramInt)))
    {
      if ((paramView instanceof RedDotImageView)) {
        ((RedDotImageView)paramView).a(false);
      }
      paramQQAppInterface.a("2001");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RedDotImageView paramRedDotImageView, int paramInt)
  {
    paramRedDotImageView.a(false);
    ThreadManager.executeOnSubThread(new xem(new WeakReference(paramQQAppInterface), new WeakReference(paramRedDotImageView), paramInt));
  }
  
  private static void a(File paramFile)
  {
    if (paramFile.exists()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QWallet.unzip", 2, "Creating dir " + paramFile.getName());
      }
    } while (paramFile.mkdirs());
    throw new RuntimeException("Can not create dir " + paramFile);
  }
  
  /* Error */
  public static void a(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 317	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 321	java/io/File:exists	()Z
    //   18: ifne +26 -> 44
    //   21: aload_1
    //   22: invokevirtual 594	java/io/File:getParentFile	()Ljava/io/File;
    //   25: invokevirtual 321	java/io/File:exists	()Z
    //   28: ifne +11 -> 39
    //   31: aload_1
    //   32: invokevirtual 594	java/io/File:getParentFile	()Ljava/io/File;
    //   35: invokevirtual 382	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: aload_1
    //   40: invokevirtual 597	java/io/File:createNewFile	()Z
    //   43: pop
    //   44: new 599	java/io/FileOutputStream
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 600	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: astore_1
    //   53: new 332	java/io/ByteArrayOutputStream
    //   56: dup
    //   57: invokespecial 333	java/io/ByteArrayOutputStream:<init>	()V
    //   60: astore_3
    //   61: new 602	java/io/ObjectOutputStream
    //   64: dup
    //   65: aload_3
    //   66: invokespecial 605	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_2
    //   70: aload_2
    //   71: aload_0
    //   72: invokevirtual 608	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   75: aload_2
    //   76: invokevirtual 611	java/io/ObjectOutputStream:flush	()V
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 614	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 615	java/io/ObjectOutputStream:close	()V
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 616	java/io/FileOutputStream:close	()V
    //   108: return
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   114: return
    //   115: astore 4
    //   117: aconst_null
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload 4
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 615	java/io/ObjectOutputStream:close	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   146: aload_1
    //   147: ifnull -39 -> 108
    //   150: aload_1
    //   151: invokevirtual 616	java/io/FileOutputStream:close	()V
    //   154: return
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   160: return
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aload 4
    //   168: astore_1
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 615	java/io/ObjectOutputStream:close	()V
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 616	java/io/FileOutputStream:close	()V
    //   193: aload_0
    //   194: athrow
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   200: goto -7 -> 193
    //   203: astore_0
    //   204: aconst_null
    //   205: astore_3
    //   206: aconst_null
    //   207: astore_2
    //   208: goto -39 -> 169
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_2
    //   214: goto -45 -> 169
    //   217: astore_0
    //   218: goto -49 -> 169
    //   221: astore 4
    //   223: aload_0
    //   224: astore_3
    //   225: aload 4
    //   227: astore_0
    //   228: goto -59 -> 169
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_0
    //   236: goto -110 -> 126
    //   239: astore 4
    //   241: aload_3
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_2
    //   245: aload 4
    //   247: astore_3
    //   248: goto -122 -> 126
    //   251: astore 4
    //   253: aload_3
    //   254: astore_0
    //   255: aload 4
    //   257: astore_3
    //   258: goto -132 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramObject	Object
    //   0	261	1	paramString	String
    //   69	176	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   4	221	3	localObject1	Object
    //   231	11	3	localException1	Exception
    //   247	11	3	localException2	Exception
    //   1	1	4	localObject2	Object
    //   115	52	4	localException3	Exception
    //   221	5	4	localObject3	Object
    //   239	7	4	localException4	Exception
    //   251	5	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   88	92	109	java/io/IOException
    //   96	100	109	java/io/IOException
    //   104	108	109	java/io/IOException
    //   5	39	115	java/lang/Exception
    //   39	44	115	java/lang/Exception
    //   44	53	115	java/lang/Exception
    //   134	138	155	java/io/IOException
    //   142	146	155	java/io/IOException
    //   150	154	155	java/io/IOException
    //   5	39	161	finally
    //   39	44	161	finally
    //   44	53	161	finally
    //   173	177	195	java/io/IOException
    //   181	185	195	java/io/IOException
    //   189	193	195	java/io/IOException
    //   53	61	203	finally
    //   61	70	211	finally
    //   70	84	217	finally
    //   126	130	221	finally
    //   53	61	231	java/lang/Exception
    //   61	70	239	java/lang/Exception
    //   70	84	251	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        FileUtils.a(paramString, false);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static void a(ZipFile paramZipFile, ZipEntry paramZipEntry, String paramString, boolean paramBoolean)
  {
    if (paramZipEntry.isDirectory()) {
      a(new File(paramString, paramZipEntry.getName()));
    }
    Object localObject1;
    do
    {
      return;
      if (paramBoolean) {
        localObject1 = paramZipEntry.getName() + "tmp";
      }
      BufferedOutputStream localBufferedOutputStream;
      for (;;)
      {
        localObject1 = new File(paramString, (String)localObject1);
        if (!((File)localObject1).getParentFile().exists()) {
          a(((File)localObject1).getParentFile());
        }
        if (QLog.isColorLevel()) {
          QLog.i("QWallet.unzip", 2, "Extracting: " + paramZipEntry);
        }
        paramZipFile = new BufferedInputStream(paramZipFile.getInputStream(paramZipEntry));
        localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject1));
        try
        {
          byte[] arrayOfByte = new byte[8192];
          for (;;)
          {
            int i = paramZipFile.read(arrayOfByte, 0, 8192);
            if (i == -1) {
              break;
            }
            localBufferedOutputStream.write(arrayOfByte, 0, i);
          }
          localObject1 = paramZipEntry.getName();
        }
        finally
        {
          localBufferedOutputStream.close();
          paramZipFile.close();
          if (paramBoolean) {
            FileUtils.b((File)localObject1, new File(paramString, paramZipEntry.getName()));
          }
        }
      }
      localBufferedOutputStream.close();
      paramZipFile.close();
    } while (!paramBoolean);
    FileUtils.b((File)localObject1, new File(paramString, paramZipEntry.getName()));
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    if (paramAppRuntime == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tenpay_mqq");
    localStringBuilder.append("|");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("||");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|0|1|0|android.");
    try
    {
      localStringBuilder.append(paramAppRuntime.getApplication().getPackageManager().getPackageInfo(paramAppRuntime.getApplication().getPackageName(), 0).versionName);
      localStringBuilder.append("|");
      localStringBuilder.append(CommonUtil.a());
      localStringBuilder.append("|");
      if ((!TextUtils.isEmpty(paramString4)) || (!TextUtils.isEmpty(paramString5)))
      {
        localStringBuilder.append(paramString4);
        localStringBuilder.append(".");
        localStringBuilder.append(paramString5);
      }
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".");
      if (!TextUtils.isEmpty(paramString2)) {
        localStringBuilder.append(paramString2.replace("|", ","));
      }
      localStringBuilder.append("|");
      if (0L != paramLong) {
        VACDReportUtil.a(paramLong, null, paramString3, "op_type=" + paramInt2, 0, "");
      }
      StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).b(paramAppRuntime, localStringBuilder.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void a(File[] paramArrayOfFile)
  {
    Arrays.sort(paramArrayOfFile, new xek());
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    boolean bool = false;
    try
    {
      j = new JSONObject(paramString).optInt("aioType", 7);
      if (((j & 0x1) == 1) && (paramInt == 0))
      {
        i = 1;
        if (((j & 0x2) != 2) || (paramInt != 1)) {
          break label99;
        }
        k = 1;
        if (((j & 0x4) != 4) || (paramInt != 3000)) {
          break label105;
        }
        paramInt = 1;
        if ((i != 0) || (k != 0) || (paramInt != 0)) {
          bool = true;
        }
        return bool;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int j = 7;
        continue;
        int i = 0;
        continue;
        label99:
        int k = 0;
        continue;
        label105:
        paramInt = 0;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    Object localObject1 = new File(paramString1);
    if (!((File)localObject1).exists()) {
      return false;
    }
    String str = paramString1 + "Tmp";
    FileUtils.a(str, false);
    StringBuilder localStringBuilder;
    Object localObject2;
    if ((QLog.isColorLevel()) && (!((File)localObject1).exists()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0." + localObject1 + "\n");
      localObject1 = new File(str);
      localStringBuilder.append("1." + localObject1 + ((File)localObject1).exists() + "\n");
      localObject2 = new File(paramString1 + "Interim");
      localStringBuilder.append("2." + localObject2 + ((File)localObject2).exists() + "\n");
      localObject2 = new File(paramString1.substring(0, paramString1.length() - 1));
      localStringBuilder.append("3." + localObject2 + ((File)localObject2).exists() + "\n");
      localObject2 = new StringBuilder().append("4.").append(((File)localObject1).isDirectory()).append(((File)localObject1).isFile());
      if ((!((File)localObject1).exists()) || (((File)localObject1).isFile())) {
        break label386;
      }
    }
    label386:
    for (localObject1 = ((File)localObject1).listFiles();; localObject1 = "**")
    {
      localStringBuilder.append(localObject1 + "\n");
      QLog.d("QWalletTools", 2, "unzip exception:" + localStringBuilder.toString());
      if (b(paramString1, str)) {
        break;
      }
      return false;
    }
    paramString1 = new File(str);
    if (!paramString1.exists()) {
      return false;
    }
    localObject1 = new File(paramString2);
    FileUtils.a(paramString2, false);
    if (!FileUtils.b(paramString1, (File)localObject1)) {
      return false;
    }
    return ((File)localObject1).exists();
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 317	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 743	com/tencent/commonsdk/zip/QZipFile
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 744	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_0
    //   22: aload_3
    //   23: invokevirtual 748	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   26: astore 5
    //   28: aload_3
    //   29: astore_0
    //   30: aload 5
    //   32: invokeinterface 753 1 0
    //   37: ifeq +81 -> 118
    //   40: aload_3
    //   41: astore_0
    //   42: aload_3
    //   43: aload 5
    //   45: invokeinterface 756 1 0
    //   50: checkcast 624	java/util/zip/ZipEntry
    //   53: aload_1
    //   54: iload_2
    //   55: invokestatic 758	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/lang/String;Z)V
    //   58: goto -30 -> 28
    //   61: astore_0
    //   62: aload_3
    //   63: astore_1
    //   64: aload_0
    //   65: astore_3
    //   66: aload_1
    //   67: astore_0
    //   68: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +37 -> 108
    //   74: aload_1
    //   75: astore_0
    //   76: ldc_w 577
    //   79: iconst_2
    //   80: new 60	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 760
    //   90: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 4
    //   95: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: aload_3
    //   99: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 762	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 763	java/util/zip/ZipFile:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 763	java/util/zip/ZipFile:close	()V
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual 277	java/lang/Throwable:printStackTrace	()V
    //   133: goto -7 -> 126
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 277	java/lang/Throwable:printStackTrace	()V
    //   141: iconst_0
    //   142: ireturn
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 763	java/util/zip/ZipFile:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 277	java/lang/Throwable:printStackTrace	()V
    //   161: goto -7 -> 154
    //   164: astore_1
    //   165: goto -19 -> 146
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_1
    //   171: goto -105 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramString1	String
    //   0	174	1	paramString2	String
    //   0	174	2	paramBoolean	boolean
    //   19	104	3	localObject	Object
    //   168	1	3	localException	Exception
    //   8	86	4	localFile	File
    //   26	18	5	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   22	28	61	java/lang/Exception
    //   30	40	61	java/lang/Exception
    //   42	58	61	java/lang/Exception
    //   122	126	128	java/lang/Throwable
    //   112	116	136	java/lang/Throwable
    //   10	20	143	finally
    //   150	154	156	java/lang/Throwable
    //   22	28	164	finally
    //   30	40	164	finally
    //   42	58	164	finally
    //   68	74	164	finally
    //   76	108	164	finally
    //   10	20	168	java/lang/Exception
  }
  
  public static Drawable[] a(String paramString)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("DecodeDrawables", 2, "folderPath:" + paramString);
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("DecodeDrawables", 2, "folderPath not exist");
      }
      return null;
    }
    paramString = paramString.listFiles();
    if ((paramString == null) || (paramString.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("DecodeDrawables", 2, "nothing in unzip folder");
      }
      return null;
    }
    a(paramString);
    Drawable[] arrayOfDrawable = new Drawable[paramString.length];
    int j = 0;
    int i = 0;
    while (j < paramString.length)
    {
      if ((paramString[j] != null) && (paramString[j].isFile()) && (FileUtils.e(paramString[j].getAbsolutePath())))
      {
        try
        {
          arrayOfDrawable[j] = new BitmapDrawable(paramString[j].getAbsolutePath());
          if ((i == 0) && (((BitmapDrawable)arrayOfDrawable[j]).getBitmap() != null)) {
            break label286;
          }
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("DecodeDrawables", 2, "decode fail till" + paramString[j].getAbsolutePath());
            i = j;
          }
          while (i >= 0)
          {
            a(arrayOfDrawable[i]);
            i -= 1;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("DecodeDrawables", 2, "decode fail - OutOfMemoryError" + localOutOfMemoryError);
            }
            i = 1;
          }
        }
        return null;
      }
      label286:
      j += 1;
    }
    int m = arrayOfDrawable.length;
    j = 0;
    i = k;
    while (i < m)
    {
      k = j;
      if (arrayOfDrawable[i] != null) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DecodeDrawables", 2, "no valid frame");
      }
      return null;
    }
    return arrayOfDrawable;
  }
  
  public static long b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -1L;
      try
      {
        paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString);
        if (paramString != null)
        {
          long l = paramString.getTime();
          return l;
        }
      }
      catch (Exception paramString) {}
    }
    return -1L;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, false);
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramString1 == null) && (paramString2 == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        if (paramString1 == null) {
          break;
        }
        bool1 = bool2;
      } while (paramString2 == null);
      if (paramString1 != null) {
        break;
      }
      bool1 = bool2;
    } while (paramString2 != null);
    return paramString1.equals(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools
 * JD-Core Version:    0.7.0.1
 */