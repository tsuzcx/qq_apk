package com.huawei.hms.update.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;

public class UpdateProvider
  extends ContentProvider
{
  public static final String AUTHORITIES_SUFFIX = ".hms.update.provider";
  private static final String[] a = { "_display_name", "_size" };
  private static a b = new a();
  
  private static int a(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if (("w".equals(paramString)) || ("wt".equals(paramString))) {
      return 738197504;
    }
    if ("wa".equals(paramString)) {
      return 704643072;
    }
    if ("rw".equals(paramString)) {
      return 939524096;
    }
    if ("rwt".equals(paramString)) {
      return 1006632960;
    }
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }
  
  private static Object[] a(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] a(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  public static File getLocalFile(Context paramContext, String paramString)
  {
    b.a(paramContext.getApplicationContext());
    return b.a(paramString);
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    b.a(paramContext.getApplicationContext());
    return b.a(paramFile, paramString);
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported) {
      throw new SecurityException("Provider must not be exported");
    }
    if (!paramProviderInfo.grantUriPermissions) {
      throw new SecurityException("Provider must grant uri permissions");
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    b.a(getContext().getApplicationContext());
    if (b.a(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    if (getContext() == null) {
      paramUri = "application/octet-stream";
    }
    String str;
    do
    {
      return paramUri;
      b.a(getContext().getApplicationContext());
      paramUri = b.a(paramUri).getName();
      int i = paramUri.lastIndexOf('.');
      if (i < 0) {
        break;
      }
      paramUri = paramUri.substring(i + 1);
      str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      paramUri = str;
    } while (!TextUtils.isEmpty(str));
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    b.a(getContext().getApplicationContext());
    return ParcelFileDescriptor.open(b.a(paramUri), a(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    b.a(getContext().getApplicationContext());
    paramString1 = b.a(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = a;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      paramString2 = paramUri[j];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[i] = "_display_name";
        k = i + 1;
        paramArrayOfString1[i] = paramString1.getName();
        i = k;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ("_size".equals(paramString2))
      {
        paramArrayOfString2[i] = "_size";
        k = i + 1;
        paramArrayOfString1[i] = Long.valueOf(paramString1.length());
        i = k;
        continue;
        paramUri = a(paramArrayOfString2, i);
        paramArrayOfString1 = a(paramArrayOfString1, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramArrayOfString1);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.provider.UpdateProvider
 * JD-Core Version:    0.7.0.1
 */