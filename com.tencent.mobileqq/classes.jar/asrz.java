import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class asrz
  implements aszj
{
  asrz(asry paramasry) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    int i = this.a.a.i();
    int j = this.a.a.d();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (i == 6) {
      if (j == 0) {
        localQQAppInterface.getOnlineFileSessionCenter().b(this.a.a.d());
      }
    }
    for (;;)
    {
      if (this.a.a.jdField_a_of_type_Assz != null) {
        this.a.a.jdField_a_of_type_Assz.d();
      }
      return;
      localQQAppInterface.getFileManagerEngine().a(this.a.a.d());
      continue;
      if (j == 0) {
        localQQAppInterface.getOnlineFileSessionCenter().a(this.a.a.d());
      } else {
        localQQAppInterface.getFileManagerEngine().b(this.a.a.jdField_a_of_type_Asqs.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrz
 * JD-Core Version:    0.7.0.1
 */