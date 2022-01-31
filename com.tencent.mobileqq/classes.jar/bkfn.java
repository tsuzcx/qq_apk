import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bkfn
  extends bkev
{
  public Path a;
  ArrayList<bkfv> jdField_a_of_type_JavaUtilArrayList;
  List<Integer> jdField_a_of_type_JavaUtilList;
  public int b;
  List<Integer> b;
  public int c;
  
  public bkfn(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bkfn(bkev parambkev, float paramFloat)
  {
    super(parambkev.jdField_a_of_type_Int);
    if ((parambkev instanceof bkfn))
    {
      parambkev = (bkfn)parambkev;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambkev.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambkev.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = parambkev.jdField_b_of_type_Int;
      this.jdField_c_of_type_Int = ((int)(parambkev.jdField_c_of_type_Int * paramFloat));
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
 * Qualified Name:     bkfn
 * JD-Core Version:    0.7.0.1
 */