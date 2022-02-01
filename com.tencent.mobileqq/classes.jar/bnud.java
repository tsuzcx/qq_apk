import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class bnud
  implements bnug
{
  bnud(bnuc parambnuc, bntz parambntz, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(bnuc.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_Bntz.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bncx.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    bnuc.a(this.jdField_a_of_type_Bnuc).c.add(str);
    bnuc.a(this.jdField_a_of_type_Bnuc).a.add(paramString);
    if ((this.jdField_a_of_type_Bntz.c != null) && (!this.jdField_a_of_type_Bntz.c.equals(""))) {
      bnuc.a(this.jdField_a_of_type_Bnuc).b.add(this.jdField_a_of_type_Bntz.c);
    }
    for (;;)
    {
      bnuc.a(this.jdField_a_of_type_Bnuc).d.add(Integer.valueOf(this.jdField_a_of_type_Bntz.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      bnuc.a(this.jdField_a_of_type_Bnuc).b.add(this.jdField_a_of_type_Bntz.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnud
 * JD-Core Version:    0.7.0.1
 */