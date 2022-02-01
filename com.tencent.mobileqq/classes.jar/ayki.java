import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class ayki
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ayjt jdField_a_of_type_Ayjt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ayjt b;
  private ayjt c;
  private ayjt d;
  private ayjt e;
  
  public ayki(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(aylx paramaylx)
  {
    if ((paramaylx instanceof aylw)) {
      return 0;
    }
    if ((paramaylx instanceof ayma)) {
      return 1;
    }
    if ((paramaylx instanceof ayly)) {
      return 2;
    }
    if ((paramaylx instanceof aylu)) {
      return 3;
    }
    if ((paramaylx instanceof aymb)) {
      return 4;
    }
    return -1;
  }
  
  public ayjt a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Ayjt != null) {
        localObject = this.jdField_a_of_type_Ayjt;
      }
    }
    do
    {
      return localObject;
      localObject = new aykg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Ayjt = ((ayjt)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new aylq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((ayjt)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new ayln(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((ayjt)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new aykb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.d = ((ayjt)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.e != null) {
      return this.e;
    }
    localObject = new ayls(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.e = ((ayjt)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayki
 * JD-Core Version:    0.7.0.1
 */