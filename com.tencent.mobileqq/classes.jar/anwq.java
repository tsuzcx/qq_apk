import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class anwq
  implements mrl
{
  private final bgat jdField_a_of_type_Bgat;
  private final WeakReference<anwd> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  anwq(anwd paramanwd, bgat parambgat, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanwd);
    this.jdField_a_of_type_Bgat = parambgat;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, mrn parammrn, int paramInt2)
  {
    parammrn = (anwd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parammrn != null) && (parammrn.app != null))
    {
      if (paramInt1 == 0) {
        parammrn.app.a().a(1, this.jdField_a_of_type_Bgat.a, this.jdField_a_of_type_Bgat.b, this.jdField_a_of_type_ArrayOfLong, 2, 0, 0, -1);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + parammrn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwq
 * JD-Core Version:    0.7.0.1
 */