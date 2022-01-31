import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class aosy
  implements aotf
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  static aotf a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return new aosq(paramQQAppInterface, paramFileManagerEntity);
  }
  
  static aotf a(QQAppInterface paramQQAppInterface, WeiYunFileInfo paramWeiYunFileInfo)
  {
    return new aost(paramQQAppInterface, paramWeiYunFileInfo);
  }
  
  static aotf a(FileInfo paramFileInfo)
  {
    return new aosr(paramFileInfo);
  }
  
  static aotf b(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return new aoss(paramQQAppInterface, paramFileManagerEntity);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public String f()
  {
    return "";
  }
  
  public String i()
  {
    String str2 = "";
    String str1 = str2;
    if (c() > 0L)
    {
      str1 = str2;
      if (c() != 3) {
        if ((e() == null) || (e().length() <= 0)) {
          break label92;
        }
      }
    }
    label92:
    for (int i = 1;; i = 0)
    {
      str1 = str2;
      if (i == 0) {
        str1 = "" + BaseApplicationImpl.getContext().getString(2131626862) + apck.a(c(), b());
      }
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosy
 * JD-Core Version:    0.7.0.1
 */