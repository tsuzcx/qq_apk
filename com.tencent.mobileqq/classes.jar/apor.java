import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class apor
{
  private float jdField_a_of_type_Float;
  private final bdvv jdField_a_of_type_Bdvv;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  
  public apor(String paramString, bdvv parambdvv)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bdvv = parambdvv;
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_Bdvv != null) {
      return this.jdField_a_of_type_Bdvv.jdField_a_of_type_Float;
    }
    return this.jdField_a_of_type_Float;
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Bdvv != null) {
      return this.jdField_a_of_type_Bdvv.a();
    }
    return (Bundle)((bdqa)paramQQAppInterface.getManager(235)).a.a.get(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_Bdvv != null) {
      this.jdField_a_of_type_Bdvv.a(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apor
 * JD-Core Version:    0.7.0.1
 */