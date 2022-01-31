import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bmqx
  extends bmqf
{
  public Path a;
  ArrayList<bmrf> jdField_a_of_type_JavaUtilArrayList;
  List<Integer> jdField_a_of_type_JavaUtilList;
  public int b;
  List<Integer> b;
  public int c;
  
  public bmqx(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bmqx(bmqf parambmqf, float paramFloat)
  {
    super(parambmqf.jdField_a_of_type_Int);
    if ((parambmqf instanceof bmqx))
    {
      parambmqf = (bmqx)parambmqf;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambmqf.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambmqf.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = parambmqf.jdField_b_of_type_Int;
      this.jdField_c_of_type_Int = ((int)(parambmqf.jdField_c_of_type_Int * paramFloat));
    }
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mode", this.jdField_a_of_type_Int);
      localJSONObject.put("color", this.jdField_b_of_type_Int);
      localJSONObject.put("lineWidth", this.jdField_c_of_type_Int);
      JSONArray localJSONArray = new JSONArray();
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localJSONObject.put("StorageMode", "separate");
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localJSONArray.put(this.jdField_a_of_type_JavaUtilList.get(i));
          localJSONArray.put(this.jdField_b_of_type_JavaUtilList.get(i));
          i += 1;
        }
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        bmrf localbmrf = (bmrf)localIterator.next();
        localJSONArray.put(localbmrf.jdField_d_of_type_Int);
        localJSONArray.put(localbmrf.a);
        localJSONArray.put(localbmrf.b);
        if (localbmrf.jdField_d_of_type_Int == bmrf.jdField_c_of_type_Int)
        {
          localJSONArray.put(localbmrf.jdField_c_of_type_Float);
          localJSONArray.put(localbmrf.jdField_d_of_type_Float);
        }
      }
      localJSONObject.put("points", localJSONArray);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqx
 * JD-Core Version:    0.7.0.1
 */