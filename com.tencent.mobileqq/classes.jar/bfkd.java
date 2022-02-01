import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bfkd
  extends bgod
{
  bfkd(bfkc parambfkc, File paramFile, bfke parambfke) {}
  
  public void onDone(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    if ((parambgoe.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_Bfkc.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Bfkc.b(BaseApplicationImpl.getContext())))
    {
      this.jdField_a_of_type_Bfkc.a(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.jdField_a_of_type_Bfke != null) {
        this.jdField_a_of_type_Bfke.a(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.jdField_a_of_type_Bfke != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.jdField_a_of_type_Bfke.a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkd
 * JD-Core Version:    0.7.0.1
 */