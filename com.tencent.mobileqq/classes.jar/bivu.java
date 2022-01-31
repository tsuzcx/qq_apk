import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class bivu
  implements bivx
{
  bivu(bivt parambivt, bivq parambivq, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(bivt.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_Bivq.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      biii.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    bivt.a(this.jdField_a_of_type_Bivt).c.add(str);
    bivt.a(this.jdField_a_of_type_Bivt).a.add(paramString);
    if ((this.jdField_a_of_type_Bivq.c != null) && (!this.jdField_a_of_type_Bivq.c.equals(""))) {
      bivt.a(this.jdField_a_of_type_Bivt).b.add(this.jdField_a_of_type_Bivq.c);
    }
    for (;;)
    {
      bivt.a(this.jdField_a_of_type_Bivt).d.add(Integer.valueOf(this.jdField_a_of_type_Bivq.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      bivt.a(this.jdField_a_of_type_Bivt).b.add(this.jdField_a_of_type_Bivq.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivu
 * JD-Core Version:    0.7.0.1
 */