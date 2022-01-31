import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

class arju
  implements arir
{
  arju(arjq paramarjq) {}
  
  public void a(arkl paramarkl)
  {
    arhz localarhz = ((ariu)paramarkl).a();
    if (localarhz != null)
    {
      if (1 != localarhz.c()) {
        break label147;
      }
      if (!localarhz.a().isZipInnerFile) {
        break label91;
      }
      paramarkl = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localarhz.a());
      if ((paramarkl != null) && (this.a.jdField_a_of_type_Arkn != null)) {
        this.a.jdField_a_of_type_Arkn.a(String.valueOf(localarhz.a()), paramarkl);
      }
    }
    label91:
    while (2 != localarhz.c())
    {
      do
      {
        return;
        paramarkl = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localarhz.a(), 7);
      } while ((paramarkl == null) || (this.a.jdField_a_of_type_Arkn == null));
      this.a.jdField_a_of_type_Arkn.a(localarhz.c(), paramarkl);
      return;
    }
    label147:
    aqsb localaqsb = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = localarhz.e();
    if (localarhz.a() == null) {}
    for (paramarkl = null;; paramarkl = localarhz.a().e)
    {
      paramarkl = localaqsb.a(str, paramarkl, 7, localarhz);
      if ((paramarkl == null) || (this.a.jdField_a_of_type_Arkn == null)) {
        break;
      }
      this.a.jdField_a_of_type_Arkn.a(localarhz.e(), paramarkl);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arju
 * JD-Core Version:    0.7.0.1
 */