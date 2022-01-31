import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class avqr
{
  private Context jdField_a_of_type_AndroidContentContext;
  private avqc jdField_a_of_type_Avqc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private avqc b;
  private avqc c;
  private avqc d;
  private avqc e;
  
  public avqr(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(avsg paramavsg)
  {
    if ((paramavsg instanceof avsf)) {
      return 0;
    }
    if ((paramavsg instanceof avsj)) {
      return 1;
    }
    if ((paramavsg instanceof avsh)) {
      return 2;
    }
    if ((paramavsg instanceof avsd)) {
      return 3;
    }
    if ((paramavsg instanceof avsk)) {
      return 4;
    }
    return -1;
  }
  
  public avqc a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Avqc != null) {
        localObject = this.jdField_a_of_type_Avqc;
      }
    }
    do
    {
      return localObject;
      localObject = new avqp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Avqc = ((avqc)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new avrz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((avqc)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new avrw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((avqc)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new avqk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.d = ((avqc)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.e != null) {
      return this.e;
    }
    localObject = new avsb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.e = ((avqc)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avqr
 * JD-Core Version:    0.7.0.1
 */