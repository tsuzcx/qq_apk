package com.tencent.mobileqq.app.proxy;

import akko;
import akkq;
import akpc;
import akpw;
import akpx;
import akqa;
import aksu;
import aksw;
import aksx;
import aksy;
import akta;
import aktb;
import aktc;
import aktd;
import akte;
import aktf;
import amhe;
import amnw;
import android.content.ContentValues;
import aper;
import apwd;
import aslw;
import auko;
import aukp;
import aukq;
import avex;
import awzy;
import axra;
import azrz;
import bfwu;
import bgoe;
import bhvy;
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
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { avex.class, amnw.class };
  private static int jdField_b_of_type_Int = 10000;
  private static int jdField_c_of_type_Int = 2000;
  private static int d = 10000;
  private long jdField_a_of_type_Long;
  private akkq jdField_a_of_type_Akkq;
  private akpc jdField_a_of_type_Akpc;
  private akpw jdField_a_of_type_Akpw;
  private akqa jdField_a_of_type_Akqa;
  private aksy jdField_a_of_type_Aksy;
  private aktb jdField_a_of_type_Aktb;
  private amhe jdField_a_of_type_Amhe;
  private amnw jdField_a_of_type_Amnw;
  private aper jdField_a_of_type_Aper;
  private apwd jdField_a_of_type_Apwd;
  private aslw jdField_a_of_type_Aslw;
  private avex jdField_a_of_type_Avex;
  private axra jdField_a_of_type_Axra;
  private azrz jdField_a_of_type_Azrz;
  private bgoe jdField_a_of_type_Bgoe;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  public final Object a;
  private Thread jdField_a_of_type_JavaLangThread;
  private ArrayList<akte> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<aksu> jdField_a_of_type_JavaUtilSet = new HashSet();
  private Vector<aktc> jdField_a_of_type_JavaUtilVector;
  volatile boolean jdField_a_of_type_Boolean;
  private aksu[] jdField_a_of_type_ArrayOfAksu;
  private aksy jdField_b_of_type_Aksy;
  public Object b;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean = true;
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bhvy.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Akkq = paramQQAppInterface.a().a();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_Akpw = new akpw(paramQQAppInterface, this);
    this.jdField_a_of_type_Akqa = new akqa(paramQQAppInterface, this);
    this.jdField_b_of_type_Aksy = new aksx(paramQQAppInterface, this);
    this.jdField_a_of_type_Aksy = new aksw(paramQQAppInterface, this);
    this.jdField_a_of_type_Aktb = new aktb(paramQQAppInterface, this);
    this.jdField_a_of_type_Aper = new aper(paramQQAppInterface, this);
    this.jdField_a_of_type_Azrz = new azrz(paramQQAppInterface, this);
    this.jdField_a_of_type_Apwd = new apwd(paramQQAppInterface, this);
    this.jdField_a_of_type_Axra = new axra(paramQQAppInterface, this);
    this.jdField_a_of_type_Bgoe = new bgoe(paramQQAppInterface, this);
    this.jdField_a_of_type_Akpc = new akpc(paramQQAppInterface, this);
    this.jdField_a_of_type_Avex = new avex(paramQQAppInterface, this);
    this.jdField_a_of_type_Amnw = new amnw(paramQQAppInterface, this);
    this.jdField_a_of_type_Aslw = new aslw(paramQQAppInterface, this);
    this.jdField_a_of_type_Amhe = new amhe(paramQQAppInterface, this);
    this.jdField_a_of_type_ArrayOfAksu = new aksu[] { this.jdField_a_of_type_Akpw, this.jdField_b_of_type_Aksy, this.jdField_a_of_type_Aksy, this.jdField_a_of_type_Aper, this.jdField_a_of_type_Axra, this.jdField_a_of_type_Bgoe, this.jdField_a_of_type_Apwd, this.jdField_a_of_type_Akpc, this.jdField_a_of_type_Avex, this.jdField_a_of_type_Amnw, this.jdField_a_of_type_Azrz, this.jdField_a_of_type_Aslw, this.jdField_a_of_type_Amhe };
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
        ((akte)localIterator.next()).a(paramInt);
      }
    }
  }
  
  /* Error */
  private void a(aukp paramaukp, List<aktc> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 232 1 0
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_c_of_type_Boolean	Z
    //   14: ifeq +59 -> 73
    //   17: getstatic 235	akta:jdField_a_of_type_Boolean	Z
    //   20: ifeq +467 -> 487
    //   23: aload_0
    //   24: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokestatic 240	bbmo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   30: ifeq +457 -> 487
    //   33: aload_0
    //   34: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakta;
    //   40: invokevirtual 245	akta:a	()Z
    //   43: ifeq +30 -> 73
    //   46: aload_0
    //   47: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakta;
    //   53: invokevirtual 248	akta:a	()Lakti;
    //   56: astore 17
    //   58: aload 17
    //   60: ifnull +8 -> 68
    //   63: aload 17
    //   65: invokevirtual 252	akti:b	()V
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_c_of_type_Boolean	Z
    //   73: aconst_null
    //   74: astore 17
    //   76: invokestatic 255	axrn:a	()Z
    //   79: istore 10
    //   81: iload 10
    //   83: ifeq +412 -> 495
    //   86: iconst_0
    //   87: invokestatic 258	axrn:a	(I)Z
    //   90: ifeq +405 -> 495
    //   93: iconst_1
    //   94: istore 7
    //   96: invokestatic 264	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   99: astore 18
    //   101: invokestatic 267	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   104: astore 19
    //   106: aload 18
    //   108: aload 19
    //   110: if_acmpne +391 -> 501
    //   113: iconst_1
    //   114: istore 9
    //   116: iload 9
    //   118: ifeq +37 -> 155
    //   121: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +31 -> 155
    //   127: ldc_w 274
    //   130: iconst_2
    //   131: new 276	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 279
    //   141: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: iload 9
    //   146: invokevirtual 286	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   149: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_1
    //   156: invokevirtual 298	aukp:a	()Laukr;
    //   159: astore 18
    //   161: aload 18
    //   163: astore 17
    //   165: invokestatic 304	java/lang/System:nanoTime	()J
    //   168: lstore 13
    //   170: aload 17
    //   172: invokevirtual 308	aukr:a	()V
    //   175: iload 7
    //   177: ifeq +2085 -> 2262
    //   180: invokestatic 304	java/lang/System:nanoTime	()J
    //   183: lload 13
    //   185: lsub
    //   186: ldc2_w 309
    //   189: ldiv
    //   190: lstore 11
    //   192: new 312	java/util/HashMap
    //   195: dup
    //   196: invokespecial 313	java/util/HashMap:<init>	()V
    //   199: astore 19
    //   201: iload 9
    //   203: ifeq +304 -> 507
    //   206: ldc_w 315
    //   209: astore 18
    //   211: aload 19
    //   213: ldc_w 317
    //   216: aload 18
    //   218: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   221: pop
    //   222: aload 19
    //   224: ldc_w 323
    //   227: ldc_w 325
    //   230: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: pop
    //   234: aload 19
    //   236: ldc_w 327
    //   239: lload 11
    //   241: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   244: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   247: pop
    //   248: aload 19
    //   250: ldc_w 335
    //   253: getstatic 338	akfu:jdField_a_of_type_Boolean	Z
    //   256: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   259: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   262: pop
    //   263: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   266: invokestatic 350	axrn:a	(Landroid/content/Context;)Laxrn;
    //   269: aconst_null
    //   270: ldc_w 352
    //   273: iconst_1
    //   274: ldc2_w 353
    //   277: lconst_0
    //   278: aload 19
    //   280: aconst_null
    //   281: iconst_0
    //   282: invokevirtual 357	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   285: aload_2
    //   286: invokeinterface 358 1 0
    //   291: astore 18
    //   293: iconst_0
    //   294: istore_3
    //   295: iconst_0
    //   296: istore 4
    //   298: aload 18
    //   300: invokeinterface 218 1 0
    //   305: ifeq +1174 -> 1479
    //   308: aload 18
    //   310: invokeinterface 222 1 0
    //   315: checkcast 360	aktc
    //   318: astore 19
    //   320: iload 4
    //   322: iconst_1
    //   323: iadd
    //   324: istore 4
    //   326: iload_3
    //   327: istore 6
    //   329: iload_3
    //   330: istore 5
    //   332: aload 19
    //   334: getfield 363	aktc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   337: astore 20
    //   339: iload_3
    //   340: istore 6
    //   342: iload_3
    //   343: istore 5
    //   345: aload 19
    //   347: getfield 366	aktc:jdField_a_of_type_Aktd	Laktd;
    //   350: astore 21
    //   352: iload_3
    //   353: istore 6
    //   355: iload_3
    //   356: istore 5
    //   358: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +1909 -> 2270
    //   364: iload_3
    //   365: istore 6
    //   367: iload_3
    //   368: istore 5
    //   370: aload 19
    //   372: getfield 369	aktc:jdField_a_of_type_Auko	Lauko;
    //   375: instanceof 371
    //   378: ifeq +137 -> 515
    //   381: iload_3
    //   382: iconst_1
    //   383: iadd
    //   384: istore_3
    //   385: iload_3
    //   386: istore 6
    //   388: iload_3
    //   389: istore 5
    //   391: ldc_w 274
    //   394: iconst_2
    //   395: iconst_4
    //   396: anewarray 4	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: ldc_w 373
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: aload 19
    //   409: getfield 374	aktc:jdField_b_of_type_Int	I
    //   412: invokestatic 379	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aastore
    //   416: dup
    //   417: iconst_2
    //   418: ldc_w 381
    //   421: aastore
    //   422: dup
    //   423: iconst_3
    //   424: aload 19
    //   426: getfield 369	aktc:jdField_a_of_type_Auko	Lauko;
    //   429: aastore
    //   430: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   433: aload 19
    //   435: getfield 374	aktc:jdField_b_of_type_Int	I
    //   438: istore 5
    //   440: iload 5
    //   442: tableswitch	default:+42 -> 484, 0:+220->662, 1:+493->935, 2:+754->1196, 3:+467->909, 4:+726->1168, 5:+969->1411, 6:+997->1439
    //   485: impdep2
    //   486: fstore_3
    //   487: aload_0
    //   488: iconst_0
    //   489: putfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_c_of_type_Boolean	Z
    //   492: goto -419 -> 73
    //   495: iconst_0
    //   496: istore 7
    //   498: goto -402 -> 96
    //   501: iconst_0
    //   502: istore 9
    //   504: goto -388 -> 116
    //   507: ldc_w 386
    //   510: astore 18
    //   512: goto -301 -> 211
    //   515: iload_3
    //   516: istore 6
    //   518: iload_3
    //   519: istore 5
    //   521: aload 19
    //   523: getfield 374	aktc:jdField_b_of_type_Int	I
    //   526: istore 8
    //   528: iload_3
    //   529: istore 6
    //   531: iload_3
    //   532: istore 5
    //   534: aload 19
    //   536: getfield 388	aktc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   539: astore 22
    //   541: iload_3
    //   542: istore 6
    //   544: iload_3
    //   545: istore 5
    //   547: aload 19
    //   549: getfield 363	aktc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   552: astore 23
    //   554: iload_3
    //   555: istore 6
    //   557: iload_3
    //   558: istore 5
    //   560: aload 19
    //   562: getfield 391	aktc:jdField_a_of_type_AndroidContentContentValues	Landroid/content/ContentValues;
    //   565: ifnull +90 -> 655
    //   568: iload_3
    //   569: istore 6
    //   571: iload_3
    //   572: istore 5
    //   574: aload 19
    //   576: getfield 391	aktc:jdField_a_of_type_AndroidContentContentValues	Landroid/content/ContentValues;
    //   579: invokevirtual 396	android/content/ContentValues:hashCode	()I
    //   582: invokestatic 379	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   585: astore_2
    //   586: iload_3
    //   587: istore 6
    //   589: iload_3
    //   590: istore 5
    //   592: ldc_w 274
    //   595: iconst_2
    //   596: bipush 8
    //   598: anewarray 4	java/lang/Object
    //   601: dup
    //   602: iconst_0
    //   603: ldc_w 373
    //   606: aastore
    //   607: dup
    //   608: iconst_1
    //   609: iload 8
    //   611: invokestatic 379	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: aastore
    //   615: dup
    //   616: iconst_2
    //   617: ldc_w 398
    //   620: aastore
    //   621: dup
    //   622: iconst_3
    //   623: aload 22
    //   625: aastore
    //   626: dup
    //   627: iconst_4
    //   628: ldc_w 400
    //   631: aastore
    //   632: dup
    //   633: iconst_5
    //   634: aload 23
    //   636: aastore
    //   637: dup
    //   638: bipush 6
    //   640: ldc_w 402
    //   643: aastore
    //   644: dup
    //   645: bipush 7
    //   647: aload_2
    //   648: aastore
    //   649: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   652: goto +1618 -> 2270
    //   655: ldc_w 404
    //   658: astore_2
    //   659: goto -73 -> 586
    //   662: invokestatic 304	java/lang/System:nanoTime	()J
    //   665: lstore 11
    //   667: getstatic 235	akta:jdField_a_of_type_Boolean	Z
    //   670: ifeq +41 -> 711
    //   673: aload_0
    //   674: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   677: invokestatic 240	bbmo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   680: ifeq +31 -> 711
    //   683: aload_0
    //   684: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   687: invokestatic 406	bbmo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   690: ifeq +21 -> 711
    //   693: aload_0
    //   694: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   697: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakta;
    //   700: invokevirtual 248	akta:a	()Lakti;
    //   703: aload 19
    //   705: getfield 369	aktc:jdField_a_of_type_Auko	Lauko;
    //   708: invokevirtual 409	akti:a	(Lauko;)V
    //   711: aload_1
    //   712: aload 19
    //   714: getfield 369	aktc:jdField_a_of_type_Auko	Lauko;
    //   717: invokevirtual 411	aukp:b	(Lauko;)V
    //   720: invokestatic 304	java/lang/System:nanoTime	()J
    //   723: lload 11
    //   725: lsub
    //   726: ldc2_w 309
    //   729: ldiv
    //   730: lstore 15
    //   732: aload 21
    //   734: ifnull +12 -> 746
    //   737: aload 21
    //   739: aload 20
    //   741: invokeinterface 416 2 0
    //   746: getstatic 235	akta:jdField_a_of_type_Boolean	Z
    //   749: ifeq +42 -> 791
    //   752: aload_0
    //   753: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   756: invokestatic 240	bbmo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   759: ifeq +32 -> 791
    //   762: aload_0
    //   763: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   766: invokestatic 406	bbmo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   769: ifeq +22 -> 791
    //   772: aload_0
    //   773: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   776: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakta;
    //   779: invokevirtual 248	akta:a	()Lakti;
    //   782: aload 19
    //   784: getfield 369	aktc:jdField_a_of_type_Auko	Lauko;
    //   787: aload_1
    //   788: invokevirtual 419	akti:a	(Lauko;Laukp;)V
    //   791: lload 15
    //   793: lstore 11
    //   795: iload 10
    //   797: ifeq +1455 -> 2252
    //   800: lload 15
    //   802: lstore 11
    //   804: iconst_4
    //   805: invokestatic 258	axrn:a	(I)Z
    //   808: ifeq +1444 -> 2252
    //   811: new 312	java/util/HashMap
    //   814: dup
    //   815: invokespecial 313	java/util/HashMap:<init>	()V
    //   818: astore 19
    //   820: iload 9
    //   822: ifeq +1451 -> 2273
    //   825: ldc_w 315
    //   828: astore_2
    //   829: aload 19
    //   831: ldc_w 317
    //   834: aload_2
    //   835: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   838: pop
    //   839: aload 19
    //   841: ldc_w 323
    //   844: ldc_w 421
    //   847: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   850: pop
    //   851: aload 19
    //   853: ldc_w 327
    //   856: lload 15
    //   858: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   861: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   864: pop
    //   865: aload 19
    //   867: ldc_w 335
    //   870: getstatic 338	akfu:jdField_a_of_type_Boolean	Z
    //   873: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   876: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   879: pop
    //   880: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   883: invokestatic 350	axrn:a	(Landroid/content/Context;)Laxrn;
    //   886: aconst_null
    //   887: ldc_w 352
    //   890: iconst_1
    //   891: ldc2_w 353
    //   894: lconst_0
    //   895: aload 19
    //   897: aconst_null
    //   898: iconst_0
    //   899: invokevirtual 357	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   902: lload 15
    //   904: lstore 11
    //   906: goto -422 -> 484
    //   909: aload_1
    //   910: aload 19
    //   912: getfield 369	aktc:jdField_a_of_type_Auko	Lauko;
    //   915: invokevirtual 411	aukp:b	(Lauko;)V
    //   918: aload 21
    //   920: ifnull -436 -> 484
    //   923: aload 21
    //   925: aload 20
    //   927: invokeinterface 416 2 0
    //   932: goto -448 -> 484
    //   935: getstatic 235	akta:jdField_a_of_type_Boolean	Z
    //   938: ifeq +39 -> 977
    //   941: aload_0
    //   942: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   945: invokestatic 240	bbmo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   948: ifeq +29 -> 977
    //   951: aload_0
    //   952: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   955: invokestatic 406	bbmo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   958: ifeq +19 -> 977
    //   961: aload_0
    //   962: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   965: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakta;
    //   968: invokevirtual 248	akta:a	()Lakti;
    //   971: aload 19
    //   973: aload_1
    //   974: invokevirtual 424	akti:a	(Laktc;Laukp;)V
    //   977: invokestatic 304	java/lang/System:nanoTime	()J
    //   980: lstore 15
    //   982: aload_0
    //   983: invokespecial 425	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   986: astore_2
    //   987: aload_2
    //   988: ifnull +1267 -> 2255
    //   991: aload_2
    //   992: aload 20
    //   994: aload 19
    //   996: getfield 391	aktc:jdField_a_of_type_AndroidContentContentValues	Landroid/content/ContentValues;
    //   999: aload 19
    //   1001: getfield 427	aktc:c	Ljava/lang/String;
    //   1004: aload 19
    //   1006: getfield 430	aktc:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1009: invokevirtual 435	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1012: istore 5
    //   1014: invokestatic 304	java/lang/System:nanoTime	()J
    //   1017: lload 15
    //   1019: lsub
    //   1020: ldc2_w 309
    //   1023: ldiv
    //   1024: lstore 11
    //   1026: lload 11
    //   1028: lstore 15
    //   1030: aload 21
    //   1032: ifnull +18 -> 1050
    //   1035: aload 21
    //   1037: aload 20
    //   1039: iload 5
    //   1041: invokeinterface 438 3 0
    //   1046: lload 11
    //   1048: lstore 15
    //   1050: lload 15
    //   1052: lstore 11
    //   1054: iload 10
    //   1056: ifeq +1196 -> 2252
    //   1059: lload 15
    //   1061: lstore 11
    //   1063: iconst_5
    //   1064: invokestatic 258	axrn:a	(I)Z
    //   1067: ifeq +1185 -> 2252
    //   1070: new 312	java/util/HashMap
    //   1073: dup
    //   1074: invokespecial 313	java/util/HashMap:<init>	()V
    //   1077: astore 19
    //   1079: iload 9
    //   1081: ifeq +1199 -> 2280
    //   1084: ldc_w 315
    //   1087: astore_2
    //   1088: aload 19
    //   1090: ldc_w 317
    //   1093: aload_2
    //   1094: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1097: pop
    //   1098: aload 19
    //   1100: ldc_w 323
    //   1103: ldc_w 440
    //   1106: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1109: pop
    //   1110: aload 19
    //   1112: ldc_w 327
    //   1115: lload 15
    //   1117: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1120: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1123: pop
    //   1124: aload 19
    //   1126: ldc_w 335
    //   1129: getstatic 338	akfu:jdField_a_of_type_Boolean	Z
    //   1132: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1135: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1138: pop
    //   1139: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1142: invokestatic 350	axrn:a	(Landroid/content/Context;)Laxrn;
    //   1145: aconst_null
    //   1146: ldc_w 352
    //   1149: iconst_1
    //   1150: ldc2_w 353
    //   1153: lconst_0
    //   1154: aload 19
    //   1156: aconst_null
    //   1157: iconst_0
    //   1158: invokevirtual 357	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1161: lload 15
    //   1163: lstore 11
    //   1165: goto -681 -> 484
    //   1168: aload_1
    //   1169: aload 19
    //   1171: getfield 369	aktc:jdField_a_of_type_Auko	Lauko;
    //   1174: invokevirtual 443	aukp:a	(Lauko;)Z
    //   1177: pop
    //   1178: aload 21
    //   1180: ifnull -696 -> 484
    //   1183: aload 21
    //   1185: aload 20
    //   1187: iconst_1
    //   1188: invokeinterface 438 3 0
    //   1193: goto -709 -> 484
    //   1196: getstatic 235	akta:jdField_a_of_type_Boolean	Z
    //   1199: ifeq +39 -> 1238
    //   1202: aload_0
    //   1203: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1206: invokestatic 240	bbmo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1209: ifeq +29 -> 1238
    //   1212: aload_0
    //   1213: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1216: invokestatic 406	bbmo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1219: ifeq +19 -> 1238
    //   1222: aload_0
    //   1223: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1226: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:a	()Lakta;
    //   1229: invokevirtual 248	akta:a	()Lakti;
    //   1232: aload 19
    //   1234: aload_1
    //   1235: invokevirtual 445	akti:b	(Laktc;Laukp;)V
    //   1238: invokestatic 304	java/lang/System:nanoTime	()J
    //   1241: lstore 11
    //   1243: aload_0
    //   1244: invokespecial 425	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1247: aload 20
    //   1249: aload 19
    //   1251: getfield 427	aktc:c	Ljava/lang/String;
    //   1254: aload 19
    //   1256: getfield 430	aktc:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1259: invokevirtual 448	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1262: istore 5
    //   1264: invokestatic 304	java/lang/System:nanoTime	()J
    //   1267: lload 11
    //   1269: lsub
    //   1270: ldc2_w 309
    //   1273: ldiv
    //   1274: lstore 15
    //   1276: aload 21
    //   1278: ifnull +14 -> 1292
    //   1281: aload 21
    //   1283: aload 20
    //   1285: iload 5
    //   1287: invokeinterface 450 3 0
    //   1292: lload 15
    //   1294: lstore 11
    //   1296: iload 10
    //   1298: ifeq +954 -> 2252
    //   1301: lload 15
    //   1303: lstore 11
    //   1305: bipush 6
    //   1307: invokestatic 258	axrn:a	(I)Z
    //   1310: ifeq +942 -> 2252
    //   1313: new 312	java/util/HashMap
    //   1316: dup
    //   1317: invokespecial 313	java/util/HashMap:<init>	()V
    //   1320: astore 19
    //   1322: iload 9
    //   1324: ifeq +963 -> 2287
    //   1327: ldc_w 315
    //   1330: astore_2
    //   1331: aload 19
    //   1333: ldc_w 317
    //   1336: aload_2
    //   1337: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1340: pop
    //   1341: aload 19
    //   1343: ldc_w 323
    //   1346: ldc_w 452
    //   1349: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1352: pop
    //   1353: aload 19
    //   1355: ldc_w 327
    //   1358: lload 15
    //   1360: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1363: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1366: pop
    //   1367: aload 19
    //   1369: ldc_w 335
    //   1372: getstatic 338	akfu:jdField_a_of_type_Boolean	Z
    //   1375: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1378: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1381: pop
    //   1382: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1385: invokestatic 350	axrn:a	(Landroid/content/Context;)Laxrn;
    //   1388: aconst_null
    //   1389: ldc_w 352
    //   1392: iconst_1
    //   1393: ldc2_w 353
    //   1396: lconst_0
    //   1397: aload 19
    //   1399: aconst_null
    //   1400: iconst_0
    //   1401: invokevirtual 357	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1404: lload 15
    //   1406: lstore 11
    //   1408: goto -924 -> 484
    //   1411: aload_1
    //   1412: aload 19
    //   1414: getfield 369	aktc:jdField_a_of_type_Auko	Lauko;
    //   1417: invokevirtual 454	aukp:b	(Lauko;)Z
    //   1420: pop
    //   1421: aload 21
    //   1423: ifnull -939 -> 484
    //   1426: aload 21
    //   1428: aload 20
    //   1430: iconst_1
    //   1431: invokeinterface 450 3 0
    //   1436: goto -952 -> 484
    //   1439: aload_0
    //   1440: invokespecial 425	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1443: aload 20
    //   1445: aload 19
    //   1447: getfield 427	aktc:c	Ljava/lang/String;
    //   1450: aload 19
    //   1452: getfield 430	aktc:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1455: invokevirtual 448	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1458: istore 5
    //   1460: aload 21
    //   1462: ifnull +14 -> 1476
    //   1465: aload 21
    //   1467: aload 20
    //   1469: iload 5
    //   1471: invokeinterface 450 3 0
    //   1476: goto -992 -> 484
    //   1479: aload 17
    //   1481: invokevirtual 456	aukr:c	()V
    //   1484: aload_0
    //   1485: sipush 1000
    //   1488: invokespecial 457	com/tencent/mobileqq/app/proxy/ProxyManager:a	(I)V
    //   1491: aload 17
    //   1493: ifnull -1484 -> 9
    //   1496: aload 17
    //   1498: invokevirtual 458	aukr:b	()V
    //   1501: invokestatic 304	java/lang/System:nanoTime	()J
    //   1504: lload 13
    //   1506: lsub
    //   1507: ldc2_w 309
    //   1510: ldiv
    //   1511: lstore 11
    //   1513: iload 7
    //   1515: ifeq -1506 -> 9
    //   1518: new 312	java/util/HashMap
    //   1521: dup
    //   1522: invokespecial 313	java/util/HashMap:<init>	()V
    //   1525: astore_2
    //   1526: iload 9
    //   1528: ifeq +129 -> 1657
    //   1531: ldc_w 315
    //   1534: astore_1
    //   1535: aload_2
    //   1536: ldc_w 317
    //   1539: aload_1
    //   1540: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1543: pop
    //   1544: aload_2
    //   1545: ldc_w 323
    //   1548: ldc_w 460
    //   1551: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1554: pop
    //   1555: aload_2
    //   1556: ldc_w 327
    //   1559: lload 11
    //   1561: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1564: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1567: pop
    //   1568: aload_2
    //   1569: ldc_w 462
    //   1572: iload 4
    //   1574: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1577: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1580: pop
    //   1581: aload_2
    //   1582: ldc_w 467
    //   1585: iload_3
    //   1586: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1589: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1592: pop
    //   1593: aload_2
    //   1594: ldc_w 469
    //   1597: lload 11
    //   1599: l2f
    //   1600: iload 4
    //   1602: i2f
    //   1603: fdiv
    //   1604: invokestatic 472	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1607: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1610: pop
    //   1611: aload_2
    //   1612: ldc_w 474
    //   1615: ldc_w 460
    //   1618: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1621: pop
    //   1622: aload_2
    //   1623: ldc_w 335
    //   1626: getstatic 338	akfu:jdField_a_of_type_Boolean	Z
    //   1629: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1632: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1635: pop
    //   1636: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1639: invokestatic 350	axrn:a	(Landroid/content/Context;)Laxrn;
    //   1642: aconst_null
    //   1643: ldc_w 476
    //   1646: iconst_1
    //   1647: lload 11
    //   1649: lconst_0
    //   1650: aload_2
    //   1651: aconst_null
    //   1652: iconst_0
    //   1653: invokevirtual 357	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1656: return
    //   1657: ldc_w 386
    //   1660: astore_1
    //   1661: goto -126 -> 1535
    //   1664: astore_1
    //   1665: ldc2_w 353
    //   1668: lstore 11
    //   1670: iconst_0
    //   1671: istore 4
    //   1673: iconst_0
    //   1674: istore 9
    //   1676: iconst_0
    //   1677: istore_3
    //   1678: aload 17
    //   1680: astore_2
    //   1681: aload_1
    //   1682: invokevirtual 479	java/lang/Exception:printStackTrace	()V
    //   1685: aload_0
    //   1686: sipush 1001
    //   1689: invokespecial 457	com/tencent/mobileqq/app/proxy/ProxyManager:a	(I)V
    //   1692: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1695: ifeq +33 -> 1728
    //   1698: ldc_w 274
    //   1701: iconst_2
    //   1702: new 276	java/lang/StringBuilder
    //   1705: dup
    //   1706: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1709: ldc_w 481
    //   1712: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: aload_1
    //   1716: invokevirtual 484	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1719: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1725: invokestatic 487	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1728: aload_2
    //   1729: ifnull -1720 -> 9
    //   1732: aload_2
    //   1733: invokevirtual 458	aukr:b	()V
    //   1736: invokestatic 304	java/lang/System:nanoTime	()J
    //   1739: lload 11
    //   1741: lsub
    //   1742: ldc2_w 309
    //   1745: ldiv
    //   1746: lstore 11
    //   1748: iload 7
    //   1750: ifeq -1741 -> 9
    //   1753: new 312	java/util/HashMap
    //   1756: dup
    //   1757: invokespecial 313	java/util/HashMap:<init>	()V
    //   1760: astore_2
    //   1761: iload 9
    //   1763: ifeq +129 -> 1892
    //   1766: ldc_w 315
    //   1769: astore_1
    //   1770: aload_2
    //   1771: ldc_w 317
    //   1774: aload_1
    //   1775: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1778: pop
    //   1779: aload_2
    //   1780: ldc_w 323
    //   1783: ldc_w 460
    //   1786: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1789: pop
    //   1790: aload_2
    //   1791: ldc_w 327
    //   1794: lload 11
    //   1796: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1799: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1802: pop
    //   1803: aload_2
    //   1804: ldc_w 462
    //   1807: iload 4
    //   1809: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1812: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1815: pop
    //   1816: aload_2
    //   1817: ldc_w 467
    //   1820: iload_3
    //   1821: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1824: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1827: pop
    //   1828: aload_2
    //   1829: ldc_w 469
    //   1832: lload 11
    //   1834: l2f
    //   1835: iload 4
    //   1837: i2f
    //   1838: fdiv
    //   1839: invokestatic 472	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1842: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1845: pop
    //   1846: aload_2
    //   1847: ldc_w 474
    //   1850: ldc_w 460
    //   1853: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1856: pop
    //   1857: aload_2
    //   1858: ldc_w 335
    //   1861: getstatic 338	akfu:jdField_a_of_type_Boolean	Z
    //   1864: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1867: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1870: pop
    //   1871: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1874: invokestatic 350	axrn:a	(Landroid/content/Context;)Laxrn;
    //   1877: aconst_null
    //   1878: ldc_w 476
    //   1881: iconst_1
    //   1882: lload 11
    //   1884: lconst_0
    //   1885: aload_2
    //   1886: aconst_null
    //   1887: iconst_0
    //   1888: invokevirtual 357	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1891: return
    //   1892: ldc_w 386
    //   1895: astore_1
    //   1896: goto -126 -> 1770
    //   1899: astore_1
    //   1900: iconst_0
    //   1901: istore_3
    //   1902: iconst_0
    //   1903: istore 4
    //   1905: ldc2_w 353
    //   1908: lstore 13
    //   1910: iconst_0
    //   1911: istore 9
    //   1913: aconst_null
    //   1914: astore 17
    //   1916: aload 17
    //   1918: ifnull +173 -> 2091
    //   1921: aload 17
    //   1923: invokevirtual 458	aukr:b	()V
    //   1926: invokestatic 304	java/lang/System:nanoTime	()J
    //   1929: lload 13
    //   1931: lsub
    //   1932: ldc2_w 309
    //   1935: ldiv
    //   1936: lstore 11
    //   1938: iload 7
    //   1940: ifeq +151 -> 2091
    //   1943: new 312	java/util/HashMap
    //   1946: dup
    //   1947: invokespecial 313	java/util/HashMap:<init>	()V
    //   1950: astore 17
    //   1952: iload 9
    //   1954: ifeq +139 -> 2093
    //   1957: ldc_w 315
    //   1960: astore_2
    //   1961: aload 17
    //   1963: ldc_w 317
    //   1966: aload_2
    //   1967: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1970: pop
    //   1971: aload 17
    //   1973: ldc_w 323
    //   1976: ldc_w 460
    //   1979: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1982: pop
    //   1983: aload 17
    //   1985: ldc_w 327
    //   1988: lload 11
    //   1990: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1993: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1996: pop
    //   1997: aload 17
    //   1999: ldc_w 462
    //   2002: iload 4
    //   2004: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2007: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2010: pop
    //   2011: aload 17
    //   2013: ldc_w 467
    //   2016: iload_3
    //   2017: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2020: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2023: pop
    //   2024: aload 17
    //   2026: ldc_w 469
    //   2029: lload 11
    //   2031: l2f
    //   2032: iload 4
    //   2034: i2f
    //   2035: fdiv
    //   2036: invokestatic 472	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   2039: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2042: pop
    //   2043: aload 17
    //   2045: ldc_w 474
    //   2048: ldc_w 460
    //   2051: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2054: pop
    //   2055: aload 17
    //   2057: ldc_w 335
    //   2060: getstatic 338	akfu:jdField_a_of_type_Boolean	Z
    //   2063: invokestatic 341	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2066: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2069: pop
    //   2070: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2073: invokestatic 350	axrn:a	(Landroid/content/Context;)Laxrn;
    //   2076: aconst_null
    //   2077: ldc_w 476
    //   2080: iconst_1
    //   2081: lload 11
    //   2083: lconst_0
    //   2084: aload 17
    //   2086: aconst_null
    //   2087: iconst_0
    //   2088: invokevirtual 357	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2091: aload_1
    //   2092: athrow
    //   2093: ldc_w 386
    //   2096: astore_2
    //   2097: goto -136 -> 1961
    //   2100: astore_1
    //   2101: iconst_0
    //   2102: istore_3
    //   2103: iconst_0
    //   2104: istore 4
    //   2106: ldc2_w 353
    //   2109: lstore 13
    //   2111: aconst_null
    //   2112: astore 17
    //   2114: goto -198 -> 1916
    //   2117: astore_1
    //   2118: iconst_0
    //   2119: istore_3
    //   2120: iconst_0
    //   2121: istore 4
    //   2123: ldc2_w 353
    //   2126: lstore 13
    //   2128: goto -212 -> 1916
    //   2131: astore_1
    //   2132: iconst_0
    //   2133: istore_3
    //   2134: iconst_0
    //   2135: istore 4
    //   2137: goto -221 -> 1916
    //   2140: astore_1
    //   2141: goto -225 -> 1916
    //   2144: astore_1
    //   2145: iload 6
    //   2147: istore_3
    //   2148: goto -232 -> 1916
    //   2151: astore_1
    //   2152: goto -236 -> 1916
    //   2155: astore_1
    //   2156: lload 11
    //   2158: lstore 13
    //   2160: aload_2
    //   2161: astore 17
    //   2163: goto -247 -> 1916
    //   2166: astore_1
    //   2167: iconst_0
    //   2168: istore_3
    //   2169: ldc2_w 353
    //   2172: lstore 11
    //   2174: iconst_0
    //   2175: istore 4
    //   2177: aload 17
    //   2179: astore_2
    //   2180: goto -499 -> 1681
    //   2183: astore_1
    //   2184: iconst_0
    //   2185: istore_3
    //   2186: ldc2_w 353
    //   2189: lstore 11
    //   2191: aload 17
    //   2193: astore_2
    //   2194: iconst_0
    //   2195: istore 4
    //   2197: goto -516 -> 1681
    //   2200: astore_1
    //   2201: iconst_0
    //   2202: istore_3
    //   2203: iconst_0
    //   2204: istore 4
    //   2206: lload 13
    //   2208: lstore 11
    //   2210: aload 17
    //   2212: astore_2
    //   2213: goto -532 -> 1681
    //   2216: astore_1
    //   2217: lload 13
    //   2219: lstore 11
    //   2221: aload 17
    //   2223: astore_2
    //   2224: goto -543 -> 1681
    //   2227: astore_1
    //   2228: lload 13
    //   2230: lstore 11
    //   2232: aload 17
    //   2234: astore_2
    //   2235: iload 5
    //   2237: istore_3
    //   2238: goto -557 -> 1681
    //   2241: astore_1
    //   2242: lload 13
    //   2244: lstore 11
    //   2246: aload 17
    //   2248: astore_2
    //   2249: goto -568 -> 1681
    //   2252: goto -1768 -> 484
    //   2255: lload 11
    //   2257: lstore 15
    //   2259: goto -1209 -> 1050
    //   2262: ldc2_w 353
    //   2265: lstore 11
    //   2267: goto -1982 -> 285
    //   2270: goto -1837 -> 433
    //   2273: ldc_w 386
    //   2276: astore_2
    //   2277: goto -1448 -> 829
    //   2280: ldc_w 386
    //   2283: astore_2
    //   2284: goto -1196 -> 1088
    //   2287: ldc_w 386
    //   2290: astore_2
    //   2291: goto -960 -> 1331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2294	0	this	ProxyManager
    //   0	2294	1	paramaukp	aukp
    //   0	2294	2	paramList	List<aktc>
    //   294	1944	3	i	int
    //   296	1909	4	j	int
    //   330	1906	5	k	int
    //   327	1819	6	m	int
    //   94	1845	7	n	int
    //   526	84	8	i1	int
    //   114	1839	9	bool1	boolean
    //   79	1218	10	bool2	boolean
    //   190	2076	11	l1	long
    //   168	2075	13	l2	long
    //   730	1528	15	l3	long
    //   56	2191	17	localObject1	Object
    //   99	412	18	localObject2	Object
    //   104	1347	19	localObject3	Object
    //   337	1131	20	str1	String
    //   350	1116	21	localaktd	aktd
    //   539	85	22	str2	String
    //   552	83	23	str3	String
    // Exception table:
    //   from	to	target	type
    //   96	106	1664	java/lang/Exception
    //   96	106	1899	finally
    //   121	155	2100	finally
    //   155	161	2100	finally
    //   165	170	2117	finally
    //   170	175	2131	finally
    //   180	201	2131	finally
    //   211	285	2131	finally
    //   285	293	2131	finally
    //   298	320	2140	finally
    //   1479	1491	2140	finally
    //   332	339	2144	finally
    //   345	352	2144	finally
    //   358	364	2144	finally
    //   370	381	2144	finally
    //   391	433	2144	finally
    //   521	528	2144	finally
    //   534	541	2144	finally
    //   547	554	2144	finally
    //   560	568	2144	finally
    //   574	586	2144	finally
    //   592	652	2144	finally
    //   433	440	2151	finally
    //   662	711	2151	finally
    //   711	732	2151	finally
    //   737	746	2151	finally
    //   746	791	2151	finally
    //   804	820	2151	finally
    //   829	902	2151	finally
    //   909	918	2151	finally
    //   923	932	2151	finally
    //   935	977	2151	finally
    //   977	987	2151	finally
    //   991	1026	2151	finally
    //   1035	1046	2151	finally
    //   1063	1079	2151	finally
    //   1088	1161	2151	finally
    //   1168	1178	2151	finally
    //   1183	1193	2151	finally
    //   1196	1238	2151	finally
    //   1238	1276	2151	finally
    //   1281	1292	2151	finally
    //   1305	1322	2151	finally
    //   1331	1404	2151	finally
    //   1411	1421	2151	finally
    //   1426	1436	2151	finally
    //   1439	1460	2151	finally
    //   1465	1476	2151	finally
    //   1681	1728	2155	finally
    //   121	155	2166	java/lang/Exception
    //   155	161	2166	java/lang/Exception
    //   165	170	2183	java/lang/Exception
    //   170	175	2200	java/lang/Exception
    //   180	201	2200	java/lang/Exception
    //   211	285	2200	java/lang/Exception
    //   285	293	2200	java/lang/Exception
    //   298	320	2216	java/lang/Exception
    //   1479	1491	2216	java/lang/Exception
    //   332	339	2227	java/lang/Exception
    //   345	352	2227	java/lang/Exception
    //   358	364	2227	java/lang/Exception
    //   370	381	2227	java/lang/Exception
    //   391	433	2227	java/lang/Exception
    //   521	528	2227	java/lang/Exception
    //   534	541	2227	java/lang/Exception
    //   547	554	2227	java/lang/Exception
    //   560	568	2227	java/lang/Exception
    //   574	586	2227	java/lang/Exception
    //   592	652	2227	java/lang/Exception
    //   433	440	2241	java/lang/Exception
    //   662	711	2241	java/lang/Exception
    //   711	732	2241	java/lang/Exception
    //   737	746	2241	java/lang/Exception
    //   746	791	2241	java/lang/Exception
    //   804	820	2241	java/lang/Exception
    //   829	902	2241	java/lang/Exception
    //   909	918	2241	java/lang/Exception
    //   923	932	2241	java/lang/Exception
    //   935	977	2241	java/lang/Exception
    //   977	987	2241	java/lang/Exception
    //   991	1026	2241	java/lang/Exception
    //   1035	1046	2241	java/lang/Exception
    //   1063	1079	2241	java/lang/Exception
    //   1088	1161	2241	java/lang/Exception
    //   1168	1178	2241	java/lang/Exception
    //   1183	1193	2241	java/lang/Exception
    //   1196	1238	2241	java/lang/Exception
    //   1238	1276	2241	java/lang/Exception
    //   1281	1292	2241	java/lang/Exception
    //   1305	1322	2241	java/lang/Exception
    //   1331	1404	2241	java/lang/Exception
    //   1411	1421	2241	java/lang/Exception
    //   1426	1436	2241	java/lang/Exception
    //   1439	1460	2241	java/lang/Exception
    //   1465	1476	2241	java/lang/Exception
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
  
  private boolean a(aksu paramaksu)
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
          Class localClass1 = paramaksu.getClass();
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
        if ((i < this.jdField_a_of_type_ArrayOfAksu.length) && (!this.jdField_a_of_type_Boolean)) {
          if (a(this.jdField_a_of_type_ArrayOfAksu[i]))
          {
            this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ArrayOfAksu[i]);
          }
          else
          {
            bfwu.a("i." + this.jdField_a_of_type_ArrayOfAksu[i]);
            long l = System.currentTimeMillis();
            this.jdField_a_of_type_ArrayOfAksu[i].a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + this.jdField_a_of_type_ArrayOfAksu[i].getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
            }
            bfwu.a();
          }
        }
      }
      finally {}
      return;
      i += 1;
    }
  }
  
  public akpc a()
  {
    return this.jdField_a_of_type_Akpc;
  }
  
  public akpw a()
  {
    return this.jdField_a_of_type_Akpw;
  }
  
  public akqa a()
  {
    return this.jdField_a_of_type_Akqa;
  }
  
  public aksy a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Aksy.a();
      return this.jdField_b_of_type_Aksy;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Aksy.a();
      return this.jdField_a_of_type_Aksy;
    }
    this.jdField_b_of_type_Aksy.a();
    return this.jdField_b_of_type_Aksy;
  }
  
  public aktb a()
  {
    return this.jdField_a_of_type_Aktb;
  }
  
  @Deprecated
  public aktf a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public amhe a()
  {
    return this.jdField_a_of_type_Amhe;
  }
  
  public amnw a()
  {
    return this.jdField_a_of_type_Amnw;
  }
  
  public aper a()
  {
    return this.jdField_a_of_type_Aper;
  }
  
  public apwd a()
  {
    return this.jdField_a_of_type_Apwd;
  }
  
  public aslw a()
  {
    return this.jdField_a_of_type_Aslw;
  }
  
  public avex a()
  {
    return this.jdField_a_of_type_Avex;
  }
  
  public azrz a()
  {
    return this.jdField_a_of_type_Azrz;
  }
  
  public Vector<aktc> a()
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
          aksu localaksu = (aksu)localIterator.next();
          bfwu.a("i." + localaksu);
          long l = System.currentTimeMillis();
          localaksu.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localaksu.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
          }
          bfwu.a();
        }
        else
        {
          this.jdField_a_of_type_JavaUtilSet.clear();
        }
      }
      finally {}
    }
  }
  
  public void a(akte paramakte)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramakte)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramakte);
    }
  }
  
  /* Error */
  public void a(aukp paramaukp)
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
    //   91: invokespecial 587	com/tencent/mobileqq/app/proxy/ProxyManager:a	(Laukp;Ljava/util/List;)V
    //   94: aload_0
    //   95: getfield 79	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   98: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:a	()Lawzy;
    //   101: invokevirtual 595	awzy:e	()V
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
    //   0	117	1	paramaukp	aukp
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
          aktc localaktc = (aktc)localIterator.next();
          if ((akpx.a(localaktc.jdField_a_of_type_JavaLangString, paramString, localaktc.jdField_a_of_type_Int, paramInt)) && ((localaktc.jdField_b_of_type_Int == 1) || (localaktc.jdField_b_of_type_Int == 2) || (localaktc.jdField_b_of_type_Int == 0))) {
            localArrayList.add(localaktc);
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
  
  public void a(String arg1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, aktd paramaktd)
  {
    paramContentValues = new aktc(???, paramInt1, paramString2, paramContentValues, paramString3, paramArrayOfString, paramInt2, paramaktd);
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
  
  public void a(String paramString1, int paramInt1, String paramString2, auko paramauko, int paramInt2, aktd paramaktd)
  {
    d(paramString1, paramInt1, paramString2, paramauko, paramInt2, paramaktd);
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
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt2, aktd paramaktd)
  {
    a(paramString1, paramInt1, paramString2, null, paramString3, paramArrayOfString, paramInt2, paramaktd);
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
  
  public void b(akte paramakte)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramakte)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramakte);
    }
  }
  
  public void b(String paramString1, int paramInt1, String paramString2, auko paramauko, int paramInt2, aktd paramaktd)
  {
    d(paramString1, paramInt1, paramString2, paramauko, paramInt2, paramaktd);
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
  
  public void c(String paramString1, int paramInt1, String paramString2, auko paramauko, int paramInt2, aktd paramaktd)
  {
    d(paramString1, paramInt1, paramString2, paramauko, paramInt2, paramaktd);
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
    aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).createEntityManager();
    a(localaukp);
    localaukp.a();
  }
  
  public void d(String arg1, int paramInt1, String paramString2, auko paramauko, int paramInt2, aktd paramaktd)
  {
    paramauko = new aktc(???, paramInt1, paramString2, paramauko, paramInt2, paramaktd);
    if ((QLog.isColorLevel()) && ((paramauko.jdField_a_of_type_Auko instanceof MessageRecord))) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueueDonotNotify QueueItem.action: " + paramauko.jdField_b_of_type_Int + ",mr=" + paramauko.jdField_a_of_type_Auko);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramauko);
        return;
      }
      catch (OutOfMemoryError paramauko)
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
      this.jdField_a_of_type_Akkq.c();
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
        if (i < this.jdField_a_of_type_ArrayOfAksu.length)
        {
          this.jdField_a_of_type_ArrayOfAksu[i].b();
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