import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amks
  implements InvocationHandler
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<amkt> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public amks(Activity paramActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    if ((!this.b) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      this.b = true;
      amkm.a(this.jdField_a_of_type_AndroidAppActivity, this);
    }
  }
  
  public void a(amkt paramamkt)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramamkt);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ((paramMethod.getName().equalsIgnoreCase("onTranslucentConversionComplete")) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      this.jdField_a_of_type_Boolean = true;
      paramMethod = paramArrayOfObject[0];
      if (QLog.isColorLevel()) {
        QLog.d("TranslucentConvertor", 2, "onTranslucentConversionComplete: " + paramMethod);
      }
      paramObject = Boolean.valueOf(false);
      if ((paramMethod instanceof Boolean)) {
        paramObject = (Boolean)paramMethod;
      }
      paramMethod = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMethod.hasNext()) {
        ((amkt)paramMethod.next()).d_(paramObject.booleanValue());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amks
 * JD-Core Version:    0.7.0.1
 */