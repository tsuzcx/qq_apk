import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class benw
  implements bkxw
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public benw(benv parambenv)
  {
    switch (benv.a(parambenv))
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
    if (this.jdField_a_of_type_Benv.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_Benv.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(benv.a(this.jdField_a_of_type_Benv)), ", info hash=", Integer.valueOf(benv.a(this.jdField_a_of_type_Benv).hashCode()), ", info status=", Integer.valueOf(benv.a(this.jdField_a_of_type_Benv).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Benv.isCanceled())
    {
      this.jdField_a_of_type_Benv.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(benv.a(this.jdField_a_of_type_Benv)), ", info hash=", Integer.valueOf(benv.a(this.jdField_a_of_type_Benv).hashCode()), ", info status=", Integer.valueOf(benv.a(this.jdField_a_of_type_Benv).g) });
    }
    switch (benv.a(this.jdField_a_of_type_Benv))
    {
    }
    while (!this.jdField_a_of_type_Benv.isCanceled())
    {
      benv.a(this.jdField_a_of_type_Benv, benv.a(this.jdField_a_of_type_Benv));
      return;
      benz localbenz = (benz)benv.a(this.jdField_a_of_type_Benv);
      localbenz.e = paramString;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localbenz));
      continue;
      benv.a(this.jdField_a_of_type_Benv).b = paramString;
    }
    this.jdField_a_of_type_Benv.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(benv.a(this.jdField_a_of_type_Benv).b()), ", mediaType=", Integer.valueOf(benv.a(this.jdField_a_of_type_Benv)) });
    }
    if (benv.a(this.jdField_a_of_type_Benv) == 2)
    {
      benv.b(this.jdField_a_of_type_Benv, benv.a(this.jdField_a_of_type_Benv));
      return;
    }
    benv.a(this.jdField_a_of_type_Benv, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benw
 * JD-Core Version:    0.7.0.1
 */