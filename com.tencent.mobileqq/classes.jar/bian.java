import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class bian
  implements biaq
{
  bian(biam parambiam, biaj parambiaj, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(biam.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_Biaj.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bhfb.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    biam.a(this.jdField_a_of_type_Biam).c.add(str);
    biam.a(this.jdField_a_of_type_Biam).a.add(paramString);
    if ((this.jdField_a_of_type_Biaj.c != null) && (!this.jdField_a_of_type_Biaj.c.equals(""))) {
      biam.a(this.jdField_a_of_type_Biam).b.add(this.jdField_a_of_type_Biaj.c);
    }
    for (;;)
    {
      biam.a(this.jdField_a_of_type_Biam).d.add(Integer.valueOf(this.jdField_a_of_type_Biaj.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      biam.a(this.jdField_a_of_type_Biam).b.add(this.jdField_a_of_type_Biaj.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bian
 * JD-Core Version:    0.7.0.1
 */