import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class bcgc
  implements bcmt
{
  bcfu jdField_a_of_type_Bcfu;
  bcgb jdField_a_of_type_Bcgb;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  final String b;
  
  bcgc(WeakReference<QQAppInterface> paramWeakReference, String paramString1, String paramString2, bcfu parambcfu, bcgb parambcgb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString1;
    this.jdField_a_of_type_Bcgb = parambcgb;
    this.jdField_a_of_type_JavaLangThrowable = null;
    if (paramString2 == null) {
      throw new IllegalArgumentException("null == outputFilePath");
    }
    this.jdField_a_of_type_Bcfu = parambcfu;
  }
  
  private boolean a()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
  
  public bcmu a(int paramInt1, int paramInt2)
  {
    bcmu localbcmu = new bcmu();
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    localbcmu.jdField_a_of_type_JavaIoFile = localFile;
    localbcmu.jdField_a_of_type_Float = this.jdField_a_of_type_Bcfu.jdField_a_of_type_Float;
    localbcmu.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Bcfu.b);
    localbcmu.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_Bcfu.jdField_a_of_type_Long);
    localbcmu.jdField_b_of_type_Boolean = a();
    return localbcmu;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
    }
    if (this.jdField_a_of_type_Bcgb != null) {
      this.jdField_a_of_type_Bcgb.a(null, 1);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
    }
    if ((this.jdField_a_of_type_Bcgb != null) && (paramInt >= 0) && (paramInt <= 10000)) {
      this.jdField_a_of_type_Bcgb.a(null, paramInt / 10000.0F);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
    if (this.jdField_a_of_type_Bcgb != null) {
      this.jdField_a_of_type_Bcgb.a(null, 2);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onCanceled!");
    }
    if (this.jdField_a_of_type_Bcgb != null) {
      this.jdField_a_of_type_Bcgb.a(null, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgc
 * JD-Core Version:    0.7.0.1
 */