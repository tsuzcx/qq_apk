import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class asjr
{
  private float jdField_a_of_type_Float;
  private final bhyo jdField_a_of_type_Bhyo;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  
  public asjr(String paramString, bhyo parambhyo)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bhyo = parambhyo;
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_Bhyo != null) {
      return this.jdField_a_of_type_Bhyo.jdField_a_of_type_Float;
    }
    return this.jdField_a_of_type_Float;
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Bhyo != null) {
      return this.jdField_a_of_type_Bhyo.a();
    }
    return (Bundle)((bhou)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a.get(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_Bhyo != null) {
      this.jdField_a_of_type_Bhyo.a(true);
    }
    String str;
    do
    {
      return;
      str = "bqmall.android.h5magic." + this.jdField_a_of_type_JavaLangString + ".zip";
      paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.cancelDwonloadItem(1004L, str);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjr
 * JD-Core Version:    0.7.0.1
 */