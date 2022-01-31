import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bceg
  implements bkda
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public bceg(bcef parambcef)
  {
    switch (bcef.a(parambcef))
    {
    default: 
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Float = 1.0F;
      return;
    case 1: 
      this.jdField_a_of_type_Int = 10;
      this.jdField_a_of_type_Float = 0.85F;
      return;
    }
    this.jdField_a_of_type_Int = 95;
    this.jdField_a_of_type_Float = 0.05F;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcef.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_Bcef.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(bcef.a(this.jdField_a_of_type_Bcef)), ", info hash=", Integer.valueOf(bcef.a(this.jdField_a_of_type_Bcef).hashCode()), ", info status=", Integer.valueOf(bcef.a(this.jdField_a_of_type_Bcef).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bcef.isCanceled())
    {
      this.jdField_a_of_type_Bcef.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(bcef.a(this.jdField_a_of_type_Bcef)), ", info hash=", Integer.valueOf(bcef.a(this.jdField_a_of_type_Bcef).hashCode()), ", info status=", Integer.valueOf(bcef.a(this.jdField_a_of_type_Bcef).g) });
    }
    switch (bcef.a(this.jdField_a_of_type_Bcef))
    {
    }
    while (!this.jdField_a_of_type_Bcef.isCanceled())
    {
      bcef.a(this.jdField_a_of_type_Bcef, bcef.a(this.jdField_a_of_type_Bcef));
      return;
      bcej localbcej = (bcej)bcef.a(this.jdField_a_of_type_Bcef);
      localbcej.e = paramString;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localbcej));
      continue;
      bcef.a(this.jdField_a_of_type_Bcef).b = paramString;
    }
    this.jdField_a_of_type_Bcef.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(bcef.a(this.jdField_a_of_type_Bcef).b()), ", mediaType=", Integer.valueOf(bcef.a(this.jdField_a_of_type_Bcef)) });
    }
    if (bcef.a(this.jdField_a_of_type_Bcef) == 2)
    {
      bcef.b(this.jdField_a_of_type_Bcef, bcef.a(this.jdField_a_of_type_Bcef));
      return;
    }
    bcef.a(this.jdField_a_of_type_Bcef, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bceg
 * JD-Core Version:    0.7.0.1
 */