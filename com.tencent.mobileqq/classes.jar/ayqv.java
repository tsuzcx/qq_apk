import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class ayqv
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ayqg jdField_a_of_type_Ayqg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ayqg b;
  private ayqg c;
  private ayqg d;
  private ayqg e;
  
  public ayqv(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(aysk paramaysk)
  {
    if ((paramaysk instanceof aysj)) {
      return 0;
    }
    if ((paramaysk instanceof aysn)) {
      return 1;
    }
    if ((paramaysk instanceof aysl)) {
      return 2;
    }
    if ((paramaysk instanceof aysh)) {
      return 3;
    }
    if ((paramaysk instanceof ayso)) {
      return 4;
    }
    return -1;
  }
  
  public ayqg a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Ayqg != null) {
        localObject = this.jdField_a_of_type_Ayqg;
      }
    }
    do
    {
      return localObject;
      localObject = new ayqt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Ayqg = ((ayqg)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new aysd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((ayqg)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new aysa(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((ayqg)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new ayqo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.d = ((ayqg)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.e != null) {
      return this.e;
    }
    localObject = new aysf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.e = ((ayqg)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqv
 * JD-Core Version:    0.7.0.1
 */