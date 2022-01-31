package com.tencent.common.config.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import xpa;
import xpb;

public class QZoneConfigProvider
  extends ContentProvider
  implements xpb
{
  private static final UriMatcher jdField_a_of_type_AndroidContentUriMatcher = ;
  private xpa jdField_a_of_type_Xpa;
  
  private int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = this.jdField_a_of_type_Xpa.d(paramString, paramArrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = this.jdField_a_of_type_Xpa.a(paramUri, "table_qz_unread", paramArrayOfContentValues);
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
    return this.jdField_a_of_type_Xpa.c(paramArrayOfString);
  }
  
  private Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.jdField_a_of_type_Xpa.b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "cookie");
    paramUri = this.jdField_a_of_type_Xpa.d(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private int b(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = this.jdField_a_of_type_Xpa.a(paramUri, "qz_navigator_bar", paramArrayOfContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private Cursor b(String[] paramArrayOfString)
  {
    return this.jdField_a_of_type_Xpa.a(paramArrayOfString);
  }
  
  private Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.jdField_a_of_type_Xpa.c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "check_time");
    paramUri = this.jdField_a_of_type_Xpa.e(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor c(String[] paramArrayOfString)
  {
    return this.jdField_a_of_type_Xpa.b(paramArrayOfString);
  }
  
  private Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.jdField_a_of_type_Xpa.a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "updatelog");
    paramUri = this.jdField_a_of_type_Xpa.f(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor d(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.jdField_a_of_type_Xpa.d(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.jdField_a_of_type_Xpa.a(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.jdField_a_of_type_Xpa.c(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.jdField_a_of_type_Xpa.b(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri g(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.jdField_a_of_type_Xpa.g(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    default: 
      QZLog.e("QZoneConfigProvider", 1, new Object[] { "uri:", paramUri, "not used right" });
      return 0;
    case 9: 
      return a(paramUri, paramArrayOfContentValues);
    case 8: 
      return b(paramUri, paramArrayOfContentValues);
    }
    return this.jdField_a_of_type_Xpa.a(paramUri, "qz_configs", paramArrayOfContentValues);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 7: 
    default: 
      return 0;
    case 1: 
      return this.jdField_a_of_type_Xpa.a(paramString, paramArrayOfString);
    case 2: 
      return this.jdField_a_of_type_Xpa.a();
    case 3: 
      return this.jdField_a_of_type_Xpa.c();
    case 4: 
      return this.jdField_a_of_type_Xpa.b(paramString, paramArrayOfString);
    case 6: 
      return this.jdField_a_of_type_Xpa.d();
    case 5: 
      return this.jdField_a_of_type_Xpa.b();
    case 8: 
      return this.jdField_a_of_type_Xpa.c(paramString, paramArrayOfString);
    }
    return a(paramUri, paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return "";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 6: 
    case 7: 
    default: 
      return null;
    case 1: 
      return d(paramUri, paramContentValues);
    case 2: 
      return a(paramUri, paramContentValues);
    case 3: 
      return c(paramUri, paramContentValues);
    case 4: 
      return e(paramUri, paramContentValues);
    case 5: 
      return b(paramUri, paramContentValues);
    case 8: 
      return f(paramUri, paramContentValues);
    }
    return g(paramUri, paramContentValues);
  }
  
  public boolean onCreate()
  {
    this.jdField_a_of_type_Xpa = new xpa(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
      {
      case 1: 
        return a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      }
    }
    catch (Throwable paramUri)
    {
      if (!QLog.isColorLevel()) {
        break label138;
      }
      QLog.e("QZoneConfigProvider", 2, "query异常", paramUri);
      return null;
    }
    return b(paramArrayOfString1);
    return a(paramArrayOfString1);
    return b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    return c(paramArrayOfString1);
    return c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    paramUri = d(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    return paramUri;
    label138:
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZoneConfigProvider
 * JD-Core Version:    0.7.0.1
 */