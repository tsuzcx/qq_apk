import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class bdbd
  extends AsyncTask<Void, Void, String>
{
  bdbc jdField_a_of_type_Bdbc;
  
  public bdbd(bday parambday, bdbc parambdbc)
  {
    this.jdField_a_of_type_Bdbc = parambdbc;
    bhnn.a();
  }
  
  private String a()
  {
    boolean bool2 = false;
    Object localObject4 = this.jdField_a_of_type_Bdbc.jdField_a_of_type_ArrayOfByte;
    Object localObject1 = this.jdField_a_of_type_Bdbc.jdField_a_of_type_JavaIoFile;
    bhnn.a();
    if (localObject1 == null) {
      return null;
    }
    int i;
    if (localObject4 != null)
    {
      i = aqql.a(this.jdField_a_of_type_Bday.jdField_a_of_type_Aqpp, this.jdField_a_of_type_Bday.jdField_a_of_type_Int, this.jdField_a_of_type_Bdbc.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.i(bday.b, 2, "[onPictureTaken] mirror=" + this.jdField_a_of_type_Bdbc.jdField_a_of_type_Boolean + " frontFlip=" + this.jdField_a_of_type_Bday.jdField_a_of_type_Aqpp.a().b() + " jpegRotation=" + i);
      }
    }
    for (;;)
    {
      try
      {
        boolean bool3 = bday.a(this.jdField_a_of_type_Bday, this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidHardwareCamera$Size.width, this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidHardwareCamera$Size.height, this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidGraphicsRect.height());
        boolean bool1 = bool2;
        if (this.jdField_a_of_type_Bdbc.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_Bday.jdField_a_of_type_Aqpp.a().b()) {
            bool1 = true;
          }
        }
        localObject4 = aqql.b((byte[])localObject4, this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidGraphicsRect, bool1, i);
        alwe.a("clip_rotate;");
        bhmq.b((Bitmap)localObject4, this.jdField_a_of_type_Bdbc.c, (File)localObject1);
        alwe.a(false, this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidHardwareCamera$Size.width, this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidHardwareCamera$Size.height, this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidGraphicsRect.height(), bool3, i, bool1);
        alwe.a("save jpg;");
        if (0 == 0) {}
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e(bday.b, 2, "[onPictureTaken] createBitmap failed orientation:" + this.jdField_a_of_type_Bdbc.jdField_a_of_type_Int + ", " + localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        aqql.a(null);
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        continue;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
        aqql.a(null);
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
        }
        continue;
      }
      finally
      {
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
          throw localObject2;
        }
        catch (IOException localIOException5)
        {
          localIOException5.printStackTrace();
          continue;
        }
        aqql.a(null);
        continue;
      }
      try
      {
        throw new NullPointerException();
        if ((localObject1 != null) && (0 != 0)) {}
        try
        {
          bhmq.a(BaseApplicationImpl.getContext(), ((File)localObject1).getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.i(bday.b, 2, "[onPictureTaken] saveBitmapFileAsJPEG to " + ((File)localObject1).getPath());
          }
          if (!((File)localObject1).exists()) {
            continue;
          }
          BaseApplicationImpl.sImageCache.put(((File)localObject1).getAbsolutePath() + "#short_video_camera_preview_cache", null);
        }
        catch (Exception localException)
        {
          QLog.e(bday.b, 2, "[onPictureTaken] saveBitmapFileAsJPEG failed: " + localException.getMessage());
          if (!localObject2.exists()) {
            break label660;
          }
          BaseApplicationImpl.sImageCache.put(localObject2.getAbsolutePath() + "#short_video_camera_preview_cache", null);
          continue;
          aqql.a(null);
          continue;
        }
        finally
        {
          if (!localObject2.exists()) {
            break label712;
          }
          BaseApplicationImpl.sImageCache.put(localObject2.getAbsolutePath() + "#short_video_camera_preview_cache", null);
          for (;;)
          {
            throw localObject5;
            aqql.a(null);
          }
          Object localObject3 = null;
          continue;
        }
        bhnn.a(bday.b, "TakePictureTask_writeTmpFile_needClip");
        if (((File)localObject1).exists())
        {
          localObject1 = ((File)localObject1).getAbsolutePath();
          return localObject1;
        }
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
  }
  
  private void a(File paramFile, byte[] paramArrayOfByte)
  {
    do
    {
      try
      {
        localFileOutputStream = new FileOutputStream(paramFile);
        paramFile.printStackTrace();
      }
      catch (Exception paramFile)
      {
        try
        {
          localFileOutputStream.write(paramArrayOfByte);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          return;
        }
        catch (Exception paramFile)
        {
          FileOutputStream localFileOutputStream;
          paramArrayOfByte = localFileOutputStream;
          continue;
        }
        paramFile = paramFile;
        paramArrayOfByte = null;
      }
    } while (paramArrayOfByte == null);
    try
    {
      paramArrayOfByte.close();
      return;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
      return;
    }
  }
  
  private String b()
  {
    int j = 0;
    byte[] arrayOfByte = this.jdField_a_of_type_Bdbc.jdField_a_of_type_ArrayOfByte;
    Object localObject = this.jdField_a_of_type_Bdbc.jdField_a_of_type_AndroidGraphicsRect;
    localObject = this.jdField_a_of_type_Bdbc.jdField_a_of_type_JavaIoFile;
    if (QLog.isColorLevel()) {
      QLog.i(bday.b, 2, "Do not clip photo");
    }
    bhnn.a();
    a((File)localObject, arrayOfByte);
    if (bdax.d(bdax.j)) {
      bhmq.a(((File)localObject).getAbsolutePath(), "Orientation", String.valueOf(6));
    }
    while (!bdax.d(bdax.k))
    {
      bhnn.a(bday.b, "TakePictureTask_writePhotoFile");
      if (!((File)localObject).exists()) {
        break;
      }
      return ((File)localObject).getAbsolutePath();
    }
    int i = j;
    switch (this.jdField_a_of_type_Bdbc.jdField_a_of_type_Int % 360)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      bhmq.a(((File)localObject).getAbsolutePath(), "Orientation", String.valueOf(i));
      break;
      i = 6;
      continue;
      i = 3;
      continue;
      i = 8;
    }
    return null;
  }
  
  protected String a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bdbc.d == 0) {
      return b();
    }
    if (this.jdField_a_of_type_Bdbc.d == 1) {
      return a();
    }
    return null;
  }
  
  protected void a(String paramString)
  {
    
    if (this.jdField_a_of_type_Bdbc.jdField_a_of_type_Amap != null)
    {
      this.jdField_a_of_type_Bdbc.jdField_a_of_type_Amap.a_(paramString);
      if ((paramString == null) && (QLog.isColorLevel())) {
        QLog.i(bday.b, 2, "Picture bitmap data error or output file not exist");
      }
    }
    bhnn.a(bday.b, "TakePictureTask_onPictureTokenCb");
    if (this.jdField_a_of_type_Bday.jdField_a_of_type_AndroidHardwareCamera != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bday.jdField_a_of_type_AndroidHardwareCamera.startPreview();
        this.jdField_a_of_type_Bday.jdField_a_of_type_Boolean = true;
        bhnn.a(bday.b, "TakePictureTask");
        return;
      }
      catch (RuntimeException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i(bday.b, 2, "[onPostExecute]mCamera is " + null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbd
 * JD-Core Version:    0.7.0.1
 */