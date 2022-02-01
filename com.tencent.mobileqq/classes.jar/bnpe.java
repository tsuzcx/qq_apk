import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class bnpe
  implements bnph
{
  bnpe(bnpd parambnpd, bnpa parambnpa, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(bnpd.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_Bnpa.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bmve.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    bnpd.a(this.jdField_a_of_type_Bnpd).c.add(str);
    bnpd.a(this.jdField_a_of_type_Bnpd).a.add(paramString);
    if ((this.jdField_a_of_type_Bnpa.c != null) && (!this.jdField_a_of_type_Bnpa.c.equals(""))) {
      bnpd.a(this.jdField_a_of_type_Bnpd).b.add(this.jdField_a_of_type_Bnpa.c);
    }
    for (;;)
    {
      bnpd.a(this.jdField_a_of_type_Bnpd).d.add(Integer.valueOf(this.jdField_a_of_type_Bnpa.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      bnpd.a(this.jdField_a_of_type_Bnpd).b.add(this.jdField_a_of_type_Bnpa.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpe
 * JD-Core Version:    0.7.0.1
 */