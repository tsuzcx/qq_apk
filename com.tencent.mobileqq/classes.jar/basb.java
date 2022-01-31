import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class basb
  extends baqn
{
  protected BaseApplicationImpl a;
  
  public basb(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private Bitmap a(basc parambasc)
  {
    int j = 0;
    Object localObject2;
    if (parambasc == null) {
      localObject2 = null;
    }
    for (;;)
    {
      return localObject2;
      int i = parambasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbWidth;
      int k = parambasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbHeight;
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localOptions.inDensity = 160;
        localOptions.inTargetDensity = 160;
        localOptions.inScreenDensity = 160;
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(parambasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localOptions);
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = b(localOptions, i, k);
        Object localObject1 = arsj.a(parambasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localOptions);
        k = aepi.a(135.0F, BaseApplicationImpl.getContext().getResources());
        if (localOptions.outHeight > localOptions.outWidth * 2.0F)
        {
          i = (int)((localOptions.outHeight - localOptions.outWidth * 2.0F) / 2.0F);
          localOptions.outHeight = ((int)(localOptions.outWidth * 2.0F));
        }
        for (;;)
        {
          localObject2 = Bitmap.createBitmap((Bitmap)localObject1, j, i, localOptions.outWidth, localOptions.outHeight);
          if (localOptions.outWidth <= k)
          {
            localObject1 = localObject2;
            if (localOptions.outHeight <= k) {}
          }
          else
          {
            localObject1 = bdhj.a((Bitmap)localObject2, k);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            break;
          }
          return new bazi(parambasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path).a((Bitmap)localObject1);
          if (localOptions.outWidth <= localOptions.outHeight * 2.0F) {
            break label361;
          }
          j = (int)((localOptions.outWidth - localOptions.outHeight * 2.0F) / 2.0F);
          localOptions.outWidth = ((int)(localOptions.outHeight * 2.0F));
          i = 0;
        }
      }
      catch (Exception parambasc)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "make Thumb ", parambasc);
        }
        return null;
      }
      catch (OutOfMemoryError parambasc)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("_dataline_file", 2, "make Thumb OOM ", parambasc);
            continue;
            label361:
            i = 0;
          }
        }
      }
    }
  }
  
  public basc a(URL paramURL)
  {
    try
    {
      basc localbasc = new basc(this);
      paramURL = paramURL.getFile().split("\\|");
      localbasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      localbasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramURL[0];
      localbasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbWidth = Integer.parseInt(paramURL[1]);
      localbasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbHeight = Integer.parseInt(paramURL[2]);
      localbasc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.modifiedDate = Long.parseLong(paramURL[3]);
      localbasc.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramURL[4]);
      return localbasc;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if (paramOutputStream != null) {
      return new File(paramOutputStream.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
    }
    return new File(alof.aW);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      if (paramOptions.outWidth * paramOptions.outHeight > 5000000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "calculateInSampleSize options.outWidth*options.outHeight=" + paramOptions.outWidth * paramOptions.outHeight);
        }
        j = 2;
      }
    }
    int k;
    int m;
    label95:
    do
    {
      do
      {
        return j;
        k = paramOptions.outHeight;
        m = paramOptions.outWidth;
        j = i;
      } while (k <= paramInt2);
      j = i;
    } while (m <= paramInt1);
    int n = Math.round(k / paramInt2);
    j = Math.round(m / paramInt1);
    if (n < j) {}
    for (;;)
    {
      j = i;
      if (n < 2) {
        break;
      }
      m /= 2;
      k /= 2;
      i *= 2;
      break label95;
      n = j;
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = AlbumThumbManager.getInstance(BaseApplicationImpl.getContext());
    Object localObject = new basd(this);
    localObject = paramURLDrawableHandler.getThumb(paramDownloadParams.url, (bazg)localObject);
    paramURLDrawableHandler = (URLDrawableHandler)localObject;
    if (localObject == null)
    {
      paramURLDrawableHandler = BaseApplicationImpl.getContext();
      int i = arrr.a(paramFile.getPath());
      paramURLDrawableHandler = a(paramURLDrawableHandler.getResources().getDrawable(arrr.a(i)));
    }
    paramDownloadParams = a(paramDownloadParams.url);
    paramFile = paramURLDrawableHandler;
    if (paramDownloadParams != null)
    {
      paramFile = paramURLDrawableHandler;
      if (paramDownloadParams.jdField_a_of_type_Boolean)
      {
        paramFile = bdhj.a(paramURLDrawableHandler, aepi.a(12.0F, BaseApplicationImpl.getContext().getResources()));
        paramURLDrawableHandler.recycle();
      }
    }
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basb
 * JD-Core Version:    0.7.0.1
 */