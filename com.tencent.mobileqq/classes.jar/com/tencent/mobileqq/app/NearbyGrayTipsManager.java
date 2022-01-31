package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
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
import zor;

public class NearbyGrayTipsManager
  implements Manager
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList;
  private Random jdField_a_of_type_JavaUtilRandom;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private List jdField_c_of_type_JavaUtilList;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "getFaceScoreWordingById id= " + paramInt);
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        int j = this.jdField_b_of_type_JavaUtilList.size();
        i = 0;
        NearbyGrayTipsManager.FaceScoreWording localFaceScoreWording = null;
        if (i < j)
        {
          localFaceScoreWording = (NearbyGrayTipsManager.FaceScoreWording)this.jdField_b_of_type_JavaUtilList.get(i);
          if (localFaceScoreWording == null) {
            break label144;
          }
          if (localFaceScoreWording.id != paramInt) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "getFaceScoreWordingById return faceScoreWording= " + localFaceScoreWording);
          }
          return localFaceScoreWording;
        }
        localFaceScoreWording = null;
      }
      label144:
      i += 1;
    }
  }
  
  /* Error */
  public static NearbyGrayTipsManager.GrayTipsConfig a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 114	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: new 65	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   22: astore 7
    //   24: new 116	java/io/FileReader
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 119	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   32: astore_0
    //   33: new 121	java/io/BufferedReader
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 124	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore 4
    //   43: aload_0
    //   44: astore_3
    //   45: aload 4
    //   47: astore_2
    //   48: aload 4
    //   50: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 5
    //   55: aload 5
    //   57: ifnull +414 -> 471
    //   60: aload_0
    //   61: astore_3
    //   62: aload 4
    //   64: astore_2
    //   65: aload 7
    //   67: aload 5
    //   69: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: goto -30 -> 43
    //   76: astore 5
    //   78: aload_0
    //   79: astore_3
    //   80: aload 4
    //   82: astore_2
    //   83: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +16 -> 102
    //   89: aload_0
    //   90: astore_3
    //   91: aload 4
    //   93: astore_2
    //   94: ldc 129
    //   96: iconst_2
    //   97: ldc 131
    //   99: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload_0
    //   103: astore_3
    //   104: aload 4
    //   106: astore_2
    //   107: aload 5
    //   109: invokevirtual 134	java/io/FileNotFoundException:printStackTrace	()V
    //   112: aload 4
    //   114: ifnull +8 -> 122
    //   117: aload 4
    //   119: invokevirtual 137	java/io/BufferedReader:close	()V
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 138	java/io/FileReader:close	()V
    //   130: aload 7
    //   132: invokevirtual 141	java/lang/StringBuilder:length	()I
    //   135: ifle +1835 -> 1970
    //   138: new 143	org/json/JSONObject
    //   141: dup
    //   142: aload 7
    //   144: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokespecial 146	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   150: astore_3
    //   151: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +28 -> 182
    //   157: ldc 129
    //   159: iconst_2
    //   160: new 65	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   167: ldc 148
    //   169: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_3
    //   173: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: new 150	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig
    //   185: dup
    //   186: invokespecial 151	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:<init>	()V
    //   189: astore_0
    //   190: aload_3
    //   191: ldc 153
    //   193: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   196: ifne +17 -> 213
    //   199: aload_0
    //   200: aload_3
    //   201: ldc 153
    //   203: invokevirtual 161	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   206: ldc2_w 162
    //   209: lmul
    //   210: putfield 166	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:createTime	J
    //   213: aload_3
    //   214: ldc 168
    //   216: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   219: ifne +13 -> 232
    //   222: aload_0
    //   223: aload_3
    //   224: ldc 168
    //   226: invokevirtual 171	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   229: putfield 174	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:grayTipsEnable	Z
    //   232: aload_3
    //   233: ldc 176
    //   235: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   238: ifne +13 -> 251
    //   241: aload_0
    //   242: aload_3
    //   243: ldc 176
    //   245: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   248: putfield 183	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:global_MaxTipsCountPerDay	I
    //   251: aload_3
    //   252: ldc 185
    //   254: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   257: ifne +48 -> 305
    //   260: aload_3
    //   261: ldc 185
    //   263: invokevirtual 189	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   266: astore_2
    //   267: aload_2
    //   268: ldc 191
    //   270: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   273: ifne +13 -> 286
    //   276: aload_0
    //   277: aload_2
    //   278: ldc 191
    //   280: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   283: putfield 194	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:maxTipsCount	I
    //   286: aload_2
    //   287: ldc 196
    //   289: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   292: ifne +13 -> 305
    //   295: aload_0
    //   296: aload_2
    //   297: ldc 196
    //   299: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   302: putfield 199	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:messageCount	I
    //   305: aload_0
    //   306: astore_2
    //   307: aload_3
    //   308: ldc 201
    //   310: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   313: ifne -300 -> 13
    //   316: aload_3
    //   317: ldc 201
    //   319: invokevirtual 189	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   322: astore_3
    //   323: aload_3
    //   324: ldc 203
    //   326: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   329: ifne +13 -> 342
    //   332: aload_0
    //   333: aload_3
    //   334: ldc 203
    //   336: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   339: putfield 204	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:id	I
    //   342: aload_3
    //   343: ldc 206
    //   345: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   348: ifne +13 -> 361
    //   351: aload_0
    //   352: aload_3
    //   353: ldc 206
    //   355: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   358: putfield 209	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:priority	I
    //   361: aload_3
    //   362: ldc 185
    //   364: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   367: ifne +48 -> 415
    //   370: aload_3
    //   371: ldc 185
    //   373: invokevirtual 189	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   376: astore_2
    //   377: aload_2
    //   378: ldc 211
    //   380: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   383: ifne +13 -> 396
    //   386: aload_0
    //   387: aload_2
    //   388: ldc 211
    //   390: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   393: putfield 214	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:singleTask_MaxTipsCountPerDay	I
    //   396: aload_2
    //   397: ldc 216
    //   399: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   402: ifne +13 -> 415
    //   405: aload_0
    //   406: aload_2
    //   407: ldc 216
    //   409: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   412: putfield 219	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:singleTask_maxTipsCount	I
    //   415: aload_3
    //   416: ldc 221
    //   418: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   421: ifne +228 -> 649
    //   424: aload_3
    //   425: ldc 221
    //   427: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   430: astore_2
    //   431: new 24	java/util/ArrayList
    //   434: dup
    //   435: invokespecial 25	java/util/ArrayList:<init>	()V
    //   438: astore 4
    //   440: iconst_0
    //   441: istore_1
    //   442: iload_1
    //   443: aload_2
    //   444: invokevirtual 228	org/json/JSONArray:length	()I
    //   447: if_icmpge +196 -> 643
    //   450: aload 4
    //   452: aload_2
    //   453: iload_1
    //   454: invokevirtual 231	org/json/JSONArray:getInt	(I)I
    //   457: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   463: pop
    //   464: iload_1
    //   465: iconst_1
    //   466: iadd
    //   467: istore_1
    //   468: goto -26 -> 442
    //   471: aload 4
    //   473: ifnull +8 -> 481
    //   476: aload 4
    //   478: invokevirtual 137	java/io/BufferedReader:close	()V
    //   481: aload_0
    //   482: ifnull -352 -> 130
    //   485: aload_0
    //   486: invokevirtual 138	java/io/FileReader:close	()V
    //   489: goto -359 -> 130
    //   492: astore_0
    //   493: aload_0
    //   494: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   497: goto -367 -> 130
    //   500: astore_2
    //   501: aload_2
    //   502: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   505: goto -24 -> 481
    //   508: astore_2
    //   509: aload_2
    //   510: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   513: goto -391 -> 122
    //   516: astore_0
    //   517: aload_0
    //   518: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   521: goto -391 -> 130
    //   524: astore 6
    //   526: aconst_null
    //   527: astore 5
    //   529: aconst_null
    //   530: astore_0
    //   531: aload 5
    //   533: astore_3
    //   534: aload_0
    //   535: astore_2
    //   536: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +16 -> 555
    //   542: aload 5
    //   544: astore_3
    //   545: aload_0
    //   546: astore_2
    //   547: ldc 129
    //   549: iconst_2
    //   550: ldc 244
    //   552: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   555: aload 5
    //   557: astore_3
    //   558: aload_0
    //   559: astore_2
    //   560: aload 6
    //   562: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   565: aload_0
    //   566: ifnull +7 -> 573
    //   569: aload_0
    //   570: invokevirtual 137	java/io/BufferedReader:close	()V
    //   573: aload 5
    //   575: ifnull -445 -> 130
    //   578: aload 5
    //   580: invokevirtual 138	java/io/FileReader:close	()V
    //   583: goto -453 -> 130
    //   586: astore_0
    //   587: aload_0
    //   588: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   591: goto -461 -> 130
    //   594: astore_0
    //   595: aload_0
    //   596: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   599: goto -26 -> 573
    //   602: astore 4
    //   604: aconst_null
    //   605: astore_0
    //   606: aconst_null
    //   607: astore_2
    //   608: aload_2
    //   609: ifnull +7 -> 616
    //   612: aload_2
    //   613: invokevirtual 137	java/io/BufferedReader:close	()V
    //   616: aload_0
    //   617: ifnull +7 -> 624
    //   620: aload_0
    //   621: invokevirtual 138	java/io/FileReader:close	()V
    //   624: aload 4
    //   626: athrow
    //   627: astore_2
    //   628: aload_2
    //   629: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   632: goto -16 -> 616
    //   635: astore_0
    //   636: aload_0
    //   637: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   640: goto -16 -> 624
    //   643: aload_0
    //   644: aload 4
    //   646: putfield 247	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:aioTypes	Ljava/util/ArrayList;
    //   649: aload_3
    //   650: ldc 249
    //   652: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   655: ifne +56 -> 711
    //   658: aload_3
    //   659: ldc 249
    //   661: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   664: astore_2
    //   665: new 24	java/util/ArrayList
    //   668: dup
    //   669: invokespecial 25	java/util/ArrayList:<init>	()V
    //   672: astore 4
    //   674: iconst_0
    //   675: istore_1
    //   676: iload_1
    //   677: aload_2
    //   678: invokevirtual 228	org/json/JSONArray:length	()I
    //   681: if_icmpge +24 -> 705
    //   684: aload 4
    //   686: aload_2
    //   687: iload_1
    //   688: invokevirtual 231	org/json/JSONArray:getInt	(I)I
    //   691: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   694: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   697: pop
    //   698: iload_1
    //   699: iconst_1
    //   700: iadd
    //   701: istore_1
    //   702: goto -26 -> 676
    //   705: aload_0
    //   706: aload 4
    //   708: putfield 252	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sexTypes	Ljava/util/ArrayList;
    //   711: aload_3
    //   712: ldc 254
    //   714: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   717: ifne +13 -> 730
    //   720: aload_0
    //   721: aload_3
    //   722: ldc 254
    //   724: invokevirtual 171	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   727: putfield 257	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:timeRangeControl	Z
    //   730: aload_3
    //   731: ldc_w 259
    //   734: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   737: ifne +111 -> 848
    //   740: aload_3
    //   741: ldc_w 259
    //   744: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   747: astore_2
    //   748: new 24	java/util/ArrayList
    //   751: dup
    //   752: invokespecial 25	java/util/ArrayList:<init>	()V
    //   755: astore 4
    //   757: iconst_0
    //   758: istore_1
    //   759: iload_1
    //   760: aload_2
    //   761: invokevirtual 228	org/json/JSONArray:length	()I
    //   764: if_icmpge +78 -> 842
    //   767: aload_2
    //   768: iload_1
    //   769: invokevirtual 262	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   772: astore 5
    //   774: aload 5
    //   776: ldc_w 264
    //   779: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   782: ifne +1190 -> 1972
    //   785: aload 5
    //   787: ldc_w 266
    //   790: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   793: ifne +1179 -> 1972
    //   796: new 268	com/tencent/mobileqq/app/NearbyGrayTipsManager$TimeRangeInOneDay
    //   799: dup
    //   800: invokespecial 269	com/tencent/mobileqq/app/NearbyGrayTipsManager$TimeRangeInOneDay:<init>	()V
    //   803: astore 6
    //   805: aload 6
    //   807: aload 5
    //   809: ldc_w 264
    //   812: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   815: putfield 272	com/tencent/mobileqq/app/NearbyGrayTipsManager$TimeRangeInOneDay:beginTime	I
    //   818: aload 6
    //   820: aload 5
    //   822: ldc_w 266
    //   825: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   828: putfield 275	com/tencent/mobileqq/app/NearbyGrayTipsManager$TimeRangeInOneDay:endTime	I
    //   831: aload 4
    //   833: aload 6
    //   835: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   838: pop
    //   839: goto +1133 -> 1972
    //   842: aload_0
    //   843: aload 4
    //   845: putfield 278	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:timeRange	Ljava/util/ArrayList;
    //   848: aload_3
    //   849: ldc_w 280
    //   852: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   855: ifne +14 -> 869
    //   858: aload_0
    //   859: aload_3
    //   860: ldc_w 280
    //   863: invokevirtual 171	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   866: putfield 283	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:showKeyboard	Z
    //   869: aload_3
    //   870: ldc_w 285
    //   873: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   876: ifne +14 -> 890
    //   879: aload_0
    //   880: aload_3
    //   881: ldc_w 285
    //   884: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   887: putfield 293	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:url	Ljava/lang/String;
    //   890: aload_3
    //   891: ldc_w 295
    //   894: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   897: ifne +111 -> 1008
    //   900: aload_3
    //   901: ldc_w 295
    //   904: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   907: astore_2
    //   908: new 24	java/util/ArrayList
    //   911: dup
    //   912: invokespecial 25	java/util/ArrayList:<init>	()V
    //   915: astore 4
    //   917: iconst_0
    //   918: istore_1
    //   919: iload_1
    //   920: aload_2
    //   921: invokevirtual 228	org/json/JSONArray:length	()I
    //   924: if_icmpge +78 -> 1002
    //   927: aload_2
    //   928: iload_1
    //   929: invokevirtual 262	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   932: astore 5
    //   934: aload 5
    //   936: ldc_w 297
    //   939: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   942: ifne +1037 -> 1979
    //   945: new 299	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording
    //   948: dup
    //   949: invokespecial 300	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:<init>	()V
    //   952: astore 6
    //   954: aload 6
    //   956: aload 5
    //   958: ldc_w 297
    //   961: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   964: putfield 303	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:text	Ljava/lang/String;
    //   967: aload 5
    //   969: ldc_w 305
    //   972: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   975: ifne +16 -> 991
    //   978: aload 6
    //   980: aload 5
    //   982: ldc_w 305
    //   985: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   988: putfield 308	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:highlightText	Ljava/lang/String;
    //   991: aload 4
    //   993: aload 6
    //   995: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   998: pop
    //   999: goto +980 -> 1979
    //   1002: aload_0
    //   1003: aload 4
    //   1005: putfield 311	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:grayTipWordings	Ljava/util/ArrayList;
    //   1008: aload_3
    //   1009: ldc_w 313
    //   1012: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1015: ifne +111 -> 1126
    //   1018: aload_3
    //   1019: ldc_w 313
    //   1022: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1025: astore_2
    //   1026: new 24	java/util/ArrayList
    //   1029: dup
    //   1030: invokespecial 25	java/util/ArrayList:<init>	()V
    //   1033: astore 4
    //   1035: iconst_0
    //   1036: istore_1
    //   1037: iload_1
    //   1038: aload_2
    //   1039: invokevirtual 228	org/json/JSONArray:length	()I
    //   1042: if_icmpge +78 -> 1120
    //   1045: aload_2
    //   1046: iload_1
    //   1047: invokevirtual 262	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1050: astore 5
    //   1052: aload 5
    //   1054: ldc_w 297
    //   1057: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1060: ifne +926 -> 1986
    //   1063: new 299	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording
    //   1066: dup
    //   1067: invokespecial 300	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:<init>	()V
    //   1070: astore 6
    //   1072: aload 6
    //   1074: aload 5
    //   1076: ldc_w 297
    //   1079: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1082: putfield 303	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:text	Ljava/lang/String;
    //   1085: aload 5
    //   1087: ldc_w 305
    //   1090: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1093: ifne +16 -> 1109
    //   1096: aload 6
    //   1098: aload 5
    //   1100: ldc_w 305
    //   1103: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1106: putfield 308	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:highlightText	Ljava/lang/String;
    //   1109: aload 4
    //   1111: aload 6
    //   1113: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1116: pop
    //   1117: goto +869 -> 1986
    //   1120: aload_0
    //   1121: aload 4
    //   1123: putfield 316	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:favoriteGrayTipWordings1	Ljava/util/ArrayList;
    //   1126: aload_3
    //   1127: ldc_w 318
    //   1130: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1133: ifne +111 -> 1244
    //   1136: aload_3
    //   1137: ldc_w 318
    //   1140: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1143: astore_2
    //   1144: new 24	java/util/ArrayList
    //   1147: dup
    //   1148: invokespecial 25	java/util/ArrayList:<init>	()V
    //   1151: astore 4
    //   1153: iconst_0
    //   1154: istore_1
    //   1155: iload_1
    //   1156: aload_2
    //   1157: invokevirtual 228	org/json/JSONArray:length	()I
    //   1160: if_icmpge +78 -> 1238
    //   1163: aload_2
    //   1164: iload_1
    //   1165: invokevirtual 262	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1168: astore 5
    //   1170: aload 5
    //   1172: ldc_w 297
    //   1175: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1178: ifne +815 -> 1993
    //   1181: new 299	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording
    //   1184: dup
    //   1185: invokespecial 300	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:<init>	()V
    //   1188: astore 6
    //   1190: aload 6
    //   1192: aload 5
    //   1194: ldc_w 297
    //   1197: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1200: putfield 303	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:text	Ljava/lang/String;
    //   1203: aload 5
    //   1205: ldc_w 305
    //   1208: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1211: ifne +16 -> 1227
    //   1214: aload 6
    //   1216: aload 5
    //   1218: ldc_w 305
    //   1221: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1224: putfield 308	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:highlightText	Ljava/lang/String;
    //   1227: aload 4
    //   1229: aload 6
    //   1231: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1234: pop
    //   1235: goto +758 -> 1993
    //   1238: aload_0
    //   1239: aload 4
    //   1241: putfield 321	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:favoriteGrayTipWordings2	Ljava/util/ArrayList;
    //   1244: aload_3
    //   1245: ldc_w 323
    //   1248: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1251: ifne +14 -> 1265
    //   1254: aload_0
    //   1255: aload_3
    //   1256: ldc_w 323
    //   1259: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1262: putfield 326	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneId	I
    //   1265: aload_3
    //   1266: ldc_w 328
    //   1269: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1272: ifne +54 -> 1326
    //   1275: aload_3
    //   1276: ldc_w 328
    //   1279: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1282: astore_2
    //   1283: new 24	java/util/ArrayList
    //   1286: dup
    //   1287: invokespecial 25	java/util/ArrayList:<init>	()V
    //   1290: astore 4
    //   1292: iconst_0
    //   1293: istore_1
    //   1294: iload_1
    //   1295: aload_2
    //   1296: invokevirtual 228	org/json/JSONArray:length	()I
    //   1299: if_icmpge +21 -> 1320
    //   1302: aload 4
    //   1304: aload_2
    //   1305: iload_1
    //   1306: invokevirtual 331	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1309: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1312: pop
    //   1313: iload_1
    //   1314: iconst_1
    //   1315: iadd
    //   1316: istore_1
    //   1317: goto -23 -> 1294
    //   1320: aload_0
    //   1321: aload 4
    //   1323: putfield 334	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:randomWordings	Ljava/util/ArrayList;
    //   1326: aload_3
    //   1327: ldc_w 336
    //   1330: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1333: ifne +48 -> 1381
    //   1336: aload_3
    //   1337: ldc_w 336
    //   1340: invokevirtual 189	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1343: astore_2
    //   1344: new 338	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneOne
    //   1347: dup
    //   1348: invokespecial 339	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneOne:<init>	()V
    //   1351: astore 4
    //   1353: aload_2
    //   1354: ldc_w 341
    //   1357: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1360: ifne +15 -> 1375
    //   1363: aload 4
    //   1365: aload_2
    //   1366: ldc_w 341
    //   1369: invokevirtual 171	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1372: putfield 344	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneOne:sayHiTrigger	Z
    //   1375: aload_0
    //   1376: aload 4
    //   1378: putfield 348	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneOne	Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$SceneOne;
    //   1381: aload_3
    //   1382: ldc_w 350
    //   1385: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1388: ifne +92 -> 1480
    //   1391: aload_3
    //   1392: ldc_w 350
    //   1395: invokevirtual 189	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1398: astore_2
    //   1399: new 352	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo
    //   1402: dup
    //   1403: invokespecial 353	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo:<init>	()V
    //   1406: astore 4
    //   1408: aload_2
    //   1409: ldc_w 355
    //   1412: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1415: ifne +59 -> 1474
    //   1418: aload 4
    //   1420: aload_2
    //   1421: ldc_w 355
    //   1424: invokevirtual 171	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1427: putfield 358	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo:sayHiFrequencyControl	Z
    //   1430: aload_2
    //   1431: ldc_w 360
    //   1434: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1437: ifne +15 -> 1452
    //   1440: aload 4
    //   1442: aload_2
    //   1443: ldc_w 360
    //   1446: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1449: putfield 362	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo:timeRange	I
    //   1452: aload_2
    //   1453: ldc_w 364
    //   1456: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1459: ifne +15 -> 1474
    //   1462: aload 4
    //   1464: aload_2
    //   1465: ldc_w 364
    //   1468: invokevirtual 180	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1471: putfield 367	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo:sayHiPeopleCount	I
    //   1474: aload_0
    //   1475: aload 4
    //   1477: putfield 371	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneTwo	Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo;
    //   1480: aload_3
    //   1481: ldc_w 373
    //   1484: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1487: ifne +183 -> 1670
    //   1490: aload_3
    //   1491: ldc_w 373
    //   1494: invokevirtual 189	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1497: astore 4
    //   1499: aload 4
    //   1501: ldc_w 375
    //   1504: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1507: ifne +163 -> 1670
    //   1510: new 377	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree
    //   1513: dup
    //   1514: invokespecial 378	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree:<init>	()V
    //   1517: astore_2
    //   1518: aload_2
    //   1519: aload 4
    //   1521: ldc_w 375
    //   1524: invokevirtual 171	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1527: putfield 381	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree:keywordTrigger	Z
    //   1530: aload 4
    //   1532: ldc_w 383
    //   1535: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1538: ifne +61 -> 1599
    //   1541: aload 4
    //   1543: ldc_w 383
    //   1546: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1549: astore 5
    //   1551: new 24	java/util/ArrayList
    //   1554: dup
    //   1555: invokespecial 25	java/util/ArrayList:<init>	()V
    //   1558: astore 6
    //   1560: iconst_0
    //   1561: istore_1
    //   1562: iload_1
    //   1563: aload 5
    //   1565: invokevirtual 228	org/json/JSONArray:length	()I
    //   1568: if_icmpge +25 -> 1593
    //   1571: aload 6
    //   1573: aload 5
    //   1575: iload_1
    //   1576: invokevirtual 231	org/json/JSONArray:getInt	(I)I
    //   1579: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1582: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1585: pop
    //   1586: iload_1
    //   1587: iconst_1
    //   1588: iadd
    //   1589: istore_1
    //   1590: goto -28 -> 1562
    //   1593: aload_2
    //   1594: aload 6
    //   1596: putfield 386	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree:whichSide	Ljava/util/ArrayList;
    //   1599: aload 4
    //   1601: ldc_w 388
    //   1604: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1607: ifne +58 -> 1665
    //   1610: aload 4
    //   1612: ldc_w 388
    //   1615: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1618: astore 4
    //   1620: new 24	java/util/ArrayList
    //   1623: dup
    //   1624: invokespecial 25	java/util/ArrayList:<init>	()V
    //   1627: astore 5
    //   1629: iconst_0
    //   1630: istore_1
    //   1631: iload_1
    //   1632: aload 4
    //   1634: invokevirtual 228	org/json/JSONArray:length	()I
    //   1637: if_icmpge +22 -> 1659
    //   1640: aload 5
    //   1642: aload 4
    //   1644: iload_1
    //   1645: invokevirtual 331	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1648: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1651: pop
    //   1652: iload_1
    //   1653: iconst_1
    //   1654: iadd
    //   1655: istore_1
    //   1656: goto -25 -> 1631
    //   1659: aload_2
    //   1660: aload 5
    //   1662: putfield 391	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree:keywords	Ljava/util/ArrayList;
    //   1665: aload_0
    //   1666: aload_2
    //   1667: putfield 395	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneThree	Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree;
    //   1670: aload_3
    //   1671: ldc_w 397
    //   1674: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1677: ifne +38 -> 1715
    //   1680: aload_3
    //   1681: ldc_w 397
    //   1684: invokevirtual 189	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1687: astore_2
    //   1688: new 399	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFour
    //   1691: dup
    //   1692: invokespecial 400	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFour:<init>	()V
    //   1695: astore 4
    //   1697: aload 4
    //   1699: aload_2
    //   1700: ldc_w 402
    //   1703: invokevirtual 171	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1706: putfield 405	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFour:enterAIOTrigger	Z
    //   1709: aload_0
    //   1710: aload 4
    //   1712: putfield 409	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneFour	Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFour;
    //   1715: aload_0
    //   1716: astore_2
    //   1717: aload_3
    //   1718: ldc_w 411
    //   1721: invokevirtual 157	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1724: ifne -1711 -> 13
    //   1727: aload_3
    //   1728: ldc_w 411
    //   1731: invokevirtual 189	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1734: astore_3
    //   1735: new 413	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFive
    //   1738: dup
    //   1739: invokespecial 414	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFive:<init>	()V
    //   1742: astore_2
    //   1743: aload_2
    //   1744: aload_3
    //   1745: ldc_w 416
    //   1748: invokevirtual 171	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1751: putfield 419	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFive:faceScoreTrigger	Z
    //   1754: aload_3
    //   1755: ldc_w 421
    //   1758: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1761: astore 4
    //   1763: new 24	java/util/ArrayList
    //   1766: dup
    //   1767: invokespecial 25	java/util/ArrayList:<init>	()V
    //   1770: astore 5
    //   1772: iconst_0
    //   1773: istore_1
    //   1774: iload_1
    //   1775: aload 4
    //   1777: invokevirtual 228	org/json/JSONArray:length	()I
    //   1780: if_icmpge +22 -> 1802
    //   1783: aload 5
    //   1785: aload 4
    //   1787: iload_1
    //   1788: invokevirtual 331	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1791: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1794: pop
    //   1795: iload_1
    //   1796: iconst_1
    //   1797: iadd
    //   1798: istore_1
    //   1799: goto -25 -> 1774
    //   1802: aload_2
    //   1803: aload 5
    //   1805: putfield 424	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFive:randomWordingForMale	Ljava/util/ArrayList;
    //   1808: aload_3
    //   1809: ldc_w 426
    //   1812: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1815: astore_3
    //   1816: new 24	java/util/ArrayList
    //   1819: dup
    //   1820: invokespecial 25	java/util/ArrayList:<init>	()V
    //   1823: astore 4
    //   1825: iconst_0
    //   1826: istore_1
    //   1827: iload_1
    //   1828: aload_3
    //   1829: invokevirtual 228	org/json/JSONArray:length	()I
    //   1832: if_icmpge +21 -> 1853
    //   1835: aload 4
    //   1837: aload_3
    //   1838: iload_1
    //   1839: invokevirtual 331	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1842: invokevirtual 241	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1845: pop
    //   1846: iload_1
    //   1847: iconst_1
    //   1848: iadd
    //   1849: istore_1
    //   1850: goto -23 -> 1827
    //   1853: aload_2
    //   1854: aload 4
    //   1856: putfield 429	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFive:randomWordingForFeMale	Ljava/util/ArrayList;
    //   1859: aload_0
    //   1860: aload_2
    //   1861: putfield 433	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneFive	Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFive;
    //   1864: aload_0
    //   1865: areturn
    //   1866: astore_2
    //   1867: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1870: ifeq +33 -> 1903
    //   1873: ldc 129
    //   1875: iconst_2
    //   1876: new 65	java/lang/StringBuilder
    //   1879: dup
    //   1880: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1883: ldc_w 435
    //   1886: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1889: aload 7
    //   1891: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1894: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1897: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1900: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1903: aload_2
    //   1904: invokevirtual 436	org/json/JSONException:printStackTrace	()V
    //   1907: aload_0
    //   1908: areturn
    //   1909: astore_2
    //   1910: aconst_null
    //   1911: astore_0
    //   1912: goto -45 -> 1867
    //   1915: astore 4
    //   1917: aconst_null
    //   1918: astore_2
    //   1919: goto -1311 -> 608
    //   1922: astore 4
    //   1924: aload_3
    //   1925: astore_0
    //   1926: goto -1318 -> 608
    //   1929: astore 6
    //   1931: aconst_null
    //   1932: astore_2
    //   1933: aload_0
    //   1934: astore 5
    //   1936: aload_2
    //   1937: astore_0
    //   1938: goto -1407 -> 531
    //   1941: astore 6
    //   1943: aload_0
    //   1944: astore 5
    //   1946: aload 4
    //   1948: astore_0
    //   1949: goto -1418 -> 531
    //   1952: astore 5
    //   1954: aconst_null
    //   1955: astore_0
    //   1956: aconst_null
    //   1957: astore 4
    //   1959: goto -1881 -> 78
    //   1962: astore 5
    //   1964: aconst_null
    //   1965: astore 4
    //   1967: goto -1889 -> 78
    //   1970: aconst_null
    //   1971: areturn
    //   1972: iload_1
    //   1973: iconst_1
    //   1974: iadd
    //   1975: istore_1
    //   1976: goto -1217 -> 759
    //   1979: iload_1
    //   1980: iconst_1
    //   1981: iadd
    //   1982: istore_1
    //   1983: goto -1064 -> 919
    //   1986: iload_1
    //   1987: iconst_1
    //   1988: iadd
    //   1989: istore_1
    //   1990: goto -953 -> 1037
    //   1993: iload_1
    //   1994: iconst_1
    //   1995: iadd
    //   1996: istore_1
    //   1997: goto -842 -> 1155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2000	0	paramFile	File
    //   441	1556	1	i	int
    //   12	441	2	localObject1	Object
    //   500	2	2	localIOException1	java.io.IOException
    //   508	2	2	localIOException2	java.io.IOException
    //   535	78	2	localFile	File
    //   627	2	2	localIOException3	java.io.IOException
    //   664	1197	2	localObject2	Object
    //   1866	38	2	localJSONException1	org.json.JSONException
    //   1909	1	2	localJSONException2	org.json.JSONException
    //   1918	19	2	localObject3	Object
    //   44	1881	3	localObject4	Object
    //   41	436	4	localObject5	Object
    //   602	43	4	localObject6	Object
    //   672	1183	4	localObject7	Object
    //   1915	1	4	localObject8	Object
    //   1922	25	4	localObject9	Object
    //   1957	9	4	localObject10	Object
    //   53	15	5	str	String
    //   76	32	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   527	1418	5	localObject11	Object
    //   1952	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   1962	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   524	37	6	localIOException4	java.io.IOException
    //   803	792	6	localObject12	Object
    //   1929	1	6	localIOException5	java.io.IOException
    //   1941	1	6	localIOException6	java.io.IOException
    //   22	1868	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	55	76	java/io/FileNotFoundException
    //   65	73	76	java/io/FileNotFoundException
    //   485	489	492	java/io/IOException
    //   476	481	500	java/io/IOException
    //   117	122	508	java/io/IOException
    //   126	130	516	java/io/IOException
    //   24	33	524	java/io/IOException
    //   578	583	586	java/io/IOException
    //   569	573	594	java/io/IOException
    //   24	33	602	finally
    //   612	616	627	java/io/IOException
    //   620	624	635	java/io/IOException
    //   190	213	1866	org/json/JSONException
    //   213	232	1866	org/json/JSONException
    //   232	251	1866	org/json/JSONException
    //   251	286	1866	org/json/JSONException
    //   286	305	1866	org/json/JSONException
    //   307	342	1866	org/json/JSONException
    //   342	361	1866	org/json/JSONException
    //   361	396	1866	org/json/JSONException
    //   396	415	1866	org/json/JSONException
    //   415	440	1866	org/json/JSONException
    //   442	464	1866	org/json/JSONException
    //   643	649	1866	org/json/JSONException
    //   649	674	1866	org/json/JSONException
    //   676	698	1866	org/json/JSONException
    //   705	711	1866	org/json/JSONException
    //   711	730	1866	org/json/JSONException
    //   730	757	1866	org/json/JSONException
    //   759	839	1866	org/json/JSONException
    //   842	848	1866	org/json/JSONException
    //   848	869	1866	org/json/JSONException
    //   869	890	1866	org/json/JSONException
    //   890	917	1866	org/json/JSONException
    //   919	991	1866	org/json/JSONException
    //   991	999	1866	org/json/JSONException
    //   1002	1008	1866	org/json/JSONException
    //   1008	1035	1866	org/json/JSONException
    //   1037	1109	1866	org/json/JSONException
    //   1109	1117	1866	org/json/JSONException
    //   1120	1126	1866	org/json/JSONException
    //   1126	1153	1866	org/json/JSONException
    //   1155	1227	1866	org/json/JSONException
    //   1227	1235	1866	org/json/JSONException
    //   1238	1244	1866	org/json/JSONException
    //   1244	1265	1866	org/json/JSONException
    //   1265	1292	1866	org/json/JSONException
    //   1294	1313	1866	org/json/JSONException
    //   1320	1326	1866	org/json/JSONException
    //   1326	1375	1866	org/json/JSONException
    //   1375	1381	1866	org/json/JSONException
    //   1381	1452	1866	org/json/JSONException
    //   1452	1474	1866	org/json/JSONException
    //   1474	1480	1866	org/json/JSONException
    //   1480	1560	1866	org/json/JSONException
    //   1562	1586	1866	org/json/JSONException
    //   1593	1599	1866	org/json/JSONException
    //   1599	1629	1866	org/json/JSONException
    //   1631	1652	1866	org/json/JSONException
    //   1659	1665	1866	org/json/JSONException
    //   1665	1670	1866	org/json/JSONException
    //   1670	1715	1866	org/json/JSONException
    //   1717	1772	1866	org/json/JSONException
    //   1774	1795	1866	org/json/JSONException
    //   1802	1825	1866	org/json/JSONException
    //   1827	1846	1866	org/json/JSONException
    //   1853	1864	1866	org/json/JSONException
    //   138	182	1909	org/json/JSONException
    //   182	190	1909	org/json/JSONException
    //   33	43	1915	finally
    //   48	55	1922	finally
    //   65	73	1922	finally
    //   83	89	1922	finally
    //   94	102	1922	finally
    //   107	112	1922	finally
    //   536	542	1922	finally
    //   547	555	1922	finally
    //   560	565	1922	finally
    //   33	43	1929	java/io/IOException
    //   48	55	1941	java/io/IOException
    //   65	73	1941	java/io/IOException
    //   24	33	1952	java/io/FileNotFoundException
    //   33	43	1962	java/io/FileNotFoundException
  }
  
  private NearbyGrayTipsManager.GreetWording a(int paramInt)
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      NearbyGrayTipsManager.GreetWording localGreetWording = null;
      if (i < j)
      {
        localGreetWording = (NearbyGrayTipsManager.GreetWording)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localGreetWording != null) {
          if (localGreetWording.id != paramInt) {
            break label82;
          }
        }
      }
      else
      {
        return localGreetWording;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label82:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public static Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 445	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 446	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 448	java/io/BufferedInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 451	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_1
    //   21: new 453	java/io/ObjectInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 454	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 5
    //   31: aload 5
    //   33: astore 4
    //   35: aload_1
    //   36: astore_3
    //   37: aload_0
    //   38: astore_2
    //   39: aload 5
    //   41: invokevirtual 458	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   44: astore 6
    //   46: aload 6
    //   48: astore_2
    //   49: aload 5
    //   51: ifnull +8 -> 59
    //   54: aload 5
    //   56: invokevirtual 459	java/io/ObjectInputStream:close	()V
    //   59: aload_1
    //   60: ifnull +7 -> 67
    //   63: aload_1
    //   64: invokevirtual 460	java/io/BufferedInputStream:close	()V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull +9 -> 79
    //   73: aload_0
    //   74: invokevirtual 461	java/io/FileInputStream:close	()V
    //   77: aload_2
    //   78: astore_1
    //   79: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +39 -> 121
    //   85: new 65	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 463
    //   95: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: astore_2
    //   99: aload_1
    //   100: ifnonnull +283 -> 383
    //   103: ldc_w 465
    //   106: astore_0
    //   107: ldc 129
    //   109: iconst_2
    //   110: aload_2
    //   111: aload_0
    //   112: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 468	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_1
    //   122: areturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   128: aload_2
    //   129: astore_1
    //   130: goto -51 -> 79
    //   133: astore 6
    //   135: aconst_null
    //   136: astore 5
    //   138: aconst_null
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: aload 5
    //   144: astore 4
    //   146: aload_1
    //   147: astore_3
    //   148: aload_0
    //   149: astore_2
    //   150: aload 6
    //   152: invokevirtual 134	java/io/FileNotFoundException:printStackTrace	()V
    //   155: aload 5
    //   157: ifnull +8 -> 165
    //   160: aload 5
    //   162: invokevirtual 459	java/io/ObjectInputStream:close	()V
    //   165: aload_1
    //   166: ifnull +7 -> 173
    //   169: aload_1
    //   170: invokevirtual 460	java/io/BufferedInputStream:close	()V
    //   173: aload 7
    //   175: astore_1
    //   176: aload_0
    //   177: ifnull -98 -> 79
    //   180: aload_0
    //   181: invokevirtual 461	java/io/FileInputStream:close	()V
    //   184: aload 7
    //   186: astore_1
    //   187: goto -108 -> 79
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   195: aload 7
    //   197: astore_1
    //   198: goto -119 -> 79
    //   201: astore 6
    //   203: aconst_null
    //   204: astore 5
    //   206: aconst_null
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_0
    //   210: aload 5
    //   212: astore 4
    //   214: aload_1
    //   215: astore_3
    //   216: aload_0
    //   217: astore_2
    //   218: aload 6
    //   220: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 459	java/io/ObjectInputStream:close	()V
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 460	java/io/BufferedInputStream:close	()V
    //   241: aload 7
    //   243: astore_1
    //   244: aload_0
    //   245: ifnull -166 -> 79
    //   248: aload_0
    //   249: invokevirtual 461	java/io/FileInputStream:close	()V
    //   252: aload 7
    //   254: astore_1
    //   255: goto -176 -> 79
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   263: aload 7
    //   265: astore_1
    //   266: goto -187 -> 79
    //   269: astore 6
    //   271: aconst_null
    //   272: astore 5
    //   274: aconst_null
    //   275: astore_1
    //   276: aconst_null
    //   277: astore_0
    //   278: aload 5
    //   280: astore 4
    //   282: aload_1
    //   283: astore_3
    //   284: aload_0
    //   285: astore_2
    //   286: aload 6
    //   288: invokevirtual 469	java/lang/Exception:printStackTrace	()V
    //   291: aload 5
    //   293: ifnull +8 -> 301
    //   296: aload 5
    //   298: invokevirtual 459	java/io/ObjectInputStream:close	()V
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 460	java/io/BufferedInputStream:close	()V
    //   309: aload 7
    //   311: astore_1
    //   312: aload_0
    //   313: ifnull -234 -> 79
    //   316: aload_0
    //   317: invokevirtual 461	java/io/FileInputStream:close	()V
    //   320: aload 7
    //   322: astore_1
    //   323: goto -244 -> 79
    //   326: astore_0
    //   327: aload_0
    //   328: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   331: aload 7
    //   333: astore_1
    //   334: goto -255 -> 79
    //   337: astore 5
    //   339: aconst_null
    //   340: astore 4
    //   342: aconst_null
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_0
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 459	java/io/ObjectInputStream:close	()V
    //   356: aload_1
    //   357: ifnull +7 -> 364
    //   360: aload_1
    //   361: invokevirtual 460	java/io/BufferedInputStream:close	()V
    //   364: aload_0
    //   365: ifnull +7 -> 372
    //   368: aload_0
    //   369: invokevirtual 461	java/io/FileInputStream:close	()V
    //   372: aload 5
    //   374: athrow
    //   375: astore_0
    //   376: aload_0
    //   377: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   380: goto -8 -> 372
    //   383: aload_1
    //   384: invokevirtual 470	java/lang/Object:toString	()Ljava/lang/String;
    //   387: astore_0
    //   388: goto -281 -> 107
    //   391: astore 5
    //   393: aconst_null
    //   394: astore 4
    //   396: aconst_null
    //   397: astore_1
    //   398: goto -52 -> 346
    //   401: astore 5
    //   403: aconst_null
    //   404: astore 4
    //   406: goto -60 -> 346
    //   409: astore 5
    //   411: aload_3
    //   412: astore_1
    //   413: aload_2
    //   414: astore_0
    //   415: goto -69 -> 346
    //   418: astore 6
    //   420: aconst_null
    //   421: astore 5
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -147 -> 278
    //   428: astore 6
    //   430: aconst_null
    //   431: astore 5
    //   433: goto -155 -> 278
    //   436: astore 6
    //   438: goto -160 -> 278
    //   441: astore 6
    //   443: aconst_null
    //   444: astore 5
    //   446: aconst_null
    //   447: astore_1
    //   448: goto -238 -> 210
    //   451: astore 6
    //   453: aconst_null
    //   454: astore 5
    //   456: goto -246 -> 210
    //   459: astore 6
    //   461: goto -251 -> 210
    //   464: astore 6
    //   466: aconst_null
    //   467: astore 5
    //   469: aconst_null
    //   470: astore_1
    //   471: goto -329 -> 142
    //   474: astore 6
    //   476: aconst_null
    //   477: astore 5
    //   479: goto -337 -> 142
    //   482: astore 6
    //   484: goto -342 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramString	String
    //   20	451	1	localObject1	Object
    //   38	376	2	localObject2	Object
    //   36	376	3	localObject3	Object
    //   33	372	4	localObjectInputStream1	java.io.ObjectInputStream
    //   29	268	5	localObjectInputStream2	java.io.ObjectInputStream
    //   337	36	5	localObject4	Object
    //   391	1	5	localObject5	Object
    //   401	1	5	localObject6	Object
    //   409	1	5	localObject7	Object
    //   421	57	5	localObject8	Object
    //   44	3	6	localObject9	Object
    //   133	18	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   201	18	6	localIOException1	java.io.IOException
    //   269	18	6	localException1	java.lang.Exception
    //   418	1	6	localException2	java.lang.Exception
    //   428	1	6	localException3	java.lang.Exception
    //   436	1	6	localException4	java.lang.Exception
    //   441	1	6	localIOException2	java.io.IOException
    //   451	1	6	localIOException3	java.io.IOException
    //   459	1	6	localIOException4	java.io.IOException
    //   464	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   474	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   482	1	6	localFileNotFoundException4	java.io.FileNotFoundException
    //   1	331	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   54	59	123	java/io/IOException
    //   63	67	123	java/io/IOException
    //   73	77	123	java/io/IOException
    //   3	12	133	java/io/FileNotFoundException
    //   160	165	190	java/io/IOException
    //   169	173	190	java/io/IOException
    //   180	184	190	java/io/IOException
    //   3	12	201	java/io/IOException
    //   228	233	258	java/io/IOException
    //   237	241	258	java/io/IOException
    //   248	252	258	java/io/IOException
    //   3	12	269	java/lang/Exception
    //   296	301	326	java/io/IOException
    //   305	309	326	java/io/IOException
    //   316	320	326	java/io/IOException
    //   3	12	337	finally
    //   351	356	375	java/io/IOException
    //   360	364	375	java/io/IOException
    //   368	372	375	java/io/IOException
    //   12	21	391	finally
    //   21	31	401	finally
    //   39	46	409	finally
    //   150	155	409	finally
    //   218	223	409	finally
    //   286	291	409	finally
    //   12	21	418	java/lang/Exception
    //   21	31	428	java/lang/Exception
    //   39	46	436	java/lang/Exception
    //   12	21	441	java/io/IOException
    //   21	31	451	java/io/IOException
    //   39	46	459	java/io/IOException
    //   12	21	464	java/io/FileNotFoundException
    //   21	31	474	java/io/FileNotFoundException
    //   39	46	482	java/io/FileNotFoundException
  }
  
  public static String a()
  {
    File localFile = new File(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/nearby_gray_tips_configs");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + "/";
  }
  
  /* Error */
  public static void a(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 9
    //   15: aload_0
    //   16: ifnonnull +19 -> 35
    //   19: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +12 -> 34
    //   25: ldc 129
    //   27: iconst_2
    //   28: ldc_w 496
    //   31: invokestatic 468	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: return
    //   35: iconst_0
    //   36: istore_3
    //   37: new 498	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 499	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: new 501	java/io/BufferedOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 504	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore 4
    //   56: aload 4
    //   58: astore 6
    //   60: aload 5
    //   62: astore 7
    //   64: aload_1
    //   65: astore 5
    //   67: new 506	java/io/ObjectOutputStream
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 507	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   76: astore 8
    //   78: aload 8
    //   80: aload_0
    //   81: invokevirtual 511	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   84: aload 4
    //   86: invokevirtual 514	java/io/BufferedOutputStream:flush	()V
    //   89: iconst_1
    //   90: istore_3
    //   91: aload 4
    //   93: ifnull +8 -> 101
    //   96: aload 4
    //   98: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   101: aload 8
    //   103: ifnull +8 -> 111
    //   106: aload 8
    //   108: invokevirtual 516	java/io/ObjectOutputStream:close	()V
    //   111: iload_3
    //   112: istore_2
    //   113: aload_1
    //   114: ifnull +9 -> 123
    //   117: aload_1
    //   118: invokevirtual 517	java/io/FileOutputStream:close	()V
    //   121: iload_3
    //   122: istore_2
    //   123: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq -92 -> 34
    //   129: ldc 129
    //   131: iconst_2
    //   132: new 65	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 519
    //   142: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload_2
    //   146: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   149: ldc_w 524
    //   152: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: invokevirtual 470	java/lang/Object:toString	()Ljava/lang/String;
    //   159: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 468	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: return
    //   169: astore 4
    //   171: aload 4
    //   173: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   176: goto -75 -> 101
    //   179: astore 4
    //   181: aload 4
    //   183: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   186: goto -75 -> 111
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   194: iload_3
    //   195: istore_2
    //   196: goto -73 -> 123
    //   199: astore 5
    //   201: aconst_null
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_1
    //   206: aload 9
    //   208: astore 7
    //   210: aload 5
    //   212: invokevirtual 134	java/io/FileNotFoundException:printStackTrace	()V
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   225: aload 7
    //   227: ifnull +8 -> 235
    //   230: aload 7
    //   232: invokevirtual 516	java/io/ObjectOutputStream:close	()V
    //   235: iload_3
    //   236: istore_2
    //   237: aload_1
    //   238: ifnull -115 -> 123
    //   241: aload_1
    //   242: invokevirtual 517	java/io/FileOutputStream:close	()V
    //   245: iload_3
    //   246: istore_2
    //   247: goto -124 -> 123
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   255: iload_3
    //   256: istore_2
    //   257: goto -134 -> 123
    //   260: astore 4
    //   262: aload 4
    //   264: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   267: goto -42 -> 225
    //   270: astore 4
    //   272: aload 4
    //   274: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   277: goto -42 -> 235
    //   280: astore 8
    //   282: aconst_null
    //   283: astore 4
    //   285: aconst_null
    //   286: astore_1
    //   287: aload 10
    //   289: astore 9
    //   291: aload 4
    //   293: astore 6
    //   295: aload 9
    //   297: astore 7
    //   299: aload_1
    //   300: astore 5
    //   302: aload 8
    //   304: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   307: aload 4
    //   309: ifnull +8 -> 317
    //   312: aload 4
    //   314: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   317: aload 9
    //   319: ifnull +8 -> 327
    //   322: aload 9
    //   324: invokevirtual 516	java/io/ObjectOutputStream:close	()V
    //   327: iload_3
    //   328: istore_2
    //   329: aload_1
    //   330: ifnull -207 -> 123
    //   333: aload_1
    //   334: invokevirtual 517	java/io/FileOutputStream:close	()V
    //   337: iload_3
    //   338: istore_2
    //   339: goto -216 -> 123
    //   342: astore_1
    //   343: aload_1
    //   344: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   347: iload_3
    //   348: istore_2
    //   349: goto -226 -> 123
    //   352: astore 4
    //   354: aload 4
    //   356: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   359: goto -42 -> 317
    //   362: astore 4
    //   364: aload 4
    //   366: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   369: goto -42 -> 327
    //   372: astore 8
    //   374: aconst_null
    //   375: astore 4
    //   377: aconst_null
    //   378: astore_1
    //   379: aload 11
    //   381: astore 9
    //   383: aload 4
    //   385: astore 6
    //   387: aload 9
    //   389: astore 7
    //   391: aload_1
    //   392: astore 5
    //   394: aload 8
    //   396: invokevirtual 469	java/lang/Exception:printStackTrace	()V
    //   399: aload 4
    //   401: ifnull +8 -> 409
    //   404: aload 4
    //   406: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   409: aload 9
    //   411: ifnull +8 -> 419
    //   414: aload 9
    //   416: invokevirtual 516	java/io/ObjectOutputStream:close	()V
    //   419: iload_3
    //   420: istore_2
    //   421: aload_1
    //   422: ifnull -299 -> 123
    //   425: aload_1
    //   426: invokevirtual 517	java/io/FileOutputStream:close	()V
    //   429: iload_3
    //   430: istore_2
    //   431: goto -308 -> 123
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   439: iload_3
    //   440: istore_2
    //   441: goto -318 -> 123
    //   444: astore 4
    //   446: aload 4
    //   448: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   451: goto -42 -> 409
    //   454: astore 4
    //   456: aload 4
    //   458: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   461: goto -42 -> 419
    //   464: astore_0
    //   465: aconst_null
    //   466: astore 4
    //   468: aconst_null
    //   469: astore_1
    //   470: aload 4
    //   472: ifnull +8 -> 480
    //   475: aload 4
    //   477: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   480: aload 7
    //   482: ifnull +8 -> 490
    //   485: aload 7
    //   487: invokevirtual 516	java/io/ObjectOutputStream:close	()V
    //   490: aload_1
    //   491: ifnull +7 -> 498
    //   494: aload_1
    //   495: invokevirtual 517	java/io/FileOutputStream:close	()V
    //   498: aload_0
    //   499: athrow
    //   500: astore 4
    //   502: aload 4
    //   504: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   507: goto -27 -> 480
    //   510: astore 4
    //   512: aload 4
    //   514: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   517: goto -27 -> 490
    //   520: astore_1
    //   521: aload_1
    //   522: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   525: goto -27 -> 498
    //   528: astore_0
    //   529: aconst_null
    //   530: astore 4
    //   532: goto -62 -> 470
    //   535: astore_0
    //   536: aload 6
    //   538: astore 4
    //   540: aload 5
    //   542: astore_1
    //   543: goto -73 -> 470
    //   546: astore_0
    //   547: aload 8
    //   549: astore 7
    //   551: goto -81 -> 470
    //   554: astore_0
    //   555: goto -85 -> 470
    //   558: astore 8
    //   560: aconst_null
    //   561: astore 4
    //   563: aload 11
    //   565: astore 9
    //   567: goto -184 -> 383
    //   570: astore 8
    //   572: aload 11
    //   574: astore 9
    //   576: goto -193 -> 383
    //   579: astore 5
    //   581: aload 8
    //   583: astore 9
    //   585: aload 5
    //   587: astore 8
    //   589: goto -206 -> 383
    //   592: astore 8
    //   594: aconst_null
    //   595: astore 4
    //   597: aload 10
    //   599: astore 9
    //   601: goto -310 -> 291
    //   604: astore 8
    //   606: aload 10
    //   608: astore 9
    //   610: goto -319 -> 291
    //   613: astore 5
    //   615: aload 8
    //   617: astore 9
    //   619: aload 5
    //   621: astore 8
    //   623: goto -332 -> 291
    //   626: astore 5
    //   628: aconst_null
    //   629: astore 4
    //   631: aload 9
    //   633: astore 7
    //   635: goto -425 -> 210
    //   638: astore 5
    //   640: aload 9
    //   642: astore 7
    //   644: goto -434 -> 210
    //   647: astore 5
    //   649: aload 8
    //   651: astore 7
    //   653: goto -443 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	paramObject	Object
    //   0	656	1	paramString	String
    //   112	329	2	bool1	boolean
    //   36	404	3	bool2	boolean
    //   54	43	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   169	3	4	localIOException1	java.io.IOException
    //   179	3	4	localIOException2	java.io.IOException
    //   202	19	4	localObject1	Object
    //   260	3	4	localIOException3	java.io.IOException
    //   270	3	4	localIOException4	java.io.IOException
    //   283	30	4	localObject2	Object
    //   352	3	4	localIOException5	java.io.IOException
    //   362	3	4	localIOException6	java.io.IOException
    //   375	30	4	localObject3	Object
    //   444	3	4	localIOException7	java.io.IOException
    //   454	3	4	localIOException8	java.io.IOException
    //   466	10	4	localObject4	Object
    //   500	3	4	localIOException9	java.io.IOException
    //   510	3	4	localIOException10	java.io.IOException
    //   530	100	4	localObject5	Object
    //   10	56	5	str1	String
    //   199	12	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   300	241	5	str2	String
    //   579	7	5	localException1	java.lang.Exception
    //   613	7	5	localIOException11	java.io.IOException
    //   626	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   638	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   647	1	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   58	479	6	localObject6	Object
    //   7	645	7	localObject7	Object
    //   76	31	8	localObjectOutputStream	java.io.ObjectOutputStream
    //   280	23	8	localIOException12	java.io.IOException
    //   372	176	8	localException2	java.lang.Exception
    //   558	1	8	localException3	java.lang.Exception
    //   570	12	8	localException4	java.lang.Exception
    //   587	1	8	localException5	java.lang.Exception
    //   592	1	8	localIOException13	java.io.IOException
    //   604	12	8	localIOException14	java.io.IOException
    //   621	29	8	localIOException15	java.io.IOException
    //   13	628	9	localObject8	Object
    //   1	606	10	localObject9	Object
    //   4	569	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   96	101	169	java/io/IOException
    //   106	111	179	java/io/IOException
    //   117	121	189	java/io/IOException
    //   37	46	199	java/io/FileNotFoundException
    //   241	245	250	java/io/IOException
    //   220	225	260	java/io/IOException
    //   230	235	270	java/io/IOException
    //   37	46	280	java/io/IOException
    //   333	337	342	java/io/IOException
    //   312	317	352	java/io/IOException
    //   322	327	362	java/io/IOException
    //   37	46	372	java/lang/Exception
    //   425	429	434	java/io/IOException
    //   404	409	444	java/io/IOException
    //   414	419	454	java/io/IOException
    //   37	46	464	finally
    //   475	480	500	java/io/IOException
    //   485	490	510	java/io/IOException
    //   494	498	520	java/io/IOException
    //   46	56	528	finally
    //   67	78	535	finally
    //   302	307	535	finally
    //   394	399	535	finally
    //   78	89	546	finally
    //   210	215	554	finally
    //   46	56	558	java/lang/Exception
    //   67	78	570	java/lang/Exception
    //   78	89	579	java/lang/Exception
    //   46	56	592	java/io/IOException
    //   67	78	604	java/io/IOException
    //   78	89	613	java/io/IOException
    //   46	56	626	java/io/FileNotFoundException
    //   67	78	638	java/io/FileNotFoundException
    //   78	89	647	java/io/FileNotFoundException
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    if (localCalendar1.get(6) != localCalendar2.get(6)) {}
    while (localCalendar1.get(1) != localCalendar2.get(1)) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_0
    //   15: ifnonnull +5 -> 20
    //   18: iload_1
    //   19: ireturn
    //   20: new 498	java/io/FileOutputStream
    //   23: dup
    //   24: new 65	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   31: invokestatic 539	com/tencent/mobileqq/app/NearbyGrayTipsManager:a	()Ljava/lang/String;
    //   34: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 204	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:id	I
    //   41: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc_w 541
    //   47: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 499	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_2
    //   57: new 501	java/io/BufferedOutputStream
    //   60: dup
    //   61: aload_2
    //   62: invokespecial 504	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_3
    //   66: aload_3
    //   67: astore 6
    //   69: aload_2
    //   70: astore 5
    //   72: new 506	java/io/ObjectOutputStream
    //   75: dup
    //   76: aload_3
    //   77: invokespecial 507	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   80: astore 4
    //   82: aload 4
    //   84: aload_0
    //   85: invokevirtual 511	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   88: aload_3
    //   89: invokevirtual 514	java/io/BufferedOutputStream:flush	()V
    //   92: iconst_1
    //   93: istore_1
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 516	java/io/ObjectOutputStream:close	()V
    //   104: aload_3
    //   105: ifnull +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   112: aload_2
    //   113: ifnull -95 -> 18
    //   116: aload_2
    //   117: invokevirtual 517	java/io/FileOutputStream:close	()V
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   127: iconst_1
    //   128: ireturn
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_3
    //   135: invokevirtual 134	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 516	java/io/ObjectOutputStream:close	()V
    //   146: aload 4
    //   148: ifnull +8 -> 156
    //   151: aload 4
    //   153: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   156: aload_2
    //   157: ifnull -139 -> 18
    //   160: aload_2
    //   161: invokevirtual 517	java/io/FileOutputStream:close	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_0
    //   174: aconst_null
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_2
    //   178: aload 8
    //   180: astore 4
    //   182: aload 4
    //   184: astore 7
    //   186: aload_3
    //   187: astore 6
    //   189: aload_2
    //   190: astore 5
    //   192: aload_0
    //   193: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   196: aload 4
    //   198: ifnull +8 -> 206
    //   201: aload 4
    //   203: invokevirtual 516	java/io/ObjectOutputStream:close	()V
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   214: aload_2
    //   215: ifnull -197 -> 18
    //   218: aload_2
    //   219: invokevirtual 517	java/io/FileOutputStream:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_0
    //   232: aconst_null
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_2
    //   236: aload 5
    //   238: astore 4
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 516	java/io/ObjectOutputStream:close	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   258: aload_2
    //   259: ifnull +7 -> 266
    //   262: aload_2
    //   263: invokevirtual 517	java/io/FileOutputStream:close	()V
    //   266: aload_0
    //   267: athrow
    //   268: astore_2
    //   269: aload_2
    //   270: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   273: goto -7 -> 266
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_3
    //   279: aload 5
    //   281: astore 4
    //   283: goto -43 -> 240
    //   286: astore_0
    //   287: aload 7
    //   289: astore 4
    //   291: aload 6
    //   293: astore_3
    //   294: aload 5
    //   296: astore_2
    //   297: goto -57 -> 240
    //   300: astore_0
    //   301: goto -61 -> 240
    //   304: astore 5
    //   306: aload 4
    //   308: astore_3
    //   309: aload_0
    //   310: astore 4
    //   312: aload 5
    //   314: astore_0
    //   315: goto -75 -> 240
    //   318: astore_0
    //   319: aconst_null
    //   320: astore_3
    //   321: aload 8
    //   323: astore 4
    //   325: goto -143 -> 182
    //   328: astore_0
    //   329: aload 8
    //   331: astore 4
    //   333: goto -151 -> 182
    //   336: astore_0
    //   337: goto -155 -> 182
    //   340: astore_3
    //   341: aconst_null
    //   342: astore_0
    //   343: goto -209 -> 134
    //   346: astore 5
    //   348: aconst_null
    //   349: astore_0
    //   350: aload_3
    //   351: astore 4
    //   353: aload 5
    //   355: astore_3
    //   356: goto -222 -> 134
    //   359: astore_0
    //   360: aload_3
    //   361: astore 5
    //   363: aload_0
    //   364: astore_3
    //   365: aload 4
    //   367: astore_0
    //   368: aload 5
    //   370: astore 4
    //   372: goto -238 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramGrayTipsConfig	NearbyGrayTipsManager.GrayTipsConfig
    //   1	93	1	bool	boolean
    //   56	207	2	localFileOutputStream	java.io.FileOutputStream
    //   268	2	2	localIOException	java.io.IOException
    //   296	1	2	localObject1	Object
    //   65	44	3	localBufferedOutputStream	java.io.BufferedOutputStream
    //   129	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   175	146	3	localObject2	Object
    //   340	11	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   355	10	3	localObject3	Object
    //   12	359	4	localObject4	Object
    //   6	289	5	localObject5	Object
    //   304	9	5	localObject6	Object
    //   346	8	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   361	8	5	localObject7	Object
    //   67	225	6	localObject8	Object
    //   9	279	7	localObject9	Object
    //   3	327	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   99	104	122	java/io/IOException
    //   108	112	122	java/io/IOException
    //   116	120	122	java/io/IOException
    //   20	57	129	java/io/FileNotFoundException
    //   142	146	166	java/io/IOException
    //   151	156	166	java/io/IOException
    //   160	164	166	java/io/IOException
    //   20	57	173	java/io/IOException
    //   201	206	224	java/io/IOException
    //   210	214	224	java/io/IOException
    //   218	222	224	java/io/IOException
    //   20	57	231	finally
    //   245	250	268	java/io/IOException
    //   254	258	268	java/io/IOException
    //   262	266	268	java/io/IOException
    //   57	66	276	finally
    //   72	82	286	finally
    //   192	196	286	finally
    //   82	92	300	finally
    //   134	138	304	finally
    //   57	66	318	java/io/IOException
    //   72	82	328	java/io/IOException
    //   82	92	336	java/io/IOException
    //   57	66	340	java/io/FileNotFoundException
    //   72	82	346	java/io/FileNotFoundException
    //   82	92	359	java/io/FileNotFoundException
  }
  
  private void c()
  {
    Object localObject1;
    Object localObject3;
    int j;
    int i;
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "loadLocalData");
      }
      a(true);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      this.d = ((SharedPreferences)localObject1).getInt("nearby_max_count_in_one_day", 0);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject1).getLong("nearby_mark_day_time", 0L);
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "loadLocalData, [" + this.d + "," + this.jdField_a_of_type_Long + "]");
      }
      localObject1 = a();
      localObject3 = new File((String)localObject1);
      if (!((File)localObject3).isDirectory()) {
        break label240;
      }
      localObject3 = ((File)localObject3).listFiles();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        break label236;
      }
      j = localObject3.length;
      i = 0;
    }
    finally {}
    Object localObject4 = ((File)localObject4).getName();
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject4).endsWith(".conf")))
    {
      localObject4 = a((String)localObject1 + (String)localObject4);
      if ((localObject4 instanceof NearbyGrayTipsManager.GrayTipsConfig)) {
        a((NearbyGrayTipsManager.GrayTipsConfig)localObject4);
      }
    }
    label264:
    for (;;)
    {
      label236:
      a();
      label240:
      return;
      for (;;)
      {
        if (i >= j) {
          break label264;
        }
        localObject4 = localObject3[i];
        if (localObject4 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipStatisticData a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ??? = null;
    label221:
    for (;;)
    {
      int i;
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        int j = this.jdField_c_of_type_JavaUtilList.size();
        i = 0;
        ??? = ???;
        if (i < j)
        {
          ??? = (NearbyGrayTipsManager.GrayTipStatisticData)this.jdField_c_of_type_JavaUtilList.get(i);
          if ((??? == null) || (((NearbyGrayTipsManager.GrayTipStatisticData)???).mId != paramInt)) {}
        }
        else
        {
          if ((??? != null) || (!paramBoolean1)) {
            break label221;
          }
          ??? = a(NearbyGrayTipsManager.GrayTipStatisticData.getPath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt));
          if (!(??? instanceof NearbyGrayTipsManager.GrayTipStatisticData)) {
            break label221;
          }
          ??? = (NearbyGrayTipsManager.GrayTipStatisticData)???;
          synchronized (this.jdField_c_of_type_JavaUtilList)
          {
            this.jdField_c_of_type_JavaUtilList.add(???);
            ??? = ???;
            if (??? == null)
            {
              ??? = ???;
              if (paramBoolean2) {
                ??? = new NearbyGrayTipsManager.GrayTipStatisticData(paramInt);
              }
            }
          }
        }
      }
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_c_of_type_JavaUtilList.add(???);
        return ???;
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig a(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    Object localObject2;
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "getValidConfigForEnterAIO, not enable");
      }
      localObject2 = null;
      return localObject2;
    }
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig1 = null;
    label294:
    label303:
    label310:
    label317:
    for (;;)
    {
      NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig3;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          localGrayTipsConfig1 = null;
          if (!localIterator.hasNext()) {
            break label317;
          }
          localGrayTipsConfig3 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          if ((localGrayTipsConfig3 == null) || (localGrayTipsConfig3.sceneId != 4) || (localGrayTipsConfig3.sceneFour == null) || (!localGrayTipsConfig3.sceneFour.enterAIOTrigger)) {
            continue;
          }
          if (!localGrayTipsConfig3.isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)) {
            break label310;
          }
          if (!QLog.isDevelopLevel()) {
            break label294;
          }
          QLog.i("nearby_aio_operation_gray_tips", 4, "getValidConfigForEnterAIO, valid id = " + localGrayTipsConfig3.id);
          break label294;
          localObject2 = localGrayTipsConfig3;
          if (localGrayTipsConfig1.priority < localGrayTipsConfig3.priority) {
            break label303;
          }
          if (localGrayTipsConfig1.priority != localGrayTipsConfig3.priority) {
            break label310;
          }
          localObject2 = localGrayTipsConfig3;
          if (localGrayTipsConfig1.createTime < localGrayTipsConfig3.createTime) {
            break label303;
          }
          break label310;
        }
        localObject2 = localGrayTipsConfig1;
        if (localGrayTipsConfig1 == null) {
          break;
        }
        localObject2 = a(localGrayTipsConfig1.id, true, true);
        if ((localObject2 != null) && (((NearbyGrayTipsManager.GrayTipStatisticData)localObject2).isLimit(localGrayTipsConfig1, paramLong))) {
          return null;
        }
      }
      a(localGrayTipsConfig2, false);
      return localGrayTipsConfig2;
      if (localGrayTipsConfig2 == null)
      {
        Object localObject1;
        for (localObject2 = localGrayTipsConfig3;; localObject2 = localObject1)
        {
          localObject1 = localObject2;
          break;
        }
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
    Object localObject1 = null;
    label389:
    label396:
    for (;;)
    {
      Object localObject2;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject3;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          localObject1 = null;
          if (!localIterator.hasNext()) {
            break label396;
          }
          localObject3 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          if ((localObject3 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneId != 3) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.keywordTrigger) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.keywords == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.keywords.size() == 0) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.whichSide == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.whichSide.contains(Integer.valueOf(paramInt3)))) {
            continue;
          }
          if (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)) {
            break label389;
          }
          if (localObject1 == null)
          {
            localObject2 = localObject3;
            break label382;
          }
          localObject2 = localObject3;
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).priority < ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority) {
            break label382;
          }
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).priority != ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority) {
            break label389;
          }
          localObject2 = localObject3;
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).createTime < ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).createTime) {
            break label382;
          }
          break label389;
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = a(((NearbyGrayTipsManager.GrayTipsConfig)localObject1).id, true, true);
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (((NearbyGrayTipsManager.GrayTipStatisticData)localObject3).isLimit((NearbyGrayTipsManager.GrayTipsConfig)localObject1, paramLong)) {
              localObject2 = null;
            }
          }
        }
        if (localObject2 == null) {
          break label379;
        }
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
      }
      paramInt1 = 0;
      for (;;)
      {
        if ((paramInt1 >= localObject2.sceneThree.keywords.size()) || (paramString.indexOf((String)localObject2.sceneThree.keywords.get(paramInt1)) >= 0))
        {
          if (paramInt1 != localObject2.sceneThree.keywords.size()) {
            break;
          }
          return null;
        }
        paramInt1 += 1;
      }
      label379:
      return localObject2;
      for (;;)
      {
        label382:
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  public String a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "getRandomFaceScoreWording id=" + paramInt1 + "  gender=" + paramInt2 + "  toLoad=" + paramBoolean);
    }
    NearbyGrayTipsManager.FaceScoreWording localFaceScoreWording = a(paramInt1);
    if ((localFaceScoreWording == null) && (paramBoolean))
    {
      Object localObject = a(NearbyGrayTipsManager.FaceScoreWording.getPath(paramInt1));
      if ((localObject instanceof NearbyGrayTipsManager.FaceScoreWording)) {
        localFaceScoreWording = (NearbyGrayTipsManager.FaceScoreWording)localObject;
      }
    }
    for (;;)
    {
      if (localFaceScoreWording == null) {
        return "";
      }
      return localFaceScoreWording.getWording(this.jdField_a_of_type_JavaUtilRandom, paramInt2);
    }
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    NearbyGrayTipsManager.GreetWording localGreetWording = a(paramInt);
    if ((localGreetWording == null) && (paramBoolean))
    {
      Object localObject = a(NearbyGrayTipsManager.GreetWording.getPath(paramInt));
      if ((localObject instanceof NearbyGrayTipsManager.GreetWording)) {
        localGreetWording = (NearbyGrayTipsManager.GreetWording)localObject;
      }
    }
    for (;;)
    {
      if (localGreetWording == null) {
        return "";
      }
      return localGreetWording.getWording(this.jdField_a_of_type_JavaUtilRandom);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            Object localObject1 = (NearbyGrayTipsManager.GrayTipsConfig)this.jdField_a_of_type_JavaUtilArrayList.get(0);
            Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (localIterator.hasNext())
            {
              NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
              if (localGrayTipsConfig.createTime > ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).createTime) {
                localObject1 = localGrayTipsConfig;
              }
            }
            else
            {
              this.jdField_b_of_type_Boolean = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).grayTipsEnable;
              this.jdField_a_of_type_Int = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).global_MaxTipsCountPerDay;
              this.jdField_b_of_type_Int = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).maxTipsCount;
              this.jdField_c_of_type_Int = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).messageCount;
            }
          }
          else
          {
            return;
          }
        }
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
    if (a(paramLong, this.jdField_a_of_type_Long)) {
      this.d += 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("nearby_max_count_in_one_day", this.d).putLong("nearby_mark_day_time", this.jdField_a_of_type_Long).commit();
      return;
      this.d = 1;
      this.jdField_a_of_type_Long = paramLong;
    }
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
            break label202;
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
          ((StringBuilder)localObject).append("updateOrAddAConfig").append(",").append("[").append(i).append(",").append("config_id =").append(paramGrayTipsConfig.id).append(",").append("config_scene_id =").append(paramGrayTipsConfig.sceneId).append(",").append("]");
          QLog.i("nearby_aio_operation_gray_tips", 4, ((StringBuilder)localObject).toString());
        }
        return;
      }
      finally {}
      return;
      label202:
      i += 1;
    }
  }
  
  public void a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramGrayTipsConfig != null) && (paramGrayTipsConfig.sceneId == 4))
    {
      localObject2 = a(paramGrayTipsConfig.id);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyGrayTipsManager.GreetWording(paramGrayTipsConfig.id);
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        if (!paramBoolean) {
          break label83;
        }
      }
    }
    for (;;)
    {
      label83:
      try
      {
        this.jdField_a_of_type_JavaUtilList.add(0, localObject1);
        ((NearbyGrayTipsManager.GreetWording)localObject1).saveWording(paramGrayTipsConfig.createTime, paramGrayTipsConfig.randomWordings, paramBoolean);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
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
    if (this.jdField_a_of_type_Int == 0) {}
    do
    {
      return false;
      if (!a(paramLong, this.jdField_a_of_type_Long)) {
        break;
      }
    } while (this.d < this.jdField_a_of_type_Int);
    return true;
    this.d = 0;
    this.jdField_a_of_type_Long = 0L;
    return false;
  }
  
  public boolean a(List paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int k;
    if (paramList != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Int > 0)
      {
        bool1 = bool2;
        if (this.jdField_c_of_type_Int > 0)
        {
          i = paramList.size() - 1;
          j = 0;
          if (i < 0) {
            break label165;
          }
          if (!MessageUtils.a(((ChatMessage)paramList.get(i)).msgtype))
          {
            k = j + 1;
            j = k;
            if (k != this.jdField_c_of_type_Int) {}
          }
        }
      }
    }
    label162:
    label165:
    for (int j = i;; j = 0)
    {
      k = paramList.size() - 1;
      i = 0;
      label98:
      if (k >= j)
      {
        if (-2027 != ((ChatMessage)paramList.get(k)).msgtype) {
          break label162;
        }
        i += 1;
      }
      for (;;)
      {
        k -= 1;
        break label98;
        i -= 1;
        break;
        bool1 = bool2;
        if (i >= this.jdField_b_of_type_Int) {
          bool1 = true;
        }
        return bool1;
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig b(int paramInt1, int paramInt2, long paramLong)
  {
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig1 = null;
    Object localObject3 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "getValidConfigForFaceScore aioType= " + paramInt1 + "  otherGender=" + paramInt2 + "  curTime=" + paramLong);
    }
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      return localObject3;
    }
    label280:
    label287:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          localGrayTipsConfig1 = null;
          if (!localIterator.hasNext()) {
            break label287;
          }
          NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig2 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          if ((localGrayTipsConfig2 == null) || (localGrayTipsConfig2.sceneId != 5) || (localGrayTipsConfig2.sceneFive == null) || (!localGrayTipsConfig2.sceneFive.faceScoreTrigger)) {
            continue;
          }
          if (!localGrayTipsConfig2.isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)) {
            break label280;
          }
          if (localGrayTipsConfig1 == null)
          {
            localObject3 = localGrayTipsConfig2;
          }
          else
          {
            localObject3 = localGrayTipsConfig2;
            if (localGrayTipsConfig1.priority >= localGrayTipsConfig2.priority)
            {
              if (localGrayTipsConfig1.priority != localGrayTipsConfig2.priority) {
                break label280;
              }
              localObject3 = localGrayTipsConfig2;
              if (localGrayTipsConfig1.createTime >= localGrayTipsConfig2.createTime) {
                break label280;
              }
            }
          }
        }
        else
        {
          localObject3 = localGrayTipsConfig1;
          if (localGrayTipsConfig1 == null) {
            break;
          }
          b(localGrayTipsConfig1, false);
          return localGrayTipsConfig1;
        }
      }
      for (;;)
      {
        Object localObject2 = localObject3;
        break;
        localObject3 = localObject2;
      }
    }
  }
  
  public void b()
  {
    ??? = new File(a());
    if ((??? != null) && (((File)???).exists()) && (((File)???).isDirectory()))
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
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  public void b(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "updateFaceScoreWording config= " + paramGrayTipsConfig + "  needSaveToFile=" + paramBoolean);
    }
    Object localObject1;
    if ((paramGrayTipsConfig != null) && (paramGrayTipsConfig.sceneId == 5) && (paramGrayTipsConfig.sceneFive != null))
    {
      localObject2 = a(paramGrayTipsConfig.id);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyGrayTipsManager.FaceScoreWording(paramGrayTipsConfig.id);
        localObject2 = this.jdField_b_of_type_JavaUtilList;
        if (!paramBoolean) {
          break label142;
        }
      }
    }
    for (;;)
    {
      label142:
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(0, localObject1);
        ((NearbyGrayTipsManager.FaceScoreWording)localObject1).saveWording(paramGrayTipsConfig.createTime, paramGrayTipsConfig.sceneFive.randomWordingForMale, paramGrayTipsConfig.sceneFive.randomWordingForFeMale, paramBoolean);
        return;
      }
      finally {}
      this.jdField_b_of_type_JavaUtilList.add(localObject1);
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
    label260:
    label267:
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig = null;
          if (!localIterator.hasNext()) {
            break label267;
          }
          Object localObject4 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          if ((localObject4 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneId != 1) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneOne == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneOne.sayHiTrigger)) {
            continue;
          }
          if (!((NearbyGrayTipsManager.GrayTipsConfig)localObject4).isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)) {
            break label260;
          }
          if (localGrayTipsConfig == null)
          {
            localObject3 = localObject4;
            break label253;
          }
          localObject3 = localObject4;
          if (localGrayTipsConfig.priority < ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).priority) {
            break label253;
          }
          if (localGrayTipsConfig.priority != ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).priority) {
            break label260;
          }
          localObject3 = localObject4;
          if (localGrayTipsConfig.createTime < ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).createTime) {
            break label253;
          }
          break label260;
          localObject3 = localGrayTipsConfig;
          if (localGrayTipsConfig != null)
          {
            localObject4 = a(localGrayTipsConfig.id, true, true);
            localObject3 = localGrayTipsConfig;
            if (localObject4 != null)
            {
              localObject3 = localGrayTipsConfig;
              if (((NearbyGrayTipsManager.GrayTipStatisticData)localObject4).isLimit(localGrayTipsConfig, paramLong)) {
                localObject3 = null;
              }
            }
          }
          return localObject3;
        }
      }
      Object localObject2 = null;
      continue;
      for (;;)
      {
        label253:
        localObject2 = localObject3;
        break;
        localObject3 = localObject2;
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
    Object localObject1 = null;
    label665:
    label673:
    label680:
    label687:
    for (;;)
    {
      Object localObject4;
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject6;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject6 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          localObject1 = null;
          if (!((Iterator)localObject6).hasNext()) {
            break label687;
          }
          localObject4 = (NearbyGrayTipsManager.GrayTipsConfig)((Iterator)localObject6).next();
          if ((localObject4 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneId != 2) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneTwo == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneTwo.sayHiFrequencyControl) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneTwo.timeRange == 0) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneTwo.sayHiPeopleCount == 0)) {
            continue;
          }
          if (!((NearbyGrayTipsManager.GrayTipsConfig)localObject4).isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)) {
            break label680;
          }
          if (localObject1 == null)
          {
            localObject3 = localObject4;
            break label673;
          }
          localObject3 = localObject4;
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).priority < ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).priority) {
            break label673;
          }
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).priority != ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).priority) {
            break label680;
          }
          localObject3 = localObject4;
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).createTime < ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).createTime) {
            break label673;
          }
          break label680;
        }
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          localObject4 = a(((NearbyGrayTipsManager.GrayTipsConfig)localObject1).id, true, true);
          localObject3 = localObject1;
          if (localObject4 != null)
          {
            localObject3 = localObject1;
            if (((NearbyGrayTipsManager.GrayTipStatisticData)localObject4).isLimit((NearbyGrayTipsManager.GrayTipsConfig)localObject1, paramLong)) {
              localObject3 = null;
            }
          }
        }
        if ((localObject3 == null) || (localObject3.aioTypes == null) || (localObject3.aioTypes.size() <= 0)) {
          break label665;
        }
        localObject1 = new ArrayList();
        localObject4 = localObject3.aioTypes.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label447;
        }
        ??? = (Integer)((Iterator)localObject4).next();
        if (((Integer)???).intValue() == 1)
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1001).a(AppConstants.G, 1001);
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10002).a(AppConstants.G, 10002);
          ((List)localObject1).addAll((Collection)???);
          ((List)localObject1).addAll((Collection)localObject6);
        }
      }
      if (((Integer)???).intValue() == 2)
      {
        localList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1010).a(AppConstants.X, 1010));
        continue;
        label447:
        paramLong = (paramLong - localObject3.sceneTwo.timeRange * 60 * 1000) / 1000L;
        paramInt1 = localList.size() - 1;
        if (paramInt1 >= 0)
        {
          localObject4 = (MessageRecord)localList.get(paramInt1);
          if (localObject4 != null) {
            if (((MessageRecord)localObject4).time < paramLong) {
              localList.remove(paramInt1);
            }
          }
          for (;;)
          {
            paramInt1 -= 1;
            break;
            localList.remove(paramInt1);
          }
        }
        Collections.sort(localList, new zor(this));
        localObject4 = (QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
        paramInt1 = 0;
        Object localObject2 = localList.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          ??? = (MessageRecord)((Iterator)localObject2).next();
          ??? = ((QQMessageFacade)localObject4).a(((MessageRecord)???).senderuin, ((MessageRecord)???).istroop);
          if ((??? != null) && (!((QQMessageFacade.Message)???).hasReply))
          {
            paramInt2 = paramInt1 + 1;
            paramInt1 = paramInt2;
            if (paramInt2 < localObject3.sceneTwo.sayHiPeopleCount) {}
          }
        }
        for (;;)
        {
          if (paramInt2 < localObject3.sceneTwo.sayHiPeopleCount)
          {
            return null;
            break;
          }
          return localObject3;
          paramInt2 = paramInt1;
        }
        for (;;)
        {
          localObject2 = localObject3;
          break;
          localObject3 = localObject2;
        }
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager
 * JD-Core Version:    0.7.0.1
 */