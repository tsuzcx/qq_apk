import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.HashMap;

public class azcb
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
  
  public static azcb a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    azcb localazcb = new azcb();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localazcb.jdField_a_of_type_Int = ((int)(afur.a(8.0F, paramResources) + (float)Math.random() * afur.a(3.0F, paramResources)));
    localazcb.jdField_b_of_type_Int = ((int)(f * localazcb.jdField_a_of_type_Int));
    localazcb.jdField_a_of_type_ArrayOfFloat = new float[2];
    localazcb.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    localazcb.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    localazcb.jdField_a_of_type_Float = ((float)Math.random() * afur.a(90.0F, paramResources) - afur.a(45.0F, paramResources));
    localazcb.jdField_a_of_type_Double = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localazcb.jdField_a_of_type_Double >= 0.0D) {}
    for (localazcb.jdField_b_of_type_Float = (afur.a(10.0F, paramResources) + (float)Math.random() * afur.a(200.0F, paramResources));; localazcb.jdField_b_of_type_Float = (-afur.a(10.0F, paramResources) - (float)Math.random() * afur.a(200.0F, paramResources)))
    {
      localazcb.c = ((float)(localazcb.jdField_b_of_type_Float * Math.cos(localazcb.jdField_a_of_type_Double)));
      localazcb.d = ((float)(localazcb.jdField_b_of_type_Float * Math.sin(localazcb.jdField_a_of_type_Double)));
      localazcb.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localazcb.jdField_a_of_type_Int)));
      if (localazcb.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localazcb.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localazcb.jdField_a_of_type_Int, localazcb.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localazcb.jdField_a_of_type_Int), localazcb.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localazcb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcb
 * JD-Core Version:    0.7.0.1
 */