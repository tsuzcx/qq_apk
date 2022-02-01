import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bgeo
  implements bnsp
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public bgeo(bgen parambgen)
  {
    switch (bgen.a(parambgen))
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
    if (this.jdField_a_of_type_Bgen.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_Bgen.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(bgen.a(this.jdField_a_of_type_Bgen)), ", info hash=", Integer.valueOf(bgen.a(this.jdField_a_of_type_Bgen).hashCode()), ", info status=", Integer.valueOf(bgen.a(this.jdField_a_of_type_Bgen).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bgen.isCanceled())
    {
      this.jdField_a_of_type_Bgen.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(bgen.a(this.jdField_a_of_type_Bgen)), ", info hash=", Integer.valueOf(bgen.a(this.jdField_a_of_type_Bgen).hashCode()), ", info status=", Integer.valueOf(bgen.a(this.jdField_a_of_type_Bgen).g) });
    }
    switch (bgen.a(this.jdField_a_of_type_Bgen))
    {
    }
    while (!this.jdField_a_of_type_Bgen.isCanceled())
    {
      bgen.a(this.jdField_a_of_type_Bgen, bgen.a(this.jdField_a_of_type_Bgen));
      return;
      bger localbger = (bger)bgen.a(this.jdField_a_of_type_Bgen);
      localbger.e = paramString;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localbger));
      continue;
      bgen.a(this.jdField_a_of_type_Bgen).b = paramString;
    }
    this.jdField_a_of_type_Bgen.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(bgen.a(this.jdField_a_of_type_Bgen).b()), ", mediaType=", Integer.valueOf(bgen.a(this.jdField_a_of_type_Bgen)) });
    }
    if (bgen.a(this.jdField_a_of_type_Bgen) == 2)
    {
      bgen.b(this.jdField_a_of_type_Bgen, bgen.a(this.jdField_a_of_type_Bgen));
      return;
    }
    bgen.a(this.jdField_a_of_type_Bgen, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgeo
 * JD-Core Version:    0.7.0.1
 */