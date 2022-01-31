import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aszc
{
  private Context jdField_a_of_type_AndroidContentContext;
  private asyn jdField_a_of_type_Asyn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private asyn b;
  private asyn c;
  private asyn d;
  private asyn e;
  
  public aszc(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(atar paramatar)
  {
    if ((paramatar instanceof ataq)) {
      return 0;
    }
    if ((paramatar instanceof atau)) {
      return 1;
    }
    if ((paramatar instanceof atas)) {
      return 2;
    }
    if ((paramatar instanceof atao)) {
      return 3;
    }
    if ((paramatar instanceof atav)) {
      return 4;
    }
    return -1;
  }
  
  public asyn a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Asyn != null) {
        localObject = this.jdField_a_of_type_Asyn;
      }
    }
    do
    {
      return localObject;
      localObject = new asza(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Asyn = ((asyn)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new atak(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((asyn)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new atah(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((asyn)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new asyv(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.d = ((asyn)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.e != null) {
      return this.e;
    }
    localObject = new atam(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.e = ((asyn)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aszc
 * JD-Core Version:    0.7.0.1
 */