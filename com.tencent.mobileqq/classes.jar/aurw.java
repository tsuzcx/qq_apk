import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class aurw
{
  public static final String a;
  private static final Comparator<PadFaceAd> jdField_a_of_type_JavaUtilComparator = new aurx();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private List<PadFaceAd> jdField_a_of_type_JavaUtilList = new ArrayList(4);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  
  static
  {
    jdField_a_of_type_JavaLangString = anni.a(2131706633);
  }
  
  public aurw(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    ThreadManagerV2.executeOnFileThread(new PadFaceManager.1(this));
  }
  
  public static int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if ((paramAppInfo != null) && ((paramAppInfo.iNewFlag.get() != 0) || (paramBoolean)))
    {
      paramAppInfo = paramAppInfo.buffer.get();
      if (!TextUtils.isEmpty(paramAppInfo)) {
        try
        {
          paramAppInfo = new JSONObject(paramAppInfo).optString("_show_mission");
          if (TextUtils.isEmpty(paramAppInfo)) {
            return 0;
          }
          int i = Integer.parseInt(paramAppInfo);
          return i;
        }
        catch (Exception paramAppInfo) {}
      }
    }
    return 0;
  }
  
  public static Intent a(PadFaceAd paramPadFaceAd, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("pad_face_ad", paramPadFaceAd);
    return localIntent;
  }
  
  public static aury a(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences("gamecenter_sp" + paramAppInterface.getCurrentAccountUin(), 4);
    aury localaury = new aury();
    localaury.jdField_b_of_type_Long = paramAppInterface.getLong("pwa_version", 0L);
    localaury.jdField_a_of_type_Long = paramAppInterface.getLong("last_pwa_version", 0L);
    localaury.jdField_a_of_type_JavaLangString = paramAppInterface.getString("pwa_url", "");
    return localaury;
  }
  
  public static PadFaceAd a(Intent paramIntent)
  {
    PadFaceAd localPadFaceAd = (PadFaceAd)paramIntent.getParcelableExtra("pad_face_ad");
    if (localPadFaceAd != null) {
      paramIntent.removeExtra("pad_face_ad");
    }
    return localPadFaceAd;
  }
  
  private void a()
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PadFaceAd.class);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (localArrayList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
  
  public static void a(AppInterface paramAppInterface, long paramLong)
  {
    paramAppInterface.getApp().getSharedPreferences("gamecenter_sp" + paramAppInterface.getCurrentAccountUin(), 4).edit().putLong("last_pwa_version", paramLong);
  }
  
  private boolean a(PadFaceAd paramPadFaceAd)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((PadFaceAd)localIterator.next()).padFaceId == paramPadFaceAd.padFaceId) {
        return true;
      }
    }
    return false;
  }
  
  private PadFaceAd c(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      PadFaceAd localPadFaceAd = (PadFaceAd)localIterator.next();
      if (localPadFaceAd.padFaceId == paramInt)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localPadFaceAd);
        return localPadFaceAd;
      }
    }
    return null;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("pwa_version", 0L);
  }
  
  public PadFaceAd a(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!this.jdField_b_of_type_Boolean) {
          return null;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label179;
        }
        long l = NetConnInfoCenter.getServerTime();
        i = 0;
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label173;
        }
        localObject4 = (PadFaceAd)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((((PadFaceAd)localObject4).startTime < l) && (l < ((PadFaceAd)localObject4).endTime))
        {
          Object localObject1 = localObject4;
          if (paramInt > 0)
          {
            if (((PadFaceAd)localObject4).redPointId == paramInt) {
              localObject1 = localObject4;
            }
          }
          else
          {
            localObject4 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localObject1;
              if (paramInt > 0)
              {
                localObject4 = new PadFaceAd();
                ((PadFaceAd)localObject4).redPointId = paramInt;
              }
            }
            if (localObject4 != null) {
              QLog.e("PadFaceManager", 1, new Object[] { "[getPadFaceToShow] outAd=", localObject4 });
            }
            return localObject4;
          }
        }
      }
      finally {}
      i += 1;
      continue;
      label173:
      Object localObject3 = null;
      continue;
      label179:
      Object localObject4 = null;
    }
  }
  
  public final String a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("pwa_url", "");
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      PadFaceAd localPadFaceAd = c(paramInt);
      if (localPadFaceAd != null)
      {
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      }
      if (localPadFaceAd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localPadFaceAd);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("last_id_pad_face_shown", this.jdField_a_of_type_Int).putLong("last_time_pad_face_shown", this.jdField_a_of_type_Long).commit();
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(71)).c(paramInt);
        return;
      }
    }
    finally {}
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_b_of_type_Boolean) {
          return;
        }
        int k = a(paramAppInfo, false);
        i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(k);
        if ((k > 0) && (b(k) == null) && (i < 2))
        {
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(k, i + 1);
          i = 1;
          if (i != 0)
          {
            this.c = System.currentTimeMillis();
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_pad_face_request_time", this.c).commit();
            j = this.jdField_a_of_type_Int;
            l = this.jdField_a_of_type_Long;
            if (i == 0) {
              break label211;
            }
            QLog.e("PadFaceManager", 2, new Object[] { "pullPadFace, mLastRequestTime=", Long.valueOf(this.c) });
            ((VasExtensionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(71)).a(k, j, l);
          }
        }
        else
        {
          if (this.c == 0L) {
            break label212;
          }
          if (System.currentTimeMillis() - this.c <= this.jdField_b_of_type_Long) {
            break label206;
          }
        }
      }
      finally {}
      long l = 0L;
      int j = 0;
      continue;
      label206:
      int i = 0;
      continue;
      label211:
      return;
      label212:
      i = 1;
    }
  }
  
  /* Error */
  public void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 287
    //   3: iconst_2
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 351
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_1
    //   17: aastore
    //   18: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   21: new 193	com/tencent/mobileqq/gamecenter/data/PadFaceAd
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 353	com/tencent/mobileqq/gamecenter/data/PadFaceAd:<init>	(Lorg/json/JSONObject;)V
    //   29: astore 11
    //   31: aload_1
    //   32: ldc_w 355
    //   35: iconst_1
    //   36: invokevirtual 359	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   39: iconst_1
    //   40: if_icmpne +588 -> 628
    //   43: iconst_1
    //   44: istore 6
    //   46: aload_1
    //   47: ldc_w 361
    //   50: invokevirtual 365	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   53: lstore 7
    //   55: aload_1
    //   56: ldc 178
    //   58: invokevirtual 108	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 13
    //   63: iconst_2
    //   64: bipush 24
    //   66: aload_1
    //   67: ldc_w 367
    //   70: iconst_2
    //   71: invokevirtual 359	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   74: invokestatic 373	java/lang/Math:min	(II)I
    //   77: invokestatic 376	java/lang/Math:max	(II)I
    //   80: istore 5
    //   82: iconst_0
    //   83: istore_2
    //   84: iconst_0
    //   85: istore 4
    //   87: iconst_0
    //   88: istore_3
    //   89: new 41	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 377	java/util/ArrayList:<init>	()V
    //   96: astore 12
    //   98: aload_0
    //   99: monitorenter
    //   100: aload_0
    //   101: getfield 257	aurw:jdField_b_of_type_Boolean	Z
    //   104: ifne +6 -> 110
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: aload_0
    //   111: getfield 258	aurw:jdField_b_of_type_Long	J
    //   114: iload 5
    //   116: i2l
    //   117: ldc2_w 378
    //   120: lmul
    //   121: lcmp
    //   122: ifeq +41 -> 163
    //   125: aload_0
    //   126: iload 5
    //   128: i2l
    //   129: ldc2_w 378
    //   132: lmul
    //   133: putfield 258	aurw:jdField_b_of_type_Long	J
    //   136: ldc_w 287
    //   139: iconst_2
    //   140: iconst_2
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: ldc_w 381
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: iload 5
    //   154: invokestatic 384	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   161: iconst_1
    //   162: istore_2
    //   163: iload 6
    //   165: aload_0
    //   166: getfield 236	aurw:jdField_a_of_type_Boolean	Z
    //   169: if_icmpeq +29 -> 198
    //   172: aload_0
    //   173: iload 6
    //   175: putfield 236	aurw:jdField_a_of_type_Boolean	Z
    //   178: aload_0
    //   179: getfield 236	aurw:jdField_a_of_type_Boolean	Z
    //   182: ifne +452 -> 634
    //   185: ldc_w 287
    //   188: iconst_2
    //   189: ldc_w 386
    //   192: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: goto +439 -> 634
    //   198: aload_0
    //   199: invokevirtual 391	aurw:a	()J
    //   202: lstore 9
    //   204: lload 9
    //   206: lload 7
    //   208: lcmp
    //   209: ifeq +431 -> 640
    //   212: ldc_w 287
    //   215: iconst_1
    //   216: iconst_4
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: ldc_w 393
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload_0
    //   229: invokevirtual 395	aurw:a	()Ljava/lang/String;
    //   232: aastore
    //   233: dup
    //   234: iconst_2
    //   235: ldc_w 397
    //   238: aastore
    //   239: dup
    //   240: iconst_3
    //   241: lload 9
    //   243: invokestatic 345	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   246: aastore
    //   247: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   250: iconst_1
    //   251: istore_3
    //   252: goto +388 -> 640
    //   255: aload_0
    //   256: getfield 130	aurw:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   259: invokeinterface 227 1 0
    //   264: astore_1
    //   265: iload_2
    //   266: ifeq +15 -> 281
    //   269: aload_1
    //   270: ldc_w 399
    //   273: iload 5
    //   275: invokeinterface 306 3 0
    //   280: pop
    //   281: iload 4
    //   283: ifeq +23 -> 306
    //   286: aload_0
    //   287: getfield 236	aurw:jdField_a_of_type_Boolean	Z
    //   290: ifeq +373 -> 663
    //   293: iconst_1
    //   294: istore_2
    //   295: aload_1
    //   296: ldc_w 401
    //   299: iload_2
    //   300: invokeinterface 306 3 0
    //   305: pop
    //   306: iload_3
    //   307: ifeq +25 -> 332
    //   310: aload_1
    //   311: ldc 178
    //   313: aload 13
    //   315: invokeinterface 405 3 0
    //   320: pop
    //   321: aload_1
    //   322: ldc 164
    //   324: lload 7
    //   326: invokeinterface 233 4 0
    //   331: pop
    //   332: aload_1
    //   333: invokeinterface 311 1 0
    //   338: pop
    //   339: aload_0
    //   340: getfield 236	aurw:jdField_a_of_type_Boolean	Z
    //   343: ifeq +236 -> 579
    //   346: aload 11
    //   348: getfield 254	com/tencent/mobileqq/gamecenter/data/PadFaceAd:padFaceId	I
    //   351: ifle +228 -> 579
    //   354: aload_0
    //   355: aload 11
    //   357: invokespecial 407	aurw:a	(Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;)Z
    //   360: ifne +219 -> 579
    //   363: aload_0
    //   364: getfield 46	aurw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   367: aload 11
    //   369: invokeinterface 410 2 0
    //   374: pop
    //   375: invokestatic 269	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   378: lstore 7
    //   380: iconst_0
    //   381: istore_2
    //   382: iload_2
    //   383: aload_0
    //   384: getfield 46	aurw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   387: invokeinterface 272 1 0
    //   392: if_icmpge +49 -> 441
    //   395: aload_0
    //   396: getfield 46	aurw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   399: iload_2
    //   400: invokeinterface 275 2 0
    //   405: checkcast 193	com/tencent/mobileqq/gamecenter/data/PadFaceAd
    //   408: astore_1
    //   409: aload_1
    //   410: getfield 278	com/tencent/mobileqq/gamecenter/data/PadFaceAd:startTime	J
    //   413: lload 7
    //   415: lcmp
    //   416: ifge +13 -> 429
    //   419: lload 7
    //   421: aload_1
    //   422: getfield 281	com/tencent/mobileqq/gamecenter/data/PadFaceAd:endTime	J
    //   425: lcmp
    //   426: iflt +230 -> 656
    //   429: aload 12
    //   431: aload_1
    //   432: invokeinterface 410 2 0
    //   437: pop
    //   438: goto +218 -> 656
    //   441: aload 12
    //   443: invokeinterface 272 1 0
    //   448: ifle +41 -> 489
    //   451: iconst_0
    //   452: istore_2
    //   453: iload_2
    //   454: aload 12
    //   456: invokeinterface 272 1 0
    //   461: if_icmpge +28 -> 489
    //   464: aload_0
    //   465: getfield 46	aurw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   468: aload 12
    //   470: iload_2
    //   471: invokeinterface 275 2 0
    //   476: invokeinterface 263 2 0
    //   481: pop
    //   482: iload_2
    //   483: iconst_1
    //   484: iadd
    //   485: istore_2
    //   486: goto -33 -> 453
    //   489: aload_0
    //   490: getfield 46	aurw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   493: getstatic 36	aurw:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   496: invokestatic 220	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   499: aload 11
    //   501: astore_1
    //   502: aload_0
    //   503: monitorexit
    //   504: aload_1
    //   505: ifnull +122 -> 627
    //   508: aload_0
    //   509: getfield 199	aurw:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   512: aload_1
    //   513: invokevirtual 414	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   516: aload 12
    //   518: invokeinterface 272 1 0
    //   523: ifle +104 -> 627
    //   526: aload_0
    //   527: getfield 199	aurw:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   530: astore 11
    //   532: aload 11
    //   534: invokevirtual 418	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   537: astore_1
    //   538: aload_1
    //   539: invokevirtual 423	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   542: iconst_0
    //   543: istore_2
    //   544: iload_2
    //   545: aload 12
    //   547: invokeinterface 272 1 0
    //   552: if_icmpge +37 -> 589
    //   555: aload 11
    //   557: aload 12
    //   559: iload_2
    //   560: invokeinterface 275 2 0
    //   565: checkcast 425	com/tencent/mobileqq/persistence/Entity
    //   568: invokevirtual 300	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   571: pop
    //   572: iload_2
    //   573: iconst_1
    //   574: iadd
    //   575: istore_2
    //   576: goto -32 -> 544
    //   579: aconst_null
    //   580: astore_1
    //   581: goto -79 -> 502
    //   584: astore_1
    //   585: aload_0
    //   586: monitorexit
    //   587: aload_1
    //   588: athrow
    //   589: aload_1
    //   590: invokevirtual 427	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   593: aload_1
    //   594: invokevirtual 430	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   597: return
    //   598: astore 11
    //   600: ldc_w 287
    //   603: iconst_1
    //   604: aload 11
    //   606: iconst_0
    //   607: anewarray 4	java/lang/Object
    //   610: invokestatic 433	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   613: aload_1
    //   614: invokevirtual 430	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   617: return
    //   618: astore 11
    //   620: aload_1
    //   621: invokevirtual 430	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   624: aload 11
    //   626: athrow
    //   627: return
    //   628: iconst_0
    //   629: istore 6
    //   631: goto -585 -> 46
    //   634: iconst_1
    //   635: istore 4
    //   637: goto -439 -> 198
    //   640: iload_2
    //   641: ifne -386 -> 255
    //   644: iload 4
    //   646: ifne -391 -> 255
    //   649: iload_3
    //   650: ifeq -311 -> 339
    //   653: goto -398 -> 255
    //   656: iload_2
    //   657: iconst_1
    //   658: iadd
    //   659: istore_2
    //   660: goto -278 -> 382
    //   663: iconst_0
    //   664: istore_2
    //   665: goto -370 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	668	0	this	aurw
    //   0	668	1	paramJSONObject	JSONObject
    //   83	582	2	i	int
    //   88	562	3	j	int
    //   85	560	4	k	int
    //   80	194	5	m	int
    //   44	586	6	bool	boolean
    //   53	367	7	l1	long
    //   202	40	9	l2	long
    //   29	527	11	localObject1	Object
    //   598	7	11	localException	Exception
    //   618	7	11	localObject2	Object
    //   96	462	12	localArrayList	ArrayList
    //   61	253	13	str	String
    // Exception table:
    //   from	to	target	type
    //   100	109	584	finally
    //   110	161	584	finally
    //   163	195	584	finally
    //   198	204	584	finally
    //   212	250	584	finally
    //   255	265	584	finally
    //   269	281	584	finally
    //   286	293	584	finally
    //   295	306	584	finally
    //   310	332	584	finally
    //   332	339	584	finally
    //   339	380	584	finally
    //   382	429	584	finally
    //   429	438	584	finally
    //   441	451	584	finally
    //   453	482	584	finally
    //   489	499	584	finally
    //   502	504	584	finally
    //   585	587	584	finally
    //   538	542	598	java/lang/Exception
    //   544	572	598	java/lang/Exception
    //   589	593	598	java/lang/Exception
    //   538	542	618	finally
    //   544	572	618	finally
    //   589	593	618	finally
    //   600	613	618	finally
  }
  
  public PadFaceAd b(int paramInt)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        PadFaceAd localPadFaceAd = (PadFaceAd)localIterator.next();
        if (localPadFaceAd.redPointId == paramInt) {
          return localPadFaceAd;
        }
      }
      return null;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurw
 * JD-Core Version:    0.7.0.1
 */