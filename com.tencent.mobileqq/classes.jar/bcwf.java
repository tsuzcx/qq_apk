import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bcwf
  extends bead
{
  bcwf(bcwe parambcwe, File paramFile, bcwg parambcwg) {}
  
  public void onDone(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    if ((parambeae.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_Bcwe.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Bcwe.b(BaseApplicationImpl.getContext())))
    {
      this.jdField_a_of_type_Bcwe.a(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.jdField_a_of_type_Bcwg != null) {
        this.jdField_a_of_type_Bcwg.a(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.jdField_a_of_type_Bcwg != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.jdField_a_of_type_Bcwg.a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwf
 * JD-Core Version:    0.7.0.1
 */