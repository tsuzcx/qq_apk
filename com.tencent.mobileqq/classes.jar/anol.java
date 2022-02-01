import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class anol
  extends bgod
{
  anol(String paramString) {}
  
  public void onCancel(bgoe parambgoe)
  {
    anoh.jdField_a_of_type_Bgoe = null;
    QLog.d(anoh.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(bgoe parambgoe)
  {
    anoh.jdField_a_of_type_Bgoe = null;
    if (parambgoe.a() == 3)
    {
      QLog.d(anoh.jdField_a_of_type_JavaLangString, 1, "download finished " + anoh.f);
      parambgoe = new File(this.jdField_a_of_type_JavaLangString);
      if ((parambgoe.exists()) && (anoh.a(parambgoe))) {
        QLog.d(anoh.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(anoh.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", parambgoe.b, " code=", Integer.valueOf(parambgoe.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anol
 * JD-Core Version:    0.7.0.1
 */