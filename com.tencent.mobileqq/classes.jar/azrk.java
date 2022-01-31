import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class azrk
  extends batl
{
  azrk(azrj paramazrj, File paramFile, azrl paramazrl) {}
  
  public void onDone(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    if ((parambatm.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_Azrj.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Azrj.b(BaseApplicationImpl.getContext())))
    {
      this.jdField_a_of_type_Azrj.a(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.jdField_a_of_type_Azrl != null) {
        this.jdField_a_of_type_Azrl.a(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.jdField_a_of_type_Azrl != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.jdField_a_of_type_Azrl.a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azrk
 * JD-Core Version:    0.7.0.1
 */