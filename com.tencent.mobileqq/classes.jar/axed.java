import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class axed
{
  private Context jdField_a_of_type_AndroidContentContext;
  private axdo jdField_a_of_type_Axdo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private axdo b;
  private axdo c;
  private axdo d;
  private axdo e;
  
  public axed(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(axfs paramaxfs)
  {
    if ((paramaxfs instanceof axfr)) {
      return 0;
    }
    if ((paramaxfs instanceof axfv)) {
      return 1;
    }
    if ((paramaxfs instanceof axft)) {
      return 2;
    }
    if ((paramaxfs instanceof axfp)) {
      return 3;
    }
    if ((paramaxfs instanceof axfw)) {
      return 4;
    }
    return -1;
  }
  
  public axdo a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Axdo != null) {
        localObject = this.jdField_a_of_type_Axdo;
      }
    }
    do
    {
      return localObject;
      localObject = new axeb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Axdo = ((axdo)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new axfl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((axdo)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new axfi(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((axdo)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new axdw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.d = ((axdo)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.e != null) {
      return this.e;
    }
    localObject = new axfn(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.e = ((axdo)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axed
 * JD-Core Version:    0.7.0.1
 */