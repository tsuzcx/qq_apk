import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;

class assn
  implements asrk
{
  assn(assj paramassj) {}
  
  public void a(assv paramassv)
  {
    asqs localasqs = ((asrn)paramassv).a();
    if (localasqs != null)
    {
      if (1 != localasqs.c()) {
        break label147;
      }
      if (!localasqs.a().isZipInnerFile) {
        break label91;
      }
      paramassv = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().c(localasqs.a());
      if ((paramassv != null) && (this.a.jdField_a_of_type_Assy != null)) {
        this.a.jdField_a_of_type_Assy.a(String.valueOf(localasqs.a()), paramassv);
      }
    }
    label91:
    while (2 != localasqs.c())
    {
      do
      {
        return;
        paramassv = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localasqs.a(), 7);
      } while ((paramassv == null) || (this.a.jdField_a_of_type_Assy == null));
      this.a.jdField_a_of_type_Assy.a(localasqs.c(), paramassv);
      return;
    }
    label147:
    asdg localasdg = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    String str = localasqs.e();
    if (localasqs.a() == null) {}
    for (paramassv = null;; paramassv = localasqs.a().e)
    {
      paramassv = localasdg.a(str, paramassv, 7, localasqs);
      if ((paramassv == null) || (this.a.jdField_a_of_type_Assy == null)) {
        break;
      }
      this.a.jdField_a_of_type_Assy.a(localasqs.e(), paramassv);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assn
 * JD-Core Version:    0.7.0.1
 */