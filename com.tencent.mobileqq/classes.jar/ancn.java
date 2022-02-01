import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ancn
  implements mrs
{
  private final bfkg jdField_a_of_type_Bfkg;
  private final WeakReference<anca> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  ancn(anca paramanca, bfkg parambfkg, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanca);
    this.jdField_a_of_type_Bfkg = parambfkg;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, mru parammru, int paramInt2)
  {
    parammru = (anca)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parammru != null) && (parammru.app != null))
    {
      if (paramInt1 == 0) {
        parammru.app.getGAudioHandler().a(1, this.jdField_a_of_type_Bfkg.a, this.jdField_a_of_type_Bfkg.b, this.jdField_a_of_type_ArrayOfLong, 2, 0, 0, -1);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + parammru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancn
 * JD-Core Version:    0.7.0.1
 */