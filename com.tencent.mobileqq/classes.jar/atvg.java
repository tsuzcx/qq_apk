import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class atvg
{
  private Context jdField_a_of_type_AndroidContentContext;
  private atur jdField_a_of_type_Atur;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private atur b;
  private atur c;
  private atur d;
  private atur e;
  
  public atvg(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(atwv paramatwv)
  {
    if ((paramatwv instanceof atwu)) {
      return 0;
    }
    if ((paramatwv instanceof atwy)) {
      return 1;
    }
    if ((paramatwv instanceof atww)) {
      return 2;
    }
    if ((paramatwv instanceof atws)) {
      return 3;
    }
    if ((paramatwv instanceof atwz)) {
      return 4;
    }
    return -1;
  }
  
  public atur a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Atur != null) {
        localObject = this.jdField_a_of_type_Atur;
      }
    }
    do
    {
      return localObject;
      localObject = new atve(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Atur = ((atur)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new atwo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((atur)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new atwl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((atur)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new atuz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.d = ((atur)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.e != null) {
      return this.e;
    }
    localObject = new atwq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.e = ((atur)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvg
 * JD-Core Version:    0.7.0.1
 */