import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

class apmi
  implements aplf
{
  apmi(apme paramapme) {}
  
  public void a(apmy paramapmy)
  {
    apkp localapkp = ((apli)paramapmy).a();
    if (localapkp != null)
    {
      if (1 != localapkp.c()) {
        break label147;
      }
      if (!localapkp.a().isZipInnerFile) {
        break label91;
      }
      paramapmy = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localapkp.a());
      if ((paramapmy != null) && (this.a.jdField_a_of_type_Apna != null)) {
        this.a.jdField_a_of_type_Apna.a(String.valueOf(localapkp.a()), paramapmy);
      }
    }
    label91:
    while (2 != localapkp.c())
    {
      do
      {
        return;
        paramapmy = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localapkp.a(), 7);
      } while ((paramapmy == null) || (this.a.jdField_a_of_type_Apna == null));
      this.a.jdField_a_of_type_Apna.a(localapkp.c(), paramapmy);
      return;
    }
    label147:
    aouq localaouq = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = localapkp.e();
    if (localapkp.a() == null) {}
    for (paramapmy = null;; paramapmy = localapkp.a().e)
    {
      paramapmy = localaouq.a(str, paramapmy, 7, localapkp);
      if ((paramapmy == null) || (this.a.jdField_a_of_type_Apna == null)) {
        break;
      }
      this.a.jdField_a_of_type_Apna.a(localapkp.e(), paramapmy);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmi
 * JD-Core Version:    0.7.0.1
 */