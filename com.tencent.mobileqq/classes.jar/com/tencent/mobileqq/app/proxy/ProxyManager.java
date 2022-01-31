package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationProxy;
import com.tencent.mobileqq.app.message.MsgProxyContainer;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportControllerImpl.ReportProxyAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import cooperation.qlink.QlinkReliableReport.ReliableReportProxy;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;
import zsh;
import zsi;

public class ProxyManager
  implements Manager
{
  public static int a;
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { QCallProxy.class, ConfessProxy.class };
  private static int jdField_b_of_type_Int = 10000;
  private static int jdField_c_of_type_Int = 2000;
  private static int d = 10000;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private DBDelayManager jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager;
  private ConversationProxy jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy;
  private MsgProxyContainer jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer;
  private MultiMsgProxy jdField_a_of_type_ComTencentMobileqqAppMessageMultiMsgProxy;
  private DataLineMsgProxy jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
  private MpfileTaskProxy jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy;
  private RecentUserProxy jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
  private ConfessProxy jdField_a_of_type_ComTencentMobileqqConfessConfessProxy;
  private FileManagerProxy jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy;
  private UniformDownloadBPTransProxy jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy;
  private QCallProxy jdField_a_of_type_ComTencentMobileqqQcallQCallProxy;
  private ReportControllerImpl.ReportProxyAdapter jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter;
  private QlinkReliableReport.ReliableReportProxy jdField_a_of_type_CooperationQlinkQlinkReliableReport$ReliableReportProxy;
  public final Object a;
  private Thread jdField_a_of_type_JavaLangThread;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private Vector jdField_a_of_type_JavaUtilVector;
  public volatile boolean a;
  private BaseProxy[] jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy;
  private DataLineMsgProxy jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
  public Object b;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean = true;
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ReadInJoyHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager = paramQQAppInterface.a().a();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer = new MsgProxyContainer(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMultiMsgProxy = new MultiMsgProxy(paramQQAppInterface, this);
    this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy = new DataLineMsgPcProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy = new DataLineMsgIpadProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy = new MpfileTaskProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy = new FileManagerProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy = new UniformDownloadBPTransProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter = new ReportControllerImpl.ReportProxyAdapter(paramQQAppInterface, this);
    this.jdField_a_of_type_CooperationQlinkQlinkReliableReport$ReliableReportProxy = new QlinkReliableReport.ReliableReportProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy = new ConversationProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = new RecentUserProxy(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy = new QCallProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessProxy = new ConfessProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy = new BaseProxy[] { this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer, this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy, this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy, this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter, this.jdField_a_of_type_CooperationQlinkQlinkReliableReport$ReliableReportProxy, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy, this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy, this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy, this.jdField_a_of_type_ComTencentMobileqqConfessConfessProxy };
    this.jdField_a_of_type_JavaLangThread = new Thread(new zsi(this));
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
        ((ProxyObserver)localIterator.next()).a(paramInt);
      }
    }
  }
  
  /* Error */
  private void a(EntityManager paramEntityManager, List paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 219 1 0
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 67	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_c_of_type_Boolean	Z
    //   14: ifeq +50 -> 64
    //   17: getstatic 222	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_Boolean	Z
    //   20: ifeq +459 -> 479
    //   23: aload_0
    //   24: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokestatic 227	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   30: ifeq +449 -> 479
    //   33: aload_0
    //   34: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/FTSDBManager;
    //   40: invokevirtual 232	com/tencent/mobileqq/app/proxy/FTSDBManager:a	()Z
    //   43: ifeq +21 -> 64
    //   46: aload_0
    //   47: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/FTSDBManager;
    //   53: invokevirtual 235	com/tencent/mobileqq/app/proxy/FTSDBManager:a	()Lcom/tencent/mobileqq/app/proxy/fts/FTSMsgOperator;
    //   56: invokevirtual 239	com/tencent/mobileqq/app/proxy/fts/FTSMsgOperator:b	()V
    //   59: aload_0
    //   60: iconst_0
    //   61: putfield 67	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_c_of_type_Boolean	Z
    //   64: aconst_null
    //   65: astore 17
    //   67: invokestatic 242	com/tencent/mobileqq/statistics/StatisticCollector:a	()Z
    //   70: istore 10
    //   72: iload 10
    //   74: ifeq +413 -> 487
    //   77: iconst_0
    //   78: invokestatic 245	com/tencent/mobileqq/statistics/StatisticCollector:a	(I)Z
    //   81: ifeq +406 -> 487
    //   84: iconst_1
    //   85: istore 7
    //   87: invokestatic 251	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   90: astore 18
    //   92: invokestatic 254	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   95: astore 19
    //   97: aload 18
    //   99: aload 19
    //   101: if_acmpne +392 -> 493
    //   104: iconst_1
    //   105: istore 9
    //   107: iload 9
    //   109: ifeq +37 -> 146
    //   112: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +31 -> 146
    //   118: ldc_w 261
    //   121: iconst_2
    //   122: new 263	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 266
    //   132: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload 9
    //   137: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 280	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_1
    //   147: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   150: astore 18
    //   152: aload 18
    //   154: astore 17
    //   156: invokestatic 291	java/lang/System:nanoTime	()J
    //   159: lstore 13
    //   161: aload 17
    //   163: invokevirtual 295	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   166: iload 7
    //   168: ifeq +2042 -> 2210
    //   171: invokestatic 291	java/lang/System:nanoTime	()J
    //   174: lload 13
    //   176: lsub
    //   177: ldc2_w 296
    //   180: ldiv
    //   181: lstore 11
    //   183: new 299	java/util/HashMap
    //   186: dup
    //   187: invokespecial 300	java/util/HashMap:<init>	()V
    //   190: astore 19
    //   192: iload 9
    //   194: ifeq +305 -> 499
    //   197: ldc_w 302
    //   200: astore 18
    //   202: aload 19
    //   204: ldc_w 304
    //   207: aload 18
    //   209: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload 19
    //   215: ldc_w 310
    //   218: ldc_w 312
    //   221: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: aload 19
    //   227: ldc_w 314
    //   230: lload 11
    //   232: invokestatic 320	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   235: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: pop
    //   239: aload 19
    //   241: ldc_w 322
    //   244: getstatic 325	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_Boolean	Z
    //   247: invokestatic 328	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   250: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   253: pop
    //   254: invokestatic 334	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   257: invokestatic 337	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   260: aconst_null
    //   261: ldc_w 339
    //   264: iconst_1
    //   265: ldc2_w 340
    //   268: lconst_0
    //   269: aload 19
    //   271: aconst_null
    //   272: iconst_0
    //   273: invokevirtual 344	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   276: aload_2
    //   277: invokeinterface 345 1 0
    //   282: astore 18
    //   284: iconst_0
    //   285: istore_3
    //   286: iconst_0
    //   287: istore 4
    //   289: aload 18
    //   291: invokeinterface 205 1 0
    //   296: ifeq +1131 -> 1427
    //   299: aload 18
    //   301: invokeinterface 209 1 0
    //   306: checkcast 347	com/tencent/mobileqq/app/proxy/MsgQueueItem
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
    //   325: getfield 350	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   328: astore 20
    //   330: iload_3
    //   331: istore 6
    //   333: iload_3
    //   334: istore 5
    //   336: aload 19
    //   338: getfield 353	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener	Lcom/tencent/mobileqq/app/proxy/ProxyListener;
    //   341: astore 21
    //   343: iload_3
    //   344: istore 6
    //   346: iload_3
    //   347: istore 5
    //   349: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +1866 -> 2218
    //   355: iload_3
    //   356: istore 6
    //   358: iload_3
    //   359: istore 5
    //   361: aload 19
    //   363: getfield 356	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ComTencentMobileqqPersistenceEntity	Lcom/tencent/mobileqq/persistence/Entity;
    //   366: instanceof 358
    //   369: ifeq +138 -> 507
    //   372: iload_3
    //   373: iconst_1
    //   374: iadd
    //   375: istore_3
    //   376: iload_3
    //   377: istore 6
    //   379: iload_3
    //   380: istore 5
    //   382: ldc_w 261
    //   385: iconst_2
    //   386: iconst_4
    //   387: anewarray 4	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: ldc_w 360
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: aload 19
    //   400: getfield 361	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_b_of_type_Int	I
    //   403: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: aastore
    //   407: dup
    //   408: iconst_2
    //   409: ldc_w 368
    //   412: aastore
    //   413: dup
    //   414: iconst_3
    //   415: aload 19
    //   417: getfield 356	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ComTencentMobileqqPersistenceEntity	Lcom/tencent/mobileqq/persistence/Entity;
    //   420: aastore
    //   421: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   424: aload 19
    //   426: getfield 361	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_b_of_type_Int	I
    //   429: istore 5
    //   431: iload 5
    //   433: tableswitch	default:+43 -> 476, 0:+221->654, 1:+450->883, 2:+711->1144, 3:+424->857, 4:+683->1116, 5:+926->1359, 6:+954->1387
    //   477: impdep2
    //   478: fstore_2
    //   479: aload_0
    //   480: iconst_0
    //   481: putfield 67	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_c_of_type_Boolean	Z
    //   484: goto -420 -> 64
    //   487: iconst_0
    //   488: istore 7
    //   490: goto -403 -> 87
    //   493: iconst_0
    //   494: istore 9
    //   496: goto -389 -> 107
    //   499: ldc_w 373
    //   502: astore 18
    //   504: goto -302 -> 202
    //   507: iload_3
    //   508: istore 6
    //   510: iload_3
    //   511: istore 5
    //   513: aload 19
    //   515: getfield 361	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_b_of_type_Int	I
    //   518: istore 8
    //   520: iload_3
    //   521: istore 6
    //   523: iload_3
    //   524: istore 5
    //   526: aload 19
    //   528: getfield 375	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   531: astore 22
    //   533: iload_3
    //   534: istore 6
    //   536: iload_3
    //   537: istore 5
    //   539: aload 19
    //   541: getfield 350	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   544: astore 23
    //   546: iload_3
    //   547: istore 6
    //   549: iload_3
    //   550: istore 5
    //   552: aload 19
    //   554: getfield 378	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_AndroidContentContentValues	Landroid/content/ContentValues;
    //   557: ifnull +90 -> 647
    //   560: iload_3
    //   561: istore 6
    //   563: iload_3
    //   564: istore 5
    //   566: aload 19
    //   568: getfield 378	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_AndroidContentContentValues	Landroid/content/ContentValues;
    //   571: invokevirtual 383	android/content/ContentValues:hashCode	()I
    //   574: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: astore_2
    //   578: iload_3
    //   579: istore 6
    //   581: iload_3
    //   582: istore 5
    //   584: ldc_w 261
    //   587: iconst_2
    //   588: bipush 8
    //   590: anewarray 4	java/lang/Object
    //   593: dup
    //   594: iconst_0
    //   595: ldc_w 360
    //   598: aastore
    //   599: dup
    //   600: iconst_1
    //   601: iload 8
    //   603: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   606: aastore
    //   607: dup
    //   608: iconst_2
    //   609: ldc_w 385
    //   612: aastore
    //   613: dup
    //   614: iconst_3
    //   615: aload 22
    //   617: aastore
    //   618: dup
    //   619: iconst_4
    //   620: ldc_w 387
    //   623: aastore
    //   624: dup
    //   625: iconst_5
    //   626: aload 23
    //   628: aastore
    //   629: dup
    //   630: bipush 6
    //   632: ldc_w 389
    //   635: aastore
    //   636: dup
    //   637: bipush 7
    //   639: aload_2
    //   640: aastore
    //   641: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   644: goto +1574 -> 2218
    //   647: ldc_w 391
    //   650: astore_2
    //   651: goto -73 -> 578
    //   654: invokestatic 291	java/lang/System:nanoTime	()J
    //   657: lstore 11
    //   659: aload_1
    //   660: aload 19
    //   662: getfield 356	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ComTencentMobileqqPersistenceEntity	Lcom/tencent/mobileqq/persistence/Entity;
    //   665: invokevirtual 394	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   668: invokestatic 291	java/lang/System:nanoTime	()J
    //   671: lload 11
    //   673: lsub
    //   674: ldc2_w 296
    //   677: ldiv
    //   678: lstore 15
    //   680: aload 21
    //   682: ifnull +12 -> 694
    //   685: aload 21
    //   687: aload 20
    //   689: invokeinterface 399 2 0
    //   694: getstatic 222	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_Boolean	Z
    //   697: ifeq +42 -> 739
    //   700: aload_0
    //   701: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   704: invokestatic 227	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   707: ifeq +32 -> 739
    //   710: aload_0
    //   711: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   714: invokestatic 401	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   717: ifeq +22 -> 739
    //   720: aload_0
    //   721: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   724: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/FTSDBManager;
    //   727: invokevirtual 235	com/tencent/mobileqq/app/proxy/FTSDBManager:a	()Lcom/tencent/mobileqq/app/proxy/fts/FTSMsgOperator;
    //   730: aload 19
    //   732: getfield 356	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ComTencentMobileqqPersistenceEntity	Lcom/tencent/mobileqq/persistence/Entity;
    //   735: aload_1
    //   736: invokevirtual 404	com/tencent/mobileqq/app/proxy/fts/FTSMsgOperator:a	(Lcom/tencent/mobileqq/persistence/Entity;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   739: lload 15
    //   741: lstore 11
    //   743: iload 10
    //   745: ifeq +1455 -> 2200
    //   748: lload 15
    //   750: lstore 11
    //   752: iconst_4
    //   753: invokestatic 245	com/tencent/mobileqq/statistics/StatisticCollector:a	(I)Z
    //   756: ifeq +1444 -> 2200
    //   759: new 299	java/util/HashMap
    //   762: dup
    //   763: invokespecial 300	java/util/HashMap:<init>	()V
    //   766: astore 19
    //   768: iload 9
    //   770: ifeq +1451 -> 2221
    //   773: ldc_w 302
    //   776: astore_2
    //   777: aload 19
    //   779: ldc_w 304
    //   782: aload_2
    //   783: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   786: pop
    //   787: aload 19
    //   789: ldc_w 310
    //   792: ldc_w 406
    //   795: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   798: pop
    //   799: aload 19
    //   801: ldc_w 314
    //   804: lload 15
    //   806: invokestatic 320	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   809: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   812: pop
    //   813: aload 19
    //   815: ldc_w 322
    //   818: getstatic 325	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_Boolean	Z
    //   821: invokestatic 328	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   824: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   827: pop
    //   828: invokestatic 334	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   831: invokestatic 337	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   834: aconst_null
    //   835: ldc_w 339
    //   838: iconst_1
    //   839: ldc2_w 340
    //   842: lconst_0
    //   843: aload 19
    //   845: aconst_null
    //   846: iconst_0
    //   847: invokevirtual 344	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   850: lload 15
    //   852: lstore 11
    //   854: goto -378 -> 476
    //   857: aload_1
    //   858: aload 19
    //   860: getfield 356	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ComTencentMobileqqPersistenceEntity	Lcom/tencent/mobileqq/persistence/Entity;
    //   863: invokevirtual 394	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   866: aload 21
    //   868: ifnull -392 -> 476
    //   871: aload 21
    //   873: aload 20
    //   875: invokeinterface 399 2 0
    //   880: goto -404 -> 476
    //   883: getstatic 222	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_Boolean	Z
    //   886: ifeq +39 -> 925
    //   889: aload_0
    //   890: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   893: invokestatic 227	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   896: ifeq +29 -> 925
    //   899: aload_0
    //   900: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   903: invokestatic 401	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   906: ifeq +19 -> 925
    //   909: aload_0
    //   910: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   913: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/FTSDBManager;
    //   916: invokevirtual 235	com/tencent/mobileqq/app/proxy/FTSDBManager:a	()Lcom/tencent/mobileqq/app/proxy/fts/FTSMsgOperator;
    //   919: aload 19
    //   921: aload_1
    //   922: invokevirtual 409	com/tencent/mobileqq/app/proxy/fts/FTSMsgOperator:a	(Lcom/tencent/mobileqq/app/proxy/MsgQueueItem;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   925: invokestatic 291	java/lang/System:nanoTime	()J
    //   928: lstore 15
    //   930: aload_0
    //   931: invokespecial 410	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   934: astore_2
    //   935: aload_2
    //   936: ifnull +1267 -> 2203
    //   939: aload_2
    //   940: aload 20
    //   942: aload 19
    //   944: getfield 378	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_AndroidContentContentValues	Landroid/content/ContentValues;
    //   947: aload 19
    //   949: getfield 412	com/tencent/mobileqq/app/proxy/MsgQueueItem:c	Ljava/lang/String;
    //   952: aload 19
    //   954: getfield 415	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   957: invokevirtual 420	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   960: istore 5
    //   962: invokestatic 291	java/lang/System:nanoTime	()J
    //   965: lload 15
    //   967: lsub
    //   968: ldc2_w 296
    //   971: ldiv
    //   972: lstore 11
    //   974: lload 11
    //   976: lstore 15
    //   978: aload 21
    //   980: ifnull +18 -> 998
    //   983: aload 21
    //   985: aload 20
    //   987: iload 5
    //   989: invokeinterface 423 3 0
    //   994: lload 11
    //   996: lstore 15
    //   998: lload 15
    //   1000: lstore 11
    //   1002: iload 10
    //   1004: ifeq +1196 -> 2200
    //   1007: lload 15
    //   1009: lstore 11
    //   1011: iconst_5
    //   1012: invokestatic 245	com/tencent/mobileqq/statistics/StatisticCollector:a	(I)Z
    //   1015: ifeq +1185 -> 2200
    //   1018: new 299	java/util/HashMap
    //   1021: dup
    //   1022: invokespecial 300	java/util/HashMap:<init>	()V
    //   1025: astore 19
    //   1027: iload 9
    //   1029: ifeq +1199 -> 2228
    //   1032: ldc_w 302
    //   1035: astore_2
    //   1036: aload 19
    //   1038: ldc_w 304
    //   1041: aload_2
    //   1042: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: pop
    //   1046: aload 19
    //   1048: ldc_w 310
    //   1051: ldc_w 425
    //   1054: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1057: pop
    //   1058: aload 19
    //   1060: ldc_w 314
    //   1063: lload 15
    //   1065: invokestatic 320	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1068: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1071: pop
    //   1072: aload 19
    //   1074: ldc_w 322
    //   1077: getstatic 325	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_Boolean	Z
    //   1080: invokestatic 328	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1083: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1086: pop
    //   1087: invokestatic 334	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1090: invokestatic 337	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1093: aconst_null
    //   1094: ldc_w 339
    //   1097: iconst_1
    //   1098: ldc2_w 340
    //   1101: lconst_0
    //   1102: aload 19
    //   1104: aconst_null
    //   1105: iconst_0
    //   1106: invokevirtual 344	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1109: lload 15
    //   1111: lstore 11
    //   1113: goto -637 -> 476
    //   1116: aload_1
    //   1117: aload 19
    //   1119: getfield 356	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ComTencentMobileqqPersistenceEntity	Lcom/tencent/mobileqq/persistence/Entity;
    //   1122: invokevirtual 428	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1125: pop
    //   1126: aload 21
    //   1128: ifnull -652 -> 476
    //   1131: aload 21
    //   1133: aload 20
    //   1135: iconst_1
    //   1136: invokeinterface 423 3 0
    //   1141: goto -665 -> 476
    //   1144: getstatic 222	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_Boolean	Z
    //   1147: ifeq +39 -> 1186
    //   1150: aload_0
    //   1151: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1154: invokestatic 227	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1157: ifeq +29 -> 1186
    //   1160: aload_0
    //   1161: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1164: invokestatic 401	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1167: ifeq +19 -> 1186
    //   1170: aload_0
    //   1171: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1174: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/FTSDBManager;
    //   1177: invokevirtual 235	com/tencent/mobileqq/app/proxy/FTSDBManager:a	()Lcom/tencent/mobileqq/app/proxy/fts/FTSMsgOperator;
    //   1180: aload 19
    //   1182: aload_1
    //   1183: invokevirtual 430	com/tencent/mobileqq/app/proxy/fts/FTSMsgOperator:b	(Lcom/tencent/mobileqq/app/proxy/MsgQueueItem;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1186: invokestatic 291	java/lang/System:nanoTime	()J
    //   1189: lstore 11
    //   1191: aload_0
    //   1192: invokespecial 410	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1195: aload 20
    //   1197: aload 19
    //   1199: getfield 412	com/tencent/mobileqq/app/proxy/MsgQueueItem:c	Ljava/lang/String;
    //   1202: aload 19
    //   1204: getfield 415	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1207: invokevirtual 433	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1210: istore 5
    //   1212: invokestatic 291	java/lang/System:nanoTime	()J
    //   1215: lload 11
    //   1217: lsub
    //   1218: ldc2_w 296
    //   1221: ldiv
    //   1222: lstore 15
    //   1224: aload 21
    //   1226: ifnull +14 -> 1240
    //   1229: aload 21
    //   1231: aload 20
    //   1233: iload 5
    //   1235: invokeinterface 435 3 0
    //   1240: lload 15
    //   1242: lstore 11
    //   1244: iload 10
    //   1246: ifeq +954 -> 2200
    //   1249: lload 15
    //   1251: lstore 11
    //   1253: bipush 6
    //   1255: invokestatic 245	com/tencent/mobileqq/statistics/StatisticCollector:a	(I)Z
    //   1258: ifeq +942 -> 2200
    //   1261: new 299	java/util/HashMap
    //   1264: dup
    //   1265: invokespecial 300	java/util/HashMap:<init>	()V
    //   1268: astore 19
    //   1270: iload 9
    //   1272: ifeq +963 -> 2235
    //   1275: ldc_w 302
    //   1278: astore_2
    //   1279: aload 19
    //   1281: ldc_w 304
    //   1284: aload_2
    //   1285: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1288: pop
    //   1289: aload 19
    //   1291: ldc_w 310
    //   1294: ldc_w 437
    //   1297: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1300: pop
    //   1301: aload 19
    //   1303: ldc_w 314
    //   1306: lload 15
    //   1308: invokestatic 320	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1311: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1314: pop
    //   1315: aload 19
    //   1317: ldc_w 322
    //   1320: getstatic 325	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_Boolean	Z
    //   1323: invokestatic 328	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1326: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1329: pop
    //   1330: invokestatic 334	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1333: invokestatic 337	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1336: aconst_null
    //   1337: ldc_w 339
    //   1340: iconst_1
    //   1341: ldc2_w 340
    //   1344: lconst_0
    //   1345: aload 19
    //   1347: aconst_null
    //   1348: iconst_0
    //   1349: invokevirtual 344	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1352: lload 15
    //   1354: lstore 11
    //   1356: goto -880 -> 476
    //   1359: aload_1
    //   1360: aload 19
    //   1362: getfield 356	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ComTencentMobileqqPersistenceEntity	Lcom/tencent/mobileqq/persistence/Entity;
    //   1365: invokevirtual 439	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1368: pop
    //   1369: aload 21
    //   1371: ifnull -895 -> 476
    //   1374: aload 21
    //   1376: aload 20
    //   1378: iconst_1
    //   1379: invokeinterface 435 3 0
    //   1384: goto -908 -> 476
    //   1387: aload_0
    //   1388: invokespecial 410	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1391: aload 20
    //   1393: aload 19
    //   1395: getfield 412	com/tencent/mobileqq/app/proxy/MsgQueueItem:c	Ljava/lang/String;
    //   1398: aload 19
    //   1400: getfield 415	com/tencent/mobileqq/app/proxy/MsgQueueItem:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1403: invokevirtual 433	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1406: istore 5
    //   1408: aload 21
    //   1410: ifnull +14 -> 1424
    //   1413: aload 21
    //   1415: aload 20
    //   1417: iload 5
    //   1419: invokeinterface 435 3 0
    //   1424: goto -948 -> 476
    //   1427: aload 17
    //   1429: invokevirtual 441	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   1432: aload_0
    //   1433: sipush 1000
    //   1436: invokespecial 442	com/tencent/mobileqq/app/proxy/ProxyManager:a	(I)V
    //   1439: aload 17
    //   1441: ifnull -1432 -> 9
    //   1444: aload 17
    //   1446: invokevirtual 443	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1449: invokestatic 291	java/lang/System:nanoTime	()J
    //   1452: lload 13
    //   1454: lsub
    //   1455: ldc2_w 296
    //   1458: ldiv
    //   1459: lstore 11
    //   1461: iload 7
    //   1463: ifeq -1454 -> 9
    //   1466: new 299	java/util/HashMap
    //   1469: dup
    //   1470: invokespecial 300	java/util/HashMap:<init>	()V
    //   1473: astore_2
    //   1474: iload 9
    //   1476: ifeq +129 -> 1605
    //   1479: ldc_w 302
    //   1482: astore_1
    //   1483: aload_2
    //   1484: ldc_w 304
    //   1487: aload_1
    //   1488: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1491: pop
    //   1492: aload_2
    //   1493: ldc_w 310
    //   1496: ldc_w 445
    //   1499: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1502: pop
    //   1503: aload_2
    //   1504: ldc_w 314
    //   1507: lload 11
    //   1509: invokestatic 320	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1512: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1515: pop
    //   1516: aload_2
    //   1517: ldc_w 447
    //   1520: iload 4
    //   1522: invokestatic 450	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1525: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1528: pop
    //   1529: aload_2
    //   1530: ldc_w 452
    //   1533: iload_3
    //   1534: invokestatic 450	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1537: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1540: pop
    //   1541: aload_2
    //   1542: ldc_w 454
    //   1545: lload 11
    //   1547: l2f
    //   1548: iload 4
    //   1550: i2f
    //   1551: fdiv
    //   1552: invokestatic 457	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1555: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1558: pop
    //   1559: aload_2
    //   1560: ldc_w 459
    //   1563: ldc_w 445
    //   1566: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1569: pop
    //   1570: aload_2
    //   1571: ldc_w 322
    //   1574: getstatic 325	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_Boolean	Z
    //   1577: invokestatic 328	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1580: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1583: pop
    //   1584: invokestatic 334	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1587: invokestatic 337	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1590: aconst_null
    //   1591: ldc_w 461
    //   1594: iconst_1
    //   1595: lload 11
    //   1597: lconst_0
    //   1598: aload_2
    //   1599: aconst_null
    //   1600: iconst_0
    //   1601: invokevirtual 344	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1604: return
    //   1605: ldc_w 373
    //   1608: astore_1
    //   1609: goto -126 -> 1483
    //   1612: astore_1
    //   1613: ldc2_w 340
    //   1616: lstore 11
    //   1618: iconst_0
    //   1619: istore 4
    //   1621: iconst_0
    //   1622: istore 9
    //   1624: iconst_0
    //   1625: istore_3
    //   1626: aload 17
    //   1628: astore_2
    //   1629: aload_1
    //   1630: invokevirtual 464	java/lang/Exception:printStackTrace	()V
    //   1633: aload_0
    //   1634: sipush 1001
    //   1637: invokespecial 442	com/tencent/mobileqq/app/proxy/ProxyManager:a	(I)V
    //   1640: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1643: ifeq +33 -> 1676
    //   1646: ldc_w 261
    //   1649: iconst_2
    //   1650: new 263	java/lang/StringBuilder
    //   1653: dup
    //   1654: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1657: ldc_w 466
    //   1660: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1663: aload_1
    //   1664: invokevirtual 469	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1667: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1670: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1673: invokestatic 472	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1676: aload_2
    //   1677: ifnull -1668 -> 9
    //   1680: aload_2
    //   1681: invokevirtual 443	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1684: invokestatic 291	java/lang/System:nanoTime	()J
    //   1687: lload 11
    //   1689: lsub
    //   1690: ldc2_w 296
    //   1693: ldiv
    //   1694: lstore 11
    //   1696: iload 7
    //   1698: ifeq -1689 -> 9
    //   1701: new 299	java/util/HashMap
    //   1704: dup
    //   1705: invokespecial 300	java/util/HashMap:<init>	()V
    //   1708: astore_2
    //   1709: iload 9
    //   1711: ifeq +129 -> 1840
    //   1714: ldc_w 302
    //   1717: astore_1
    //   1718: aload_2
    //   1719: ldc_w 304
    //   1722: aload_1
    //   1723: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1726: pop
    //   1727: aload_2
    //   1728: ldc_w 310
    //   1731: ldc_w 445
    //   1734: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1737: pop
    //   1738: aload_2
    //   1739: ldc_w 314
    //   1742: lload 11
    //   1744: invokestatic 320	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1747: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1750: pop
    //   1751: aload_2
    //   1752: ldc_w 447
    //   1755: iload 4
    //   1757: invokestatic 450	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1760: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1763: pop
    //   1764: aload_2
    //   1765: ldc_w 452
    //   1768: iload_3
    //   1769: invokestatic 450	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1772: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1775: pop
    //   1776: aload_2
    //   1777: ldc_w 454
    //   1780: lload 11
    //   1782: l2f
    //   1783: iload 4
    //   1785: i2f
    //   1786: fdiv
    //   1787: invokestatic 457	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1790: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1793: pop
    //   1794: aload_2
    //   1795: ldc_w 459
    //   1798: ldc_w 445
    //   1801: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1804: pop
    //   1805: aload_2
    //   1806: ldc_w 322
    //   1809: getstatic 325	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_Boolean	Z
    //   1812: invokestatic 328	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1815: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1818: pop
    //   1819: invokestatic 334	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1822: invokestatic 337	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1825: aconst_null
    //   1826: ldc_w 461
    //   1829: iconst_1
    //   1830: lload 11
    //   1832: lconst_0
    //   1833: aload_2
    //   1834: aconst_null
    //   1835: iconst_0
    //   1836: invokevirtual 344	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1839: return
    //   1840: ldc_w 373
    //   1843: astore_1
    //   1844: goto -126 -> 1718
    //   1847: astore_1
    //   1848: iconst_0
    //   1849: istore_3
    //   1850: iconst_0
    //   1851: istore 4
    //   1853: ldc2_w 340
    //   1856: lstore 13
    //   1858: iconst_0
    //   1859: istore 9
    //   1861: aconst_null
    //   1862: astore 17
    //   1864: aload 17
    //   1866: ifnull +173 -> 2039
    //   1869: aload 17
    //   1871: invokevirtual 443	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1874: invokestatic 291	java/lang/System:nanoTime	()J
    //   1877: lload 13
    //   1879: lsub
    //   1880: ldc2_w 296
    //   1883: ldiv
    //   1884: lstore 11
    //   1886: iload 7
    //   1888: ifeq +151 -> 2039
    //   1891: new 299	java/util/HashMap
    //   1894: dup
    //   1895: invokespecial 300	java/util/HashMap:<init>	()V
    //   1898: astore 17
    //   1900: iload 9
    //   1902: ifeq +139 -> 2041
    //   1905: ldc_w 302
    //   1908: astore_2
    //   1909: aload 17
    //   1911: ldc_w 304
    //   1914: aload_2
    //   1915: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1918: pop
    //   1919: aload 17
    //   1921: ldc_w 310
    //   1924: ldc_w 445
    //   1927: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1930: pop
    //   1931: aload 17
    //   1933: ldc_w 314
    //   1936: lload 11
    //   1938: invokestatic 320	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1941: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1944: pop
    //   1945: aload 17
    //   1947: ldc_w 447
    //   1950: iload 4
    //   1952: invokestatic 450	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1955: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1958: pop
    //   1959: aload 17
    //   1961: ldc_w 452
    //   1964: iload_3
    //   1965: invokestatic 450	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1968: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1971: pop
    //   1972: aload 17
    //   1974: ldc_w 454
    //   1977: lload 11
    //   1979: l2f
    //   1980: iload 4
    //   1982: i2f
    //   1983: fdiv
    //   1984: invokestatic 457	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1987: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1990: pop
    //   1991: aload 17
    //   1993: ldc_w 459
    //   1996: ldc_w 445
    //   1999: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2002: pop
    //   2003: aload 17
    //   2005: ldc_w 322
    //   2008: getstatic 325	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_Boolean	Z
    //   2011: invokestatic 328	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2014: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2017: pop
    //   2018: invokestatic 334	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2021: invokestatic 337	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2024: aconst_null
    //   2025: ldc_w 461
    //   2028: iconst_1
    //   2029: lload 11
    //   2031: lconst_0
    //   2032: aload 17
    //   2034: aconst_null
    //   2035: iconst_0
    //   2036: invokevirtual 344	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2039: aload_1
    //   2040: athrow
    //   2041: ldc_w 373
    //   2044: astore_2
    //   2045: goto -136 -> 1909
    //   2048: astore_1
    //   2049: iconst_0
    //   2050: istore_3
    //   2051: iconst_0
    //   2052: istore 4
    //   2054: ldc2_w 340
    //   2057: lstore 13
    //   2059: aconst_null
    //   2060: astore 17
    //   2062: goto -198 -> 1864
    //   2065: astore_1
    //   2066: iconst_0
    //   2067: istore_3
    //   2068: iconst_0
    //   2069: istore 4
    //   2071: ldc2_w 340
    //   2074: lstore 13
    //   2076: goto -212 -> 1864
    //   2079: astore_1
    //   2080: iconst_0
    //   2081: istore_3
    //   2082: iconst_0
    //   2083: istore 4
    //   2085: goto -221 -> 1864
    //   2088: astore_1
    //   2089: goto -225 -> 1864
    //   2092: astore_1
    //   2093: iload 6
    //   2095: istore_3
    //   2096: goto -232 -> 1864
    //   2099: astore_1
    //   2100: goto -236 -> 1864
    //   2103: astore_1
    //   2104: lload 11
    //   2106: lstore 13
    //   2108: aload_2
    //   2109: astore 17
    //   2111: goto -247 -> 1864
    //   2114: astore_1
    //   2115: iconst_0
    //   2116: istore_3
    //   2117: ldc2_w 340
    //   2120: lstore 11
    //   2122: iconst_0
    //   2123: istore 4
    //   2125: aload 17
    //   2127: astore_2
    //   2128: goto -499 -> 1629
    //   2131: astore_1
    //   2132: iconst_0
    //   2133: istore_3
    //   2134: ldc2_w 340
    //   2137: lstore 11
    //   2139: aload 17
    //   2141: astore_2
    //   2142: iconst_0
    //   2143: istore 4
    //   2145: goto -516 -> 1629
    //   2148: astore_1
    //   2149: iconst_0
    //   2150: istore_3
    //   2151: iconst_0
    //   2152: istore 4
    //   2154: lload 13
    //   2156: lstore 11
    //   2158: aload 17
    //   2160: astore_2
    //   2161: goto -532 -> 1629
    //   2164: astore_1
    //   2165: lload 13
    //   2167: lstore 11
    //   2169: aload 17
    //   2171: astore_2
    //   2172: goto -543 -> 1629
    //   2175: astore_1
    //   2176: lload 13
    //   2178: lstore 11
    //   2180: aload 17
    //   2182: astore_2
    //   2183: iload 5
    //   2185: istore_3
    //   2186: goto -557 -> 1629
    //   2189: astore_1
    //   2190: lload 13
    //   2192: lstore 11
    //   2194: aload 17
    //   2196: astore_2
    //   2197: goto -568 -> 1629
    //   2200: goto -1724 -> 476
    //   2203: lload 11
    //   2205: lstore 15
    //   2207: goto -1209 -> 998
    //   2210: ldc2_w 340
    //   2213: lstore 11
    //   2215: goto -1939 -> 276
    //   2218: goto -1794 -> 424
    //   2221: ldc_w 373
    //   2224: astore_2
    //   2225: goto -1448 -> 777
    //   2228: ldc_w 373
    //   2231: astore_2
    //   2232: goto -1196 -> 1036
    //   2235: ldc_w 373
    //   2238: astore_2
    //   2239: goto -960 -> 1279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2242	0	this	ProxyManager
    //   0	2242	1	paramEntityManager	EntityManager
    //   0	2242	2	paramList	List
    //   285	1901	3	i	int
    //   287	1866	4	j	int
    //   321	1863	5	k	int
    //   318	1776	6	m	int
    //   85	1802	7	n	int
    //   518	84	8	i1	int
    //   105	1796	9	bool1	boolean
    //   70	1175	10	bool2	boolean
    //   181	2033	11	l1	long
    //   159	2032	13	l2	long
    //   678	1528	15	l3	long
    //   65	2130	17	localObject1	Object
    //   90	413	18	localObject2	Object
    //   95	1304	19	localObject3	Object
    //   328	1088	20	str1	String
    //   341	1073	21	localProxyListener	ProxyListener
    //   531	85	22	str2	String
    //   544	83	23	str3	String
    // Exception table:
    //   from	to	target	type
    //   87	97	1612	java/lang/Exception
    //   87	97	1847	finally
    //   112	146	2048	finally
    //   146	152	2048	finally
    //   156	161	2065	finally
    //   161	166	2079	finally
    //   171	192	2079	finally
    //   202	276	2079	finally
    //   276	284	2079	finally
    //   289	311	2088	finally
    //   1427	1439	2088	finally
    //   323	330	2092	finally
    //   336	343	2092	finally
    //   349	355	2092	finally
    //   361	372	2092	finally
    //   382	424	2092	finally
    //   513	520	2092	finally
    //   526	533	2092	finally
    //   539	546	2092	finally
    //   552	560	2092	finally
    //   566	578	2092	finally
    //   584	644	2092	finally
    //   424	431	2099	finally
    //   654	680	2099	finally
    //   685	694	2099	finally
    //   694	739	2099	finally
    //   752	768	2099	finally
    //   777	850	2099	finally
    //   857	866	2099	finally
    //   871	880	2099	finally
    //   883	925	2099	finally
    //   925	935	2099	finally
    //   939	974	2099	finally
    //   983	994	2099	finally
    //   1011	1027	2099	finally
    //   1036	1109	2099	finally
    //   1116	1126	2099	finally
    //   1131	1141	2099	finally
    //   1144	1186	2099	finally
    //   1186	1224	2099	finally
    //   1229	1240	2099	finally
    //   1253	1270	2099	finally
    //   1279	1352	2099	finally
    //   1359	1369	2099	finally
    //   1374	1384	2099	finally
    //   1387	1408	2099	finally
    //   1413	1424	2099	finally
    //   1629	1676	2103	finally
    //   112	146	2114	java/lang/Exception
    //   146	152	2114	java/lang/Exception
    //   156	161	2131	java/lang/Exception
    //   161	166	2148	java/lang/Exception
    //   171	192	2148	java/lang/Exception
    //   202	276	2148	java/lang/Exception
    //   276	284	2148	java/lang/Exception
    //   289	311	2164	java/lang/Exception
    //   1427	1439	2164	java/lang/Exception
    //   323	330	2175	java/lang/Exception
    //   336	343	2175	java/lang/Exception
    //   349	355	2175	java/lang/Exception
    //   361	372	2175	java/lang/Exception
    //   382	424	2175	java/lang/Exception
    //   513	520	2175	java/lang/Exception
    //   526	533	2175	java/lang/Exception
    //   539	546	2175	java/lang/Exception
    //   552	560	2175	java/lang/Exception
    //   566	578	2175	java/lang/Exception
    //   584	644	2175	java/lang/Exception
    //   424	431	2189	java/lang/Exception
    //   654	680	2189	java/lang/Exception
    //   685	694	2189	java/lang/Exception
    //   694	739	2189	java/lang/Exception
    //   752	768	2189	java/lang/Exception
    //   777	850	2189	java/lang/Exception
    //   857	866	2189	java/lang/Exception
    //   871	880	2189	java/lang/Exception
    //   883	925	2189	java/lang/Exception
    //   925	935	2189	java/lang/Exception
    //   939	974	2189	java/lang/Exception
    //   983	994	2189	java/lang/Exception
    //   1011	1027	2189	java/lang/Exception
    //   1036	1109	2189	java/lang/Exception
    //   1116	1126	2189	java/lang/Exception
    //   1131	1141	2189	java/lang/Exception
    //   1144	1186	2189	java/lang/Exception
    //   1186	1224	2189	java/lang/Exception
    //   1229	1240	2189	java/lang/Exception
    //   1253	1270	2189	java/lang/Exception
    //   1279	1352	2189	java/lang/Exception
    //   1359	1369	2189	java/lang/Exception
    //   1374	1384	2189	java/lang/Exception
    //   1387	1408	2189	java/lang/Exception
    //   1413	1424	2189	java/lang/Exception
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
  
  private boolean a(BaseProxy paramBaseProxy)
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
          Class localClass1 = paramBaseProxy.getClass();
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
        if ((i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy.length) && (!this.jdField_a_of_type_Boolean)) {
          if (a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i]))
          {
            this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i]);
          }
          else
          {
            TraceUtils.a("i." + this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i]);
            long l = System.currentTimeMillis();
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i].a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i].getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
            }
            TraceUtils.a();
          }
        }
      }
      finally {}
      return;
      i += 1;
    }
  }
  
  public ConversationProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy;
  }
  
  public MsgProxyContainer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer;
  }
  
  public MultiMsgProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageMultiMsgProxy;
  }
  
  public DataLineMsgProxy a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a();
      return this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a();
      return this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a();
    return this.jdField_b_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
  }
  
  public MpfileTaskProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy;
  }
  
  public RecentUserProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
  }
  
  public ConfessProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfessConfessProxy;
  }
  
  public FileManagerProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy;
  }
  
  public UniformDownloadBPTransProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy;
  }
  
  public QCallProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy;
  }
  
  public Vector a()
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
          BaseProxy localBaseProxy = (BaseProxy)localIterator.next();
          TraceUtils.a("i." + localBaseProxy);
          long l = System.currentTimeMillis();
          localBaseProxy.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localBaseProxy.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
          }
          TraceUtils.a();
        }
        else
        {
          this.jdField_a_of_type_JavaUtilSet.clear();
        }
      }
      finally {}
    }
  }
  
  public void a(ProxyObserver paramProxyObserver)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramProxyObserver)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramProxyObserver);
    }
  }
  
  /* Error */
  public void a(EntityManager paramEntityManager)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 63	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +36 -> 53
    //   20: ldc_w 261
    //   23: iconst_2
    //   24: new 263	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 553
    //   34: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 97	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   41: invokevirtual 556	java/util/Vector:size	()I
    //   44: invokevirtual 559	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 280	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 97	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   57: invokevirtual 560	java/util/Vector:isEmpty	()Z
    //   60: ifeq +8 -> 68
    //   63: aload_3
    //   64: monitorexit
    //   65: aload_2
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: getfield 97	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   72: astore 4
    //   74: aload_0
    //   75: new 94	java/util/Vector
    //   78: dup
    //   79: invokespecial 95	java/util/Vector:<init>	()V
    //   82: putfield 97	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   85: aload_3
    //   86: monitorexit
    //   87: aload_0
    //   88: aload_1
    //   89: aload 4
    //   91: invokespecial 562	com/tencent/mobileqq/app/proxy/ProxyManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/List;)V
    //   94: aload_0
    //   95: getfield 74	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   98: invokevirtual 565	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   101: invokevirtual 570	com/tencent/mobileqq/service/message/MessageCache:e	()V
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
    //   0	117	1	paramEntityManager	EntityManager
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
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
          if ((MsgProxyUtils.a(localMsgQueueItem.jdField_a_of_type_JavaLangString, paramString, localMsgQueueItem.jdField_a_of_type_Int, paramInt)) && ((localMsgQueueItem.jdField_b_of_type_Int == 1) || (localMsgQueueItem.jdField_b_of_type_Int == 2) || (localMsgQueueItem.jdField_b_of_type_Int == 0))) {
            localArrayList.add(localMsgQueueItem);
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
  
  public void a(String arg1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    paramContentValues = new MsgQueueItem(???, paramInt1, paramString2, paramContentValues, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
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
  
  public void a(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    d(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
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
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    a(paramString1, paramInt1, paramString2, null, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
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
  
  public void b(ProxyObserver paramProxyObserver)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramProxyObserver)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramProxyObserver);
    }
  }
  
  public void b(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    d(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
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
  
  public void c(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    d(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
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
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).createEntityManager();
    a(localEntityManager);
    localEntityManager.a();
  }
  
  public void d(String arg1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    paramEntity = new MsgQueueItem(???, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    if ((QLog.isColorLevel()) && ((paramEntity.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof MessageRecord))) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueueDonotNotify QueueItem.action: " + paramEntity.jdField_b_of_type_Int + ",mr=" + paramEntity.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramEntity);
        return;
      }
      catch (OutOfMemoryError paramEntity)
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
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.c();
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
      ThreadManager.post(new zsh(this), 8, null, false);
      int i = j;
      if (this.jdField_a_of_type_JavaUtilVector != null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilVector != null) {
          this.jdField_a_of_type_JavaLangObject.notify();
        }
        i = j;
        if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i].b();
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