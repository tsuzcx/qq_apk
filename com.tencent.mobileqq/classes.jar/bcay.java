import com.tencent.open.appcommon.JsWebWorker;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class bcay
{
  public Class a;
  public String a;
  public Map<Integer, Object> a;
  public Map<String, Method> b = new HashMap();
  
  public bcay(JsWebWorker paramJsWebWorker)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    this.jdField_a_of_type_JavaUtilMap = null;
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcay
 * JD-Core Version:    0.7.0.1
 */