import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class bajx
  extends ajsy
{
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private bajw jdField_a_of_type_Bajw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bajx(Context paramContext, long paramLong, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  public bajx(Context paramContext, bajw parambajw, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Bajw = parambajw;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof bajv))) {}
    Context localContext;
    long l1;
    do
    {
      return;
      paramObject = (bajv)paramObject;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      long l2 = this.jdField_a_of_type_Long;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Bajw != null) {
          l1 = this.jdField_a_of_type_Bajw.a();
        }
      }
    } while (localContext == null);
    bajt.a(paramObject, l1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bajx
 * JD-Core Version:    0.7.0.1
 */