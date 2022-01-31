package com.tencent.av.service;

import alig;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
import babp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import llo;
import org.xmlpull.v1.XmlPullParser;

public class AVRedPacketConfig
  implements Parcelable, Serializable
{
  static final String CONFIG_PATH = "avredpacket_config_";
  public static final Parcelable.Creator<AVRedPacketConfig> CREATOR = new llo();
  static final String TAG = "AVRedPacketConfig";
  public boolean checkEyeOpenClose;
  public boolean checkNormalFaceExpression;
  public int continuousHitCount;
  public List<AVRedPacketConfig.ExpressionInfo> expressionInfoList;
  public long game321MaxTimeOut;
  public int gameExpressionCount;
  public List<Integer> gameExpressionDurationList;
  public List<Integer> gameExpressionIDList;
  public int gameMaxScore;
  public long gameSendRedBagMaxTimeOut;
  public boolean mainSwitch;
  public String musicResMd5;
  public String musicResUrl;
  public long operatingEntranceBeginTime;
  public long operatingEntranceEndTime;
  public String resMD5;
  public String resURL;
  public List<Integer> shareExpressionIDList;
  public long tipsTimeout;
  public boolean uploadUserExpression;
  public int version;
  
  public AVRedPacketConfig() {}
  
  public AVRedPacketConfig(Parcel paramParcel)
  {
    this.version = paramParcel.readInt();
    this.gameExpressionCount = paramParcel.readInt();
    this.gameMaxScore = paramParcel.readInt();
    this.continuousHitCount = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.mainSwitch = bool1;
      if (paramParcel.readByte() == 0) {
        break label222;
      }
      bool1 = true;
      label61:
      this.checkEyeOpenClose = bool1;
      if (paramParcel.readByte() == 0) {
        break label227;
      }
      bool1 = true;
      label75:
      this.checkNormalFaceExpression = bool1;
      if (paramParcel.readByte() == 0) {
        break label232;
      }
    }
    label222:
    label227:
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.uploadUserExpression = bool1;
      this.tipsTimeout = paramParcel.readLong();
      this.gameSendRedBagMaxTimeOut = paramParcel.readLong();
      this.game321MaxTimeOut = paramParcel.readLong();
      this.operatingEntranceBeginTime = paramParcel.readLong();
      this.operatingEntranceEndTime = paramParcel.readLong();
      this.resURL = paramParcel.readString();
      this.resMD5 = paramParcel.readString();
      this.musicResUrl = paramParcel.readString();
      this.musicResMd5 = paramParcel.readString();
      this.expressionInfoList = paramParcel.createTypedArrayList(AVRedPacketConfig.ExpressionInfo.CREATOR);
      this.gameExpressionIDList = paramParcel.readArrayList(Long.class.getClassLoader());
      this.gameExpressionDurationList = paramParcel.readArrayList(Long.class.getClassLoader());
      this.shareExpressionIDList = paramParcel.readArrayList(Long.class.getClassLoader());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label61;
      bool1 = false;
      break label75;
    }
  }
  
  public static void deleteLocalConfig(String paramString)
  {
    paramString = BaseApplicationImpl.getContext().getFileStreamPath(getConfigPrefix() + paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfig", 2, "deleteLocalConfig path:" + paramString.getAbsolutePath());
    }
  }
  
  static final String getConfigPrefix()
  {
    Object localObject = "";
    try
    {
      String str = babp.a(BaseApplicationImpl.getContext());
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("AVRedPacketConfig", 1, "getConfigPrefix exception", localException);
      }
    }
    return (String)localObject + "avredpacket_config_";
  }
  
  public static AVRedPacketConfig parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    AVRedPacketConfig localAVRedPacketConfig = new AVRedPacketConfig();
    ArrayList localArrayList = new ArrayList();
    int i;
    boolean bool;
    label189:
    label226:
    String[] arrayOfString;
    label263:
    int k;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramString) {}
      i = localXmlPullParser.next();
      break label1324;
      paramString = localXmlPullParser.getName();
      if (paramString.equalsIgnoreCase("mainSwitch"))
      {
        if (Integer.parseInt(localXmlPullParser.nextText()) == 1)
        {
          bool = true;
          localAVRedPacketConfig.mainSwitch = bool;
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AVRedPacketConfig", 2, "parse exception:" + paramString.toString());
          return null;
        }
        bool = false;
        continue;
      }
      if (paramString.equalsIgnoreCase("isCheckRefuseOfCloseEye"))
      {
        if (Integer.parseInt(localXmlPullParser.nextText()) != 1) {
          break label1367;
        }
        bool = true;
        localAVRedPacketConfig.checkEyeOpenClose = bool;
      }
      else if (paramString.equalsIgnoreCase("isCheckRefuseOfNoneFace"))
      {
        if (Integer.parseInt(localXmlPullParser.nextText()) != 1) {
          break label1373;
        }
        bool = true;
        localAVRedPacketConfig.checkNormalFaceExpression = bool;
      }
      else if (paramString.equalsIgnoreCase("uploadUserExpression"))
      {
        if (Integer.parseInt(localXmlPullParser.nextText()) != 1) {
          break label1379;
        }
        bool = true;
        localAVRedPacketConfig.uploadUserExpression = bool;
      }
      else if (paramString.equalsIgnoreCase("gameExpressionCount"))
      {
        localAVRedPacketConfig.gameExpressionCount = Integer.parseInt(localXmlPullParser.nextText());
      }
      else if (paramString.equalsIgnoreCase("gameMaxScore"))
      {
        localAVRedPacketConfig.gameMaxScore = Integer.parseInt(localXmlPullParser.nextText());
      }
      else if (paramString.equalsIgnoreCase("checkLinkHitCount"))
      {
        localAVRedPacketConfig.continuousHitCount = Integer.parseInt(localXmlPullParser.nextText());
      }
      else if (paramString.equalsIgnoreCase("detectTimeout"))
      {
        localAVRedPacketConfig.tipsTimeout = Long.parseLong(localXmlPullParser.nextText());
      }
      else if (paramString.equalsIgnoreCase("gameSendRedBagMaxTimeOut"))
      {
        localAVRedPacketConfig.gameSendRedBagMaxTimeOut = Long.parseLong(localXmlPullParser.nextText());
      }
      else if (paramString.equalsIgnoreCase("game321MaxTimeOut"))
      {
        localAVRedPacketConfig.game321MaxTimeOut = Long.parseLong(localXmlPullParser.nextText());
      }
      else if (paramString.equalsIgnoreCase("activityBeginTime"))
      {
        localAVRedPacketConfig.operatingEntranceBeginTime = alig.b(localXmlPullParser.nextText());
      }
      else if (paramString.equalsIgnoreCase("activityEndTime"))
      {
        localAVRedPacketConfig.operatingEntranceEndTime = alig.b(localXmlPullParser.nextText());
      }
      else if (paramString.equalsIgnoreCase("androidCommonResUrl"))
      {
        localAVRedPacketConfig.resURL = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("androidCommonResMd5"))
      {
        localAVRedPacketConfig.resMD5 = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("musicResUrlAndroid"))
      {
        localAVRedPacketConfig.musicResUrl = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("musicResMd5Android"))
      {
        localAVRedPacketConfig.musicResMd5 = localXmlPullParser.nextText();
      }
      else
      {
        int j;
        if (paramString.equalsIgnoreCase("gameExpressionIDList"))
        {
          str = localXmlPullParser.nextText();
          if (!TextUtils.isEmpty(str))
          {
            paramString = new ArrayList();
            arrayOfString = str.split(",");
            str = paramString;
            if (arrayOfString != null)
            {
              str = paramString;
              if (arrayOfString.length > 0)
              {
                j = arrayOfString.length;
                i = 0;
                for (;;)
                {
                  str = paramString;
                  if (i >= j) {
                    break label755;
                  }
                  str = arrayOfString[i];
                  try
                  {
                    k = Integer.parseInt(str);
                    str = paramString;
                    if (paramString != null)
                    {
                      paramString.add(Integer.valueOf(k));
                      str = paramString;
                    }
                    label706:
                    i += 1;
                    paramString = str;
                  }
                  catch (NumberFormatException paramString)
                  {
                    if (!QLog.isColorLevel()) {
                      break label1385;
                    }
                  }
                }
                QLog.d("AVRedPacketConfig", 2, "parse NumberFormatException :" + paramString.toString());
                break label1385;
              }
            }
            label755:
            localAVRedPacketConfig.gameExpressionIDList = str;
          }
        }
        else if (paramString.equalsIgnoreCase("gameExpressionDuration"))
        {
          str = localXmlPullParser.nextText();
          if (!TextUtils.isEmpty(str))
          {
            paramString = new ArrayList();
            arrayOfString = str.split(",");
            str = paramString;
            if (arrayOfString != null)
            {
              str = paramString;
              if (arrayOfString.length > 0)
              {
                j = arrayOfString.length;
                i = 0;
                for (;;)
                {
                  str = paramString;
                  if (i >= j) {
                    break label923;
                  }
                  str = arrayOfString[i];
                  try
                  {
                    k = Integer.parseInt(str);
                    str = paramString;
                    if (paramString != null)
                    {
                      paramString.add(Integer.valueOf(k));
                      str = paramString;
                    }
                    label874:
                    i += 1;
                    paramString = str;
                  }
                  catch (NumberFormatException paramString)
                  {
                    if (!QLog.isColorLevel()) {
                      break label1391;
                    }
                  }
                }
                QLog.d("AVRedPacketConfig", 2, "parse NumberFormatException :" + paramString.toString());
                break label1391;
              }
            }
            label923:
            localAVRedPacketConfig.gameExpressionDurationList = str;
          }
        }
        else if (paramString.equalsIgnoreCase("shareExpressionIDList"))
        {
          str = localXmlPullParser.nextText();
          if (TextUtils.isEmpty(str)) {
            continue;
          }
          paramString = new ArrayList();
          arrayOfString = str.split(",");
          str = paramString;
          if (arrayOfString != null)
          {
            str = paramString;
            if (arrayOfString.length > 0)
            {
              j = arrayOfString.length;
              i = 0;
              str = paramString;
              if (i >= j) {}
            }
          }
        }
      }
    }
    for (String str = arrayOfString[i];; str = null)
    {
      try
      {
        k = Integer.parseInt(str);
        str = paramString;
        if (paramString != null)
        {
          paramString.add(Integer.valueOf(k));
          str = paramString;
        }
        i += 1;
        paramString = str;
      }
      catch (NumberFormatException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      QLog.d("AVRedPacketConfig", 2, "parse NumberFormatException :" + paramString.toString());
      continue;
      localAVRedPacketConfig.shareExpressionIDList = str;
      break;
      if (!paramString.equalsIgnoreCase("expression")) {
        break;
      }
      i = localXmlPullParser.next();
      paramString = new AVRedPacketConfig.ExpressionInfo();
      label1127:
      if (i != 1)
      {
        if (i != 2) {
          break label1238;
        }
        str = localXmlPullParser.getName();
        if (!str.equalsIgnoreCase("expressionID")) {
          break label1182;
        }
        paramString.id = Integer.parseInt(localXmlPullParser.nextText());
      }
      label1182:
      label1238:
      while (i != 3) {
        for (;;)
        {
          i = localXmlPullParser.next();
          break label1127;
          break;
          if (str.equalsIgnoreCase("coolValue")) {
            paramString.coolValue = Integer.parseInt(localXmlPullParser.nextText());
          } else if (str.equalsIgnoreCase("perfectValue")) {
            paramString.perfectValue = Integer.parseInt(localXmlPullParser.nextText());
          }
        }
      }
      if (!localXmlPullParser.getName().equalsIgnoreCase("expression")) {
        break;
      }
      localArrayList.add(paramString);
      break;
      label1324:
      do
      {
        if (localArrayList.size() > 0) {
          localAVRedPacketConfig.expressionInfoList = localArrayList;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfig", 2, "parse result = " + localAVRedPacketConfig);
        }
        return localAVRedPacketConfig;
      } while (i == 1);
      switch (i)
      {
      }
      break;
      label1367:
      bool = false;
      break label189;
      label1373:
      bool = false;
      break label226;
      label1379:
      bool = false;
      break label263;
      label1385:
      str = null;
      break label706;
      label1391:
      str = null;
      break label874;
    }
  }
  
  /* Error */
  public static AVRedPacketConfig readFromFile(String paramString)
  {
    // Byte code:
    //   0: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 18
    //   8: iconst_2
    //   9: ldc_w 353
    //   12: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +20 -> 39
    //   22: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +12 -> 37
    //   28: ldc 18
    //   30: iconst_2
    //   31: ldc_w 355
    //   34: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aconst_null
    //   38: areturn
    //   39: invokestatic 144	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: new 146	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   49: invokestatic 150	com/tencent/av/service/AVRedPacketConfig:getConfigPrefix	()Ljava/lang/String;
    //   52: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokevirtual 163	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 169	java/io/File:exists	()Z
    //   70: ifne +20 -> 90
    //   73: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq -39 -> 37
    //   79: ldc 18
    //   81: iconst_2
    //   82: ldc_w 357
    //   85: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aconst_null
    //   89: areturn
    //   90: new 359	java/io/FileInputStream
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: astore_1
    //   99: new 364	java/io/ObjectInputStream
    //   102: dup
    //   103: new 366	java/io/BufferedInputStream
    //   106: dup
    //   107: aload_1
    //   108: invokespecial 369	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   111: invokespecial 370	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: astore 5
    //   116: aload 5
    //   118: astore_3
    //   119: aload_1
    //   120: astore_2
    //   121: aload 5
    //   123: invokevirtual 374	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   126: checkcast 2	com/tencent/av/service/AVRedPacketConfig
    //   129: astore 4
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 377	java/io/FileInputStream:close	()V
    //   139: aload 4
    //   141: astore_0
    //   142: aload 5
    //   144: ifnull +11 -> 155
    //   147: aload 5
    //   149: invokevirtual 378	java/io/ObjectInputStream:close	()V
    //   152: aload 4
    //   154: astore_0
    //   155: aload_0
    //   156: areturn
    //   157: astore_0
    //   158: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -22 -> 139
    //   164: aload_0
    //   165: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   168: goto -29 -> 139
    //   171: astore_1
    //   172: aload 4
    //   174: astore_0
    //   175: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq -23 -> 155
    //   181: aload_1
    //   182: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   185: aload 4
    //   187: astore_0
    //   188: goto -33 -> 155
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_0
    //   198: astore_3
    //   199: aload_1
    //   200: astore_2
    //   201: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +37 -> 241
    //   207: aload_0
    //   208: astore_3
    //   209: aload_1
    //   210: astore_2
    //   211: ldc 18
    //   213: iconst_2
    //   214: new 146	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 383
    //   224: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 4
    //   229: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   232: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 377	java/io/FileInputStream:close	()V
    //   249: aload_0
    //   250: ifnull +120 -> 370
    //   253: aload_0
    //   254: invokevirtual 378	java/io/ObjectInputStream:close	()V
    //   257: aconst_null
    //   258: astore_0
    //   259: goto -104 -> 155
    //   262: astore_1
    //   263: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq -17 -> 249
    //   269: aload_1
    //   270: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   273: goto -24 -> 249
    //   276: astore_0
    //   277: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +7 -> 287
    //   283: aload_0
    //   284: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   287: aconst_null
    //   288: astore_0
    //   289: goto -134 -> 155
    //   292: astore_0
    //   293: aconst_null
    //   294: astore_3
    //   295: aconst_null
    //   296: astore_1
    //   297: aload_1
    //   298: ifnull +7 -> 305
    //   301: aload_1
    //   302: invokevirtual 377	java/io/FileInputStream:close	()V
    //   305: aload_3
    //   306: ifnull +7 -> 313
    //   309: aload_3
    //   310: invokevirtual 378	java/io/ObjectInputStream:close	()V
    //   313: aload_0
    //   314: athrow
    //   315: astore_1
    //   316: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq -14 -> 305
    //   322: aload_1
    //   323: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   326: goto -21 -> 305
    //   329: astore_1
    //   330: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq -20 -> 313
    //   336: aload_1
    //   337: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   340: goto -27 -> 313
    //   343: astore_0
    //   344: aconst_null
    //   345: astore_3
    //   346: goto -49 -> 297
    //   349: astore_0
    //   350: aload_2
    //   351: astore_1
    //   352: goto -55 -> 297
    //   355: astore 4
    //   357: aconst_null
    //   358: astore_0
    //   359: goto -162 -> 197
    //   362: astore 4
    //   364: aload 5
    //   366: astore_0
    //   367: goto -170 -> 197
    //   370: aconst_null
    //   371: astore_0
    //   372: goto -217 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramString	String
    //   98	38	1	localFileInputStream	java.io.FileInputStream
    //   171	11	1	localIOException1	java.io.IOException
    //   196	50	1	localObject1	Object
    //   262	8	1	localIOException2	java.io.IOException
    //   296	6	1	localObject2	Object
    //   315	8	1	localIOException3	java.io.IOException
    //   329	8	1	localIOException4	java.io.IOException
    //   351	1	1	localObject3	Object
    //   120	231	2	localObject4	Object
    //   118	228	3	localObject5	Object
    //   129	57	4	localAVRedPacketConfig	AVRedPacketConfig
    //   191	37	4	localException1	Exception
    //   355	1	4	localException2	Exception
    //   362	1	4	localException3	Exception
    //   114	251	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   135	139	157	java/io/IOException
    //   147	152	171	java/io/IOException
    //   90	99	191	java/lang/Exception
    //   245	249	262	java/io/IOException
    //   253	257	276	java/io/IOException
    //   90	99	292	finally
    //   301	305	315	java/io/IOException
    //   309	313	329	java/io/IOException
    //   99	116	343	finally
    //   121	131	349	finally
    //   201	207	349	finally
    //   211	241	349	finally
    //   99	116	355	java/lang/Exception
    //   121	131	362	java/lang/Exception
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  /* Error */
  public void saveToFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +19 -> 25
    //   9: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 18
    //   17: iconst_2
    //   18: ldc_w 389
    //   21: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: return
    //   25: invokestatic 144	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: new 146	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   35: invokestatic 150	com/tencent/av/service/AVRedPacketConfig:getConfigPrefix	()Ljava/lang/String;
    //   38: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokevirtual 163	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   51: astore 8
    //   53: invokestatic 144	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: new 146	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   63: invokestatic 150	com/tencent/av/service/AVRedPacketConfig:getConfigPrefix	()Ljava/lang/String;
    //   66: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 391
    //   76: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 163	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   85: astore 9
    //   87: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +33 -> 123
    //   93: ldc 18
    //   95: iconst_2
    //   96: new 146	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 393
    //   106: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 8
    //   111: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   114: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 9
    //   125: invokevirtual 169	java/io/File:exists	()Z
    //   128: ifeq +9 -> 137
    //   131: aload 9
    //   133: invokevirtual 172	java/io/File:delete	()Z
    //   136: pop
    //   137: aload 9
    //   139: invokevirtual 396	java/io/File:createNewFile	()Z
    //   142: pop
    //   143: new 398	java/io/FileOutputStream
    //   146: dup
    //   147: aload 9
    //   149: invokespecial 399	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   152: astore_3
    //   153: new 401	java/io/BufferedOutputStream
    //   156: dup
    //   157: aload_3
    //   158: invokespecial 404	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   161: astore_1
    //   162: new 406	java/io/ObjectOutputStream
    //   165: dup
    //   166: aload_1
    //   167: invokespecial 407	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   170: astore 4
    //   172: aload_3
    //   173: astore 7
    //   175: aload_1
    //   176: astore 6
    //   178: aload 4
    //   180: astore 5
    //   182: aload 4
    //   184: aload_0
    //   185: invokevirtual 411	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   188: aload_3
    //   189: astore 7
    //   191: aload_1
    //   192: astore 6
    //   194: aload 4
    //   196: astore 5
    //   198: aload 4
    //   200: invokevirtual 414	java/io/ObjectOutputStream:flush	()V
    //   203: aload_3
    //   204: astore 7
    //   206: aload_1
    //   207: astore 6
    //   209: aload 4
    //   211: astore 5
    //   213: aload 8
    //   215: invokevirtual 169	java/io/File:exists	()Z
    //   218: ifeq +19 -> 237
    //   221: aload_3
    //   222: astore 7
    //   224: aload_1
    //   225: astore 6
    //   227: aload 4
    //   229: astore 5
    //   231: aload 8
    //   233: invokevirtual 172	java/io/File:delete	()Z
    //   236: pop
    //   237: aload_3
    //   238: astore 7
    //   240: aload_1
    //   241: astore 6
    //   243: aload 4
    //   245: astore 5
    //   247: aload 9
    //   249: aload 8
    //   251: invokevirtual 418	java/io/File:renameTo	(Ljava/io/File;)Z
    //   254: pop
    //   255: aload_3
    //   256: astore 7
    //   258: aload_1
    //   259: astore 6
    //   261: aload 4
    //   263: astore 5
    //   265: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +22 -> 290
    //   271: aload_3
    //   272: astore 7
    //   274: aload_1
    //   275: astore 6
    //   277: aload 4
    //   279: astore 5
    //   281: ldc 18
    //   283: iconst_2
    //   284: ldc_w 420
    //   287: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_3
    //   291: ifnull +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 421	java/io/FileOutputStream:close	()V
    //   298: aload_1
    //   299: ifnull +7 -> 306
    //   302: aload_1
    //   303: invokevirtual 422	java/io/BufferedOutputStream:close	()V
    //   306: aload 4
    //   308: ifnull -284 -> 24
    //   311: aload 4
    //   313: invokevirtual 423	java/io/ObjectOutputStream:close	()V
    //   316: return
    //   317: astore_1
    //   318: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq -297 -> 24
    //   324: aload_1
    //   325: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   328: return
    //   329: astore_2
    //   330: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq -35 -> 298
    //   336: aload_2
    //   337: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   340: goto -42 -> 298
    //   343: astore_1
    //   344: aload_1
    //   345: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   348: goto -42 -> 306
    //   351: astore 4
    //   353: aconst_null
    //   354: astore_3
    //   355: aconst_null
    //   356: astore_1
    //   357: aload 4
    //   359: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   362: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +33 -> 398
    //   368: ldc 18
    //   370: iconst_2
    //   371: new 146	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 425
    //   381: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 4
    //   386: invokevirtual 426	java/io/IOException:toString	()Ljava/lang/String;
    //   389: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload_3
    //   399: ifnull +7 -> 406
    //   402: aload_3
    //   403: invokevirtual 421	java/io/FileOutputStream:close	()V
    //   406: aload_2
    //   407: ifnull +7 -> 414
    //   410: aload_2
    //   411: invokevirtual 422	java/io/BufferedOutputStream:close	()V
    //   414: aload_1
    //   415: ifnull -391 -> 24
    //   418: aload_1
    //   419: invokevirtual 423	java/io/ObjectOutputStream:close	()V
    //   422: return
    //   423: astore_1
    //   424: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq -403 -> 24
    //   430: aload_1
    //   431: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   434: return
    //   435: astore_3
    //   436: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq -33 -> 406
    //   442: aload_3
    //   443: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   446: goto -40 -> 406
    //   449: astore_2
    //   450: aload_2
    //   451: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   454: goto -40 -> 414
    //   457: astore_2
    //   458: aconst_null
    //   459: astore 8
    //   461: aconst_null
    //   462: astore_3
    //   463: aconst_null
    //   464: astore_1
    //   465: aload 8
    //   467: astore 7
    //   469: aload_3
    //   470: astore 6
    //   472: aload_1
    //   473: astore 5
    //   475: ldc 18
    //   477: iconst_2
    //   478: new 146	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   485: ldc_w 428
    //   488: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload_2
    //   492: invokevirtual 431	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   495: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: aload 8
    //   506: ifnull +8 -> 514
    //   509: aload 8
    //   511: invokevirtual 421	java/io/FileOutputStream:close	()V
    //   514: aload_3
    //   515: ifnull +7 -> 522
    //   518: aload_3
    //   519: invokevirtual 422	java/io/BufferedOutputStream:close	()V
    //   522: aload_1
    //   523: ifnull -499 -> 24
    //   526: aload_1
    //   527: invokevirtual 423	java/io/ObjectOutputStream:close	()V
    //   530: return
    //   531: astore_1
    //   532: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq -511 -> 24
    //   538: aload_1
    //   539: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   542: return
    //   543: astore_2
    //   544: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq -33 -> 514
    //   550: aload_2
    //   551: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   554: goto -40 -> 514
    //   557: astore_2
    //   558: aload_2
    //   559: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   562: goto -40 -> 522
    //   565: astore_2
    //   566: aconst_null
    //   567: astore 4
    //   569: aconst_null
    //   570: astore_1
    //   571: aconst_null
    //   572: astore_3
    //   573: aload 4
    //   575: ifnull +8 -> 583
    //   578: aload 4
    //   580: invokevirtual 421	java/io/FileOutputStream:close	()V
    //   583: aload_1
    //   584: ifnull +7 -> 591
    //   587: aload_1
    //   588: invokevirtual 422	java/io/BufferedOutputStream:close	()V
    //   591: aload_3
    //   592: ifnull +7 -> 599
    //   595: aload_3
    //   596: invokevirtual 423	java/io/ObjectOutputStream:close	()V
    //   599: aload_2
    //   600: athrow
    //   601: astore 4
    //   603: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq -23 -> 583
    //   609: aload 4
    //   611: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   614: goto -31 -> 583
    //   617: astore_1
    //   618: aload_1
    //   619: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   622: goto -31 -> 591
    //   625: astore_1
    //   626: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   629: ifeq -30 -> 599
    //   632: aload_1
    //   633: invokevirtual 381	java/io/IOException:printStackTrace	()V
    //   636: goto -37 -> 599
    //   639: astore_2
    //   640: aconst_null
    //   641: astore_1
    //   642: aconst_null
    //   643: astore 5
    //   645: aload_3
    //   646: astore 4
    //   648: aload 5
    //   650: astore_3
    //   651: goto -78 -> 573
    //   654: astore_2
    //   655: aconst_null
    //   656: astore 5
    //   658: aload_3
    //   659: astore 4
    //   661: aload 5
    //   663: astore_3
    //   664: goto -91 -> 573
    //   667: astore_2
    //   668: aload 7
    //   670: astore 4
    //   672: aload 6
    //   674: astore_1
    //   675: aload 5
    //   677: astore_3
    //   678: goto -105 -> 573
    //   681: astore 4
    //   683: aload_1
    //   684: astore 5
    //   686: aload_2
    //   687: astore_1
    //   688: aload 4
    //   690: astore_2
    //   691: aload_3
    //   692: astore 4
    //   694: aload 5
    //   696: astore_3
    //   697: goto -124 -> 573
    //   700: astore_2
    //   701: aconst_null
    //   702: astore 4
    //   704: aconst_null
    //   705: astore_1
    //   706: aload_3
    //   707: astore 8
    //   709: aload 4
    //   711: astore_3
    //   712: goto -247 -> 465
    //   715: astore_2
    //   716: aconst_null
    //   717: astore 4
    //   719: aload_3
    //   720: astore 8
    //   722: aload_1
    //   723: astore_3
    //   724: aload 4
    //   726: astore_1
    //   727: goto -262 -> 465
    //   730: astore_2
    //   731: aload_3
    //   732: astore 8
    //   734: aload_1
    //   735: astore_3
    //   736: aload 4
    //   738: astore_1
    //   739: goto -274 -> 465
    //   742: astore 4
    //   744: aconst_null
    //   745: astore_1
    //   746: goto -389 -> 357
    //   749: astore 4
    //   751: aconst_null
    //   752: astore 5
    //   754: aload_1
    //   755: astore_2
    //   756: aload 5
    //   758: astore_1
    //   759: goto -402 -> 357
    //   762: astore_2
    //   763: aload 4
    //   765: astore 5
    //   767: aload_2
    //   768: astore 4
    //   770: aload_1
    //   771: astore_2
    //   772: aload 5
    //   774: astore_1
    //   775: goto -418 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	778	0	this	AVRedPacketConfig
    //   0	778	1	paramString	String
    //   1	1	2	localObject1	Object
    //   329	82	2	localIOException1	java.io.IOException
    //   449	2	2	localIOException2	java.io.IOException
    //   457	35	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   543	8	2	localIOException3	java.io.IOException
    //   557	2	2	localIOException4	java.io.IOException
    //   565	35	2	localObject2	Object
    //   639	1	2	localObject3	Object
    //   654	1	2	localObject4	Object
    //   667	20	2	localObject5	Object
    //   690	1	2	localObject6	Object
    //   700	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   715	1	2	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   730	1	2	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   755	1	2	str1	String
    //   762	6	2	localIOException5	java.io.IOException
    //   771	1	2	str2	String
    //   152	251	3	localFileOutputStream	java.io.FileOutputStream
    //   435	8	3	localIOException6	java.io.IOException
    //   462	274	3	localObject7	Object
    //   170	142	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   351	34	4	localIOException7	java.io.IOException
    //   567	12	4	localObject8	Object
    //   601	9	4	localIOException8	java.io.IOException
    //   646	25	4	localObject9	Object
    //   681	8	4	localObject10	Object
    //   692	45	4	localObject11	Object
    //   742	1	4	localIOException9	java.io.IOException
    //   749	15	4	localIOException10	java.io.IOException
    //   768	1	4	localIOException11	java.io.IOException
    //   180	593	5	localObject12	Object
    //   176	497	6	localObject13	Object
    //   173	496	7	localObject14	Object
    //   51	682	8	localObject15	Object
    //   85	163	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   311	316	317	java/io/IOException
    //   294	298	329	java/io/IOException
    //   302	306	343	java/io/IOException
    //   137	153	351	java/io/IOException
    //   418	422	423	java/io/IOException
    //   402	406	435	java/io/IOException
    //   410	414	449	java/io/IOException
    //   137	153	457	java/lang/OutOfMemoryError
    //   526	530	531	java/io/IOException
    //   509	514	543	java/io/IOException
    //   518	522	557	java/io/IOException
    //   137	153	565	finally
    //   578	583	601	java/io/IOException
    //   587	591	617	java/io/IOException
    //   595	599	625	java/io/IOException
    //   153	162	639	finally
    //   162	172	654	finally
    //   182	188	667	finally
    //   198	203	667	finally
    //   213	221	667	finally
    //   231	237	667	finally
    //   247	255	667	finally
    //   265	271	667	finally
    //   281	290	667	finally
    //   475	504	667	finally
    //   357	398	681	finally
    //   153	162	700	java/lang/OutOfMemoryError
    //   162	172	715	java/lang/OutOfMemoryError
    //   182	188	730	java/lang/OutOfMemoryError
    //   198	203	730	java/lang/OutOfMemoryError
    //   213	221	730	java/lang/OutOfMemoryError
    //   231	237	730	java/lang/OutOfMemoryError
    //   247	255	730	java/lang/OutOfMemoryError
    //   265	271	730	java/lang/OutOfMemoryError
    //   281	290	730	java/lang/OutOfMemoryError
    //   153	162	742	java/io/IOException
    //   162	172	749	java/io/IOException
    //   182	188	762	java/io/IOException
    //   198	203	762	java/io/IOException
    //   213	221	762	java/io/IOException
    //   231	237	762	java/io/IOException
    //   247	255	762	java/io/IOException
    //   265	271	762	java/io/IOException
    //   281	290	762	java/io/IOException
  }
  
  public String toString()
  {
    return "AVRedPacketConfig{ version=" + this.version + " gameExpressionCount=" + this.gameExpressionCount + " gameMaxScore=" + this.gameMaxScore + " continuousHitCount=" + this.continuousHitCount + ", mainSwitch=" + this.mainSwitch + ", checkEyeOpenClose=" + this.checkEyeOpenClose + ", checkNormalFaceExpression=" + this.checkNormalFaceExpression + ", uploadUserExpression=" + this.uploadUserExpression + ", tipsTimeout=" + this.tipsTimeout + ", gameSendRedBagMaxTimeOut=" + this.gameSendRedBagMaxTimeOut + ", game321MaxTimeOut=" + this.game321MaxTimeOut + ", resMD5='" + this.resMD5 + '\'' + ", resURL='" + this.resURL + '\'' + ", musicResUrl='" + this.musicResUrl + '\'' + ", musicResMd5='" + this.musicResMd5 + '\'' + ", expressionInfoList=" + this.expressionInfoList + ", gameExpressionIDList=" + this.gameExpressionIDList + ", gameExpressionDurationList=" + this.gameExpressionDurationList + ", shareExpressionIDList=" + this.shareExpressionIDList + ", operatingEntrance[" + this.operatingEntranceBeginTime + "->" + this.operatingEntranceEndTime + "]" + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.gameExpressionCount);
    paramParcel.writeInt(this.gameMaxScore);
    paramParcel.writeInt(this.continuousHitCount);
    if (this.mainSwitch)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.checkEyeOpenClose) {
        break label204;
      }
      paramInt = 1;
      label58:
      paramParcel.writeByte((byte)paramInt);
      if (!this.checkNormalFaceExpression) {
        break label209;
      }
      paramInt = 1;
      label73:
      paramParcel.writeByte((byte)paramInt);
      if (!this.uploadUserExpression) {
        break label214;
      }
    }
    label204:
    label209:
    label214:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.tipsTimeout);
      paramParcel.writeLong(this.gameSendRedBagMaxTimeOut);
      paramParcel.writeLong(this.game321MaxTimeOut);
      paramParcel.writeLong(this.operatingEntranceBeginTime);
      paramParcel.writeLong(this.operatingEntranceEndTime);
      paramParcel.writeString(this.resURL);
      paramParcel.writeString(this.resMD5);
      paramParcel.writeString(this.musicResUrl);
      paramParcel.writeString(this.musicResMd5);
      paramParcel.writeTypedList(this.expressionInfoList);
      paramParcel.writeList(this.gameExpressionIDList);
      paramParcel.writeList(this.gameExpressionDurationList);
      paramParcel.writeList(this.shareExpressionIDList);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label58;
      paramInt = 0;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.service.AVRedPacketConfig
 * JD-Core Version:    0.7.0.1
 */