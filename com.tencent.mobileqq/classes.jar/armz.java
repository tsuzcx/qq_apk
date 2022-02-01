import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class armz
{
  public arna a;
  public String a;
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("user_id", this.jdField_a_of_type_Arna.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("source_md5", this.jdField_a_of_type_Arna.jdField_b_of_type_JavaLangString);
      localJSONObject2.put("source_url", this.jdField_a_of_type_Arna.c);
      localJSONArray = new JSONArray();
      localIterator = this.jdField_a_of_type_Arna.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put((String)localIterator.next());
      }
      localException.put("expose_md5s", localJSONArray);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoutuReportData", 2, "convert error:" + localException);
      }
      return localJSONObject1;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_Arna.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put((String)localIterator.next());
    }
    localException.put("expose_urls", localJSONArray);
    localException.put("click_md5", this.jdField_a_of_type_Arna.d);
    localException.put("click_url", this.jdField_a_of_type_Arna.e);
    localException.put("aio_type", this.jdField_a_of_type_Arna.f);
    localException.put("mobile_type", this.jdField_a_of_type_Arna.g);
    localException.put("to_user_id", this.jdField_a_of_type_Arna.h);
    localJSONObject1.put("dcId", this.jdField_a_of_type_JavaLangString);
    localJSONObject1.put("data", localException);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armz
 * JD-Core Version:    0.7.0.1
 */