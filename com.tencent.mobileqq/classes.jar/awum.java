import android.graphics.Bitmap;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;

class awum
  extends awuh
{
  awum(awul paramawul, long paramLong)
  {
    super(paramLong);
  }
  
  public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask)
  {
    paramUploadImageSize = awug.a(paramAbstractUploadTask.uploadFilePath);
    if (paramUploadImageSize != null)
    {
      paramAbstractUploadTask = new IUploadConfig.UploadImageSize(paramUploadImageSize.getWidth(), paramUploadImageSize.getHeight(), 100);
      paramUploadImageSize.recycle();
      return paramAbstractUploadTask;
    }
    return new IUploadConfig.UploadImageSize(640, 1136, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awum
 * JD-Core Version:    0.7.0.1
 */