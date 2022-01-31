package com.tencent.mobileqq.activity.qwallet.utils;

import LBS.Attr;
import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import Wallet.ReportHBGameReq;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.ShowInfo;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
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
import org.json.JSONObject;
import xnk;
import xnl;
import xnm;
import xno;
import xnp;

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
          localSpannableString.setSpan(new xnl(paramTextUrlClickListener, str2), 0, str1.length(), 33);
          localSpannableString.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131493045)), 0, str1.length(), 33);
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
    //   295	13	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   341	1	3	localObject2	Object
    //   361	2	3	localIOException2	java.io.IOException
    //   380	71	3	str	String
    //   457	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   477	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   494	17	3	localOutOfMemoryError4	java.lang.OutOfMemoryError
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
    //   508	5	7	localOutOfMemoryError5	java.lang.OutOfMemoryError
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
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, ResultReceiver paramResultReceiver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletTools", 2, "GrapHbWithParam params:" + paramString1 + ",gameid:" + paramString2 + ",score:" + paramString3);
    }
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      paramString2 = "gameid=" + paramString2 + "&point=" + paramString3;
      paramString3 = new JSONObject(paramString1);
      paramString3.put("feedsid", paramString2);
      paramString1 = new Bundle();
      paramString1.putString("extra_data", paramString3.toString());
      paramString1.putString("callbackSn", "0");
      paramString2 = new Bundle();
      paramString2.putInt("PayInvokerId", 22);
      paramString3 = Parcel.obtain();
      paramResultReceiver.writeToParcel(paramString3, 0);
      paramString3.setDataPosition(0);
      paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString3);
      paramString3.recycle();
      paramString2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
      paramString2.putBundle("_qwallet_payparams_data", paramString1);
      paramString2.putString("_qwallet_payparams_tag", "graphb");
      QWalletPayBridge.getWalletDataByService(BaseApplicationImpl.sApplication, paramAppInterface, paramString2);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
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
    ThreadManager.executeOnSubThread(new xnm(new WeakReference(paramQQAppInterface), new WeakReference(paramRedDotImageView), paramInt));
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
    //   22: invokevirtual 684	java/io/File:getParentFile	()Ljava/io/File;
    //   25: invokevirtual 321	java/io/File:exists	()Z
    //   28: ifne +11 -> 39
    //   31: aload_1
    //   32: invokevirtual 684	java/io/File:getParentFile	()Ljava/io/File;
    //   35: invokevirtual 382	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: aload_1
    //   40: invokevirtual 687	java/io/File:createNewFile	()Z
    //   43: pop
    //   44: new 689	java/io/FileOutputStream
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 690	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: astore_1
    //   53: new 332	java/io/ByteArrayOutputStream
    //   56: dup
    //   57: invokespecial 333	java/io/ByteArrayOutputStream:<init>	()V
    //   60: astore_3
    //   61: new 692	java/io/ObjectOutputStream
    //   64: dup
    //   65: aload_3
    //   66: invokespecial 695	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_2
    //   70: aload_2
    //   71: aload_0
    //   72: invokevirtual 698	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   75: aload_2
    //   76: invokevirtual 701	java/io/ObjectOutputStream:flush	()V
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 704	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 705	java/io/ObjectOutputStream:close	()V
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 706	java/io/FileOutputStream:close	()V
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
    //   135: invokevirtual 705	java/io/ObjectOutputStream:close	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   146: aload_1
    //   147: ifnull -39 -> 108
    //   150: aload_1
    //   151: invokevirtual 706	java/io/FileOutputStream:close	()V
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
    //   174: invokevirtual 705	java/io/ObjectOutputStream:close	()V
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 706	java/io/FileOutputStream:close	()V
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
  
  public static void a(String paramString1, long paramLong, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    ReportHBGameReq localReportHBGameReq = new ReportHBGameReq();
    localReportHBGameReq.sHBId = paramString1;
    localReportHBGameReq.lUin = paramLong;
    localReportHBGameReq.sPoint = paramString2;
    localReportHBGameReq.iAmount = paramInt1;
    localReportHBGameReq.bSucc = paramBoolean1;
    localReportHBGameReq.bStart = paramBoolean2;
    localReportHBGameReq.iGameId = paramInt2;
    QWalletCommonServlet.a(localReportHBGameReq, new xnp());
  }
  
  public static void a(String paramString, boolean paramBoolean, File paramFile)
  {
    QLog.d("QWalletTools", 2, "1.0 delete " + paramString + paramBoolean + paramFile + paramFile.exists());
    if (paramString == null) {}
    do
    {
      return;
      paramString = new File(paramString);
      QLog.d("QWalletTools", 2, "1.0 delete tag0" + paramString + paramString.exists());
      if ((paramString == null) || (!paramString.exists()))
      {
        QLog.d("QWalletTools", 2, "1.0 delete tag1" + paramFile.exists());
        return;
      }
      if (paramString.isFile())
      {
        QLog.d("QWalletTools", 2, "1.0 delete tag2" + paramString + paramString.exists() + paramFile.exists());
        paramString.delete();
        QLog.d("QWalletTools", 2, "1.0 delete tag3" + paramString + paramString.exists() + paramFile.exists());
        return;
      }
      File[] arrayOfFile = paramString.listFiles();
      if (arrayOfFile == null)
      {
        QLog.d("QWalletTools", 2, "1.0 delete tag4" + paramFile.exists());
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        QLog.d("QWalletTools", 2, "1.0 delete tag5" + localFile + paramFile.exists());
        a(localFile.getAbsolutePath(), paramBoolean, paramFile);
        QLog.d("QWalletTools", 2, "1.0 delete tag6" + localFile + paramFile.exists());
        i += 1;
      }
    } while (paramBoolean);
    QLog.d("QWalletTools", 2, "1.0 delete tag7" + paramString + paramFile.exists());
    paramString.delete();
    QLog.d("QWalletTools", 2, "1.0 delete tag8" + paramString + paramFile.exists());
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
    ThreadManager.post(new xno(paramString1, paramInt2, paramString3, paramAppRuntime, paramString4, paramString5, paramInt1, paramString2, paramLong), 2, null, true);
  }
  
  public static void a(File[] paramArrayOfFile)
  {
    Arrays.sort(paramArrayOfFile, new xnk());
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
    File localFile2 = new File(paramString1);
    if (!localFile2.exists()) {}
    for (;;)
    {
      return false;
      String str = paramString1 + "Tmp";
      File localFile1 = new File(str);
      if (QLog.isColorLevel()) {
        QLog.d("QWalletTools", 2, "unzipAtomically1" + localFile2 + localFile2.exists() + localFile1 + localFile1.exists());
      }
      FileUtils.a(str, false);
      if (QLog.isColorLevel()) {
        QLog.d("QWalletTools", 2, "unzipAtomically2" + localFile2 + localFile2.exists() + localFile1 + localFile1.exists());
      }
      if ((QLog.isColorLevel()) && (!localFile2.exists())) {}
      try
      {
        FileUtils.a(new byte[] { 0, 0 }, paramString1);
        QLog.d("QWalletTools", 2, "0." + localFile2 + localFile2.exists());
        a(str, false, localFile2);
        QLog.d("QWalletTools", 2, "2." + localFile2 + localFile2.exists());
        if ((!b(paramString1, str)) || (!localFile1.exists())) {
          continue;
        }
        paramString1 = new File(paramString2);
        FileUtils.a(paramString2, false);
        if ((!FileUtils.b(localFile1, paramString1)) || (!paramString1.exists())) {
          continue;
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
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
    //   10: new 865	com/tencent/commonsdk/zip/QZipFile
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 866	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_0
    //   22: aload_3
    //   23: invokevirtual 870	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   26: astore 5
    //   28: aload_3
    //   29: astore_0
    //   30: aload 5
    //   32: invokeinterface 875 1 0
    //   37: ifeq +81 -> 118
    //   40: aload_3
    //   41: astore_0
    //   42: aload_3
    //   43: aload 5
    //   45: invokeinterface 878 1 0
    //   50: checkcast 786	java/util/zip/ZipEntry
    //   53: aload_1
    //   54: iload_2
    //   55: invokestatic 880	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/lang/String;Z)V
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
    //   76: ldc_w 667
    //   79: iconst_2
    //   80: new 60	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 882
    //   90: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 4
    //   95: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: aload_3
    //   99: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 885	java/util/zip/ZipFile:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 885	java/util/zip/ZipFile:close	()V
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
    //   151: invokevirtual 885	java/util/zip/ZipFile:close	()V
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
  
  /* Error */
  public static Drawable[] a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +30 -> 35
    //   8: ldc_w 888
    //   11: iconst_2
    //   12: new 60	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 890
    //   22: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: new 317	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 321	java/io/File:exists	()Z
    //   48: ifne +21 -> 69
    //   51: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +13 -> 67
    //   57: ldc_w 888
    //   60: iconst_2
    //   61: ldc_w 892
    //   64: invokestatic 884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_0
    //   70: invokevirtual 768	java/io/File:listFiles	()[Ljava/io/File;
    //   73: astore 7
    //   75: aload 7
    //   77: ifnull +9 -> 86
    //   80: aload 7
    //   82: arraylength
    //   83: ifgt +21 -> 104
    //   86: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +13 -> 102
    //   92: ldc_w 888
    //   95: iconst_2
    //   96: ldc_w 894
    //   99: invokestatic 884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aconst_null
    //   103: areturn
    //   104: aload 7
    //   106: invokestatic 896	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	([Ljava/io/File;)V
    //   109: aload 7
    //   111: arraylength
    //   112: anewarray 509	android/graphics/drawable/Drawable
    //   115: astore 8
    //   117: iconst_0
    //   118: istore_2
    //   119: iconst_0
    //   120: istore_1
    //   121: iload_2
    //   122: aload 7
    //   124: arraylength
    //   125: if_icmpge +359 -> 484
    //   128: aload 7
    //   130: iload_2
    //   131: aaload
    //   132: ifnull +345 -> 477
    //   135: aload 7
    //   137: iload_2
    //   138: aaload
    //   139: invokevirtual 757	java/io/File:isFile	()Z
    //   142: ifeq +335 -> 477
    //   145: aload 7
    //   147: iload_2
    //   148: aaload
    //   149: invokevirtual 775	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   152: invokestatic 899	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   155: ifeq +322 -> 477
    //   158: new 800	java/io/BufferedInputStream
    //   161: dup
    //   162: new 327	java/io/FileInputStream
    //   165: dup
    //   166: aload 7
    //   168: iload_2
    //   169: aaload
    //   170: invokevirtual 775	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   173: invokespecial 900	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   176: invokespecial 807	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   179: astore 5
    //   181: aload 5
    //   183: astore_0
    //   184: aload 8
    //   186: iload_2
    //   187: new 515	android/graphics/drawable/BitmapDrawable
    //   190: dup
    //   191: aload 5
    //   193: invokespecial 901	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   196: aastore
    //   197: aload 5
    //   199: ifnull +363 -> 562
    //   202: aload 5
    //   204: invokevirtual 816	java/io/BufferedInputStream:close	()V
    //   207: iload_1
    //   208: ifne +16 -> 224
    //   211: aload 8
    //   213: iload_2
    //   214: aaload
    //   215: checkcast 515	android/graphics/drawable/BitmapDrawable
    //   218: invokevirtual 519	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   221: ifnonnull +256 -> 477
    //   224: iload_2
    //   225: istore_1
    //   226: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +38 -> 267
    //   232: ldc_w 888
    //   235: iconst_2
    //   236: new 60	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 903
    //   246: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 7
    //   251: iload_2
    //   252: aaload
    //   253: invokevirtual 775	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   256: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: iload_2
    //   266: istore_1
    //   267: iload_1
    //   268: iflt +207 -> 475
    //   271: aload 8
    //   273: iload_1
    //   274: aaload
    //   275: invokestatic 905	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	(Landroid/graphics/drawable/Drawable;)V
    //   278: iload_1
    //   279: iconst_1
    //   280: isub
    //   281: istore_1
    //   282: goto -15 -> 267
    //   285: astore_0
    //   286: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +30 -> 319
    //   292: ldc_w 888
    //   295: iconst_2
    //   296: new 60	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   303: ldc_w 907
    //   306: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_0
    //   310: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: iconst_1
    //   320: istore_1
    //   321: goto -114 -> 207
    //   324: astore 6
    //   326: aconst_null
    //   327: astore 5
    //   329: aload 5
    //   331: astore_0
    //   332: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq +34 -> 369
    //   338: aload 5
    //   340: astore_0
    //   341: ldc_w 888
    //   344: iconst_2
    //   345: new 60	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 909
    //   355: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 6
    //   360: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload 5
    //   371: ifnull +186 -> 557
    //   374: aload 5
    //   376: invokevirtual 816	java/io/BufferedInputStream:close	()V
    //   379: iconst_1
    //   380: istore_1
    //   381: goto -174 -> 207
    //   384: astore_0
    //   385: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +30 -> 418
    //   391: ldc_w 888
    //   394: iconst_2
    //   395: new 60	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 907
    //   405: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_0
    //   409: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: iconst_1
    //   419: istore_1
    //   420: goto -213 -> 207
    //   423: astore 5
    //   425: aconst_null
    //   426: astore_0
    //   427: aload_0
    //   428: ifnull +7 -> 435
    //   431: aload_0
    //   432: invokevirtual 816	java/io/BufferedInputStream:close	()V
    //   435: aload 5
    //   437: athrow
    //   438: astore_0
    //   439: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq -7 -> 435
    //   445: ldc_w 888
    //   448: iconst_2
    //   449: new 60	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 907
    //   459: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_0
    //   463: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: goto -37 -> 435
    //   475: aconst_null
    //   476: areturn
    //   477: iload_2
    //   478: iconst_1
    //   479: iadd
    //   480: istore_2
    //   481: goto -360 -> 121
    //   484: aload 8
    //   486: arraylength
    //   487: istore 4
    //   489: iconst_0
    //   490: istore_2
    //   491: iload_3
    //   492: istore_1
    //   493: iload_1
    //   494: iload 4
    //   496: if_icmpge +25 -> 521
    //   499: iload_2
    //   500: istore_3
    //   501: aload 8
    //   503: iload_1
    //   504: aaload
    //   505: ifnull +7 -> 512
    //   508: iload_2
    //   509: iconst_1
    //   510: iadd
    //   511: istore_3
    //   512: iload_1
    //   513: iconst_1
    //   514: iadd
    //   515: istore_1
    //   516: iload_3
    //   517: istore_2
    //   518: goto -25 -> 493
    //   521: iload_2
    //   522: iconst_1
    //   523: if_icmpge +21 -> 544
    //   526: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq +13 -> 542
    //   532: ldc_w 888
    //   535: iconst_2
    //   536: ldc_w 911
    //   539: invokestatic 884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: aconst_null
    //   543: areturn
    //   544: aload 8
    //   546: areturn
    //   547: astore 5
    //   549: goto -122 -> 427
    //   552: astore 6
    //   554: goto -225 -> 329
    //   557: iconst_1
    //   558: istore_1
    //   559: goto -352 -> 207
    //   562: goto -355 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	paramString	String
    //   120	439	1	i	int
    //   118	406	2	j	int
    //   1	516	3	k	int
    //   487	10	4	m	int
    //   179	196	5	localBufferedInputStream	BufferedInputStream
    //   423	13	5	localObject1	Object
    //   547	1	5	localObject2	Object
    //   324	35	6	localThrowable1	Throwable
    //   552	1	6	localThrowable2	Throwable
    //   73	177	7	arrayOfFile	File[]
    //   115	430	8	arrayOfDrawable	Drawable[]
    // Exception table:
    //   from	to	target	type
    //   202	207	285	java/io/IOException
    //   158	181	324	java/lang/Throwable
    //   374	379	384	java/io/IOException
    //   158	181	423	finally
    //   431	435	438	java/io/IOException
    //   184	197	547	finally
    //   332	338	547	finally
    //   341	369	547	finally
    //   184	197	552	java/lang/Throwable
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