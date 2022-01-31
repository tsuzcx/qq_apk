package com.tencent.mobileqq.app.proxy;

import ajwf;
import ajwh;
import akar;
import akbl;
import akbm;
import akbp;
import akej;
import akel;
import akem;
import aken;
import akep;
import akeq;
import aker;
import akes;
import aket;
import akeu;
import also;
import alyh;
import android.content.ContentValues;
import aons;
import apeh;
import arpq;
import atmo;
import atmp;
import atmq;
import aufp;
import awao;
import awqz;
import ayrh;
import beoj;
import bffw;
import bgmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

public class ProxyManager
  implements Manager
{
  public static int a;
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { aufp.class, alyh.class };
  private static int jdField_b_of_type_Int = 10000;
  private static int jdField_c_of_type_Int = 2000;
  private static int d = 10000;
  private long jdField_a_of_type_Long;
  private ajwh jdField_a_of_type_Ajwh;
  private akar jdField_a_of_type_Akar;
  private akbl jdField_a_of_type_Akbl;
  private akbp jdField_a_of_type_Akbp;
  private aken jdField_a_of_type_Aken;
  private akeq jdField_a_of_type_Akeq;
  private also jdField_a_of_type_Also;
  private alyh jdField_a_of_type_Alyh;
  private aons jdField_a_of_type_Aons;
  private apeh jdField_a_of_type_Apeh;
  private arpq jdField_a_of_type_Arpq;
  private aufp jdField_a_of_type_Aufp;
  private awqz jdField_a_of_type_Awqz;
  private ayrh jdField_a_of_type_Ayrh;
  private bffw jdField_a_of_type_Bffw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  public final Object a;
  private Thread jdField_a_of_type_JavaLangThread;
  private ArrayList<aket> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<akej> jdField_a_of_type_JavaUtilSet = new HashSet();
  private Vector<aker> jdField_a_of_type_JavaUtilVector;
  volatile boolean jdField_a_of_type_Boolean;
  private akej[] jdField_a_of_type_ArrayOfAkej;
  private aken jdField_b_of_type_Aken;
  public Object b;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean = true;
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bgmq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Ajwh = paramQQAppInterface.a().a();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_Akbl = new akbl(paramQQAppInterface, this);
    this.jdField_a_of_type_Akbp = new akbp(paramQQAppInterface, this);
    this.jdField_b_of_type_Aken = new akem(paramQQAppInterface, this);
    this.jdField_a_of_type_Aken = new akel(paramQQAppInterface, this);
    this.jdField_a_of_type_Akeq = new akeq(paramQQAppInterface, this);
    this.jdField_a_of_type_Aons = new aons(paramQQAppInterface, this);
    this.jdField_a_of_type_Ayrh = new ayrh(paramQQAppInterface, this);
    this.jdField_a_of_type_Apeh = new apeh(paramQQAppInterface, this);
    this.jdField_a_of_type_Awqz = new awqz(paramQQAppInterface, this);
    this.jdField_a_of_type_Bffw = new bffw(paramQQAppInterface, this);
    this.jdField_a_of_type_Akar = new akar(paramQQAppInterface, this);
    this.jdField_a_of_type_Aufp = new aufp(paramQQAppInterface, this);
    this.jdField_a_of_type_Alyh = new alyh(paramQQAppInterface, this);
    this.jdField_a_of_type_Arpq = new arpq(paramQQAppInterface, this);
    this.jdField_a_of_type_Also = new also(paramQQAppInterface, this);
    this.jdField_a_of_type_ArrayOfAkej = new akej[] { this.jdField_a_of_type_Akbl, this.jdField_b_of_type_Aken, this.jdField_a_of_type_Aken, this.jdField_a_of_type_Aons, this.jdField_a_of_type_Awqz, this.jdField_a_of_type_Bffw, this.jdField_a_of_type_Apeh, this.jdField_a_of_type_Akar, this.jdField_a_of_type_Aufp, this.jdField_a_of_type_Alyh, this.jdField_a_of_type_Ayrh, this.jdField_a_of_type_Arpq, this.jdField_a_of_type_Also };
    this.jdField_a_of_type_JavaLangThread = new Thread(new ProxyManager.2(this));
    this.jdField_a_of_type_Boolean = false;
  }
  
  private SQLiteDatabase a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((aket)localIterator.next()).a(paramInt);
      }
    }
  }
  
  /* Error */
  private void a(atmp paramatmp, List<aker> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 232 1 0
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_c_of_type_Boolean	Z
    //   14: ifeq +50 -> 64
    //   17: getstatic 235	akep:jdField_a_of_type_Boolean	Z
    //   20: ifeq +459 -> 479
    //   23: aload_0
    //   24: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokestatic 240	bakq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   30: ifeq +449 -> 479
    //   33: aload_0
    //   34: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakep;
    //   40: invokevirtual 245	akep:a	()Z
    //   43: ifeq +21 -> 64
    //   46: aload_0
    //   47: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakep;
    //   53: invokevirtual 248	akep:a	()Lakex;
    //   56: invokevirtual 252	akex:b	()V
    //   59: aload_0
    //   60: iconst_0
    //   61: putfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_c_of_type_Boolean	Z
    //   64: aconst_null
    //   65: astore 17
    //   67: invokestatic 255	awrn:a	()Z
    //   70: istore 10
    //   72: iload 10
    //   74: ifeq +413 -> 487
    //   77: iconst_0
    //   78: invokestatic 258	awrn:a	(I)Z
    //   81: ifeq +406 -> 487
    //   84: iconst_1
    //   85: istore 7
    //   87: invokestatic 264	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   90: astore 18
    //   92: invokestatic 267	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   95: astore 19
    //   97: aload 18
    //   99: aload 19
    //   101: if_acmpne +392 -> 493
    //   104: iconst_1
    //   105: istore 9
    //   107: iload 9
    //   109: ifeq +37 -> 146
    //   112: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +31 -> 146
    //   118: ldc_w 274
    //   121: iconst_2
    //   122: new 276	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 279
    //   132: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload 9
    //   137: invokevirtual 286	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_1
    //   147: invokevirtual 298	atmp:a	()Latmr;
    //   150: astore 18
    //   152: aload 18
    //   154: astore 17
    //   156: invokestatic 304	java/lang/System:nanoTime	()J
    //   159: lstore 13
    //   161: aload 17
    //   163: invokevirtual 308	atmr:a	()V
    //   166: iload 7
    //   168: ifeq +2086 -> 2254
    //   171: invokestatic 304	java/lang/System:nanoTime	()J
    //   174: lload 13
    //   176: lsub
    //   177: ldc2_w 309
    //   180: ldiv
    //   181: lstore 11
    //   183: new 312	java/util/HashMap
    //   186: dup
    //   187: invokespecial 313	java/util/HashMap:<init>	()V
    //   190: astore 19
    //   192: iload 9
    //   194: ifeq +305 -> 499
    //   197: ldc_w 315
    //   200: astore 18
    //   202: aload 19
    //   204: ldc_w 317
    //   207: aload 18
    //   209: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload 19
    //   215: ldc_w 323
    //   218: ldc_w 325
    //   221: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: aload 19
    //   227: ldc_w 327
    //   230: lload 11
    //   232: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   235: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: pop
    //   239: aload 19
    //   241: ldc_w 335
    //   244: getstatic 338	ajrl:jdField_a_of_type_Boolean	Z
    //   247: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   250: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   253: pop
    //   254: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   257: invokestatic 350	awrn:a	(Landroid/content/Context;)Lawrn;
    //   260: aconst_null
    //   261: ldc_w 352
    //   264: iconst_1
    //   265: ldc2_w 353
    //   268: lconst_0
    //   269: aload 19
    //   271: aconst_null
    //   272: iconst_0
    //   273: invokevirtual 357	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   276: aload_2
    //   277: invokeinterface 358 1 0
    //   282: astore 18
    //   284: iconst_0
    //   285: istore_3
    //   286: iconst_0
    //   287: istore 4
    //   289: aload 18
    //   291: invokeinterface 218 1 0
    //   296: ifeq +1175 -> 1471
    //   299: aload 18
    //   301: invokeinterface 222 1 0
    //   306: checkcast 360	aker
    //   309: astore 19
    //   311: iload 4
    //   313: iconst_1
    //   314: iadd
    //   315: istore 4
    //   317: iload_3
    //   318: istore 6
    //   320: iload_3
    //   321: istore 5
    //   323: aload 19
    //   325: getfield 363	aker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   328: astore 20
    //   330: iload_3
    //   331: istore 6
    //   333: iload_3
    //   334: istore 5
    //   336: aload 19
    //   338: getfield 366	aker:jdField_a_of_type_Akes	Lakes;
    //   341: astore 21
    //   343: iload_3
    //   344: istore 6
    //   346: iload_3
    //   347: istore 5
    //   349: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +1910 -> 2262
    //   355: iload_3
    //   356: istore 6
    //   358: iload_3
    //   359: istore 5
    //   361: aload 19
    //   363: getfield 369	aker:jdField_a_of_type_Atmo	Latmo;
    //   366: instanceof 371
    //   369: ifeq +138 -> 507
    //   372: iload_3
    //   373: iconst_1
    //   374: iadd
    //   375: istore_3
    //   376: iload_3
    //   377: istore 6
    //   379: iload_3
    //   380: istore 5
    //   382: ldc_w 274
    //   385: iconst_2
    //   386: iconst_4
    //   387: anewarray 4	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: ldc_w 373
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: aload 19
    //   400: getfield 374	aker:jdField_b_of_type_Int	I
    //   403: invokestatic 379	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: aastore
    //   407: dup
    //   408: iconst_2
    //   409: ldc_w 381
    //   412: aastore
    //   413: dup
    //   414: iconst_3
    //   415: aload 19
    //   417: getfield 369	aker:jdField_a_of_type_Atmo	Latmo;
    //   420: aastore
    //   421: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   424: aload 19
    //   426: getfield 374	aker:jdField_b_of_type_Int	I
    //   429: istore 5
    //   431: iload 5
    //   433: tableswitch	default:+43 -> 476, 0:+221->654, 1:+494->927, 2:+755->1188, 3:+468->901, 4:+727->1160, 5:+970->1403, 6:+998->1431
    //   477: impdep2
    //   478: fstore_2
    //   479: aload_0
    //   480: iconst_0
    //   481: putfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_c_of_type_Boolean	Z
    //   484: goto -420 -> 64
    //   487: iconst_0
    //   488: istore 7
    //   490: goto -403 -> 87
    //   493: iconst_0
    //   494: istore 9
    //   496: goto -389 -> 107
    //   499: ldc_w 386
    //   502: astore 18
    //   504: goto -302 -> 202
    //   507: iload_3
    //   508: istore 6
    //   510: iload_3
    //   511: istore 5
    //   513: aload 19
    //   515: getfield 374	aker:jdField_b_of_type_Int	I
    //   518: istore 8
    //   520: iload_3
    //   521: istore 6
    //   523: iload_3
    //   524: istore 5
    //   526: aload 19
    //   528: getfield 388	aker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   531: astore 22
    //   533: iload_3
    //   534: istore 6
    //   536: iload_3
    //   537: istore 5
    //   539: aload 19
    //   541: getfield 363	aker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   544: astore 23
    //   546: iload_3
    //   547: istore 6
    //   549: iload_3
    //   550: istore 5
    //   552: aload 19
    //   554: getfield 391	aker:jdField_a_of_type_AndroidContentContentValues	Landroid/content/ContentValues;
    //   557: ifnull +90 -> 647
    //   560: iload_3
    //   561: istore 6
    //   563: iload_3
    //   564: istore 5
    //   566: aload 19
    //   568: getfield 391	aker:jdField_a_of_type_AndroidContentContentValues	Landroid/content/ContentValues;
    //   571: invokevirtual 396	android/content/ContentValues:hashCode	()I
    //   574: invokestatic 379	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: astore_2
    //   578: iload_3
    //   579: istore 6
    //   581: iload_3
    //   582: istore 5
    //   584: ldc_w 274
    //   587: iconst_2
    //   588: bipush 8
    //   590: anewarray 4	java/lang/Object
    //   593: dup
    //   594: iconst_0
    //   595: ldc_w 373
    //   598: aastore
    //   599: dup
    //   600: iconst_1
    //   601: iload 8
    //   603: invokestatic 379	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   606: aastore
    //   607: dup
    //   608: iconst_2
    //   609: ldc_w 398
    //   612: aastore
    //   613: dup
    //   614: iconst_3
    //   615: aload 22
    //   617: aastore
    //   618: dup
    //   619: iconst_4
    //   620: ldc_w 400
    //   623: aastore
    //   624: dup
    //   625: iconst_5
    //   626: aload 23
    //   628: aastore
    //   629: dup
    //   630: bipush 6
    //   632: ldc_w 402
    //   635: aastore
    //   636: dup
    //   637: bipush 7
    //   639: aload_2
    //   640: aastore
    //   641: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   644: goto +1618 -> 2262
    //   647: ldc_w 404
    //   650: astore_2
    //   651: goto -73 -> 578
    //   654: invokestatic 304	java/lang/System:nanoTime	()J
    //   657: lstore 11
    //   659: getstatic 235	akep:jdField_a_of_type_Boolean	Z
    //   662: ifeq +41 -> 703
    //   665: aload_0
    //   666: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   669: invokestatic 240	bakq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   672: ifeq +31 -> 703
    //   675: aload_0
    //   676: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   679: invokestatic 406	bakq:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   682: ifeq +21 -> 703
    //   685: aload_0
    //   686: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   689: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakep;
    //   692: invokevirtual 248	akep:a	()Lakex;
    //   695: aload 19
    //   697: getfield 369	aker:jdField_a_of_type_Atmo	Latmo;
    //   700: invokevirtual 409	akex:a	(Latmo;)V
    //   703: aload_1
    //   704: aload 19
    //   706: getfield 369	aker:jdField_a_of_type_Atmo	Latmo;
    //   709: invokevirtual 411	atmp:b	(Latmo;)V
    //   712: invokestatic 304	java/lang/System:nanoTime	()J
    //   715: lload 11
    //   717: lsub
    //   718: ldc2_w 309
    //   721: ldiv
    //   722: lstore 15
    //   724: aload 21
    //   726: ifnull +12 -> 738
    //   729: aload 21
    //   731: aload 20
    //   733: invokeinterface 416 2 0
    //   738: getstatic 235	akep:jdField_a_of_type_Boolean	Z
    //   741: ifeq +42 -> 783
    //   744: aload_0
    //   745: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   748: invokestatic 240	bakq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   751: ifeq +32 -> 783
    //   754: aload_0
    //   755: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   758: invokestatic 406	bakq:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   761: ifeq +22 -> 783
    //   764: aload_0
    //   765: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   768: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakep;
    //   771: invokevirtual 248	akep:a	()Lakex;
    //   774: aload 19
    //   776: getfield 369	aker:jdField_a_of_type_Atmo	Latmo;
    //   779: aload_1
    //   780: invokevirtual 419	akex:a	(Latmo;Latmp;)V
    //   783: lload 15
    //   785: lstore 11
    //   787: iload 10
    //   789: ifeq +1455 -> 2244
    //   792: lload 15
    //   794: lstore 11
    //   796: iconst_4
    //   797: invokestatic 258	awrn:a	(I)Z
    //   800: ifeq +1444 -> 2244
    //   803: new 312	java/util/HashMap
    //   806: dup
    //   807: invokespecial 313	java/util/HashMap:<init>	()V
    //   810: astore 19
    //   812: iload 9
    //   814: ifeq +1451 -> 2265
    //   817: ldc_w 315
    //   820: astore_2
    //   821: aload 19
    //   823: ldc_w 317
    //   826: aload_2
    //   827: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   830: pop
    //   831: aload 19
    //   833: ldc_w 323
    //   836: ldc_w 421
    //   839: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   842: pop
    //   843: aload 19
    //   845: ldc_w 327
    //   848: lload 15
    //   850: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   853: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   856: pop
    //   857: aload 19
    //   859: ldc_w 335
    //   862: getstatic 338	ajrl:jdField_a_of_type_Boolean	Z
    //   865: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   868: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   871: pop
    //   872: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   875: invokestatic 350	awrn:a	(Landroid/content/Context;)Lawrn;
    //   878: aconst_null
    //   879: ldc_w 352
    //   882: iconst_1
    //   883: ldc2_w 353
    //   886: lconst_0
    //   887: aload 19
    //   889: aconst_null
    //   890: iconst_0
    //   891: invokevirtual 357	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   894: lload 15
    //   896: lstore 11
    //   898: goto -422 -> 476
    //   901: aload_1
    //   902: aload 19
    //   904: getfield 369	aker:jdField_a_of_type_Atmo	Latmo;
    //   907: invokevirtual 411	atmp:b	(Latmo;)V
    //   910: aload 21
    //   912: ifnull -436 -> 476
    //   915: aload 21
    //   917: aload 20
    //   919: invokeinterface 416 2 0
    //   924: goto -448 -> 476
    //   927: getstatic 235	akep:jdField_a_of_type_Boolean	Z
    //   930: ifeq +39 -> 969
    //   933: aload_0
    //   934: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   937: invokestatic 240	bakq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   940: ifeq +29 -> 969
    //   943: aload_0
    //   944: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   947: invokestatic 406	bakq:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   950: ifeq +19 -> 969
    //   953: aload_0
    //   954: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   957: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakep;
    //   960: invokevirtual 248	akep:a	()Lakex;
    //   963: aload 19
    //   965: aload_1
    //   966: invokevirtual 424	akex:a	(Laker;Latmp;)V
    //   969: invokestatic 304	java/lang/System:nanoTime	()J
    //   972: lstore 15
    //   974: aload_0
    //   975: invokespecial 425	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   978: astore_2
    //   979: aload_2
    //   980: ifnull +1267 -> 2247
    //   983: aload_2
    //   984: aload 20
    //   986: aload 19
    //   988: getfield 391	aker:jdField_a_of_type_AndroidContentContentValues	Landroid/content/ContentValues;
    //   991: aload 19
    //   993: getfield 427	aker:c	Ljava/lang/String;
    //   996: aload 19
    //   998: getfield 430	aker:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1001: invokevirtual 435	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1004: istore 5
    //   1006: invokestatic 304	java/lang/System:nanoTime	()J
    //   1009: lload 15
    //   1011: lsub
    //   1012: ldc2_w 309
    //   1015: ldiv
    //   1016: lstore 11
    //   1018: lload 11
    //   1020: lstore 15
    //   1022: aload 21
    //   1024: ifnull +18 -> 1042
    //   1027: aload 21
    //   1029: aload 20
    //   1031: iload 5
    //   1033: invokeinterface 438 3 0
    //   1038: lload 11
    //   1040: lstore 15
    //   1042: lload 15
    //   1044: lstore 11
    //   1046: iload 10
    //   1048: ifeq +1196 -> 2244
    //   1051: lload 15
    //   1053: lstore 11
    //   1055: iconst_5
    //   1056: invokestatic 258	awrn:a	(I)Z
    //   1059: ifeq +1185 -> 2244
    //   1062: new 312	java/util/HashMap
    //   1065: dup
    //   1066: invokespecial 313	java/util/HashMap:<init>	()V
    //   1069: astore 19
    //   1071: iload 9
    //   1073: ifeq +1199 -> 2272
    //   1076: ldc_w 315
    //   1079: astore_2
    //   1080: aload 19
    //   1082: ldc_w 317
    //   1085: aload_2
    //   1086: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1089: pop
    //   1090: aload 19
    //   1092: ldc_w 323
    //   1095: ldc_w 440
    //   1098: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1101: pop
    //   1102: aload 19
    //   1104: ldc_w 327
    //   1107: lload 15
    //   1109: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1112: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1115: pop
    //   1116: aload 19
    //   1118: ldc_w 335
    //   1121: getstatic 338	ajrl:jdField_a_of_type_Boolean	Z
    //   1124: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1127: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1130: pop
    //   1131: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1134: invokestatic 350	awrn:a	(Landroid/content/Context;)Lawrn;
    //   1137: aconst_null
    //   1138: ldc_w 352
    //   1141: iconst_1
    //   1142: ldc2_w 353
    //   1145: lconst_0
    //   1146: aload 19
    //   1148: aconst_null
    //   1149: iconst_0
    //   1150: invokevirtual 357	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1153: lload 15
    //   1155: lstore 11
    //   1157: goto -681 -> 476
    //   1160: aload_1
    //   1161: aload 19
    //   1163: getfield 369	aker:jdField_a_of_type_Atmo	Latmo;
    //   1166: invokevirtual 443	atmp:a	(Latmo;)Z
    //   1169: pop
    //   1170: aload 21
    //   1172: ifnull -696 -> 476
    //   1175: aload 21
    //   1177: aload 20
    //   1179: iconst_1
    //   1180: invokeinterface 438 3 0
    //   1185: goto -709 -> 476
    //   1188: getstatic 235	akep:jdField_a_of_type_Boolean	Z
    //   1191: ifeq +39 -> 1230
    //   1194: aload_0
    //   1195: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1198: invokestatic 240	bakq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1201: ifeq +29 -> 1230
    //   1204: aload_0
    //   1205: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1208: invokestatic 406	bakq:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1211: ifeq +19 -> 1230
    //   1214: aload_0
    //   1215: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1218: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakep;
    //   1221: invokevirtual 248	akep:a	()Lakex;
    //   1224: aload 19
    //   1226: aload_1
    //   1227: invokevirtual 445	akex:b	(Laker;Latmp;)V
    //   1230: invokestatic 304	java/lang/System:nanoTime	()J
    //   1233: lstore 11
    //   1235: aload_0
    //   1236: invokespecial 425	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1239: aload 20
    //   1241: aload 19
    //   1243: getfield 427	aker:c	Ljava/lang/String;
    //   1246: aload 19
    //   1248: getfield 430	aker:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1251: invokevirtual 448	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1254: istore 5
    //   1256: invokestatic 304	java/lang/System:nanoTime	()J
    //   1259: lload 11
    //   1261: lsub
    //   1262: ldc2_w 309
    //   1265: ldiv
    //   1266: lstore 15
    //   1268: aload 21
    //   1270: ifnull +14 -> 1284
    //   1273: aload 21
    //   1275: aload 20
    //   1277: iload 5
    //   1279: invokeinterface 450 3 0
    //   1284: lload 15
    //   1286: lstore 11
    //   1288: iload 10
    //   1290: ifeq +954 -> 2244
    //   1293: lload 15
    //   1295: lstore 11
    //   1297: bipush 6
    //   1299: invokestatic 258	awrn:a	(I)Z
    //   1302: ifeq +942 -> 2244
    //   1305: new 312	java/util/HashMap
    //   1308: dup
    //   1309: invokespecial 313	java/util/HashMap:<init>	()V
    //   1312: astore 19
    //   1314: iload 9
    //   1316: ifeq +963 -> 2279
    //   1319: ldc_w 315
    //   1322: astore_2
    //   1323: aload 19
    //   1325: ldc_w 317
    //   1328: aload_2
    //   1329: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1332: pop
    //   1333: aload 19
    //   1335: ldc_w 323
    //   1338: ldc_w 452
    //   1341: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1344: pop
    //   1345: aload 19
    //   1347: ldc_w 327
    //   1350: lload 15
    //   1352: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1355: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1358: pop
    //   1359: aload 19
    //   1361: ldc_w 335
    //   1364: getstatic 338	ajrl:jdField_a_of_type_Boolean	Z
    //   1367: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1370: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1373: pop
    //   1374: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1377: invokestatic 350	awrn:a	(Landroid/content/Context;)Lawrn;
    //   1380: aconst_null
    //   1381: ldc_w 352
    //   1384: iconst_1
    //   1385: ldc2_w 353
    //   1388: lconst_0
    //   1389: aload 19
    //   1391: aconst_null
    //   1392: iconst_0
    //   1393: invokevirtual 357	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1396: lload 15
    //   1398: lstore 11
    //   1400: goto -924 -> 476
    //   1403: aload_1
    //   1404: aload 19
    //   1406: getfield 369	aker:jdField_a_of_type_Atmo	Latmo;
    //   1409: invokevirtual 454	atmp:b	(Latmo;)Z
    //   1412: pop
    //   1413: aload 21
    //   1415: ifnull -939 -> 476
    //   1418: aload 21
    //   1420: aload 20
    //   1422: iconst_1
    //   1423: invokeinterface 450 3 0
    //   1428: goto -952 -> 476
    //   1431: aload_0
    //   1432: invokespecial 425	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1435: aload 20
    //   1437: aload 19
    //   1439: getfield 427	aker:c	Ljava/lang/String;
    //   1442: aload 19
    //   1444: getfield 430	aker:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1447: invokevirtual 448	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1450: istore 5
    //   1452: aload 21
    //   1454: ifnull +14 -> 1468
    //   1457: aload 21
    //   1459: aload 20
    //   1461: iload 5
    //   1463: invokeinterface 450 3 0
    //   1468: goto -992 -> 476
    //   1471: aload 17
    //   1473: invokevirtual 456	atmr:c	()V
    //   1476: aload_0
    //   1477: sipush 1000
    //   1480: invokespecial 457	com/tencent/mobileqq/app/proxy/ProxyManager:a	(I)V
    //   1483: aload 17
    //   1485: ifnull -1476 -> 9
    //   1488: aload 17
    //   1490: invokevirtual 458	atmr:b	()V
    //   1493: invokestatic 304	java/lang/System:nanoTime	()J
    //   1496: lload 13
    //   1498: lsub
    //   1499: ldc2_w 309
    //   1502: ldiv
    //   1503: lstore 11
    //   1505: iload 7
    //   1507: ifeq -1498 -> 9
    //   1510: new 312	java/util/HashMap
    //   1513: dup
    //   1514: invokespecial 313	java/util/HashMap:<init>	()V
    //   1517: astore_2
    //   1518: iload 9
    //   1520: ifeq +129 -> 1649
    //   1523: ldc_w 315
    //   1526: astore_1
    //   1527: aload_2
    //   1528: ldc_w 317
    //   1531: aload_1
    //   1532: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1535: pop
    //   1536: aload_2
    //   1537: ldc_w 323
    //   1540: ldc_w 460
    //   1543: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1546: pop
    //   1547: aload_2
    //   1548: ldc_w 327
    //   1551: lload 11
    //   1553: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1556: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1559: pop
    //   1560: aload_2
    //   1561: ldc_w 462
    //   1564: iload 4
    //   1566: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1569: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1572: pop
    //   1573: aload_2
    //   1574: ldc_w 467
    //   1577: iload_3
    //   1578: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1581: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1584: pop
    //   1585: aload_2
    //   1586: ldc_w 469
    //   1589: lload 11
    //   1591: l2f
    //   1592: iload 4
    //   1594: i2f
    //   1595: fdiv
    //   1596: invokestatic 472	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1599: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1602: pop
    //   1603: aload_2
    //   1604: ldc_w 474
    //   1607: ldc_w 460
    //   1610: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1613: pop
    //   1614: aload_2
    //   1615: ldc_w 335
    //   1618: getstatic 338	ajrl:jdField_a_of_type_Boolean	Z
    //   1621: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1624: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1627: pop
    //   1628: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1631: invokestatic 350	awrn:a	(Landroid/content/Context;)Lawrn;
    //   1634: aconst_null
    //   1635: ldc_w 476
    //   1638: iconst_1
    //   1639: lload 11
    //   1641: lconst_0
    //   1642: aload_2
    //   1643: aconst_null
    //   1644: iconst_0
    //   1645: invokevirtual 357	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1648: return
    //   1649: ldc_w 386
    //   1652: astore_1
    //   1653: goto -126 -> 1527
    //   1656: astore_1
    //   1657: ldc2_w 353
    //   1660: lstore 11
    //   1662: iconst_0
    //   1663: istore 4
    //   1665: iconst_0
    //   1666: istore 9
    //   1668: iconst_0
    //   1669: istore_3
    //   1670: aload 17
    //   1672: astore_2
    //   1673: aload_1
    //   1674: invokevirtual 479	java/lang/Exception:printStackTrace	()V
    //   1677: aload_0
    //   1678: sipush 1001
    //   1681: invokespecial 457	com/tencent/mobileqq/app/proxy/ProxyManager:a	(I)V
    //   1684: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1687: ifeq +33 -> 1720
    //   1690: ldc_w 274
    //   1693: iconst_2
    //   1694: new 276	java/lang/StringBuilder
    //   1697: dup
    //   1698: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1701: ldc_w 481
    //   1704: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: aload_1
    //   1708: invokevirtual 484	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1711: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1717: invokestatic 487	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1720: aload_2
    //   1721: ifnull -1712 -> 9
    //   1724: aload_2
    //   1725: invokevirtual 458	atmr:b	()V
    //   1728: invokestatic 304	java/lang/System:nanoTime	()J
    //   1731: lload 11
    //   1733: lsub
    //   1734: ldc2_w 309
    //   1737: ldiv
    //   1738: lstore 11
    //   1740: iload 7
    //   1742: ifeq -1733 -> 9
    //   1745: new 312	java/util/HashMap
    //   1748: dup
    //   1749: invokespecial 313	java/util/HashMap:<init>	()V
    //   1752: astore_2
    //   1753: iload 9
    //   1755: ifeq +129 -> 1884
    //   1758: ldc_w 315
    //   1761: astore_1
    //   1762: aload_2
    //   1763: ldc_w 317
    //   1766: aload_1
    //   1767: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1770: pop
    //   1771: aload_2
    //   1772: ldc_w 323
    //   1775: ldc_w 460
    //   1778: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1781: pop
    //   1782: aload_2
    //   1783: ldc_w 327
    //   1786: lload 11
    //   1788: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1791: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1794: pop
    //   1795: aload_2
    //   1796: ldc_w 462
    //   1799: iload 4
    //   1801: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1804: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1807: pop
    //   1808: aload_2
    //   1809: ldc_w 467
    //   1812: iload_3
    //   1813: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1816: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1819: pop
    //   1820: aload_2
    //   1821: ldc_w 469
    //   1824: lload 11
    //   1826: l2f
    //   1827: iload 4
    //   1829: i2f
    //   1830: fdiv
    //   1831: invokestatic 472	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1834: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1837: pop
    //   1838: aload_2
    //   1839: ldc_w 474
    //   1842: ldc_w 460
    //   1845: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1848: pop
    //   1849: aload_2
    //   1850: ldc_w 335
    //   1853: getstatic 338	ajrl:jdField_a_of_type_Boolean	Z
    //   1856: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1859: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1862: pop
    //   1863: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1866: invokestatic 350	awrn:a	(Landroid/content/Context;)Lawrn;
    //   1869: aconst_null
    //   1870: ldc_w 476
    //   1873: iconst_1
    //   1874: lload 11
    //   1876: lconst_0
    //   1877: aload_2
    //   1878: aconst_null
    //   1879: iconst_0
    //   1880: invokevirtual 357	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1883: return
    //   1884: ldc_w 386
    //   1887: astore_1
    //   1888: goto -126 -> 1762
    //   1891: astore_1
    //   1892: iconst_0
    //   1893: istore_3
    //   1894: iconst_0
    //   1895: istore 4
    //   1897: ldc2_w 353
    //   1900: lstore 13
    //   1902: iconst_0
    //   1903: istore 9
    //   1905: aconst_null
    //   1906: astore 17
    //   1908: aload 17
    //   1910: ifnull +173 -> 2083
    //   1913: aload 17
    //   1915: invokevirtual 458	atmr:b	()V
    //   1918: invokestatic 304	java/lang/System:nanoTime	()J
    //   1921: lload 13
    //   1923: lsub
    //   1924: ldc2_w 309
    //   1927: ldiv
    //   1928: lstore 11
    //   1930: iload 7
    //   1932: ifeq +151 -> 2083
    //   1935: new 312	java/util/HashMap
    //   1938: dup
    //   1939: invokespecial 313	java/util/HashMap:<init>	()V
    //   1942: astore 17
    //   1944: iload 9
    //   1946: ifeq +139 -> 2085
    //   1949: ldc_w 315
    //   1952: astore_2
    //   1953: aload 17
    //   1955: ldc_w 317
    //   1958: aload_2
    //   1959: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1962: pop
    //   1963: aload 17
    //   1965: ldc_w 323
    //   1968: ldc_w 460
    //   1971: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1974: pop
    //   1975: aload 17
    //   1977: ldc_w 327
    //   1980: lload 11
    //   1982: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1985: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1988: pop
    //   1989: aload 17
    //   1991: ldc_w 462
    //   1994: iload 4
    //   1996: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1999: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2002: pop
    //   2003: aload 17
    //   2005: ldc_w 467
    //   2008: iload_3
    //   2009: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2012: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2015: pop
    //   2016: aload 17
    //   2018: ldc_w 469
    //   2021: lload 11
    //   2023: l2f
    //   2024: iload 4
    //   2026: i2f
    //   2027: fdiv
    //   2028: invokestatic 472	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   2031: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2034: pop
    //   2035: aload 17
    //   2037: ldc_w 474
    //   2040: ldc_w 460
    //   2043: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2046: pop
    //   2047: aload 17
    //   2049: ldc_w 335
    //   2052: getstatic 338	ajrl:jdField_a_of_type_Boolean	Z
    //   2055: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2058: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2061: pop
    //   2062: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2065: invokestatic 350	awrn:a	(Landroid/content/Context;)Lawrn;
    //   2068: aconst_null
    //   2069: ldc_w 476
    //   2072: iconst_1
    //   2073: lload 11
    //   2075: lconst_0
    //   2076: aload 17
    //   2078: aconst_null
    //   2079: iconst_0
    //   2080: invokevirtual 357	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2083: aload_1
    //   2084: athrow
    //   2085: ldc_w 386
    //   2088: astore_2
    //   2089: goto -136 -> 1953
    //   2092: astore_1
    //   2093: iconst_0
    //   2094: istore_3
    //   2095: iconst_0
    //   2096: istore 4
    //   2098: ldc2_w 353
    //   2101: lstore 13
    //   2103: aconst_null
    //   2104: astore 17
    //   2106: goto -198 -> 1908
    //   2109: astore_1
    //   2110: iconst_0
    //   2111: istore_3
    //   2112: iconst_0
    //   2113: istore 4
    //   2115: ldc2_w 353
    //   2118: lstore 13
    //   2120: goto -212 -> 1908
    //   2123: astore_1
    //   2124: iconst_0
    //   2125: istore_3
    //   2126: iconst_0
    //   2127: istore 4
    //   2129: goto -221 -> 1908
    //   2132: astore_1
    //   2133: goto -225 -> 1908
    //   2136: astore_1
    //   2137: iload 6
    //   2139: istore_3
    //   2140: goto -232 -> 1908
    //   2143: astore_1
    //   2144: goto -236 -> 1908
    //   2147: astore_1
    //   2148: lload 11
    //   2150: lstore 13
    //   2152: aload_2
    //   2153: astore 17
    //   2155: goto -247 -> 1908
    //   2158: astore_1
    //   2159: iconst_0
    //   2160: istore_3
    //   2161: ldc2_w 353
    //   2164: lstore 11
    //   2166: iconst_0
    //   2167: istore 4
    //   2169: aload 17
    //   2171: astore_2
    //   2172: goto -499 -> 1673
    //   2175: astore_1
    //   2176: iconst_0
    //   2177: istore_3
    //   2178: ldc2_w 353
    //   2181: lstore 11
    //   2183: aload 17
    //   2185: astore_2
    //   2186: iconst_0
    //   2187: istore 4
    //   2189: goto -516 -> 1673
    //   2192: astore_1
    //   2193: iconst_0
    //   2194: istore_3
    //   2195: iconst_0
    //   2196: istore 4
    //   2198: lload 13
    //   2200: lstore 11
    //   2202: aload 17
    //   2204: astore_2
    //   2205: goto -532 -> 1673
    //   2208: astore_1
    //   2209: lload 13
    //   2211: lstore 11
    //   2213: aload 17
    //   2215: astore_2
    //   2216: goto -543 -> 1673
    //   2219: astore_1
    //   2220: lload 13
    //   2222: lstore 11
    //   2224: aload 17
    //   2226: astore_2
    //   2227: iload 5
    //   2229: istore_3
    //   2230: goto -557 -> 1673
    //   2233: astore_1
    //   2234: lload 13
    //   2236: lstore 11
    //   2238: aload 17
    //   2240: astore_2
    //   2241: goto -568 -> 1673
    //   2244: goto -1768 -> 476
    //   2247: lload 11
    //   2249: lstore 15
    //   2251: goto -1209 -> 1042
    //   2254: ldc2_w 353
    //   2257: lstore 11
    //   2259: goto -1983 -> 276
    //   2262: goto -1838 -> 424
    //   2265: ldc_w 386
    //   2268: astore_2
    //   2269: goto -1448 -> 821
    //   2272: ldc_w 386
    //   2275: astore_2
    //   2276: goto -1196 -> 1080
    //   2279: ldc_w 386
    //   2282: astore_2
    //   2283: goto -960 -> 1323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2286	0	this	ProxyManager
    //   0	2286	1	paramatmp	atmp
    //   0	2286	2	paramList	List<aker>
    //   285	1945	3	i	int
    //   287	1910	4	j	int
    //   321	1907	5	k	int
    //   318	1820	6	m	int
    //   85	1846	7	n	int
    //   518	84	8	i1	int
    //   105	1840	9	bool1	boolean
    //   70	1219	10	bool2	boolean
    //   181	2077	11	l1	long
    //   159	2076	13	l2	long
    //   722	1528	15	l3	long
    //   65	2174	17	localObject1	Object
    //   90	413	18	localObject2	Object
    //   95	1348	19	localObject3	Object
    //   328	1132	20	str1	String
    //   341	1117	21	localakes	akes
    //   531	85	22	str2	String
    //   544	83	23	str3	String
    // Exception table:
    //   from	to	target	type
    //   87	97	1656	java/lang/Exception
    //   87	97	1891	finally
    //   112	146	2092	finally
    //   146	152	2092	finally
    //   156	161	2109	finally
    //   161	166	2123	finally
    //   171	192	2123	finally
    //   202	276	2123	finally
    //   276	284	2123	finally
    //   289	311	2132	finally
    //   1471	1483	2132	finally
    //   323	330	2136	finally
    //   336	343	2136	finally
    //   349	355	2136	finally
    //   361	372	2136	finally
    //   382	424	2136	finally
    //   513	520	2136	finally
    //   526	533	2136	finally
    //   539	546	2136	finally
    //   552	560	2136	finally
    //   566	578	2136	finally
    //   584	644	2136	finally
    //   424	431	2143	finally
    //   654	703	2143	finally
    //   703	724	2143	finally
    //   729	738	2143	finally
    //   738	783	2143	finally
    //   796	812	2143	finally
    //   821	894	2143	finally
    //   901	910	2143	finally
    //   915	924	2143	finally
    //   927	969	2143	finally
    //   969	979	2143	finally
    //   983	1018	2143	finally
    //   1027	1038	2143	finally
    //   1055	1071	2143	finally
    //   1080	1153	2143	finally
    //   1160	1170	2143	finally
    //   1175	1185	2143	finally
    //   1188	1230	2143	finally
    //   1230	1268	2143	finally
    //   1273	1284	2143	finally
    //   1297	1314	2143	finally
    //   1323	1396	2143	finally
    //   1403	1413	2143	finally
    //   1418	1428	2143	finally
    //   1431	1452	2143	finally
    //   1457	1468	2143	finally
    //   1673	1720	2147	finally
    //   112	146	2158	java/lang/Exception
    //   146	152	2158	java/lang/Exception
    //   156	161	2175	java/lang/Exception
    //   161	166	2192	java/lang/Exception
    //   171	192	2192	java/lang/Exception
    //   202	276	2192	java/lang/Exception
    //   276	284	2192	java/lang/Exception
    //   289	311	2208	java/lang/Exception
    //   1471	1483	2208	java/lang/Exception
    //   323	330	2219	java/lang/Exception
    //   336	343	2219	java/lang/Exception
    //   349	355	2219	java/lang/Exception
    //   361	372	2219	java/lang/Exception
    //   382	424	2219	java/lang/Exception
    //   513	520	2219	java/lang/Exception
    //   526	533	2219	java/lang/Exception
    //   539	546	2219	java/lang/Exception
    //   552	560	2219	java/lang/Exception
    //   566	578	2219	java/lang/Exception
    //   584	644	2219	java/lang/Exception
    //   424	431	2233	java/lang/Exception
    //   654	703	2233	java/lang/Exception
    //   703	724	2233	java/lang/Exception
    //   729	738	2233	java/lang/Exception
    //   738	783	2233	java/lang/Exception
    //   796	812	2233	java/lang/Exception
    //   821	894	2233	java/lang/Exception
    //   901	910	2233	java/lang/Exception
    //   915	924	2233	java/lang/Exception
    //   927	969	2233	java/lang/Exception
    //   969	979	2233	java/lang/Exception
    //   983	1018	2233	java/lang/Exception
    //   1027	1038	2233	java/lang/Exception
    //   1055	1071	2233	java/lang/Exception
    //   1080	1153	2233	java/lang/Exception
    //   1160	1170	2233	java/lang/Exception
    //   1175	1185	2233	java/lang/Exception
    //   1188	1230	2233	java/lang/Exception
    //   1230	1268	2233	java/lang/Exception
    //   1273	1284	2233	java/lang/Exception
    //   1297	1314	2233	java/lang/Exception
    //   1323	1396	2233	java/lang/Exception
    //   1403	1413	2233	java/lang/Exception
    //   1418	1428	2233	java/lang/Exception
    //   1431	1452	2233	java/lang/Exception
    //   1457	1468	2233	java/lang/Exception
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    int i;
    if (!this.jdField_b_of_type_Boolean)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
      if (i != 0) {
        break label86;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L)
      {
        this.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "isSaveDBAtOnce timeout30s isSaveDBAtOnceFlag:" + this.jdField_b_of_type_Boolean);
        }
      }
      bool1 = false;
    }
    label86:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (i != 1);
      this.jdField_b_of_type_Boolean = true;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MsgProxy", 2, "isSaveDBAtOnce unActionLoginB isSaveDBAtOnceFlag:" + this.jdField_b_of_type_Boolean);
    return true;
  }
  
  private boolean a(akej paramakej)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      try
      {
        if (i < jdField_a_of_type_ArrayOfJavaLangClass.length)
        {
          Class localClass1 = paramakej.getClass();
          Class localClass2 = jdField_a_of_type_ArrayOfJavaLangClass[i];
          if (localClass1 == localClass2) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  private void h()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i < this.jdField_a_of_type_ArrayOfAkej.length) && (!this.jdField_a_of_type_Boolean)) {
          if (a(this.jdField_a_of_type_ArrayOfAkej[i]))
          {
            this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ArrayOfAkej[i]);
          }
          else
          {
            beoj.a("i." + this.jdField_a_of_type_ArrayOfAkej[i]);
            long l = System.currentTimeMillis();
            this.jdField_a_of_type_ArrayOfAkej[i].a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + this.jdField_a_of_type_ArrayOfAkej[i].getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
            }
            beoj.a();
          }
        }
      }
      finally {}
      return;
      i += 1;
    }
  }
  
  public akar a()
  {
    return this.jdField_a_of_type_Akar;
  }
  
  public akbl a()
  {
    return this.jdField_a_of_type_Akbl;
  }
  
  public akbp a()
  {
    return this.jdField_a_of_type_Akbp;
  }
  
  public aken a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Aken.a();
      return this.jdField_b_of_type_Aken;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Aken.a();
      return this.jdField_a_of_type_Aken;
    }
    this.jdField_b_of_type_Aken.a();
    return this.jdField_b_of_type_Aken;
  }
  
  public akeq a()
  {
    return this.jdField_a_of_type_Akeq;
  }
  
  @Deprecated
  public akeu a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public also a()
  {
    return this.jdField_a_of_type_Also;
  }
  
  public alyh a()
  {
    return this.jdField_a_of_type_Alyh;
  }
  
  public aons a()
  {
    return this.jdField_a_of_type_Aons;
  }
  
  public apeh a()
  {
    return this.jdField_a_of_type_Apeh;
  }
  
  public arpq a()
  {
    return this.jdField_a_of_type_Arpq;
  }
  
  public aufp a()
  {
    return this.jdField_a_of_type_Aufp;
  }
  
  public ayrh a()
  {
    return this.jdField_a_of_type_Ayrh;
  }
  
  public Vector<aker> a()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          boolean bool = this.jdField_a_of_type_JavaUtilSet.isEmpty();
          if (!bool) {}
        }
        else
        {
          return;
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        if (localIterator.hasNext())
        {
          akej localakej = (akej)localIterator.next();
          beoj.a("i." + localakej);
          long l = System.currentTimeMillis();
          localakej.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localakej.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
          }
          beoj.a();
        }
        else
        {
          this.jdField_a_of_type_JavaUtilSet.clear();
        }
      }
      finally {}
    }
  }
  
  public void a(aket paramaket)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramaket)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaket);
    }
  }
  
  /* Error */
  public void a(atmp paramatmp)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 68	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +36 -> 53
    //   20: ldc_w 274
    //   23: iconst_2
    //   24: new 276	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 578
    //   34: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 102	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   41: invokevirtual 581	java/util/Vector:size	()I
    //   44: invokevirtual 584	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 102	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   57: invokevirtual 585	java/util/Vector:isEmpty	()Z
    //   60: ifeq +8 -> 68
    //   63: aload_3
    //   64: monitorexit
    //   65: aload_2
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: getfield 102	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   72: astore 4
    //   74: aload_0
    //   75: new 99	java/util/Vector
    //   78: dup
    //   79: invokespecial 100	java/util/Vector:<init>	()V
    //   82: putfield 102	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   85: aload_3
    //   86: monitorexit
    //   87: aload_0
    //   88: aload_1
    //   89: aload 4
    //   91: invokespecial 587	com/tencent/mobileqq/app/proxy/ProxyManager:a	(Latmp;Ljava/util/List;)V
    //   94: aload_0
    //   95: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   98: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   101: invokevirtual 595	awao:e	()V
    //   104: aload_2
    //   105: monitorexit
    //   106: return
    //   107: astore_1
    //   108: aload_2
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: aload_3
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ProxyManager
    //   0	117	1	paramatmp	atmp
    //   4	105	2	localObject1	Object
    //   72	18	4	localVector	Vector
    // Exception table:
    //   from	to	target	type
    //   7	14	107	finally
    //   65	67	107	finally
    //   87	106	107	finally
    //   108	110	107	finally
    //   115	117	107	finally
    //   14	53	112	finally
    //   53	65	112	finally
    //   68	87	112	finally
    //   113	115	112	finally
  }
  
  public void a(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      localArrayList = new ArrayList();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {
          return;
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
        while (localIterator.hasNext())
        {
          aker localaker = (aker)localIterator.next();
          if ((akbm.a(localaker.jdField_a_of_type_JavaLangString, paramString, localaker.jdField_a_of_type_Int, paramInt)) && ((localaker.jdField_b_of_type_Int == 1) || (localaker.jdField_b_of_type_Int == 2) || (localaker.jdField_b_of_type_Int == 0))) {
            localArrayList.add(localaker);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "transSaveToDatabase writeRunnable msgQueue size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilVector.size()), " item size:", Integer.valueOf(localArrayList.size()) });
    }
    this.jdField_a_of_type_JavaUtilVector.remove(localArrayList);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).createEntityManager(), localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
  }
  
  public void a(String arg1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, akes paramakes)
  {
    paramContentValues = new aker(???, paramInt1, paramString2, paramContentValues, paramString3, paramArrayOfString, paramInt2, paramakes);
    do
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        try
        {
          this.jdField_a_of_type_JavaUtilVector.add(paramContentValues);
          if (this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
            }
            f();
            return;
          }
        }
        catch (OutOfMemoryError paramContentValues)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue oom, " + paramString2);
            }
          }
        }
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
    }
    f();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, atmo paramatmo, int paramInt2, akes paramakes)
  {
    d(paramString1, paramInt1, paramString2, paramatmo, paramInt2, paramakes);
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
      }
      f();
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
    }
    f();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt2, akes paramakes)
  {
    a(paramString1, paramInt1, paramString2, null, paramString3, paramArrayOfString, paramInt2, paramakes);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangThread != null) && (this.jdField_a_of_type_JavaLangThread.getState() == Thread.State.NEW))
    {
      h();
      this.jdField_a_of_type_JavaLangThread.setName("QQ_DB");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  public void b(aket paramaket)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramaket)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramaket);
    }
  }
  
  public void b(String paramString1, int paramInt1, String paramString2, atmo paramatmo, int paramInt2, akes paramakes)
  {
    d(paramString1, paramInt1, paramString2, paramatmo, paramInt2, paramakes);
    f();
  }
  
  public void c()
  {
    jdField_a_of_type_Int += 1;
    float f;
    if (jdField_a_of_type_Int % 6 == 5)
    {
      long l1 = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
      long l2 = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
      f = (float)l1 / (float)l2;
      if (f <= 0.8D) {
        break label86;
      }
      jdField_b_of_type_Int /= 2;
      jdField_b_of_type_Int = Math.max(jdField_b_of_type_Int, jdField_c_of_type_Int);
    }
    label86:
    while (f >= 0.5D) {
      return;
    }
    jdField_b_of_type_Int += 2000;
    jdField_b_of_type_Int = Math.min(jdField_b_of_type_Int, d);
  }
  
  public void c(String paramString1, int paramInt1, String paramString2, atmo paramatmo, int paramInt2, akes paramakes)
  {
    d(paramString1, paramInt1, paramString2, paramatmo, paramInt2, paramakes);
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
      }
      f();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "transSaveToDatabase");
    }
    atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).createEntityManager();
    a(localatmp);
    localatmp.a();
  }
  
  public void d(String arg1, int paramInt1, String paramString2, atmo paramatmo, int paramInt2, akes paramakes)
  {
    paramatmo = new aker(???, paramInt1, paramString2, paramatmo, paramInt2, paramakes);
    if ((QLog.isColorLevel()) && ((paramatmo.jdField_a_of_type_Atmo instanceof MessageRecord))) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueueDonotNotify QueueItem.action: " + paramatmo.jdField_b_of_type_Int + ",mr=" + paramatmo.jdField_a_of_type_Atmo);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramatmo);
        return;
      }
      catch (OutOfMemoryError paramatmo)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue oom, " + paramString2);
          }
        }
      }
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilVector.clear();
      return;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_Ajwh.c();
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
  
  public void g()
  {
    a(2000);
  }
  
  public void onDestroy()
  {
    int j = 0;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().onDestroy();
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.post(new ProxyManager.1(this), 8, null, false);
      int i = j;
      if (this.jdField_a_of_type_JavaUtilVector != null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilVector != null) {
          this.jdField_a_of_type_JavaLangObject.notify();
        }
        i = j;
        if (i < this.jdField_a_of_type_ArrayOfAkej.length)
        {
          this.jdField_a_of_type_ArrayOfAkej[i].b();
          i += 1;
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyManager
 * JD-Core Version:    0.7.0.1
 */