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
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +43 -> 65
    //   25: aload_1
    //   26: astore_0
    //   27: aload_1
    //   28: invokeinterface 30 1 0
    //   33: ifeq +32 -> 65
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: aload_1
    //   40: ldc 18
    //   42: invokeinterface 34 2 0
    //   47: invokeinterface 38 2 0
    //   52: astore_2
    //   53: aload_1
    //   54: ifnull +9 -> 63
    //   57: aload_1
    //   58: invokeinterface 42 1 0
    //   63: aload_2
    //   64: areturn
    //   65: aload_1
    //   66: ifnull +9 -> 75
    //   69: aload_1
    //   70: invokeinterface 42 1 0
    //   75: aconst_null
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 45	java/lang/Exception:printStackTrace	()V
    //   86: aload_1
    //   87: ifnull -12 -> 75
    //   90: aload_1
    //   91: invokeinterface 42 1 0
    //   96: goto -21 -> 75
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: aload_0
    //   107: invokeinterface 42 1 0
    //   112: aload_1
    //   113: athrow
    //   114: astore_1
    //   115: goto -13 -> 102
    //   118: astore_2
    //   119: goto -39 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramUri	Uri
    //   0	122	2	paramString	String
    //   0	122	3	paramArrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   0	21	77	java/lang/Exception
    //   0	21	99	finally
    //   27	36	114	finally
    //   38	53	114	finally
    //   82	86	114	finally
    //   27	36	118	java/lang/Exception
    //   38	53	118	java/lang/Exception
  }
  
  private static String a(File paramFile)
  {
    Object localObject1 = null;
    try
    {
      paramFile = paramFile.getAbsolutePath();
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile, (BitmapFactory.Options)localObject2);
      localObject2 = ((BitmapFactory.Options)localObject2).outMimeType;
      if ((!((String)localObject2).contains("jpg")) && (!((String)localObject2).contains("gif")) && (!((String)localObject2).contains("png")))
      {
        paramFile = localObject1;
        if (!((String)localObject2).contains("jpeg")) {}
      }
      else
      {
        paramFile = "image/*";
      }
      return paramFile;
    }
    catch (Exception paramFile) {}
    return "*/*";
  }
  
  public static boolean a(Context paramContext, Uri paramUri)
  {
    paramContext = c(paramContext, paramUri);
    if (TextUtils.isEmpty(paramContext)) {
      throw new IllegalArgumentException("get image path is null");
    }
    paramContext = new File(paramContext);
    if (b(paramContext)) {}
    do
    {
      return false;
      paramContext = a(paramContext);
    } while ((TextUtils.isEmpty(paramContext)) || (!paramContext.startsWith("image/")));
    return true;
  }
  
  public static boolean b(Context paramContext, Uri paramUri)
  {
    paramContext = c(paramContext, paramUri);
    if (TextUtils.isEmpty(paramContext)) {
      throw new IllegalArgumentException("get video path is null");
    }
    paramUri = new File(paramContext);
    if (b(paramUri)) {
      return false;
    }
    paramContext = "*/*";
    paramUri = paramUri.getName();
    int i = paramUri.lastIndexOf(".");
    if (i < 0) {}
    while ((!TextUtils.isEmpty(paramContext)) && (paramContext.startsWith("video/")))
    {
      return true;
      paramUri = paramUri.substring(i);
      if ((!TextUtils.isEmpty(paramUri)) || (paramUri.length() >= 2))
      {
        paramContext = paramUri.substring(1).toLowerCase();
        paramContext = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramContext);
      }
    }
    return false;
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
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      i = 1;
      if ((i == 0) || (!DocumentsContract.isDocumentUri(paramContext, paramUri))) {
        break label234;
      }
      if (!"com.android.externalstorage.documents".equals(paramUri.getAuthority())) {
        break label95;
      }
      paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
      if ("primary".equalsIgnoreCase(paramContext[0])) {
        localObject1 = Environment.getExternalStorageDirectory() + "/" + paramContext[1];
      }
    }
    label95:
    label234:
    do
    {
      do
      {
        return localObject1;
        i = 0;
        break;
        if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority()))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          return a(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
        }
      } while (!"com.android.providers.media.documents".equals(paramUri.getAuthority()));
      localObject1 = DocumentsContract.getDocumentId(paramUri).split(":");
      Object localObject3 = localObject1[0];
      if ("image".equals(localObject3)) {
        paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      }
      for (;;)
      {
        return a(paramContext, paramUri, "_id=?", new String[] { localObject1[1] });
        if ("video".equals(localObject3))
        {
          paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        else
        {
          paramUri = localObject2;
          if ("audio".equals(localObject3)) {
            paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
          }
        }
      }
      if ("content".equalsIgnoreCase(paramUri.getScheme()))
      {
        if ("com.google.android.apps.photos.content".equals(paramUri.getAuthority())) {
          return paramUri.getLastPathSegment();
        }
        return a(paramContext, paramUri, null, null);
      }
    } while (!"file".equalsIgnoreCase(paramUri.getScheme()));
    return paramUri.getPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */