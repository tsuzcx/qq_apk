import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.HashMap;

public class azuo
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
  
  public static azuo a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    azuo localazuo = new azuo();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localazuo.jdField_a_of_type_Int = ((int)(agej.a(8.0F, paramResources) + (float)Math.random() * agej.a(3.0F, paramResources)));
    localazuo.jdField_b_of_type_Int = ((int)(f * localazuo.jdField_a_of_type_Int));
    localazuo.jdField_a_of_type_ArrayOfFloat = new float[2];
    localazuo.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    localazuo.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    localazuo.jdField_a_of_type_Float = ((float)Math.random() * agej.a(90.0F, paramResources) - agej.a(45.0F, paramResources));
    localazuo.jdField_a_of_type_Double = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localazuo.jdField_a_of_type_Double >= 0.0D) {}
    for (localazuo.jdField_b_of_type_Float = (agej.a(10.0F, paramResources) + (float)Math.random() * agej.a(200.0F, paramResources));; localazuo.jdField_b_of_type_Float = (-agej.a(10.0F, paramResources) - (float)Math.random() * agej.a(200.0F, paramResources)))
    {
      localazuo.c = ((float)(localazuo.jdField_b_of_type_Float * Math.cos(localazuo.jdField_a_of_type_Double)));
      localazuo.d = ((float)(localazuo.jdField_b_of_type_Float * Math.sin(localazuo.jdField_a_of_type_Double)));
      localazuo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localazuo.jdField_a_of_type_Int)));
      if (localazuo.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localazuo.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localazuo.jdField_a_of_type_Int, localazuo.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localazuo.jdField_a_of_type_Int), localazuo.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localazuo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azuo
 * JD-Core Version:    0.7.0.1
 */