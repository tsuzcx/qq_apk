package com.qq.im.poi;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class LbsPackConfig
  implements Serializable
{
  public int allFriend;
  private ArrayList greetings;
  public String mQQTitle;
  public String mStructUrl;
  public String mWXTitle;
  public int packShow = 7;
  public int version;
  
  public static void deleteLocalConfig(String paramString)
  {
    paramString = BaseApplicationImpl.getContext().getFileStreamPath("lbspack_config_" + paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LbsPackConfig", 2, "deleteLocalConfig path:" + paramString.getAbsolutePath());
    }
  }
  
  public static LbsPackConfig parseConfig(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    LbsPackConfig localLbsPackConfig = new LbsPackConfig();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramString) {}
      int i = localXmlPullParser.next();
      break label499;
      paramString = localXmlPullParser.getName();
      if ("greeting".equals(paramString))
      {
        paramString = localXmlPullParser.nextText();
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        paramString = paramString.split("\\|\\|");
        if (paramString.length != 4) {
          continue;
        }
        l1 = PortalManager.a(paramString[0]);
        l2 = PortalManager.a(paramString[1]);
        l3 = Long.parseLong(paramString[2]);
        paramString = paramString[3];
        if (localLbsPackConfig.greetings == null) {
          localLbsPackConfig.greetings = new ArrayList(2);
        }
        localGreeting = new LbsPackConfig.Greeting(null);
        localGreeting.begin = l1;
        localGreeting.end = l2;
        localGreeting.limit = l3;
        localGreeting.msg = paramString;
        localLbsPackConfig.greetings.add(localGreeting);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("LbsPackConfig", 2, "parse exception:" + paramString.toString());
        return null;
      }
      bool = "allFriend".equals(paramString);
      if (bool)
      {
        try
        {
          localLbsPackConfig.allFriend = Integer.parseInt(localXmlPullParser.nextText());
        }
        catch (Exception paramString) {}
        if (QLog.isColorLevel()) {
          QLog.d("LbsPackConfig", 2, "parseInt allFriend exception:" + paramString.toString());
        }
      }
      else if ("structUrl".equals(paramString))
      {
        localLbsPackConfig.mStructUrl = localXmlPullParser.nextText();
      }
      else if ("qqTitle".equals(paramString))
      {
        localLbsPackConfig.mQQTitle = localXmlPullParser.nextText();
      }
      else if ("wxTitle".equals(paramString))
      {
        localLbsPackConfig.mWXTitle = localXmlPullParser.nextText();
      }
      else
      {
        bool = "packShow".equals(paramString);
        if (bool)
        {
          try
          {
            paramString = localXmlPullParser.nextText();
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            localLbsPackConfig.packShow = Integer.parseInt(paramString);
          }
          catch (Exception paramString) {}
          if (QLog.isColorLevel())
          {
            QLog.d("LbsPackConfig", 2, "parseInt packShow exception:" + paramString.toString());
            label499:
            while (i == 1)
            {
              long l1;
              long l2;
              long l3;
              LbsPackConfig.Greeting localGreeting;
              boolean bool;
              if (QLog.isColorLevel()) {
                QLog.d("LbsPackConfig", 2, "parse:" + localLbsPackConfig);
              }
              return localLbsPackConfig;
            }
            switch (i)
            {
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public static LbsPackConfig readFromFile(String paramString)
  {
    // Byte code:
    //   0: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 66
    //   8: iconst_2
    //   9: ldc 214
    //   11: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +19 -> 37
    //   21: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +11 -> 35
    //   27: ldc 66
    //   29: iconst_2
    //   30: ldc 216
    //   32: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aconst_null
    //   36: areturn
    //   37: invokestatic 31	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   40: new 33	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   47: ldc 36
    //   49: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 50	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 56	java/io/File:exists	()Z
    //   67: ifne +19 -> 86
    //   70: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -38 -> 35
    //   76: ldc 66
    //   78: iconst_2
    //   79: ldc 218
    //   81: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aconst_null
    //   85: areturn
    //   86: new 220	java/io/FileInputStream
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: astore_1
    //   95: new 225	java/io/ObjectInputStream
    //   98: dup
    //   99: new 227	java/io/BufferedInputStream
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 230	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: invokespecial 231	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   110: astore 5
    //   112: aload 5
    //   114: astore_3
    //   115: aload_1
    //   116: astore_2
    //   117: aload 5
    //   119: invokevirtual 235	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   122: checkcast 2	com/qq/im/poi/LbsPackConfig
    //   125: astore 4
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 238	java/io/FileInputStream:close	()V
    //   135: aload 4
    //   137: astore_0
    //   138: aload 5
    //   140: ifnull +11 -> 151
    //   143: aload 5
    //   145: invokevirtual 239	java/io/ObjectInputStream:close	()V
    //   148: aload 4
    //   150: astore_0
    //   151: aload_0
    //   152: areturn
    //   153: astore_0
    //   154: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq -22 -> 135
    //   160: aload_0
    //   161: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   164: goto -29 -> 135
    //   167: astore_1
    //   168: aload 4
    //   170: astore_0
    //   171: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -23 -> 151
    //   177: aload_1
    //   178: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   181: aload 4
    //   183: astore_0
    //   184: goto -33 -> 151
    //   187: astore 4
    //   189: aconst_null
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_0
    //   194: astore_3
    //   195: aload_1
    //   196: astore_2
    //   197: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +17 -> 217
    //   203: aload_0
    //   204: astore_3
    //   205: aload_1
    //   206: astore_2
    //   207: ldc 66
    //   209: iconst_2
    //   210: ldc 244
    //   212: aload 4
    //   214: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 238	java/io/FileInputStream:close	()V
    //   225: aload_0
    //   226: ifnull +120 -> 346
    //   229: aload_0
    //   230: invokevirtual 239	java/io/ObjectInputStream:close	()V
    //   233: aconst_null
    //   234: astore_0
    //   235: goto -84 -> 151
    //   238: astore_1
    //   239: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq -17 -> 225
    //   245: aload_1
    //   246: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   249: goto -24 -> 225
    //   252: astore_0
    //   253: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +7 -> 263
    //   259: aload_0
    //   260: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   263: aconst_null
    //   264: astore_0
    //   265: goto -114 -> 151
    //   268: astore_0
    //   269: aconst_null
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_1
    //   273: aload_1
    //   274: ifnull +7 -> 281
    //   277: aload_1
    //   278: invokevirtual 238	java/io/FileInputStream:close	()V
    //   281: aload_3
    //   282: ifnull +7 -> 289
    //   285: aload_3
    //   286: invokevirtual 239	java/io/ObjectInputStream:close	()V
    //   289: aload_0
    //   290: athrow
    //   291: astore_1
    //   292: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq -14 -> 281
    //   298: aload_1
    //   299: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   302: goto -21 -> 281
    //   305: astore_1
    //   306: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq -20 -> 289
    //   312: aload_1
    //   313: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   316: goto -27 -> 289
    //   319: astore_0
    //   320: aconst_null
    //   321: astore_3
    //   322: goto -49 -> 273
    //   325: astore_0
    //   326: aload_2
    //   327: astore_1
    //   328: goto -55 -> 273
    //   331: astore 4
    //   333: aconst_null
    //   334: astore_0
    //   335: goto -142 -> 193
    //   338: astore 4
    //   340: aload 5
    //   342: astore_0
    //   343: goto -150 -> 193
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -197 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramString	String
    //   94	38	1	localFileInputStream	java.io.FileInputStream
    //   167	11	1	localIOException1	java.io.IOException
    //   192	30	1	localObject1	Object
    //   238	8	1	localIOException2	java.io.IOException
    //   272	6	1	localObject2	Object
    //   291	8	1	localIOException3	java.io.IOException
    //   305	8	1	localIOException4	java.io.IOException
    //   327	1	1	localObject3	Object
    //   116	211	2	localObject4	Object
    //   114	208	3	localObject5	Object
    //   125	57	4	localLbsPackConfig	LbsPackConfig
    //   187	26	4	localException1	Exception
    //   331	1	4	localException2	Exception
    //   338	1	4	localException3	Exception
    //   110	231	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   131	135	153	java/io/IOException
    //   143	148	167	java/io/IOException
    //   86	95	187	java/lang/Exception
    //   221	225	238	java/io/IOException
    //   229	233	252	java/io/IOException
    //   86	95	268	finally
    //   277	281	291	java/io/IOException
    //   285	289	305	java/io/IOException
    //   95	112	319	finally
    //   117	127	325	finally
    //   197	203	325	finally
    //   207	217	325	finally
    //   95	112	331	java/lang/Exception
    //   117	127	338	java/lang/Exception
  }
  
  public String getGreeting(long paramLong)
  {
    Object localObject = null;
    String str1 = null;
    int i;
    if (this.greetings != null)
    {
      int j = this.greetings.size();
      i = 0;
      localObject = str1;
      if (i < j)
      {
        localObject = (LbsPackConfig.Greeting)this.greetings.get(i);
        if ((paramLong < ((LbsPackConfig.Greeting)localObject).begin) || (paramLong >= ((LbsPackConfig.Greeting)localObject).end)) {
          break label184;
        }
        SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("lbs_data_perf", 0);
        String str2 = "lbs_greet_cnt_" + ((LbsPackConfig.Greeting)localObject).begin + "_" + ((LbsPackConfig.Greeting)localObject).end;
        int k = localSharedPreferences.getInt(str2, 0);
        if (k >= ((LbsPackConfig.Greeting)localObject).limit) {
          break label184;
        }
        localSharedPreferences.edit().putInt(str2, k + 1).commit();
        str1 = ((LbsPackConfig.Greeting)localObject).msg;
      }
    }
    label184:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  /* Error */
  public void saveToFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +19 -> 25
    //   9: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 66
    //   17: iconst_2
    //   18: ldc_w 295
    //   21: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: return
    //   25: invokestatic 31	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: new 33	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   35: ldc 36
    //   37: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 50	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   50: astore 5
    //   52: invokestatic 31	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: new 33	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   62: ldc 36
    //   64: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 297
    //   74: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokevirtual 50	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   83: astore_1
    //   84: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +33 -> 120
    //   90: ldc 66
    //   92: iconst_2
    //   93: new 33	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 299
    //   103: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 5
    //   108: invokevirtual 71	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_1
    //   121: invokevirtual 56	java/io/File:exists	()Z
    //   124: ifeq +8 -> 132
    //   127: aload_1
    //   128: invokevirtual 59	java/io/File:delete	()Z
    //   131: pop
    //   132: aload_1
    //   133: invokevirtual 302	java/io/File:createNewFile	()Z
    //   136: pop
    //   137: new 304	java/io/FileOutputStream
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 305	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   145: astore 4
    //   147: new 307	java/io/BufferedOutputStream
    //   150: dup
    //   151: aload 4
    //   153: invokespecial 310	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   156: astore_3
    //   157: new 312	java/io/ObjectOutputStream
    //   160: dup
    //   161: aload_3
    //   162: invokespecial 313	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   165: astore_2
    //   166: aload_2
    //   167: aload_0
    //   168: invokevirtual 317	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   171: aload_2
    //   172: invokevirtual 320	java/io/ObjectOutputStream:flush	()V
    //   175: aload 5
    //   177: invokevirtual 56	java/io/File:exists	()Z
    //   180: ifeq +9 -> 189
    //   183: aload 5
    //   185: invokevirtual 59	java/io/File:delete	()Z
    //   188: pop
    //   189: aload_1
    //   190: aload 5
    //   192: invokevirtual 324	java/io/File:renameTo	(Ljava/io/File;)Z
    //   195: pop
    //   196: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +12 -> 211
    //   202: ldc 66
    //   204: iconst_2
    //   205: ldc_w 326
    //   208: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload 4
    //   213: ifnull +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 327	java/io/FileOutputStream:close	()V
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 328	java/io/ObjectOutputStream:close	()V
    //   229: aload_3
    //   230: ifnull -206 -> 24
    //   233: aload_3
    //   234: invokevirtual 329	java/io/BufferedOutputStream:close	()V
    //   237: return
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   243: return
    //   244: astore_1
    //   245: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -27 -> 221
    //   251: aload_1
    //   252: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   255: goto -34 -> 221
    //   258: astore_1
    //   259: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq -33 -> 229
    //   265: aload_1
    //   266: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   269: goto -40 -> 229
    //   272: astore_3
    //   273: aconst_null
    //   274: astore 4
    //   276: aconst_null
    //   277: astore_1
    //   278: aload_3
    //   279: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   282: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +13 -> 298
    //   288: ldc 66
    //   290: iconst_2
    //   291: ldc_w 331
    //   294: aload_3
    //   295: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   298: aload 4
    //   300: ifnull +8 -> 308
    //   303: aload 4
    //   305: invokevirtual 327	java/io/FileOutputStream:close	()V
    //   308: aload_1
    //   309: ifnull +7 -> 316
    //   312: aload_1
    //   313: invokevirtual 328	java/io/ObjectOutputStream:close	()V
    //   316: aload_2
    //   317: ifnull -293 -> 24
    //   320: aload_2
    //   321: invokevirtual 329	java/io/BufferedOutputStream:close	()V
    //   324: return
    //   325: astore_1
    //   326: aload_1
    //   327: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   330: return
    //   331: astore_3
    //   332: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq -27 -> 308
    //   338: aload_3
    //   339: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   342: goto -34 -> 308
    //   345: astore_1
    //   346: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq -33 -> 316
    //   352: aload_1
    //   353: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   356: goto -40 -> 316
    //   359: astore_1
    //   360: aconst_null
    //   361: astore 4
    //   363: aconst_null
    //   364: astore_3
    //   365: aconst_null
    //   366: astore_2
    //   367: aload 4
    //   369: ifnull +8 -> 377
    //   372: aload 4
    //   374: invokevirtual 327	java/io/FileOutputStream:close	()V
    //   377: aload_2
    //   378: ifnull +7 -> 385
    //   381: aload_2
    //   382: invokevirtual 328	java/io/ObjectOutputStream:close	()V
    //   385: aload_3
    //   386: ifnull +7 -> 393
    //   389: aload_3
    //   390: invokevirtual 329	java/io/BufferedOutputStream:close	()V
    //   393: aload_1
    //   394: athrow
    //   395: astore 4
    //   397: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq -23 -> 377
    //   403: aload 4
    //   405: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   408: goto -31 -> 377
    //   411: astore_2
    //   412: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq -30 -> 385
    //   418: aload_2
    //   419: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   422: goto -37 -> 385
    //   425: astore_2
    //   426: aload_2
    //   427: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   430: goto -37 -> 393
    //   433: astore_1
    //   434: aconst_null
    //   435: astore_3
    //   436: aconst_null
    //   437: astore_2
    //   438: goto -71 -> 367
    //   441: astore_1
    //   442: aconst_null
    //   443: astore_2
    //   444: goto -77 -> 367
    //   447: astore_1
    //   448: goto -81 -> 367
    //   451: astore_3
    //   452: aload_1
    //   453: astore 5
    //   455: aload_3
    //   456: astore_1
    //   457: aload_2
    //   458: astore_3
    //   459: aload 5
    //   461: astore_2
    //   462: goto -95 -> 367
    //   465: astore_3
    //   466: aconst_null
    //   467: astore_1
    //   468: goto -190 -> 278
    //   471: astore 5
    //   473: aconst_null
    //   474: astore_1
    //   475: aload_3
    //   476: astore_2
    //   477: aload 5
    //   479: astore_3
    //   480: goto -202 -> 278
    //   483: astore 6
    //   485: aload_3
    //   486: astore_1
    //   487: aload_2
    //   488: astore 5
    //   490: aload 6
    //   492: astore_3
    //   493: aload_1
    //   494: astore_2
    //   495: aload 5
    //   497: astore_1
    //   498: goto -220 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	LbsPackConfig
    //   0	501	1	paramString	String
    //   1	381	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   411	8	2	localIOException1	java.io.IOException
    //   425	2	2	localIOException2	java.io.IOException
    //   437	58	2	localObject1	Object
    //   156	78	3	localBufferedOutputStream	java.io.BufferedOutputStream
    //   272	23	3	localIOException3	java.io.IOException
    //   331	8	3	localIOException4	java.io.IOException
    //   364	72	3	localObject2	Object
    //   451	5	3	localObject3	Object
    //   458	1	3	localObject4	Object
    //   465	11	3	localIOException5	java.io.IOException
    //   479	14	3	localObject5	Object
    //   145	228	4	localFileOutputStream	java.io.FileOutputStream
    //   395	9	4	localIOException6	java.io.IOException
    //   50	410	5	localObject6	Object
    //   471	7	5	localIOException7	java.io.IOException
    //   488	8	5	localObject7	Object
    //   483	8	6	localIOException8	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   233	237	238	java/io/IOException
    //   216	221	244	java/io/IOException
    //   225	229	258	java/io/IOException
    //   132	147	272	java/io/IOException
    //   320	324	325	java/io/IOException
    //   303	308	331	java/io/IOException
    //   312	316	345	java/io/IOException
    //   132	147	359	finally
    //   372	377	395	java/io/IOException
    //   381	385	411	java/io/IOException
    //   389	393	425	java/io/IOException
    //   147	157	433	finally
    //   157	166	441	finally
    //   166	189	447	finally
    //   189	211	447	finally
    //   278	298	451	finally
    //   147	157	465	java/io/IOException
    //   157	166	471	java/io/IOException
    //   166	189	483	java/io/IOException
    //   189	211	483	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackConfig
 * JD-Core Version:    0.7.0.1
 */