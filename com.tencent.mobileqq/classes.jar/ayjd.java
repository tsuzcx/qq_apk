import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.HashMap;

public class ayjd
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
  
  public static ayjd a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    ayjd localayjd = new ayjd();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localayjd.jdField_a_of_type_Int = ((int)(AIOUtils.dp2px(8.0F, paramResources) + (float)Math.random() * AIOUtils.dp2px(3.0F, paramResources)));
    localayjd.jdField_b_of_type_Int = ((int)(f * localayjd.jdField_a_of_type_Int));
    localayjd.jdField_a_of_type_ArrayOfFloat = new float[2];
    localayjd.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    localayjd.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    localayjd.jdField_a_of_type_Float = ((float)Math.random() * AIOUtils.dp2px(90.0F, paramResources) - AIOUtils.dp2px(45.0F, paramResources));
    localayjd.jdField_a_of_type_Double = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localayjd.jdField_a_of_type_Double >= 0.0D) {}
    for (localayjd.jdField_b_of_type_Float = (AIOUtils.dp2px(10.0F, paramResources) + (float)Math.random() * AIOUtils.dp2px(200.0F, paramResources));; localayjd.jdField_b_of_type_Float = (-AIOUtils.dp2px(10.0F, paramResources) - (float)Math.random() * AIOUtils.dp2px(200.0F, paramResources)))
    {
      localayjd.c = ((float)(localayjd.jdField_b_of_type_Float * Math.cos(localayjd.jdField_a_of_type_Double)));
      localayjd.d = ((float)(localayjd.jdField_b_of_type_Float * Math.sin(localayjd.jdField_a_of_type_Double)));
      localayjd.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localayjd.jdField_a_of_type_Int)));
      if (localayjd.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localayjd.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localayjd.jdField_a_of_type_Int, localayjd.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localayjd.jdField_a_of_type_Int), localayjd.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localayjd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjd
 * JD-Core Version:    0.7.0.1
 */