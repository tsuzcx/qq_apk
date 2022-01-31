import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class bivd
  implements bivg
{
  bivd(bivc parambivc, biuz parambiuz, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(bivc.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_Biuz.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bihr.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    bivc.a(this.jdField_a_of_type_Bivc).c.add(str);
    bivc.a(this.jdField_a_of_type_Bivc).a.add(paramString);
    if ((this.jdField_a_of_type_Biuz.c != null) && (!this.jdField_a_of_type_Biuz.c.equals(""))) {
      bivc.a(this.jdField_a_of_type_Bivc).b.add(this.jdField_a_of_type_Biuz.c);
    }
    for (;;)
    {
      bivc.a(this.jdField_a_of_type_Bivc).d.add(Integer.valueOf(this.jdField_a_of_type_Biuz.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      bivc.a(this.jdField_a_of_type_Bivc).b.add(this.jdField_a_of_type_Biuz.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivd
 * JD-Core Version:    0.7.0.1
 */