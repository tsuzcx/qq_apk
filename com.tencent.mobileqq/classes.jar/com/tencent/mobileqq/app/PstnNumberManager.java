package com.tencent.mobileqq.app;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

public class PstnNumberManager
{
  private static String jdField_a_of_type_JavaLangString;
  private static final List jdField_a_of_type_JavaUtilList = Arrays.asList((Object[])jdField_c_of_type_ArrayOfJavaLangString.clone());
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "data1" };
  private static String jdField_b_of_type_JavaLangString;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "contact_id" };
  private static String jdField_c_of_type_JavaLangString;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  private static String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "来电专线";
    jdField_b_of_type_JavaLangString = "专线电话";
    jdField_c_of_type_JavaLangString = "回拨电话";
    d = "这是“来电”回拨模式专线号码。";
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "4008016062", "4009180338", "07507841000", "02886544200", "059528394996", "4008257119", "4008640166", "075583765566", "02886544201", "02886544226", "059522564190", "059528394740" };
  }
  
  private static void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString1, String paramString2)
  {
    BaseApplicationImpl localBaseApplicationImpl = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    int i;
    do
    {
      return;
      i = localBaseApplicationImpl.getContentResolver().delete(ContactsContract.Data.CONTENT_URI, "raw_contact_id=? AND mimetype = ? AND data1=?", new String[] { paramString2, "vnd.android.cursor.item/phone_v2", paramString1 });
    } while (!QLog.isColorLevel());
    QLog.i("PstnNumberManager", 2, "delete success, num:" + paramString1 + ", result:" + i);
  }
  
  private static void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString1, String paramString2, String paramString3)
  {
    BaseApplicationImpl localBaseApplicationImpl = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      if (QLog.isColorLevel()) {
        QLog.i("PstnNumberManager", 2, "updateOldNumber|element null!");
      }
    }
    int i;
    do
    {
      return;
      paramBaseApplicationImpl = new ContentValues();
      paramBaseApplicationImpl.put("data1", paramString1);
      paramBaseApplicationImpl.put("data2", Integer.valueOf(0));
      paramBaseApplicationImpl.put("data3", jdField_c_of_type_JavaLangString);
      i = localBaseApplicationImpl.getContentResolver().update(ContactsContract.Data.CONTENT_URI, paramBaseApplicationImpl, "raw_contact_id=? AND mimetype = ? AND data1=?", new String[] { paramString3, "vnd.android.cursor.item/phone_v2", paramString2 });
      if (QLog.isColorLevel()) {
        QLog.i("PstnNumberManager", 2, "update success, oldNum:" + paramString2 + ",phoneNew:" + paramString1 + ",result:" + i);
      }
    } while (i != 0);
    a(localBaseApplicationImpl, paramString2, paramString3);
    b(localBaseApplicationImpl, paramString1, paramString3);
  }
  
  private static void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString, List paramList1, List paramList2)
  {
    int j = 0;
    BaseApplicationImpl localBaseApplicationImpl = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    }
    if ((paramList1 == null) || (paramList1.size() == 0) || (paramList2 == null) || (paramList2.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      a(localBaseApplicationImpl, (String)paramList1.get(i), paramString);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PstnNumberManager", 2, "delete when setup > 30");
    }
    paramBaseApplicationImpl = SharedPreUtils.a(localBaseApplicationImpl.getRuntime().getAccount()).edit();
    i = j;
    if (i < paramList2.size())
    {
      paramList1 = (String)paramList2.get(i);
      if (!TextUtils.isEmpty(paramList1))
      {
        b(localBaseApplicationImpl, paramList1, paramString);
        if (i >= 6) {
          break label205;
        }
        paramBaseApplicationImpl.putString("callbackPhone_" + i, paramList1);
      }
      for (;;)
      {
        i += 1;
        break;
        label205:
        paramBaseApplicationImpl.putString("callbackPhone_f_" + (i - 6), paramList1);
      }
    }
    paramBaseApplicationImpl.commit();
  }
  
  /* Error */
  private static void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 91	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: astore_3
    //   4: aload_3
    //   5: invokevirtual 101	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   8: astore_1
    //   9: getstatic 107	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   12: astore_2
    //   13: getstatic 27	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: astore 4
    //   18: aload_1
    //   19: aload_2
    //   20: iconst_1
    //   21: anewarray 15	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 237
    //   28: aastore
    //   29: ldc 239
    //   31: iconst_1
    //   32: anewarray 15	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload 4
    //   39: aastore
    //   40: aconst_null
    //   41: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +60 -> 106
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: invokeinterface 248 1 0
    //   57: ifeq +49 -> 106
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: invokeinterface 251 1 0
    //   68: pop
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_2
    //   73: ldc 237
    //   75: invokeinterface 255 2 0
    //   80: invokeinterface 259 2 0
    //   85: astore 4
    //   87: aload_2
    //   88: astore_1
    //   89: aload 4
    //   91: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +12 -> 106
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: aload_0
    //   101: aload 4
    //   103: invokestatic 184	com/tencent/mobileqq/app/PstnNumberManager:b	(Lcom/tencent/common/app/BaseApplicationImpl;Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_2
    //   107: ifnull +9 -> 116
    //   110: aload_2
    //   111: invokeinterface 262 1 0
    //   116: return
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 265	java/lang/Exception:printStackTrace	()V
    //   122: return
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: astore_1
    //   128: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +15 -> 146
    //   134: aload_2
    //   135: astore_1
    //   136: ldc 125
    //   138: iconst_2
    //   139: ldc_w 267
    //   142: aload_0
    //   143: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_2
    //   147: ifnull -31 -> 116
    //   150: aload_2
    //   151: invokeinterface 262 1 0
    //   156: return
    //   157: astore_0
    //   158: aload_0
    //   159: invokevirtual 265	java/lang/Exception:printStackTrace	()V
    //   162: return
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull +9 -> 176
    //   170: aload_1
    //   171: invokeinterface 262 1 0
    //   176: aload_0
    //   177: athrow
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 265	java/lang/Exception:printStackTrace	()V
    //   183: goto -7 -> 176
    //   186: astore_0
    //   187: goto -21 -> 166
    //   190: astore_0
    //   191: goto -65 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramString	String
    //   8	163	1	localObject1	Object
    //   178	2	1	localException	java.lang.Exception
    //   12	139	2	localObject2	Object
    //   3	97	3	localBaseApplicationImpl	BaseApplicationImpl
    //   16	86	4	str	String
    // Exception table:
    //   from	to	target	type
    //   110	116	117	java/lang/Exception
    //   4	45	123	java/lang/Throwable
    //   150	156	157	java/lang/Exception
    //   4	45	163	finally
    //   170	176	178	java/lang/Exception
    //   51	60	186	finally
    //   62	69	186	finally
    //   71	87	186	finally
    //   89	97	186	finally
    //   99	106	186	finally
    //   128	134	186	finally
    //   136	146	186	finally
    //   51	60	190	java/lang/Throwable
    //   62	69	190	java/lang/Throwable
    //   71	87	190	java/lang/Throwable
    //   89	97	190	java/lang/Throwable
    //   99	106	190	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +19 -> 23
    //   7: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 125
    //   15: iconst_2
    //   16: ldc_w 274
    //   19: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: return
    //   23: invokestatic 276	com/tencent/mobileqq/app/PstnNumberManager:a	()Z
    //   26: ifne -4 -> 22
    //   29: ldc 125
    //   31: iconst_2
    //   32: new 127	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 278
    //   42: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: invokestatic 91	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   58: astore 14
    //   60: new 280	java/util/ArrayList
    //   63: dup
    //   64: invokespecial 281	java/util/ArrayList:<init>	()V
    //   67: astore 15
    //   69: aconst_null
    //   70: astore_2
    //   71: aconst_null
    //   72: astore 10
    //   74: aconst_null
    //   75: astore 4
    //   77: aconst_null
    //   78: astore 11
    //   80: aconst_null
    //   81: astore 12
    //   83: aconst_null
    //   84: astore 9
    //   86: aconst_null
    //   87: astore 13
    //   89: aload 11
    //   91: astore 8
    //   93: aload 10
    //   95: astore 7
    //   97: aload_2
    //   98: astore 6
    //   100: aload 14
    //   102: invokevirtual 101	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   105: astore_3
    //   106: aload 11
    //   108: astore 8
    //   110: aload 10
    //   112: astore 7
    //   114: aload_2
    //   115: astore 6
    //   117: getstatic 107	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   120: astore 5
    //   122: aload 11
    //   124: astore 8
    //   126: aload 10
    //   128: astore 7
    //   130: aload_2
    //   131: astore 6
    //   133: getstatic 27	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   136: astore 16
    //   138: aload 11
    //   140: astore 8
    //   142: aload 10
    //   144: astore 7
    //   146: aload_2
    //   147: astore 6
    //   149: aload_3
    //   150: aload 5
    //   152: iconst_1
    //   153: anewarray 15	java/lang/String
    //   156: dup
    //   157: iconst_0
    //   158: ldc 237
    //   160: aastore
    //   161: ldc 239
    //   163: iconst_1
    //   164: anewarray 15	java/lang/String
    //   167: dup
    //   168: iconst_0
    //   169: aload 16
    //   171: aastore
    //   172: aconst_null
    //   173: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   176: astore_2
    //   177: aload 12
    //   179: astore_3
    //   180: aload 13
    //   182: astore 5
    //   184: aload_2
    //   185: ifnull +258 -> 443
    //   188: aload 12
    //   190: astore_3
    //   191: aload 13
    //   193: astore 5
    //   195: aload 11
    //   197: astore 8
    //   199: aload 10
    //   201: astore 7
    //   203: aload_2
    //   204: astore 6
    //   206: aload_2
    //   207: invokeinterface 248 1 0
    //   212: ifeq +231 -> 443
    //   215: aload 11
    //   217: astore 8
    //   219: aload 10
    //   221: astore 7
    //   223: aload_2
    //   224: astore 6
    //   226: aload_2
    //   227: invokeinterface 251 1 0
    //   232: pop
    //   233: aload 11
    //   235: astore 8
    //   237: aload 10
    //   239: astore 7
    //   241: aload_2
    //   242: astore 6
    //   244: aload_2
    //   245: aload_2
    //   246: ldc 237
    //   248: invokeinterface 255 2 0
    //   253: invokeinterface 259 2 0
    //   258: astore 5
    //   260: aload 11
    //   262: astore 8
    //   264: aload 10
    //   266: astore 7
    //   268: aload_2
    //   269: astore 6
    //   271: aload 14
    //   273: invokevirtual 101	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   276: getstatic 107	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   279: iconst_1
    //   280: anewarray 15	java/lang/String
    //   283: dup
    //   284: iconst_0
    //   285: ldc 17
    //   287: aastore
    //   288: ldc_w 283
    //   291: iconst_2
    //   292: anewarray 15	java/lang/String
    //   295: dup
    //   296: iconst_0
    //   297: aload 5
    //   299: aastore
    //   300: dup
    //   301: iconst_1
    //   302: ldc 111
    //   304: aastore
    //   305: aconst_null
    //   306: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   309: astore_3
    //   310: aload_3
    //   311: ifnull +132 -> 443
    //   314: aload_3
    //   315: invokeinterface 286 1 0
    //   320: ifeq +123 -> 443
    //   323: aload_3
    //   324: aload_3
    //   325: ldc 17
    //   327: invokeinterface 255 2 0
    //   332: invokeinterface 259 2 0
    //   337: astore 6
    //   339: aload 6
    //   341: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   344: ifne -30 -> 314
    //   347: aload 15
    //   349: aload 6
    //   351: invokeinterface 290 2 0
    //   356: pop
    //   357: goto -43 -> 314
    //   360: astore 5
    //   362: aload_3
    //   363: astore_0
    //   364: aconst_null
    //   365: astore_3
    //   366: aconst_null
    //   367: astore 6
    //   369: aload_2
    //   370: astore 4
    //   372: aload_0
    //   373: astore_2
    //   374: aload 6
    //   376: astore_0
    //   377: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +14 -> 394
    //   383: ldc 125
    //   385: iconst_2
    //   386: ldc_w 292
    //   389: aload 5
    //   391: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   394: aload 4
    //   396: ifnull +10 -> 406
    //   399: aload 4
    //   401: invokeinterface 262 1 0
    //   406: aload_2
    //   407: ifnull +9 -> 416
    //   410: aload_2
    //   411: invokeinterface 262 1 0
    //   416: aload_3
    //   417: ifnull +9 -> 426
    //   420: aload_3
    //   421: invokeinterface 262 1 0
    //   426: aload_0
    //   427: ifnull -405 -> 22
    //   430: aload_0
    //   431: invokeinterface 262 1 0
    //   436: return
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 265	java/lang/Exception:printStackTrace	()V
    //   442: return
    //   443: aload_3
    //   444: astore 8
    //   446: aload 10
    //   448: astore 7
    //   450: aload_2
    //   451: astore 6
    //   453: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +76 -> 532
    //   459: aload_3
    //   460: astore 8
    //   462: aload 10
    //   464: astore 7
    //   466: aload_2
    //   467: astore 6
    //   469: ldc 125
    //   471: iconst_2
    //   472: new 127	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 294
    //   482: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_0
    //   486: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc_w 296
    //   492: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: iload_1
    //   496: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: ldc_w 298
    //   502: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload 5
    //   507: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: ldc_w 300
    //   513: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload 15
    //   518: invokeinterface 191 1 0
    //   523: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: aload_3
    //   533: astore 8
    //   535: aload 10
    //   537: astore 7
    //   539: aload_2
    //   540: astore 6
    //   542: aload 15
    //   544: invokeinterface 191 1 0
    //   549: ifne +675 -> 1224
    //   552: aload_3
    //   553: astore 8
    //   555: aload 10
    //   557: astore 7
    //   559: aload_2
    //   560: astore 6
    //   562: aload 14
    //   564: invokevirtual 101	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   567: astore 4
    //   569: aload_3
    //   570: astore 8
    //   572: aload 10
    //   574: astore 7
    //   576: aload_2
    //   577: astore 6
    //   579: getstatic 107	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   582: astore 11
    //   584: aload_3
    //   585: astore 8
    //   587: aload 10
    //   589: astore 7
    //   591: aload_2
    //   592: astore 6
    //   594: getstatic 31	com/tencent/mobileqq/app/PstnNumberManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   597: astore 12
    //   599: aload_3
    //   600: astore 8
    //   602: aload 10
    //   604: astore 7
    //   606: aload_2
    //   607: astore 6
    //   609: aload 4
    //   611: aload 11
    //   613: iconst_1
    //   614: anewarray 15	java/lang/String
    //   617: dup
    //   618: iconst_0
    //   619: ldc 237
    //   621: aastore
    //   622: ldc 239
    //   624: iconst_1
    //   625: anewarray 15	java/lang/String
    //   628: dup
    //   629: iconst_0
    //   630: aload 12
    //   632: aastore
    //   633: aconst_null
    //   634: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   637: astore 4
    //   639: aload 4
    //   641: ifnull +565 -> 1206
    //   644: aload_3
    //   645: astore 8
    //   647: aload 4
    //   649: astore 7
    //   651: aload_2
    //   652: astore 6
    //   654: aload 4
    //   656: invokeinterface 248 1 0
    //   661: ifeq +545 -> 1206
    //   664: aload_3
    //   665: astore 8
    //   667: aload 4
    //   669: astore 7
    //   671: aload_2
    //   672: astore 6
    //   674: aload 4
    //   676: invokeinterface 251 1 0
    //   681: pop
    //   682: aload_3
    //   683: astore 8
    //   685: aload 4
    //   687: astore 7
    //   689: aload_2
    //   690: astore 6
    //   692: aload 4
    //   694: aload 4
    //   696: ldc 237
    //   698: invokeinterface 255 2 0
    //   703: invokeinterface 259 2 0
    //   708: astore 5
    //   710: aload_3
    //   711: astore 8
    //   713: aload 4
    //   715: astore 7
    //   717: aload_2
    //   718: astore 6
    //   720: aload 14
    //   722: invokevirtual 101	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   725: getstatic 107	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   728: iconst_1
    //   729: anewarray 15	java/lang/String
    //   732: dup
    //   733: iconst_0
    //   734: ldc 17
    //   736: aastore
    //   737: ldc_w 283
    //   740: iconst_2
    //   741: anewarray 15	java/lang/String
    //   744: dup
    //   745: iconst_0
    //   746: aload 5
    //   748: aastore
    //   749: dup
    //   750: iconst_1
    //   751: ldc 111
    //   753: aastore
    //   754: aconst_null
    //   755: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   758: astore 10
    //   760: aload 10
    //   762: astore 6
    //   764: aload 6
    //   766: ifnull +72 -> 838
    //   769: aload 6
    //   771: invokeinterface 286 1 0
    //   776: ifeq +62 -> 838
    //   779: aload 6
    //   781: aload 6
    //   783: ldc 17
    //   785: invokeinterface 255 2 0
    //   790: invokeinterface 259 2 0
    //   795: astore 7
    //   797: aload 7
    //   799: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   802: ifne -33 -> 769
    //   805: aload 15
    //   807: aload 7
    //   809: invokeinterface 290 2 0
    //   814: pop
    //   815: goto -46 -> 769
    //   818: astore 5
    //   820: aload_2
    //   821: astore 7
    //   823: aload 6
    //   825: astore_0
    //   826: aload_3
    //   827: astore_2
    //   828: aload 4
    //   830: astore_3
    //   831: aload 7
    //   833: astore 4
    //   835: goto -458 -> 377
    //   838: aload 5
    //   840: astore 7
    //   842: aload 4
    //   844: astore 5
    //   846: aload 6
    //   848: astore 4
    //   850: aload 7
    //   852: astore 6
    //   854: aload 15
    //   856: invokeinterface 191 1 0
    //   861: ifne +83 -> 944
    //   864: getstatic 80	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   867: invokestatic 303	com/tencent/mobileqq/app/PstnNumberManager:a	(Ljava/util/List;)Z
    //   870: pop
    //   871: aload_0
    //   872: iload_1
    //   873: aload 6
    //   875: invokestatic 305	com/tencent/mobileqq/app/PstnNumberManager:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   881: ifeq +12 -> 893
    //   884: ldc 125
    //   886: iconst_2
    //   887: ldc_w 307
    //   890: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: aload_2
    //   894: ifnull +9 -> 903
    //   897: aload_2
    //   898: invokeinterface 262 1 0
    //   903: aload_3
    //   904: ifnull +9 -> 913
    //   907: aload_3
    //   908: invokeinterface 262 1 0
    //   913: aload 5
    //   915: ifnull +10 -> 925
    //   918: aload 5
    //   920: invokeinterface 262 1 0
    //   925: aload 4
    //   927: ifnull -905 -> 22
    //   930: aload 4
    //   932: invokeinterface 262 1 0
    //   937: return
    //   938: astore_0
    //   939: aload_0
    //   940: invokevirtual 265	java/lang/Exception:printStackTrace	()V
    //   943: return
    //   944: aload 15
    //   946: aload_0
    //   947: invokeinterface 310 2 0
    //   952: ifeq +21 -> 973
    //   955: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   958: ifeq -65 -> 893
    //   961: ldc 125
    //   963: iconst_2
    //   964: ldc_w 312
    //   967: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   970: goto -77 -> 893
    //   973: aload 15
    //   975: invokeinterface 191 1 0
    //   980: bipush 30
    //   982: if_icmple +15 -> 997
    //   985: aload 14
    //   987: aload 6
    //   989: aload 15
    //   991: getstatic 80	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   994: invokestatic 314	com/tencent/mobileqq/app/PstnNumberManager:a	(Lcom/tencent/common/app/BaseApplicationImpl;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   997: aload_0
    //   998: iload_1
    //   999: aload 6
    //   1001: invokestatic 305	com/tencent/mobileqq/app/PstnNumberManager:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1004: goto -111 -> 893
    //   1007: astore 6
    //   1009: aload 4
    //   1011: astore_0
    //   1012: aload 5
    //   1014: astore 4
    //   1016: aload_0
    //   1017: astore 5
    //   1019: aload 6
    //   1021: astore_0
    //   1022: aload_2
    //   1023: ifnull +9 -> 1032
    //   1026: aload_2
    //   1027: invokeinterface 262 1 0
    //   1032: aload_3
    //   1033: ifnull +9 -> 1042
    //   1036: aload_3
    //   1037: invokeinterface 262 1 0
    //   1042: aload 4
    //   1044: ifnull +10 -> 1054
    //   1047: aload 4
    //   1049: invokeinterface 262 1 0
    //   1054: aload 5
    //   1056: ifnull +10 -> 1066
    //   1059: aload 5
    //   1061: invokeinterface 262 1 0
    //   1066: aload_0
    //   1067: athrow
    //   1068: astore_2
    //   1069: aload_2
    //   1070: invokevirtual 265	java/lang/Exception:printStackTrace	()V
    //   1073: goto -7 -> 1066
    //   1076: astore_0
    //   1077: aload 9
    //   1079: astore 5
    //   1081: aload 8
    //   1083: astore_3
    //   1084: aload 7
    //   1086: astore 4
    //   1088: aload 6
    //   1090: astore_2
    //   1091: goto -69 -> 1022
    //   1094: astore_0
    //   1095: aload 9
    //   1097: astore 5
    //   1099: goto -77 -> 1022
    //   1102: astore_0
    //   1103: aload 6
    //   1105: astore 5
    //   1107: goto -85 -> 1022
    //   1110: astore 8
    //   1112: aload_0
    //   1113: astore 5
    //   1115: aload_3
    //   1116: astore 6
    //   1118: aload 4
    //   1120: astore 7
    //   1122: aload 8
    //   1124: astore_0
    //   1125: aload_2
    //   1126: astore_3
    //   1127: aload 6
    //   1129: astore 4
    //   1131: aload 7
    //   1133: astore_2
    //   1134: goto -112 -> 1022
    //   1137: astore 5
    //   1139: aconst_null
    //   1140: astore_0
    //   1141: aconst_null
    //   1142: astore_2
    //   1143: aconst_null
    //   1144: astore_3
    //   1145: aconst_null
    //   1146: astore 4
    //   1148: goto -771 -> 377
    //   1151: astore 5
    //   1153: aconst_null
    //   1154: astore_0
    //   1155: aconst_null
    //   1156: astore 6
    //   1158: aconst_null
    //   1159: astore_3
    //   1160: aload_2
    //   1161: astore 4
    //   1163: aload 6
    //   1165: astore_2
    //   1166: goto -789 -> 377
    //   1169: astore 5
    //   1171: aconst_null
    //   1172: astore_0
    //   1173: aconst_null
    //   1174: astore 6
    //   1176: aload_2
    //   1177: astore 4
    //   1179: aload_3
    //   1180: astore_2
    //   1181: aload 6
    //   1183: astore_3
    //   1184: goto -807 -> 377
    //   1187: astore 5
    //   1189: aconst_null
    //   1190: astore_0
    //   1191: aload_2
    //   1192: astore 6
    //   1194: aload_3
    //   1195: astore_2
    //   1196: aload 4
    //   1198: astore_3
    //   1199: aload 6
    //   1201: astore 4
    //   1203: goto -826 -> 377
    //   1206: aload 5
    //   1208: astore 6
    //   1210: aconst_null
    //   1211: astore 7
    //   1213: aload 4
    //   1215: astore 5
    //   1217: aload 7
    //   1219: astore 4
    //   1221: goto -367 -> 854
    //   1224: aconst_null
    //   1225: astore 4
    //   1227: aconst_null
    //   1228: astore 7
    //   1230: aload 5
    //   1232: astore 6
    //   1234: aload 7
    //   1236: astore 5
    //   1238: goto -384 -> 854
    //   1241: astore_0
    //   1242: aload 5
    //   1244: astore 6
    //   1246: aload_2
    //   1247: astore 7
    //   1249: aload_3
    //   1250: astore_2
    //   1251: aload_0
    //   1252: astore 5
    //   1254: aload 4
    //   1256: astore_0
    //   1257: aload 6
    //   1259: astore_3
    //   1260: aload 7
    //   1262: astore 4
    //   1264: goto -887 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1267	0	paramString	String
    //   0	1267	1	paramInt	int
    //   70	957	2	localObject1	Object
    //   1068	2	2	localException	java.lang.Exception
    //   1090	161	2	localObject2	Object
    //   105	1155	3	localObject3	Object
    //   75	1188	4	localObject4	Object
    //   120	178	5	localObject5	Object
    //   360	146	5	localThrowable1	Throwable
    //   708	39	5	str1	String
    //   818	21	5	localThrowable2	Throwable
    //   844	270	5	localObject6	Object
    //   1137	1	5	localThrowable3	Throwable
    //   1151	1	5	localThrowable4	Throwable
    //   1169	1	5	localThrowable5	Throwable
    //   1187	20	5	localThrowable6	Throwable
    //   1215	38	5	localObject7	Object
    //   98	902	6	localObject8	Object
    //   1007	97	6	localObject9	Object
    //   1116	142	6	localObject10	Object
    //   95	1166	7	localObject11	Object
    //   91	991	8	localObject12	Object
    //   1110	13	8	localObject13	Object
    //   84	1012	9	localObject14	Object
    //   72	689	10	localCursor	android.database.Cursor
    //   78	534	11	localUri	Uri
    //   81	550	12	str2	String
    //   87	105	13	localObject15	Object
    //   58	928	14	localBaseApplicationImpl	BaseApplicationImpl
    //   67	923	15	localArrayList	java.util.ArrayList
    //   136	34	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   314	357	360	java/lang/Throwable
    //   399	406	437	java/lang/Exception
    //   410	416	437	java/lang/Exception
    //   420	426	437	java/lang/Exception
    //   430	436	437	java/lang/Exception
    //   769	815	818	java/lang/Throwable
    //   897	903	938	java/lang/Exception
    //   907	913	938	java/lang/Exception
    //   918	925	938	java/lang/Exception
    //   930	937	938	java/lang/Exception
    //   854	893	1007	finally
    //   944	970	1007	finally
    //   973	997	1007	finally
    //   997	1004	1007	finally
    //   1026	1032	1068	java/lang/Exception
    //   1036	1042	1068	java/lang/Exception
    //   1047	1054	1068	java/lang/Exception
    //   1059	1066	1068	java/lang/Exception
    //   100	106	1076	finally
    //   117	122	1076	finally
    //   133	138	1076	finally
    //   149	177	1076	finally
    //   206	215	1076	finally
    //   226	233	1076	finally
    //   244	260	1076	finally
    //   271	310	1076	finally
    //   453	459	1076	finally
    //   469	532	1076	finally
    //   542	552	1076	finally
    //   562	569	1076	finally
    //   579	584	1076	finally
    //   594	599	1076	finally
    //   609	639	1076	finally
    //   654	664	1076	finally
    //   674	682	1076	finally
    //   692	710	1076	finally
    //   720	760	1076	finally
    //   314	357	1094	finally
    //   769	815	1102	finally
    //   377	394	1110	finally
    //   100	106	1137	java/lang/Throwable
    //   117	122	1137	java/lang/Throwable
    //   133	138	1137	java/lang/Throwable
    //   149	177	1137	java/lang/Throwable
    //   206	215	1151	java/lang/Throwable
    //   226	233	1151	java/lang/Throwable
    //   244	260	1151	java/lang/Throwable
    //   271	310	1151	java/lang/Throwable
    //   453	459	1169	java/lang/Throwable
    //   469	532	1169	java/lang/Throwable
    //   542	552	1169	java/lang/Throwable
    //   562	569	1169	java/lang/Throwable
    //   579	584	1169	java/lang/Throwable
    //   594	599	1169	java/lang/Throwable
    //   609	639	1169	java/lang/Throwable
    //   654	664	1187	java/lang/Throwable
    //   674	682	1187	java/lang/Throwable
    //   692	710	1187	java/lang/Throwable
    //   720	760	1187	java/lang/Throwable
    //   854	893	1241	java/lang/Throwable
    //   944	970	1241	java/lang/Throwable
    //   973	997	1241	java/lang/Throwable
    //   997	1004	1241	java/lang/Throwable
  }
  
  private static void a(String paramString1, int paramInt, String paramString2)
  {
    String str2 = "update_fixed_location";
    String str1 = "callbackPhone_";
    if (paramInt != 2)
    {
      str2 = "update_float_location";
      str1 = "callbackPhone_f_";
    }
    Object localObject = SharedPreUtils.a(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    int i = (((SharedPreferences)localObject).getInt(str2, 0) + 1) % 6;
    String str3 = ((SharedPreferences)localObject).getString(str1 + i, "");
    if (QLog.isColorLevel()) {
      QLog.i("PstnNumberManager", 2, "numberType:" + paramInt + ",location:" + i + ",oldNum:" + str3 + ",newNum:" + paramString1);
    }
    if (!TextUtils.isEmpty(str3))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(str2, i);
      ((SharedPreferences.Editor)localObject).putString(str1 + i, paramString1);
      ((SharedPreferences.Editor)localObject).commit();
      a(null, paramString1, str3, paramString2);
    }
    do
    {
      return;
      a(paramString1);
    } while (!QLog.isColorLevel());
    QLog.i("PstnNumberManager", 2, "number from sp is empty");
  }
  
  private static boolean a()
  {
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (1 == BaseApplicationImpl.getContext().getSharedPreferences(str, 0).getInt("key_gray_switch_no_need_add_address", 0))
      {
        QLog.i("PstnNumberManager", 2, "updatePstnContact csBackPhoneNum gray switch break");
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    return false;
  }
  
  private static boolean a(List paramList)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    for (;;)
    {
      ContentValues localContentValues;
      Object localObject;
      long l;
      int i;
      try
      {
        localContentValues = new ContentValues();
        localObject = localBaseApplicationImpl.getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues);
        if (localObject == null) {
          return false;
        }
        l = ContentUris.parseId((Uri)localObject);
        localContentValues.clear();
        localContentValues.put("raw_contact_id", Long.valueOf(l));
        localContentValues.put("mimetype", "vnd.android.cursor.item/name");
        localContentValues.put("data1", jdField_b_of_type_JavaLangString);
        localBaseApplicationImpl.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
        localObject = SharedPreUtils.a(localBaseApplicationImpl.getRuntime().getAccount()).edit();
        i = 0;
        if (i < paramList.size())
        {
          String str = (String)paramList.get(i);
          if (TextUtils.isEmpty(str)) {
            break label392;
          }
          localContentValues.clear();
          localContentValues.put("raw_contact_id", Long.valueOf(l));
          localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
          localContentValues.put("data1", str);
          localContentValues.put("data2", Integer.valueOf(0));
          localContentValues.put("data3", jdField_c_of_type_JavaLangString);
          localBaseApplicationImpl.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
          if (i < 6) {
            ((SharedPreferences.Editor)localObject).putString("callbackPhone_" + i, str);
          } else {
            ((SharedPreferences.Editor)localObject).putString("callbackPhone_f_" + (i - 6), str);
          }
        }
      }
      catch (Throwable paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PstnNumberManager", 2, "insert default_number exception ", paramList);
        }
        return false;
      }
      ((SharedPreferences.Editor)localObject).commit();
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l));
      localContentValues.put("mimetype", "vnd.android.cursor.item/website");
      localContentValues.put("data1", "http://www.lightalk.com");
      localContentValues.put("data2", Integer.valueOf(1));
      localBaseApplicationImpl.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      if (QLog.isColorLevel()) {
        QLog.i("PstnNumberManager", 2, "insert default number");
      }
      return true;
      label392:
      i += 1;
    }
  }
  
  private static void b(BaseApplicationImpl paramBaseApplicationImpl, String paramString1, String paramString2)
  {
    BaseApplicationImpl localBaseApplicationImpl = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramBaseApplicationImpl = new ContentValues();
      paramBaseApplicationImpl.put("raw_contact_id", paramString2);
      paramBaseApplicationImpl.put("mimetype", "vnd.android.cursor.item/phone_v2");
      paramBaseApplicationImpl.put("data1", paramString1);
      paramBaseApplicationImpl.put("data2", Integer.valueOf(0));
      paramBaseApplicationImpl.put("data3", jdField_c_of_type_JavaLangString);
      localBaseApplicationImpl.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, paramBaseApplicationImpl);
    } while (!QLog.isColorLevel());
    QLog.i("PstnNumberManager", 2, "insert success,num:" + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PstnNumberManager
 * JD-Core Version:    0.7.0.1
 */