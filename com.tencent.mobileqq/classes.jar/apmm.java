import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

class apmm
  implements aplj
{
  apmm(apmi paramapmi) {}
  
  public void a(apnc paramapnc)
  {
    apkt localapkt = ((aplm)paramapnc).a();
    if (localapkt != null)
    {
      if (1 != localapkt.c()) {
        break label147;
      }
      if (!localapkt.a().isZipInnerFile) {
        break label91;
      }
      paramapnc = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localapkt.a());
      if ((paramapnc != null) && (this.a.jdField_a_of_type_Apne != null)) {
        this.a.jdField_a_of_type_Apne.a(String.valueOf(localapkt.a()), paramapnc);
      }
    }
    label91:
    while (2 != localapkt.c())
    {
      do
      {
        return;
        paramapnc = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localapkt.a(), 7);
      } while ((paramapnc == null) || (this.a.jdField_a_of_type_Apne == null));
      this.a.jdField_a_of_type_Apne.a(localapkt.c(), paramapnc);
      return;
    }
    label147:
    aouu localaouu = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = localapkt.e();
    if (localapkt.a() == null) {}
    for (paramapnc = null;; paramapnc = localapkt.a().e)
    {
      paramapnc = localaouu.a(str, paramapnc, 7, localapkt);
      if ((paramapnc == null) || (this.a.jdField_a_of_type_Apne == null)) {
        break;
      }
      this.a.jdField_a_of_type_Apne.a(localapkt.e(), paramapnc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmm
 * JD-Core Version:    0.7.0.1
 */