import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class ardd
  extends ardb
{
  public bbpe a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final String jdField_a_of_type_JavaLangString = "TroopFileViewerAdapter";
  
  public ardd(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = arni.a(paramQQAppInterface.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    if ((paramFileManagerEntity.isZipInnerFile) && (arni.a(paramQQAppInterface, this))) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Bbpe = bcjk.a(paramQQAppInterface, paramFileManagerEntity);
    if ((this.jdField_a_of_type_Bbpe.b == 2) || (this.jdField_a_of_type_Bbpe.b == 3))
    {
      boolean bool3 = arni.a(this);
      if (c() == 3)
      {
        boolean bool1 = bool2;
        if (this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
        this.jdField_a_of_type_Boolean = bool1;
      }
    }
  }
  
  public int c()
  {
    if (arof.b(super.g())) {
      return 3;
    }
    return super.c();
  }
  
  public int d()
  {
    if ((c() == 6) && (e() == 31)) {
      return super.d();
    }
    if (this.jdField_a_of_type_Bbpe != null) {
      return this.jdField_a_of_type_Bbpe.b;
    }
    return 0;
  }
  
  public String i()
  {
    String str2 = arof.a(super.b());
    String str1 = str2;
    if (104 == super.a().busId)
    {
      str1 = str2;
      if (super.a().lastTime > 0L)
      {
        str1 = str2 + BaseApplicationImpl.getContext().getString(2131692552);
        str1 = str1 + bcjk.a(BaseApplicationImpl.getContext(), super.a().lastTime);
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardd
 * JD-Core Version:    0.7.0.1
 */