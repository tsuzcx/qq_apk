import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bcrw
  extends bdvu
{
  bcrw(bcrv parambcrv, File paramFile, bcrx parambcrx) {}
  
  public void onDone(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    if ((parambdvv.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_Bcrv.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Bcrv.b(BaseApplicationImpl.getContext())))
    {
      this.jdField_a_of_type_Bcrv.a(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.jdField_a_of_type_Bcrx != null) {
        this.jdField_a_of_type_Bcrx.a(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.jdField_a_of_type_Bcrx != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.jdField_a_of_type_Bcrx.a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrw
 * JD-Core Version:    0.7.0.1
 */