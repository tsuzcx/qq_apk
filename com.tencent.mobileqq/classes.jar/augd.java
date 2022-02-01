import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;

class augd
  implements aufa
{
  augd(aufz paramaufz) {}
  
  public void a(augl paramaugl)
  {
    auei localauei = ((aufd)paramaugl).a();
    if (localauei != null)
    {
      if (1 != localauei.c()) {
        break label147;
      }
      if (!localauei.a().isZipInnerFile) {
        break label91;
      }
      paramaugl = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localauei.a());
      if ((paramaugl != null) && (this.a.jdField_a_of_type_Augo != null)) {
        this.a.jdField_a_of_type_Augo.a(String.valueOf(localauei.a()), paramaugl);
      }
    }
    label91:
    while (2 != localauei.c())
    {
      do
      {
        return;
        paramaugl = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localauei.a(), 7);
      } while ((paramaugl == null) || (this.a.jdField_a_of_type_Augo == null));
      this.a.jdField_a_of_type_Augo.a(localauei.c(), paramaugl);
      return;
    }
    label147:
    atqx localatqx = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = localauei.e();
    if (localauei.a() == null) {}
    for (paramaugl = null;; paramaugl = localauei.a().e)
    {
      paramaugl = localatqx.a(str, paramaugl, 7, localauei);
      if ((paramaugl == null) || (this.a.jdField_a_of_type_Augo == null)) {
        break;
      }
      this.a.jdField_a_of_type_Augo.a(localauei.e(), paramaugl);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augd
 * JD-Core Version:    0.7.0.1
 */