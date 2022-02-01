package com.tencent.mm.vfs;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class VFSFileProvider
  extends ContentProvider
{
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final Pattern PATH_SEPARATE = Pattern.compile("/");
  private String mAuthority;
  
  private static Uri contentUriToVfsUri(Uri paramUri)
  {
    Object localObject = paramUri.getPath();
    if (localObject != null)
    {
      if (((String)localObject).isEmpty()) {
        return null;
      }
      paramUri = (Uri)localObject;
      if (((String)localObject).startsWith("/")) {
        paramUri = ((String)localObject).substring(1);
      }
      String[] arrayOfString = PATH_SEPARATE.split(paramUri, 3);
      if (arrayOfString.length < 2) {
        return null;
      }
      localObject = new Uri.Builder();
      String str = arrayOfString[0];
      if (str.startsWith("@"))
      {
        if (arrayOfString.length < 3) {
          return null;
        }
        ((Uri.Builder)localObject).scheme(str.substring(1));
        if (arrayOfString[1].equals("@")) {
          ((Uri.Builder)localObject).authority(null);
        } else {
          ((Uri.Builder)localObject).authority(arrayOfString[1]);
        }
        ((Uri.Builder)localObject).path(arrayOfString[2]);
      }
      else
      {
        paramUri = paramUri.substring(str.length() + 1);
        ((Uri.Builder)localObject).scheme("wcf").authority(str).path(paramUri);
      }
      return ((Uri.Builder)localObject).build();
    }
    return null;
  }
  
  static Uri vfsUriToContentUri(Uri paramUri, String paramString)
  {
    Object localObject = paramUri.getScheme();
    if ((localObject != null) && (!((String)localObject).isEmpty()) && (!((String)localObject).equals("file")))
    {
      if (((String)localObject).equals("wcf"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramUri.getAuthority());
        ((StringBuilder)localObject).append(paramUri.getPath());
        paramUri = ((StringBuilder)localObject).toString();
      }
      else
      {
        String str = paramUri.getAuthority();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("@");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append('/');
        if (str != null)
        {
          localObject = str;
          if (!str.isEmpty()) {}
        }
        else
        {
          localObject = "@";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramUri.getPath());
        paramUri = localStringBuilder.toString();
      }
      return new Uri.Builder().scheme("content").authority(paramString).path(paramUri).build();
    }
    return null;
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!paramProviderInfo.exported)
    {
      if (paramProviderInfo.grantUriPermissions)
      {
        this.mAuthority = paramProviderInfo.authority;
        return;
      }
      throw new SecurityException("Provider must grant uri permissions");
    }
    throw new SecurityException("Provider must not be exported");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String getType(Uri paramUri)
  {
    Object localObject = contentUriToVfsUri(paramUri);
    if (localObject != null)
    {
      paramUri = ((Uri)localObject).getScheme();
      if ((paramUri != null) && (paramUri.equals("content")))
      {
        paramUri = getContext();
        if (paramUri != null) {
          return paramUri.getContentResolver().getType((Uri)localObject);
        }
      }
      paramUri = new VFSFile((Uri)localObject);
      int i = paramUri.getName().lastIndexOf('.');
      if (i >= 0)
      {
        paramUri = paramUri.getName().substring(i + 1);
        paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
        if (paramUri != null) {
          return paramUri;
        }
      }
      return "application/octet-stream";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No mapping found for ");
    ((StringBuilder)localObject).append(paramUri);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
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
    Object localObject = contentUriToVfsUri(paramUri);
    if (localObject != null)
    {
      localObject = FileSystemManager.instance().resolve((Uri)localObject);
      if (((FileSystemManager.Resolution)localObject).valid()) {
        try
        {
          paramUri = ((FileSystemManager.Resolution)localObject).fileSystem.openParcelFd(((FileSystemManager.Resolution)localObject).path, paramString);
          return paramUri;
        }
        catch (FileNotFoundException paramUri)
        {
          throw paramUri;
        }
      }
      paramString = new StringBuilder();
      paramString.append("File not found: ");
      paramString.append(paramUri);
      throw new FileNotFoundException(paramString.toString());
    }
    paramString = new StringBuilder();
    paramString.append("File not found: ");
    paramString.append(paramUri);
    throw new FileNotFoundException(paramString.toString());
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = contentUriToVfsUri(paramUri);
    if (paramString1 != null)
    {
      paramString1 = new VFSFile(paramString1);
      paramUri = paramArrayOfString1;
      if (paramArrayOfString1 == null) {
        paramUri = COLUMNS;
      }
      paramArrayOfString2 = new String[paramUri.length];
      paramArrayOfString1 = new Object[paramUri.length];
      int m = paramUri.length;
      int j = 0;
      int k;
      for (int i = 0; j < m; i = k)
      {
        paramString2 = paramUri[j];
        if ("_display_name".equals(paramString2))
        {
          paramArrayOfString2[i] = "_display_name";
          k = i + 1;
          paramArrayOfString1[i] = paramString1.getName();
        }
        for (i = k;; i = k)
        {
          k = i;
          break;
          k = i;
          if (!"_size".equals(paramString2)) {
            break;
          }
          paramArrayOfString2[i] = "_size";
          k = i + 1;
          paramArrayOfString1[i] = Long.valueOf(paramString1.length());
        }
        j += 1;
      }
      paramUri = (String[])Arrays.copyOf(paramArrayOfString2, i);
      paramArrayOfString1 = Arrays.copyOf(paramArrayOfString1, i);
      paramUri = new MatrixCursor(paramUri, 1);
      paramUri.addRow(paramArrayOfString1);
      return paramUri;
    }
    paramArrayOfString1 = new StringBuilder();
    paramArrayOfString1.append("No mapping found for ");
    paramArrayOfString1.append(paramUri);
    paramUri = new IllegalArgumentException(paramArrayOfString1.toString());
    for (;;)
    {
      throw paramUri;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileProvider
 * JD-Core Version:    0.7.0.1
 */