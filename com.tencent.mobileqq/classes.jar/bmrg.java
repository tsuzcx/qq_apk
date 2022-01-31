import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bmrg
  extends bmqf
{
  public Path a;
  ArrayList<bmrf> a;
  public int b;
  public int c;
  
  public bmrg(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bmrg(bmqf parambmqf, float paramFloat)
  {
    super(parambmqf.jdField_a_of_type_Int);
    if ((parambmqf instanceof bmrg))
    {
      parambmqf = (bmrg)parambmqf;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambmqf.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambmqf.jdField_a_of_type_Int;
      this.b = parambmqf.b;
      this.jdField_c_of_type_Int = ((int)(parambmqf.jdField_c_of_type_Int * paramFloat));
    }
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mode", this.jdField_a_of_type_Int);
      localJSONObject.put("color", this.b);
      localJSONObject.put("lineWidth", this.jdField_c_of_type_Int);
      JSONArray localJSONArray = new JSONArray();
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
 * Qualified Name:     bmrg
 * JD-Core Version:    0.7.0.1
 */