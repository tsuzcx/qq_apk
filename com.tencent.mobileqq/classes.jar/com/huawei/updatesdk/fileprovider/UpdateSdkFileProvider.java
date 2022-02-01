package com.huawei.updatesdk.fileprovider;

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

public class UpdateSdkFileProvider
  extends ContentProvider
{
  public static final String AUTHORITIES_SUFFIX = ".updateSdk.fileProvider";
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final String TAG = "UpdateSdkFileProvider";
  private static a mWStrategy;
  private String authority;
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (str == null) {
        break label40;
      }
      paramFile = new File(paramFile, str);
    }
    label40:
    for (;;)
    {
      i += 1;
      break;
      return paramFile;
    }
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static a createWiseDistPathStrategy(Context paramContext, String paramString)
  {
    try
    {
      if (mWStrategy == null)
      {
        mWStrategy = new b(paramString);
        if (paramContext.getFilesDir() != null)
        {
          paramContext = buildPath(paramContext.getFilesDir(), new String[] { "/" });
          mWStrategy.a("updatesdkapk", paramContext);
        }
      }
      paramContext = mWStrategy;
      return paramContext;
    }
    finally {}
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    createWiseDistPathStrategy(paramContext, paramString);
    return mWStrategy.a(paramFile);
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported) {
      throw new SecurityException("WiseDist Provider must not be exported");
    }
    if (!paramProviderInfo.grantUriPermissions) {
      throw new SecurityException("WiseDist Provider must grant uri permissions");
    }
    this.authority = paramProviderInfo.authority;
    createWiseDistPathStrategy(paramContext, paramProviderInfo.authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  public String getType(Uri paramUri)
  {
    if ((paramUri != null) && (!TextUtils.isEmpty(paramUri.toString())) && (paramUri.toString().endsWith("apk")))
    {
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension("apk");
      if (paramUri != null) {
        return paramUri;
      }
    }
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
    if (paramUri == null) {}
    while ((paramUri.getAuthority() == null) || (!paramUri.getAuthority().equals(this.authority))) {
      return null;
    }
    paramUri = mWStrategy.a(paramUri);
    if (!paramUri.getName().endsWith("apk"))
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("UpdateSdkFileProvider", "can not open this file.");
      return null;
    }
    return ParcelFileDescriptor.open(paramUri, 268435456);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = mWStrategy.a(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = COLUMNS;
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
        paramUri = copyOf(paramArrayOfString2, i);
        paramArrayOfString1 = copyOf(paramArrayOfString1, i);
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
 * Qualified Name:     com.huawei.updatesdk.fileprovider.UpdateSdkFileProvider
 * JD-Core Version:    0.7.0.1
 */