import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.HashMap;

public class auro
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
  
  public static auro a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    auro localauro = new auro();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localauro.jdField_a_of_type_Int = ((int)(actn.a(8.0F, paramResources) + (float)Math.random() * actn.a(3.0F, paramResources)));
    localauro.jdField_b_of_type_Int = ((int)(f * localauro.jdField_a_of_type_Int));
    localauro.jdField_a_of_type_ArrayOfFloat = new float[2];
    localauro.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    localauro.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    localauro.jdField_a_of_type_Float = ((float)Math.random() * actn.a(90.0F, paramResources) - actn.a(45.0F, paramResources));
    localauro.jdField_a_of_type_Double = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localauro.jdField_a_of_type_Double >= 0.0D) {}
    for (localauro.jdField_b_of_type_Float = (actn.a(10.0F, paramResources) + (float)Math.random() * actn.a(200.0F, paramResources));; localauro.jdField_b_of_type_Float = (-actn.a(10.0F, paramResources) - (float)Math.random() * actn.a(200.0F, paramResources)))
    {
      localauro.c = ((float)(localauro.jdField_b_of_type_Float * Math.cos(localauro.jdField_a_of_type_Double)));
      localauro.d = ((float)(localauro.jdField_b_of_type_Float * Math.sin(localauro.jdField_a_of_type_Double)));
      localauro.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localauro.jdField_a_of_type_Int)));
      if (localauro.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localauro.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localauro.jdField_a_of_type_Int, localauro.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localauro.jdField_a_of_type_Int), localauro.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localauro;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auro
 * JD-Core Version:    0.7.0.1
 */