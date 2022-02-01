import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;

class atoi
  implements atnf
{
  atoi(atoe paramatoe) {}
  
  public void a(atoq paramatoq)
  {
    atmn localatmn = ((atni)paramatoq).a();
    if (localatmn != null)
    {
      if (1 != localatmn.c()) {
        break label147;
      }
      if (!localatmn.a().isZipInnerFile) {
        break label91;
      }
      paramatoq = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localatmn.a());
      if ((paramatoq != null) && (this.a.jdField_a_of_type_Atot != null)) {
        this.a.jdField_a_of_type_Atot.a(String.valueOf(localatmn.a()), paramatoq);
      }
    }
    label91:
    while (2 != localatmn.c())
    {
      do
      {
        return;
        paramatoq = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localatmn.a(), 7);
      } while ((paramatoq == null) || (this.a.jdField_a_of_type_Atot == null));
      this.a.jdField_a_of_type_Atot.a(localatmn.c(), paramatoq);
      return;
    }
    label147:
    aszd localaszd = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = localatmn.e();
    if (localatmn.a() == null) {}
    for (paramatoq = null;; paramatoq = localatmn.a().e)
    {
      paramatoq = localaszd.a(str, paramatoq, 7, localatmn);
      if ((paramatoq == null) || (this.a.jdField_a_of_type_Atot == null)) {
        break;
      }
      this.a.jdField_a_of_type_Atot.a(localatmn.e(), paramatoq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoi
 * JD-Core Version:    0.7.0.1
 */