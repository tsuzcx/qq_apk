import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

class arfl
  implements arei
{
  arfl(arfh paramarfh) {}
  
  public void a(argc paramargc)
  {
    ardq localardq = ((arel)paramargc).a();
    if (localardq != null)
    {
      if (1 != localardq.c()) {
        break label147;
      }
      if (!localardq.a().isZipInnerFile) {
        break label91;
      }
      paramargc = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localardq.a());
      if ((paramargc != null) && (this.a.jdField_a_of_type_Arge != null)) {
        this.a.jdField_a_of_type_Arge.a(String.valueOf(localardq.a()), paramargc);
      }
    }
    label91:
    while (2 != localardq.c())
    {
      do
      {
        return;
        paramargc = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localardq.a(), 7);
      } while ((paramargc == null) || (this.a.jdField_a_of_type_Arge == null));
      this.a.jdField_a_of_type_Arge.a(localardq.c(), paramargc);
      return;
    }
    label147:
    aqns localaqns = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = localardq.e();
    if (localardq.a() == null) {}
    for (paramargc = null;; paramargc = localardq.a().e)
    {
      paramargc = localaqns.a(str, paramargc, 7, localardq);
      if ((paramargc == null) || (this.a.jdField_a_of_type_Arge == null)) {
        break;
      }
      this.a.jdField_a_of_type_Arge.a(localardq.e(), paramargc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfl
 * JD-Core Version:    0.7.0.1
 */