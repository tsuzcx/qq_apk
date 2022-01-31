import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bkff
  extends bkee
{
  public Path a;
  ArrayList<bkfe> a;
  public int b;
  public int c;
  
  public bkff(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bkff(bkee parambkee, float paramFloat)
  {
    super(parambkee.jdField_a_of_type_Int);
    if ((parambkee instanceof bkff))
    {
      parambkee = (bkff)parambkee;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambkee.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambkee.jdField_a_of_type_Int;
      this.b = parambkee.b;
      this.jdField_c_of_type_Int = ((int)(parambkee.jdField_c_of_type_Int * paramFloat));
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
        bkfe localbkfe = (bkfe)localIterator.next();
        localJSONArray.put(localbkfe.jdField_d_of_type_Int);
        localJSONArray.put(localbkfe.a);
        localJSONArray.put(localbkfe.b);
        if (localbkfe.jdField_d_of_type_Int == bkfe.jdField_c_of_type_Int)
        {
          localJSONArray.put(localbkfe.jdField_c_of_type_Float);
          localJSONArray.put(localbkfe.jdField_d_of_type_Float);
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
 * Qualified Name:     bkff
 * JD-Core Version:    0.7.0.1
 */