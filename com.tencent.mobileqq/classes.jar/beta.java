import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class beta
  extends bera
{
  public beta(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("favimage", paramBaseApplicationImpl);
  }
  
  public static File a(URL paramURL)
  {
    paramURL = a(paramURL, new String[] { null });
    if (paramURL == null) {
      return null;
    }
    return new File(paramURL);
  }
  
  private static String a(URL paramURL, String[] paramArrayOfString)
  {
    Object localObject = paramURL.getFile();
    if (((String)localObject).startsWith("file/")) {
      paramURL = ((String)localObject).substring("file/".length());
    }
    do
    {
      do
      {
        return paramURL;
        if (((String)localObject).startsWith("file://")) {
          return ((String)localObject).substring(7);
        }
        paramURL = (URL)localObject;
      } while (!((String)localObject).startsWith("http"));
      paramURL = (URL)localObject;
      if (((String)localObject).startsWith("http/")) {
        paramURL = ((String)localObject).substring("http/".length());
      }
      localObject = paramURL.split("\\|");
    } while (localObject.length < 2);
    paramArrayOfString[0] = localObject[0];
    return localObject[1];
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = new String[1];
    paramOutputStream[0] = null;
    String str1 = a(paramDownloadParams.url, paramOutputStream);
    int i;
    Object localObject;
    if (paramOutputStream[0] != null)
    {
      if (new File(str1).exists()) {
        break label405;
      }
      i = 1;
      j = i;
      if (i == 0)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      }
    }
    label100:
    String str3;
    try
    {
      BitmapFactory.decodeFile(str1, (BitmapFactory.Options)localObject);
      i = ((BitmapFactory.Options)localObject).outHeight;
      j = ((BitmapFactory.Options)localObject).outWidth;
      if (j + i != 0) {
        break label411;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2;
        label405:
        label411:
        i = 1;
      }
    }
    int j = i;
    if (i != 0)
    {
      new File(str1).delete();
      j = i;
    }
    if ((j != 0) && (bhnv.g(this.a.getApplicationContext())))
    {
      localObject = paramDownloadParams.url;
      str2 = paramDownloadParams.urlStr;
      paramDownloadParams.url = new URL(paramOutputStream[0]);
      paramDownloadParams.urlStr = paramOutputStream[0];
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav", 4, "favimage download: " + paramOutputStream[0] + " -> " + str1);
      }
      str3 = str1 + ".tmp";
      paramOutputStream = new File(str3);
      if (paramOutputStream.exists()) {
        paramOutputStream.delete();
      }
      paramURLDrawableHandler.publishProgress(0);
    }
    for (;;)
    {
      try
      {
        paramOutputStream = new FileOutputStream(str3);
      }
      catch (Exception paramOutputStream)
      {
        File localFile;
        paramOutputStream = null;
      }
      try
      {
        new beuf().a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        paramOutputStream.close();
        paramURLDrawableHandler = new File(str3);
        localFile = new File(str1);
        if (!paramURLDrawableHandler.renameTo(localFile))
        {
          bhmi.a(paramURLDrawableHandler, localFile);
          paramURLDrawableHandler.delete();
        }
        bmky.a(this.a.waitAppRuntime(null), false, new File(str1).length());
        paramDownloadParams.url = ((URL)localObject);
        paramDownloadParams.urlStr = str2;
        paramOutputStream = new File(str1);
        if ((!paramOutputStream.exists()) || (paramOutputStream.length() <= 0L)) {
          break label452;
        }
        return paramOutputStream;
      }
      catch (Exception paramURLDrawableHandler)
      {
        break label428;
      }
      i = 0;
      break;
      i = 0;
      break label100;
      label428:
      if (paramOutputStream != null) {
        paramOutputStream.close();
      }
      new File(str3).delete();
    }
    label452:
    paramOutputStream.delete();
    QLog.e("qqfav.FavoriteImageDownloader", 1, "downloadImage|file not exist or empty. filepath=" + str1);
    throw new IOException("File not Found. url: " + paramDownloadParams.url);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject;
    if (paramFile == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      if (GifDrawable.isGifFile(paramFile)) {
        return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
      }
      if (5 == aunj.a(paramFile.getName()))
      {
        localObject = aunb.a(this.a, paramFile.getPath());
        if (localObject != null)
        {
          if ((localObject instanceof BitmapDrawable)) {
            return ((BitmapDrawable)localObject).getBitmap();
          }
          paramFile = Bitmap.createBitmap(((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight(), Bitmap.Config.RGB_565);
          paramDownloadParams = new Canvas(paramFile);
          ((Drawable)localObject).setBounds(0, 0, paramDownloadParams.getWidth(), paramDownloadParams.getHeight());
          ((Drawable)localObject).draw(paramDownloadParams);
          return paramFile;
        }
      }
      localObject = paramFile.getPath();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = BitmapFactory.decodeFile((String)localObject);
        }
        catch (OutOfMemoryError paramFile)
        {
          try
          {
            int i = ((Bitmap)localObject).getByteCount();
            if (i <= 20971520) {
              continue;
            }
            paramFile = super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
            return paramFile;
          }
          catch (Exception paramFile)
          {
            break label181;
          }
          catch (OutOfMemoryError paramFile)
          {
            break label170;
          }
          paramFile = paramFile;
          localObject = null;
          paramFile.printStackTrace();
          return localObject;
        }
        catch (Exception paramFile)
        {
          label170:
          localObject = null;
          label181:
          paramFile.printStackTrace();
          return localObject;
        }
      }
    }
    return null;
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beta
 * JD-Core Version:    0.7.0.1
 */