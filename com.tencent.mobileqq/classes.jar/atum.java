import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class atum
  extends atuk
{
  public bfjs a;
  QQAppInterface a;
  
  public atum(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = auea.a(paramQQAppInterface.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    if ((paramFileManagerEntity.isZipInnerFile) && (auea.a(paramQQAppInterface, this, true))) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Bfjs = bgke.a(paramQQAppInterface, paramFileManagerEntity);
    if ((this.jdField_a_of_type_Bfjs.b == 2) || (this.jdField_a_of_type_Bfjs.b == 3))
    {
      boolean bool2 = auea.a(this);
      if (c() == 3) {
        if ((!this.jdField_a_of_type_Boolean) || (!bool2)) {
          break label119;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      return;
      label119:
      bool1 = false;
    }
  }
  
  public int c()
  {
    if (FileUtil.fileExistsAndNotEmpty(super.g())) {
      return 3;
    }
    return super.c();
  }
  
  public int d()
  {
    if ((c() == 6) && (e() == 31)) {
      return super.d();
    }
    if (this.jdField_a_of_type_Bfjs != null) {
      return this.jdField_a_of_type_Bfjs.b;
    }
    return 0;
  }
  
  public String i()
  {
    String str2 = FileUtil.filesizeToString(super.b());
    String str1 = str2;
    if (104 == super.a().busId)
    {
      str1 = str2;
      if (super.a().lastTime > 0L)
      {
        str1 = str2 + BaseApplicationImpl.getContext().getString(2131692282);
        str1 = str1 + bgke.a(BaseApplicationImpl.getContext(), super.a().lastTime);
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atum
 * JD-Core Version:    0.7.0.1
 */