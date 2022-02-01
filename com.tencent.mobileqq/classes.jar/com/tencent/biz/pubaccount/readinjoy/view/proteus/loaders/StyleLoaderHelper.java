package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.PtsAlladinKeyConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.PtsCommentFeedsAladdinKeyConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.PtsNativeFeedsAladdinKeyConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.file.ReadAssetFile;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class StyleLoaderHelper
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1000);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public StyleLoaderHelper(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public static int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  private InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    return new ReadAssetFile(paramContext, paramString1).a(paramString2);
  }
  
  private Set<String> a(String paramString)
  {
    QLog.d("TemplateFactory", 2, "getAladdinKeysByService | localPath " + paramString);
    Object localObject = new HashSet();
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    if (paramString.contains("default_feeds"))
    {
      paramString = PtsAlladinKeyConfigHandler.a();
      QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_DEFAULT_FEEDS ");
    }
    for (;;)
    {
      localObject = new StringBuilder();
      Iterator localIterator = paramString.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((StringBuilder)localObject).append((String)localIterator.next() + "\n");
          continue;
          if (paramString.contains("native_article"))
          {
            paramString = PtsNativeFeedsAladdinKeyConfigHandler.a();
            QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_NATIVE_ARTICLE ");
            break;
          }
          if (!paramString.contains("comment_feeds")) {
            break label200;
          }
          paramString = PtsCommentFeedsAladdinKeyConfigHandler.a();
          QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_COMMENT_FEEDS ");
          break;
        }
      }
      QLog.d("TemplateFactory", 1, "getAladdinKeysByService | aladdinKeys: " + ((StringBuilder)localObject).toString());
      return paramString;
      label200:
      paramString = (String)localObject;
    }
  }
  
  public static void a(String paramString)
  {
    RealTimeTemplateFactory.a(paramString, true);
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new StyleLoaderHelper.1(this));
  }
  
  public TemplateFactory a(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  /* Error */
  public TemplateFactory a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 43
    //   2: iconst_1
    //   3: new 45	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   10: ldc 158
    //   12: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: ifnull +15 -> 44
    //   32: ldc 163
    //   34: aload_0
    //   35: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +34 -> 75
    //   44: ldc 43
    //   46: iconst_2
    //   47: new 45	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   54: ldc 169
    //   56: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aconst_null
    //   70: astore 5
    //   72: aload 5
    //   74: areturn
    //   75: aload_0
    //   76: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   79: invokestatic 174	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   82: astore 6
    //   84: iload_2
    //   85: ifeq +12 -> 97
    //   88: aload 6
    //   90: astore 5
    //   92: aload 6
    //   94: ifnonnull -22 -> 72
    //   97: aload_0
    //   98: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: invokestatic 177	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils$ConfigData;
    //   104: astore 5
    //   106: aload 5
    //   108: getfield 182	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils$ConfigData:jdField_a_of_type_Boolean	Z
    //   111: ifne +85 -> 196
    //   114: aload 5
    //   116: getfield 185	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils$ConfigData:jdField_a_of_type_Int	I
    //   119: sipush 1001
    //   122: if_icmpne +38 -> 160
    //   125: ldc 43
    //   127: iconst_1
    //   128: new 45	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   135: ldc 187
    //   137: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   144: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 189
    //   149: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aconst_null
    //   159: areturn
    //   160: ldc 43
    //   162: iconst_1
    //   163: new 45	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   170: ldc 187
    //   172: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc 194
    //   184: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: goto -35 -> 158
    //   196: new 196	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory
    //   199: dup
    //   200: invokespecial 197	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:<init>	()V
    //   203: astore 7
    //   205: aload 7
    //   207: iconst_2
    //   208: invokevirtual 199	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	(I)V
    //   211: aload 7
    //   213: aload_0
    //   214: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   217: invokevirtual 201	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	(Ljava/lang/String;)V
    //   220: aload 7
    //   222: aload 5
    //   224: invokevirtual 204	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils$ConfigData;)V
    //   227: invokestatic 210	java/lang/System:currentTimeMillis	()J
    //   230: lstore_3
    //   231: aload_0
    //   232: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   235: invokestatic 215	com/tencent/biz/common/offline/OfflineEnvHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   238: astore 5
    //   240: ldc 43
    //   242: iconst_2
    //   243: new 45	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   250: ldc 217
    //   252: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 5
    //   257: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload 5
    //   268: ifnonnull +38 -> 306
    //   271: ldc 43
    //   273: iconst_1
    //   274: new 45	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   281: ldc 217
    //   283: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_0
    //   287: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   290: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc 219
    //   295: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aconst_null
    //   305: areturn
    //   306: new 45	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   313: aload 5
    //   315: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   322: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore 5
    //   330: aload 5
    //   332: aload_0
    //   333: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   336: invokestatic 224	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   339: ifne +38 -> 377
    //   342: ldc 43
    //   344: iconst_1
    //   345: new 45	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   352: ldc 226
    //   354: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_0
    //   358: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   361: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc 228
    //   366: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aconst_null
    //   376: areturn
    //   377: new 45	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   384: aload 5
    //   386: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc 230
    //   391: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc 232
    //   396: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: astore 8
    //   404: new 45	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   411: aload_0
    //   412: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   415: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc 230
    //   420: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc 232
    //   425: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: astore 9
    //   433: new 234	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/file/ReadMergeFile
    //   436: dup
    //   437: aload_1
    //   438: aload 5
    //   440: aload_0
    //   441: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   444: invokespecial 237	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/file/ReadMergeFile:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   447: astore 5
    //   449: new 234	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/file/ReadMergeFile
    //   452: dup
    //   453: aload_1
    //   454: aload 8
    //   456: aload 9
    //   458: invokespecial 237	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/file/ReadMergeFile:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   461: astore 10
    //   463: new 239	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/OfflineComplementFileStringLoader
    //   466: dup
    //   467: aload 10
    //   469: invokespecial 242	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/OfflineComplementFileStringLoader:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/file/ReadFile;)V
    //   472: astore 11
    //   474: aload 10
    //   476: invokeinterface 247 1 0
    //   481: astore_1
    //   482: aload_1
    //   483: ifnull +442 -> 925
    //   486: new 249	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   489: dup
    //   490: invokespecial 250	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   493: astore 12
    //   495: aload 12
    //   497: ldc 252
    //   499: invokevirtual 255	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setVersion	(Ljava/lang/String;)V
    //   502: aload 12
    //   504: aload_0
    //   505: aload_0
    //   506: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   509: invokespecial 257	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:a	(Ljava/lang/String;)Ljava/util/Set;
    //   512: invokevirtual 261	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setAladdinKey	(Ljava/util/Set;)V
    //   515: aload 5
    //   517: ldc_w 263
    //   520: invokeinterface 264 2 0
    //   525: astore 5
    //   527: aload 5
    //   529: ifnull +13 -> 542
    //   532: aload 12
    //   534: aload 5
    //   536: invokestatic 267	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   539: invokevirtual 270	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   542: aload_1
    //   543: invokeinterface 273 1 0
    //   548: astore 13
    //   550: aload 13
    //   552: invokeinterface 97 1 0
    //   557: ifeq +299 -> 856
    //   560: aload 13
    //   562: invokeinterface 101 1 0
    //   567: checkcast 75	java/lang/String
    //   570: astore_1
    //   571: ldc 43
    //   573: iconst_1
    //   574: new 45	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 275
    //   584: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_1
    //   588: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: ldc_w 277
    //   600: astore 6
    //   602: aload 6
    //   604: astore 5
    //   606: aload_1
    //   607: ldc_w 279
    //   610: invokevirtual 283	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   613: ifeq -63 -> 550
    //   616: aload 6
    //   618: astore 5
    //   620: aload 10
    //   622: aload_1
    //   623: invokeinterface 264 2 0
    //   628: astore 14
    //   630: aload 6
    //   632: astore 5
    //   634: aload 14
    //   636: instanceof 285
    //   639: ifeq +170 -> 809
    //   642: aload 6
    //   644: astore 5
    //   646: new 45	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   653: aload 9
    //   655: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: ldc 230
    //   660: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: aload_1
    //   664: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: astore_1
    //   671: aload_1
    //   672: astore 5
    //   674: aload 12
    //   676: aload 7
    //   678: aload 14
    //   680: invokestatic 267	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   683: aload 11
    //   685: invokevirtual 289	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   688: aload_1
    //   689: astore 5
    //   691: ldc 43
    //   693: iconst_1
    //   694: new 45	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   701: ldc_w 291
    //   704: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: aload_1
    //   708: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   717: goto -167 -> 550
    //   720: astore_1
    //   721: ldc 43
    //   723: iconst_1
    //   724: new 45	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   731: ldc_w 293
    //   734: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: aload 5
    //   739: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: aload_1
    //   746: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   749: aload_1
    //   750: athrow
    //   751: astore_1
    //   752: ldc 43
    //   754: iconst_1
    //   755: ldc_w 298
    //   758: aload_1
    //   759: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   762: aconst_null
    //   763: areturn
    //   764: astore 5
    //   766: ldc 43
    //   768: iconst_1
    //   769: new 45	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   776: ldc_w 300
    //   779: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload 5
    //   784: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 303	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: goto -251 -> 542
    //   796: astore_1
    //   797: ldc 43
    //   799: iconst_1
    //   800: ldc_w 305
    //   803: aload_1
    //   804: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   807: aconst_null
    //   808: areturn
    //   809: aload 6
    //   811: astore 5
    //   813: aload 14
    //   815: instanceof 307
    //   818: ifeq +35 -> 853
    //   821: aload 6
    //   823: astore 5
    //   825: new 45	java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   832: aload 8
    //   834: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: ldc 230
    //   839: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload_1
    //   843: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: astore_1
    //   850: goto -179 -> 671
    //   853: goto -182 -> 671
    //   856: ldc 43
    //   858: iconst_2
    //   859: new 45	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 309
    //   869: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokestatic 210	java/lang/System:currentTimeMillis	()J
    //   875: lload_3
    //   876: lsub
    //   877: invokevirtual 312	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   880: ldc_w 314
    //   883: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   892: ldc 43
    //   894: iconst_1
    //   895: ldc_w 316
    //   898: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   901: aload_0
    //   902: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   905: aload 7
    //   907: invokestatic 319	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;)V
    //   910: aload_0
    //   911: invokespecial 321	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	()V
    //   914: iconst_3
    //   915: aload_0
    //   916: getfield 24	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   919: invokestatic 326	com/tencent/biz/pubaccount/util/ProteusReportUtil:a	(ILjava/lang/String;)V
    //   922: aload 7
    //   924: areturn
    //   925: ldc 43
    //   927: iconst_1
    //   928: ldc_w 328
    //   931: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   934: aconst_null
    //   935: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	936	0	this	StyleLoaderHelper
    //   0	936	1	paramContext	Context
    //   0	936	2	paramBoolean	boolean
    //   230	646	3	l	long
    //   70	668	5	localObject1	Object
    //   764	19	5	localIOException	java.io.IOException
    //   811	13	5	localObject2	Object
    //   82	740	6	localObject3	Object
    //   203	720	7	localTemplateFactory	TemplateFactory
    //   402	431	8	str1	String
    //   431	223	9	str2	String
    //   461	160	10	localReadMergeFile	com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.file.ReadMergeFile
    //   472	212	11	localOfflineComplementFileStringLoader	OfflineComplementFileStringLoader
    //   493	182	12	localProteusParser	com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser
    //   548	13	13	localIterator	Iterator
    //   628	186	14	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   606	616	720	org/json/JSONException
    //   620	630	720	org/json/JSONException
    //   634	642	720	org/json/JSONException
    //   646	671	720	org/json/JSONException
    //   674	688	720	org/json/JSONException
    //   691	717	720	org/json/JSONException
    //   813	821	720	org/json/JSONException
    //   825	850	720	org/json/JSONException
    //   377	482	751	java/lang/OutOfMemoryError
    //   486	515	751	java/lang/OutOfMemoryError
    //   515	527	751	java/lang/OutOfMemoryError
    //   532	542	751	java/lang/OutOfMemoryError
    //   542	550	751	java/lang/OutOfMemoryError
    //   550	597	751	java/lang/OutOfMemoryError
    //   606	616	751	java/lang/OutOfMemoryError
    //   620	630	751	java/lang/OutOfMemoryError
    //   634	642	751	java/lang/OutOfMemoryError
    //   646	671	751	java/lang/OutOfMemoryError
    //   674	688	751	java/lang/OutOfMemoryError
    //   691	717	751	java/lang/OutOfMemoryError
    //   721	751	751	java/lang/OutOfMemoryError
    //   766	793	751	java/lang/OutOfMemoryError
    //   813	821	751	java/lang/OutOfMemoryError
    //   825	850	751	java/lang/OutOfMemoryError
    //   856	892	751	java/lang/OutOfMemoryError
    //   925	934	751	java/lang/OutOfMemoryError
    //   515	527	764	java/io/IOException
    //   532	542	764	java/io/IOException
    //   377	482	796	java/lang/Exception
    //   486	515	796	java/lang/Exception
    //   515	527	796	java/lang/Exception
    //   532	542	796	java/lang/Exception
    //   542	550	796	java/lang/Exception
    //   550	597	796	java/lang/Exception
    //   606	616	796	java/lang/Exception
    //   620	630	796	java/lang/Exception
    //   634	642	796	java/lang/Exception
    //   646	671	796	java/lang/Exception
    //   674	688	796	java/lang/Exception
    //   691	717	796	java/lang/Exception
    //   721	751	796	java/lang/Exception
    //   766	793	796	java/lang/Exception
    //   813	821	796	java/lang/Exception
    //   825	850	796	java/lang/Exception
    //   856	892	796	java/lang/Exception
    //   925	934	796	java/lang/Exception
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("0".equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.executeOnFileThread(new StyleLoaderHelper.2(this));
  }
  
  /* Error */
  public TemplateFactory b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   4: ifnonnull +35 -> 39
    //   7: ldc 43
    //   9: iconst_2
    //   10: new 45	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 277
    //   20: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: invokestatic 210	java/lang/System:currentTimeMillis	()J
    //   42: lstore_2
    //   43: aload_0
    //   44: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   47: invokestatic 174	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   50: astore 5
    //   52: aload 5
    //   54: astore 4
    //   56: aload 5
    //   58: ifnonnull -22 -> 36
    //   61: new 196	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory
    //   64: dup
    //   65: invokespecial 197	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:<init>	()V
    //   68: astore 7
    //   70: aload 7
    //   72: iconst_1
    //   73: invokevirtual 199	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	(I)V
    //   76: aload 7
    //   78: ldc 163
    //   80: invokevirtual 201	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 341	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   87: astore 8
    //   89: new 45	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   96: aload_0
    //   97: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   100: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 230
    //   105: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 232
    //   110: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore 9
    //   118: new 33	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/file/ReadAssetFile
    //   121: dup
    //   122: aload_1
    //   123: aload 9
    //   125: invokespecial 36	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/file/ReadAssetFile:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   128: astore 10
    //   130: aload 10
    //   132: invokeinterface 247 1 0
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +613 -> 754
    //   144: ldc 43
    //   146: iconst_1
    //   147: new 45	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 343
    //   157: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 5
    //   162: invokeinterface 346 1 0
    //   167: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 351
    //   173: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   180: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: new 249	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   192: dup
    //   193: invokespecial 250	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   196: astore 4
    //   198: aload 4
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   205: invokespecial 257	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:a	(Ljava/lang/String;)Ljava/util/Set;
    //   208: invokevirtual 261	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setAladdinKey	(Ljava/util/Set;)V
    //   211: invokestatic 357	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   214: invokevirtual 360	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   217: ifeq +548 -> 765
    //   220: invokestatic 357	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   223: astore 4
    //   225: aload 4
    //   227: aload_0
    //   228: aload_1
    //   229: aload_0
    //   230: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   233: ldc_w 263
    //   236: invokespecial 362	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   239: invokestatic 267	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   242: invokevirtual 270	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   245: new 364	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/AssetsComplementFileStringLoader
    //   248: dup
    //   249: aload_1
    //   250: aload 9
    //   252: invokespecial 365	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/AssetsComplementFileStringLoader:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   255: astore 11
    //   257: aload 5
    //   259: invokeinterface 273 1 0
    //   264: astore 12
    //   266: aload 12
    //   268: invokeinterface 97 1 0
    //   273: ifeq +319 -> 592
    //   276: aload 12
    //   278: invokeinterface 101 1 0
    //   283: checkcast 75	java/lang/String
    //   286: astore 13
    //   288: aload 13
    //   290: ldc_w 279
    //   293: invokevirtual 283	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   296: ifeq -30 -> 266
    //   299: ldc 43
    //   301: iconst_2
    //   302: new 45	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 367
    //   312: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 13
    //   317: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: invokestatic 357	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   329: invokevirtual 360	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   332: ifeq +143 -> 475
    //   335: invokestatic 357	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   338: aload_1
    //   339: aload 7
    //   341: aload 11
    //   343: new 45	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   350: aload 9
    //   352: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 230
    //   357: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 13
    //   362: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: aload 9
    //   370: new 45	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   377: aload_0
    //   378: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   381: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 369
    //   387: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokevirtual 373	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:createViewTempFromAssets	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   396: goto -130 -> 266
    //   399: astore 5
    //   401: ldc 43
    //   403: iconst_1
    //   404: new 45	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 375
    //   414: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 13
    //   419: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: aload 5
    //   427: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: goto -164 -> 266
    //   433: astore_1
    //   434: ldc 43
    //   436: iconst_1
    //   437: ldc_w 377
    //   440: aload_1
    //   441: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   444: aconst_null
    //   445: areturn
    //   446: astore 6
    //   448: ldc 43
    //   450: iconst_2
    //   451: ldc_w 379
    //   454: aload 6
    //   456: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   459: goto -214 -> 245
    //   462: astore_1
    //   463: ldc 43
    //   465: iconst_1
    //   466: ldc_w 379
    //   469: aload_1
    //   470: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   473: aconst_null
    //   474: areturn
    //   475: aload 10
    //   477: aload 13
    //   479: invokeinterface 264 2 0
    //   484: astore 6
    //   486: aload 6
    //   488: astore 5
    //   490: aload 6
    //   492: ifnonnull +78 -> 570
    //   495: aload 8
    //   497: new 45	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   504: aload 9
    //   506: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc 230
    //   511: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload 13
    //   516: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokevirtual 384	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   525: astore 5
    //   527: ldc 43
    //   529: iconst_1
    //   530: new 45	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 386
    //   540: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 9
    //   545: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc 230
    //   550: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 13
    //   555: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: ldc_w 388
    //   561: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 4
    //   572: aload 7
    //   574: aload 5
    //   576: invokestatic 267	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   579: aload 11
    //   581: invokevirtual 289	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   584: aload 5
    //   586: invokevirtual 393	java/io/InputStream:close	()V
    //   589: goto -323 -> 266
    //   592: aload 7
    //   594: invokevirtual 397	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:getNameTemplateMap	()Ljava/util/Map;
    //   597: astore 4
    //   599: new 45	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   606: astore_1
    //   607: aload 4
    //   609: invokeinterface 402 1 0
    //   614: invokeinterface 91 1 0
    //   619: astore 4
    //   621: aload 4
    //   623: invokeinterface 97 1 0
    //   628: ifeq +51 -> 679
    //   631: aload 4
    //   633: invokeinterface 101 1 0
    //   638: checkcast 404	java/util/Map$Entry
    //   641: astore 5
    //   643: aload_1
    //   644: new 45	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   651: aload 5
    //   653: invokeinterface 407 1 0
    //   658: checkcast 75	java/lang/String
    //   661: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc 103
    //   666: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: goto -55 -> 621
    //   679: ldc 43
    //   681: iconst_2
    //   682: new 45	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   689: ldc_w 409
    //   692: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: aload_1
    //   696: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: ldc 43
    //   710: iconst_1
    //   711: new 45	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 411
    //   721: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokestatic 210	java/lang/System:currentTimeMillis	()J
    //   727: lload_2
    //   728: lsub
    //   729: invokevirtual 312	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   732: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload_0
    //   739: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	Ljava/lang/String;
    //   742: aload 7
    //   744: invokestatic 319	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;)V
    //   747: aload_0
    //   748: invokespecial 321	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleLoaderHelper:b	()V
    //   751: aload 7
    //   753: areturn
    //   754: ldc 43
    //   756: iconst_1
    //   757: ldc_w 413
    //   760: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: aconst_null
    //   764: areturn
    //   765: goto -540 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	768	0	this	StyleLoaderHelper
    //   0	768	1	paramContext	Context
    //   42	686	2	l	long
    //   34	598	4	localObject1	Object
    //   50	208	5	localObject2	Object
    //   399	27	5	localException1	java.lang.Exception
    //   488	164	5	localObject3	Object
    //   446	9	6	localException2	java.lang.Exception
    //   484	7	6	localInputStream	InputStream
    //   68	684	7	localTemplateFactory	TemplateFactory
    //   87	409	8	localAssetManager	android.content.res.AssetManager
    //   116	428	9	str1	String
    //   128	348	10	localReadAssetFile	ReadAssetFile
    //   255	325	11	localAssetsComplementFileStringLoader	AssetsComplementFileStringLoader
    //   264	13	12	localIterator	Iterator
    //   286	268	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   326	396	399	java/lang/Exception
    //   475	486	399	java/lang/Exception
    //   495	570	399	java/lang/Exception
    //   570	589	399	java/lang/Exception
    //   118	139	433	java/lang/OutOfMemoryError
    //   144	225	433	java/lang/OutOfMemoryError
    //   225	245	433	java/lang/OutOfMemoryError
    //   245	266	433	java/lang/OutOfMemoryError
    //   266	326	433	java/lang/OutOfMemoryError
    //   326	396	433	java/lang/OutOfMemoryError
    //   401	430	433	java/lang/OutOfMemoryError
    //   448	459	433	java/lang/OutOfMemoryError
    //   475	486	433	java/lang/OutOfMemoryError
    //   495	570	433	java/lang/OutOfMemoryError
    //   570	589	433	java/lang/OutOfMemoryError
    //   592	621	433	java/lang/OutOfMemoryError
    //   621	676	433	java/lang/OutOfMemoryError
    //   679	708	433	java/lang/OutOfMemoryError
    //   754	763	433	java/lang/OutOfMemoryError
    //   225	245	446	java/lang/Exception
    //   118	139	462	java/lang/Exception
    //   144	225	462	java/lang/Exception
    //   245	266	462	java/lang/Exception
    //   266	326	462	java/lang/Exception
    //   401	430	462	java/lang/Exception
    //   448	459	462	java/lang/Exception
    //   592	621	462	java/lang/Exception
    //   621	676	462	java/lang/Exception
    //   679	708	462	java/lang/Exception
    //   754	763	462	java/lang/Exception
  }
  
  public void b(String paramString)
  {
    QLog.d("TemplateFactory", 1, "resetTemplates: " + paramString);
    TemplateFactory localTemplateFactory = a(BaseApplicationImpl.getApplication(), false);
    if (localTemplateFactory == null)
    {
      QLog.d("TemplateFactory", 1, "templateFactory == null  bid : " + paramString);
      return;
    }
    localTemplateFactory.a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet());
    OfflineUtils.a(paramString, localTemplateFactory);
    TemplateFactory.a();
  }
  
  public String toString()
  {
    return " bid :" + this.jdField_a_of_type_JavaLangString + " localPath: " + this.b + " config: " + HtmlOffline.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper
 * JD-Core Version:    0.7.0.1
 */