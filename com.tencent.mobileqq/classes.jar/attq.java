import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.HashMap;

public class attq
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
  
  public static attq a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    attq localattq = new attq();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localattq.jdField_a_of_type_Int = ((int)(aciy.a(8.0F, paramResources) + (float)Math.random() * aciy.a(3.0F, paramResources)));
    localattq.jdField_b_of_type_Int = ((int)(f * localattq.jdField_a_of_type_Int));
    localattq.jdField_a_of_type_ArrayOfFloat = new float[2];
    localattq.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    localattq.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    localattq.jdField_a_of_type_Float = ((float)Math.random() * aciy.a(90.0F, paramResources) - aciy.a(45.0F, paramResources));
    localattq.jdField_a_of_type_Double = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localattq.jdField_a_of_type_Double >= 0.0D) {}
    for (localattq.jdField_b_of_type_Float = (aciy.a(10.0F, paramResources) + (float)Math.random() * aciy.a(200.0F, paramResources));; localattq.jdField_b_of_type_Float = (-aciy.a(10.0F, paramResources) - (float)Math.random() * aciy.a(200.0F, paramResources)))
    {
      localattq.c = ((float)(localattq.jdField_b_of_type_Float * Math.cos(localattq.jdField_a_of_type_Double)));
      localattq.d = ((float)(localattq.jdField_b_of_type_Float * Math.sin(localattq.jdField_a_of_type_Double)));
      localattq.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localattq.jdField_a_of_type_Int)));
      if (localattq.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localattq.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localattq.jdField_a_of_type_Int, localattq.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localattq.jdField_a_of_type_Int), localattq.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localattq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     attq
 * JD-Core Version:    0.7.0.1
 */