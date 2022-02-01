import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class blzu
  implements blzx
{
  blzu(blzt paramblzt, blzq paramblzq, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(blzt.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_Blzq.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      blin.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    blzt.a(this.jdField_a_of_type_Blzt).c.add(str);
    blzt.a(this.jdField_a_of_type_Blzt).a.add(paramString);
    if ((this.jdField_a_of_type_Blzq.c != null) && (!this.jdField_a_of_type_Blzq.c.equals(""))) {
      blzt.a(this.jdField_a_of_type_Blzt).b.add(this.jdField_a_of_type_Blzq.c);
    }
    for (;;)
    {
      blzt.a(this.jdField_a_of_type_Blzt).d.add(Integer.valueOf(this.jdField_a_of_type_Blzq.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      blzt.a(this.jdField_a_of_type_Blzt).b.add(this.jdField_a_of_type_Blzq.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzu
 * JD-Core Version:    0.7.0.1
 */