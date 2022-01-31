import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

class aouw
  implements aott
{
  aouw(aous paramaous) {}
  
  public void a(aovl paramaovl)
  {
    aotf localaotf = ((aotw)paramaovl).a();
    if (localaotf != null)
    {
      if (1 != localaotf.c()) {
        break label147;
      }
      if (!localaotf.a().isZipInnerFile) {
        break label91;
      }
      paramaovl = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaotf.a());
      if ((paramaovl != null) && (this.a.jdField_a_of_type_Aovn != null)) {
        this.a.jdField_a_of_type_Aovn.a(String.valueOf(localaotf.a()), paramaovl);
      }
    }
    label91:
    while (2 != localaotf.c())
    {
      do
      {
        return;
        paramaovl = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaotf.a(), 7);
      } while ((paramaovl == null) || (this.a.jdField_a_of_type_Aovn == null));
      this.a.jdField_a_of_type_Aovn.a(localaotf.c(), paramaovl);
      return;
    }
    label147:
    aodw localaodw = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = localaotf.e();
    if (localaotf.a() == null) {}
    for (paramaovl = null;; paramaovl = localaotf.a().e)
    {
      paramaovl = localaodw.a(str, paramaovl, 7, localaotf);
      if ((paramaovl == null) || (this.a.jdField_a_of_type_Aovn == null)) {
        break;
      }
      this.a.jdField_a_of_type_Aovn.a(localaotf.e(), paramaovl);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aouw
 * JD-Core Version:    0.7.0.1
 */