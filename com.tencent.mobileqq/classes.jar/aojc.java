import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aojc
  implements msj
{
  private final bhau jdField_a_of_type_Bhau;
  private final WeakReference<aoip> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  aojc(aoip paramaoip, bhau parambhau, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaoip);
    this.jdField_a_of_type_Bhau = parambhau;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, msl parammsl, int paramInt2)
  {
    parammsl = (aoip)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parammsl != null) && (parammsl.app != null))
    {
      if (paramInt1 == 0) {
        parammsl.app.a().a(1, this.jdField_a_of_type_Bhau.a, this.jdField_a_of_type_Bhau.b, this.jdField_a_of_type_ArrayOfLong, 2, 0, 0, -1);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + parammsl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojc
 * JD-Core Version:    0.7.0.1
 */