import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class anfe
{
  public static anfc a(anff paramanff, int paramInt)
  {
    if (paramanff == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramanff.jdField_a_of_type_Int)
    {
    default: 
      localObject = new anfh(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramanff.toString());
      return localObject;
      localObject = new anew(paramInt);
      continue;
      localObject = new anfj(paramInt);
      continue;
      localObject = new anfa(paramInt);
      continue;
      localObject = new anfb(paramInt);
      continue;
      if (TextUtils.isEmpty(paramanff.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new anex(paramInt, paramanff.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static anff a(int paramInt)
  {
    return new anff(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfe
 * JD-Core Version:    0.7.0.1
 */