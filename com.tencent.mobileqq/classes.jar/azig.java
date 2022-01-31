import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class azig
  extends ajey
{
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private azif jdField_a_of_type_Azif;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  public azig(Context paramContext, long paramLong, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  public azig(Context paramContext, azif paramazif, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Azif = paramazif;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof azie))) {}
    Context localContext;
    long l1;
    do
    {
      return;
      paramObject = (azie)paramObject;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      long l2 = this.jdField_a_of_type_Long;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Azif != null) {
          l1 = this.jdField_a_of_type_Azif.a();
        }
      }
    } while (localContext == null);
    azic.a(paramObject, l1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azig
 * JD-Core Version:    0.7.0.1
 */