import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;

final class apcl
  implements apcx
{
  apcl(String paramString1, String paramString2) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    try
    {
      apdh.a(paramBitmap, this.a);
      paramBitmap.recycle();
      int i = ey.a(this.b);
      ey.a(this.a, i);
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramBitmap.getMessage());
      return;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramBitmap.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apcl
 * JD-Core Version:    0.7.0.1
 */