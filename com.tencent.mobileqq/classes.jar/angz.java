import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class angz
{
  public int a;
  public String a;
  public final List<anha> a;
  
  public angz()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public JSONObject a(String paramString, AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramAppInterface == null)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((anha)localIterator.next()).a(paramString, localJSONObject, paramAppInterface);
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClientId:").append(this.jdField_a_of_type_Int).append(" mCmdSSOName:").append(this.jdField_a_of_type_JavaLangString).append(" mParameters:").append(this.jdField_a_of_type_JavaUtilList);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angz
 * JD-Core Version:    0.7.0.1
 */