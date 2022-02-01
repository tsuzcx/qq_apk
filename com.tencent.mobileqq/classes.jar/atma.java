import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class atma
  extends atly
{
  public bety a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final String jdField_a_of_type_JavaLangString = "TroopFileViewerAdapter";
  
  public atma(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = atvo.a(paramQQAppInterface.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    if ((paramFileManagerEntity.isZipInnerFile) && (atvo.a(paramQQAppInterface, this, true))) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Bety = bfsj.a(paramQQAppInterface, paramFileManagerEntity);
    if ((this.jdField_a_of_type_Bety.b == 2) || (this.jdField_a_of_type_Bety.b == 3))
    {
      boolean bool2 = atvo.a(this);
      if (c() == 3) {
        if ((!this.jdField_a_of_type_Boolean) || (!bool2)) {
          break label125;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      return;
      label125:
      bool1 = false;
    }
  }
  
  public int c()
  {
    if (atwl.b(super.g())) {
      return 3;
    }
    return super.c();
  }
  
  public int d()
  {
    if ((c() == 6) && (e() == 31)) {
      return super.d();
    }
    if (this.jdField_a_of_type_Bety != null) {
      return this.jdField_a_of_type_Bety.b;
    }
    return 0;
  }
  
  public String i()
  {
    String str2 = atwl.a(super.b());
    String str1 = str2;
    if (104 == super.a().busId)
    {
      str1 = str2;
      if (super.a().lastTime > 0L)
      {
        str1 = str2 + BaseApplicationImpl.getContext().getString(2131692139);
        str1 = str1 + bfsj.a(BaseApplicationImpl.getContext(), super.a().lastTime);
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atma
 * JD-Core Version:    0.7.0.1
 */