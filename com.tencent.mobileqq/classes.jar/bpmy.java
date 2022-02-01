import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bpmy
  extends bplx
{
  public Path a;
  ArrayList<bpmx> a;
  public int b;
  public int c;
  
  public bpmy(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bpmy(bplx parambplx, float paramFloat)
  {
    super(parambplx.jdField_a_of_type_Int);
    if ((parambplx instanceof bpmy))
    {
      parambplx = (bpmy)parambplx;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambplx.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambplx.jdField_a_of_type_Int;
      this.b = parambplx.b;
      this.jdField_c_of_type_Int = ((int)(parambplx.jdField_c_of_type_Int * paramFloat));
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
        bpmx localbpmx = (bpmx)localIterator.next();
        localJSONArray.put(localbpmx.jdField_d_of_type_Int);
        localJSONArray.put(localbpmx.a);
        localJSONArray.put(localbpmx.b);
        if (localbpmx.jdField_d_of_type_Int == bpmx.jdField_c_of_type_Int)
        {
          localJSONArray.put(localbpmx.jdField_c_of_type_Float);
          localJSONArray.put(localbpmx.jdField_d_of_type_Float);
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
 * Qualified Name:     bpmy
 * JD-Core Version:    0.7.0.1
 */