import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

class aspe
  implements aszj
{
  aspe(aspd paramaspd) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localQQAppInterface.getFileManagerEngine().a(this.a.jdField_a_of_type_JavaLangString, null, localQQAppInterface.getAccount(), 0, false);
    aszt.a(this.a.jdField_a_of_type_JavaLangString);
    aszk.d(BaseActivity.sTopActivity.getString(2131692493));
    if (this.a.jdField_a_of_type_Asqp != null) {
      this.a.jdField_a_of_type_Asqp.a(1);
    }
    if (this.a.jdField_a_of_type_Asqp.c())
    {
      long l = this.a.jdField_a_of_type_Asqp.a().b();
      aszt.a(this.a.jdField_a_of_type_Asqp.a(), l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspe
 * JD-Core Version:    0.7.0.1
 */