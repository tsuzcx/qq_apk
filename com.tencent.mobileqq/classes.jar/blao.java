import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class blao
  implements blar
{
  blao(blan paramblan, blak paramblak, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(blan.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_Blak.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bkkd.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    blan.a(this.jdField_a_of_type_Blan).c.add(str);
    blan.a(this.jdField_a_of_type_Blan).a.add(paramString);
    if ((this.jdField_a_of_type_Blak.c != null) && (!this.jdField_a_of_type_Blak.c.equals(""))) {
      blan.a(this.jdField_a_of_type_Blan).b.add(this.jdField_a_of_type_Blak.c);
    }
    for (;;)
    {
      blan.a(this.jdField_a_of_type_Blan).d.add(Integer.valueOf(this.jdField_a_of_type_Blak.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      blan.a(this.jdField_a_of_type_Blan).b.add(this.jdField_a_of_type_Blak.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blao
 * JD-Core Version:    0.7.0.1
 */