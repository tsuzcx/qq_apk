package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class NearbyGrayTipsManager
  implements Manager
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<NearbyGrayTipsManager.GrayTipsConfig> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<NearbyGrayTipsManager.GreetWording> jdField_a_of_type_JavaUtilList = null;
  private Random jdField_a_of_type_JavaUtilRandom;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private List<NearbyGrayTipsManager.FaceScoreWording> jdField_b_of_type_JavaUtilList = null;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private List<NearbyGrayTipsManager.GrayTipStatisticData> jdField_c_of_type_JavaUtilList = null;
  private int d;
  
  public NearbyGrayTipsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(2);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(2);
    this.jdField_c_of_type_JavaUtilList = new ArrayList(2);
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_JavaUtilRandom.setSeed(System.currentTimeMillis());
  }
  
  private NearbyGrayTipsManager.FaceScoreWording a(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getFaceScoreWordingById id= ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject1).toString());
    }
    int i;
    label167:
    Object localObject3;
    label170:
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      int j = this.jdField_b_of_type_JavaUtilList.size();
      i = 0;
      localObject1 = null;
      if (i < j)
      {
        localObject1 = (NearbyGrayTipsManager.FaceScoreWording)this.jdField_b_of_type_JavaUtilList.get(i);
        if (localObject1 == null) {
          break label170;
        }
        if (((NearbyGrayTipsManager.FaceScoreWording)localObject1).id != paramInt) {
          break label167;
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("getFaceScoreWordingById return faceScoreWording= ");
        ((StringBuilder)???).append(localObject1);
        QLog.d("Q..troop.faceScore", 2, ((StringBuilder)???).toString());
      }
      return localObject1;
    }
  }
  
  private NearbyGrayTipsManager.GrayTipsConfig a(int paramInt1, int paramInt2, int paramInt3, long paramLong, NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig = paramGrayTipsConfig;
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          do
          {
            localGrayTipsConfig = paramGrayTipsConfig;
            if (!localIterator.hasNext()) {
              break;
            }
            localGrayTipsConfig = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          } while ((localGrayTipsConfig == null) || (localGrayTipsConfig.sceneId != 3) || (localGrayTipsConfig.sceneThree == null) || (!localGrayTipsConfig.sceneThree.keywordTrigger) || (localGrayTipsConfig.sceneThree.keywords == null) || (localGrayTipsConfig.sceneThree.keywords.size() == 0) || (localGrayTipsConfig.sceneThree.whichSide == null) || (!localGrayTipsConfig.sceneThree.whichSide.contains(Integer.valueOf(paramInt3))) || (!localGrayTipsConfig.isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)));
          if ((paramGrayTipsConfig == null) || (paramGrayTipsConfig.priority < localGrayTipsConfig.priority)) {
            break label238;
          }
        } while ((paramGrayTipsConfig.priority != localGrayTipsConfig.priority) || (paramGrayTipsConfig.createTime >= localGrayTipsConfig.createTime));
      }
      else
      {
        return localGrayTipsConfig;
      }
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramGrayTipsConfig;
        }
        label238:
        paramGrayTipsConfig = localGrayTipsConfig;
      }
    }
  }
  
  private NearbyGrayTipsManager.GrayTipsConfig a(int paramInt1, int paramInt2, long paramLong, NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig = paramGrayTipsConfig;
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          do
          {
            localGrayTipsConfig = paramGrayTipsConfig;
            if (!localIterator.hasNext()) {
              break;
            }
            localGrayTipsConfig = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          } while ((localGrayTipsConfig == null) || (localGrayTipsConfig.sceneId != 2) || (localGrayTipsConfig.sceneTwo == null) || (!localGrayTipsConfig.sceneTwo.sayHiFrequencyControl) || (localGrayTipsConfig.sceneTwo.timeRange == 0) || (localGrayTipsConfig.sceneTwo.sayHiPeopleCount == 0) || (!localGrayTipsConfig.isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)));
          if ((paramGrayTipsConfig == null) || (paramGrayTipsConfig.priority < localGrayTipsConfig.priority)) {
            break label205;
          }
        } while ((paramGrayTipsConfig.priority != localGrayTipsConfig.priority) || (paramGrayTipsConfig.createTime >= localGrayTipsConfig.createTime));
      }
      else
      {
        return localGrayTipsConfig;
      }
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramGrayTipsConfig;
        }
        label205:
        paramGrayTipsConfig = localGrayTipsConfig;
      }
    }
  }
  
  /* Error */
  public static NearbyGrayTipsManager.GrayTipsConfig a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnull +533 -> 540
    //   10: aload_0
    //   11: invokevirtual 189	java/io/File:exists	()Z
    //   14: ifne +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: new 67	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   26: astore 8
    //   28: new 191	java/io/FileReader
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 194	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   36: astore_0
    //   37: new 196	java/io/BufferedReader
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 199	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_3
    //   46: aload_0
    //   47: astore_1
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: invokevirtual 202	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 4
    //   56: aload 4
    //   58: ifnull +18 -> 76
    //   61: aload_0
    //   62: astore_1
    //   63: aload_3
    //   64: astore_2
    //   65: aload 8
    //   67: aload 4
    //   69: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: goto -27 -> 46
    //   76: aload_3
    //   77: invokevirtual 205	java/io/BufferedReader:close	()V
    //   80: goto +8 -> 88
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   88: aload_0
    //   89: invokevirtual 209	java/io/FileReader:close	()V
    //   92: goto +206 -> 298
    //   95: astore 5
    //   97: aload_0
    //   98: astore 4
    //   100: aload_3
    //   101: astore_0
    //   102: goto +58 -> 160
    //   105: astore 5
    //   107: aload_0
    //   108: astore 4
    //   110: aload_3
    //   111: astore_0
    //   112: goto +118 -> 230
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_2
    //   118: goto +388 -> 506
    //   121: astore 5
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_0
    //   126: astore 4
    //   128: aload_1
    //   129: astore_0
    //   130: goto +30 -> 160
    //   133: astore 5
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_0
    //   138: astore 4
    //   140: aload_1
    //   141: astore_0
    //   142: goto +88 -> 230
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_2
    //   149: astore_0
    //   150: goto +356 -> 506
    //   153: astore 5
    //   155: aconst_null
    //   156: astore_0
    //   157: aload_0
    //   158: astore 4
    //   160: aload 4
    //   162: astore_1
    //   163: aload_0
    //   164: astore_2
    //   165: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +16 -> 184
    //   171: aload 4
    //   173: astore_1
    //   174: aload_0
    //   175: astore_2
    //   176: ldc 211
    //   178: iconst_2
    //   179: ldc 213
    //   181: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 4
    //   186: astore_1
    //   187: aload_0
    //   188: astore_2
    //   189: aload 5
    //   191: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   194: aload_0
    //   195: ifnull +15 -> 210
    //   198: aload_0
    //   199: invokevirtual 205	java/io/BufferedReader:close	()V
    //   202: goto +8 -> 210
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   210: aload 4
    //   212: ifnull +86 -> 298
    //   215: aload 4
    //   217: invokevirtual 209	java/io/FileReader:close	()V
    //   220: goto +78 -> 298
    //   223: astore 5
    //   225: aconst_null
    //   226: astore_0
    //   227: aload_0
    //   228: astore 4
    //   230: aload 4
    //   232: astore_1
    //   233: aload_0
    //   234: astore_2
    //   235: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +16 -> 254
    //   241: aload 4
    //   243: astore_1
    //   244: aload_0
    //   245: astore_2
    //   246: ldc 211
    //   248: iconst_2
    //   249: ldc 215
    //   251: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload 4
    //   256: astore_1
    //   257: aload_0
    //   258: astore_2
    //   259: aload 5
    //   261: invokevirtual 216	java/io/FileNotFoundException:printStackTrace	()V
    //   264: aload_0
    //   265: ifnull +15 -> 280
    //   268: aload_0
    //   269: invokevirtual 205	java/io/BufferedReader:close	()V
    //   272: goto +8 -> 280
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   280: aload 4
    //   282: ifnull +16 -> 298
    //   285: aload 4
    //   287: invokevirtual 209	java/io/FileReader:close	()V
    //   290: goto +8 -> 298
    //   293: astore_0
    //   294: aload_0
    //   295: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   298: aload 7
    //   300: astore_0
    //   301: aload 8
    //   303: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   306: ifle +193 -> 499
    //   309: new 221	org/json/JSONObject
    //   312: dup
    //   313: aload 8
    //   315: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokespecial 224	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   321: astore_1
    //   322: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +34 -> 359
    //   328: new 67	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   335: astore_0
    //   336: aload_0
    //   337: ldc 226
    //   339: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_0
    //   344: aload_1
    //   345: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: ldc 211
    //   351: iconst_2
    //   352: aload_0
    //   353: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: new 123	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig
    //   362: dup
    //   363: invokespecial 227	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:<init>	()V
    //   366: astore_0
    //   367: aload_0
    //   368: aload_1
    //   369: invokestatic 231	com/tencent/mobileqq/app/NearbyGrayTipsManager:l	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   372: aload_1
    //   373: ldc 233
    //   375: invokevirtual 237	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   378: ifne +65 -> 443
    //   381: aload_1
    //   382: ldc 233
    //   384: invokevirtual 241	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   387: astore_1
    //   388: aload_0
    //   389: aload_1
    //   390: invokestatic 244	com/tencent/mobileqq/app/NearbyGrayTipsManager:k	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   393: aload_0
    //   394: aload_1
    //   395: invokestatic 247	com/tencent/mobileqq/app/NearbyGrayTipsManager:j	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   398: aload_0
    //   399: aload_1
    //   400: invokestatic 250	com/tencent/mobileqq/app/NearbyGrayTipsManager:i	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   403: aload_0
    //   404: aload_1
    //   405: invokestatic 253	com/tencent/mobileqq/app/NearbyGrayTipsManager:h	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   408: aload_0
    //   409: aload_1
    //   410: invokestatic 256	com/tencent/mobileqq/app/NearbyGrayTipsManager:g	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   413: aload_0
    //   414: aload_1
    //   415: invokestatic 259	com/tencent/mobileqq/app/NearbyGrayTipsManager:f	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   418: aload_0
    //   419: aload_1
    //   420: invokestatic 262	com/tencent/mobileqq/app/NearbyGrayTipsManager:e	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   423: aload_0
    //   424: aload_1
    //   425: invokestatic 264	com/tencent/mobileqq/app/NearbyGrayTipsManager:d	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   428: aload_0
    //   429: aload_1
    //   430: invokestatic 266	com/tencent/mobileqq/app/NearbyGrayTipsManager:c	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   433: aload_0
    //   434: aload_1
    //   435: invokestatic 268	com/tencent/mobileqq/app/NearbyGrayTipsManager:b	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   438: aload_0
    //   439: aload_1
    //   440: invokestatic 270	com/tencent/mobileqq/app/NearbyGrayTipsManager:a	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   443: aload_0
    //   444: areturn
    //   445: astore_1
    //   446: goto +7 -> 453
    //   449: astore_1
    //   450: aload 6
    //   452: astore_0
    //   453: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +39 -> 495
    //   459: new 67	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   466: astore_2
    //   467: aload_2
    //   468: ldc_w 272
    //   471: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_2
    //   476: aload 8
    //   478: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: ldc 211
    //   487: iconst_2
    //   488: aload_2
    //   489: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: aload_1
    //   496: invokevirtual 273	org/json/JSONException:printStackTrace	()V
    //   499: aload_0
    //   500: areturn
    //   501: astore_3
    //   502: aload_1
    //   503: astore_0
    //   504: aload_3
    //   505: astore_1
    //   506: aload_2
    //   507: ifnull +15 -> 522
    //   510: aload_2
    //   511: invokevirtual 205	java/io/BufferedReader:close	()V
    //   514: goto +8 -> 522
    //   517: astore_2
    //   518: aload_2
    //   519: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   522: aload_0
    //   523: ifnull +15 -> 538
    //   526: aload_0
    //   527: invokevirtual 209	java/io/FileReader:close	()V
    //   530: goto +8 -> 538
    //   533: astore_0
    //   534: aload_0
    //   535: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   538: aload_1
    //   539: athrow
    //   540: aconst_null
    //   541: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	542	0	paramFile	File
    //   47	16	1	localFile	File
    //   83	2	1	localIOException1	java.io.IOException
    //   115	1	1	localObject1	Object
    //   124	17	1	localObject2	Object
    //   145	1	1	localObject3	Object
    //   162	278	1	localObject4	Object
    //   445	1	1	localJSONException1	org.json.JSONException
    //   449	54	1	localJSONException2	org.json.JSONException
    //   505	34	1	localObject5	Object
    //   49	462	2	localObject6	Object
    //   517	2	2	localIOException2	java.io.IOException
    //   45	66	3	localBufferedReader	java.io.BufferedReader
    //   501	4	3	localObject7	Object
    //   54	232	4	localObject8	Object
    //   95	1	5	localIOException3	java.io.IOException
    //   105	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   121	1	5	localIOException4	java.io.IOException
    //   133	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   153	37	5	localIOException5	java.io.IOException
    //   223	37	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   4	447	6	localObject9	Object
    //   1	298	7	localObject10	Object
    //   26	451	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   76	80	83	java/io/IOException
    //   50	56	95	java/io/IOException
    //   65	73	95	java/io/IOException
    //   50	56	105	java/io/FileNotFoundException
    //   65	73	105	java/io/FileNotFoundException
    //   37	46	115	finally
    //   37	46	121	java/io/IOException
    //   37	46	133	java/io/FileNotFoundException
    //   28	37	145	finally
    //   28	37	153	java/io/IOException
    //   198	202	205	java/io/IOException
    //   28	37	223	java/io/FileNotFoundException
    //   268	272	275	java/io/IOException
    //   88	92	293	java/io/IOException
    //   215	220	293	java/io/IOException
    //   285	290	293	java/io/IOException
    //   367	443	445	org/json/JSONException
    //   309	359	449	org/json/JSONException
    //   359	367	449	org/json/JSONException
    //   50	56	501	finally
    //   65	73	501	finally
    //   165	171	501	finally
    //   176	184	501	finally
    //   189	194	501	finally
    //   235	241	501	finally
    //   246	254	501	finally
    //   259	264	501	finally
    //   510	514	517	java/io/IOException
    //   526	530	533	java/io/IOException
  }
  
  private NearbyGrayTipsManager.GrayTipsConfig a(String paramString, NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig)
  {
    if (paramGrayTipsConfig != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      int i = 0;
      while ((i < paramGrayTipsConfig.sceneThree.keywords.size()) && (paramString.indexOf((String)paramGrayTipsConfig.sceneThree.keywords.get(i)) < 0)) {
        i += 1;
      }
      if (i == paramGrayTipsConfig.sceneThree.keywords.size()) {
        return null;
      }
    }
    return paramGrayTipsConfig;
  }
  
  private NearbyGrayTipsManager.GreetWording a(int paramInt)
  {
    int i;
    label84:
    Object localObject2;
    label87:
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      NearbyGrayTipsManager.GreetWording localGreetWording = null;
      if (i < j)
      {
        localGreetWording = (NearbyGrayTipsManager.GreetWording)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localGreetWording == null) {
          break label87;
        }
        if (localGreetWording.id != paramInt) {
          break label84;
        }
      }
      return localGreetWording;
    }
  }
  
  /* Error */
  public static Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 7
    //   11: new 296	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 297	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: new 299	java/io/BufferedInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 302	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_1
    //   29: new 304	java/io/ObjectInputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 305	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore 5
    //   39: aload_0
    //   40: astore 4
    //   42: aload 5
    //   44: astore_2
    //   45: aload_1
    //   46: astore_3
    //   47: aload 5
    //   49: invokevirtual 308	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   52: astore 6
    //   54: aload 6
    //   56: astore_2
    //   57: aload 5
    //   59: invokevirtual 309	java/io/ObjectInputStream:close	()V
    //   62: aload 6
    //   64: astore_2
    //   65: aload_1
    //   66: invokevirtual 310	java/io/BufferedInputStream:close	()V
    //   69: aload 6
    //   71: astore_2
    //   72: aload_0
    //   73: invokevirtual 311	java/io/FileInputStream:close	()V
    //   76: aload 6
    //   78: astore_2
    //   79: goto +363 -> 442
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   87: goto +355 -> 442
    //   90: astore_2
    //   91: aload_0
    //   92: astore 6
    //   94: aload 5
    //   96: astore_0
    //   97: aload_2
    //   98: astore 5
    //   100: goto +154 -> 254
    //   103: astore_2
    //   104: aload_0
    //   105: astore 6
    //   107: aload 5
    //   109: astore_0
    //   110: aload_2
    //   111: astore 5
    //   113: goto +208 -> 321
    //   116: astore_2
    //   117: aload_0
    //   118: astore 6
    //   120: aload 5
    //   122: astore_0
    //   123: aload_2
    //   124: astore 5
    //   126: goto +262 -> 388
    //   129: astore_2
    //   130: aload_0
    //   131: astore_3
    //   132: aload 4
    //   134: astore_0
    //   135: goto +375 -> 510
    //   138: astore 5
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_0
    //   143: astore 6
    //   145: aload_2
    //   146: astore_0
    //   147: goto +107 -> 254
    //   150: astore 5
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_0
    //   155: astore 6
    //   157: aload_2
    //   158: astore_0
    //   159: goto +162 -> 321
    //   162: astore 5
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_0
    //   167: astore 6
    //   169: aload_2
    //   170: astore_0
    //   171: goto +217 -> 388
    //   174: astore 4
    //   176: aload_0
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_3
    //   181: astore_0
    //   182: aload 4
    //   184: astore_3
    //   185: goto +333 -> 518
    //   188: astore 5
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore_2
    //   194: aload_0
    //   195: astore 6
    //   197: aload_2
    //   198: astore_0
    //   199: goto +55 -> 254
    //   202: astore 5
    //   204: aconst_null
    //   205: astore_1
    //   206: aload_1
    //   207: astore_2
    //   208: aload_0
    //   209: astore 6
    //   211: aload_2
    //   212: astore_0
    //   213: goto +108 -> 321
    //   216: astore 5
    //   218: aconst_null
    //   219: astore_1
    //   220: aload_1
    //   221: astore_2
    //   222: aload_0
    //   223: astore 6
    //   225: aload_2
    //   226: astore_0
    //   227: goto +161 -> 388
    //   230: astore 4
    //   232: aconst_null
    //   233: astore_1
    //   234: aload_1
    //   235: astore_2
    //   236: aload_3
    //   237: astore_0
    //   238: aload 4
    //   240: astore_3
    //   241: goto +277 -> 518
    //   244: astore 5
    //   246: aconst_null
    //   247: astore_1
    //   248: aload_1
    //   249: astore 6
    //   251: aload 6
    //   253: astore_0
    //   254: aload 6
    //   256: astore 4
    //   258: aload_0
    //   259: astore_2
    //   260: aload_1
    //   261: astore_3
    //   262: aload 5
    //   264: invokevirtual 312	java/lang/Exception:printStackTrace	()V
    //   267: aload_0
    //   268: ifnull +10 -> 278
    //   271: aload 7
    //   273: astore_2
    //   274: aload_0
    //   275: invokevirtual 309	java/io/ObjectInputStream:close	()V
    //   278: aload_1
    //   279: ifnull +10 -> 289
    //   282: aload 7
    //   284: astore_2
    //   285: aload_1
    //   286: invokevirtual 310	java/io/BufferedInputStream:close	()V
    //   289: aload 8
    //   291: astore_2
    //   292: aload 6
    //   294: ifnull +148 -> 442
    //   297: aload 7
    //   299: astore_2
    //   300: aload 6
    //   302: invokevirtual 311	java/io/FileInputStream:close	()V
    //   305: aload 8
    //   307: astore_2
    //   308: goto +134 -> 442
    //   311: astore 5
    //   313: aconst_null
    //   314: astore_1
    //   315: aload_1
    //   316: astore 6
    //   318: aload 6
    //   320: astore_0
    //   321: aload 6
    //   323: astore 4
    //   325: aload_0
    //   326: astore_2
    //   327: aload_1
    //   328: astore_3
    //   329: aload 5
    //   331: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   334: aload_0
    //   335: ifnull +10 -> 345
    //   338: aload 7
    //   340: astore_2
    //   341: aload_0
    //   342: invokevirtual 309	java/io/ObjectInputStream:close	()V
    //   345: aload_1
    //   346: ifnull +10 -> 356
    //   349: aload 7
    //   351: astore_2
    //   352: aload_1
    //   353: invokevirtual 310	java/io/BufferedInputStream:close	()V
    //   356: aload 8
    //   358: astore_2
    //   359: aload 6
    //   361: ifnull +81 -> 442
    //   364: aload 7
    //   366: astore_2
    //   367: aload 6
    //   369: invokevirtual 311	java/io/FileInputStream:close	()V
    //   372: aload 8
    //   374: astore_2
    //   375: goto +67 -> 442
    //   378: astore 5
    //   380: aconst_null
    //   381: astore_1
    //   382: aload_1
    //   383: astore 6
    //   385: aload 6
    //   387: astore_0
    //   388: aload 6
    //   390: astore 4
    //   392: aload_0
    //   393: astore_2
    //   394: aload_1
    //   395: astore_3
    //   396: aload 5
    //   398: invokevirtual 216	java/io/FileNotFoundException:printStackTrace	()V
    //   401: aload_0
    //   402: ifnull +10 -> 412
    //   405: aload 7
    //   407: astore_2
    //   408: aload_0
    //   409: invokevirtual 309	java/io/ObjectInputStream:close	()V
    //   412: aload_1
    //   413: ifnull +10 -> 423
    //   416: aload 7
    //   418: astore_2
    //   419: aload_1
    //   420: invokevirtual 310	java/io/BufferedInputStream:close	()V
    //   423: aload 8
    //   425: astore_2
    //   426: aload 6
    //   428: ifnull +14 -> 442
    //   431: aload 7
    //   433: astore_2
    //   434: aload 6
    //   436: invokevirtual 311	java/io/FileInputStream:close	()V
    //   439: aload 8
    //   441: astore_2
    //   442: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +51 -> 496
    //   448: new 67	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   455: astore_1
    //   456: aload_1
    //   457: ldc_w 314
    //   460: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload_2
    //   465: ifnonnull +10 -> 475
    //   468: ldc_w 316
    //   471: astore_0
    //   472: goto +8 -> 480
    //   475: aload_2
    //   476: invokevirtual 317	java/lang/Object:toString	()Ljava/lang/String;
    //   479: astore_0
    //   480: aload_1
    //   481: aload_0
    //   482: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: ldc 211
    //   488: iconst_2
    //   489: aload_1
    //   490: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 319	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload_2
    //   497: areturn
    //   498: astore_0
    //   499: aload_3
    //   500: astore_1
    //   501: aload_0
    //   502: astore_3
    //   503: aload_2
    //   504: astore_0
    //   505: aload_3
    //   506: astore_2
    //   507: aload 4
    //   509: astore_3
    //   510: aload_3
    //   511: astore 4
    //   513: aload_2
    //   514: astore_3
    //   515: aload 4
    //   517: astore_2
    //   518: aload_0
    //   519: ifnull +10 -> 529
    //   522: aload_0
    //   523: invokevirtual 309	java/io/ObjectInputStream:close	()V
    //   526: goto +3 -> 529
    //   529: aload_1
    //   530: ifnull +7 -> 537
    //   533: aload_1
    //   534: invokevirtual 310	java/io/BufferedInputStream:close	()V
    //   537: aload_2
    //   538: ifnull +14 -> 552
    //   541: aload_2
    //   542: invokevirtual 311	java/io/FileInputStream:close	()V
    //   545: goto +7 -> 552
    //   548: aload_0
    //   549: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   552: aload_3
    //   553: athrow
    //   554: astore_0
    //   555: goto -7 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	paramString	String
    //   28	506	1	localObject1	Object
    //   44	35	2	localObject2	Object
    //   90	8	2	localException1	java.lang.Exception
    //   103	8	2	localIOException1	java.io.IOException
    //   116	8	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   129	1	2	localObject3	Object
    //   141	401	2	localObject4	Object
    //   7	546	3	localObject5	Object
    //   4	129	4	str	String
    //   174	9	4	localObject6	Object
    //   230	9	4	localObject7	Object
    //   256	260	4	localObject8	Object
    //   37	88	5	localObject9	Object
    //   138	1	5	localException2	java.lang.Exception
    //   150	1	5	localIOException2	java.io.IOException
    //   162	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   188	1	5	localException3	java.lang.Exception
    //   202	1	5	localIOException3	java.io.IOException
    //   216	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   244	19	5	localException4	java.lang.Exception
    //   311	19	5	localIOException4	java.io.IOException
    //   378	19	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   52	383	6	localObject10	Object
    //   9	423	7	localObject11	Object
    //   1	439	8	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   57	62	82	java/io/IOException
    //   65	69	82	java/io/IOException
    //   72	76	82	java/io/IOException
    //   274	278	82	java/io/IOException
    //   285	289	82	java/io/IOException
    //   300	305	82	java/io/IOException
    //   341	345	82	java/io/IOException
    //   352	356	82	java/io/IOException
    //   367	372	82	java/io/IOException
    //   408	412	82	java/io/IOException
    //   419	423	82	java/io/IOException
    //   434	439	82	java/io/IOException
    //   47	54	90	java/lang/Exception
    //   47	54	103	java/io/IOException
    //   47	54	116	java/io/FileNotFoundException
    //   29	39	129	finally
    //   29	39	138	java/lang/Exception
    //   29	39	150	java/io/IOException
    //   29	39	162	java/io/FileNotFoundException
    //   20	29	174	finally
    //   20	29	188	java/lang/Exception
    //   20	29	202	java/io/IOException
    //   20	29	216	java/io/FileNotFoundException
    //   11	20	230	finally
    //   11	20	244	java/lang/Exception
    //   11	20	311	java/io/IOException
    //   11	20	378	java/io/FileNotFoundException
    //   47	54	498	finally
    //   262	267	498	finally
    //   329	334	498	finally
    //   396	401	498	finally
    //   522	526	554	java/io/IOException
    //   533	537	554	java/io/IOException
    //   541	545	554	java/io/IOException
  }
  
  public static String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append("/nearby_gray_tips_configs");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong, NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, List<MessageRecord> paramList)
  {
    paramLong = (paramLong - paramGrayTipsConfig.sceneTwo.timeRange * 60 * 1000) / 1000L;
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      paramGrayTipsConfig = (MessageRecord)paramList.get(i);
      if (paramGrayTipsConfig != null)
      {
        if (paramGrayTipsConfig.time < paramLong) {
          paramList.remove(i);
        }
      }
      else {
        paramList.remove(i);
      }
      i -= 1;
    }
  }
  
  private void a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, List<MessageRecord> paramList)
  {
    paramGrayTipsConfig = paramGrayTipsConfig.aioTypes.iterator();
    while (paramGrayTipsConfig.hasNext())
    {
      Object localObject = (Integer)paramGrayTipsConfig.next();
      if (((Integer)localObject).intValue() == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1001).a(AppConstants.LBS_HELLO_UIN, 1001);
        List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(10002).a(AppConstants.LBS_HELLO_UIN, 10002);
        paramList.addAll((Collection)localObject);
        paramList.addAll(localList);
      }
      else if (((Integer)localObject).intValue() == 2)
      {
        paramList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1010).a(AppConstants.DATE_UIN, 1010));
      }
    }
  }
  
  private static void a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("SceneType")) {
      paramGrayTipsConfig.sceneId = paramJSONObject.getInt("SceneType");
    }
    boolean bool = paramJSONObject.isNull("RandomWording");
    int j = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if (!bool)
    {
      localObject1 = paramJSONObject.getJSONArray("RandomWording");
      localObject2 = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        ((ArrayList)localObject2).add(((JSONArray)localObject1).getString(i));
        i += 1;
      }
      paramGrayTipsConfig.randomWordings = ((ArrayList)localObject2);
    }
    if (!paramJSONObject.isNull("SceneFirst"))
    {
      localObject1 = paramJSONObject.getJSONObject("SceneFirst");
      localObject2 = new NearbyGrayTipsManager.SceneOne();
      if (!((JSONObject)localObject1).isNull("SayHiTrigger")) {
        ((NearbyGrayTipsManager.SceneOne)localObject2).sayHiTrigger = ((JSONObject)localObject1).getBoolean("SayHiTrigger");
      }
      paramGrayTipsConfig.sceneOne = ((NearbyGrayTipsManager.SceneOne)localObject2);
    }
    if (!paramJSONObject.isNull("SceneSecond"))
    {
      localObject1 = paramJSONObject.getJSONObject("SceneSecond");
      localObject2 = new NearbyGrayTipsManager.SceneTwo();
      if (!((JSONObject)localObject1).isNull("SayHiFrequencyControl"))
      {
        ((NearbyGrayTipsManager.SceneTwo)localObject2).sayHiFrequencyControl = ((JSONObject)localObject1).getBoolean("SayHiFrequencyControl");
        if (!((JSONObject)localObject1).isNull("TimeRange")) {
          ((NearbyGrayTipsManager.SceneTwo)localObject2).timeRange = ((JSONObject)localObject1).getInt("TimeRange");
        }
        if (!((JSONObject)localObject1).isNull("UsersCount")) {
          ((NearbyGrayTipsManager.SceneTwo)localObject2).sayHiPeopleCount = ((JSONObject)localObject1).getInt("UsersCount");
        }
      }
      paramGrayTipsConfig.sceneTwo = ((NearbyGrayTipsManager.SceneTwo)localObject2);
    }
    Object localObject3;
    if (!paramJSONObject.isNull("SceneThird"))
    {
      localObject2 = paramJSONObject.getJSONObject("SceneThird");
      if (!((JSONObject)localObject2).isNull("KeywordTrigger"))
      {
        localObject1 = new NearbyGrayTipsManager.SceneThree();
        ((NearbyGrayTipsManager.SceneThree)localObject1).keywordTrigger = ((JSONObject)localObject2).getBoolean("KeywordTrigger");
        if (!((JSONObject)localObject2).isNull("MessageSide"))
        {
          localObject3 = ((JSONObject)localObject2).getJSONArray("MessageSide");
          ArrayList localArrayList = new ArrayList();
          i = 0;
          while (i < ((JSONArray)localObject3).length())
          {
            localArrayList.add(Integer.valueOf(((JSONArray)localObject3).getInt(i)));
            i += 1;
          }
          ((NearbyGrayTipsManager.SceneThree)localObject1).whichSide = localArrayList;
        }
        if (!((JSONObject)localObject2).isNull("KeywordList"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("KeywordList");
          localObject3 = new ArrayList();
          i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            ((ArrayList)localObject3).add(((JSONArray)localObject2).getString(i));
            i += 1;
          }
          ((NearbyGrayTipsManager.SceneThree)localObject1).keywords = ((ArrayList)localObject3);
        }
        paramGrayTipsConfig.sceneThree = ((NearbyGrayTipsManager.SceneThree)localObject1);
      }
    }
    if (!paramJSONObject.isNull("SceneForth"))
    {
      localObject1 = paramJSONObject.getJSONObject("SceneForth");
      localObject2 = new NearbyGrayTipsManager.SceneFour();
      ((NearbyGrayTipsManager.SceneFour)localObject2).enterAIOTrigger = ((JSONObject)localObject1).getBoolean("AIOTrigger");
      paramGrayTipsConfig.sceneFour = ((NearbyGrayTipsManager.SceneFour)localObject2);
    }
    if (!paramJSONObject.isNull("SceneFifth"))
    {
      localObject1 = paramJSONObject.getJSONObject("SceneFifth");
      paramJSONObject = new NearbyGrayTipsManager.SceneFive();
      paramJSONObject.faceScoreTrigger = ((JSONObject)localObject1).getBoolean("FaceScoreTrigger");
      localObject2 = ((JSONObject)localObject1).getJSONArray("RandomWordingForMale");
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        ((ArrayList)localObject3).add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
      paramJSONObject.randomWordingForMale = ((ArrayList)localObject3);
      localObject1 = ((JSONObject)localObject1).getJSONArray("RandomWordingForFemale");
      localObject2 = new ArrayList();
      i = j;
      while (i < ((JSONArray)localObject1).length())
      {
        ((ArrayList)localObject2).add(((JSONArray)localObject1).getString(i));
        i += 1;
      }
      paramJSONObject.randomWordingForFeMale = ((ArrayList)localObject2);
      paramGrayTipsConfig.sceneFive = paramJSONObject;
    }
  }
  
  /* Error */
  public static void a(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 211
    //   12: iconst_2
    //   13: ldc_w 490
    //   16: invokestatic 319	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: return
    //   20: iconst_0
    //   21: istore_3
    //   22: iconst_0
    //   23: istore 4
    //   25: aconst_null
    //   26: astore 6
    //   28: aconst_null
    //   29: astore 7
    //   31: aconst_null
    //   32: astore 9
    //   34: aconst_null
    //   35: astore 8
    //   37: new 492	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 493	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   45: astore 5
    //   47: new 495	java/io/BufferedOutputStream
    //   50: dup
    //   51: aload 5
    //   53: invokespecial 498	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_1
    //   57: new 500	java/io/ObjectOutputStream
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 501	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore 6
    //   67: aload 6
    //   69: aload_0
    //   70: invokevirtual 505	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   73: aload_1
    //   74: invokevirtual 508	java/io/BufferedOutputStream:flush	()V
    //   77: iconst_1
    //   78: istore_3
    //   79: iconst_1
    //   80: istore_2
    //   81: aload_1
    //   82: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   85: goto +8 -> 93
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   93: aload 6
    //   95: invokevirtual 510	java/io/ObjectOutputStream:close	()V
    //   98: goto +8 -> 106
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   106: aload 5
    //   108: invokevirtual 511	java/io/FileOutputStream:close	()V
    //   111: iload_3
    //   112: istore_2
    //   113: goto +443 -> 556
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   121: goto +435 -> 556
    //   124: astore_0
    //   125: aload 6
    //   127: astore 7
    //   129: goto +52 -> 181
    //   132: astore 9
    //   134: aload_1
    //   135: astore 8
    //   137: aload 5
    //   139: astore 10
    //   141: aload 6
    //   143: astore_1
    //   144: goto +175 -> 319
    //   147: astore 9
    //   149: aload_1
    //   150: astore 8
    //   152: aload 5
    //   154: astore 10
    //   156: aload 6
    //   158: astore_1
    //   159: goto +244 -> 403
    //   162: astore 9
    //   164: aload_1
    //   165: astore 8
    //   167: aload 5
    //   169: astore 10
    //   171: aload 6
    //   173: astore_1
    //   174: goto +313 -> 487
    //   177: astore_0
    //   178: aconst_null
    //   179: astore 7
    //   181: aload 5
    //   183: astore 6
    //   185: goto +431 -> 616
    //   188: astore 9
    //   190: aconst_null
    //   191: astore 6
    //   193: aload_1
    //   194: astore 8
    //   196: aload 5
    //   198: astore 10
    //   200: aload 6
    //   202: astore_1
    //   203: goto +116 -> 319
    //   206: astore 9
    //   208: aconst_null
    //   209: astore 6
    //   211: aload_1
    //   212: astore 8
    //   214: aload 5
    //   216: astore 10
    //   218: aload 6
    //   220: astore_1
    //   221: goto +182 -> 403
    //   224: astore 9
    //   226: aconst_null
    //   227: astore 6
    //   229: aload_1
    //   230: astore 8
    //   232: aload 5
    //   234: astore 10
    //   236: aload 6
    //   238: astore_1
    //   239: goto +248 -> 487
    //   242: astore_0
    //   243: aconst_null
    //   244: astore 7
    //   246: aload 9
    //   248: astore_1
    //   249: aload 5
    //   251: astore 6
    //   253: goto +363 -> 616
    //   256: astore 9
    //   258: aconst_null
    //   259: astore_1
    //   260: aload 5
    //   262: astore 10
    //   264: goto +55 -> 319
    //   267: astore 9
    //   269: aconst_null
    //   270: astore_1
    //   271: aload 6
    //   273: astore 8
    //   275: aload 5
    //   277: astore 10
    //   279: goto +124 -> 403
    //   282: astore 9
    //   284: aconst_null
    //   285: astore_1
    //   286: aload 7
    //   288: astore 8
    //   290: aload 5
    //   292: astore 10
    //   294: goto +193 -> 487
    //   297: astore_0
    //   298: aconst_null
    //   299: astore 6
    //   301: aload 6
    //   303: astore 7
    //   305: aload 9
    //   307: astore_1
    //   308: goto +308 -> 616
    //   311: astore 9
    //   313: aconst_null
    //   314: astore 10
    //   316: aload 10
    //   318: astore_1
    //   319: aload 8
    //   321: astore 5
    //   323: aload 10
    //   325: astore 6
    //   327: aload_1
    //   328: astore 7
    //   330: aload 9
    //   332: invokevirtual 312	java/lang/Exception:printStackTrace	()V
    //   335: aload 8
    //   337: ifnull +18 -> 355
    //   340: aload 8
    //   342: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   345: goto +10 -> 355
    //   348: astore 5
    //   350: aload 5
    //   352: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   355: aload_1
    //   356: ifnull +15 -> 371
    //   359: aload_1
    //   360: invokevirtual 510	java/io/ObjectOutputStream:close	()V
    //   363: goto +8 -> 371
    //   366: astore_1
    //   367: aload_1
    //   368: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   371: iload_3
    //   372: istore_2
    //   373: aload 10
    //   375: ifnull +181 -> 556
    //   378: iload 4
    //   380: istore_2
    //   381: aload 10
    //   383: invokevirtual 511	java/io/FileOutputStream:close	()V
    //   386: iload_3
    //   387: istore_2
    //   388: goto +168 -> 556
    //   391: astore 9
    //   393: aconst_null
    //   394: astore 10
    //   396: aload 10
    //   398: astore_1
    //   399: aload 6
    //   401: astore 8
    //   403: aload 8
    //   405: astore 5
    //   407: aload 10
    //   409: astore 6
    //   411: aload_1
    //   412: astore 7
    //   414: aload 9
    //   416: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   419: aload 8
    //   421: ifnull +18 -> 439
    //   424: aload 8
    //   426: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   429: goto +10 -> 439
    //   432: astore 5
    //   434: aload 5
    //   436: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   439: aload_1
    //   440: ifnull +15 -> 455
    //   443: aload_1
    //   444: invokevirtual 510	java/io/ObjectOutputStream:close	()V
    //   447: goto +8 -> 455
    //   450: astore_1
    //   451: aload_1
    //   452: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   455: iload_3
    //   456: istore_2
    //   457: aload 10
    //   459: ifnull +97 -> 556
    //   462: iload 4
    //   464: istore_2
    //   465: aload 10
    //   467: invokevirtual 511	java/io/FileOutputStream:close	()V
    //   470: iload_3
    //   471: istore_2
    //   472: goto +84 -> 556
    //   475: astore 9
    //   477: aconst_null
    //   478: astore 10
    //   480: aload 10
    //   482: astore_1
    //   483: aload 7
    //   485: astore 8
    //   487: aload 8
    //   489: astore 5
    //   491: aload 10
    //   493: astore 6
    //   495: aload_1
    //   496: astore 7
    //   498: aload 9
    //   500: invokevirtual 216	java/io/FileNotFoundException:printStackTrace	()V
    //   503: aload 8
    //   505: ifnull +18 -> 523
    //   508: aload 8
    //   510: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   513: goto +10 -> 523
    //   516: astore 5
    //   518: aload 5
    //   520: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   523: aload_1
    //   524: ifnull +15 -> 539
    //   527: aload_1
    //   528: invokevirtual 510	java/io/ObjectOutputStream:close	()V
    //   531: goto +8 -> 539
    //   534: astore_1
    //   535: aload_1
    //   536: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   539: iload_3
    //   540: istore_2
    //   541: aload 10
    //   543: ifnull +13 -> 556
    //   546: iload 4
    //   548: istore_2
    //   549: aload 10
    //   551: invokevirtual 511	java/io/FileOutputStream:close	()V
    //   554: iload_3
    //   555: istore_2
    //   556: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq +52 -> 611
    //   562: new 67	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   569: astore_1
    //   570: aload_1
    //   571: ldc_w 513
    //   574: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload_1
    //   579: iload_2
    //   580: invokevirtual 516	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload_1
    //   585: ldc_w 518
    //   588: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload_1
    //   593: aload_0
    //   594: invokevirtual 317	java/lang/Object:toString	()Ljava/lang/String;
    //   597: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: ldc 211
    //   603: iconst_2
    //   604: aload_1
    //   605: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 319	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: return
    //   612: astore_0
    //   613: aload 5
    //   615: astore_1
    //   616: aload_1
    //   617: ifnull +15 -> 632
    //   620: aload_1
    //   621: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   624: goto +8 -> 632
    //   627: astore_1
    //   628: aload_1
    //   629: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   632: aload 7
    //   634: ifnull +16 -> 650
    //   637: aload 7
    //   639: invokevirtual 510	java/io/ObjectOutputStream:close	()V
    //   642: goto +8 -> 650
    //   645: astore_1
    //   646: aload_1
    //   647: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   650: aload 6
    //   652: ifnull +16 -> 668
    //   655: aload 6
    //   657: invokevirtual 511	java/io/FileOutputStream:close	()V
    //   660: goto +8 -> 668
    //   663: astore_1
    //   664: aload_1
    //   665: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   668: aload_0
    //   669: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	paramObject	Object
    //   0	670	1	paramString	String
    //   80	500	2	bool1	boolean
    //   21	534	3	bool2	boolean
    //   23	524	4	bool3	boolean
    //   45	277	5	localObject1	Object
    //   348	3	5	localIOException1	java.io.IOException
    //   405	1	5	localObject2	Object
    //   432	3	5	localIOException2	java.io.IOException
    //   489	1	5	localObject3	Object
    //   516	98	5	localIOException3	java.io.IOException
    //   26	630	6	localObject4	Object
    //   29	609	7	localObject5	Object
    //   35	474	8	localObject6	Object
    //   32	1	9	localObject7	Object
    //   132	1	9	localException1	java.lang.Exception
    //   147	1	9	localIOException4	java.io.IOException
    //   162	1	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   188	1	9	localException2	java.lang.Exception
    //   206	1	9	localIOException5	java.io.IOException
    //   224	23	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   256	1	9	localException3	java.lang.Exception
    //   267	1	9	localIOException6	java.io.IOException
    //   282	24	9	localFileNotFoundException3	java.io.FileNotFoundException
    //   311	20	9	localException4	java.lang.Exception
    //   391	24	9	localIOException7	java.io.IOException
    //   475	24	9	localFileNotFoundException4	java.io.FileNotFoundException
    //   139	411	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   81	85	88	java/io/IOException
    //   93	98	101	java/io/IOException
    //   106	111	116	java/io/IOException
    //   381	386	116	java/io/IOException
    //   465	470	116	java/io/IOException
    //   549	554	116	java/io/IOException
    //   67	77	124	finally
    //   67	77	132	java/lang/Exception
    //   67	77	147	java/io/IOException
    //   67	77	162	java/io/FileNotFoundException
    //   57	67	177	finally
    //   57	67	188	java/lang/Exception
    //   57	67	206	java/io/IOException
    //   57	67	224	java/io/FileNotFoundException
    //   47	57	242	finally
    //   47	57	256	java/lang/Exception
    //   47	57	267	java/io/IOException
    //   47	57	282	java/io/FileNotFoundException
    //   37	47	297	finally
    //   37	47	311	java/lang/Exception
    //   340	345	348	java/io/IOException
    //   359	363	366	java/io/IOException
    //   37	47	391	java/io/IOException
    //   424	429	432	java/io/IOException
    //   443	447	450	java/io/IOException
    //   37	47	475	java/io/FileNotFoundException
    //   508	513	516	java/io/IOException
    //   527	531	534	java/io/IOException
    //   330	335	612	finally
    //   414	419	612	finally
    //   498	503	612	finally
    //   620	624	627	java/io/IOException
    //   637	642	645	java/io/IOException
    //   655	660	663	java/io/IOException
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    if (localCalendar1.get(6) != localCalendar2.get(6)) {
      return false;
    }
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  /* Error */
  public static boolean a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aconst_null
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 9
    //   20: new 67	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: invokestatic 533	com/tencent/mobileqq/app/NearbyGrayTipsManager:a	()Ljava/lang/String;
    //   32: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_0
    //   38: getfield 534	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:id	I
    //   41: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: ldc_w 536
    //   49: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: new 492	java/io/FileOutputStream
    //   56: dup
    //   57: aload_3
    //   58: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 493	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: new 495	java/io/BufferedOutputStream
    //   68: dup
    //   69: aload_3
    //   70: invokespecial 498	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   73: astore 4
    //   75: aload 6
    //   77: astore 5
    //   79: aload_3
    //   80: astore 6
    //   82: aload 4
    //   84: astore 7
    //   86: new 500	java/io/ObjectOutputStream
    //   89: dup
    //   90: aload 4
    //   92: invokespecial 501	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   95: astore 8
    //   97: aload 8
    //   99: aload_0
    //   100: invokevirtual 505	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   103: aload 4
    //   105: invokevirtual 508	java/io/BufferedOutputStream:flush	()V
    //   108: iconst_1
    //   109: istore_2
    //   110: iload_2
    //   111: istore_1
    //   112: aload 8
    //   114: invokevirtual 510	java/io/ObjectOutputStream:close	()V
    //   117: iload_2
    //   118: istore_1
    //   119: aload 4
    //   121: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   124: iload_2
    //   125: istore_1
    //   126: aload_3
    //   127: invokevirtual 511	java/io/FileOutputStream:close	()V
    //   130: iconst_1
    //   131: ireturn
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   137: iload_1
    //   138: ireturn
    //   139: astore_0
    //   140: aload 8
    //   142: astore 5
    //   144: goto +195 -> 339
    //   147: astore_0
    //   148: goto +71 -> 219
    //   151: astore_0
    //   152: goto +128 -> 280
    //   155: astore_0
    //   156: aload 9
    //   158: astore 8
    //   160: goto +59 -> 219
    //   163: astore_0
    //   164: aload 10
    //   166: astore 8
    //   168: goto +112 -> 280
    //   171: astore_0
    //   172: aconst_null
    //   173: astore 4
    //   175: goto +164 -> 339
    //   178: astore_0
    //   179: aconst_null
    //   180: astore 4
    //   182: aload 9
    //   184: astore 8
    //   186: goto +33 -> 219
    //   189: astore_0
    //   190: aconst_null
    //   191: astore 4
    //   193: aload 10
    //   195: astore 8
    //   197: goto +83 -> 280
    //   200: astore_0
    //   201: aconst_null
    //   202: astore_3
    //   203: aload_3
    //   204: astore 4
    //   206: goto +133 -> 339
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_3
    //   212: aload_3
    //   213: astore 4
    //   215: aload 9
    //   217: astore 8
    //   219: aload 8
    //   221: astore 5
    //   223: aload_3
    //   224: astore 6
    //   226: aload 4
    //   228: astore 7
    //   230: aload_0
    //   231: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   234: aload 8
    //   236: ifnull +10 -> 246
    //   239: iload_2
    //   240: istore_1
    //   241: aload 8
    //   243: invokevirtual 510	java/io/ObjectOutputStream:close	()V
    //   246: aload 4
    //   248: ifnull +10 -> 258
    //   251: iload_2
    //   252: istore_1
    //   253: aload 4
    //   255: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   258: aload_3
    //   259: ifnull +70 -> 329
    //   262: iload_2
    //   263: istore_1
    //   264: aload_3
    //   265: invokevirtual 511	java/io/FileOutputStream:close	()V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_0
    //   271: aconst_null
    //   272: astore_3
    //   273: aload_3
    //   274: astore 4
    //   276: aload 10
    //   278: astore 8
    //   280: aload 8
    //   282: astore 5
    //   284: aload_3
    //   285: astore 6
    //   287: aload 4
    //   289: astore 7
    //   291: aload_0
    //   292: invokevirtual 216	java/io/FileNotFoundException:printStackTrace	()V
    //   295: aload 8
    //   297: ifnull +10 -> 307
    //   300: iload_2
    //   301: istore_1
    //   302: aload 8
    //   304: invokevirtual 510	java/io/ObjectOutputStream:close	()V
    //   307: aload 4
    //   309: ifnull +10 -> 319
    //   312: iload_2
    //   313: istore_1
    //   314: aload 4
    //   316: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   319: aload_3
    //   320: ifnull +9 -> 329
    //   323: iload_2
    //   324: istore_1
    //   325: aload_3
    //   326: invokevirtual 511	java/io/FileOutputStream:close	()V
    //   329: iconst_0
    //   330: ireturn
    //   331: astore_0
    //   332: aload 7
    //   334: astore 4
    //   336: aload 6
    //   338: astore_3
    //   339: aload 5
    //   341: ifnull +11 -> 352
    //   344: aload 5
    //   346: invokevirtual 510	java/io/ObjectOutputStream:close	()V
    //   349: goto +3 -> 352
    //   352: aload 4
    //   354: ifnull +8 -> 362
    //   357: aload 4
    //   359: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   362: aload_3
    //   363: ifnull +14 -> 377
    //   366: aload_3
    //   367: invokevirtual 511	java/io/FileOutputStream:close	()V
    //   370: goto +7 -> 377
    //   373: aload_3
    //   374: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   377: aload_0
    //   378: athrow
    //   379: astore_3
    //   380: goto -7 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramGrayTipsConfig	NearbyGrayTipsManager.GrayTipsConfig
    //   111	214	1	bool1	boolean
    //   1	323	2	bool2	boolean
    //   27	347	3	localObject1	Object
    //   379	1	3	localIOException	java.io.IOException
    //   73	285	4	localObject2	Object
    //   15	330	5	localObject3	Object
    //   12	325	6	localObject4	Object
    //   84	249	7	localObject5	Object
    //   95	208	8	localObject6	Object
    //   18	198	9	localObject7	Object
    //   9	268	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   112	117	132	java/io/IOException
    //   119	124	132	java/io/IOException
    //   126	130	132	java/io/IOException
    //   241	246	132	java/io/IOException
    //   253	258	132	java/io/IOException
    //   264	268	132	java/io/IOException
    //   302	307	132	java/io/IOException
    //   314	319	132	java/io/IOException
    //   325	329	132	java/io/IOException
    //   97	108	139	finally
    //   97	108	147	java/io/IOException
    //   97	108	151	java/io/FileNotFoundException
    //   86	97	155	java/io/IOException
    //   86	97	163	java/io/FileNotFoundException
    //   65	75	171	finally
    //   65	75	178	java/io/IOException
    //   65	75	189	java/io/FileNotFoundException
    //   20	65	200	finally
    //   20	65	209	java/io/IOException
    //   20	65	270	java/io/FileNotFoundException
    //   86	97	331	finally
    //   230	234	331	finally
    //   291	295	331	finally
    //   344	349	379	java/io/IOException
    //   357	362	379	java/io/IOException
    //   366	370	379	java/io/IOException
  }
  
  private static void b(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.isNull("FavoriteContent1");
    int j = 0;
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (!bool)
    {
      localObject1 = paramJSONObject.getJSONArray("FavoriteContent1");
      localObject2 = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        if (!((JSONObject)localObject3).isNull("Title"))
        {
          NearbyGrayTipsManager.Wording localWording = new NearbyGrayTipsManager.Wording();
          localWording.text = ((JSONObject)localObject3).getString("Title");
          if (!((JSONObject)localObject3).isNull("HighlightTitle")) {
            localWording.highlightText = ((JSONObject)localObject3).getString("HighlightTitle");
          }
          ((ArrayList)localObject2).add(localWording);
        }
        i += 1;
      }
      paramGrayTipsConfig.favoriteGrayTipWordings1 = ((ArrayList)localObject2);
    }
    if (!paramJSONObject.isNull("FavoriteContent2"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("FavoriteContent2");
      localObject1 = new ArrayList();
      i = j;
      while (i < paramJSONObject.length())
      {
        localObject2 = paramJSONObject.getJSONObject(i);
        if (!((JSONObject)localObject2).isNull("Title"))
        {
          localObject3 = new NearbyGrayTipsManager.Wording();
          ((NearbyGrayTipsManager.Wording)localObject3).text = ((JSONObject)localObject2).getString("Title");
          if (!((JSONObject)localObject2).isNull("HighlightTitle")) {
            ((NearbyGrayTipsManager.Wording)localObject3).highlightText = ((JSONObject)localObject2).getString("HighlightTitle");
          }
          ((ArrayList)localObject1).add(localObject3);
        }
        i += 1;
      }
      paramGrayTipsConfig.favoriteGrayTipWordings2 = ((ArrayList)localObject1);
    }
  }
  
  private void c()
  {
    label274:
    label290:
    label295:
    for (;;)
    {
      int i;
      Object localObject3;
      int j;
      Object localObject4;
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("nearby_aio_operation_gray_tips", 4, "loadLocalData");
        }
        a(true);
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        i = 0;
        this.d = ((SharedPreferences)localObject1).getInt("nearby_max_count_in_one_day", 0);
        this.jdField_a_of_type_Long = ((SharedPreferences)localObject1).getLong("nearby_mark_day_time", 0L);
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("loadLocalData, [");
          ((StringBuilder)localObject1).append(this.d);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
          ((StringBuilder)localObject1).append("]");
          QLog.i("nearby_aio_operation_gray_tips", 4, ((StringBuilder)localObject1).toString());
        }
        localObject1 = a();
        localObject3 = new File((String)localObject1);
        if (((File)localObject3).isDirectory())
        {
          localObject3 = ((File)localObject3).listFiles();
          if ((localObject3 != null) && (localObject3.length > 0))
          {
            j = localObject3.length;
            break label274;
            localObject4 = ((File)localObject4).getName();
            if ((TextUtils.isEmpty((CharSequence)localObject4)) || (!((String)localObject4).endsWith(".conf"))) {
              break label290;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append((String)localObject4);
            localObject4 = a(localStringBuilder.toString());
            if (!(localObject4 instanceof NearbyGrayTipsManager.GrayTipsConfig)) {
              break label290;
            }
            a((NearbyGrayTipsManager.GrayTipsConfig)localObject4);
            break label290;
          }
          a();
        }
        return;
      }
      finally {}
      for (;;)
      {
        throw localObject2;
      }
      for (;;)
      {
        if (i >= j) {
          break label295;
        }
        localObject4 = localObject3[i];
        if (localObject4 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private static void c(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("Content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("Content");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        if (!localJSONObject.isNull("Title"))
        {
          NearbyGrayTipsManager.Wording localWording = new NearbyGrayTipsManager.Wording();
          localWording.text = localJSONObject.getString("Title");
          if (!localJSONObject.isNull("HighlightTitle")) {
            localWording.highlightText = localJSONObject.getString("HighlightTitle");
          }
          localArrayList.add(localWording);
        }
        i += 1;
      }
      paramGrayTipsConfig.grayTipWordings = localArrayList;
    }
  }
  
  private static void d(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("Link")) {
      paramGrayTipsConfig.url = paramJSONObject.getString("Link");
    }
  }
  
  private static void e(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("ShowKeyboardSupport")) {
      paramGrayTipsConfig.showKeyboard = paramJSONObject.getBoolean("ShowKeyboardSupport");
    }
  }
  
  private static void f(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("TimeDailyControl")) {
      paramGrayTipsConfig.timeRangeControl = paramJSONObject.getBoolean("TimeDailyControl");
    }
    if (!paramJSONObject.isNull("TimeRangeDaily"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("TimeRangeDaily");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        if ((!localJSONObject.isNull("BeginTime")) && (!localJSONObject.isNull("EndTime")))
        {
          NearbyGrayTipsManager.TimeRangeInOneDay localTimeRangeInOneDay = new NearbyGrayTipsManager.TimeRangeInOneDay();
          localTimeRangeInOneDay.beginTime = localJSONObject.getInt("BeginTime");
          localTimeRangeInOneDay.endTime = localJSONObject.getInt("EndTime");
          localArrayList.add(localTimeRangeInOneDay);
        }
        i += 1;
      }
      paramGrayTipsConfig.timeRange = localArrayList;
    }
  }
  
  private static void g(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("SexType"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("SexType");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(Integer.valueOf(paramJSONObject.getInt(i)));
        i += 1;
      }
      paramGrayTipsConfig.sexTypes = localArrayList;
    }
  }
  
  private static void h(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("AIOType"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("AIOType");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(Integer.valueOf(paramJSONObject.getInt(i)));
        i += 1;
      }
      paramGrayTipsConfig.aioTypes = localArrayList;
    }
  }
  
  private static void i(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("Frequency"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("Frequency");
      if (!paramJSONObject.isNull("SingleTaskTipsCountPerDay")) {
        paramGrayTipsConfig.singleTaskMaxTipsCountPerDay = paramJSONObject.getInt("SingleTaskTipsCountPerDay");
      }
      if (!paramJSONObject.isNull("SingleTaskTotalTipsCount")) {
        paramGrayTipsConfig.singleTaskMaxTipsCount = paramJSONObject.getInt("SingleTaskTotalTipsCount");
      }
    }
  }
  
  private static void j(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("Priority")) {
      paramGrayTipsConfig.priority = paramJSONObject.getInt("Priority");
    }
  }
  
  private static void k(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("ID")) {
      paramGrayTipsConfig.id = paramJSONObject.getInt("ID");
    }
  }
  
  private static void l(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("CreationDate")) {
      paramGrayTipsConfig.createTime = (paramJSONObject.getLong("CreationDate") * 1000L);
    }
    if (!paramJSONObject.isNull("TipEnable")) {
      paramGrayTipsConfig.grayTipsEnable = paramJSONObject.getBoolean("TipEnable");
    }
    if (!paramJSONObject.isNull("GlobalTipsCountPerDay")) {
      paramGrayTipsConfig.globalMaxTipsCountPerDay = paramJSONObject.getInt("GlobalTipsCountPerDay");
    }
    if (!paramJSONObject.isNull("Frequency"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("Frequency");
      if (!paramJSONObject.isNull("TipsCount")) {
        paramGrayTipsConfig.maxTipsCount = paramJSONObject.getInt("TipsCount");
      }
      if (!paramJSONObject.isNull("MessageCount")) {
        paramGrayTipsConfig.messageCount = paramJSONObject.getInt("MessageCount");
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipStatisticData a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    label227:
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      int j = this.jdField_c_of_type_JavaUtilList.size();
      i = 0;
      ??? = null;
      if (i < j)
      {
        ??? = (NearbyGrayTipsManager.GrayTipStatisticData)this.jdField_c_of_type_JavaUtilList.get(i);
        if ((??? == null) || (((NearbyGrayTipsManager.GrayTipStatisticData)???).mId != paramInt)) {
          break label227;
        }
      }
      ??? = ???;
      if (??? == null)
      {
        ??? = ???;
        if (paramBoolean1)
        {
          Object localObject5 = a(NearbyGrayTipsManager.GrayTipStatisticData.getPath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt));
          ??? = ???;
          if ((localObject5 instanceof NearbyGrayTipsManager.GrayTipStatisticData))
          {
            ??? = (NearbyGrayTipsManager.GrayTipStatisticData)localObject5;
            synchronized (this.jdField_c_of_type_JavaUtilList)
            {
              this.jdField_c_of_type_JavaUtilList.add(???);
            }
          }
        }
      }
      if ((localObject4 == null) && (paramBoolean2))
      {
        NearbyGrayTipsManager.GrayTipStatisticData localGrayTipStatisticData1 = new NearbyGrayTipsManager.GrayTipStatisticData(paramInt);
        synchronized (this.jdField_c_of_type_JavaUtilList)
        {
          this.jdField_c_of_type_JavaUtilList.add(localGrayTipStatisticData1);
          return localGrayTipStatisticData1;
        }
      }
      return localGrayTipStatisticData2;
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig a(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "getValidConfigForEnterAIO, not enable");
      }
      return null;
    }
    Object localObject3;
    label301:
    label306:
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        NearbyGrayTipsManager.GrayTipStatisticData localGrayTipStatisticData = null;
        do
        {
          do
          {
            localObject3 = localGrayTipStatisticData;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          } while ((localObject3 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneId != 4) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneFour == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneFour.enterAIOTrigger) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)));
          if (!QLog.isDevelopLevel()) {
            break label301;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getValidConfigForEnterAIO, valid id = ");
          localStringBuilder.append(((NearbyGrayTipsManager.GrayTipsConfig)localObject3).id);
          QLog.i("nearby_aio_operation_gray_tips", 4, localStringBuilder.toString());
          break label301;
          if (localGrayTipStatisticData.priority < ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority) {
            break label306;
          }
        } while ((localGrayTipStatisticData.priority != ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority) || (localGrayTipStatisticData.createTime >= ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).createTime));
        break label306;
        if (localObject3 != null)
        {
          localGrayTipStatisticData = a(((NearbyGrayTipsManager.GrayTipsConfig)localObject3).id, true, true);
          if ((localGrayTipStatisticData != null) && (localGrayTipStatisticData.isLimit((NearbyGrayTipsManager.GrayTipsConfig)localObject3, paramLong))) {
            return null;
          }
          a((NearbyGrayTipsManager.GrayTipsConfig)localObject3, false);
        }
        return localObject3;
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      return null;
    }
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig2 = a(paramInt1, paramInt2, paramInt3, paramLong, null);
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig1 = localGrayTipsConfig2;
    if (localGrayTipsConfig2 != null)
    {
      NearbyGrayTipsManager.GrayTipStatisticData localGrayTipStatisticData = a(localGrayTipsConfig2.id, true, true);
      localGrayTipsConfig1 = localGrayTipsConfig2;
      if (localGrayTipStatisticData != null)
      {
        localGrayTipsConfig1 = localGrayTipsConfig2;
        if (localGrayTipStatisticData.isLimit(localGrayTipsConfig2, paramLong)) {
          localGrayTipsConfig1 = null;
        }
      }
    }
    return a(paramString, localGrayTipsConfig1);
  }
  
  public String a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getRandomFaceScoreWording id=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("  gender=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("  toLoad=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject1).toString());
    }
    NearbyGrayTipsManager.FaceScoreWording localFaceScoreWording = a(paramInt1);
    Object localObject1 = localFaceScoreWording;
    if (localFaceScoreWording == null)
    {
      localObject1 = localFaceScoreWording;
      if (paramBoolean)
      {
        Object localObject2 = a(NearbyGrayTipsManager.FaceScoreWording.getPath(paramInt1));
        localObject1 = localFaceScoreWording;
        if ((localObject2 instanceof NearbyGrayTipsManager.FaceScoreWording)) {
          localObject1 = (NearbyGrayTipsManager.FaceScoreWording)localObject2;
        }
      }
    }
    if (localObject1 == null) {
      return "";
    }
    return ((NearbyGrayTipsManager.FaceScoreWording)localObject1).getWording(this.jdField_a_of_type_JavaUtilRandom, paramInt2);
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    NearbyGrayTipsManager.GreetWording localGreetWording2 = a(paramInt);
    NearbyGrayTipsManager.GreetWording localGreetWording1 = localGreetWording2;
    if (localGreetWording2 == null)
    {
      localGreetWording1 = localGreetWording2;
      if (paramBoolean)
      {
        Object localObject = a(NearbyGrayTipsManager.GreetWording.getPath(paramInt));
        localGreetWording1 = localGreetWording2;
        if ((localObject instanceof NearbyGrayTipsManager.GreetWording)) {
          localGreetWording1 = (NearbyGrayTipsManager.GreetWording)localObject;
        }
      }
    }
    if (localGreetWording1 == null) {
      return "";
    }
    return localGreetWording1.getWording(this.jdField_a_of_type_JavaUtilRandom);
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject1 = (NearbyGrayTipsManager.GrayTipsConfig)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
            if (localGrayTipsConfig.createTime > ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).createTime) {
              localObject1 = localGrayTipsConfig;
            }
          }
          this.jdField_b_of_type_Boolean = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).grayTipsEnable;
          this.jdField_a_of_type_Int = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).globalMaxTipsCountPerDay;
          this.jdField_b_of_type_Int = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).maxTipsCount;
          this.jdField_c_of_type_Int = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).messageCount;
        }
        return;
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    NearbyGrayTipsManager.GrayTipStatisticData localGrayTipStatisticData = a(paramInt, true, true);
    if (localGrayTipStatisticData != null)
    {
      localGrayTipStatisticData.increase(paramLong);
      a(localGrayTipStatisticData, NearbyGrayTipsManager.GrayTipStatisticData.getPath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt));
    }
    if (a(paramLong, this.jdField_a_of_type_Long))
    {
      this.d += 1;
    }
    else
    {
      this.d = 1;
      this.jdField_a_of_type_Long = paramLong;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("nearby_max_count_in_one_day", this.d).putLong("nearby_mark_day_time", this.jdField_a_of_type_Long).commit();
  }
  
  public void a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig)
  {
    ArrayList localArrayList;
    int i;
    if (paramGrayTipsConfig != null)
    {
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        Object localObject;
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = (NearbyGrayTipsManager.GrayTipsConfig)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject).id != paramGrayTipsConfig.id) {
            break label238;
          }
          if (paramGrayTipsConfig.createTime > ((NearbyGrayTipsManager.GrayTipsConfig)localObject).createTime) {
            this.jdField_a_of_type_JavaUtilArrayList.set(i, paramGrayTipsConfig);
          }
        }
        if (i == this.jdField_a_of_type_JavaUtilArrayList.size()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramGrayTipsConfig);
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateOrAddAConfig");
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append("[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append("config_id =");
          ((StringBuilder)localObject).append(paramGrayTipsConfig.id);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append("config_scene_id =");
          ((StringBuilder)localObject).append(paramGrayTipsConfig.sceneId);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append("]");
          QLog.i("nearby_aio_operation_gray_tips", 4, ((StringBuilder)localObject).toString());
        }
        return;
      }
      finally {}
      return;
      label238:
      i += 1;
    }
  }
  
  public void a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, boolean paramBoolean)
  {
    if ((paramGrayTipsConfig != null) && (paramGrayTipsConfig.sceneId == 4))
    {
      Object localObject2 = a(paramGrayTipsConfig.id);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyGrayTipsManager.GreetWording(paramGrayTipsConfig.id);
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        if (paramBoolean) {}
        label80:
        try
        {
          this.jdField_a_of_type_JavaUtilList.add(0, localObject1);
          break label80;
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
        }
        finally {}
      }
      ((NearbyGrayTipsManager.GreetWording)localObject1).saveWording(paramGrayTipsConfig.createTime, paramGrayTipsConfig.randomWordings, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (this.jdField_a_of_type_Int == 0) {
      return false;
    }
    if (a(paramLong, this.jdField_a_of_type_Long))
    {
      if (this.d >= this.jdField_a_of_type_Int) {
        return true;
      }
    }
    else
    {
      this.d = 0;
      this.jdField_a_of_type_Long = 0L;
    }
    return false;
  }
  
  public boolean a(List<ChatMessage> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Int > 0)
      {
        bool1 = bool2;
        if (this.jdField_c_of_type_Int > 0)
        {
          int i = paramList.size() - 1;
          for (int k = 0; i >= 0; k = j)
          {
            j = k;
            if (!MessageUtils.a(((ChatMessage)paramList.get(i)).msgtype))
            {
              k += 1;
              j = k;
              if (k == this.jdField_c_of_type_Int) {
                break label104;
              }
            }
            i -= 1;
          }
          i = 0;
          label104:
          int j = paramList.size() - 1;
          int m;
          for (k = 0; j >= i; k = m)
          {
            m = k;
            if (-2027 == ((ChatMessage)paramList.get(j)).msgtype) {
              m = k + 1;
            }
            j -= 1;
          }
          bool1 = bool2;
          if (k >= this.jdField_b_of_type_Int) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig b(int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getValidConfigForFaceScore aioType= ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("  otherGender=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("  curTime=");
      localStringBuilder.append(paramLong);
      QLog.d("Q..troop.faceScore", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    boolean bool = this.jdField_b_of_type_Boolean;
    Object localObject3 = null;
    StringBuilder localStringBuilder = null;
    if (!bool) {
      return null;
    }
    label295:
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          do
          {
            localObject3 = localStringBuilder;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          } while ((localObject3 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneId != 5) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneFive == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneFive.faceScoreTrigger) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)));
          if ((localStringBuilder == null) || (localStringBuilder.priority < ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority)) {
            break label295;
          }
        } while ((localStringBuilder.priority != ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority) || (localStringBuilder.createTime >= ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).createTime));
      }
      else
      {
        if (localObject3 != null) {
          b((NearbyGrayTipsManager.GrayTipsConfig)localObject3, false);
        }
        return localObject3;
      }
    }
  }
  
  public void b()
  {
    ??? = new File(a());
    if ((((File)???).exists()) && (((File)???).isDirectory()))
    {
      ??? = ((File)???).listFiles();
      if ((??? != null) && (???.length > 0))
      {
        int j = ???.length;
        int i = 0;
        while (i < j)
        {
          ???[i].delete();
          i += 1;
        }
      }
    }
    ??? = this.jdField_a_of_type_JavaUtilArrayList;
    if ((??? != null) && (((ArrayList)???).size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateFaceScoreWording config= ");
      ((StringBuilder)localObject1).append(paramGrayTipsConfig);
      ((StringBuilder)localObject1).append("  needSaveToFile=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramGrayTipsConfig != null) && (paramGrayTipsConfig.sceneId == 5) && (paramGrayTipsConfig.sceneFive != null))
    {
      Object localObject2 = a(paramGrayTipsConfig.id);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyGrayTipsManager.FaceScoreWording(paramGrayTipsConfig.id);
        localObject2 = this.jdField_b_of_type_JavaUtilList;
        if (paramBoolean) {}
        label139:
        try
        {
          this.jdField_b_of_type_JavaUtilList.add(0, localObject1);
          break label139;
          this.jdField_b_of_type_JavaUtilList.add(localObject1);
        }
        finally {}
      }
      ((NearbyGrayTipsManager.FaceScoreWording)localObject1).saveWording(paramGrayTipsConfig.createTime, paramGrayTipsConfig.sceneFive.randomWordingForMale, paramGrayTipsConfig.sceneFive.randomWordingForFeMale, paramBoolean);
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig c(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      return null;
    }
    Object localObject3;
    label238:
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        NearbyGrayTipsManager.GrayTipStatisticData localGrayTipStatisticData = null;
        do
        {
          do
          {
            localObject3 = localGrayTipStatisticData;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          } while ((localObject3 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneId != 1) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneOne == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneOne.sayHiTrigger) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)));
          if ((localGrayTipStatisticData == null) || (localGrayTipStatisticData.priority < ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority)) {
            break label238;
          }
        } while ((localGrayTipStatisticData.priority != ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority) || (localGrayTipStatisticData.createTime >= ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).createTime));
        break label238;
        if (localObject3 != null)
        {
          localGrayTipStatisticData = a(((NearbyGrayTipsManager.GrayTipsConfig)localObject3).id, true, true);
          if ((localGrayTipStatisticData != null) && (localGrayTipStatisticData.isLimit((NearbyGrayTipsManager.GrayTipsConfig)localObject3, paramLong))) {
            return null;
          }
        }
        return localObject3;
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig d(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      return null;
    }
    Object localObject2 = a(paramInt1, paramInt2, paramLong, null);
    Object localObject1 = localObject2;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = a(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, true, true);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((NearbyGrayTipsManager.GrayTipStatisticData)localObject3).isLimit((NearbyGrayTipsManager.GrayTipsConfig)localObject2, paramLong)) {
          localObject1 = null;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.aioTypes != null)
      {
        localObject2 = localObject1;
        if (localObject1.aioTypes.size() > 0)
        {
          localObject3 = new ArrayList();
          a(localObject1, (List)localObject3);
          a(paramLong, localObject1, (List)localObject3);
          Collections.sort((List)localObject3, new NearbyGrayTipsManager.1(this));
          localObject2 = (QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE);
          paramInt1 = 0;
          localObject3 = ((List)localObject3).iterator();
          do
          {
            Object localObject4;
            do
            {
              paramInt2 = paramInt1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject4 = (MessageRecord)((Iterator)localObject3).next();
              localObject4 = ((QQMessageFacade)localObject2).getLastMessage(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
            } while ((localObject4 == null) || (((Message)localObject4).hasReply));
            paramInt2 = paramInt1 + 1;
            paramInt1 = paramInt2;
          } while (paramInt2 < localObject1.sceneTwo.sayHiPeopleCount);
          localObject2 = localObject1;
          if (paramInt2 < localObject1.sceneTwo.sayHiPeopleCount) {
            localObject2 = null;
          }
        }
      }
    }
    return localObject2;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager
 * JD-Core Version:    0.7.0.1
 */