import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bmvs
  extends bmur
{
  public Path a;
  ArrayList<bmvr> a;
  public int b;
  public int c;
  
  public bmvs(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bmvs(bmur parambmur, float paramFloat)
  {
    super(parambmur.jdField_a_of_type_Int);
    if ((parambmur instanceof bmvs))
    {
      parambmur = (bmvs)parambmur;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambmur.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambmur.jdField_a_of_type_Int;
      this.b = parambmur.b;
      this.jdField_c_of_type_Int = ((int)(parambmur.jdField_c_of_type_Int * paramFloat));
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
        bmvr localbmvr = (bmvr)localIterator.next();
        localJSONArray.put(localbmvr.jdField_d_of_type_Int);
        localJSONArray.put(localbmvr.a);
        localJSONArray.put(localbmvr.b);
        if (localbmvr.jdField_d_of_type_Int == bmvr.jdField_c_of_type_Int)
        {
          localJSONArray.put(localbmvr.jdField_c_of_type_Float);
          localJSONArray.put(localbmvr.jdField_d_of_type_Float);
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
 * Qualified Name:     bmvs
 * JD-Core Version:    0.7.0.1
 */