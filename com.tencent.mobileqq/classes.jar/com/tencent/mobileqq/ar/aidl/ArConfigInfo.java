package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import zzu;

public class ArConfigInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new zzu();
  public static final String TAG = "ArConfigInfo";
  public static final int VERSION_700 = 10;
  public static final int VERSION_710 = 11;
  public static final int VERSION_715 = 12;
  public static final int VERSION_718 = 13;
  public static final int VERSION_720 = 14;
  public static final int VERSION_739 = 19;
  public static final int VERSION_760 = 20;
  public long aRBegin;
  public long aRCloudBegin;
  public long aRCloudCacheExpireTime;
  public long aRCloudEnd;
  public long aREnd;
  public ArrayList mArCloudConfigInfos = new ArrayList();
  public boolean saveConfig = true;
  public String scanLine1;
  public String scanLine2;
  public String scanLineLink;
  public String scanLinkUrl;
  public int version;
  
  public ArConfigInfo() {}
  
  public ArConfigInfo(Parcel paramParcel)
  {
    try
    {
      int i = paramParcel.readInt();
      ArCloudConfigInfo.f = i;
      if (i >= 10) {
        this.version = paramParcel.readInt();
      }
      if (i < 14) {}
      for (this.version = 0;; this.version = i)
      {
        this.aRBegin = paramParcel.readLong();
        this.aREnd = paramParcel.readLong();
        this.scanLine1 = paramParcel.readString();
        this.scanLine2 = paramParcel.readString();
        this.scanLineLink = paramParcel.readString();
        this.scanLinkUrl = paramParcel.readString();
        this.mArCloudConfigInfos = paramParcel.createTypedArrayList(ArCloudConfigInfo.CREATOR);
        this.aRCloudBegin = paramParcel.readLong();
        this.aRCloudEnd = paramParcel.readLong();
        this.aRCloudCacheExpireTime = paramParcel.readLong();
        if (paramParcel.readByte() != 0) {
          bool = true;
        }
        this.saveConfig = bool;
        return;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      QLog.i("ArConfigInfo", 1, "ArConfigInfo read fail" + paramParcel.getMessage());
    }
  }
  
  public static void deleteConfigFile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfigInfo", 2, "deleteConfigFile. uin = " + paramString);
    }
    if (paramString == null) {
      return;
    }
    deleteConfigFile(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_file_config_v739_" + paramString);
  }
  
  public static void deleteConfigFile(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfigInfo", 2, "deleteConfigFile. dir = " + paramString1 + ", filename = " + paramString2);
    }
    if ((paramString1 == null) || (paramString1.equals("")) || (paramString2 == null) || (paramString2.equals(""))) {}
    do
    {
      return;
      paramString1 = new File(paramString1, paramString2);
    } while (!paramString1.exists());
    paramString1.delete();
  }
  
  public static ArConfigInfo loadConfigFromFile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfigInfo", 2, "loadConfigFromFile. uin = " + paramString);
    }
    if (paramString == null) {
      return null;
    }
    return loadConfigFromFile(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_file_config_v739_" + paramString);
  }
  
  /* Error */
  public static ArConfigInfo loadConfigFromFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: ldc 14
    //   8: iconst_2
    //   9: new 115	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   16: ldc 198
    //   18: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 169
    //   27: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: ifnull +25 -> 66
    //   44: aload_0
    //   45: ldc 171
    //   47: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifne +16 -> 66
    //   53: aload_1
    //   54: ifnull +12 -> 66
    //   57: aload_1
    //   58: ldc 171
    //   60: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +7 -> 70
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_1
    //   69: areturn
    //   70: new 157	java/io/File
    //   73: dup
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: astore 4
    //   81: aload 4
    //   83: invokevirtual 182	java/io/File:exists	()Z
    //   86: ifeq +415 -> 501
    //   89: new 200	java/io/FileInputStream
    //   92: dup
    //   93: aload 4
    //   95: invokespecial 203	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: astore_1
    //   99: new 205	java/io/BufferedInputStream
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 208	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore_3
    //   108: aload_1
    //   109: invokevirtual 211	java/io/FileInputStream:available	()I
    //   112: newarray byte
    //   114: astore_2
    //   115: aload_3
    //   116: aload_2
    //   117: invokevirtual 215	java/io/BufferedInputStream:read	([B)I
    //   120: pop
    //   121: invokestatic 219	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   124: astore_0
    //   125: aload_0
    //   126: aload_2
    //   127: iconst_0
    //   128: aload_2
    //   129: arraylength
    //   130: invokevirtual 223	android/os/Parcel:unmarshall	([BII)V
    //   133: aload_0
    //   134: iconst_0
    //   135: invokevirtual 227	android/os/Parcel:setDataPosition	(I)V
    //   138: getstatic 53	com/tencent/mobileqq/ar/aidl/ArConfigInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   141: aload_0
    //   142: invokeinterface 233 2 0
    //   147: checkcast 2	com/tencent/mobileqq/ar/aidl/ArConfigInfo
    //   150: astore_2
    //   151: new 57	java/util/ArrayList
    //   154: dup
    //   155: invokespecial 58	java/util/ArrayList:<init>	()V
    //   158: pop
    //   159: aload_2
    //   160: getfield 60	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   163: astore 5
    //   165: aload_2
    //   166: getfield 60	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   169: invokevirtual 237	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   172: astore 6
    //   174: aload 6
    //   176: invokeinterface 242 1 0
    //   181: ifeq +125 -> 306
    //   184: aload 6
    //   186: invokeinterface 246 1 0
    //   191: checkcast 73	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo
    //   194: astore 7
    //   196: aload 7
    //   198: getfield 249	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_Boolean	Z
    //   201: ifne -27 -> 174
    //   204: aload 5
    //   206: aload 7
    //   208: invokevirtual 252	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   211: pop
    //   212: goto -38 -> 174
    //   215: astore 5
    //   217: ldc 14
    //   219: iconst_1
    //   220: new 115	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   227: ldc 254
    //   229: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 5
    //   234: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   237: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload_0
    //   247: invokevirtual 257	android/os/Parcel:recycle	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 260	java/io/BufferedInputStream:close	()V
    //   258: aload_2
    //   259: astore_0
    //   260: aload_1
    //   261: ifnull +9 -> 270
    //   264: aload_1
    //   265: invokevirtual 261	java/io/FileInputStream:close	()V
    //   268: aload_2
    //   269: astore_0
    //   270: aload_0
    //   271: astore_1
    //   272: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq -207 -> 68
    //   278: ldc 14
    //   280: iconst_2
    //   281: new 115	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 263
    //   291: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_0
    //   295: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload_0
    //   305: areturn
    //   306: aload_2
    //   307: aload 5
    //   309: putfield 60	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   312: goto -66 -> 246
    //   315: astore_2
    //   316: aload_1
    //   317: astore_0
    //   318: aload_3
    //   319: astore_1
    //   320: aload 4
    //   322: invokevirtual 185	java/io/File:delete	()Z
    //   325: pop
    //   326: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +29 -> 358
    //   332: ldc 14
    //   334: iconst_2
    //   335: new 115	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 268
    //   345: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_2
    //   349: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: aload_1
    //   359: ifnull +7 -> 366
    //   362: aload_1
    //   363: invokevirtual 260	java/io/BufferedInputStream:close	()V
    //   366: aload_0
    //   367: ifnull +129 -> 496
    //   370: aload_0
    //   371: invokevirtual 261	java/io/FileInputStream:close	()V
    //   374: aconst_null
    //   375: astore_0
    //   376: goto -106 -> 270
    //   379: astore_0
    //   380: aload_0
    //   381: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   384: goto -126 -> 258
    //   387: astore_0
    //   388: aload_0
    //   389: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   392: aload_2
    //   393: astore_0
    //   394: goto -124 -> 270
    //   397: astore_1
    //   398: aload_1
    //   399: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   402: goto -36 -> 366
    //   405: astore_0
    //   406: aload_0
    //   407: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   410: aconst_null
    //   411: astore_0
    //   412: goto -142 -> 270
    //   415: astore_0
    //   416: aconst_null
    //   417: astore_2
    //   418: aconst_null
    //   419: astore_1
    //   420: aload_1
    //   421: ifnull +7 -> 428
    //   424: aload_1
    //   425: invokevirtual 260	java/io/BufferedInputStream:close	()V
    //   428: aload_2
    //   429: ifnull +7 -> 436
    //   432: aload_2
    //   433: invokevirtual 261	java/io/FileInputStream:close	()V
    //   436: aload_0
    //   437: athrow
    //   438: astore_1
    //   439: aload_1
    //   440: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   443: goto -15 -> 428
    //   446: astore_1
    //   447: aload_1
    //   448: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   451: goto -15 -> 436
    //   454: astore_0
    //   455: aconst_null
    //   456: astore_3
    //   457: aload_1
    //   458: astore_2
    //   459: aload_3
    //   460: astore_1
    //   461: goto -41 -> 420
    //   464: astore_0
    //   465: aload_1
    //   466: astore_2
    //   467: aload_3
    //   468: astore_1
    //   469: goto -49 -> 420
    //   472: astore_3
    //   473: aload_0
    //   474: astore_2
    //   475: aload_3
    //   476: astore_0
    //   477: goto -57 -> 420
    //   480: astore_2
    //   481: aconst_null
    //   482: astore_0
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -165 -> 320
    //   488: astore_2
    //   489: aload_1
    //   490: astore_0
    //   491: aconst_null
    //   492: astore_1
    //   493: goto -173 -> 320
    //   496: aconst_null
    //   497: astore_0
    //   498: goto -228 -> 270
    //   501: aconst_null
    //   502: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	paramString1	String
    //   0	503	1	paramString2	String
    //   114	193	2	localObject1	Object
    //   315	78	2	localThrowable1	java.lang.Throwable
    //   417	58	2	str	String
    //   480	1	2	localThrowable2	java.lang.Throwable
    //   488	1	2	localThrowable3	java.lang.Throwable
    //   107	361	3	localBufferedInputStream	java.io.BufferedInputStream
    //   472	4	3	localObject2	Object
    //   79	242	4	localFile	File
    //   163	42	5	localArrayList	ArrayList
    //   215	93	5	localException	Exception
    //   172	13	6	localIterator	Iterator
    //   194	13	7	localArCloudConfigInfo	ArCloudConfigInfo
    // Exception table:
    //   from	to	target	type
    //   151	174	215	java/lang/Exception
    //   174	212	215	java/lang/Exception
    //   306	312	215	java/lang/Exception
    //   108	151	315	java/lang/Throwable
    //   151	174	315	java/lang/Throwable
    //   174	212	315	java/lang/Throwable
    //   217	246	315	java/lang/Throwable
    //   246	250	315	java/lang/Throwable
    //   306	312	315	java/lang/Throwable
    //   254	258	379	java/io/IOException
    //   264	268	387	java/io/IOException
    //   362	366	397	java/io/IOException
    //   370	374	405	java/io/IOException
    //   89	99	415	finally
    //   424	428	438	java/io/IOException
    //   432	436	446	java/io/IOException
    //   99	108	454	finally
    //   108	151	464	finally
    //   151	174	464	finally
    //   174	212	464	finally
    //   217	246	464	finally
    //   246	250	464	finally
    //   306	312	464	finally
    //   320	358	472	finally
    //   89	99	480	java/lang/Throwable
    //   99	108	488	java/lang/Throwable
  }
  
  public static ArConfigInfo parseArConfig(String paramString)
  {
    QLog.i("ArConfigInfo", 1, "parseArConfig. xmlConfigContent:" + paramString);
    Object localObject1 = Xml.newPullParser();
    ArConfigInfo localArConfigInfo = new ArConfigInfo();
    int i;
    label224:
    Object localObject2;
    label331:
    int j;
    label385:
    boolean bool;
    int k;
    label436:
    label462:
    Object localObject3;
    for (;;)
    {
      try
      {
        ((XmlPullParser)localObject1).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = ((XmlPullParser)localObject1).getEventType();
      }
      catch (Exception localException1)
      {
        String str1;
        localArConfigInfo = null;
        localObject1 = localArConfigInfo;
        if (!QLog.isColorLevel()) {
          break label224;
        }
        QLog.e("ArConfigInfo", 2, paramString, localException1);
        localObject1 = localArConfigInfo;
      }
      i = ((XmlPullParser)localObject1).next();
      break label2384;
      str1 = ((XmlPullParser)localObject1).getName();
      if (str1.equalsIgnoreCase("ScanAR"))
      {
        i = ((XmlPullParser)localObject1).next();
        if (i != 1)
        {
          if (i != 2) {
            break label331;
          }
          str1 = ((XmlPullParser)localObject1).getName();
          if (str1.equalsIgnoreCase("Begin"))
          {
            localArConfigInfo.aRBegin = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
            i = ((XmlPullParser)localObject1).next();
          }
        }
        else
        {
          continue;
        }
        if (str1.equalsIgnoreCase("End"))
        {
          localArConfigInfo.aREnd = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
          continue;
          return localObject1;
        }
        else if (localException1.equalsIgnoreCase("Scan_Line1"))
        {
          localArConfigInfo.scanLine1 = ((XmlPullParser)localObject1).nextText();
        }
        else if (localException1.equalsIgnoreCase("Scan_Line2"))
        {
          localArConfigInfo.scanLine2 = ((XmlPullParser)localObject1).nextText();
        }
        else if (localException1.equalsIgnoreCase("Scan_Line3"))
        {
          localArConfigInfo.scanLineLink = ((XmlPullParser)localObject1).nextText();
        }
        else if (localException1.equalsIgnoreCase("Scan_Line3_URL"))
        {
          localArConfigInfo.scanLinkUrl = ((XmlPullParser)localObject1).nextText();
          continue;
          if ((i != 3) || (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("ScanAR"))) {}
        }
      }
      else
      {
        label950:
        label957:
        label979:
        if (localException1.equalsIgnoreCase("Task"))
        {
          localObject2 = new ArCloudConfigInfo();
          j = ((XmlPullParser)localObject1).next();
          i = 0;
          if (j != 1)
          {
            if (j != 2) {
              break label2119;
            }
            String str2 = ((XmlPullParser)localObject1).getName();
            bool = str2.equalsIgnoreCase("BusinessId");
            if (!bool) {
              break label462;
            }
          }
          for (;;)
          {
            try
            {
              ((ArCloudConfigInfo)localObject2).jdField_a_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
              k = i;
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              ((ArCloudConfigInfo)localObject2).jdField_a_of_type_Int = 0;
              k = i;
              continue;
            }
            j = ((XmlPullParser)localObject1).next();
            i = k;
            break label385;
            break;
            bool = localNumberFormatException1.equalsIgnoreCase("LotterySet");
            if (bool)
            {
              try
              {
                ((ArCloudConfigInfo)localObject2).e = Integer.parseInt(((XmlPullParser)localObject1).nextText());
                k = i;
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                ((ArCloudConfigInfo)localObject2).e = 0;
                k = i;
              }
            }
            else if (localNumberFormatException2.equalsIgnoreCase("PicId"))
            {
              ((ArCloudConfigInfo)localObject2).jdField_b_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              k = i;
            }
            else if (localNumberFormatException2.equalsIgnoreCase("SDKVersion"))
            {
              ((ArCloudConfigInfo)localObject2).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              k = i;
            }
            else
            {
              bool = localNumberFormatException2.equalsIgnoreCase("TrackMode");
              if (bool)
              {
                try
                {
                  ((ArCloudConfigInfo)localObject2).jdField_c_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
                  k = i;
                }
                catch (NumberFormatException localNumberFormatException3)
                {
                  ((ArCloudConfigInfo)localObject2).jdField_c_of_type_Int = 0;
                  k = i;
                }
              }
              else
              {
                bool = localNumberFormatException3.equalsIgnoreCase("Type");
                if (bool)
                {
                  try
                  {
                    ((ArCloudConfigInfo)localObject2).jdField_d_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
                    k = i;
                  }
                  catch (NumberFormatException localNumberFormatException4)
                  {
                    ((ArCloudConfigInfo)localObject2).jdField_d_of_type_Int = 0;
                    k = i;
                  }
                }
                else
                {
                  if (!localNumberFormatException4.equalsIgnoreCase("Feature")) {
                    break label869;
                  }
                  localObject3 = new ArFeatureInfo();
                  int m = ((XmlPullParser)localObject1).next();
                  j = i;
                  k = j;
                  if (m != 1)
                  {
                    String str3;
                    if (m == 2)
                    {
                      str3 = ((XmlPullParser)localObject1).getName();
                      if (str3.equalsIgnoreCase("FeatureMD5"))
                      {
                        ((ArFeatureInfo)localObject3).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
                        i = 1;
                      }
                    }
                    label741:
                    do
                    {
                      do
                      {
                        for (;;)
                        {
                          m = ((XmlPullParser)localObject1).next();
                          j = i;
                          break;
                          bool = str3.equalsIgnoreCase("FeatureSize");
                          if (bool)
                          {
                            try
                            {
                              ((ArFeatureInfo)localObject3).jdField_a_of_type_Long = Long.parseLong(((XmlPullParser)localObject1).nextText());
                              i = 1;
                            }
                            catch (NumberFormatException localNumberFormatException5)
                            {
                              ((ArFeatureInfo)localObject3).jdField_a_of_type_Long = 0L;
                              i = 1;
                            }
                          }
                          else
                          {
                            if (!localNumberFormatException5.equalsIgnoreCase("FeatureUrl")) {
                              break label2379;
                            }
                            ((ArFeatureInfo)localObject3).jdField_b_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
                            i = 1;
                          }
                        }
                        i = j;
                      } while (m != 3);
                      i = j;
                    } while (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("Feature"));
                    ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)localObject3);
                    k = j;
                  }
                }
              }
            }
          }
          label869:
          if (((String)localObject3).equalsIgnoreCase("Web"))
          {
            localObject3 = new ArWebInfo();
            for (j = ((XmlPullParser)localObject1).next();; j = ((XmlPullParser)localObject1).next())
            {
              k = i;
              if (j == 1) {
                break;
              }
              if (j != 2) {
                break label1058;
              }
              String str4 = ((XmlPullParser)localObject1).getName();
              bool = str4.equalsIgnoreCase("IsUrlTransparent");
              if (!bool) {
                break label979;
              }
              try
              {
                if (Integer.parseInt(((XmlPullParser)localObject1).nextText()) != 1) {
                  break label2419;
                }
                bool = true;
                ((ArWebInfo)localObject3).b = bool;
              }
              catch (NumberFormatException localNumberFormatException6)
              {
                for (;;)
                {
                  ((ArWebInfo)localObject3).b = false;
                }
              }
            }
            bool = localNumberFormatException6.equalsIgnoreCase("IsUrlAutoJump");
            if (!bool) {
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(((XmlPullParser)localObject1).nextText()) != 1) {
          break label2425;
        }
        bool = true;
        ((ArWebInfo)localObject3).jdField_a_of_type_Boolean = bool;
      }
      catch (NumberFormatException localNumberFormatException7)
      {
        ((ArWebInfo)localObject3).jdField_a_of_type_Boolean = false;
      }
      break label957;
      if (!localNumberFormatException7.equalsIgnoreCase("WebJumpUrl")) {
        break label957;
      }
      ((ArWebInfo)localObject3).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
      break label957;
      label1058:
      if ((j != 3) || (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("Web"))) {
        break label957;
      }
      ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArWebInfo = ((ArWebInfo)localObject3);
      k = i;
      break label436;
      if (((String)localObject3).equalsIgnoreCase("ModelResource"))
      {
        localObject3 = new ArModelResource();
        j = ((XmlPullParser)localObject1).next();
        k = i;
        if (j == 1) {
          break label436;
        }
        if (j == 2)
        {
          str5 = ((XmlPullParser)localObject1).getName();
          bool = str5.equalsIgnoreCase("ModelResourceSize");
          if (!bool) {}
        }
        while ((j != 3) || (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("ModelResource"))) {
          for (;;)
          {
            try
            {
              String str5;
              ((ArModelResource)localObject3).jdField_a_of_type_Long = Integer.parseInt(((XmlPullParser)localObject1).nextText());
              j = ((XmlPullParser)localObject1).next();
            }
            catch (NumberFormatException localNumberFormatException8)
            {
              ((ArModelResource)localObject3).jdField_a_of_type_Long = 0L;
              continue;
            }
            bool = localNumberFormatException8.equalsIgnoreCase("ModelRepeatTimes");
            if (bool) {
              try
              {
                ((ArModelResource)localObject3).jdField_a_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
              }
              catch (NumberFormatException localNumberFormatException9)
              {
                ((ArModelResource)localObject3).jdField_a_of_type_Int = 0;
              }
            } else if (localNumberFormatException9.equalsIgnoreCase("ModelResourceMD5")) {
              ((ArModelResource)localObject3).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            } else if (localNumberFormatException9.equalsIgnoreCase("ModelResourceUrl")) {
              ((ArModelResource)localObject3).jdField_b_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            } else if (localNumberFormatException9.equalsIgnoreCase("ModelResourceBgMusic")) {
              ((ArModelResource)localObject3).jdField_c_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            } else if (localNumberFormatException9.equalsIgnoreCase("ModelConfigFile")) {
              ((ArModelResource)localObject3).jdField_d_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            }
          }
        }
        ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArModelResource = ((ArModelResource)localObject3);
        k = i;
        break label436;
      }
      if (((String)localObject3).equalsIgnoreCase("Award"))
      {
        localObject3 = new ArAwardInfo();
        j = ((XmlPullParser)localObject1).next();
        k = i;
        if (j == 1) {
          break label436;
        }
        if (j == 2)
        {
          str6 = ((XmlPullParser)localObject1).getName();
          bool = str6.equalsIgnoreCase("AwardDistance");
          if (!bool) {}
        }
        while ((j != 3) || (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("Award"))) {
          for (;;)
          {
            try
            {
              String str6;
              ((ArAwardInfo)localObject3).jdField_a_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
              j = ((XmlPullParser)localObject1).next();
            }
            catch (NumberFormatException localNumberFormatException10)
            {
              ((ArAwardInfo)localObject3).jdField_a_of_type_Int = 0;
              continue;
            }
            if (localNumberFormatException10.equalsIgnoreCase("NotPlayModel"))
            {
              if (Integer.parseInt(((XmlPullParser)localObject1).nextText()) == 1) {
                ((ArAwardInfo)localObject3).jdField_b_of_type_Int = 0;
              } else {
                ((ArAwardInfo)localObject3).jdField_b_of_type_Int = 1;
              }
            }
            else if (localNumberFormatException10.equalsIgnoreCase("BusinessBanner")) {
              ((ArAwardInfo)localObject3).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            } else if (localNumberFormatException10.equalsIgnoreCase("BusinessLogo")) {
              ((ArAwardInfo)localObject3).jdField_b_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            } else if (localNumberFormatException10.equalsIgnoreCase("BusinessName")) {
              ((ArAwardInfo)localObject3).jdField_c_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            } else if (localNumberFormatException10.equalsIgnoreCase("BusinessWishing")) {
              ((ArAwardInfo)localObject3).jdField_d_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            }
          }
        }
        ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo = ((ArAwardInfo)localObject3);
        k = i;
        break label436;
      }
      k = i;
      if (!((String)localObject3).equalsIgnoreCase("VideoResource")) {
        break label436;
      }
      localObject3 = new ArVideoResourceInfo();
      j = ((XmlPullParser)localObject1).next();
      k = i;
      if (j == 1) {
        break label436;
      }
      if (j == 2)
      {
        str7 = ((XmlPullParser)localObject1).getName();
        bool = str7.equalsIgnoreCase("VideoConnectType");
        if (!bool) {}
      }
      while ((j != 3) || (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("VideoResource"))) {
        for (;;)
        {
          try
          {
            String str7;
            ((ArVideoResourceInfo)localObject3).jdField_a_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
            j = ((XmlPullParser)localObject1).next();
          }
          catch (NumberFormatException localNumberFormatException11)
          {
            ((ArVideoResourceInfo)localObject3).jdField_a_of_type_Int = 0;
            continue;
          }
          bool = localNumberFormatException11.equalsIgnoreCase("VideoTrackMode");
          if (bool)
          {
            try
            {
              ((ArVideoResourceInfo)localObject3).jdField_c_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
            }
            catch (NumberFormatException localNumberFormatException12)
            {
              ((ArVideoResourceInfo)localObject3).jdField_c_of_type_Int = 0;
            }
          }
          else if (localNumberFormatException12.equalsIgnoreCase("VideoKeyingConfig"))
          {
            ((ArVideoResourceInfo)localObject3).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
          }
          else if (localNumberFormatException12.equalsIgnoreCase("VideoLayout"))
          {
            ((ArVideoResourceInfo)localObject3).jdField_b_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
          }
          else if (localNumberFormatException12.equalsIgnoreCase("VideoMD5"))
          {
            ((ArVideoResourceInfo)localObject3).jdField_c_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
          }
          else if (localNumberFormatException12.equalsIgnoreCase("VideoUrl"))
          {
            ((ArVideoResourceInfo)localObject3).jdField_d_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
          }
          else
          {
            bool = localNumberFormatException12.equalsIgnoreCase("VideoRepeatTimes");
            if (bool)
            {
              try
              {
                ((ArVideoResourceInfo)localObject3).jdField_b_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
              }
              catch (NumberFormatException localNumberFormatException13)
              {
                ((ArVideoResourceInfo)localObject3).jdField_b_of_type_Int = 0;
              }
            }
            else
            {
              bool = localNumberFormatException13.equalsIgnoreCase("VideoType");
              if (bool)
              {
                try
                {
                  ((ArVideoResourceInfo)localObject3).jdField_d_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
                }
                catch (NumberFormatException localNumberFormatException14)
                {
                  ((ArVideoResourceInfo)localObject3).jdField_d_of_type_Int = 0;
                }
              }
              else
              {
                bool = localNumberFormatException14.equalsIgnoreCase("VideoSize");
                if (bool)
                {
                  try
                  {
                    ((ArVideoResourceInfo)localObject3).jdField_a_of_type_Long = Long.parseLong(((XmlPullParser)localObject1).nextText());
                  }
                  catch (NumberFormatException localNumberFormatException15)
                  {
                    ((ArVideoResourceInfo)localObject3).jdField_a_of_type_Long = 0L;
                  }
                }
                else
                {
                  bool = localNumberFormatException15.equalsIgnoreCase("VideoTrackMode");
                  if (bool) {
                    try
                    {
                      ((ArVideoResourceInfo)localObject3).jdField_c_of_type_Int = Integer.parseInt(((XmlPullParser)localObject1).nextText());
                    }
                    catch (NumberFormatException localNumberFormatException16)
                    {
                      ((ArVideoResourceInfo)localObject3).jdField_c_of_type_Int = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
      ((ArCloudConfigInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
      k = i;
      break label436;
      label2119:
      k = i;
      if (j != 3) {
        break label436;
      }
      k = i;
      if (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("Task")) {
        break label436;
      }
      if (i == 0) {
        break;
      }
      localArConfigInfo.mArCloudConfigInfos.add(localObject2);
      break;
      if (!((String)localObject2).equalsIgnoreCase("Cloud")) {
        break;
      }
      i = ((XmlPullParser)localObject1).next();
      label2181:
      if (i != 1)
      {
        if (i != 2) {
          break label2315;
        }
        localObject2 = ((XmlPullParser)localObject1).getName();
        if (!((String)localObject2).equalsIgnoreCase("Begin")) {
          break label2237;
        }
        localArConfigInfo.aRCloudBegin = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
      }
      label2237:
      while ((i != 3) || (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("Cloud"))) {
        for (;;)
        {
          i = ((XmlPullParser)localObject1).next();
          break label2181;
          break;
          if (((String)localObject2).equalsIgnoreCase("End"))
          {
            localArConfigInfo.aRCloudEnd = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
          }
          else
          {
            bool = ((String)localObject2).equalsIgnoreCase("CacheExpireTime");
            if (bool) {
              try
              {
                localArConfigInfo.aRCloudCacheExpireTime = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
              }
              catch (Exception localException2)
              {
                localArConfigInfo.aRCloudCacheExpireTime = 1440L;
              }
            }
          }
        }
      }
      label2315:
      break;
      label2379:
      label2384:
      do
      {
        localObject1 = localArConfigInfo;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ArConfigInfo", 2, "parseConfig success|config=" + localArConfigInfo);
        return localArConfigInfo;
        i = 1;
        break label741;
      } while (i == 1);
      switch (i)
      {
      }
      break;
      label2419:
      bool = false;
      break label950;
      label2425:
      bool = false;
    }
  }
  
  public static boolean saveArConfigToFile(ArConfigInfo paramArConfigInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfigInfo", 2, "saveArConfigToFile. uin = " + paramString);
    }
    if (paramString == null) {
      return false;
    }
    return saveArConfigToFile(paramArConfigInfo, BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_file_config_v739_" + paramString);
  }
  
  /* Error */
  public static boolean saveArConfigToFile(ArConfigInfo paramArConfigInfo, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +38 -> 47
    //   12: ldc 14
    //   14: iconst_2
    //   15: new 115	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 532
    //   25: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 169
    //   34: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: iload 4
    //   49: istore_3
    //   50: aload_0
    //   51: ifnull +41 -> 92
    //   54: iload 4
    //   56: istore_3
    //   57: aload_1
    //   58: ifnull +34 -> 92
    //   61: iload 4
    //   63: istore_3
    //   64: aload_1
    //   65: ldc 171
    //   67: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +22 -> 92
    //   73: iload 4
    //   75: istore_3
    //   76: aload_2
    //   77: ifnull +15 -> 92
    //   80: aload_2
    //   81: ldc 171
    //   83: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +8 -> 94
    //   89: iload 4
    //   91: istore_3
    //   92: iload_3
    //   93: ireturn
    //   94: new 157	java/io/File
    //   97: dup
    //   98: aload_1
    //   99: aload_2
    //   100: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: astore 7
    //   105: new 157	java/io/File
    //   108: dup
    //   109: aload_1
    //   110: new 115	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   117: aload_2
    //   118: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 534
    //   124: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: astore 8
    //   135: invokestatic 219	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   138: astore 6
    //   140: aload 6
    //   142: iconst_0
    //   143: invokevirtual 227	android/os/Parcel:setDataPosition	(I)V
    //   146: aload_0
    //   147: aload 6
    //   149: iconst_0
    //   150: invokevirtual 538	com/tencent/mobileqq/ar/aidl/ArConfigInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   153: aload 6
    //   155: invokevirtual 541	android/os/Parcel:marshall	()[B
    //   158: astore_0
    //   159: aload 7
    //   161: invokevirtual 544	java/io/File:getParentFile	()Ljava/io/File;
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 182	java/io/File:exists	()Z
    //   169: ifne +8 -> 177
    //   172: aload_1
    //   173: invokevirtual 547	java/io/File:mkdir	()Z
    //   176: pop
    //   177: aload 8
    //   179: invokevirtual 182	java/io/File:exists	()Z
    //   182: ifeq +9 -> 191
    //   185: aload 8
    //   187: invokevirtual 185	java/io/File:delete	()Z
    //   190: pop
    //   191: new 549	java/io/FileOutputStream
    //   194: dup
    //   195: aload 8
    //   197: invokespecial 550	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   200: astore_2
    //   201: new 552	java/io/BufferedOutputStream
    //   204: dup
    //   205: aload_2
    //   206: invokespecial 555	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   209: astore_1
    //   210: aload_1
    //   211: aload_0
    //   212: invokevirtual 558	java/io/BufferedOutputStream:write	([B)V
    //   215: aload_1
    //   216: invokevirtual 561	java/io/BufferedOutputStream:flush	()V
    //   219: aload 8
    //   221: aload 7
    //   223: invokestatic 566	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   226: istore_3
    //   227: iload_3
    //   228: istore 4
    //   230: aload 6
    //   232: invokevirtual 257	android/os/Parcel:recycle	()V
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 567	java/io/BufferedOutputStream:close	()V
    //   243: iload 4
    //   245: istore_3
    //   246: aload_2
    //   247: ifnull -155 -> 92
    //   250: aload_2
    //   251: invokevirtual 568	java/io/FileOutputStream:close	()V
    //   254: iload 4
    //   256: ireturn
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   262: iload 4
    //   264: ireturn
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   270: goto -27 -> 243
    //   273: astore_2
    //   274: aconst_null
    //   275: astore_1
    //   276: aload 5
    //   278: astore_0
    //   279: aload_2
    //   280: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   283: aload 6
    //   285: invokevirtual 257	android/os/Parcel:recycle	()V
    //   288: aload_1
    //   289: ifnull +7 -> 296
    //   292: aload_1
    //   293: invokevirtual 567	java/io/BufferedOutputStream:close	()V
    //   296: iload 4
    //   298: istore_3
    //   299: aload_0
    //   300: ifnull -208 -> 92
    //   303: aload_0
    //   304: invokevirtual 568	java/io/FileOutputStream:close	()V
    //   307: iconst_0
    //   308: ireturn
    //   309: astore_0
    //   310: aload_0
    //   311: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   314: iconst_0
    //   315: ireturn
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   321: goto -25 -> 296
    //   324: astore_0
    //   325: aconst_null
    //   326: astore_1
    //   327: aconst_null
    //   328: astore_2
    //   329: aload 6
    //   331: invokevirtual 257	android/os/Parcel:recycle	()V
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 567	java/io/BufferedOutputStream:close	()V
    //   342: aload_2
    //   343: ifnull +7 -> 350
    //   346: aload_2
    //   347: invokevirtual 568	java/io/FileOutputStream:close	()V
    //   350: aload_0
    //   351: athrow
    //   352: astore_1
    //   353: aload_1
    //   354: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   357: goto -15 -> 342
    //   360: astore_1
    //   361: aload_1
    //   362: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   365: goto -15 -> 350
    //   368: astore_0
    //   369: aconst_null
    //   370: astore_1
    //   371: goto -42 -> 329
    //   374: astore_0
    //   375: goto -46 -> 329
    //   378: astore 5
    //   380: aload_0
    //   381: astore_2
    //   382: aload 5
    //   384: astore_0
    //   385: goto -56 -> 329
    //   388: astore 5
    //   390: aconst_null
    //   391: astore_1
    //   392: aload_2
    //   393: astore_0
    //   394: aload 5
    //   396: astore_2
    //   397: goto -118 -> 279
    //   400: astore 5
    //   402: aload_2
    //   403: astore_0
    //   404: aload 5
    //   406: astore_2
    //   407: goto -128 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramArConfigInfo	ArConfigInfo
    //   0	410	1	paramString1	String
    //   0	410	2	paramString2	String
    //   49	250	3	bool1	boolean
    //   4	293	4	bool2	boolean
    //   1	276	5	localObject1	Object
    //   378	5	5	localObject2	Object
    //   388	7	5	localIOException1	java.io.IOException
    //   400	5	5	localIOException2	java.io.IOException
    //   138	192	6	localParcel	Parcel
    //   103	119	7	localFile1	File
    //   133	87	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   250	254	257	java/io/IOException
    //   239	243	265	java/io/IOException
    //   191	201	273	java/io/IOException
    //   303	307	309	java/io/IOException
    //   292	296	316	java/io/IOException
    //   191	201	324	finally
    //   338	342	352	java/io/IOException
    //   346	350	360	java/io/IOException
    //   201	210	368	finally
    //   210	227	374	finally
    //   279	283	378	finally
    //   201	210	388	java/io/IOException
    //   210	227	400	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArCloudConfigInfo getModelResByMd5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.mArCloudConfigInfos.iterator();
      while (localIterator.hasNext())
      {
        ArCloudConfigInfo localArCloudConfigInfo = (ArCloudConfigInfo)localIterator.next();
        if ((localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (!TextUtils.isEmpty(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString)))
        {
          boolean bool = paramString.equals(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
          if (bool) {
            return localArCloudConfigInfo;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      return null;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArConfigInfo{");
    localStringBuffer.append("version='").append(this.version).append('\'');
    localStringBuffer.append(", aRBegin=").append(this.aRBegin);
    localStringBuffer.append(", aREnd=").append(this.aREnd);
    localStringBuffer.append(", scanLine1='").append(this.scanLine1).append('\'');
    localStringBuffer.append(", scanLine2='").append(this.scanLine2).append('\'');
    localStringBuffer.append(", scanLineLink='").append(this.scanLineLink).append('\'');
    localStringBuffer.append(", scanLinkUrl='").append(this.scanLinkUrl).append('\'');
    localStringBuffer.append(", aRCloudBegin=").append(this.aRCloudBegin).append('\'');
    localStringBuffer.append(", mArCloudConfigInfos=").append(this.mArCloudConfigInfos).append('\'');
    localStringBuffer.append(", aRCloudCacheExpireTime=").append(this.aRCloudCacheExpireTime).append('\'');
    localStringBuffer.append(", aRCloudEnd=").append(this.aRCloudEnd).append('\'');
    localStringBuffer.append(", saveConfig=").append(this.saveConfig).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(20);
    paramParcel.writeInt(this.version);
    paramParcel.writeLong(this.aRBegin);
    paramParcel.writeLong(this.aREnd);
    paramParcel.writeString(this.scanLine1);
    paramParcel.writeString(this.scanLine2);
    paramParcel.writeString(this.scanLineLink);
    paramParcel.writeString(this.scanLinkUrl);
    paramParcel.writeTypedList(this.mArCloudConfigInfos);
    paramParcel.writeLong(this.aRCloudBegin);
    paramParcel.writeLong(this.aRCloudEnd);
    paramParcel.writeLong(this.aRCloudCacheExpireTime);
    if (this.saveConfig) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArConfigInfo
 * JD-Core Version:    0.7.0.1
 */