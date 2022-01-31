import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bkfw
  extends bkev
{
  public Path a;
  ArrayList<bkfv> a;
  public int b;
  public int c;
  
  public bkfw(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bkfw(bkev parambkev, float paramFloat)
  {
    super(parambkev.jdField_a_of_type_Int);
    if ((parambkev instanceof bkfw))
    {
      parambkev = (bkfw)parambkev;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambkev.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambkev.jdField_a_of_type_Int;
      this.b = parambkev.b;
      this.jdField_c_of_type_Int = ((int)(parambkev.jdField_c_of_type_Int * paramFloat));
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
        bkfv localbkfv = (bkfv)localIterator.next();
        localJSONArray.put(localbkfv.jdField_d_of_type_Int);
        localJSONArray.put(localbkfv.a);
        localJSONArray.put(localbkfv.b);
        if (localbkfv.jdField_d_of_type_Int == bkfv.jdField_c_of_type_Int)
        {
          localJSONArray.put(localbkfv.jdField_c_of_type_Float);
          localJSONArray.put(localbkfv.jdField_d_of_type_Float);
        }
      }
      localJSONObject.put("points", localJSONArray);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkfw
 * JD-Core Version:    0.7.0.1
 */