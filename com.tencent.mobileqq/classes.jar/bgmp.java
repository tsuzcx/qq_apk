import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

final class bgmp
  extends bhyn
{
  bgmp(WeakReference paramWeakReference, File paramFile, bdyy parambdyy) {}
  
  public void onDone(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAnimationUtils", 2, "onDone:" + parambhyo.a);
    }
    bgmo.a(this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Bdyy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgmp
 * JD-Core Version:    0.7.0.1
 */