import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class bcik
  extends alkl
{
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private bcij jdField_a_of_type_Bcij;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bcik(Context paramContext, long paramLong, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  public bcik(Context paramContext, bcij parambcij, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Bcij = parambcij;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof bcii))) {}
    Context localContext;
    long l1;
    do
    {
      return;
      paramObject = (bcii)paramObject;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      long l2 = this.jdField_a_of_type_Long;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Bcij != null) {
          l1 = this.jdField_a_of_type_Bcij.a();
        }
      }
    } while (localContext == null);
    bcig.a(paramObject, l1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcik
 * JD-Core Version:    0.7.0.1
 */