import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class bgrm
  extends anua
{
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private bgrl jdField_a_of_type_Bgrl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bgrm(Context paramContext, long paramLong, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  public bgrm(Context paramContext, bgrl parambgrl, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Bgrl = parambgrl;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof bgrk))) {}
    Context localContext;
    long l1;
    do
    {
      return;
      paramObject = (bgrk)paramObject;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      long l2 = this.jdField_a_of_type_Long;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Bgrl != null) {
          l1 = this.jdField_a_of_type_Bgrl.a();
        }
      }
    } while (localContext == null);
    bgri.a(paramObject, l1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrm
 * JD-Core Version:    0.7.0.1
 */