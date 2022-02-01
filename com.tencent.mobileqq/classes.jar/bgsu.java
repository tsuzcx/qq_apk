import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bgsu
  extends bhyn
{
  bgsu(bgst parambgst, File paramFile, bgsv parambgsv) {}
  
  public void onDone(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    if ((parambhyo.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_Bgst.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Bgst.b(BaseApplicationImpl.getContext())))
    {
      this.jdField_a_of_type_Bgst.a(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.jdField_a_of_type_Bgsv != null) {
        this.jdField_a_of_type_Bgsv.a(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.jdField_a_of_type_Bgsv != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.jdField_a_of_type_Bgsv.a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgsu
 * JD-Core Version:    0.7.0.1
 */