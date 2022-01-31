import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ameb
  implements muf
{
  private final bcwi jdField_a_of_type_Bcwi;
  private final WeakReference<amdu> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  ameb(amdu paramamdu, bcwi parambcwi, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramamdu);
    this.jdField_a_of_type_Bcwi = parambcwi;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, muh parammuh, int paramInt2)
  {
    parammuh = (amdu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parammuh != null) && (parammuh.app != null))
    {
      if (paramInt1 == 0) {
        parammuh.app.a().a(1, this.jdField_a_of_type_Bcwi.a, this.jdField_a_of_type_Bcwi.b, this.jdField_a_of_type_ArrayOfLong, 2, 0, 0, -1);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + parammuh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ameb
 * JD-Core Version:    0.7.0.1
 */