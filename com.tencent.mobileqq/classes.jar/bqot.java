import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bqot
  extends bqns
{
  public Path a;
  ArrayList<bqos> a;
  public int b;
  public int c;
  
  public bqot(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bqot(bqns parambqns, float paramFloat)
  {
    super(parambqns.jdField_a_of_type_Int);
    if ((parambqns instanceof bqot))
    {
      parambqns = (bqot)parambqns;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambqns.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambqns.jdField_a_of_type_Int;
      this.b = parambqns.b;
      this.jdField_c_of_type_Int = ((int)(parambqns.jdField_c_of_type_Int * paramFloat));
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
        bqos localbqos = (bqos)localIterator.next();
        localJSONArray.put(localbqos.jdField_d_of_type_Int);
        localJSONArray.put(localbqos.a);
        localJSONArray.put(localbqos.b);
        if (localbqos.jdField_d_of_type_Int == bqos.jdField_c_of_type_Int)
        {
          localJSONArray.put(localbqos.jdField_c_of_type_Float);
          localJSONArray.put(localbqos.jdField_d_of_type_Float);
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
 * Qualified Name:     bqot
 * JD-Core Version:    0.7.0.1
 */