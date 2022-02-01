import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

class attk
  implements audq
{
  attk(attj paramattj) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localQQAppInterface.getFileManagerEngine().a(this.a.jdField_a_of_type_JavaLangString, null, localQQAppInterface.getAccount(), 0, false);
    auea.a(this.a.jdField_a_of_type_JavaLangString);
    audr.d(BaseActivity.sTopActivity.getString(2131692595));
    if (this.a.jdField_a_of_type_Atuw != null) {
      this.a.jdField_a_of_type_Atuw.a(1);
    }
    if (this.a.jdField_a_of_type_Atuw.c())
    {
      long l = this.a.jdField_a_of_type_Atuw.a().b();
      auea.a(this.a.jdField_a_of_type_Atuw.a(), l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attk
 * JD-Core Version:    0.7.0.1
 */