import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class batc
  extends bbwt
{
  batc(batb parambatb, File paramFile, batd parambatd) {}
  
  public void onDone(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    if ((parambbwu.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_Batb.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Batb.b(BaseApplicationImpl.getContext())))
    {
      this.jdField_a_of_type_Batb.a(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.jdField_a_of_type_Batd != null) {
        this.jdField_a_of_type_Batd.a(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.jdField_a_of_type_Batd != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.jdField_a_of_type_Batd.a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batc
 * JD-Core Version:    0.7.0.1
 */