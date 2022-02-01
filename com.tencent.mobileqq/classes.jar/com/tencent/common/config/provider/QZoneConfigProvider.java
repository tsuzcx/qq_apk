package com.tencent.common.config.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;

public class QZoneConfigProvider
  extends ContentProvider
  implements QZoneConfigConst
{
  public static ConcurrentHashMap<String, QZConfigSqliteManager> a = new ConcurrentHashMap();
  private static final UriMatcher k = a();
  public Object j = new Object();
  
  private int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = b().d(paramString, paramArrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = b().a(paramUri, "table_qz_unread", paramArrayOfContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private static UriMatcher a()
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_configs", 1);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_cookie", 2);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_update", 3);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_isp_config", 4);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_delete", 6);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_check_time", 5);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_navigator_bar", 8);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "table_qz_unread", 9);
    return localUriMatcher;
  }
  
  private Cursor a(String[] paramArrayOfString)
  {
    return b().c(paramArrayOfString);
  }
  
  private Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return b().b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "cookie");
    paramUri = b().d(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private int b(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = b().a(paramUri, "qz_navigator_bar", paramArrayOfContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private Cursor b(String[] paramArrayOfString)
  {
    return b().a(paramArrayOfString);
  }
  
  private Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return b().c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "check_time");
    paramUri = b().e(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private QZConfigSqliteManager b()
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      if (!"Success".equals(BaseApplicationImpl.sInjectResult))
      {
        localObject1 = localObject2;
        localObject3 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(" sIsDexInjectFinish = ");
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(BaseApplicationImpl.sInjectResult);
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append("  isUserAllow = ");
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(PrivacyPolicyHelper.d());
        localObject1 = localObject2;
        QLog.e("QZoneConfigProvider", 1, ((StringBuilder)localObject3).toString());
        return null;
      }
      localObject1 = localObject2;
      if (BaseApplicationImpl.getApplication() != null)
      {
        localObject1 = localObject2;
        if (BaseApplicationImpl.getApplication().getRuntime() != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount()))
          {
            localObject1 = localObject2;
            localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            localObject1 = localObject2;
            if (a.get(localObject2) != null)
            {
              localObject1 = localObject2;
              return (QZConfigSqliteManager)a.get(localObject2);
            }
            localObject1 = localObject2;
            localObject3 = this.j;
            localObject1 = localObject2;
            try
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("new QZConfigSqliteManager  uin=");
              ((StringBuilder)localObject1).append(LogUtil.getSafePrintUin((String)localObject2));
              QLog.e("QZoneConfigProvider", 1, ((StringBuilder)localObject1).toString());
              localObject1 = new QZConfigSqliteManager(getContext(), (String)localObject2);
              a.put(localObject2, localObject1);
              return localObject1;
            }
            finally
            {
              localObject1 = localObject2;
            }
          }
        }
      }
      localObject1 = localObject2;
      Object localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append("  uin=");
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(LogUtil.getSafePrintUin(""));
      localObject1 = localObject2;
      QLog.e("QZoneConfigProvider", 1, new Object[] { "getmSqlManager", ((StringBuilder)localObject3).toString() });
      return null;
    }
    catch (Throwable localThrowable)
    {
      label288:
      break label288;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("  uin= ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.e("QZoneConfigProvider", 1, new Object[] { "getmSqlManager init erro", ((StringBuilder)localObject2).toString() });
    return null;
  }
  
  private Cursor c(String[] paramArrayOfString)
  {
    return b().b(paramArrayOfString);
  }
  
  private Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return b().a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "updatelog");
    paramUri = b().f(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor d(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return b().d(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = b().a(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = b().c(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = b().b(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri g(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = b().g(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = k.match(paramUri);
    if (i != 1)
    {
      if (i != 8)
      {
        if (i != 9)
        {
          QZLog.e("QZoneConfigProvider", 1, new Object[] { "uri:", paramUri, "not used right" });
          return 0;
        }
        return a(paramUri, paramArrayOfContentValues);
      }
      return b(paramUri, paramArrayOfContentValues);
    }
    return b().a(paramUri, "qz_configs", paramArrayOfContentValues);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (k.match(paramUri))
    {
    case 7: 
    default: 
      return 0;
    case 9: 
      return a(paramUri, paramString, paramArrayOfString);
    case 8: 
      return b().c(paramString, paramArrayOfString);
    case 6: 
      return b().g();
    case 5: 
      return b().e();
    case 4: 
      return b().b(paramString, paramArrayOfString);
    case 3: 
      return b().f();
    case 2: 
      return b().d();
    }
    return b().a(paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return "";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    int i = k.match(paramUri);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 8)
              {
                if (i != 9) {
                  return null;
                }
                return g(paramUri, paramContentValues);
              }
              return f(paramUri, paramContentValues);
            }
            return b(paramUri, paramContentValues);
          }
          return e(paramUri, paramContentValues);
        }
        return c(paramUri, paramContentValues);
      }
      return a(paramUri, paramContentValues);
    }
    return d(paramUri, paramContentValues);
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      int i = k.match(paramUri);
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                if (i != 8)
                {
                  if (i != 9) {
                    return null;
                  }
                  return d(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
                }
                return c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
              }
              return c(paramArrayOfString1);
            }
            return b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
          }
          return a(paramArrayOfString1);
        }
        return b(paramArrayOfString1);
      }
      paramUri = a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      return paramUri;
    }
    catch (Throwable paramUri)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneConfigProvider", 2, "query异常", paramUri);
      }
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.config.provider.QZoneConfigProvider
 * JD-Core Version:    0.7.0.1
 */