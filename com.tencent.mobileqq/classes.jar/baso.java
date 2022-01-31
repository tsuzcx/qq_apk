import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class baso
  extends bbwf
{
  baso(basn parambasn, File paramFile, basp parambasp) {}
  
  public void onDone(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    if ((parambbwg.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_Basn.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Basn.b(BaseApplicationImpl.getContext())))
    {
      this.jdField_a_of_type_Basn.a(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.jdField_a_of_type_Basp != null) {
        this.jdField_a_of_type_Basp.a(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.jdField_a_of_type_Basp != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.jdField_a_of_type_Basp.a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baso
 * JD-Core Version:    0.7.0.1
 */