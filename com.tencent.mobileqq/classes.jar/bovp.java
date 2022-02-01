import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class bovp
  implements bovs
{
  bovp(bovo parambovo, bovl parambovl, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(bovo.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_Bovl.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      boef.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    bovo.a(this.jdField_a_of_type_Bovo).c.add(str);
    bovo.a(this.jdField_a_of_type_Bovo).a.add(paramString);
    if ((this.jdField_a_of_type_Bovl.c != null) && (!this.jdField_a_of_type_Bovl.c.equals(""))) {
      bovo.a(this.jdField_a_of_type_Bovo).b.add(this.jdField_a_of_type_Bovl.c);
    }
    for (;;)
    {
      bovo.a(this.jdField_a_of_type_Bovo).d.add(Integer.valueOf(this.jdField_a_of_type_Bovl.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      bovo.a(this.jdField_a_of_type_Bovo).b.add(this.jdField_a_of_type_Bovl.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bovp
 * JD-Core Version:    0.7.0.1
 */