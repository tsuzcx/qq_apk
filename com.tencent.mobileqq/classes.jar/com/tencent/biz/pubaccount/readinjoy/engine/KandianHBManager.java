package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.hb.ReadinjoyHBLogic;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class KandianHBManager
{
  private static volatile KandianHBManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  private final int jdField_a_of_type_Int = 4;
  private KandianHBManager.HBInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo;
  public String a;
  public AtomicBoolean a;
  private final int b = 8;
  
  private KandianHBManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    Object localObject = ReadInJoyUtils.a();
    if (localObject != null) {
      this.jdField_a_of_type_JavaLangString = ((AppRuntime)localObject).getAccount();
    }
    localObject = ReadInJoyHelper.a((AppRuntime)localObject, true, true);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo = KandianHBManager.HBInfo.buildFromSp(((SharedPreferences)localObject).getString("kandian_hb", null));
    }
    QLog.d("kandianhb.KandianHBManager", 2, "create KandianHBManager , hbInfo : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo);
  }
  
  public static KandianHBManager a()
  {
    String str = ReadInJoyUtils.a();
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager = new KandianHBManager();
      }
      if (!TextUtils.equals(jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager.jdField_a_of_type_JavaLangString, str))
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager = null;
        a();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager;
    }
    finally {}
  }
  
  public void a()
  {
    KandianHBManager.HBInfo localHBInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo;
    if (localHBInfo != null)
    {
      localHBInfo.accumlatedDay = 0;
      localHBInfo.writeToStorage();
      ReadinjoyHBLogic.a().a(localHBInfo, true);
      QLog.d("kandianhb.KandianHBManager", 2, "clear hb accmulatedDay");
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = a();
        if (!bool) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo = new KandianHBManager.HBInfo();
        }
        int i = ReadinjoyHBLogic.a().a();
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo.accumlatedDay != paramInt2) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo.accumlatedDay == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo.totalDay) && (i < 2))) && (ReadinjoyHBLogic.a().a()))
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo.totalDay = paramInt1;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo.accumlatedDay = paramInt2;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo.turntableUrl = paramString;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo.writeToStorage();
          ReadinjoyHBLogic.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo, true);
          if (QLog.isColorLevel()) {
            QLog.d("kandianhb.KandianHBManager", 2, "update hb info from 68b , totalDay : " + paramInt1 + " , accumlatedDay : " + paramInt2 + " , turntableUrl : " + paramString);
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        }
      }
      finally {}
    }
  }
  
  public void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, boolean paramBoolean)
  {
    if ((!a()) && (!ReadinjoyHBLogic.a().a())) {}
    while (paramRequest0x68bParams == null) {
      return;
    }
    int i = paramRequest0x68bParams.f | 0x4;
    if (!paramBoolean) {
      i |= 0x8;
    }
    for (;;)
    {
      paramRequest0x68bParams.f = i;
      QLog.d("kandianhb.KandianHBManager", 2, "fill hb 68b up way flag , value is : " + i);
      return;
      i &= 0xFFFFFFF7;
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 179	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 181	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 183
    //   26: invokevirtual 186	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 8
    //   31: aload_1
    //   32: ldc 188
    //   34: invokevirtual 186	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 9
    //   39: aload_1
    //   40: ldc 190
    //   42: invokevirtual 186	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 10
    //   47: aload_1
    //   48: ldc 192
    //   50: invokevirtual 186	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 11
    //   55: aload_1
    //   56: ldc 194
    //   58: invokevirtual 186	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 12
    //   63: aload_1
    //   64: ldc 196
    //   66: invokevirtual 200	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   69: istore_2
    //   70: getstatic 30	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   73: aload 8
    //   75: invokevirtual 204	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   78: invokevirtual 210	java/util/Date:getTime	()J
    //   81: lstore 4
    //   83: getstatic 30	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   86: aload 9
    //   88: invokevirtual 204	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   91: invokevirtual 210	java/util/Date:getTime	()J
    //   94: lstore 6
    //   96: aload_0
    //   97: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   100: ifnonnull +14 -> 114
    //   103: aload_0
    //   104: new 72	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo
    //   107: dup
    //   108: invokespecial 136	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:<init>	()V
    //   111: putfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   114: aload_0
    //   115: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   118: lload 4
    //   120: putfield 214	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:startTime	J
    //   123: aload_0
    //   124: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   127: lload 6
    //   129: putfield 217	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:endTime	J
    //   132: aload_0
    //   133: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   136: iload_2
    //   137: putfield 142	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:totalDay	I
    //   140: aload_0
    //   141: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   144: aload 10
    //   146: putfield 220	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:toastUrl	Ljava/lang/String;
    //   149: aload_0
    //   150: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   153: aload 11
    //   155: putfield 223	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:introductionUrl	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   162: aload 12
    //   164: putfield 225	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:popIntroUrl	Ljava/lang/String;
    //   167: aload_0
    //   168: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   171: iconst_0
    //   172: putfield 118	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:accumlatedDay	I
    //   175: aload_0
    //   176: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   179: aconst_null
    //   180: putfield 150	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:turntableUrl	Ljava/lang/String;
    //   183: aload_0
    //   184: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   187: invokevirtual 121	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo:writeToStorage	()V
    //   190: invokestatic 126	com/tencent/biz/pubaccount/readinjoy/engine/hb/ReadinjoyHBLogic:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/hb/ReadinjoyHBLogic;
    //   193: aload_0
    //   194: getfield 78	com/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo	Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;
    //   197: iconst_0
    //   198: invokevirtual 129	com/tencent/biz/pubaccount/readinjoy/engine/hb/ReadinjoyHBLogic:a	(Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianHBManager$HBInfo;Z)V
    //   201: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq -193 -> 11
    //   207: ldc 80
    //   209: iconst_2
    //   210: new 82	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   217: ldc 227
    //   219: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 8
    //   224: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc 229
    //   229: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 9
    //   234: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc 231
    //   239: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 10
    //   244: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc 233
    //   249: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 11
    //   254: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto -252 -> 11
    //   266: astore_1
    //   267: aload_1
    //   268: invokevirtual 236	java/lang/Exception:printStackTrace	()V
    //   271: goto -260 -> 11
    //   274: astore_1
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_1
    //   278: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	KandianHBManager
    //   0	279	1	paramString	String
    //   69	68	2	i	int
    //   6	2	3	bool	boolean
    //   81	38	4	l1	long
    //   94	34	6	l2	long
    //   29	194	8	str1	String
    //   37	196	9	str2	String
    //   45	198	10	str3	String
    //   53	200	11	str4	String
    //   61	102	12	str5	String
    // Exception table:
    //   from	to	target	type
    //   14	114	266	java/lang/Exception
    //   114	263	266	java/lang/Exception
    //   2	7	274	finally
    //   14	114	274	finally
    //   114	263	274	finally
    //   267	271	274	finally
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo == null) {}
    long l;
    do
    {
      return false;
      l = NetConnInfoCenter.getServerTimeMillis();
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo.startTime > l) || (l >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianHBManager$HBInfo.endTime));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianHBManager
 * JD-Core Version:    0.7.0.1
 */