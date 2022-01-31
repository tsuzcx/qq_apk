import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class biok
  extends binj
{
  public Path a;
  ArrayList<bioj> a;
  public int b;
  public int c;
  
  public biok(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public biok(binj parambinj, float paramFloat)
  {
    super(parambinj.jdField_a_of_type_Int);
    if ((parambinj instanceof biok))
    {
      parambinj = (biok)parambinj;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambinj.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambinj.jdField_a_of_type_Int;
      this.b = parambinj.b;
      this.jdField_c_of_type_Int = ((int)(parambinj.jdField_c_of_type_Int * paramFloat));
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
        bioj localbioj = (bioj)localIterator.next();
        localJSONArray.put(localbioj.jdField_d_of_type_Int);
        localJSONArray.put(localbioj.a);
        localJSONArray.put(localbioj.b);
        if (localbioj.jdField_d_of_type_Int == bioj.jdField_c_of_type_Int)
        {
          localJSONArray.put(localbioj.jdField_c_of_type_Float);
          localJSONArray.put(localbioj.jdField_d_of_type_Float);
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
 * Qualified Name:     biok
 * JD-Core Version:    0.7.0.1
 */