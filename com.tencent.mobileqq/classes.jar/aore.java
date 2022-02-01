import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aore
  extends bhyn
{
  aore(String paramString) {}
  
  public void onCancel(bhyo parambhyo)
  {
    aora.jdField_a_of_type_Bhyo = null;
    QLog.d(aora.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(bhyo parambhyo)
  {
    aora.jdField_a_of_type_Bhyo = null;
    if (parambhyo.a() == 3)
    {
      QLog.d(aora.jdField_a_of_type_JavaLangString, 1, "download finished " + aora.f);
      parambhyo = new File(this.jdField_a_of_type_JavaLangString);
      if ((parambhyo.exists()) && (aora.a(parambhyo))) {
        QLog.d(aora.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(aora.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", parambhyo.b, " code=", Integer.valueOf(parambhyo.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aore
 * JD-Core Version:    0.7.0.1
 */