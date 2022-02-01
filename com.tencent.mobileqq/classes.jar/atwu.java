import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;

class atwu
  implements atvr
{
  atwu(atwq paramatwq) {}
  
  public void a(atxc paramatxc)
  {
    atuz localatuz = ((atvu)paramatxc).a();
    if (localatuz != null)
    {
      if (1 != localatuz.c()) {
        break label147;
      }
      if (!localatuz.a().isZipInnerFile) {
        break label91;
      }
      paramatxc = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().c(localatuz.a());
      if ((paramatxc != null) && (this.a.jdField_a_of_type_Atxf != null)) {
        this.a.jdField_a_of_type_Atxf.a(String.valueOf(localatuz.a()), paramatxc);
      }
    }
    label91:
    while (2 != localatuz.c())
    {
      do
      {
        return;
        paramatxc = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localatuz.a(), 7);
      } while ((paramatxc == null) || (this.a.jdField_a_of_type_Atxf == null));
      this.a.jdField_a_of_type_Atxf.a(localatuz.c(), paramatxc);
      return;
    }
    label147:
    athn localathn = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    String str = localatuz.e();
    if (localatuz.a() == null) {}
    for (paramatxc = null;; paramatxc = localatuz.a().e)
    {
      paramatxc = localathn.a(str, paramatxc, 7, localatuz);
      if ((paramatxc == null) || (this.a.jdField_a_of_type_Atxf == null)) {
        break;
      }
      this.a.jdField_a_of_type_Atxf.a(localatuz.e(), paramatxc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwu
 * JD-Core Version:    0.7.0.1
 */