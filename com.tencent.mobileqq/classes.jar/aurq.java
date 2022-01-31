import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

class aurq
  extends Handler
{
  aurq(aurm paramaurm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).getString("BUNDLE_KEY_FILE_PATH");; localObject = null)
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if ((paramMessage != null) && (localObject != null))
      {
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      try
      {
        localObject = new FileOutputStream((File)localObject);
        paramMessage.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
        ((FileOutputStream)localObject).flush();
        ((FileOutputStream)localObject).close();
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aurq
 * JD-Core Version:    0.7.0.1
 */