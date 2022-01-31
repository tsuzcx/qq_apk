package com.tencent.common.config.provider;

import NS_UNDEAL_COUNT.entrance_cfg;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class QZConfigProviderUtil
{
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: invokestatic 19	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 23	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 29	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 35	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +39 -> 57
    //   21: aload_2
    //   22: invokeinterface 41 1 0
    //   27: ifeq +30 -> 57
    //   30: aload_2
    //   31: aload_2
    //   32: ldc 43
    //   34: invokeinterface 47 2 0
    //   39: invokeinterface 51 2 0
    //   44: lstore_0
    //   45: aload_2
    //   46: ifnull +9 -> 55
    //   49: aload_2
    //   50: invokeinterface 54 1 0
    //   55: lload_0
    //   56: lreturn
    //   57: aload_2
    //   58: ifnull +9 -> 67
    //   61: aload_2
    //   62: invokeinterface 54 1 0
    //   67: lconst_0
    //   68: lreturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_2
    //   72: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +32 -> 107
    //   78: ldc 61
    //   80: iconst_2
    //   81: new 63	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   88: ldc 66
    //   90: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_3
    //   104: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_2
    //   108: ifnull -41 -> 67
    //   111: aload_2
    //   112: invokeinterface 54 1 0
    //   117: goto -50 -> 67
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +9 -> 133
    //   127: aload_2
    //   128: invokeinterface 54 1 0
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: goto -13 -> 123
    //   139: astore_3
    //   140: goto -17 -> 123
    //   143: astore_3
    //   144: goto -72 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	12	0	l	long
    //   16	112	2	localCursor	android.database.Cursor
    //   69	35	3	localException1	Exception
    //   120	14	3	localObject1	Object
    //   135	1	3	localObject2	Object
    //   139	1	3	localObject3	Object
    //   143	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	69	java/lang/Exception
    //   0	17	120	finally
    //   21	45	135	finally
    //   72	107	139	finally
    //   21	45	143	java/lang/Exception
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 19	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 23	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 84	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 35	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +55 -> 73
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokeinterface 41 1 0
    //   29: ifeq +44 -> 73
    //   32: aload_1
    //   33: astore_0
    //   34: new 86	java/lang/String
    //   37: dup
    //   38: aload_1
    //   39: aload_1
    //   40: ldc 88
    //   42: invokeinterface 47 2 0
    //   47: invokeinterface 92 2 0
    //   52: invokevirtual 96	java/lang/String:getBytes	()[B
    //   55: ldc 98
    //   57: invokespecial 101	java/lang/String:<init>	([BLjava/lang/String;)V
    //   60: astore_2
    //   61: aload_1
    //   62: ifnull +9 -> 71
    //   65: aload_1
    //   66: invokeinterface 54 1 0
    //   71: aload_2
    //   72: areturn
    //   73: aload_1
    //   74: ifnull +9 -> 83
    //   77: aload_1
    //   78: invokeinterface 54 1 0
    //   83: ldc 103
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +34 -> 128
    //   97: aload_1
    //   98: astore_0
    //   99: ldc 61
    //   101: iconst_2
    //   102: new 63	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   109: ldc 105
    //   111: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_2
    //   115: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_2
    //   125: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_1
    //   129: ifnull -46 -> 83
    //   132: aload_1
    //   133: invokeinterface 54 1 0
    //   138: goto -55 -> 83
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_0
    //   144: aload_0
    //   145: ifnull +9 -> 154
    //   148: aload_0
    //   149: invokeinterface 54 1 0
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: goto -13 -> 144
    //   160: astore_2
    //   161: goto -72 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	127	0	localCursor1	android.database.Cursor
    //   16	117	1	localCursor2	android.database.Cursor
    //   141	14	1	localObject1	Object
    //   156	1	1	localObject2	Object
    //   60	12	2	str	String
    //   86	39	2	localException1	Exception
    //   160	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	86	java/lang/Exception
    //   0	17	141	finally
    //   23	32	156	finally
    //   34	61	156	finally
    //   91	97	156	finally
    //   99	128	156	finally
    //   23	32	160	java/lang/Exception
    //   34	61	160	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 115	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokestatic 115	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   21: ifle -10 -> 11
    //   24: invokestatic 19	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   27: invokevirtual 23	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 117	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   33: aconst_null
    //   34: ldc 119
    //   36: iconst_2
    //   37: anewarray 86	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_1
    //   47: aastore
    //   48: aconst_null
    //   49: invokevirtual 35	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull +147 -> 201
    //   57: aload_1
    //   58: astore_0
    //   59: aload_1
    //   60: invokeinterface 41 1 0
    //   65: ifeq +136 -> 201
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: aload_1
    //   72: ldc 121
    //   74: invokeinterface 47 2 0
    //   79: invokeinterface 92 2 0
    //   84: astore_2
    //   85: aload_2
    //   86: astore_0
    //   87: aload_1
    //   88: ifnull +11 -> 99
    //   91: aload_1
    //   92: invokeinterface 54 1 0
    //   97: aload_2
    //   98: astore_0
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   106: aload_2
    //   107: astore_0
    //   108: goto -9 -> 99
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: astore_0
    //   116: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +21 -> 140
    //   122: aload_1
    //   123: astore_0
    //   124: ldc 61
    //   126: iconst_2
    //   127: aload_2
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: ldc 126
    //   136: aastore
    //   137: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   140: aload_1
    //   141: ifnull +55 -> 196
    //   144: aload_1
    //   145: invokeinterface 54 1 0
    //   150: aconst_null
    //   151: astore_0
    //   152: goto -53 -> 99
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   160: aconst_null
    //   161: astore_0
    //   162: goto -63 -> 99
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +9 -> 178
    //   172: aload_0
    //   173: invokeinterface 54 1 0
    //   178: aload_1
    //   179: athrow
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   185: goto -7 -> 178
    //   188: astore_1
    //   189: goto -21 -> 168
    //   192: astore_2
    //   193: goto -79 -> 114
    //   196: aconst_null
    //   197: astore_0
    //   198: goto -99 -> 99
    //   201: aconst_null
    //   202: astore_2
    //   203: goto -118 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramString1	String
    //   0	206	1	paramString2	String
    //   84	23	2	str	String
    //   111	17	2	localException1	Exception
    //   192	1	2	localException2	Exception
    //   202	1	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   91	97	101	java/lang/Exception
    //   24	53	111	java/lang/Exception
    //   144	150	155	java/lang/Exception
    //   24	53	165	finally
    //   172	178	180	java/lang/Exception
    //   59	68	188	finally
    //   70	85	188	finally
    //   116	122	188	finally
    //   124	140	188	finally
    //   59	68	192	java/lang/Exception
    //   70	85	192	java/lang/Exception
  }
  
  /* Error */
  public static Map a()
  {
    // Byte code:
    //   0: new 132	java/util/HashMap
    //   3: dup
    //   4: invokespecial 133	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: invokestatic 19	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 23	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 135	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 35	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +88 -> 114
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokeinterface 41 1 0
    //   37: ifeq +77 -> 114
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: new 86	java/lang/String
    //   46: dup
    //   47: aload_2
    //   48: aload_2
    //   49: ldc 137
    //   51: invokeinterface 47 2 0
    //   56: invokeinterface 92 2 0
    //   61: invokevirtual 96	java/lang/String:getBytes	()[B
    //   64: ldc 98
    //   66: invokespecial 101	java/lang/String:<init>	([BLjava/lang/String;)V
    //   69: new 86	java/lang/String
    //   72: dup
    //   73: aload_2
    //   74: aload_2
    //   75: ldc 121
    //   77: invokeinterface 47 2 0
    //   82: invokeinterface 92 2 0
    //   87: invokevirtual 96	java/lang/String:getBytes	()[B
    //   90: ldc 98
    //   92: invokespecial 101	java/lang/String:<init>	([BLjava/lang/String;)V
    //   95: invokeinterface 143 3 0
    //   100: pop
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: invokeinterface 146 1 0
    //   109: istore_0
    //   110: iload_0
    //   111: ifne -71 -> 40
    //   114: aload_2
    //   115: ifnull +9 -> 124
    //   118: aload_2
    //   119: invokeinterface 54 1 0
    //   124: aload_3
    //   125: areturn
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +34 -> 168
    //   137: aload_2
    //   138: astore_1
    //   139: ldc 61
    //   141: iconst_2
    //   142: new 63	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   149: ldc 148
    //   151: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_3
    //   155: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: aload_3
    //   165: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload_2
    //   169: ifnull +9 -> 178
    //   172: aload_2
    //   173: invokeinterface 54 1 0
    //   178: aconst_null
    //   179: areturn
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +9 -> 193
    //   187: aload_1
    //   188: invokeinterface 54 1 0
    //   193: aload_2
    //   194: athrow
    //   195: astore_2
    //   196: goto -13 -> 183
    //   199: astore_3
    //   200: goto -71 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   109	2	0	bool	boolean
    //   30	158	1	localCursor1	android.database.Cursor
    //   24	149	2	localCursor2	android.database.Cursor
    //   180	14	2	localObject1	Object
    //   195	1	2	localObject2	Object
    //   7	118	3	localHashMap	java.util.HashMap
    //   126	39	3	localException1	Exception
    //   199	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	25	126	java/lang/Exception
    //   8	25	180	finally
    //   31	40	195	finally
    //   42	101	195	finally
    //   103	110	195	finally
    //   131	137	195	finally
    //   139	168	195	finally
    //   31	40	199	java/lang/Exception
    //   42	101	199	java/lang/Exception
    //   103	110	199	java/lang/Exception
  }
  
  public static void a()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.d, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "database clear error" + localException.getMessage(), localException);
    }
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("check_time", Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("QZConfigProviderUtil", 2, "saveIspCheckTime time:" + paramLong);
    }
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.f, localContentValues);
      localContentValues.clear();
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localSQLException.getMessage(), localSQLException);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localException.getMessage(), localException);
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    String str;
    if (paramString == null)
    {
      str = "";
      localContentValues.put("cookie", str);
      QLog.i("ConfigProvider", 1, "saveConfigCookie cookie" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.b, localContentValues);
        if (paramString == null) {
          continue;
        }
        QLog.i("QZConfigProviderUtil", 1, paramString.toString() + " saveConfigCookie done.");
      }
      catch (SQLException paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      catch (Exception paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      localContentValues.clear();
      return;
      str = paramString;
      break;
      QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error!");
    }
  }
  
  public static void a(String paramString, ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      if (paramArrayList.size() != 0)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          a(paramString, (entrance_cfg)paramArrayList.next());
        }
      }
    }
  }
  
  public static void a(Map paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      if (!paramMap.isEmpty())
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          a(str, (String)paramMap.get(str));
        }
      }
    }
  }
  
  public static void a(Map paramMap, String paramString1, String paramString2, AppRuntime paramAppRuntime)
  {
    boolean bool = a(paramMap, paramString2);
    if ((b("PhotoUpload")) && (b("PhotoSvrList"))) {
      if (bool) {
        a(paramString1);
      }
    }
    for (;;)
    {
      a(paramString2);
      if (paramAppRuntime != null) {}
      try
      {
        if (((paramAppRuntime instanceof QQAppInterface)) && (paramAppRuntime.getLongAccountUin() != 0L))
        {
          paramMap = QzoneConfig.getInstance().getConfig("QZoneSetting", "Qzone_clearCacheVersion", "");
          if ((!TextUtils.isEmpty(paramMap)) && (!LocalMultiProcConfig.getString4Uin("Qzone_clearCacheVersion", "", paramAppRuntime.getLongAccountUin()).equals(paramMap)))
          {
            QZoneHelper.a(paramAppRuntime, true);
            LocalMultiProcConfig.putString4Uin("Qzone_clearCacheVersion", paramMap, paramAppRuntime.getLongAccountUin());
          }
        }
        return;
      }
      catch (Exception paramMap)
      {
        QLog.e("QZConfigProviderUtil", 1, paramMap.getMessage());
      }
      a("");
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("updatelog", paramString);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.c, localContentValues);
      return true;
    }
    catch (SQLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  private static boolean a(String paramString, entrance_cfg paramentrance_cfg)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    String str;
    do
    {
      do
      {
        return false;
      } while ((paramentrance_cfg == null) || (paramentrance_cfg.iEntranceId < 0) || (paramentrance_cfg.iEntranceId > 999));
      str = paramString.replace(" ", "");
      QZLog.e("QZConfigProviderUtil", 2, new Object[] { "********* insertNavigatorConfigItem ******** rsp return navigator item id:", Integer.valueOf(paramentrance_cfg.iEntranceId), " item name: ", paramentrance_cfg.sEntranceName, " item icon: ", paramentrance_cfg.sEntranceIcon, " item action: ", paramentrance_cfg.sEntranceAction });
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramentrance_cfg.sEntranceName)));
    paramString = new ContentValues();
    paramString.put("uin", str + "&" + paramentrance_cfg.iEntranceId);
    paramString.put("entraceid", Integer.valueOf(paramentrance_cfg.iEntranceId));
    paramString.put("entracename", paramentrance_cfg.sEntranceName);
    paramString.put("entraceicon", paramentrance_cfg.sEntranceIcon);
    paramString.put("entraceaction", paramentrance_cfg.sEntranceAction);
    paramString.put("isDefault", Integer.valueOf(paramentrance_cfg.isDefualt));
    paramString.put("tabid", Integer.valueOf(paramentrance_cfg.tabid));
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.g, paramString);
      return true;
    }
    catch (SQLException paramentrance_cfg)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramentrance_cfg.getMessage(), paramentrance_cfg);
      }
      return false;
    }
    catch (Exception paramentrance_cfg)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramentrance_cfg.getMessage(), paramentrance_cfg);
      }
      return false;
    }
    finally
    {
      paramString.clear();
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.getTrimmedLength(paramString1) <= 0)) {}
    while ((paramString2 == null) || (TextUtils.getTrimmedLength(paramString2) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString1);
    localContentValues.put("value", paramString2);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.e, localContentValues);
      return true;
    }
    catch (SQLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  /* Error */
  public static boolean a(String paramString, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 115	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokevirtual 393	java/util/ArrayList:clear	()V
    //   21: aload_0
    //   22: ldc_w 325
    //   25: ldc 103
    //   27: invokevirtual 329	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   30: astore_0
    //   31: new 63	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 395
    //   41: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 397
    //   51: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_0
    //   58: invokestatic 19	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   61: invokevirtual 23	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   64: getstatic 387	com/tencent/common/config/provider/QZoneConfigProvider:g	Landroid/net/Uri;
    //   67: aconst_null
    //   68: aload_0
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 35	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore_0
    //   75: aload_0
    //   76: ifnull +161 -> 237
    //   79: aload_0
    //   80: invokeinterface 41 1 0
    //   85: ifeq +152 -> 237
    //   88: aload_1
    //   89: new 233	NS_UNDEAL_COUNT/entrance_cfg
    //   92: dup
    //   93: aload_0
    //   94: aload_0
    //   95: ldc_w 366
    //   98: invokeinterface 47 2 0
    //   103: invokeinterface 401 2 0
    //   108: new 86	java/lang/String
    //   111: dup
    //   112: aload_0
    //   113: aload_0
    //   114: ldc_w 371
    //   117: invokeinterface 47 2 0
    //   122: invokeinterface 92 2 0
    //   127: invokevirtual 96	java/lang/String:getBytes	()[B
    //   130: ldc 98
    //   132: invokespecial 101	java/lang/String:<init>	([BLjava/lang/String;)V
    //   135: new 86	java/lang/String
    //   138: dup
    //   139: aload_0
    //   140: aload_0
    //   141: ldc_w 373
    //   144: invokeinterface 47 2 0
    //   149: invokeinterface 92 2 0
    //   154: invokevirtual 96	java/lang/String:getBytes	()[B
    //   157: ldc 98
    //   159: invokespecial 101	java/lang/String:<init>	([BLjava/lang/String;)V
    //   162: new 86	java/lang/String
    //   165: dup
    //   166: aload_0
    //   167: aload_0
    //   168: ldc_w 375
    //   171: invokeinterface 47 2 0
    //   176: invokeinterface 92 2 0
    //   181: invokevirtual 96	java/lang/String:getBytes	()[B
    //   184: ldc 98
    //   186: invokespecial 101	java/lang/String:<init>	([BLjava/lang/String;)V
    //   189: aload_0
    //   190: aload_0
    //   191: ldc_w 377
    //   194: invokeinterface 47 2 0
    //   199: invokeinterface 401 2 0
    //   204: aload_0
    //   205: aload_0
    //   206: ldc_w 382
    //   209: invokeinterface 47 2 0
    //   214: invokeinterface 401 2 0
    //   219: invokespecial 404	NS_UNDEAL_COUNT/entrance_cfg:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   222: invokevirtual 407	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   225: pop
    //   226: aload_0
    //   227: invokeinterface 146 1 0
    //   232: istore_2
    //   233: iload_2
    //   234: ifne -146 -> 88
    //   237: aload_0
    //   238: ifnull -227 -> 11
    //   241: aload_0
    //   242: invokeinterface 54 1 0
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_0
    //   252: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq +33 -> 288
    //   258: ldc 61
    //   260: iconst_2
    //   261: new 63	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 409
    //   271: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_1
    //   275: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: aload_1
    //   285: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: aload_0
    //   289: ifnull -278 -> 11
    //   292: aload_0
    //   293: invokeinterface 54 1 0
    //   298: iconst_0
    //   299: ireturn
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_0
    //   303: aload_0
    //   304: ifnull +9 -> 313
    //   307: aload_0
    //   308: invokeinterface 54 1 0
    //   313: aload_1
    //   314: athrow
    //   315: astore_1
    //   316: goto -13 -> 303
    //   319: astore_1
    //   320: goto -17 -> 303
    //   323: astore_1
    //   324: goto -72 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramString	String
    //   0	327	1	paramArrayList	ArrayList
    //   232	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   58	75	249	java/lang/Exception
    //   58	75	300	finally
    //   79	88	315	finally
    //   88	233	315	finally
    //   252	288	319	finally
    //   79	88	323	java/lang/Exception
    //   88	233	323	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(Map paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 411 1 0
    //   6: invokestatic 19	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: invokevirtual 23	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   12: getstatic 117	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 35	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +310 -> 336
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: invokeinterface 146 1 0
    //   39: ifeq +170 -> 209
    //   42: aload 4
    //   44: astore_3
    //   45: aload 4
    //   47: iconst_0
    //   48: invokeinterface 92 2 0
    //   53: astore 7
    //   55: aload 4
    //   57: astore_3
    //   58: aload 4
    //   60: iconst_1
    //   61: invokeinterface 92 2 0
    //   66: astore 8
    //   68: aload 7
    //   70: ifnull -41 -> 29
    //   73: aload 8
    //   75: ifnull -46 -> 29
    //   78: aload 4
    //   80: astore_3
    //   81: aload 4
    //   83: iconst_2
    //   84: invokeinterface 92 2 0
    //   89: astore 9
    //   91: aload 4
    //   93: astore_3
    //   94: aload_0
    //   95: aload 7
    //   97: invokeinterface 251 2 0
    //   102: checkcast 413	java/util/concurrent/ConcurrentHashMap
    //   105: astore 6
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: ifnonnull +29 -> 142
    //   116: aload 4
    //   118: astore_3
    //   119: new 413	java/util/concurrent/ConcurrentHashMap
    //   122: dup
    //   123: invokespecial 414	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   126: astore 5
    //   128: aload 4
    //   130: astore_3
    //   131: aload_0
    //   132: aload 7
    //   134: aload 5
    //   136: invokeinterface 143 3 0
    //   141: pop
    //   142: aload 5
    //   144: ifnull -115 -> 29
    //   147: aload 4
    //   149: astore_3
    //   150: aload 5
    //   152: aload 8
    //   154: aload 9
    //   156: invokevirtual 415	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: goto -131 -> 29
    //   163: astore_0
    //   164: aload 4
    //   166: astore_3
    //   167: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +23 -> 193
    //   173: aload 4
    //   175: astore_3
    //   176: ldc 61
    //   178: iconst_2
    //   179: aload_0
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: ldc_w 417
    //   189: aastore
    //   190: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   193: aload 4
    //   195: ifnull +139 -> 334
    //   198: aload 4
    //   200: invokeinterface 54 1 0
    //   205: iconst_0
    //   206: istore_2
    //   207: iload_2
    //   208: ireturn
    //   209: iconst_1
    //   210: istore_1
    //   211: iload_1
    //   212: istore_2
    //   213: aload 4
    //   215: ifnull -8 -> 207
    //   218: aload 4
    //   220: invokeinterface 54 1 0
    //   225: iload_1
    //   226: ireturn
    //   227: astore_0
    //   228: iload_1
    //   229: istore_2
    //   230: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -26 -> 207
    //   236: ldc 61
    //   238: iconst_2
    //   239: aload_0
    //   240: iconst_1
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: ldc_w 417
    //   249: aastore
    //   250: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   253: iload_1
    //   254: ireturn
    //   255: astore_0
    //   256: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +20 -> 279
    //   262: ldc 61
    //   264: iconst_2
    //   265: aload_0
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: ldc_w 417
    //   275: aastore
    //   276: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_3
    //   284: aload_3
    //   285: ifnull +9 -> 294
    //   288: aload_3
    //   289: invokeinterface 54 1 0
    //   294: aload_0
    //   295: athrow
    //   296: astore_3
    //   297: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq -6 -> 294
    //   303: ldc 61
    //   305: iconst_2
    //   306: aload_3
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: ldc_w 417
    //   316: aastore
    //   317: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   320: goto -26 -> 294
    //   323: astore_0
    //   324: goto -40 -> 284
    //   327: astore_0
    //   328: aconst_null
    //   329: astore 4
    //   331: goto -167 -> 164
    //   334: iconst_0
    //   335: ireturn
    //   336: iconst_0
    //   337: istore_1
    //   338: goto -127 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramMap	Map
    //   210	128	1	bool1	boolean
    //   206	24	2	bool2	boolean
    //   31	258	3	localCursor1	android.database.Cursor
    //   296	11	3	localException	Exception
    //   22	308	4	localCursor2	android.database.Cursor
    //   109	42	5	localConcurrentHashMap1	java.util.concurrent.ConcurrentHashMap
    //   105	7	6	localConcurrentHashMap2	java.util.concurrent.ConcurrentHashMap
    //   53	80	7	str1	String
    //   66	87	8	str2	String
    //   89	66	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   32	42	163	java/lang/Exception
    //   45	55	163	java/lang/Exception
    //   58	68	163	java/lang/Exception
    //   81	91	163	java/lang/Exception
    //   94	107	163	java/lang/Exception
    //   119	128	163	java/lang/Exception
    //   131	142	163	java/lang/Exception
    //   150	160	163	java/lang/Exception
    //   218	225	227	java/lang/Exception
    //   198	205	255	java/lang/Exception
    //   0	24	281	finally
    //   288	294	296	java/lang/Exception
    //   32	42	323	finally
    //   45	55	323	finally
    //   58	68	323	finally
    //   81	91	323	finally
    //   94	107	323	finally
    //   119	128	323	finally
    //   131	142	323	finally
    //   150	160	323	finally
    //   167	173	323	finally
    //   176	193	323	finally
    //   0	24	327	java/lang/Exception
  }
  
  private static boolean a(Map paramMap, String paramString)
  {
    if (paramMap == null) {}
    while (paramMap.isEmpty()) {
      return false;
    }
    paramString = paramMap.keySet();
    QZLog.i("QZConfigProviderUtil", 1, new Object[] { "saveConfig mainkey count:", Integer.valueOf(paramString.size()) });
    localArrayList = new ArrayList();
    Iterator localIterator1 = paramString.iterator();
    while (localIterator1.hasNext())
    {
      paramString = (String)localIterator1.next();
      Object localObject1 = (byte[])paramMap.get(paramString);
      if ((paramString != null) && (localObject1 != null) && (localObject1.length > 0))
      {
        QZLog.i("QZConfigProviderUtil", 1, new Object[] { "saveConfig mainKey:", paramString });
        QzoneConfig.getInstance().deleteConfigs(paramString);
        UniAttribute localUniAttribute = new UniAttribute();
        localUniAttribute.setEncodeName("utf-8");
        localUniAttribute.decode((byte[])localObject1);
        Iterator localIterator2 = localUniAttribute.getKeySet().iterator();
        while (localIterator2.hasNext())
        {
          Object localObject2 = (String)localIterator2.next();
          String str = (String)localUniAttribute.get((String)localObject2);
          localObject1 = paramString;
          if (localObject2 != null)
          {
            if (QLog.isColorLevel()) {
              QZLog.i("QZConfigProviderUtil", 2, new Object[] { " main key:", paramString, " second key:", localObject2, " value:", str });
            }
            localObject1 = paramString.toLowerCase();
            paramString = ((String)localObject2).toLowerCase();
            localObject2 = new ContentValues();
            ((ContentValues)localObject2).put("main_key", (String)localObject1);
            ((ContentValues)localObject2).put("second_key", paramString);
            ((ContentValues)localObject2).put("value", str);
            QzoneConfig.getInstance().updateOneConfig((String)localObject1, paramString, str);
            localArrayList.add(localObject2);
          }
          paramString = (String)localObject1;
        }
        try
        {
          BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.a, "main_key=?", new String[] { paramString });
          if (QLog.isColorLevel()) {
            QZLog.i("QZConfigProviderUtil", 4, new Object[] { "deleteConfig: ", paramString });
          }
        }
        catch (Exception paramString)
        {
          QZLog.e("QZConfigProviderUtil", 1, paramString, new Object[] { "deleteConfig error:" });
        }
      }
    }
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.a, (ContentValues[])localArrayList.toArray(new ContentValues[localArrayList.size()]));
      localArrayList.clear();
      bool = true;
    }
    catch (SQLException paramMap)
    {
      for (;;)
      {
        QZLog.e("QZConfigProviderUtil", 1, paramMap, new Object[] { "saveConfig error:" });
        localArrayList.clear();
        bool = false;
      }
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        QZLog.e("QZConfigProviderUtil", 1, paramMap, new Object[] { "saveConfig error:" });
        localArrayList.clear();
        boolean bool = false;
      }
    }
    finally
    {
      localArrayList.clear();
    }
    return bool;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: invokestatic 19	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 23	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 317	com/tencent/common/config/provider/QZoneConfigProvider:c	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 35	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +128 -> 146
    //   21: aload_0
    //   22: astore_1
    //   23: aload_0
    //   24: invokeinterface 41 1 0
    //   29: ifeq +117 -> 146
    //   32: aload_0
    //   33: astore_1
    //   34: aload_0
    //   35: aload_0
    //   36: ldc_w 314
    //   39: invokeinterface 47 2 0
    //   44: invokeinterface 92 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +9 -> 62
    //   56: aload_0
    //   57: invokeinterface 54 1 0
    //   62: aload_1
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +35 -> 107
    //   75: aload_0
    //   76: astore_1
    //   77: ldc 61
    //   79: iconst_2
    //   80: new 63	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 484
    //   90: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_2
    //   94: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: ifnull +35 -> 143
    //   111: aload_0
    //   112: invokeinterface 54 1 0
    //   117: ldc 103
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +9 -> 133
    //   127: aload_1
    //   128: invokeinterface 54 1 0
    //   133: aload_0
    //   134: athrow
    //   135: astore_0
    //   136: goto -13 -> 123
    //   139: astore_2
    //   140: goto -73 -> 67
    //   143: ldc 103
    //   145: areturn
    //   146: ldc 103
    //   148: astore_1
    //   149: goto -97 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	96	0	localCursor	android.database.Cursor
    //   120	14	0	localObject1	Object
    //   135	1	0	localObject2	Object
    //   22	127	1	localObject3	Object
    //   49	2	2	str	String
    //   64	40	2	localException1	Exception
    //   139	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	64	java/lang/Exception
    //   0	17	120	finally
    //   23	32	135	finally
    //   34	50	135	finally
    //   69	75	135	finally
    //   77	107	135	finally
    //   23	32	139	java/lang/Exception
    //   34	50	139	java/lang/Exception
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 19	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 23	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 117	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   9: iconst_1
    //   10: anewarray 86	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 486
    //   18: aastore
    //   19: ldc_w 488
    //   22: iconst_1
    //   23: anewarray 86	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: aastore
    //   30: aconst_null
    //   31: invokevirtual 35	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +175 -> 213
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokeinterface 491 1 0
    //   51: istore_1
    //   52: iload_1
    //   53: ifne +27 -> 80
    //   56: iconst_0
    //   57: istore_1
    //   58: iload_1
    //   59: istore_2
    //   60: aload 4
    //   62: ifnull +12 -> 74
    //   65: aload 4
    //   67: invokeinterface 54 1 0
    //   72: iload_1
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +122 -> 197
    //   78: iconst_1
    //   79: ireturn
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: invokeinterface 41 1 0
    //   90: pop
    //   91: aload 4
    //   93: astore_3
    //   94: aload 4
    //   96: iconst_0
    //   97: invokeinterface 401 2 0
    //   102: istore_1
    //   103: goto -45 -> 58
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +48 -> 165
    //   120: aload 4
    //   122: astore_3
    //   123: ldc 61
    //   125: iconst_2
    //   126: new 63	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 493
    //   136: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 495
    //   146: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload 5
    //   162: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload 4
    //   167: ifnull +41 -> 208
    //   170: aload 4
    //   172: invokeinterface 54 1 0
    //   177: iconst_0
    //   178: istore_2
    //   179: goto -105 -> 74
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull +9 -> 195
    //   189: aload_3
    //   190: invokeinterface 54 1 0
    //   195: aload_0
    //   196: athrow
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_0
    //   200: goto -15 -> 185
    //   203: astore 5
    //   205: goto -94 -> 111
    //   208: iconst_0
    //   209: istore_2
    //   210: goto -136 -> 74
    //   213: iconst_0
    //   214: istore_1
    //   215: goto -157 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString	String
    //   51	164	1	i	int
    //   59	151	2	j	int
    //   43	147	3	localCursor1	android.database.Cursor
    //   34	137	4	localCursor2	android.database.Cursor
    //   106	55	5	localException1	Exception
    //   203	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	36	106	java/lang/Exception
    //   0	36	182	finally
    //   44	52	199	finally
    //   83	91	199	finally
    //   94	103	199	finally
    //   114	120	199	finally
    //   123	165	199	finally
    //   44	52	203	java/lang/Exception
    //   83	91	203	java/lang/Exception
    //   94	103	203	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZConfigProviderUtil
 * JD-Core Version:    0.7.0.1
 */