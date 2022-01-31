import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class avmi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private avlt jdField_a_of_type_Avlt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private avlt b;
  private avlt c;
  private avlt d;
  private avlt e;
  
  public avmi(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(avnx paramavnx)
  {
    if ((paramavnx instanceof avnw)) {
      return 0;
    }
    if ((paramavnx instanceof avoa)) {
      return 1;
    }
    if ((paramavnx instanceof avny)) {
      return 2;
    }
    if ((paramavnx instanceof avnu)) {
      return 3;
    }
    if ((paramavnx instanceof avob)) {
      return 4;
    }
    return -1;
  }
  
  public avlt a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Avlt != null) {
        localObject = this.jdField_a_of_type_Avlt;
      }
    }
    do
    {
      return localObject;
      localObject = new avmg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Avlt = ((avlt)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new avnq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((avlt)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new avnn(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((avlt)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new avmb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.d = ((avlt)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.e != null) {
      return this.e;
    }
    localObject = new avns(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.e = ((avlt)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmi
 * JD-Core Version:    0.7.0.1
 */