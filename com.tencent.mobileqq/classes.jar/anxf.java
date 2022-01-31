import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class anxf
{
  private float jdField_a_of_type_Float;
  private final bbwu jdField_a_of_type_Bbwu;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  
  public anxf(String paramString, bbwu parambbwu)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bbwu = parambbwu;
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_Bbwu != null) {
      return this.jdField_a_of_type_Bbwu.jdField_a_of_type_Float;
    }
    return this.jdField_a_of_type_Float;
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Bbwu != null) {
      return this.jdField_a_of_type_Bbwu.a();
    }
    return (Bundle)((bbrg)paramQQAppInterface.getManager(235)).a.a.get(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_Bbwu != null) {
      this.jdField_a_of_type_Bbwu.a(true);
    }
    String str;
    do
    {
      return;
      str = "bqmall.android.h5magic." + this.jdField_a_of_type_JavaLangString + ".zip";
      paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.cancelDwonloadItem(1004L, str);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxf
 * JD-Core Version:    0.7.0.1
 */