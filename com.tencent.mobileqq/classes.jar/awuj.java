import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;

class awuj
  implements IUploadTaskCallback
{
  awuj(awui paramawui) {}
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    this.a.f = 1002;
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.c = paramString;
    this.a.a(1002, new Object[0]);
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2) {}
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (this.a.f != paramInt)
    {
      this.a.f = paramInt;
      this.a.a(this.a.f, new Object[0]);
    }
  }
  
  public void onUploadSucceed(AbstractUploadTask paramAbstractUploadTask, Object paramObject)
  {
    this.a.f = 1001;
    this.a.jdField_a_of_type_JavaLangObject = paramObject;
    this.a.a(1001, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awuj
 * JD-Core Version:    0.7.0.1
 */