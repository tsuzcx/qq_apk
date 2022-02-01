package com.sina.weibo.sdk.c;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;

public final class b
{
  /* Error */
  private static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 14	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: iconst_1
    //   6: anewarray 16	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: ldc 18
    //   13: aastore
    //   14: aload_2
    //   15: aload_3
    //   16: aconst_null
    //   17: invokevirtual 24	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +47 -> 69
    //   25: aload_0
    //   26: astore_1
    //   27: aload_0
    //   28: invokeinterface 30 1 0
    //   33: ifeq +36 -> 69
    //   36: aload_0
    //   37: astore_1
    //   38: aload_0
    //   39: aload_0
    //   40: ldc 18
    //   42: invokeinterface 34 2 0
    //   47: invokeinterface 38 2 0
    //   52: astore_2
    //   53: aload_0
    //   54: ifnull +9 -> 63
    //   57: aload_0
    //   58: invokeinterface 42 1 0
    //   63: aload_2
    //   64: areturn
    //   65: astore_2
    //   66: goto +19 -> 85
    //   69: aload_0
    //   70: ifnull +31 -> 101
    //   73: goto +22 -> 95
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_1
    //   79: goto +25 -> 104
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_0
    //   86: astore_1
    //   87: aload_2
    //   88: invokevirtual 45	java/lang/Exception:printStackTrace	()V
    //   91: aload_0
    //   92: ifnull +9 -> 101
    //   95: aload_0
    //   96: invokeinterface 42 1 0
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: aload_1
    //   105: ifnull +9 -> 114
    //   108: aload_1
    //   109: invokeinterface 42 1 0
    //   114: aload_0
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramContext	Context
    //   0	116	1	paramUri	Uri
    //   0	116	2	paramString	String
    //   0	116	3	paramArrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   27	36	65	java/lang/Exception
    //   38	53	65	java/lang/Exception
    //   0	21	76	finally
    //   0	21	82	java/lang/Exception
    //   27	36	103	finally
    //   38	53	103	finally
    //   87	91	103	finally
  }
  
  private static String a(File paramFile)
  {
    try
    {
      paramFile = paramFile.getAbsolutePath();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile, localOptions);
      paramFile = localOptions.outMimeType;
      if ((!paramFile.contains("jpg")) && (!paramFile.contains("gif")) && (!paramFile.contains("png"))) {
        if (!paramFile.contains("jpeg")) {
          break label78;
        }
      }
      return "image/*";
    }
    catch (Exception paramFile)
    {
      label71:
      break label71;
    }
    return "*/*";
    label78:
    return null;
  }
  
  public static boolean a(Context paramContext, Uri paramUri)
  {
    paramContext = c(paramContext, paramUri);
    if (!TextUtils.isEmpty(paramContext))
    {
      paramContext = new File(paramContext);
      if (b(paramContext)) {
        return false;
      }
      paramContext = a(paramContext);
      return (!TextUtils.isEmpty(paramContext)) && (paramContext.startsWith("image/"));
    }
    throw new IllegalArgumentException("get image path is null");
  }
  
  public static boolean b(Context paramContext, Uri paramUri)
  {
    paramContext = c(paramContext, paramUri);
    if (!TextUtils.isEmpty(paramContext))
    {
      paramContext = new File(paramContext);
      if (b(paramContext)) {
        return false;
      }
      paramContext = paramContext.getName();
      int i = paramContext.lastIndexOf(".");
      if (i >= 0)
      {
        paramContext = paramContext.substring(i);
        if ((!TextUtils.isEmpty(paramContext)) || (paramContext.length() >= 2)) {}
      }
      else
      {
        paramContext = "*/*";
        break label94;
      }
      paramContext = paramContext.substring(1).toLowerCase();
      paramContext = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramContext);
      label94:
      return (!TextUtils.isEmpty(paramContext)) && (paramContext.startsWith("video/"));
    }
    throw new IllegalArgumentException("get video path is null");
  }
  
  private static boolean b(File paramFile)
  {
    File localFile = paramFile;
    if (paramFile.getParent() != null) {
      localFile = new File(paramFile.getParentFile().getCanonicalFile(), paramFile.getName());
    }
    return !localFile.getCanonicalFile().equals(localFile.getAbsoluteFile());
  }
  
  @TargetApi(19)
  private static String c(Context paramContext, Uri paramUri)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = null;
    if ((i != 0) && (DocumentsContract.isDocumentUri(paramContext, paramUri)))
    {
      if ("com.android.externalstorage.documents".equals(paramUri.getAuthority()))
      {
        paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
        if ("primary".equalsIgnoreCase(paramContext[0]))
        {
          paramUri = new StringBuilder();
          paramUri.append(Environment.getExternalStorageDirectory());
          paramUri.append("/");
          paramUri.append(paramContext[1]);
          return paramUri.toString();
        }
      }
      else
      {
        if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority()))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          return a(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
        }
        if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
        {
          String[] arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
          String str = arrayOfString[0];
          if ("image".equals(str))
          {
            paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
          }
          else if ("video".equals(str))
          {
            paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
          }
          else
          {
            paramUri = localObject;
            if ("audio".equals(str)) {
              paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
          }
          return a(paramContext, paramUri, "_id=?", new String[] { arrayOfString[1] });
        }
      }
    }
    else
    {
      if ("content".equalsIgnoreCase(paramUri.getScheme()))
      {
        if ("com.google.android.apps.photos.content".equals(paramUri.getAuthority())) {
          return paramUri.getLastPathSegment();
        }
        return a(paramContext, paramUri, null, null);
      }
      if ("file".equalsIgnoreCase(paramUri.getScheme())) {
        return paramUri.getPath();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */