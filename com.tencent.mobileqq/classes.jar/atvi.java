import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class atvi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private atut jdField_a_of_type_Atut;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private atut b;
  private atut c;
  private atut d;
  private atut e;
  
  public atvi(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(atwx paramatwx)
  {
    if ((paramatwx instanceof atww)) {
      return 0;
    }
    if ((paramatwx instanceof atxa)) {
      return 1;
    }
    if ((paramatwx instanceof atwy)) {
      return 2;
    }
    if ((paramatwx instanceof atwu)) {
      return 3;
    }
    if ((paramatwx instanceof atxb)) {
      return 4;
    }
    return -1;
  }
  
  public atut a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Atut != null) {
        localObject = this.jdField_a_of_type_Atut;
      }
    }
    do
    {
      return localObject;
      localObject = new atvg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Atut = ((atut)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new atwq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((atut)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new atwn(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((atut)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new atvb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.d = ((atut)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.e != null) {
      return this.e;
    }
    localObject = new atws(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.e = ((atut)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvi
 * JD-Core Version:    0.7.0.1
 */