import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.HashMap;

public class aurq
{
  static HashMap<Integer, Bitmap> a;
  public double a;
  public float a;
  public int a;
  public Bitmap a;
  public float[] a;
  float b;
  public int b;
  public float c;
  public float d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static aurq a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    aurq localaurq = new aurq();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localaurq.jdField_a_of_type_Int = ((int)(actj.a(8.0F, paramResources) + (float)Math.random() * actj.a(3.0F, paramResources)));
    localaurq.jdField_b_of_type_Int = ((int)(f * localaurq.jdField_a_of_type_Int));
    localaurq.jdField_a_of_type_ArrayOfFloat = new float[2];
    localaurq.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    localaurq.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    localaurq.jdField_a_of_type_Float = ((float)Math.random() * actj.a(90.0F, paramResources) - actj.a(45.0F, paramResources));
    localaurq.jdField_a_of_type_Double = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localaurq.jdField_a_of_type_Double >= 0.0D) {}
    for (localaurq.jdField_b_of_type_Float = (actj.a(10.0F, paramResources) + (float)Math.random() * actj.a(200.0F, paramResources));; localaurq.jdField_b_of_type_Float = (-actj.a(10.0F, paramResources) - (float)Math.random() * actj.a(200.0F, paramResources)))
    {
      localaurq.c = ((float)(localaurq.jdField_b_of_type_Float * Math.cos(localaurq.jdField_a_of_type_Double)));
      localaurq.d = ((float)(localaurq.jdField_b_of_type_Float * Math.sin(localaurq.jdField_a_of_type_Double)));
      localaurq.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localaurq.jdField_a_of_type_Int)));
      if (localaurq.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localaurq.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localaurq.jdField_a_of_type_Int, localaurq.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localaurq.jdField_a_of_type_Int), localaurq.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localaurq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aurq
 * JD-Core Version:    0.7.0.1
 */