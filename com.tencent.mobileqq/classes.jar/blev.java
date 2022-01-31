import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class blev
  implements bley
{
  blev(bleu parambleu, bler parambler, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    QLog.d(bleu.a(), 4, "create pngs for material index = " + this.jdField_a_of_type_Bler.a + " end, pngDir = " + paramString);
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bkok.a(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    bleu.a(this.jdField_a_of_type_Bleu).c.add(str);
    bleu.a(this.jdField_a_of_type_Bleu).a.add(paramString);
    if ((this.jdField_a_of_type_Bler.c != null) && (!this.jdField_a_of_type_Bler.c.equals(""))) {
      bleu.a(this.jdField_a_of_type_Bleu).b.add(this.jdField_a_of_type_Bler.c);
    }
    for (;;)
    {
      bleu.a(this.jdField_a_of_type_Bleu).d.add(Integer.valueOf(this.jdField_a_of_type_Bler.a));
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
      bleu.a(this.jdField_a_of_type_Bleu).b.add(this.jdField_a_of_type_Bler.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blev
 * JD-Core Version:    0.7.0.1
 */