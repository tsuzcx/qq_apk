import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bhar
  extends biht
{
  bhar(bhaq parambhaq, File paramFile, bhas parambhas) {}
  
  public void onDone(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    if ((parambihu.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_Bhaq.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Bhaq.b(BaseApplicationImpl.getContext())))
    {
      this.jdField_a_of_type_Bhaq.a(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.jdField_a_of_type_Bhas != null) {
        this.jdField_a_of_type_Bhas.a(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.jdField_a_of_type_Bhas != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.jdField_a_of_type_Bhas.a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhar
 * JD-Core Version:    0.7.0.1
 */