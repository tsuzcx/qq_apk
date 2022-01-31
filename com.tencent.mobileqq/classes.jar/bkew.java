import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bkew
  extends bkee
{
  public Path a;
  ArrayList<bkfe> jdField_a_of_type_JavaUtilArrayList;
  List<Integer> jdField_a_of_type_JavaUtilList;
  public int b;
  List<Integer> b;
  public int c;
  
  public bkew(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bkew(bkee parambkee, float paramFloat)
  {
    super(parambkee.jdField_a_of_type_Int);
    if ((parambkee instanceof bkew))
    {
      parambkee = (bkew)parambkee;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambkee.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambkee.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = parambkee.jdField_b_of_type_Int;
      this.jdField_c_of_type_Int = ((int)(parambkee.jdField_c_of_type_Int * paramFloat));
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
 * Qualified Name:     bkew
 * JD-Core Version:    0.7.0.1
 */