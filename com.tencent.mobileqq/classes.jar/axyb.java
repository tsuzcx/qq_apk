import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class axyb
{
  private Context jdField_a_of_type_AndroidContentContext;
  private axxm jdField_a_of_type_Axxm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private axxm b;
  private axxm c;
  private axxm d;
  private axxm e;
  
  public axyb(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(axzq paramaxzq)
  {
    if ((paramaxzq instanceof axzp)) {
      return 0;
    }
    if ((paramaxzq instanceof axzt)) {
      return 1;
    }
    if ((paramaxzq instanceof axzr)) {
      return 2;
    }
    if ((paramaxzq instanceof axzn)) {
      return 3;
    }
    if ((paramaxzq instanceof axzu)) {
      return 4;
    }
    return -1;
  }
  
  public axxm a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Axxm != null) {
        localObject = this.jdField_a_of_type_Axxm;
      }
    }
    do
    {
      return localObject;
      localObject = new axxz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Axxm = ((axxm)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new axzj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((axxm)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new axzg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((axxm)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new axxu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.d = ((axxm)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.e != null) {
      return this.e;
    }
    localObject = new axzl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.e = ((axxm)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyb
 * JD-Core Version:    0.7.0.1
 */