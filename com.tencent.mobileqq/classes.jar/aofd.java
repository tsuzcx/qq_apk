import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aofd
  implements msp
{
  private final bgsx jdField_a_of_type_Bgsx;
  private final WeakReference<aoep> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  aofd(aoep paramaoep, bgsx parambgsx, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaoep);
    this.jdField_a_of_type_Bgsx = parambgsx;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, msr parammsr, int paramInt2)
  {
    parammsr = (aoep)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parammsr != null) && (parammsr.app != null))
    {
      if (paramInt1 == 0) {
        parammsr.app.getGAudioHandler().a(1, this.jdField_a_of_type_Bgsx.a, this.jdField_a_of_type_Bgsx.b, this.jdField_a_of_type_ArrayOfLong, 2, 0, 0, -1);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + parammsr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofd
 * JD-Core Version:    0.7.0.1
 */