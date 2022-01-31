import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.HashMap;

public class awnl
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
  
  public static awnl a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    awnl localawnl = new awnl();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localawnl.jdField_a_of_type_Int = ((int)(aepi.a(8.0F, paramResources) + (float)Math.random() * aepi.a(3.0F, paramResources)));
    localawnl.jdField_b_of_type_Int = ((int)(f * localawnl.jdField_a_of_type_Int));
    localawnl.jdField_a_of_type_ArrayOfFloat = new float[2];
    localawnl.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    localawnl.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    localawnl.jdField_a_of_type_Float = ((float)Math.random() * aepi.a(90.0F, paramResources) - aepi.a(45.0F, paramResources));
    localawnl.jdField_a_of_type_Double = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localawnl.jdField_a_of_type_Double >= 0.0D) {}
    for (localawnl.jdField_b_of_type_Float = (aepi.a(10.0F, paramResources) + (float)Math.random() * aepi.a(200.0F, paramResources));; localawnl.jdField_b_of_type_Float = (-aepi.a(10.0F, paramResources) - (float)Math.random() * aepi.a(200.0F, paramResources)))
    {
      localawnl.c = ((float)(localawnl.jdField_b_of_type_Float * Math.cos(localawnl.jdField_a_of_type_Double)));
      localawnl.d = ((float)(localawnl.jdField_b_of_type_Float * Math.sin(localawnl.jdField_a_of_type_Double)));
      localawnl.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localawnl.jdField_a_of_type_Int)));
      if (localawnl.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localawnl.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localawnl.jdField_a_of_type_Int, localawnl.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localawnl.jdField_a_of_type_Int), localawnl.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localawnl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awnl
 * JD-Core Version:    0.7.0.1
 */