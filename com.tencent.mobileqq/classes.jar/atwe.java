import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class atwe
{
  private static File a(String paramString1, String paramString2)
  {
    paramString1 = atvo.a(paramString1);
    atvo.a(paramString1);
    File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    localFile = new File(localFile.getAbsolutePath() + "/QQ/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString1 = new File(atvo.b(localFile.getAbsolutePath() + "/" + paramString1 + paramString2));
    try
    {
      paramString1.createNewFile();
      return paramString1;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private static String a(Uri paramUri)
  {
    Uri localUri = null;
    Object localObject = new String[1];
    localObject[0] = "_data";
    label81:
    for (;;)
    {
      try
      {
        paramUri = BaseApplicationImpl.getContext().getContentResolver().query(paramUri, (String[])localObject, null, null, null);
        if (paramUri != null) {}
        paramUri = null;
      }
      catch (Exception paramUri)
      {
        try
        {
          if (!paramUri.moveToFirst()) {
            break label81;
          }
          localObject = paramUri.getString(paramUri.getColumnIndexOrThrow(localObject[0]));
          paramUri = (Uri)localObject;
          localUri = paramUri;
          return localUri;
        }
        catch (Exception localException)
        {
          continue;
        }
        paramUri = paramUri;
        paramUri = null;
        if (paramUri != null)
        {
          paramUri.close();
          return null;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (!bgmg.b(paramString)) {
      paramString = null;
    }
    String str2;
    Object localObject4;
    String str1;
    Object localObject3;
    int i;
    Object localObject2;
    do
    {
      return paramString;
      str2 = atvo.a(paramString);
      localObject4 = "";
      Object localObject1 = localObject4;
      str1 = str2;
      localObject3 = localObject4;
      try
      {
        if (str2.indexOf('.') < 0)
        {
          localObject3 = localObject4;
          localObject1 = "." + bgmg.b(paramString);
          localObject3 = localObject1;
          str1 = str2 + (String)localObject1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("FilePathUtil<FileAssistant>", 1, "copyMediaFileToMediaStorage: get file ext error");
          localObject2 = localObject3;
          str1 = str2;
        }
        localObject3 = BaseApplicationImpl.getContext();
        str2 = beas.a((Context)localObject3, str1);
        int j = ff.a(paramString);
        localObject4 = new ContentValues();
        ((ContentValues)localObject4).put("title", str1);
        ((ContentValues)localObject4).put("_display_name", str1);
        ((ContentValues)localObject4).put("description", str1);
        ((ContentValues)localObject4).put("mime_type", str2);
        localObject2 = a(paramString, (String)localObject2);
        if (localObject2 != null) {
          continue;
        }
        return null;
        if (!new File(paramString).renameTo((File)localObject2)) {
          continue;
        }
        QLog.i("FilePathUtil<FileAssistant>", 1, "rename :" + paramString + " to:" + ((File)localObject2).getAbsolutePath());
        localObject2 = ((File)localObject2).getAbsolutePath();
        ((ContentValues)localObject4).put("_data", (String)localObject2);
        if (i != 0) {
          continue;
        }
        ((ContentValues)localObject4).put("datetaken", Long.valueOf(System.currentTimeMillis()));
        ((ContentValues)localObject4).put("orientation", Integer.valueOf(j));
        ((Context)localObject3).getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject4);
        return localObject2;
        paramString = (String)localObject2;
      }
      i = atvo.a(str1);
      if ((i != 2) && (i != 0))
      {
        QLog.w("FilePathUtil<FileAssistant>", 1, "unsupport type:" + i);
        return null;
      }
    } while (i != 2);
    long l = ShortVideoUtils.a((String)localObject2);
    ((ContentValues)localObject4).put("datetaken", Long.valueOf(System.currentTimeMillis()));
    ((ContentValues)localObject4).put("duration", Long.valueOf(l));
    ((Context)localObject3).getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject4);
    return localObject2;
  }
  
  public static boolean a(String paramString)
  {
    return bgmg.b(c(paramString));
  }
  
  public static String b(String paramString)
  {
    if (!bgmg.b(paramString)) {}
    Object localObject4;
    String str2;
    Object localObject2;
    int i;
    Object localObject1;
    int j;
    ContentValues localContentValues;
    do
    {
      return null;
      localObject4 = atvo.a(paramString);
      str2 = "";
      String str1 = str2;
      localObject3 = localObject4;
      localObject2 = str2;
      try
      {
        if (((String)localObject4).indexOf('.') < 0)
        {
          localObject2 = str2;
          str1 = "." + bgmg.b(paramString);
          localObject2 = str1;
          localObject3 = (String)localObject4 + str1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("FilePathUtil<FileAssistant>", 1, "copyMediaFileToMediaStorage: get file ext error");
          localObject1 = localObject2;
          localObject3 = localObject4;
        }
        localObject2 = BaseApplicationImpl.getContext();
        str2 = beas.a((Context)localObject2, (String)localObject3);
        j = ff.a(paramString);
        localContentValues = new ContentValues();
        localContentValues.put("title", (String)localObject3);
        localContentValues.put("_display_name", (String)localObject3);
        localContentValues.put("description", (String)localObject3);
        localContentValues.put("mime_type", str2);
        localObject4 = a(paramString, (String)localObject1);
      }
      i = atvo.a((String)localObject3);
      if ((i != 2) && (i != 0))
      {
        QLog.w("FilePathUtil<FileAssistant>", 1, "unsupport type:" + i);
        return null;
      }
    } while (localObject4 == null);
    Object localObject3 = ((File)localObject4).getAbsolutePath();
    localContentValues.put("_data", (String)localObject3);
    if (i == 0)
    {
      localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("orientation", Integer.valueOf(j));
      localObject1 = ((Context)localObject2).getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);
    }
    for (;;)
    {
      if (atwt.a((Context)localObject2, paramString, (Uri)localObject1))
      {
        paramString = ((File)localObject4).getAbsolutePath();
        localObject1 = new atwf();
        MediaScannerConnection.scanFile((Context)localObject2, new String[] { paramString }, new String[] { str2 }, (MediaScannerConnection.OnScanCompletedListener)localObject1);
      }
      return localObject3;
      if (i == 2)
      {
        long l = ShortVideoUtils.a(paramString);
        localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("duration", Long.valueOf(l));
        localObject1 = ((Context)localObject2).getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues);
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    return bgmg.a(c(paramString));
  }
  
  public static String c(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.startsWith("content"));
    return a(Uri.parse(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwe
 * JD-Core Version:    0.7.0.1
 */